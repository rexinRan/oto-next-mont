package com.buss.specialrecruitjobappointment.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.specialrecruit.entity.DxsSpecialRecruitEntity;
import com.buss.specialrecruitjob.entity.DxsSpecialRecruitJobEntity;
import com.buss.user.entity.DxsUserEntity;
import org.hibernate.annotations.GenericGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_special_recruit_job_appointment
 * @author onlineGenerator
 * @date 2016-07-25 15:58:47
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_special_recruit_job_appointment", schema = "")
@SuppressWarnings("serial")
public class DxsSpecialRecruitJobAppointmentEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**专场招聘id*/
	@Excel(name="专场招聘id")
	private java.lang.String srId;
	/**专岗id*/
	@Excel(name="专岗id")
	private String srjId;
	/**用户id*/
	@Excel(name="用户id")
	private String userId;
	/**预约类型*/
	@Excel(name="预约类型")
	private Integer appointmentType;
	/**预约时间*/
	@Excel(name="预约时间",format = "yyyy-MM-dd")
	private Date appointmentTime;
	/**申请类型*/
	@Excel(name="申请类型")
	private Integer type;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private Date createTime;
	/**更新时间*/
	@Excel(name="更新时间",format = "yyyy-MM-dd")
	private Date updateTime;
	/**删除标志*/
	@Excel(name="删除标志")
	private Integer isDelete;

	private DxsSpecialRecruitJobEntity dxsSpecialRecruitJobEntity;

	private DxsSpecialRecruitEntity dxsSpecialRecruitEntity;

	private DxsUserEntity dxsUserEntity;
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
	 *@return: java.lang.String  专岗id
	 */
	@Column(name ="SRJ_ID",nullable=true,length=32)
	public String getSrjId(){
		return this.srjId;
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
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专岗id
	 */
	public void setSrjId(String srjId){
		this.srjId = srjId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户id
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户id
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  预约类型
	 */
	@Column(name ="APPOINTMENT_TYPE",nullable=true,length=3)
	public Integer getAppointmentType(){
		return this.appointmentType;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  预约类型
	 */
	public void setAppointmentType(Integer appointmentType){
		this.appointmentType = appointmentType;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  预约时间
	 */
	@Column(name ="APPOINTMENT_TIME",nullable=true)
	public Date getAppointmentTime(){
		return this.appointmentTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  预约时间
	 */
	public void setAppointmentTime(Date appointmentTime){
		this.appointmentTime = appointmentTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  申请类型
	 */
	@Column(name ="TYPE",nullable=true,length=3)
	public Integer getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  申请类型
	 */
	public void setType(Integer type){
		this.type = type;
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


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "srj_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)
	public DxsSpecialRecruitJobEntity getDxsSpecialRecruitJobEntity() {
		return dxsSpecialRecruitJobEntity;
	}

	public void setDxsSpecialRecruitJobEntity(DxsSpecialRecruitJobEntity dxsSpecialRecruitJobEntity) {
		this.dxsSpecialRecruitJobEntity = dxsSpecialRecruitJobEntity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sr_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)
	public DxsSpecialRecruitEntity getDxsSpecialRecruitEntity() {
		return dxsSpecialRecruitEntity;
	}

	public void setDxsSpecialRecruitEntity(DxsSpecialRecruitEntity dxsSpecialRecruitEntity) {
		this.dxsSpecialRecruitEntity = dxsSpecialRecruitEntity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)
	public DxsUserEntity getDxsUserEntity() {
		return dxsUserEntity;
	}

	public void setDxsUserEntity(DxsUserEntity dxsUserEntity) {
		this.dxsUserEntity = dxsUserEntity;
	}
}
