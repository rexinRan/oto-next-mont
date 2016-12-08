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
import org.jeecgframework.poi.excel.annotation.Excel;

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
public class DxsSpecialsEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**介绍*/
	@Excel(name="介绍")
	private String introduce;
	/**视频地址*/
	@Excel(name="视频地址")
	private String videoUrl;
	/**缩略图*/
	@Excel(name="缩略图")
	private String imgUrl;
	/**志愿者招募对象和条件*/
	@Excel(name="志愿者招募对象和条件")
	private String volunteerObj;
	/**招募方式*/
	@Excel(name="招募方式")
	private String volunteerJoinType;
	/**服务期限*/
	@Excel(name="服务期限")
	private String volunteerService;
	/**业务指导与监测评估*/
	@Excel(name="业务指导与监测评估")
	private String volunteerAssessment;
	/**工作时间及工作量*/
	@Excel(name="工作时间及工作量")
	private String volunteerWorks;
	/**文化活动安排*/
	@Excel(name="文化活动安排")
	private String volunteerActive;
	/**志愿者培训*/
	@Excel(name="志愿者培训")
	private String volunteerTeach;
	/**工作点的设置与管理*/
	@Excel(name="工作点的设置与管理")
	private String volunteerManager;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private Date createTime;
	/**更新时间*/
	@Excel(name="更新时间",format = "yyyy-MM-dd")
	private Date updateTime;
	/**删除标志*/
	@Excel(name="删除标志")
	private Integer isDelete;
	/**所属分类*/
	@Excel(name="所属分类")
	private Integer type;
	
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
	 *@return: java.lang.String  介绍
	 */
	@Column(name ="INTRODUCE",nullable=true,length=65535)
	public String getIntroduce(){
		return this.introduce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  介绍
	 */
	public void setIntroduce(String introduce){
		this.introduce = introduce;
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
	 *@return: java.lang.String  志愿者招募对象和条件
	 */
	@Column(name ="VOLUNTEER_OBJ",nullable=true,length=255)
	public String getVolunteerObj(){
		return this.volunteerObj;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  志愿者招募对象和条件
	 */
	public void setVolunteerObj(String volunteerObj){
		this.volunteerObj = volunteerObj;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  招募方式
	 */
	@Column(name ="VOLUNTEER_JOIN_TYPE",nullable=true,length=65535)
	public String getVolunteerJoinType(){
		return this.volunteerJoinType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  招募方式
	 */
	public void setVolunteerJoinType(String volunteerJoinType){
		this.volunteerJoinType = volunteerJoinType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  服务期限
	 */
	@Column(name ="VOLUNTEER_SERVICE",nullable=true,length=16777215)
	public String getVolunteerService(){
		return this.volunteerService;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  服务期限
	 */
	public void setVolunteerService(String volunteerService){
		this.volunteerService = volunteerService;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  业务指导与监测评估
	 */
	@Column(name ="VOLUNTEER_ASSESSMENT",nullable=true,length=16777215)
	public String getVolunteerAssessment(){
		return this.volunteerAssessment;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  业务指导与监测评估
	 */
	public void setVolunteerAssessment(String volunteerAssessment){
		this.volunteerAssessment = volunteerAssessment;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工作时间及工作量
	 */
	@Column(name ="VOLUNTEER_WORKS",nullable=true,length=16777215)
	public String getVolunteerWorks(){
		return this.volunteerWorks;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工作时间及工作量
	 */
	public void setVolunteerWorks(String volunteerWorks){
		this.volunteerWorks = volunteerWorks;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  文化活动安排
	 */
	@Column(name ="VOLUNTEER_ACTIVE",nullable=true,length=16777215)
	public String getVolunteerActive(){
		return this.volunteerActive;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  文化活动安排
	 */
	public void setVolunteerActive(String volunteerActive){
		this.volunteerActive = volunteerActive;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  志愿者培训
	 */
	@Column(name ="VOLUNTEER_TEACH",nullable=true,length=16777215)
	public String getVolunteerTeach(){
		return this.volunteerTeach;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  志愿者培训
	 */
	public void setVolunteerTeach(String volunteerTeach){
		this.volunteerTeach = volunteerTeach;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  工作点的设置与管理
	 */
	@Column(name ="VOLUNTEER_MANAGER",nullable=true,length=16777215)
	public String getVolunteerManager(){
		return this.volunteerManager;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  工作点的设置与管理
	 */
	public void setVolunteerManager(String volunteerManager){
		this.volunteerManager = volunteerManager;
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
}
