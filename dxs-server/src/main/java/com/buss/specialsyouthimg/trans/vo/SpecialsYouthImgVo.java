package com.buss.specialsyouthimg.trans.vo;

import com.buss.specialsyouthimg.entity.SpecialsYouthImgEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by JSADKFJ on 2016/8/14.
 */
@Mapping(entityClass = SpecialsYouthImgEntity.class)
public class SpecialsYouthImgVo extends BaseVO{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**图片集ID*/
    @Mapping
    private java.lang.String dsyiId;
    /**图片地址*/
    @Mapping
    private java.lang.String imgUrl;
    /**编号*/
    @Mapping
    private java.lang.String sort;
    /**创建时间*/
    @Mapping
    private java.lang.String createTime;
    /**更新时间*/
    @Mapping
    private java.lang.String updateTime;
    /**删除标志*/
    @Mapping
    private java.lang.String isDelete;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDsyiId() {
        return dsyiId;
    }

    public void setDsyiId(String dsyiId) {
        this.dsyiId = dsyiId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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
