package com.buss.trainingcatalog.entity;

import com.buss.quiz.entity.QuizEntity;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

/**   
 * @Title: Entity
 * @Description: dxs_training_catalog
 * @author lu
 * @date 2016-06-08 10:10:43
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_training_catalog", catalog = "dxsdb")
public class TrainingCatalogEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**父级主键*/

	private String pid;
	/**培训中心分类名称*/

	private String trainingCatalogName;
	/**分类配图*/

	private String trainingCatalogImg;
	/**分类简介*/

	private String trainingCatalogIntroduction;
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
	 *@return: java.lang.String  父级主键
	 */
	@Column(name ="PID",nullable=true,length=32)
	public String getPid(){
		return this.pid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  父级主键
	 */
	public void setPid(String pid){
		this.pid = pid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  培训中心分类名称
	 */
	@Column(name ="TRAINING_CATALOG_NAME",nullable=true,length=200)
	public String getTrainingCatalogName(){
		return this.trainingCatalogName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  培训中心分类名称
	 */
	public void setTrainingCatalogName(String trainingCatalogName){
		this.trainingCatalogName = trainingCatalogName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  分类配图
	 */
	@Column(name ="TRAINING_CATALOG_IMG",nullable=true,length=200)
	public String getTrainingCatalogImg(){
		return this.trainingCatalogImg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分类配图
	 */
	public void setTrainingCatalogImg(String trainingCatalogImg){
		this.trainingCatalogImg = trainingCatalogImg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  分类简介
	 */
	@Column(name ="TRAINING_CATALOG_INTRODUCTION",nullable=true,length=255)
	public String getTrainingCatalogIntroduction(){
		return this.trainingCatalogIntroduction;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  分类简介
	 */
	public void setTrainingCatalogIntroduction(String trainingCatalogIntroduction){
		this.trainingCatalogIntroduction = trainingCatalogIntroduction;
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
