package com.buss.project.projectapply.trans.form;

import com.buss.project.projectapply.entity.ProjectApplyEntity;
import com.buss.project.projectresult.entity.ProjectResultEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;


/**
 * @author lu
 * @date 2016-06-06 11:48:24
 * @version V1.0
 *
 */
@Mapping(entityClass= ProjectApplyEntity.class)
public class ProjectApplySearchForm extends SearchForm {
    /**主键*/
    @Mapping
    private String id;
    /**用户id*/
    @Mapping
    private String userId;
    /**教师id*/
    @Mapping
    private String teaId;
    /**项目id*/
    @Mapping
    private String projectId;
    /**关联id*/
    @Mapping
    private String outId;
    /**类型*/
    @Mapping
    private String type;
    /**申请类型*/
    @Mapping
    private String applyType;
    /**申请结果*/
    @Mapping
    private String result;
    /**消息反馈*/
    @Mapping
    private String message;
    /**备注*/
    @Mapping
    private String remarks;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTeaId() {
        return teaId;
    }

    public void setTeaId(String teaId) {
        this.teaId = teaId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getApplyType() {
        return applyType;
    }

    public void setApplyType(String applyType) {
        this.applyType = applyType;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
