package com.buss.indexarticle.trans.form;

import com.buss.indexarticle.entity.IndexArticleEntity;
import com.buss.news.entity.NewsEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;


/**
 * @Title: Entity
 * @Description: dxs_index_article
 * @author lu
 * @date 2016-07-12 16:38:13
 * @version V1.0
 *
 */
@Mapping(entityClass=IndexArticleEntity.class)
public class IndexArticleSearchForm extends SearchForm {
    /**主键*/
    @Mapping
    private String id;
    /**首页分类id*/
    @Mapping
    private String indexCatelogId;
    /**文章标题*/
    @Mapping
    private String articleTitle;
    /**文章编辑人*/
    @Mapping
    private String articleEditor;
    /**文章发布时间*/
    @Mapping
    private String articlePublishTime;
    /**文章简介*/
    @Mapping
    private String articleIntroduction;
    /**文章内容*/
    @Mapping
    private String articleContents;
    /**文章排序*/
    @Mapping
    private String articleSort;
    /**文章缩略图*/
    @Mapping
    private String articleImgUrl;
    /**文章视频*/
    @Mapping
    private String articleVideoUrl;
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

    public String getIndexCatelogId() {
        return indexCatelogId;
    }

    public void setIndexCatelogId(String indexCatelogId) {
        this.indexCatelogId = indexCatelogId;
    }

    public String getArticleTitle() {
        return articleTitle;
    }

    public void setArticleTitle(String articleTitle) {
        this.articleTitle = articleTitle;
    }

    public String getArticleEditor() {
        return articleEditor;
    }

    public void setArticleEditor(String articleEditor) {
        this.articleEditor = articleEditor;
    }

    public String getArticlePublishTime() {
        return articlePublishTime;
    }

    public void setArticlePublishTime(String articlePublishTime) {
        this.articlePublishTime = articlePublishTime;
    }

    public String getArticleIntroduction() {
        return articleIntroduction;
    }

    public void setArticleIntroduction(String articleIntroduction) {
        this.articleIntroduction = articleIntroduction;
    }

    public String getArticleContents() {
        return articleContents;
    }

    public void setArticleContents(String articleContents) {
        this.articleContents = articleContents;
    }

    public String getArticleSort() {
        return articleSort;
    }

    public void setArticleSort(String articleSort) {
        this.articleSort = articleSort;
    }

    public String getArticleImgUrl() {
        return articleImgUrl;
    }

    public void setArticleImgUrl(String articleImgUrl) {
        this.articleImgUrl = articleImgUrl;
    }

    public String getArticleVideoUrl() {
        return articleVideoUrl;
    }

    public void setArticleVideoUrl(String articleVideoUrl) {
        this.articleVideoUrl = articleVideoUrl;
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