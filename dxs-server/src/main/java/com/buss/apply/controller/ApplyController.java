package com.buss.apply.controller;

import com.buss.apply.entity.ApplyEntity;
import com.buss.apply.trans.form.ApplyForm;
import com.buss.apply.trans.vo.ApplyVo;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.bean.annotation.Mapping;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.lang.model.element.Name;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/20.
 * 个人中心
 */
@Controller
@RequestMapping("/apply")
public class ApplyController {
    @Resource
    private SysServiceI sysServiceI;

    /**
     * 我的奖学金
     * @param applyForm
     * @param curPage
     * @param pageSize
     * @param request
     * @return
     */
    @RequestMapping("/scholarship")
    @ResponseBody
    public ReplyDataMode scholarship(ApplyForm applyForm,Integer curPage, Integer  pageSize , HttpServletRequest request){
        applyForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 获取当前用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if (user != null){
            applyForm.setUserId(user.getId());
            CriteriaQuery criteriaQuery = applyForm.getCriteriaQuery();
            criteriaQuery.setCurPage(curPage);
            criteriaQuery.setPageSize(pageSize);
            criteriaQuery.addOrder("createTime", "desc");

            PageMode mode = this.sysServiceI.list4page(criteriaQuery,curPage,pageSize);
            List<ApplyEntity> ae = mode.getResult();
            List<ApplyVo> applyVos = new ArrayList<ApplyVo>();

            for (ApplyEntity applyEntity:ae){
                ApplyVo applyVo = new ApplyVo();
                applyVo.copyEntity(applyEntity);
                applyVos.add(applyVo);
            }
            mode.setResult(applyVos);
            replyDataMode.setData(mode);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);
        }
        return replyDataMode;
    }

    /**
     * 我的助学金
     * @param applyForm
     * @param curPage
     * @param pageSize
     * @param request
     * @return
     */
    @RequestMapping("/studentGrant")
    @ResponseBody
    public ReplyDataMode studentGrant(ApplyForm applyForm,Integer curPage, Integer  pageSize, HttpServletRequest request){

        applyForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 获取当前用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if (user != null){
            applyForm.setUserId(user.getId());
            CriteriaQuery criteriaQuery = applyForm.getCriteriaQuery();
            criteriaQuery.setCurPage(curPage);
            criteriaQuery.setPageSize(pageSize);
            criteriaQuery.addOrder("createTime", "desc");

            PageMode mode = this.sysServiceI.list4page(criteriaQuery,curPage,pageSize);
            List<ApplyEntity> ae = mode.getResult();
            List<ApplyVo> applyVos = new ArrayList<ApplyVo>();

            for (ApplyEntity applyEntity:ae){
                ApplyVo applyVo = new ApplyVo();
                applyVo.copyEntity(applyEntity);
                applyVos.add(applyVo);
            }

            mode.setResult(applyVos);

            replyDataMode.setData(mode);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);
        }
        return replyDataMode;
    }
}
