package com.buss.collentions.trans.vo;

import com.buss.collentions.entity.CollentionsEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

import java.lang.String;

/**
 * Created by Administrator on 2016/7/21.
 */
@Mapping(entityClass = CollentionsEntity.class)
public class CollentionsVo extends BaseVO{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**外键*/
    @Mapping
    private java.lang.String outId;
    /**用户id*/
    @Mapping
    private java.lang.String userId;
    /**类型*/
    @Mapping
    private java.lang.String type;
    /**备注*/
    @Mapping
    private java.lang.String remarks;
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

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
