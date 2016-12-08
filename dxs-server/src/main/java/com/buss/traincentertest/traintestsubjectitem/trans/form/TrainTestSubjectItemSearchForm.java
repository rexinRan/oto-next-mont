package com.buss.traincentertest.traintestsubjectitem.trans.form;

import com.buss.traincentertest.traintestsubject.entity.TrainTestSubjectEntity;
import com.buss.traincentertest.traintestsubjectitem.entity.TrainTestSubjectItemEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;


/**
 * @author lu
 * @date 2016-06-27 17:10:43
 * @version V1.0
 *
 */
@Mapping(entityClass=TrainTestSubjectItemEntity.class)
public class TrainTestSubjectItemSearchForm extends SearchForm {
    /**主键*/
    @Mapping
    private String id;
    /**试题ID*/
    @Mapping
    private String ttsId;
    /**试题项内容*/
    @Mapping
    private String itemName;
    /**测试偏向*/
    @Mapping
    private String itemObject;
    /**编号*/
    @Mapping
    private String sort;
    /**创建时间*/
    @Mapping
    private String createTime;
    /**更新时间*/
    @Mapping
    private String updateTime;
    /**删除标志*/
    @Mapping
    private String isDelete;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTtsId() {
        return ttsId;
    }

    public void setTtsId(String ttsId) {
        this.ttsId = ttsId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getItemObject() {
        return itemObject;
    }

    public void setItemObject(String itemObject) {
        this.itemObject = itemObject;
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
}
