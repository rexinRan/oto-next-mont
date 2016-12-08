package com.buss.aidactives.trans.vo;

import com.buss.aidactives.entity.AidActivesEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

import java.util.Map;


/**
 * @author lu
 * @date 2016-06-01 13:38:23
 * @version V1.0
 *
 */
@Mapping(entityClass=AidActivesEntity.class)
public class AidActiveItemsVO extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**公益主题*/
    @Mapping
    private String catalog;
    /**主办方*/
    @Mapping
    private String sponsor;
    /**发布时间*/
    @Mapping
    private String publishTime;
    /**报名截止时间*/
    @Mapping
    private String deadlineDate;
    /**活动开始时间*/
    @Mapping
    private String activeStartTime;
    /**活动结束时间*/
    @Mapping
    private String activeEndTime;
    /**活动分类*/
    @Mapping
    private String activeCatelog;
    /**已报名人数*/
    @Mapping
    private String activeNumber;
    /**活动地点*/
    @Mapping
    private String activeAddress;
    /**活动简介*/
    @Mapping
    private String activeIntroduce;
    /**缩略图*/
    @Mapping
    private String imgUrl;
    /**活动状态*/
    private  String state;
    /**活动介绍*/
    private Map content;
    /**实施意义*/
    private Map meanings;
    /**达到目的*/
    private Map target;
    /**精彩回顾*/
    private Map review;
    /**活动总结*/
    private Map summary;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Map getContent() {
        return content;
    }

    public void setContent(Map content) {
        this.content = content;
    }

    public Map getMeanings() {
        return meanings;
    }

    public void setMeanings(Map meanings) {
        this.meanings = meanings;
    }

    public Map getTarget() {
        return target;
    }

    public void setTarget(Map target) {
        this.target = target;
    }

    public Map getReview() {
        return review;
    }

    public void setReview(Map review) {
        this.review = review;
    }

    public Map getSummary() {
        return summary;
    }

    public void setSummary(Map summary) {
        this.summary = summary;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(String deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public String getActiveStartTime() {
        return activeStartTime;
    }

    public void setActiveStartTime(String activeStartTime) {
        this.activeStartTime = activeStartTime;
    }

    public String getActiveEndTime() {
        return activeEndTime;
    }

    public void setActiveEndTime(String activeEndTime) {
        this.activeEndTime = activeEndTime;
    }

    public String getActiveCatelog() {
        return activeCatelog;
    }

    public void setActiveCatelog(String activeCatelog) {
        this.activeCatelog = activeCatelog;
    }

    public String getActiveNumber() {
        return activeNumber;
    }

    public void setActiveNumber(String activeNumber) {
        this.activeNumber = activeNumber;
    }

    public String getActiveAddress() {
        return activeAddress;
    }

    public void setActiveAddress(String activeAddress) {
        this.activeAddress = activeAddress;
    }

    public String getActiveIntroduce() {
        return activeIntroduce;
    }

    public void setActiveIntroduce(String activeIntroduce) {
        this.activeIntroduce = activeIntroduce;
    }
}
