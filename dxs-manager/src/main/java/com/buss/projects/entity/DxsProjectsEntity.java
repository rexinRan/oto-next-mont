package com.buss.projects.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.competition.entity.DxsCompetitionEntity;
import com.buss.user.entity.DxsUserEntity;
import org.hibernate.annotations.GenericGenerator;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_projects
 * @author onlineGenerator
 * @date 2016-07-21 14:17:28
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_projects", schema = "")
@SuppressWarnings("serial")
public class DxsProjectsEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**用户的id*/
	@Excel(name="用户的id")
	private String userId;
	/**竞赛ID*/
	@Excel(name="竞赛ID")
	private String bcId;
	/**项目标识*/
	@Excel(name="项目标识")
	private String projectImg;
	/**项目名称*/
	@Excel(name="项目名称")
	private String projectName;
	/**项目所在地*/
	@Excel(name="项目所在地")
	private java.lang.String projectAddress;
	/**所属行业*/
	@Excel(name="所属行业")
	private String projectIndustry;
	/**所属类别*/
	@Excel(name="所属类别")
	private String projectType;
	/**是否与高校科技结合*/
	@Excel(name="是否与高校科技结合")
	private String isSchoolTechnology;
	/**股权结构*/
	@Excel(name="股权结构")
	private String isStock;
	/**团队名称*/
	@Excel(name="团队名称")
	private String teamName;
	/**项目介绍*/
	@Excel(name="项目介绍")
	private String projectIntroduce;
	/**项目进展*/
	@Excel(name="项目进展")
	private String projectProgress;
	/**项目计划书*/
	@Excel(name="项目计划书")
	private String projectPlanFileurl;
	/**成员人数*/
	@Excel(name="成员人数")
	private Integer userNum;
	/**隐私设置*/
	@Excel(name="隐私设置")
	private String isPrivacy;
	/**是否结束*/
	@Excel(name="是否结束")
	private String isEnd;
	/**是否已获投资*/
	@Excel(name="是否已获投资")
	private java.lang.Integer isFound;
	/**是否已获基地*/
	@Excel(name="是否已获基地")
	private java.lang.Integer isAddress;
	/**基金需求*/
	@Excel(name="基金需求")
	private String foundNeed;
	/**基地需求*/
	@Excel(name="基地需求")
	private String addressNeed;
	/**招聘需求*/
	@Excel(name="招聘需求")
	private String recruitNeed;
	/**参赛类型(给推荐预留)*/
	@Excel(name="参赛类型(给推荐预留)")
	private String joinType;
	/**晋级级别*/
	@Excel(name="晋级级别")
	private java.lang.String projectClass;
	/**备注*/
	@Excel(name="备注")
	private java.lang.String remarks;
	/**创建年*/
	@Excel(name="创建年")
	private java.lang.String createYear;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private Date createTime;
	/**修改次数*/
	@Excel(name="修改次数")
	private Integer updateCount;
	/**更新时间*/
	@Excel(name="更新时间",format = "yyyy-MM-dd")
	private Date updateTime;
	/**删除标志*/
	@Excel(name="删除标志")
	private Integer isDelete;

	private DxsCompetitionEntity dxsCompetitionEntity;

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
	 *@return: java.lang.String  用户的id
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户的id
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  竞赛ID
	 */
	@Column(name ="BC_ID",nullable=true,length=32)
	public String getBcId(){
		return this.bcId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  竞赛ID
	 */
	public void setBcId(String bcId){
		this.bcId = bcId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目标识
	 */
	@Column(name ="PROJECT_IMG",nullable=true,length=255)
	public String getProjectImg(){
		return this.projectImg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目标识
	 */
	public void setProjectImg(String projectImg){
		this.projectImg = projectImg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目名称
	 */
	@Column(name ="PROJECT_NAME",nullable=true,length=200)
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
	 *@return: java.lang.String  项目所在地
	 */
	@Column(name ="PROJECT_ADDRESS",nullable=true,length=255)
	public java.lang.String getProjectAddress(){
		return this.projectAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目所在地
	 */
	public void setProjectAddress(java.lang.String projectAddress){
		this.projectAddress = projectAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属行业
	 */
	@Column(name ="PROJECT_INDUSTRY",nullable=true,length=200)
	public String getProjectIndustry(){
		return this.projectIndustry;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属行业
	 */
	public void setProjectIndustry(String projectIndustry){
		this.projectIndustry = projectIndustry;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属类别
	 */
	@Column(name ="PROJECT_TYPE",nullable=true,length=255)
	public String getProjectType(){
		return this.projectType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属类别
	 */
	public void setProjectType(String projectType){
		this.projectType = projectType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否与高校科技结合
	 */
	@Column(name ="IS_SCHOOL_TECHNOLOGY",nullable=true,length=255)
	public String getIsSchoolTechnology(){
		return this.isSchoolTechnology;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否与高校科技结合
	 */
	public void setIsSchoolTechnology(String isSchoolTechnology){
		this.isSchoolTechnology = isSchoolTechnology;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  股权结构
	 */
	@Column(name ="IS_STOCK",nullable=true,length=255)
	public String getIsStock(){
		return this.isStock;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  股权结构
	 */
	public void setIsStock(String isStock){
		this.isStock = isStock;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  团队名称
	 */
	@Column(name ="TEAM_NAME",nullable=true,length=255)
	public String getTeamName(){
		return this.teamName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  团队名称
	 */
	public void setTeamName(String teamName){
		this.teamName = teamName;
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
	 *@return: java.lang.String  项目进展
	 */
	@Column(name ="PROJECT_PROGRESS",nullable=true,length=255)
	public String getProjectProgress(){
		return this.projectProgress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目进展
	 */
	public void setProjectProgress(String projectProgress){
		this.projectProgress = projectProgress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目计划书
	 */
	@Column(name ="PROJECT_PLAN_FILEURL",nullable=true,length=255)
	public String getProjectPlanFileurl(){
		return this.projectPlanFileurl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目计划书
	 */
	public void setProjectPlanFileurl(String projectPlanFileurl){
		this.projectPlanFileurl = projectPlanFileurl;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  成员人数
	 */
	@Column(name ="USER_NUM",nullable=true,length=10)
	public Integer getUserNum(){
		return this.userNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  成员人数
	 */
	public void setUserNum(Integer userNum){
		this.userNum = userNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  隐私设置
	 */
	@Column(name ="IS_PRIVACY",nullable=true,length=255)
	public String getIsPrivacy(){
		return this.isPrivacy;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  隐私设置
	 */
	public void setIsPrivacy(String isPrivacy){
		this.isPrivacy = isPrivacy;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  是否结束
	 */
	@Column(name ="IS_END",nullable=true,length=2)
	public String getIsEnd(){
		return this.isEnd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  是否结束
	 */
	public void setIsEnd(String isEnd){
		this.isEnd = isEnd;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否已获投资
	 */
	@Column(name ="IS_FOUND",nullable=true,length=3)
	public java.lang.Integer getIsFound(){
		return this.isFound;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否已获投资
	 */
	public void setIsFound(java.lang.Integer isFound){
		this.isFound = isFound;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否已获基地
	 */
	@Column(name ="IS_ADDRESS",nullable=true,length=3)
	public java.lang.Integer getIsAddress(){
		return this.isAddress;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否已获基地
	 */
	public void setIsAddress(java.lang.Integer isAddress){
		this.isAddress = isAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  基金需求
	 */
	@Column(name ="FOUND_NEED",nullable=true,length=255)
	public String getFoundNeed(){
		return this.foundNeed;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  基金需求
	 */
	public void setFoundNeed(String foundNeed){
		this.foundNeed = foundNeed;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  基地需求
	 */
	@Column(name ="ADDRESS_NEED",nullable=true,length=255)
	public String getAddressNeed(){
		return this.addressNeed;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  基地需求
	 */
	public void setAddressNeed(String addressNeed){
		this.addressNeed = addressNeed;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  招聘需求
	 */
	@Column(name ="RECRUIT_NEED",nullable=true,length=255)
	public String getRecruitNeed(){
		return this.recruitNeed;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  招聘需求
	 */
	public void setRecruitNeed(String recruitNeed){
		this.recruitNeed = recruitNeed;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参赛类型(给推荐预留)
	 */
	@Column(name ="JOIN_TYPE",nullable=true,length=255)
	public String getJoinType(){
		return this.joinType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参赛类型(给推荐预留)
	 */
	public void setJoinType(String joinType){
		this.joinType = joinType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  晋级级别
	 */
	@Column(name ="PROJECT_CLASS",nullable=true,length=50)
	public java.lang.String getProjectClass(){
		return this.projectClass;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  晋级级别
	 */
	public void setProjectClass(java.lang.String projectClass){
		this.projectClass = projectClass;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARKS",nullable=true,length=255)
	public java.lang.String getRemarks(){
		return this.remarks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemarks(java.lang.String remarks){
		this.remarks = remarks;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创建年
	 */
	@Column(name ="CREATE_YEAR",nullable=true,length=255)
	public java.lang.String getCreateYear(){
		return this.createYear;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创建年
	 */
	public void setCreateYear(java.lang.String createYear){
		this.createYear = createYear;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  修改次数
	 */
	@Column(name ="UPDATE_COUNT",nullable=true,length=10)
	public Integer getUpdateCount(){
		return this.updateCount;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  修改次数
	 */
	public void setUpdateCount(Integer updateCount){
		this.updateCount = updateCount;
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
	@JoinColumn(name = "bc_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)
	public DxsCompetitionEntity getDxsCompetitionEntity() {
		return dxsCompetitionEntity;
	}

	public void setDxsCompetitionEntity(DxsCompetitionEntity dxsCompetitionEntity) {
		this.dxsCompetitionEntity = dxsCompetitionEntity;
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
