package com.buss.employedcatalog.trans.vo;

import com.buss.employedcatalog.entity.EmployedCatalogEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**

 * @author lu
 * @date 2016-06-02 16:56:51
 * @version V1.0
 *
 */
@Mapping(entityClass=EmployedCatalogEntity.class)
public class EmployedCatalogVO extends BaseVO {

    /**主键*/
    @Mapping
    private String id;
    /**父级id*/
    @Mapping
    private String pid;
    /**就业分类名称*/
    @Mapping
    private String employedCatalogName;
    /**分类配图*/
    @Mapping
    private String employedImgurl;
    /**分类介绍*/
    @Mapping
    private String employedIntroduction;

    public EmployedCatalogVO() {
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

    public String getEmployedCatalogName() {
        return employedCatalogName;
    }

    public void setEmployedCatalogName(String employedCatalogName) {
        this.employedCatalogName = employedCatalogName;
    }

    public String getEmployedImgurl() {
        return employedImgurl;
    }

    public void setEmployedImgurl(String employedImgurl) {
        this.employedImgurl = employedImgurl;
    }

    public String getEmployedIntroduction() {
        return employedIntroduction;
    }

    public void setEmployedIntroduction(String employedIntroduction) {
        this.employedIntroduction = employedIntroduction;
    }


}
