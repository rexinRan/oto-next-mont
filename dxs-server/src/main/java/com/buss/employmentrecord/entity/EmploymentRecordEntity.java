package com.buss.employmentrecord.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.soap.Text;
import java.sql.Blob;
import java.util.HashSet;
import java.util.Set;

import com.buss.leadassessment.entity.LeadAssessmentEntity;
import com.buss.member.entity.GeneralUserEntity;
import org.hibernate.annotations.*;

/**   
 * @Title: Entity
 * @Description: dxs_employment_record
 * @author onlineGenerator
 * @date 2016-06-22 08:55:32
 * @version V1.0   
 * 我的职业动态
 */
@Entity
@Table(name = "dxs_employment_record", schema = "")
@SuppressWarnings("serial")
public class EmploymentRecordEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**企业ID*/
	private java.lang.String companyUserId;
	/**职工ID*/
	private java.lang.String workUserId;
	/**入职员工点评Id*/
//	private java.lang.String leadAssessmentId;
	/**公司名称*/
	private java.lang.String companyNmae;
	/**职位*/
	private java.lang.String position;
	/**开始工作*/
	private java.lang.String workStart;
	/**结束工作*/
	private java.lang.String workEnd;
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
	 *@return: java.lang.String  企业ID
	 */
	@Column(name ="COMPANY_USER_ID",nullable=true,length=32)
	public java.lang.String getCompanyUserId(){
		return this.companyUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  企业ID
	 */
	public void setCompanyUserId(java.lang.String companyUserId){
		this.companyUserId = companyUserId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  职工ID
	 */


	@Column(name ="WORK_USER_ID",nullable=true,length=32)

	public java.lang.String getWorkUserId(){
		return this.workUserId;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  职工ID
	 */
	public void setWorkUserId(java.lang.String workUserId){
		this.workUserId = workUserId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入职员工点评Id
	 */
//	@Column(name ="LEAD_ASSESSMENT_ID",nullable=true,length=32)
//	public java.lang.String getLeadAssessmentId(){
//		return this.leadAssessmentId;
//	}
//
//	/**
//	 *方法: 设置java.lang.String
//	 *@param: java.lang.String  入职员工点评Id
//	 */
//	public void setLeadAssessmentId(java.lang.String leadAssessmentId){
//		this.leadAssessmentId = leadAssessmentId;
//	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司名称
	 */
	@Column(name ="COMPANY_NMAE",nullable=true,length=100)
	public java.lang.String getCompanyNmae(){
		return this.companyNmae;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司名称
	 */
	public void setCompanyNmae(java.lang.String companyNmae){
		this.companyNmae = companyNmae;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职位
	 */
	@Column(name ="POSITION",nullable=true,length=50)
	public java.lang.String getPosition(){
		return this.position;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职位
	 */
	public void setPosition(java.lang.String position){
		this.position = position;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开始工作
	 */
	@Column(name ="WORK_START",nullable=true,length=50)
	public java.lang.String getWorkStart(){
		return this.workStart;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开始工作
	 */
	public void setWorkStart(java.lang.String workStart){
		this.workStart = workStart;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结束工作
	 */
	@Column(name ="WORK_END",nullable=true,length=50)
	public java.lang.String getWorkEnd(){
		return this.workEnd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结束工作
	 */
	public void setWorkEnd(java.lang.String workEnd){
		this.workEnd = workEnd;
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


	// =========================================关联关系映射配置===============================================


	// 用户
	private GeneralUserEntity generalUserEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "work_user_id", insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	public GeneralUserEntity getGeneralUserEntity() {
		return generalUserEntity;
	}

	public void setGeneralUserEntity(GeneralUserEntity generalUserEntity) {
		this.generalUserEntity = generalUserEntity;
	}

	// 入职员工点评
	/*private LeadAssessmentVo leadAssessmentEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lead_assessment_id", insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	public LeadAssessmentVo getLeadAssessmentEntity() {
		return leadAssessmentEntity;
	}

	public void setLeadAssessmentEntity(LeadAssessmentVo leadAssessmentEntity) {
		this.leadAssessmentEntity = leadAssessmentEntity;
	}*/

	private Set<LeadAssessmentEntity> leadAssessmentEntities;

	@OneToMany(mappedBy="employmentRecordEntity")
	@LazyCollection(LazyCollectionOption.EXTRA)
	public Set<LeadAssessmentEntity> getLeadAssessmentEntities() {
		return leadAssessmentEntities;
	}
	public void setLeadAssessmentEntities(Set<LeadAssessmentEntity> leadAssessmentEntities) {
		this.leadAssessmentEntities = leadAssessmentEntities;
	}
}
