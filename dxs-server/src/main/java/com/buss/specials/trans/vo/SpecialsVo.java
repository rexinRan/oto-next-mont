package com.buss.specials.trans.vo;

import com.buss.specials.entity.SpecialsEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/8/5.
 */
@Mapping(entityClass = SpecialsEntity.class)
public class SpecialsVo extends BaseVO{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**介绍*/
    @Mapping
    private java.lang.String introduce;
    /**视频地址*/
    @Mapping
    private java.lang.String videoUrl;
    /**缩略图*/
    @Mapping
    private java.lang.String imgUrl;
    /**志愿者招募对象和条件*/
    @Mapping
    private java.lang.String volunteerObj;
    /**招募方式*/
    @Mapping
    private java.lang.String volunteerJoinType;
    /**服务期限*/
    @Mapping
    private java.lang.String volunteerService;
    /**业务指导与监测评估*/
    @Mapping
    private java.lang.String volunteerAssessment;
    /**工作时间及工作量*/
    @Mapping
    private java.lang.String volunteerWorks;
    /**文化活动安排*/
    @Mapping
    private java.lang.String volunteerActive;
    /**志愿者培训*/
    @Mapping
    private java.lang.String volunteerTeach;
    /**工作点的设置与管理*/
    @Mapping
    private java.lang.String volunteerManager;
    /**创建时间*/
    @Mapping
    private java.lang.String createTime;
    /**更新时间*/
    @Mapping
    private java.lang.String updateTime;
    /**删除标志*/
    @Mapping
    private java.lang.String isDelete;
    /**所属分类*/
    @Mapping
    private java.lang.String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getVolunteerObj() {
        return volunteerObj;
    }

    public void setVolunteerObj(String volunteerObj) {
        this.volunteerObj = volunteerObj;
    }

    public String getVolunteerJoinType() {
        return volunteerJoinType;
    }

    public void setVolunteerJoinType(String volunteerJoinType) {
        this.volunteerJoinType = volunteerJoinType;
    }

    public String getVolunteerService() {
        return volunteerService;
    }

    public void setVolunteerService(String volunteerService) {
        this.volunteerService = volunteerService;
    }

    public String getVolunteerAssessment() {
        return volunteerAssessment;
    }

    public void setVolunteerAssessment(String volunteerAssessment) {
        this.volunteerAssessment = volunteerAssessment;
    }

    public String getVolunteerWorks() {
        return volunteerWorks;
    }

    public void setVolunteerWorks(String volunteerWorks) {
        this.volunteerWorks = volunteerWorks;
    }

    public String getVolunteerActive() {
        return volunteerActive;
    }

    public void setVolunteerActive(String volunteerActive) {
        this.volunteerActive = volunteerActive;
    }

    public String getVolunteerTeach() {
        return volunteerTeach;
    }

    public void setVolunteerTeach(String volunteerTeach) {
        this.volunteerTeach = volunteerTeach;
    }

    public String getVolunteerManager() {
        return volunteerManager;
    }

    public void setVolunteerManager(String volunteerManager) {
        this.volunteerManager = volunteerManager;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
