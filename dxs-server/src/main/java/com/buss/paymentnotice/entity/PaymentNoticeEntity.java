package com.buss.paymentnotice.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * @Title: Entity
 * @Description: dxs_payment_notice
 * @author onlineGenerator
 * @date 2016-11-19 15:27:41
 * @version V1.0
 *
 */
@Entity
@Table(name = "dxs_payment_notice", schema = "")
@SuppressWarnings("serial")
public class PaymentNoticeEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**用户ID*/
	private java.lang.String userId;
	/**买家支付宝账户号*/
	private java.lang.String buyer_id;
	/**支付宝交易号*/
	private java.lang.String trade_no;
	/**商品描述*/
	private java.lang.String body;
	/**接口名称*/
	private java.lang.String exterface;
	/**通知时间*/
	private java.lang.String notify_time;
	/**商品名称*/
	private java.lang.String subject;
	/**签名方式*/
	private java.lang.String sign_type;
	/**通知类型*/
	private java.lang.String notify_type;
	/**商户网站唯一订单号*/
	private java.lang.String out_trade_no;
	/**交易状态*/
	private java.lang.String trade_status;
	/**签名*/
	private java.lang.String sign;
	/**买家支付宝账号*/
	private java.lang.String buyer_email;
	/**成功标识*/
	private java.lang.String is_success;
	/**交易金额*/
	private java.lang.String total_fee;
	/**卖家支付宝账户号*/
	private java.lang.String seller_id;
	/**通知校验ID*/
	private java.lang.String notify_id;
	/**卖家支付宝账号*/
	private java.lang.String seller_email;
	/**支付类型*/
	private java.lang.String payment_type;
	/**支付是否成功*/
	private java.lang.String whetherSuccessful;
	/**创建时间*/
	private java.util.Date createTime;
	/**更新时间*/
	private java.util.Date updateTime;
	/**是否删除*/
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
	 *@return: java.lang.String  买家支付宝账户号
	 */
	@Column(name ="BUYER_ID",nullable=true,length=50)
	public java.lang.String getBuyer_id(){
		return this.buyer_id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  买家支付宝账户号
	 */
	public void setBuyer_id(java.lang.String buyer_id){
		this.buyer_id = buyer_id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支付宝交易号
	 */
	@Column(name ="TRADE_NO",nullable=true,length=50)
	public java.lang.String getTrade_no(){
		return this.trade_no;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  支付宝交易号
	 */
	public void setTrade_no(java.lang.String trade_no){
		this.trade_no = trade_no;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品描述
	 */
	@Column(name ="BODY",nullable=true,length=50)
	public java.lang.String getBody(){
		return this.body;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品描述
	 */
	public void setBody(java.lang.String body){
		this.body = body;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  接口名称
	 */
	@Column(name ="EXTERFACE",nullable=true,length=50)
	public java.lang.String getExterface(){
		return this.exterface;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  接口名称
	 */
	public void setExterface(java.lang.String exterface){
		this.exterface = exterface;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  通知时间
	 */
	@Column(name ="NOTIFY_TIME",nullable=true,length=50)
	public java.lang.String getNotify_time(){
		return this.notify_time;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  通知时间
	 */
	public void setNotify_time(java.lang.String notify_time){
		this.notify_time = notify_time;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商品名称
	 */
	@Column(name ="SUBJECTS",nullable=true,length=50)
	public java.lang.String getSubject(){
		return this.subject;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商品名称
	 */
	public void setSubject(java.lang.String subject){
		this.subject = subject;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  签名方式
	 */
	@Column(name ="SIGN_TYPE",nullable=true,length=50)
	public java.lang.String getSign_type(){
		return this.sign_type;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  签名方式
	 */
	public void setSign_type(java.lang.String sign_type){
		this.sign_type = sign_type;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  通知类型
	 */
	@Column(name ="NOTIFY_TYPE",nullable=true,length=50)
	public java.lang.String getNotify_type(){
		return this.notify_type;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  通知类型
	 */
	public void setNotify_type(java.lang.String notify_type){
		this.notify_type = notify_type;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  商户网站唯一订单号
	 */
	@Column(name ="OUT_TRADE_NO",nullable=true,length=50)
	public java.lang.String getOut_trade_no(){
		return this.out_trade_no;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  商户网站唯一订单号
	 */
	public void setOut_trade_no(java.lang.String out_trade_no){
		this.out_trade_no = out_trade_no;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  交易状态
	 */
	@Column(name ="TRADE_STATUS",nullable=true,length=50)
	public java.lang.String getTrade_status(){
		return this.trade_status;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交易状态
	 */
	public void setTrade_status(java.lang.String trade_status){
		this.trade_status = trade_status;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  签名
	 */
	@Column(name ="SIGN",nullable=true,length=50)
	public java.lang.String getSign(){
		return this.sign;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  签名
	 */
	public void setSign(java.lang.String sign){
		this.sign = sign;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  买家支付宝账号
	 */
	@Column(name ="BUYER_EMAIL",nullable=true,length=50)
	public java.lang.String getBuyer_email(){
		return this.buyer_email;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  买家支付宝账号
	 */
	public void setBuyer_email(java.lang.String buyer_email){
		this.buyer_email = buyer_email;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  成功标识
	 */
	@Column(name ="IS_SUCCESS",nullable=true,length=50)
	public java.lang.String getIs_success(){
		return this.is_success;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  成功标识
	 */
	public void setIs_success(java.lang.String is_success){
		this.is_success = is_success;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  交易金额
	 */
	@Column(name ="TOTAL_FEE",nullable=true,length=50)
	public java.lang.String getTotal_fee(){
		return this.total_fee;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  交易金额
	 */
	public void setTotal_fee(java.lang.String total_fee){
		this.total_fee = total_fee;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  卖家支付宝账户号
	 */
	@Column(name ="SELLER_ID",nullable=true,length=100)
	public java.lang.String getSeller_id(){
		return this.seller_id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  卖家支付宝账户号
	 */
	public void setSeller_id(java.lang.String seller_id){
		this.seller_id = seller_id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  通知校验ID
	 */
	@Column(name ="NOTIFY_ID",nullable=true,length=100)
	public java.lang.String getNotify_id(){
		return this.notify_id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  通知校验ID
	 */
	public void setNotify_id(java.lang.String notify_id){
		this.notify_id = notify_id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  卖家支付宝账号
	 */
	@Column(name ="SELLER_EMAIL",nullable=true,length=50)
	public java.lang.String getSeller_email(){
		return this.seller_email;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  卖家支付宝账号
	 */
	public void setSeller_email(java.lang.String seller_email){
		this.seller_email = seller_email;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支付类型
	 */
	@Column(name ="PAYMENT_TYPE",nullable=true,length=50)
	public java.lang.String getPayment_type(){
		return this.payment_type;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  支付类型
	 */
	public void setPayment_type(java.lang.String payment_type){
		this.payment_type = payment_type;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支付是否成功
	 */
	@Column(name ="whether_successful",nullable=true,length=10)
	public String getWhetherSuccessful() {
		return whetherSuccessful;
	}

	public void setWhetherSuccessful(String whetherSuccessful) {
		this.whetherSuccessful = whetherSuccessful;
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
	 *@return: java.lang.Integer  是否删除
	 */
	@Column(name ="IS_DELETE",nullable=true,length=19)
	public java.lang.Integer getIsDelete(){
		return this.isDelete;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否删除
	 */
	public void setIsDelete(java.lang.Integer isDelete){
		this.isDelete = isDelete;
	}
}
