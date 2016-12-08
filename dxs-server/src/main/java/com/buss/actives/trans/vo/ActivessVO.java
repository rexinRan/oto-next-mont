package com.buss.actives.trans.vo;

import com.buss.actives.entity.ActivesEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/8/2.
 */
@Mapping(entityClass=ActivesEntity.class)
public class ActivessVO extends BaseVO{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**活动分类的id*/
    @Mapping
    private java.lang.String activeCatelogId;
    /**缩略图*/
    @Mapping
    private java.lang.String activeImage;
    /**内容图选*/
    @Mapping
    private java.lang.String activeContentImg;
    /**活动名称*/
    @Mapping
    private java.lang.String activeTitle;
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
    /**报名人数*/
    @Mapping
    private java.lang.String regNumbers;
    /**精彩回顾*/
    @Mapping
    private java.lang.String histaryDate;
    /**发布时间*/
    @Mapping
    private java.lang.String publishTime;
    /**报名截止时间*/
    @Mapping
    private java.lang.String deadlineDate;
    /**活动开始时间*/
    @Mapping
    private java.lang.String activeStateTime;
    /**活动结束时间*/
    @Mapping
    private java.lang.String activeEndTime;
    /**活动对象*/
    @Mapping
    private java.lang.String activeUsertypeId;
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
    /**赠送鸿鑫币数量*/
    @Mapping
    private java.lang.String giftAccountCount;
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
    private java.lang.String activesNum;
    /**特色简介*/
    @Mapping
    private java.lang.String activesCharacteristics;
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

    public String getActiveCatelogId() {
        return activeCatelogId;
    }

    public void setActiveCatelogId(String activeCatelogId) {
        this.activeCatelogId = activeCatelogId;
    }

    public String getActiveImage() {
        return activeImage;
    }

    public void setActiveImage(String activeImage) {
        this.activeImage = activeImage;
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

    public String getActiveContentImg() {
        return activeContentImg;
    }

    public void setActiveContentImg(String activeContentImg) {
        this.activeContentImg = activeContentImg;
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

    public String getRegNumbers() {
        return regNumbers;
    }

    public void setRegNumbers(String regNumbers) {
        this.regNumbers = regNumbers;
    }

    public String getHistaryDate() {
        return histaryDate;
    }

    public void setHistaryDate(String histaryDate) {
        this.histaryDate = histaryDate;
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



    // ===========================================yzg=======================================

    /**
     * 用户名称
     */
    private java.lang.String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    /**
     * 活动类型名称
     */
    private java.lang.String typeName;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }
}
