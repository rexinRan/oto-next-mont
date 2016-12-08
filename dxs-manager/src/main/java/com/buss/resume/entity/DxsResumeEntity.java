package com.buss.resume.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_resume
 * @author onlineGenerator
 * @date 2016-06-01 11:30:53
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_resume", schema = "")
@SuppressWarnings("serial")
public class DxsResumeEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**用户id*/
	@Excel(name="用户id")
	private String userid;
	/**姓名*/
	@Excel(name="姓名")
	private String name;
	/**头像*/
	@Excel(name="头像")
	private java.lang.String headImg;
	/**是否让好职位来找我*/
	@Excel(name="是否让好职位来找我")
	private java.lang.Integer isPublic;
	/**性别*/
	@Excel(name="性别")
	private String sex;
	/**身高*/
	@Excel(name="身高")
	private java.lang.String bodyHight;
	/**体重*/
	@Excel(name="体重")
	private java.lang.String bodyWeight;
	/**出生日期*/
	@Excel(name="出生日期")
	private String borthday;
	/**户籍所在地*/
	@Excel(name="户籍所在地")
	private String residence;
	/**工作经验*/
	@Excel(name="工作经验")
	private java.lang.String workExperience;
	/**手机号*/
	@Excel(name="手机号")
	private String phone;
	/**邮箱*/
	@Excel(name="邮箱")
	private String email;
	/**民族*/
	@Excel(name="民族")
	private java.lang.String preNative;
	/**身份证号*/
	@Excel(name="身份证号")
	private String idcard;
	/**QQ*/
	@Excel(name="QQ")
	private java.lang.String qq;
	/**MSN*/
	@Excel(name="MSN")
	private java.lang.String msn;
	/**求职状态*/
	@Excel(name="求职状态")
	private java.lang.String jobStatus;
	/**期望地点*/
	@Excel(name="期望地点")
	private java.lang.String targetAddress;
	/**职位类别*/
	@Excel(name="职位类别")
	private java.lang.String targetJobType;
	/**求职岗位*/
	@Excel(name="求职岗位")
	private java.lang.String targetJob;
	/**求职类型*/
	@Excel(name="求职类型")
	private java.lang.String jobType;
	/**学校名称*/
	@Excel(name="学校名称")
	private String schoolName;
	/**学校地址*/
	@Excel(name="学校地址")
	private String schoolAddress;
	/**入学时间*/
	@Excel(name="入学时间")
	private String schoolAdmission;
	/**毕业时间*/
	@Excel(name="毕业时间")
	private String schoolGraduation;
	/**专业*/
	@Excel(name="专业")
	private String schoolMajor;
	/**学历*/
	@Excel(name="学历")
	private String schoolEducation;
	/**证书*/
	@Excel(name="证书")
	private String schoolCertificate;
	/**专业技能*/
	@Excel(name="专业技能")
	private String professional;
	/**兴趣爱好*/
	@Excel(name="兴趣爱好")
	private java.lang.String hobby;
	/**自我评价*/
	@Excel(name="自我评价")
	private String selfAssessment;
	/**简历附件*/
	@Excel(name="简历附件")
	private String accessories;
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
	 *@return: java.lang.String  姓名
	 */
	@Column(name ="NAME",nullable=true,length=100)
	public String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  头像
	 */
	@Column(name ="HEAD_IMG",nullable=true,length=200)
	public java.lang.String getHeadImg(){
		return this.headImg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  头像
	 */
	public void setHeadImg(java.lang.String headImg){
		this.headImg = headImg;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否让好职位来找我
	 */
	@Column(name ="IS_PUBLIC",nullable=true,length=3)
	public java.lang.Integer getIsPublic(){
		return this.isPublic;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否让好职位来找我
	 */
	public void setIsPublic(java.lang.Integer isPublic){
		this.isPublic = isPublic;
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
	 *@return: java.lang.String  身高
	 */
	@Column(name ="BODY_HIGHT",nullable=true,length=20)
	public java.lang.String getBodyHight(){
		return this.bodyHight;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身高
	 */
	public void setBodyHight(java.lang.String bodyHight){
		this.bodyHight = bodyHight;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  体重
	 */
	@Column(name ="BODY_WEIGHT",nullable=true,length=20)
	public java.lang.String getBodyWeight(){
		return this.bodyWeight;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  体重
	 */
	public void setBodyWeight(java.lang.String bodyWeight){
		this.bodyWeight = bodyWeight;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出生日期
	 */
	@Column(name ="BORTHDAY",nullable=true,length=100)
	public String getBorthday(){
		return this.borthday;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出生日期
	 */
	public void setBorthday(String borthday){
		this.borthday = borthday;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户籍所在地
	 */
	@Column(name ="RESIDENCE",nullable=true,length=100)
	public String getResidence(){
		return this.residence;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户籍所在地
	 */
	public void setResidence(String residence){
		this.residence = residence;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工作经验
	 */
	@Column(name ="WORK_EXPERIENCE",nullable=true,length=50)
	public java.lang.String getWorkExperience(){
		return this.workExperience;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工作经验
	 */
	public void setWorkExperience(java.lang.String workExperience){
		this.workExperience = workExperience;
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
	 *@return: java.lang.String  民族
	 */
	@Column(name ="PRE_NATIVE",nullable=true,length=20)
	public java.lang.String getPreNative(){
		return this.preNative;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  民族
	 */
	public void setPreNative(java.lang.String preNative){
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
	 *@return: java.lang.String  MSN
	 */
	@Column(name ="MSN",nullable=true,length=50)
	public java.lang.String getMsn(){
		return this.msn;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  MSN
	 */
	public void setMsn(java.lang.String msn){
		this.msn = msn;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  求职状态
	 */
	@Column(name ="JOB_STATUS",nullable=true,length=3)
	public java.lang.String getJobStatus(){
		return this.jobStatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  求职状态
	 */
	public void setJobStatus(java.lang.String jobStatus){
		this.jobStatus = jobStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  期望地点
	 */
	@Column(name ="TARGET_ADDRESS",nullable=true,length=255)
	public java.lang.String getTargetAddress(){
		return this.targetAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  期望地点
	 */
	public void setTargetAddress(java.lang.String targetAddress){
		this.targetAddress = targetAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职位类别
	 */
	@Column(name ="TARGET_JOB_TYPE",nullable=true,length=255)
	public java.lang.String getTargetJobType(){
		return this.targetJobType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职位类别
	 */
	public void setTargetJobType(java.lang.String targetJobType){
		this.targetJobType = targetJobType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  求职岗位
	 */
	@Column(name ="TARGET_JOB",nullable=true,length=100)
	public java.lang.String getTargetJob(){
		return this.targetJob;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  求职岗位
	 */
	public void setTargetJob(java.lang.String targetJob){
		this.targetJob = targetJob;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  求职类型
	 */
	@Column(name ="JOB_TYPE",nullable=true,length=100)
	public java.lang.String getJobType(){
		return this.jobType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  求职类型
	 */
	public void setJobType(java.lang.String jobType){
		this.jobType = jobType;
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
	 *@return: java.lang.String  学校地址
	 */
	@Column(name ="SCHOOL_ADDRESS",nullable=true,length=100)
	public String getSchoolAddress(){
		return this.schoolAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学校地址
	 */
	public void setSchoolAddress(String schoolAddress){
		this.schoolAddress = schoolAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入学时间
	 */
	@Column(name ="SCHOOL_ADMISSION",nullable=true,length=50)
	public String getSchoolAdmission(){
		return this.schoolAdmission;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入学时间
	 */
	public void setSchoolAdmission(String schoolAdmission){
		this.schoolAdmission = schoolAdmission;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  毕业时间
	 */
	@Column(name ="SCHOOL_GRADUATION",nullable=true,length=50)
	public String getSchoolGraduation(){
		return this.schoolGraduation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  毕业时间
	 */
	public void setSchoolGraduation(String schoolGraduation){
		this.schoolGraduation = schoolGraduation;
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
	 *@return: java.lang.String  证书
	 */
	@Column(name ="SCHOOL_CERTIFICATE",nullable=true,length=255)
	public String getSchoolCertificate(){
		return this.schoolCertificate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证书
	 */
	public void setSchoolCertificate(String schoolCertificate){
		this.schoolCertificate = schoolCertificate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  专业技能
	 */
	@Column(name ="PROFESSIONAL",nullable=true,length=255)
	public String getProfessional(){
		return this.professional;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专业技能
	 */
	public void setProfessional(String professional){
		this.professional = professional;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  兴趣爱好
	 */
	@Column(name ="HOBBY",nullable=true,length=16777215)
	public java.lang.String getHobby(){
		return this.hobby;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  兴趣爱好
	 */
	public void setHobby(java.lang.String hobby){
		this.hobby = hobby;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  自我评价
	 */
	@Column(name ="SELF_ASSESSMENT",nullable=true,length=255)
	public String getSelfAssessment(){
		return this.selfAssessment;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  自我评价
	 */
	public void setSelfAssessment(String selfAssessment){
		this.selfAssessment = selfAssessment;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  简历附件
	 */
	@Column(name ="ACCESSORIES",nullable=true,length=255)
	public String getAccessories(){
		return this.accessories;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  简历附件
	 */
	public void setAccessories(String accessories){
		this.accessories = accessories;
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

}
