package com.buss.lectures.entity;

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
import org.jweb.core.bean.annotation.Mapping;

import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: dxs_lectures
 * @author onlineGenerator
 * @date 2016-08-22 09:49:54
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_lectures", schema = "")
@SuppressWarnings("serial")
public class LecturesEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**活动id*/
	private java.lang.String acitveId;
	/**名家/企业家的id*/
	private java.lang.String lpId;
	/**主题*/
	private java.lang.String lectureTitle;
	/**学校名称*/
	private java.lang.String schoolName;
	/**所在站名*/
	private java.lang.String lectureAddressShort;
	/**演讲地址*/
	private java.lang.String lectureAddress;
	/**演讲时间*/
	private java.util.Date lectureTime;
	/**主题内容简介*/
	private java.lang.String lectureContentSummary;
	/**图片地址*/
	private java.lang.String lectureContentImgs;
	/**主题内容详解*/
	private java.lang.String lectureContent;
	/**外部标记*/
	private java.lang.String outSign;
	/**所属场次*/
	private java.lang.String lgId;
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
	@Column(name ="ACITVE_ID",nullable=true,length=32)
	public java.lang.String getAcitveId(){
		return this.acitveId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动id
	 */
	public void setAcitveId(java.lang.String acitveId){
		this.acitveId = acitveId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  名家/企业家的id
	 */
	@Column(name ="LP_ID",nullable=true,length=32)
	public java.lang.String getLpId(){
		return this.lpId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  名家/企业家的id
	 */
	public void setLpId(java.lang.String lpId){
		this.lpId = lpId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主题
	 */
	@Column(name ="LECTURE_TITLE",nullable=true,length=255)
	public java.lang.String getLectureTitle(){
		return this.lectureTitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主题
	 */
	public void setLectureTitle(java.lang.String lectureTitle){
		this.lectureTitle = lectureTitle;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学校名称
	 */
	@Column(name ="SCHOOL_NAME",nullable=true,length=255)
	public String getSchoolName() {
		return schoolName;
	}

	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所在站名
	 */
	@Column(name ="LECTURE_ADDRESS_SHORT",nullable=true,length=50)
	public java.lang.String getLectureAddressShort(){
		return this.lectureAddressShort;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所在站名
	 */
	public void setLectureAddressShort(java.lang.String lectureAddressShort){
		this.lectureAddressShort = lectureAddressShort;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  演讲地址
	 */
	@Column(name ="LECTURE_ADDRESS",nullable=true,length=255)
	public java.lang.String getLectureAddress(){
		return this.lectureAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  演讲地址
	 */
	public void setLectureAddress(java.lang.String lectureAddress){
		this.lectureAddress = lectureAddress;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  演讲时间
	 */
	@Column(name ="LECTURE_TIME",nullable=true)
	public java.util.Date getLectureTime(){
		return this.lectureTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  演讲时间
	 */
	public void setLectureTime(java.util.Date lectureTime){
		this.lectureTime = lectureTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主题内容简介
	 */
	@Column(name ="LECTURE_CONTENT_SUMMARY",nullable=true,length=255)
	public java.lang.String getLectureContentSummary(){
		return this.lectureContentSummary;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主题内容简介
	 */
	public void setLectureContentSummary(java.lang.String lectureContentSummary){
		this.lectureContentSummary = lectureContentSummary;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片地址
	 */
	@Column(name ="LECTURE_CONTENT_IMGS",nullable=true,length=1000)
	public java.lang.String getLectureContentImgs(){
		return this.lectureContentImgs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片地址
	 */
	public void setLectureContentImgs(java.lang.String lectureContentImgs){
		this.lectureContentImgs = lectureContentImgs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主题内容详解
	 */
	@Column(name ="LECTURE_CONTENT",nullable=true,length=16777215)
	public java.lang.String getLectureContent(){
		return this.lectureContent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主题内容详解
	 */
	public void setLectureContent(java.lang.String lectureContent){
		this.lectureContent = lectureContent;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  外部标记
	 */
	@Column(name ="OUT_SIGN",nullable=true,length=50)
	public String getOutSign() {
		return outSign;
	}

	public void setOutSign(String outSign) {
		this.outSign = outSign;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属场次
	 */
	@Column(name ="LG_ID",nullable=true,length=32)
	public java.lang.String getLgId(){
		return this.lgId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属场次
	 */
	public void setLgId(java.lang.String lgId){
		this.lgId = lgId;
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
