package com.buss.interview.controller;

import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;
import com.buss.employed.entity.EmployedEntity;
import com.buss.employed.trans.form.EmployedForm;
import com.buss.interview.entity.InterviewEntity;
import com.buss.interview.trans.form.InterviewForm;
import com.buss.interviewassessment.entity.InterviewAssessmentEntity;
import com.buss.interviewassessment.trans.form.InterviewAssessmentForm;
import com.buss.interviewassessment.trans.vo.InterviewAssessmentVo;
import com.buss.resumeuser.entity.ResumeUserEntity;
import com.buss.resumeuser.trans.form.ResumeUserForm;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.runtime.internal.cflowstack.ThreadStackImpl11;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/6/25.
 */
@Controller
@RequestMapping("/InterviewController")
public class InterviewController {

    @Resource
    private SysServiceI sysServiceI;

    /**
     * 查询面试邀请
     * @param interviewForm   面试邀请(需要投递简历的ID)
     * @param request
     * @return
     */
    @RequestMapping("/InterviewInvitation")
    @ResponseBody
    public ReplyDataMode InterviewInvitation(InterviewForm interviewForm,HttpServletRequest request){
        interviewForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();

        CriteriaQuery criteriaQuery = interviewForm.getCriteriaQuery();
        // 查询面试邀请
        List<InterviewEntity> interviewEntityList = this.sysServiceI.list(criteriaQuery);

        if (interviewEntityList != null && interviewEntityList.size() > 0){
            replyDataMode.setData(interviewEntityList.get(0));
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);
            return replyDataMode;
        }

        replyDataMode.setStatusCode("查询失败！");
        replyDataMode.setSuccess(false);
        return replyDataMode;
    }


    /**
     * 查询用户对该公司中的某种职位的所有评价
     * @param interviewForm  面试邀请表
     * @param request
     * @return
     */
    @RequestMapping("/queryAllEvaluation")
    @ResponseBody
    public ReplyDataMode queryAllEvaluation( InterviewForm interviewForm,HttpServletRequest request,Integer curPage, Integer pageSize){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 通过当前用户的面试邀请的ID查询投递简历的ID
        if (interviewForm.getId() != "" && interviewForm.getId() != null){
            // 查询面试邀请
            InterviewEntity interviewEntity = this.sysServiceI.get(InterviewEntity.class,interviewForm.getId());
            if (interviewEntity != null){
                // 查询简历投递
                ResumeUserEntity resumeUserEntity = this.sysServiceI.get(ResumeUserEntity.class,interviewEntity.getResumeUserId());
                if(resumeUserEntity != null) {
                    // 通过职位的ID(注:职位的一条ID就指定了某个公司中的某个职位)查询所有的用户的简历投递
                    ResumeUserForm resumeUserForm = new ResumeUserForm();
                    resumeUserForm.setIsDelete("0");
                    // 设置已收到面试邀请的查询条件
                    resumeUserForm.setResult("1");
                    resumeUserForm.setEmoloyedId(resumeUserEntity.getEmoloyedId());
                    CriteriaQuery criteriaQuery = resumeUserForm.getCriteriaQuery();
                    // 查询所有的用户的简历投递
                    List<ResumeUserEntity> resumeUserEntityList = this.sysServiceI.list(criteriaQuery);
                    if (resumeUserEntityList != null && resumeUserEntityList.size() > 0) {
                        // 存放多个评价
                        List<InterviewAssessmentVo> interviewAssessmentVos = new ArrayList<InterviewAssessmentVo>();
                        PageMode mode = new PageMode();
                        for (ResumeUserEntity resumeUserEntity1 : resumeUserEntityList) {
                            // 通过每个投送简历的ID查询相对应的面试邀请
                            interviewForm.setId(null);
                            interviewForm.setIsDelete("0");
                            interviewForm.setResumeUserId(resumeUserEntity1.getId());
                            CriteriaQuery criteriaQuery1 = interviewForm.getCriteriaQuery();
                            // 查询面试邀请
                            List<InterviewEntity> interviewEntityList = this.sysServiceI.list(criteriaQuery1);
                            if (interviewEntityList != null && interviewEntityList.size() > 0) {
                                for (InterviewEntity interviewEntity1 : interviewEntityList) {
                                    // 通过每个面试邀请的ID查询所指定的评价信息
                                    InterviewAssessmentForm interviewAssessmentForm = new InterviewAssessmentForm();
                                    interviewAssessmentForm.setIsDelete("0");
                                    interviewAssessmentForm.setInterviewId(interviewEntity1.getId());
                                    CriteriaQuery criteriaQuery2 = interviewAssessmentForm.getCriteriaQuery();
                                    criteriaQuery2.setCurPage(curPage);
                                    criteriaQuery2.setPageSize(pageSize);
                                    criteriaQuery2.addOrder("publishTime","desc");
                                    // 查询评价信息
                                    mode = this.sysServiceI.list4page(criteriaQuery2,curPage,pageSize);
                                    List<InterviewAssessmentEntity> interviewAssessmentEntityList = mode.getResult();
                                    if (interviewAssessmentEntityList != null && interviewAssessmentEntityList.size() > 0) {
                                        for (InterviewAssessmentEntity interviewAssessmentEntity : interviewAssessmentEntityList) {
                                            InterviewAssessmentVo interviewAssessmentVo = new InterviewAssessmentVo();
                                            interviewAssessmentVo.copyEntity(interviewAssessmentEntity);
                                            interviewAssessmentVos.add(interviewAssessmentVo);

                                        }
                                    }
                                }
                            }
                        }
                        mode.setResult(interviewAssessmentVos);
                        replyDataMode.setData(mode);
                        replyDataMode.setStatusCode("200");
                        replyDataMode.setSuccess(true);
                        return replyDataMode;
                    }
                }
            }
        }
        replyDataMode.setStatusCode("没有评价信息！");
        replyDataMode.setSuccess(false);
        return replyDataMode;
    }


    /**
     * 保存面试邀请中对企业的评价
     * @param interviewAssessmentEntity
     * @param request
     * @return
     */
    @RequestMapping("/saveAppraise")
    @ResponseBody
    public ReplyDataMode saveAppraise(InterviewAssessmentEntity interviewAssessmentEntity,HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 获取用户相关信息
        Subject subject = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) subject.getSession().getAttribute("userInfo");

        try {
            if (interviewAssessmentEntity.getInterviewId() != null && !interviewAssessmentEntity.getInterviewId().isEmpty()){
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String date = format.format(new Date());
                Date date1 = new Date();

                if (user != null){
                    interviewAssessmentEntity.setUserId(user.getId());
                    interviewAssessmentEntity.setPublishTime(date);
                    interviewAssessmentEntity.setCreateTime(date1);
                    interviewAssessmentEntity.setUpdateTime(date1);
                    interviewAssessmentEntity.setIsDelete(0);

                    // 保存
                    this.sysServiceI.saveOrUpdate(interviewAssessmentEntity);

                    replyDataMode.setData("保存成功!");
                    replyDataMode.setStatusCode("200");
                    replyDataMode.setSuccess(true);
                }
            }
        }catch (Exception ex){
            replyDataMode.setStatusCode("保存失败！");
            replyDataMode.setSuccess(false);
        }
        return replyDataMode;
    }
}
