package com.buss.specialrecruitjob.entity;

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
import com.buss.user.entity.DxsUserEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_special_recruit_job
 * @author onlineGenerator
 * @date 2016-07-25 15:58:01
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_special_recruit_job", schema = "")
@SuppressWarnings("serial")
public class DxsSpecialRecruitJobEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**所属专场*/
	@Excel(name="所属专场")
	private String srId;
	/**岗位名称*/
	@Excel(name="岗位名称")
	private String srJobName;
	/**人数*/
	@Excel(name="人数")
	private Integer srJobNum;
	/**工资待遇*/
	@Excel(name="工资待遇")
	private String srJobSalary;
	/**工作地点*/
	@Excel(name="工作地点")
	private String srJobAddress;
	/**招聘单位id*/
	@Excel(name="招聘单位id")
	private String srJobUnitId;
	/**招聘单位*/
	@Excel(name="招聘单位")
	private String srJobUnit;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private Date createTime;
	/**更新时间*/
	@Excel(name="更新时间",format = "yyyy-MM-dd")
	private Date updateTime;
	/**删除标志*/
	@Excel(name="删除标志")
	private Integer isDelete;

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
	 *@return: java.lang.String  所属专场
	 */
	@Column(name ="SR_ID",nullable=true,length=32)
	public String getSrId(){
		return this.srId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属专场
	 */
	public void setSrId(String srId){
		this.srId = srId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  岗位名称
	 */
	@Column(name ="SR_JOB_NAME",nullable=true,length=255)
	public String getSrJobName(){
		return this.srJobName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  岗位名称
	 */
	public void setSrJobName(String srJobName){
		this.srJobName = srJobName;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  人数
	 */
	@Column(name ="SR_JOB_NUM",nullable=true,length=10)
	public Integer getSrJobNum(){
		return this.srJobNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  人数
	 */
	public void setSrJobNum(Integer srJobNum){
		this.srJobNum = srJobNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工资待遇
	 */
	@Column(name ="SR_JOB_SALARY",nullable=true,length=100)
	public String getSrJobSalary(){
		return this.srJobSalary;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工资待遇
	 */
	public void setSrJobSalary(String srJobSalary){
		this.srJobSalary = srJobSalary;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工作地点
	 */
	@Column(name ="SR_JOB_ADDRESS",nullable=true,length=255)
	public String getSrJobAddress(){
		return this.srJobAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工作地点
	 */
	public void setSrJobAddress(String srJobAddress){
		this.srJobAddress = srJobAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  招聘单位id
	 */
	@Column(name ="SR_JOB_UNIT_ID",nullable=true,length=32)
	public String getSrJobUnitId(){
		return this.srJobUnitId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  招聘单位id
	 */
	public void setSrJobUnitId(String srJobUnitId){
		this.srJobUnitId = srJobUnitId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  招聘单位
	 */
	@Column(name ="SR_JOB_UNIT",nullable=true,length=255)
	public String getSrJobUnit(){
		return this.srJobUnit;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  招聘单位
	 */
	public void setSrJobUnit(String srJobUnit){
		this.srJobUnit = srJobUnit;
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
	@JoinColumn(name = "sr_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)

	public DxsSpecialRecruitEntity getDxsSpecialRecruitEntity() {
		return dxsSpecialRecruitEntity;
	}

	public void setDxsSpecialRecruitEntity(DxsSpecialRecruitEntity dxsSpecialRecruitEntity) {
		this.dxsSpecialRecruitEntity = dxsSpecialRecruitEntity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "sr_job_unit_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)

	public DxsUserEntity getDxsUserEntity() {
		return dxsUserEntity;
	}

	public void setDxsUserEntity(DxsUserEntity dxsUserEntity) {
		this.dxsUserEntity = dxsUserEntity;
	}
}
