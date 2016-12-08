package com.buss.project.founds.trans.vo;

import com.buss.project.founds.entity.FoundEntity;
import com.buss.project.projects.entity.ProjectEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

import java.util.List;
import java.util.Map;


/**
 * @author lu
 * @date 2016-07-25 13:38:23
 * @version V1.0
 *
 */
@Mapping(entityClass=FoundEntity.class)
public class FoundVO extends BaseVO {
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
    private String foundAddress;
    /**成功案例*/
    private String foundException;
    /**成功案例集合*/
    private List ExceptionList;

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

    public String getFoundImgUrl() {
        return foundImgUrl;
    }

    public void setFoundImgUrl(String foundImgUrl) {
        this.foundImgUrl = foundImgUrl;
    }

    public List getExceptionList() {
        return ExceptionList;
    }

    public void setExceptionList(List exceptionList) {
        ExceptionList = exceptionList;
    }
}
