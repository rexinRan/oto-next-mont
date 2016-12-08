package com.buss.aidtheme.trans.form;

import com.buss.aidactives.entity.AidActivesEntity;
import com.buss.aidtheme.entity.AidThemeEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;
import org.jweb.core.query.annotation.QueryStrategy;


/**
 * @author lu
 * @date 2016-06-01 13:38:23
 * @version V1.0
 *
 */
@Mapping(entityClass= AidThemeEntity.class)
public class AidThemeSearchForm extends SearchForm {
    /**主键*/
    @Mapping
    private String id;
    /**标题*/
    @Mapping
    private String title;
    /**banner图地址*/
    @Mapping
    private String bannerImg;
    /**详情页图片地址*/
    @Mapping
    private String detailImg;
    /**状态*/
    @Mapping
    private String state;
    /**目标金额*/
    @Mapping
    private String tagetMoney;
    /**已筹金额*/
    @Mapping
    private String existingMoney;
    /**开始时间*/
    @Mapping
    private String startTime;
    /**结束时间*/
    @Mapping
    private String endTime;
    /**捐款人数*/
    @Mapping
    private String number;
    /**创建时间*/
    @Mapping
    private String createTime;
    /**更新时间*/
    @Mapping
    private String updateTime;
    /**删除标志*/
    @Mapping
    private String isDelete;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBannerImg() {
        return bannerImg;
    }

    public void setBannerImg(String bannerImg) {
        this.bannerImg = bannerImg;
    }

    public String getDetailImg() {
        return detailImg;
    }

    public void setDetailImg(String detailImg) {
        this.detailImg = detailImg;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTagetMoney() {
        return tagetMoney;
    }

    public void setTagetMoney(String tagetMoney) {
        this.tagetMoney = tagetMoney;
    }

    public String getExistingMoney() {
        return existingMoney;
    }

    public void setExistingMoney(String existingMoney) {
        this.existingMoney = existingMoney;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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