package com.buss.activescustom.trans.vo;

import com.buss.activescustom.entity.ActivesCustomEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/8/1.
 */
@Mapping(entityClass = ActivesCustomEntity.class)
public class ActivesCustomVo extends BaseVO{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**用户id*/
    @Mapping
    private java.lang.String userId;
    /**课程id*/
    @Mapping
    private java.lang.String customizedId;
    /**国家id*/
    @Mapping
    private java.lang.String customCountryId;
    /**选修课ID*/
    @Mapping
    private java.lang.String customCoursesId;
    /**住宿方式*/
    @Mapping
    private java.lang.String customModeId;
    /**课程时长*/
    @Mapping
    private java.lang.String customDurationId;
    /**签证方式id*/
    @Mapping
    private java.lang.String customVisaId;
    /**setouttime*/
    @Mapping
    private java.lang.String setouttime;
    /**紧急联系人*/
    @Mapping
    private java.lang.String contacts1;
    /**紧急联系电话*/
    @Mapping
    private java.lang.String phone1;
    /**紧急联系人2*/
    @Mapping
    private java.lang.String contacts2;
    /**紧急联系电话2*/
    @Mapping
    private java.lang.String phone2;
    /**是否缴费*/
    @Mapping
    private java.lang.String result;
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

    public String getCustomizedId() {
        return customizedId;
    }

    public void setCustomizedId(String customizedId) {
        this.customizedId = customizedId;
    }

    public String getCustomCountryId() {
        return customCountryId;
    }

    public void setCustomCountryId(String customCountryId) {
        this.customCountryId = customCountryId;
    }

    public String getCustomCoursesId() {
        return customCoursesId;
    }

    public void setCustomCoursesId(String customCoursesId) {
        this.customCoursesId = customCoursesId;
    }

    public String getCustomModeId() {
        return customModeId;
    }

    public void setCustomModeId(String customModeId) {
        this.customModeId = customModeId;
    }

    public String getCustomDurationId() {
        return customDurationId;
    }

    public void setCustomDurationId(String customDurationId) {
        this.customDurationId = customDurationId;
    }

    public String getCustomVisaId() {
        return customVisaId;
    }

    public void setCustomVisaId(String customVisaId) {
        this.customVisaId = customVisaId;
    }

    public String getSetouttime() {
        return setouttime;
    }

    public void setSetouttime(String setouttime) {
        this.setouttime = setouttime;
    }

    public String getContacts1() {
        return contacts1;
    }

    public void setContacts1(String contacts1) {
        this.contacts1 = contacts1;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getContacts2() {
        return contacts2;
    }

    public void setContacts2(String contacts2) {
        this.contacts2 = contacts2;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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
