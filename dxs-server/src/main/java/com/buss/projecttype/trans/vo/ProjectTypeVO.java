package com.buss.projecttype.trans.vo;

import com.buss.projectarea.entity.ProjectAreaEntity;
import com.buss.projecttype.entity.ProjectTypeEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * @author lu
 * @date 2016-06-13 15:25:09
 * @version V1.0
 *
 */
@Mapping(entityClass=ProjectTypeEntity.class)
public class ProjectTypeVO extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**产品类型*/
    @Mapping
    private String projectType;
    /**编号*/
    @Mapping
    private String sort;

    public ProjectTypeVO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }
}
