package com.buss.careerguidance.entity;

import com.buss.careerguidancecatalog.entity.CareerGuidanceCatalogEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: dxs_career_guidance
 * @author onlineGenerator
 * @date 2016-08-24 13:53:07
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_career_guidance", schema = "")
@SuppressWarnings("serial")
public class CareerGuidanceEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**职场引导分类id*/

	private String cgCatelogId;
	/**职场引导标题*/

	private String cgTitle;
	/**编辑人*/

	private String cgEditor;
	/**发布时间*/

	private Date cgPublishTime;
	/**职场引导简介*/

	private String cgIntroduction;
	/**职场引导内容*/

	private String cgContents;
	/**编号*/

	private Integer cgSort;
	/**职场引导视频*/

	private String cgVideoUrl;
	/**职场引导缩略图*/

	private String cgImgUrl;
	/**职场引导发布年份*/

	private String cgPublishYear;
	/**职场引导发布月份*/

	private String cgPublicMonth;
	/**是否特别关注*/

	private Integer isSpecial;
	/**职场引导来源*/

	private String cgFrom;
	/**外部标记*/

	private Integer outSign;
	/**createTime*/

	private Date createTime;
	/**updateTime*/

	private Date updateTime;
	/**删除标志*/

	private Integer isDelete;

	/**分类实体*/
	private CareerGuidanceCatalogEntity catalogEntity;

	@ManyToOne()
	@JoinColumn(name="CG_CATELOG_ID",insertable = false, updatable = false)
	public CareerGuidanceCatalogEntity getCatalogEntity() {
		return catalogEntity;
	}

	public void setCatalogEntity(CareerGuidanceCatalogEntity catalogEntity) {
		this.catalogEntity = catalogEntity;
	}

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
	 *@return: java.lang.String  职场引导分类id
	 */
	@Column(name ="CG_CATELOG_ID",nullable=true,length=32)
	public String getCgCatelogId(){
		return this.cgCatelogId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职场引导分类id
	 */
	public void setCgCatelogId(String cgCatelogId){
		this.cgCatelogId = cgCatelogId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职场引导标题
	 */
	@Column(name ="CG_TITLE",nullable=true,length=200)
	public String getCgTitle(){
		return this.cgTitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职场引导标题
	 */
	public void setCgTitle(String cgTitle){
		this.cgTitle = cgTitle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编辑人
	 */
	@Column(name ="CG_EDITOR",nullable=true,length=100)
	public String getCgEditor(){
		return this.cgEditor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  编辑人
	 */
	public void setCgEditor(String cgEditor){
		this.cgEditor = cgEditor;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  发布时间
	 */
	@Column(name ="CG_PUBLISH_TIME",nullable=true)
	public Date getCgPublishTime(){
		return this.cgPublishTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  发布时间
	 */
	public void setCgPublishTime(Date cgPublishTime){
		this.cgPublishTime = cgPublishTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职场引导简介
	 */
	@Column(name ="CG_INTRODUCTION",nullable=true,length=255)
	public String getCgIntroduction(){
		return this.cgIntroduction;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职场引导简介
	 */
	public void setCgIntroduction(String cgIntroduction){
		this.cgIntroduction = cgIntroduction;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职场引导内容
	 */
	@Column(name ="CG_CONTENTS",nullable=true,length=16777215)
	public String getCgContents(){
		return this.cgContents;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职场引导内容
	 */
	public void setCgContents(String cgContents){
		this.cgContents = cgContents;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  编号
	 */
	@Column(name ="CG_SORT",nullable=true,length=10)
	public Integer getCgSort(){
		return this.cgSort;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  编号
	 */
	public void setCgSort(Integer cgSort){
		this.cgSort = cgSort;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职场引导视频
	 */
	@Column(name ="CG_VIDEO_URL",nullable=true,length=200)
	public String getCgVideoUrl(){
		return this.cgVideoUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职场引导视频
	 */
	public void setCgVideoUrl(String cgVideoUrl){
		this.cgVideoUrl = cgVideoUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职场引导缩略图
	 */
	@Column(name ="CG_IMG_URL",nullable=true,length=200)
	public String getCgImgUrl(){
		return this.cgImgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职场引导缩略图
	 */
	public void setCgImgUrl(String cgImgUrl){
		this.cgImgUrl = cgImgUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职场引导发布年份
	 */
	@Column(name ="CG_PUBLISH_YEAR",nullable=true,length=100)
	public String getCgPublishYear(){
		return this.cgPublishYear;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职场引导发布年份
	 */
	public void setCgPublishYear(String cgPublishYear){
		this.cgPublishYear = cgPublishYear;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职场引导发布月份
	 */
	@Column(name ="CG_PUBLIC_MONTH",nullable=true,length=50)
	public String getCgPublicMonth(){
		return this.cgPublicMonth;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职场引导发布月份
	 */
	public void setCgPublicMonth(String cgPublicMonth){
		this.cgPublicMonth = cgPublicMonth;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否特别关注
	 */
	@Column(name ="IS_SPECIAL",nullable=true,length=10)
	public Integer getIsSpecial(){
		return this.isSpecial;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否特别关注
	 */
	public void setIsSpecial(Integer isSpecial){
		this.isSpecial = isSpecial;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职场引导来源
	 */
	@Column(name ="CG_FROM",nullable=true,length=100)
	public String getCgFrom(){
		return this.cgFrom;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职场引导来源
	 */
	public void setCgFrom(String cgFrom){
		this.cgFrom = cgFrom;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  外部标记
	 */
	@Column(name ="OUT_SIGN",nullable=true,length=10)
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
}
