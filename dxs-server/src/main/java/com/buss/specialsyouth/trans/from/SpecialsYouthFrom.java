package com.buss.specialsyouth.trans.from;

import com.buss.specialsyouth.entity.SpecialsYouthEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by Administrator on 2016/8/5.
 */
@Mapping(entityClass = SpecialsYouthEntity.class)
public class SpecialsYouthFrom extends SearchForm{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**用户id(预留)*/
    @Mapping
    private java.lang.String userId;
    /**所属分类*/
    @Mapping
    private java.lang.String type;
    /**头像*/
    @Mapping
    private java.lang.String headImgUrl;
    /**详情页图片*/
    @Mapping
    private java.lang.String detailImgUrl;
    /**姓名*/
    @Mapping
    private java.lang.String name;
    /**年龄*/
    @Mapping
    private java.lang.String age;
    /**政治面貌*/
    @Mapping
    private java.lang.String political;
    /**学历*/
    @Mapping
    private java.lang.String education;
    /**现在岗位*/
    @Mapping
    private java.lang.String persentPost;
    /**工作地点*/
    @Mapping
    private java.lang.String workPlace;
    /**专业*/
    @Mapping
    private java.lang.String major;
    /**毕业院校*/
    @Mapping
    private java.lang.String university;
    /**座右铭*/
    @Mapping
    private java.lang.String motto;
    /**个人简介*/
    @Mapping
    private java.lang.String profile;
    /**优秀事迹*/
    @Mapping
    private java.lang.String deeds;
    /**编号*/
    @Mapping
    private java.lang.String sort;
    /**创建时间*/
    @Mapping
    private java.lang.String createTime;
    /**更新时间*/
    @Mapping
    private java.lang.String updateTime;
    /**删除标志*/
    @Mapping
    private java.lang.String isDelete;
    /**风采展示图*/
    @Mapping
    private java.lang.String displayImg01Fid;
    /**风采展示图地址*/
    @Mapping
    private java.lang.String displayImg01Url;
    /**风采展示图*/
    @Mapping
    private java.lang.String displayImg02Fid;
    /**风采展示图地址*/
    @Mapping
    private java.lang.String displayImg02Url;
    /**风采展示图*/
    @Mapping
    private java.lang.String displayImg03Fid;
    /**风采展示图地址*/
    @Mapping
    private java.lang.String displayImg03Url;
    /**风采展示图*/
    @Mapping
    private java.lang.String displayImg04Fid;
    /**风采展示图地址*/
    @Mapping
    private java.lang.String displayImg04Url;
    /**风采展示图*/
    @Mapping
    private java.lang.String displayImg05Fid;
    /**风采展示图地址*/
    @Mapping
    private java.lang.String displayImg05Url;

    public String getDetailImgUrl() {
        return detailImgUrl;
    }

    public void setDetailImgUrl(String detailImgUrl) {
        this.detailImgUrl = detailImgUrl;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPolitical() {
        return political;
    }

    public void setPolitical(String political) {
        this.political = political;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getPersentPost() {
        return persentPost;
    }

    public void setPersentPost(String persentPost) {
        this.persentPost = persentPost;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getDeeds() {
        return deeds;
    }

    public void setDeeds(String deeds) {
        this.deeds = deeds;
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

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    public String getDisplayImg01Fid() {
        return displayImg01Fid;
    }

    public void setDisplayImg01Fid(String displayImg01Fid) {
        this.displayImg01Fid = displayImg01Fid;
    }

    public String getDisplayImg01Url() {
        return displayImg01Url;
    }

    public void setDisplayImg01Url(String displayImg01Url) {
        this.displayImg01Url = displayImg01Url;
    }

    public String getDisplayImg02Fid() {
        return displayImg02Fid;
    }

    public void setDisplayImg02Fid(String displayImg02Fid) {
        this.displayImg02Fid = displayImg02Fid;
    }

    public String getDisplayImg02Url() {
        return displayImg02Url;
    }

    public void setDisplayImg02Url(String displayImg02Url) {
        this.displayImg02Url = displayImg02Url;
    }

    public String getDisplayImg03Fid() {
        return displayImg03Fid;
    }

    public void setDisplayImg03Fid(String displayImg03Fid) {
        this.displayImg03Fid = displayImg03Fid;
    }

    public String getDisplayImg03Url() {
        return displayImg03Url;
    }

    public void setDisplayImg03Url(String displayImg03Url) {
        this.displayImg03Url = displayImg03Url;
    }

    public String getDisplayImg04Fid() {
        return displayImg04Fid;
    }

    public void setDisplayImg04Fid(String displayImg04Fid) {
        this.displayImg04Fid = displayImg04Fid;
    }

    public String getDisplayImg04Url() {
        return displayImg04Url;
    }

    public void setDisplayImg04Url(String displayImg04Url) {
        this.displayImg04Url = displayImg04Url;
    }

    public String getDisplayImg05Fid() {
        return displayImg05Fid;
    }

    public void setDisplayImg05Fid(String displayImg05Fid) {
        this.displayImg05Fid = displayImg05Fid;
    }

    public String getDisplayImg05Url() {
        return displayImg05Url;
    }

    public void setDisplayImg05Url(String displayImg05Url) {
        this.displayImg05Url = displayImg05Url;
    }
}
