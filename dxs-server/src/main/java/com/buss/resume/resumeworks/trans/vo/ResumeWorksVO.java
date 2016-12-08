package com.buss.resume.resumeworks.trans.vo;

import com.buss.resume.resumehonor.entity.ResumeHonorEntity;
import com.buss.resume.resumeworks.entity.ResumeWorksEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * @author lu
 * @date 2016-06-21 11:12:54
 * @version V1.0
 *
 */
@Mapping(entityClass=ResumeWorksEntity.class)
public class ResumeWorksVO extends BaseVO{
    /**主键*/
    @Mapping
    private String id;
    /**简历id*/
    @Mapping
    private String resumeId;
    /**作品名称*/
    @Mapping
    private String workName;
    /**时间*/
    @Mapping
    private String workFinishTime;
    /**副标题*/
    @Mapping
    private String workName2;
    /**描述*/
    @Mapping
    private String workIntroduce;
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

    public String getWorkName() {
        return workName;
    }

    public void setWorkName(String workName) {
        this.workName = workName;
    }

    public String getWorkFinishTime() {
        return workFinishTime;
    }

    public void setWorkFinishTime(String workFinishTime) {
        this.workFinishTime = workFinishTime;
    }

    public String getWorkName2() {
        return workName2;
    }

    public void setWorkName2(String workName2) {
        this.workName2 = workName2;
    }

    public String getWorkIntroduce() {
        return workIntroduce;
    }

    public void setWorkIntroduce(String workIntroduce) {
        this.workIntroduce = workIntroduce;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
}
