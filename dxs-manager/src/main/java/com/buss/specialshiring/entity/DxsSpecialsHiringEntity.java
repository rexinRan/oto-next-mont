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
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_specials_hiring
 * @author onlineGenerator
 * @date 2016-08-09 11:30:36
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_specials_hiring", schema = "")
@SuppressWarnings("serial")
public class DxsSpecialsHiringEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**专项就业id*/
	@Excel(name="专项就业id")
	private String specialsId;
	/**标题*/
	@Excel(name="标题")
	private String title;
	/**简介*/
	@Excel(name="简介")
	private String introduce;
	/**选聘范围*/
	@Excel(name="选聘范围")
	private String hiringRange;
	/**选聘数量*/
	@Excel(name="选聘数量")
	private Integer hiringNum;
	/**选聘专业*/
	@Excel(name="选聘专业")
	private String hiringMajor;
	/**选聘条件*/
	@Excel(name="选聘条件")
	private String hiringCondition;
	/**选聘地点*/
	@Excel(name="选聘地点")
	private String hiringPlace;
	/**志愿项目*/
	@Excel(name="志愿项目")
	private String hiringJob;
	/**网上报名时间及要求*/
	@Excel(name="网上报名时间及要求")
	private String hiringNet;
	/**笔试时间及要求*/
	@Excel(name="笔试时间及要求")
	private String hiringExam;
	/**资格初审内容及标准*/
	@Excel(name="资格初审内容及标准")
	private String hiringStandard;
	/**面试时间及相关事宜*/
	@Excel(name="面试时间及相关事宜")
	private String hiringInterview;
	/**确定拟聘用人员时间及标准*/
	@Excel(name="确定拟聘用人员时间及标准")
	private String hiringPlan;
	/**体验和心理测试*/
	@Excel(name="体验和心理测试")
	private String hiringExperience;
	/**资格复审*/
	@Excel(name="资格复审")
	private String hiringRetest;
	/**办理报到手续及签订劳动合同*/
	@Excel(name="办理报到手续及签订劳动合同")
	private String hiringReport;
	/**岗前培训*/
	@Excel(name="岗前培训")
	private String hiringJobTraining;
	/**持证上岗*/
	@Excel(name="持证上岗")
	private String hiringCertiticates;
	/**联系人及联系电话*/
	@Excel(name="联系人及联系电话")
	private String hiringContact;
	/**附件*/
	@Excel(name="附件")
	private String hiringEnclosureFid;
	/**附件地址*/
	@Excel(name="附件地址")
	private String hiringEnclosureUrl;
	/**选聘项目(预留)*/
	@Excel(name="选聘项目(预留)")
	private String hiringProject;
	/**发布单位*/
	@Excel(name="发布单位")
	private String publishCompany;
	/**发布时间*/
	@Excel(name="发布时间",format = "yyyy-MM-dd")
	private Date publishTime;
	/**编号*/
	@Excel(name="编号")
	private Integer sort;
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
	 *@return: java.lang.String  专项就业id
	 */
	@Column(name ="SPECIALS_ID",nullable=true,length=32)
	public String getSpecialsId(){
		return this.specialsId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专项就业id
	 */
	public void setSpecialsId(String specialsId){
		this.specialsId = specialsId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  标题
	 */
	@Column(name ="TITLE",nullable=true,length=255)
	public String getTitle(){
		return this.title;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  标题
	 */
	public void setTitle(String title){
		this.title = title;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  简介
	 */
	@Column(name ="INTRODUCE",nullable=true)
	public String getIntroduce(){
		return this.introduce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  简介
	 */
	public void setIntroduce(String introduce){
		this.introduce = introduce;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  选聘范围
	 */
	@Column(name ="HIRING_RANGE",nullable=true)
	public String getHiringRange(){
		return this.hiringRange;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  选聘范围
	 */
	public void setHiringRange(String hiringRange){
		this.hiringRange = hiringRange;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  选聘数量
	 */
	@Column(name ="HIRING_NUM",nullable=true,length=10)
	public Integer getHiringNum(){
		return this.hiringNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  选聘数量
	 */
	public void setHiringNum(Integer hiringNum){
		this.hiringNum = hiringNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  选聘专业
	 */
	@Column(name ="HIRING_MAJOR",nullable=true)
	public String getHiringMajor(){
		return this.hiringMajor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  选聘专业
	 */
	public void setHiringMajor(String hiringMajor){
		this.hiringMajor = hiringMajor;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  选聘条件
	 */
	@Column(name ="HIRING_CONDITION",nullable=true)
	public String getHiringCondition(){
		return this.hiringCondition;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  选聘条件
	 */
	public void setHiringCondition(String hiringCondition){
		this.hiringCondition = hiringCondition;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  选聘地点
	 */
	@Column(name ="HIRING_PLACE",nullable=true)
	public String getHiringPlace(){
		return this.hiringPlace;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  选聘地点
	 */
	public void setHiringPlace(String hiringPlace){
		this.hiringPlace = hiringPlace;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  志愿项目
	 */
	@Column(name ="HIRING_JOB",nullable=true,length=50)
	public String getHiringJob(){
		return this.hiringJob;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  志愿项目
	 */
	public void setHiringJob(String hiringJob){
		this.hiringJob = hiringJob;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  网上报名时间及要求
	 */
	@Column(name ="HIRING_NET",nullable=true)
	public String getHiringNet(){
		return this.hiringNet;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  网上报名时间及要求
	 */
	public void setHiringNet(String hiringNet){
		this.hiringNet = hiringNet;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  笔试时间及要求
	 */
	@Column(name ="HIRING_EXAM",nullable=true)
	public String getHiringExam(){
		return this.hiringExam;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  笔试时间及要求
	 */
	public void setHiringExam(String hiringExam){
		this.hiringExam = hiringExam;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  资格初审内容及标准
	 */
	@Column(name ="HIRING_STANDARD",nullable=true)
	public String getHiringStandard(){
		return this.hiringStandard;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  资格初审内容及标准
	 */
	public void setHiringStandard(String hiringStandard){
		this.hiringStandard = hiringStandard;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  面试时间及相关事宜
	 */
	@Column(name ="HIRING_INTERVIEW",nullable=true)
	public String getHiringInterview(){
		return this.hiringInterview;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  面试时间及相关事宜
	 */
	public void setHiringInterview(String hiringInterview){
		this.hiringInterview = hiringInterview;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  确定拟聘用人员时间及标准
	 */
	@Column(name ="HIRING_PLAN",nullable=true)
	public String getHiringPlan(){
		return this.hiringPlan;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  确定拟聘用人员时间及标准
	 */
	public void setHiringPlan(String hiringPlan){
		this.hiringPlan = hiringPlan;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  体验和心理测试
	 */
	@Column(name ="HIRING_EXPERIENCE",nullable=true)
	public String getHiringExperience(){
		return this.hiringExperience;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  体验和心理测试
	 */
	public void setHiringExperience(String hiringExperience){
		this.hiringExperience = hiringExperience;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  资格复审
	 */
	@Column(name ="HIRING_RETEST",nullable=true)
	public String getHiringRetest(){
		return this.hiringRetest;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  资格复审
	 */
	public void setHiringRetest(String hiringRetest){
		this.hiringRetest = hiringRetest;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  办理报到手续及签订劳动合同
	 */
	@Column(name ="HIRING_REPORT",nullable=true)
	public String getHiringReport(){
		return this.hiringReport;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  办理报到手续及签订劳动合同
	 */
	public void setHiringReport(String hiringReport){
		this.hiringReport = hiringReport;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  岗前培训
	 */
	@Column(name ="HIRING_JOB_TRAINING",nullable=true)
	public String getHiringJobTraining(){
		return this.hiringJobTraining;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  岗前培训
	 */
	public void setHiringJobTraining(String hiringJobTraining){
		this.hiringJobTraining = hiringJobTraining;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  持证上岗
	 */
	@Column(name ="HIRING_CERTITICATES",nullable=true)
	public String getHiringCertiticates(){
		return this.hiringCertiticates;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  持证上岗
	 */
	public void setHiringCertiticates(String hiringCertiticates){
		this.hiringCertiticates = hiringCertiticates;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人及联系电话
	 */
	@Column(name ="HIRING_CONTACT",nullable=true)
	public String getHiringContact(){
		return this.hiringContact;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人及联系电话
	 */
	public void setHiringContact(String hiringContact){
		this.hiringContact = hiringContact;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附件
	 */
	@Column(name ="HIRING_ENCLOSURE_FID",nullable=true,length=32)
	public String getHiringEnclosureFid(){
		return this.hiringEnclosureFid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附件
	 */
	public void setHiringEnclosureFid(String hiringEnclosureFid){
		this.hiringEnclosureFid = hiringEnclosureFid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  附件地址
	 */
	@Column(name ="HIRING_ENCLOSURE_URL",nullable=true,length=255)
	public String getHiringEnclosureUrl(){
		return this.hiringEnclosureUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  附件地址
	 */
	public void setHiringEnclosureUrl(String hiringEnclosureUrl){
		this.hiringEnclosureUrl = hiringEnclosureUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  选聘项目(预留)
	 */
	@Column(name ="HIRING_PROJECT",nullable=true,length=255)
	public String getHiringProject(){
		return this.hiringProject;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  选聘项目(预留)
	 */
	public void setHiringProject(String hiringProject){
		this.hiringProject = hiringProject;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发布单位
	 */
	@Column(name ="PUBLISH_COMPANY",nullable=true,length=255)
	public String getPublishCompany(){
		return this.publishCompany;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发布单位
	 */
	public void setPublishCompany(String publishCompany){
		this.publishCompany = publishCompany;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  发布时间
	 */
	@Column(name ="PUBLISH_TIME",nullable=true)
	public Date getPublishTime(){
		return this.publishTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  发布时间
	 */
	public void setPublishTime(Date publishTime){
		this.publishTime = publishTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  编号
	 */
	@Column(name ="SORT",nullable=true,length=10)
	public Integer getSort(){
		return this.sort;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  编号
	 */
	public void setSort(Integer sort){
		this.sort = sort;
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
