package com.buss.employedmeeting.trans.form;

import com.buss.employedmeeting.entity.EmployedMeetingEntity;
import com.buss.entrepreneurshiparticle.entity.EntrepreneurshipArticleEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * @author lu
 * @date 2016-06-12 11:37:12
 * @version V1.0
 *
 */
@Mapping(entityClass=EmployedMeetingEntity.class)
public class EmployedMeetingSearchForm extends SearchForm{
    /**主键*/
    @Mapping
    private String id;
    /**招聘分类主键*/
    @Mapping
    private String emoloyedCatelogId;
    /**招聘会主题*/
    @Mapping
    private String meetingTitle;
    /**招聘会配图*/
    @Mapping
    private String meetingImgurl;
    /**招聘会描述*/
    @Mapping
    private String meetingContents;
    /**编号*/
    @Mapping
    private String meetingSort;
    /**创建时间*/
    @Mapping
    private String createTime;
    /**更新时间*/
    @Mapping
    private String updateTime;
    /**删除标志*/
    @Mapping
    private String isDelete;

    public EmployedMeetingSearchForm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmoloyedCatelogId() {
        return emoloyedCatelogId;
    }

    public void setEmoloyedCatelogId(String emoloyedCatelogId) {
        this.emoloyedCatelogId = emoloyedCatelogId;
    }

    public String getMeetingTitle() {
        return meetingTitle;
    }

    public void setMeetingTitle(String meetingTitle) {
        this.meetingTitle = meetingTitle;
    }

    public String getMeetingImgurl() {
        return meetingImgurl;
    }

    public void setMeetingImgurl(String meetingImgurl) {
        this.meetingImgurl = meetingImgurl;
    }

    public String getMeetingContents() {
        return meetingContents;
    }

    public void setMeetingContents(String meetingContents) {
        this.meetingContents = meetingContents;
    }

    public String getMeetingSort() {
        return meetingSort;
    }

    public void setMeetingSort(String meetingSort) {
        this.meetingSort = meetingSort;
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
