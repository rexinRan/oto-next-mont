package com.buss.actives.trans.form;

import com.buss.actives.entity.ActivesEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;
import org.jweb.core.query.annotation.Begin;
import org.jweb.core.query.annotation.End;
import org.jweb.core.query.constant.RegionPattern;

import java.util.Date;


/**
 * @author lu
 * @date 2016-06-06 11:48:24
 * @version V1.0
 *
 */
@Mapping(entityClass=ActivesEntity.class)
public class ActivesSearchForm extends SearchForm {
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**活动分类的id*/
    @Mapping
    private java.lang.String activeCatelogId;
    /**活动分类名*/
    @Mapping("activeCatelogEntity.activeCatelogName")
    private String activeCatelogName;
    /**活动分类pid*/
    @Mapping("activeCatelogEntity.pid")
    private String pid;
    /**活动种类配图*/
    @Mapping("activeCatelogEntity.activeCatelogImg")
    private String activeCatelogImg;
    /**内容图选*/
    @Mapping
    private java.lang.String activeContentImg;
    /**活动种类的描述*/
    @Mapping("activeCatelogEntity.activeCatelogDescribe")
    private String activeCatelogDescribe;
    /**活动种类的排序*/
    @Mapping("activeCatelogEntity.activeCatelogSort")
    private String activeCatelogSort;
    /**活动标题*/
    @Mapping
    private java.lang.String activeTitle;
    /**活动缩略图*/
    @Mapping
    private java.lang.String activeImage;
    /**展示菜单*/
    @Mapping
    private java.lang.String displayMenu;
    /**活动地点*/
    @Mapping
    private java.lang.String activeAddress;
    /**主办单位*/
    @Mapping
    private java.lang.String hostUnit;
    /**限报人数*/
    @Mapping
    private java.lang.String limitedNumber;
    /**精彩回顾*/
    @Mapping
    private java.lang.String histaryDate;
    /**报名截止时间*/
    @Mapping
    private String deadlineDate;
    /**活动开始时间*/
    @Mapping
    private String activeStateTime;
    /**活动结束时间*/
    @Mapping
    private String activeEndTime;
    /**活动对象*/
    @Mapping
    private java.lang.String activeUsertypeId;
    /**报名人数*/
    @Mapping
    private java.lang.String regNumbers;
    /**具体活动内容*/
    @Mapping
    private java.lang.String activeContent;
    /**价钱*/
    @Mapping
    private java.lang.String activePrice;
    /**是否收费 0收费 1不收费*/
    @Mapping
    private java.lang.String isCharge;
    /**可使用鸿鑫币数量*/
    @Mapping
    private java.lang.String maxAccountCount;
    /**活动赠送鸿鑫豆的数量*/
    @Mapping
    private  java.lang.String giftAccountCount;
    /**发布时间*/
    @Mapping
    private String publishTime;
    /**编辑人*/
    @Mapping
    private java.lang.String activeEditor;
    /**备注*/
    @Mapping
    private java.lang.String remarks;
    /**活动分类2*/
    @Mapping
    private java.lang.String sctiveType2;
    /**活动分类3*/
    @Mapping
    private java.lang.String sctiveType3;
    /**出发时间*/
    @Mapping
    private java.lang.String setOutTime;
    /**出发地*/
    @Mapping
    private java.lang.String setOutAddress;
    /**活动国家*/
    @Mapping
    private java.lang.String activeCountry;
    /**行程天数*/
    @Mapping
    private java.lang .String activesNum;
    /**特色简介*/
    @Mapping
    private java.lang.String activesCharacteristics;
    /**创建时间*/
    @Mapping
    private String createTime;
    /**更新时间*/
    @Mapping
    private String updateTime;
    /**删除标志*/
    @Mapping
    private java.lang.String isDelete;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActiveCatelogId() {
        return activeCatelogId;
    }

    public void setActiveCatelogId(String activeCatelogId) {
        this.activeCatelogId = activeCatelogId;
    }

    public String getActiveCatelogName() {
        return activeCatelogName;
    }

    public void setActiveCatelogName(String activeCatelogName) {
        this.activeCatelogName = activeCatelogName;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getActiveCatelogImg() {
        return activeCatelogImg;
    }

    public void setActiveCatelogImg(String activeCatelogImg) {
        this.activeCatelogImg = activeCatelogImg;
    }

    public String getActiveCatelogDescribe() {
        return activeCatelogDescribe;
    }

    public void setActiveCatelogDescribe(String activeCatelogDescribe) {
        this.activeCatelogDescribe = activeCatelogDescribe;
    }

    public String getRegNumbers() {
        return regNumbers;
    }

    public void setRegNumbers(String regNumbers) {
        this.regNumbers = regNumbers;
    }

    public String getActiveCatelogSort() {
        return activeCatelogSort;
    }

    public void setActiveCatelogSort(String activeCatelogSort) {
        this.activeCatelogSort = activeCatelogSort;
    }

    public String getActiveTitle() {
        return activeTitle;
    }

    public void setActiveTitle(String activeTitle) {
        this.activeTitle = activeTitle;
    }

    public String getDisplayMenu() {
        return displayMenu;
    }

    public void setDisplayMenu(String displayMenu) {
        this.displayMenu = displayMenu;
    }

    public String getActiveAddress() {
        return activeAddress;
    }

    public void setActiveAddress(String activeAddress) {
        this.activeAddress = activeAddress;
    }

    public String getHostUnit() {
        return hostUnit;
    }

    public void setHostUnit(String hostUnit) {
        this.hostUnit = hostUnit;
    }

    public String getLimitedNumber() {
        return limitedNumber;
    }

    public void setLimitedNumber(String limitedNumber) {
        this.limitedNumber = limitedNumber;
    }

    public String getHistaryDate() {
        return histaryDate;
    }

    public void setHistaryDate(String histaryDate) {
        this.histaryDate = histaryDate;
    }

    public String getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(String deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public String getActiveStateTime() {
        return activeStateTime;
    }

    public void setActiveStateTime(String activeStateTime) {
        this.activeStateTime = activeStateTime;
    }

    public String getActiveEndTime() {
        return activeEndTime;
    }

    public void setActiveEndTime(String activeEndTime) {
        this.activeEndTime = activeEndTime;
    }

    public String getActiveUsertypeId() {
        return activeUsertypeId;
    }

    public void setActiveUsertypeId(String activeUsertypeId) {
        this.activeUsertypeId = activeUsertypeId;
    }

    public String getActiveContent() {
        return activeContent;
    }

    public void setActiveContent(String activeContent) {
        this.activeContent = activeContent;
    }

    public String getActivePrice() {
        return activePrice;
    }

    public void setActivePrice(String activePrice) {
        this.activePrice = activePrice;
    }

    public String getIsCharge() {
        return isCharge;
    }

    public void setIsCharge(String isCharge) {
        this.isCharge = isCharge;
    }

    public String getMaxAccountCount() {
        return maxAccountCount;
    }

    public void setMaxAccountCount(String maxAccountCount) {
        this.maxAccountCount = maxAccountCount;
    }

    public String getGiftAccountCount() {
        return giftAccountCount;
    }

    public void setGiftAccountCount(String giftAccountCount) {
        this.giftAccountCount = giftAccountCount;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getActiveEditor() {
        return activeEditor;
    }

    public void setActiveEditor(String activeEditor) {
        this.activeEditor = activeEditor;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getSctiveType2() {
        return sctiveType2;
    }

    public void setSctiveType2(String sctiveType2) {
        this.sctiveType2 = sctiveType2;
    }

    public String getSctiveType3() {
        return sctiveType3;
    }

    public void setSctiveType3(String sctiveType3) {
        this.sctiveType3 = sctiveType3;
    }

    public String getSetOutTime() {
        return setOutTime;
    }

    public void setSetOutTime(String setOutTime) {
        this.setOutTime = setOutTime;
    }

    public String getSetOutAddress() {
        return setOutAddress;
    }

    public void setSetOutAddress(String setOutAddress) {
        this.setOutAddress = setOutAddress;
    }

    public String getActiveCountry() {
        return activeCountry;
    }

    public void setActiveCountry(String activeCountry) {
        this.activeCountry = activeCountry;
    }

    public String getActivesNum() {
        return activesNum;
    }

    public void setActivesNum(String activesNum) {
        this.activesNum = activesNum;
    }

    public String getActivesCharacteristics() {
        return activesCharacteristics;
    }

    public void setActivesCharacteristics(String activesCharacteristics) {
        this.activesCharacteristics = activesCharacteristics;
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

    public String getActiveImage() {
        return activeImage;
    }

    public void setActiveImage(String activeImage) {
        this.activeImage = activeImage;
    }

    public String getActiveContentImg() {
        return activeContentImg;
    }

    public void setActiveContentImg(String activeContentImg) {
        this.activeContentImg = activeContentImg;
    }
}
