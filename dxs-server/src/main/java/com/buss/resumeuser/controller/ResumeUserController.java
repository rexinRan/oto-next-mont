package com.buss.resumeuser.controller;

import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;
import com.buss.resume.resume.entity.ResumeEntity;
import com.buss.resumeuser.entity.ResumeUserEntity;
import com.buss.resumeuser.trans.form.ResumeUserForm;
import com.buss.resumeuser.trans.vo.ResumeUserVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.jweb.core.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/6/20.
 * 个人中心
 */
@Controller
@RequestMapping("/resumeuser")
public class ResumeUserController {

    @Resource
    private SysServiceI sysServiceI;

    /**
     *个人中心中我的投递的初始化和带条件查询
     * @param request
     * @param curPage
     * @param pageSize
     * @return
     */
    @RequestMapping("/deliver")
    @ResponseBody
    public ReplyDataMode deliver(ResumeUserForm resumeUserForm, Integer curPage, Integer pageSize, HttpServletRequest request){
        resumeUserForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 获取当前用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

            try {
                if (user != null){
                    resumeUserForm.setUserId(user.getId());
                    CriteriaQuery criteriaQuery = resumeUserForm.getCriteriaQuery();
                    criteriaQuery.setCurPage(curPage);
                    criteriaQuery.setPageSize(pageSize);
                    criteriaQuery.addOrder("createTime", "desc");
                    PageMode mode = this.sysServiceI.list4page(criteriaQuery,curPage,pageSize);
                    List<ResumeUserEntity> ae = mode.getResult();
                    List<ResumeUserVo> resumeUserVos = new ArrayList<ResumeUserVo>();

                    for (ResumeUserEntity resumeUserEntity:ae){
                        ResumeUserVo resumeUserVo = new ResumeUserVo();
                        resumeUserVo.copyEntity(resumeUserEntity);
                        resumeUserVos.add(resumeUserVo);
                    }
                    mode.setResult(resumeUserVos);
                    replyDataMode.setData(mode);
                    replyDataMode.setStatusCode("200");
                    replyDataMode.setSuccess(true);
                }else {
                    replyDataMode.setStatusCode("请登录!");
                    replyDataMode.setSuccess(false);
                }
            }catch (Exception e){
                replyDataMode.setStatusCode("没有参与投递!");
                replyDataMode.setSuccess(false);
                return replyDataMode;
            }

       return replyDataMode;
    }



    @RequestMapping("/saveResumeUser.do")
    @ResponseBody
    public ReplyDataMode saveResumeUser(ResumeUserForm searchForm, HttpServletRequest request){

        ReplyDataMode replyDataMode = new ReplyDataMode();
        boolean flag = false;
        //获取用户登录信息
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
        List<ResumeEntity> resumeEntityList = null;
        try {
             resumeEntityList= this.sysServiceI.findByProperty(ResumeEntity.class,"userid",user.getId());
        }catch (Exception e){
            //用户没有登录
            replyDataMode.setStatusCode("403");

            replyDataMode.setSuccess(flag);

            return replyDataMode;
        }

        if (resumeEntityList!=null&&resumeEntityList.size() != 0) {
            ResumeEntity resumeEntity = resumeEntityList.get(0);
            //设置已确定字段
            ResumeUserEntity resumeUserEntity = (ResumeUserEntity) searchForm.toEntity();
            resumeUserEntity.setUserId(user.getId());
            resumeUserEntity.setUserName(user.getRealname());
            resumeUserEntity.setResumeId(resumeEntity.getId());
            resumeUserEntity.setEmoloyedId(searchForm.getEmoloyedId());
            resumeUserEntity.setRtype(1);
            resumeUserEntity.setResult(0);
            resumeUserEntity.setIsDelete(0);
            Date date = new Date();
            resumeUserEntity.setSendTime(date);
            resumeUserEntity.setCreateTime(date);
            resumeUserEntity.setUpdateTime(date);


            try {

                this.sysServiceI.saveOrUpdate(resumeUserEntity);
                replyDataMode.setStatusCode("200");
                flag = true;

            } catch (Exception e) {
                //保存失败
                replyDataMode.setStatusCode("401");
            }
        }else {
            //用户没有完善信息
            replyDataMode.setStatusCode("402");
        }


        replyDataMode.setSuccess(flag);

        return replyDataMode;
    }
}
