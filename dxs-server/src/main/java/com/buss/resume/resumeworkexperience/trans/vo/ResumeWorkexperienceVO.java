package com.buss.resume.resumeworkexperience.trans.vo;

import com.buss.resume.resume.entity.ResumeEntity;
import com.buss.resume.resumeworkexperience.entity.ResumeWorkexperienceEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * @author lu
 * @date 2016-06-16 17:12:01
 * @version V1.0
 *
 */
@Mapping(entityClass=ResumeWorkexperienceEntity.class)
public class ResumeWorkexperienceVO extends BaseVO{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**简历ID*/
    @Mapping
    private java.lang.String resumeId;
    /**公司名称*/
    @Mapping
    private java.lang.String companyName;
    /**公司地址*/
    @Mapping
    private java.lang.String companyAddress;
    /**所在部门*/
    @Mapping
    private java.lang.String companyDepartment;
    /**从事职位*/
    @Mapping
    private java.lang.String companyJob;
    /**职位级别*/
    @Mapping
    private java.lang.String companyClass;
    /**职位类型*/
    @Mapping
    private java.lang.String companyType;
    /**开始时间*/
    @Mapping
    private java.lang.String companyStart;
    /**结束时间*/
    @Mapping
    private java.lang.String companyEnd;
    /**工作经历*/
    @Mapping
    private java.lang.String workExperience;
    /**图片*/
    @Mapping
    private java.lang.String imgUrl;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getCompanyDepartment() {
        return companyDepartment;
    }

    public void setCompanyDepartment(String companyDepartment) {
        this.companyDepartment = companyDepartment;
    }

    public String getCompanyJob() {
        return companyJob;
    }

    public void setCompanyJob(String companyJob) {
        this.companyJob = companyJob;
    }

    public String getCompanyClass() {
        return companyClass;
    }

    public void setCompanyClass(String companyClass) {
        this.companyClass = companyClass;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public String getCompanyStart() {
        return companyStart;
    }

    public void setCompanyStart(String companyStart) {
        this.companyStart = companyStart;
    }

    public String getCompanyEnd() {
        return companyEnd;
    }

    public void setCompanyEnd(String companyEnd) {
        this.companyEnd = companyEnd;
    }

    public String getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
