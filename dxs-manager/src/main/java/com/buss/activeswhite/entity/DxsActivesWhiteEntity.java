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
import org.jeecgframework.poi.excel.annotation.Excel;

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
public class DxsActivesWhiteEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**用户id*/
	@Excel(name="用户id")
	private String userId;
	/**目的地*/
	@Excel(name="目的地")
	private String destination;
	/**备选目的地*/
	@Excel(name="备选目的地")
	private String destinationRemarks;
	/**出发时间*/
	@Excel(name="出发时间")
	private String setOutTime;
	/**备选时间*/
	@Excel(name="备选时间")
	private String setOutTimeRemarksTime;
	/**出行天数*/
	@Excel(name="出行天数")
	private String days;
	/**行程预算*/
	@Excel(name="行程预算")
	private String tripPrices;
	/**成了人数*/
	@Excel(name="成了人数")
	private Integer tripBigNum;
	/**儿童人数*/
	@Excel(name="儿童人数")
	private Integer tripSmailNum;
	/**详细地址*/
	@Excel(name="详细地址")
	private String address;
	/**备注*/
	@Excel(name="备注")
	private String remarks;
	/**申请状态*/
	@Excel(name="申请状态")
	private Integer result;
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
	 *@return: java.lang.String  目的地
	 */
	@Column(name ="DESTINATION",nullable=true,length=255)
	public String getDestination(){
		return this.destination;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  目的地
	 */
	public void setDestination(String destination){
		this.destination = destination;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备选目的地
	 */
	@Column(name ="DESTINATION_REMARKS",nullable=true,length=255)
	public String getDestinationRemarks(){
		return this.destinationRemarks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备选目的地
	 */
	public void setDestinationRemarks(String destinationRemarks){
		this.destinationRemarks = destinationRemarks;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出发时间
	 */
	@Column(name ="SET_OUT_TIME",nullable=true,length=50)
	public String getSetOutTime(){
		return this.setOutTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出发时间
	 */
	public void setSetOutTime(String setOutTime){
		this.setOutTime = setOutTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备选时间
	 */
	@Column(name ="SET_OUT_TIME_REMARKS_TIME",nullable=true,length=50)
	public String getSetOutTimeRemarksTime(){
		return this.setOutTimeRemarksTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备选时间
	 */
	public void setSetOutTimeRemarksTime(String setOutTimeRemarksTime){
		this.setOutTimeRemarksTime = setOutTimeRemarksTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出行天数
	 */
	@Column(name ="DAYS",nullable=true,length=20)
	public String getDays(){
		return this.days;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出行天数
	 */
	public void setDays(String days){
		this.days = days;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  行程预算
	 */
	@Column(name ="TRIP_PRICES",nullable=true,length=255)
	public String getTripPrices(){
		return this.tripPrices;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  行程预算
	 */
	public void setTripPrices(String tripPrices){
		this.tripPrices = tripPrices;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  成了人数
	 */
	@Column(name ="TRIP_BIG_NUM",nullable=true,length=10)
	public Integer getTripBigNum(){
		return this.tripBigNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  成了人数
	 */
	public void setTripBigNum(Integer tripBigNum){
		this.tripBigNum = tripBigNum;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  儿童人数
	 */
	@Column(name ="TRIP_SMAIL_NUM",nullable=true,length=10)
	public Integer getTripSmailNum(){
		return this.tripSmailNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  儿童人数
	 */
	public void setTripSmailNum(Integer tripSmailNum){
		this.tripSmailNum = tripSmailNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  详细地址
	 */
	@Column(name ="ADDRESS",nullable=true,length=255)
	public String getAddress(){
		return this.address;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  详细地址
	 */
	public void setAddress(String address){
		this.address = address;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  申请状态
	 */
	@Column(name ="RESULT",nullable=true,length=3)
	public Integer getResult(){
		return this.result;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  申请状态
	 */
	public void setResult(Integer result){
		this.result = result;
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
}
