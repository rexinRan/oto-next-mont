package com.buss.competition.trans.form;


import com.buss.competition.entity.CompetitionEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

import java.util.Date;

/**

 * @author lu
 * @date 2016-06-02 16:56:51
 * @version V1.0
 *
 */
@Mapping(entityClass=CompetitionEntity.class)
public class CompetitionForm extends SearchForm {

    /**主键*/
    @Mapping
    private String id;
    /**用户id*/
    @Mapping
    private String userId;
    /**缩略图id*/
    @Mapping
    private String competitionImgId;
    /**缩略图URL*/
    @Mapping
    private String competitionImgUrl;
    /**大赛名称*/
    @Mapping
    private String competitionTitle;
    /**主办方*/
    @Mapping
    private String competitionOrganisers;
    /**大赛简介*/
    @Mapping
    private String competitionIntroduce;
    /**大赛开始时间*/
    @Mapping
    private String competitionStartTime;
    /**大赛结束时间*/
    @Mapping
    private String competitionEndTime;
    /**赛区范围*/
    @Mapping
    private String competitionAreas;
    /**大赛主旨*/
    @Mapping
    private String competitionTopic;
    /**参赛对象*/
    @Mapping
    private String competitionObject;
    /**大赛规则*/
    @Mapping
    private String competitionRule;
    /**创建时间*/
    @Mapping
    private String createTime;
    /**更新时间*/
    @Mapping
    private String updateTime;
    /**删除标志*/
    @Mapping
    private String  isDelete;

    public CompetitionForm() {
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

    public String getCompetitionTitle() {
        return competitionTitle;
    }

    public void setCompetitionTitle(String competitionTitle) {
        this.competitionTitle = competitionTitle;
    }

    public String getCompetitionOrganisers() {
        return competitionOrganisers;
    }

    public void setCompetitionOrganisers(String competitionOrganisers) {
        this.competitionOrganisers = competitionOrganisers;
    }

    public String getCompetitionIntroduce() {
        return competitionIntroduce;
    }

    public void setCompetitionIntroduce(String competitionIntroduce) {
        this.competitionIntroduce = competitionIntroduce;
    }

    public String getCompetitionStartTime() {
        return competitionStartTime;
    }

    public void setCompetitionStartTime(String competitionStartTime) {
        this.competitionStartTime = competitionStartTime;
    }

    public String getCompetitionEndTime() {
        return competitionEndTime;
    }

    public void setCompetitionEndTime(String competitionEndTime) {
        this.competitionEndTime = competitionEndTime;
    }

    public String getCompetitionAreas() {
        return competitionAreas;
    }

    public void setCompetitionAreas(String competitionAreas) {
        this.competitionAreas = competitionAreas;
    }

    public String getCompetitionTopic() {
        return competitionTopic;
    }

    public void setCompetitionTopic(String competitionTopic) {
        this.competitionTopic = competitionTopic;
    }

    public String getCompetitionObject() {
        return competitionObject;
    }

    public void setCompetitionObject(String competitionObject) {
        this.competitionObject = competitionObject;
    }

    public String getCompetitionRule() {
        return competitionRule;
    }

    public void setCompetitionRule(String competitionRule) {
        this.competitionRule = competitionRule;
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

    public String  getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public String getCompetitionImgId() {
        return competitionImgId;
    }

    public void setCompetitionImgId(String competitionImgId) {
        this.competitionImgId = competitionImgId;
    }

    public String getCompetitionImgUrl() {
        return competitionImgUrl;
    }

    public void setCompetitionImgUrl(String competitionImgUrl) {
        this.competitionImgUrl = competitionImgUrl;
    }
}
