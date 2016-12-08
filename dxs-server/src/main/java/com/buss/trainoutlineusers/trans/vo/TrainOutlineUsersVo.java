package com.buss.trainoutlineusers.trans.vo;

import com.buss.trainoutlineusers.entity.TrainOutlineUsersEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by HongXinGuoJi-yzg on 2016/9/9.
 */
@Mapping(entityClass = TrainOutlineUsersEntity.class)
public class TrainOutlineUsersVo extends BaseVO{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**姓名*/
    @Mapping
    private java.lang.String name;
    /**头像*/
    @Mapping
    private java.lang.String headImgUrl;
    /**就职公司*/
    @Mapping
    private java.lang.String company;
    /**工作*/
    @Mapping
    private java.lang.String job;
    /**薪资*/
    @Mapping
    private java.lang.String salary;
    /**备注(预留)*/
    @Mapping
    private java.lang.String resume;
    /**createTime*/
    @Mapping
    private java.lang.String createTime;
    /**updateTime*/
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
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
