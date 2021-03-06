package com.buss.activesweek.entity;

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
 * @Description: dxs_actives_week
 * @author onlineGenerator
 * @date 2016-08-29 11:27:31
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_actives_week", schema = "")
@SuppressWarnings("serial")
public class ActivesWeekEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**活动id*/
	private java.lang.String activeId;
	/**协办单位*/
	private java.lang.String coOrganizer;
	/**承办单位*/
	private java.lang.String undertakingUnit;
	/**赞助单位*/
	private java.lang.String supportingUnit;
	/**支持单位*/
	private java.lang.String supportUnit;
	/**媒体单位*/
	private java.lang.String mediaUnit;
	/**学校*/
	private java.lang.String schoolName;
	/**区域*/
	private java.lang.String areaName;
	/**子分类(预留)*/
	private java.lang.String catalogChildren;
	/**活动日程*/
	private java.lang.String activeSchedule;
	/**参加对象及要求*/
	private java.lang.String objectRequired;
	/**精彩回放*/
	private java.lang.String imgUrls;
	/**宣传片*/
	private java.lang.String videoUrl;
	/**其他*/
	private java.lang.String others;
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
	 *@return: java.lang.String  活动id
	 */
	@Column(name ="ACTIVE_ID",nullable=true,length=32)
	public java.lang.String getActiveId(){
		return this.activeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动id
	 */
	public void setActiveId(java.lang.String activeId){
		this.activeId = activeId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  协办单位
	 */
	@Column(name ="CO_ORGANIZER",nullable=true,length=255)
	public java.lang.String getCoOrganizer(){
		return this.coOrganizer;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  协办单位
	 */
	public void setCoOrganizer(java.lang.String coOrganizer){
		this.coOrganizer = coOrganizer;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  承办单位
	 */
	@Column(name ="UNDERTAKING_UNIT",nullable=true,length=255)
	public java.lang.String getUndertakingUnit(){
		return this.undertakingUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  承办单位
	 */
	public void setUndertakingUnit(java.lang.String undertakingUnit){
		this.undertakingUnit = undertakingUnit;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  区域
	 */
	@Column(name ="AREA_NAME",nullable=true,length=50)
	public String getAreaName() {
		return areaName;
	}

	public void setAreaName(String areaName) {
		this.areaName = areaName;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  赞助单位
	 */
	@Column(name ="SUPPORTING_UNIT",nullable=true,length=255)
	public java.lang.String getSupportingUnit(){
		return this.supportingUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  赞助单位
	 */
	public void setSupportingUnit(java.lang.String supportingUnit){
		this.supportingUnit = supportingUnit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支持单位
	 */
	@Column(name ="SUPPORT_UNIT",nullable=true,length=255)
	public java.lang.String getSupportUnit(){
		return this.supportUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  支持单位
	 */
	public void setSupportUnit(java.lang.String supportUnit){
		this.supportUnit = supportUnit;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  宣传片
	 */
	@Column(name ="VIDEO_URL",nullable=true,length=255)
	public String getVideoUrl() {
		return videoUrl;
	}

	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  媒体单位
	 */
	@Column(name ="MEDIA_UNIT",nullable=true,length=255)
	public java.lang.String getMediaUnit(){
		return this.mediaUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  媒体单位
	 */
	public void setMediaUnit(java.lang.String mediaUnit){
		this.mediaUnit = mediaUnit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学校
	 */
	@Column(name ="SCHOOL_NAME",nullable=true,length=255)
	public java.lang.String getSchoolName(){
		return this.schoolName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学校
	 */
	public void setSchoolName(java.lang.String schoolName){
		this.schoolName = schoolName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  子分类(预留)
	 */
	@Column(name ="CATALOG_CHILDREN",nullable=true,length=255)
	public java.lang.String getCatalogChildren(){
		return this.catalogChildren;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  子分类(预留)
	 */
	public void setCatalogChildren(java.lang.String catalogChildren){
		this.catalogChildren = catalogChildren;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动日程
	 */
	@Column(name ="ACTIVE_SCHEDULE",nullable=true,length=255)
	public java.lang.String getActiveSchedule(){
		return this.activeSchedule;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动日程
	 */
	public void setActiveSchedule(java.lang.String activeSchedule){
		this.activeSchedule = activeSchedule;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参加对象及要求
	 */
	@Column(name ="OBJECT_REQUIRED",nullable=true,length=255)
	public java.lang.String getObjectRequired(){
		return this.objectRequired;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参加对象及要求
	 */
	public void setObjectRequired(java.lang.String objectRequired){
		this.objectRequired = objectRequired;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  精彩回放
	 */
	@Column(name ="IMG_URLS",nullable=true,length=255)
	public java.lang.String getImgUrls(){
		return this.imgUrls;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  精彩回放
	 */
	public void setImgUrls(java.lang.String imgUrls){
		this.imgUrls = imgUrls;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  其他
	 */
	@Column(name ="OTHERS",nullable=true,length=255)
	public java.lang.String getOthers(){
		return this.others;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  其他
	 */
	public void setOthers(java.lang.String others){
		this.others = others;
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
