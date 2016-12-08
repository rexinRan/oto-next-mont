package com.buss.trainingcatalog.trans.form;

import com.buss.trainingcatalog.entity.TrainingCatalogEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;


/**
 * @author lu
 * @date 2016-06-08 10:10:43
 * @version V1.0
 *
 */
@Mapping(entityClass=TrainingCatalogEntity.class)
public class TrainingCatalogSearchForm extends SearchForm {
    /**主键*/
    @Mapping
    private String id;
    /**父级主键*/
    @Mapping
    private String pid;
    /**培训中心分类名称*/
    @Mapping
    private String trainingCatalogName;
    /**分类配图*/
    @Mapping
    private String trainingCatalogImg;
    /**分类简介*/
    @Mapping
    private String trainingCatalogIntroduction;
    /**创建时间*/
    @Mapping
    private String createTime;
    /**更新时间*/
    @Mapping
    private String updateTime;
    /**删除标志*/
    @Mapping
    private String isDelete;

    public TrainingCatalogSearchForm() {
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

    public String getTrainingCatalogName() {
        return trainingCatalogName;
    }

    public void setTrainingCatalogName(String trainingCatalogName) {
        this.trainingCatalogName = trainingCatalogName;
    }

    public String getTrainingCatalogImg() {
        return trainingCatalogImg;
    }

    public void setTrainingCatalogImg(String trainingCatalogImg) {
        this.trainingCatalogImg = trainingCatalogImg;
    }

    public String getTrainingCatalogIntroduction() {
        return trainingCatalogIntroduction;
    }

    public void setTrainingCatalogIntroduction(String trainingCatalogIntroduction) {
        this.trainingCatalogIntroduction = trainingCatalogIntroduction;
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
