package com.buss.project.projectusers.trans.vo;

import com.buss.project.projectresult.entity.ProjectResultEntity;
import com.buss.project.projectusers.entity.ProjectUsersEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;


/**
 * @author lu
 * @date 2016-06-06 11:48:24
 * @version V1.0
 *
 */
@Mapping(entityClass=ProjectUsersEntity.class)
public class ProjectUsersVO extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**项目id*/
    @Mapping
    private String projectId;
    /**用户id*/
    @Mapping
    private String userId;
    /**姓名*/
    @Mapping
    private String name;
    /**身份证号*/
    @Mapping
    private String idCard;
    /**类型*/
    @Mapping
    private String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
