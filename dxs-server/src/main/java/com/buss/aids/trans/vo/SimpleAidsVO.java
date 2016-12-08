package com.buss.aids.trans.vo;

import com.buss.aids.entity.AidsEntity;
import com.buss.news.entity.NewsEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;


/**
 * @author lu
 * @date 2016-06-01 13:38:23
 * @version V1.0
 *
 */
@Mapping(entityClass=AidsEntity.class)
public class SimpleAidsVO extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**扶贫标题*/
    @Mapping
    private String aidTitle;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAidTitle() {
        return aidTitle;
    }

    public void setAidTitle(String aidTitle) {
        this.aidTitle = aidTitle;
    }
}
