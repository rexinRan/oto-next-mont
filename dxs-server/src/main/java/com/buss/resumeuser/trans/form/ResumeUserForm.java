package com.buss.resumeuser.trans.form;

import com.buss.resumeuser.entity.ResumeUserEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;
import org.jweb.core.query.annotation.QueryStrategy;

import java.lang.String;

/**
 * Created by Administrator on 2016/6/20.
 */
@Mapping(entityClass=ResumeUserEntity.class)
public class ResumeUserForm extends SearchForm{

    /**主键*/
    @Mapping
    private java.lang.String id;
    /**用户ID*/
    @Mapping("generalUserEntity.id")
    private java.lang.String userId;
    /**投递人*/
    @Mapping
    private java.lang.String userName;
    /**简历的id*/
    @Mapping("resumeEntity.id")
    private java.lang.String resumeId;
    /**职位id*/
    @Mapping("employedEntity.id")
    private java.lang.String emoloyedId;
    /**投递时间*/
    @Mapping
    private java.lang.String sendTime;
    /**结果*/
    @Mapping
    private java.lang.String result;
    /**类型*/
    @Mapping
    private java.lang.String type;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
    }

    public String getEmoloyedId() {
        return emoloyedId;
    }

    public void setEmoloyedId(String emoloyedId) {
        this.emoloyedId = emoloyedId;
    }

    public String getSendTime() {
        return sendTime;
    }

    public void setSendTime(String sendTime) {
        this.sendTime = sendTime;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    // ================================================关联字段映射======================================

    /**企业名称*/
    @Mapping("employedEntity.compancyName")
    @QueryStrategy
    private java.lang.String compancyName;;

    public String getCompancyName() {
        return compancyName;
    }

    public void setCompancyName(String compancyName) {
        this.compancyName = compancyName;
    }
}
