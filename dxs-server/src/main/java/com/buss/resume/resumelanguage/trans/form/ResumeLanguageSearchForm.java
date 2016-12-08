package com.buss.resume.resumelanguage.trans.form;

import com.buss.resume.resumelanguage.entity.ResumeLanguageEntity;
import com.buss.resume.resumeschool.entity.ResumeSchoolEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**

 * @author lu
 * @date 2016-06-22 11:12:54
 * @version V1.0
 *
 */
@Mapping(entityClass=ResumeLanguageEntity.class)
public class ResumeLanguageSearchForm extends SearchForm{
    /**主键*/
    @Mapping
    private String id;
    /**简历ID*/
    @Mapping
    private String resumeId;
    /**语种*/
    @Mapping
    private String languageName;
    /**听说能力*/
    @Mapping
    private String languageListenSay;
    /**读写能力*/
    @Mapping
    private String languageReadWrite;
    /**等级考试*/
    @Mapping
    private String languageClass;
    /**得分*/
    @Mapping
    private String languageSore;
    /**创建时间*/
    @Mapping
    private String createTime;
    /**更新时间*/
    @Mapping
    private String updateTime;
    /**删除标志*/
    @Mapping
    private String isDelete;

    public ResumeLanguageSearchForm() {
    }

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

    public String getLanguageName() {
        return languageName;
    }

    public void setLanguageName(String languageName) {
        this.languageName = languageName;
    }

    public String getLanguageListenSay() {
        return languageListenSay;
    }

    public void setLanguageListenSay(String languageListenSay) {
        this.languageListenSay = languageListenSay;
    }

    public String getLanguageReadWrite() {
        return languageReadWrite;
    }

    public void setLanguageReadWrite(String languageReadWrite) {
        this.languageReadWrite = languageReadWrite;
    }

    public String getLanguageClass() {
        return languageClass;
    }

    public void setLanguageClass(String languageClass) {
        this.languageClass = languageClass;
    }

    public String getLanguageSore() {
        return languageSore;
    }

    public void setLanguageSore(String languageSore) {
        this.languageSore = languageSore;
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
