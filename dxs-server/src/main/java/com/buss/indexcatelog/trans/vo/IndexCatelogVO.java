package com.buss.indexcatelog.trans.vo;

import com.buss.indexcatelog.entity.IndexCatelogEntity;
import com.buss.newscatelog.entity.NewsCatelogEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;


/**
 * @author lu
 * @date 2016-07-12 16:38:40
 * @version V1.0
 *
 */
@Mapping(entityClass=IndexCatelogEntity.class)
public class IndexCatelogVO extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**首页分类名称*/
    @Mapping
    private String indexCatelogName;
    /**首页分类描述*/
    @Mapping
    private String indexCatelogDescribe;
    /**首页分类配图*/
    @Mapping
    private String indexCatelogImg;
    /**排序*/
    @Mapping
    private String sort;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getIndexCatelogImg() {
        return indexCatelogImg;
    }

    public void setIndexCatelogImg(String indexCatelogImg) {
        this.indexCatelogImg = indexCatelogImg;
    }

    public String getIndexCatelogDescribe() {
        return indexCatelogDescribe;
    }

    public void setIndexCatelogDescribe(String indexCatelogDescribe) {
        this.indexCatelogDescribe = indexCatelogDescribe;
    }

    public String getIndexCatelogName() {
        return indexCatelogName;
    }

    public void setIndexCatelogName(String indexCatelogName) {
        this.indexCatelogName = indexCatelogName;
    }
}
