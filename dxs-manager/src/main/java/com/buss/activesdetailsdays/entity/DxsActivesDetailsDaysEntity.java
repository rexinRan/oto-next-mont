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
import org.jeecgframework.poi.excel.annotation.Excel;

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
public class DxsActivesDetailsDaysEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**活动id*/
	@Excel(name="活动id")
	private String activeId;
	/**天数*/
	@Excel(name="天数")
	private Integer daysName;
	/**地名*/
	@Excel(name="地名")
	private String addressName;
	/**图片1主键*/
	@Excel(name="图片1主键")
	private String fid1;
	/**图片1地址*/
	@Excel(name="图片1地址")
	private String fid1ImgUrl;
	/**图片2主键*/
	@Excel(name="图片2主键")
	private String fid2;
	/**图片2地址*/
	@Excel(name="图片2地址")
	private String fid2ImgUrl;
	/**图片3主键*/
	@Excel(name="图片3主键")
	private String fid3;
	/**图片3地址*/
	@Excel(name="图片3地址")
	private String fidImgUrl;
	/**内容*/
	@Excel(name="内容")
	private String content;
	/**住宿地*/
	@Excel(name="住宿地")
	private String boarders;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private Date createTime;
	/**更新时间*/
	@Excel(name="更新时间",format = "yyyy-MM-dd")
	private Date updateTime;
	/**删除标志*/
	@Excel(name="删除标志")
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
	 *@return: java.lang.String  活动id
	 */
	@Column(name ="ACTIVE_ID",nullable=true,length=32)
	public String getActiveId(){
		return this.activeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动id
	 */
	public void setActiveId(String activeId){
		this.activeId = activeId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  天数
	 */
	@Column(name ="DAYS_NAME",nullable=true,length=10)
	public Integer getDaysName(){
		return this.daysName;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  天数
	 */
	public void setDaysName(Integer daysName){
		this.daysName = daysName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  地名
	 */
	@Column(name ="ADDRESS_NAME",nullable=true,length=255)
	public String getAddressName(){
		return this.addressName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  地名
	 */
	public void setAddressName(String addressName){
		this.addressName = addressName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片1主键
	 */
	@Column(name ="FID1",nullable=true,length=32)
	public String getFid1(){
		return this.fid1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片1主键
	 */
	public void setFid1(String fid1){
		this.fid1 = fid1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片1地址
	 */
	@Column(name ="FID1_IMG_URL",nullable=true,length=255)
	public String getFid1ImgUrl(){
		return this.fid1ImgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片1地址
	 */
	public void setFid1ImgUrl(String fid1ImgUrl){
		this.fid1ImgUrl = fid1ImgUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片2主键
	 */
	@Column(name ="FID2",nullable=true,length=32)
	public String getFid2(){
		return this.fid2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片2主键
	 */
	public void setFid2(String fid2){
		this.fid2 = fid2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片2地址
	 */
	@Column(name ="FID2_IMG_URL",nullable=true,length=255)
	public String getFid2ImgUrl(){
		return this.fid2ImgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片2地址
	 */
	public void setFid2ImgUrl(String fid2ImgUrl){
		this.fid2ImgUrl = fid2ImgUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片3主键
	 */
	@Column(name ="FID3",nullable=true,length=32)
	public String getFid3(){
		return this.fid3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片3主键
	 */
	public void setFid3(String fid3){
		this.fid3 = fid3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片3地址
	 */
	@Column(name ="FID_IMG_URL",nullable=true,length=255)
	public String getFidImgUrl(){
		return this.fidImgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片3地址
	 */
	public void setFidImgUrl(String fidImgUrl){
		this.fidImgUrl = fidImgUrl;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  内容
	 */
	@Column(name ="CONTENT",nullable=true)
	public String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  内容
	 */
	public void setContent(String content){
		this.content = content;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  住宿地
	 */
	@Column(name ="BOARDERS",nullable=true,length=50)
	public String getBoarders(){
		return this.boarders;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  住宿地
	 */
	public void setBoarders(String boarders){
		this.boarders = boarders;
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
}
