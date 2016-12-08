package com.buss.signin.trans.vo;

import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by HongXinGuoJi-yzg on 2016/9/21.
 */
public class SignInVo extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**用户ID*/
    @Mapping
    private String userId;
    /**签到类型*/
    @Mapping
    private String signType;
    /**签到时间*/
    @Mapping
    private String signTime;
    /**连续签到天数*/
    @Mapping
    private String signDay;
    /**签到状态*/
    @Mapping
    private String signStatus;
    /**鸿鑫币数量*/
    @Mapping
    private String hxbNum;
    /**是否连续签到*/
    @Mapping
    private String isContinuity;
    /**备注*/
    @Mapping
    private String remarks;
    /**创建时间*/
    @Mapping
    private String createTime;
    /**更新时间*/
    @Mapping
    private String upStringTime;
    /**删除标志*/
    @Mapping
    private String isDelete;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getSignType() {
        return signType;
    }

    public void setSignType(String signType) {
        this.signType = signType;
    }

    public String getSignTime() {
        return signTime;
    }

    public void setSignTime(String signTime) {
        this.signTime = signTime;
    }

    public String getSignDay() {
        return signDay;
    }

    public void setSignDay(String signDay) {
        this.signDay = signDay;
    }

    public String getHxbNum() {
        return hxbNum;
    }

    public void setHxbNum(String hxbNum) {
        this.hxbNum = hxbNum;
    }

    public String getIsContinuity() {
        return isContinuity;
    }

    public void setIsContinuity(String isContinuity) {
        this.isContinuity = isContinuity;
    }

    public String getSignStatus() {
        return signStatus;
    }

    public void setSignStatus(String signStatus) {
        this.signStatus = signStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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
}
