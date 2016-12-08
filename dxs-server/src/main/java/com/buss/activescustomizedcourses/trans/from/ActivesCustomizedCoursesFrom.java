package com.buss.activescustomizedcourses.trans.from;

import com.buss.activescustomizedcourses.entity.ActivesCustomizedCoursesEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/8/1.
 */
@Mapping(entityClass = ActivesCustomizedCoursesEntity.class)
public class ActivesCustomizedCoursesFrom extends SearchForm{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**父类主键*/
    @Mapping
    private java.lang.String pid;
    /**课程名字*/
    @Mapping
    private java.lang.String courseName;
    /**价格*/
    @Mapping
    private java.lang.String coursePrice;
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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(String coursePrice) {
        this.coursePrice = coursePrice;
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
