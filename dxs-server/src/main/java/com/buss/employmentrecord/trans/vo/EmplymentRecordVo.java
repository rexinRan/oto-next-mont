package com.buss.employmentrecord.trans.vo;

import com.buss.employmentrecord.entity.EmploymentRecordEntity;
import com.buss.leadassessment.entity.LeadAssessmentEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

import javax.persistence.OneToMany;
import java.security.KeyStore;
import java.util.*;

/**
 * Created by Administrator on 2016/6/22.
 */
@Mapping(entityClass = EmploymentRecordEntity.class)
public class EmplymentRecordVo extends BaseVO {

    /**主键*/
    @Mapping
    private java.lang.String id;
    /**企业ID*/
    @Mapping
    private java.lang.String companyUserId;
    /**职工ID*/
    @Mapping("generalUserEntity.id")
    private java.lang.String workUserId;
    /**入职员工点评Id*/
//   @Mapping("leadAssessmentEntities.id")
//    private java.lang.String leadAssessmentId;
   /**公司名称*/
    @Mapping
    private java.lang.String companyNmae;
    /**职位*/
    @Mapping
    private java.lang.String position;
    /**开始工作*/
    @Mapping
    private java.lang.String workStart;
    /**结束工作*/
    @Mapping
    private java.lang.String workEnd;
    /**创建时间*/
    @Mapping
    private java.lang.String createTime;
    /**更新时间*/
    @Mapping
    private java.lang.String upStringTime;
    /**删除标志*/
    @Mapping
    private java.lang.String isDelete;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyUserId() {
        return companyUserId;
    }

    public void setCompanyUserId(String companyUserId) {
        this.companyUserId = companyUserId;
    }

    public String getWorkUserId() {
        return workUserId;
    }

    public void setWorkUserId(String workUserId) {
        this.workUserId = workUserId;
    }

//    public String getLeadAssessmentId() {
//        return leadAssessmentId;
//    }
//
//    public void setLeadAssessmentId(String leadAssessmentId) {
//        this.leadAssessmentId = leadAssessmentId;
//    }

    public String getCompanyNmae() {
        return companyNmae;
    }

    public void setCompanyNmae(String companyNmae) {
        this.companyNmae = companyNmae;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getWorkStart() {
        return workStart;
    }

    public void setWorkStart(String workStart) {
        this.workStart = workStart;
    }

    public String getWorkEnd() {
        return workEnd;
    }

    public void setWorkEnd(String workEnd) {
        this.workEnd = workEnd;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpStringTime() {
        return upStringTime;
    }

    public void setUpStringTime(String upStringTime) {
        this.upStringTime = upStringTime;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }


    //==============================================================================================
    // 用于存放入职员工的评价
    private List<Object> list = new ArrayList<Object>();

    public List<Object> getList() {
        return list;
    }

    public void setList(List<Object> list) {
        this.list = list;
    }
}
