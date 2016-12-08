package com.buss.activescustomcountry.entity;

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
 * @Description: dxs_actives_custom_country
 * @author onlineGenerator
 * @date 2016-08-01 09:38:40
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_actives_custom_country", schema = "")
@SuppressWarnings("serial")
public class ActivesCustomCountryEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**父类id*/
	private java.lang.String pid;
	/**国家名字*/
	private java.lang.String countryName;
	/**是否可用*/
	private java.lang.Integer isTrue;
	/**价格*/
	private java.lang.Integer countryPrice;
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
	 *@return: java.lang.String  父类id
	 */
	@Column(name ="PID",nullable=true,length=32)
	public java.lang.String getPid(){
		return this.pid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  父类id
	 */
	public void setPid(java.lang.String pid){
		this.pid = pid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  国家名字
	 */
	@Column(name ="COUNTRY_NAME",nullable=true,length=200)
	public java.lang.String getCountryName(){
		return this.countryName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  国家名字
	 */
	public void setCountryName(java.lang.String countryName){
		this.countryName = countryName;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否可用
	 */
	@Column(name ="IS_TRUE",nullable=true,length=3)
	public java.lang.Integer getIsTrue(){
		return this.isTrue;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否可用
	 */
	public void setIsTrue(java.lang.Integer isTrue){
		this.isTrue = isTrue;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  价格
	 */
	@Column(name ="COUNTRY_PRICE",nullable=true,length=10)
	public java.lang.Integer getCountryPrice(){
		return this.countryPrice;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  价格
	 */
	public void setCountryPrice(java.lang.Integer countryPrice){
		this.countryPrice = countryPrice;
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
