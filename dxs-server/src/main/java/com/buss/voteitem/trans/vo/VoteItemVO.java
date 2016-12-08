package com.buss.voteitem.trans.vo;

import com.buss.vote.entity.VoteEntity;
import com.buss.voteitem.entity.VoteItemEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

import java.util.Date;


/**
 * Created by Administrator on 2016/6/15.
 */
@Mapping(entityClass=VoteItemEntity.class)
public class VoteItemVO extends BaseVO{
    /**主键*/
    @Mapping
    private String id;
    /**投票id*/
    @Mapping
    private String voteId;
    /**投票项图片*/
    @Mapping
    private String itemImage;
    /**投票项图片*/
    @Mapping
    private String itemNum;
    /**投票项标题*/
    @Mapping
    private String viTitle;
    /**投票内容*/
    @Mapping
    private String viContent;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVoteId() {
        return voteId;
    }

    public void setVoteId(String voteId) {
        this.voteId = voteId;
    }

    public String getItemImage() {
        return itemImage;
    }

    public void setItemImage(String itemImage) {
        this.itemImage = itemImage;
    }

    public String getItemNum() {
        return itemNum;
    }

    public void setItemNum(String itemNum) {
        this.itemNum = itemNum;
    }

    public String getViTitle() {
        return viTitle;
    }

    public void setViTitle(String viTitle) {
        this.viTitle = viTitle;
    }

    public String getViContent() {
        return viContent;
    }

    public void setViContent(String viContent) {
        this.viContent = viContent;
    }
}
