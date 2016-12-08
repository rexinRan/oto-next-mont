package com.buss.entrepreneurshipprojectarticle.entity;

import com.buss.entrepreneurshiparticle.entity.DxsEntrepreneurshipArticleEntity;
import com.buss.file.entity.DxsFileEntity;
import com.buss.user.entity.DxsUserEntity;
import org.hibernate.annotations.*;
import org.jeecgframework.poi.excel.annotation.Excel;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

/**   
 * @Title: Entity
 * @Description: entrepreneurship_project_fund
 * @author onlineGenerator
 * @date 2016-06-28 19:18:33
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_entrepreneurship_project_fund", schema = "")
@SuppressWarnings("serial")
public class EntrepreneurshipProjectArticleEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**用户ID*/
	@Excel(name="用户ID")
	private String userId;
	/**基地外键*/
	@Excel(name="基地外键")
	private String applytoId;
	/**项目名称*/
	@Excel(name="项目名称")
	private String projectName;
	/**是否专利*/
	@Excel(name="是否专利")
	private String isPatent;
	/**项目介绍*/
	@Excel(name="项目介绍")
	private String projectIntroduce;
	/**所属领域*/
	@Excel(name="所属领域")
	private String projectionField;
	/**产品类型*/
	@Excel(name="产品类型")
	private String projectionType;
	/**项目计划书*/
	@Excel(name="项目计划书")
	private String projectionPlan;
	/**项目进展*/
	@Excel(name="项目进展")
	private String projectionProgress;
	/**经营范围*/
	@Excel(name="经营范围")
	private String projectionScope;
	/**审核码*/
	@Excel(name="审核码")
	private Integer checkCode;
	/**项目类型*/
	@Excel(name="项目类型")
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
	 *@return: java.lang.String  用户ID
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户ID
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  基地外键
	 */
	@Column(name ="APPLYTO_ID",nullable=true,length=32)
	public String getApplytoId(){
		return this.applytoId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  基地外键
	 */
	public void setApplytoId(String applytoId){
		this.applytoId = applytoId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目名称
	 */
	@Column(name ="PROJECT_NAME",nullable=true,length=100)
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
	 *@return: java.lang.String  是否专利
	 */
	@Column(name ="IS_PATENT",nullable=true,length=50)
	public String getIsPatent(){
		return this.isPatent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否专利
	 */
	public void setIsPatent(String isPatent){
		this.isPatent = isPatent;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目介绍
	 */
	@Column(name ="PROJECT_INTRODUCE",nullable=true,length=255)
	public String getProjectIntroduce(){
		return this.projectIntroduce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目介绍
	 */
	public void setProjectIntroduce(String projectIntroduce){
		this.projectIntroduce = projectIntroduce;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属领域
	 */
	@Column(name ="PROJECTION_FIELD",nullable=true,length=50)
	public String getProjectionField(){
		return this.projectionField;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属领域
	 */
	public void setProjectionField(String projectionField){
		this.projectionField = projectionField;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  产品类型
	 */
	@Column(name ="PROJECTION_TYPE",nullable=true,length=50)
	public String getProjectionType(){
		return this.projectionType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  产品类型
	 */
	public void setProjectionType(String projectionType){
		this.projectionType = projectionType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目计划书
	 */
	@Column(name ="PROJECTION_PLAN",nullable=true,length=200)
	public String getProjectionPlan(){
		return this.projectionPlan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目计划书
	 */
	public void setProjectionPlan(String projectionPlan){
		this.projectionPlan = projectionPlan;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目进展
	 */
	@Column(name ="PROJECTION_PROGRESS",nullable=true,length=255)
	public String getProjectionProgress(){
		return this.projectionProgress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目进展
	 */
	public void setProjectionProgress(String projectionProgress){
		this.projectionProgress = projectionProgress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  经营范围
	 */
	@Column(name ="PROJECTION_SCOPE",nullable=true,length=255)
	public String getProjectionScope(){
		return this.projectionScope;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  经营范围
	 */
	public void setProjectionScope(String projectionScope){
		this.projectionScope = projectionScope;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  项目类型
	 */
	@Column(name ="TYPE",nullable=true,length=10)
	public Integer getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  项目类型
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

	// =============================关系映射================================================
	/**
	 * 用户
	 */
	private DxsUserEntity dxsUserEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id",insertable = false,updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	public DxsUserEntity getDxsUserEntity() {
		return dxsUserEntity;
	}

	public void setDxsUserEntity(DxsUserEntity dxsUserEntity) {
		this.dxsUserEntity = dxsUserEntity;
	}

	/**
	 * 用户
	 */
	private DxsEntrepreneurshipArticleEntity entrepreneurshipArticleEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "applyto_id",insertable = false,updatable = false)
	@NotFound(action = NotFoundAction.IGNORE)
	public DxsEntrepreneurshipArticleEntity getEntrepreneurshipArticleEntity() {
		return entrepreneurshipArticleEntity;
	}

	public void setEntrepreneurshipArticleEntity(DxsEntrepreneurshipArticleEntity entrepreneurshipArticleEntity) {
		this.entrepreneurshipArticleEntity = entrepreneurshipArticleEntity;
	}

	/**
	 * 文件表
	 */
/*	@OneToMany(mappedBy="employmentRecordEntity")
	@LazyCollection(LazyCollectionOption.EXTRA)*/

	private Set<DxsFileEntity> dxsFileEntitySet;

	@OneToMany(mappedBy = "entrepreneurshipProjectFundEntity")
	@LazyCollection(LazyCollectionOption.EXTRA)
	public Set<DxsFileEntity> getDxsFileEntitySet() {
		return dxsFileEntitySet;
	}

	public void setDxsFileEntitySet(Set<DxsFileEntity> dxsFileEntitySet) {
		this.dxsFileEntitySet = dxsFileEntitySet;
	}
}
