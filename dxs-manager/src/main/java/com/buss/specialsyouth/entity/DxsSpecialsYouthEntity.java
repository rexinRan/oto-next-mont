package com.buss.specialsyouth.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.user.entity.DxsUserEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

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
public class DxsSpecialsYouthEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**用户id(预留)*/
	@Excel(name="用户id(预留)")
	private String userId;
	/**所属分类*/
	@Excel(name="所属分类")
	private Integer type;
	/**头像*/
	@Excel(name="头像")
	private String headImgUrl;
	/**详情页图片*/
	@Excel(name="详情页图片")
	private String detailImgUrl;
	/**姓名*/
	@Excel(name="姓名")
	private String name;
	/**年龄*/
	@Excel(name="年龄")
	private String age;
	/**政治面貌*/
	@Excel(name="政治面貌")
	private String political;
	/**学历*/
	@Excel(name="学历")
	private String education;
	/**现在岗位*/
	@Excel(name="现在岗位")
	private String persentPost;
	/**工作地点*/
	@Excel(name="工作地点")
	private String workPlace;
	/**专业*/
	@Excel(name="专业")
	private String major;
	/**毕业院校*/
	@Excel(name="毕业院校")
	private String university;
	/**座右铭*/
	@Excel(name="座右铭")
	private String motto;
	/**个人简介*/
	@Excel(name="个人简介")
	private String profile;
	/**优秀事迹*/
	@Excel(name="优秀事迹")
	private String deeds;
	/**编号*/
	@Excel(name="编号")
	private Integer sort;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private Date createTime;
	/**更新时间*/
	@Excel(name="更新时间",format = "yyyy-MM-dd")
	private Date updateTime;
	/**删除标志*/
	@Excel(name="删除标志")
	private Integer isDelete;
	/**风采展示图*/
	@Excel(name="风采展示图")
	private String displayImg01Fid;
	/**风采展示图地址*/
	@Excel(name="风采展示图地址")
	private String displayImg01Url;
	/**风采展示图*/
	@Excel(name="风采展示图")
	private String displayImg02Fid;
	/**风采展示图地址*/
	@Excel(name="风采展示图地址")
	private String displayImg02Url;
	/**风采展示图*/
	@Excel(name="风采展示图")
	private String displayImg03Fid;
	/**风采展示图地址*/
	@Excel(name="风采展示图地址")
	private String displayImg03Url;
	/**风采展示图*/
	@Excel(name="风采展示图")
	private String displayImg04Fid;
	/**风采展示图地址*/
	@Excel(name="风采展示图地址")
	private String displayImg04Url;
	/**风采展示图*/
	@Excel(name="风采展示图")
	private String displayImg05Fid;
	/**风采展示图地址*/
	@Excel(name="风采展示图地址")
	private String displayImg05Url;

	private DxsUserEntity dxsUserEntity;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  主键
	 */
	@Id
	@GeneratedValue(generator = "paymentableGenerator")
	@GenericGenerator(name = "paymentableGenerator", strategy = "uuid")
	@Column(name ="ID",nullable=false,length=32)
	public String getId(){
		return this.id;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  主键
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户id(预留)
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户id(预留)
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  所属分类
	 */
	@Column(name ="TYPE",nullable=true,length=3)
	public Integer getType(){
		return this.type;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  所属分类
	 */
	public void setType(Integer type){
		this.type = type;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  头像
	 */
	@Column(name ="HEAD_IMG_URL",nullable=true,length=255)
	public String getHeadImgUrl(){
		return this.headImgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  头像
	 */
	public void setHeadImgUrl(String headImgUrl){
		this.headImgUrl = headImgUrl;
	}
	@Column(name ="DETAIL_IMG_URL",nullable=true,length=255)
	public String getDetailImgUrl() {
		return detailImgUrl;
	}

	public void setDetailImgUrl(String detailImgUrl) {
		this.detailImgUrl = detailImgUrl;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  姓名
	 */
	@Column(name ="NAME",nullable=true,length=100)
	public String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  姓名
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  年龄
	 */
	@Column(name ="AGE",nullable=true,length=3)
	public String getAge(){
		return this.age;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  年龄
	 */
	public void setAge(String age){
		this.age = age;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  政治面貌
	 */
	@Column(name ="POLITICAL",nullable=true,length=20)
	public String getPolitical(){
		return this.political;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  政治面貌
	 */
	public void setPolitical(String political){
		this.political = political;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学历
	 */
	@Column(name ="EDUCATION",nullable=true,length=50)
	public String getEducation(){
		return this.education;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学历
	 */
	public void setEducation(String education){
		this.education = education;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  现在岗位
	 */
	@Column(name ="PERSENT_POST",nullable=true,length=200)
	public String getPersentPost(){
		return this.persentPost;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  现在岗位
	 */
	public void setPersentPost(String persentPost){
		this.persentPost = persentPost;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工作地点
	 */
	@Column(name ="WORK_PLACE",nullable=true,length=100)
	public String getWorkPlace(){
		return this.workPlace;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工作地点
	 */
	public void setWorkPlace(String workPlace){
		this.workPlace = workPlace;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  专业
	 */
	@Column(name ="MAJOR",nullable=true,length=50)
	public String getMajor(){
		return this.major;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专业
	 */
	public void setMajor(String major){
		this.major = major;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  毕业院校
	 */
	@Column(name ="UNIVERSITY",nullable=true,length=100)
	public String getUniversity(){
		return this.university;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  毕业院校
	 */
	public void setUniversity(String university){
		this.university = university;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  座右铭
	 */
	@Column(name ="MOTTO",nullable=true,length=255)
	public String getMotto(){
		return this.motto;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  座右铭
	 */
	public void setMotto(String motto){
		this.motto = motto;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  个人简介
	 */
	@Column(name ="PROFILE",nullable=true,length=16777215)
	public String getProfile(){
		return this.profile;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  个人简介
	 */
	public void setProfile(String profile){
		this.profile = profile;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  优秀事迹
	 */
	@Column(name ="DEEDS",nullable=true,length=16777215)
	public String getDeeds(){
		return this.deeds;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  优秀事迹
	 */
	public void setDeeds(String deeds){
		this.deeds = deeds;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  编号
	 */
	@Column(name ="SORT",nullable=true,length=10)
	public Integer getSort(){
		return this.sort;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  编号
	 */
	public void setSort(Integer sort){
		this.sort = sort;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  创建时间
	 */
	@Column(name ="CREATE_TIME",nullable=true)
	public Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  创建时间
	 */
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  更新时间
	 */
	@Column(name ="UPDATE_TIME",nullable=true)
	public Date getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新时间
	 */
	public void setUpdateTime(Date updateTime){
		this.updateTime = updateTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  删除标志
	 */
	@Column(name ="IS_DELETE",nullable=true,length=3)
	public Integer getIsDelete(){
		return this.isDelete;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  删除标志
	 */
	public void setIsDelete(Integer isDelete){
		this.isDelete = isDelete;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  风采展示图
	 */
	@Column(name ="DISPLAY_IMG01_FID",nullable=true,length=32)
	public String getDisplayImg01Fid(){
		return this.displayImg01Fid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  风采展示图
	 */
	public void setDisplayImg01Fid(String displayImg01Fid){
		this.displayImg01Fid = displayImg01Fid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  风采展示图地址
	 */
	@Column(name ="DISPLAY_IMG01_URL",nullable=true,length=255)
	public String getDisplayImg01Url(){
		return this.displayImg01Url;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  风采展示图地址
	 */
	public void setDisplayImg01Url(String displayImg01Url){
		this.displayImg01Url = displayImg01Url;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  风采展示图
	 */
	@Column(name ="DISPLAY_IMG02_FID",nullable=true,length=32)
	public String getDisplayImg02Fid(){
		return this.displayImg02Fid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  风采展示图
	 */
	public void setDisplayImg02Fid(String displayImg02Fid){
		this.displayImg02Fid = displayImg02Fid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  风采展示图地址
	 */
	@Column(name ="DISPLAY_IMG02_URL",nullable=true,length=255)
	public String getDisplayImg02Url(){
		return this.displayImg02Url;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  风采展示图地址
	 */
	public void setDisplayImg02Url(String displayImg02Url){
		this.displayImg02Url = displayImg02Url;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  风采展示图
	 */
	@Column(name ="DISPLAY_IMG03_FID",nullable=true,length=32)
	public String getDisplayImg03Fid(){
		return this.displayImg03Fid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  风采展示图
	 */
	public void setDisplayImg03Fid(String displayImg03Fid){
		this.displayImg03Fid = displayImg03Fid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  风采展示图地址
	 */
	@Column(name ="DISPLAY_IMG03_URL",nullable=true,length=255)
	public String getDisplayImg03Url(){
		return this.displayImg03Url;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  风采展示图地址
	 */
	public void setDisplayImg03Url(String displayImg03Url){
		this.displayImg03Url = displayImg03Url;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  风采展示图
	 */
	@Column(name ="DISPLAY_IMG04_FID",nullable=true,length=32)
	public String getDisplayImg04Fid(){
		return this.displayImg04Fid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  风采展示图
	 */
	public void setDisplayImg04Fid(String displayImg04Fid){
		this.displayImg04Fid = displayImg04Fid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  风采展示图地址
	 */
	@Column(name ="DISPLAY_IMG04_URL",nullable=true,length=255)
	public String getDisplayImg04Url(){
		return this.displayImg04Url;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  风采展示图地址
	 */
	public void setDisplayImg04Url(String displayImg04Url){
		this.displayImg04Url = displayImg04Url;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  风采展示图
	 */
	@Column(name ="DISPLAY_IMG05_FID",nullable=true,length=32)
	public String getDisplayImg05Fid(){
		return this.displayImg05Fid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  风采展示图
	 */
	public void setDisplayImg05Fid(String displayImg05Fid){
		this.displayImg05Fid = displayImg05Fid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  风采展示图地址
	 */
	@Column(name ="DISPLAY_IMG05_URL",nullable=true,length=255)
	public String getDisplayImg05Url(){
		return this.displayImg05Url;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  风采展示图地址
	 */
	public void setDisplayImg05Url(String displayImg05Url){
		this.displayImg05Url = displayImg05Url;
	}


	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)

	public DxsUserEntity getDxsUserEntity() {
		return dxsUserEntity;
	}

	public void setDxsUserEntity(DxsUserEntity dxsUserEntity) {
		this.dxsUserEntity = dxsUserEntity;
	}
}
