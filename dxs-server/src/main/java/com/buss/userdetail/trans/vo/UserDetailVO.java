package com.buss.userdetail.trans.vo;

import com.buss.userdetail.entity.UserDetailEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

import java.util.List;


/**
 * Created by Administrator on 2016/6/15.
 */
@Mapping(entityClass = UserDetailEntity.class)
public class UserDetailVO extends BaseVO{
    /**主键*/
    @Mapping
    private java.lang.String id;

    @Mapping
    private java.lang.String userId;

    /**真实姓名*/
    @Mapping("userEntity.realname")
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
    @Mapping("userEntity.mphone")
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

    /**院系*/
    @Mapping
    private java.lang.String schoolFaculty;

    /**部门科室*/
    @Mapping
    private java.lang.String department;

    /**专业*/
    @Mapping
    private java.lang.String schoolMajor;

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
    private java.lang.String upStringTime;

    /**删除标志*/
    @Mapping
    private java.lang.String isDelete;
    /**任职院校*/
    @Mapping
    private java.lang.String jobSchool;

    /**任职职位*/
    @Mapping
    private java.lang.String jobSchoolPosition;
    /**就职单位*/
    private List jobSchoolList;

    public List getJobSchoolList() {
        return jobSchoolList;
    }

    public void setJobSchoolList(List jobSchoolList) {
        this.jobSchoolList = jobSchoolList;
    }

    public java.lang.String getId() {
        return id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public java.lang.String getUserId() {
        return userId;
    }

    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public java.lang.String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(java.lang.String headImg) {
        this.headImg = headImg;
    }

    public java.lang.String getSex() {
        return sex;
    }

    public void setSex(java.lang.String sex) {
        this.sex = sex;
    }

    public java.lang.String getBodyHight() {
        return bodyHight;
    }

    public void setBodyHight(java.lang.String bodyHight) {
        this.bodyHight = bodyHight;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public java.lang.String getBodyWeight() {
        return bodyWeight;
    }

    public void setBodyWeight(java.lang.String bodyWeight) {
        this.bodyWeight = bodyWeight;
    }

    public java.lang.String getBorthday() {
        return borthday;
    }

    public void setBorthday(java.lang.String borthday) {
        this.borthday = borthday;
    }

    public java.lang.String getResidence() {
        return residence;
    }

    public void setResidence(java.lang.String residence) {
        this.residence = residence;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getSchoolFaculty() {
        return schoolFaculty;
    }

    public void setSchoolFaculty(String schoolFaculty) {
        this.schoolFaculty = schoolFaculty;
    }

    public java.lang.String getPhone() {
        return phone;
    }

    public void setPhone(java.lang.String phone) {
        this.phone = phone;
    }

    public java.lang.String getEmail() {
        return email;
    }

    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    public java.lang.String getPreNative() {
        return preNative;
    }

    public void setPreNative(java.lang.String preNative) {
        this.preNative = preNative;
    }

    public java.lang.String getIdcard() {
        return idcard;
    }

    public void setIdcard(java.lang.String idcard) {
        this.idcard = idcard;
    }

    public java.lang.String getQq() {
        return qq;
    }

    public void setQq(java.lang.String qq) {
        this.qq = qq;
    }

    public java.lang.String getMsn() {
        return msn;
    }

    public void setMsn(java.lang.String msn) {
        this.msn = msn;
    }

    public java.lang.String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(java.lang.String schoolName) {
        this.schoolName = schoolName;
    }

    public java.lang.String getSchoolAddress() {
        return schoolAddress;
    }

    public void setSchoolAddress(java.lang.String schoolAddress) {
        this.schoolAddress = schoolAddress;
    }

    public java.lang.String getSchoolAdmission() {
        return schoolAdmission;
    }

    public void setSchoolAdmission(java.lang.String schoolAdmission) {
        this.schoolAdmission = schoolAdmission;
    }

    public java.lang.String getSchoolGraduation() {
        return schoolGraduation;
    }

    public void setSchoolGraduation(java.lang.String schoolGraduation) {
        this.schoolGraduation = schoolGraduation;
    }

    public java.lang.String getSchoolMajor() {
        return schoolMajor;
    }

    public void setSchoolMajor(java.lang.String schoolMajor) {
        this.schoolMajor = schoolMajor;
    }

    public java.lang.String getSchoolEducation() {
        return schoolEducation;
    }

    public void setSchoolEducation(java.lang.String schoolEducation) {
        this.schoolEducation = schoolEducation;
    }

    public java.lang.String getSchoolCertificate() {
        return schoolCertificate;
    }

    public void setSchoolCertificate(java.lang.String schoolCertificate) {
        this.schoolCertificate = schoolCertificate;
    }

    public java.lang.String getRemarks() {
        return remarks;
    }

    public void setRemarks(java.lang.String remarks) {
        this.remarks = remarks;
    }

    public java.lang.String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(java.lang.String createTime) {
        this.createTime = createTime;
    }

    public java.lang.String getUpStringTime() {
        return upStringTime;
    }

    public void setUpStringTime(java.lang.String upStringTime) {
        this.upStringTime = upStringTime;
    }

    public java.lang.String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(java.lang.String isDelete) {
        this.isDelete = isDelete;
    }

    public java.lang.String getSchoolGrade() {
        return schoolGrade;
    }

    public void setSchoolGrade(java.lang.String schoolGrade) {
        this.schoolGrade = schoolGrade;
    }

    public java.lang.String getHobby() {
        return hobby;
    }

    public void setHobby(java.lang.String hobby) {
        this.hobby = hobby;
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
