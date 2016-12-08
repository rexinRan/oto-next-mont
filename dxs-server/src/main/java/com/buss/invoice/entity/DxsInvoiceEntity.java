package com.buss.invoice.entity;

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
 * @Description: dxs_invoice
 * @author onlineGenerator
 * @date 2016-09-23 15:01:13
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_invoice", schema = "")
@SuppressWarnings("serial")
public class DxsInvoiceEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**用户id*/

	private String userId;
	/**发票抬头*/

	private String invoiceType;
	/**发票抬头*/

	private String invoiceHead;
	/**开具类型*/

	private String type;
	/**税务登记号*/

	private String taxRegistrationNumber;
	/**开户银行名称*/

	private String bankName;
	/**开户银行账号*/

	private String bankAccount;
	/**注册场所地址*/

	private String registrationPlace;
	/**注册固定电话*/

	private String registrationPhone;
	/**营业执照复印件id*/

	private String businessLicenseFid;
	/**税务登记复印件id*/

	private String taxRegistrationFid;
	/**纳税人资格扫描件id*/

	private Integer taxpayerFid;
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
	 *@return: java.lang.String  发票抬头
	 */
	@Column(name ="INVOICE_TYPE",nullable=true,length=100)
	public String getInvoiceType(){
		return this.invoiceType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发票抬头
	 */
	public void setInvoiceType(String invoiceType){
		this.invoiceType = invoiceType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  发票抬头
	 */
	@Column(name ="INVOICE_HEAD",nullable=true,length=200)
	public String getInvoiceHead(){
		return this.invoiceHead;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  发票抬头
	 */
	public void setInvoiceHead(String invoiceHead){
		this.invoiceHead = invoiceHead;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开具类型
	 */
	@Column(name ="TYPE",nullable=true,length=100)
	public String getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开具类型
	 */
	public void setType(String type){
		this.type = type;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  税务登记号
	 */
	@Column(name ="TAX_REGISTRATION_NUMBER",nullable=true,length=200)
	public String getTaxRegistrationNumber(){
		return this.taxRegistrationNumber;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  税务登记号
	 */
	public void setTaxRegistrationNumber(String taxRegistrationNumber){
		this.taxRegistrationNumber = taxRegistrationNumber;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开户银行名称
	 */
	@Column(name ="BANK_NAME",nullable=true,length=255)
	public String getBankName(){
		return this.bankName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开户银行名称
	 */
	public void setBankName(String bankName){
		this.bankName = bankName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  开户银行账号
	 */
	@Column(name ="BANK_ACCOUNT",nullable=true,length=100)
	public String getBankAccount(){
		return this.bankAccount;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  开户银行账号
	 */
	public void setBankAccount(String bankAccount){
		this.bankAccount = bankAccount;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  注册场所地址
	 */
	@Column(name ="REGISTRATION_PLACE",nullable=true,length=255)
	public String getRegistrationPlace(){
		return this.registrationPlace;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  注册场所地址
	 */
	public void setRegistrationPlace(String registrationPlace){
		this.registrationPlace = registrationPlace;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  注册固定电话
	 */
	@Column(name ="REGISTRATION_PHONE",nullable=true,length=50)
	public String getRegistrationPhone(){
		return this.registrationPhone;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  注册固定电话
	 */
	public void setRegistrationPhone(String registrationPhone){
		this.registrationPhone = registrationPhone;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  营业执照复印件id
	 */
	@Column(name ="BUSINESS_LICENSE_FID",nullable=true,length=32)
	public String getBusinessLicenseFid(){
		return this.businessLicenseFid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  营业执照复印件id
	 */
	public void setBusinessLicenseFid(String businessLicenseFid){
		this.businessLicenseFid = businessLicenseFid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  税务登记复印件id
	 */
	@Column(name ="TAX_REGISTRATION_FID",nullable=true,length=32)
	public String getTaxRegistrationFid(){
		return this.taxRegistrationFid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  税务登记复印件id
	 */
	public void setTaxRegistrationFid(String taxRegistrationFid){
		this.taxRegistrationFid = taxRegistrationFid;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  纳税人资格扫描件id
	 */
	@Column(name ="TAXPAYER_FID",nullable=true,length=10)
	public Integer getTaxpayerFid(){
		return this.taxpayerFid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  纳税人资格扫描件id
	 */
	public void setTaxpayerFid(Integer taxpayerFid){
		this.taxpayerFid = taxpayerFid;
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
