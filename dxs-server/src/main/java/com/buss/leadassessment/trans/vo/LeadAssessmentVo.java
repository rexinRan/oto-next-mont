package com.buss.leadassessment.trans.vo;

import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/6/22.
 */
@Mapping(entityClass = LeadAssessmentVo.class)
public class LeadAssessmentVo extends BaseVO {

    /**主键*/
    @Mapping
    private java.lang.String id;
    /**评价用户ID*/
    @Mapping
    private java.lang.String fromUserId;

    /**我的职业动态ID*/
    @Mapping
    private java.lang.String employmentRecordId;

    /**被评价用户id*/
    @Mapping
    private java.lang.String toUserId;
    /**职位id*/
    @Mapping
    private java.lang.String employedId;
    /**对企业的评价*/
    @Mapping
    private java.lang.String leadAssessment;
    /**发布时间*/
    @Mapping
    private java.lang.String publishTime;
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

    public String getFromUserId() {
        return fromUserId;
    }

    public void setFromUserId(String fromUserId) {
        this.fromUserId = fromUserId;
    }

    public String getToUserId() {
        return toUserId;
    }

    public void setToUserId(String toUserId) {
        this.toUserId = toUserId;
    }

    public String getEmployedId() {
        return employedId;
    }

    public void setEmployedId(String employedId) {
        this.employedId = employedId;
    }

    public String getLeadAssessment() {
        return leadAssessment;
    }

    public void setLeadAssessment(String leadAssessment) {
        this.leadAssessment = leadAssessment;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
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

    public String getEmploymentRecordId() {
        return employmentRecordId;
    }

    public void setEmploymentRecordId(String employmentRecordId) {
        this.employmentRecordId = employmentRecordId;
    }
}
