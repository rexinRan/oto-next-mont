package com.buss.lecturesgroups.trans.vo;

import com.buss.lecturesgroups.entity.LecturesGroupsEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by HongXinGuoJi-yzg on 2016/8/25.
 */
@Mapping(entityClass = LecturesGroupsEntity.class)
public class LecturesGroupsVo extends BaseVO{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**标题*/
    @Mapping
    private java.lang.String title;
    /**缩略图*/
    @Mapping
    private java.lang.String imgUrl;
    /**简介*/
    @Mapping
    private java.lang.String summy;
    /**介绍*/
    @Mapping
    private java.lang.String introduce;
    /**主办方*/
    @Mapping
    private java.lang.String company;
    /**类型*/
    @Mapping
    private java.lang.String type;
    /**编号*/
    @Mapping
    private java.lang.String sort;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getSummy() {
        return summy;
    }

    public void setSummy(String summy) {
        this.summy = summy;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
