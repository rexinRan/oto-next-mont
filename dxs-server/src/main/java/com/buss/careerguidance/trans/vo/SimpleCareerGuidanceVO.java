package com.buss.careerguidance.trans.vo;

import com.buss.careerguidance.entity.CareerGuidanceEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;


/**
 * @author lu
 * @date 2016-06-08 10:10:43
 * @version V1.0
 *
 */
@Mapping(entityClass=CareerGuidanceEntity.class)
public class SimpleCareerGuidanceVO extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**职场引导标题*/
    @Mapping
    private String cgTitle;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCgTitle() {
        return cgTitle;
    }

    public void setCgTitle(String cgTitle) {
        this.cgTitle = cgTitle;
    }
}
