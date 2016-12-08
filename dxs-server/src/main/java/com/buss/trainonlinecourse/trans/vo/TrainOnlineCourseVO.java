package com.buss.trainonlinecourse.trans.vo;

import com.buss.trainingcourse.entity.TrainingCourseEntity;
import com.buss.trainonlinecourse.entity.TrainOnlineCourseEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;


/**
 * @author lu
 * @date 2016-06-27 17:10:43
 * @version V1.0
 *
 */
@Mapping(entityClass=TrainOnlineCourseEntity.class)
public class TrainOnlineCourseVO extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**分类id*/
    @Mapping
    private String tccId;
    /**显示分类*/
    @Mapping
    private String catalogDisplayNum;
    /**导师id*/
    @Mapping
    private String userId;
    /**总课时数*/
    @Mapping
    private String courseNumAll;
    /**总学习数*/
    @Mapping
    private String courseMinutesAll;
    /**课程价格*/
    @Mapping
    private String coursePrices;
    /**缩略图*/
    @Mapping
    private String imgUrl;
    /**培训课题*/
    @Mapping
    private String title;
    /**外部标记*/
    @Mapping
    private String outSign;
    /**班号*/
    @Mapping
    private String classNum;
    /**授课方式*/
    @Mapping
    private String courseType;
    /**培训方式*/
    @Mapping
    private String trainType;
    /**学费*/
    @Mapping
    private String price;
    /**课程介绍*/
    @Mapping
    private String courseIntroduce;
    /**适用学员*/
    @Mapping
    private String courseObj;
    /**教学目标*/
    @Mapping
    private String trainObj;
    /**授课内容*/
    @Mapping
    private String trainContent;
    /**课程体系*/
    @Mapping
    private String courseDir;
    /**课程特色*/
    @Mapping
    private String courseSpecial;
    /**开班规律*/
    @Mapping
    private String startClassRule;
    /**其他*/
    @Mapping
    private String others;
    /**赠送鸿鑫币*/
    @Mapping
    private String account;
    /**备注*/
    @Mapping
    private String remarks;
    /**编号*/
    @Mapping
    private String sort;
    /**所属专题*/
    @Mapping("trainCourseCatalog.catalogName")
    private String catalogName;



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


    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
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
}
