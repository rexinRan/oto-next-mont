package com.buss.resume.resumeskills.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: dxs_resume_skills
 * @author lu
 * @date 2016-06-24 11:12:25
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_resume_skills", schema = "")
@SuppressWarnings("serial")
public class ResumeSkillsEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**简历ID*/

	private String resumeId;
	/**技能项*/

	private String skills;
	/**技能类型*/

	private String skillsType;
	/**技能有效值*/

	private String skillsKey;
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
	 *@return: java.lang.String  简历ID
	 */
	@Column(name ="RESUME_ID",nullable=true,length=32)
	public String getResumeId(){
		return this.resumeId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  简历ID
	 */
	public void setResumeId(String resumeId){
		this.resumeId = resumeId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  技能项
	 */
	@Column(name ="SKILLS",nullable=true,length=50)
	public String getSkills(){
		return this.skills;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  技能项
	 */
	public void setSkills(String skills){
		this.skills = skills;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  技能类型
	 */
	@Column(name ="SKILLS_TYPE",nullable=true,length=2)
	public String getSkillsType(){
		return this.skillsType;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  技能类型
	 */
	public void setSkillsType(String skillsType){
		this.skillsType = skillsType;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  技能有效值
	 */
	@Column(name ="SKILLS_KEY",nullable=true,length=10)
	public String getSkillsKey(){
		return this.skillsKey;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  技能有效值
	 */
	public void setSkillsKey(String skillsKey){
		this.skillsKey = skillsKey;
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
