package com.buss.project.projects.trans.vo;

import com.buss.project.projects.entity.ProjectEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

import java.util.List;


/**
 * @author lu
 * @date 2016-07-25 13:38:23
 * @version V1.0
 *
 */
@Mapping(entityClass=ProjectEntity.class)
public class ProjectVO extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**用户的id*/
    @Mapping
    private String userId;
    /**竞赛ID*/
    @Mapping
    private String bcId;
    /**项目标识*/
    @Mapping
    private String projectImg;
    /**项目名称*/
    @Mapping
    private String projectName;
    /**项目所在地*/
    @Mapping
    private String projectAddress;
    /**所属行业*/
    @Mapping
    private String projectIndustry;
    /**所属类别*/
    @Mapping
    private String projectType;
    /**是否与高校科技结合*/
    @Mapping
    private String isSchoolTechnology;
    /**股权结构*/
    @Mapping
    private String isStock;
    /**团队名称*/
    @Mapping
    private String teamName;
    /**项目介绍*/
    @Mapping
    private String projectIntroduce;
    /**项目进展*/
    @Mapping
    private String projectProgress;
    /**项目计划书*/
    @Mapping
    private String projectPlanFileurl;
    /**成员人数*/
    @Mapping
    private Integer userNum;
    /**报名费*/
    @Mapping
    private String entryFee;
    /**隐私设置*/
    @Mapping
    private String isPrivacy;
    /**是否结束*/
    @Mapping
    private String isEnd;
    /**基金需求*/
    @Mapping
    private String foundNeed;
    /**基地需求*/
    @Mapping
    private String addressNeed;
    /**招聘需求*/
    @Mapping
    private String recruitNeed;
    /**参赛类型(给推荐预留)*/
    @Mapping
    private String joinType;
    /**创建时间*/
    @Mapping
    private String createTime;
    /**修改次数*/
    @Mapping
    private String updateCount;
    /**更新时间*/
    @Mapping
    private String updateTime;
    /**是否已获投资*/
    @Mapping
    private String isFound;
    /**是否已获基地*/
    @Mapping
    private String isAddress;
    /**晋级级别*/
    @Mapping
    private String projectClass;
    /**创建年*/
    @Mapping
    private String createYear;
    /**大学名称*/
    private String schoolName;
    /**项目负责人*/
    private String userName;
    /**是否关注*/
    private  String isCollention;
    /**备注*/
    @Mapping
    private String remarks;

    /**客户群体*/
    @Mapping
    private java.lang.String customerGroup;
    /**项目测评*/
    @Mapping
    private java.lang.String projectProspect;
    /**项目总投资*/
    @Mapping
    private java.lang.String totalProjectInvestment;
    /**外部标记*/
    @Mapping
    private String outSign;

    public String getOutSign() {
        return outSign;
    }

    public void setOutSign(String outSign) {
        this.outSign = outSign;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getCreateYear() {
        return createYear;
    }

    public void setCreateYear(String createYear) {
        this.createYear = createYear;
    }

    public String getProjectClass() {
        return projectClass;
    }

    public void setProjectClass(String projectClass) {
        this.projectClass = projectClass;
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

    public String getBcId() {
        return bcId;
    }

    public void setBcId(String bcId) {
        this.bcId = bcId;
    }

    public String getProjectImg() {
        return projectImg;
    }

    public void setProjectImg(String projectImg) {
        this.projectImg = projectImg;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectAddress() {
        return projectAddress;
    }

    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress;
    }

    public String getProjectIndustry() {
        return projectIndustry;
    }

    public void setProjectIndustry(String projectIndustry) {
        this.projectIndustry = projectIndustry;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getIsSchoolTechnology() {
        return isSchoolTechnology;
    }

    public void setIsSchoolTechnology(String isSchoolTechnology) {
        this.isSchoolTechnology = isSchoolTechnology;
    }

    public String getIsStock() {
        return isStock;
    }

    public void setIsStock(String isStock) {
        this.isStock = isStock;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getProjectIntroduce() {
        return projectIntroduce;
    }

    public void setProjectIntroduce(String projectIntroduce) {
        this.projectIntroduce = projectIntroduce;
    }

    public String getProjectProgress() {
        return projectProgress;
    }

    public void setProjectProgress(String projectProgress) {
        this.projectProgress = projectProgress;
    }

    public String getProjectPlanFileurl() {
        return projectPlanFileurl;
    }

    public void setProjectPlanFileurl(String projectPlanFileurl) {
        this.projectPlanFileurl = projectPlanFileurl;
    }

    public Integer getUserNum() {
        return userNum;
    }

    public void setUserNum(Integer userNum) {
        this.userNum = userNum;
    }

    public String getIsPrivacy() {
        return isPrivacy;
    }

    public void setIsPrivacy(String isPrivacy) {
        this.isPrivacy = isPrivacy;
    }

    public String getIsEnd() {
        return isEnd;
    }

    public void setIsEnd(String isEnd) {
        this.isEnd = isEnd;
    }

    public String getFoundNeed() {
        return foundNeed;
    }

    public void setFoundNeed(String foundNeed) {
        this.foundNeed = foundNeed;
    }

    public String getAddressNeed() {
        return addressNeed;
    }

    public void setAddressNeed(String addressNeed) {
        this.addressNeed = addressNeed;
    }

    public String getRecruitNeed() {
        return recruitNeed;
    }

    public void setRecruitNeed(String recruitNeed) {
        this.recruitNeed = recruitNeed;
    }

    public String getJoinType() {
        return joinType;
    }

    public void setJoinType(String joinType) {
        this.joinType = joinType;
    }

    public String getUpdateCount() {
        return updateCount;
    }

    public void setUpdateCount(String updateCount) {
        this.updateCount = updateCount;
    }



    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getIsCollention() {
        return isCollention;
    }

    public void setIsCollention(String isCollention) {
        this.isCollention = isCollention;
    }

    public String getIsFound() {
        return isFound;
    }

    public void setIsFound(String isFound) {
        this.isFound = isFound;
    }

    public String getIsAddress() {
        return isAddress;
    }

    public void setIsAddress(String isAddress) {
        this.isAddress = isAddress;
    }

    public String getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(String entryFee) {
        this.entryFee = entryFee;
    }

    public String getCustomerGroup() {
        return customerGroup;
    }

    public void setCustomerGroup(String customerGroup) {
        this.customerGroup = customerGroup;
    }

    public String getProjectProspect() {
        return projectProspect;
    }

    public void setProjectProspect(String projectProspect) {
        this.projectProspect = projectProspect;
    }

    public String getTotalProjectInvestment() {
        return totalProjectInvestment;
    }

    public void setTotalProjectInvestment(String totalProjectInvestment) {
        this.totalProjectInvestment = totalProjectInvestment;
    }
}
