package com.buss.entrepreneurshipprojectcompetition.trans.vo;

import com.buss.entrepreneurshipprojectcompetition.entity.EntrepreneurshipProjectCompetitionEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * @author lu
 * @date 2016-06-07 16:08:26
 * @version V1.0
 *
 */
@Mapping(entityClass=EntrepreneurshipProjectCompetitionEntity.class)
public class EntrepreneurshipProjectCompetitionVO extends BaseVO{
    /**主键*/
    @Mapping
    private String id;
    /**项目所属领域id*/
    @Mapping
    private String projectAreaId;
    /**项目所属类型id*/
    @Mapping
    private String projectTypeId;
    /**项目名称*/
    @Mapping
    private String projectName;
    /**项目分类*/
    @Mapping
    private String projectCatalog;
    /**项目开始时间*/
    @Mapping
    private String projectStartTime;
    /**项目结束时间*/
    @Mapping
    private String projectEndTime;
    /**项目状态*/
    @Mapping
    private Integer projectStatus;
    /**项目简介*/
    @Mapping
    private String projectProfile;
    /**审核码*/
    @Mapping
    private Integer checkCode;
    /**项目展示图片*/
    @Mapping
    private String projectImgurl;
    /**项目等级*/
    @Mapping
    private Integer projectGrade;

    public EntrepreneurshipProjectCompetitionVO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectAreaId() {
        return projectAreaId;
    }

    public void setProjectAreaId(String projectAreaId) {
        this.projectAreaId = projectAreaId;
    }

    public String getProjectTypeId() {
        return projectTypeId;
    }

    public void setProjectTypeId(String projectTypeId) {
        this.projectTypeId = projectTypeId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectCatalog() {
        return projectCatalog;
    }

    public void setProjectCatalog(String projectCatalog) {
        this.projectCatalog = projectCatalog;
    }

    public String getProjectStartTime() {
        return projectStartTime;
    }

    public void setProjectStartTime(String projectStartTime) {
        this.projectStartTime = projectStartTime;
    }

    public String getProjectEndTime() {
        return projectEndTime;
    }

    public void setProjectEndTime(String projectEndTime) {
        this.projectEndTime = projectEndTime;
    }

    public Integer getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(Integer projectStatus) {
        this.projectStatus = projectStatus;
    }

    public String getProjectProfile() {
        return projectProfile;
    }

    public void setProjectProfile(String projectProfile) {
        this.projectProfile = projectProfile;
    }

    public Integer getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(Integer checkCode) {
        this.checkCode = checkCode;
    }

    public String getProjectImgurl() {
        return projectImgurl;
    }

    public void setProjectImgurl(String projectImgurl) {
        this.projectImgurl = projectImgurl;
    }

    public Integer getProjectGrade() {
        return projectGrade;
    }

    public void setProjectGrade(Integer projectGrade) {
        this.projectGrade = projectGrade;
    }
}
