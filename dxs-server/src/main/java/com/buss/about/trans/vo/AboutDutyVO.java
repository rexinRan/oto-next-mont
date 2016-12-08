package com.buss.about.trans.vo;

import com.buss.about.entity.AboutDutyEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

import java.util.Date;

/**
 * Created by Administrator on 2016/7/16.
 */
@Mapping(entityClass=AboutDutyEntity.class)
public class AboutDutyVO extends BaseVO {
    /**缩略图id*/
    @Mapping
    private String imgFid;
    /**图片地址*/
    @Mapping
    private String imgUrl;
    /**主键*/
    @Mapping
    private String id;
    /**概述*/
    @Mapping
    private String summary;
    /**发布时间*/
    @Mapping
    private String publishTime;
    /**作者*/
    @Mapping
    private String author;
    /**出处*/
    @Mapping
    private String articleFrom;
    /**标题*/
    @Mapping
    private String title;
    /**内容*/
    @Mapping
    private String content;
    /**编号*/
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

    public String getImgFid() {
        return imgFid;
    }

    public void setImgFid(String imgFid) {
        this.imgFid = imgFid;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getArticleFrom() {
        return articleFrom;
    }

    public void setArticleFrom(String articleFrom) {
        this.articleFrom = articleFrom;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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