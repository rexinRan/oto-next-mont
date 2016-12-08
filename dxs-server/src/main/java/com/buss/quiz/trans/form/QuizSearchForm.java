package com.buss.quiz.trans.form;

import com.buss.quiz.entity.QuizEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;



/**
 * @author lu
 * @date 2016-06-08 09:51:18
 * @version V1.0
 *
 */
@Mapping(entityClass=QuizEntity.class)
public class QuizSearchForm extends SearchForm {
    /**主键*/
    @Mapping
    private String id;
    /**培训分类id*/
    @Mapping
    private String trainingCatalogId;
    /**试卷名称*/
    @Mapping
    private String quizName;
    /**出题人*/
    @Mapping
    private String quizEditor;
    /**书卷介绍*/
    @Mapping
    private String quizIntroduction;
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

    public QuizSearchForm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTrainingCatalogId() {
        return trainingCatalogId;
    }

    public void setTrainingCatalogId(String trainingCatalogId) {
        this.trainingCatalogId = trainingCatalogId;
    }

    public String getQuizName() {
        return quizName;
    }

    public void setQuizName(String quizName) {
        this.quizName = quizName;
    }

    public String getQuizEditor() {
        return quizEditor;
    }

    public void setQuizEditor(String quizEditor) {
        this.quizEditor = quizEditor;
    }

    public String getQuizIntroduction() {
        return quizIntroduction;
    }

    public void setQuizIntroduction(String quizIntroduction) {
        this.quizIntroduction = quizIntroduction;
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