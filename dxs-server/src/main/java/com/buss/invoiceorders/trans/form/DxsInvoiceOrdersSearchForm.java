package com.buss.invoiceorders.trans.form;

import com.buss.invoice.entity.DxsInvoiceEntity;
import com.buss.invoiceorders.entity.DxsInvoiceOrdersEntity;
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
@Mapping(entityClass=DxsInvoiceOrdersEntity.class)
public class DxsInvoiceOrdersSearchForm extends SearchForm {
	/**主键*/
	@Mapping
	private String id;
	/**发票信息id*/
	@Mapping
	private String invoiceId;
	/**用户id*/
	@Mapping
	private String userId;
	/**订单id*/
	@Mapping
	private String orderId;
	/**发票金额*/
	@Mapping
	private String invoiceValue;
	/**发票标号*/
	@Mapping
	private String invoiceLabels;
	/**申请时间*/
	@Mapping
	private String applyTime;
	/**发票状态*/
	@Mapping
	private String invoiceStatus;
	/**收件人*/
	@Mapping
	private String recipient;
	/**收取地址*/
	@Mapping
	private String recipientAddress;
	/**收取方式*/
	@Mapping
	private String collectionType;
	/**邮编*/
	@Mapping
	private String postNum;
	/**联系电话*/
	@Mapping
	private String phone;
	/**物流公司*/
	@Mapping
	private String logisticsCompany;
	/**快递编号*/
	@Mapping
	private String expressNumber;
	/**开票订单号*/
	@Mapping
	private String invoiceOrderNum;
	/**产品名称*/
	@Mapping
	private String productName;
	/**创建时间*/
	@Mapping
	private String createTime;
	/**更新时间*/
	@Mapping
	private String updateTime;
	/**删除标志*/
	@Mapping
	private String isDelete;


	public DxsInvoiceOrdersSearchForm(){

	}

	public String getCollectionType() {
		return collectionType;
	}

	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getInvoiceValue() {
		return invoiceValue;
	}

	public void setInvoiceValue(String invoiceValue) {
		this.invoiceValue = invoiceValue;
	}

	public String getInvoiceLabels() {
		return invoiceLabels;
	}

	public void setInvoiceLabels(String invoiceLabels) {
		this.invoiceLabels = invoiceLabels;
	}

	public String getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(String applyTime) {
		this.applyTime = applyTime;
	}

	public String getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getRecipientAddress() {
		return recipientAddress;
	}

	public void setRecipientAddress(String recipientAddress) {
		this.recipientAddress = recipientAddress;
	}

	public String getPostNum() {
		return postNum;
	}

	public void setPostNum(String postNum) {
		this.postNum = postNum;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLogisticsCompany() {
		return logisticsCompany;
	}

	public void setLogisticsCompany(String logisticsCompany) {
		this.logisticsCompany = logisticsCompany;
	}

	public String getExpressNumber() {
		return expressNumber;
	}

	public void setExpressNumber(String expressNumber) {
		this.expressNumber = expressNumber;
	}

	public String getInvoiceOrderNum() {
		return invoiceOrderNum;
	}

	public void setInvoiceOrderNum(String invoiceOrderNum) {
		this.invoiceOrderNum = invoiceOrderNum;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
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
