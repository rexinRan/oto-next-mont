package com.buss.careerguidancecatalog.entity;

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
 * @Description: dxs_career_guidance_catalog
 * @author onlineGenerator
 * @date 2016-08-24 13:52:17
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_career_guidance_catalog", schema = "")
@SuppressWarnings("serial")
public class DxsCareerGuidanceCatalogEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**职场引导的名称*/
	@Excel(name="职场引导的名称")
	private String cgCatelogName;
	/**职场引导的描述*/
	@Excel(name="职场引导的描述")
	private String cgCatelogDescribe;
	/**职场引导分类的配图*/
	@Excel(name="职场引导分类的配图")
	private String cgCatelogImg;
	/**职场引导分类显示位置*/
	@Excel(name="职场引导分类显示位置")
	private Integer cgCatelogPosition;
	/**父id*/
	@Excel(name="父id")
	private String pid;
	/**职场引导分类的创建时间*/
	@Excel(name="职场引导分类的创建时间",format = "yyyy-MM-dd")
	private Date createTime;
	/**职场引导分类的修改时间*/
	@Excel(name="职场引导分类的修改时间",format = "yyyy-MM-dd")
	private Date updateTime;
	/**删除标志*/
	@Excel(name="删除标志")
	private Integer isDelete;
	/**排序*/
	@Excel(name="排序")
	private Integer sort;
	
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
	 *@return: java.lang.String  职场引导的名称
	 */
	@Column(name ="CG_CATELOG_NAME",nullable=true,length=200)
	public String getCgCatelogName(){
		return this.cgCatelogName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职场引导的名称
	 */
	public void setCgCatelogName(String cgCatelogName){
		this.cgCatelogName = cgCatelogName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职场引导的描述
	 */
	@Column(name ="CG_CATELOG_DESCRIBE",nullable=true,length=200)
	public String getCgCatelogDescribe(){
		return this.cgCatelogDescribe;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职场引导的描述
	 */
	public void setCgCatelogDescribe(String cgCatelogDescribe){
		this.cgCatelogDescribe = cgCatelogDescribe;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  职场引导分类的配图
	 */
	@Column(name ="CG_CATELOG_IMG",nullable=true,length=100)
	public String getCgCatelogImg(){
		return this.cgCatelogImg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  职场引导分类的配图
	 */
	public void setCgCatelogImg(String cgCatelogImg){
		this.cgCatelogImg = cgCatelogImg;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  职场引导分类显示位置
	 */
	@Column(name ="CG_CATELOG_POSITION",nullable=true,length=10)
	public Integer getCgCatelogPosition(){
		return this.cgCatelogPosition;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  职场引导分类显示位置
	 */
	public void setCgCatelogPosition(Integer cgCatelogPosition){
		this.cgCatelogPosition = cgCatelogPosition;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  父id
	 */
	@Column(name ="PID",nullable=true,length=32)
	public String getPid(){
		return this.pid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  父id
	 */
	public void setPid(String pid){
		this.pid = pid;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  职场引导分类的创建时间
	 */
	@Column(name ="CREATE_TIME",nullable=true)
	public Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  职场引导分类的创建时间
	 */
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  职场引导分类的修改时间
	 */
	@Column(name ="UPDATE_TIME",nullable=true)
	public Date getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  职场引导分类的修改时间
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
	 *@return: java.lang.Integer  排序
	 */
	@Column(name ="SORT",nullable=true,length=10)
	public Integer getSort(){
		return this.sort;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  排序
	 */
	public void setSort(Integer sort){
		this.sort = sort;
	}
}
