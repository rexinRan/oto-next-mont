package com.buss.activescustomcountry.trans.from;

import com.buss.activescustomcountry.entity.ActivesCustomCountryEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/8/1.
 */
@Mapping(entityClass = ActivesCustomCountryEntity.class)
public class ActivesCustomCountryFrom extends SearchForm{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**父类id*/
    @Mapping
    private java.lang.String pid;
    /**国家名字*/
    @Mapping
    private java.lang.String countryName;
    /**是否可用*/
    @Mapping
    private java.lang.String isTrue;
    /**价格*/
    @Mapping
    private java.lang.String countryPrice;
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

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getIsTrue() {
        return isTrue;
    }

    public void setIsTrue(String isTrue) {
        this.isTrue = isTrue;
    }

    public String getCountryPrice() {
        return countryPrice;
    }

    public void setCountryPrice(String countryPrice) {
        this.countryPrice = countryPrice;
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
