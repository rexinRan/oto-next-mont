package com.buss.entrepreneurshiparticle.trans.form;

import com.buss.entrepreneurshiparticle.entity.EntrepreneurshipArticleEntity;
import com.buss.entrepreneurshipcatalog.entity.EntrepreneurshipCatalogEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * @Title: Entity
 * @Description: dxs_entrepreneurship_catalog
 * @author lu
 * @date 2016-06-06 14:24:58
 * @version V1.0
 *
 */
@Mapping(entityClass=EntrepreneurshipArticleEntity.class)
public class EntrepreneurshipArticleSearchForm extends SearchForm{
    /**主键*/
    @Mapping
    private String id;
    /**创业中心分类id*/
    @Mapping
    private String entrepreneurshipCatelogId;
    /**缩略图*/
    @Mapping
    private String entrepreneurshipImgurl;
    /**创业中心文章标题*/
    @Mapping
    private String entrepreneurshipTitle;
    /**创业中心文章简介*/
    @Mapping
    private String entrepreneurshipIntroduction;
    /**编辑人*/
    @Mapping
    private String entrepreneurshipEditor;
    /**发布时间*/
    @Mapping
    private String entrepreneurshipPublishTime;
    /**创业中心文章内容*/
    @Mapping
    private String entrepreneurshipContents;
    /**编号*/
    @Mapping
    private String entrepreneurshipSort;
    /**创建时间*/
    @Mapping
    private String createTime;
    /**修改时间*/
    @Mapping
    private String updateTime;
    /**删除标志*/
    @Mapping
    private String isDelete;

    public EntrepreneurshipArticleSearchForm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEntrepreneurshipCatelogId() {
        return entrepreneurshipCatelogId;
    }

    public void setEntrepreneurshipCatelogId(String entrepreneurshipCatelogId) {
        this.entrepreneurshipCatelogId = entrepreneurshipCatelogId;
    }

    public String getEntrepreneurshipImgurl() {
        return entrepreneurshipImgurl;
    }

    public void setEntrepreneurshipImgurl(String entrepreneurshipImgurl) {
        this.entrepreneurshipImgurl = entrepreneurshipImgurl;
    }

    public String getEntrepreneurshipTitle() {
        return entrepreneurshipTitle;
    }

    public void setEntrepreneurshipTitle(String entrepreneurshipTitle) {
        this.entrepreneurshipTitle = entrepreneurshipTitle;
    }

    public String getEntrepreneurshipEditor() {
        return entrepreneurshipEditor;
    }

    public void setEntrepreneurshipEditor(String entrepreneurshipEditor) {
        this.entrepreneurshipEditor = entrepreneurshipEditor;
    }

    public String getEntrepreneurshipPublishTime() {
        return entrepreneurshipPublishTime;
    }

    public void setEntrepreneurshipPublishTime(String entrepreneurshipPublishTime) {
        this.entrepreneurshipPublishTime = entrepreneurshipPublishTime;
    }

    public String getEntrepreneurshipContents() {
        return entrepreneurshipContents;
    }

    public void setEntrepreneurshipContents(String entrepreneurshipContents) {
        this.entrepreneurshipContents = entrepreneurshipContents;
    }

    public String getEntrepreneurshipSort() {
        return entrepreneurshipSort;
    }

    public void setEntrepreneurshipSort(String entrepreneurshipSort) {
        this.entrepreneurshipSort = entrepreneurshipSort;
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

    public String getEntrepreneurshipIntroduction() {
        return entrepreneurshipIntroduction;
    }

    public void setEntrepreneurshipIntroduction(String entrepreneurshipIntroduction) {
        this.entrepreneurshipIntroduction = entrepreneurshipIntroduction;
    }
}
