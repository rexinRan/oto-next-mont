package com.buss.actives.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.activecatelog.entity.DxsActiveCatelogEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_actives
 * @author onlineGenerator
 * @date 2016-06-23 17:11:48
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_actives", schema = "")
@SuppressWarnings("serial")
public class DxsActivesEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**活动分类的id*/
	@Excel(name="活动分类的id")
	private String activeCatelogId;
	/**缩略图*/
	@Excel(name="缩略图")
	private  String activeImage;
	/**活动标题*/
	@Excel(name="活动标题")
	private String activeTitle;
	/**展示菜单*/
	@Excel(name="展示菜单")
	private String displayMenu;
	/**活动地点*/
	@Excel(name="活动地点")
	private String activeAddress;
	/**主办单位*/
	@Excel(name="主办单位")
	private String hostUnit;
	/**报名人数*/
	@Excel(name="报名人数")
	private java.lang.Integer regNumbers;
	/**限报人数*/
	@Excel(name="限报人数")
	private String limitedNumber;
	/**精彩回顾*/
	@Excel(name="精彩回顾")
	private String histaryDate;
	/**报名截止时间*/
	@Excel(name="报名截止时间",format = "yyyy-MM-dd")
	private Date deadlineDate;
	/**活动开始时间*/
	@Excel(name="活动开始时间",format = "yyyy-MM-dd")
	private Date activeStateTime;
	/**活动结束时间*/
	@Excel(name="活动结束时间",format = "yyyy-MM-dd")
	private Date activeEndTime;
	/**活动对象*/
	@Excel(name="活动对象")
	private String activeUsertypeId;
	/**内容图选*/
	@Excel(name="内容图选")
	private java.lang.String activeContentImg;
	/**具体活动内容*/
	@Excel(name="具体活动内容")
	private String activeContent;
	/**价钱*/
	@Excel(name="价钱")
	private Integer activePrice;
	/**是否收费*/
	@Excel(name="是否收费")
	private Integer isCharge;
	/**可使用鸿鑫币数量*/
	@Excel(name="可使用鸿鑫币数量")
	private String maxAccountCount;
	/**发布时间*/
	@Excel(name="发布时间",format = "yyyy-MM-dd")
	private Date publishTime;
	/**编辑人*/
	@Excel(name="编辑人")
	private String activeEditor;
	/**备注*/
	@Excel(name="备注")
	private String remarks;
	/**活动分类2*/
	@Excel(name="活动分类2")
	private Integer sctiveType2;
	/**活动分类3*/
	@Excel(name="活动分类3")
	private Integer sctiveType3;
	/**出发时间*/
	@Excel(name="出发时间")
	private String setOutTime;
	/**出发地*/
	@Excel(name="出发地")
	private String setOutAddress;
	/**活动国家*/
	@Excel(name="活动国家")
	private String activeCountry;
	/**行程天数*/
	@Excel(name="行程天数")
	private Integer activesNum;
	/**特色简介*/
	@Excel(name="特色简介")
	private String activesCharacteristics;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private Date createTime;
	/**更新时间*/
	@Excel(name="更新时间",format = "yyyy-MM-dd")
	private Date updateTime;
	/**删除标志*/
	@Excel(name="删除标志")
	private Integer isDelete;

	private DxsActiveCatelogEntity  dxsActiveCatelogEntity;
	
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
	 *@return: java.lang.String  活动分类的id
	 */
	@Column(name ="ACTIVE_CATELOG_ID",nullable=true,length=32)
	public String getActiveCatelogId(){
		return this.activeCatelogId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动分类的id
	 */
	public void setActiveCatelogId(String activeCatelogId){
		this.activeCatelogId = activeCatelogId;
	}

	@Column(name ="ACTIVE_IMAGE",nullable=true,length=255)
	public String getActiveImage() {
		return activeImage;
	}

	public void setActiveImage(String activeImage) {
		this.activeImage = activeImage;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动标题
	 */
	@Column(name ="ACTIVE_TITLE",nullable=true,length=100)
	public String getActiveTitle(){
		return this.activeTitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动标题
	 */
	public void setActiveTitle(String activeTitle){
		this.activeTitle = activeTitle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  展示菜单
	 */
	@Column(name ="DISPLAY_MENU",nullable=true,length=100)
	public String getDisplayMenu(){
		return this.displayMenu;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  展示菜单
	 */
	public void setDisplayMenu(String displayMenu){
		this.displayMenu = displayMenu;
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
	 *@return: java.lang.String  主办单位
	 */
	@Column(name ="HOST_UNIT",nullable=true,length=100)
	public String getHostUnit(){
		return this.hostUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主办单位
	 */
	public void setHostUnit(String hostUnit){
		this.hostUnit = hostUnit;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  报名人数
	 */
	@Column(name ="REG_NUMBERS",nullable=true,length=10)
	public java.lang.Integer getRegNumbers(){
		return this.regNumbers;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  报名人数
	 */
	public void setRegNumbers(java.lang.Integer regNumbers){
		this.regNumbers = regNumbers;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  限报人数
	 */
	@Column(name ="LIMITED_NUMBER",nullable=true,length=255)
	public String getLimitedNumber(){
		return this.limitedNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  限报人数
	 */
	public void setLimitedNumber(String limitedNumber){
		this.limitedNumber = limitedNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  精彩回顾
	 */
	@Column(name ="HISTARY_DATE",nullable=true,length=255)
	public String getHistaryDate(){
		return this.histaryDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  精彩回顾
	 */
	public void setHistaryDate(String histaryDate){
		this.histaryDate = histaryDate;
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
	@Column(name ="ACTIVE_STATE_TIME",nullable=true)
	public Date getActiveStateTime(){
		return this.activeStateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  活动开始时间
	 */
	public void setActiveStateTime(Date activeStateTime){
		this.activeStateTime = activeStateTime;
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
	 *@return: java.lang.String  活动对象
	 */
	@Column(name ="ACTIVE_USERTYPE_ID",nullable=true,length=32)
	public String getActiveUsertypeId(){
		return this.activeUsertypeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动对象
	 */
	public void setActiveUsertypeId(String activeUsertypeId){
		this.activeUsertypeId = activeUsertypeId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  内容图选
	 */
	@Column(name ="ACTIVE_CONTENT_IMG",nullable=true,length=255)
	public java.lang.String getActiveContentImg(){
		return this.activeContentImg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内容图选
	 */
	public void setActiveContentImg(java.lang.String activeContentImg){
		this.activeContentImg = activeContentImg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  具体活动内容
	 */
	@Column(name ="ACTIVE_CONTENT",nullable=true,length=16777215)
	public String getActiveContent(){
		return this.activeContent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  具体活动内容
	 */
	public void setActiveContent(String activeContent){
		this.activeContent = activeContent;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  价钱
	 */
	@Column(name ="ACTIVE_PRICE",nullable=true,length=11)
	public Integer getActivePrice(){
		return this.activePrice;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  价钱
	 */
	public void setActivePrice(Integer activePrice){
		this.activePrice = activePrice;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否收费
	 */
	@Column(name ="IS_CHARGE",nullable=true,length=10)
	public Integer getIsCharge(){
		return this.isCharge;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否收费
	 */
	public void setIsCharge(Integer isCharge){
		this.isCharge = isCharge;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  可使用鸿鑫币数量
	 */
	@Column(name ="MAX_ACCOUNT_COUNT",nullable=true,length=255)
	public String getMaxAccountCount(){
		return this.maxAccountCount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  可使用鸿鑫币数量
	 */
	public void setMaxAccountCount(String maxAccountCount){
		this.maxAccountCount = maxAccountCount;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编辑人
	 */
	@Column(name ="ACTIVE_EDITOR",nullable=true,length=100)
	public String getActiveEditor(){
		return this.activeEditor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  编辑人
	 */
	public void setActiveEditor(String activeEditor){
		this.activeEditor = activeEditor;
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
	 *@return: java.lang.Integer  活动分类2
	 */
	@Column(name ="SCTIVE_TYPE_2",nullable=true,length=3)
	public Integer getSctiveType2(){
		return this.sctiveType2;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  活动分类2
	 */
	public void setSctiveType2(Integer sctiveType2){
		this.sctiveType2 = sctiveType2;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  活动分类3
	 */
	@Column(name ="SCTIVE_TYPE_3",nullable=true,length=3)
	public Integer getSctiveType3(){
		return this.sctiveType3;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  活动分类3
	 */
	public void setSctiveType3(Integer sctiveType3){
		this.sctiveType3 = sctiveType3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出发时间
	 */
	@Column(name ="SET_OUT_TIME",nullable=true,length=20)
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
	 *@return: java.lang.String  出发地
	 */
	@Column(name ="SET_OUT_ADDRESS",nullable=true,length=255)
	public String getSetOutAddress(){
		return this.setOutAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出发地
	 */
	public void setSetOutAddress(String setOutAddress){
		this.setOutAddress = setOutAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动国家
	 */
	@Column(name ="ACTIVE_COUNTRY",nullable=true,length=100)
	public String getActiveCountry(){
		return this.activeCountry;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动国家
	 */
	public void setActiveCountry(String activeCountry){
		this.activeCountry = activeCountry;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  行程天数
	 */
	@Column(name ="ACTIVES_NUM",nullable=true,length=10)
	public Integer getActivesNum(){
		return this.activesNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  行程天数
	 */
	public void setActivesNum(Integer activesNum){
		this.activesNum = activesNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  特色简介
	 */
	@Column(name ="ACTIVES_CHARACTERISTICS",nullable=true,length=255)
	public String getActivesCharacteristics(){
		return this.activesCharacteristics;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  特色简介
	 */
	public void setActivesCharacteristics(String activesCharacteristics){
		this.activesCharacteristics = activesCharacteristics;
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
	@JoinColumn(name = "active_catelog_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)
	public DxsActiveCatelogEntity getDxsActiveCatelogEntity() {
		return dxsActiveCatelogEntity;
	}

	public void setDxsActiveCatelogEntity(DxsActiveCatelogEntity dxsActiveCatelogEntity) {
		this.dxsActiveCatelogEntity = dxsActiveCatelogEntity;
	}
}
