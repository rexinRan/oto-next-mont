package com.buss.traincoursevideo.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: dxs_train_course_video
 * @author onlineGenerator
 * @date 2016-09-06 13:39:52
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_train_course_video", schema = "")
@SuppressWarnings("serial")
public class TrainCourseVideoEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**课程id*/

	private String tocId;
	/**导师id*/

	private String userId;
	/**视频名称*/

	private String videoName;
	/**缩略图*/

	private String imgUrl;
	/**视频地址*/

	private String videoUrl;
	/**编号*/

	private Integer sort;
	/**视频时长*/

	private String videoHourses;
	/**是否免费*/

	private Integer isFree;
	/**内部标记*/

	private Integer inSign;
	/**外部标记*/

	private Integer outSign;
	/**价格(预留)*/

	private String price;
	/**创建时间*/

	private Date createTime;
	/**更新时间*/

	private Date updateTime;
	/**删除标志*/

	private Integer isDelete;
	
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
	 *@return: java.lang.String  课程id
	 */
	@Column(name ="TOC_ID",nullable=true,length=32)
	public String getTocId(){
		return this.tocId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课程id
	 */
	public void setTocId(String tocId){
		this.tocId = tocId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  导师id
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  导师id
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  视频名称
	 */
	@Column(name ="VIDEO_NAME",nullable=true,length=200)
	public String getVideoName(){
		return this.videoName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  视频名称
	 */
	public void setVideoName(String videoName){
		this.videoName = videoName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  缩略图
	 */
	@Column(name ="IMG_URL",nullable=true,length=255)
	public String getImgUrl(){
		return this.imgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  缩略图
	 */
	public void setImgUrl(String imgUrl){
		this.imgUrl = imgUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  视频地址
	 */
	@Column(name ="VIDEO_URL",nullable=true,length=255)
	public String getVideoUrl(){
		return this.videoUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  视频地址
	 */
	public void setVideoUrl(String videoUrl){
		this.videoUrl = videoUrl;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  视频时长
	 */
	@Column(name ="VIDEO_HOURSES",nullable=true,length=255)
	public String getVideoHourses(){
		return this.videoHourses;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  视频时长
	 */
	public void setVideoHourses(String videoHourses){
		this.videoHourses = videoHourses;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否免费
	 */
	@Column(name ="IS_FREE",nullable=true,length=3)
	public Integer getIsFree(){
		return this.isFree;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否免费
	 */
	public void setIsFree(Integer isFree){
		this.isFree = isFree;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  内部标记
	 */
	@Column(name ="IN_SIGN",nullable=true,length=3)
	public Integer getInSign(){
		return this.inSign;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  内部标记
	 */
	public void setInSign(Integer inSign){
		this.inSign = inSign;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  外部标记
	 */
	@Column(name ="OUT_SIGN",nullable=true,length=3)
	public Integer getOutSign(){
		return this.outSign;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  外部标记
	 */
	public void setOutSign(Integer outSign){
		this.outSign = outSign;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  价格(预留)
	 */
	@Column(name ="PRICE",nullable=true,length=10)
	public String getPrice(){
		return this.price;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  价格(预留)
	 */
	public void setPrice(String price){
		this.price = price;
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
