package com.buss.activecatelog.trans.form;


import java.lang.String;

import com.buss.activecatelog.entity.ActiveCatelogEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;



/**
 * @author lu
 * @date 2016-06-06 11:47:58
 * @version V1.0
 *
 */
@Mapping(entityClass=ActiveCatelogEntity.class)
public class ActiveCatelogSearchForm extends SearchForm {
    /**主键*/
    @Mapping
    private String id;
    /**活动种类名称*/
    @Mapping
    private String activeCatelogName;
    /**菜单类型*/
    @Mapping
    private String pid;
    /**活动种类配图*/
    @Mapping
    private String activeCatelogImg;
    /**活动种类的描述*/
    @Mapping
    private String activeCatelogDescribe;
    /**活动种类的排序*/
    @Mapping
    private String activeCatelogSort;
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

    public String getActiveCatelogName() {
        return activeCatelogName;
    }

    public void setActiveCatelogName(String activeCatelogName) {
        this.activeCatelogName = activeCatelogName;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getActiveCatelogImg() {
        return activeCatelogImg;
    }

    public void setActiveCatelogImg(String activeCatelogImg) {
        this.activeCatelogImg = activeCatelogImg;
    }

    public String getActiveCatelogDescribe() {
        return activeCatelogDescribe;
    }

    public void setActiveCatelogDescribe(String activeCatelogDescribe) {
        this.activeCatelogDescribe = activeCatelogDescribe;
    }

    public String getActiveCatelogSort() {
        return activeCatelogSort;
    }

    public void setActiveCatelogSort(String activeCatelogSort) {
        this.activeCatelogSort = activeCatelogSort;
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
