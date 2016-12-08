package com.buss.dist.trans.form;

import org.jweb.core.bean.SearchForm;

/**
 * Created by Administrator on 2016/7/21.
 */
public class DistProjectClassSearchForm extends SearchForm {
    /**主键*/
    private String id;
    /**级别*/
    private String projectClass;
    /**排序*/
    private String sort;
    /**创建时间*/
    private String createTime;
    /**更新时间*/
    private String updateTime;
    /**删除标志*/
    private String isDelete;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectClass() {
        return projectClass;
    }

    public void setProjectClass(String projectClass) {
        this.projectClass = projectClass;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
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
