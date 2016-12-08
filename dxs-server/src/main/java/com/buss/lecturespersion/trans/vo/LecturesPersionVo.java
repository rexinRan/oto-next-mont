package com.buss.lecturespersion.trans.vo;

import com.buss.lecturespersion.entity.LecturesPersionEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by HongXinGuoJi-yzg on 2016/8/22.
 */
@Mapping(entityClass = LecturesPersionEntity.class)
public class LecturesPersionVo extends BaseVO{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**用户id(预留)*/
    @Mapping
    private java.lang.String userId;
    /**学历*/
    @Mapping
    private java.lang.String educational;
    /**姓名*/
    @Mapping
    private java.lang.String prosonName;
    /**缩略图*/
    @Mapping
    private java.lang.String imgUrl;
    /**职位*/
    @Mapping
    private java.lang.String prosonJob;
    /**地点*/
    @Mapping
    private java.lang.String prosonAddress;
    /**毕业院校*/
    @Mapping
    private java.lang.String prosonEdu;
    /**社会最高职位*/
    @Mapping
    private java.lang.String prosonTopJob;
    /**现任职单位*/
    @Mapping
    private java.lang.String prosonNowJob;
    /**企业经营项目*/
    @Mapping
    private java.lang.String prosonNowProject;
    /**社会职务简绍*/
    @Mapping
    private java.lang.String postJane;
    /**个人履历*/
    @Mapping
    private java.lang.String prosonResumeDisplay;
    /**企业家风采视频*/
    @Mapping
    private java.lang.String prosonStyleVideo;
    /**企业家风采描述*/
    @Mapping
    private java.lang.String prosonStyle;
    /**个人成就展*/
    @Mapping
    private java.lang.String prosonAccomplishment;
    /**类别*/
    @Mapping
    private java.lang.String type;
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

    public String getEducational() {
        return educational;
    }

    public void setEducational(String educational) {
        this.educational = educational;
    }

    public String getProsonName() {
        return prosonName;
    }

    public void setProsonName(String prosonName) {
        this.prosonName = prosonName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getProsonJob() {
        return prosonJob;
    }

    public void setProsonJob(String prosonJob) {
        this.prosonJob = prosonJob;
    }

    public String getProsonAddress() {
        return prosonAddress;
    }

    public String getPostJane() {
        return postJane;
    }

    public void setPostJane(String postJane) {
        this.postJane = postJane;
    }

    public void setProsonAddress(String prosonAddress) {
        this.prosonAddress = prosonAddress;
    }

    public String getProsonEdu() {
        return prosonEdu;
    }

    public void setProsonEdu(String prosonEdu) {
        this.prosonEdu = prosonEdu;
    }

    public String getProsonTopJob() {
        return prosonTopJob;
    }

    public void setProsonTopJob(String prosonTopJob) {
        this.prosonTopJob = prosonTopJob;
    }

    public String getProsonNowJob() {
        return prosonNowJob;
    }

    public void setProsonNowJob(String prosonNowJob) {
        this.prosonNowJob = prosonNowJob;
    }

    public String getProsonNowProject() {
        return prosonNowProject;
    }

    public void setProsonNowProject(String prosonNowProject) {
        this.prosonNowProject = prosonNowProject;
    }

    public String getProsonResumeDisplay() {
        return prosonResumeDisplay;
    }

    public void setProsonResumeDisplay(String prosonResumeDisplay) {
        this.prosonResumeDisplay = prosonResumeDisplay;
    }

    public String getProsonStyleVideo() {
        return prosonStyleVideo;
    }

    public void setProsonStyleVideo(String prosonStyleVideo) {
        this.prosonStyleVideo = prosonStyleVideo;
    }

    public String getProsonStyle() {
        return prosonStyle;
    }

    public void setProsonStyle(String prosonStyle) {
        this.prosonStyle = prosonStyle;
    }

    public String getProsonAccomplishment() {
        return prosonAccomplishment;
    }

    public void setProsonAccomplishment(String prosonAccomplishment) {
        this.prosonAccomplishment = prosonAccomplishment;
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
