package com.buss.activesdetailsdays.entity;

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
 * @Description: dxs_actives_details_days
 * @author onlineGenerator
 * @date 2016-08-04 09:16:13
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_actives_details_days", schema = "")
@SuppressWarnings("serial")
public class ActivesDetailsDaysEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**活动id*/
	private java.lang.String activeId;
	/**天数*/
	private java.lang.Integer daysName;
	/**地名*/
	private java.lang.String addressName;
	/**图片1主键*/
	private java.lang.String fid1;
	/**图片1地址*/
	private java.lang.String fid1ImgUrl;
	/**图片2主键*/
	private java.lang.String fid2;
	/**图片2地址*/
	private java.lang.String fid2ImgUrl;
	/**图片3主键*/
	private java.lang.String fid3;
	/**图片3地址*/
	private java.lang.String fidImgUrl;
	/**内容*/
	private java.lang.String content;
	/**住宿地*/
	private java.lang.String boarders;
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
	 *@return: java.lang.String  活动id
	 */
	@Column(name ="ACTIVE_ID",nullable=true,length=32)
	public java.lang.String getActiveId(){
		return this.activeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动id
	 */
	public void setActiveId(java.lang.String activeId){
		this.activeId = activeId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  天数
	 */
	@Column(name ="DAYS_NAME",nullable=true,length=10)
	public java.lang.Integer getDaysName(){
		return this.daysName;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  天数
	 */
	public void setDaysName(java.lang.Integer daysName){
		this.daysName = daysName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  地名
	 */
	@Column(name ="ADDRESS_NAME",nullable=true,length=255)
	public java.lang.String getAddressName(){
		return this.addressName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  地名
	 */
	public void setAddressName(java.lang.String addressName){
		this.addressName = addressName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片1主键
	 */
	@Column(name ="FID1",nullable=true,length=32)
	public java.lang.String getFid1(){
		return this.fid1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片1主键
	 */
	public void setFid1(java.lang.String fid1){
		this.fid1 = fid1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片1地址
	 */
	@Column(name ="FID1_IMG_URL",nullable=true,length=255)
	public java.lang.String getFid1ImgUrl(){
		return this.fid1ImgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片1地址
	 */
	public void setFid1ImgUrl(java.lang.String fid1ImgUrl){
		this.fid1ImgUrl = fid1ImgUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片2主键
	 */
	@Column(name ="FID2",nullable=true,length=32)
	public java.lang.String getFid2(){
		return this.fid2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片2主键
	 */
	public void setFid2(java.lang.String fid2){
		this.fid2 = fid2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片2地址
	 */
	@Column(name ="FID2_IMG_URL",nullable=true,length=255)
	public java.lang.String getFid2ImgUrl(){
		return this.fid2ImgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片2地址
	 */
	public void setFid2ImgUrl(java.lang.String fid2ImgUrl){
		this.fid2ImgUrl = fid2ImgUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片3主键
	 */
	@Column(name ="FID3",nullable=true,length=32)
	public java.lang.String getFid3(){
		return this.fid3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片3主键
	 */
	public void setFid3(java.lang.String fid3){
		this.fid3 = fid3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片3地址
	 */
	@Column(name ="FID_IMG_URL",nullable=true,length=255)
	public java.lang.String getFidImgUrl(){
		return this.fidImgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片3地址
	 */
	public void setFidImgUrl(java.lang.String fidImgUrl){
		this.fidImgUrl = fidImgUrl;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  内容
	 */
	@Column(name ="CONTENT",nullable=true)
	public java.lang.String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  内容
	 */
	public void setContent(java.lang.String content){
		this.content = content;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  住宿地
	 */
	@Column(name ="BOARDERS",nullable=true,length=50)
	public java.lang.String getBoarders(){
		return this.boarders;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  住宿地
	 */
	public void setBoarders(java.lang.String boarders){
		this.boarders = boarders;
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
