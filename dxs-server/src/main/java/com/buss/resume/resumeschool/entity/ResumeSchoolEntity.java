package com.buss.resume.resumeschool.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @Title: Entity
 * @Description: dxs_resume_school
 * @author onlineGenerator
 * @date 2016-08-22 13:32:23
 * @version V1.0
 *
 */
@Entity
@Table(name = "dxs_resume_school", schema = "")
@SuppressWarnings("serial")
public class ResumeSchoolEntity implements java.io.Serializable {
	/**主键*/
	private java.lang.String id;
	/**简历ID*/

	private java.lang.String resumeId;
	/**入学时间*/

	private java.lang.String schoolStart;
	/**毕业时间*/

	private java.lang.String schoolEnd;
	/**学校名称*/

	private java.lang.String schoolName;
	/**专业名称*/

	private java.lang.String schoolProfessional;
	/**学历*/

	private java.lang.String schoolQualifications;
	/**专业描述*/

	private java.lang.String schoolDescription;
	/**导师*/

	private java.lang.String teacher;
	/**GPA*/

	private java.lang.String gpa;
	/**课程*/

	private java.lang.String courses;
	/**备注*/

	private java.lang.String remark;
	/**创建时间*/

	private java.util.Date createTime;
	/**更新时间*/

	private java.util.Date updateTime;
	/**删除标志*/

	private java.lang.Integer isDelete;

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
	 *@return: java.lang.String  简历ID
	 */
	@Column(name ="RESUME_ID",nullable=true,length=32)
	public java.lang.String getResumeId(){
		return this.resumeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  简历ID
	 */
	public void setResumeId(java.lang.String resumeId){
		this.resumeId = resumeId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  入学时间
	 */
	@Column(name ="SCHOOL_START",nullable=true,length=20)
	public java.lang.String getSchoolStart(){
		return this.schoolStart;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  入学时间
	 */
	public void setSchoolStart(java.lang.String schoolStart){
		this.schoolStart = schoolStart;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  毕业时间
	 */
	@Column(name ="SCHOOL_END",nullable=true,length=20)
	public java.lang.String getSchoolEnd(){
		return this.schoolEnd;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  毕业时间
	 */
	public void setSchoolEnd(java.lang.String schoolEnd){
		this.schoolEnd = schoolEnd;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学校名称
	 */
	@Column(name ="SCHOOL_NAME",nullable=true,length=100)
	public java.lang.String getSchoolName(){
		return this.schoolName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学校名称
	 */
	public void setSchoolName(java.lang.String schoolName){
		this.schoolName = schoolName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  专业名称
	 */
	@Column(name ="SCHOOL_PROFESSIONAL",nullable=true,length=100)
	public java.lang.String getSchoolProfessional(){
		return this.schoolProfessional;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专业名称
	 */
	public void setSchoolProfessional(java.lang.String schoolProfessional){
		this.schoolProfessional = schoolProfessional;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  学历
	 */
	@Column(name ="SCHOOL_QUALIFICATIONS",nullable=true,length=10)
	public java.lang.String getSchoolQualifications(){
		return this.schoolQualifications;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  学历
	 */
	public void setSchoolQualifications(java.lang.String schoolQualifications){
		this.schoolQualifications = schoolQualifications;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  专业描述
	 */
	@Column(name ="SCHOOL_DESCRIPTION",nullable=true,length=255)
	public java.lang.String getSchoolDescription(){
		return this.schoolDescription;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  专业描述
	 */
	public void setSchoolDescription(java.lang.String schoolDescription){
		this.schoolDescription = schoolDescription;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  导师
	 */
	@Column(name ="TEACHER",nullable=true,length=100)
	public java.lang.String getTeacher(){
		return this.teacher;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  导师
	 */
	public void setTeacher(java.lang.String teacher){
		this.teacher = teacher;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  GPA
	 */
	@Column(name ="GPA",nullable=true,length=5)
	public java.lang.String getGpa(){
		return this.gpa;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  GPA
	 */
	public void setGpa(java.lang.String gpa){
		this.gpa = gpa;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  课程
	 */
	@Column(name ="COURSES",nullable=true,length=16777215)
	public java.lang.String getCourses(){
		return this.courses;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  课程
	 */
	public void setCourses(java.lang.String courses){
		this.courses = courses;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备注
	 */
	@Column(name ="REMARK",nullable=true,length=255)
	public java.lang.String getRemark(){
		return this.remark;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备注
	 */
	public void setRemark(java.lang.String remark){
		this.remark = remark;
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
}
