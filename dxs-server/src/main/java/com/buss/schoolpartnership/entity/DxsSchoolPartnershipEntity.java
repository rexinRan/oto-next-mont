package com.buss.schoolpartnership.entity;

import org.hibernate.annotations.GenericGenerator;
import org.jweb.core.bean.SearchForm;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: dxs_school_partnership
 * @author onlineGenerator
 * @date 2016-07-14 16:06:06
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_school_partnership", schema = "")
public class DxsSchoolPartnershipEntity  implements java.io.Serializable{
	/**主键*/
	private String id;
	/**用户id(预留)*/
	private String userId;
	/**学校logo*/
	private String logoImg;
	/**大缩略图*/
	private  String logoBigImg;
	/**学院名称*/
	private String schoolName;
	/**学校简介*/
	private String schoolIntroduce;
	/**校园风景*/
	private String schoolScenery;
	/**视频播放地址*/
	private String schoolVideoUrl;
	/**特色展示*/
	private String schoolDisplay;
	/**校址*/
	private String schoolRealAddress;
	/**网址*/
	private String schoolNetAddress;
	/**联系电话*/
	private String schoolPhone;
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
	 *@return: java.lang.String  用户id(预留)
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户id(预留)
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学校logo
	 */
	@Column(name ="LOGO_IMG",nullable=true,length=255)
	public String getLogoImg(){
		return this.logoImg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学校logo
	 */
	public void setLogoImg(String logoImg){
		this.logoImg = logoImg;
	}

	@Column(name ="logo_big_img",nullable=true,length=200)
	public String getLogoBigImg() {
		return logoBigImg;
	}

	public void setLogoBigImg(String logoBigImg) {
		this.logoBigImg = logoBigImg;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学院名称
	 */

	@Column(name ="SCHOOL_NAME",nullable=true,length=200)
	public String getSchoolName(){
		return this.schoolName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学院名称
	 */
	public void setSchoolName(String schoolName){
		this.schoolName = schoolName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学校简介
	 */
	@Column(name ="SCHOOL_INTRODUCE",nullable=true)
	public String getSchoolIntroduce(){
		return this.schoolIntroduce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学校简介
	 */
	public void setSchoolIntroduce(String schoolIntroduce){
		this.schoolIntroduce = schoolIntroduce;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  校园风景
	 */
	@Column(name ="SCHOOL_SCENERY",nullable=true)
	public String getSchoolScenery(){
		return this.schoolScenery;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  校园风景
	 */
	public void setSchoolScenery(String schoolScenery){
		this.schoolScenery = schoolScenery;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  视频播放地址
	 */
	@Column(name ="SCHOOL_VIDEO_URL",nullable=true,length=255)
	public java.lang.String getSchoolVideoUrl(){
		return this.schoolVideoUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  视频播放地址
	 */
	public void setSchoolVideoUrl(java.lang.String schoolVideoUrl){
		this.schoolVideoUrl = schoolVideoUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  特色展示
	 */
	@Column(name ="SCHOOL_DISPLAY",nullable=true)
	public String getSchoolDisplay(){
		return this.schoolDisplay;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  特色展示
	 */
	public void setSchoolDisplay(String schoolDisplay){
		this.schoolDisplay = schoolDisplay;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  校址
	 */
	@Column(name ="SCHOOL_REAL_ADDRESS",nullable=true,length=200)
	public String getSchoolRealAddress(){
		return this.schoolRealAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  校址
	 */
	public void setSchoolRealAddress(String schoolRealAddress){
		this.schoolRealAddress = schoolRealAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  网址
	 */
	@Column(name ="SCHOOL_NET_ADDRESS",nullable=true,length=255)
	public String getSchoolNetAddress(){
		return this.schoolNetAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  网址
	 */
	public void setSchoolNetAddress(String schoolNetAddress){
		this.schoolNetAddress = schoolNetAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系电话
	 */
	@Column(name ="SCHOOL_PHONE",nullable=true,length=50)
	public String getSchoolPhone(){
		return this.schoolPhone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系电话
	 */
	public void setSchoolPhone(String schoolPhone){
		this.schoolPhone = schoolPhone;
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
