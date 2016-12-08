package com.buss.specialshiring.trans.from;

import com.buss.specialshiring.entity.SpecialsHiringEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/8/5.
 */
@Mapping(entityClass = SpecialsHiringEntity.class)
public class SpecialsHiringFrom extends SearchForm{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**专项就业id*/
    @Mapping
    private java.lang.String specialsId;
    /**标题*/
    @Mapping
    private java.lang.String title;
    /**简介*/
    @Mapping
    private java.lang.String introduce;
    /**选聘范围*/
    @Mapping
    private java.lang.String hiringRange;
    /**选聘数量*/
    @Mapping
    private java.lang.String hiringNum;
    /**选聘专业*/
    @Mapping
    private java.lang.String hiringMajor;
    /**选聘条件*/
    @Mapping
    private java.lang.String hiringCondition;
    /**选聘地点*/
    @Mapping
    private java.lang.String hiringPlace;
    /**网上报名时间及要求*/
    @Mapping
    private java.lang.String hiringNet;
    /**笔试时间及要求*/
    @Mapping
    private java.lang.String hiringExam;
    /**资格初审内容及标准*/
    @Mapping
    private java.lang.String hiringStandard;
    /**面试时间及相关事宜*/
    @Mapping
    private java.lang.String hiringInterview;
    /**确定拟聘用人员时间及标准*/
    @Mapping
    private java.lang.String hiringPlan;
    /**体验和心理测试*/
    @Mapping
    private java.lang.String hiringExperience;
    /**资格复审*/
    @Mapping
    private java.lang.String hiringRetest;
    /**办理报到手续及签订劳动合同*/
    @Mapping
    private java.lang.String hiringReport;
    /**岗前培训*/
    @Mapping
    private java.lang.String hiringJobTraining;
    /**持证上岗*/
    @Mapping
    private java.lang.String hiringCertiticates;
    /**联系人及联系电话*/
    @Mapping
    private java.lang.String hiringContact;
    /**附件*/
    @Mapping
    private java.lang.String hiringEnclosureFid;
    /**附件地址*/
    @Mapping
    private java.lang.String hiringEnclosureUrl;
    /**选聘项目(预留)*/
    @Mapping
    private java.lang.String hiringProject;
    /**发布单位*/
    @Mapping
    private java.lang.String publishCompany;
    /**发布时间*/
    @Mapping
    private java.lang.String publishTime;
    /**编号*/
    @Mapping
    private java.lang.String sort;
    /**创建时间*/
    @Mapping
    private java.lang.String createTime;
    /**更新时间*/
    @Mapping
    private java.lang.String updateTime;
    /**删除标志*/
    @Mapping
    private java.lang.String isDelete;
    /**志愿项目*/
    @Mapping
    private java.lang.String hiringJob;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSpecialsId() {
        return specialsId;
    }

    public void setSpecialsId(String specialsId) {
        this.specialsId = specialsId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getHiringRange() {
        return hiringRange;
    }

    public void setHiringRange(String hiringRange) {
        this.hiringRange = hiringRange;
    }

    public String getHiringNum() {
        return hiringNum;
    }

    public void setHiringNum(String hiringNum) {
        this.hiringNum = hiringNum;
    }

    public String getHiringMajor() {
        return hiringMajor;
    }

    public void setHiringMajor(String hiringMajor) {
        this.hiringMajor = hiringMajor;
    }

    public String getHiringCondition() {
        return hiringCondition;
    }

    public void setHiringCondition(String hiringCondition) {
        this.hiringCondition = hiringCondition;
    }

    public String getHiringPlace() {
        return hiringPlace;
    }

    public void setHiringPlace(String hiringPlace) {
        this.hiringPlace = hiringPlace;
    }

    public String getHiringJob() {
        return hiringJob;
    }

    public void setHiringJob(String hiringJob) {
        this.hiringJob = hiringJob;
    }

    public String getHiringNet() {
        return hiringNet;
    }

    public void setHiringNet(String hiringNet) {
        this.hiringNet = hiringNet;
    }

    public String getHiringExam() {
        return hiringExam;
    }

    public void setHiringExam(String hiringExam) {
        this.hiringExam = hiringExam;
    }

    public String getHiringStandard() {
        return hiringStandard;
    }

    public void setHiringStandard(String hiringStandard) {
        this.hiringStandard = hiringStandard;
    }

    public String getHiringInterview() {
        return hiringInterview;
    }

    public void setHiringInterview(String hiringInterview) {
        this.hiringInterview = hiringInterview;
    }

    public String getHiringPlan() {
        return hiringPlan;
    }

    public void setHiringPlan(String hiringPlan) {
        this.hiringPlan = hiringPlan;
    }

    public String getHiringExperience() {
        return hiringExperience;
    }

    public void setHiringExperience(String hiringExperience) {
        this.hiringExperience = hiringExperience;
    }

    public String getHiringRetest() {
        return hiringRetest;
    }

    public void setHiringRetest(String hiringRetest) {
        this.hiringRetest = hiringRetest;
    }

    public String getHiringReport() {
        return hiringReport;
    }

    public void setHiringReport(String hiringReport) {
        this.hiringReport = hiringReport;
    }

    public String getHiringJobTraining() {
        return hiringJobTraining;
    }

    public void setHiringJobTraining(String hiringJobTraining) {
        this.hiringJobTraining = hiringJobTraining;
    }

    public String getHiringCertiticates() {
        return hiringCertiticates;
    }

    public void setHiringCertiticates(String hiringCertiticates) {
        this.hiringCertiticates = hiringCertiticates;
    }

    public String getHiringContact() {
        return hiringContact;
    }

    public void setHiringContact(String hiringContact) {
        this.hiringContact = hiringContact;
    }

    public String getHiringEnclosureFid() {
        return hiringEnclosureFid;
    }

    public void setHiringEnclosureFid(String hiringEnclosureFid) {
        this.hiringEnclosureFid = hiringEnclosureFid;
    }

    public String getHiringEnclosureUrl() {
        return hiringEnclosureUrl;
    }

    public void setHiringEnclosureUrl(String hiringEnclosureUrl) {
        this.hiringEnclosureUrl = hiringEnclosureUrl;
    }

    public String getHiringProject() {
        return hiringProject;
    }

    public void setHiringProject(String hiringProject) {
        this.hiringProject = hiringProject;
    }

    public String getPublishCompany() {
        return publishCompany;
    }

    public void setPublishCompany(String publishCompany) {
        this.publishCompany = publishCompany;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
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
