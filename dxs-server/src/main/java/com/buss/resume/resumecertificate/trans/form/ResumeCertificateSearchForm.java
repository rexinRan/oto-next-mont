package com.buss.resume.resumecertificate.trans.form;

import com.buss.resume.resumecertificate.entity.ResumeCertificateEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**

 * @author lu
 * @date 2016-06-24 14:12:54
 * @version V1.0
 *
 */
@Mapping(entityClass=ResumeCertificateEntity.class)
public class ResumeCertificateSearchForm extends SearchForm{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**简历ID*/
    @Mapping
    private java.lang.String resumeId;
    /**证书种类(预留)*/
    @Mapping
    private java.lang.String certificateKey;
    /**证书名称*/
    @Mapping
    private java.lang.String certificateName;
    /**补充*/
    @Mapping
    private java.lang.String certificateName2;
    /**分数*/
    @Mapping
    private java.lang.String score;
    /**图片*/
    @Mapping
    private java.lang.String imgUrl;
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

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
    }

    public String getCertificateKey() {
        return certificateKey;
    }

    public void setCertificateKey(String certificateKey) {
        this.certificateKey = certificateKey;
    }

    public String getCertificateName() {
        return certificateName;
    }

    public void setCertificateName(String certificateName) {
        this.certificateName = certificateName;
    }

    public String getCertificateName2() {
        return certificateName2;
    }

    public void setCertificateName2(String certificateName2) {
        this.certificateName2 = certificateName2;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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
