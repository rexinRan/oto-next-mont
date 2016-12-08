package com.buss.about.trans.vo;

import com.buss.about.entity.AboutConcernEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * @author dq
 * @date 2016/7/16.
 * @version V1.0
 */
@Mapping(entityClass=AboutConcernEntity.class)
public class AboutConcernVO extends BaseVO {

    /**主键*/
    @Mapping
    private String id;
    /**公司简介*/
    @Mapping
    private String concernImg;
    /**公司信息*/
    @Mapping
    private String concernContent;
    /**编号*/
    @Mapping
    private String sort;
    /**创建时间*/
    @Mapping
    private String createTime;
    /**更新时间*/
    @Mapping
    private String  updateTime;
    /**删除标志*/
    @Mapping
    private String isDelete;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getConcernImg() {
        return concernImg;
    }

    public void setConcernImg(String concernImg) {
        this.concernImg = concernImg;
    }

    public String getConcernContent() {
        return concernContent;
    }

    public void setConcernContent(String concernContent) {
        this.concernContent = concernContent;
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