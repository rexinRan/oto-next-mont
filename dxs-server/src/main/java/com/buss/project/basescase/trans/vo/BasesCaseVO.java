package com.buss.project.basescase.trans.vo;

import com.buss.project.bases.entity.BasesEntity;
import com.buss.project.basescase.entity.BasesCaseEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;


/**
 * @author lu
 * @date 2016-07-25 13:38:23
 * @version V1.0
 *
 */
@Mapping(entityClass=BasesCaseEntity.class)
public class BasesCaseVO extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**基地主键*/
    @Mapping
    private String dbId;
    /**基地图片文件*/
    @Mapping
    private String dbImgFid;
    /**图片地址*/
    @Mapping
    private String dbImgUrl;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDbId() {
        return dbId;
    }

    public void setDbId(String dbId) {
        this.dbId = dbId;
    }

    public String getDbImgFid() {
        return dbImgFid;
    }

    public void setDbImgFid(String dbImgFid) {
        this.dbImgFid = dbImgFid;
    }

    public String getDbImgUrl() {
        return dbImgUrl;
    }

    public void setDbImgUrl(String dbImgUrl) {
        this.dbImgUrl = dbImgUrl;
    }
}
