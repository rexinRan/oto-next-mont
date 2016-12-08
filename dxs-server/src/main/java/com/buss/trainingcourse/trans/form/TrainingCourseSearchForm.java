package com.buss.trainingcourse.trans.form;

import com.buss.trainingcourse.entity.TrainingCourseEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;


/**
 * @author lu
 * @date 2016-06-27 17:10:43
 * @version V1.0
 *
 */
@Mapping(entityClass=TrainingCourseEntity.class)
public class TrainingCourseSearchForm extends SearchForm {
    /**主键*/
    @Mapping
    private String id;
    /**培训中心分类id*/
    @Mapping
    private String trainingCatelogId;
    /**课程名称*/
    @Mapping
    private String courseName;
    /**任课老师*/
    @Mapping
    private String courseTeacher;
    /**课程发布者*/
    @Mapping
    private String courseEditor;
    /**发布时间*/
    @Mapping
    private String coursePublishTime;
    /**课程视频*/
    @Mapping
    private String courseVideourl;
    /**课程介绍*/
    @Mapping
    private String courseIntroduce;
    /**编号*/
    @Mapping
    private String courseSort;
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

    public String getTrainingCatelogId() {
        return trainingCatelogId;
    }

    public void setTrainingCatelogId(String trainingCatelogId) {
        this.trainingCatelogId = trainingCatelogId;
    }

    public String getCourseTeacher() {
        return courseTeacher;
    }

    public void setCourseTeacher(String courseTeacher) {
        this.courseTeacher = courseTeacher;
    }

    public String getCourseEditor() {
        return courseEditor;
    }

    public void setCourseEditor(String courseEditor) {
        this.courseEditor = courseEditor;
    }

    public String getCoursePublishTime() {
        return coursePublishTime;
    }

    public void setCoursePublishTime(String coursePublishTime) {
        this.coursePublishTime = coursePublishTime;
    }

    public String getCourseVideourl() {
        return courseVideourl;
    }

    public void setCourseVideourl(String courseVideourl) {
        this.courseVideourl = courseVideourl;
    }

    public String getCourseIntroduce() {
        return courseIntroduce;
    }

    public void setCourseIntroduce(String courseIntroduce) {
        this.courseIntroduce = courseIntroduce;
    }

    public String getCourseSort() {
        return courseSort;
    }

    public void setCourseSort(String courseSort) {
        this.courseSort = courseSort;
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
