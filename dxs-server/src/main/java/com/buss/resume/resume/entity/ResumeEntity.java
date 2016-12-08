package com.buss.resume.resume.entity;

import com.buss.resume.resumetemplate.entity.ResumeTemplateEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @Title: Entity
 * @Description: dxs_resume
 * @author onlineGenerator
 * @date 2016-08-22 13:28:46
 * @version V1.0
 *
 */
@Entity
@Table(name = "dxs_resume", schema = "")
@SuppressWarnings("serial")
public class ResumeEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**用户id*/

	private java.lang.String userid;
	/**简历id*/

	private java.lang.String rtId;
	/**姓名*/

	private java.lang.String name;
	/**头像*/

	private java.lang.String headImg;
	/**性别*/

	private java.lang.String sex;
	/**身高*/

	private java.lang.String bodyHight;
	/**体重*/

	private java.lang.String bodyWeight;
	/**出生日期*/

	private java.lang.String borthday;
	/**户籍所在地*/

	private java.lang.String residence;
	/**工作经验*/

	private java.lang.String workExperience;
	/**手机号*/

	private java.lang.String phone;
	/**邮箱*/

	private java.lang.String email;
	/**民族*/

	private java.lang.String preNative;
	/**身份证号*/

	private java.lang.String idcard;
	/**QQ*/

	private java.lang.String qq;
	/**MSN*/

	private java.lang.String msn;
	/**求职状态*/

	private java.lang.String jobStatus;
	/**期望地点*/

	private java.lang.String targetAddress;
	/**职位类别*/

	private java.lang.String targetJobType;
	/**求职岗位(期望职位)*/

	private java.lang.String targetJob;
	/**求职类型(职位类型)*/

	private java.lang.String jobType;
	/**学校名称*/

	private java.lang.String schoolName;
	/**学校地址*/

	private java.lang.String schoolAddress;
	/**入学时间*/

	private java.lang.String schoolAdmission;
	/**毕业时间*/

	private java.lang.String schoolGraduation;
	/**专业*/

	private java.lang.String schoolMajor;
	/**学历*/

	private java.lang.String schoolEducation;
	/**证书*/

	private java.lang.String schoolCertificate;
	/**专业技能*/

	private java.lang.String professional;
	/**兴趣爱好*/

	private java.lang.String hobby;
	/**自我评价(其他信息)*/
	private java.lang.String selfAssessment;
	/**简历附件*/

	private java.lang.String accessories;
	/**备注*/

	private java.lang.String remarks;
	/**创建时间*/

	private java.util.Date createTime;
	/**更新时间*/

	private java.util.Date updateTime;
	/**删除标志*/

	private java.lang.Integer isDelete;
	/**是否公开*/

	private java.lang.Integer isPublic;
	/**简历模板*/
	private ResumeTemplateEntity resumeTemplate;

	@OneToOne()
	@JoinColumn(name="RT_ID",insertable = false, updatable = false)
	public ResumeTemplateEntity getResumeTemplate() {
		return resumeTemplate;
	}

	public void setResumeTemplate(ResumeTemplateEntity resumeTemplate) {
		this.resumeTemplate = resumeTemplate;
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
	 *@return: java.lang.String  用户id
	 */
	@Column(name ="USERID",nullable=true,length=32)
	public java.lang.String getUserid(){
		return this.userid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户id
	 */
	public void setUserid(java.lang.String userid){
		this.userid = userid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  简历id
	 */
	@Column(name ="RT_ID",nullable=true,length=32)
	public java.lang.String getRtId(){
		return this.rtId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  简历id
	 */
	public void setRtId(java.lang.String rtId){
		this.rtId = rtId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  姓名
	 */
	@Column(name ="NAME",nullable=true,length=100)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setName(java.lang.String name){
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
	public java.lang.String getBorthday(){
		return this.borthday;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出生日期
	 */
	public void setBorthday(java.lang.String borthday){
		this.borthday = borthday;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  户籍所在地
	 */
	@Column(name ="RESIDENCE",nullable=true,length=100)
	public java.lang.String getResidence(){
		return this.residence;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  户籍所在地
	 */
	public void setResidence(java.lang.String residence){
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
	 *@param: java.lang.String  邮箱
	 */
	public void setEmail(java.lang.String email){
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
	@Column(name ="JOB_STATUS",nullable=true,length=50)
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
	 *@return: java.lang.String  求职岗位(期望职位)
	 */
	@Column(name ="TARGET_JOB",nullable=true,length=100)
	public java.lang.String getTargetJob(){
		return this.targetJob;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  求职岗位(期望职位)
	 */
	public void setTargetJob(java.lang.String targetJob){
		this.targetJob = targetJob;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  求职类型(职位类型)
	 */
	@Column(name ="JOB_TYPE",nullable=true,length=100)
	public java.lang.String getJobType(){
		return this.jobType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  求职类型(职位类型)
	 */
	public void setJobType(java.lang.String jobType){
		this.jobType = jobType;
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
	 *@return: java.lang.String  学校地址
	 */
	@Column(name ="SCHOOL_ADDRESS",nullable=true,length=100)
	public java.lang.String getSchoolAddress(){
		return this.schoolAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学校地址
	 */
	public void setSchoolAddress(java.lang.String schoolAddress){
		this.schoolAddress = schoolAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入学时间
	 */
	@Column(name ="SCHOOL_ADMISSION",nullable=true,length=50)
	public java.lang.String getSchoolAdmission(){
		return this.schoolAdmission;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入学时间
	 */
	public void setSchoolAdmission(java.lang.String schoolAdmission){
		this.schoolAdmission = schoolAdmission;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  毕业时间
	 */
	@Column(name ="SCHOOL_GRADUATION",nullable=true,length=50)
	public java.lang.String getSchoolGraduation(){
		return this.schoolGraduation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  毕业时间
	 */
	public void setSchoolGraduation(java.lang.String schoolGraduation){
		this.schoolGraduation = schoolGraduation;
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
	 *@return: java.lang.String  证书
	 */
	@Column(name ="SCHOOL_CERTIFICATE",nullable=true,length=255)
	public java.lang.String getSchoolCertificate(){
		return this.schoolCertificate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  证书
	 */
	public void setSchoolCertificate(java.lang.String schoolCertificate){
		this.schoolCertificate = schoolCertificate;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  专业技能
	 */
	@Column(name ="PROFESSIONAL",nullable=true,length=255)
	public java.lang.String getProfessional(){
		return this.professional;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专业技能
	 */
	public void setProfessional(java.lang.String professional){
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
	 *@return: java.lang.String  自我评价(其他信息)
	 */
	@Column(name ="SELF_ASSESSMENT",nullable=true,length=255)
	public java.lang.String getSelfAssessment(){
		return this.selfAssessment;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  自我评价(其他信息)
	 */
	public void setSelfAssessment(java.lang.String selfAssessment){
		this.selfAssessment = selfAssessment;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  简历附件
	 */
	@Column(name ="ACCESSORIES",nullable=true,length=255)
	public java.lang.String getAccessories(){
		return this.accessories;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  简历附件
	 */
	public void setAccessories(java.lang.String accessories){
		this.accessories = accessories;
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
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否公开
	 */
	@Column(name ="IS_PUBLIC",nullable=true,length=2)
	public java.lang.Integer getIsPublic(){
		return this.isPublic;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否公开
	 */
	public void setIsPublic(java.lang.Integer isPublic){
		this.isPublic = isPublic;
	}
}
