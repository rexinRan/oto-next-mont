package com.buss.entrepreneurshipprojectcompetition.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: dxs_entrepreneurship_project_competition
 * @author lu
 * @date 2016-06-13 15:29:19
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_entrepreneurship_project_competition", catalog = "dxsdb")
public class EntrepreneurshipProjectCompetitionEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**项目所属领域id*/

	private String projectAreaId;
	/**项目所属类型id*/

	private String projectTypeId;
	/**项目名称*/

	private String projectName;
	/**项目分类*/

	private String projectCatalog;
	/**项目开始时间*/

	private String projectStartTime;
	/**项目结束时间*/

	private String projectEndTime;
	/**项目状态*/

	private Integer projectStatus;
	/**项目简介*/

	private String projectProfile;
	/**审核码*/

	private Integer checkCode;
	/**项目展示图片*/

	private String projectImgurl;
	/**项目等级*/

	private Integer projectGrade;
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
	 *@return: java.lang.String  项目所属领域id
	 */
	@Column(name ="PROJECT_AREA_ID",nullable=true,length=32)
	public String getProjectAreaId(){
		return this.projectAreaId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目所属领域id
	 */
	public void setProjectAreaId(String projectAreaId){
		this.projectAreaId = projectAreaId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目所属类型id
	 */
	@Column(name ="PROJECT_TYPE_ID",nullable=true,length=32)
	public String getProjectTypeId(){
		return this.projectTypeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目所属类型id
	 */
	public void setProjectTypeId(String projectTypeId){
		this.projectTypeId = projectTypeId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目名称
	 */
	@Column(name ="PROJECT_NAME",nullable=true,length=50)
	public String getProjectName(){
		return this.projectName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目名称
	 */
	public void setProjectName(String projectName){
		this.projectName = projectName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目分类
	 */
	@Column(name ="PROJECT_CATALOG",nullable=true,length=255)
	public String getProjectCatalog(){
		return this.projectCatalog;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目分类
	 */
	public void setProjectCatalog(String projectCatalog){
		this.projectCatalog = projectCatalog;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目开始时间
	 */
	@Column(name ="PROJECT_START_TIME",nullable=true,length=50)
	public String getProjectStartTime(){
		return this.projectStartTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目开始时间
	 */
	public void setProjectStartTime(String projectStartTime){
		this.projectStartTime = projectStartTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目结束时间
	 */
	@Column(name ="PROJECT_END_TIME",nullable=true,length=50)
	public String getProjectEndTime(){
		return this.projectEndTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目结束时间
	 */
	public void setProjectEndTime(String projectEndTime){
		this.projectEndTime = projectEndTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  项目状态
	 */
	@Column(name ="PROJECT_STATUS",nullable=true,length=10)
	public Integer getProjectStatus(){
		return this.projectStatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  项目状态
	 */
	public void setProjectStatus(Integer projectStatus){
		this.projectStatus = projectStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目简介
	 */
	@Column(name ="PROJECT_PROFILE",nullable=true,length=255)
	public String getProjectProfile(){
		return this.projectProfile;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目简介
	 */
	public void setProjectProfile(String projectProfile){
		this.projectProfile = projectProfile;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  审核码
	 */
	@Column(name ="CHECK_CODE",nullable=true,length=10)
	public Integer getCheckCode(){
		return this.checkCode;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  审核码
	 */
	public void setCheckCode(Integer checkCode){
		this.checkCode = checkCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目展示图片
	 */
	@Column(name ="PROJECT_IMGURL",nullable=true,length=200)
	public String getProjectImgurl(){
		return this.projectImgurl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目展示图片
	 */
	public void setProjectImgurl(String projectImgurl){
		this.projectImgurl = projectImgurl;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  项目等级
	 */
	@Column(name ="PROJECT_GRADE",nullable=true,length=10)
	public Integer getProjectGrade(){
		return this.projectGrade;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  项目等级
	 */
	public void setProjectGrade(Integer projectGrade){
		this.projectGrade = projectGrade;
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
