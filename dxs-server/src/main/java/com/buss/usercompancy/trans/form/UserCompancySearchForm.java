package com.buss.usercompancy.trans.form;

import com.buss.usercompancy.entity.UserCompancyEntity;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.bean.annotation.Mapping;
import org.jweb.core.query.annotation.QueryStrategy;


/**
 * @author lu
 * @date 2016-06-15 11:24:55
 * @version V1.0
 *
 */
@Mapping(entityClass=UserCompancyEntity.class)
public class UserCompancySearchForm extends SearchForm {
    /**主键*/
    @Mapping
    private String id;
    /**用户id*/
    @Mapping
    private String userId;
    /**用户表主键*/
    @Mapping("userEntity.id")
    private String uId;
    /**真实姓名*/
    @Mapping("userEntity.realname")
    private String uRealname;
    /**用户角色*/
    @Mapping("userEntity.rolecode")
    private String uRolecode;
    /**手机号(老师/学生登录账号)*/
    @Mapping("userEntity.mphone")
    private String uMphone;
    /**密码*/
    @Mapping("userEntity.pwd")
    private String uPwd;
    /**电子邮箱(企业登录账号)*/
    @Mapping("userEntity.email")
    private String uEmail;
    /**企业名称*/
    @Mapping("userEntity.empname")
    private String uEmpname;
    /**企业组织代码证号*/
    @Mapping("userEntity.empcode")
    private String uEmpcode;

    /**身份证号*/
    @Mapping("userEntity.idcardnumber")
    private String uIdcardnumber;

    /**核审状态(预留判断企业)*/
    @Mapping("userEntity.checkstatus")
    private String uCheckstatus;
    /**是否删除(0未删除1删除)*/
    @Mapping("userEntity.isdelete")
    private String uIsdelete;
    /**用户加入时间*/
    @Mapping("userEntity.createtime")
    private String uCreatetime;
    /**公司名称*/
    @Mapping
    private String compancyName;
    /**公司官网*/
    @Mapping
    private String compancyAddress;
    /**公司详情页图片*/
    @Mapping
    private String compancyImg;
    /**公司展示图*/
    @Mapping
    private String displayImg;
    /**公司展示大图*/
    @Mapping
    private String displayBigImg;
    /**公司视频展示*/
    @Mapping
    private String displayVideo;
    /**联系人*/
    @Mapping
    private String contactName;
    /**联系人电话*/
    @Mapping
    private String contactTel;
    /**公司规模*/
    @Mapping
    private String compancyNum;
    /**公司地点*/
    @Mapping
    @QueryStrategy
    private String compancyPositation;
    /**公司介绍*/
    @Mapping
    private String compancyIntroduce;
    /**所属行业*/
    @Mapping
    private String compancyType;
    /**公司性质*/
    @Mapping
    private String compancyNature;
    /**创建时间*/
    @Mapping
    private String createTime;
    /**更新时间*/
    @Mapping
    private String updateTime;
    /**删除标志*/
    @Mapping
    private String isDelete;

    public UserCompancySearchForm() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getuRealname() {
        return uRealname;
    }

    public void setuRealname(String uRealname) {
        this.uRealname = uRealname;
    }

    public String getuRolecode() {
        return uRolecode;
    }

    public void setuRolecode(String uRolecode) {
        this.uRolecode = uRolecode;
    }

    public String getuMphone() {
        return uMphone;
    }

    public void setuMphone(String uMphone) {
        this.uMphone = uMphone;
    }

    public String getuPwd() {
        return uPwd;
    }

    public void setuPwd(String uPwd) {
        this.uPwd = uPwd;
    }

    public String getuEmail() {
        return uEmail;
    }

    public void setuEmail(String uEmail) {
        this.uEmail = uEmail;
    }

    public String getuEmpname() {
        return uEmpname;
    }

    public void setuEmpname(String uEmpname) {
        this.uEmpname = uEmpname;
    }

    public String getuEmpcode() {
        return uEmpcode;
    }

    public void setuEmpcode(String uEmpcode) {
        this.uEmpcode = uEmpcode;
    }

    public String getuIdcardnumber() {
        return uIdcardnumber;
    }

    public void setuIdcardnumber(String uIdcardnumber) {
        this.uIdcardnumber = uIdcardnumber;
    }

    public String getuCheckstatus() {
        return uCheckstatus;
    }

    public void setuCheckstatus(String uCheckstatus) {
        this.uCheckstatus = uCheckstatus;
    }

    public String getuIsdelete() {
        return uIsdelete;
    }

    public void setuIsdelete(String uIsdelete) {
        this.uIsdelete = uIsdelete;
    }

    public String getuCreatetime() {
        return uCreatetime;
    }

    public void setuCreatetime(String uCreatetime) {
        this.uCreatetime = uCreatetime;
    }

    public String getCompancyName() {
        return compancyName;
    }

    public void setCompancyName(String compancyName) {
        this.compancyName = compancyName;
    }

    public String getCompancyAddress() {
        return compancyAddress;
    }

    public void setCompancyAddress(String compancyAddress) {
        this.compancyAddress = compancyAddress;
    }

    public String getDisplayImg() {
        return displayImg;
    }

    public void setDisplayImg(String displayImg) {
        this.displayImg = displayImg;
    }

    public String getDisplayVideo() {
        return displayVideo;
    }

    public void setDisplayVideo(String displayVideo) {
        this.displayVideo = displayVideo;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTel() {
        return contactTel;
    }

    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    public String getCompancyNum() {
        return compancyNum;
    }

    public void setCompancyNum(String compancyNum) {
        this.compancyNum = compancyNum;
    }

    public String getCompancyPositation() {
        return compancyPositation;
    }

    public void setCompancyPositation(String compancyPositation) {
        this.compancyPositation = compancyPositation;
    }

    public String getCompancyIntroduce() {
        return compancyIntroduce;
    }

    public void setCompancyIntroduce(String compancyIntroduce) {
        this.compancyIntroduce = compancyIntroduce;
    }

    public String getCompancyType() {
        return compancyType;
    }

    public void setCompancyType(String compancyType) {
        this.compancyType = compancyType;
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

    public String getCompancyImg() {
        return compancyImg;
    }

    public void setCompancyImg(String compancyImg) {
        this.compancyImg = compancyImg;
    }

    public String getDisplayBigImg() {
        return displayBigImg;
    }

    public void setDisplayBigImg(String displayBigImg) {
        this.displayBigImg = displayBigImg;
    }

    public String getCompancyNature() {
        return compancyNature;
    }

    public void setCompancyNature(String compancyNature) {
        this.compancyNature = compancyNature;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
