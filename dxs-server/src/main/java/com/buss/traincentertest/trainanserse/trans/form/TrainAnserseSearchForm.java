package com.buss.traincentertest.trainanserse.trans.form;

import com.buss.traincentertest.trainanserse.entity.TrainAnserseEntity;
import com.buss.traincentertest.traintest.entity.TrainTestEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;


/**
 * @author lu
 * @date 2016-06-27 17:10:43
 * @version V1.0
 *
 */
@Mapping(entityClass=TrainAnserseEntity.class)
public class TrainAnserseSearchForm extends SearchForm {
    /**主键*/
    @Mapping
    private String id;
    /**结果*/
    @Mapping
    private String result;
    /**试卷id*/
    @Mapping
    private String ttId;
    /**性格特征解析*/
    @Mapping
    private String characterAnalysis;
    /**性格类型*/
    @Mapping
    private String characterType;
    /**性格特质*/
    @Mapping
    private String characterTrait;
    /**适合从事*/
    @Mapping
    private String characterSuitible;
    /**代表人物及身份*/
    @Mapping
    private String symbol;
    /**代表人物头像*/
    @Mapping
    private String symbolImg;
    /**代表人物语录*/
    @Mapping
    private String symbolSay;
    /**基本描述*/
    @Mapping
    private String baseIntroduce;
    /**适合领域*/
    @Mapping
    private String suitField;
    /**适合岗位*/
    @Mapping
    private String sultJob;
    /**气质类型*/
    @Mapping
    private String temperamentType;
    /**总体描述*/
    @Mapping
    private String generalIntrodece;
    /**潜在弱点*/
    @Mapping
    private String weakness;
    /**优势*/
    @Mapping
    private String advantage;
    /**劣势*/
    @Mapping
    private String inferiority;
    /**创建时间*/
    @Mapping
    private String createTime;
    /**更新时间*/
    @Mapping
    private String updateTime;
    /**删除标志*/
    @Mapping
    private String isDelete;

    public String getSymbolImg() {
        return symbolImg;
    }

    public void setSymbolImg(String symbolImg) {
        this.symbolImg = symbolImg;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getTtId() {
        return ttId;
    }

    public void setTtId(String ttId) {
        this.ttId = ttId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCharacterAnalysis() {
        return characterAnalysis;
    }

    public void setCharacterAnalysis(String characterAnalysis) {
        this.characterAnalysis = characterAnalysis;
    }

    public String getCharacterType() {
        return characterType;
    }

    public void setCharacterType(String characterType) {
        this.characterType = characterType;
    }

    public String getCharacterTrait() {
        return characterTrait;
    }

    public void setCharacterTrait(String characterTrait) {
        this.characterTrait = characterTrait;
    }

    public String getCharacterSuitible() {
        return characterSuitible;
    }

    public void setCharacterSuitible(String characterSuitible) {
        this.characterSuitible = characterSuitible;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getSymbolSay() {
        return symbolSay;
    }

    public void setSymbolSay(String symbolSay) {
        this.symbolSay = symbolSay;
    }

    public String getBaseIntroduce() {
        return baseIntroduce;
    }

    public void setBaseIntroduce(String baseIntroduce) {
        this.baseIntroduce = baseIntroduce;
    }

    public String getSuitField() {
        return suitField;
    }

    public void setSuitField(String suitField) {
        this.suitField = suitField;
    }

    public String getSultJob() {
        return sultJob;
    }

    public void setSultJob(String sultJob) {
        this.sultJob = sultJob;
    }

    public String getTemperamentType() {
        return temperamentType;
    }

    public void setTemperamentType(String temperamentType) {
        this.temperamentType = temperamentType;
    }

    public String getGeneralIntrodece() {
        return generalIntrodece;
    }

    public void setGeneralIntrodece(String generalIntrodece) {
        this.generalIntrodece = generalIntrodece;
    }

    public String getWeakness() {
        return weakness;
    }

    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    public String getAdvantage() {
        return advantage;
    }

    public void setAdvantage(String advantage) {
        this.advantage = advantage;
    }

    public String getInferiority() {
        return inferiority;
    }

    public void setInferiority(String inferiority) {
        this.inferiority = inferiority;
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
