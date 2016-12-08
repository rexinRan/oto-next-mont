package com.buss.activeswhite.entity;

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
 * @Description: dxs_actives_white
 * @author onlineGenerator
 * @date 2016-07-30 13:42:22
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_actives_white", schema = "")
@SuppressWarnings("serial")
public class ActivesWhiteEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**用户id*/
	private java.lang.String userId;
	/**目的地*/
	private java.lang.String destination;
	/**备选目的地*/
	private java.lang.String destinationRemarks;
	/**出发时间*/
	private java.lang.String setOutTime;
	/**备选时间*/
	private java.lang.String setOutTimeRemarksTime;
	/**出行天数*/
	private java.lang.String days;
	/**行程预算*/
	private java.lang.String tripPrices;
	/**成了人数*/
	private java.lang.Integer tripBigNum;
	/**儿童人数*/
	private java.lang.Integer tripSmailNum;
	/**详细地址*/
	private java.lang.String address;
	/**备注*/
	private java.lang.String remarks;
	/**申请状态*/
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
	 *@return: java.lang.String  目的地
	 */
	@Column(name ="DESTINATION",nullable=true,length=255)
	public java.lang.String getDestination(){
		return this.destination;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  目的地
	 */
	public void setDestination(java.lang.String destination){
		this.destination = destination;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备选目的地
	 */
	@Column(name ="DESTINATION_REMARKS",nullable=true,length=255)
	public java.lang.String getDestinationRemarks(){
		return this.destinationRemarks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备选目的地
	 */
	public void setDestinationRemarks(java.lang.String destinationRemarks){
		this.destinationRemarks = destinationRemarks;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出发时间
	 */
	@Column(name ="SET_OUT_TIME",nullable=true,length=50)
	public java.lang.String getSetOutTime(){
		return this.setOutTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出发时间
	 */
	public void setSetOutTime(java.lang.String setOutTime){
		this.setOutTime = setOutTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备选时间
	 */
	@Column(name ="SET_OUT_TIME_REMARKS_TIME",nullable=true,length=50)
	public java.lang.String getSetOutTimeRemarksTime(){
		return this.setOutTimeRemarksTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备选时间
	 */
	public void setSetOutTimeRemarksTime(java.lang.String setOutTimeRemarksTime){
		this.setOutTimeRemarksTime = setOutTimeRemarksTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出行天数
	 */
	@Column(name ="DAYS",nullable=true,length=20)
	public java.lang.String getDays(){
		return this.days;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出行天数
	 */
	public void setDays(java.lang.String days){
		this.days = days;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  行程预算
	 */
	@Column(name ="TRIP_PRICES",nullable=true,length=255)
	public java.lang.String getTripPrices(){
		return this.tripPrices;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  行程预算
	 */
	public void setTripPrices(java.lang.String tripPrices){
		this.tripPrices = tripPrices;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  成了人数
	 */
	@Column(name ="TRIP_BIG_NUM",nullable=true,length=10)
	public java.lang.Integer getTripBigNum(){
		return this.tripBigNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  成了人数
	 */
	public void setTripBigNum(java.lang.Integer tripBigNum){
		this.tripBigNum = tripBigNum;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  儿童人数
	 */
	@Column(name ="TRIP_SMAIL_NUM",nullable=true,length=10)
	public java.lang.Integer getTripSmailNum(){
		return this.tripSmailNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  儿童人数
	 */
	public void setTripSmailNum(java.lang.Integer tripSmailNum){
		this.tripSmailNum = tripSmailNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  详细地址
	 */
	@Column(name ="ADDRESS",nullable=true,length=255)
	public java.lang.String getAddress(){
		return this.address;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  详细地址
	 */
	public void setAddress(java.lang.String address){
		this.address = address;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  申请状态
	 */
	@Column(name ="RESULT",nullable=true,length=3)
	public java.lang.Integer getResult(){
		return this.result;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  申请状态
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
