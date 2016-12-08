package com.buss.project.basescase.trans.form;

import com.buss.project.bases.entity.BasesEntity;
import com.buss.project.basescase.entity.BasesCaseEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;


/**
 * @author lu
 * @date 2016-07-25 13:38:23
 * @version V1.0
 *
 */
@Mapping(entityClass=BasesCaseEntity.class)
public class BasesCaseSearchForm extends SearchForm {
    /**主键*/
    @Mapping
    private String id;
    /**基地主键*/
    @Mapping
    private String dbId;
    /**基地图片文件*/
    @Mapping
    private String dbImgFid;
    /**图片地址*/
    @Mapping
    private String dbImgUrl;
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

    public String getDbId() {
        return dbId;
    }

    public void setDbId(String dbId) {
        this.dbId = dbId;
    }

    public String getDbImgFid() {
        return dbImgFid;
    }

    public void setDbImgFid(String dbImgFid) {
        this.dbImgFid = dbImgFid;
    }

    public String getDbImgUrl() {
        return dbImgUrl;
    }

    public void setDbImgUrl(String dbImgUrl) {
        this.dbImgUrl = dbImgUrl;
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