package com.buss.leadassessment.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import javax.xml.ws.Action;
import java.sql.Blob;

import com.buss.employmentrecord.entity.EmploymentRecordEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**   
 * @Title: Entity
 * @Description: dxs_lead_assessment
 * @author onlineGenerator
 * @date 2016-06-22 08:58:47
 * @version V1.0   
 *入职员工点评
 */
@Entity
@Table(name = "dxs_lead_assessment", schema = "")
@SuppressWarnings("serial")
public class LeadAssessmentEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**评价用户ID*/
	private java.lang.String fromUserId;

	/**我的职业动态ID*/
	private java.lang.String employmentRecordId;

	/**被评价用户id*/
	private java.lang.String toUserId;
	/**职位id*/
	private java.lang.String employedId;
	/**对企业的评价*/
	private java.lang.String leadAssessment;
	/**发布时间*/
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
	@Column(name ="ID",nullable=false,length=255)
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
	 *@return: java.lang.String  评价用户ID
	 */
	@Column(name ="FROM_USER_ID",nullable=true,length=32)
	public java.lang.String getFromUserId(){
		return this.fromUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  评价用户ID
	 */
	public void setFromUserId(java.lang.String fromUserId){
		this.fromUserId = fromUserId;
	}

	@Column(name ="EMPLOYMENT_RECORD_ID",nullable=true,length=32)
	public String getEmploymentRecordId() {
		return employmentRecordId;
	}

	public void setEmploymentRecordId(String employmentRecordId) {
		this.employmentRecordId = employmentRecordId;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  被评价用户id
	 */
	@Column(name ="TO_USER_ID",nullable=true,length=32)
	public java.lang.String getToUserId(){
		return this.toUserId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  被评价用户id
	 */
	public void setToUserId(java.lang.String toUserId){
		this.toUserId = toUserId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职位id
	 */
	@Column(name ="EMPLOYED_ID",nullable=true,length=32)
	public java.lang.String getEmployedId(){
		return this.employedId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职位id
	 */
	public void setEmployedId(java.lang.String employedId){
		this.employedId = employedId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  对企业的评价
	 */
	@Column(name ="LEAD_ASSESSMENT",nullable=true,length=255)
	public java.lang.String getLeadAssessment(){
		return this.leadAssessment;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  对企业的评价
	 */
	public void setLeadAssessment(java.lang.String leadAssessment){
		this.leadAssessment = leadAssessment;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发布时间
	 */
	@Column(name ="PUBLISH_TIME",nullable=true,length=255)
	public java.lang.String getPublishTime(){
		return this.publishTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发布时间
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

	// ====================================================================================
	private EmploymentRecordEntity employmentRecordEntity;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "employment_record_id", insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	public EmploymentRecordEntity getEmploymentRecordEntity() {
		return employmentRecordEntity;
	}

	public void setEmploymentRecordEntity(EmploymentRecordEntity employmentRecordEntity) {
		this.employmentRecordEntity = employmentRecordEntity;
	}
}
