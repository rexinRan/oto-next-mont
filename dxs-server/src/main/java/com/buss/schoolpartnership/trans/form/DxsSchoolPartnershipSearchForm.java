package com.buss.schoolpartnership.trans.form;

import com.buss.schoolpartnership.entity.DxsSchoolPartnershipEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;
import org.jweb.core.query.annotation.QueryStrategy;


/**
 * @author daquan
 * Created by Administrator on 2016/7/14.
 * @version V1.0
 */
@Mapping(entityClass=DxsSchoolPartnershipEntity.class)
public class DxsSchoolPartnershipSearchForm extends SearchForm {
    /**主键*/
    @Mapping
    @QueryStrategy
    private String id;
    /**用户id(预留)*/
    @Mapping
    private String userId;
    /**学校logo*/
    @Mapping
    private String logoImg;
    /**大缩略图*/
    @Mapping
    private  String logoBigImg;
    /**学院名称*/
    @Mapping
    private String schoolName;
    /**学校简介*/
    @Mapping
    private String schoolIntroduce;
    /**校园风景*/
    @Mapping
    private String schoolScenery;
    /**视频播放地址*/
    @Mapping
    private String schoolVideoUrl;
    /**特色展示*/
    @Mapping
    private String schoolDisplay;
    /**校址*/
    @Mapping
    @QueryStrategy
    private String schoolRealAddress;
    /**网址*/
    @Mapping
    private String schoolNetAddress;
    /**联系电话*/
    @Mapping
    private String schoolPhone;
    /**创建时间*/
    @Mapping
    private String createTime;
    /**更新时间*/
    @Mapping
    private String updateTime;
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

    public String getLogoImg() {
        return logoImg;
    }

    public void setLogoImg(String logoImg) {
        this.logoImg = logoImg;
    }

    public String getLogoBigImg() {
        return logoBigImg;
    }

    public void setLogoBigImg(String logoBigImg) {
        this.logoBigImg = logoBigImg;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolIntroduce() {
        return schoolIntroduce;
    }

    public void setSchoolIntroduce(String schoolIntroduce) {
        this.schoolIntroduce = schoolIntroduce;
    }

    public String getSchoolScenery() {
        return schoolScenery;
    }

    public void setSchoolScenery(String schoolScenery) {
        this.schoolScenery = schoolScenery;
    }

    public String getSchoolVideoUrl() {
        return schoolVideoUrl;
    }

    public void setSchoolVideoUrl(String schoolVideoUrl) {
        this.schoolVideoUrl = schoolVideoUrl;
    }

    public String getSchoolDisplay() {
        return schoolDisplay;
    }

    public void setSchoolDisplay(String schoolDisplay) {
        this.schoolDisplay = schoolDisplay;
    }

    public String getSchoolRealAddress() {
        return schoolRealAddress;
    }

    public void setSchoolRealAddress(String schoolRealAddress) {
        this.schoolRealAddress = schoolRealAddress;
    }

    public String getSchoolNetAddress() {
        return schoolNetAddress;
    }

    public void setSchoolNetAddress(String schoolNetAddress) {
        this.schoolNetAddress = schoolNetAddress;
    }

    public String getSchoolPhone() {
        return schoolPhone;
    }

    public void setSchoolPhone(String schoolPhone) {
        this.schoolPhone = schoolPhone;
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
