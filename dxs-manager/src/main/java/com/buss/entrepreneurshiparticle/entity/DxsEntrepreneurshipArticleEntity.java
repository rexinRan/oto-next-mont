package com.buss.entrepreneurshiparticle.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.entrepreneurshipcatalog.entity.DxsEntrepreneurshipCatalogEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_entrepreneurship_article
 * @author onlineGenerator
 * @date 2016-06-06 14:25:34
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_entrepreneurship_article", schema = "")
@SuppressWarnings("serial")
public class DxsEntrepreneurshipArticleEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**创业中心分类id*/
	@Excel(name="创业中心分类id")
	private String entrepreneurshipCatelogId;
	/**缩略图*/
	@Excel(name="缩略图")
	private String entrepreneurshipImgurl;
	/**创业中心文章标题*/
	@Excel(name="创业中心文章标题")
	private String entrepreneurshipTitle;
	/**文章简介*/
	@Excel(name="文章简介")
	private java.lang.String entrepreneurshipIntroduction;
	/**编辑人*/
	@Excel(name="编辑人")
	private String entrepreneurshipEditor;
	/**发布时间*/
	@Excel(name="发布时间",format = "yyyy-MM-dd")
	private Date entrepreneurshipPublishTime;
	/**创业中心文章内容*/
	@Excel(name="创业中心文章内容")
	private String entrepreneurshipContents;
	/**编号*/
	@Excel(name="编号")
	private Integer entrepreneurshipSort;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private Date createTime;
	/**修改时间*/
	@Excel(name="修改时间",format = "yyyy-MM-dd")
	private Date updateTime;
	/**删除标志*/
	@Excel(name="删除标志")
	private Integer isDelete;

	private DxsEntrepreneurshipCatalogEntity dxsEntrepreneurshipCatalogEntity;
	
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
	 *@return: java.lang.String  创业中心分类id
	 */
	@Column(name ="ENTREPRENEURSHIP_CATELOG_ID",nullable=true,length=32)
	public String getEntrepreneurshipCatelogId(){
		return this.entrepreneurshipCatelogId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创业中心分类id
	 */
	public void setEntrepreneurshipCatelogId(String entrepreneurshipCatelogId){
		this.entrepreneurshipCatelogId = entrepreneurshipCatelogId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  缩略图
	 */
	@Column(name ="ENTREPRENEURSHIP_IMGURL",nullable=true,length=200)
	public String getEntrepreneurshipImgurl(){
		return this.entrepreneurshipImgurl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  缩略图
	 */
	public void setEntrepreneurshipImgurl(String entrepreneurshipImgurl){
		this.entrepreneurshipImgurl = entrepreneurshipImgurl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创业中心文章标题
	 */
	@Column(name ="ENTREPRENEURSHIP_TITLE",nullable=true,length=200)
	public String getEntrepreneurshipTitle(){
		return this.entrepreneurshipTitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创业中心文章标题
	 */
	public void setEntrepreneurshipTitle(String entrepreneurshipTitle){
		this.entrepreneurshipTitle = entrepreneurshipTitle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文章简介
	 */
	@Column(name ="ENTREPRENEURSHIP_INTRODUCTION",nullable=true,length=255)
	public java.lang.String getEntrepreneurshipIntroduction(){
		return this.entrepreneurshipIntroduction;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文章简介
	 */
	public void setEntrepreneurshipIntroduction(java.lang.String entrepreneurshipIntroduction){
		this.entrepreneurshipIntroduction = entrepreneurshipIntroduction;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编辑人
	 */
	@Column(name ="ENTREPRENEURSHIP_EDITOR",nullable=true,length=100)
	public String getEntrepreneurshipEditor(){
		return this.entrepreneurshipEditor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  编辑人
	 */
	public void setEntrepreneurshipEditor(String entrepreneurshipEditor){
		this.entrepreneurshipEditor = entrepreneurshipEditor;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  发布时间
	 */
	@Column(name ="ENTREPRENEURSHIP_PUBLISH_TIME",nullable=true)
	public Date getEntrepreneurshipPublishTime(){
		return this.entrepreneurshipPublishTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  发布时间
	 */
	public void setEntrepreneurshipPublishTime(Date entrepreneurshipPublishTime){
		this.entrepreneurshipPublishTime = entrepreneurshipPublishTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创业中心文章内容
	 */
	@Column(name ="ENTREPRENEURSHIP_CONTENTS",nullable=true)
	public String getEntrepreneurshipContents(){
		return this.entrepreneurshipContents;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创业中心文章内容
	 */
	public void setEntrepreneurshipContents(String entrepreneurshipContents){
		this.entrepreneurshipContents = entrepreneurshipContents;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  编号
	 */
	@Column(name ="ENTREPRENEURSHIP_SORT",nullable=true,length=10)
	public Integer getEntrepreneurshipSort(){
		return this.entrepreneurshipSort;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  编号
	 */
	public void setEntrepreneurshipSort(Integer entrepreneurshipSort){
		this.entrepreneurshipSort = entrepreneurshipSort;
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
	 *@return: java.util.Date  修改时间
	 */
	@Column(name ="UPDATE_TIME",nullable=true)
	public Date getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  修改时间
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
	@JoinColumn(name = "Entrepreneurship_catelog_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)

	public DxsEntrepreneurshipCatalogEntity getDxsEntrepreneurshipCatalogEntity() {
		return dxsEntrepreneurshipCatalogEntity;
	}

	public void setDxsEntrepreneurshipCatalogEntity(DxsEntrepreneurshipCatalogEntity dxsEntrepreneurshipCatalogEntity) {
		this.dxsEntrepreneurshipCatalogEntity = dxsEntrepreneurshipCatalogEntity;
	}
}
