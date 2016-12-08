package com.buss.resume.resumeworks.controller;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;
import com.buss.resume.resume.entity.ResumeEntity;

import com.buss.resume.resumeworks.entity.ResumeWorksEntity;
import com.buss.resume.resumeworks.trans.form.ResumeWorksSearchForm;
import com.buss.resume.resumeworks.trans.vo.ResumeWorksVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author lu
 *
 */
@Controller
@RequestMapping("/resumeWorks")
public class ResumeWorksController {

    @Resource
    private SysServiceI sysService;

    @RequestMapping("/list.do")
    @ResponseBody
    public ReplyDataMode resumeWorksList(ResumeWorksSearchForm searchForm, HttpServletRequest request){

        ReplyDataMode replyDataMode = new ReplyDataMode();
        searchForm.setIsDelete("0");
        //获取用户登录信息
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        ResumeEntity resumeEntity = new ResumeEntity();
        resumeEntity.setIsDelete(0);
        if(user!=null) {

            resumeEntity.setUserid(user.getId());
            List<ResumeEntity> resumeList = this.sysService.findByExample(ResumeEntity.class.getName(), resumeEntity);
            if (resumeList != null && resumeList.size() != 0) {
                searchForm.setResumeId(resumeList.get(0).getId());
                CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

                Map<String, Object> orderMap = new HashMap<String, Object>();
                orderMap.put("createTime", "desc");
                orderMap.put("updateTime", "desc");
                criteriaQuery.setOrder(orderMap);

                List<ResumeWorksEntity> resumeWorks = this.sysService.list(criteriaQuery);
                List<ResumeWorksVO> resumeWorksVOs = new ArrayList<ResumeWorksVO>();

                for (ResumeWorksEntity resumeWorksEntity : resumeWorks) {
                    ResumeWorksVO resumeWorksVO = new ResumeWorksVO();
                    resumeWorksVO.copyEntity(resumeWorksEntity);
                    resumeWorksVOs.add(resumeWorksVO);

                }
                replyDataMode.setData(resumeWorksVOs);
            }
        }else {

            replyDataMode.setData("用户未登陆");
        }

        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

    @RequestMapping("/saveResumeWorks.do")
    @ResponseBody
    public ReplyDataMode saveResumeWorks(ResumeWorksSearchForm searchForm, HttpServletRequest request){
        String result = "操作成功";
        ReplyDataMode replyDataMode = new ReplyDataMode();

        //获取用户登录信息
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if(user!=null) {
            ResumeEntity resumeEntity = new ResumeEntity();
            resumeEntity.setIsDelete(0);

            resumeEntity.setUserid(user.getId());
            List<ResumeEntity> resumeList = this.sysService.findByExample(ResumeEntity.class.getName(), resumeEntity);
            if (resumeList != null && resumeList.size() != 0) {
                searchForm.setResumeId(resumeList.get(0).getId());

                //设置已确定字段
                ResumeWorksEntity resumeWorksEntity = (ResumeWorksEntity) searchForm.toEntity();
                resumeWorksEntity.setIsDelete(0);
                Date date = new Date();
                resumeWorksEntity.setCreateTime(date);
                resumeWorksEntity.setUpdateTime(date);

                try {

                    this.sysService.saveOrUpdate(resumeWorksEntity);

                }catch (Exception e){
                    result= "操作失败";

                }
            }
        }else{
            result = "用户未登陆";
        }

        replyDataMode.setData(result);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

    @RequestMapping("/updateResumeWorks.do")
    @ResponseBody
    public ReplyDataMode updateResumeWorks(ResumeWorksSearchForm searchForm, HttpServletRequest request) throws Exception {

        String result = "操作成功";
        ReplyDataMode replyDataMode = new ReplyDataMode();

        ResumeWorksEntity resumeWorksEntity = this.sysService.getEntity(ResumeWorksEntity.class,searchForm.getId());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        resumeWorksEntity.setWorkFinishTime(sdf.parse(searchForm.getWorkFinishTime()));
        resumeWorksEntity.setWorkName(searchForm.getWorkName());
        resumeWorksEntity.setWorkName2(searchForm.getWorkName2());
        resumeWorksEntity.setWorkIntroduce(searchForm.getWorkIntroduce());
        resumeWorksEntity.setImgUrl(searchForm.getImgUrl());
        resumeWorksEntity.setUpdateTime(new Date());

        try {

            this.sysService.saveOrUpdate(resumeWorksEntity);

        }catch (Exception e){
            result = "操作失败";
        }

        replyDataMode.setData(result);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);
        return replyDataMode;

    }

    @RequestMapping("/deleteResumeWorks.do")
    @ResponseBody
    public ReplyDataMode deleteResumeWorks(ResumeWorksSearchForm searchForm, HttpServletRequest request) {

        ReplyDataMode replyDataMode = new ReplyDataMode();
        String result = "操作成功";

        ResumeWorksEntity resumeWorksEntity = this.sysService.getEntity(ResumeWorksEntity.class,searchForm.getId());
        resumeWorksEntity.setIsDelete(1);

        try {

            this.sysService.saveOrUpdate(resumeWorksEntity);

        }catch (Exception e){

            result = "操作失败";
        }

        replyDataMode.setData(result);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);
        return replyDataMode;

    }


    @RequestMapping("/listm.do")
    @ResponseBody
    public ReplyDataMode resumeWorksListm(ResumeWorksSearchForm searchForm, HttpServletRequest request){

        ReplyDataMode replyDataMode = new ReplyDataMode();
        searchForm.setIsDelete("0");

        ResumeEntity resumeEntity = new ResumeEntity();
        resumeEntity.setIsDelete(0);

            resumeEntity.setUserid("8a2c9a985722138e015722b7cbdb001c");
            List<ResumeEntity> resumeList = this.sysService.findByExample(ResumeEntity.class.getName(), resumeEntity);
            if (resumeList != null && resumeList.size() != 0) {
                searchForm.setResumeId(resumeList.get(0).getId());
                CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

                Map<String, Object> orderMap = new HashMap<String, Object>();
                orderMap.put("createTime", "desc");
                orderMap.put("updateTime", "desc");
                criteriaQuery.setOrder(orderMap);

                List<ResumeWorksEntity> resumeWorks = this.sysService.list(criteriaQuery);
                List<ResumeWorksVO> resumeWorksVOs = new ArrayList<ResumeWorksVO>();

                for (ResumeWorksEntity resumeWorksEntity : resumeWorks) {
                    ResumeWorksVO resumeWorksVO = new ResumeWorksVO();
                    resumeWorksVO.copyEntity(resumeWorksEntity);
                    resumeWorksVOs.add(resumeWorksVO);

                }
                replyDataMode.setData(resumeWorksVOs);
            }


        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


}