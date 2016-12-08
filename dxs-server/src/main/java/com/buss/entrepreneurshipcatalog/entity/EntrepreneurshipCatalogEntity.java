package com.buss.entrepreneurshipcatalog.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: dxs_entrepreneurship_catalog
 * @author lu
 * @date 2016-06-06 14:24:58
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_entrepreneurship_catalog",catalog = "dxsdb")
public class EntrepreneurshipCatalogEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**父节点*/

	private String pid;
	/**创业中心分类*/

	private String entrepreneurshipCatalogName;
	/**分类配图*/

	private String entrepreneurshipImg;
	/**分类的简介*/

	private String entrepreneurshipIntroduction;
	/**编码*/

	private Integer sort;
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
	 *@return: java.lang.String  父节点
	 */
	@Column(name ="PID",nullable=true,length=32)
	public String getPid(){
		return this.pid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  父节点
	 */
	public void setPid(String pid){
		this.pid = pid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创业中心分类
	 */
	@Column(name ="ENTREPRENEURSHIP_CATALOG_NAME",nullable=true,length=100)
	public String getEntrepreneurshipCatalogName(){
		return this.entrepreneurshipCatalogName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创业中心分类
	 */
	public void setEntrepreneurshipCatalogName(String entrepreneurshipCatalogName){
		this.entrepreneurshipCatalogName = entrepreneurshipCatalogName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  分类配图
	 */
	@Column(name ="ENTREPRENEURSHIP_IMG",nullable=true,length=200)
	public String getEntrepreneurshipImg(){
		return this.entrepreneurshipImg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分类配图
	 */
	public void setEntrepreneurshipImg(String entrepreneurshipImg){
		this.entrepreneurshipImg = entrepreneurshipImg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  分类的简介
	 */
	@Column(name ="ENTREPRENEURSHIP_INTRODUCTION",nullable=true,length=255)
	public String getEntrepreneurshipIntroduction(){
		return this.entrepreneurshipIntroduction;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分类的简介
	 */
	public void setEntrepreneurshipIntroduction(String entrepreneurshipIntroduction){
		this.entrepreneurshipIntroduction = entrepreneurshipIntroduction;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  编码
	 */
	@Column(name ="SORT",nullable=true,length=10)
	public Integer getSort(){
		return this.sort;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  编码
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
}
