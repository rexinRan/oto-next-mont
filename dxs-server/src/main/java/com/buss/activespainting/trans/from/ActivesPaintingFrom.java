package com.buss.activespainting.trans.from;

import com.buss.activespainting.entity.ActivesPaintingEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by HongXinGuoJi-yzg on 2016/8/30.
 */
@Mapping(entityClass = ActivesPaintingEntity.class)
public class ActivesPaintingFrom extends SearchForm{
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
    /**举办省份*/
    @Mapping
    private java.lang.String hostProvinces;
    /**活动流程*/
    @Mapping
    private java.lang.String activityFlow;
    /**参赛对象及要求*/
    @Mapping
    private java.lang.String objectRequired;
    /**精彩回放*/
    @Mapping
    private java.lang.String imgUrls;
    /**宣传片*/
    @Mapping
    private java.lang.String videoUrl;
    /**时间流程*/
    @Mapping
    private java.lang.String timeFlows;
    /**其他*/
    @Mapping
    private java.lang.String others;
    /**子分类*/
    @Mapping
    private java.lang.String catalogChilds;
    /**邮箱*/
    @Mapping
    private java.lang.String sendEmail;
    /**邮件格式*/
    @Mapping
    private java.lang.String emailStyle;
    /**快递地址*/
    @Mapping
    private java.lang.String sendAddress;
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

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
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

    public String getHostProvinces() {
        return hostProvinces;
    }

    public void setHostProvinces(String hostProvinces) {
        this.hostProvinces = hostProvinces;
    }

    public String getActivityFlow() {
        return activityFlow;
    }

    public void setActivityFlow(String activityFlow) {
        this.activityFlow = activityFlow;
    }

    public String getObjectRequired() {
        return objectRequired;
    }

    public void setObjectRequired(String objectRequired) {
        this.objectRequired = objectRequired;
    }

    public String getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(String imgUrls) {
        this.imgUrls = imgUrls;
    }

    public String getTimeFlows() {
        return timeFlows;
    }

    public void setTimeFlows(String timeFlows) {
        this.timeFlows = timeFlows;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
    }

    public String getCatalogChilds() {
        return catalogChilds;
    }

    public void setCatalogChilds(String catalogChilds) {
        this.catalogChilds = catalogChilds;
    }

    public String getSendEmail() {
        return sendEmail;
    }

    public void setSendEmail(String sendEmail) {
        this.sendEmail = sendEmail;
    }

    public String getEmailStyle() {
        return emailStyle;
    }

    public void setEmailStyle(String emailStyle) {
        this.emailStyle = emailStyle;
    }

    public String getSendAddress() {
        return sendAddress;
    }

    public void setSendAddress(String sendAddress) {
        this.sendAddress = sendAddress;
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
