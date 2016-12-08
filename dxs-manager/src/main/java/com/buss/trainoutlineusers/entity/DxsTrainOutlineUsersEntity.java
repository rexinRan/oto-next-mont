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
import org.jeecgframework.poi.excel.annotation.Excel;

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
public class DxsTrainOutlineUsersEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**姓名*/
	@Excel(name="姓名")
	private String name;
	/**头像*/
	@Excel(name="头像")
	private String headImgUrl;
	/**就职公司*/
	@Excel(name="就职公司")
	private String company;
	/**工作*/
	@Excel(name="工作")
	private String job;
	/**薪资*/
	@Excel(name="薪资")
	private String salary;
	/**备注(预留)*/
	@Excel(name="备注(预留)")
	private String resume;
	/**createTime*/
	@Excel(name="createTime",format = "yyyy-MM-dd")
	private Date createTime;
	/**updateTime*/
	@Excel(name="updateTime",format = "yyyy-MM-dd")
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
	 *@return: java.lang.String  姓名
	 */
	@Column(name ="NAME",nullable=true,length=100)
	public String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  头像
	 */
	@Column(name ="HEAD_IMG_URL",nullable=true,length=255)
	public String getHeadImgUrl(){
		return this.headImgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  头像
	 */
	public void setHeadImgUrl(String headImgUrl){
		this.headImgUrl = headImgUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  就职公司
	 */
	@Column(name ="COMPANY",nullable=true,length=255)
	public String getCompany(){
		return this.company;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  就职公司
	 */
	public void setCompany(String company){
		this.company = company;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工作
	 */
	@Column(name ="JOB",nullable=true,length=20)
	public String getJob(){
		return this.job;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工作
	 */
	public void setJob(String job){
		this.job = job;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  薪资
	 */
	@Column(name ="SALARY",nullable=true,length=50)
	public String getSalary(){
		return this.salary;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  薪资
	 */
	public void setSalary(String salary){
		this.salary = salary;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注(预留)
	 */
	@Column(name ="RESUME",nullable=true,length=255)
	public String getResume(){
		return this.resume;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注(预留)
	 */
	public void setResume(String resume){
		this.resume = resume;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  createTime
	 */
	@Column(name ="CREATE_TIME",nullable=true)
	public Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  createTime
	 */
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  updateTime
	 */
	@Column(name ="UPDATE_TIME",nullable=true)
	public Date getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  updateTime
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
