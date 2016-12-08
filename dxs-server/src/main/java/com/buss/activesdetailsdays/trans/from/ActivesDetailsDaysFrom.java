package com.buss.activesdetailsdays.trans.from;

import com.buss.activesdetailsdays.entity.ActivesDetailsDaysEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/8/4.
 */
@Mapping(entityClass = ActivesDetailsDaysEntity.class)
public class ActivesDetailsDaysFrom extends SearchForm{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**活动id*/
    @Mapping
    private java.lang.String activeId;
    /**天数*/
    @Mapping
    private java.lang.String daysName;
    /**地名*/
    @Mapping
    private java.lang.String addressName;
    /**图片1主键*/
    @Mapping
    private java.lang.String fid1;
    /**图片1地址*/
    @Mapping
    private java.lang.String fid1ImgUrl;
    /**图片2主键*/
    @Mapping
    private java.lang.String fid2;
    /**图片2地址*/
    @Mapping
    private java.lang.String fid2ImgUrl;
    /**图片3主键*/
    @Mapping
    private java.lang.String fid3;
    /**图片3地址*/
    @Mapping
    private java.lang.String fidImgUrl;
    /**内容*/
    @Mapping
    private java.lang.String content;
    /**住宿地*/
    @Mapping
    private java.lang.String boarders;
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

    public String getActiveId() {
        return activeId;
    }

    public void setActiveId(String activeId) {
        this.activeId = activeId;
    }

    public String getDaysName() {
        return daysName;
    }

    public void setDaysName(String daysName) {
        this.daysName = daysName;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getFid1() {
        return fid1;
    }

    public void setFid1(String fid1) {
        this.fid1 = fid1;
    }

    public String getFid1ImgUrl() {
        return fid1ImgUrl;
    }

    public void setFid1ImgUrl(String fid1ImgUrl) {
        this.fid1ImgUrl = fid1ImgUrl;
    }

    public String getFid2() {
        return fid2;
    }

    public void setFid2(String fid2) {
        this.fid2 = fid2;
    }

    public String getFid2ImgUrl() {
        return fid2ImgUrl;
    }

    public void setFid2ImgUrl(String fid2ImgUrl) {
        this.fid2ImgUrl = fid2ImgUrl;
    }

    public String getFid3() {
        return fid3;
    }

    public void setFid3(String fid3) {
        this.fid3 = fid3;
    }

    public String getFidImgUrl() {
        return fidImgUrl;
    }

    public void setFidImgUrl(String fidImgUrl) {
        this.fidImgUrl = fidImgUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBoarders() {
        return boarders;
    }

    public void setBoarders(String boarders) {
        this.boarders = boarders;
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
