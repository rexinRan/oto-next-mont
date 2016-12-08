package com.buss.trainoutlineusers.entity;

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
 * @Description: dxs_train_outline_users
 * @author onlineGenerator
 * @date 2016-09-09 09:32:28
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_train_outline_users", schema = "")
@SuppressWarnings("serial")
public class TrainOutlineUsersEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**姓名*/
	private java.lang.String name;
	/**头像*/
	private java.lang.String headImgUrl;
	/**就职公司*/
	private java.lang.String company;
	/**工作*/
	private java.lang.String job;
	/**薪资*/
	private java.lang.String salary;
	/**备注(预留)*/
	private java.lang.String resume;
	/**createTime*/
	private java.util.Date createTime;
	/**updateTime*/
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
	 *@return: java.lang.String  姓名
	 */
	@Column(name ="NAME",nullable=true,length=100)
	public java.lang.String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setName(java.lang.String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  头像
	 */
	@Column(name ="HEAD_IMG_URL",nullable=true,length=255)
	public java.lang.String getHeadImgUrl(){
		return this.headImgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  头像
	 */
	public void setHeadImgUrl(java.lang.String headImgUrl){
		this.headImgUrl = headImgUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  就职公司
	 */
	@Column(name ="COMPANY",nullable=true,length=255)
	public java.lang.String getCompany(){
		return this.company;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  就职公司
	 */
	public void setCompany(java.lang.String company){
		this.company = company;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工作
	 */
	@Column(name ="JOB",nullable=true,length=20)
	public java.lang.String getJob(){
		return this.job;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工作
	 */
	public void setJob(java.lang.String job){
		this.job = job;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  薪资
	 */
	@Column(name ="SALARY",nullable=true,length=50)
	public java.lang.String getSalary(){
		return this.salary;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  薪资
	 */
	public void setSalary(java.lang.String salary){
		this.salary = salary;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注(预留)
	 */
	@Column(name ="RESUME",nullable=true,length=255)
	public java.lang.String getResume(){
		return this.resume;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注(预留)
	 */
	public void setResume(java.lang.String resume){
		this.resume = resume;
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
