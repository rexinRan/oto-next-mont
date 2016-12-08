package com.buss.specialsarticles.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

/**   
 * @Title: Entity
 * @Description: dxs_specials_articles
 * @author onlineGenerator
 * @date 2016-08-14 15:54:26
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_specials_articles", schema = "")
@SuppressWarnings("serial")
public class SpecialsArticlesEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**专项就业id*/
	private java.lang.String specialId;
	/**标题*/
	private java.lang.String title;
	/**作者*/
	private java.lang.String autor;
	/**来源*/
	private java.lang.String sources;
	/**发表时间*/
	private java.util.Date publishTime;
	/**区域*/
	private java.lang.String addressArea;
	/**年份*/
	private java.lang.String timeYear;
	/**略略图*/
	private java.lang.String imgUrl;
	/**视频地址*/
	private java.lang.String videoUrl;
	/**简介*/
	private java.lang.String summary;
	/**内容*/
	private java.lang.String content;
	/**分类*/
	private java.lang.Integer cateLog;
	/**编号*/
	private java.lang.Integer sort;
	/**创建时间*/
	private java.util.Date createTime;
	/**更新时间*/
	private java.util.Date updateTime;
	/**删除标志*/
	private java.lang.Integer isDelete;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=32)
	public java.lang.String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  专项就业id
	 */
	@Column(name ="SPECIAL_ID",nullable=true,length=32)
	public java.lang.String getSpecialId(){
		return this.specialId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专项就业id
	 */
	public void setSpecialId(java.lang.String specialId){
		this.specialId = specialId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  标题
	 */
	@Column(name ="TITLE",nullable=true,length=100)
	public java.lang.String getTitle(){
		return this.title;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  标题
	 */
	public void setTitle(java.lang.String title){
		this.title = title;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  作者
	 */
	@Column(name ="AUTOR",nullable=true,length=100)
	public java.lang.String getAutor(){
		return this.autor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  作者
	 */
	public void setAutor(java.lang.String autor){
		this.autor = autor;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  来源
	 */
	@Column(name ="SOURCES",nullable=true,length=255)
	public java.lang.String getSources(){
		return this.sources;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  来源
	 */
	public void setSources(java.lang.String sources){
		this.sources = sources;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  发表时间
	 */
	@Column(name ="PUBLISH_TIME",nullable=true)
	public java.util.Date getPublishTime(){
		return this.publishTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  发表时间
	 */
	public void setPublishTime(java.util.Date publishTime){
		this.publishTime = publishTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  区域
	 */
	@Column(name ="ADDRESS_AREA",nullable=true,length=50)
	public java.lang.String getAddressArea(){
		return this.addressArea;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  区域
	 */
	public void setAddressArea(java.lang.String addressArea){
		this.addressArea = addressArea;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  年份
	 */
	@Column(name ="TIME_YEAR",nullable=true,length=50)
	public java.lang.String getTimeYear(){
		return this.timeYear;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  年份
	 */
	public void setTimeYear(java.lang.String timeYear){
		this.timeYear = timeYear;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  略略图
	 */
	@Column(name ="IMG_URL",nullable=true,length=255)
	public java.lang.String getImgUrl(){
		return this.imgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  略略图
	 */
	public void setImgUrl(java.lang.String imgUrl){
		this.imgUrl = imgUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  视频地址
	 */
	@Column(name ="VIDEO_URL",nullable=true,length=255)
	public java.lang.String getVideoUrl(){
		return this.videoUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  视频地址
	 */
	public void setVideoUrl(java.lang.String videoUrl){
		this.videoUrl = videoUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  简介
	 */
	@Column(name ="SUMMARY",nullable=true,length=255)
	public java.lang.String getSummary(){
		return this.summary;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  简介
	 */
	public void setSummary(java.lang.String summary){
		this.summary = summary;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  内容
	 */
	@Column(name ="CONTENT",nullable=true,length=16777215)
	public java.lang.String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内容
	 */
	public void setContent(java.lang.String content){
		this.content = content;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  分类
	 */
	@Column(name ="CATE_LOG",nullable=true,length=10)
	public java.lang.Integer getCateLog(){
		return this.cateLog;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  分类
	 */
	public void setCateLog(java.lang.Integer cateLog){
		this.cateLog = cateLog;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  编号
	 */
	@Column(name ="SORT",nullable=true,length=10)
	public java.lang.Integer getSort(){
		return this.sort;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  编号
	 */
	public void setSort(java.lang.Integer sort){
		this.sort = sort;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATE_TIME",nullable=true)
	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新时间
	 */
	@Column(name ="UPDATE_TIME",nullable=true)
	public java.util.Date getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新时间
	 */
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime = updateTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  删除标志
	 */
	@Column(name ="IS_DELETE",nullable=true,length=3)
	public java.lang.Integer getIsDelete(){
		return this.isDelete;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  删除标志
	 */
	public void setIsDelete(java.lang.Integer isDelete){
		this.isDelete = isDelete;
	}
}
