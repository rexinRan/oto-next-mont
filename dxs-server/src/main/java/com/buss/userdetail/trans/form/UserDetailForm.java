package com.buss.userdetail.trans.form;

import com.buss.userdetail.entity.UserDetailEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

import java.lang.String;


/**
 * Created by Administrator on 2016/6/15.
 */
@Mapping(entityClass= UserDetailEntity.class)
public class UserDetailForm extends SearchForm{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**用户id*/
    @Mapping
    private java.lang.String userId;
    /**真实姓名*/
    @Mapping
    private java.lang.String name;
    /**头像(预留)*/
    @Mapping
    private java.lang.String headImg;
    /**性别*/
    @Mapping
    private java.lang.String sex;
    /**身高(预留)*/
    @Mapping
    private java.lang.String bodyHight;
    /**体重(预留)*/
    @Mapping
    private java.lang.String bodyWeight;
    /**出生日期(预留)*/
    @Mapping
    private java.lang.String borthday;
    /**户籍所在地(预留)*/
    @Mapping
    private java.lang.String residence;
    /**通讯地址*/
    @Mapping
    private java.lang.String postalAddress;
    /**手机号*/
    @Mapping
    private java.lang.String phone;
    /**邮箱*/
    @Mapping
    private java.lang.String email;
    /**邮编*/
    @Mapping
    private java.lang.String zipCode;
    /**民族(预留)*/
    @Mapping
    private java.lang.String preNative;
    /**身份证号*/
    @Mapping
    private java.lang.String idcard;
    /**QQ*/
    @Mapping
    private java.lang.String qq;
    /**MSN(预留)*/
    @Mapping
    private java.lang.String msn;
    /**学校名称*/
    @Mapping
    private java.lang.String schoolName;
    /**学校所在地*/
    @Mapping
    private java.lang.String schoolAddress;
    /**入学时间(预留)*/
    @Mapping
    private java.lang.String schoolAdmission;
    /**毕业时间(预留)*/
    @Mapping
    private java.lang.String schoolGraduation;
    /**年级*/
    @Mapping
    private java.lang.String schoolGrade;
    /**专业*/
    @Mapping
    private java.lang.String schoolMajor;
    /**院系*/
    @Mapping
    private java.lang.String schoolFaculty;
    /**部门科室*/
    @Mapping
    private java.lang.String department;
    /**学历*/
    @Mapping
    private java.lang.String schoolEducation;
    /**证书(预留)*/
    @Mapping
    private java.lang.String schoolCertificate;
    /**爱好*/
    @Mapping
    private java.lang.String hobby;
    /**备注*/
    @Mapping
    private java.lang.String remarks;
    /**创建时间*/
    @Mapping
    private java.lang.String createTime;
    /**更新时间*/
    @Mapping
    private java.lang.String updateTime;
    /**删除标志*/
    @Mapping
    private java.lang.String isDelete;

    /**任职院校*/
    @Mapping
    private java.lang.String jobSchool;

    /**任职职位*/
    @Mapping
    private java.lang.String jobSchoolPosition;


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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getBorthday() {
        return borthday;
    }

    public void setBorthday(String borthday) {
        this.borthday = borthday;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getSchoolFaculty() {
        return schoolFaculty;
    }

    public void setSchoolFaculty(String schoolFaculty) {
        this.schoolFaculty = schoolFaculty;
    }

    public String getResidence() {
        return residence;
    }

    public void setResidence(String residence) {
        this.residence = residence;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
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

    public String getSchoolGrade() {
        return schoolGrade;
    }

    public void setSchoolGrade(String schoolGrade) {
        this.schoolGrade = schoolGrade;
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

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
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

    public String getupdateTime() {
        return updateTime;
    }

    public void setupdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getJobSchool() {
        return jobSchool;
    }

    public void setJobSchool(String jobSchool) {
        this.jobSchool = jobSchool;
    }

    public String getJobSchoolPosition() {
        return jobSchoolPosition;
    }

    public void setJobSchoolPosition(String jobSchoolPosition) {
        this.jobSchoolPosition = jobSchoolPosition;
    }
}
