package com.buss.voteuser.trans.form;

import com.buss.voteitem.entity.VoteItemEntity;
import com.buss.voteuser.entity.VoteUserEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/6/15.
 */
@Mapping(entityClass= VoteUserEntity.class)
public class VoteUserSearchForm extends SearchForm{
    /**主键*/
    @Mapping
    private String id;
    /**用户id*/
    @Mapping
    private String userId;
    /**投票id*/
    @Mapping
    private String voteId;
    /**投票项id*/
    @Mapping
    private String viItem;
    /**投票时间*/
    @Mapping
    private String viTime;
    /**当前投票数*/
    @Mapping
    private String viNum;
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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVoteId() {
        return voteId;
    }

    public void setVoteId(String voteId) {
        this.voteId = voteId;
    }

    public String getViItem() {
        return viItem;
    }

    public void setViItem(String viItem) {
        this.viItem = viItem;
    }

    public String getViNum() {
        return viNum;
    }

    public void setViNum(String viNum) {
        this.viNum = viNum;
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

    public String getViTime() {
        return viTime;
    }

    public void setViTime(String viTime) {
        this.viTime = viTime;
    }
}
