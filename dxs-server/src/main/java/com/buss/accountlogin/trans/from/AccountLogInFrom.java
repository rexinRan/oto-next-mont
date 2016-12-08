package com.buss.accountlogin.trans.from;

import com.buss.accountlogin.entity.AccountLogInEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by HongXinGuoJi-yzg on 2016/9/22.
 */
@Mapping(entityClass = AccountLogInEntity.class)
public class AccountLogInFrom extends SearchForm{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**账户id*/
    @Mapping
    private java.lang.String accoutId;
    /**用户ID*/
    @Mapping
    private java.lang.String userId;
    /**进账数目*/
    @Mapping
    private java.lang.String accountIn;
    /**出账数目(预留)*/
    @Mapping
    private java.lang.String accountOut;
    /**来源*/
    @Mapping
    private java.lang.String accountFrom;
    /**产品名称*/
    @Mapping
    private java.lang.String productName;
    /**账目进出id*/
    @Mapping
    private java.lang.String accountFromId;
    /**流水状态*/
    @Mapping
    private java.lang.String accountStatus;
    /**备注*/
    @Mapping
    private java.lang.String remarks;
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

    public String getAccoutId() {
        return accoutId;
    }

    public void setAccoutId(String accoutId) {
        this.accoutId = accoutId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAccountIn() {
        return accountIn;
    }

    public void setAccountIn(String accountIn) {
        this.accountIn = accountIn;
    }

    public String getAccountOut() {
        return accountOut;
    }

    public void setAccountOut(String accountOut) {
        this.accountOut = accountOut;
    }

    public String getAccountFrom() {
        return accountFrom;
    }

    public void setAccountFrom(String accountFrom) {
        this.accountFrom = accountFrom;
    }

    public String getAccountFromId() {
        return accountFromId;
    }

    public void setAccountFromId(String accountFromId) {
        this.accountFromId = accountFromId;
    }

    public String getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(String accountStatus) {
        this.accountStatus = accountStatus;
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

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    // ======================================yzg=========================================================

    /**产品金额*/
    private String price;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

}
