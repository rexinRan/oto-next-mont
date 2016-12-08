package com.buss.specialrecruitjob.trans.from;

import com.buss.specialrecruitjob.entity.SpecialRecruitJobEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/7/25.
 */
@Mapping(entityClass = SpecialRecruitJobEntity.class)
public class SpecialRecruitJobFrom extends SearchForm {
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**所属专场*/
    @Mapping
    private  java.lang.String srId;
    /**岗位名称*/
    @Mapping
    private java.lang.String srJobName;
    /**人数*/
    @Mapping
    private java.lang.String srJobNum;
    /**工资待遇*/
    @Mapping
    private java.lang.String srJobSalary;
    /**工作地点*/
    @Mapping
    private java.lang.String srJobAddress;
    /**招聘单位id*/
    @Mapping
    private java.lang.String srJobUnitId;
    /**招聘单位*/
    @Mapping
    private java.lang.String srJobUnit;
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

    public String getSrId() {
        return srId;
    }

    public void setSrId(String srId) {
        this.srId = srId;
    }

    public String getSrJobName() {
        return srJobName;
    }

    public void setSrJobName(String srJobName) {
        this.srJobName = srJobName;
    }

    public String getSrJobNum() {
        return srJobNum;
    }

    public void setSrJobNum(String srJobNum) {
        this.srJobNum = srJobNum;
    }

    public String getSrJobSalary() {
        return srJobSalary;
    }

    public void setSrJobSalary(String srJobSalary) {
        this.srJobSalary = srJobSalary;
    }

    public String getSrJobAddress() {
        return srJobAddress;
    }

    public void setSrJobAddress(String srJobAddress) {
        this.srJobAddress = srJobAddress;
    }

    public String getSrJobUnitId() {
        return srJobUnitId;
    }

    public void setSrJobUnitId(String srJobUnitId) {
        this.srJobUnitId = srJobUnitId;
    }

    public String getSrJobUnit() {
        return srJobUnit;
    }

    public void setSrJobUnit(String srJobUnit) {
        this.srJobUnit = srJobUnit;
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
