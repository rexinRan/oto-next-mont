package com.buss.activity.trans.vo;

import com.buss.actives.entity.ActivesEntity;
import com.buss.actives.trans.vo.ActivesVO;
import com.buss.activity.entity.ActiveUserEntity;
import com.buss.userdetail.entity.UserDetailEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import javax.persistence.criteria.Fetch;
import java.lang.String;
import java.lang.String;

/**
 * Created by Administrator on 2016/6/16.
 */
@Mapping(entityClass= ActiveUserEntity.class)
public class ActiveVO extends BaseVO {

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
    private java.lang.String type;
    /**创建时间*/
    @Mapping
    private java.lang.String createTime;
    /**更新时间*/
    @Mapping
    private java.lang.String upStringTime;
    /**删除标志*/
    @Mapping
    private java.lang.String isDelete;
    @Mapping
    private ActivesVO activeVO;
    @Mapping
    private ActivesEntity activesEntity;

    public ActivesVO getActiveVO() {
        return activeVO;
    }

    public void setActiveVO(ActivesVO activeVO) {
        this.activeVO = activeVO;
    }

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeposit() {
        return deposit;
    }

    public void setDeposit(String deposit) {
        this.deposit = deposit;
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step;
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

    public String getUpStringTime() {
        return upStringTime;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setUpStringTime(String upStringTime) {
        this.upStringTime = upStringTime;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public ActivesEntity getActivesEntity() {
        return activesEntity;
    }

    public void setActivesEntity(ActivesEntity activesEntity) {
        this.activesEntity = activesEntity;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    //    ================================================ activesEntity ================================================


    /**活动标题*/
    @Mapping("activesEntity.activeTitle")
    private String activeTitle;

    /**价钱*/
    @Mapping("activesEntity.activePrice")
    private String activePrice;

    /**是否收费*/
    @Mapping("activesEntity.isCharge")
    private java.lang.String isCharge;

    /**可使用鸿鑫币数量*/
    @Mapping("activesEntity.maxAccountCount")
    private java.lang.String maxAccountCount;

    public String getActiveTitle() {
        return activeTitle;
    }

    public void setActiveTitle(String activeTitle) {
        this.activeTitle = activeTitle;
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

    // ===================================账号信息表========================================================

    // 鸿鑫币
    private String account;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    // ======================================================================================================
    @Transient
    private  java.lang.String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
