package com.buss.activesroadshowapply.trans.from;

import com.buss.activesroadshowapply.entity.ActivesRoadshowApplyEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by HongXinGuoJi-yzg on 2016/8/18.
 */
@Mapping(entityClass = ActivesRoadshowApplyEntity.class)
public class ActivesRoadshowApplyFrom extends SearchForm{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**申请人id*/
    @Mapping
    private java.lang.String userId;
    /**活动的ID*/
    @Mapping
    private java.lang.String activesId;
    /**企业所在地*/
    @Mapping
    private java.lang.String companyAddress;
    /**注册资金*/
    @Mapping
    private java.lang.String regFound;
    /**企业简介*/
    @Mapping
    private java.lang.String companyIntroduce;
    /**团队介绍*/
    @Mapping
    private java.lang.String companyTeamIntroduce;
    /**项目介绍*/
    @Mapping
    private java.lang.String projectIntroduce;
    /**项目名称*/
    @Mapping
    private java.lang.String projectName;
    /**项目前景*/
    @Mapping
    private java.lang.String projectProspect;
    /**行业优势*/
    @Mapping
    private java.lang.String industryAdvantage;
    /**文件地址*/
    @Mapping
    private java.lang.String fileUrl;
    /**文件id*/
    @Mapping
    private java.lang.String fileId;
    /**路演需求*/
    @Mapping
    private java.lang.String roadshowNeed;
    /**处理结果*/
    @Mapping
    private java.lang.String result;
    /**处理结果说明*/
    @Mapping
    private java.lang.String message;
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

    public String getActivesId() {
        return activesId;
    }

    public void setActivesId(String activesId) {
        this.activesId = activesId;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getRegFound() {
        return regFound;
    }

    public void setRegFound(String regFound) {
        this.regFound = regFound;
    }

    public String getCompanyIntroduce() {
        return companyIntroduce;
    }

    public void setCompanyIntroduce(String companyIntroduce) {
        this.companyIntroduce = companyIntroduce;
    }

    public String getCompanyTeamIntroduce() {
        return companyTeamIntroduce;
    }

    public void setCompanyTeamIntroduce(String companyTeamIntroduce) {
        this.companyTeamIntroduce = companyTeamIntroduce;
    }

    public String getProjectIntroduce() {
        return projectIntroduce;
    }

    public void setProjectIntroduce(String projectIntroduce) {
        this.projectIntroduce = projectIntroduce;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectProspect() {
        return projectProspect;
    }

    public void setProjectProspect(String projectProspect) {
        this.projectProspect = projectProspect;
    }

    public String getIndustryAdvantage() {
        return industryAdvantage;
    }

    public void setIndustryAdvantage(String industryAdvantage) {
        this.industryAdvantage = industryAdvantage;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getRoadshowNeed() {
        return roadshowNeed;
    }

    public void setRoadshowNeed(String roadshowNeed) {
        this.roadshowNeed = roadshowNeed;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
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
