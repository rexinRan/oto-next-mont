package com.buss.activesdetails.trans.vo;

import com.buss.activesdetails.entity.ActivesDetailsEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/8/4.
 */
@Mapping(entityClass = ActivesDetailsEntity.class)
public class ActivesDetailsVo extends BaseVO{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**活动id*/
    @Mapping
    private java.lang.String activesId;
    /**推荐理由*/
    @Mapping
    private java.lang.String recommendedReason;
    /**费用包含*/
    @Mapping
    private java.lang.String costInclude;
    /**费用不包含*/
    @Mapping
    private java.lang.String costUninclude;
    /**签证方式*/
    @Mapping
    private java.lang.String visaNote;
    /**行前准备*/
    @Mapping
    private java.lang.String preparation;
    /**付款方式*/
    @Mapping
    private java.lang.String paymentMethod;
    /**常见问题(待定)*/
    @Mapping
    private java.lang.String commonProblem;
    /**创建时间*/
    @Mapping
    private java.lang.String createTime;
    /**更新时间*/
    @Mapping
    private java.lang.String updateTime;
    /**删除标志*/
    @Mapping
    private java.lang.String isDelete;
    /**出发日期和团信息*/
    @Mapping
    private java.lang.String activesStart2;
    /**图片1id*/
    @Mapping
    private java.lang.String img1Fid;
    /**图片1地址*/
    @Mapping
    private java.lang.String img1Url;
    /**图片id*/
    @Mapping
    private java.lang.String img2Fid;
    /**图片2地址*/
    @Mapping
    private java.lang.String img2Url;
    /**图片3id*/
    @Mapping
    private java.lang.String img3Fid;
    /**图片3地址*/
    @Mapping
    private java.lang.String img3Url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getActivesId() {
        return activesId;
    }

    public void setActivesId(String activesId) {
        this.activesId = activesId;
    }

    public String getRecommendedReason() {
        return recommendedReason;
    }

    public void setRecommendedReason(String recommendedReason) {
        this.recommendedReason = recommendedReason;
    }

    public String getCostInclude() {
        return costInclude;
    }

    public void setCostInclude(String costInclude) {
        this.costInclude = costInclude;
    }

    public String getCostUninclude() {
        return costUninclude;
    }

    public void setCostUninclude(String costUninclude) {
        this.costUninclude = costUninclude;
    }

    public String getVisaNote() {
        return visaNote;
    }

    public void setVisaNote(String visaNote) {
        this.visaNote = visaNote;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getCommonProblem() {
        return commonProblem;
    }

    public void setCommonProblem(String commonProblem) {
        this.commonProblem = commonProblem;
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

    public String getActivesStart2() {
        return activesStart2;
    }

    public void setActivesStart2(String activesStart2) {
        this.activesStart2 = activesStart2;
    }

    public String getImg1Fid() {
        return img1Fid;
    }

    public void setImg1Fid(String img1Fid) {
        this.img1Fid = img1Fid;
    }

    public String getImg1Url() {
        return img1Url;
    }

    public void setImg1Url(String img1Url) {
        this.img1Url = img1Url;
    }

    public String getImg2Fid() {
        return img2Fid;
    }

    public void setImg2Fid(String img2Fid) {
        this.img2Fid = img2Fid;
    }

    public String getImg2Url() {
        return img2Url;
    }

    public void setImg2Url(String img2Url) {
        this.img2Url = img2Url;
    }

    public String getImg3Fid() {
        return img3Fid;
    }

    public void setImg3Fid(String img3Fid) {
        this.img3Fid = img3Fid;
    }

    public String getImg3Url() {
        return img3Url;
    }

    public void setImg3Url(String img3Url) {
        this.img3Url = img3Url;
    }
}
