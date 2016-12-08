package com.buss.specialsarticles.trans.vo;

import com.buss.specialsarticles.entity.SpecialsArticlesEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by JSADKFJ on 2016/8/14.
 */
@Mapping(entityClass = SpecialsArticlesEntity.class)
public class SpecialsArticlesVo extends BaseVO{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**专项就业id*/
    @Mapping
    private java.lang.String specialId;
    /**标题*/
    @Mapping
    private java.lang.String title;
    /**作者*/
    @Mapping
    private java.lang.String autor;
    /**来源*/
    @Mapping
    private java.lang.String sources;
    /**发表时间*/
    @Mapping
    private java.lang.String publishTime;
    /**区域*/
    @Mapping
    private java.lang.String addressArea;
    /**年份*/
    @Mapping
    private java.lang.String timeYear;
    /**略略图*/
    @Mapping
    private java.lang.String imgUrl;
    /**视频地址*/
    @Mapping
    private java.lang.String videoUrl;
    /**简介*/
    @Mapping
    private java.lang.String summary;
    /**内容*/
    @Mapping
    private java.lang.String content;
    /**分类*/
    @Mapping
    private java.lang.String cateLog;
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

    public String getSpecialId() {
        return specialId;
    }

    public void setSpecialId(String specialId) {
        this.specialId = specialId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getSources() {
        return sources;
    }

    public void setSources(String sources) {
        this.sources = sources;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getAddressArea() {
        return addressArea;
    }

    public void setAddressArea(String addressArea) {
        this.addressArea = addressArea;
    }

    public String getTimeYear() {
        return timeYear;
    }

    public void setTimeYear(String timeYear) {
        this.timeYear = timeYear;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCateLog() {
        return cateLog;
    }

    public void setCateLog(String cateLog) {
        this.cateLog = cateLog;
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
