package com.buss.orderitems.entity;

import javax.persistence.*;

import com.buss.orders.entity.OrdersEntity;
import com.buss.trainonlinecourse.entity.TrainOnlineCourseEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.hibernate.internal.CriteriaImpl;


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
public class OrderItemsEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**用户id*/
	private java.lang.String userId;
	/**订单ID*/
	private java.lang.String orderId;
	/**订单编号*/
	private java.lang.String orderNum;
	/**外键*/
	private java.lang.String outId;
	/**外部分类*/
	private java.lang.String outCatalog;
	/**产品名称*/
	private java.lang.String productName;
	/**备注*/
	private java.lang.String remarks;
	/**商品单价*/
	private java.lang.String price;
	/**折后价*/
	private java.lang.String priceShort;
	/**商品数量*/
	private java.lang.Integer num;
	/**订货日期*/
	private java.util.Date orderTime;
	/**创建时间*/
	private java.util.Date createTime;
	/**更新时间*/
	private java.util.Date updateTime;
	/**删除标志*/
	private java.lang.Integer isDelete;

	private OrdersEntity ordersEntity;

	private TrainOnlineCourseEntity onlineCourseEntity;

	@OneToOne()
	@JoinColumn(name="ORDER_ID",insertable = false, updatable = false)
	public OrdersEntity getOrdersEntity() {
		return ordersEntity;
	}

	public void setOrdersEntity(OrdersEntity ordersEntity) {
		this.ordersEntity = ordersEntity;
	}

	@OneToOne()
	@JoinColumn(name="OUT_ID",insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	public TrainOnlineCourseEntity getOnlineCourseEntity() {
		return onlineCourseEntity;
	}

	public void setOnlineCourseEntity(TrainOnlineCourseEntity onlineCourseEntity) {
		this.onlineCourseEntity = onlineCourseEntity;
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
	 *@return: java.lang.String  外键
	 */
	@Column(name ="OUT_ID",nullable=true,length=32)
	public java.lang.String getOutId(){
		return this.outId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  外键
	 */
	public void setOutId(java.lang.String outId){
		this.outId = outId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  外部分类
	 */
	@Column(name ="OUT_CATALOG",nullable=true,length=50)
	public java.lang.String getOutCatalog(){
		return this.outCatalog;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  外部分类
	 */
	public void setOutCatalog(java.lang.String outCatalog){
		this.outCatalog = outCatalog;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品名称
	 */
	@Column(name ="PRODUCT_NAME",nullable=true,length=255)
	public java.lang.String getProductName(){
		return this.productName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品名称
	 */
	public void setProductName(java.lang.String productName){
		this.productName = productName;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品单价
	 */
	@Column(name ="PRICE",nullable=true,length=10)
	public java.lang.String getPrice(){
		return this.price;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品单价
	 */
	public void setPrice(java.lang.String price){
		this.price = price;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  折后价
	 */
	@Column(name ="PRICE_SHORT",nullable=true,length=10)
	public java.lang.String getPriceShort(){
		return this.priceShort;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  折后价
	 */
	public void setPriceShort(java.lang.String priceShort){
		this.priceShort = priceShort;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  商品数量
	 */
	@Column(name ="NUM",nullable=true,length=10)
	public java.lang.Integer getNum(){
		return this.num;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  商品数量
	 */
	public void setNum(java.lang.Integer num){
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
