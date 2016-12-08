package com.buss.actives.entity;

import com.buss.activecatelog.entity.ActiveCatelogEntity;
import org.hibernate.annotations.GenericGenerator;


import javax.persistence.*;
import java.util.Date;

/**
 * 活动
 * @Title: Entity
 * @Description: dxs_actives
 * @author onlineGenerator
 * @date 2016-07-14 11:47:22
 * @version V1.0
 *
 */
@Entity
@Table(name = "dxs_actives", schema = "")
@SuppressWarnings("serial")
public class ActivesEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**活动分类的id*/

	private java.lang.String activeCatelogId;

	/**活动分类实体类*/
	private ActiveCatelogEntity activeCatelogEntity;
	/**活动标题*/

	private java.lang.String activeTitle;
	/**展示菜单*/

	private java.lang.String displayMenu;
	/**活动地点*/

	private java.lang.String activeAddress;
	/**主办单位*/

	private java.lang.String hostUnit;
	/**报名人数*/

	private java.lang.Integer regNumbers;
	/**限报人数*/

	private java.lang.String limitedNumber;
	/**精彩回顾*/

	private java.lang.String histaryDate;
	/**报名截止时间*/

	private java.util.Date deadlineDate;
	/**活动开始时间*/

	private java.util.Date activeStateTime;
	/**活动结束时间*/

	private java.util.Date activeEndTime;
	/**活动对象*/

	private java.lang.String activeUsertypeId;
	/**具体活动内容*/

	private java.lang.String activeContent;
	/**活动缩略图*/

	private java.lang.String activeImage;
	/**内容图选*/

	private java.lang.String activeContentImg;

	/**价钱*/

	private java.lang.Integer activePrice;
	/**是否收费 0收费 1不收费*/

	private java.lang.Integer isCharge;
	/**可使用鸿鑫币数量*/

	private java.lang.String maxAccountCount;
	/**活动赠送鸿鑫豆的数量*/

	private  java.lang.String giftAccountCount;
	/**发布时间*/

	private java.util.Date publishTime;
	/**编辑人*/

	private java.lang.String activeEditor;
	/**备注*/

	private java.lang.String remarks;
	/**活动分类2*/

	private java.lang.Integer sctiveType2;
	/**活动分类3*/

	private java.lang.String sctiveType3;
	/**出发时间*/

	private java.lang.String setOutTime;
	/**出发地*/

	private java.lang.String setOutAddress;
	/**活动国家*/

	private java.lang.String activeCountry;
	/**行程天数*/

	private java.lang .Integer activesNum;
	/**特色简介*/

	private java.lang.String activesCharacteristics;
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
	 *@return: java.lang.String  活动分类的id
	 */
	@Column(name ="ACTIVE_CATELOG_ID",nullable=true,length=32)
	public java.lang.String getActiveCatelogId(){
		return this.activeCatelogId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动分类的id
	 */
	public void setActiveCatelogId(java.lang.String activeCatelogId){
		this.activeCatelogId = activeCatelogId;
	}

	@OneToOne()
	@JoinColumn(name="ACTIVE_CATELOG_ID",insertable = false, updatable = false)
	public ActiveCatelogEntity getActiveCatelogEntity() {
		return activeCatelogEntity;
	}

	public void setActiveCatelogEntity(ActiveCatelogEntity activeCatelogEntity) {
		this.activeCatelogEntity = activeCatelogEntity;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动标题
	 */
	@Column(name ="ACTIVE_TITLE",nullable=true,length=100)
	public java.lang.String getActiveTitle(){
		return this.activeTitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动标题
	 */
	public void setActiveTitle(java.lang.String activeTitle){
		this.activeTitle = activeTitle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动缩略图
	 */
	@Column(name ="ACTIVE_IMAGE",nullable=true,length=255)
	public java.lang.String getActiveImage(){
		return this.activeImage;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动缩略图
	 */
	public void setActiveImage(java.lang.String activeImage){
		this.activeImage = activeImage;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动缩略图
	 */
	@Column(name ="ACTIVE_CONTENT_IMG",nullable=true,length=255)
	public String getActiveContentImg() {
		return activeContentImg;
	}

	public void setActiveContentImg(String activeContentImg) {
		this.activeContentImg = activeContentImg;
	}

	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  限报人数
	 */
	@Column(name ="REG_NUMBERS",nullable=true,length=11)
	public Integer getRegNumbers() {
		return regNumbers;
	}

	public void setRegNumbers(Integer regNumbers) {
		this.regNumbers = regNumbers;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  展示菜单
	 */
	@Column(name ="DISPLAY_MENU",nullable=true,length=100)
	public java.lang.String getDisplayMenu(){
		return this.displayMenu;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  展示菜单
	 */
	public void setDisplayMenu(java.lang.String displayMenu){
		this.displayMenu = displayMenu;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动地点
	 */
	@Column(name ="ACTIVE_ADDRESS",nullable=true,length=255)
	public java.lang.String getActiveAddress(){
		return this.activeAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动地点
	 */
	public void setActiveAddress(java.lang.String activeAddress){
		this.activeAddress = activeAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主办单位
	 */
	@Column(name ="HOST_UNIT",nullable=true,length=100)
	public java.lang.String getHostUnit(){
		return this.hostUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主办单位
	 */
	public void setHostUnit(java.lang.String hostUnit){
		this.hostUnit = hostUnit;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  限报人数
	 */
	@Column(name ="LIMITED_NUMBER",nullable=true,length=255)
	public java.lang.String getLimitedNumber(){
		return this.limitedNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  限报人数
	 */
	public void setLimitedNumber(java.lang.String limitedNumber){
		this.limitedNumber = limitedNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  精彩回顾
	 */
	@Column(name ="HISTARY_DATE",nullable=true,length=255)
	public java.lang.String getHistaryDate(){
		return this.histaryDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  精彩回顾
	 */
	public void setHistaryDate(java.lang.String histaryDate){
		this.histaryDate = histaryDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  报名截止时间
	 */
	@Column(name ="DEADLINE_DATE",nullable=true)
	public java.util.Date getDeadlineDate(){
		return this.deadlineDate;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  报名截止时间
	 */
	public void setDeadlineDate(java.util.Date deadlineDate){
		this.deadlineDate = deadlineDate;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  活动开始时间
	 */
	@Column(name ="ACTIVE_STATE_TIME",nullable=true)
	public java.util.Date getActiveStateTime(){
		return this.activeStateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  活动开始时间
	 */
	public void setActiveStateTime(java.util.Date activeStateTime){
		this.activeStateTime = activeStateTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  活动结束时间
	 */
	@Column(name ="ACTIVE_END_TIME",nullable=true)
	public java.util.Date getActiveEndTime(){
		return this.activeEndTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  活动结束时间
	 */
	public void setActiveEndTime(java.util.Date activeEndTime){
		this.activeEndTime = activeEndTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动对象
	 */
	@Column(name ="ACTIVE_USERTYPE_ID",nullable=true,length=32)
	public java.lang.String getActiveUsertypeId(){
		return this.activeUsertypeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动对象
	 */
	public void setActiveUsertypeId(java.lang.String activeUsertypeId){
		this.activeUsertypeId = activeUsertypeId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  具体活动内容
	 */
	@Column(name ="ACTIVE_CONTENT",nullable=true,length=4)
	public java.lang.String getActiveContent(){
		return this.activeContent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  具体活动内容
	 */
	public void setActiveContent(java.lang.String activeContent){
		this.activeContent = activeContent;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  价钱
	 */
	@Column(name ="ACTIVE_PRICE",nullable=true,length=11)
	public java.lang.Integer getActivePrice(){
		return this.activePrice;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  价钱
	 */
	public void setActivePrice(java.lang.Integer activePrice){
		this.activePrice = activePrice;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否收费 0收费 1不收费
	 */
	@Column(name ="IS_CHARGE",nullable=true,length=10)
	public java.lang.Integer getIsCharge(){
		return this.isCharge;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否收费 0收费 1不收费
	 */
	public void setIsCharge(java.lang.Integer isCharge){
		this.isCharge = isCharge;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  可使用鸿鑫币数量
	 */
	@Column(name ="MAX_ACCOUNT_COUNT",nullable=true,length=255)
	public java.lang.String getMaxAccountCount(){
		return this.maxAccountCount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  可使用鸿鑫币数量
	 */
	public void setMaxAccountCount(java.lang.String maxAccountCount){
		this.maxAccountCount = maxAccountCount;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动赠送的鸿鑫豆的数量
	 */
	@Column(name ="GIFT_ACCOUNT_COUNT",nullable=true,length=255)
	public String getGiftAccountCount() {
		return giftAccountCount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动赠送的鸿鑫豆的数量
	 */
	public void setGiftAccountCount(String giftAccountCount) {
		this.giftAccountCount = giftAccountCount;
	}

	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  发布时间
	 */
	@Column(name ="PUBLISH_TIME",nullable=true)
	public java.util.Date getPublishTime(){
		return this.publishTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  发布时间
	 */
	public void setPublishTime(java.util.Date publishTime){
		this.publishTime = publishTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编辑人
	 */
	@Column(name ="ACTIVE_EDITOR",nullable=true,length=100)
	public java.lang.String getActiveEditor(){
		return this.activeEditor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  编辑人
	 */
	public void setActiveEditor(java.lang.String activeEditor){
		this.activeEditor = activeEditor;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARKS",nullable=true,length=255)
	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  活动分类2
	 */
	@Column(name ="SCTIVE_TYPE_2",nullable=true,length=2)
	public Integer getSctiveType2() {
		return sctiveType2;
	}

	public void setSctiveType2(Integer sctiveType2) {
		this.sctiveType2 = sctiveType2;
	}

	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  活动分类3
	 */
	@Column(name ="SCTIVE_TYPE_3",nullable=true,length=2)
	public String getSctiveType3() {
		return sctiveType3;
	}

	public void setSctiveType3(String sctiveType3) {
		this.sctiveType3 = sctiveType3;
	}

	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  出发时间
	 */
	@Column(name ="SET_OUT_TIME",nullable=true,length = 20)
	public String getSetOutTime() {
		return setOutTime;
	}

	public void setSetOutTime(String setOutTime) {
		this.setOutTime = setOutTime;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出发地
	 */
	@Column(name ="SET_OUT_ADDRESS",nullable=true,length=255)
	public String getSetOutAddress() {
		return setOutAddress;
	}

	public void setSetOutAddress(String setOutAddress) {
		this.setOutAddress = setOutAddress;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动国家
	 */
	@Column(name ="ACTIVE_COUNTRY",nullable=true,length=100)
	public String getActiveCountry() {
		return activeCountry;
	}

	public void setActiveCountry(String activeCountry) {
		this.activeCountry = activeCountry;
	}

	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  行程天数
	 */
	@Column(name ="ACTIVES_NUM",nullable=true,length=11)
	public Integer getActivesNum() {
		return activesNum;
	}

	public void setActivesNum(Integer activesNum) {
		this.activesNum = activesNum;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  行程天数
	 */
	@Column(name ="ACTIVES_CHARACTERISTICS",nullable=true,length=255)
	public String getActivesCharacteristics() {
		return activesCharacteristics;
	}

	public void setActivesCharacteristics(String activesCharacteristics) {
		this.activesCharacteristics = activesCharacteristics;
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
