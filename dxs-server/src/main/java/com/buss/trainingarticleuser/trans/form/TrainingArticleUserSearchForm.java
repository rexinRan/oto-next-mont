package com.buss.trainingarticleuser.trans.form;

import com.buss.trainingarticleuser.entity.TrainingArticleUserEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * @author lu
 * @date 2016-07-01 11:37:03
 * @version V1.0
 *
 */
@Mapping(entityClass= TrainingArticleUserEntity.class)
public class TrainingArticleUserSearchForm extends SearchForm {
    /**主键id*/
    @Mapping
    private String id;
    /**用户id*/
    @Mapping
    private String userId;
    /**培训文章id*/
    @Mapping
    private String trainingArticleId;
    /**申请结果*/
    @Mapping
    private String result;
    /**申请时间*/
    @Mapping
    private String applyTime;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTrainingArticleId() {
        return trainingArticleId;
    }

    public void setTrainingArticleId(String trainingArticleId) {
        this.trainingArticleId = trainingArticleId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getApplyTime() {
        return applyTime;
    }

    public void setApplyTime(String applyTime) {
        this.applyTime = applyTime;
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
