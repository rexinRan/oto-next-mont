package com.buss.employed.trans.form;


import com.buss.employed.entity.EmployedEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;
import org.jweb.core.query.annotation.QueryStrategy;

/**

 * @author lu
 * @date 2016-06-02 16:56:51
 * @version V1.0
 *
 */
@Mapping(entityClass=EmployedEntity.class)
public class EmployedForm extends SearchForm {

    /**主键*/
    @Mapping
    private java.lang.String id;
    /**就业分类*/
    @Mapping
    private java.lang.String employedCatalogId;
    /**发布人id*/
    @Mapping
    private java.lang.String userId;
    /**定向就业组的id*/
    @Mapping
    private java.lang.String degId;
    /**线上专场id*/
    @Mapping
    private java.lang.String osId;
    /**职位名称*/
    @Mapping
    private java.lang.String employedName;
    /**工作地点*/
    @Mapping
    @QueryStrategy
    private java.lang.String employedPosition;
    /**月薪*/
    @Mapping
    private java.lang.String employedSalary;
    /**招聘岗位数目*/
    @Mapping
    private java.lang.String employedNum;
    /**岗位职责*/
    @Mapping
    private java.lang.String employedResponsibilities;
    /**任职要求*/
    @Mapping
    private java.lang.String employedRequirements;
    /**职位类型*/
    @Mapping
    private java.lang.String employedType;
    /**工作经验*/
    @Mapping
    private java.lang.String experience;
    /**学历*/
    @Mapping
    private java.lang.String education;
    /**公司名称*/
    @Mapping
    private java.lang.String compancyName;
    /**公司网址*/
    @Mapping
    private java.lang.String compancyAddress;
    /**联系人*/
    @Mapping
    private java.lang.String contactName;
    /**电话*/
    @Mapping
    private java.lang.String contactTel;
    /**手机*/
    @Mapping
    private java.lang.String contactPhone;
    /**邮箱*/
    @Mapping
    private java.lang.String contactMail;
    /**线上招聘针对大学*/
    @Mapping
    private java.lang.String university;
    /**招聘信息发布时间*/
    @Mapping
    private java.lang.String publishTime;
    /**福利待遇(新增)*/
    @Mapping
    private java.lang.String employedPerks;
    /**投递人数(预留)*/
    @Mapping
    private java.lang.String postNum;
    /**创建时间*/
    @Mapping
    private java.lang.String createTime;
    /**更新时间*/
    @Mapping
    private java.lang.String updateTime;
    /**删除标志*/
    @Mapping
    private java.lang.String isDelete;
    /**专业要求*/
    @Mapping
    private  String employMajor;
    @Mapping("userEntity.userCompancyEntity.compancyNature")
    private  String companyNature;

    /**招聘状态*/
    @Mapping
    private java.lang.String status;

    public String getOsId() {
        return osId;
    }

    public void setOsId(String osId) {
        this.osId = osId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployedCatalogId() {
        return employedCatalogId;
    }

    public void setEmployedCatalogId(String employedCatalogId) {
        this.employedCatalogId = employedCatalogId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDegId() {
        return degId;
    }

    public void setDegId(String degId) {
        this.degId = degId;
    }

    public String getEmployedName() {
        return employedName;
    }

    public void setEmployedName(String employedName) {
        this.employedName = employedName;
    }

    public String getEmployedPosition() {
        return employedPosition;
    }

    public void setEmployedPosition(String employedPosition) {
        this.employedPosition = employedPosition;
    }

    public String getEmployedSalary() {
        return employedSalary;
    }

    public void setEmployedSalary(String employedSalary) {
        this.employedSalary = employedSalary;
    }

    public String getEmployedNum() {
        return employedNum;
    }

    public void setEmployedNum(String employedNum) {
        this.employedNum = employedNum;
    }

    public String getEmployedResponsibilities() {
        return employedResponsibilities;
    }

    public void setEmployedResponsibilities(String employedResponsibilities) {
        this.employedResponsibilities = employedResponsibilities;
    }

    public String getEmployedRequirements() {
        return employedRequirements;
    }

    public void setEmployedRequirements(String employedRequirements) {
        this.employedRequirements = employedRequirements;
    }

    public String getEmployedType() {
        return employedType;
    }

    public void setEmployedType(String employedType) {
        this.employedType = employedType;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCompancyName() {
        return compancyName;
    }

    public void setCompancyName(String compancyName) {
        this.compancyName = compancyName;
    }

    public String getCompancyAddress() {
        return compancyAddress;
    }

    public void setCompancyAddress(String compancyAddress) {
        this.compancyAddress = compancyAddress;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    public String getContactMail() {
        return contactMail;
    }

    public void setContactMail(String contactMail) {
        this.contactMail = contactMail;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getEmployedPerks() {
        return employedPerks;
    }

    public void setEmployedPerks(String employedPerks) {
        this.employedPerks = employedPerks;
    }

    public String getPostNum() {
        return postNum;
    }

    public void setPostNum(String postNum) {
        this.postNum = postNum;
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

    public String getCompanyNature() {
        return companyNature;
    }

    public void setCompanyNature(String companyNature) {
        this.companyNature = companyNature;
    }

    public String getEmployMajor() {
        return employMajor;
    }

    public void setEmployMajor(String employMajor) {
        this.employMajor = employMajor;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
