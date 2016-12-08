package com.buss.complanysponsor.trans.vo;

import com.buss.companypartnership.entity.CompanyPartnershipEntity;
import com.buss.complanysponsor.entity.DxsComplanySponsorEntity;
import org.jweb.core.bean.BaseVO;
import org.jweb.core.bean.annotation.Mapping;

import java.util.Date;


/**
 * @author lu
 * @date 2016-06-01 13:38:23
 * @version V1.0
 *
 */
@Mapping(entityClass= DxsComplanySponsorEntity.class)
public class DxsComplanySponsorVO extends BaseVO {
    /**主键*/
    @Mapping
    private String id;
    /**申请人的ID*/
    @Mapping
    private String userId;
    /**企业log*/
    @Mapping
    private String logAddress;
    /**公司名称*/
    @Mapping
    private String complanyName;
    /**公司网址*/
    @Mapping
    private String complanyWebAddress;
    /**所属行业*/
    @Mapping
    private String complanyField;
    /**办公地点*/
    @Mapping
    private String complanyRealAddress;
    /**微信公众号*/
    @Mapping
    private String complanyWeixin;
    /**公司简介*/
    @Mapping
    private String complanyIntroduce;
    /**公司规模*/
    @Mapping
    private String complanyNum;
    /**营业执照图*/
    @Mapping
    private String complanyLicenseImg;
    /**营业执照编号*/
    @Mapping
    private Integer complanyLicenseNum;
    /**身份证号*/
    @Mapping
    private String complanyIdcard;
    /**身份证正面文件id*/
    @Mapping
    private java.lang.String complanyIdcardImg1Fid;
    /**身份证正面URL*/
    @Mapping
    private java.lang.String complanyIdcardImg1Url;
    /**身份证反面文件id*/
    @Mapping
    private java.lang.String complanyIdcardImg2Fid;
    /**身份证反面URL*/
    @Mapping
    private java.lang.String complanyIdcardImg2Url;
    /**赞助活动*/
    @Mapping
    private String complanyActive;
    /**联系人姓名*/
    @Mapping
    private String contactsName;
    /**联系人职位*/
    @Mapping
    private String contentsJob;
    /**单位介绍函*/
    @Mapping
    private String contentsLetter;
    /**联系人邮箱*/
    @Mapping
    private String contactsEmail;
    /**联系人单位座机*/
    @Mapping
    private String contentsTel;
    /**联系人手机号*/
    @Mapping
    private String contentIphone;
    /**联系人QQ*/
    @Mapping
    private String contentQq;
    /**创建时间*/
    @Mapping
    private Date createTime;
    /**更新时间*/
    @Mapping
    private Date updateTime;
    /**删除标志*/
    @Mapping
    private Integer isDelete;

    public String getComplanyIdcardImg1Fid() {
        return complanyIdcardImg1Fid;
    }

    public void setComplanyIdcardImg1Fid(String complanyIdcardImg1Fid) {
        this.complanyIdcardImg1Fid = complanyIdcardImg1Fid;
    }

    public String getComplanyIdcardImg1Url() {
        return complanyIdcardImg1Url;
    }

    public void setComplanyIdcardImg1Url(String complanyIdcardImg1Url) {
        this.complanyIdcardImg1Url = complanyIdcardImg1Url;
    }

    public String getComplanyIdcardImg2Fid() {
        return complanyIdcardImg2Fid;
    }

    public void setComplanyIdcardImg2Fid(String complanyIdcardImg2Fid) {
        this.complanyIdcardImg2Fid = complanyIdcardImg2Fid;
    }

    public String getComplanyIdcardImg2Url() {
        return complanyIdcardImg2Url;
    }

    public void setComplanyIdcardImg2Url(String complanyIdcardImg2Url) {
        this.complanyIdcardImg2Url = complanyIdcardImg2Url;
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

    public String getLogAddress() {
        return logAddress;
    }

    public void setLogAddress(String logAddress) {
        this.logAddress = logAddress;
    }

    public String getComplanyName() {
        return complanyName;
    }

    public void setComplanyName(String complanyName) {
        this.complanyName = complanyName;
    }

    public String getComplanyWebAddress() {
        return complanyWebAddress;
    }

    public void setComplanyWebAddress(String complanyWebAddress) {
        this.complanyWebAddress = complanyWebAddress;
    }

    public String getComplanyField() {
        return complanyField;
    }

    public void setComplanyField(String complanyField) {
        this.complanyField = complanyField;
    }

    public String getComplanyRealAddress() {
        return complanyRealAddress;
    }

    public void setComplanyRealAddress(String complanyRealAddress) {
        this.complanyRealAddress = complanyRealAddress;
    }

    public String getComplanyWeixin() {
        return complanyWeixin;
    }

    public void setComplanyWeixin(String complanyWeixin) {
        this.complanyWeixin = complanyWeixin;
    }

    public String getComplanyIntroduce() {
        return complanyIntroduce;
    }

    public void setComplanyIntroduce(String complanyIntroduce) {
        this.complanyIntroduce = complanyIntroduce;
    }

    public String getComplanyNum() {
        return complanyNum;
    }

    public void setComplanyNum(String complanyNum) {
        this.complanyNum = complanyNum;
    }

    public String getComplanyLicenseImg() {
        return complanyLicenseImg;
    }

    public void setComplanyLicenseImg(String complanyLicenseImg) {
        this.complanyLicenseImg = complanyLicenseImg;
    }

    public Integer getComplanyLicenseNum() {
        return complanyLicenseNum;
    }

    public void setComplanyLicenseNum(Integer complanyLicenseNum) {
        this.complanyLicenseNum = complanyLicenseNum;
    }

    public String getComplanyIdcard() {
        return complanyIdcard;
    }

    public void setComplanyIdcard(String complanyIdcard) {
        this.complanyIdcard = complanyIdcard;
    }

    public String getComplanyActive() {
        return complanyActive;
    }

    public void setComplanyActive(String complanyActive) {
        this.complanyActive = complanyActive;
    }

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }

    public String getContentsJob() {
        return contentsJob;
    }

    public void setContentsJob(String contentsJob) {
        this.contentsJob = contentsJob;
    }

    public String getContentsLetter() {
        return contentsLetter;
    }

    public void setContentsLetter(String contentsLetter) {
        this.contentsLetter = contentsLetter;
    }

    public String getContactsEmail() {
        return contactsEmail;
    }

    public void setContactsEmail(String contactsEmail) {
        this.contactsEmail = contactsEmail;
    }

    public String getContentsTel() {
        return contentsTel;
    }

    public void setContentsTel(String contentsTel) {
        this.contentsTel = contentsTel;
    }

    public String getContentIphone() {
        return contentIphone;
    }

    public void setContentIphone(String contentIphone) {
        this.contentIphone = contentIphone;
    }

    public String getContentQq() {
        return contentQq;
    }

    public void setContentQq(String contentQq) {
        this.contentQq = contentQq;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
