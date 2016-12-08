package com.buss.quizitems.trans.vo;

import com.buss.quizitems.entity.QuizItemsEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * @author lu
 * @date 2016-06-08 09:51:18
 * @version V1.0
 *
 */
@Mapping(entityClass=QuizItemsEntity.class)
public class QuizItemsVO extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**试卷主键*/
    @Mapping
    private String quizId;
    /**本题内容*/
    @Mapping
    private String quizItemContent;
    /**本题答案*/
    @Mapping
    private String quizItemAnswer;
    /**本题解析*/
    @Mapping
    private String quizItemAnswerIntroduce;
    /**编号*/
    @Mapping
    private String sort;

    public QuizItemsVO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public String getQuizItemContent() {
        return quizItemContent;
    }

    public void setQuizItemContent(String quizItemContent) {
        this.quizItemContent = quizItemContent;
    }

    public String getQuizItemAnswer() {
        return quizItemAnswer;
    }

    public void setQuizItemAnswer(String quizItemAnswer) {
        this.quizItemAnswer = quizItemAnswer;
    }

    public String getQuizItemAnswerIntroduce() {
        return quizItemAnswerIntroduce;
    }

    public void setQuizItemAnswerIntroduce(String quizItemAnswerIntroduce) {
        this.quizItemAnswerIntroduce = quizItemAnswerIntroduce;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
