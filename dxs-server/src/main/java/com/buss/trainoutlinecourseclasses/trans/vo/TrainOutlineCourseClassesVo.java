package com.buss.trainoutlinecourseclasses.trans.vo;

import com.buss.trainoutlinecourseclasses.entity.TrainOutlineCourseClassesEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by HongXinGuoJi-yzg on 2016/9/9.
 */
@Mapping(entityClass = TrainOutlineCourseClassesEntity.class)
public class TrainOutlineCourseClassesVo extends BaseVO{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**培训中心->线下培训的id*/
    @Mapping
    private java.lang.String tocId;
    /**培训时间*/
    @Mapping
    private java.lang.String openTime;
    /**培训城市*/
    @Mapping
    private java.lang.String addressShort;
    /**上课地点*/
    @Mapping
    private java.lang.String address;
    /**上课时间*/
    @Mapping
    private java.lang.String time;
    /**开学时间*/
    @Mapping
    private java.lang.String startClass;
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

    public String getTocId() {
        return tocId;
    }

    public void setTocId(String tocId) {
        this.tocId = tocId;
    }

    public String getOpenTime() {
        return openTime;
    }

    public void setOpenTime(String openTime) {
        this.openTime = openTime;
    }

    public String getAddressShort() {
        return addressShort;
    }

    public void setAddressShort(String addressShort) {
        this.addressShort = addressShort;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getStartClass() {
        return startClass;
    }

    public void setStartClass(String startClass) {
        this.startClass = startClass;
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
