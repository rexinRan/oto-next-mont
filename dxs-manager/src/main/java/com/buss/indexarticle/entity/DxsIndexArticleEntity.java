package com.buss.indexarticle.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.indexcatelog.entity.DxsIndexCatelogEntity;
import org.hibernate.annotations.GenericGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_index_article
 * @author onlineGenerator
 * @date 2016-07-12 16:38:13
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_index_article", schema = "")
@SuppressWarnings("serial")
public class DxsIndexArticleEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**首页分类id*/
	@Excel(name="首页分类id")
	private String indexCatelogId;
	/**文章标题*/
	@Excel(name="文章标题")
	private String articleTitle;
	/**文章编辑人*/
	@Excel(name="文章编辑人")
	private String articleEditor;
	/**文章发布时间*/
	@Excel(name="文章发布时间",format = "yyyy-MM-dd")
	private Date articlePublishTime;
	/**文章简介*/
	@Excel(name="文章简介")
	private String articleIntroduction;
	/**文章内容*/
	@Excel(name="文章内容")
	private String articleContents;
	/**文章排序*/
	@Excel(name="文章排序")
	private Integer articleSort;
	/**文章缩略图*/
	@Excel(name="文章缩略图")
	private String articleImgUrl;
	/**文章视频*/
	@Excel(name="文章视频")
	private String articleVideoUrl;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private Date createTime;
	/**更新时间*/
	@Excel(name="更新时间",format = "yyyy-MM-dd")
	private Date updateTime;
	/**删除标志*/
	@Excel(name="删除标志")
	private Integer isDelete;

	private DxsIndexCatelogEntity dxsIndexCatelogEntity;
	
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
	 *@return: java.lang.String  首页分类id
	 */
	@Column(name ="INDEX_CATELOG_ID",nullable=true,length=32)
	public String getIndexCatelogId(){
		return this.indexCatelogId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  首页分类id
	 */
	public void setIndexCatelogId(String indexCatelogId){
		this.indexCatelogId = indexCatelogId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文章标题
	 */
	@Column(name ="ARTICLE_TITLE",nullable=true,length=200)
	public String getArticleTitle(){
		return this.articleTitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文章标题
	 */
	public void setArticleTitle(String articleTitle){
		this.articleTitle = articleTitle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文章编辑人
	 */
	@Column(name ="ARTICLE_EDITOR",nullable=true,length=100)
	public String getArticleEditor(){
		return this.articleEditor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文章编辑人
	 */
	public void setArticleEditor(String articleEditor){
		this.articleEditor = articleEditor;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  文章发布时间
	 */
	@Column(name ="ARTICLE_PUBLISH_TIME",nullable=true)
	public Date getArticlePublishTime(){
		return this.articlePublishTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  文章发布时间
	 */
	public void setArticlePublishTime(Date articlePublishTime){
		this.articlePublishTime = articlePublishTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文章简介
	 */
	@Column(name ="ARTICLE_INTRODUCTION",nullable=true,length=255)
	public String getArticleIntroduction(){
		return this.articleIntroduction;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文章简介
	 */
	public void setArticleIntroduction(String articleIntroduction){
		this.articleIntroduction = articleIntroduction;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  文章内容
	 */
	@Column(name ="ARTICLE_CONTENTS",nullable=true)
	public String getArticleContents(){
		return this.articleContents;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  文章内容
	 */
	public void setArticleContents(String articleContents){
		this.articleContents = articleContents;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  文章排序
	 */
	@Column(name ="ARTICLE_SORT",nullable=true,length=10)
	public Integer getArticleSort(){
		return this.articleSort;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  文章排序
	 */
	public void setArticleSort(Integer articleSort){
		this.articleSort = articleSort;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文章缩略图
	 */
	@Column(name ="ARTICLE_IMG_URL",nullable=true,length=200)
	public String getArticleImgUrl(){
		return this.articleImgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文章缩略图
	 */
	public void setArticleImgUrl(String articleImgUrl){
		this.articleImgUrl = articleImgUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文章视频
	 */
	@Column(name ="ARTICLE_VIDEO_URL",nullable=true,length=200)
	public String getArticleVideoUrl(){
		return this.articleVideoUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文章视频
	 */
	public void setArticleVideoUrl(String articleVideoUrl){
		this.articleVideoUrl = articleVideoUrl;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "index_catelog_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)
	public DxsIndexCatelogEntity getDxsIndexCatelogEntity() {
		return dxsIndexCatelogEntity;
	}

	public void setDxsIndexCatelogEntity(DxsIndexCatelogEntity dxsIndexCatelogEntity) {
		this.dxsIndexCatelogEntity = dxsIndexCatelogEntity;
	}
}
