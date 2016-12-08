package com.buss.orders.entity;

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
import com.buss.user.entity.DxsUserEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

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
public class DxsOrdersEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**用户id*/
	@Excel(name="用户id")
	private String userId;
	/**订单编号*/
	@Excel(name="订单编号")
	private String orderNum;
	/**注册号*/
	@Excel(name="注册号")
	private String regNum;
	/**订单金额*/
	@Excel(name="订单金额")
	private String orderAll;
	/**订货日期*/
	@Excel(name="订货日期",format = "yyyy-MM-dd")
	private Date orderTime;
	/**发票号码*/
	@Excel(name="发票号码")
	private String invoiceNum;
	/**鸿鑫豆数量*/
	@Excel(name="鸿鑫豆数量")
	private Integer hongxinNum;
	/**订单状态*/
	@Excel(name="订单状态")
	private Integer orderStatus;
	/**配送日期*/
	@Excel(name="配送日期",format = "yyyy-MM-dd")
	private Date sendTime;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private Date createTime;
	/**更新时间*/
	@Excel(name="更新时间",format = "yyyy-MM-dd")
	private Date updateTime;
	/**删除标志*/
	@Excel(name="删除标志")
	private Integer isDelete;

	private DxsUserDetailEntity dxsUserDetailEntity;
	
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
	 *@return: java.lang.String  注册号
	 */
	@Column(name ="REG_NUM",nullable=true,length=50)
	public String getRegNum(){
		return this.regNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  注册号
	 */
	public void setRegNum(String regNum){
		this.regNum = regNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  订单金额
	 */
	@Column(name ="ORDER_ALL",nullable=true,length=10)
	public String getOrderAll(){
		return this.orderAll;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  订单金额
	 */
	public void setOrderAll(String orderAll){
		this.orderAll = orderAll;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  订货日期
	 */
	@Column(name ="ORDER_TIME",nullable=true)
	public Date getOrderTime(){
		return this.orderTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  订货日期
	 */
	public void setOrderTime(Date orderTime){
		this.orderTime = orderTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发票号码
	 */
	@Column(name ="INVOICE_NUM",nullable=true,length=50)
	public String getInvoiceNum(){
		return this.invoiceNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发票号码
	 */
	public void setInvoiceNum(String invoiceNum){
		this.invoiceNum = invoiceNum;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  鸿鑫豆数量
	 */
	@Column(name ="HONGXIN_NUM",nullable=true,length=10)
	public Integer getHongxinNum(){
		return this.hongxinNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  鸿鑫豆数量
	 */
	public void setHongxinNum(Integer hongxinNum){
		this.hongxinNum = hongxinNum;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  订单状态
	 */
	@Column(name ="ORDER_STATUS",nullable=true,length=3)
	public Integer getOrderStatus(){
		return this.orderStatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  订单状态
	 */
	public void setOrderStatus(Integer orderStatus){
		this.orderStatus = orderStatus;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  配送日期
	 */
	@Column(name ="SEND_TIME",nullable=true)
	public Date getSendTime(){
		return this.sendTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  配送日期
	 */
	public void setSendTime(Date sendTime){
		this.sendTime = sendTime;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)

	public DxsUserDetailEntity getDxsUserDetailEntity() {
		return dxsUserDetailEntity;
	}

	public void setDxsUserDetailEntity(DxsUserDetailEntity dxsUserDetailEntity) {
		this.dxsUserDetailEntity = dxsUserDetailEntity;
	}
}
