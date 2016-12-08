package com.buss.project.foundcases.trans.vo;

import com.buss.project.foundcases.entity.FoundCaseEntity;
import com.buss.project.founds.entity.FoundEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;


/**
 * @author lu
 * @date 2016-07-25 13:38:23
 * @version V1.0
 *
 */
@Mapping(entityClass=FoundCaseEntity.class)
public class FoundCaseVO extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**基金的id*/
    @Mapping
    private String dfId;
    /**案例缩图*/
    @Mapping
    private String dfImgUrl;
    /**成功案例的名称*/
    @Mapping
    private String dfName;
    /**案例缩图id*/
    @Mapping
    private String dfImgFid;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDfId() {
        return dfId;
    }

    public void setDfId(String dfId) {
        this.dfId = dfId;
    }

    public String getDfName() {
        return dfName;
    }

    public void setDfName(String dfName) {
        this.dfName = dfName;
    }

    public String getDfImgFid() {
        return dfImgFid;
    }

    public void setDfImgFid(String dfImgFid) {
        this.dfImgFid = dfImgFid;
    }

    public String getDfImgUrl() {
        return dfImgUrl;
    }

    public void setDfImgUrl(String dfImgUrl) {
        this.dfImgUrl = dfImgUrl;
    }
}
