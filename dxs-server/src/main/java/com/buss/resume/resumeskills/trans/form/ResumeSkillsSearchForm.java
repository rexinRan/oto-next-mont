package com.buss.resume.resumeskills.trans.form;

import com.buss.resume.resumecertificate.entity.ResumeCertificateEntity;
import com.buss.resume.resumeskills.entity.ResumeSkillsEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**

 * @author lu
 * @date 2016-06-24 14:12:54
 * @version V1.0
 *
 */
@Mapping(entityClass=ResumeSkillsEntity.class)
public class ResumeSkillsSearchForm extends SearchForm{
    /**主键*/
    @Mapping
    private String id;
    /**简历ID*/
    @Mapping
    private String resumeId;
    /**技能项*/
    @Mapping
    private String skills;
    /**技能类型*/
    @Mapping
    private String skillsType;
    /**技能有效值*/
    @Mapping
    private String skillsKey;
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

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getSkillsType() {
        return skillsType;
    }

    public void setSkillsType(String skillsType) {
        this.skillsType = skillsType;
    }

    public String getSkillsKey() {
        return skillsKey;
    }

    public void setSkillsKey(String skillsKey) {
        this.skillsKey = skillsKey;
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
