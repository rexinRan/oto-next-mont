package com.buss.activescustomduration.trans.vo;

import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/8/1.
 */
@Mapping
public class ActivesCustomDurationVo extends BaseVO{
    /**id*/
    @Mapping
    private java.lang.String id;
    /**courseLang*/
    @Mapping
    private java.lang.String courseLang;
    /**isTrue*/
    @Mapping
    private java.lang.String isTrue;
    /**createTime*/
    @Mapping
    private java.lang.String createTime;
    /**updateTime*/
    @Mapping
    private java.lang.String updateTime;
    /**isDelete*/
    @Mapping
    private java.lang.String isDelete;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourseLang() {
        return courseLang;
    }

    public void setCourseLang(String courseLang) {
        this.courseLang = courseLang;
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
