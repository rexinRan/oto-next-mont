package com.buss.resume.resumepapers.trans.vo;

import com.buss.resume.resumehonor.entity.ResumeHonorEntity;
import com.buss.resume.resumepapers.entity.ResumePapersEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * @author lu
 * @date 2016-06-21 11:12:54
 * @version V1.0
 *
 */
@Mapping(entityClass=ResumePapersEntity.class)
public class ResumePapersVO extends BaseVO{
    /**主键*/
    @Mapping
    private String id;
    /**简历id*/
    @Mapping
    private String resumeId;
    /**名称*/
    @Mapping
    private String name;
    /**类型*/
    @Mapping
    private String type;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
