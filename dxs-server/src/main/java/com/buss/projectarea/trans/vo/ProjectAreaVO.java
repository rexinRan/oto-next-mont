package com.buss.projectarea.trans.vo;

import com.buss.projectarea.entity.ProjectAreaEntity;
import com.buss.quiz.entity.QuizEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * @author lu
 * @date 2016-06-13 15:25:09
 * @version V1.0
 *
 */
@Mapping(entityClass=ProjectAreaEntity.class)
public class ProjectAreaVO extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**领域名称*/
    @Mapping
    private String areaName;
    /**编号*/
    @Mapping
    private Integer sort;

    public ProjectAreaVO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
