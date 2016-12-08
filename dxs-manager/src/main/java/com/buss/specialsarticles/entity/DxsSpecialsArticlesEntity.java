package com.buss.specialsarticles.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.specials.controller.DxsSpecialsController;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_specials_articles
 * @author onlineGenerator
 * @date 2016-08-16 14:14:36
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_specials_articles", schema = "")
@SuppressWarnings("serial")
public class DxsSpecialsArticlesEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**专项就业id*/
	@Excel(name="专项就业id")
	private String specialId;
	/**标题*/
	@Excel(name="标题")
	private String title;
	/**作者*/
	@Excel(name="作者")
	private String autor;
	/**来源*/
	@Excel(name="来源")
	private String sources;
	/**发表时间*/
	@Excel(name="发表时间",format = "yyyy-MM-dd")
	private Date publishTime;
	/**区域*/
	@Excel(name="区域")
	private String addressArea;
	/**年份*/
	@Excel(name="年份")
	private String timeYear;
	/**略略图*/
	@Excel(name="略略图")
	private String imgUrl;
	/**视频地址*/
	@Excel(name="视频地址")
	private String videoUrl;
	/**简介*/
	@Excel(name="简介")
	private String summary;
	/**内容*/
	@Excel(name="内容")
	private String content;
	/**分类*/
	@Excel(name="分类")
	private Integer cateLog;
	/**编号*/
	@Excel(name="编号")
	private Integer sort;
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
	 *@return: java.lang.String  专项就业id
	 */
	@Column(name ="SPECIAL_ID",nullable=true,length=32)
	public String getSpecialId(){
		return this.specialId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专项就业id
	 */
	public void setSpecialId(String specialId){
		this.specialId = specialId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  标题
	 */
	@Column(name ="TITLE",nullable=true,length=100)
	public String getTitle(){
		return this.title;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  标题
	 */
	public void setTitle(String title){
		this.title = title;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  作者
	 */
	@Column(name ="AUTOR",nullable=true,length=100)
	public String getAutor(){
		return this.autor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  作者
	 */
	public void setAutor(String autor){
		this.autor = autor;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  来源
	 */
	@Column(name ="SOURCES",nullable=true,length=255)
	public String getSources(){
		return this.sources;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  来源
	 */
	public void setSources(String sources){
		this.sources = sources;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  发表时间
	 */
	@Column(name ="PUBLISH_TIME",nullable=true)
	public Date getPublishTime(){
		return this.publishTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  发表时间
	 */
	public void setPublishTime(Date publishTime){
		this.publishTime = publishTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  区域
	 */
	@Column(name ="ADDRESS_AREA",nullable=true,length=50)
	public String getAddressArea(){
		return this.addressArea;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  区域
	 */
	public void setAddressArea(String addressArea){
		this.addressArea = addressArea;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  年份
	 */
	@Column(name ="TIME_YEAR",nullable=true,length=50)
	public String getTimeYear(){
		return this.timeYear;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  年份
	 */
	public void setTimeYear(String timeYear){
		this.timeYear = timeYear;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  略略图
	 */
	@Column(name ="IMG_URL",nullable=true,length=255)
	public String getImgUrl(){
		return this.imgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  略略图
	 */
	public void setImgUrl(String imgUrl){
		this.imgUrl = imgUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  视频地址
	 */
	@Column(name ="VIDEO_URL",nullable=true,length=255)
	public String getVideoUrl(){
		return this.videoUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  视频地址
	 */
	public void setVideoUrl(String videoUrl){
		this.videoUrl = videoUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  简介
	 */
	@Column(name ="SUMMARY",nullable=true,length=255)
	public String getSummary(){
		return this.summary;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  简介
	 */
	public void setSummary(String summary){
		this.summary = summary;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  内容
	 */
	@Column(name ="CONTENT",nullable=true,length=16777215)
	public String getContent(){
		return this.content;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  内容
	 */
	public void setContent(String content){
		this.content = content;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  分类
	 */
	@Column(name ="CATE_LOG",nullable=true,length=10)
	public Integer getCateLog(){
		return this.cateLog;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  分类
	 */
	public void setCateLog(Integer cateLog){
		this.cateLog = cateLog;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  编号
	 */
	@Column(name ="SORT",nullable=true,length=10)
	public Integer getSort(){
		return this.sort;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  编号
	 */
	public void setSort(Integer sort){
		this.sort = sort;
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

	//大权添加与dxs_specials表的多对一关联
//	private DxsSpecialsController dxsSpecialsController;
//
//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "special_id", insertable=false, updatable = false)
//	@NotFound(action= NotFoundAction.IGNORE)
//	public DxsSpecialsController getDxsSpecialsController() {
//		return dxsSpecialsController;
//	}
//
//	public void setDxsSpecialsController(DxsSpecialsController dxsSpecialsController) {
//		this.dxsSpecialsController = dxsSpecialsController;
//	}
}
