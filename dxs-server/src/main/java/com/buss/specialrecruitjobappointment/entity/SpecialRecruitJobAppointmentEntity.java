package com.buss.specialrecruitjobappointment.entity;

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
 * @Description: dxs_special_recruit_job_appointment
 * @author onlineGenerator
 * @date 2016-07-25 16:54:47
 * @version V1.0
 *
 */
@Entity
@Table(name = "dxs_special_recruit_job_appointment", schema = "")
@SuppressWarnings("serial")
public class SpecialRecruitJobAppointmentEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**专场招聘id*/
	private java.lang.String srId;
	/**专岗id*/
	private java.lang.String srjId;
	/**用户id*/
	private java.lang.String userId;
	/**预约类型*/
	private java.lang.Integer appointmentType;
	/**预约时间*/
	private java.util.Date appointmentTime;
	/**申请类型*/
	private java.lang.Integer type;
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
	 *@return: java.lang.String  专场招聘id
	 */
	@Column(name ="SR_ID",nullable=true,length=32)
	public java.lang.String getSrId(){
		return this.srId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专场招聘id
	 */
	public void setSrId(java.lang.String srId){
		this.srId = srId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  专岗id
	 */
	@Column(name ="SRJ_ID",nullable=true,length=32)
	public java.lang.String getSrjId(){
		return this.srjId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专岗id
	 */
	public void setSrjId(java.lang.String srjId){
		this.srjId = srjId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户id
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public java.lang.String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户id
	 */
	public void setUserId(java.lang.String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  预约类型
	 */
	@Column(name ="APPOINTMENT_TYPE",nullable=true,length=3)
	public java.lang.Integer getAppointmentType(){
		return this.appointmentType;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  预约类型
	 */
	public void setAppointmentType(java.lang.Integer appointmentType){
		this.appointmentType = appointmentType;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  预约时间
	 */
	@Column(name ="APPOINTMENT_TIME",nullable=true)
	public java.util.Date getAppointmentTime(){
		return this.appointmentTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  预约时间
	 */
	public void setAppointmentTime(java.util.Date appointmentTime){
		this.appointmentTime = appointmentTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  申请类型
	 */
	@Column(name ="TYPE",nullable=true,length=3)
	public java.lang.Integer getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  申请类型
	 */
	public void setType(java.lang.Integer type){
		this.type = type;
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
