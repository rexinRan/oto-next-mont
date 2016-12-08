package com.buss.vote.trans.vo;

import com.buss.vote.entity.VoteEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

import java.util.Date;


/**
 * Created by Administrator on 2016/6/15.
 */
@Mapping(entityClass=VoteEntity.class)
public class VoteVO extends BaseVO{
    /**主键*/
    @Mapping
    private String id;
    /**用户id(admin)*/
    @Mapping
    private String userId;
    /**活动分类的id*/
    @Mapping
    private String voteId;
    /**活动标题*/
    @Mapping
    private String voteTitle;
    /**展示菜单*/
    @Mapping
    private String displayMenu;
    /**活动地点*/
    @Mapping
    private String voteAddress;
    /**主办单位*/
    @Mapping
    private String hostUnit;
    /**限报人数*/
    @Mapping
    private String limitedNumber;
    /**精彩回顾*/
    @Mapping
    private String histaryDate;
    /**截止投票时间*/
    @Mapping
    private String deadlineDate;
    /**活动开始时间*/
    @Mapping
    private String voteStateTime;
    /**活动结束时间*/
    @Mapping
    private String voteEndTime;
    /**活动对象*/
    @Mapping
    private String voteUsertypeId;
    /**活动内容*/
    @Mapping
    private String voteIntroduce;
    /**投票规则*/
    @Mapping
    private String voteRule;
    /**投票总人数*/
    @Mapping
    private String voteNum;
    /**投票总人数*/
    @Mapping
    private String voteCount;
    /**是否收费 0收费 1不收费*/
    @Mapping
    private String isCharge;
    /**可得到鸿鑫币数量*/
    @Mapping
    private String maxAccountCount;
    /**发布时间*/
    @Mapping
    private String publishTime;
    /**编辑人*/
    @Mapping
    private String activeEditor;
    /**投票活动图片*/
    @Mapping
    private String voteImage;
    /**备注*/
    @Mapping
    private String remarks;

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

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

    public String getVoteTitle() {
        return voteTitle;
    }

    public void setVoteTitle(String voteTitle) {
        this.voteTitle = voteTitle;
    }

    public String getDisplayMenu() {
        return displayMenu;
    }

    public void setDisplayMenu(String displayMenu) {
        this.displayMenu = displayMenu;
    }

    public String getVoteAddress() {
        return voteAddress;
    }

    public void setVoteAddress(String voteAddress) {
        this.voteAddress = voteAddress;
    }

    public String getHostUnit() {
        return hostUnit;
    }

    public void setHostUnit(String hostUnit) {
        this.hostUnit = hostUnit;
    }

    public String getLimitedNumber() {
        return limitedNumber;
    }

    public void setLimitedNumber(String limitedNumber) {
        this.limitedNumber = limitedNumber;
    }

    public String getHistaryDate() {
        return histaryDate;
    }

    public void setHistaryDate(String histaryDate) {
        this.histaryDate = histaryDate;
    }

    public String getDeadlineDate() {
        return deadlineDate;
    }

    public void setDeadlineDate(String deadlineDate) {
        this.deadlineDate = deadlineDate;
    }

    public String getVoteStateTime() {
        return voteStateTime;
    }

    public void setVoteStateTime(String voteStateTime) {
        this.voteStateTime = voteStateTime;
    }

    public String getVoteEndTime() {
        return voteEndTime;
    }

    public void setVoteEndTime(String voteEndTime) {
        this.voteEndTime = voteEndTime;
    }

    public String getVoteUsertypeId() {
        return voteUsertypeId;
    }

    public void setVoteUsertypeId(String voteUsertypeId) {
        this.voteUsertypeId = voteUsertypeId;
    }

    public String getVoteIntroduce() {
        return voteIntroduce;
    }

    public void setVoteIntroduce(String voteIntroduce) {
        this.voteIntroduce = voteIntroduce;
    }

    public String getVoteRule() {
        return voteRule;
    }

    public void setVoteRule(String voteRule) {
        this.voteRule = voteRule;
    }

    public String getVoteNum() {
        return voteNum;
    }

    public void setVoteNum(String voteNum) {
        this.voteNum = voteNum;
    }

    public String getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(String voteCount) {
        this.voteCount = voteCount;
    }

    public String getIsCharge() {
        return isCharge;
    }

    public void setIsCharge(String isCharge) {
        this.isCharge = isCharge;
    }

    public String getMaxAccountCount() {
        return maxAccountCount;
    }

    public void setMaxAccountCount(String maxAccountCount) {
        this.maxAccountCount = maxAccountCount;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getActiveEditor() {
        return activeEditor;
    }

    public void setActiveEditor(String activeEditor) {
        this.activeEditor = activeEditor;
    }

    public String getVoteImage() {
        return voteImage;
    }

    public void setVoteImage(String voteImage) {
        this.voteImage = voteImage;
    }
}
