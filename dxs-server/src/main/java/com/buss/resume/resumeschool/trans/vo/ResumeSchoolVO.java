package com.buss.resume.resumeschool.trans.vo;

import com.buss.resume.resumeschool.entity.ResumeSchoolEntity;
import com.buss.resume.resumeworkexperience.entity.ResumeWorkexperienceEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * @author lu
 * @date 2016-06-21 11:12:54
 * @version V1.0
 *
 */
@Mapping(entityClass=ResumeSchoolEntity.class)
public class ResumeSchoolVO extends BaseVO{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**简历ID*/
    @Mapping
    private java.lang.String resumeId;
    /**入学时间*/
    @Mapping
    private java.lang.String schoolStart;
    /**毕业时间*/
    @Mapping
    private java.lang.String schoolEnd;
    /**学校名称*/
    @Mapping
    private java.lang.String schoolName;
    /**专业名称*/
    @Mapping
    private java.lang.String schoolProfessional;
    /**学历*/
    @Mapping
    private java.lang.String schoolQualifications;
    /**专业描述*/
    @Mapping
    private java.lang.String schoolDescription;
    /**导师*/
    @Mapping
    private java.lang.String teacher;
    /**GPA*/
    @Mapping
    private java.lang.String gpa;
    /**课程*/
    @Mapping
    private java.lang.String courses;
    /**备注*/
    @Mapping
    private java.lang.String remark;

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

    public String getSchoolStart() {
        return schoolStart;
    }

    public void setSchoolStart(String schoolStart) {
        this.schoolStart = schoolStart;
    }

    public String getSchoolEnd() {
        return schoolEnd;
    }

    public void setSchoolEnd(String schoolEnd) {
        this.schoolEnd = schoolEnd;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getSchoolProfessional() {
        return schoolProfessional;
    }

    public void setSchoolProfessional(String schoolProfessional) {
        this.schoolProfessional = schoolProfessional;
    }

    public String getSchoolQualifications() {
        return schoolQualifications;
    }

    public void setSchoolQualifications(String schoolQualifications) {
        this.schoolQualifications = schoolQualifications;
    }

    public String getSchoolDescription() {
        return schoolDescription;
    }

    public void setSchoolDescription(String schoolDescription) {
        this.schoolDescription = schoolDescription;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public String getGpa() {
        return gpa;
    }

    public void setGpa(String gpa) {
        this.gpa = gpa;
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
