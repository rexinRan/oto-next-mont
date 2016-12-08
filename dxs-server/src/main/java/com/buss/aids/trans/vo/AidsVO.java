package com.buss.aids.trans.vo;

import com.buss.aids.entity.AidsEntity;
import com.buss.news.entity.NewsEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;


/**
 * @author lu
 * @date 2016-06-01 13:38:23
 * @version V1.0
 *
 */
@Mapping(entityClass=AidsEntity.class)
public class AidsVO extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**扶贫分类id*/
    @Mapping
    private String aidCatelogId;
    /**扶贫标题*/
    @Mapping
    private String aidTitle;
    /**编辑人*/
    @Mapping
    private String aidEditor;
    /**发布时间*/
    @Mapping
    private String aidPublishTime;
    /**扶贫简介*/
    @Mapping
    private String aidIntroduction;
    /**扶贫内容*/
    @Mapping
    private String aidContents;
    /**编号*/
    @Mapping
    private String aidSort;
    /**扶贫视频*/
    @Mapping
    private String aidVideoUrl;
    /**扶贫缩略图*/
    @Mapping
    private String aidImgUrl;
    /**扶贫发布年份*/
    @Mapping
    private String aidPublishYear;
    /**扶贫发布月份*/
    @Mapping
    private String aidPublicMonth;
    /**所属地区*/
    @Mapping
    private String aidRegion;
    /**是否特别关注*/
    @Mapping
    private String isSpecial;
    /**新闻来源*/
    @Mapping
    private String aidFrom;
    /**外部标记*/
    @Mapping
    private String outSign;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAidCatelogId() {
        return aidCatelogId;
    }

    public void setAidCatelogId(String aidCatelogId) {
        this.aidCatelogId = aidCatelogId;
    }

    public String getAidTitle() {
        return aidTitle;
    }

    public void setAidTitle(String aidTitle) {
        this.aidTitle = aidTitle;
    }

    public String getAidEditor() {
        return aidEditor;
    }

    public void setAidEditor(String aidEditor) {
        this.aidEditor = aidEditor;
    }

    public String getAidPublishTime() {
        return aidPublishTime;
    }

    public void setAidPublishTime(String aidPublishTime) {
        this.aidPublishTime = aidPublishTime;
    }

    public String getAidIntroduction() {
        return aidIntroduction;
    }

    public void setAidIntroduction(String aidIntroduction) {
        this.aidIntroduction = aidIntroduction;
    }

    public String getAidContents() {
        return aidContents;
    }

    public void setAidContents(String aidContents) {
        this.aidContents = aidContents;
    }

    public String getAidSort() {
        return aidSort;
    }

    public void setAidSort(String aidSort) {
        this.aidSort = aidSort;
    }

    public String getAidVideoUrl() {
        return aidVideoUrl;
    }

    public void setAidVideoUrl(String aidVideoUrl) {
        this.aidVideoUrl = aidVideoUrl;
    }

    public String getAidImgUrl() {
        return aidImgUrl;
    }

    public void setAidImgUrl(String aidImgUrl) {
        this.aidImgUrl = aidImgUrl;
    }

    public String getAidPublishYear() {
        return aidPublishYear;
    }

    public void setAidPublishYear(String aidPublishYear) {
        this.aidPublishYear = aidPublishYear;
    }

    public String getAidPublicMonth() {
        return aidPublicMonth;
    }

    public void setAidPublicMonth(String aidPublicMonth) {
        this.aidPublicMonth = aidPublicMonth;
    }

    public String getAidRegion() {
        return aidRegion;
    }

    public void setAidRegion(String aidRegion) {
        this.aidRegion = aidRegion;
    }

    public String getIsSpecial() {
        return isSpecial;
    }

    public void setIsSpecial(String isSpecial) {
        this.isSpecial = isSpecial;
    }

    public String getAidFrom() {
        return aidFrom;
    }

    public void setAidFrom(String aidFrom) {
        this.aidFrom = aidFrom;
    }

    public String getOutSign() {
        return outSign;
    }

    public void setOutSign(String outSign) {
        this.outSign = outSign;
    }
}
