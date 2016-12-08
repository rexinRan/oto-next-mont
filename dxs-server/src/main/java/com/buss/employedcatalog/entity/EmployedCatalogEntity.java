package com.buss.employedcatalog.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


/**   
 * @Title: Entity
 * @Description: dxs_employed_catalog
 * @author onlineGenerator
 * @date 2016-06-02 16:56:51
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_employed_catalog",catalog = "dxsdb")
public class EmployedCatalogEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**父级id*/

	private String pid;
	/**就业分类名称*/

	private String employedCatalogName;
	/**分类配图*/

	private String employedImgurl;
	/**分类介绍*/

	private String employedIntroduction;
	/**创建时间*/

	private Date createTime;
	/**更新时间*/

	private Date updateTime;
	/**删除标志*/

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
	 *@return: java.lang.String  父级id
	 */
	@Column(name ="PID",nullable=true,length=32)
	public String getPid(){
		return this.pid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  父级id
	 */
	public void setPid(String pid){
		this.pid = pid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  就业分类名称
	 */
	@Column(name ="EMPLOYED_CATALOG_NAME",nullable=true,length=200)
	public String getEmployedCatalogName(){
		return this.employedCatalogName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  就业分类名称
	 */
	public void setEmployedCatalogName(String employedCatalogName){
		this.employedCatalogName = employedCatalogName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  分类配图
	 */
	@Column(name ="EMPLOYED_IMGURL",nullable=true,length=200)
	public String getEmployedImgurl(){
		return this.employedImgurl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分类配图
	 */
	public void setEmployedImgurl(String employedImgurl){
		this.employedImgurl = employedImgurl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  分类介绍
	 */
	@Column(name ="EMPLOYED_INTRODUCTION",nullable=true,length=255)
	public String getEmployedIntroduction(){
		return this.employedIntroduction;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分类介绍
	 */
	public void setEmployedIntroduction(String employedIntroduction){
		this.employedIntroduction = employedIntroduction;
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
