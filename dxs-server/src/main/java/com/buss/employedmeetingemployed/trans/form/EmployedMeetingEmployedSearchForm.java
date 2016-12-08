package com.buss.employedmeetingemployed.trans.form;

import com.buss.employedmeetingemployed.entity.EmployedMeetingEmployedEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * @author lu
 * @date 2016-06-12 11:37:12
 * @version V1.0
 *
 */
@Mapping(entityClass=EmployedMeetingEmployedEntity.class)
public class EmployedMeetingEmployedSearchForm extends SearchForm{
    /**主键*/
    @Mapping
    private String id;
    /**招聘会主键*/
    @Mapping
    private String employedMeetingId;
    /**职位名称*/
    @Mapping
    private String employedName;
    /**招聘人数*/
    @Mapping
    private String employedNumber;
    /**招聘公司*/
    @Mapping
    private String employedCompany;
    /**地点*/
    @Mapping
    private String employedPosition;
    /**编号*/
    @Mapping
    private String employedSort;
    /**创建时间*/
    @Mapping
    private String createTime;
    /**更新时间*/
    @Mapping
    private String updateTime;
    /**删除标志*/
    @Mapping
    private String isDelete;

    public EmployedMeetingEmployedSearchForm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployedMeetingId() {
        return employedMeetingId;
    }

    public void setEmployedMeetingId(String employedMeetingId) {
        this.employedMeetingId = employedMeetingId;
    }

    public String getEmployedName() {
        return employedName;
    }

    public void setEmployedName(String employedName) {
        this.employedName = employedName;
    }

    public String getEmployedNumber() {
        return employedNumber;
    }

    public void setEmployedNumber(String employedNumber) {
        this.employedNumber = employedNumber;
    }

    public String getEmployedCompany() {
        return employedCompany;
    }

    public void setEmployedCompany(String employedCompany) {
        this.employedCompany = employedCompany;
    }

    public String getEmployedPosition() {
        return employedPosition;
    }

    public void setEmployedPosition(String employedPosition) {
        this.employedPosition = employedPosition;
    }

    public String getEmployedSort() {
        return employedSort;
    }

    public void setEmployedSort(String employedSort) {
        this.employedSort = employedSort;
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
