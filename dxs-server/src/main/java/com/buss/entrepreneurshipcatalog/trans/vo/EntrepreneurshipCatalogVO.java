package com.buss.entrepreneurshipcatalog.trans.vo;

import com.buss.entrepreneurshipcatalog.entity.EntrepreneurshipCatalogEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * @author lu
 * @date 2016-06-06 14:24:58
 * @version V1.0
 *
 */
@Mapping(entityClass=EntrepreneurshipCatalogEntity.class)
public class EntrepreneurshipCatalogVO extends BaseVO{
    /**主键*/
    @Mapping
    private String id;
    /**父节点*/
    @Mapping
    private String pid;
    /**创业中心分类*/
    @Mapping
    private String entrepreneurshipCatalogName;
    /**分类配图*/
    @Mapping
    private String entrepreneurshipImg;
    /**分类的简介*/
    @Mapping
    private String entrepreneurshipIntroduction;
    /**编码*/
    @Mapping
    private String sort;

    public EntrepreneurshipCatalogVO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getEntrepreneurshipCatalogName() {
        return entrepreneurshipCatalogName;
    }

    public void setEntrepreneurshipCatalogName(String entrepreneurshipCatalogName) {
        this.entrepreneurshipCatalogName = entrepreneurshipCatalogName;
    }

    public String getEntrepreneurshipImg() {
        return entrepreneurshipImg;
    }

    public void setEntrepreneurshipImg(String entrepreneurshipImg) {
        this.entrepreneurshipImg = entrepreneurshipImg;
    }

    public String getEntrepreneurshipIntroduction() {
        return entrepreneurshipIntroduction;
    }

    public void setEntrepreneurshipIntroduction(String entrepreneurshipIntroduction) {
        this.entrepreneurshipIntroduction = entrepreneurshipIntroduction;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
