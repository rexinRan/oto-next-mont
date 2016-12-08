package com.buss.manager.transfer.vo;

import com.buss.resumeuser.entity.ResumeUserEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/6/20.
 */
@Mapping(entityClass = ResumeUserEntity.class)
public class JobResumeVO extends BaseVO {

    /**
     * 主键
     */
    @Mapping
    private String id;
    /**
     * 用户ID
     */
    @Mapping("generalUserEntity.id")
    private String userId;
    /**
     * 投递人
     */
    @Mapping
    private String userName;
    /**
     * 简历的id
     */
    @Mapping("resumeEntity.id")
    private String resumeId;
    /**
     * 职位id
     */
    @Mapping("employedEntity.id")
    private String emoloyedId;
    /**
     * 投递时间
     */
    @Mapping
    private String sendTime;
    /**
     * 结果
     */
    @Mapping
    private String result;
    /**
     * 类型
     */
    @Mapping
    private String type;
    /**
     * 创建时间
     */
    @Mapping
    private String createTime;
    /**
     * 更新时间
     */
    @Mapping
    private String upStringTime;
    /**
     * 删除标志
     */
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
    }

    public String getEmoloyedId() {
        return emoloyedId;
    }

    public void setEmoloyedId(String emoloyedId) {
        this.emoloyedId = emoloyedId;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    // ================================================关联字段映射======================================

    /**公司名称*/
    @Mapping("employedEntity.compancyName")
    private String compancyName;

    public String getCompancyName() {
        return compancyName;
    }

    public void setCompancyName(String compancyName) {
        this.compancyName = compancyName;
    }


    /**姓名*/
    @Mapping("resumeEntity.name")
    private String name;
    /**性别*/
    @Mapping("resumeEntity.sex")
    private String sex;
    /**求职岗位*/
    @Mapping("resumeEntity.targetJob")
    private String targetJob;
    /**求职类型*/
    @Mapping("resumeEntity.jobType")
    private String jobType;

    /**学校名称*/
    @Mapping("resumeEntity.schoolName")
    private String schoolName;
    /**学历*/
    @Mapping("resumeEntity.schoolEducation")
    private String schoolEducation;


    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTargetJob() {
        return targetJob;
    }

    public void setTargetJob(String targetJob) {
        this.targetJob = targetJob;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolEducation() {
        return schoolEducation;
    }

    public void setSchoolEducation(String schoolEducation) {
        this.schoolEducation = schoolEducation;
    }


    /**
     * 格式化后的时间
     */
    private String formatDate;

    public String getFormatDate() {
        return formatDate;
    }

    public void setFormatDate(String formatDate) {
        this.formatDate = formatDate;
    }
}