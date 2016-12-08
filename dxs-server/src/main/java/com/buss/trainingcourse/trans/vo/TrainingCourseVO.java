package com.buss.trainingcourse.trans.vo;

import com.buss.trainingcourse.entity.TrainingCourseEntity;
import com.buss.trainonlinecourse.entity.TrainOnlineCourseEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;


/**
 * @author lu
 * @date 2016-06-27 17:10:43
 * @version V1.0
 *
 */
@Mapping(entityClass=TrainOnlineCourseEntity.class)
public class TrainingCourseVO extends BaseVO {
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
