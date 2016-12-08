package com.buss.aidactives.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: dxs_aid_actives
 * @author onlineGenerator
 * @date 2016-09-01 10:42:43
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_aid_actives", schema = "")
@SuppressWarnings("serial")
public class AidActivesEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**公益主题*/

	private String catalog;
	/**缩略图*/

	private String imgUrl;
	/**主办方*/

	private String sponsor;
	/**发布时间*/

	private Date publishTime;
	/**报名截止时间*/

	private Date deadlineDate;
	/**活动开始时间*/

	private Date activeStartTime;
	/**活动结束时间*/

	private Date activeEndTime;
	/**活动分类*/

	private String activeCatelog;
	/**已报名人数*/

	private Integer activeNumber;
	/**活动地点*/

	private String activeAddress;
	/**活动简介*/

	private String activeIntroduce;
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
	 *@return: java.lang.String  公益主题
	 */
	@Column(name ="CATALOG",nullable=true,length=32)
	public String getCatalog(){
		return this.catalog;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公益主题
	 */
	public void setCatalog(String catalog){
		this.catalog = catalog;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  缩略图
	 */
	@Column(name ="IMG_URL",nullable=true)
	public String getImgUrl(){
		return this.imgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  缩略图
	 */
	public void setImgUrl(String imgUrl){
		this.imgUrl = imgUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主办方
	 */
	@Column(name ="SPONSOR",nullable=true,length=100)
	public String getSponsor(){
		return this.sponsor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主办方
	 */
	public void setSponsor(String sponsor){
		this.sponsor = sponsor;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  发布时间
	 */
	@Column(name ="PUBLISH_TIME",nullable=true)
	public Date getPublishTime(){
		return this.publishTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  发布时间
	 */
	public void setPublishTime(Date publishTime){
		this.publishTime = publishTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  报名截止时间
	 */
	@Column(name ="DEADLINE_DATE",nullable=true)
	public Date getDeadlineDate(){
		return this.deadlineDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  报名截止时间
	 */
	public void setDeadlineDate(Date deadlineDate){
		this.deadlineDate = deadlineDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  活动开始时间
	 */
	@Column(name ="ACTIVE_START_TIME",nullable=true)
	public Date getActiveStartTime(){
		return this.activeStartTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  活动开始时间
	 */
	public void setActiveStartTime(Date activeStartTime){
		this.activeStartTime = activeStartTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  活动结束时间
	 */
	@Column(name ="ACTIVE_END_TIME",nullable=true)
	public Date getActiveEndTime(){
		return this.activeEndTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  活动结束时间
	 */
	public void setActiveEndTime(Date activeEndTime){
		this.activeEndTime = activeEndTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动分类
	 */
	@Column(name ="ACTIVE_CATELOG",nullable=true,length=100)
	public String getActiveCatelog(){
		return this.activeCatelog;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动分类
	 */
	public void setActiveCatelog(String activeCatelog){
		this.activeCatelog = activeCatelog;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  已报名人数
	 */
	@Column(name ="ACTIVE_NUMBER",nullable=true,length=10)
	public Integer getActiveNumber(){
		return this.activeNumber;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  已报名人数
	 */
	public void setActiveNumber(Integer activeNumber){
		this.activeNumber = activeNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动地点
	 */
	@Column(name ="ACTIVE_ADDRESS",nullable=true,length=255)
	public String getActiveAddress(){
		return this.activeAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动地点
	 */
	public void setActiveAddress(String activeAddress){
		this.activeAddress = activeAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动简介
	 */
	@Column(name ="ACTIVE_INTRODUCE",nullable=true,length=255)
	public String getActiveIntroduce(){
		return this.activeIntroduce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动简介
	 */
	public void setActiveIntroduce(String activeIntroduce){
		this.activeIntroduce = activeIntroduce;
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
