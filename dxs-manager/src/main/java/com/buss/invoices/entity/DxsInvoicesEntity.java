package com.buss.invoices.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.common.entity.DxsUserDetailEntity;
import com.buss.user.entity.DxsUserEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_invoices
 * @author onlineGenerator
 * @date 2016-09-23 14:59:30
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_invoices", schema = "")
@SuppressWarnings("serial")
public class DxsInvoicesEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**用户ID*/
	@Excel(name="用户ID")
	private String userId;
	/**开具类型*/
	@Excel(name="开具类型")
	private Integer issueType;
	/**发票抬头*/
	@Excel(name="发票抬头")
	private String invoiceHeader;
	/**发票类型*/
	@Excel(name="发票类型")
	private Integer invoiceType;
	/**税务登记账号*/
	@Excel(name="税务登记账号")
	private String taxAccount;
	/**基本开户银行名称*/
	@Excel(name="基本开户银行名称")
	private String bankName;
	/**基本开户账号*/
	@Excel(name="基本开户账号")
	private String bankAccount;
	/**注册场所地址*/
	@Excel(name="注册场所地址")
	private String registerPalce;
	/**注册固定电话*/
	@Excel(name="注册固定电话")
	private String registerPhone;
	/**营业执照复印件*/
	@Excel(name="营业执照复印件")
	private String businessLincense;
	/**税务登记复印件*/
	@Excel(name="税务登记复印件")
	private String taxPerson;
	/**一般纳税人资格复印件*/
	@Excel(name="一般纳税人资格复印件")
	private String generalTaxpayer;
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
	 *@return: java.lang.String  用户ID
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户ID
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  开具类型
	 */
	@Column(name ="ISSUE_TYPE",nullable=true,length=3)
	public Integer getIssueType(){
		return this.issueType;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  开具类型
	 */
	public void setIssueType(Integer issueType){
		this.issueType = issueType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发票抬头
	 */
	@Column(name ="INVOICE_HEADER",nullable=true,length=255)
	public String getInvoiceHeader(){
		return this.invoiceHeader;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发票抬头
	 */
	public void setInvoiceHeader(String invoiceHeader){
		this.invoiceHeader = invoiceHeader;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  发票类型
	 */
	@Column(name ="INVOICE_TYPE",nullable=true,length=3)
	public Integer getInvoiceType(){
		return this.invoiceType;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  发票类型
	 */
	public void setInvoiceType(Integer invoiceType){
		this.invoiceType = invoiceType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  税务登记账号
	 */
	@Column(name ="TAX_ACCOUNT",nullable=true,length=50)
	public String getTaxAccount(){
		return this.taxAccount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  税务登记账号
	 */
	public void setTaxAccount(String taxAccount){
		this.taxAccount = taxAccount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  基本开户银行名称
	 */
	@Column(name ="BANK_NAME",nullable=true,length=100)
	public String getBankName(){
		return this.bankName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  基本开户银行名称
	 */
	public void setBankName(String bankName){
		this.bankName = bankName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  基本开户账号
	 */
	@Column(name ="BANK_ACCOUNT",nullable=true,length=50)
	public String getBankAccount(){
		return this.bankAccount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  基本开户账号
	 */
	public void setBankAccount(String bankAccount){
		this.bankAccount = bankAccount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  注册场所地址
	 */
	@Column(name ="REGISTER_PALCE",nullable=true,length=255)
	public String getRegisterPalce(){
		return this.registerPalce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  注册场所地址
	 */
	public void setRegisterPalce(String registerPalce){
		this.registerPalce = registerPalce;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  注册固定电话
	 */
	@Column(name ="REGISTER_PHONE",nullable=true,length=20)
	public String getRegisterPhone(){
		return this.registerPhone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  注册固定电话
	 */
	public void setRegisterPhone(String registerPhone){
		this.registerPhone = registerPhone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  营业执照复印件
	 */
	@Column(name ="BUSINESS_LINCENSE",nullable=true,length=255)
	public String getBusinessLincense(){
		return this.businessLincense;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  营业执照复印件
	 */
	public void setBusinessLincense(String businessLincense){
		this.businessLincense = businessLincense;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  税务登记复印件
	 */
	@Column(name ="TAX_PERSON",nullable=true,length=255)
	public String getTaxPerson(){
		return this.taxPerson;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  税务登记复印件
	 */
	public void setTaxPerson(String taxPerson){
		this.taxPerson = taxPerson;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  一般纳税人资格复印件
	 */
	@Column(name ="GENERAL_TAXPAYER",nullable=true,length=255)
	public String getGeneralTaxpayer(){
		return this.generalTaxpayer;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  一般纳税人资格复印件
	 */
	public void setGeneralTaxpayer(String generalTaxpayer){
		this.generalTaxpayer = generalTaxpayer;
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


	/**
	 *@author dq
	 *添加表dxs_userdetail多对一bean
	 */
	private DxsUserDetailEntity dxsUserDetailEntity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)

	public DxsUserDetailEntity getDxsUserDetailEntity() {
		return dxsUserDetailEntity;
	}

	public void setDxsUserDetailEntity(DxsUserDetailEntity dxsUserDetailEntity) {
		this.dxsUserDetailEntity = dxsUserDetailEntity;
	}
}
