package com.buss.traincentertest.traintestuser.trans.vo;

import com.buss.traincentertest.traintestsubject.entity.TrainTestSubjectEntity;
import com.buss.traincentertest.traintestsubjectitem.entity.TrainTestSubjectItemEntity;
import com.buss.traincentertest.traintestuser.entity.TrainTestUserEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

import java.util.List;


/**
 * @author lu
 * @date 2016-06-27 17:10:43
 * @version V1.0
 *
 */
@Mapping(entityClass=TrainTestUserEntity.class)
public class TrainTestUserVO extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**用户id*/
    @Mapping
    private String userId;
    /**试卷id*/
    @Mapping
    private String ttId;
    /**答案*/
    @Mapping
    private String answer;
    /**测试结果*/
    @Mapping
    private String result;
    /**备注*/
    @Mapping
    private String remarks;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

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

    public String getTtId() {
        return ttId;
    }

    public void setTtId(String ttId) {
        this.ttId = ttId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
