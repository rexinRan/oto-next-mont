package com.buss.employedarticle.trans.form;

import com.buss.employedarticle.entity.EmployedArticleEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**

 * @author lu
 * @date 2016-06-02 16:56:51
 * @version V1.0
 *
 */
@Mapping(entityClass= EmployedArticleEntity.class)
public class EmployedArticleSearchForm extends SearchForm {

    /**主键*/
    @Mapping
    private String id;
    /**就业中心分类id*/
    @Mapping
    private String emoloyedCatelogId;

    /**就业中心文章标题*/
    @Mapping
    private String emoloyedTitle;
    /**编辑人*/
    @Mapping
    private String emoloyedEditor;
    /**发布时间*/
    @Mapping
    private String emoloyedPublishTime;
    /**缩略图*/
    @Mapping
    private String emoloyedImgurl;
    /**视频地址*/
    @Mapping
    private String emoloyedVideoUrl;
    /**就业中心文章内容*/
    @Mapping
    private String emoloyedContents;
    /**编号*/
    @Mapping
    private Integer emoloyedSort;
    /**createTime*/
    @Mapping
    private String createTime;
    /**updateTime*/
    @Mapping
    private String updateTime;
    /**删除标志*/
    @Mapping
    private String isDelete;
    /**文章来源*/
    @Mapping
    private String emoloyedFrom;
    /**文章简介*/
    @Mapping
    private String emoloyedIntroduction;
    /**外部标记*/
    @Mapping
    private String outSign;

    public String getEmoloyedVideoUrl() {
        return emoloyedVideoUrl;
    }

    public void setEmoloyedVideoUrl(String emoloyedVideoUrl) {
        this.emoloyedVideoUrl = emoloyedVideoUrl;
    }

    public String getEmoloyedFrom() {
        return emoloyedFrom;
    }

    public void setEmoloyedFrom(String emoloyedFrom) {
        this.emoloyedFrom = emoloyedFrom;
    }

    public String getEmoloyedIntroduction() {
        return emoloyedIntroduction;
    }

    public void setEmoloyedIntroduction(String emoloyedIntroduction) {
        this.emoloyedIntroduction = emoloyedIntroduction;
    }

    public String getOutSign() {
        return outSign;
    }

    public void setOutSign(String outSign) {
        this.outSign = outSign;
    }

    public EmployedArticleSearchForm() {
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

    public String getEmoloyedTitle() {
        return emoloyedTitle;
    }

    public void setEmoloyedTitle(String emoloyedTitle) {
        this.emoloyedTitle = emoloyedTitle;
    }

    public String getEmoloyedEditor() {
        return emoloyedEditor;
    }

    public void setEmoloyedEditor(String emoloyedEditor) {
        this.emoloyedEditor = emoloyedEditor;
    }

    public String getEmoloyedPublishTime() {
        return emoloyedPublishTime;
    }

    public void setEmoloyedPublishTime(String emoloyedPublishTime) {
        this.emoloyedPublishTime = emoloyedPublishTime;
    }

    public String getEmoloyedImgurl() {
        return emoloyedImgurl;
    }

    public void setEmoloyedImgurl(String emoloyedImgurl) {
        this.emoloyedImgurl = emoloyedImgurl;
    }

    public String getEmoloyedContents() {
        return emoloyedContents;
    }

    public void setEmoloyedContents(String emoloyedContents) {
        this.emoloyedContents = emoloyedContents;
    }

    public Integer getEmoloyedSort() {
        return emoloyedSort;
    }

    public void setEmoloyedSort(Integer emoloyedSort) {
        this.emoloyedSort = emoloyedSort;
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
