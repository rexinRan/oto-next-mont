package com.buss.about.trans.form;

import com.buss.about.entity.AboutCenterEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/7/16.
 */
@Mapping(entityClass=AboutCenterEntity.class)
public class AboutCenterForm extends SearchForm {
    /**主键*/
    @Mapping
    private String id;
    /**标题*/
    @Mapping
    private String title;
    /**发表时间*/
    @Mapping
    private String publishTime;
    /**内容*/
    @Mapping
    private String content;
    /**编号*/
    @Mapping
    private String sort;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
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
