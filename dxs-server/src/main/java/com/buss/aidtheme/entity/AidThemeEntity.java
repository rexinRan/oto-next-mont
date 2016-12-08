package com.buss.aidtheme.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: dxs_aid_theme
 * @author onlineGenerator
 * @date 2016-09-01 10:44:29
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_aid_theme", schema = "")
@SuppressWarnings("serial")
public class AidThemeEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**标题*/

	private String title;
	/**banner图地址*/

	private String bannerImg;
	/**详情页图片地址*/

	private String detailImg;
	/**状态*/

	private String state;
	/**目标金额*/

	private Integer tagetMoney;
	/**已筹金额*/

	private Integer existingMoney;
	/**开始时间*/

	private Date startTime;
	/**结束时间*/

	private Date endTime;
	/**捐款人数*/

	private Integer number;
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
	 *@return: java.lang.String  banner图地址
	 */
	@Column(name ="BANNER_IMG",nullable=true,length=255)
	public String getBannerImg(){
		return this.bannerImg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  banner图地址
	 */
	public void setBannerImg(String bannerImg){
		this.bannerImg = bannerImg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  标题
	 */
	@Column(name ="Title",nullable=true,length=100)
	public String getTitle(){
		return this.title;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  标题
	 */
	public void setTitle(String title){
		this.title = title;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  详情页图片地址
	 */
	@Column(name ="DETAIL_IMG",nullable=true,length=255)
	public String getDetailImg(){
		return this.detailImg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  详情页图片地址
	 */
	public void setDetailImg(String detailImg){
		this.detailImg = detailImg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  状态
	 */
	@Column(name ="STATE",nullable=true,length=100)
	public String getState(){
		return this.state;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  状态
	 */
	public void setState(String state){
		this.state = state;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  目标金额
	 */
	@Column(name ="TAGET_MONEY",nullable=true,length=10)
	public Integer getTagetMoney(){
		return this.tagetMoney;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  目标金额
	 */
	public void setTagetMoney(Integer tagetMoney){
		this.tagetMoney = tagetMoney;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  已筹金额
	 */
	@Column(name ="EXISTING_MONEY",nullable=true,length=10)
	public Integer getExistingMoney(){
		return this.existingMoney;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  已筹金额
	 */
	public void setExistingMoney(Integer existingMoney){
		this.existingMoney = existingMoney;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  开始时间
	 */
	@Column(name ="START_TIME",nullable=true)
	public Date getStartTime(){
		return this.startTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  开始时间
	 */
	public void setStartTime(Date startTime){
		this.startTime = startTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  结束时间
	 */
	@Column(name ="END_TIME",nullable=true)
	public Date getEndTime(){
		return this.endTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  结束时间
	 */
	public void setEndTime(Date endTime){
		this.endTime = endTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  捐款人数
	 */
	@Column(name ="NUMBER",nullable=true,length=10)
	public Integer getNumber(){
		return this.number;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  捐款人数
	 */
	public void setNumber(Integer number){
		this.number = number;
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
