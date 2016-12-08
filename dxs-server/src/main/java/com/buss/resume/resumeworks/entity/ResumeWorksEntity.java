package com.buss.resume.resumeworks.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: dxs_resume_works
 * @author onlineGenerator
 * @date 2016-08-22 13:33:10
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_resume_works", schema = "")
@SuppressWarnings("serial")
public class ResumeWorksEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**简历id*/

	private String resumeId;
	/**作品名称*/

	private String workName;
	/**时间*/

	private Date workFinishTime;
	/**副标题*/

	private String workName2;
	/**描述*/

	private String workIntroduce;
	/**图片*/

	private String imgUrl;
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
	 *@return: java.lang.String  简历id
	 */
	@Column(name ="RESUME_ID",nullable=true,length=32)
	public String getResumeId(){
		return this.resumeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  简历id
	 */
	public void setResumeId(String resumeId){
		this.resumeId = resumeId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  作品名称
	 */
	@Column(name ="WORK_NAME",nullable=true,length=200)
	public String getWorkName(){
		return this.workName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  作品名称
	 */
	public void setWorkName(String workName){
		this.workName = workName;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  时间
	 */
	@Column(name ="WORK_FINISH_TIME",nullable=true)
	public Date getWorkFinishTime(){
		return this.workFinishTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  时间
	 */
	public void setWorkFinishTime(Date workFinishTime){
		this.workFinishTime = workFinishTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  副标题
	 */
	@Column(name ="WORK_NAME2",nullable=true,length=255)
	public String getWorkName2(){
		return this.workName2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  副标题
	 */
	public void setWorkName2(String workName2){
		this.workName2 = workName2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  描述
	 */
	@Column(name ="WORK_INTRODUCE",nullable=true,length=65535)
	public String getWorkIntroduce(){
		return this.workIntroduce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  描述
	 */
	public void setWorkIntroduce(String workIntroduce){
		this.workIntroduce = workIntroduce;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  图片
	 */
	@Column(name ="IMG_URL",nullable=true,length=255)
	public String getImgUrl(){
		return this.imgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  图片
	 */
	public void setImgUrl(String imgUrl){
		this.imgUrl = imgUrl;
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
