package com.buss.orders.trans.from;

import com.buss.orders.entity.OrdersEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by HongXinGuoJi-yzg on 2016/9/21.
 */
@Mapping(entityClass = OrdersEntity.class)
public class OrdersFrom extends SearchForm{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**用户id*/
    @Mapping
    private java.lang.String userId;
    /**支付方式*/
    @Mapping
    private java.lang.String modePayment;
    /**订单电话*/
    @Mapping
    private java.lang.String phone;
    /**订单编号*/
    @Mapping
    private java.lang.String orderNum;
    /**注册号*/
    @Mapping
    private java.lang.String regNum;
    /**订单金额*/
    @Mapping
    private java.lang.String orderAll;
    /**订货日期*/
    @Mapping
    private java.lang.String orderTime;
    /**发票号码*/
    @Mapping
    private java.lang.String invoiceNum;
    /**鸿鑫豆数量*/
    @Mapping
    private java.lang.String hongxinNum;
    /**订单状态*/
    @Mapping    //0到付,3待付款,9已付款,9待退款,12退款成功,15退款失败
    private java.lang.String orderStatus;
    /**配送日期*/
    @Mapping
    private java.lang.String sendTime;
    /**创建时间*/
    @Mapping
    private java.lang.String createTime;
    /**更新时间*/
    @Mapping
    private java.lang.String updateTime;
    /**删除标志*/
    @Mapping
    private java.lang.String isDelete;


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

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    public String getOrderAll() {
        return orderAll;
    }

    public void setOrderAll(String orderAll) {
        this.orderAll = orderAll;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
    }

    public String getInvoiceNum() {
        return invoiceNum;
    }

    public void setInvoiceNum(String invoiceNum) {
        this.invoiceNum = invoiceNum;
    }

    public String getHongxinNum() {
        return hongxinNum;
    }

    public void setHongxinNum(String hongxinNum) {
        this.hongxinNum = hongxinNum;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getModePayment() {
        return modePayment;
    }

    public void setModePayment(String modePayment) {
        this.modePayment = modePayment;
    }
}
