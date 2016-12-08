package com.buss.orders.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import org.jweb.core.bean.annotation.Mapping;

/**   
 * @Title: Entity
 * @Description: dxs_orders
 * @author onlineGenerator
 * @date 2016-09-18 14:14:28
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_orders", schema = "")
@SuppressWarnings("serial")
public class OrdersEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**用户id*/
	private java.lang.String userId;
	/**订单编号*/
	private java.lang.String orderNum;
	/**支付方式*/
	private java.lang.String modePayment;
	/**订单电话*/
	private java.lang.String phone;
	/**商品数量*/
	private java.lang.String regNum;
	/**订单金额*/
	private java.lang.String orderAll;
	/**订货日期*/
	private java.util.Date orderTime;
	/**发票号码*/
	private java.lang.String invoiceNum;
	/**鸿鑫豆数量*/
	private java.lang.Integer hongxinNum;
	/**订单状态*/
	private java.lang.Integer orderStatus;
	/**配送日期*/
	private java.util.Date sendTime;
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
	 *@return: java.lang.String  用户id
	 */
	@Column(name ="PHONE",nullable=true,length=50)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  订单编号
	 */
	@Column(name ="ORDER_NUM",nullable=true,length=50)
	public java.lang.String getOrderNum(){
		return this.orderNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订单编号
	 */
	public void setOrderNum(java.lang.String orderNum){
		this.orderNum = orderNum;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支付方式
	 */
	@Column(name ="MODE_PAYMENT",nullable=true,length=10)
	public String getModePayment() {
		return modePayment;
	}

	public void setModePayment(String modePayment) {
		this.modePayment = modePayment;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  注册号
	 */
	@Column(name ="REG_NUM",nullable=true,length=50)
	public java.lang.String getRegNum(){
		return this.regNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  注册号
	 */
	public void setRegNum(java.lang.String regNum){
		this.regNum = regNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  订单金额
	 */
	@Column(name ="ORDER_ALL",nullable=true,length=10)
	public java.lang.String getOrderAll(){
		return this.orderAll;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订单金额
	 */
	public void setOrderAll(java.lang.String orderAll){
		this.orderAll = orderAll;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  订货日期
	 */
	@Column(name ="ORDER_TIME",nullable=true)
	public java.util.Date getOrderTime(){
		return this.orderTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  订货日期
	 */
	public void setOrderTime(java.util.Date orderTime){
		this.orderTime = orderTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发票号码
	 */
	@Column(name ="INVOICE_NUM",nullable=true,length=50)
	public java.lang.String getInvoiceNum(){
		return this.invoiceNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发票号码
	 */
	public void setInvoiceNum(java.lang.String invoiceNum){
		this.invoiceNum = invoiceNum;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  鸿鑫豆数量
	 */
	@Column(name ="HONGXIN_NUM",nullable=true,length=10)
	public java.lang.Integer getHongxinNum(){
		return this.hongxinNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  鸿鑫豆数量
	 */
	public void setHongxinNum(java.lang.Integer hongxinNum){
		this.hongxinNum = hongxinNum;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  订单状态
	 */
	@Column(name ="ORDER_STATUS",nullable=true,length=3)
	public java.lang.Integer getOrderStatus(){
		return this.orderStatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  订单状态
	 */
	public void setOrderStatus(java.lang.Integer orderStatus){
		this.orderStatus = orderStatus;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  配送日期
	 */
	@Column(name ="SEND_TIME",nullable=true)
	public java.util.Date getSendTime(){
		return this.sendTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  配送日期
	 */
	public void setSendTime(java.util.Date sendTime){
		this.sendTime = sendTime;
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
}
