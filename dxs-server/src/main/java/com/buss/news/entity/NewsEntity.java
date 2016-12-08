package com.buss.news.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


/**   
 * @Title: Entity
 * @Description: dxs_news
 * @author lu
 * @date 2016-06-01 13:38:23
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_news",catalog = "dxsdb")
public class NewsEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**新闻分类id*/

	private String newCatelogId;
	/**新闻标题*/

	private String newTitle;
	/**编辑人*/

	private String newEditor;
	/**新闻发布年份*/

	private String newPublishYear;
	/**发布时间*/

	private Date newPublishTime;
	/**新闻简介*/

	private String newIntroduction;
	/**新闻内容*/

	private String newContents;
	/**编号*/

	private Integer newSort;
	/**外部标记*/

	private Integer outSign;
	/**是否为特别关注*/

	private Integer isSpecial;
	/**新闻视频*/

	private String newVideoUrl;
	/**新闻图片*/

	private String newImgUrl;
	/**新闻来源*/

	private String newFrom;
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
	 *@return: java.lang.String  新闻分类id
	 */
	@Column(name ="NEW_CATELOG_ID",nullable=true,length=32)
	public String getNewCatelogId(){
		return this.newCatelogId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  新闻分类id
	 */
	public void setNewCatelogId(String newCatelogId){
		this.newCatelogId = newCatelogId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  新闻来源
	 */
	@Column(name ="NEW_FROM",nullable=true,length=32)
	public String getNewFrom(){
		return this.newFrom;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  新闻来源
	 */
	public void setNewFrom(String newFrom){
		this.newFrom = newFrom;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  新闻标题
	 */
	@Column(name ="NEW_TITLE",nullable=true,length=200)
	public String getNewTitle(){
		return this.newTitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  新闻标题
	 */
	public void setNewTitle(String newTitle){
		this.newTitle = newTitle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编辑人
	 */
	@Column(name ="NEW_EDITOR",nullable=true,length=100)
	public String getNewEditor(){
		return this.newEditor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  新闻发布年份
	 */
	public void setNewPublishYear(String newPublishYear){
		this.newPublishYear = newPublishYear;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  新闻发布年份
	 */
	@Column(name ="NEW_PUBLISH_YEAR",nullable=true,length=100)
	public String getNewPublishYear(){
		return this.newPublishYear;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  编辑人
	 */
	public void setNewEditor(String newEditor){
		this.newEditor = newEditor;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  发布时间
	 */
	@Column(name ="NEW_PUBLISH_TIME",nullable=true)
	public Date getNewPublishTime(){
		return this.newPublishTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  发布时间
	 */
	public void setNewPublishTime(Date newPublishTime){
		this.newPublishTime = newPublishTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  新闻简介
	 */
	@Column(name ="NEW_INTRODUCTION",nullable=true,length=255)
	public String getNewIntroduction(){
		return this.newIntroduction;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  新闻简介
	 */
	public void setNewIntroduction(String newIntroduction){
		this.newIntroduction = newIntroduction;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  新闻内容
	 */
	@Column(name ="NEW_CONTENTS",nullable=true,length=255)
	public String getNewContents(){
		return this.newContents;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  新闻内容
	 */
	public void setNewContents(String newContents){
		this.newContents = newContents;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  编号
	 */
	@Column(name ="NEW_SORT",nullable=true,length=11)
	public Integer getNewSort(){
		return this.newSort;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  编号
	 */
	public void setNewSort(Integer newSort){
		this.newSort = newSort;
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
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  新闻视频
	 */
	@Column(name ="NEW_VIDEO_URL",nullable=true,length=200)
	public String getNewVideoUrl(){
		return this.newVideoUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  新闻视频
	 */
	public void setNewVideoUrl(String newVideoUrl){
		this.newVideoUrl = newVideoUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  新闻图片
	 */
	@Column(name ="NEW_IMG_URL",nullable=true,length=200)
	public String getNewImgUrl(){
		return this.newImgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  新闻图片
	 */
	public void setNewImgUrl(String newImgUrl){
		this.newImgUrl = newImgUrl;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否是特别关注
	 */
	@Column(name ="IS_SPECIAL",nullable=true,length=2)
	public Integer getIsSpecial(){
		return this.isSpecial;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否是特别关注
	 */
	public void setIsSpecial(Integer isSpecial){
		this.isSpecial = isSpecial;
	}
}
