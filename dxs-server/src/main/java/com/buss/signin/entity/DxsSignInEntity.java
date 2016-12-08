package com.buss.signin.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: dxs_sign_in
 * @author onlineGenerator
 * @date 2016-06-22 15:24:25
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_sign_in", schema = "")
@SuppressWarnings("serial")
public class DxsSignInEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**用户ID*/
	private String userId;
	/**签到类型*/
	private String signType;
	/**签到时间*/
	private Date signTime;
	/**连续签到天数*/
	private Integer signDay;
	/**签到状态*/
	private String signStatus;
	/**鸿鑫币数量*/
	private Integer hxbNum;
	/**是否连续签到*/
	private Integer isContinuity;
	/**备注*/
	private String remarks;
	/**创建时间*/
	private Date createTime;
	/**更新时间*/
	private Date updateTime;
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
	 *@return: java.lang.String  用户ID
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户ID
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  签到类型
	 */
	@Column(name ="SIGN_TYPE",nullable=true,length=2)
	public String getSignType(){
		return this.signType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  签到类型
	 */
	public void setSignType(String signType){
		this.signType = signType;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  签到时间
	 */
	@Column(name ="SIGN_TIME",nullable=true)
	public Date getSignTime(){
		return this.signTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  签到时间
	 */
	public void setSignTime(Date signTime){
		this.signTime = signTime;
	}

	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  签到时间
	 */
	@Column(name ="HXB_NUM",nullable=true)
	public Integer getHxbNum() {
		return hxbNum;
	}

	public void setHxbNum(Integer hxbNum) {
		this.hxbNum = hxbNum;
	}

	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  签到时间
	 */
	@Column(name ="IS_CONTINUITY",nullable=true)
	public Integer getIsContinuity() {
		return isContinuity;
	}

	public void setIsContinuity(Integer isContinuity) {
		this.isContinuity = isContinuity;
	}

	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  连续签到天数
	 */
	@Column(name ="SIGN_DAY",nullable=true,length=10)
	public Integer getSignDay(){
		return this.signDay;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  连续签到天数
	 */
	public void setSignDay(Integer signDay){
		this.signDay = signDay;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  签到状态
	 */
	@Column(name ="SIGN_STATUS",nullable=true,length=3)
	public String getSignStatus(){
		return this.signStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  签到状态
	 */
	public void setSignStatus(String signStatus){
		this.signStatus = signStatus;
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
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="REMARKS",nullable=true)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
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
