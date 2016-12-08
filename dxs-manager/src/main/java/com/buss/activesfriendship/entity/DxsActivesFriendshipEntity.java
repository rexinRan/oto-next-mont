package com.buss.activesfriendship.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.actives.entity.DxsActivesEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_actives_friendship
 * @author onlineGenerator
 * @date 2016-08-29 11:29:42
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_actives_friendship", schema = "")
@SuppressWarnings("serial")
public class DxsActivesFriendshipEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**活动id*/
	@Excel(name="活动id")
	private String activeId;
	/**协办单位*/
	@Excel(name="协办单位")
	private String coOrganizer;
	/**承办单位*/
	@Excel(name="承办单位")
	private String undertakingUnit;
	/**赞助单位*/
	@Excel(name="赞助单位")
	private String supportingUnit;
	/**支持单位*/
	@Excel(name="支持单位")
	private String supportUnit;
	/**学校*/
	@Excel(name="学校")
	private java.lang.String schoolName;
	/**媒体单位*/
	@Excel(name="媒体单位")
	private String mediaUnit;
	/**举办省份*/
	@Excel(name="举办省份")
	private String hostProvinces;
	/**活动流程*/
	@Excel(name="活动流程")
	private String activityFlow;
	/**参赛对象及要求*/
	@Excel(name="参赛对象及要求")
	private String objectRequired;
	/**宣传片*/
	@Excel(name="宣传片")
	private String videoUrl;
	/**精彩回放*/
	@Excel(name="精彩回放")
	private String imgUrls;
	/**时间流程图*/
	@Excel(name="时间流程图")
	private java.lang.String timeFlow;
	/**其他*/
	@Excel(name="其他")
	private String others;
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
	 *@return: java.lang.String  活动id
	 */
	@Column(name ="ACTIVE_ID",nullable=true,length=32)
	public String getActiveId(){
		return this.activeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动id
	 */
	public void setActiveId(String activeId){
		this.activeId = activeId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  协办单位
	 */
	@Column(name ="CO_ORGANIZER",nullable=true,length=255)
	public String getCoOrganizer(){
		return this.coOrganizer;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  协办单位
	 */
	public void setCoOrganizer(String coOrganizer){
		this.coOrganizer = coOrganizer;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  承办单位
	 */
	@Column(name ="UNDERTAKING_UNIT",nullable=true,length=255)
	public String getUndertakingUnit(){
		return this.undertakingUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  承办单位
	 */
	public void setUndertakingUnit(String undertakingUnit){
		this.undertakingUnit = undertakingUnit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  赞助单位
	 */
	@Column(name ="SUPPORTING_UNIT",nullable=true,length=255)
	public String getSupportingUnit(){
		return this.supportingUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  赞助单位
	 */
	public void setSupportingUnit(String supportingUnit){
		this.supportingUnit = supportingUnit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  支持单位
	 */
	@Column(name ="SUPPORT_UNIT",nullable=true,length=255)
	public String getSupportUnit(){
		return this.supportUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  支持单位
	 */
	public void setSupportUnit(String supportUnit){
		this.supportUnit = supportUnit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学校
	 */
	@Column(name ="SCHOOL_NAME",nullable=true,length=50)
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
	 *@return: java.lang.String  媒体单位
	 */
	@Column(name ="MEDIA_UNIT",nullable=true,length=255)
	public String getMediaUnit(){
		return this.mediaUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  媒体单位
	 */
	public void setMediaUnit(String mediaUnit){
		this.mediaUnit = mediaUnit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  举办省份
	 */
	@Column(name ="HOST_PROVINCES",nullable=true,length=255)
	public String getHostProvinces(){
		return this.hostProvinces;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  举办省份
	 */
	public void setHostProvinces(String hostProvinces){
		this.hostProvinces = hostProvinces;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动流程
	 */
	@Column(name ="ACTIVITY_FLOW",nullable=true,length=255)
	public String getActivityFlow(){
		return this.activityFlow;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动流程
	 */
	public void setActivityFlow(String activityFlow){
		this.activityFlow = activityFlow;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参赛对象及要求
	 */
	@Column(name ="OBJECT_REQUIRED",nullable=true,length=255)
	public String getObjectRequired(){
		return this.objectRequired;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参赛对象及要求
	 */
	public void setObjectRequired(String objectRequired){
		this.objectRequired = objectRequired;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  宣传片
	 */
	@Column(name ="VIDEO_URL",nullable=true,length=255)
	public String getVideoUrl(){
		return this.videoUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  宣传片
	 */
	public void setVideoUrl(String videoUrl){
		this.videoUrl = videoUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  精彩回放
	 */
	@Column(name ="IMG_URLS",nullable=true,length=255)
	public String getImgUrls(){
		return this.imgUrls;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  精彩回放
	 */
	public void setImgUrls(String imgUrls){
		this.imgUrls = imgUrls;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  时间流程图
	 */
	@Column(name ="TIME_FLOW",nullable=true,length=255)
	public java.lang.String getTimeFlow(){
		return this.timeFlow;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  时间流程图
	 */
	public void setTimeFlow(java.lang.String timeFlow){
		this.timeFlow = timeFlow;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  其他
	 */
	@Column(name ="OTHERS",nullable=true,length=255)
	public String getOthers(){
		return this.others;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  其他
	 */
	public void setOthers(String others){
		this.others = others;
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

	//大权添加与dxs_actives表的多对一关联
	private DxsActivesEntity dxsActivesEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "active_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)
	public DxsActivesEntity getDxsActivesEntity() {
		return dxsActivesEntity;
	}

	public void setDxsActivesEntity(DxsActivesEntity dxsActivesEntity) {
		this.dxsActivesEntity = dxsActivesEntity;
	}
}
