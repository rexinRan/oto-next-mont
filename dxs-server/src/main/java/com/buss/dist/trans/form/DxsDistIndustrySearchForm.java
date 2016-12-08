package com.buss.dist.trans.form;

import com.buss.dist.entity.DxsDistIndustryEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/7/23.
 */
@Mapping(entityClass=DxsDistIndustryEntity.class)
public class DxsDistIndustrySearchForm extends SearchForm {
    /**主键*/
    private java.lang.String id;
    /**行业编号*/
    private java.lang.String industryNo;
    /**行业名称*/
    private java.lang.String industryName;
    /**父级编号*/
    @Mapping
    private java.lang.String parentNo;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIndustryNo() {
        return industryNo;
    }

    public void setIndustryNo(String industryNo) {
        this.industryNo = industryNo;
    }

    public String getIndustryName() {
        return industryName;
    }

    public void setIndustryName(String industryName) {
        this.industryName = industryName;
    }

    public String getParentNo() {
        return parentNo;
    }

    public void setParentNo(String parentNo) {
        this.parentNo = parentNo;
    }
}
