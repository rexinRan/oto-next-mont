package com.buss.project.foundcases.trans.form;

import com.buss.project.foundcases.entity.FoundCaseEntity;
import com.buss.project.founds.entity.FoundEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;
import org.jweb.core.query.annotation.QueryStrategy;


/**
 * @author lu
 * @date 2016-07-25 13:38:23
 * @version V1.0
 *
 */
@Mapping(entityClass=FoundCaseEntity.class)
public class FoundCaseSearchForm extends SearchForm {
    /**主键*/
    @Mapping
    private String id;
    /**基金的id*/
    @Mapping
    private String dfId;
    /**成功案例的名称*/
    @Mapping
    private String dfName;
    /**案例缩图id*/
    @Mapping
    private String dfImgFid;
    /**案例缩图*/
    @Mapping
    private String dfImgUrl;
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

    public String getDfId() {
        return dfId;
    }

    public void setDfId(String dfId) {
        this.dfId = dfId;
    }

    public String getDfName() {
        return dfName;
    }

    public void setDfName(String dfName) {
        this.dfName = dfName;
    }

    public String getDfImgFid() {
        return dfImgFid;
    }

    public void setDfImgFid(String dfImgFid) {
        this.dfImgFid = dfImgFid;
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

    public String getDfImgUrl() {
        return dfImgUrl;
    }

    public void setDfImgUrl(String dfImgUrl) {
        this.dfImgUrl = dfImgUrl;
    }
}