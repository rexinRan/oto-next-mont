package com.buss.activesmathch.trans.from;

import com.buss.activesmathch.entity.ActivesMathchEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by HongXinGuoJi-yzg on 2016/8/30.
 */
@Mapping(entityClass = ActivesMathchEntity.class)
public class ActivesMathchFrom extends SearchForm{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**活动id*/
    @Mapping
    private java.lang.String activeId;
    /**协办单位*/
    @Mapping
    private java.lang.String coOrganizer;
    /**承办单位*/
    @Mapping
    private java.lang.String undertakingUnit;
    /**赞助单位*/
    @Mapping
    private java.lang.String supportingUnit;
    /**支持单位*/
    @Mapping
    private java.lang.String supportUnit;
    /**媒体单位*/
    @Mapping
    private java.lang.String mediaUnit;
    /**奖项设置*/
    @Mapping
    private java.lang.String prize;
    /**参赛对象及要求*/
    @Mapping
    private java.lang.String objectRequired;
    /**报名指南*/
    @Mapping
    private java.lang.String guide;
    /**赛事安排*/
    @Mapping
    private java.lang.String origanze;
    /**赛事动态*/
    @Mapping
    private java.lang.String news;
    /**赛事宣传片*/
    @Mapping
    private java.lang.String videoUrl;
    /**精彩回放*/
    @Mapping
    private java.lang.String imgurls;
    /**资料下载(预留)*/
    @Mapping
    private java.lang.String fid;
    /**时间流程图*/
    @Mapping
    private java.lang.String timeFlow;
    /**其他*/
    @Mapping
    private java.lang.String others;
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

    public String getActiveId() {
        return activeId;
    }

    public void setActiveId(String activeId) {
        this.activeId = activeId;
    }

    public String getCoOrganizer() {
        return coOrganizer;
    }

    public void setCoOrganizer(String coOrganizer) {
        this.coOrganizer = coOrganizer;
    }

    public String getUndertakingUnit() {
        return undertakingUnit;
    }

    public void setUndertakingUnit(String undertakingUnit) {
        this.undertakingUnit = undertakingUnit;
    }

    public String getSupportingUnit() {
        return supportingUnit;
    }

    public void setSupportingUnit(String supportingUnit) {
        this.supportingUnit = supportingUnit;
    }

    public String getSupportUnit() {
        return supportUnit;
    }

    public void setSupportUnit(String supportUnit) {
        this.supportUnit = supportUnit;
    }

    public String getMediaUnit() {
        return mediaUnit;
    }

    public void setMediaUnit(String mediaUnit) {
        this.mediaUnit = mediaUnit;
    }

    public String getPrize() {
        return prize;
    }

    public void setPrize(String prize) {
        this.prize = prize;
    }

    public String getObjectRequired() {
        return objectRequired;
    }

    public void setObjectRequired(String objectRequired) {
        this.objectRequired = objectRequired;
    }

    public String getGuide() {
        return guide;
    }

    public void setGuide(String guide) {
        this.guide = guide;
    }

    public String getOriganze() {
        return origanze;
    }

    public void setOriganze(String origanze) {
        this.origanze = origanze;
    }

    public String getNews() {
        return news;
    }

    public void setNews(String news) {
        this.news = news;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getImgurls() {
        return imgurls;
    }

    public void setImgurls(String imgurls) {
        this.imgurls = imgurls;
    }

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getTimeFlow() {
        return timeFlow;
    }

    public void setTimeFlow(String timeFlow) {
        this.timeFlow = timeFlow;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
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
