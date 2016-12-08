package com.buss.resume.projectexperience.trans.vo;

import com.buss.resume.projectexperience.entity.ProjectExperienceEntity;
import com.buss.resume.resume.entity.ResumeEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * @author lu
 * @date 2016-06-22 11:10:38
 * @version V1.0
 *
 */
@Mapping(entityClass=ProjectExperienceEntity.class)
public class ProjectExperienceVO extends BaseVO{
    /**主键*/
    @Mapping
    private String id;
    /**简历ID*/
    @Mapping
    private String resumeId;
    /**项目名*/
    @Mapping
    private String projectName;
    /**团队规模*/
    @Mapping
    private String projectNum;
    /**项目描述*/
    @Mapping
    private String projectDescription;
    /**项目角色*/
    @Mapping
    private String projectTask;
    /**开始时间*/
    @Mapping
    private String projectStart;
    /**结束时间*/
    @Mapping
    private String projectEnd;

    public ProjectExperienceVO() {
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectNum() {
        return projectNum;
    }

    public void setProjectNum(String projectNum) {
        this.projectNum = projectNum;
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String projectDescription) {
        this.projectDescription = projectDescription;
    }

    public String getProjectTask() {
        return projectTask;
    }

    public void setProjectTask(String projectTask) {
        this.projectTask = projectTask;
    }

    public String getProjectStart() {
        return projectStart;
    }

    public void setProjectStart(String projectStart) {
        this.projectStart = projectStart;
    }

    public String getProjectEnd() {
        return projectEnd;
    }

    public void setProjectEnd(String projectEnd) {
        this.projectEnd = projectEnd;
    }
}
