package com.buss.trainingcourse.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.trainingcatalog.entity.DxsTrainingCatalogEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_training_course
 * @author onlineGenerator
 * @date 2016-07-01 10:59:40
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_training_course", schema = "")
@SuppressWarnings("serial")
public class DxsTrainingCourseEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**培训中心分类id*/
	@Excel(name="培训中心分类id")
	private String trainingCatelogId;
	/**课程名称*/
	@Excel(name="课程名称")
	private String courseName;
	/**任课老师*/
	@Excel(name="任课老师")
	private String courseTeacher;
	/**课程发布者*/
	@Excel(name="课程发布者")
	private String courseEditor;
	/**发布时间*/
	@Excel(name="发布时间",format = "yyyy-MM-dd")
	private Date coursePublishTime;
	/**课程视频*/
	@Excel(name="课程视频")
	private String courseVideourl;
	/**课程介绍*/
	@Excel(name="课程介绍")
	private String courseIntroduce;
	/**编号*/
	@Excel(name="编号")
	private Integer courseSort;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private Date createTime;
	/**更新时间*/
	@Excel(name="更新时间",format = "yyyy-MM-dd")
	private Date updateTime;
	/**删除标志*/
	@Excel(name="删除标志")
	private Integer isDelete;

	private DxsTrainingCatalogEntity dxsTrainingCatalogEntity;
	
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
	 *@return: java.lang.String  培训中心分类id
	 */
	@Column(name ="TRAINING_CATELOG_ID",nullable=true,length=32)
	public String getTrainingCatelogId(){
		return this.trainingCatelogId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  培训中心分类id
	 */
	public void setTrainingCatelogId(String trainingCatelogId){
		this.trainingCatelogId = trainingCatelogId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  课程名称
	 */
	@Column(name ="COURSE_NAME",nullable=true,length=100)
	public String getCourseName(){
		return this.courseName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课程名称
	 */
	public void setCourseName(String courseName){
		this.courseName = courseName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  任课老师
	 */
	@Column(name ="COURSE_TEACHER",nullable=true,length=200)
	public String getCourseTeacher(){
		return this.courseTeacher;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  任课老师
	 */
	public void setCourseTeacher(String courseTeacher){
		this.courseTeacher = courseTeacher;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  课程发布者
	 */
	@Column(name ="COURSE_EDITOR",nullable=true,length=100)
	public String getCourseEditor(){
		return this.courseEditor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课程发布者
	 */
	public void setCourseEditor(String courseEditor){
		this.courseEditor = courseEditor;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  发布时间
	 */
	@Column(name ="COURSE_PUBLISH_TIME",nullable=true)
	public Date getCoursePublishTime(){
		return this.coursePublishTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  发布时间
	 */
	public void setCoursePublishTime(Date coursePublishTime){
		this.coursePublishTime = coursePublishTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  课程视频
	 */
	@Column(name ="COURSE_VIDEOURL",nullable=true,length=200)
	public String getCourseVideourl(){
		return this.courseVideourl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课程视频
	 */
	public void setCourseVideourl(String courseVideourl){
		this.courseVideourl = courseVideourl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  课程介绍
	 */
	@Column(name ="COURSE_INTRODUCE",nullable=true,length=16777215)
	public String getCourseIntroduce(){
		return this.courseIntroduce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课程介绍
	 */
	public void setCourseIntroduce(String courseIntroduce){
		this.courseIntroduce = courseIntroduce;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  编号
	 */
	@Column(name ="COURSE_SORT",nullable=true,length=10)
	public Integer getCourseSort(){
		return this.courseSort;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  编号
	 */
	public void setCourseSort(Integer courseSort){
		this.courseSort = courseSort;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "training_catelog_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)
	public DxsTrainingCatalogEntity getDxsTrainingCatalogEntity() {
		return dxsTrainingCatalogEntity;
	}

	public void setDxsTrainingCatalogEntity(DxsTrainingCatalogEntity dxsTrainingCatalogEntity) {
		this.dxsTrainingCatalogEntity = dxsTrainingCatalogEntity;
	}
}
