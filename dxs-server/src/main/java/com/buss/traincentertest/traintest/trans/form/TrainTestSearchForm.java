package com.buss.traincentertest.traintest.trans.form;

import com.buss.traincentertest.traintest.entity.TrainTestEntity;
import com.buss.trainonlinecourse.entity.TrainOnlineCourseEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;


/**
 * @author lu
 * @date 2016-06-27 17:10:43
 * @version V1.0
 *
 */
@Mapping(entityClass=TrainTestEntity.class)
public class TrainTestSearchForm extends SearchForm {
    /**主键*/
    @Mapping
    private String id;
    /**题目总数*/
    @Mapping
    private String tiNum;
    /**试题分类*/
    @Mapping
    private String ttcId;
    /**试题名称*/
    @Mapping
    private String tName;
    /**缩略图*/
    @Mapping
    private String imgUrl;
    /**摘要(预留)*/
    @Mapping
    private String tSummary;
    /**介绍*/
    @Mapping
    private String tIntroduce;
    /**答题须知*/
    @Mapping
    private String requested;
    /**计分类型*/
    @Mapping
    private String scoreType;
    /**创建时间*/
    @Mapping
    private String createTime;
    /**更新时间*/
    @Mapping
    private String updateTime;
    /**删除标志*/
    @Mapping
    private String isDelete;
//    /**测试题分类*/
//    @Mapping("trainTestCatalog.catalogName")
//    private String catalogName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTiNum() {
        return tiNum;
    }

    public void setTiNum(String tiNum) {
        this.tiNum = tiNum;
    }

    public String getTtcId() {
        return ttcId;
    }

    public void setTtcId(String ttcId) {
        this.ttcId = ttcId;
    }

    public String gettName() {
        return tName;
    }

    public void settName(String tName) {
        this.tName = tName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String gettSummary() {
        return tSummary;
    }

    public void settSummary(String tSummary) {
        this.tSummary = tSummary;
    }

    public String gettIntroduce() {
        return tIntroduce;
    }

    public void settIntroduce(String tIntroduce) {
        this.tIntroduce = tIntroduce;
    }

    public String getRequested() {
        return requested;
    }

    public void setRequested(String requested) {
        this.requested = requested;
    }

    public String getScoreType() {
        return scoreType;
    }

    public void setScoreType(String scoreType) {
        this.scoreType = scoreType;
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

//    public String getCatalogName() {
//        return catalogName;
//    }
//
//    public void setCatalogName(String catalogName) {
//        this.catalogName = catalogName;
//    }
}
