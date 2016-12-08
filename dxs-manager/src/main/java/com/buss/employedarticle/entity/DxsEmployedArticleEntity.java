package com.buss.employedarticle.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.employedcatalog.entity.DxsEmployedCatalogEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_employed_article
 * @author onlineGenerator
 * @date 2016-06-03 11:27:23
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_employed_article", schema = "")
@SuppressWarnings("serial")
public class DxsEmployedArticleEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**就业中心分类id*/
	@Excel(name="就业中心分类id")
	private String emoloyedCatelogId;
	/**就业中心文章标题*/
	@Excel(name="就业中心文章标题")
	private String emoloyedTitle;
	/**编辑人*/
	@Excel(name="编辑人")
	private String emoloyedEditor;
	/**发布时间*/
	@Excel(name="发布时间",format = "yyyy-MM-dd")
	private Date emoloyedPublishTime;
	/**缩略图*/
	@Excel(name="缩略图")
	private String emoloyedImgurl;
	/**视频url*/
	@Excel(name="视频url")
	private java.lang.String emoloyedVideoUrl;
	/**文章来源*/
	@Excel(name="文章来源")
	private java.lang.String emoloyedFrom;
	/**文章简介*/
	@Excel(name="文章简介")
	private java.lang.String emoloyedIntroduction;
	/**外部标记*/
	@Excel(name="外部标记")
	private java.lang.Integer outSign;
	/**就业中心文章内容*/
	@Excel(name="就业中心文章内容")
	private String emoloyedContents;
	/**编号*/
	@Excel(name="编号")
	private Integer emoloyedSort;
	/**createTime*/
	@Excel(name="createTime",format = "yyyy-MM-dd")
	private Date createTime;
	/**updateTime*/
	@Excel(name="updateTime",format = "yyyy-MM-dd")
	private Date updateTime;
	/**删除标志*/
	@Excel(name="删除标志")
	private Integer isDelete;

	private DxsEmployedCatalogEntity dxsEmployedCatalogEntity;
	
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
	 *@return: java.lang.String  视频url
	 */
	@Column(name ="EMOLOYED_VIDEO_URL",nullable=true,length=255)
	public java.lang.String getEmoloyedVideoUrl(){
		return this.emoloyedVideoUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  视频url
	 */
	public void setEmoloyedVideoUrl(java.lang.String emoloyedVideoUrl){
		this.emoloyedVideoUrl = emoloyedVideoUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文章来源
	 */
	@Column(name ="EMOLOYED_FROM",nullable=true,length=100)
	public java.lang.String getEmoloyedFrom(){
		return this.emoloyedFrom;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文章来源
	 */
	public void setEmoloyedFrom(java.lang.String emoloyedFrom){
		this.emoloyedFrom = emoloyedFrom;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文章简介
	 */
	@Column(name ="EMOLOYED_INTRODUCTION",nullable=true,length=255)
	public java.lang.String getEmoloyedIntroduction(){
		return this.emoloyedIntroduction;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文章简介
	 */
	public void setEmoloyedIntroduction(java.lang.String emoloyedIntroduction){
		this.emoloyedIntroduction = emoloyedIntroduction;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  就业中心文章内容
	 */
	@Column(name ="EMOLOYED_CONTENTS",nullable=true)
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "emoloyed_catelog_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)

	public DxsEmployedCatalogEntity getDxsEmployedCatalogEntity() {
		return dxsEmployedCatalogEntity;
	}

	public void setDxsEmployedCatalogEntity(DxsEmployedCatalogEntity dxsEmployedCatalogEntity) {
		this.dxsEmployedCatalogEntity = dxsEmployedCatalogEntity;
	}
}
