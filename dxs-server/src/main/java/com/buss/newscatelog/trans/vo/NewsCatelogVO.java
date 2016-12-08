package com.buss.newscatelog.trans.vo;

import com.buss.newscatelog.entity.NewsCatelogEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;


/**

 * @author lu
 * @date 2016-06-01 13:37:58
 * @version V1.0
 *
 */
@Mapping(entityClass=NewsCatelogEntity.class)
public class NewsCatelogVO extends BaseVO {
    @Mapping
    private String id;

    /**新闻分类的名称*/
    @Mapping
    private String newCatelogName;
    /**新闻分类的描述*/
    @Mapping
    private String newCatelogDescribe;
    /**新闻分类的配图*/
    @Mapping
    private String newCatelogImg;
    /**排序*/
    @Mapping
    private String sort;
    /**新闻分类显示位置*/
    @Mapping
    private Integer newCatelogPosition  ;

    public NewsCatelogVO() {
    }

    public NewsCatelogVO(String id, String newCatelogName, String newCatelogDescribe, String newCatelogImg, String createTime, String updateTime, String isDelete, String sort) {
        this.id = id;
        this.newCatelogName = newCatelogName;
        this.newCatelogDescribe = newCatelogDescribe;
        this.newCatelogImg = newCatelogImg;
        this.sort = sort;
    }

    public String getNewCatelogDescribe() {
        return newCatelogDescribe;
    }

    public void setNewCatelogDescribe(String newCatelogDescribe) {
        this.newCatelogDescribe = newCatelogDescribe;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNewCatelogName() {
        return newCatelogName;
    }

    public void setNewCatelogName(String newCatelogName) {
        this.newCatelogName = newCatelogName;
    }

    public String getNewCatelogImg() {
        return newCatelogImg;
    }

    public void setNewCatelogImg(String newCatelogImg) {
        this.newCatelogImg = newCatelogImg;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public Integer getNewCatelogPosition() {
        return newCatelogPosition;
    }

    public void setNewCatelogPosition(Integer newCatelogPosition) {
        this.newCatelogPosition = newCatelogPosition;
    }
}
