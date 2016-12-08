package com.buss.activescustom.entity;

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

/**   
 * @Title: Entity
 * @Description: dxs_actives_custom
 * @author onlineGenerator
 * @date 2016-08-01 11:56:36
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_actives_custom", schema = "")
@SuppressWarnings("serial")
public class ActivesCustomEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**用户id*/
	private java.lang.String userId;
	/**课程id*/
	private java.lang.String customizedId;
	/**国家id*/
	private java.lang.String customCountryId;
	/**选修课ID*/
	private java.lang.String customCoursesId;
	/**住宿方式*/
	private java.lang.String customModeId;
	/**课程时长*/
	private java.lang.String customDurationId;
	/**签证方式id*/
	private java.lang.String customVisaId;
	/**setouttime*/
	private java.util.Date setouttime;
	/**紧急联系人*/
	private java.lang.String contacts1;
	/**紧急联系电话*/
	private java.lang.String phone1;
	/**紧急联系人2*/
	private java.lang.String contacts2;
	/**紧急联系电话2*/
	private java.lang.String phone2;
	/**是否缴费*/
	private java.lang.Integer result;
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
	 *@return: java.lang.String  用户id
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public java.lang.String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户id
	 */
	public void setUserId(java.lang.String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  课程id
	 */
	@Column(name ="CUSTOMIZED_ID",nullable=true,length=32)
	public java.lang.String getCustomizedId(){
		return this.customizedId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课程id
	 */
	public void setCustomizedId(java.lang.String customizedId){
		this.customizedId = customizedId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  国家id
	 */
	@Column(name ="CUSTOM_COUNTRY_ID",nullable=true,length=32)
	public java.lang.String getCustomCountryId(){
		return this.customCountryId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  国家id
	 */
	public void setCustomCountryId(java.lang.String customCountryId){
		this.customCountryId = customCountryId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  选修课ID
	 */
	@Column(name ="CUSTOM_COURSES_ID",nullable=true,length=32)
	public java.lang.String getCustomCoursesId(){
		return this.customCoursesId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  选修课ID
	 */
	public void setCustomCoursesId(java.lang.String customCoursesId){
		this.customCoursesId = customCoursesId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  住宿方式
	 */
	@Column(name ="CUSTOM_MODE_ID",nullable=true,length=32)
	public java.lang.String getCustomModeId(){
		return this.customModeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  住宿方式
	 */
	public void setCustomModeId(java.lang.String customModeId){
		this.customModeId = customModeId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  课程时长
	 */
	@Column(name ="CUSTOM_DURATION_ID",nullable=true,length=32)
	public java.lang.String getCustomDurationId(){
		return this.customDurationId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课程时长
	 */
	public void setCustomDurationId(java.lang.String customDurationId){
		this.customDurationId = customDurationId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  签证方式id
	 */
	@Column(name ="CUSTOM_VISA_ID",nullable=true,length=32)
	public java.lang.String getCustomVisaId(){
		return this.customVisaId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  签证方式id
	 */
	public void setCustomVisaId(java.lang.String customVisaId){
		this.customVisaId = customVisaId;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  setouttime
	 */
	@Column(name ="SETOUTTIME",nullable=true)
	public java.util.Date getSetouttime(){
		return this.setouttime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  setouttime
	 */
	public void setSetouttime(java.util.Date setouttime){
		this.setouttime = setouttime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  紧急联系人
	 */
	@Column(name ="CONTACTS1",nullable=true,length=200)
	public java.lang.String getContacts1(){
		return this.contacts1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  紧急联系人
	 */
	public void setContacts1(java.lang.String contacts1){
		this.contacts1 = contacts1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  紧急联系电话
	 */
	@Column(name ="PHONE1",nullable=true,length=20)
	public java.lang.String getPhone1(){
		return this.phone1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  紧急联系电话
	 */
	public void setPhone1(java.lang.String phone1){
		this.phone1 = phone1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  紧急联系人2
	 */
	@Column(name ="CONTACTS2",nullable=true,length=200)
	public java.lang.String getContacts2(){
		return this.contacts2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  紧急联系人2
	 */
	public void setContacts2(java.lang.String contacts2){
		this.contacts2 = contacts2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  紧急联系电话2
	 */
	@Column(name ="PHONE2",nullable=true,length=20)
	public java.lang.String getPhone2(){
		return this.phone2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  紧急联系电话2
	 */
	public void setPhone2(java.lang.String phone2){
		this.phone2 = phone2;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否缴费
	 */
	@Column(name ="RESULT",nullable=true,length=10)
	public java.lang.Integer getResult(){
		return this.result;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否缴费
	 */
	public void setResult(java.lang.Integer result){
		this.result = result;
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
	@Column(name ="IS_DELETE",nullable=true,length=10)
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
}
