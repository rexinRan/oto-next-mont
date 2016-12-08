package com.buss.project.projectresult.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: dxs_project_restule
 * @author onlineGenerator
 * @date 2016-07-23 15:13:08
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_project_restule", schema = "")
@SuppressWarnings("serial")
public class ProjectResultEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**项目id*/
	private String pId;
	/**级别id*/
	private String pcId;
	/**结果*/
	private Integer result;
	/**初审(答辩)*/
	private String type;
	/**结果说明*/
	private String message;
	/**得分*/
	private String score;
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
	 *@return: java.lang.String  项目id
	 */
	@Column(name ="P_ID",nullable=true,length=32)
	public String getPId(){
		return this.pId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目id
	 */
	public void setPId(String pId){
		this.pId = pId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  级别id
	 */
	@Column(name ="PC_ID",nullable=true,length=32)
	public String getPcId(){
		return this.pcId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  级别id
	 */
	public void setPcId(String pcId){
		this.pcId = pcId;
	}

	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  初审/答辩
	 */
	@Column(name ="TYPE",nullable=true,length=50)
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  结果
	 */
	@Column(name ="RESULT",nullable=true,length=3)
	public Integer getResult(){
		return this.result;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  结果
	 */
	public void setResult(Integer result){
		this.result = result;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结果说明
	 */
	@Column(name ="MESSAGE",nullable=true,length=255)
	public String getMessage(){
		return this.message;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结果说明
	 */
	public void setMessage(String message){
		this.message = message;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  得分
	 */
	@Column(name ="SCORE",nullable=true,length=10)
	public String getScore(){
		return this.score;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  得分
	 */
	public void setScore(String score){
		this.score = score;
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
