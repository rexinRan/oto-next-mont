package com.buss.schoolpartnership.trans.vo;

import com.buss.schoolpartnership.entity.SchoolPartnershipImgsEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/7/27.
 */
@Mapping(entityClass = SchoolPartnershipImgsEntity.class)
public class SchoolPartnershipImgsVO extends BaseVO {
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**合作院校id*/
    @Mapping
    private java.lang.String spId;
    /**图片文件id*/
    @Mapping
    private java.lang.String spImgFid;
    /**图片访问地址*/
    @Mapping
    private java.lang.String spImgUrl;
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

    public String getSpId() {
        return spId;
    }

    public void setSpId(String spId) {
        this.spId = spId;
    }

    public String getSpImgFid() {
        return spImgFid;
    }

    public void setSpImgFid(String spImgFid) {
        this.spImgFid = spImgFid;
    }

    public String getSpImgUrl() {
        return spImgUrl;
    }

    public void setSpImgUrl(String spImgUrl) {
        this.spImgUrl = spImgUrl;
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
