package com.buss.activescompanies.trans.vo;

import com.buss.activescompanies.entity.ActivesCompaniesEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;

/**
 * Created by HongXinGuoJi-yzg on 2016/8/18.
 */
@Mapping(entityClass = ActivesCompaniesEntity.class)
public class ActivesCompaniesVo extends BaseVO{
    /**主键*/
    @Mapping
    private java.lang.String id;
    /**企业id(预留)*/
    @Mapping
    private java.lang.String companyUserId;
    /**活动id*/
    @Mapping
    private java.lang.String activeId;
    /**图片*/
    @Mapping
    private java.lang.String images;
    /**名企所属地*/
    @Mapping
    private java.lang.String companyAddress;
    /**大巴车牌号*/
    @Mapping
    private java.lang.String busNum;
    /**参观企业*/
    @Mapping
    private java.lang.String companyName;
    /**参观流程*/
    @Mapping
    private java.lang.String companyPropress;
    /**注意事项*/
    @Mapping
    private java.lang.String companyNotes;
    /**参观费用*/
    @Mapping
    private java.lang.String seeFree;
    /**创建时间*/
    @Mapping
    private java.lang.String createTime;
    /**更新时间*/
    @Mapping
    private java.lang.String updateTime;
    /**删除标志*/
    @Mapping
    private java.lang.String isDelete;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyUserId() {
        return companyUserId;
    }

    public void setCompanyUserId(String companyUserId) {
        this.companyUserId = companyUserId;
    }

    public String getActiveId() {
        return activeId;
    }

    public void setActiveId(String activeId) {
        this.activeId = activeId;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public void setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
    }

    public String getBusNum() {
        return busNum;
    }

    public void setBusNum(String busNum) {
        this.busNum = busNum;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyPropress() {
        return companyPropress;
    }

    public void setCompanyPropress(String companyPropress) {
        this.companyPropress = companyPropress;
    }

    public String getCompanyNotes() {
        return companyNotes;
    }

    public void setCompanyNotes(String companyNotes) {
        this.companyNotes = companyNotes;
    }

    public String getSeeFree() {
        return seeFree;
    }

    public void setSeeFree(String seeFree) {
        this.seeFree = seeFree;
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
