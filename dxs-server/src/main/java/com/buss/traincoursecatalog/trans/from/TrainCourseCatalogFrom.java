package com.buss.traincoursecatalog.trans.from;

import com.buss.traincoursecatalog.entity.TrainCourseCatalogEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;


/**
 * Created by HongXinGuoJi-yzg on 2016/9/7.
 */
@Mapping(entityClass = TrainCourseCatalogEntity.class)
public class TrainCourseCatalogFrom extends SearchForm {

    /**主键*/
    @Mapping
    private String id;
    /**分类名称*/
    @Mapping
    private String catalogName;
    /**分类显示名(预留)*/
    @Mapping
    private String catalogDisplayName;
    /**编号*/
    @Mapping
    private String sort;
    /**父id*/
    @Mapping
    private String pid;
    /**创建时间*/
    @Mapping
    private String createTime;
    /**更新时间*/
    @Mapping
    private String upStringTime;
    /**删除标志*/
    @Mapping
    private String isDelete;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public String getCatalogDisplayName() {
        return catalogDisplayName;
    }

    public void setCatalogDisplayName(String catalogDisplayName) {
        this.catalogDisplayName = catalogDisplayName;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
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
