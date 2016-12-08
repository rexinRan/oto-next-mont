package com.buss.manager.transfer.form;

import com.buss.leadassessment.entity.LeadAssessmentEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/6/22.
 * 入职员工点评
 */
@Mapping(entityClass = LeadAssessmentEntity.class)
public class EmpAssessmentForm extends SearchForm {

    /**主键*/
    @Mapping
    private String id;
    /**评价用户ID*/
    @Mapping
    private String fromUserId;
    /**被评价用户id*/

    /**我的职业动态ID*/
    @Mapping
    private String employmentRecordId;

    @Mapping
    private String toUserId;
    /**职位id*/
    @Mapping
    private String employedId;
    /**对企业的评价*/
    @Mapping
    private String leadAssessment;
    /**发布时间*/
    @Mapping
    private String publishTime;
    /**创建时间*/
    @Mapping
    private String createTime;
    /**更新时间*/
    @Mapping
    private String updateTime;
    /**删除标志*/
    @Mapping
    private String isDelete;

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
