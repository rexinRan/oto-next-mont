package com.buss.specialrecruitapply.trans.vo;

import com.buss.specialrecruitapply.entity.SpecialRecruitApplyEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by HongXinGuoJi-yzg on 2016/8/11.
 */
@Mapping(entityClass = SpecialRecruitApplyEntity.class)
public class SpecialRecruitApplyVo extends BaseVO{
    /**
     * 主键
     */
    @Mapping
    private java.lang.String id;
    /**
     * 申请企业id
     */
    @Mapping
    private java.lang.String userId;
    /**
     * 专场id
     */
    @Mapping
    private java.lang.String srId;
    /**
     * 招聘省份
     */
    @Mapping
    private java.lang.String privince;
    /**
     * 招聘方向
     */
    @Mapping
    private java.lang.String employDirection;
    /**
     * 招聘院校
     */
    @Mapping
    private java.lang.String employSchool;
    /**
     * 岗位文件id
     */
    @Mapping
    private java.lang.String fileId;
    /**
     * 是否处理
     */
    @Mapping
    private java.lang.String isHandle;
    /**
     * 创建时间
     */
    @Mapping
    private java.lang.String createTime;
    /**
     * 更新时间
     */
    @Mapping
    private java.lang.String updateTime;
    /**
     * 删除标志
     */
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

    public String getSrId() {
        return srId;
    }

    public void setSrId(String srId) {
        this.srId = srId;
    }

    public String getPrivince() {
        return privince;
    }

    public void setPrivince(String privince) {
        this.privince = privince;
    }

    public String getEmployDirection() {
        return employDirection;
    }

    public void setEmployDirection(String employDirection) {
        this.employDirection = employDirection;
    }

    public String getEmploySchool() {
        return employSchool;
    }

    public void setEmploySchool(String employSchool) {
        this.employSchool = employSchool;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getIsHandle() {
        return isHandle;
    }

    public void setIsHandle(String isHandle) {
        this.isHandle = isHandle;
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
