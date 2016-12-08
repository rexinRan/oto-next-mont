package com.buss.entrepreneurshipprojectcompetition.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.projectarea.controller.ProjectAreaController;
import com.buss.projectarea.entity.ProjectAreaEntity;
import com.buss.projecttype.entity.ProjectTypeEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: entrepreneurship_project_competition
 * @author onlineGenerator
 * @date 2016-06-30 11:56:21
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_entrepreneurship_project_competition", schema = "")
@SuppressWarnings("serial")
public class DxsEntrepreneurshipProjectCompetitionEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**项目所属领域id*/
	@Excel(name="项目所属领域id")
	private java.lang.String projectAreaId;
	/**项目所属类型id*/
	@Excel(name="项目所属类型id")
	private java.lang.String projectTypeId;
	/**项目名称*/
	@Excel(name="项目名称")
	private java.lang.String projectName;
	/**项目分类*/
	@Excel(name="项目分类")
	private java.lang.String projectCatalog;
	/**项目开始时间*/
	@Excel(name="项目开始时间")
	private java.lang.String projectStartTime;
	/**项目结束时间*/
	@Excel(name="项目结束时间")
	private java.lang.String projectEndTime;
	/**项目状态*/
	@Excel(name="项目状态")
	private java.lang.Integer projectStatus;
	/**项目简介*/
	@Excel(name="项目简介")
	private java.lang.String projectProfile;
	/**审核码*/
	@Excel(name="审核码")
	private java.lang.Integer checkCode;
	/**项目展示图片*/
	@Excel(name="项目展示图片")
	private java.lang.String projectImgurl;
	/**项目等级*/
	@Excel(name="项目等级")
	private java.lang.Integer projectGrade;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private java.util.Date createTime;
	/**更新时间*/
	@Excel(name="更新时间",format = "yyyy-MM-dd")
	private java.util.Date updateTime;
	/**删除标志*/
	@Excel(name="删除标志")
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
	 *@return: java.lang.String  项目所属领域id
	 */
	@Column(name ="PROJECT_AREA_ID",nullable=true,length=32)
	public java.lang.String getProjectAreaId(){
		return this.projectAreaId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目所属领域id
	 */
	public void setProjectAreaId(java.lang.String projectAreaId){
		this.projectAreaId = projectAreaId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目所属类型id
	 */
	@Column(name ="PROJECT_TYPE_ID",nullable=true,length=32)
	public java.lang.String getProjectTypeId(){
		return this.projectTypeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目所属类型id
	 */
	public void setProjectTypeId(java.lang.String projectTypeId){
		this.projectTypeId = projectTypeId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目名称
	 */
	@Column(name ="PROJECT_NAME",nullable=true,length=50)
	public java.lang.String getProjectName(){
		return this.projectName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目名称
	 */
	public void setProjectName(java.lang.String projectName){
		this.projectName = projectName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目分类
	 */
	@Column(name ="PROJECT_CATALOG",nullable=true,length=255)
	public java.lang.String getProjectCatalog(){
		return this.projectCatalog;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目分类
	 */
	public void setProjectCatalog(java.lang.String projectCatalog){
		this.projectCatalog = projectCatalog;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目开始时间
	 */
	@Column(name ="PROJECT_START_TIME",nullable=true,length=50)
	public java.lang.String getProjectStartTime(){
		return this.projectStartTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目开始时间
	 */
	public void setProjectStartTime(java.lang.String projectStartTime){
		this.projectStartTime = projectStartTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目结束时间
	 */
	@Column(name ="PROJECT_END_TIME",nullable=true,length=50)
	public java.lang.String getProjectEndTime(){
		return this.projectEndTime;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目结束时间
	 */
	public void setProjectEndTime(java.lang.String projectEndTime){
		this.projectEndTime = projectEndTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  项目状态
	 */
	@Column(name ="PROJECT_STATUS",nullable=true,length=10)
	public java.lang.Integer getProjectStatus(){
		return this.projectStatus;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  项目状态
	 */
	public void setProjectStatus(java.lang.Integer projectStatus){
		this.projectStatus = projectStatus;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目简介
	 */
	@Column(name ="PROJECT_PROFILE",nullable=true)
	public java.lang.String getProjectProfile(){
		return this.projectProfile;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目简介
	 */
	public void setProjectProfile(java.lang.String projectProfile){
		this.projectProfile = projectProfile;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  审核码
	 */
	@Column(name ="CHECK_CODE",nullable=true,length=10)
	public java.lang.Integer getCheckCode(){
		return this.checkCode;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  审核码
	 */
	public void setCheckCode(java.lang.Integer checkCode){
		this.checkCode = checkCode;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目展示图片
	 */
	@Column(name ="PROJECT_IMGURL",nullable=true,length=200)
	public java.lang.String getProjectImgurl(){
		return this.projectImgurl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目展示图片
	 */
	public void setProjectImgurl(java.lang.String projectImgurl){
		this.projectImgurl = projectImgurl;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  项目等级
	 */
	@Column(name ="PROJECT_GRADE",nullable=true,length=10)
	public java.lang.Integer getProjectGrade(){
		return this.projectGrade;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  项目等级
	 */
	public void setProjectGrade(java.lang.Integer projectGrade){
		this.projectGrade = projectGrade;
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

	// =====================================映射关系========================================================
	/**项目所属领域*/
	private ProjectAreaEntity projectAreaEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_area_id",insertable = false,updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	public ProjectAreaEntity getProjectAreaEntity() {
		return projectAreaEntity;
	}

	public void setProjectAreaEntity(ProjectAreaEntity projectAreaEntity) {
		this.projectAreaEntity = projectAreaEntity;
	}

	/**项目所属类型*/
	private ProjectTypeEntity projectTypeEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "project_type_id",insertable = false,updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	public ProjectTypeEntity getProjectTypeEntity() {
		return projectTypeEntity;
	}

	public void setProjectTypeEntity(ProjectTypeEntity projectTypeEntity) {
		this.projectTypeEntity = projectTypeEntity;
	}
}
