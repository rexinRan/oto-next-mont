package com.buss.competition.entity;

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
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_competition
 * @author onlineGenerator
 * @date 2016-07-21 15:40:26
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_competition", schema = "")
@SuppressWarnings("serial")
public class DxsCompetitionEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**用户id*/
	@Excel(name="用户id")
	private String userId;
	/**缩略图id*/
	@Excel(name="缩略图id")
	private java.lang.String competitionImgId;
	/**缩略图URL*/
	@Excel(name="缩略图URL")
	private java.lang.String competitionImgUrl;
	/**大赛名称*/
	@Excel(name="大赛名称")
	private String competitionTitle;
	/**主办方*/
	@Excel(name="主办方")
	private String competitionOrganisers;
	/**大赛简介*/
	@Excel(name="大赛简介")
	private String competitionIntroduce;
	/**大赛开始时间*/
	@Excel(name="大赛开始时间",format = "yyyy-MM-dd")
	private Date competitionStartTime;
	/**大赛结束时间*/
	@Excel(name="大赛结束时间",format = "yyyy-MM-dd")
	private Date competitionEndTime;
	/**赛区范围*/
	@Excel(name="赛区范围")
	private String competitionAreas;
	/**大赛主旨*/
	@Excel(name="大赛主旨")
	private String competitionTopic;
	/**参赛对象*/
	@Excel(name="参赛对象")
	private String competitionObject;
	/**大赛规则*/
	@Excel(name="大赛规则")
	private String competitionRule;
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
	 *@return: java.lang.String  缩略图id
	 */
	@Column(name ="COMPETITION_IMG_ID",nullable=true,length=32)
	public java.lang.String getCompetitionImgId(){
		return this.competitionImgId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  缩略图id
	 */
	public void setCompetitionImgId(java.lang.String competitionImgId){
		this.competitionImgId = competitionImgId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  缩略图URL
	 */
	@Column(name ="COMPETITION_IMG_URL",nullable=true,length=255)
	public java.lang.String getCompetitionImgUrl(){
		return this.competitionImgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  缩略图URL
	 */
	public void setCompetitionImgUrl(java.lang.String competitionImgUrl){
		this.competitionImgUrl = competitionImgUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  大赛名称
	 */
	@Column(name ="COMPETITION_TITLE",nullable=true,length=255)
	public String getCompetitionTitle(){
		return this.competitionTitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  大赛名称
	 */
	public void setCompetitionTitle(String competitionTitle){
		this.competitionTitle = competitionTitle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主办方
	 */
	@Column(name ="COMPETITION_ORGANISERS",nullable=true,length=255)
	public String getCompetitionOrganisers(){
		return this.competitionOrganisers;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主办方
	 */
	public void setCompetitionOrganisers(String competitionOrganisers){
		this.competitionOrganisers = competitionOrganisers;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  大赛简介
	 */
	@Column(name ="COMPETITION_INTRODUCE",nullable=true)
	public String getCompetitionIntroduce(){
		return this.competitionIntroduce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  大赛简介
	 */
	public void setCompetitionIntroduce(String competitionIntroduce){
		this.competitionIntroduce = competitionIntroduce;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  大赛开始时间
	 */
	@Column(name ="COMPETITION_START_TIME",nullable=true)
	public Date getCompetitionStartTime(){
		return this.competitionStartTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  大赛开始时间
	 */
	public void setCompetitionStartTime(Date competitionStartTime){
		this.competitionStartTime = competitionStartTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  大赛结束时间
	 */
	@Column(name ="COMPETITION_END_TIME",nullable=true)
	public Date getCompetitionEndTime(){
		return this.competitionEndTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  大赛结束时间
	 */
	public void setCompetitionEndTime(Date competitionEndTime){
		this.competitionEndTime = competitionEndTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  赛区范围
	 */
	@Column(name ="COMPETITION_AREAS",nullable=true,length=255)
	public String getCompetitionAreas(){
		return this.competitionAreas;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  赛区范围
	 */
	public void setCompetitionAreas(String competitionAreas){
		this.competitionAreas = competitionAreas;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  大赛主旨
	 */
	@Column(name ="COMPETITION_TOPIC",nullable=true,length=255)
	public String getCompetitionTopic(){
		return this.competitionTopic;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  大赛主旨
	 */
	public void setCompetitionTopic(String competitionTopic){
		this.competitionTopic = competitionTopic;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  参赛对象
	 */
	@Column(name ="COMPETITION_OBJECT",nullable=true,length=255)
	public String getCompetitionObject(){
		return this.competitionObject;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  参赛对象
	 */
	public void setCompetitionObject(String competitionObject){
		this.competitionObject = competitionObject;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  大赛规则
	 */
	@Column(name ="COMPETITION_RULE",nullable=true)
	public String getCompetitionRule(){
		return this.competitionRule;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  大赛规则
	 */
	public void setCompetitionRule(String competitionRule){
		this.competitionRule = competitionRule;
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
