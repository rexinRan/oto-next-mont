package com.buss.specialshiring.entity;

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
 * @Description: dxs_specials_hiring
 * @author onlineGenerator
 * @date 2016-08-08 17:16:28
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_specials_hiring", schema = "")
@SuppressWarnings("serial")
public class SpecialsHiringEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**专项就业id*/
	private java.lang.String specialsId;
	/**标题*/
	private java.lang.String title;
	/**简介*/
	private java.lang.String introduce;
	/**选聘范围*/
	private java.lang.String hiringRange;
	/**选聘数量*/
	private java.lang.Integer hiringNum;
	/**选聘专业*/
	private java.lang.String hiringMajor;
	/**选聘条件*/
	private java.lang.String hiringCondition;
	/**选聘地点*/
	private java.lang.String hiringPlace;
	/**志愿项目*/
	private java.lang.String hiringJob;
	/**网上报名时间及要求*/
	private java.lang.String hiringNet;
	/**笔试时间及要求*/
	private java.lang.String hiringExam;
	/**资格初审内容及标准*/
	private java.lang.String hiringStandard;
	/**面试时间及相关事宜*/
	private java.lang.String hiringInterview;
	/**确定拟聘用人员时间及标准*/
	private java.lang.String hiringPlan;
	/**体验和心理测试*/
	private java.lang.String hiringExperience;
	/**资格复审*/
	private java.lang.String hiringRetest;
	/**办理报到手续及签订劳动合同*/
	private java.lang.String hiringReport;
	/**岗前培训*/
	private java.lang.String hiringJobTraining;
	/**持证上岗*/
	private java.lang.String hiringCertiticates;
	/**联系人及联系电话*/
	private java.lang.String hiringContact;
	/**附件*/
	private java.lang.String hiringEnclosureFid;
	/**附件地址*/
	private java.lang.String hiringEnclosureUrl;
	/**选聘项目(预留)*/
	private java.lang.String hiringProject;
	/**发布单位*/
	private java.lang.String publishCompany;
	/**发布时间*/
	private java.util.Date publishTime;
	/**编号*/
	private java.lang.Integer sort;
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
	 *@return: java.lang.String  专项就业id
	 */
	@Column(name ="SPECIALS_ID",nullable=true,length=32)
	public java.lang.String getSpecialsId(){
		return this.specialsId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专项就业id
	 */
	public void setSpecialsId(java.lang.String specialsId){
		this.specialsId = specialsId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  标题
	 */
	@Column(name ="TITLE",nullable=true,length=255)
	public java.lang.String getTitle(){
		return this.title;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  标题
	 */
	public void setTitle(java.lang.String title){
		this.title = title;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  简介
	 */
	@Column(name ="INTRODUCE",nullable=true,length=16777215)
	public java.lang.String getIntroduce(){
		return this.introduce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  简介
	 */
	public void setIntroduce(java.lang.String introduce){
		this.introduce = introduce;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  选聘范围
	 */
	@Column(name ="HIRING_RANGE",nullable=true,length=16777215)
	public java.lang.String getHiringRange(){
		return this.hiringRange;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  选聘范围
	 */
	public void setHiringRange(java.lang.String hiringRange){
		this.hiringRange = hiringRange;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  选聘数量
	 */
	@Column(name ="HIRING_NUM",nullable=true,length=10)
	public java.lang.Integer getHiringNum(){
		return this.hiringNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  选聘数量
	 */
	public void setHiringNum(java.lang.Integer hiringNum){
		this.hiringNum = hiringNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  选聘专业
	 */
	@Column(name ="HIRING_MAJOR",nullable=true,length=16777215)
	public java.lang.String getHiringMajor(){
		return this.hiringMajor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  选聘专业
	 */
	public void setHiringMajor(java.lang.String hiringMajor){
		this.hiringMajor = hiringMajor;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  选聘条件
	 */
	@Column(name ="HIRING_CONDITION",nullable=true,length=16777215)
	public java.lang.String getHiringCondition(){
		return this.hiringCondition;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  选聘条件
	 */
	public void setHiringCondition(java.lang.String hiringCondition){
		this.hiringCondition = hiringCondition;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  选聘地点
	 */
	@Column(name ="HIRING_PLACE",nullable=true,length=16777215)
	public java.lang.String getHiringPlace(){
		return this.hiringPlace;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  选聘地点
	 */
	public void setHiringPlace(java.lang.String hiringPlace){
		this.hiringPlace = hiringPlace;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  志愿项目
	 */
	@Column(name ="HIRING_JOB",nullable=true,length=50)
	public String getHiringJob() {
		return hiringJob;
	}

	public void setHiringJob(String hiringJob) {
		this.hiringJob = hiringJob;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  网上报名时间及要求
	 */
	@Column(name ="HIRING_NET",nullable=true,length=16777215)
	public java.lang.String getHiringNet(){
		return this.hiringNet;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  网上报名时间及要求
	 */
	public void setHiringNet(java.lang.String hiringNet){
		this.hiringNet = hiringNet;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  笔试时间及要求
	 */
	@Column(name ="HIRING_EXAM",nullable=true,length=16777215)
	public java.lang.String getHiringExam(){
		return this.hiringExam;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  笔试时间及要求
	 */
	public void setHiringExam(java.lang.String hiringExam){
		this.hiringExam = hiringExam;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  资格初审内容及标准
	 */
	@Column(name ="HIRING_STANDARD",nullable=true,length=16777215)
	public java.lang.String getHiringStandard(){
		return this.hiringStandard;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  资格初审内容及标准
	 */
	public void setHiringStandard(java.lang.String hiringStandard){
		this.hiringStandard = hiringStandard;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  面试时间及相关事宜
	 */
	@Column(name ="HIRING_INTERVIEW",nullable=true,length=16777215)
	public java.lang.String getHiringInterview(){
		return this.hiringInterview;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  面试时间及相关事宜
	 */
	public void setHiringInterview(java.lang.String hiringInterview){
		this.hiringInterview = hiringInterview;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  确定拟聘用人员时间及标准
	 */
	@Column(name ="HIRING_PLAN",nullable=true,length=16777215)
	public java.lang.String getHiringPlan(){
		return this.hiringPlan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  确定拟聘用人员时间及标准
	 */
	public void setHiringPlan(java.lang.String hiringPlan){
		this.hiringPlan = hiringPlan;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  体验和心理测试
	 */
	@Column(name ="HIRING_EXPERIENCE",nullable=true,length=16777215)
	public java.lang.String getHiringExperience(){
		return this.hiringExperience;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  体验和心理测试
	 */
	public void setHiringExperience(java.lang.String hiringExperience){
		this.hiringExperience = hiringExperience;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  资格复审
	 */
	@Column(name ="HIRING_RETEST",nullable=true,length=16777215)
	public java.lang.String getHiringRetest(){
		return this.hiringRetest;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  资格复审
	 */
	public void setHiringRetest(java.lang.String hiringRetest){
		this.hiringRetest = hiringRetest;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  办理报到手续及签订劳动合同
	 */
	@Column(name ="HIRING_REPORT",nullable=true,length=16777215)
	public java.lang.String getHiringReport(){
		return this.hiringReport;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  办理报到手续及签订劳动合同
	 */
	public void setHiringReport(java.lang.String hiringReport){
		this.hiringReport = hiringReport;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  岗前培训
	 */
	@Column(name ="HIRING_JOB_TRAINING",nullable=true,length=16777215)
	public java.lang.String getHiringJobTraining(){
		return this.hiringJobTraining;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  岗前培训
	 */
	public void setHiringJobTraining(java.lang.String hiringJobTraining){
		this.hiringJobTraining = hiringJobTraining;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  持证上岗
	 */
	@Column(name ="HIRING_CERTITICATES",nullable=true,length=16777215)
	public java.lang.String getHiringCertiticates(){
		return this.hiringCertiticates;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  持证上岗
	 */
	public void setHiringCertiticates(java.lang.String hiringCertiticates){
		this.hiringCertiticates = hiringCertiticates;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人及联系电话
	 */
	@Column(name ="HIRING_CONTACT",nullable=true,length=65535)
	public java.lang.String getHiringContact(){
		return this.hiringContact;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人及联系电话
	 */
	public void setHiringContact(java.lang.String hiringContact){
		this.hiringContact = hiringContact;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附件
	 */
	@Column(name ="HIRING_ENCLOSURE_FID",nullable=true,length=32)
	public java.lang.String getHiringEnclosureFid(){
		return this.hiringEnclosureFid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附件
	 */
	public void setHiringEnclosureFid(java.lang.String hiringEnclosureFid){
		this.hiringEnclosureFid = hiringEnclosureFid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附件地址
	 */
	@Column(name ="HIRING_ENCLOSURE_URL",nullable=true,length=255)
	public java.lang.String getHiringEnclosureUrl(){
		return this.hiringEnclosureUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附件地址
	 */
	public void setHiringEnclosureUrl(java.lang.String hiringEnclosureUrl){
		this.hiringEnclosureUrl = hiringEnclosureUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  选聘项目(预留)
	 */
	@Column(name ="HIRING_PROJECT",nullable=true,length=255)
	public java.lang.String getHiringProject(){
		return this.hiringProject;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  选聘项目(预留)
	 */
	public void setHiringProject(java.lang.String hiringProject){
		this.hiringProject = hiringProject;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发布单位
	 */
	@Column(name ="PUBLISH_COMPANY",nullable=true,length=255)
	public java.lang.String getPublishCompany(){
		return this.publishCompany;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发布单位
	 */
	public void setPublishCompany(java.lang.String publishCompany){
		this.publishCompany = publishCompany;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  发布时间
	 */
	@Column(name ="PUBLISH_TIME",nullable=true)
	public java.util.Date getPublishTime(){
		return this.publishTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  发布时间
	 */
	public void setPublishTime(java.util.Date publishTime){
		this.publishTime = publishTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  编号
	 */
	@Column(name ="SORT",nullable=true,length=10)
	public java.lang.Integer getSort(){
		return this.sort;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  编号
	 */
	public void setSort(java.lang.Integer sort){
		this.sort = sort;
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
