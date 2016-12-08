package com.buss.project.founds.trans.form;

import com.buss.project.founds.entity.FoundEntity;
import com.buss.project.projects.entity.ProjectEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;
import org.jweb.core.query.annotation.QueryStrategy;


/**
 * @author lu
 * @date 2016-07-25 13:38:23
 * @version V1.0
 *
 */
@Mapping(entityClass=FoundEntity.class)
public class FoundSearchForm extends SearchForm {
    /**主键*/
    @Mapping
    private String id;
    /**用户id*/
    @Mapping
    private String userId;
    /**基金名称*/
    @Mapping
    private String foundTitle;
    /**log文件*/
    @Mapping
    private String foundImgFid;
    /**log图片*/
    @Mapping
    private String foundImgUrl;
    /**创始人*/
    @Mapping
    private String foundUserName;
    /**关注领域*/
    @Mapping
    @QueryStrategy
    private String foundIndustry;
    /**投资阶段*/
    @Mapping
    private String foundStage;
    /**基金金额*/
    @Mapping
    private String foundNum;
    /**基金简介*/
    @Mapping
    private String foundSummary;
    /**基金介绍*/
    @Mapping
    private String foundIntroduce;
    /**办公地点*/
    @Mapping
    @QueryStrategy
    private String foundAddress;
    /**成功案例*/
    @Mapping
    private String foundException;
    /**创建时间*/
    @Mapping
    private String createTime;
    /**修改时间*/
    @Mapping
    private String updateTime;
    /**删除标志*/
    @Mapping
    private String isDelete;

    public String getFoundSummary() {
        return foundSummary;
    }

    public void setFoundSummary(String foundSummary) {
        this.foundSummary = foundSummary;
    }

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

    public String getFoundTitle() {
        return foundTitle;
    }

    public void setFoundTitle(String foundTitle) {
        this.foundTitle = foundTitle;
    }

    public String getFoundImgFid() {
        return foundImgFid;
    }

    public void setFoundImgFid(String foundImgFid) {
        this.foundImgFid = foundImgFid;
    }

    public String getFoundUserName() {
        return foundUserName;
    }

    public void setFoundUserName(String foundUserName) {
        this.foundUserName = foundUserName;
    }

    public String getFoundIndustry() {
        return foundIndustry;
    }

    public void setFoundIndustry(String foundIndustry) {
        this.foundIndustry = foundIndustry;
    }

    public String getFoundStage() {
        return foundStage;
    }

    public void setFoundStage(String foundStage) {
        this.foundStage = foundStage;
    }

    public String getFoundNum() {
        return foundNum;
    }

    public void setFoundNum(String foundNum) {
        this.foundNum = foundNum;
    }

    public String getFoundIntroduce() {
        return foundIntroduce;
    }

    public void setFoundIntroduce(String foundIntroduce) {
        this.foundIntroduce = foundIntroduce;
    }

    public String getFoundAddress() {
        return foundAddress;
    }

    public void setFoundAddress(String foundAddress) {
        this.foundAddress = foundAddress;
    }

    public String getFoundException() {
        return foundException;
    }

    public void setFoundException(String foundException) {
        this.foundException = foundException;
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

    public String getFoundImgUrl() {
        return foundImgUrl;
    }

    public void setFoundImgUrl(String foundImgUrl) {
        this.foundImgUrl = foundImgUrl;
    }
}