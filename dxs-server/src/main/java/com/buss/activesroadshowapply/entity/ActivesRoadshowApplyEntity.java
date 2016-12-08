package com.buss.activesroadshowapply.entity;

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
 * @Description: dxs_actives_roadshow_apply
 * @author onlineGenerator
 * @date 2016-08-18 13:36:17
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_actives_roadshow_apply", schema = "")
@SuppressWarnings("serial")
public class ActivesRoadshowApplyEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**申请人id*/
	private java.lang.String userId;
	/**活动的ID*/
	private java.lang.String activesId;
	/**企业所在地*/
	private java.lang.String companyAddress;
	/**注册资金*/
	private java.lang.String regFound;
	/**企业简介*/
	private java.lang.String companyIntroduce;
	/**团队介绍*/
	private java.lang.String companyTeamIntroduce;
	/**项目介绍*/
	private java.lang.String projectIntroduce;
	/**项目名称*/
	private java.lang.String projectName;
	/**项目前景*/
	private java.lang.String projectProspect;
	/**行业优势*/
	private java.lang.String industryAdvantage;
	/**文件地址*/
	private java.lang.String fileUrl;
	/**文件id*/
	private java.lang.String fileId;
	/**路演需求*/
	private java.lang.String roadshowNeed;
	/**处理结果*/
	private java.lang.Integer result;
	/**处理结果说明*/
	private java.lang.String message;
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
	 *@return: java.lang.String  申请人id
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public java.lang.String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  申请人id
	 */
	public void setUserId(java.lang.String userId){
		this.userId = userId;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动ID
	 */
	@Column(name ="ACTIVES_ID",nullable=true,length=32)
	public String getActivesId() {
		return activesId;
	}

	public void setActivesId(String activesId) {
		this.activesId = activesId;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  企业所在地
	 */
	@Column(name ="COMPANY_ADDRESS",nullable=true,length=255)
	public java.lang.String getCompanyAddress(){
		return this.companyAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  企业所在地
	 */
	public void setCompanyAddress(java.lang.String companyAddress){
		this.companyAddress = companyAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  注册资金
	 */
	@Column(name ="REG_FOUND",nullable=true,length=20)
	public java.lang.String getRegFound(){
		return this.regFound;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  注册资金
	 */
	public void setRegFound(java.lang.String regFound){
		this.regFound = regFound;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  企业简介
	 */
	@Column(name ="COMPANY_INTRODUCE",nullable=true,length=16777215)
	public java.lang.String getCompanyIntroduce(){
		return this.companyIntroduce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  企业简介
	 */
	public void setCompanyIntroduce(java.lang.String companyIntroduce){
		this.companyIntroduce = companyIntroduce;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  团队介绍
	 */
	@Column(name ="COMPANY_TEAM_INTRODUCE",nullable=true,length=16777215)
	public java.lang.String getCompanyTeamIntroduce(){
		return this.companyTeamIntroduce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  团队介绍
	 */
	public void setCompanyTeamIntroduce(java.lang.String companyTeamIntroduce){
		this.companyTeamIntroduce = companyTeamIntroduce;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目介绍
	 */
	@Column(name ="PROJECT_INTRODUCE",nullable=true,length=16777215)
	public java.lang.String getProjectIntroduce(){
		return this.projectIntroduce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目介绍
	 */
	public void setProjectIntroduce(java.lang.String projectIntroduce){
		this.projectIntroduce = projectIntroduce;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  项目名称
	 */
	@Column(name ="PROJECT_NAME",nullable=true,length=255)
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
	 *@return: java.lang.String  项目前景
	 */
	@Column(name ="PROJECT_PROSPECT",nullable=true,length=16777215)
	public java.lang.String getProjectProspect(){
		return this.projectProspect;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目前景
	 */
	public void setProjectProspect(java.lang.String projectProspect){
		this.projectProspect = projectProspect;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  行业优势
	 */
	@Column(name ="INDUSTRY_ADVANTAGE",nullable=true,length=16777215)
	public java.lang.String getIndustryAdvantage(){
		return this.industryAdvantage;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  行业优势
	 */
	public void setIndustryAdvantage(java.lang.String industryAdvantage){
		this.industryAdvantage = industryAdvantage;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文件地址
	 */
	@Column(name ="FILE_URL",nullable=true,length=255)
	public java.lang.String getFileUrl(){
		return this.fileUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文件地址
	 */
	public void setFileUrl(java.lang.String fileUrl){
		this.fileUrl = fileUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文件id
	 */
	@Column(name ="FILE_ID",nullable=true,length=32)
	public java.lang.String getFileId(){
		return this.fileId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文件id
	 */
	public void setFileId(java.lang.String fileId){
		this.fileId = fileId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  路演需求
	 */
	@Column(name ="ROADSHOW_NEED",nullable=true,length=16777215)
	public java.lang.String getRoadshowNeed(){
		return this.roadshowNeed;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  路演需求
	 */
	public void setRoadshowNeed(java.lang.String roadshowNeed){
		this.roadshowNeed = roadshowNeed;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  处理结果
	 */
	@Column(name ="RESULT",nullable=true,length=10)
	public java.lang.Integer getResult(){
		return this.result;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  处理结果
	 */
	public void setResult(java.lang.Integer result){
		this.result = result;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  处理结果说明
	 */
	@Column(name ="MESSAGE",nullable=true,length=16777215)
	public java.lang.String getMessage(){
		return this.message;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  处理结果说明
	 */
	public void setMessage(java.lang.String message){
		this.message = message;
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
