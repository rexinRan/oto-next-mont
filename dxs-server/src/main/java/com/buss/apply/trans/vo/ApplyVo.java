package com.buss.apply.trans.vo;

import com.buss.activity.entity.ActiveUserEntity;
import com.buss.apply.entity.ApplyEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

import java.lang.String;
import java.lang.String;

/**
 * Created by Administrator on 2016/6/20.
 */
@Mapping(entityClass= ApplyEntity.class)
public class ApplyVo extends BaseVO{

    /**主键*/
    @Mapping
    private java.lang.String id;
    /**用户ID*/
    @Mapping("generalUserEntity.id")
    private java.lang.String userId;
    /**审核码*/
    @Mapping
    private java.lang.String checkcode;
    /**奖学金级别*/
    @Mapping
    private java.lang.String textType;
    /**申请时间*/
    @Mapping
    private java.lang.String applicationTime;
    /**申请类型*/
    @Mapping
    private java.lang.String applyType;
    /**创建时间*/
    @Mapping
    private java.lang.String createTime;
    /**更新时间*/
    @Mapping
    private java.lang.String upStringTime;
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

    public String getCheckcode() {
        return checkcode;
    }

    public void setCheckcode(String checkcode) {
        this.checkcode = checkcode;
    }

    public String getTextType() {
        return textType;
    }

    public void setTextType(String textType) {
        this.textType = textType;
    }

    public String getApplicationTime() {
        return applicationTime;
    }

    public void setApplicationTime(String applicationTime) {
        this.applicationTime = applicationTime;
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
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
