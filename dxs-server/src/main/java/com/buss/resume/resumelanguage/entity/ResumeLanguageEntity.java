package com.buss.resume.resumelanguage.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: dxs_resume_language
 * @author lu
 * @date 2016-06-22 10:13:14
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_resume_language", catalog = "dxsdb")
@SuppressWarnings("serial")
public class ResumeLanguageEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**简历ID*/

	private String resumeId;
	/**语种*/

	private String languageName;
	/**听说能力*/

	private String languageListenSay;
	/**读写能力*/

	private String languageReadWrite;
	/**等级考试*/

	private String languageClass;
	/**得分*/

	private String languageSore;
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
	 *@return: java.lang.String  语种
	 */
	@Column(name ="LANGUAGE_NAME",nullable=true,length=20)
	public String getLanguageName(){
		return this.languageName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  语种
	 */
	public void setLanguageName(String languageName){
		this.languageName = languageName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  听说能力
	 */
	@Column(name ="LANGUAGE_LISTEN_SAY",nullable=true,length=10)
	public String getLanguageListenSay(){
		return this.languageListenSay;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  听说能力
	 */
	public void setLanguageListenSay(String languageListenSay){
		this.languageListenSay = languageListenSay;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  读写能力
	 */
	@Column(name ="LANGUAGE_READ_WRITE",nullable=true,length=10)
	public String getLanguageReadWrite(){
		return this.languageReadWrite;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  读写能力
	 */
	public void setLanguageReadWrite(String languageReadWrite){
		this.languageReadWrite = languageReadWrite;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  等级考试
	 */
	@Column(name ="LANGUAGE_CLASS",nullable=true,length=10)
	public String getLanguageClass(){
		return this.languageClass;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  等级考试
	 */
	public void setLanguageClass(String languageClass){
		this.languageClass = languageClass;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  得分
	 */
	@Column(name ="LANGUAGE_SORE",nullable=true,length=5)
	public String getLanguageSore(){
		return this.languageSore;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  得分
	 */
	public void setLanguageSore(String languageSore){
		this.languageSore = languageSore;
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
