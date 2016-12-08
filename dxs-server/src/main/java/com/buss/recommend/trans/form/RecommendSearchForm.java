package com.buss.recommend.trans.form;

import com.buss.recommend.entity.RecommendEntity;
import com.buss.resume.resume.entity.ResumeEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * @author lu
 * @date 2016-06-27 17:10:38
 * @version V1.0
 *
 */
@Mapping(entityClass=RecommendEntity.class)
public class RecommendSearchForm extends SearchForm{
    /**主键*/
    @Mapping
    private String id;
    /**招聘岗位的ID*/
    @Mapping
    private String outId;
    /**推荐人id*/
    @Mapping
    private String recommendedUserId;
    /**被推荐人id*/
    @Mapping
    private String berecommendedUserId;
    /**简历投递id*/
    @Mapping
    private String resumeUserId;
    /**推荐评语*/
    @Mapping
    private String recommendedReviews;
    /**简历附件*/
    @Mapping
    private String accessories;
    /**结果*/
    @Mapping
    private String result;
    /**推荐类型*/
    @Mapping
    private String type;
    /**创建时间*/
    @Mapping
    private String createTime;
    /**更新时间*/
    @Mapping
    private String updateTime;
    /**删除标志*/
    @Mapping
    private String isDelete;
    /**鸿鑫币*/
    @Mapping
    private String hxCurrency;
    /**推荐时间*/
    @Mapping
    private String recommendTime;
    /**推荐理由*/
    @Mapping
    private java.lang.String recommendAccount;
    /**备注*/
    @Mapping
    private java.lang.String remarks;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOutId() {
        return outId;
    }

    public void setOutId(String outId) {
        this.outId = outId;
    }

    public String getRecommendedUserId() {
        return recommendedUserId;
    }

    public void setRecommendedUserId(String recommendedUserId) {
        this.recommendedUserId = recommendedUserId;
    }

    public String getBerecommendedUserId() {
        return berecommendedUserId;
    }

    public void setBerecommendedUserId(String berecommendedUserId) {
        this.berecommendedUserId = berecommendedUserId;
    }

    public String getResumeUserId() {
        return resumeUserId;
    }

    public void setResumeUserId(String resumeUserId) {
        this.resumeUserId = resumeUserId;
    }

    public String getRecommendedReviews() {
        return recommendedReviews;
    }

    public void setRecommendedReviews(String recommendedReviews) {
        this.recommendedReviews = recommendedReviews;
    }

    public String getAccessories() {
        return accessories;
    }

    public void setAccessories(String accessories) {
        this.accessories = accessories;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String getHxCurrency() {
        return hxCurrency;
    }

    public void setHxCurrency(String hxCurrency) {
        this.hxCurrency = hxCurrency;
    }

    public String getRecommendTime() {
        return recommendTime;
    }

    public void setRecommendTime(String recommendTime) {
        this.recommendTime = recommendTime;
    }

    public String getRecommendAccount() {
        return recommendAccount;
    }

    public void setRecommendAccount(String recommendAccount) {
        this.recommendAccount = recommendAccount;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
