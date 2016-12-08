package com.buss.resume.projectexperience.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: dxs_project_experience
 * @author onlineGenerator
 * @date 2016-06-22 11:11:07
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_project_experience", catalog = "dxsdb")
@SuppressWarnings("serial")
public class ProjectExperienceEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**简历ID*/

	private String resumeId;
	/**项目名*/

	private String projectName;
	/**团队规模*/

	private String projectNum;
	/**项目描述*/

	private String projectDescription;
	/**项目角色*/

	private String projectTask;
	/**开始时间*/

	private String projectStart;
	/**结束时间*/

	private String projectEnd;
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
	 *@return: java.lang.String  简历ID
	 */
	@Column(name ="RESUME_ID",nullable=true,length=32)
	public String getResumeId(){
		return this.resumeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  简历ID
	 */
	public void setResumeId(String resumeId){
		this.resumeId = resumeId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目名
	 */
	@Column(name ="PROJECT_NAME",nullable=true,length=50)
	public String getProjectName(){
		return this.projectName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目名
	 */
	public void setProjectName(String projectName){
		this.projectName = projectName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  团队规模
	 */
	@Column(name ="PROJECT_NUM",nullable=true,length=10)
	public String getProjectNum(){
		return this.projectNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  团队规模
	 */
	public void setProjectNum(String projectNum){
		this.projectNum = projectNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目描述
	 */
	@Column(name ="PROJECT_DESCRIPTION",nullable=true,length=255)
	public String getProjectDescription(){
		return this.projectDescription;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目描述
	 */
	public void setProjectDescription(String projectDescription){
		this.projectDescription = projectDescription;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目角色
	 */
	@Column(name ="PROJECT_TASK",nullable=true,length=100)
	public String getProjectTask(){
		return this.projectTask;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目角色
	 */
	public void setProjectTask(String projectTask){
		this.projectTask = projectTask;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开始时间
	 */
	@Column(name ="PROJECT_START",nullable=true,length=20)
	public String getProjectStart(){
		return this.projectStart;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开始时间
	 */
	public void setProjectStart(String projectStart){
		this.projectStart = projectStart;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结束时间
	 */
	@Column(name ="PROJECT_END",nullable=true,length=20)
	public String getProjectEnd(){
		return this.projectEnd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结束时间
	 */
	public void setProjectEnd(String projectEnd){
		this.projectEnd = projectEnd;
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
