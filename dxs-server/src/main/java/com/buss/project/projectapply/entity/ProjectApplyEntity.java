package com.buss.project.projectapply.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: dxs_project_apply
 * @author onlineGenerator
 * @date 2016-07-23 15:13:49
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_project_apply", schema = "")
@SuppressWarnings("serial")
public class ProjectApplyEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**用户id*/

	private String userId;
	/**教师id*/

	private String teaId;
	/**项目id*/

	private String projectId;
	/**关联id*/

	private String outId;
	/**类型*/

	private Integer type;
	/**申请类型*/

	private Integer applyType;
	/**申请结果*/

	private Integer result;
	/**消息反馈*/

	private String message;
	/**备注*/

	private String remarks;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  教师id
	 */
	@Column(name ="TEA_ID",nullable=true,length=32)
	public String getTeaId(){
		return this.teaId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  教师id
	 */
	public void setTeaId(String teaId){
		this.teaId = teaId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目id
	 */
	@Column(name ="PROJECT_ID",nullable=true,length=32)
	public String getProjectId(){
		return this.projectId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目id
	 */
	public void setProjectId(String projectId){
		this.projectId = projectId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  关联id
	 */
	@Column(name ="OUT_ID",nullable=true,length=32)
	public String getOutId(){
		return this.outId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  关联id
	 */
	public void setOutId(String outId){
		this.outId = outId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  类型
	 */
	@Column(name ="TYPE",nullable=true,length=10)
	public Integer getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  类型
	 */
	public void setType(Integer type){
		this.type = type;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  申请类型
	 */
	@Column(name ="APPLY_TYPE",nullable=true,length=10)
	public Integer getApplyType(){
		return this.applyType;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  申请类型
	 */
	public void setApplyType(Integer applyType){
		this.applyType = applyType;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  申请结果
	 */
	@Column(name ="RESULT",nullable=true,length=10)
	public Integer getResult(){
		return this.result;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  申请结果
	 */
	public void setResult(Integer result){
		this.result = result;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  消息反馈
	 */
	@Column(name ="MESSAGE",nullable=true,length=255)
	public String getMessage(){
		return this.message;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  消息反馈
	 */
	public void setMessage(String message){
		this.message = message;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARKS",nullable=true,length=255)
	public String getRemarks(){
		return this.remarks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemarks(String remarks){
		this.remarks = remarks;
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
