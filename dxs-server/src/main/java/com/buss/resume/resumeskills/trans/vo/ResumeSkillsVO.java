package com.buss.resume.resumeskills.trans.vo;

import com.buss.resume.resumecertificate.entity.ResumeCertificateEntity;
import com.buss.resume.resumeskills.entity.ResumeSkillsEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * @author lu
 * @date 2016-06-24 14:12:54
 * @version V1.0
 *
 */
@Mapping(entityClass=ResumeSkillsEntity.class)
public class ResumeSkillsVO extends BaseVO{
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
}
