package com.buss.project.bases.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: dxs_bases
 * @author onlineGenerator
 * @date 2016-07-25 14:00:38
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_bases", schema = "")
@SuppressWarnings("serial")
public class BasesEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**基地名称*/

	private String baseName;
	/**基地缩图文件*/

	private String baseImgFid;
	/**基地缩图地址*/

	private String baseImgUrl;
	/**视频文件id*/

	private String baseVideoFid;
	/**视频播放地址*/

	private String baseVideoUrl;
	/**基地简介*/

	private String baseIntroduce;
	/**主管单位*/

	private String baseUnitName;
	/**基地级别*/

	private Integer baseClass;
	/**优惠政策*/

	private String basePolicy;
	/**入驻指南*/

	private String baseGuide;
	/**详细地址*/

	private String baseAddress;
	/**服务行业*/

	private String baseIndustry;
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
	 *@return: java.lang.String  基地名称
	 */
	@Column(name ="BASE_NAME",nullable=true,length=200)
	public String getBaseName(){
		return this.baseName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  基地名称
	 */
	public void setBaseName(String baseName){
		this.baseName = baseName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  基地缩图文件
	 */
	@Column(name ="BASE_IMG_FID",nullable=true,length=255)
	public String getBaseImgFid(){
		return this.baseImgFid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  基地缩图文件
	 */
	public void setBaseImgFid(String baseImgFid){
		this.baseImgFid = baseImgFid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  基地缩图地址
	 */
	@Column(name ="BASE_IMG_URL",nullable=true,length=255)
	public String getBaseImgUrl(){
		return this.baseImgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  基地缩图地址
	 */
	public void setBaseImgUrl(String baseImgUrl){
		this.baseImgUrl = baseImgUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  视频文件id
	 */
	@Column(name ="BASE_VIDEO_FID",nullable=true,length=32)
	public String getBaseVideoFid(){
		return this.baseVideoFid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  视频文件id
	 */
	public void setBaseVideoFid(String baseVideoFid){
		this.baseVideoFid = baseVideoFid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  视频播放地址
	 */
	@Column(name ="BASE_VIDEO_URL",nullable=true,length=255)
	public String getBaseVideoUrl(){
		return this.baseVideoUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  视频播放地址
	 */
	public void setBaseVideoUrl(String baseVideoUrl){
		this.baseVideoUrl = baseVideoUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  基地简介
	 */
	@Column(name ="BASE_INTRODUCE",nullable=true,length=16777215)
	public String getBaseIntroduce(){
		return this.baseIntroduce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  基地简介
	 */
	public void setBaseIntroduce(String baseIntroduce){
		this.baseIntroduce = baseIntroduce;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主管单位
	 */
	@Column(name ="BASE_UNIT_NAME",nullable=true,length=200)
	public String getBaseUnitName(){
		return this.baseUnitName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主管单位
	 */
	public void setBaseUnitName(String baseUnitName){
		this.baseUnitName = baseUnitName;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  基地级别
	 */
	@Column(name ="BASE_CLASS",nullable=true,length=10)
	public Integer getBaseClass(){
		return this.baseClass;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  基地级别
	 */
	public void setBaseClass(Integer baseClass){
		this.baseClass = baseClass;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  优惠政策
	 */
	@Column(name ="BASE_POLICY",nullable=true,length=16777215)
	public String getBasePolicy(){
		return this.basePolicy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  优惠政策
	 */
	public void setBasePolicy(String basePolicy){
		this.basePolicy = basePolicy;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  入驻指南
	 */
	@Column(name ="BASE_GUIDE",nullable=true,length=16777215)
	public String getBaseGuide(){
		return this.baseGuide;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  入驻指南
	 */
	public void setBaseGuide(String baseGuide){
		this.baseGuide = baseGuide;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  详细地址
	 */
	@Column(name ="BASE_ADDRESS",nullable=true,length=255)
	public String getBaseAddress(){
		return this.baseAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  详细地址
	 */
	public void setBaseAddress(String baseAddress){
		this.baseAddress = baseAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  服务行业
	 */
	@Column(name ="BASE_INDUSTRY",nullable=true,length=255)
	public String getBaseIndustry(){
		return this.baseIndustry;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  服务行业
	 */
	public void setBaseIndustry(String baseIndustry){
		this.baseIndustry = baseIndustry;
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
