package com.buss.project.projectresult.trans.form;

import com.buss.project.projectresult.entity.ProjectResultEntity;
import com.buss.projectvote.entity.DxsProjectVoteEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;


/**
 * @author lu
 * @date 2016-06-06 11:48:24
 * @version V1.0
 *
 */
@Mapping(entityClass=ProjectResultEntity.class)
public class ProjectResultSearchForm extends SearchForm {
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
    /**结果说明*/
    @Mapping
    private String message;
    /**得分*/
    @Mapping
    private String score;
    /**初审(答辩)*/
    @Mapping
    private String type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
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
