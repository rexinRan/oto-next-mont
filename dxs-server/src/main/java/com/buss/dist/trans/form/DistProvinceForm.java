package com.buss.dist.trans.form;

import com.buss.dist.entity.DxsDistProvinceEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/7/19.
 */
@Mapping(entityClass = DxsDistProvinceEntity.class)
public class DistProvinceForm extends SearchForm {

    /**主键*/
    @Mapping
    private String pid;
    /**省份ID*/
    @Mapping
    private String provinceid;
    /**省份名称*/
    @Mapping
    private String pname;

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getProvinceid() {
        return provinceid;
    }

    public void setProvinceid(String provinceid) {
        this.provinceid = provinceid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }
}
