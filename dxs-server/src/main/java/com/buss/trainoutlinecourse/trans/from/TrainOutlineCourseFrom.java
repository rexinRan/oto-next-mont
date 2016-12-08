package com.buss.trainoutlinecourse.trans.from;

import com.buss.trainoutlinecourse.entity.TrainOutlineCourseEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

import java.lang.String;

/**
 * Created by HongXinGuoJi-yzg on 2016/9/6.
 */
@Mapping(entityClass = TrainOutlineCourseEntity.class)
public class TrainOutlineCourseFrom extends SearchForm{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**分类id*/
    @Mapping
    private java.lang.String tccId;
    /**显示分类*/
    @Mapping
    private java.lang.String catalogDisplayNum;
    /**导师id*/
    @Mapping
    private java.lang.String userId;
    /**总课时数*/
    @Mapping
    private java.lang.String courseNumAll;
    /**总学习数*/
    @Mapping
    private java.lang.String courseMinutesAll;
    /**招生人数*/
    @Mapping
    private java.lang.String number;
    /**课程价格*/
    @Mapping
    private java.lang.String coursePrices;
    /**缩略图*/
    @Mapping
    private java.lang.String imgUrl;
    /**培训课题*/
    @Mapping
    private java.lang.String title;
    /**外部标记*/
    @Mapping
    private java.lang.String outSign;
    /**班号*/
    @Mapping
    private java.lang.String classNum;
    /**授课方式*/
    @Mapping
    private java.lang.String courseType;
    /**培训方式*/
    @Mapping
    private java.lang.String trainType;
    /**学费*/
    @Mapping
    private java.lang.String price;
    /**课程介绍*/
    @Mapping
    private java.lang.String courseIntroduce;
    /**适用学员*/
    @Mapping
    private java.lang.String courseObj;
    /**教学目标*/
    @Mapping
    private java.lang.String trainObj;
    /**授课内容*/
    @Mapping
    private java.lang.String trainContent;
    /**课程体系*/
    @Mapping
    private java.lang.String courseDir;
    /**开班时间*/
    @Mapping
    private java.lang.String openingTime;
    /**课程特色*/
    @Mapping
    private java.lang.String courseSpecial;
    /**开班规律*/
    @Mapping
    private java.lang.String startClassRule;
    /**地点简称*/
    @Mapping
    private java.lang.String addressShort;
    /**具体地点*/
    @Mapping
    private java.lang.String address;
    /**其他*/
    @Mapping
    private java.lang.String others;
    /**编号*/
    @Mapping
    private java.lang.String sort;
    /**创建时间*/
    @Mapping
    private java.lang.String createTime;
    /**更新时间*/
    @Mapping
    private java.lang.String upStringTime;
    /**删除标志*/
    @Mapping
    private java.lang.String isDelete;

    /**赠送鸿鑫币*/
    @Mapping
    private String account;
    /**备注*/
    @Mapping
    private String remarks;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

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

    public String getTccId() {
        return tccId;
    }

    public void setTccId(String tccId) {
        this.tccId = tccId;
    }

    public String getCatalogDisplayNum() {
        return catalogDisplayNum;
    }

    public void setCatalogDisplayNum(String catalogDisplayNum) {
        this.catalogDisplayNum = catalogDisplayNum;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCourseNumAll() {
        return courseNumAll;
    }

    public void setCourseNumAll(String courseNumAll) {
        this.courseNumAll = courseNumAll;
    }

    public String getCourseMinutesAll() {
        return courseMinutesAll;
    }

    public void setCourseMinutesAll(String courseMinutesAll) {
        this.courseMinutesAll = courseMinutesAll;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCoursePrices() {
        return coursePrices;
    }

    public void setCoursePrices(String coursePrices) {
        this.coursePrices = coursePrices;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOutSign() {
        return outSign;
    }

    public void setOutSign(String outSign) {
        this.outSign = outSign;
    }

    public String getClassNum() {
        return classNum;
    }

    public void setClassNum(String classNum) {
        this.classNum = classNum;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public String getTrainType() {
        return trainType;
    }

    public void setTrainType(String trainType) {
        this.trainType = trainType;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCourseIntroduce() {
        return courseIntroduce;
    }

    public void setCourseIntroduce(String courseIntroduce) {
        this.courseIntroduce = courseIntroduce;
    }

    public String getCourseObj() {
        return courseObj;
    }

    public void setCourseObj(String courseObj) {
        this.courseObj = courseObj;
    }

    public String getTrainObj() {
        return trainObj;
    }

    public void setTrainObj(String trainObj) {
        this.trainObj = trainObj;
    }

    public String getTrainContent() {
        return trainContent;
    }

    public void setTrainContent(String trainContent) {
        this.trainContent = trainContent;
    }

    public String getCourseDir() {
        return courseDir;
    }

    public void setCourseDir(String courseDir) {
        this.courseDir = courseDir;
    }

    public String getOpeningTime() {
        return openingTime;
    }

    public void setOpeningTime(String openingTime) {
        this.openingTime = openingTime;
    }

    public String getCourseSpecial() {
        return courseSpecial;
    }

    public void setCourseSpecial(String courseSpecial) {
        this.courseSpecial = courseSpecial;
    }

    public String getStartClassRule() {
        return startClassRule;
    }

    public void setStartClassRule(String startClassRule) {
        this.startClassRule = startClassRule;
    }

    public String getAddressShort() {
        return addressShort;
    }

    public void setAddressShort(String addressShort) {
        this.addressShort = addressShort;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others;
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

    public String getUpStringTime() {
        return upStringTime;
    }

    public void setUpStringTime(String upStringTime) {
        this.upStringTime = upStringTime;
    }

    public String getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(String isDelete) {
        this.isDelete = isDelete;
    }
}
