package com.buss.complanysponsor.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.user.entity.DxsUserEntity;
import org.apache.ibatis.annotations.One;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

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
	private String id;
	/**申请人的ID*/
	@Excel(name="申请人的ID")
	private String userId;
	/**企业log*/
	@Excel(name="企业log")
	private String logAddress;
	/**公司名称*/
	@Excel(name="公司名称")
	private String complanyName;
	/**公司网址*/
	@Excel(name="公司网址")
	private String complanyWebAddress;
	/**所属行业*/
	@Excel(name="所属行业")
	private String complanyField;
	/**办公地点*/
	@Excel(name="办公地点")
	private String complanyRealAddress;
	/**微信公众号*/
	@Excel(name="微信公众号")
	private String complanyWeixin;
	/**公司简介*/
	@Excel(name="公司简介")
	private String complanyIntroduce;
	/**公司规模*/
	@Excel(name="公司规模")
	private String complanyNum;
	/**营业执照图*/
	@Excel(name="营业执照图")
	private String complanyLicenseImg;
	/**营业执照编号*/
	@Excel(name="营业执照编号")
	private Integer complanyLicenseNum;
	/**身份证号*/
	@Excel(name="身份证号")
	private String complanyIdcard;
	/**赞助活动*/
	@Excel(name="赞助活动")
	private String complanyActive;
	/**联系人姓名*/
	@Excel(name="联系人姓名")
	private String contactsName;
	/**联系人职位*/
	@Excel(name="联系人职位")
	private String contentsJob;
	/**单位介绍函*/
	@Excel(name="单位介绍函")
	private String contentsLetter;
	/**联系人邮箱*/
	@Excel(name="联系人邮箱")
	private String contactsEmail;
	/**联系人单位座机*/
	@Excel(name="联系人单位座机")
	private String contentsTel;
	/**联系人手机号*/
	@Excel(name="联系人手机号")
	private String contentIphone;
	/**联系人QQ*/
	@Excel(name="联系人QQ")
	private String contentQq;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private Date createTime;
	/**更新时间*/
	@Excel(name="更新时间",format = "yyyy-MM-dd")
	private Date updateTime;
	/**删除标志*/
	@Excel(name="删除标志")
	private Integer isDelete;

	private DxsUserEntity dxsUserEntity;
	
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
	 *@return: java.lang.String  申请人的ID
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请人的ID
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  企业log
	 */
	@Column(name ="LOG_ADDRESS",nullable=true,length=200)
	public String getLogAddress(){
		return this.logAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  企业log
	 */
	public void setLogAddress(String logAddress){
		this.logAddress = logAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司名称
	 */
	@Column(name ="COMPLANY_NAME",nullable=true,length=100)
	public String getComplanyName(){
		return this.complanyName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司名称
	 */
	public void setComplanyName(String complanyName){
		this.complanyName = complanyName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司网址
	 */
	@Column(name ="COMPLANY_WEB_ADDRESS",nullable=true,length=200)
	public String getComplanyWebAddress(){
		return this.complanyWebAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司网址
	 */
	public void setComplanyWebAddress(String complanyWebAddress){
		this.complanyWebAddress = complanyWebAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属行业
	 */
	@Column(name ="COMPLANY_FIELD",nullable=true,length=100)
	public String getComplanyField(){
		return this.complanyField;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属行业
	 */
	public void setComplanyField(String complanyField){
		this.complanyField = complanyField;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  办公地点
	 */
	@Column(name ="COMPLANY_REAL_ADDRESS",nullable=true,length=200)
	public String getComplanyRealAddress(){
		return this.complanyRealAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  办公地点
	 */
	public void setComplanyRealAddress(String complanyRealAddress){
		this.complanyRealAddress = complanyRealAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  微信公众号
	 */
	@Column(name ="COMPLANY_WEIXIN",nullable=true,length=50)
	public String getComplanyWeixin(){
		return this.complanyWeixin;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  微信公众号
	 */
	public void setComplanyWeixin(String complanyWeixin){
		this.complanyWeixin = complanyWeixin;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司简介
	 */
	@Column(name ="COMPLANY_INTRODUCE",nullable=true)
	public String getComplanyIntroduce(){
		return this.complanyIntroduce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司简介
	 */
	public void setComplanyIntroduce(String complanyIntroduce){
		this.complanyIntroduce = complanyIntroduce;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司规模
	 */
	@Column(name ="COMPLANY_NUM",nullable=true,length=10)
	public String getComplanyNum(){
		return this.complanyNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司规模
	 */
	public void setComplanyNum(String complanyNum){
		this.complanyNum = complanyNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  营业执照图
	 */
	@Column(name ="COMPLANY_LICENSE_IMG",nullable=true,length=200)
	public String getComplanyLicenseImg(){
		return this.complanyLicenseImg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  营业执照图
	 */
	public void setComplanyLicenseImg(String complanyLicenseImg){
		this.complanyLicenseImg = complanyLicenseImg;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  营业执照编号
	 */
	@Column(name ="COMPLANY_LICENSE_NUM",nullable=true,length=10)
	public Integer getComplanyLicenseNum(){
		return this.complanyLicenseNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  营业执照编号
	 */
	public void setComplanyLicenseNum(Integer complanyLicenseNum){
		this.complanyLicenseNum = complanyLicenseNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  身份证号
	 */
	@Column(name ="COMPLANY_IDCARD",nullable=true,length=200)
	public String getComplanyIdcard(){
		return this.complanyIdcard;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  身份证号
	 */
	public void setComplanyIdcard(String complanyIdcard){
		this.complanyIdcard = complanyIdcard;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  赞助活动
	 */
	@Column(name ="COMPLANY_ACTIVE",nullable=true,length=200)
	public String getComplanyActive(){
		return this.complanyActive;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  赞助活动
	 */
	public void setComplanyActive(String complanyActive){
		this.complanyActive = complanyActive;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人姓名
	 */
	@Column(name ="CONTACTS_NAME",nullable=true,length=50)
	public String getContactsName(){
		return this.contactsName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人姓名
	 */
	public void setContactsName(String contactsName){
		this.contactsName = contactsName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人职位
	 */
	@Column(name ="CONTENTS_JOB",nullable=true,length=50)
	public String getContentsJob(){
		return this.contentsJob;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人职位
	 */
	public void setContentsJob(String contentsJob){
		this.contentsJob = contentsJob;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  单位介绍函
	 */
	@Column(name ="CONTENTS_LETTER",nullable=true,length=200)
	public String getContentsLetter(){
		return this.contentsLetter;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  单位介绍函
	 */
	public void setContentsLetter(String contentsLetter){
		this.contentsLetter = contentsLetter;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人邮箱
	 */
	@Column(name ="CONTACTS_EMAIL",nullable=true,length=100)
	public String getContactsEmail(){
		return this.contactsEmail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人邮箱
	 */
	public void setContactsEmail(String contactsEmail){
		this.contactsEmail = contactsEmail;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人单位座机
	 */
	@Column(name ="CONTENTS_TEL",nullable=true,length=50)
	public String getContentsTel(){
		return this.contentsTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人单位座机
	 */
	public void setContentsTel(String contentsTel){
		this.contentsTel = contentsTel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人手机号
	 */
	@Column(name ="CONTENT_IPHONE",nullable=true,length=50)
	public String getContentIphone(){
		return this.contentIphone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人手机号
	 */
	public void setContentIphone(String contentIphone){
		this.contentIphone = contentIphone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人QQ
	 */
	@Column(name ="CONTENT_QQ",nullable=true,length=255)
	public String getContentQq(){
		return this.contentQq;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人QQ
	 */
	public void setContentQq(String contentQq){
		this.contentQq = contentQq;
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

	@OneToOne(optional = true, fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", insertable = false, updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	public DxsUserEntity getDxsUserEntity() {
		return dxsUserEntity;
	}

	public void setDxsUserEntity(DxsUserEntity dxsUserEntity) {
		this.dxsUserEntity = dxsUserEntity;
	}
}
