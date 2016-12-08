package com.buss.specialrecruit.entity;

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
 * @Description: dxs_special_recruit
 * @author onlineGenerator
 * @date 2016-07-25 15:57:26
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_special_recruit", schema = "")
@SuppressWarnings("serial")
public class DxsSpecialRecruitEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**专场大学*/
	@Excel(name="专场大学")
	private String spSchool;
	/**专场缩略图*/
	@Excel(name="专场缩略图")
	private String spImgurlFid;
	/**专场图片地址*/
	@Excel(name="专场图片地址")
	private String spImgurl;
	/**招聘专业方向*/
	@Excel(name="招聘专业方向")
	private String spDirection;
	/**招聘岗位数*/
	@Excel(name="招聘岗位数")
	private Integer spJobNum;
	/**学历层次*/
	@Excel(name="学历层次")
	private Integer spEducation;
	/**开始时间*/
	@Excel(name="开始时间",format = "yyyy-MM-dd")
	private java.util.Date holdStartTime;
	/**结束时间*/
	@Excel(name="结束时间",format = "yyyy-MM-dd")
	private java.util.Date holdEndTime;
	/**日期*/
	@Excel(name="日期",format = "yyyy-MM-dd")
	private String holdDatatime;
	/**举办年份*/
	@Excel(name="举办年份")
	private String holdDate;
	/**举办场次*/
	@Excel(name="举办场次")
	private Integer holdNum;
	/**详细地址*/
	@Excel(name="详细地址")
	private String spAddress;
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
	 *@return: java.lang.String  专场大学
	 */
	@Column(name ="SP_SCHOOL",nullable=true,length=255)
	public String getSpSchool(){
		return this.spSchool;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专场大学
	 */
	public void setSpSchool(String spSchool){
		this.spSchool = spSchool;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  专场缩略图
	 */
	@Column(name ="SP_IMGURL_FID",nullable=true,length=32)
	public String getSpImgurlFid(){
		return this.spImgurlFid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专场缩略图
	 */
	public void setSpImgurlFid(String spImgurlFid){
		this.spImgurlFid = spImgurlFid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  专场图片地址
	 */
	@Column(name ="SP_IMGURL",nullable=true,length=255)
	public String getSpImgurl(){
		return this.spImgurl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专场图片地址
	 */
	public void setSpImgurl(String spImgurl){
		this.spImgurl = spImgurl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  招聘专业方向
	 */
	@Column(name ="SP_DIRECTION",nullable=true,length=255)
	public String getSpDirection(){
		return this.spDirection;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  招聘专业方向
	 */
	public void setSpDirection(String spDirection){
		this.spDirection = spDirection;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  招聘岗位数
	 */
	@Column(name ="SP_JOB_NUM",nullable=true,length=10)
	public Integer getSpJobNum(){
		return this.spJobNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  招聘岗位数
	 */
	public void setSpJobNum(Integer spJobNum){
		this.spJobNum = spJobNum;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  学历层次
	 */
	@Column(name ="SP_EDUCATION",nullable=true,length=10)
	public Integer getSpEducation(){
		return this.spEducation;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  学历层次
	 */
	public void setSpEducation(Integer spEducation){
		this.spEducation = spEducation;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  开始时间
	 */
	@Column(name ="HOLD_START_TIME",nullable=true)
	public java.util.Date getHoldStartTime(){
		return this.holdStartTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  开始时间
	 */
	public void setHoldStartTime(java.util.Date holdStartTime){
		this.holdStartTime = holdStartTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  结束时间
	 */
	@Column(name ="HOLD_END_TIME",nullable=true)
	public java.util.Date getHoldEndTime(){
		return this.holdEndTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  结束时间
	 */
	public void setHoldEndTime(java.util.Date holdEndTime){
		this.holdEndTime = holdEndTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  日期
	 */
	@Column(name ="HOLD_DATATIME",nullable=true)
	public String getHoldDatatime(){
		return this.holdDatatime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  日期
	 */
	public void setHoldDatatime(String holdDatatime){
		this.holdDatatime = holdDatatime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  举办年份
	 */
	@Column(name ="HOLD_DATE",nullable=true,length=50)
	public String getHoldDate(){
		return this.holdDate;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  举办年份
	 */
	public void setHoldDate(String holdDate){
		this.holdDate = holdDate;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  举办场次
	 */
	@Column(name ="HOLD_NUM",nullable=true,length=10)
	public Integer getHoldNum(){
		return this.holdNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  举办场次
	 */
	public void setHoldNum(Integer holdNum){
		this.holdNum = holdNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  详细地址
	 */
	@Column(name ="SP_ADDRESS",nullable=true,length=255)
	public String getSpAddress(){
		return this.spAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  详细地址
	 */
	public void setSpAddress(String spAddress){
		this.spAddress = spAddress;
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
