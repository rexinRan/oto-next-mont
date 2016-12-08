package com.buss.aidthemeimage.trans.vo;

import com.buss.aidtheme.entity.AidThemeEntity;
import com.buss.aidthemeimage.entity.AidThemeImageEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;


/**
 * @author lu
 * @date 2016-06-01 13:38:23
 * @version V1.0
 *
 */
@Mapping(entityClass=AidThemeImageEntity.class)
public class AidThemeImageVO extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**主题主键*/
    @Mapping
    private String atId;
    /**图片地址*/
    @Mapping
    private String imgUrl;
    /**图片介绍*/
    @Mapping
    private String content;
    /**图片标题*/
    @Mapping
    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAtId() {
        return atId;
    }

    public void setAtId(String atId) {
        this.atId = atId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
