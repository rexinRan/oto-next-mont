package com.buss.specialsyouth.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.xml.soap.Text;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.SequenceGenerator;

/**
 * @Title: Entity
 * @Description: dxs_specials_youth
 * @author onlineGenerator
 * @date 2016-08-09 11:30:55
 * @version V1.0
 *
 */
@Entity
@Table(name = "dxs_specials_youth", schema = "")
@SuppressWarnings("serial")
public class SpecialsYouthEntity implements java.io.Serializable {
    /**主键*/
    private java.lang.String id;
    /**用户id(预留)*/
    private java.lang.String userId;
    /**所属分类*/
    private java.lang.Integer type;
    /**头像*/
    private java.lang.String headImgUrl;
    /**详情页图片*/
    private java.lang.String detailImgUrl;
    /**姓名*/
    private java.lang.String name;
    /**年龄*/
    private java.lang.String age;
    /**政治面貌*/
    private java.lang.String political;
    /**学历*/
    private java.lang.String education;
    /**现在岗位*/
    private java.lang.String persentPost;
    /**工作地点*/
    private java.lang.String workPlace;
    /**专业*/
    private java.lang.String major;
    /**毕业院校*/
    private java.lang.String university;
    /**座右铭*/
    private java.lang.String motto;
    /**个人简介*/
    private java.lang.String profile;
    /**优秀事迹*/
    private java.lang.String deeds;
    /**编号*/
    private java.lang.Integer sort;
    /**创建时间*/
    private java.util.Date createTime;
    /**更新时间*/
    private java.util.Date updateTime;
    /**删除标志*/
    private java.lang.Integer isDelete;
    /**风采展示图*/
    private java.lang.String displayImg01Fid;
    /**风采展示图地址*/
    private java.lang.String displayImg01Url;
    /**风采展示图*/
    private java.lang.String displayImg02Fid;
    /**风采展示图地址*/
    private java.lang.String displayImg02Url;
    /**风采展示图*/
    private java.lang.String displayImg03Fid;
    /**风采展示图地址*/
    private java.lang.String displayImg03Url;
    /**风采展示图*/
    private java.lang.String displayImg04Fid;
    /**风采展示图地址*/
    private java.lang.String displayImg04Url;
    /**风采展示图*/
    private java.lang.String displayImg05Fid;
    /**风采展示图地址*/
    private java.lang.String displayImg05Url;

    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  主键
     */
    @Id
    @GeneratedValue(generator = "paymentableGenerator")
    @GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
    @Column(name ="ID",nullable=false,length=32)
    public java.lang.String getId(){
        return this.id;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  主键
     */
    public void setId(java.lang.String id){
        this.id = id;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  用户id(预留)
     */
    @Column(name ="USER_ID",nullable=true,length=32)
    public java.lang.String getUserId(){
        return this.userId;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  用户id(预留)
     */
    public void setUserId(java.lang.String userId){
        this.userId = userId;
    }
    /**
     *方法: 取得java.lang.Integer
     *@return: java.lang.Integer  所属分类
     */
    @Column(name ="TYPE",nullable=true,length=3)
    public java.lang.Integer getType(){
        return this.type;
    }

    /**
     *方法: 设置java.lang.Integer
     *@param: java.lang.Integer  所属分类
     */
    public void setType(java.lang.Integer type){
        this.type = type;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  头像
     */
    @Column(name ="HEAD_IMG_URL",nullable=true,length=255)
    public java.lang.String getHeadImgUrl(){
        return this.headImgUrl;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  头像
     */
    public void setHeadImgUrl(java.lang.String headImgUrl){
        this.headImgUrl = headImgUrl;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  详情页图片
     */
    @Column(name ="DETAIL_IMG_URL",nullable=true,length=255)
    public java.lang.String getDetailImgUrl(){
        return this.detailImgUrl;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  详情页图片
     */
    public void setDetailImgUrl(java.lang.String detailImgUrl){
        this.detailImgUrl = detailImgUrl;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  姓名
     */
    @Column(name ="NAME",nullable=true,length=100)
    public java.lang.String getName(){
        return this.name;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  姓名
     */
    public void setName(java.lang.String name){
        this.name = name;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  年龄
     */
    @Column(name ="AGE",nullable=true,length=3)
    public java.lang.String getAge(){
        return this.age;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  年龄
     */
    public void setAge(java.lang.String age){
        this.age = age;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  政治面貌
     */
    @Column(name ="POLITICAL",nullable=true,length=20)
    public java.lang.String getPolitical(){
        return this.political;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  政治面貌
     */
    public void setPolitical(java.lang.String political){
        this.political = political;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  学历
     */
    @Column(name ="EDUCATION",nullable=true,length=50)
    public java.lang.String getEducation(){
        return this.education;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  学历
     */
    public void setEducation(java.lang.String education){
        this.education = education;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  现在岗位
     */
    @Column(name ="PERSENT_POST",nullable=true,length=200)
    public java.lang.String getPersentPost(){
        return this.persentPost;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  现在岗位
     */
    public void setPersentPost(java.lang.String persentPost){
        this.persentPost = persentPost;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  工作地点
     */
    @Column(name ="WORK_PLACE",nullable=true,length=100)
    public java.lang.String getWorkPlace(){
        return this.workPlace;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  工作地点
     */
    public void setWorkPlace(java.lang.String workPlace){
        this.workPlace = workPlace;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  专业
     */
    @Column(name ="MAJOR",nullable=true,length=50)
    public java.lang.String getMajor(){
        return this.major;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  专业
     */
    public void setMajor(java.lang.String major){
        this.major = major;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  毕业院校
     */
    @Column(name ="UNIVERSITY",nullable=true,length=100)
    public java.lang.String getUniversity(){
        return this.university;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  毕业院校
     */
    public void setUniversity(java.lang.String university){
        this.university = university;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  座右铭
     */
    @Column(name ="MOTTO",nullable=true,length=255)
    public java.lang.String getMotto(){
        return this.motto;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  座右铭
     */
    public void setMotto(java.lang.String motto){
        this.motto = motto;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  个人简介
     */
    @Column(name ="PROFILE",nullable=true,length=16777215)
    public java.lang.String getProfile(){
        return this.profile;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  个人简介
     */
    public void setProfile(java.lang.String profile){
        this.profile = profile;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  优秀事迹
     */
    @Column(name ="DEEDS",nullable=true,length=16777215)
    public java.lang.String getDeeds(){
        return this.deeds;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  优秀事迹
     */
    public void setDeeds(java.lang.String deeds){
        this.deeds = deeds;
    }
    /**
     *方法: 取得java.lang.Integer
     *@return: java.lang.Integer  编号
     */
    @Column(name ="SORT",nullable=true,length=10)
    public java.lang.Integer getSort(){
        return this.sort;
    }

    /**
     *方法: 设置java.lang.Integer
     *@param: java.lang.Integer  编号
     */
    public void setSort(java.lang.Integer sort){
        this.sort = sort;
    }
    /**
     *方法: 取得java.util.Date
     *@return: java.util.Date  创建时间
     */
    @Column(name ="CREATE_TIME",nullable=true)
    public java.util.Date getCreateTime(){
        return this.createTime;
    }

    /**
     *方法: 设置java.util.Date
     *@param: java.util.Date  创建时间
     */
    public void setCreateTime(java.util.Date createTime){
        this.createTime = createTime;
    }
    /**
     *方法: 取得java.util.Date
     *@return: java.util.Date  更新时间
     */
    @Column(name ="UPDATE_TIME",nullable=true)
    public java.util.Date getUpdateTime(){
        return this.updateTime;
    }

    /**
     *方法: 设置java.util.Date
     *@param: java.util.Date  更新时间
     */
    public void setUpdateTime(java.util.Date updateTime){
        this.updateTime = updateTime;
    }
    /**
     *方法: 取得java.lang.Integer
     *@return: java.lang.Integer  删除标志
     */
    @Column(name ="IS_DELETE",nullable=true,length=3)
    public java.lang.Integer getIsDelete(){
        return this.isDelete;
    }

    /**
     *方法: 设置java.lang.Integer
     *@param: java.lang.Integer  删除标志
     */
    public void setIsDelete(java.lang.Integer isDelete){
        this.isDelete = isDelete;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  风采展示图
     */
    @Column(name ="DISPLAY_IMG01_FID",nullable=true,length=32)
    public java.lang.String getDisplayImg01Fid(){
        return this.displayImg01Fid;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  风采展示图
     */
    public void setDisplayImg01Fid(java.lang.String displayImg01Fid){
        this.displayImg01Fid = displayImg01Fid;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  风采展示图地址
     */
    @Column(name ="DISPLAY_IMG01_URL",nullable=true,length=255)
    public java.lang.String getDisplayImg01Url(){
        return this.displayImg01Url;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  风采展示图地址
     */
    public void setDisplayImg01Url(java.lang.String displayImg01Url){
        this.displayImg01Url = displayImg01Url;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  风采展示图
     */
    @Column(name ="DISPLAY_IMG02_FID",nullable=true,length=32)
    public java.lang.String getDisplayImg02Fid(){
        return this.displayImg02Fid;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  风采展示图
     */
    public void setDisplayImg02Fid(java.lang.String displayImg02Fid){
        this.displayImg02Fid = displayImg02Fid;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  风采展示图地址
     */
    @Column(name ="DISPLAY_IMG02_URL",nullable=true,length=255)
    public java.lang.String getDisplayImg02Url(){
        return this.displayImg02Url;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  风采展示图地址
     */
    public void setDisplayImg02Url(java.lang.String displayImg02Url){
        this.displayImg02Url = displayImg02Url;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  风采展示图
     */
    @Column(name ="DISPLAY_IMG03_FID",nullable=true,length=32)
    public java.lang.String getDisplayImg03Fid(){
        return this.displayImg03Fid;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  风采展示图
     */
    public void setDisplayImg03Fid(java.lang.String displayImg03Fid){
        this.displayImg03Fid = displayImg03Fid;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  风采展示图地址
     */
    @Column(name ="DISPLAY_IMG03_URL",nullable=true,length=255)
    public java.lang.String getDisplayImg03Url(){
        return this.displayImg03Url;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  风采展示图地址
     */
    public void setDisplayImg03Url(java.lang.String displayImg03Url){
        this.displayImg03Url = displayImg03Url;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  风采展示图
     */
    @Column(name ="DISPLAY_IMG04_FID",nullable=true,length=32)
    public java.lang.String getDisplayImg04Fid(){
        return this.displayImg04Fid;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  风采展示图
     */
    public void setDisplayImg04Fid(java.lang.String displayImg04Fid){
        this.displayImg04Fid = displayImg04Fid;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  风采展示图地址
     */
    @Column(name ="DISPLAY_IMG04_URL",nullable=true,length=255)
    public java.lang.String getDisplayImg04Url(){
        return this.displayImg04Url;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  风采展示图地址
     */
    public void setDisplayImg04Url(java.lang.String displayImg04Url){
        this.displayImg04Url = displayImg04Url;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  风采展示图
     */
    @Column(name ="DISPLAY_IMG05_FID",nullable=true,length=32)
    public java.lang.String getDisplayImg05Fid(){
        return this.displayImg05Fid;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  风采展示图
     */
    public void setDisplayImg05Fid(java.lang.String displayImg05Fid){
        this.displayImg05Fid = displayImg05Fid;
    }
    /**
     *方法: 取得java.lang.String
     *@return: java.lang.String  风采展示图地址
     */
    @Column(name ="DISPLAY_IMG05_URL",nullable=true,length=255)
    public java.lang.String getDisplayImg05Url(){
        return this.displayImg05Url;
    }

    /**
     *方法: 设置java.lang.String
     *@param: java.lang.String  风采展示图地址
     */
    public void setDisplayImg05Url(java.lang.String displayImg05Url){
        this.displayImg05Url = displayImg05Url;
    }
}
