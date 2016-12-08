package com.buss.specialsobj.trans.from;

import com.buss.specialsobj.entity.SpecialsObjEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/8/5.
 */
@Mapping(entityClass = SpecialsObjEntity.class)
public class SpecialsObjFrom extends SearchForm{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**用户id*/
    @Mapping
    private java.lang.String userId;
    /**选聘简章id*/
    @Mapping
    private java.lang.String shId;
    /**申请省*/
    @Mapping
    private java.lang.String objAddressProvince;
    /**申请市*/
    @Mapping
    private java.lang.String objAddressCity;
    /**申请项目*/
    @Mapping
    private java.lang.String objProject;
    /**申请类型*/
    @Mapping
    private java.lang.String type;
    /**申请结果*/
    @Mapping
    private java.lang.String result;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getShId() {
        return shId;
    }

    public void setShId(String shId) {
        this.shId = shId;
    }

    public String getObjAddressProvince() {
        return objAddressProvince;
    }

    public void setObjAddressProvince(String objAddressProvince) {
        this.objAddressProvince = objAddressProvince;
    }

    public String getObjAddressCity() {
        return objAddressCity;
    }

    public void setObjAddressCity(String objAddressCity) {
        this.objAddressCity = objAddressCity;
    }

    public String getObjProject() {
        return objProject;
    }

    public void setObjProject(String objProject) {
        this.objProject = objProject;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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
