package com.buss.trainingarticle.entity;

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
 * @Description: dxs_training_article
 * @author onlineGenerator
 * @date 2016-06-13 17:08:16
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_training_article", schema = "")
@SuppressWarnings("serial")
public class DxsTrainingArticleEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**培训中心分类id*/
	@Excel(name="培训中心分类id")
	private String trainingCatelogId;
	/**培训中心文章标题*/
	@Excel(name="培训中心文章标题")
	private String trainingTitle;
	/**编辑人*/
	@Excel(name="编辑人")
	private String trainingEditor;
	/**发布时间*/
	@Excel(name="发布时间",format = "yyyy-MM-dd")
	private Date trainingPublishTime;
	/**缩略图*/
	@Excel(name="缩略图")
	private String trainingImgurl;
	/**培训中心文章内容*/
	@Excel(name="培训中心文章内容")
	private String trainingContents;
	/**编号*/
	@Excel(name="编号")
	private Integer trainingSort;
	/**createTime*/
	@Excel(name="createTime",format = "yyyy-MM-dd")
	private Date createTime;
	/**updateTime*/
	@Excel(name="updateTime",format = "yyyy-MM-dd")
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
	 *@return: java.lang.String  培训中心文章标题
	 */
	@Column(name ="TRAINING_TITLE",nullable=true,length=200)
	public String getTrainingTitle(){
		return this.trainingTitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  培训中心文章标题
	 */
	public void setTrainingTitle(String trainingTitle){
		this.trainingTitle = trainingTitle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  编辑人
	 */
	@Column(name ="TRAINING_EDITOR",nullable=true,length=100)
	public String getTrainingEditor(){
		return this.trainingEditor;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  编辑人
	 */
	public void setTrainingEditor(String trainingEditor){
		this.trainingEditor = trainingEditor;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  发布时间
	 */
	@Column(name ="TRAINING_PUBLISH_TIME",nullable=true)
	public Date getTrainingPublishTime(){
		return this.trainingPublishTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  发布时间
	 */
	public void setTrainingPublishTime(Date trainingPublishTime){
		this.trainingPublishTime = trainingPublishTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  缩略图
	 */
	@Column(name ="TRAINING_IMGURL",nullable=true,length=200)
	public String getTrainingImgurl(){
		return this.trainingImgurl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  缩略图
	 */
	public void setTrainingImgurl(String trainingImgurl){
		this.trainingImgurl = trainingImgurl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  培训中心文章内容
	 */
	@Column(name ="TRAINING_CONTENTS",nullable=true)
	public String getTrainingContents(){
		return this.trainingContents;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  培训中心文章内容
	 */
	public void setTrainingContents(String trainingContents){
		this.trainingContents = trainingContents;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  编号
	 */
	@Column(name ="TRAINING_SORT",nullable=true,length=10)
	public Integer getTrainingSort(){
		return this.trainingSort;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  编号
	 */
	public void setTrainingSort(Integer trainingSort){
		this.trainingSort = trainingSort;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  createTime
	 */
	@Column(name ="CREATE_TIME",nullable=true)
	public Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  createTime
	 */
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  updateTime
	 */
	@Column(name ="UPDATE_TIME",nullable=true)
	public Date getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  updateTime
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
