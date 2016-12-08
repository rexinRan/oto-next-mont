package com.buss.activesnotes.entity;

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
 * @Description: dxs_actives_notes
 * @author onlineGenerator
 * @date 2016-07-29 09:16:25
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_actives_notes", schema = "")
@SuppressWarnings("serial")
public class ActivesNotesEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**用户id*/
	private java.lang.String userId;
	/**缩略图URL*/
	private java.lang.String imgUrl;
	/**视频URL*/
	private java.lang.String videoUrl;
	/**标题*/
	private java.lang.String title;
	/**作者*/
	private java.lang.String editor;
	/**发表时间*/
	private java.util.Date publishTime;
	/**摘要*/
	private java.lang.String summary;
	/**内容*/
	private java.lang.String contents;
	/**发表年份*/
	private java.lang.String publishYear;
	/**国别*/
	private java.lang.String countrys;
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
	 *@return: java.lang.String  用户id
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public java.lang.String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户id
	 */
	public void setUserId(java.lang.String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  缩略图URL
	 */
	@Column(name ="IMG_URL",nullable=true,length=255)
	public java.lang.String getImgUrl(){
		return this.imgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  缩略图URL
	 */
	public void setImgUrl(java.lang.String imgUrl){
		this.imgUrl = imgUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  视频URL
	 */
	@Column(name ="VIDEO_URL",nullable=true,length=255)
	public java.lang.String getVideoUrl(){
		return this.videoUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  视频URL
	 */
	public void setVideoUrl(java.lang.String videoUrl){
		this.videoUrl = videoUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  标题
	 */
	@Column(name ="TITLE",nullable=true,length=200)
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
	@Column(name ="EDITOR",nullable=true,length=20)
	public java.lang.String getEditor(){
		return this.editor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  作者
	 */
	public void setEditor(java.lang.String editor){
		this.editor = editor;
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
	 *@return: java.lang.String  摘要
	 */
	@Column(name ="SUMMARY",nullable=true,length=255)
	public java.lang.String getSummary(){
		return this.summary;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  摘要
	 */
	public void setSummary(java.lang.String summary){
		this.summary = summary;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  内容
	 */
	@Column(name ="CONTENTS",nullable=true,length=16777215)
	public java.lang.String getContents(){
		return this.contents;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内容
	 */
	public void setContents(java.lang.String contents){
		this.contents = contents;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发表年份
	 */
	@Column(name ="PUBLISH_YEAR",nullable=true,length=50)
	public java.lang.String getPublishYear(){
		return this.publishYear;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发表年份
	 */
	public void setPublishYear(java.lang.String publishYear){
		this.publishYear = publishYear;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  国别
	 */
	@Column(name ="COUNTRYS",nullable=true,length=10)
	public java.lang.String getCountrys(){
		return this.countrys;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  国别
	 */
	public void setCountrys(java.lang.String countrys){
		this.countrys = countrys;
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
