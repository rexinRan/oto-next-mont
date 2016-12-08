package com.buss.dist.trans.vo;

import com.buss.dist.entity.DxsDistAreaEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/7/19.
 */
@Mapping(entityClass = DxsDistAreaEntity.class)
public class DistAreaVo extends BaseVO{

    /**主键*/
    @Mapping
    private String aid;
    /**市区的id*/
    @Mapping
    private String areaid;
    /**市区名字*/
    @Mapping
    private String area;
    /**市id*/
    @Mapping
    private String cityid;

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getAreaid() {
        return areaid;
    }

    public void setAreaid(String areaid) {
        this.areaid = areaid;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }
}
