package com.buss.resumetemplate.entity;

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
 * @Description: dxs_resume_template
 * @author onlineGenerator
 * @date 2016-08-30 11:44:03
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_resume_template", schema = "")
@SuppressWarnings("serial")
public class DxsResumeTemplateEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**模板名称*/
	@Excel(name="模板名称")
	private String templateName;
	/**求职意向*/
	@Excel(name="求职意向")
	private String jobIntention;
	/**模板风格*/
	@Excel(name="模板风格")
	private String templateStyle;
	/**模板语言*/
	@Excel(name="模板语言")
	private String templateLanguage;
	/**模板图片*/
	@Excel(name="模板图片")
	private String imgUrl;
	/**大图*/
	@Excel(name="大图")
	private java.lang.String bigImgUrl;
	/**模板分类*/
	@Excel(name="模板分类")
	private String templateCatelog;
	/**模板访问地址*/
	@Excel(name="模板访问地址")
	private String templateUrl;
	/**模板特点*/
	@Excel(name="模板特点")
	private String templateFeature;
	/**价格*/
	@Excel(name="价格")
	private Integer price;
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
	 *@return: java.lang.String  模板名称
	 */
	@Column(name ="TEMPLATE_NAME",nullable=true,length=100)
	public String getTemplateName(){
		return this.templateName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  模板名称
	 */
	public void setTemplateName(String templateName){
		this.templateName = templateName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  求职意向
	 */
	@Column(name ="JOB_INTENTION",nullable=true,length=100)
	public String getJobIntention(){
		return this.jobIntention;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  求职意向
	 */
	public void setJobIntention(String jobIntention){
		this.jobIntention = jobIntention;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  模板风格
	 */
	@Column(name ="TEMPLATE_STYLE",nullable=true,length=100)
	public String getTemplateStyle(){
		return this.templateStyle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  模板风格
	 */
	public void setTemplateStyle(String templateStyle){
		this.templateStyle = templateStyle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  模板语言
	 */
	@Column(name ="TEMPLATE_LANGUAGE",nullable=true,length=100)
	public String getTemplateLanguage(){
		return this.templateLanguage;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  模板语言
	 */
	public void setTemplateLanguage(String templateLanguage){
		this.templateLanguage = templateLanguage;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  模板图片
	 */
	@Column(name ="IMG_URL",nullable=true,length=100)
	public String getImgUrl(){
		return this.imgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  模板图片
	 */
	public void setImgUrl(String imgUrl){
		this.imgUrl = imgUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  大图
	 */
	@Column(name ="BIG_IMG_URL",nullable=true,length=255)
	public java.lang.String getBigImgUrl(){
		return this.bigImgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  大图
	 */
	public void setBigImgUrl(java.lang.String bigImgUrl){
		this.bigImgUrl = bigImgUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  模板分类
	 */
	@Column(name ="TEMPLATE_CATELOG",nullable=true,length=100)
	public String getTemplateCatelog(){
		return this.templateCatelog;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  模板分类
	 */
	public void setTemplateCatelog(String templateCatelog){
		this.templateCatelog = templateCatelog;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  模板访问地址
	 */
	@Column(name ="TEMPLATE_URL",nullable=true,length=255)
	public String getTemplateUrl(){
		return this.templateUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  模板访问地址
	 */
	public void setTemplateUrl(String templateUrl){
		this.templateUrl = templateUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  模板特点
	 */
	@Column(name ="TEMPLATE_FEATURE",nullable=true,length=16777215)
	public String getTemplateFeature(){
		return this.templateFeature;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  模板特点
	 */
	public void setTemplateFeature(String templateFeature){
		this.templateFeature = templateFeature;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  价格
	 */
	@Column(name ="PRICE",nullable=true,length=10)
	public Integer getPrice(){
		return this.price;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  价格
	 */
	public void setPrice(Integer price){
		this.price = price;
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
