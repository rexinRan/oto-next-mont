package com.buss.trainoutlinecourseuser.trans.from;

import com.buss.trainoutlinecourseuser.entity.TrainOutlineCourseUserEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;
import org.w3c.dom.Entity;

/**
 * Created by HongXinGuoJi-yzg on 2016/9/6.
 */
@Mapping(entityClass = TrainOutlineCourseUserEntity.class)
public class TrainOutlineCourseUserFrom extends SearchForm{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**用户id*/
    @Mapping
    private java.lang.String userId;
    /**课程id*/
    @Mapping
    private java.lang.String tocId;
    /**报名类型*/
    @Mapping
    private java.lang.String type;
    /**结果字段*/
    @Mapping
    private java.lang.String result;
    /**备注*/
    @Mapping
    private java.lang.String resume;
    /**创建时间*/
    @Mapping
    private java.lang.String createTime;
    /**更新时间*/
    @Mapping
    private java.lang.String updateTime;
    /**删除标志*/
    @Mapping
    private java.lang.String isDelete;

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

    public String getTocId() {
        return tocId;
    }

    public void setTocId(String tocId) {
        this.tocId = tocId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
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
