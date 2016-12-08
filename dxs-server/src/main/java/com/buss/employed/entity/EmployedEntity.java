package com.buss.employed.entity;

import com.buss.directionalemploymentgroups.entity.DirectionalEmploymentGroupsEntity;
import com.buss.member.entity.GeneralUserEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @Title: Entity
 * @Description: dxs_employed
 * @author onlineGenerator
 * @date 2016-08-02 16:30:05
 * @version V1.0
 *
 */
@Entity
@Table(name = "dxs_employed", schema = "")
@SuppressWarnings("serial")
public class EmployedEntity implements java.io.Serializable {
    /**主键*/
    private java.lang.String id;
    /**就业分类*/

    private java.lang.String employedCatalogId;
    /**发布人id*/

    private java.lang.String userId;
    /**定向就业组的id*/

    private java.lang.String degId;
    /**线上专场id*/

    private java.lang.String osId;
    /**职位名称*/

    private java.lang.String employedName;
    /**工作地点*/

    private java.lang.String employedPosition;
    /**月薪*/

    private java.lang.String employedSalary;
    /**招聘岗位数目*/

    private java.lang.Integer employedNum;
    /**专业要求*/

    private  String employMajor;
    /**岗位职责*/

    private java.lang.String employedResponsibilities;
    /**任职要求*/

    private java.lang.String employedRequirements;
    /**职位类型*/

    private java.lang.String employedType;
    /**工作经验*/

    private java.lang.String experience;
    /**学历*/

    private java.lang.String education;
    /**公司名称*/

    private java.lang.String compancyName;
    /**公司网址*/

    private java.lang.String compancyAddress;
    /**联系人*/

    private java.lang.String contactName;
    /**电话*/

    private java.lang.String contactTel;
    /**手机*/

    private java.lang.String contactPhone;
    /**邮箱*/

    private java.lang.String contactMail;
    /**线上招聘针对大学*/

    private java.lang.String university;
    /**招聘信息发布时间*/

    private java.util.Date publishTime;
    /**福利待遇(新增)*/

    private java.lang.String employedPerks;
    /**投递人数(预留)*/

    private java.lang.Integer postNum;
    /**创建时间*/

    private java.util.Date createTime;
    /**更新时间*/

    private java.util.Date updateTime;
    /**删除标志*/

    private java.lang.Integer isDelete;
    /**关联用户实体*/
    private GeneralUserEntity userEntity;
    /**定向就业组*/
    private DirectionalEmploymentGroupsEntity groupsEntity;
    /**招聘状态*/
    private java.lang.Integer status;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "DEG_ID",insertable = false, updatable = false)
    public DirectionalEmploymentGroupsEntity getGroupsEntity() {
        return groupsEntity;
    }

    public void setGroupsEntity(DirectionalEmploymentGroupsEntity groupsEntity) {
        this.groupsEntity = groupsEntity;
    }

    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  主键
     */
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    @Column(name ="ID",nullable=false,length=32)
    public java.lang.String getId(){
        return this.id;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  主键
     */
    public void setId(java.lang.String id){
        this.id = id;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  就业分类
     */
    @Column(name ="EMPLOYED_CATALOG_ID",nullable=true,length=32)
    public java.lang.String getEmployedCatalogId(){
        return this.employedCatalogId;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  就业分类
     */
    public void setEmployedCatalogId(java.lang.String employedCatalogId){
        this.employedCatalogId = employedCatalogId;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  发布人id
     */
    @Column(name ="USER_ID",nullable=true,length=32)
    public java.lang.String getUserId(){
        return this.userId;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  发布人id
     */
    public void setUserId(java.lang.String userId){
        this.userId = userId;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  定向就业组的id
     */
    @Column(name ="DEG_ID",nullable=true,length=32)
    public java.lang.String getDegId(){
        return this.degId;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  定向就业组的id
     */
    public void setDegId(java.lang.String degId){
        this.degId = degId;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  线上专场id
     */
    @Column(name ="OS_ID",nullable=true,length=32)
    public java.lang.String getOsId(){
        return this.osId;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  线上专场id
     */
    public void setOsId(java.lang.String osId){
        this.osId = osId;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  职位名称
     */
    @Column(name ="EMPLOYED_NAME",nullable=true,length=100)
    public java.lang.String getEmployedName(){
        return this.employedName;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  职位名称
     */
    public void setEmployedName(java.lang.String employedName){
        this.employedName = employedName;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  专业要求
     */
    @Column(name ="EMPLOY_MAJOR",nullable=true,length=100)
    public java.lang.String getEmployMajor(){
        return this.employMajor;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  专业要求
     */
    public void setEmployMajor(java.lang.String employMajor){
        this.employMajor = employMajor;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  工作地点
     */
    @Column(name ="EMPLOYED_POSITION",nullable=true,length=255)
    public java.lang.String getEmployedPosition(){
        return this.employedPosition;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  工作地点
     */
    public void setEmployedPosition(java.lang.String employedPosition){
        this.employedPosition = employedPosition;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  月薪
     */
    @Column(name ="EMPLOYED_SALARY",nullable=true,length=255)
    public java.lang.String getEmployedSalary(){
        return this.employedSalary;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  月薪
     */
    public void setEmployedSalary(java.lang.String employedSalary){
        this.employedSalary = employedSalary;
    }
    /**
     *方法: 取得java.lang.Integer
     *@return: java.lang.Integer  招聘岗位数目
     */
    @Column(name ="EMPLOYED_NUM",nullable=true,length=10)
    public java.lang.Integer getEmployedNum(){
        return this.employedNum;
    }

    /**
     *方法: 设置java.lang.Integer
     *@param: java.lang.Integer  招聘岗位数目
     */
    public void setEmployedNum(java.lang.Integer employedNum){
        this.employedNum = employedNum;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  岗位职责
     */
    @Column(name ="EMPLOYED_RESPONSIBILITIES",nullable=true,length=16777215)
    public java.lang.String getEmployedResponsibilities(){
        return this.employedResponsibilities;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  岗位职责
     */
    public void setEmployedResponsibilities(java.lang.String employedResponsibilities){
        this.employedResponsibilities = employedResponsibilities;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  任职要求
     */
    @Column(name ="EMPLOYED_REQUIREMENTS",nullable=true,length=16777215)
    public java.lang.String getEmployedRequirements(){
        return this.employedRequirements;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  任职要求
     */
    public void setEmployedRequirements(java.lang.String employedRequirements){
        this.employedRequirements = employedRequirements;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  职位类型
     */
    @Column(name ="EMPLOYED_TYPE",nullable=true,length=50)
    public java.lang.String getEmployedType(){
        return this.employedType;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  职位类型
     */
    public void setEmployedType(java.lang.String employedType){
        this.employedType = employedType;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  工作经验
     */
    @Column(name ="EXPERIENCE",nullable=true,length=100)
    public java.lang.String getExperience(){
        return this.experience;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  工作经验
     */
    public void setExperience(java.lang.String experience){
        this.experience = experience;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  学历
     */
    @Column(name ="EDUCATION",nullable=true,length=100)
    public java.lang.String getEducation(){
        return this.education;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  学历
     */
    public void setEducation(java.lang.String education){
        this.education = education;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  公司名称
     */
    @Column(name ="COMPANCY_NAME",nullable=true,length=100)
    public java.lang.String getCompancyName(){
        return this.compancyName;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  公司名称
     */
    public void setCompancyName(java.lang.String compancyName){
        this.compancyName = compancyName;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  公司网址
     */
    @Column(name ="COMPANCY_ADDRESS",nullable=true,length=200)
    public java.lang.String getCompancyAddress(){
        return this.compancyAddress;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  公司网址
     */
    public void setCompancyAddress(java.lang.String compancyAddress){
        this.compancyAddress = compancyAddress;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  联系人
     */
    @Column(name ="CONTACT_NAME",nullable=true,length=100)
    public java.lang.String getContactName(){
        return this.contactName;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  联系人
     */
    public void setContactName(java.lang.String contactName){
        this.contactName = contactName;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  电话
     */
    @Column(name ="CONTACT_TEL",nullable=true,length=20)
    public java.lang.String getContactTel(){
        return this.contactTel;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  电话
     */
    public void setContactTel(java.lang.String contactTel){
        this.contactTel = contactTel;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  手机
     */
    @Column(name ="CONTACT_PHONE",nullable=true,length=11)
    public java.lang.String getContactPhone(){
        return this.contactPhone;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  手机
     */
    public void setContactPhone(java.lang.String contactPhone){
        this.contactPhone = contactPhone;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  邮箱
     */
    @Column(name ="CONTACT_MAIL",nullable=true,length=50)
    public java.lang.String getContactMail(){
        return this.contactMail;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  邮箱
     */
    public void setContactMail(java.lang.String contactMail){
        this.contactMail = contactMail;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  线上招聘针对大学
     */
    @Column(name ="UNIVERSITY",nullable=true,length=100)
    public java.lang.String getUniversity(){
        return this.university;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  线上招聘针对大学
     */
    public void setUniversity(java.lang.String university){
        this.university = university;
    }
    /**
     *方法: 取得java.util.Date
     *@return: java.util.Date  招聘信息发布时间
     */
    @Column(name ="PUBLISH_TIME",nullable=true)
    public java.util.Date getPublishTime(){
        return this.publishTime;
    }

    /**
     *方法: 设置java.util.Date
     *@param: java.util.Date  招聘信息发布时间
     */
    public void setPublishTime(java.util.Date publishTime){
        this.publishTime = publishTime;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  福利待遇(新增)
     */
    @Column(name ="EMPLOYED_PERKS",nullable=true,length=255)
    public java.lang.String getEmployedPerks(){
        return this.employedPerks;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  福利待遇(新增)
     */
    public void setEmployedPerks(java.lang.String employedPerks){
        this.employedPerks = employedPerks;
    }
    /**
     *方法: 取得java.lang.Integer
     *@return: java.lang.Integer  投递人数(预留)
     */
    @Column(name ="POST_NUM",nullable=true,length=10)
    public java.lang.Integer getPostNum(){
        return this.postNum;
    }

    /**
     *方法: 设置java.lang.Integer
     *@param: java.lang.Integer  投递人数(预留)
     */
    public void setPostNum(java.lang.Integer postNum){
        this.postNum = postNum;
    }
    /**
     *方法: 取得java.util.Date
     *@return: java.util.Date  创建时间
     */
    @Column(name ="CREATE_TIME",nullable=true)
    public java.util.Date getCreateTime(){
        return this.createTime;
    }

    /**
     *方法: 设置java.util.Date
     *@param: java.util.Date  创建时间
     */
    public void setCreateTime(java.util.Date createTime){
        this.createTime = createTime;
    }
    /**
     *方法: 取得java.util.Date
     *@return: java.util.Date  更新时间
     */
    @Column(name ="UPDATE_TIME",nullable=true)
    public java.util.Date getUpdateTime(){
        return this.updateTime;
    }

    /**
     *方法: 设置java.util.Date
     *@param: java.util.Date  更新时间
     */
    public void setUpdateTime(java.util.Date updateTime){
        this.updateTime = updateTime;
    }
    /**
     *方法: 取得java.lang.Integer
     *@return: java.lang.Integer  删除标志
     */
    @Column(name ="IS_DELETE",nullable=true,length=3)
    public java.lang.Integer getIsDelete(){
        return this.isDelete;
    }

    /**
     *方法: 设置java.lang.Integer
     *@param: java.lang.Integer  删除标志
     */
    public void setIsDelete(java.lang.Integer isDelete){
        this.isDelete = isDelete;
    }
    @ManyToOne()
    @JoinColumn(name="USER_ID",insertable = false, updatable = false)
    public GeneralUserEntity getUserEntity() {
        return userEntity;
    }

    public void setUserEntity(GeneralUserEntity userEntity) {
        this.userEntity = userEntity;
    }

    /**
     *方法: 取得java.lang.Integer
     *@return: java.lang.Integer  招聘状态
     */
    @Column(name ="STATUS",nullable=true,length=10)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
