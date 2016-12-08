package com.buss.quizuser.trans.vo;

import com.buss.quizuser.entity.QuizUserEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;


import java.util.Set;

import java.util.Date;


/**
 * @author lu
 * @date 2016-06-08 09:51:18
 * @version V1.0
 *
 */
@Mapping(entityClass=QuizUserEntity.class)
public class QuizUserVO extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**用户id*/
    @Mapping
    private String userId;
    /**试卷id*/
    @Mapping
    private String quizId;
    /**结果处理类型*/
    @Mapping
    private String resulttype;
    /**结果*/
    @Mapping
    private String result;
    /**备注**/
    @Mapping
    private String remark;
    /**测试时间**/
    @Mapping
    private Date evaluationtime;
    /**结果报告地址*/
    @Mapping
    private String resultUrl;

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

    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public String getResulttype() {
        return resulttype;
    }

    public void setResulttype(String resulttype) {
        this.resulttype = resulttype;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getResultUrl() {
        return resultUrl;
    }

    public void setResultUrl(String resultUrl) {
        this.resultUrl = resultUrl;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getEvaluationtime() {
        return evaluationtime;
    }

    public void setEvaluationtime(Date evaluationtime) {
        this.evaluationtime = evaluationtime;
    }


}
