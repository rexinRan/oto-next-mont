package com.buss.quiz.entity;

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
 * @Description: dxs_quiz
 * @author onlineGenerator
 * @date 2016-06-02 10:41:13
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_quiz", schema = "")
@SuppressWarnings("serial")
public class DxsQuizEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**培训试卷名称*/
	@Excel(name="培训试卷名称")
	private String trainingCatalogId;
	/**试卷名称*/
	@Excel(name="试卷名称")
	private String quizName;
	/**出题人*/
	@Excel(name="出题人")
	private String quizEditor;
	/**书卷介绍*/
	@Excel(name="书卷介绍")
	private String quizIntroduction;
	/**编号*/
	@Excel(name="编号")
	private Integer sort;
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
	 *@return: java.lang.String  培训试卷名称
	 */
	@Column(name ="TRAINING_CATALOG_ID",nullable=true,length=32)
	public String getTrainingCatalogId(){
		return this.trainingCatalogId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  培训试卷名称
	 */
	public void setTrainingCatalogId(String trainingCatalogId){
		this.trainingCatalogId = trainingCatalogId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  试卷名称
	 */
	@Column(name ="QUIZ_NAME",nullable=true,length=255)
	public String getQuizName(){
		return this.quizName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  试卷名称
	 */
	public void setQuizName(String quizName){
		this.quizName = quizName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  出题人
	 */
	@Column(name ="QUIZ_EDITOR",nullable=true,length=100)
	public String getQuizEditor(){
		return this.quizEditor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  出题人
	 */
	public void setQuizEditor(String quizEditor){
		this.quizEditor = quizEditor;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  书卷介绍
	 */
	@Column(name ="QUIZ_INTRODUCTION",nullable=true)
	public String getQuizIntroduction(){
		return this.quizIntroduction;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  书卷介绍
	 */
	public void setQuizIntroduction(String quizIntroduction){
		this.quizIntroduction = quizIntroduction;
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
	@JoinColumn(name = "training_catalog_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)
	public DxsTrainingCatalogEntity getDxsTrainingCatalogEntity() {
		return dxsTrainingCatalogEntity;
	}

	public void setDxsTrainingCatalogEntity(DxsTrainingCatalogEntity dxsTrainingCatalogEntity) {
		this.dxsTrainingCatalogEntity = dxsTrainingCatalogEntity;
	}
}
