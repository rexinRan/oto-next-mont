package com.buss.employedmeetingemployed.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: dxs_employed_meeting_employed
 * @author lu
 * @date 2016-06-12 11:25:50
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_employed_meeting_employed", catalog = "dxsdb")
public class EmployedMeetingEmployedEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**招聘会主键*/

	private String employedMeetingId;
	/**职位名称*/

	private String employedName;
	/**招聘人数*/

	private Integer employedNumber;
	/**招聘公司*/

	private String employedCompany;
	/**地点*/

	private String employedPosition;
	/**编号*/

	private Integer employedSort;
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
	 *@return: java.lang.String  招聘会主键
	 */
	@Column(name ="EMPLOYED_MEETING_ID",nullable=true,length=32)
	public String getEmployedMeetingId(){
		return this.employedMeetingId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  招聘会主键
	 */
	public void setEmployedMeetingId(String employedMeetingId){
		this.employedMeetingId = employedMeetingId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职位名称
	 */
	@Column(name ="EMPLOYED_NAME",nullable=true,length=100)
	public String getEmployedName(){
		return this.employedName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职位名称
	 */
	public void setEmployedName(String employedName){
		this.employedName = employedName;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  招聘人数
	 */
	@Column(name ="EMPLOYED_NUMBER",nullable=true,length=10)
	public Integer getEmployedNumber(){
		return this.employedNumber;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  招聘人数
	 */
	public void setEmployedNumber(Integer employedNumber){
		this.employedNumber = employedNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  招聘公司
	 */
	@Column(name ="EMPLOYED_COMPANY",nullable=true,length=100)
	public String getEmployedCompany(){
		return this.employedCompany;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  招聘公司
	 */
	public void setEmployedCompany(String employedCompany){
		this.employedCompany = employedCompany;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  地点
	 */
	@Column(name ="EMPLOYED_POSITION",nullable=true,length=200)
	public String getEmployedPosition(){
		return this.employedPosition;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  地点
	 */
	public void setEmployedPosition(String employedPosition){
		this.employedPosition = employedPosition;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  编号
	 */
	@Column(name ="EMPLOYED_SORT",nullable=true,length=10)
	public Integer getEmployedSort(){
		return this.employedSort;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  编号
	 */
	public void setEmployedSort(Integer employedSort){
		this.employedSort = employedSort;
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
