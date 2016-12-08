package com.buss.invoices.trans.vo;

import com.buss.invoices.entity.DxsInvoicesEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**   
 * @Title: Entity
 * @Description: dxs_messages
 * @author onlineGenerator
 * @date 2016-09-20 10:18:25
 * @version V1.0   
 *
 */
@Mapping(entityClass=DxsInvoicesEntity.class)
public class DxsInvoicesVO extends BaseVO {
	/**主键*/
	@Mapping
	private String id;
	/**用户ID*/
	@Mapping
	private String userId;
	/**开具类型*/
	@Mapping
	private String issueType;
	/**发票抬头*/
	@Mapping
	private String invoiceHeader;
	/**发票类型*/
	@Mapping
	private String invoiceType;
	/**税务登记账号*/
	@Mapping
	private String taxAccount;
	/**基本开户银行名称*/
	@Mapping
	private String bankName;
	/**基本开户账号*/
	@Mapping
	private String bankAccount;
	/**注册场所地址*/
	@Mapping
	private String registerPalce;
	/**注册固定电话*/
	@Mapping
	private String registerPhone;
	/**营业执照复印件*/
	@Mapping
	private String businessLincense;
	/**税务登记复印件*/
	@Mapping
	private String taxPerson;
	/**一般纳税人资格复印件*/
	@Mapping
	private String generalTaxpayer;
	/**创建时间*/
	@Mapping
	private String createTime;
	/**更新时间*/
	@Mapping
	private String updateTime;
	/**删除标志*/
	@Mapping
	private String isDelete;


	public DxsInvoicesVO() {
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

	public String getIssueType() {
		return issueType;
	}

	public void setIssueType(String issueType) {
		this.issueType = issueType;
	}

	public String getInvoiceHeader() {
		return invoiceHeader;
	}

	public void setInvoiceHeader(String invoiceHeader) {
		this.invoiceHeader = invoiceHeader;
	}

	public String getInvoiceType() {
		return invoiceType;
	}

	public void setInvoiceType(String invoiceType) {
		this.invoiceType = invoiceType;
	}

	public String getTaxAccount() {
		return taxAccount;
	}

	public void setTaxAccount(String taxAccount) {
		this.taxAccount = taxAccount;
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

	public String getRegisterPalce() {
		return registerPalce;
	}

	public void setRegisterPalce(String registerPalce) {
		this.registerPalce = registerPalce;
	}

	public String getRegisterPhone() {
		return registerPhone;
	}

	public void setRegisterPhone(String registerPhone) {
		this.registerPhone = registerPhone;
	}

	public String getBusinessLincense() {
		return businessLincense;
	}

	public void setBusinessLincense(String businessLincense) {
		this.businessLincense = businessLincense;
	}

	public String getTaxPerson() {
		return taxPerson;
	}

	public void setTaxPerson(String taxPerson) {
		this.taxPerson = taxPerson;
	}

	public String getGeneralTaxpayer() {
		return generalTaxpayer;
	}

	public void setGeneralTaxpayer(String generalTaxpayer) {
		this.generalTaxpayer = generalTaxpayer;
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
