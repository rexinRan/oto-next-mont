package com.buss.invoiceorders.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.common.entity.DxsUserDetailEntity;
import com.buss.invoices.entity.DxsInvoicesEntity;
import com.buss.orders.entity.DxsOrdersEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_invoice_orders
 * @author onlineGenerator
 * @date 2016-09-29 10:19:10
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_invoice_orders", schema = "")
@SuppressWarnings("serial")
public class DxsInvoiceOrdersEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**发票信息id*/
	@Excel(name="发票信息id")
	private String invoiceId;
	/**用户id*/
	@Excel(name="用户id")
	private String userId;
	/**订单id*/
	@Excel(name="订单id")
	private String orderId;
	/**发票金额*/
	@Excel(name="发票金额")
	private String invoiceValue;
	/**发票标号*/
	@Excel(name="发票标号")
	private String invoiceLabels;
	/**申请时间*/
	@Excel(name="申请时间",format = "yyyy-MM-dd")
	private Date applyTime;
	/**发票状态*/
	@Excel(name="发票状态")
	private Integer invoiceStatus;
	/**收件人*/
	@Excel(name="收件人")
	private String recipient;
	/**收取地址*/
	@Excel(name="收取地址")
	private String recipientAddress;
	/**邮编*/
	@Excel(name="邮编")
	private String postNum;
	/**联系电话*/
	@Excel(name="联系电话")
	private String phone;
	/**物流公司*/
	@Excel(name="物流公司")
	private String logisticsCompany;
	/**快递编号*/
	@Excel(name="快递编号")
	private String expressNumber;
	/**开票订单号*/
	@Excel(name="开票订单号")
	private String invoiceOrderNum;
	/**产品名称*/
	@Excel(name="产品名称")
	private String productName;
	/**收取方式*/
	@Excel(name="收取方式")
	private String collectionType;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private Date createTime;
	/**更新时间*/
	@Excel(name="更新时间",format = "yyyy-MM-dd")
	private Date updateTime;
	/**删除标志*/
	@Excel(name="删除标志")
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
	 *@return: java.lang.String  发票信息id
	 */
	@Column(name ="INVOICE_ID",nullable=false,length=32)
	public String getInvoiceId(){
		return this.invoiceId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发票信息id
	 */
	public void setInvoiceId(String invoiceId){
		this.invoiceId = invoiceId;
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
	 *@return: java.lang.String  订单id
	 */
	@Column(name ="ORDER_ID",nullable=true,length=32)
	public String getOrderId(){
		return this.orderId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订单id
	 */
	public void setOrderId(String orderId){
		this.orderId = orderId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发票金额
	 */
	@Column(name ="INVOICE_VALUE",nullable=true,length=20)
	public String getInvoiceValue(){
		return this.invoiceValue;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发票金额
	 */
	public void setInvoiceValue(String invoiceValue){
		this.invoiceValue = invoiceValue;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发票标号
	 */
	@Column(name ="INVOICE_LABELS",nullable=true,length=100)
	public String getInvoiceLabels(){
		return this.invoiceLabels;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发票标号
	 */
	public void setInvoiceLabels(String invoiceLabels){
		this.invoiceLabels = invoiceLabels;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  申请时间
	 */
	@Column(name ="APPLY_TIME",nullable=true)
	public Date getApplyTime(){
		return this.applyTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  申请时间
	 */
	public void setApplyTime(Date applyTime){
		this.applyTime = applyTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  发票状态
	 */
	@Column(name ="INVOICE_STATUS",nullable=true,length=3)
	public Integer getInvoiceStatus(){
		return this.invoiceStatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  发票状态
	 */
	public void setInvoiceStatus(Integer invoiceStatus){
		this.invoiceStatus = invoiceStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收件人
	 */
	@Column(name ="RECIPIENT",nullable=true,length=50)
	public String getRecipient(){
		return this.recipient;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收件人
	 */
	public void setRecipient(String recipient){
		this.recipient = recipient;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  收取地址
	 */
	@Column(name ="RECIPIENT_ADDRESS",nullable=true,length=255)
	public String getRecipientAddress(){
		return this.recipientAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收取地址
	 */
	public void setRecipientAddress(String recipientAddress){
		this.recipientAddress = recipientAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  邮编
	 */
	@Column(name ="POST_NUM",nullable=true,length=20)
	public String getPostNum(){
		return this.postNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  邮编
	 */
	public void setPostNum(String postNum){
		this.postNum = postNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */
	@Column(name ="PHONE",nullable=true,length=20)
	public String getPhone(){
		return this.phone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setPhone(String phone){
		this.phone = phone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  物流公司
	 */
	@Column(name ="LOGISTICS_COMPANY",nullable=true,length=30)
	public String getLogisticsCompany(){
		return this.logisticsCompany;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  物流公司
	 */
	public void setLogisticsCompany(String logisticsCompany){
		this.logisticsCompany = logisticsCompany;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  快递编号
	 */
	@Column(name ="EXPRESS_NUMBER",nullable=true,length=30)
	public String getExpressNumber(){
		return this.expressNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  快递编号
	 */
	public void setExpressNumber(String expressNumber){
		this.expressNumber = expressNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开票订单号
	 */
	@Column(name ="INVOICE_ORDER_NUM",nullable=true,length=50)
	public String getInvoiceOrderNum(){
		return this.invoiceOrderNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开票订单号
	 */
	public void setInvoiceOrderNum(String invoiceOrderNum){
		this.invoiceOrderNum = invoiceOrderNum;
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
	 *@return: java.lang.String  收取方式
	 */
	@Column(name ="COLLECTION_TYPE",nullable=true,length=255)
	public String getCollectionType(){
		return this.collectionType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  收取方式
	 */
	public void setCollectionType(String collectionType){
		this.collectionType = collectionType;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATE_TIME",nullable=true)
	public Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新时间
	 */
	@Column(name ="UPDATE_TIME",nullable=true)
	public Date getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新时间
	 */
	public void setUpdateTime(Date updateTime){
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

	/**
	 *@author dq
	 *添加表dxs_userdetail多对一bean
	 */
	private DxsUserDetailEntity dxsUserDetailEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)

	public DxsUserDetailEntity getDxsUserDetailEntity() {
		return dxsUserDetailEntity;
	}

	public void setDxsUserDetailEntity(DxsUserDetailEntity dxsUserDetailEntity) {
		this.dxsUserDetailEntity = dxsUserDetailEntity;
	}

	/**
	 *@author dq
	 *添加表dxs_invoice多对一bean
	 */
	private DxsInvoicesEntity dxsInvoicesEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "invoice_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)

	public DxsInvoicesEntity getDxsInvoicesEntity() {
		return dxsInvoicesEntity;
	}

	public void setDxsInvoicesEntity(DxsInvoicesEntity dxsInvoicesEntity) {
		this.dxsInvoicesEntity = dxsInvoicesEntity;
	}

	/**
	 *@author dq
	 *添加表dxs_orders多对一bean
	 */
	private DxsOrdersEntity dxsOrdersEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)

	public DxsOrdersEntity getDxsOrdersEntity() {
		return dxsOrdersEntity;
	}

	public void setDxsOrdersEntity(DxsOrdersEntity dxsOrdersEntity) {
		this.dxsOrdersEntity = dxsOrdersEntity;
	}
}
