package com.buss.activescustomcourses.trans.vo;

import com.buss.activescustomcourses.entity.ActivesCustomCoursesEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/8/1.
 */
@Mapping(entityClass = ActivesCustomCoursesEntity.class)
public class ActivesCustomCoursesVo extends BaseVO {
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**课程名*/
    @Mapping
    private java.lang.String courses;
    /**价格*/
    @Mapping
    private java.lang.String prices;
    /**是否可用*/
    @Mapping
    private java.lang.String isTrue;
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

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public String getPrices() {
        return prices;
    }

    public void setPrices(String prices) {
        this.prices = prices;
    }

    public String getIsTrue() {
        return isTrue;
    }

    public void setIsTrue(String isTrue) {
        this.isTrue = isTrue;
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
