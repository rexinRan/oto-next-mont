package com.buss.resume.resumetemplate.trans.vo;

import com.buss.resume.resumetemplate.entity.ResumeTemplateEntity;
import com.buss.resume.resumeworks.entity.ResumeWorksEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * @author lu
 * @date 2016-06-21 11:12:54
 * @version V1.0
 *
 */
@Mapping(entityClass=ResumeTemplateEntity.class)
public class ResumeTemplateVO extends BaseVO{
    /**主键*/
    @Mapping
    private String id;
    /**模板名称*/
    @Mapping
    private String templateName;
    /**求职意向*/
    @Mapping
    private String jobIntention;
    /**模板风格*/
    @Mapping
    private String templateStyle;
    /**模板语言*/
    @Mapping
    private String templateLanguage;
    /**模板图片*/
    @Mapping
    private String imgUrl;
    /**模板大图片*/
    @Mapping
    private String bigImgUrl;
    /**模板分类*/
    @Mapping
    private String templateCatelog;
    /**模板访问地址*/
    @Mapping
    private String templateUrl;
    /**模板特点*/
    @Mapping
    private String templateFeature;
    /**价格*/
    @Mapping
    private String price;

    public String getBigImgUrl() {
        return bigImgUrl;
    }

    public void setBigImgUrl(String bigImgUrl) {
        this.bigImgUrl = bigImgUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getJobIntention() {
        return jobIntention;
    }

    public void setJobIntention(String jobIntention) {
        this.jobIntention = jobIntention;
    }

    public String getTemplateStyle() {
        return templateStyle;
    }

    public void setTemplateStyle(String templateStyle) {
        this.templateStyle = templateStyle;
    }

    public String getTemplateLanguage() {
        return templateLanguage;
    }

    public void setTemplateLanguage(String templateLanguage) {
        this.templateLanguage = templateLanguage;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTemplateCatelog() {
        return templateCatelog;
    }

    public void setTemplateCatelog(String templateCatelog) {
        this.templateCatelog = templateCatelog;
    }

    public String getTemplateUrl() {
        return templateUrl;
    }

    public void setTemplateUrl(String templateUrl) {
        this.templateUrl = templateUrl;
    }

    public String getTemplateFeature() {
        return templateFeature;
    }

    public void setTemplateFeature(String templateFeature) {
        this.templateFeature = templateFeature;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
