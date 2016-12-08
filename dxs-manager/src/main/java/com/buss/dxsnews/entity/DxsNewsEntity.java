package com.buss.dxsnews.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.dxsnewscatelog.entity.DxsNewsCatelogEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_news
 * @author onlineGenerator
 * @date 2016-05-30 17:05:49
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_news", schema = "")
@SuppressWarnings("serial")
public class DxsNewsEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**新闻分类id*/
	@Excel(name="新闻分类id")
	private String newCatelogId;
	/**新闻标题*/
	@Excel(name="新闻标题")
	private String newTitle;
	/**编辑人*/
	@Excel(name="编辑人")
	private String newEditor;
	/**来源*/
	@Excel(name="来源")
	private String newFrom;
	/**发布时间*/
	@Excel(name="发布时间",format = "yyyy-MM-dd")
	private Date newPublishTime;
	/**新闻发布年份*/
	@Excel(name="新闻发布年份")
	private java.lang.String newPublishYear;
	/**新闻简介*/
	@Excel(name="新闻简介")
	private java.lang.String newIntroduction;
	/**新闻内容*/
	@Excel(name="新闻内容")
	private String newContents;
	/**编号*/
	@Excel(name="编号")
	private Integer newSort;
	/**新闻视频*/
	@Excel(name="新闻视频")
	private java.lang.String newVideoUrl;
	/**新闻缩略图*/
	@Excel(name="新闻缩略图")
	private java.lang.String newImgUrl;
	/**是否特别关注*/
	@Excel(name="是否特别关注")
	private java.lang.Integer isSpecial;
	/**外部标记*/
	@Excel(name="外部标记")
	private java.lang.Integer outSign;
	/**createTime*/
	@Excel(name="createTime",format = "yyyy-MM-dd")
	private Date createTime;
	/**updateTime*/
	@Excel(name="updateTime",format = "yyyy-MM-dd")
	private Date updateTime;
	/**删除标志*/
	@Excel(name="删除标志")
	private Integer isDelete;

	// 王腾云
	// 新闻分类的名称
	private DxsNewsCatelogEntity dxsNewsCatelogEntity;


	
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
	 *@param: java.lang.String  编辑人
	 */
	public void setNewEditor(String newEditor){
		this.newEditor = newEditor;
	}

	@Column(name ="NEW_FROM",nullable=true,length=100)
	public String getNewFrom() {
		return newFrom;
	}

	public void setNewFrom(String newFrom) {
		this.newFrom = newFrom;
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
	 *@return: java.lang.String  新闻发布年份
	 */
	@Column(name ="NEW_PUBLISH_YEAR",nullable=true,length=100)
	public java.lang.String getNewPublishYear(){
		return this.newPublishYear;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  新闻发布年份
	 */
	public void setNewPublishYear(java.lang.String newPublishYear){
		this.newPublishYear = newPublishYear;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  新闻简介
	 */
	@Column(name ="NEW_INTRODUCTION",nullable=true,length=255)
	public java.lang.String getNewIntroduction(){
		return this.newIntroduction;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  新闻简介
	 */
	public void setNewIntroduction(java.lang.String newIntroduction){
		this.newIntroduction = newIntroduction;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  新闻内容
	 */
	@Column(name ="NEW_CONTENTS",nullable=true)
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
	@Column(name ="NEW_SORT",nullable=true,length=10)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  新闻视频
	 */
	@Column(name ="NEW_VIDEO_URL",nullable=true,length=200)
	public java.lang.String getNewVideoUrl(){
		return this.newVideoUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  新闻视频
	 */
	public void setNewVideoUrl(java.lang.String newVideoUrl){
		this.newVideoUrl = newVideoUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  新闻缩略图
	 */
	@Column(name ="NEW_IMG_URL",nullable=true,length=200)
	public java.lang.String getNewImgUrl(){
		return this.newImgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  新闻缩略图
	 */
	public void setNewImgUrl(java.lang.String newImgUrl){
		this.newImgUrl = newImgUrl;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否特别关注
	 */
	@Column(name ="IS_SPECIAL",nullable=true,length=10)
	public java.lang.Integer getIsSpecial(){
		return this.isSpecial;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否特别关注
	 */
	public void setIsSpecial(java.lang.Integer isSpecial){
		this.isSpecial = isSpecial;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  外部标记
	 */
	@Column(name ="OUT_SIGN",nullable=true,length=10)
	public java.lang.Integer getOutSign(){
		return this.outSign;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  外部标记
	 */
	public void setOutSign(java.lang.Integer outSign){
		this.outSign = outSign;
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
	 *@param: java.lang.Integer  删除标志, referencedColumnName = "newCatelogId"
	 */
	public void setIsDelete(Integer isDelete){
		this.isDelete = isDelete;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "new_Catelog_Id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)
	public DxsNewsCatelogEntity getDxsNewsCatelogEntity() {
		return dxsNewsCatelogEntity;
	}

	public void setDxsNewsCatelogEntity(DxsNewsCatelogEntity dxsNewsCatelogEntity) {
		this.dxsNewsCatelogEntity = dxsNewsCatelogEntity;
	}
}
