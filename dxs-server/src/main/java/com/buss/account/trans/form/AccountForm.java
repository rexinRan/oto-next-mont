package com.buss.account.trans.form;

import com.buss.account.entity.DxsAccountEntity;
import com.buss.activity.entity.ActiveUserEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;


/**
 * Created by Administrator on 2016/7/4.
 */
@Mapping(entityClass= DxsAccountEntity.class)
public class AccountForm extends SearchForm {
    /**主键*/
    @Mapping
    private String id;
    /**用户ID*/
    @Mapping
    private String userId;
    /**账户*/
    @Mapping
    private String account;
    /**签到鸿鑫币*/
    @Mapping
    private Integer signAccount;
    /**外部标记*/
    @Mapping
    private String outId;
    /**账户状态*/
    @Mapping
    private String accountStatus;
    /**创建时间*/
    @Mapping
    private String createTime;
    /**更新时间*/
    @Mapping
    private String upStringTime;
    /**删除标志*/
    @Mapping
    private String isDelete;


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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getSignAccount() {
        return signAccount;
    }

    public void setSignAccount(Integer signAccount) {
        this.signAccount = signAccount;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
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

    public String getUpStringTime() {
        return upStringTime;
    }

    public void setUpStringTime(String upStringTime) {
        this.upStringTime = upStringTime;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
}
