package com.buss.trainoutlinecourseclasses.entity;

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
 * @Description: dxs_train_outline_course_classes
 * @author onlineGenerator
 * @date 2016-09-09 11:01:06
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_train_outline_course_classes", schema = "")
@SuppressWarnings("serial")
public class TrainOutlineCourseClassesEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**培训中心->线下培训的id*/
	private java.lang.String tocId;
	/**培训时间*/
	private java.util.Date openTime;
	/**培训城市*/
	private java.lang.String addressShort;
	/**上课地点*/
	private java.lang.String address;
	/**上课时间*/
	private java.lang.String time;
	/**开学时间*/
	private java.lang.String startClass;
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
	 *@return: java.lang.String  培训中心->线下培训的id
	 */
	@Column(name ="TOC_ID",nullable=true,length=32)
	public java.lang.String getTocId(){
		return this.tocId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  培训中心->线下培训的id
	 */
	public void setTocId(java.lang.String tocId){
		this.tocId = tocId;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  培训时间
	 */
	@Column(name ="OPEN_TIME",nullable=true)
	public java.util.Date getOpenTime(){
		return this.openTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  培训时间
	 */
	public void setOpenTime(java.util.Date openTime){
		this.openTime = openTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  培训城市
	 */
	@Column(name ="ADDRESS_SHORT",nullable=true,length=50)
	public java.lang.String getAddressShort(){
		return this.addressShort;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  培训城市
	 */
	public void setAddressShort(java.lang.String addressShort){
		this.addressShort = addressShort;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  上课地点
	 */
	@Column(name ="ADDRESS",nullable=true,length=255)
	public java.lang.String getAddress(){
		return this.address;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  上课地点
	 */
	public void setAddress(java.lang.String address){
		this.address = address;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  上课时间
	 */
	@Column(name ="TIME",nullable=true,length=200)
	public java.lang.String getTime(){
		return this.time;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  上课时间
	 */
	public void setTime(java.lang.String time){
		this.time = time;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开学时间
	 */
	@Column(name ="START_CLASS",nullable=true,length=200)
	public java.lang.String getStartClass(){
		return this.startClass;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开学时间
	 */
	public void setStartClass(java.lang.String startClass){
		this.startClass = startClass;
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
