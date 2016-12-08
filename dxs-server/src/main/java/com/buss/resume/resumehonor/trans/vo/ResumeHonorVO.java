package com.buss.resume.resumehonor.trans.vo;

import com.buss.resume.resumehonor.entity.ResumeHonorEntity;
import com.buss.resume.resumeschool.entity.ResumeSchoolEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * @author lu
 * @date 2016-06-21 11:12:54
 * @version V1.0
 *
 */
@Mapping(entityClass=ResumeHonorEntity.class)
public class ResumeHonorVO extends BaseVO{
    /**主键*/
    @Mapping
    private String id;
    /**简历id*/
    @Mapping
    private String resumeId;
    /**时间*/
    @Mapping
    private String time;
    /**标题(预留)*/
    @Mapping
    private String title;
    /**荣誉内容*/
    @Mapping
    private String content;
    /**图片*/
    @Mapping
    private String imgUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
