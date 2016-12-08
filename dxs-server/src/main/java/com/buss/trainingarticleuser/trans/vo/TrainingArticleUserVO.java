package com.buss.trainingarticleuser.trans.vo;

import com.buss.actives.entity.ActivesEntity;
import com.buss.actives.trans.vo.ActivesVO;
import com.buss.activity.entity.ActiveUserEntity;
import com.buss.trainingarticleuser.entity.TrainingArticleUserEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

import javax.persistence.Transient;

/**
 * @author lu
 * @date 2016-07-01 11:37:03
 * @version V1.0
 *
 */
@Mapping(entityClass= TrainingArticleUserEntity.class)
public class TrainingArticleUserVO extends BaseVO {
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
}
