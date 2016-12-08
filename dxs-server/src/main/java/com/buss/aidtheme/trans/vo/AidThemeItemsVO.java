package com.buss.aidtheme.trans.vo;

import com.buss.aidactives.entity.AidActivesEntity;
import com.buss.aidtheme.entity.AidThemeEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

import java.util.List;
import java.util.Map;


/**
 * @author lu
 * @date 2016-06-01 13:38:23
 * @version V1.0
 *
 */
@Mapping(entityClass=AidThemeEntity.class)
public class AidThemeItemsVO extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**标题*/
    @Mapping
    private String title;
    /**banner图地址*/
    @Mapping
    private String bannerImg;
    /**详情页图片地址*/
    @Mapping
    private String detailImg;
    /**状态*/
    @Mapping
    private String state;
    /**目标金额*/
    @Mapping
    private String tagetMoney;
    /**已筹金额*/
    @Mapping
    private String existingMoney;
    /**开始时间*/
    @Mapping
    private String startTime;
    /**结束时间*/
    @Mapping
    private String endTime;
    /**捐款人数*/
    @Mapping
    private String number;
    /**项目说明*/
    private Map introduce;
    /**实施意义*/
    private Map meanings;
    /**项目内容*/
    private Map content;
    /**项目团队*/
    private Map team;
    /**项目执行*/
    private Map implement;
    /**使用说明*/
    private Map Instructions;
    /**发票说明*/
    private Map invoice;
    /**项目进展*/
    private List progress;
    /**关于我们*/
    private Map about;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBannerImg() {
        return bannerImg;
    }

    public void setBannerImg(String bannerImg) {
        this.bannerImg = bannerImg;
    }

    public String getDetailImg() {
        return detailImg;
    }

    public void setDetailImg(String detailImg) {
        this.detailImg = detailImg;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getTagetMoney() {
        return tagetMoney;
    }

    public void setTagetMoney(String tagetMoney) {
        this.tagetMoney = tagetMoney;
    }

    public String getExistingMoney() {
        return existingMoney;
    }

    public void setExistingMoney(String existingMoney) {
        this.existingMoney = existingMoney;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Map getIntroduce() {
        return introduce;
    }

    public void setIntroduce(Map introduce) {
        this.introduce = introduce;
    }

    public Map getMeanings() {
        return meanings;
    }

    public void setMeanings(Map meanings) {
        this.meanings = meanings;
    }

    public Map getContent() {
        return content;
    }

    public void setContent(Map content) {
        this.content = content;
    }

    public Map getTeam() {
        return team;
    }

    public void setTeam(Map team) {
        this.team = team;
    }

    public Map getImplement() {
        return implement;
    }

    public void setImplement(Map implement) {
        this.implement = implement;
    }

    public Map getInstructions() {
        return Instructions;
    }

    public void setInstructions(Map instructions) {
        Instructions = instructions;
    }

    public Map getInvoice() {
        return invoice;
    }

    public void setInvoice(Map invoice) {
        this.invoice = invoice;
    }

    public List getProgress() {
        return progress;
    }

    public void setProgress(List progress) {
        this.progress = progress;
    }

    public Map getAbout() {
        return about;
    }

    public void setAbout(Map about) {
        this.about = about;
    }
}
