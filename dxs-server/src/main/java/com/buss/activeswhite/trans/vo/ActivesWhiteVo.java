package com.buss.activeswhite.trans.vo;

import com.buss.activeswhite.entity.ActivesWhiteEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/7/30.
 */
@Mapping(entityClass = ActivesWhiteEntity.class)
public class ActivesWhiteVo extends BaseVO{

    /**主键*/
    @Mapping
    private java.lang.String id;
    /**用户id*/
    @Mapping
    private java.lang.String userId;
    /**目的地*/
    @Mapping
    private java.lang.String destination;
    /**备选目的地*/
    @Mapping
    private java.lang.String destinationRemarks;
    /**出发时间*/
    @Mapping
    private java.lang.String setOutTime;
    /**备选时间*/
    @Mapping
    private java.lang.String setOutTimeRemarksTime;
    /**出行天数*/
    @Mapping
    private java.lang.String days;
    /**行程预算*/
    @Mapping
    private java.lang.String tripPrices;
    /**成了人数*/
    @Mapping
    private java.lang.String tripBigNum;
    /**儿童人数*/
    @Mapping
    private java.lang.String tripSmailNum;
    /**详细地址*/
    @Mapping
    private java.lang.String address;
    /**备注*/
    @Mapping
    private java.lang.String remarks;
    /**申请状态*/
    @Mapping
    private java.lang.String result;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestinationRemarks() {
        return destinationRemarks;
    }

    public void setDestinationRemarks(String destinationRemarks) {
        this.destinationRemarks = destinationRemarks;
    }

    public String getSetOutTime() {
        return setOutTime;
    }

    public void setSetOutTime(String setOutTime) {
        this.setOutTime = setOutTime;
    }

    public String getSetOutTimeRemarksTime() {
        return setOutTimeRemarksTime;
    }

    public void setSetOutTimeRemarksTime(String setOutTimeRemarksTime) {
        this.setOutTimeRemarksTime = setOutTimeRemarksTime;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getTripPrices() {
        return tripPrices;
    }

    public void setTripPrices(String tripPrices) {
        this.tripPrices = tripPrices;
    }

    public String getTripBigNum() {
        return tripBigNum;
    }

    public void setTripBigNum(String tripBigNum) {
        this.tripBigNum = tripBigNum;
    }

    public String getTripSmailNum() {
        return tripSmailNum;
    }

    public void setTripSmailNum(String tripSmailNum) {
        this.tripSmailNum = tripSmailNum;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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
