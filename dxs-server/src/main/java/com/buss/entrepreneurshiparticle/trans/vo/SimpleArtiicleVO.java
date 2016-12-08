package com.buss.entrepreneurshiparticle.trans.vo;

import com.buss.entrepreneurshiparticle.entity.EntrepreneurshipArticleEntity;
import com.buss.news.entity.NewsEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

/**
 * @author lu
 * @date 2016-06-06 14:24:58
 * @version V1.0
 *
 */
@Mapping(entityClass=EntrepreneurshipArticleEntity.class)
public class SimpleArtiicleVO extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**创业中心文章标题*/
    @Mapping
    private String entrepreneurshipTitle;

    public String getEntrepreneurshipTitle() {
        return entrepreneurshipTitle;
    }

    public void setEntrepreneurshipTitle(String entrepreneurshipTitle) {
        this.entrepreneurshipTitle = entrepreneurshipTitle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
