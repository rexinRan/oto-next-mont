package com.buss.news.trans.vo;

import com.buss.news.entity.NewsEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;


/**
 * @author lu
 * @date 2016-06-01 13:38:23
 * @version V1.0
 *
 */
@Mapping(entityClass=NewsEntity.class)
public class SimpleNewsVO extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**新闻标题*/
    @Mapping
    private String newTitle;

    public SimpleNewsVO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNewTitle() {
        return newTitle;
    }

    public void setNewTitle(String newTitle) {
        this.newTitle = newTitle;
    }
}
