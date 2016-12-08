package com.buss.specialrecruitjobappointment.trans.from;

import com.buss.specialrecruitjobappointment.entity.SpecialRecruitJobAppointmentEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

import java.lang.String;

/**
 * Created by Administrator on 2016/7/25.
 */
@Mapping(entityClass = SpecialRecruitJobAppointmentEntity.class)
public class SpecialRecruitJobAppointmentFrom extends SearchForm{

    /**主键*/
    @Mapping
    private java.lang.String id;
    /**专场招聘id*/
    @Mapping
    private java.lang.String srId;
    /**专岗id*/
    @Mapping
    private java.lang.String srjId;
    /**用户id*/
    @Mapping
    private java.lang.String userId;
    /**预约类型*/
    @Mapping
    private java.lang.String appointmentType;
    /**预约时间*/
    @Mapping
    private java.lang.String appointmentTime;
    /**申请类型*/
    @Mapping
    private java.lang.String type;
    /**创建时间*/
    @Mapping
    private java.lang.String createTime;
    /**更新时间*/
    @Mapping
    private java.lang.String upStringTime;
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

    public String getSrjId() {
        return srjId;
    }

    public void setSrjId(String srjId) {
        this.srjId = srjId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpStringTime() {
        return upStringTime;
    }

    public void setUpStringTime(String upStringTime) {
        this.upStringTime = upStringTime;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
}
