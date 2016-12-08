package com.buss.complanysponsor.trans.form;

import com.buss.complanysponsor.entity.DxsCsponsorActiveEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/7/23.
 */
@Mapping(entityClass = DxsCsponsorActiveEntity.class)
public class DxsCsponsorActiveSearchForm extends SearchForm {
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**用户id*/
    @Mapping
    private java.lang.String userId;
    /**活动id*/
    @Mapping
    private java.lang.String activeId;
    /**赞助商的id*/
    @Mapping
    private java.lang.String csponsorId;
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

    public String getActiveId() {
        return activeId;
    }

    public void setActiveId(String activeId) {
        this.activeId = activeId;
    }

    public String getCsponsorId() {
        return csponsorId;
    }

    public void setCsponsorId(String csponsorId) {
        this.csponsorId = csponsorId;
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
