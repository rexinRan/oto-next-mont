package com.buss.activesfriendship.trans.vo;

import com.buss.activesfriendship.entity.ActivesFriendshipEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by HongXinGuoJi-yzg on 2016/8/30.
 */
@Mapping(entityClass = ActivesFriendshipEntity.class)
public class ActivesFriendshipVo extends BaseVO{
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
    /**学校*/
    @Mapping
    private java.lang.String schoolName;
    /**时间流程图*/
    @Mapping
    private java.lang.String timeFlow;
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

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getTimeFlow() {
        return timeFlow;
    }

    public void setTimeFlow(String timeFlow) {
        this.timeFlow = timeFlow;
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

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
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

    // ==========================================================================

    private Object picture[];

    public Object[] getPicture() {
        return picture;
    }

    public void setPicture(Object[] picture) {
        this.picture = picture;
    }
}
