package com.buss.manager.transfer.form;

import com.buss.interviewassessment.entity.InterviewAssessmentEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/6/25.
 */

@Mapping(entityClass=InterviewAssessmentEntity.class)
public class EmpInterviewAssessmentForm extends SearchForm{

    /**主键*/
    @Mapping
    private String id;
    /**用户的id*/
    @Mapping
    private String userId;
    /**面试邀请的id*/
    @Mapping
    private String interviewId;

    /**面试邀请的id*/
    @Mapping("interviewEntity.id")
    private String ieId;
    /**投送简历的id*/
    @Mapping("interviewEntity.resumeUserId")
    private String resumeUserId;
    /**投送简历的 简历和用户关联表 */
    @Mapping("interviewEntity.resumeEntity")
    private String resumeUserEntity;


    /**公司环境*/
    @Mapping
    private String corporateEnvironment;
    /**员工氛围*/
    @Mapping
    private String employeeAtmosphere;
    /**面试情况*/
    @Mapping
    private String interviewerLevel;
    /**评论内容*/
    @Mapping
    private String assessmentContent;
    /**评价时间*/
    @Mapping
    private String publishTime;
    /**创建时间*/
    @Mapping
    private String createTime;
    /**更新时间*/
    @Mapping
    private String upStringTime;
    /**删除标志*/
    @Mapping
    private String isDelete;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getInterviewId() {
        return interviewId;
    }

    public void setInterviewId(String interviewId) {
        this.interviewId = interviewId;
    }

    public String getCorporateEnvironment() {
        return corporateEnvironment;
    }

    public void setCorporateEnvironment(String corporateEnvironment) {
        this.corporateEnvironment = corporateEnvironment;
    }

    public String getEmployeeAtmosphere() {
        return employeeAtmosphere;
    }

    public void setEmployeeAtmosphere(String employeeAtmosphere) {
        this.employeeAtmosphere = employeeAtmosphere;
    }

    public String getInterviewerLevel() {
        return interviewerLevel;
    }

    public void setInterviewerLevel(String interviewerLevel) {
        this.interviewerLevel = interviewerLevel;
    }

    public String getAssessmentContent() {
        return assessmentContent;
    }

    public void setAssessmentContent(String assessmentContent) {
        this.assessmentContent = assessmentContent;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpStringTime() {
        return upStringTime;
    }

    public void setUpStringTime(String upStringTime) {
        this.upStringTime = upStringTime;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getIeId() {
        return ieId;
    }

    public void setIeId(String ieId) {
        this.ieId = ieId;
    }

    public String getResumeUserId() {
        return resumeUserId;
    }

    public void setResumeUserId(String resumeUserId) {
        this.resumeUserId = resumeUserId;
    }

    public String getResumeUserEntity() {
        return resumeUserEntity;
    }

    public void setResumeUserEntity(String resumeUserEntity) {
        this.resumeUserEntity = resumeUserEntity;
    }
}
