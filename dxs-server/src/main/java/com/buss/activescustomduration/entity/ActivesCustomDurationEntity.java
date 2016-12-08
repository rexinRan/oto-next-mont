package com.buss.activescustomduration.entity;

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
 * @Description: dxs_actives_custom_duration
 * @author onlineGenerator
 * @date 2016-08-01 09:38:07
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_actives_custom_duration", schema = "")
@SuppressWarnings("serial")
public class ActivesCustomDurationEntity implements java.io.Serializable {
	/**id*/
	private java.lang.String id;
	/**courseLang*/
	private java.lang.Integer courseLang;
	/**isTrue*/
	private java.lang.Integer isTrue;
	/**createTime*/
	private java.util.Date createTime;
	/**updateTime*/
	private java.util.Date updateTime;
	/**isDelete*/
	private java.lang.Integer isDelete;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
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
	 *@param: java.lang.String  id
	 */
	public void setId(java.lang.String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  courseLang
	 */
	@Column(name ="COURSE_LANG",nullable=true,length=3)
	public java.lang.Integer getCourseLang(){
		return this.courseLang;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  courseLang
	 */
	public void setCourseLang(java.lang.Integer courseLang){
		this.courseLang = courseLang;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  isTrue
	 */
	@Column(name ="IS_TRUE",nullable=true,length=3)
	public java.lang.Integer getIsTrue(){
		return this.isTrue;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  isTrue
	 */
	public void setIsTrue(java.lang.Integer isTrue){
		this.isTrue = isTrue;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  createTime
	 */
	@Column(name ="CREATE_TIME",nullable=true)
	public java.util.Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  createTime
	 */
	public void setCreateTime(java.util.Date createTime){
		this.createTime = createTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  updateTime
	 */
	@Column(name ="UPDATE_TIME",nullable=true)
	public java.util.Date getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  updateTime
	 */
	public void setUpdateTime(java.util.Date updateTime){
		this.updateTime = updateTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  isDelete
	 */
	@Column(name ="IS_DELETE",nullable=true,length=3)
	public java.lang.Integer getIsDelete(){
		return this.isDelete;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  isDelete
	 */
	public void setIsDelete(java.lang.Integer isDelete){
		this.isDelete = isDelete;
	}
}
