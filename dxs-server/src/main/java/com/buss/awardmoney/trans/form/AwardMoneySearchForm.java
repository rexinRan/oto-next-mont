package com.buss.awardmoney.trans.form;

import com.buss.actives.entity.ActivesEntity;
import com.buss.awardmoney.entity.AwardMoneyEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;


/**
 * @author lu
 * @date 2016-06-29 17:48:24
 * @version V1.0
 *
 */
@Mapping(entityClass=AwardMoneyEntity.class)
public class AwardMoneySearchForm extends SearchForm {
    /**主键*/
    @Mapping
    private String id;
    /**奖金类型（1 奖学金，2 助学金）*/
    @Mapping
    private String type;
    /**奖金申请通知*/
    @Mapping
    private String notice;
    /**编号（备用）*/
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNotice() {
        return notice;
    }

    public void setNotice(String notice) {
        this.notice = notice;
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
