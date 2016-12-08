package com.buss.directionalemploymentgroups.trans.form;


import com.buss.directionalemploymentgroups.entity.DirectionalEmploymentGroupsEntity;
import com.buss.employed.entity.EmployedEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**

 * @author lu
 * @date 2016-06-02 16:56:51
 * @version V1.0
 *
 */
@Mapping(entityClass=DirectionalEmploymentGroupsEntity.class)
public class DirectionalEmploymentGroupsSearchForm extends SearchForm {

    /**主键*/
    @Mapping
    private String id;
    /**企业id*/
    @Mapping
    private String userId;
    /**定项就业名称*/
    @Mapping
    private String directionalEmploymentName;
    /**显示菜单*/
    @Mapping
    private String directionDisplayMenu;
    /**总投递数*/
    @Mapping
    private String postNum;
    /**定项就业发布时间*/
    @Mapping
    private String directionPublishTime;
    /**创建时间*/
    @Mapping
    private String cretateTime;
    /**更新时间*/
    @Mapping
    private String updateTime;
    /**删除标志*/
    @Mapping
    private String isDelete;
    /**企业性质*/
    @Mapping("employedList.userEntity.userCompancyEntity.compancyNature")
    private  String compancyNature;
    /**学历要求*/
    @Mapping("employedList.education")
    private String education;
    /**工作经验*/
    @Mapping("employedList.experience")
    private String experience;
    /**职位类型*/
    @Mapping("employedList.employedType")
    private String employedType;
    /**月薪*/
    @Mapping("employedList.employedSalary")
    private java.lang.String employedSalary;

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getEmployedType() {
        return employedType;
    }

    public void setEmployedType(String employedType) {
        this.employedType = employedType;
    }

    public String getEmployedSalary() {
        return employedSalary;
    }

    public void setEmployedSalary(String employedSalary) {
        this.employedSalary = employedSalary;
    }

    public String getCompancyNature() {
        return compancyNature;
    }

    public void setCompancyNature(String compancyNature) {
        this.compancyNature = compancyNature;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDirectionalEmploymentName() {
        return directionalEmploymentName;
    }

    public void setDirectionalEmploymentName(String directionalEmploymentName) {
        this.directionalEmploymentName = directionalEmploymentName;
    }

    public String getDirectionDisplayMenu() {
        return directionDisplayMenu;
    }

    public void setDirectionDisplayMenu(String directionDisplayMenu) {
        this.directionDisplayMenu = directionDisplayMenu;
    }

    public String getDirectionPublishTime() {
        return directionPublishTime;
    }

    public void setDirectionPublishTime(String directionPublishTime) {
        this.directionPublishTime = directionPublishTime;
    }

    public String getPostNum() {
        return postNum;
    }

    public void setPostNum(String postNum) {
        this.postNum = postNum;
    }

    public String getCretateTime() {
        return cretateTime;
    }

    public void setCretateTime(String cretateTime) {
        this.cretateTime = cretateTime;
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
