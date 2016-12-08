package com.buss.specialrecruit.trans.from;

import com.buss.specialrecruit.entity.SpecialRecruitEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/7/25.
 */
@Mapping(entityClass = SpecialRecruitEntity.class)
public class SpecialReruitFrom extends SearchForm{

    /**主键*/
    @Mapping
    private java.lang.String id;
    /**专场大学*/
    @Mapping
    private java.lang.String spSchool;
    /**专场缩略图*/
    @Mapping
    private java.lang.String spImgurlFid;
    /**专场图片地址*/
    @Mapping
    private java.lang.String spImgurl;
    /**招聘专业方向*/
    @Mapping
    private java.lang.String spDirection;
    /**招聘岗位数*/
    @Mapping
    private java.lang.String spJobNum;
    /**学历层次*/
    @Mapping
    private java.lang.String spEducation;
    /**开始时间*/
    @Mapping
    private java.lang.String holdStartTime;
    /**结束时间*/
    @Mapping
    private java.lang.String holdEndTime;
    /**日期*/
    private java.lang.String holdDatatime;
    /**举办年份*/
    @Mapping
    private java.lang.String holdDate;
    /**举办场次*/
    @Mapping
    private java.lang.String holdNum;
    /**详细地址*/
    @Mapping
    private java.lang.String spAddress;
    /**创建时间*/
    @Mapping
    private java.lang.String createTime;
    /**更新时间*/
    @Mapping
    private java.lang.String updateTime;
    /**删除标志*/
    @Mapping
    private java.lang.String isDelete;
    

    public String getHoldStartTime() {
        return holdStartTime;
    }

    public void setHoldStartTime(String holdStartTime) {
        this.holdStartTime = holdStartTime;
    }

    public String getHoldEndTime() {
        return holdEndTime;
    }

    public void setHoldEndTime(String holdEndTime) {
        this.holdEndTime = holdEndTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpSchool() {
        return spSchool;
    }

    public void setSpSchool(String spSchool) {
        this.spSchool = spSchool;
    }

    public String getSpImgurlFid() {
        return spImgurlFid;
    }

    public void setSpImgurlFid(String spImgurlFid) {
        this.spImgurlFid = spImgurlFid;
    }

    public String getSpImgurl() {
        return spImgurl;
    }

    public void setSpImgurl(String spImgurl) {
        this.spImgurl = spImgurl;
    }

    public String getSpDirection() {
        return spDirection;
    }

    public void setSpDirection(String spDirection) {
        this.spDirection = spDirection;
    }

    public String getSpJobNum() {
        return spJobNum;
    }

    public void setSpJobNum(String spJobNum) {
        this.spJobNum = spJobNum;
    }

    public String getSpEducation() {
        return spEducation;
    }

    public void setSpEducation(String spEducation) {
        this.spEducation = spEducation;
    }

    public String getHoldDatatime() {
        return holdDatatime;
    }

    public void setHoldDatatime(String holdDatatime) {
        this.holdDatatime = holdDatatime;
    }

    public String getHoldDate() {
        return holdDate;
    }

    public void setHoldDate(String holdDate) {
        this.holdDate = holdDate;
    }

    public String getHoldNum() {
        return holdNum;
    }

    public void setHoldNum(String holdNum) {
        this.holdNum = holdNum;
    }

    public String getSpAddress() {
        return spAddress;
    }

    public void setSpAddress(String spAddress) {
        this.spAddress = spAddress;
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
