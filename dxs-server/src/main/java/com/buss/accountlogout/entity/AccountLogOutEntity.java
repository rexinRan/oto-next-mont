package com.buss.accountlogout.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**   
 * @Title: Entity
 * @Description: dxs_account_log_out
 * @author onlineGenerator
 * @date 2016-09-22 10:30:07
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_account_log_out", schema = "")
@SuppressWarnings("serial")
public class AccountLogOutEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**账户id*/
	private java.lang.String accoutId;
	/**用户ID*/
	private java.lang.String userId;
	/**进账数目*/
	private java.lang.Integer accountIn;
	/**出账数目(预留)*/
	private java.lang.Integer accountOut;
	/**产品名称*/
	private java.lang.String productName;
	/**来源*/
	private java.lang.Integer accountFrom;
	/**账目进出id*/
	private java.lang.String accountFromId;
	/**流水状态*/
	private java.lang.Integer accountStatus;
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
	 *@return: java.lang.String  账户id
	 */
	@Column(name ="ACCOUT_ID",nullable=true,length=32)
	public java.lang.String getAccoutId(){
		return this.accoutId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  账户id
	 */
	public void setAccoutId(java.lang.String accoutId){
		this.accoutId = accoutId;
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
	 *@return: java.lang.String  进账数目
	 */
	@Column(name ="ACCOUNT_IN",nullable=true,length=255)
	public java.lang.Integer getAccountIn(){
		return this.accountIn;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  进账数目
	 */
	public void setAccountIn(java.lang.Integer accountIn){
		this.accountIn = accountIn;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出账数目(预留)
	 */
	@Column(name ="ACCOUNT_OUT",nullable=true,length=255)
	public java.lang.Integer getAccountOut(){
		return this.accountOut;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出账数目(预留)
	 */
	public void setAccountOut(java.lang.Integer accountOut){
		this.accountOut = accountOut;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  来源
	 */
	@Column(name ="ACCOUNT_FROM",nullable=true,length=10)
	public java.lang.Integer getAccountFrom(){
		return this.accountFrom;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  来源
	 */
	public void setAccountFrom(java.lang.Integer accountFrom){
		this.accountFrom = accountFrom;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  账目进出id
	 */
	@Column(name ="ACCOUNT_FROM_ID",nullable=true,length=32)
	public java.lang.String getAccountFromId(){
		return this.accountFromId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  账目进出id
	 */
	public void setAccountFromId(java.lang.String accountFromId){
		this.accountFromId = accountFromId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  流水状态
	 */
	@Column(name ="ACCOUNT_STATUS",nullable=true,length=10)
	public java.lang.Integer getAccountStatus(){
		return this.accountStatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  流水状态
	 */
	public void setAccountStatus(java.lang.Integer accountStatus){
		this.accountStatus = accountStatus;
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
	 *@return: java.lang.Integer  产品名称
	 */
	@Column(name ="PRODUCT_NAME",nullable=true,length=50)
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  产品名称
	 */
	@Column(name ="REMARKS",nullable=true,length=255)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
