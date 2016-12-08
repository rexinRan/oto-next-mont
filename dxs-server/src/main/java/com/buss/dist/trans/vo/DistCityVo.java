package com.buss.dist.trans.vo;

import com.buss.dist.entity.DxsDistCityEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/7/19.
 */
@Mapping(entityClass = DxsDistCityEntity.class)
public class DistCityVo extends BaseVO {

    /**主键*/
    @Mapping
    private String cid;
    /**市id*/
    @Mapping
    private String cityid;
    /**市区名称*/
    @Mapping
    private String city;
    /**省份id*/
    @Mapping
    private String provinceid;

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid;
    }
}
