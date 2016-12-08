package com.buss.news.trans.vo;

import com.buss.news.entity.NewsEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;


/**
 * @author lu
 * @date 2016-06-01 13:38:23
 * @version V1.0
 *
 */
@Mapping(entityClass=NewsEntity.class)
public class NewsVO extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**新闻分类id*/
    @Mapping
    private String newCatelogId;
    /**新闻标题*/
    @Mapping
    private String newTitle;
    /**编辑人*/
    @Mapping
    private String newEditor;
    /**发布时间*/
    @Mapping
    private String newPublishTime;
    /**新闻来源*/
    @Mapping
    private String newFrom;
    /**新闻内容*/
    @Mapping
    private String newContents;
    /**新闻简介*/
    @Mapping
    private String newIntroduction;
    /**编号*/
    @Mapping
    private String newSort;
    /**外部标记*/
    @Mapping
    private String outSign;
    /**新闻视频*/
    @Mapping
    private String newVideoUrl;
    /**新闻图片*/
    @Mapping
    private String newImgUrl;
    @Mapping
    private String newPublishYear;
    /**是否为特别关注*/
    @Mapping
    private String isSpecial;

    public NewsVO() {
    }

    public String getOutSign() {
        return outSign;
    }

    public void setOutSign(String outSign) {
        this.outSign = outSign;
    }

    public String getId(){
        return this.id;
    }


    public void setId(String id){
        this.id = id;
    }

    public String getNewCatelogId(){
        return this.newCatelogId;
    }


    public void setNewCatelogId(String newCatelogId){
        this.newCatelogId = newCatelogId;
    }

    public String getNewTitle(){
        return this.newTitle;
    }


    public void setNewTitle(String newTitle){
        this.newTitle = newTitle;
    }

    public String getNewEditor(){
        return this.newEditor;
    }


    public void setNewEditor(String newEditor){
        this.newEditor = newEditor;
    }

    public String getNewPublishTime(){
        return this.newPublishTime;
    }


    public void setNewPublishTime(String newPublishTime){
        this.newPublishTime = newPublishTime;
    }

    public String getNewContents(){
        return this.newContents;
    }


    public void setNewContents(String newContents){
        this.newContents = newContents;
    }

    public String getNewSort(){
        return this.newSort;
    }


    public void setNewSort(String newSort){
        this.newSort = newSort;
    }

    public String getNewIntroduction() {
        return newIntroduction;
    }

    public void setNewIntroduction(String newIntroduction) {
        this.newIntroduction = newIntroduction;
    }

    public String getNewVideoUrl() {
        return newVideoUrl;
    }

    public void setNewVideoUrl(String newVideoUrl) {
        this.newVideoUrl = newVideoUrl;
    }

    public String getNewImgUrl() {
        return newImgUrl;
    }

    public void setNewImgUrl(String newImgUrl) {
        this.newImgUrl = newImgUrl;
    }

    public String getNewPublishYear() {
        return newPublishYear;
    }

    public void setNewPublishYear(String newPublishYear) {
        this.newPublishYear = newPublishYear;
    }

    public String getIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(String isSpecial) {
        this.isSpecial = isSpecial;
    }

    public String getNewFrom() {
        return newFrom;
    }

    public void setNewFrom(String newFrom) {
        this.newFrom = newFrom;
    }
}
