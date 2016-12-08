package com.buss.specialrecruitjob.entity;

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
 * 专场招聘项
 * @Title: Entity
 * @Description: dxs_special_recruit_job
 * @author onlineGenerator
 * @date 2016-07-25 10:13:10
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_special_recruit_job", schema = "")
@SuppressWarnings("serial")
public class SpecialRecruitJobEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**所属专场*/
	private  java.lang.String srId;
	/**岗位名称*/
	private java.lang.String srJobName;
	/**人数*/
	private java.lang.Integer srJobNum;
	/**工资待遇*/
	private java.lang.String srJobSalary;
	/**工作地点*/
	private java.lang.String srJobAddress;
	/**招聘单位id*/
	private java.lang.String srJobUnitId;
	/**招聘单位*/
	private java.lang.String srJobUnit;
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
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属专场
	 */
	@Column(name ="SR_ID",nullable=true,length=32)
	public String getSrId() {
		return srId;
	}

	public void setSrId(String srId) {
		this.srId = srId;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  岗位名称
	 */
	@Column(name ="SR_JOB_NAME",nullable=true,length=255)
	public java.lang.String getSrJobName(){
		return this.srJobName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  岗位名称
	 */
	public void setSrJobName(java.lang.String srJobName){
		this.srJobName = srJobName;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  人数
	 */
	@Column(name ="SR_JOB_NUM",nullable=true,length=10)
	public java.lang.Integer getSrJobNum(){
		return this.srJobNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  人数
	 */
	public void setSrJobNum(java.lang.Integer srJobNum){
		this.srJobNum = srJobNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工资待遇
	 */
	@Column(name ="SR_JOB_SALARY",nullable=true,length=100)
	public java.lang.String getSrJobSalary(){
		return this.srJobSalary;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工资待遇
	 */
	public void setSrJobSalary(java.lang.String srJobSalary){
		this.srJobSalary = srJobSalary;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工作地点
	 */
	@Column(name ="SR_JOB_ADDRESS",nullable=true,length=255)
	public java.lang.String getSrJobAddress(){
		return this.srJobAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工作地点
	 */
	public void setSrJobAddress(java.lang.String srJobAddress){
		this.srJobAddress = srJobAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  招聘单位id
	 */
	@Column(name ="SR_JOB_UNIT_ID",nullable=true,length=32)
	public java.lang.String getSrJobUnitId(){
		return this.srJobUnitId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  招聘单位id
	 */
	public void setSrJobUnitId(java.lang.String srJobUnitId){
		this.srJobUnitId = srJobUnitId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  招聘单位
	 */
	@Column(name ="SR_JOB_UNIT",nullable=true,length=255)
	public java.lang.String getSrJobUnit(){
		return this.srJobUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  招聘单位
	 */
	public void setSrJobUnit(java.lang.String srJobUnit){
		this.srJobUnit = srJobUnit;
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
