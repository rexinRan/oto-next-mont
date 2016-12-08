package com.buss.employedonlinespecial.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: dxs_employed_online_special
 * @author onlineGenerator
 * @date 2016-08-11 15:31:27
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_employed_online_special", schema = "")
@SuppressWarnings("serial")
public class EmployedOnlineSpecialEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**视频播放地址*/

	private String videoUrl;
	/**小缩略图*/

	private String imgUrl;
	/**banner图*/

	private String imgBannerUrl;
	/**通告地址(预留)*/

	private String noteUrl;
	/**开始时间*/

	private Date startTime;
	/**结束时间*/

	private Date endTime;
	/**是否开放*/

	private Integer isPublic;
	/**编号*/

	private Integer sort;
	/**创建时间*/

	private Date createTime;
	/**更新日期*/

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
	 *@return: java.lang.String  视频播放地址
	 */
	@Column(name ="VIDEO_URL",nullable=true,length=255)
	public String getVideoUrl(){
		return this.videoUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  视频播放地址
	 */
	public void setVideoUrl(String videoUrl){
		this.videoUrl = videoUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  小缩略图
	 */
	@Column(name ="IMG_URL",nullable=true,length=255)
	public String getImgUrl(){
		return this.imgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  小缩略图
	 */
	public void setImgUrl(String imgUrl){
		this.imgUrl = imgUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  banner图
	 */
	@Column(name ="IMG_BANNER_URL",nullable=true,length=255)
	public String getImgBannerUrl(){
		return this.imgBannerUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  banner图
	 */
	public void setImgBannerUrl(String imgBannerUrl){
		this.imgBannerUrl = imgBannerUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  通告地址(预留)
	 */
	@Column(name ="NOTE_URL",nullable=true,length=255)
	public String getNoteUrl(){
		return this.noteUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  通告地址(预留)
	 */
	public void setNoteUrl(String noteUrl){
		this.noteUrl = noteUrl;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  开始时间
	 */
	@Column(name ="START_TIME",nullable=true)
	public Date getStartTime(){
		return this.startTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  开始时间
	 */
	public void setStartTime(Date startTime){
		this.startTime = startTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  结束时间
	 */
	@Column(name ="END_TIME",nullable=true)
	public Date getEndTime(){
		return this.endTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  结束时间
	 */
	public void setEndTime(Date endTime){
		this.endTime = endTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否开放
	 */
	@Column(name ="IS_PUBLIC",nullable=true,length=3)
	public Integer getIsPublic(){
		return this.isPublic;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否开放
	 */
	public void setIsPublic(Integer isPublic){
		this.isPublic = isPublic;
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
	 *@return: java.util.Date  更新日期
	 */
	@Column(name ="UPDATE_TIME",nullable=true)
	public Date getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  更新日期
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
