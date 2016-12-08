package com.buss.activesnotes.trans.vo;

import com.buss.activesnotes.entity.ActivesNotesEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/7/29.
 */
@Mapping(entityClass = ActivesNotesEntity.class)
public class ActivesNotesVo extends BaseVO {

    /**主键*/
    @Mapping
    private java.lang.String id;
    /**用户id*/
    @Mapping
    private java.lang.String userId;
    /**缩略图URL*/
    @Mapping
    private java.lang.String imgUrl;
    /**视频URL*/
    @Mapping
    private java.lang.String videoUrl;
    /**标题*/
    @Mapping
    private java.lang.String title;
    /**作者*/
    @Mapping
    private java.lang.String editor;
    /**发表时间*/
    @Mapping
    private java.lang.String publishTime;
    /**摘要*/
    @Mapping
    private java.lang.String summary;
    /**内容*/
    @Mapping
    private java.lang.String contents;
    /**发表年份*/
    @Mapping
    private java.lang.String publishYear;
    /**国别*/
    @Mapping
    private java.lang.String countrys;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public String getPublishYear() {
        return publishYear;
    }

    public void setPublishYear(String publishYear) {
        this.publishYear = publishYear;
    }

    public String getCountrys() {
        return countrys;
    }

    public void setCountrys(String countrys) {
        this.countrys = countrys;
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
