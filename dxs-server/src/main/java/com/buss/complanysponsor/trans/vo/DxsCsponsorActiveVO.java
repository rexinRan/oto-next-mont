package com.buss.complanysponsor.trans.vo;

import com.buss.complanysponsor.entity.DxsCsponsorActiveEntity;
import org.jweb.core.bean.BaseForm;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

import java.util.Date;

/**
 * Created by Administrator on 2016/7/23.
 */
@Mapping(entityClass = DxsCsponsorActiveEntity.class)
public class DxsCsponsorActiveVO extends BaseVO{
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
    private java.util.Date createTime;
    /**更新时间*/
    @Mapping
    private java.util.Date updateTime;
    /**删除标志*/
    @Mapping
    private java.lang.Integer isDelete;

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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
