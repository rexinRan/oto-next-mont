package com.buss.activescustom.entity;

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
 * @Description: dxs_actives_custom
 * @author onlineGenerator
 * @date 2016-08-01 11:56:36
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_actives_custom", schema = "")
@SuppressWarnings("serial")
public class DxsActivesCustomEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**用户id*/
	@Excel(name="用户id")
	private String userId;
	/**课程id*/
	@Excel(name="课程id")
	private String customizedId;
	/**国家id*/
	@Excel(name="国家id")
	private String customCountryId;
	/**选修课ID*/
	@Excel(name="选修课ID")
	private String customCoursesId;
	/**住宿方式*/
	@Excel(name="住宿方式")
	private String customModeId;
	/**课程时长*/
	@Excel(name="课程时长")
	private String customDurationId;
	/**签证方式id*/
	@Excel(name="签证方式id")
	private String customVisaId;
	/**setouttime*/
	@Excel(name="setouttime",format = "yyyy-MM-dd")
	private Date setouttime;
	/**紧急联系人*/
	@Excel(name="紧急联系人")
	private String contacts1;
	/**紧急联系电话*/
	@Excel(name="紧急联系电话")
	private String phone1;
	/**紧急联系人2*/
	@Excel(name="紧急联系人2")
	private String contacts2;
	/**紧急联系电话2*/
	@Excel(name="紧急联系电话2")
	private String phone2;
	/**是否缴费*/
	@Excel(name="是否缴费")
	private Integer result;
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
	 *@return: java.lang.String  课程id
	 */
	@Column(name ="CUSTOMIZED_ID",nullable=true,length=32)
	public String getCustomizedId(){
		return this.customizedId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课程id
	 */
	public void setCustomizedId(String customizedId){
		this.customizedId = customizedId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  国家id
	 */
	@Column(name ="CUSTOM_COUNTRY_ID",nullable=true,length=32)
	public String getCustomCountryId(){
		return this.customCountryId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  国家id
	 */
	public void setCustomCountryId(String customCountryId){
		this.customCountryId = customCountryId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  选修课ID
	 */
	@Column(name ="CUSTOM_COURSES_ID",nullable=true,length=32)
	public String getCustomCoursesId(){
		return this.customCoursesId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  选修课ID
	 */
	public void setCustomCoursesId(String customCoursesId){
		this.customCoursesId = customCoursesId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  住宿方式
	 */
	@Column(name ="CUSTOM_MODE_ID",nullable=true,length=32)
	public String getCustomModeId(){
		return this.customModeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  住宿方式
	 */
	public void setCustomModeId(String customModeId){
		this.customModeId = customModeId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  课程时长
	 */
	@Column(name ="CUSTOM_DURATION_ID",nullable=true,length=32)
	public String getCustomDurationId(){
		return this.customDurationId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课程时长
	 */
	public void setCustomDurationId(String customDurationId){
		this.customDurationId = customDurationId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  签证方式id
	 */
	@Column(name ="CUSTOM_VISA_ID",nullable=true,length=32)
	public String getCustomVisaId(){
		return this.customVisaId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  签证方式id
	 */
	public void setCustomVisaId(String customVisaId){
		this.customVisaId = customVisaId;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  setouttime
	 */
	@Column(name ="SETOUTTIME",nullable=true)
	public Date getSetouttime(){
		return this.setouttime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  setouttime
	 */
	public void setSetouttime(Date setouttime){
		this.setouttime = setouttime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  紧急联系人
	 */
	@Column(name ="CONTACTS1",nullable=true,length=200)
	public String getContacts1(){
		return this.contacts1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  紧急联系人
	 */
	public void setContacts1(String contacts1){
		this.contacts1 = contacts1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  紧急联系电话
	 */
	@Column(name ="PHONE1",nullable=true,length=20)
	public String getPhone1(){
		return this.phone1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  紧急联系电话
	 */
	public void setPhone1(String phone1){
		this.phone1 = phone1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  紧急联系人2
	 */
	@Column(name ="CONTACTS2",nullable=true,length=200)
	public String getContacts2(){
		return this.contacts2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  紧急联系人2
	 */
	public void setContacts2(String contacts2){
		this.contacts2 = contacts2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  紧急联系电话2
	 */
	@Column(name ="PHONE2",nullable=true,length=20)
	public String getPhone2(){
		return this.phone2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  紧急联系电话2
	 */
	public void setPhone2(String phone2){
		this.phone2 = phone2;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否缴费
	 */
	@Column(name ="RESULT",nullable=true,length=10)
	public Integer getResult(){
		return this.result;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否缴费
	 */
	public void setResult(Integer result){
		this.result = result;
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
	@Column(name ="IS_DELETE",nullable=true,length=10)
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
