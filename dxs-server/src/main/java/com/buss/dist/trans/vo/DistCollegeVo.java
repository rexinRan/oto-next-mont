package com.buss.dist.trans.vo;

import com.buss.dist.entity.DxsDistCollegeEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/7/19.
 */
@Mapping(entityClass = DxsDistCollegeEntity.class)
public class DistCollegeVo extends BaseVO{

    /**主键*/
    @Mapping
    private String coid;
    /**大学名称*/
    @Mapping
    private String name;
    /**省份id*/
    @Mapping
    private String provinceid;

    public String getCoid() {
        return coid;
    }

    public void setCoid(String coid) {
        this.coid = coid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid;
    }
}
