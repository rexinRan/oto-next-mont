package com.buss.resume.resumeworkexperience.controller;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;
import com.buss.resume.resume.entity.ResumeEntity;
import com.buss.resume.resumeworkexperience.entity.ResumeWorkexperienceEntity;
import com.buss.resume.resumeworkexperience.trans.form.ResumeWorkexperienceSearchForm;
import com.buss.resume.resumeworkexperience.trans.vo.ResumeWorkexperienceVO;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author lu
 *
 */
@Controller
@RequestMapping("/resumeWorkexperience")
public class ResumeWorkexperienceController {

    @Resource
    private SysServiceI sysService;

    @RequestMapping("/list.do")
    @ResponseBody
    public ReplyDataMode resumeWorkexperienceList(ResumeWorkexperienceSearchForm searchForm, HttpServletRequest request){

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

                List<ResumeWorkexperienceEntity> resumeWorkexperience = this.sysService.list(criteriaQuery);
                List<ResumeWorkexperienceVO> resumeWorkexperienceVOs = new ArrayList<ResumeWorkexperienceVO>();

                for (ResumeWorkexperienceEntity resumeWorkexperienceEntity : resumeWorkexperience) {
                    ResumeWorkexperienceVO resumeWorkexperienceVO = new ResumeWorkexperienceVO();
                    resumeWorkexperienceVO.copyEntity(resumeWorkexperienceEntity);
                    resumeWorkexperienceVOs.add(resumeWorkexperienceVO);

                }
                replyDataMode.setData(resumeWorkexperienceVOs);
            }
        }else {

            replyDataMode.setData("用户未登陆");
        }

        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

    @RequestMapping("/saveResumeWorkexperience.do")
    @ResponseBody
    public ReplyDataMode saveResumeWorkexperience(ResumeWorkexperienceSearchForm searchForm, HttpServletRequest request){
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
                ResumeWorkexperienceEntity resumeWorkexperienceEntity = (ResumeWorkexperienceEntity) searchForm.toEntity();
                resumeWorkexperienceEntity.setIsDelete(0);
                Date date = new Date();
                resumeWorkexperienceEntity.setCreateTime(date);
                resumeWorkexperienceEntity.setUpdateTime(date);

                try {

                    this.sysService.saveOrUpdate(resumeWorkexperienceEntity);

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

    @RequestMapping("/updateResumeWorkexperience.do")
    @ResponseBody
    public ReplyDataMode updateResumeWorkexperience(ResumeWorkexperienceSearchForm searchForm, HttpServletRequest request) {

        String result = "操作成功";
        ReplyDataMode replyDataMode = new ReplyDataMode();

        ResumeWorkexperienceEntity resumeWorkexperienceEntity = this.sysService.getEntity(ResumeWorkexperienceEntity.class,searchForm.getId());

        resumeWorkexperienceEntity.setCompanyName(searchForm.getCompanyName());
        resumeWorkexperienceEntity.setCompanyJob(searchForm.getCompanyJob());
        resumeWorkexperienceEntity.setCompanyStart(searchForm.getCompanyStart());
        resumeWorkexperienceEntity.setCompanyEnd(searchForm.getCompanyEnd());
        resumeWorkexperienceEntity.setWorkExperience(searchForm.getWorkExperience()	);
        resumeWorkexperienceEntity.setImgUrl(searchForm.getImgUrl());
        resumeWorkexperienceEntity.setUpdateTime(new Date());

        try {

            this.sysService.saveOrUpdate(resumeWorkexperienceEntity);

        }catch (Exception e){
            result = "操作失败";
        }

        replyDataMode.setData(result);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);
        return replyDataMode;

    }

    @RequestMapping("/deleteResumeWorkexperience.do")
    @ResponseBody
    public ReplyDataMode deleteResumeWorkexperience(ResumeWorkexperienceSearchForm searchForm, HttpServletRequest request) {

        ReplyDataMode replyDataMode = new ReplyDataMode();
        String result = "操作成功";

        ResumeWorkexperienceEntity resumeWorkexperienceEntity = this.sysService.getEntity(ResumeWorkexperienceEntity.class,searchForm.getId());
        resumeWorkexperienceEntity.setIsDelete(1);

        try {

            this.sysService.saveOrUpdate(resumeWorkexperienceEntity);

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
    public ReplyDataMode resumeWorkexperienceListm(ResumeWorkexperienceSearchForm searchForm, HttpServletRequest request){

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

                List<ResumeWorkexperienceEntity> resumeWorkexperience = this.sysService.list(criteriaQuery);
                List<ResumeWorkexperienceVO> resumeWorkexperienceVOs = new ArrayList<ResumeWorkexperienceVO>();

                for (ResumeWorkexperienceEntity resumeWorkexperienceEntity : resumeWorkexperience) {
                    ResumeWorkexperienceVO resumeWorkexperienceVO = new ResumeWorkexperienceVO();
                    resumeWorkexperienceVO.copyEntity(resumeWorkexperienceEntity);
                    resumeWorkexperienceVOs.add(resumeWorkexperienceVO);

                }
                replyDataMode.setData(resumeWorkexperienceVOs);
            }


        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


}