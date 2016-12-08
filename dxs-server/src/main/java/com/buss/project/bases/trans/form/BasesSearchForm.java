package com.buss.project.bases.trans.form;

import com.buss.project.bases.entity.BasesEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;
import org.jweb.core.query.annotation.QueryStrategy;


/**
 * @author lu
 * @date 2016-07-25 13:38:23
 * @version V1.0
 *
 */
@Mapping(entityClass=BasesEntity.class)
public class BasesSearchForm extends SearchForm {
    /**主键*/
    @Mapping
    private String id;
    /**基地名称*/
    @Mapping
    private String baseName;
    /**基地缩图文件*/
    @Mapping
    private String baseImgFid;
    /**基地缩图地址*/
    @Mapping
    private String baseImgUrl;
    /**视频文件id*/
    @Mapping
    private String baseVideoFid;
    /**视频播放地址*/
    @Mapping
    private String baseVideoUrl;
    /**基地简介*/
    @Mapping
    private String baseIntroduce;
    /**主管单位*/
    @Mapping
    private String baseUnitName;
    /**基地级别*/
    @Mapping
    private String baseClass;
    /**优惠政策*/
    @Mapping
    private String basePolicy;
    /**入驻指南*/
    @Mapping
    private String baseGuide;
    /**详细地址*/
    @Mapping
    @QueryStrategy
    private String baseAddress;
    /**服务行业*/
    @Mapping
    @QueryStrategy
    private String baseIndustry;
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

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getBaseImgFid() {
        return baseImgFid;
    }

    public void setBaseImgFid(String baseImgFid) {
        this.baseImgFid = baseImgFid;
    }

    public String getBaseImgUrl() {
        return baseImgUrl;
    }

    public void setBaseImgUrl(String baseImgUrl) {
        this.baseImgUrl = baseImgUrl;
    }

    public String getBaseVideoFid() {
        return baseVideoFid;
    }

    public void setBaseVideoFid(String baseVideoFid) {
        this.baseVideoFid = baseVideoFid;
    }

    public String getBaseVideoUrl() {
        return baseVideoUrl;
    }

    public void setBaseVideoUrl(String baseVideoUrl) {
        this.baseVideoUrl = baseVideoUrl;
    }

    public String getBaseIntroduce() {
        return baseIntroduce;
    }

    public void setBaseIntroduce(String baseIntroduce) {
        this.baseIntroduce = baseIntroduce;
    }

    public String getBaseUnitName() {
        return baseUnitName;
    }

    public void setBaseUnitName(String baseUnitName) {
        this.baseUnitName = baseUnitName;
    }

    public String getBaseClass() {
        return baseClass;
    }

    public void setBaseClass(String baseClass) {
        this.baseClass = baseClass;
    }

    public String getBasePolicy() {
        return basePolicy;
    }

    public void setBasePolicy(String basePolicy) {
        this.basePolicy = basePolicy;
    }

    public String getBaseGuide() {
        return baseGuide;
    }

    public void setBaseGuide(String baseGuide) {
        this.baseGuide = baseGuide;
    }

    public String getBaseAddress() {
        return baseAddress;
    }

    public void setBaseAddress(String baseAddress) {
        this.baseAddress = baseAddress;
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

    public String getBaseIndustry() {
        return baseIndustry;
    }

    public void setBaseIndustry(String baseIndustry) {
        this.baseIndustry = baseIndustry;
    }
}