package com.buss.specials.entity;

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
 * @Description: dxs_specials
 * @author onlineGenerator
 * @date 2016-08-05 14:55:03
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_specials", schema = "")
@SuppressWarnings("serial")
public class SpecialsEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**介绍*/
	private java.lang.String introduce;
	/**视频地址*/
	private java.lang.String videoUrl;
	/**缩略图*/
	private java.lang.String imgUrl;
	/**志愿者招募对象和条件*/
	private java.lang.String volunteerObj;
	/**招募方式*/
	private java.lang.String volunteerJoinType;
	/**服务期限*/
	private java.lang.String volunteerService;
	/**业务指导与监测评估*/
	private java.lang.String volunteerAssessment;
	/**工作时间及工作量*/
	private java.lang.String volunteerWorks;
	/**文化活动安排*/
	private java.lang.String volunteerActive;
	/**志愿者培训*/
	private java.lang.String volunteerTeach;
	/**工作点的设置与管理*/
	private java.lang.String volunteerManager;
	/**创建时间*/
	private java.util.Date createTime;
	/**更新时间*/
	private java.util.Date updateTime;
	/**删除标志*/
	private java.lang.Integer isDelete;
	/**所属分类*/
	private java.lang.Integer type;
	
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
	 *@return: java.lang.String  介绍
	 */
	@Column(name ="INTRODUCE",nullable=true,length=65535)
	public java.lang.String getIntroduce(){
		return this.introduce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  介绍
	 */
	public void setIntroduce(java.lang.String introduce){
		this.introduce = introduce;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  视频地址
	 */
	@Column(name ="VIDEO_URL",nullable=true,length=255)
	public java.lang.String getVideoUrl(){
		return this.videoUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  视频地址
	 */
	public void setVideoUrl(java.lang.String videoUrl){
		this.videoUrl = videoUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  缩略图
	 */
	@Column(name ="IMG_URL",nullable=true,length=255)
	public java.lang.String getImgUrl(){
		return this.imgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  缩略图
	 */
	public void setImgUrl(java.lang.String imgUrl){
		this.imgUrl = imgUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  志愿者招募对象和条件
	 */
	@Column(name ="VOLUNTEER_OBJ",nullable=true,length=255)
	public java.lang.String getVolunteerObj(){
		return this.volunteerObj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  志愿者招募对象和条件
	 */
	public void setVolunteerObj(java.lang.String volunteerObj){
		this.volunteerObj = volunteerObj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  招募方式
	 */
	@Column(name ="VOLUNTEER_JOIN_TYPE",nullable=true,length=65535)
	public java.lang.String getVolunteerJoinType(){
		return this.volunteerJoinType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  招募方式
	 */
	public void setVolunteerJoinType(java.lang.String volunteerJoinType){
		this.volunteerJoinType = volunteerJoinType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  服务期限
	 */
	@Column(name ="VOLUNTEER_SERVICE",nullable=true,length=16777215)
	public java.lang.String getVolunteerService(){
		return this.volunteerService;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  服务期限
	 */
	public void setVolunteerService(java.lang.String volunteerService){
		this.volunteerService = volunteerService;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业务指导与监测评估
	 */
	@Column(name ="VOLUNTEER_ASSESSMENT",nullable=true,length=16777215)
	public java.lang.String getVolunteerAssessment(){
		return this.volunteerAssessment;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业务指导与监测评估
	 */
	public void setVolunteerAssessment(java.lang.String volunteerAssessment){
		this.volunteerAssessment = volunteerAssessment;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工作时间及工作量
	 */
	@Column(name ="VOLUNTEER_WORKS",nullable=true,length=16777215)
	public java.lang.String getVolunteerWorks(){
		return this.volunteerWorks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工作时间及工作量
	 */
	public void setVolunteerWorks(java.lang.String volunteerWorks){
		this.volunteerWorks = volunteerWorks;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文化活动安排
	 */
	@Column(name ="VOLUNTEER_ACTIVE",nullable=true,length=16777215)
	public java.lang.String getVolunteerActive(){
		return this.volunteerActive;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文化活动安排
	 */
	public void setVolunteerActive(java.lang.String volunteerActive){
		this.volunteerActive = volunteerActive;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  志愿者培训
	 */
	@Column(name ="VOLUNTEER_TEACH",nullable=true,length=16777215)
	public java.lang.String getVolunteerTeach(){
		return this.volunteerTeach;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  志愿者培训
	 */
	public void setVolunteerTeach(java.lang.String volunteerTeach){
		this.volunteerTeach = volunteerTeach;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工作点的设置与管理
	 */
	@Column(name ="VOLUNTEER_MANAGER",nullable=true,length=16777215)
	public java.lang.String getVolunteerManager(){
		return this.volunteerManager;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工作点的设置与管理
	 */
	public void setVolunteerManager(java.lang.String volunteerManager){
		this.volunteerManager = volunteerManager;
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
}
