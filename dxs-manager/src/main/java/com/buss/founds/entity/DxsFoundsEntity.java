package com.buss.founds.entity;

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
 * @Description: dxs_founds
 * @author onlineGenerator
 * @date 2016-07-25 13:59:44
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_founds", schema = "")
@SuppressWarnings("serial")
public class DxsFoundsEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**用户id*/
	@Excel(name="用户id")
	private String userId;
	/**基金名称*/
	@Excel(name="基金名称")
	private String foundTitle;
	/**log文件*/
	@Excel(name="log文件")
	private String foundImgFid;
	/**logURL*/
	@Excel(name="logURL")
	private java.lang.String foundImgUrl;
	/**创始人*/
	@Excel(name="创始人")
	private String foundUserName;
	/**关注领域*/
	@Excel(name="关注领域")
	private String foundIndustry;
	/**投资阶段*/
	@Excel(name="投资阶段")
	private String foundStage;
	/**基金金额*/
	@Excel(name="基金金额")
	private Integer foundNum;
	/**简介*/
	@Excel(name="简介")
	private java.lang.String foundSummary;
	/**基金介绍*/
	@Excel(name="基金介绍")
	private String foundIntroduce;
	/**办公地点*/
	@Excel(name="办公地点")
	private String foundAddress;
	/**成功案例*/
	@Excel(name="成功案例")
	private String foundException;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private Date createTime;
	/**修改时间*/
	@Excel(name="修改时间",format = "yyyy-MM-dd")
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
	 *@return: java.lang.String  基金名称
	 */
	@Column(name ="FOUND_TITLE",nullable=true,length=200)
	public String getFoundTitle(){
		return this.foundTitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  基金名称
	 */
	public void setFoundTitle(String foundTitle){
		this.foundTitle = foundTitle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  log文件
	 */
	@Column(name ="FOUND_IMG_FID",nullable=true,length=255)
	public String getFoundImgFid(){
		return this.foundImgFid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  log文件
	 */
	public void setFoundImgFid(String foundImgFid){
		this.foundImgFid = foundImgFid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  logURL
	 */
	@Column(name ="FOUND_IMG_URL",nullable=true,length=255)
	public java.lang.String getFoundImgUrl(){
		return this.foundImgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  logURL
	 */
	public void setFoundImgUrl(java.lang.String foundImgUrl){
		this.foundImgUrl = foundImgUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  创始人
	 */
	@Column(name ="FOUND_USER_NAME",nullable=true,length=255)
	public String getFoundUserName(){
		return this.foundUserName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  创始人
	 */
	public void setFoundUserName(String foundUserName){
		this.foundUserName = foundUserName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  关注领域
	 */
	@Column(name ="FOUND_INDUSTRY",nullable=true,length=255)
	public String getFoundIndustry(){
		return this.foundIndustry;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  关注领域
	 */
	public void setFoundIndustry(String foundIndustry){
		this.foundIndustry = foundIndustry;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  投资阶段
	 */
	@Column(name ="FOUND_STAGE",nullable=true,length=50)
	public String getFoundStage(){
		return this.foundStage;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  投资阶段
	 */
	public void setFoundStage(String foundStage){
		this.foundStage = foundStage;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  基金金额
	 */
	@Column(name ="FOUND_NUM",nullable=true,length=10)
	public Integer getFoundNum(){
		return this.foundNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  基金金额
	 */
	public void setFoundNum(Integer foundNum){
		this.foundNum = foundNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  简介
	 */
	@Column(name ="FOUND_SUMMARY",nullable=true,length=255)
	public java.lang.String getFoundSummary(){
		return this.foundSummary;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  简介
	 */
	public void setFoundSummary(java.lang.String foundSummary){
		this.foundSummary = foundSummary;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  基金介绍
	 */
	@Column(name ="FOUND_INTRODUCE",nullable=true,length=16777215)
	public String getFoundIntroduce(){
		return this.foundIntroduce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  基金介绍
	 */
	public void setFoundIntroduce(String foundIntroduce){
		this.foundIntroduce = foundIntroduce;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  办公地点
	 */
	@Column(name ="FOUND_ADDRESS",nullable=true,length=255)
	public String getFoundAddress(){
		return this.foundAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  办公地点
	 */
	public void setFoundAddress(String foundAddress){
		this.foundAddress = foundAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  成功案例
	 */
	@Column(name ="FOUND_EXCEPTION",nullable=true,length=255)
	public String getFoundException(){
		return this.foundException;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  成功案例
	 */
	public void setFoundException(String foundException){
		this.foundException = foundException;
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
	 *@return: java.util.Date  修改时间
	 */
	@Column(name ="UPDATE_TIME",nullable=true)
	public Date getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  修改时间
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
