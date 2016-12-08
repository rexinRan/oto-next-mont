package com.buss.lectures.trans.from;

import com.buss.lectures.entity.LecturesEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

import javax.persistence.EntityListeners;

/**
 * Created by HongXinGuoJi-yzg on 2016/8/22.
 */
@Mapping(entityClass = LecturesEntity.class)
public class LecturesFrom extends SearchForm{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**活动id*/
    @Mapping
    private java.lang.String acitveId;
    /**名家/企业家的id*/
    @Mapping
    private java.lang.String lpId;
    /**主题*/
    @Mapping
    private java.lang.String lectureTitle;
    /**学校名称*/
    @Mapping
    private java.lang.String schoolName;
    /**所在站名*/
    @Mapping
    private java.lang.String lectureAddressShort;
    /**演讲地址*/
    @Mapping
    private java.lang.String lectureAddress;
    /**演讲时间*/
    @Mapping
    private java.lang.String lectureTime;
    /**外部标记*/
    @Mapping
    private java.lang.String outSign;
    /**主题内容简介*/
    @Mapping
    private java.lang.String lectureContentSummary;
    /**图片地址*/
    @Mapping
    private java.lang.String lectureContentImgs;
    /**主题内容详解*/
    @Mapping
    private java.lang.String lectureContent;
    /**所属场次*/
    @Mapping
    private java.lang.String lgId;
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

    public String getAcitveId() {
        return acitveId;
    }

    public void setAcitveId(String acitveId) {
        this.acitveId = acitveId;
    }

    public String getLpId() {
        return lpId;
    }

    public void setLpId(String lpId) {
        this.lpId = lpId;
    }

    public String getLectureTitle() {
        return lectureTitle;
    }

    public void setLectureTitle(String lectureTitle) {
        this.lectureTitle = lectureTitle;
    }

    public String getOutSign() {
        return outSign;
    }

    public void setOutSign(String outSign) {
        this.outSign = outSign;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getLectureAddressShort() {
        return lectureAddressShort;
    }

    public void setLectureAddressShort(String lectureAddressShort) {
        this.lectureAddressShort = lectureAddressShort;
    }

    public String getLectureAddress() {
        return lectureAddress;
    }

    public void setLectureAddress(String lectureAddress) {
        this.lectureAddress = lectureAddress;
    }

    public String getLectureTime() {
        return lectureTime;
    }

    public void setLectureTime(String lectureTime) {
        this.lectureTime = lectureTime;
    }

    public String getLectureContentSummary() {
        return lectureContentSummary;
    }

    public void setLectureContentSummary(String lectureContentSummary) {
        this.lectureContentSummary = lectureContentSummary;
    }

    public String getLectureContentImgs() {
        return lectureContentImgs;
    }

    public void setLectureContentImgs(String lectureContentImgs) {
        this.lectureContentImgs = lectureContentImgs;
    }

    public String getLectureContent() {
        return lectureContent;
    }

    public void setLectureContent(String lectureContent) {
        this.lectureContent = lectureContent;
    }

    public String getLgId() {
        return lgId;
    }

    public void setLgId(String lgId) {
        this.lgId = lgId;
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
