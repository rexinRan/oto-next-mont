package com.buss.newscatelog.trans.form;

import com.buss.newscatelog.entity.NewsCatelogEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;


/**

 * @author lu
 * @date 2016-06-01 13:37:58
 * @version V1.0
 *
 */
@Mapping(entityClass=NewsCatelogEntity.class)
public class NewsCatelogSearchForm extends SearchForm {
    /**主键*/
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
    /**新闻分类的创建时间*/
    @Mapping
    private String createTime;
    /**新闻分类的修改时间*/
    @Mapping
    private String updateTime;
    /**删除标志*/
    @Mapping
    private String isDelete;

    public NewsCatelogSearchForm() {
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

    public String getNewCatelogDescribe() {
        return newCatelogDescribe;
    }

    public void setNewCatelogDescribe(String newCatelogDescribe) {
        this.newCatelogDescribe = newCatelogDescribe;
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

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getNewCatelogPosition() {
        return newCatelogPosition;
    }

    public void setNewCatelogPosition(Integer newCatelogPosition) {
        this.newCatelogPosition = newCatelogPosition;
    }
}
