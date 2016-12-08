package com.buss.specialrecruit.trans.from;

import com.buss.specialrecruit.entity.ResumeUsersEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/7/26.
 */
@Mapping(entityClass = ResumeUsersEntity.class)
public class ResumeUserSearchFrom extends SearchForm{

    /**主键*/
    @Mapping
    private java.lang.String id;
    /**用户ID*/
    @Mapping
    private java.lang.String userId;
    /**投递人*/
    @Mapping
    private java.lang.String userName;
    /**简历的id*/
    @Mapping
    private java.lang.String resumeId;
    /**职位id*/
    @Mapping
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
