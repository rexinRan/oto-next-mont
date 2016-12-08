package com.buss.activescustommode.trans.vo;

import com.buss.activescustommode.entity.ActivesCustomModeEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/8/1.
 */
@Mapping(entityClass = ActivesCustomModeEntity.class)
public class ActivesCustomModeVo extends BaseVO{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**住所方式*/
    @Mapping
    private java.lang.String name;
    /**价格*/
    @Mapping
    private java.lang.String price;
    /**是否有效*/
    @Mapping
    private java.lang.String isTrue;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getIsTrue() {
        return isTrue;
    }

    public void setIsTrue(String isTrue) {
        this.isTrue = isTrue;
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
