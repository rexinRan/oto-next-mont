package com.buss.project.projectuser.trans.vo;

import com.buss.project.projectresult.entity.ProjectResultEntity;
import com.buss.project.projectuser.entity.ProjectUserEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;


/**
 * @author lu
 * @date 2016-06-06 11:48:24
 * @version V1.0
 *
 */
@Mapping(entityClass=ProjectUserEntity.class)
public class ProjectUserVO extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**项目ID*/
    @Mapping
    private String pId;
    /**用户ID*/
    @Mapping
    private String userId;
    /**成员姓名*/
    @Mapping
    private String userName;
    /**成员身份证号*/
    @Mapping
    private String userIdcard;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserIdcard() {
        return userIdcard;
    }

    public void setUserIdcard(String userIdcard) {
        this.userIdcard = userIdcard;
    }
}
