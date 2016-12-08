package com.buss.complanysponsor.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: dxs_complany_sponsor
 * @author onlineGenerator
 * @date 2016-07-13 08:54:35
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_complany_sponsor", schema = "")
@SuppressWarnings("serial")
public class DxsComplanySponsorEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**申请人的ID*/
	private java.lang.String userId;
	/**企业log*/
	private java.lang.String logAddress;
	/**公司名称*/
	private java.lang.String complanyName;
	/**公司网址*/
	private java.lang.String complanyWebAddress;
	/**所属行业*/
	private java.lang.String complanyField;
	/**办公地点*/
	private java.lang.String complanyRealAddress;
	/**微信公众号*/
	private java.lang.String complanyWeixin;
	/**公司简介*/
	private java.lang.String complanyIntroduce;
	/**公司规模*/
	private java.lang.String complanyNum;
	/**营业执照图*/
	private java.lang.String complanyLicenseImg;
	/**营业执照编号*/
	private java.lang.Integer complanyLicenseNum;
	/**身份证号*/
	private java.lang.String complanyIdcard;
	/**身份证正面文件id*/
	private java.lang.String complanyIdcardImg1Fid;
	/**身份证正面URL*/
	private java.lang.String complanyIdcardImg1Url;
	/**身份证反面文件id*/
	private java.lang.String complanyIdcardImg2Fid;
	/**身份证反面URL*/
	private java.lang.String complanyIdcardImg2Url;
	/**赞助活动*/
	private java.lang.String complanyActive;
	/**联系人姓名*/
	private java.lang.String contactsName;
	/**联系人职位*/
	private java.lang.String contentsJob;
	/**单位介绍函*/
	private java.lang.String contentsLetter;
	/**联系人邮箱*/
	private java.lang.String contactsEmail;
	/**联系人单位座机*/
	private java.lang.String contentsTel;
	/**联系人手机号*/
	private java.lang.String contentIphone;
	/**联系人QQ*/
	private java.lang.String contentQq;
	/**申请类型*/
	private java.lang.String applyType;
	/**是否通过*/
	private java.lang.String isTrue;
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
	 *@return: java.lang.String  申请人的ID
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public java.lang.String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请人的ID
	 */
	public void setUserId(java.lang.String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  企业log
	 */
	@Column(name ="LOG_ADDRESS",nullable=true,length=200)
	public java.lang.String getLogAddress(){
		return this.logAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  企业log
	 */
	public void setLogAddress(java.lang.String logAddress){
		this.logAddress = logAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司名称
	 */
	@Column(name ="COMPLANY_NAME",nullable=true,length=100)
	public java.lang.String getComplanyName(){
		return this.complanyName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司名称
	 */
	public void setComplanyName(java.lang.String complanyName){
		this.complanyName = complanyName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司网址
	 */
	@Column(name ="COMPLANY_WEB_ADDRESS",nullable=true,length=200)
	public java.lang.String getComplanyWebAddress(){
		return this.complanyWebAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司网址
	 */
	public void setComplanyWebAddress(java.lang.String complanyWebAddress){
		this.complanyWebAddress = complanyWebAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属行业
	 */
	@Column(name ="COMPLANY_FIELD",nullable=true,length=100)
	public java.lang.String getComplanyField(){
		return this.complanyField;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属行业
	 */
	public void setComplanyField(java.lang.String complanyField){
		this.complanyField = complanyField;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  办公地点
	 */
	@Column(name ="COMPLANY_REAL_ADDRESS",nullable=true,length=200)
	public java.lang.String getComplanyRealAddress(){
		return this.complanyRealAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  办公地点
	 */
	public void setComplanyRealAddress(java.lang.String complanyRealAddress){
		this.complanyRealAddress = complanyRealAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  微信公众号
	 */
	@Column(name ="COMPLANY_WEIXIN",nullable=true,length=50)
	public java.lang.String getComplanyWeixin(){
		return this.complanyWeixin;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  微信公众号
	 */
	public void setComplanyWeixin(java.lang.String complanyWeixin){
		this.complanyWeixin = complanyWeixin;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司简介
	 */
	@Column(name ="COMPLANY_INTRODUCE",nullable=true,length=16777215)
	public java.lang.String getComplanyIntroduce(){
		return this.complanyIntroduce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司简介
	 */
	public void setComplanyIntroduce(java.lang.String complanyIntroduce){
		this.complanyIntroduce = complanyIntroduce;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司规模
	 */
	@Column(name ="COMPLANY_NUM",nullable=true,length=10)
	public java.lang.String getComplanyNum(){
		return this.complanyNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司规模
	 */
	public void setComplanyNum(java.lang.String complanyNum){
		this.complanyNum = complanyNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  营业执照图
	 */
	@Column(name ="COMPLANY_LICENSE_IMG",nullable=true,length=200)
	public java.lang.String getComplanyLicenseImg(){
		return this.complanyLicenseImg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  营业执照图
	 */
	public void setComplanyLicenseImg(java.lang.String complanyLicenseImg){
		this.complanyLicenseImg = complanyLicenseImg;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  营业执照编号
	 */
	@Column(name ="COMPLANY_LICENSE_NUM",nullable=true,length=10)
	public java.lang.Integer getComplanyLicenseNum(){
		return this.complanyLicenseNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  营业执照编号
	 */
	public void setComplanyLicenseNum(java.lang.Integer complanyLicenseNum){
		this.complanyLicenseNum = complanyLicenseNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号
	 */
	@Column(name ="COMPLANY_IDCARD",nullable=true,length=200)
	public java.lang.String getComplanyIdcard(){
		return this.complanyIdcard;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号
	 */
	public void setComplanyIdcard(java.lang.String complanyIdcard){
		this.complanyIdcard = complanyIdcard;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证正面文件id
	 */
	@Column(name ="COMPLANY_IDCARD_IMG1_FID",nullable=true,length=32)
	public java.lang.String getComplanyIdcardImg1Fid(){
		return this.complanyIdcardImg1Fid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证正面文件id
	 */
	public void setComplanyIdcardImg1Fid(java.lang.String complanyIdcardImg1Fid){
		this.complanyIdcardImg1Fid = complanyIdcardImg1Fid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证正面URL
	 */
	@Column(name ="COMPLANY_IDCARD_IMG1_URL",nullable=true,length=255)
	public java.lang.String getComplanyIdcardImg1Url(){
		return this.complanyIdcardImg1Url;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证正面URL
	 */
	public void setComplanyIdcardImg1Url(java.lang.String complanyIdcardImg1Url){
		this.complanyIdcardImg1Url = complanyIdcardImg1Url;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证反面文件id
	 */
	@Column(name ="COMPLANY_IDCARD_IMG2_FID",nullable=true,length=32)
	public java.lang.String getComplanyIdcardImg2Fid(){
		return this.complanyIdcardImg2Fid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证反面文件id
	 */
	public void setComplanyIdcardImg2Fid(java.lang.String complanyIdcardImg2Fid){
		this.complanyIdcardImg2Fid = complanyIdcardImg2Fid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证反面URL
	 */
	@Column(name ="COMPLANY_IDCARD_IMG2_URL",nullable=true,length=255)
	public java.lang.String getComplanyIdcardImg2Url(){
		return this.complanyIdcardImg2Url;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证反面URL
	 */
	public void setComplanyIdcardImg2Url(java.lang.String complanyIdcardImg2Url){
		this.complanyIdcardImg2Url = complanyIdcardImg2Url;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  赞助活动
	 */
	@Column(name ="COMPLANY_ACTIVE",nullable=true,length=200)
	public java.lang.String getComplanyActive(){
		return this.complanyActive;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  赞助活动
	 */
	public void setComplanyActive(java.lang.String complanyActive){
		this.complanyActive = complanyActive;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人姓名
	 */
	@Column(name ="CONTACTS_NAME",nullable=true,length=200)
	public java.lang.String getContactsName(){
		return this.contactsName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人姓名
	 */
	public void setContactsName(java.lang.String contactsName){
		this.contactsName = contactsName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人职位
	 */
	@Column(name ="CONTENTS_JOB",nullable=true,length=200)
	public java.lang.String getContentsJob(){
		return this.contentsJob;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人职位
	 */
	public void setContentsJob(java.lang.String contentsJob){
		this.contentsJob = contentsJob;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位介绍函
	 */
	@Column(name ="CONTENTS_LETTER",nullable=true,length=200)
	public java.lang.String getContentsLetter(){
		return this.contentsLetter;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位介绍函
	 */
	public void setContentsLetter(java.lang.String contentsLetter){
		this.contentsLetter = contentsLetter;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人邮箱
	 */
	@Column(name ="CONTACTS_EMAIL",nullable=true,length=100)
	public java.lang.String getContactsEmail(){
		return this.contactsEmail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人邮箱
	 */
	public void setContactsEmail(java.lang.String contactsEmail){
		this.contactsEmail = contactsEmail;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人单位座机
	 */
	@Column(name ="CONTENTS_TEL",nullable=true,length=50)
	public java.lang.String getContentsTel(){
		return this.contentsTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人单位座机
	 */
	public void setContentsTel(java.lang.String contentsTel){
		this.contentsTel = contentsTel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人手机号
	 */
	@Column(name ="CONTENT_IPHONE",nullable=true,length=50)
	public java.lang.String getContentIphone(){
		return this.contentIphone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人手机号
	 */
	public void setContentIphone(java.lang.String contentIphone){
		this.contentIphone = contentIphone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人QQ
	 */
	@Column(name ="CONTENT_QQ",nullable=true,length=255)
	public java.lang.String getContentQq(){
		return this.contentQq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人QQ
	 */
	public void setContentQq(java.lang.String contentQq){
		this.contentQq = contentQq;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  申请类型
	 */
	@Column(name ="APPLY_TYPE",nullable=true,length=2)
	public java.lang.String getApplyType(){
		return this.applyType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请类型
	 */
	public void setApplyType(java.lang.String applyType){
		this.applyType = applyType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否通过
	 */
	@Column(name ="IS_TRUE",nullable=true,length=2)
	public java.lang.String getIsTrue(){
		return this.isTrue;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否通过
	 */
	public void setIsTrue(java.lang.String isTrue){
		this.isTrue = isTrue;
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
