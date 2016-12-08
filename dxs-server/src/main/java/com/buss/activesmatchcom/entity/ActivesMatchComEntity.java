package com.buss.activesmatchcom.entity;

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
 * @Description: dxs_actives_match_com
 * @author onlineGenerator
 * @date 2016-08-30 15:48:03
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_actives_match_com", schema = "")
@SuppressWarnings("serial")
public class ActivesMatchComEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**活动id*/
	private java.lang.String activesId;
	/**校园赛事id*/
	private java.lang.String amId;
	/**缩略图id*/
	private java.lang.String imgUrl;
	/**公司名称*/
	private java.lang.String companyName;
	/**公司展示分类*/
	private java.lang.Integer dataType;
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
	@Column(name ="ACTIVES_ID",nullable=false,length=32)
	public java.lang.String getActivesId(){
		return this.activesId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动id
	 */
	public void setActivesId(java.lang.String activesId){
		this.activesId = activesId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  校园赛事id
	 */
	@Column(name ="AM_ID",nullable=true,length=32)
	public java.lang.String getAmId(){
		return this.amId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  校园赛事id
	 */
	public void setAmId(java.lang.String amId){
		this.amId = amId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  缩略图id
	 */
	@Column(name ="IMG_URL",nullable=true,length=255)
	public java.lang.String getImgUrl(){
		return this.imgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  缩略图id
	 */
	public void setImgUrl(java.lang.String imgUrl){
		this.imgUrl = imgUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司名称
	 */
	@Column(name ="COMPANY_NAME",nullable=true,length=255)
	public java.lang.String getCompanyName(){
		return this.companyName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司名称
	 */
	public void setCompanyName(java.lang.String companyName){
		this.companyName = companyName;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  公司展示分类
	 */
	@Column(name ="DATA_TYPE",nullable=true,length=3)
	public java.lang.Integer getDataType(){
		return this.dataType;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  公司展示分类
	 */
	public void setDataType(java.lang.Integer dataType){
		this.dataType = dataType;
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
