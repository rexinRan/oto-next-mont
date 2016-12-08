package com.buss.userdetail.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.member.entity.GeneralUserEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jweb.core.bean.annotation.Mapping;

/**   
 * @Title: Entity
 * @Description: dxs_user_detail
 * @author onlineGenerator
 * @date 2016-06-14 16:27:58
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_user_detail", schema = "")
@SuppressWarnings("serial")
public class UserDetailEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;

	/**用户id*/
	private java.lang.String userId;

	/**真实姓名*/
	private java.lang.String name;

	/**头像(预留)*/
	private java.lang.String headImg;
	/**性别*/
	private java.lang.String sex;
	/**身高(预留)*/
	private java.lang.String bodyHight;
	/**体重(预留)*/
	private java.lang.String bodyWeight;
	/**出生日期(预留)*/
	private java.lang.String borthday;
	/**户籍所在地(预留)*/
	private java.lang.String residence;
	/**通讯地址*/
	private java.lang.String postalAddress;
	/**手机号*/
	private java.lang.String phone;
	/**邮箱*/
	private java.lang.String email;
	/**邮编*/
	private java.lang.String zipCode;
	/**民族(预留)*/
	private java.lang.String preNative;
	/**身份证号*/
	private java.lang.String idcard;
	/**QQ*/
	private java.lang.String qq;
	/**MSN(预留)*/
	private java.lang.String msn;
	/**学校名称*/
	private java.lang.String schoolName;
	/**学校所在地*/
	private java.lang.String schoolAddress;
	/**入学时间(预留)*/
	private java.lang.String schoolAdmission;
	/**毕业时间(预留)*/
	private java.lang.String schoolGraduation;

	/**年级*/
	private java.lang.String schoolGrade;
	/**专业*/
	private java.lang.String schoolMajor;
	/**院系*/
	private java.lang.String schoolFaculty;
	/**部门科室*/
	private java.lang.String department;
	/**学历*/
	private java.lang.String schoolEducation;
	/**证书(预留)*/
	private java.lang.String schoolCertificate;

	/**爱好*/
	private java.lang.String hobby;

	/**任职院校*/
	private java.lang.String jobSchool;

	/**任职职位*/
	private java.lang.String jobSchoolPosition;

	/**备注*/
	private java.lang.String remarks;
	/**创建时间*/
	private java.util.Date createTime;
	/**更新时间*/
	private java.util.Date updateTime;
	/**删除标志*/
	private java.lang.Integer isDelete;

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
	 *@return: java.lang.String  用户
	 */
	@Column(name ="USERID",nullable=true,length=32)
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  真实姓名
	 */
	@Column(name ="NAME",nullable=true,length=100)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  真实姓名
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  头像(预留)
	 */
	@Column(name ="HEAD_IMG",nullable=true,length=200)
	public java.lang.String getHeadImg(){
		return this.headImg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  头像(预留)
	 */
	public void setHeadImg(java.lang.String headImg){
		this.headImg = headImg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */
	@Column(name ="SEX",nullable=true,length=10)
	public java.lang.String getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setSex(java.lang.String sex){
		this.sex = sex;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身高(预留)
	 */
	@Column(name ="BODY_HIGHT",nullable=true,length=20)
	public java.lang.String getBodyHight(){
		return this.bodyHight;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身高(预留)
	 */
	public void setBodyHight(java.lang.String bodyHight){
		this.bodyHight = bodyHight;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  体重(预留)
	 */
	@Column(name ="BODY_WEIGHT",nullable=true,length=20)
	public java.lang.String getBodyWeight(){
		return this.bodyWeight;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  体重(预留)
	 */
	public void setBodyWeight(java.lang.String bodyWeight){
		this.bodyWeight = bodyWeight;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出生日期(预留)
	 */
	@Column(name ="BORTHDAY",nullable=true,length=100)
	public java.lang.String getBorthday(){
		return this.borthday;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出生日期(预留)
	 */
	public void setBorthday(java.lang.String borthday){
		this.borthday = borthday;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户籍所在地(预留)
	 */
	@Column(name ="RESIDENCE",nullable=true,length=100)
	public java.lang.String getResidence(){
		return this.residence;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户籍所在地(预留)
	 */
	public void setResidence(java.lang.String residence){
		this.residence = residence;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  部门科室
	 */
	@Column(name ="DEPARTMENT",nullable=true,length=50)
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  通讯地址
	 */
	@Column(name ="POSTAL_ADDRESS",nullable=true,length=255)
	public String getPostalAddress() {
		return postalAddress;
	}

	public void setPostalAddress(String postalAddress) {
		this.postalAddress = postalAddress;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  手机号
	 */
	@Column(name ="PHONE",nullable=true,length=12)
	public java.lang.String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  手机号
	 */
	public void setPhone(java.lang.String phone){
		this.phone = phone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邮箱
	 */
	@Column(name ="EMAIL",nullable=true,length=50)
	public java.lang.String getEmail(){
		return this.email;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邮编
	 */
	public void setEmail(java.lang.String email){
		this.email = email;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邮编
	 */
	@Column(name ="ZIP_CODE",nullable=true,length=50)
	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  民族(预留)
	 */
	@Column(name ="PRE_NATIVE",nullable=true,length=20)
	public java.lang.String getPreNative(){
		return this.preNative;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  民族(预留)
	 */
	public void setPreNative(java.lang.String preNative){
		this.preNative = preNative;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号
	 */
	@Column(name ="IDCARD",nullable=true,length=19)
	public java.lang.String getIdcard(){
		return this.idcard;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号
	 */
	public void setIdcard(java.lang.String idcard){
		this.idcard = idcard;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  QQ
	 */
	@Column(name ="QQ",nullable=true,length=50)
	public java.lang.String getQq(){
		return this.qq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  QQ
	 */
	public void setQq(java.lang.String qq){
		this.qq = qq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  MSN(预留)
	 */
	@Column(name ="MSN",nullable=true,length=50)
	public java.lang.String getMsn(){
		return this.msn;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  MSN(预留)
	 */
	public void setMsn(java.lang.String msn){
		this.msn = msn;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学校名称
	 */
	@Column(name ="SCHOOL_NAME",nullable=true,length=100)
	public java.lang.String getSchoolName(){
		return this.schoolName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学校名称
	 */
	public void setSchoolName(java.lang.String schoolName){
		this.schoolName = schoolName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学校所在地
	 */
	@Column(name ="SCHOOL_ADDRESS",nullable=true,length=100)
	public java.lang.String getSchoolAddress(){
		return this.schoolAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学校所在地
	 */
	public void setSchoolAddress(java.lang.String schoolAddress){
		this.schoolAddress = schoolAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入学时间(预留)
	 */
	@Column(name ="SCHOOL_ADMISSION",nullable=true,length=50)
	public java.lang.String getSchoolAdmission(){
		return this.schoolAdmission;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入学时间(预留)
	 */
	public void setSchoolAdmission(java.lang.String schoolAdmission){
		this.schoolAdmission = schoolAdmission;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  毕业时间(预留)
	 */
	@Column(name ="SCHOOL_GRADUATION",nullable=true,length=50)
	public java.lang.String getSchoolGraduation(){
		return this.schoolGraduation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  毕业时间(预留)
	 */
	public void setSchoolGraduation(java.lang.String schoolGraduation){
		this.schoolGraduation = schoolGraduation;
	}

	/**年级*/
	@Column(name ="SCHOOL_GRADE",nullable=true,length=50)
	public String getSchoolGrade() {
		return schoolGrade;
	}

	public void setSchoolGrade(String schoolGrade) {
		this.schoolGrade = schoolGrade;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  专业
	 */
	@Column(name ="SCHOOL_MAJOR",nullable=true,length=50)
	public java.lang.String getSchoolMajor(){
		return this.schoolMajor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专业
	 */
	public void setSchoolMajor(java.lang.String schoolMajor){
		this.schoolMajor = schoolMajor;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  院系
	 */
	@Column(name ="SCHOOL_FACULTY",nullable=true,length=50)
	public String getSchoolFaculty() {
		return schoolFaculty;
	}

	public void setSchoolFaculty(String schoolFaculty) {
		this.schoolFaculty = schoolFaculty;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学历
	 */
	@Column(name ="SCHOOL_EDUCATION",nullable=true,length=10)
	public java.lang.String getSchoolEducation(){
		return this.schoolEducation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学历
	 */
	public void setSchoolEducation(java.lang.String schoolEducation){
		this.schoolEducation = schoolEducation;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  任职院校
	 */
	@Column(name ="JOB_SCHOOL",nullable=true,length=255)
	public java.lang.String getJobSchool(){
		return this.jobSchool;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  任职院校
	 */
	public void setJobSchool(java.lang.String jobSchool){
		this.jobSchool = jobSchool;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  任职职位
	 */
	@Column(name ="JOB_SCHOOL_POSITION",nullable=true,length=255)
	public java.lang.String getJobSchoolPosition(){
		return this.jobSchoolPosition;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  任职职位
	 */
	public void setJobSchoolPosition(java.lang.String jobSchoolPosition){
		this.jobSchoolPosition = jobSchoolPosition;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证书(预留)
	 */
	@Column(name ="SCHOOL_CERTIFICATE",nullable=true,length=255)
	public java.lang.String getSchoolCertificate(){
		return this.schoolCertificate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证书(预留)
	 */
	public void setSchoolCertificate(java.lang.String schoolCertificate){
		this.schoolCertificate = schoolCertificate;
	}

	/**
	 * 爱好
	 */
	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARKS",nullable=true,length=255)
	public java.lang.String getRemarks(){
		return this.remarks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemarks(java.lang.String remarks){
		this.remarks = remarks;
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


	// =====================================================================================================
	private GeneralUserEntity userEntity;
	// 用户
	@OneToOne
	@JoinColumn(name="userid", insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	public GeneralUserEntity getUserEntity() {
		return userEntity;
	}

	public void setUserEntity(GeneralUserEntity userEntity) {
		this.userEntity = userEntity;
	}
}
