package com.buss.resumeuser.entity;

import javax.persistence.*;

import com.buss.employed.entity.EmployedEntity;
import com.buss.member.entity.GeneralUserEntity;
import com.buss.resume.resume.entity.ResumeEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**   
 * @Title: Entity
 * @Description: dxs_resume_user
 * @author onlineGenerator
 * @date 2016-06-20 15:53:26
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_resume_user", schema = "")
@SuppressWarnings("serial")
public class ResumeUserEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**用户ID*/
	private java.lang.String userId;
	/**投递人*/
	private java.lang.String userName;
	/**简历的id*/
	private java.lang.String resumeId;
	/**职位id*/
	private java.lang.String emoloyedId;
	/**投递时间*/
	private java.util.Date sendTime;
	/**结果*/
	private java.lang.Integer result;
	/**投递类型*/
	private java.lang.Integer rtype;
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
	 *@return: java.lang.String  用户ID
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public java.lang.String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户ID
	 */
	public void setUserId(java.lang.String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  投递人
	 */
	@Column(name ="USER_NAME",nullable=true,length=100)
	public java.lang.String getUserName(){
		return this.userName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  投递人
	 */
	public void setUserName(java.lang.String userName){
		this.userName = userName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  简历的id
	 */
	@Column(name ="RESUME_ID",nullable=true,length=32)
	public java.lang.String getResumeId(){
		return this.resumeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  简历的id
	 */
	public void setResumeId(java.lang.String resumeId){
		this.resumeId = resumeId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职位id
	 */
	@Column(name ="EMOLOYED_ID",nullable=true,length=32)
	public java.lang.String getEmoloyedId(){
		return this.emoloyedId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职位id
	 */
	public void setEmoloyedId(java.lang.String emoloyedId){
		this.emoloyedId = emoloyedId;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  投递时间
	 */
	@Column(name ="SEND_TIME",nullable=true)
	public java.util.Date getSendTime(){
		return this.sendTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  投递时间
	 */
	public void setSendTime(java.util.Date sendTime){
		this.sendTime = sendTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结果
	 */
	@Column(name ="RESULT",nullable=true,length=3)
	public java.lang.Integer getResult(){
		return this.result;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结果
	 */
	public void setResult(java.lang.Integer result){
		this.result = result;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  投递类型
	 */
	@Column(name ="RTYPE",nullable=true,length=3)
	public java.lang.Integer getRtype(){
		return this.rtype;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  投递类型
	 */
	public void setRtype(java.lang.Integer rtype){
		this.rtype = rtype;
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


	// 简历
	private ResumeEntity resumeEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "resume_id", insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	public ResumeEntity getResumeEntity() {
		return resumeEntity;
	}

	public void setResumeEntity(ResumeEntity resumeEntity) {
		this.resumeEntity = resumeEntity;
	}

	// 职位
	private EmployedEntity employedEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emoloyed_id", insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	public EmployedEntity getEmployedEntity() {
		return employedEntity;
	}

	public void setEmployedEntity(EmployedEntity employedEntity) {
		this.employedEntity = employedEntity;
	}
}
