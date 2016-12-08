package com.buss.usercompancy.entity;

import com.buss.member.entity.GeneralUserEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**
 * @Title: Entity
 * @Description: dxs_user_compancy
 * @author lu
 * @date 2016-06-15 11:24:55
 * @version V1.0
 *
 */
@Entity
@Table(name = "dxs_user_compancy", schema = "")
@SuppressWarnings("serial")
public class UserCompancyEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**企业注册表*/

	private GeneralUserEntity userEntity;
	/**用户id*/

	private String userId;
	/**公司名称*/

	private String compancyName;
	/**公司官网*/

	private String compancyAddress;
	/**公司详情页图片*/

	private String compancyImg;
	/**公司展示大图*/

	private String displayBigImg;
	/**公司展示图*/

	private String displayImg;
	/**公司视频展示*/

	private String displayVideo;
	/**联系人*/

	private String contactName;
	/**联系人电话*/

	private String contactTel;
	/**公司规模*/

	private String compancyNum;
	/**公司地点*/

	private String compancyPositation;
	/**公司介绍*/

	private String compancyIntroduce;
	/**所属行业*/

	private String compancyType;
	/**公司性质*/

	private String compancyNature;
	/**创建时间*/

	private Date createTime;
	/**更新时间*/

	private Date updateTime;
	/**删除标志*/

	private Integer isDelete;

	// lyy


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
	 *@return: java.lang.String  企业注册表
	 */
	@OneToOne()
	@JoinColumn(name="USER_ID",insertable = false, updatable = false)
	public GeneralUserEntity getUserEntity() {
		return userEntity;
	}
	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  企业注册表
	 */
	public void setUserEntity(GeneralUserEntity userEntity) {
		this.userEntity = userEntity;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  用户id
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户id
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司名称
	 */
	@Column(name ="COMPANCY_NAME",nullable=true,length=100)
	public String getCompancyName(){
		return this.compancyName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司名称
	 */
	public void setCompancyName(String compancyName){
		this.compancyName = compancyName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司官网
	 */
	@Column(name ="COMPANCY_ADDRESS",nullable=true,length=200)
	public String getCompancyAddress(){
		return this.compancyAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司官网
	 */
	public void setCompancyAddress(String compancyAddress){
		this.compancyAddress = compancyAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司详情页图片
	 */
	@Column(name ="COMPANCY_IMG",nullable=true,length=255)
	public String getCompancyImg(){
		return this.compancyImg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司详情页图片
	 */
	public void setCompancyImg(String compancyImg){
		this.compancyImg = compancyImg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司展示图
	 */
	@Column(name ="DISPLAY_IMG",nullable=true,length=255)
	public String getDisplayImg(){
		return this.displayImg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司展示图
	 */
	public void setDisplayImg(String displayImg){
		this.displayImg = displayImg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司展示大图
	 */
	@Column(name ="DISPLAY_BIG_IMG",nullable=true,length=255)
	public String getDisplayBigImg(){
		return this.displayBigImg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司展示大图
	 */
	public void setDisplayBigImg(String displayBigImg){
		this.displayBigImg = displayBigImg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司视频展示
	 */
	@Column(name ="DISPLAY_VIDEO",nullable=true,length=255)
	public String getDisplayVideo(){
		return this.displayVideo;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司视频展示
	 */
	public void setDisplayVideo(String displayVideo){
		this.displayVideo = displayVideo;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人
	 */
	@Column(name ="CONTACT_NAME",nullable=true,length=100)
	public String getContactName(){
		return this.contactName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人
	 */
	public void setContactName(String contactName){
		this.contactName = contactName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  联系人电话
	 */
	@Column(name ="CONTACT_TEL",nullable=true,length=50)
	public String getContactTel(){
		return this.contactTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  联系人电话
	 */
	public void setContactTel(String contactTel){
		this.contactTel = contactTel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司规模
	 */
	@Column(name ="COMPANCY_NUM",nullable=true,length=50)
	public String getCompancyNum(){
		return this.compancyNum;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司规模
	 */
	public void setCompancyNum(String compancyNum){
		this.compancyNum = compancyNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司地点
	 */
	@Column(name ="COMPANCY_POSITATION",nullable=true,length=200)
	public String getCompancyPositation(){
		return this.compancyPositation;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司地点
	 */
	public void setCompancyPositation(String compancyPositation){
		this.compancyPositation = compancyPositation;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司介绍
	 */
	@Column(name ="COMPANCY_INTRODUCE",nullable=true,length=16777215)
	public String getCompancyIntroduce(){
		return this.compancyIntroduce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司介绍
	 */
	public void setCompancyIntroduce(String compancyIntroduce){
		this.compancyIntroduce = compancyIntroduce;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  所属行业
	 */
	@Column(name ="COMPANCY_TYPE",nullable=true,length=50)
	public String getCompancyType(){
		return this.compancyType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  所属行业
	 */
	public void setCompancyType(String compancyType){
		this.compancyType = compancyType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司性质
	 */
	@Column(name ="COMPANCY_NATURE",nullable=true,length=255)
	public String getCompancyNature(){
		return this.compancyNature;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司性质
	 */
	public void setCompancyNature(String compancyNature){
		this.compancyNature = compancyNature;
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
}
