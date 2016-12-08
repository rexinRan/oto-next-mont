package com.buss.employedcatalog.trans.form;


import com.buss.employedcatalog.entity.EmployedCatalogEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * @author lu
 * @date 2016-06-02 16:56:51
 * @version V1.0
 *
 */
@Mapping(entityClass=EmployedCatalogEntity.class)
public class EmployedCatalogSearchForm extends SearchForm {

    /**主键*/
    @Mapping
    private String id;
    /**父级id*/
    @Mapping
    private String pid;
    /**就业分类名称*/
    @Mapping
    private String employedCatalogName;
    /**分类配图*/
    @Mapping
    private String employedImgurl;
    /**分类介绍*/
    @Mapping
    private String employedIntroduction;
    /**创建时间*/
    @Mapping
    private String createTime;
    /**更新时间*/
    @Mapping
    private String updateTime;
    /**删除标志*/
    @Mapping
    private String isDelete;


    public EmployedCatalogSearchForm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getEmployedCatalogName() {
        return employedCatalogName;
    }

    public void setEmployedCatalogName(String employedCatalogName) {
        this.employedCatalogName = employedCatalogName;
    }

    public String getEmployedImgurl() {
        return employedImgurl;
    }

    public void setEmployedImgurl(String employedImgurl) {
        this.employedImgurl = employedImgurl;
    }

    public String getEmployedIntroduction() {
        return employedIntroduction;
    }

    public void setEmployedIntroduction(String employedIntroduction) {
        this.employedIntroduction = employedIntroduction;
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
