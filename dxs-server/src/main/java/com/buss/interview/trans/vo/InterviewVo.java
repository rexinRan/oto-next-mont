package com.buss.interview.trans.vo;

import com.buss.news.entity.NewsEntity;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/6/25.
 */
@Mapping(entityClass=InterviewVo.class)
public class InterviewVo  {

    /**主键*/
    @Mapping
    private java.lang.String id;
    /**投送简历的id*/
    @Mapping
    private java.lang.String resumeUserId;
    /**标题*/
    @Mapping
    private java.lang.String title;
    /**内容*/
    @Mapping
    private java.lang.String content;
    /**面试邀请结果*/
    @Mapping
    private java.lang.String result;
    /**创建时间*/
    @Mapping
    private java.lang.String createTime;
    /**更新时间*/
    @Mapping
    private java.lang.String upStringTime;
    /**删除标志*/
    @Mapping
    private java.lang.String isDelete;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResumeUserId() {
        return resumeUserId;
    }

    public void setResumeUserId(String resumeUserId) {
        this.resumeUserId = resumeUserId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
