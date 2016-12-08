package com.buss.entrepreneurshiparticle.trans.vo;

import com.buss.entrepreneurshiparticle.entity.EntrepreneurshipArticleEntity;
import com.buss.entrepreneurshipcatalog.entity.EntrepreneurshipCatalogEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * @author lu
 * @date 2016-06-06 14:24:58
 * @version V1.0
 *
 */
@Mapping(entityClass=EntrepreneurshipArticleEntity.class)
public class EntrepreneurshipArticleVO extends BaseVO{
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

    public EntrepreneurshipArticleVO() {
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

    public String getEntrepreneurshipIntroduction() {
        return entrepreneurshipIntroduction;
    }

    public void setEntrepreneurshipIntroduction(String entrepreneurshipIntroduction) {
        this.entrepreneurshipIntroduction = entrepreneurshipIntroduction;
    }
}
