package com.buss.lectures.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.actives.entity.DxsActivesEntity;
import com.buss.lecturespersion.entity.DxsLecturesPersionEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_lectures
 * @author dq
 * @date 2016-08-22 09:49:54
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_lectures", schema = "")
@SuppressWarnings("serial")
public class DxsLecturesEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**活动id*/
	@Excel(name="活动id")
	private String acitveId;
	/**名家/企业家的id*/
	@Excel(name="名家/企业家的id")
	private String lpId;
	/**主题*/
	@Excel(name="主题")
	private String lectureTitle;
	/**所在站名*/
	@Excel(name="所在站名")
	private String lectureAddressShort;
	/**演讲地址*/
	@Excel(name="演讲地址")
	private String lectureAddress;
	/**演讲时间*/
	@Excel(name="演讲时间",format = "yyyy-MM-dd")
	private Date lectureTime;
	/**学校名称*/
	@Excel(name="学校名称")
	private java.lang.String schoolName;
	/**主题内容简介*/
	@Excel(name="主题内容简介")
	private String lectureContentSummary;
	/**图片地址*/
	@Excel(name="图片地址")
	private String lectureContentImgs;
	/**主题内容详解*/
	@Excel(name="主题内容详解")
	private String lectureContent;
	/**外部标记*/
	@Excel(name="外部标记")
	private java.lang.String outSign;
	/**所属场次*/
	@Excel(name="所属场次")
	private String lgId;
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
	@Column(name ="ACITVE_ID",nullable=true,length=32)
	public String getAcitveId(){
		return this.acitveId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动id
	 */
	public void setAcitveId(String acitveId){
		this.acitveId = acitveId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  名家/企业家的id
	 */
	@Column(name ="LP_ID",nullable=true,length=32)
	public String getLpId(){
		return this.lpId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  名家/企业家的id
	 */
	public void setLpId(String lpId){
		this.lpId = lpId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主题
	 */
	@Column(name ="LECTURE_TITLE",nullable=true,length=255)
	public String getLectureTitle(){
		return this.lectureTitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主题
	 */
	public void setLectureTitle(String lectureTitle){
		this.lectureTitle = lectureTitle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所在站名
	 */
	@Column(name ="LECTURE_ADDRESS_SHORT",nullable=true,length=50)
	public String getLectureAddressShort(){
		return this.lectureAddressShort;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所在站名
	 */
	public void setLectureAddressShort(String lectureAddressShort){
		this.lectureAddressShort = lectureAddressShort;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  演讲地址
	 */
	@Column(name ="LECTURE_ADDRESS",nullable=true,length=255)
	public String getLectureAddress(){
		return this.lectureAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  演讲地址
	 */
	public void setLectureAddress(String lectureAddress){
		this.lectureAddress = lectureAddress;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  演讲时间
	 */
	@Column(name ="LECTURE_TIME",nullable=true)
	public Date getLectureTime(){
		return this.lectureTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  演讲时间
	 */
	public void setLectureTime(Date lectureTime){
		this.lectureTime = lectureTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学校名称
	 */
	@Column(name ="SCHOOL_NAME",nullable=true,length=255)
	public java.lang.String getSchoolName(){
		return this.schoolName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学校名称
	 */
	public void setSchoolName(java.lang.String schoolName){
		this.schoolName = schoolName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主题内容简介
	 */
	@Column(name ="LECTURE_CONTENT_SUMMARY",nullable=true,length=255)
	public String getLectureContentSummary(){
		return this.lectureContentSummary;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主题内容简介
	 */
	public void setLectureContentSummary(String lectureContentSummary){
		this.lectureContentSummary = lectureContentSummary;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片地址
	 */
	@Column(name ="LECTURE_CONTENT_IMGS",nullable=true,length=1000)
	public String getLectureContentImgs(){
		return this.lectureContentImgs;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片地址
	 */
	public void setLectureContentImgs(String lectureContentImgs){
		this.lectureContentImgs = lectureContentImgs;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主题内容详解
	 */
	@Column(name ="LECTURE_CONTENT",nullable=true,length=16777215)
	public String getLectureContent(){
		return this.lectureContent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主题内容详解
	 */
	public void setLectureContent(String lectureContent){
		this.lectureContent = lectureContent;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  外部标记
	 */
	@Column(name ="OUT_SIGN",nullable=true,length=50)
	public java.lang.String getOutSign(){
		return this.outSign;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  外部标记
	 */
	public void setOutSign(java.lang.String outSign){
		this.outSign = outSign;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属场次
	 */
	@Column(name ="LG_ID",nullable=true,length=32)
	public String getLgId(){
		return this.lgId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属场次
	 */
	public void setLgId(String lgId){
		this.lgId = lgId;
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

	//大权添加与dxs_actives表的多对一关联
	private DxsActivesEntity dxsActivesEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "acitve_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)

	public DxsActivesEntity getDxsActivesEntity() {
		return dxsActivesEntity;
	}

	public void setDxsActivesEntity(DxsActivesEntity dxsActivesEntity) {
		this.dxsActivesEntity = dxsActivesEntity;
	}

	//大权添加与表dxs_lectures_persion的多对一关联
	private DxsLecturesPersionEntity dxsLecturesPersionEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "lp_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)

	public DxsLecturesPersionEntity getDxsLecturesPersionEntity() {
		return dxsLecturesPersionEntity;
	}

	public void setDxsLecturesPersionEntity(DxsLecturesPersionEntity dxsLecturesPersionEntity) {
		this.dxsLecturesPersionEntity = dxsLecturesPersionEntity;
	}
}
