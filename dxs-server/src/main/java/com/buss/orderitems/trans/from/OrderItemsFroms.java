package com.buss.orderitems.trans.from;

import com.buss.orderitems.entity.OrderItemsEntity;
import com.buss.orderitems.entity.OrderItemsEntitys;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by HongXinGuoJi-yzg on 2016/9/21.
 */
@Mapping(entityClass = OrderItemsEntitys.class)
public class OrderItemsFroms extends SearchForm{
    /**主键*/
    @Mapping
    private String id;
    /**用户id*/
    @Mapping
    private String userId;
    /**订单ID*/
    @Mapping
    private String orderId;
    /**订单编号*/
    @Mapping
    private String orderNum;
    /**外键*/
    @Mapping
    private String outId;
    /**外部分类*/
    @Mapping
    private String outCatalog;
    /**产品名称*/
    @Mapping
    private String productName;
    /**备注*/
    @Mapping
    private String remarks;
    /**商品单价*/
    @Mapping
    private String price;
    /**折后价*/
    @Mapping
    private String priceShort;
    /**商品数量*/
    @Mapping
    private String num;
    // 是否是支付定金(1:全款  5:定金)
    @Mapping
    private String paymentAttribute;
    /**订货日期*/
    @Mapping
    private String orderTime;
    /**创建时间*/
    @Mapping
    private String createTime;
    /**更新时间*/
    @Mapping
    private String updateTime;
    /**删除标志*/
    @Mapping
    private String isDelete;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }

    public String getPaymentAttribute() {
        return paymentAttribute;
    }

    public void setPaymentAttribute(String paymentAttribute) {
        this.paymentAttribute = paymentAttribute;
    }

    public String getOutCatalog() {
        return outCatalog;
    }

    public void setOutCatalog(String outCatalog) {
        this.outCatalog = outCatalog;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPriceShort() {
        return priceShort;
    }

    public void setPriceShort(String priceShort) {
        this.priceShort = priceShort;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(String orderTime) {
        this.orderTime = orderTime;
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
