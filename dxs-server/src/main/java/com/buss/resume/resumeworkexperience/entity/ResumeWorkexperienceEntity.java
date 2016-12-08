package com.buss.resume.resumeworkexperience.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: dxs_resume_workexperience
 * @author lu
 * @date 2016-06-16 17:12:01
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_resume_workexperience", catalog = "dxsdb")
@SuppressWarnings("serial")
public class ResumeWorkexperienceEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**简历ID*/

	private java.lang.String resumeId;
	/**公司名称*/

	private java.lang.String companyName;
	/**公司地址*/

	private java.lang.String companyAddress;
	/**所在部门*/

	private java.lang.String companyDepartment;
	/**从事职位*/

	private java.lang.String companyJob;
	/**职位级别*/

	private java.lang.String companyClass;
	/**职位类型*/

	private java.lang.String companyType;
	/**开始时间*/

	private java.lang.String companyStart;
	/**结束时间*/

	private java.lang.String companyEnd;
	/**工作经历*/

	private java.lang.String workExperience;
	/**图片*/

	private java.lang.String imgUrl;
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
	 *@return: java.lang.String  简历ID
	 */
	@Column(name ="RESUME_ID",nullable=true,length=32)
	public java.lang.String getResumeId(){
		return this.resumeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  简历ID
	 */
	public void setResumeId(java.lang.String resumeId){
		this.resumeId = resumeId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司名称
	 */
	@Column(name ="COMPANY_NAME",nullable=true,length=100)
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司地址
	 */
	@Column(name ="COMPANY_ADDRESS",nullable=true,length=100)
	public java.lang.String getCompanyAddress(){
		return this.companyAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司地址
	 */
	public void setCompanyAddress(java.lang.String companyAddress){
		this.companyAddress = companyAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所在部门
	 */
	@Column(name ="COMPANY_DEPARTMENT",nullable=true,length=50)
	public java.lang.String getCompanyDepartment(){
		return this.companyDepartment;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所在部门
	 */
	public void setCompanyDepartment(java.lang.String companyDepartment){
		this.companyDepartment = companyDepartment;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  从事职位
	 */
	@Column(name ="COMPANY_JOB",nullable=true,length=20)
	public java.lang.String getCompanyJob(){
		return this.companyJob;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  从事职位
	 */
	public void setCompanyJob(java.lang.String companyJob){
		this.companyJob = companyJob;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职位级别
	 */
	@Column(name ="COMPANY_CLASS",nullable=true,length=20)
	public java.lang.String getCompanyClass(){
		return this.companyClass;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职位级别
	 */
	public void setCompanyClass(java.lang.String companyClass){
		this.companyClass = companyClass;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职位类型
	 */
	@Column(name ="COMPANY_TYPE",nullable=true,length=20)
	public java.lang.String getCompanyType(){
		return this.companyType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职位类型
	 */
	public void setCompanyType(java.lang.String companyType){
		this.companyType = companyType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开始时间
	 */
	@Column(name ="COMPANY_START",nullable=true,length=20)
	public java.lang.String getCompanyStart(){
		return this.companyStart;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开始时间
	 */
	public void setCompanyStart(java.lang.String companyStart){
		this.companyStart = companyStart;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结束时间
	 */
	@Column(name ="COMPANY_END",nullable=true,length=20)
	public java.lang.String getCompanyEnd(){
		return this.companyEnd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结束时间
	 */
	public void setCompanyEnd(java.lang.String companyEnd){
		this.companyEnd = companyEnd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工作经历
	 */
	@Column(name ="WORK_EXPERIENCE",nullable=true,length=255)
	public java.lang.String getWorkExperience(){
		return this.workExperience;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工作经历
	 */
	public void setWorkExperience(java.lang.String workExperience){
		this.workExperience = workExperience;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片
	 */
	@Column(name ="IMG_URL",nullable=true,length=255)
	public java.lang.String getImgUrl(){
		return this.imgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片
	 */
	public void setImgUrl(java.lang.String imgUrl){
		this.imgUrl = imgUrl;
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
