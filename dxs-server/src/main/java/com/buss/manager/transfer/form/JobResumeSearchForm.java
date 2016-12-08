package com.buss.manager.transfer.form;

import com.buss.resumeuser.entity.ResumeUserEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;
import org.jweb.core.query.annotation.QueryStrategy;

@Mapping(entityClass=ResumeUserEntity.class)
public class JobResumeSearchForm extends SearchForm{

    /* 职位ID */
    @Mapping("employedEntity.id")
    private java.lang.String emoloyedId;

    /* 职位关联的用户ID（意思就是由哪个企业用户发布的职位） */
    @Mapping("employedEntity.userId")
    private java.lang.String userIdEmp;

    /* 工作类型 */
    @Mapping("resumeEntity.jobType")
    private java.lang.String jobType;

    /* 学历 */
    @Mapping("resumeEntity.schoolEducation")
    private java.lang.String schoolEducation;

    /* 学历 */
    @Mapping("resumeEntity.sex")
    private java.lang.String sex;

    /* 投递类型（1主动投递，2老师推荐） */
    @Mapping
    private java.lang.String rtype;

    /* 0-未操作 5-查看简历 15-标记为不合适 20-发面试邀请 30-已发offer */
    @Mapping
    private java.lang.String result;

    /* 投递简历的用户ID */
    @Mapping
    private java.lang.String userId;
    @Mapping
    private java.lang.String isDelete;

    // 简历搜索 查询条件-模糊查询
    /**求职岗位*/
    @Mapping("resumeEntity.targetJob")
    @QueryStrategy
    private java.lang.String targetJob;
    /* 职位名称 */
    @Mapping("employedEntity.employedName")
    @QueryStrategy
    private java.lang.String employedName;



    public String getEmoloyedId() {
        return emoloyedId;
    }

    public void setEmoloyedId(String emoloyedId) {
        this.emoloyedId = emoloyedId;
    }

    public String getUserIdEmp() {
        return userIdEmp;
    }

    public void setUserIdEmp(String userIdEmp) {
        this.userIdEmp = userIdEmp;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getSchoolEducation() {
        return schoolEducation;
    }

    public void setSchoolEducation(String schoolEducation) {
        this.schoolEducation = schoolEducation;
    }

    public String getRtype() {
        return rtype;
    }

    public void setRtype(String rtype) {
        this.rtype = rtype;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getTargetJob() {
        return targetJob;
    }

    public void setTargetJob(String targetJob) {
        this.targetJob = targetJob;
    }

    public String getEmployedName() {
        return employedName;
    }

    public void setEmployedName(String employedName) {
        this.employedName = employedName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
