package com.buss.trainingcatalog.trans.vo;

import com.buss.trainingcatalog.entity.TrainingCatalogEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;


/**
 * @author lu
 * @date 2016-06-08 10:10:43
 * @version V1.0
 *
 */
@Mapping(entityClass=TrainingCatalogEntity.class)
public class TrainingCatalogVO extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**父级主键*/
    @Mapping
    private String pid;
    /**培训中心分类名称*/
    @Mapping
    private String trainingCatalogName;
    /**分类配图*/
    @Mapping
    private String trainingCatalogImg;
    /**分类简介*/
    @Mapping
    private String trainingCatalogIntroduction;

    public TrainingCatalogVO() {
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

    public String getTrainingCatalogName() {
        return trainingCatalogName;
    }

    public void setTrainingCatalogName(String trainingCatalogName) {
        this.trainingCatalogName = trainingCatalogName;
    }

    public String getTrainingCatalogImg() {
        return trainingCatalogImg;
    }

    public void setTrainingCatalogImg(String trainingCatalogImg) {
        this.trainingCatalogImg = trainingCatalogImg;
    }

    public String getTrainingCatalogIntroduction() {
        return trainingCatalogIntroduction;
    }

    public void setTrainingCatalogIntroduction(String trainingCatalogIntroduction) {
        this.trainingCatalogIntroduction = trainingCatalogIntroduction;
    }
}
