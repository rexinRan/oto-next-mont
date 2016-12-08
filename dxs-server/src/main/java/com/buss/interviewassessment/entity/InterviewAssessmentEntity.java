package com.buss.interviewassessment.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.interview.entity.InterviewEntity;
import com.buss.member.entity.GeneralUserEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**   
 * @Title: Entity
 * @Description: dxs_interview_ assessment
 * @author onlineGenerator
 * @date 2016-06-25 09:21:56
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_interview_assessment", schema = "")
@SuppressWarnings("serial")
public class InterviewAssessmentEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**用户的id*/
	private java.lang.String userId;
	/**面试邀请的id*/
	private java.lang.String interviewId;
	/**公司环境*/
	private java.lang.Integer corporateEnvironment;
	/**员工氛围*/
	private java.lang.Integer employeeAtmosphere;
	/**面试情况*/
	private java.lang.Integer interviewerLevel;
	/**评论内容*/
	private java.lang.String assessmentContent;
	/**评价时间*/
	private java.lang.String publishTime;
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
	 *@return: java.lang.String  用户的id
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public java.lang.String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户的id
	 */
	public void setUserId(java.lang.String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  面试邀请的id
	 */
	@Column(name ="INTERVIEW_ID",nullable=true,length=32)
	public java.lang.String getInterviewId(){
		return this.interviewId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  面试邀请的id
	 */
	public void setInterviewId(java.lang.String interviewId){
		this.interviewId = interviewId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  公司环境
	 */
	@Column(name ="CORPORATE_ENVIRONMENT",nullable=true,length=10)
	public java.lang.Integer getCorporateEnvironment(){
		return this.corporateEnvironment;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  公司环境
	 */
	public void setCorporateEnvironment(java.lang.Integer corporateEnvironment){
		this.corporateEnvironment = corporateEnvironment;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  员工氛围
	 */
	@Column(name ="EMPLOYEE_ATMOSPHERE",nullable=true,length=10)
	public java.lang.Integer getEmployeeAtmosphere(){
		return this.employeeAtmosphere;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  员工氛围
	 */
	public void setEmployeeAtmosphere(java.lang.Integer employeeAtmosphere){
		this.employeeAtmosphere = employeeAtmosphere;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  面试情况
	 */
	@Column(name ="INTERVIEWER_LEVEL",nullable=true,length=10)
	public java.lang.Integer getInterviewerLevel(){
		return this.interviewerLevel;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  面试情况
	 */
	public void setInterviewerLevel(java.lang.Integer interviewerLevel){
		this.interviewerLevel = interviewerLevel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  评论内容
	 */
	@Column(name ="ASSESSMENT_CONTENT",nullable=true,length=255)
	public java.lang.String getAssessmentContent(){
		return this.assessmentContent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  评论内容
	 */
	public void setAssessmentContent(java.lang.String assessmentContent){
		this.assessmentContent = assessmentContent;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  评价时间
	 */
	@Column(name ="PUBLISH_TIME",nullable=true,length=255)
	public java.lang.String getPublishTime(){
		return this.publishTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  评价时间
	 */
	public void setPublishTime(java.lang.String publishTime){
		this.publishTime = publishTime;
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


	//====================================================关系映射==============================
	// 用户
	private GeneralUserEntity generalUserEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	public GeneralUserEntity getGeneralUserEntity() {
		return generalUserEntity;
	}

	public void setGeneralUserEntity(GeneralUserEntity generalUserEntity) {
		this.generalUserEntity = generalUserEntity;
	}

	// 面试
	private InterviewEntity interviewEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "INTERVIEW_ID", insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	public InterviewEntity getInterviewEntity() {
		return interviewEntity;
	}

	public void setInterviewEntity(InterviewEntity interviewEntity) {
		this.interviewEntity = interviewEntity;
	}
}
