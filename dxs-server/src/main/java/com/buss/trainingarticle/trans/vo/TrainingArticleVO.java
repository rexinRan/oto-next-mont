package com.buss.trainingarticle.trans.vo;

import com.buss.news.entity.NewsEntity;
import com.buss.trainingarticle.entity.TrainingArticleEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;


/**
 * @author lu
 * @date 2016-06-08 10:10:07
 * @version V1.0
 *
 */
@Mapping(entityClass= TrainingArticleEntity.class)
public class TrainingArticleVO extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**培训中心分类id*/
    @Mapping
    private String trainingCatelogId;
    /**培训中心文章标题*/
    @Mapping
    private String trainingTitle;
    /**编辑人*/
    @Mapping
    private String trainingEditor;
    /**发布时间*/
    @Mapping
    private String trainingPublishTime;
    /**缩略图*/
    @Mapping
    private String trainingImgurl;
    /**培训中心文章内容*/
    @Mapping
    private String trainingContents;
    /**编号*/
    @Mapping
    private String trainingSort;

    public TrainingArticleVO() {
    }

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

    public String getTrainingTitle() {
        return trainingTitle;
    }

    public void setTrainingTitle(String trainingTitle) {
        this.trainingTitle = trainingTitle;
    }

    public String getTrainingEditor() {
        return trainingEditor;
    }

    public void setTrainingEditor(String trainingEditor) {
        this.trainingEditor = trainingEditor;
    }

    public String getTrainingPublishTime() {
        return trainingPublishTime;
    }

    public void setTrainingPublishTime(String trainingPublishTime) {
        this.trainingPublishTime = trainingPublishTime;
    }

    public String getTrainingImgurl() {
        return trainingImgurl;
    }

    public void setTrainingImgurl(String trainingImgurl) {
        this.trainingImgurl = trainingImgurl;
    }

    public String getTrainingContents() {
        return trainingContents;
    }

    public void setTrainingContents(String trainingContents) {
        this.trainingContents = trainingContents;
    }

    public String getTrainingSort() {
        return trainingSort;
    }

    public void setTrainingSort(String trainingSort) {
        this.trainingSort = trainingSort;
    }
}
