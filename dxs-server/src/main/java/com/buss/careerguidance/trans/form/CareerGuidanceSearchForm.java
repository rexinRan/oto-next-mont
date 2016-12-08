package com.buss.careerguidance.trans.form;

import com.buss.careerguidance.entity.CareerGuidanceEntity;
import com.buss.usercompancy.entity.UserCompancyEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;
import org.jweb.core.query.annotation.QueryStrategy;


/**
 * @author lu
 * @date 2016-06-15 11:24:55
 * @version V1.0
 *
 */
@Mapping(entityClass=CareerGuidanceEntity.class)
public class CareerGuidanceSearchForm extends SearchForm {
    /**主键*/
    @Mapping
    private String id;
    /**职场引导分类id*/
    @Mapping
    private String cgCatelogId;
    /**职场引导分类名称*/
    @Mapping("catalogEntity.cgCatelogName")
    private String cgCatelogName;
    /**职场引导分类名称*/
    @Mapping("catalogEntity.pid")
    private String pid;
    /**职场引导标题*/
    @Mapping
    private String cgTitle;
    /**编辑人*/
    @Mapping
    private String cgEditor;
    /**发布时间*/
    @Mapping
    private String cgPublishTime;
    /**职场引导简介*/
    @Mapping
    private String cgIntroduction;
    /**职场引导内容*/
    @Mapping
    private String cgContents;
    /**编号*/
    @Mapping
    private Integer cgSort;
    /**职场引导视频*/
    @Mapping
    private String cgVideoUrl;
    /**职场引导缩略图*/
    @Mapping
    private String cgImgUrl;
    /**职场引导发布年份*/
    @Mapping
    private String cgPublishYear;
    /**职场引导发布月份*/
    @Mapping
    private String cgPublicMonth;
    /**是否特别关注*/
    @Mapping
    private Integer isSpecial;
    /**职场引导来源*/
    @Mapping
    private String cgFrom;
    /**外部标记*/
    @Mapping
    private String outSign;
    /**createTime*/
    @Mapping
    private String createTime;
    /**updateTime*/
    @Mapping
    private String updateTime;
    /**删除标志*/
    @Mapping
    private String isDelete;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCgCatelogId() {
        return cgCatelogId;
    }

    public void setCgCatelogId(String cgCatelogId) {
        this.cgCatelogId = cgCatelogId;
    }

    public String getCgCatelogName() {
        return cgCatelogName;
    }

    public void setCgCatelogName(String cgCatelogName) {
        this.cgCatelogName = cgCatelogName;
    }

    public String getCgTitle() {
        return cgTitle;
    }

    public void setCgTitle(String cgTitle) {
        this.cgTitle = cgTitle;
    }

    public String getCgEditor() {
        return cgEditor;
    }

    public void setCgEditor(String cgEditor) {
        this.cgEditor = cgEditor;
    }

    public String getCgPublishTime() {
        return cgPublishTime;
    }

    public void setCgPublishTime(String cgPublishTime) {
        this.cgPublishTime = cgPublishTime;
    }

    public String getCgIntroduction() {
        return cgIntroduction;
    }

    public void setCgIntroduction(String cgIntroduction) {
        this.cgIntroduction = cgIntroduction;
    }

    public String getCgContents() {
        return cgContents;
    }

    public void setCgContents(String cgContents) {
        this.cgContents = cgContents;
    }

    public Integer getCgSort() {
        return cgSort;
    }

    public void setCgSort(Integer cgSort) {
        this.cgSort = cgSort;
    }

    public String getCgVideoUrl() {
        return cgVideoUrl;
    }

    public void setCgVideoUrl(String cgVideoUrl) {
        this.cgVideoUrl = cgVideoUrl;
    }

    public String getCgImgUrl() {
        return cgImgUrl;
    }

    public void setCgImgUrl(String cgImgUrl) {
        this.cgImgUrl = cgImgUrl;
    }

    public String getCgPublishYear() {
        return cgPublishYear;
    }

    public void setCgPublishYear(String cgPublishYear) {
        this.cgPublishYear = cgPublishYear;
    }

    public String getCgPublicMonth() {
        return cgPublicMonth;
    }

    public void setCgPublicMonth(String cgPublicMonth) {
        this.cgPublicMonth = cgPublicMonth;
    }

    public Integer getIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(Integer isSpecial) {
        this.isSpecial = isSpecial;
    }

    public String getCgFrom() {
        return cgFrom;
    }

    public void setCgFrom(String cgFrom) {
        this.cgFrom = cgFrom;
    }

    public String getOutSign() {
        return outSign;
    }

    public void setOutSign(String outSign) {
        this.outSign = outSign;
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
