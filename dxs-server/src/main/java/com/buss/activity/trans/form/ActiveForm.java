package com.buss.activity.trans.form;

import com.buss.activity.entity.ActiveUserEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/6/16.
 */
@Mapping(entityClass= ActiveUserEntity.class)
public class ActiveForm extends SearchForm {

    /**主键*/
    @Mapping
    private java.lang.String id;
    /**活动的id*/
    @Mapping("activesEntity.id")
    private java.lang.String activeId;
    /**用户的id*/
    @Mapping("generalUserEntity.id")
    private java.lang.String userId;
    /**活动的原价*/
    @Mapping
    private java.lang.String origin;
    /**活动实际缴费金额*/
    @Mapping
    private java.lang.String price;
    /**定金*/
    @Mapping
    private java.lang.String deposit;
    /**活动步骤*/
    @Mapping
    private java.lang.String step;
    /**活动类型*/
    @Mapping
    private String type;
    /**创建时间*/
    @Mapping
    private String createTime;
    /**更新时间*/
    @Mapping
    private String upStringTime;
    /**删除标志*/
    @Mapping
    private String isDelete;

    public java.lang.String getId() {
        return id;
    }

    public void setId(java.lang.String id) {
        this.id = id;
    }

    public java.lang.String getActiveId() {
        return activeId;
    }

    public void setActiveId(java.lang.String activeId) {
        this.activeId = activeId;
    }

    public java.lang.String getUserId1() {
        return userId;
    }

    public void setUserId(java.lang.String userId) {
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpStringTime() {
        return upStringTime;
    }

    public void setUpStringTime(String upStringTime) {
        this.upStringTime = upStringTime;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    //  ================================================ activesEntity ================================================

    /**活动分类的id*/
    @Mapping("activesEntity.id")
    private String activeCatelogId;
    /**活动标题*/
    @Mapping("activesEntity.activeTitle")
    private String activeTitle;
    /**活动开始时间*/
    @Mapping("activesEntity.activeStateTime")
    private String activeStateTime;
    /**活动结束时间*/
    @Mapping("activesEntity.activeEndTime")
    private String activeEndTime;
    /**活动对象*/
    @Mapping("activesEntity.activeUsertypeId")
    private String activeUsertypeId;
    /**具体活动内容*/
    @Mapping("activesEntity.activeContent")
    private String activeContent;
    /**价钱*/
    @Mapping("activesEntity.activePrice")
    private String activePrice;
    /**是否收费*/
    @Mapping("activesEntity.isCharge")
    private java.lang.Integer isCharge;
    /**创建时间*/
    @Mapping("activesEntity.CreateTime")
    private String CreateTime;
    /**更新时间*/
    @Mapping("activesEntity.UpStringTime")
    private String UpStringTime;
    /**删除标志*/
    @Mapping("activesEntity.isDelete")
    private String activeIsDetlete;

    public String getActivePrice() {
        return activePrice;
    }

    public void setActivePrice(String activePrice) {
        this.activePrice = activePrice;
    }

    public Integer getIsCharge() {
        return isCharge;
    }

    public void setIsCharge(Integer isCharge) {
        this.isCharge = isCharge;
    }

    public String getActiveIsDetlete() {
        return activeIsDetlete;
    }

    public void setActiveIsDetlete(String activeIsDetlete) {
        this.activeIsDetlete = activeIsDetlete;
    }

    public String getActiveCatelogId() {
        return activeCatelogId;
    }

    public void setActiveCatelogId(String activeCatelogId) {
        this.activeCatelogId = activeCatelogId;
    }

    public String getActiveTitle() {
        return activeTitle;
    }

    public void setActiveTitle(String activeTitle) {
        this.activeTitle = activeTitle;
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
}
