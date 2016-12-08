package com.buss.project.projectresult.trans.vo;

import com.buss.project.projectresult.entity.ProjectResultEntity;
import com.buss.projectvote.entity.DxsProjectVoteEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;


/**
 * @author lu
 * @date 2016-06-06 11:48:24
 * @version V1.0
 *
 */
@Mapping(entityClass=ProjectResultEntity.class)
public class ProjectResultVO extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**项目id*/
    @Mapping
    private String pId;
    /**级别id*/
    @Mapping
    private String pcId;
    /**结果*/
    @Mapping
    private String result;
    /**初审(答辩)*/
    @Mapping
    private String type;
    /**结果说明*/
    @Mapping
    private String message;
    /**得分*/
    @Mapping
    private String score;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getPcId() {
        return pcId;
    }

    public void setPcId(String pcId) {
        this.pcId = pcId;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
