package com.buss.employedonlinespecial.trans.vo;

import com.buss.employedonlinespecial.entity.EmployedOnlineSpecialEntity;
import com.buss.employmentrecord.entity.EmploymentRecordEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/6/22.
 */
@Mapping(entityClass = EmployedOnlineSpecialEntity.class)
public class EmployedOnlineSpecialVO extends BaseVO {

    /**主键*/
    @Mapping
    private String id;
    /**视频播放地址*/
    @Mapping
    private String videoUrl;
    /**小缩略图*/
    @Mapping
    private String imgUrl;
    /**banner图*/
    @Mapping
    private String imgBannerUrl;
    /**通告地址(预留)*/
    @Mapping
    private String noteUrl;
    /**开始时间*/
    @Mapping
    private String startTime;
    /**结束时间*/
    @Mapping
    private String endTime;
    /**是否开放*/
    @Mapping
    private String isPublic;
    /**编号*/
    @Mapping
    private String sort;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getImgBannerUrl() {
        return imgBannerUrl;
    }

    public void setImgBannerUrl(String imgBannerUrl) {
        this.imgBannerUrl = imgBannerUrl;
    }

    public String getNoteUrl() {
        return noteUrl;
    }

    public void setNoteUrl(String noteUrl) {
        this.noteUrl = noteUrl;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(String isPublic) {
        this.isPublic = isPublic;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
