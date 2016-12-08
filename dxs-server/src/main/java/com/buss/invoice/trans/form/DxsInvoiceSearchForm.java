package com.buss.invoice.trans.form;

import com.buss.invoice.entity.DxsInvoiceEntity;
import com.buss.invoices.entity.DxsInvoicesEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * @Title: Entity
 * @Description: dxs_messages
 * @author onlineGenerator
 * @date 2016-09-20 10:18:25
 * @version V1.0
 *
 */
@Mapping(entityClass=DxsInvoiceEntity.class)
public class DxsInvoiceSearchForm extends SearchForm {
	/**主键*/
	@Mapping
	private String id;
	/**用户id*/
	@Mapping
	private String userId;
	/**发票抬头*/
	@Mapping
	private String invoiceType;
	/**发票抬头*/
	@Mapping
	private String invoiceHead;
	/**开具类型*/
	@Mapping
	private String type;
	/**税务登记号*/
	@Mapping
	private String taxRegistrationNumber;
	/**开户银行名称*/
	@Mapping
	private String bankName;
	/**开户银行账号*/
	@Mapping
	private String bankAccount;
	/**注册场所地址*/
	@Mapping
	private String registrationPlace;
	/**注册固定电话*/
	@Mapping
	private String registrationPhone;
	/**营业执照复印件id*/
	@Mapping
	private String businessLicenseFid;
	/**税务登记复印件id*/
	@Mapping
	private String taxRegistrationFid;
	/**纳税人资格扫描件id*/
	@Mapping
	private String taxpayerFid;
	/**创建时间*/
	@Mapping
	private String createTime;
	/**更新时间*/
	@Mapping
	private String updateTime;
	/**删除标志*/
	@Mapping
	private String isDelete;


	public DxsInvoiceSearchForm(){

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getInvoiceHead() {
		return invoiceHead;
	}

	public void setInvoiceHead(String invoiceHead) {
		this.invoiceHead = invoiceHead;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTaxRegistrationNumber() {
		return taxRegistrationNumber;
	}

	public void setTaxRegistrationNumber(String taxRegistrationNumber) {
		this.taxRegistrationNumber = taxRegistrationNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}

	public String getRegistrationPlace() {
		return registrationPlace;
	}

	public void setRegistrationPlace(String registrationPlace) {
		this.registrationPlace = registrationPlace;
	}

	public String getRegistrationPhone() {
		return registrationPhone;
	}

	public void setRegistrationPhone(String registrationPhone) {
		this.registrationPhone = registrationPhone;
	}

	public String getBusinessLicenseFid() {
		return businessLicenseFid;
	}

	public void setBusinessLicenseFid(String businessLicenseFid) {
		this.businessLicenseFid = businessLicenseFid;
	}

	public String getTaxRegistrationFid() {
		return taxRegistrationFid;
	}

	public void setTaxRegistrationFid(String taxRegistrationFid) {
		this.taxRegistrationFid = taxRegistrationFid;
	}

	public String getTaxpayerFid() {
		return taxpayerFid;
	}

	public void setTaxpayerFid(String taxpayerFid) {
		this.taxpayerFid = taxpayerFid;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(String updateTime) {
		this.updateTime = updateTime;
	}

	public String getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
}
