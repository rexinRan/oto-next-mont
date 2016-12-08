package com.buss.aids.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.aidcatelog.entity.DxsAidCatelogEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_aids
 * @author onlineGenerator
 * @date 2016-08-24 13:53:42
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_aids", schema = "")
@SuppressWarnings("serial")
public class DxsAidsEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**扶贫分类id*/
	@Excel(name="扶贫分类id")
	private String aidCatelogId;
	/**扶贫标题*/
	@Excel(name="扶贫标题")
	private String aidTitle;
	/**编辑人*/
	@Excel(name="编辑人")
	private String aidEditor;
	/**发布时间*/
	@Excel(name="发布时间",format = "yyyy-MM-dd")
	private Date aidPublishTime;
	/**扶贫简介*/
	@Excel(name="扶贫简介")
	private String aidIntroduction;
	/**扶贫内容*/
	@Excel(name="扶贫内容")
	private String aidContents;
	/**编号*/
	@Excel(name="编号")
	private Integer aidSort;
	/**扶贫视频*/
	@Excel(name="扶贫视频")
	private String aidVideoUrl;
	/**扶贫缩略图*/
	@Excel(name="扶贫缩略图")
	private String aidImgUrl;
	/**扶贫发布年份*/
	@Excel(name="扶贫发布年份")
	private String aidPublishYear;
	/**扶贫发布月份*/
	@Excel(name="扶贫发布月份")
	private String aidPublicMonth;
	/**所属地区*/
	@Excel(name="所属地区")
	private String aidRegion;
	/**是否特别关注*/
	@Excel(name="是否特别关注")
	private Integer isSpecial;
	/**新闻来源*/
	@Excel(name="新闻来源")
	private String aidFrom;
	/**外部标记*/
	@Excel(name="外部标记")
	private Integer outSign;
	/**createTime*/
	@Excel(name="createTime",format = "yyyy-MM-dd")
	private Date createTime;
	/**updateTime*/
	@Excel(name="updateTime",format = "yyyy-MM-dd")
	private Date updateTime;
	/**删除标志*/
	@Excel(name="删除标志")
	private Integer isDelete;

	//luyueyeu
	private DxsAidCatelogEntity aidCatelogEntity;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "AID_CATELOG_ID", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)
	public DxsAidCatelogEntity getAidCatelogEntity() {
		return aidCatelogEntity;
	}

	public void setAidCatelogEntity(DxsAidCatelogEntity aidCatelogEntity) {
		this.aidCatelogEntity = aidCatelogEntity;
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
	 *@return: java.lang.String  扶贫分类id
	 */
	@Column(name ="AID_CATELOG_ID",nullable=true,length=32)
	public String getAidCatelogId(){
		return this.aidCatelogId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  扶贫分类id
	 */
	public void setAidCatelogId(String aidCatelogId){
		this.aidCatelogId = aidCatelogId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  扶贫标题
	 */
	@Column(name ="AID_TITLE",nullable=true,length=200)
	public String getAidTitle(){
		return this.aidTitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  扶贫标题
	 */
	public void setAidTitle(String aidTitle){
		this.aidTitle = aidTitle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编辑人
	 */
	@Column(name ="AID_EDITOR",nullable=true,length=100)
	public String getAidEditor(){
		return this.aidEditor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  编辑人
	 */
	public void setAidEditor(String aidEditor){
		this.aidEditor = aidEditor;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  发布时间
	 */
	@Column(name ="AID_PUBLISH_TIME",nullable=true)
	public Date getAidPublishTime(){
		return this.aidPublishTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  发布时间
	 */
	public void setAidPublishTime(Date aidPublishTime){
		this.aidPublishTime = aidPublishTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  扶贫简介
	 */
	@Column(name ="AID_INTRODUCTION",nullable=true,length=255)
	public String getAidIntroduction(){
		return this.aidIntroduction;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  扶贫简介
	 */
	public void setAidIntroduction(String aidIntroduction){
		this.aidIntroduction = aidIntroduction;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  扶贫内容
	 */
	@Column(name ="AID_CONTENTS",nullable=true,length=16777215)
	public String getAidContents(){
		return this.aidContents;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  扶贫内容
	 */
	public void setAidContents(String aidContents){
		this.aidContents = aidContents;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  编号
	 */
	@Column(name ="AID_SORT",nullable=true,length=10)
	public Integer getAidSort(){
		return this.aidSort;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  编号
	 */
	public void setAidSort(Integer aidSort){
		this.aidSort = aidSort;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  扶贫视频
	 */
	@Column(name ="AID_VIDEO_URL",nullable=true,length=200)
	public String getAidVideoUrl(){
		return this.aidVideoUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  扶贫视频
	 */
	public void setAidVideoUrl(String aidVideoUrl){
		this.aidVideoUrl = aidVideoUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  扶贫缩略图
	 */
	@Column(name ="AID_IMG_URL",nullable=true,length=200)
	public String getAidImgUrl(){
		return this.aidImgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  扶贫缩略图
	 */
	public void setAidImgUrl(String aidImgUrl){
		this.aidImgUrl = aidImgUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  扶贫发布年份
	 */
	@Column(name ="AID_PUBLISH_YEAR",nullable=true,length=100)
	public String getAidPublishYear(){
		return this.aidPublishYear;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  扶贫发布年份
	 */
	public void setAidPublishYear(String aidPublishYear){
		this.aidPublishYear = aidPublishYear;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  扶贫发布月份
	 */
	@Column(name ="AID_PUBLIC_MONTH",nullable=true,length=50)
	public String getAidPublicMonth(){
		return this.aidPublicMonth;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  扶贫发布月份
	 */
	public void setAidPublicMonth(String aidPublicMonth){
		this.aidPublicMonth = aidPublicMonth;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属地区
	 */
	@Column(name ="AID_REGION",nullable=true,length=50)
	public String getAidRegion(){
		return this.aidRegion;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属地区
	 */
	public void setAidRegion(String aidRegion){
		this.aidRegion = aidRegion;
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
	 *@return: java.lang.String  新闻来源
	 */
	@Column(name ="AID_FROM",nullable=true,length=100)
	public String getAidFrom(){
		return this.aidFrom;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  新闻来源
	 */
	public void setAidFrom(String aidFrom){
		this.aidFrom = aidFrom;
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
