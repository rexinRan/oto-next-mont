package com.buss.orderitems.entity;

import com.buss.orders.entity.OrdersEntity;
import com.buss.trainonlinecourse.entity.TrainOnlineCourseEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;


/**   
 * @Title: Entity
 * @Description: dxs_order_items
 * @author onlineGenerator
 * @date 2016-09-18 14:19:09
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_order_items", schema = "")
@SuppressWarnings("serial")
public class OrderItemsEntitys implements java.io.Serializable {
	/**主键*/
	private String id;
	/**用户id*/
	private String userId;
	/**订单ID*/
	private String orderId;
	/**订单编号*/
	private String orderNum;
	/**外键*/
	private String outId;
	/**外部分类*/
	private String outCatalog;
	/**产品名称*/
	private String productName;
	/**备注*/
	private String remarks;
	// 是否是支付定金(1:全款  5:定金)
	private java.lang.Integer paymentAttribute;
	/**商品单价*/
	private String price;
	/**折后价*/
	private String priceShort;
	/**商品数量*/
	private Integer num;
	/**订货日期*/
	private java.util.Date orderTime;
	/**创建时间*/
	private java.util.Date createTime;
	/**更新时间*/
	private java.util.Date updateTime;
	/**删除标志*/
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
	@Column(name ="USER_ID",nullable=true,length=32)
	public String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户id
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户id
	 */
	@Column(name ="ORDER_ID",nullable=true,length=32)
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  订单编号
	 */
	@Column(name ="ORDER_NUM",nullable=true,length=50)
	public String getOrderNum(){
		return this.orderNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订单编号
	 */
	public void setOrderNum(String orderNum){
		this.orderNum = orderNum;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否是定金支付
	 */
	@Column(name ="PAYMENT_ATTRIBUTE",nullable=true,length=5)
	public Integer getPaymentAttribute() {
		return paymentAttribute;
	}

	public void setPaymentAttribute(Integer paymentAttribute) {
		this.paymentAttribute = paymentAttribute;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  外键
	 */
	@Column(name ="OUT_ID",nullable=true,length=32)
	public String getOutId(){
		return this.outId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  外键
	 */
	public void setOutId(String outId){
		this.outId = outId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  外部分类
	 */
	@Column(name ="OUT_CATALOG",nullable=true,length=50)
	public String getOutCatalog(){
		return this.outCatalog;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  外部分类
	 */
	public void setOutCatalog(String outCatalog){
		this.outCatalog = outCatalog;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品名称
	 */
	@Column(name ="PRODUCT_NAME",nullable=true,length=255)
	public String getProductName(){
		return this.productName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品名称
	 */
	public void setProductName(String productName){
		this.productName = productName;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品单价
	 */
	@Column(name ="PRICE",nullable=true,length=100)
	public String getPrice(){
		return this.price;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品单价
	 */
	public void setPrice(String price){
		this.price = price;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  折后价
	 */
	@Column(name ="PRICE_SHORT",nullable=true,length=50)
	public String getPriceShort(){
		return this.priceShort;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  折后价
	 */
	public void setPriceShort(String priceShort){
		this.priceShort = priceShort;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  商品数量
	 */
	@Column(name ="NUM",nullable=true,length=10)
	public Integer getNum(){
		return this.num;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  商品数量
	 */
	public void setNum(Integer num){
		this.num = num;
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
