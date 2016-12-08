package com.buss.trainonlinecourseuser.trans.vo;

import com.buss.project.bases.trans.vo.BasesVO;
import com.buss.trainonlinecourseuser.entity.TrainOnlineCourseUserEntity;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by HongXinGuoJi-yzg on 2016/9/27.
 */
@Mapping(entityClass = TrainOnlineCourseUserEntity.class)
public class TrainOnlineCourseUserVo extends BasesVO {
    /**主键*/
    @Mapping
    private String id;
    /**用户id*/
    @Mapping
    private String userId;
    /**课程id*/
    @Mapping
    private String tocId;
    /**报名类型*/
    @Mapping
    private String type;
    /**结果字段*/
    @Mapping
    private String result;
    /**备注*/
    @Mapping
    private String resume;
    /**创建时间*/
    @Mapping
    private String createTime;
    /**更新时间*/
    @Mapping
    private String upStringTime;
    /**删除标志*/
    @Mapping
    private String isDelete;

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTocId() {
        return tocId;
    }

    public void setTocId(String tocId) {
        this.tocId = tocId;
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

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpStringTime() {
        return upStringTime;
    }

    public void setUpStringTime(String upStringTime) {
        this.upStringTime = upStringTime;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
}
