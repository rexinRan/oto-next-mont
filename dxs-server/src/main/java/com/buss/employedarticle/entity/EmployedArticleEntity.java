package com.buss.employedarticle.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


/**   
 * @Title: Entity
 * @Description: dxs_employed_article
 * @author lu
 * @date 2016-06-03 11:27:23
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_employed_article",catalog = "dxsdb")
public class EmployedArticleEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**就业中心分类id*/

	private String emoloyedCatelogId;
	/**就业中心文章标题*/

	private String emoloyedTitle;
	/**编辑人*/

	private String emoloyedEditor;
	/**发布时间*/

	private Date emoloyedPublishTime;
	/**缩略图*/

	private String emoloyedImgurl;
	/**视频地址*/

	private String emoloyedVideoUrl;
	/**就业中心文章内容*/

	private String emoloyedContents;
	/**编号*/

	private Integer emoloyedSort;
	/**createTime*/

	private Date createTime;
	/**updateTime*/

	private Date updateTime;
	/**删除标志*/

	private Integer isDelete;
	/**文章来源*/

	private String emoloyedFrom;
	/**文章简介*/

	private String emoloyedIntroduction;
	/**外部标记*/

	private Integer outSign;
	
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
	 *@return: java.lang.String  就业中心分类id
	 */
	@Column(name ="EMOLOYED_CATELOG_ID",nullable=true,length=32)
	public String getEmoloyedCatelogId(){
		return this.emoloyedCatelogId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  就业中心分类id
	 */
	public void setEmoloyedCatelogId(String emoloyedCatelogId){
		this.emoloyedCatelogId = emoloyedCatelogId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  就业中心文章标题
	 */
	@Column(name ="EMOLOYED_TITLE",nullable=true,length=200)
	public String getEmoloyedTitle(){
		return this.emoloyedTitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  就业中心文章标题
	 */
	public void setEmoloyedTitle(String emoloyedTitle){
		this.emoloyedTitle = emoloyedTitle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编辑人
	 */
	@Column(name ="EMOLOYED_EDITOR",nullable=true,length=100)
	public String getEmoloyedEditor(){
		return this.emoloyedEditor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  编辑人
	 */
	public void setEmoloyedEditor(String emoloyedEditor){
		this.emoloyedEditor = emoloyedEditor;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  发布时间
	 */
	@Column(name ="EMOLOYED_PUBLISH_TIME",nullable=true)
	public Date getEmoloyedPublishTime(){
		return this.emoloyedPublishTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  发布时间
	 */
	public void setEmoloyedPublishTime(Date emoloyedPublishTime){
		this.emoloyedPublishTime = emoloyedPublishTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  缩略图
	 */
	@Column(name ="EMOLOYED_IMGURL",nullable=true,length=200)
	public String getEmoloyedImgurl(){
		return this.emoloyedImgurl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  缩略图
	 */
	public void setEmoloyedImgurl(String emoloyedImgurl){
		this.emoloyedImgurl = emoloyedImgurl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  视频地址
	 */
	@Column(name ="EMOLOYED_VIDEO_URL",nullable=true,length=255)
	public String getEmoloyedVideoUrl(){
		return this.emoloyedVideoUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  视频地址
	 */
	public void setEmoloyedVideoUrl(String emoloyedVideoUrl){
		this.emoloyedVideoUrl = emoloyedVideoUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  就业中心文章内容
	 */
	@Column(name ="EMOLOYED_CONTENTS",nullable=true,length=255)
	public String getEmoloyedContents(){
		return this.emoloyedContents;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  就业中心文章内容
	 */
	public void setEmoloyedContents(String emoloyedContents){
		this.emoloyedContents = emoloyedContents;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  编号
	 */
	@Column(name ="EMOLOYED_SORT",nullable=true,length=10)
	public Integer getEmoloyedSort(){
		return this.emoloyedSort;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  编号
	 */
	public void setEmoloyedSort(Integer emoloyedSort){
		this.emoloyedSort = emoloyedSort;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  createTime
	 */
	@Column(name ="CREATE_TIME",nullable=true)
	public Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  createTime
	 */
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  updateTime
	 */
	@Column(name ="UPDATE_TIME",nullable=true)
	public Date getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  updateTime
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

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文章来源
	 */
	@Column(name ="EMOLOYED_FROM",nullable=true,length=100)
	public String getEmoloyedFrom(){
		return this.emoloyedFrom;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文章来源
	 */
	public void setEmoloyedFrom(String emoloyedFrom){
		this.emoloyedFrom = emoloyedFrom;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String 文章简介
	 */
	@Column(name ="EMOLOYED_INTRODUCTION",nullable=true,length=255)
	public String getEmoloyedIntroduction(){
		return this.emoloyedIntroduction;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文章简介
	 */
	public void setEmoloyedIntroduction(String emoloyedIntroduction){
		this.emoloyedIntroduction = emoloyedIntroduction;
	}

	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  外部标记
	 */
	@Column(name ="OUT_SIGN",nullable=true,length=4)
	public Integer getOutSign(){
		return this.outSign;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  外部标记
	 */
	public void setOutSign(Integer outSign){
		this.outSign = outSign;
	}
}
