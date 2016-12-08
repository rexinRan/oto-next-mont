package com.buss.dist.trans.vo;

import com.buss.dist.entity.DxsDistSchoolEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/7/19.
 */
@Mapping(entityClass = DxsDistSchoolEntity.class)
public class DistSchoolVo extends BaseVO {

    /**主键*/
    @Mapping
    private String scid;
    /**院系名称*/
    @Mapping
    private String name;
    /**大学id*/
    @Mapping
    private String collegeid;

    public String getScid() {
        return scid;
    }

    public void setScid(String scid) {
        this.scid = scid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCollegeid() {
        return collegeid;
    }

    public void setCollegeid(String collegeid) {
        this.collegeid = collegeid;
    }
}
