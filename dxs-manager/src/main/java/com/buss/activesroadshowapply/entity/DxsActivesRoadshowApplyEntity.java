package com.buss.activesroadshowapply.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.user.entity.DxsUserEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_actives_roadshow_apply
 * @author onlineGenerator
 * @date 2016-08-18 13:36:17
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_actives_roadshow_apply", schema = "")
@SuppressWarnings("serial")
public class DxsActivesRoadshowApplyEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**活动id*/
	@Excel(name="活动id")
	private java.lang.String activesId;
	/**申请人id*/
	@Excel(name="申请人id")
	private String userId;
	/**企业所在地*/
	@Excel(name="企业所在地")
	private String companyAddress;
	/**注册资金*/
	@Excel(name="注册资金")
	private String regFound;
	/**企业简介*/
	@Excel(name="企业简介")
	private String companyIntroduce;
	/**团队介绍*/
	@Excel(name="团队介绍")
	private String companyTeamIntroduce;
	/**项目介绍*/
	@Excel(name="项目介绍")
	private String projectIntroduce;
	/**项目名称*/
	@Excel(name="项目名称")
	private String projectName;
	/**项目前景*/
	@Excel(name="项目前景")
	private String projectProspect;
	/**行业优势*/
	@Excel(name="行业优势")
	private String industryAdvantage;
	/**文件地址*/
	@Excel(name="文件地址")
	private String fileUrl;
	/**文件id*/
	@Excel(name="文件id")
	private String fileId;
	/**路演需求*/
	@Excel(name="路演需求")
	private String roadshowNeed;
	/**处理结果*/
	@Excel(name="处理结果")
	private Integer result;
	/**处理结果说明*/
	@Excel(name="处理结果说明")
	private String message;
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
	 *@return: java.lang.String  申请人id
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请人id
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动id
	 */
	@Column(name ="ACTIVES_ID",nullable=true,length=32)
	public java.lang.String getActivesId(){
		return this.activesId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动id
	 */
	public void setActivesId(java.lang.String activesId){
		this.activesId = activesId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  企业所在地
	 */
	@Column(name ="COMPANY_ADDRESS",nullable=true,length=255)
	public String getCompanyAddress(){
		return this.companyAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  企业所在地
	 */
	public void setCompanyAddress(String companyAddress){
		this.companyAddress = companyAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  注册资金
	 */
	@Column(name ="REG_FOUND",nullable=true,length=20)
	public String getRegFound(){
		return this.regFound;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  注册资金
	 */
	public void setRegFound(String regFound){
		this.regFound = regFound;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  企业简介
	 */
	@Column(name ="COMPANY_INTRODUCE",nullable=true,length=16777215)
	public String getCompanyIntroduce(){
		return this.companyIntroduce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  企业简介
	 */
	public void setCompanyIntroduce(String companyIntroduce){
		this.companyIntroduce = companyIntroduce;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  团队介绍
	 */
	@Column(name ="COMPANY_TEAM_INTRODUCE",nullable=true,length=16777215)
	public String getCompanyTeamIntroduce(){
		return this.companyTeamIntroduce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  团队介绍
	 */
	public void setCompanyTeamIntroduce(String companyTeamIntroduce){
		this.companyTeamIntroduce = companyTeamIntroduce;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目介绍
	 */
	@Column(name ="PROJECT_INTRODUCE",nullable=true,length=16777215)
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
	 *@return: java.lang.String  项目名称
	 */
	@Column(name ="PROJECT_NAME",nullable=true,length=255)
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
	 *@return: java.lang.String  项目前景
	 */
	@Column(name ="PROJECT_PROSPECT",nullable=true,length=16777215)
	public String getProjectProspect(){
		return this.projectProspect;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目前景
	 */
	public void setProjectProspect(String projectProspect){
		this.projectProspect = projectProspect;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  行业优势
	 */
	@Column(name ="INDUSTRY_ADVANTAGE",nullable=true,length=16777215)
	public String getIndustryAdvantage(){
		return this.industryAdvantage;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  行业优势
	 */
	public void setIndustryAdvantage(String industryAdvantage){
		this.industryAdvantage = industryAdvantage;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文件地址
	 */
	@Column(name ="FILE_URL",nullable=true,length=255)
	public String getFileUrl(){
		return this.fileUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文件地址
	 */
	public void setFileUrl(String fileUrl){
		this.fileUrl = fileUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文件id
	 */
	@Column(name ="FILE_ID",nullable=true,length=32)
	public String getFileId(){
		return this.fileId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文件id
	 */
	public void setFileId(String fileId){
		this.fileId = fileId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  路演需求
	 */
	@Column(name ="ROADSHOW_NEED",nullable=true,length=16777215)
	public String getRoadshowNeed(){
		return this.roadshowNeed;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  路演需求
	 */
	public void setRoadshowNeed(String roadshowNeed){
		this.roadshowNeed = roadshowNeed;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  处理结果
	 */
	@Column(name ="RESULT",nullable=true,length=10)
	public Integer getResult(){
		return this.result;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  处理结果
	 */
	public void setResult(Integer result){
		this.result = result;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  处理结果说明
	 */
	@Column(name ="MESSAGE",nullable=true,length=16777215)
	public String getMessage(){
		return this.message;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  处理结果说明
	 */
	public void setMessage(String message){
		this.message = message;
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

//-------------------------------大权添加与表dxs_users的多对一关联------------------------------------------
	private DxsUserEntity dxsUserEntity;

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
