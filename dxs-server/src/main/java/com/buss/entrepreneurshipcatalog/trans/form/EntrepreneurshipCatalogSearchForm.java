package com.buss.entrepreneurshipcatalog.trans.form;

import com.buss.entrepreneurshipcatalog.entity.EntrepreneurshipCatalogEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * @Title: Entity
 * @Description: dxs_entrepreneurship_catalog
 * @author lu
 * @date 2016-06-06 14:24:58
 * @version V1.0
 *
 */
@Mapping(entityClass=EntrepreneurshipCatalogEntity.class)
public class EntrepreneurshipCatalogSearchForm extends SearchForm{
    /**主键*/
    @Mapping
    private String id;
    /**父节点*/
    @Mapping
    private String pid;
    /**创业中心分类*/
    @Mapping
    private String entrepreneurshipCatalogName;
    /**分类配图*/
    @Mapping
    private String entrepreneurshipImg;
    /**分类的简介*/
    @Mapping
    private String entrepreneurshipIntroduction;
    /**编码*/
    @Mapping
    private String sort;
    /**创建时间*/
    @Mapping
    private String createTime;
    /**更新时间*/
    @Mapping
    private String updateTime;
    /**删除标志*/
    @Mapping
    private String isDelete;

    public EntrepreneurshipCatalogSearchForm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getEntrepreneurshipCatalogName() {
        return entrepreneurshipCatalogName;
    }

    public void setEntrepreneurshipCatalogName(String entrepreneurshipCatalogName) {
        this.entrepreneurshipCatalogName = entrepreneurshipCatalogName;
    }

    public String getEntrepreneurshipImg() {
        return entrepreneurshipImg;
    }

    public void setEntrepreneurshipImg(String entrepreneurshipImg) {
        this.entrepreneurshipImg = entrepreneurshipImg;
    }

    public String getEntrepreneurshipIntroduction() {
        return entrepreneurshipIntroduction;
    }

    public void setEntrepreneurshipIntroduction(String entrepreneurshipIntroduction) {
        this.entrepreneurshipIntroduction = entrepreneurshipIntroduction;
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
