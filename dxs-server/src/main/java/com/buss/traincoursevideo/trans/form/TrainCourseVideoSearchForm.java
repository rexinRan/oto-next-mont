package com.buss.traincoursevideo.trans.form;

import com.buss.traincoursevideo.entity.TrainCourseVideoEntity;
import com.buss.trainingarticle.entity.TrainingArticleEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;


/**
 * @author lu
 * @date 2016-06-08 10:10:07
 * @version V1.0
 *
 */
@Mapping(entityClass= TrainCourseVideoEntity.class)
public class TrainCourseVideoSearchForm extends SearchForm {
    /**主键*/
    @Mapping
    private String id;
    /**课程id*/
    @Mapping
    private String tocId;
    /**导师id*/
    @Mapping
    private String userId;
    /**视频名称*/
    @Mapping
    private String videoName;
    /**缩略图*/
    @Mapping
    private String imgUrl;
    /**视频地址*/
    @Mapping
    private String videoUrl;
    /**编号*/
    @Mapping
    private String sort;
    /**视频时长*/
    @Mapping
    private String videoHourses;
    /**是否免费*/
    @Mapping
    private String isFree;
    /**内部标记*/
    @Mapping
    private String inSign;
    /**外部标记*/
    @Mapping
    private String outSign;
    /**价格(预留)*/
    @Mapping
    private String price;
    /**创建时间*/
    @Mapping
    private String createTime;
    /**更新时间*/
    @Mapping
    private String updateTime;
    /**删除标志*/
    @Mapping
    private String isDelete;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTocId() {
        return tocId;
    }

    public void setTocId(String tocId) {
        this.tocId = tocId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getVideoHourses() {
        return videoHourses;
    }

    public void setVideoHourses(String videoHourses) {
        this.videoHourses = videoHourses;
    }

    public String getIsFree() {
        return isFree;
    }

    public void setIsFree(String isFree) {
        this.isFree = isFree;
    }

    public String getInSign() {
        return inSign;
    }

    public void setInSign(String inSign) {
        this.inSign = inSign;
    }

    public String getOutSign() {
        return outSign;
    }

    public void setOutSign(String outSign) {
        this.outSign = outSign;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
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