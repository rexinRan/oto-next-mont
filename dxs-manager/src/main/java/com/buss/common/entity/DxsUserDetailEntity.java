package com.buss.common.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.user.entity.DxsUserEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity 学生教师的共用信息实体
 * @Description: dxs_user_detail
 * @author onlineGenerator
 * @date 2016-06-17 14:29:33
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_user_detail", schema = "")
@SuppressWarnings("serial")
public class DxsUserDetailEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**用户id*/
	@Excel(name="用户id")
	private String userid;
	/**真实姓名*/
	@Excel(name="真实姓名")
	private String name;
	/**头像(预留)*/
	@Excel(name="头像(预留)")
	private String headImg;
	/**性别*/
	@Excel(name="性别")
	private String sex;
	/**身高(预留)*/
	@Excel(name="身高(预留)")
	private String bodyHight;
	/**体重(预留)*/
	@Excel(name="体重(预留)")
	private String bodyWeight;
	/**出生日期(预留)*/
	@Excel(name="出生日期(预留)")
	private String borthday;
	/**通讯地址*/
	@Excel(name="通讯地址")
	private java.lang.String postalAddress;
	/**户籍所在地(预留)*/
	@Excel(name="户籍所在地(预留)")
	private String residence;
	/**手机号*/
	@Excel(name="手机号")
	private String phone;
	/**邮编*/
	@Excel(name="邮编")
	private java.lang.String zipCode;
	/**邮箱*/
	@Excel(name="邮箱")
	private String email;
	/**民族(预留)*/
	@Excel(name="民族(预留)")
	private String preNative;
	/**身份证号*/
	@Excel(name="身份证号")
	private String idcard;
	/**QQ*/
	@Excel(name="QQ")
	private String qq;
	/**MSN(预留)*/
	@Excel(name="MSN(预留)")
	private String msn;
	/**学校名称*/
	@Excel(name="学校名称")
	private String schoolName;
	/**学校所在地*/
	@Excel(name="学校所在地")
	private String schoolAddress;
	/**入学时间(预留)*/
	@Excel(name="入学时间(预留)")
	private String schoolAdmission;
	/**毕业时间(预留)*/
	@Excel(name="毕业时间(预留)")
	private String schoolGraduation;
	/**年级*/
	@Excel(name="年级")
	private java.lang.String schoolGrade;
	/**院系*/
	@Excel(name="院系")
	private java.lang.String schoolFaculty;
	/**专业*/
	@Excel(name="专业")
	private String schoolMajor;
	/**学历*/
	@Excel(name="学历")
	private String schoolEducation;
	/**证书(预留)*/
	@Excel(name="证书(预留)")
	private String schoolCertificate;
	/**任职院校*/
	@Excel(name="任职院校")
	private java.lang.String jobSchool;
	/**任职职位*/
	@Excel(name="任职职位")
	private java.lang.String jobSchoolPosition;
	/**专业履历*/
	@Excel(name="专业履历")
	private java.lang.String jobSchoolResume;
	/**个人爱好*/
	@Excel(name="个人爱好")
	private java.lang.String hobby;
	/**备注*/
	@Excel(name="备注")
	private String remarks;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private Date createTime;
	/**更新时间*/
	@Excel(name="更新时间",format = "yyyy-MM-dd")
	private Date updateTime;
	/**删除标志*/
	@Excel(name="删除标志")
	private Integer isDelete;

	// 王腾云
	private DxsUserEntity dxsUserEntity;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=32)
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户id
	 */
	@Column(name ="USERID",nullable=true,length=32)
	public String getUserid(){
		return this.userid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户id
	 */
	public void setUserid(String userid){
		this.userid = userid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  真实姓名
	 */
	@Column(name ="NAME",nullable=true,length=100)
	public String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  真实姓名
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  头像(预留)
	 */
	@Column(name ="HEAD_IMG",nullable=true,length=200)
	public String getHeadImg(){
		return this.headImg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  头像(预留)
	 */
	public void setHeadImg(String headImg){
		this.headImg = headImg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  性别
	 */
	@Column(name ="SEX",nullable=true,length=10)
	public String getSex(){
		return this.sex;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  性别
	 */
	public void setSex(String sex){
		this.sex = sex;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身高(预留)
	 */
	@Column(name ="BODY_HIGHT",nullable=true,length=20)
	public String getBodyHight(){
		return this.bodyHight;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身高(预留)
	 */
	public void setBodyHight(String bodyHight){
		this.bodyHight = bodyHight;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  体重(预留)
	 */
	@Column(name ="BODY_WEIGHT",nullable=true,length=20)
	public String getBodyWeight(){
		return this.bodyWeight;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  体重(预留)
	 */
	public void setBodyWeight(String bodyWeight){
		this.bodyWeight = bodyWeight;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出生日期(预留)
	 */
	@Column(name ="BORTHDAY",nullable=true,length=100)
	public String getBorthday(){
		return this.borthday;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出生日期(预留)
	 */
	public void setBorthday(String borthday){
		this.borthday = borthday;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  通讯地址
	 */
	@Column(name ="POSTAL_ADDRESS",nullable=true,length=255)
	public java.lang.String getPostalAddress(){
		return this.postalAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  通讯地址
	 */
	public void setPostalAddress(java.lang.String postalAddress){
		this.postalAddress = postalAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户籍所在地(预留)
	 */
	@Column(name ="RESIDENCE",nullable=true,length=100)
	public String getResidence(){
		return this.residence;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户籍所在地(预留)
	 */
	public void setResidence(String residence){
		this.residence = residence;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  手机号
	 */
	@Column(name ="PHONE",nullable=true,length=12)
	public String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  手机号
	 */
	public void setPhone(String phone){
		this.phone = phone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邮编
	 */
	@Column(name ="ZIP_CODE",nullable=true,length=50)
	public java.lang.String getZipCode(){
		return this.zipCode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邮编
	 */
	public void setZipCode(java.lang.String zipCode){
		this.zipCode = zipCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邮箱
	 */
	@Column(name ="EMAIL",nullable=true,length=50)
	public String getEmail(){
		return this.email;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邮箱
	 */
	public void setEmail(String email){
		this.email = email;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  民族(预留)
	 */
	@Column(name ="PRE_NATIVE",nullable=true,length=20)
	public String getPreNative(){
		return this.preNative;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  民族(预留)
	 */
	public void setPreNative(String preNative){
		this.preNative = preNative;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号
	 */
	@Column(name ="IDCARD",nullable=true,length=19)
	public String getIdcard(){
		return this.idcard;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号
	 */
	public void setIdcard(String idcard){
		this.idcard = idcard;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  QQ
	 */
	@Column(name ="QQ",nullable=true,length=50)
	public String getQq(){
		return this.qq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  QQ
	 */
	public void setQq(String qq){
		this.qq = qq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  MSN(预留)
	 */
	@Column(name ="MSN",nullable=true,length=50)
	public String getMsn(){
		return this.msn;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  MSN(预留)
	 */
	public void setMsn(String msn){
		this.msn = msn;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学校名称
	 */
	@Column(name ="SCHOOL_NAME",nullable=true,length=100)
	public String getSchoolName(){
		return this.schoolName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学校名称
	 */
	public void setSchoolName(String schoolName){
		this.schoolName = schoolName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学校所在地
	 */
	@Column(name ="SCHOOL_ADDRESS",nullable=true,length=100)
	public String getSchoolAddress(){
		return this.schoolAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学校所在地
	 */
	public void setSchoolAddress(String schoolAddress){
		this.schoolAddress = schoolAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入学时间(预留)
	 */
	@Column(name ="SCHOOL_ADMISSION",nullable=true,length=50)
	public String getSchoolAdmission(){
		return this.schoolAdmission;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入学时间(预留)
	 */
	public void setSchoolAdmission(String schoolAdmission){
		this.schoolAdmission = schoolAdmission;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  毕业时间(预留)
	 */
	@Column(name ="SCHOOL_GRADUATION",nullable=true,length=50)
	public String getSchoolGraduation(){
		return this.schoolGraduation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  毕业时间(预留)
	 */
	public void setSchoolGraduation(String schoolGraduation){
		this.schoolGraduation = schoolGraduation;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  年级
	 */
	@Column(name ="SCHOOL_GRADE",nullable=true,length=50)
	public java.lang.String getSchoolGrade(){
		return this.schoolGrade;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  年级
	 */
	public void setSchoolGrade(java.lang.String schoolGrade){
		this.schoolGrade = schoolGrade;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  院系
	 */
	@Column(name ="SCHOOL_FACULTY",nullable=true,length=50)
	public java.lang.String getSchoolFaculty(){
		return this.schoolFaculty;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  院系
	 */
	public void setSchoolFaculty(java.lang.String schoolFaculty){
		this.schoolFaculty = schoolFaculty;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  专业
	 */
	@Column(name ="SCHOOL_MAJOR",nullable=true,length=50)
	public String getSchoolMajor(){
		return this.schoolMajor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专业
	 */
	public void setSchoolMajor(String schoolMajor){
		this.schoolMajor = schoolMajor;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学历
	 */
	@Column(name ="SCHOOL_EDUCATION",nullable=true,length=10)
	public String getSchoolEducation(){
		return this.schoolEducation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学历
	 */
	public void setSchoolEducation(String schoolEducation){
		this.schoolEducation = schoolEducation;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  证书(预留)
	 */
	@Column(name ="SCHOOL_CERTIFICATE",nullable=true,length=255)
	public String getSchoolCertificate(){
		return this.schoolCertificate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证书(预留)
	 */
	public void setSchoolCertificate(String schoolCertificate){
		this.schoolCertificate = schoolCertificate;
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
	 *@return: java.lang.String  专业履历
	 */
	@Column(name ="JOB_SCHOOL_RESUME",nullable=true,length=16777215)
	public java.lang.String getJobSchoolResume(){
		return this.jobSchoolResume;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专业履历
	 */
	public void setJobSchoolResume(java.lang.String jobSchoolResume){
		this.jobSchoolResume = jobSchoolResume;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  个人爱好
	 */
	@Column(name ="HOBBY",nullable=true,length=255)
	public java.lang.String getHobby(){
		return this.hobby;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  个人爱好
	 */
	public void setHobby(java.lang.String hobby){
		this.hobby = hobby;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARKS",nullable=true,length=255)
	public String getRemarks(){
		return this.remarks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemarks(String remarks){
		this.remarks = remarks;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATE_TIME",nullable=true)
	public Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新时间
	 */
	@Column(name ="UPDATE_TIME",nullable=true)
	public Date getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新时间
	 */
	public void setUpdateTime(Date updateTime){
		this.updateTime = updateTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  删除标志
	 */
	@Column(name ="IS_DELETE",nullable=true,length=3)
	public Integer getIsDelete(){
		return this.isDelete;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  删除标志
	 */
	public void setIsDelete(Integer isDelete){
		this.isDelete = isDelete;
	}

	@OneToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "USERID", insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	public DxsUserEntity getDxsUserEntity() {
		return dxsUserEntity;
	}

	public void setDxsUserEntity(DxsUserEntity dxsUserEntity) {
		this.dxsUserEntity = dxsUserEntity;
	}
}
