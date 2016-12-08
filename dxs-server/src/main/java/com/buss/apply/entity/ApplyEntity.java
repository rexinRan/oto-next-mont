package com.buss.apply.entity;

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
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

/**   
 * @Title: Entity
 * @Description: apply
 * @author onlineGenerator
 * @date 2016-06-20 10:13:38
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_apply", schema = "")
@SuppressWarnings("serial")
public class ApplyEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**用户ID*/
	private java.lang.String userId;
	/**	奖学/助学外键 */
	private java.lang.String awardMoneyId;
	/**审核码*/
	private java.lang.String checkcode;
	/**奖学金级别*/
	private java.lang.String textType;
	/**申请时间*/
	private java.util.Date applicationTime;
	/**申请类型*/
	private java.lang.String applyType;
	/**创建时间*/
	private java.util.Date createTime;
	/**更新时间*/
	private java.util.Date updateTime;
	/**删除标志*/
	private java.lang.Integer isDelete;

	// 杨治国
	private GeneralUserEntity generalUserEntity;

	
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

	@Column(name ="Award_Money_Id",nullable=true,length=32)
	public String getAwardMoneyId() {
		return awardMoneyId;
	}

	public void setAwardMoneyId(String awardMoneyId) {
		this.awardMoneyId = awardMoneyId;
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
	 *@return: java.lang.String  审核码
	 */
	@Column(name ="CHECKCODE",nullable=true,length=10)
	public java.lang.String getCheckcode(){
		return this.checkcode;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  审核码
	 */
	public void setCheckcode(java.lang.String checkcode){
		this.checkcode = checkcode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申请类型
	 */
	@Column(name ="APPLY_TYPE",nullable=true,length=2)
	public java.lang.String getApplyType(){
		return this.applyType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请类型
	 */
	public void setApplyType(java.lang.String applyType){
		this.applyType = applyType;
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

	/**文本类型*/
	@Column(name ="TEXT_TYPE",nullable=true,length=25)
	public String getTextType() {
		return textType;
	}

	public void setTextType(String textType) {
		this.textType = textType;
	}



/**申请时间application_time*/
	/**申请时间*/

	@Column(name ="APPLICATION_TIME",nullable=true)
	public Date getApplicationTime() {
		return applicationTime;
	}

	public void setApplicationTime(Date applicationTime) {
		this.applicationTime = applicationTime;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	public GeneralUserEntity getGeneralUserEntity() {
		return generalUserEntity;
	}

	public void setGeneralUserEntity(GeneralUserEntity generalUserEntity) {
		this.generalUserEntity = generalUserEntity;
	}
}
