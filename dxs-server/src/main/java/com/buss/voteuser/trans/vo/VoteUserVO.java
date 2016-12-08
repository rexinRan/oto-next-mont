package com.buss.voteuser.trans.vo;

import com.buss.voteitem.entity.VoteItemEntity;
import com.buss.voteuser.entity.VoteUserEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

import java.util.Date;


/**
 * Created by Administrator on 2016/6/15.
 */
@Mapping(entityClass=VoteUserEntity.class)
public class VoteUserVO extends BaseVO{
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

    public String getViTime() {
        return viTime;
    }

    public void setViTime(String viTime) {
        this.viTime = viTime;
    }
}
