package com.buss.resume.resume.trans.form;

import com.buss.resume.resume.entity.ResumeEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * @author lu
 * @date 2016-06-16 17:10:38
 * @version V1.0
 *
 */
@Mapping(entityClass=ResumeEntity.class)
public class ResumeSearchForm extends SearchForm{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**简历模板id*/
    @Mapping
    private java.lang.String rtId;
    /**用户id*/
    @Mapping
    private java.lang.String userid;
    /**姓名*/
    @Mapping
    private java.lang.String name;
    /**头像*/
    @Mapping
    private java.lang.String headImg;
    /**性别*/
    @Mapping
    private java.lang.String sex;
    /**身高*/
    @Mapping
    private java.lang.String bodyHight;
    /**体重*/
    @Mapping
    private java.lang.String bodyWeight;
    /**出生日期*/
    @Mapping
    private java.lang.String borthday;
    /**户籍所在地*/
    @Mapping
    private java.lang.String residence;
    /**工作经验*/
    @Mapping
    private java.lang.String workExperience;
    /**手机号*/
    @Mapping
    private java.lang.String phone;
    /**邮箱*/
    @Mapping
    private java.lang.String email;
    /**民族*/
    @Mapping
    private java.lang.String preNative;
    /**身份证号*/
    @Mapping
    private java.lang.String idcard;
    /**QQ*/
    @Mapping
    private java.lang.String qq;
    /**MSN*/
    @Mapping
    private java.lang.String msn;
    /**求职状态*/
    @Mapping
    private java.lang.String jobStatus;
    /**期望地点*/
    @Mapping
    private java.lang.String targetAddress;
    /**职位类别*/
    @Mapping
    private java.lang.String targetJobType;
    /**求职岗位(期望职位)*/
    @Mapping
    private java.lang.String targetJob;
    /**求职类型(职位类型)*/
    @Mapping
    private java.lang.String jobType;
    /**学校名称*/
    @Mapping
    private java.lang.String schoolName;
    /**学校地址*/
    @Mapping
    private java.lang.String schoolAddress;
    /**入学时间*/
    @Mapping
    private java.lang.String schoolAdmission;
    /**毕业时间*/
    @Mapping
    private java.lang.String schoolGraduation;
    /**专业*/
    @Mapping
    private java.lang.String schoolMajor;
    /**学历*/
    @Mapping
    private java.lang.String schoolEducation;
    /**证书*/
    @Mapping
    private java.lang.String schoolCertificate;
    /**专业技能*/
    @Mapping
    private java.lang.String professional;
    /**兴趣爱好*/
    @Mapping
    private java.lang.String hobby;
    /**自我评价(其他信息)*/
    @Mapping
    private java.lang.String selfAssessment;
    /**简历附件*/
    @Mapping
    private java.lang.String accessories;
    /**备注*/
    @Mapping
    private java.lang.String remarks;
    /**创建时间*/
    @Mapping
    private String createTime;
    /**更新时间*/
    @Mapping
    private String updateTime;
    /**删除标志*/
    @Mapping
    private String isDelete;
    /**是否公开*/
    @Mapping
    private String isPublic;

    public String getRtId() {
        return rtId;
    }

    public void setRtId(String rtId) {
        this.rtId = rtId;
    }

    public String getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBodyHight() {
        return bodyHight;
    }

    public void setBodyHight(String bodyHight) {
        this.bodyHight = bodyHight;
    }

    public String getBodyWeight() {
        return bodyWeight;
    }

    public void setBodyWeight(String bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    public String getBorthday() {
        return borthday;
    }

    public void setBorthday(String borthday) {
        this.borthday = borthday;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPreNative() {
        return preNative;
    }

    public void setPreNative(String preNative) {
        this.preNative = preNative;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getMsn() {
        return msn;
    }

    public void setMsn(String msn) {
        this.msn = msn;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public String getTargetAddress() {
        return targetAddress;
    }

    public void setTargetAddress(String targetAddress) {
        this.targetAddress = targetAddress;
    }

    public String getTargetJobType() {
        return targetJobType;
    }

    public void setTargetJobType(String targetJobType) {
        this.targetJobType = targetJobType;
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

    public String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(String schoolAddress) {
        this.schoolAddress = schoolAddress;
    }

    public String getSchoolAdmission() {
        return schoolAdmission;
    }

    public void setSchoolAdmission(String schoolAdmission) {
        this.schoolAdmission = schoolAdmission;
    }

    public String getSchoolGraduation() {
        return schoolGraduation;
    }

    public void setSchoolGraduation(String schoolGraduation) {
        this.schoolGraduation = schoolGraduation;
    }

    public String getSchoolMajor() {
        return schoolMajor;
    }

    public void setSchoolMajor(String schoolMajor) {
        this.schoolMajor = schoolMajor;
    }

    public String getSchoolEducation() {
        return schoolEducation;
    }

    public void setSchoolEducation(String schoolEducation) {
        this.schoolEducation = schoolEducation;
    }

    public String getSchoolCertificate() {
        return schoolCertificate;
    }

    public void setSchoolCertificate(String schoolCertificate) {
        this.schoolCertificate = schoolCertificate;
    }

    public String getProfessional() {
        return professional;
    }

    public void setProfessional(String professional) {
        this.professional = professional;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getSelfAssessment() {
        return selfAssessment;
    }

    public void setSelfAssessment(String selfAssessment) {
        this.selfAssessment = selfAssessment;
    }

    public String getAccessories() {
        return accessories;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
}
