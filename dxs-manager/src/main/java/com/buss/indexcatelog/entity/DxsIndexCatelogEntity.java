package com.buss.indexcatelog.entity;

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
 * @Description: dxs_index_catelog
 * @author onlineGenerator
 * @date 2016-07-12 16:38:40
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_index_catelog", schema = "")
@SuppressWarnings("serial")
public class DxsIndexCatelogEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**首页分类名称*/
	@Excel(name="首页分类名称")
	private String indexCatelogName;
	/**首页分类描述*/
	@Excel(name="首页分类描述")
	private String indexCatelogDescribe;
	/**首页分类配图*/
	@Excel(name="首页分类配图")
	private String indexCatelogImg;
	/**排序*/
	@Excel(name="排序")
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
	 *@return: java.lang.String  首页分类名称
	 */
	@Column(name ="INDEX_CATELOG_NAME",nullable=true,length=200)
	public String getIndexCatelogName(){
		return this.indexCatelogName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  首页分类名称
	 */
	public void setIndexCatelogName(String indexCatelogName){
		this.indexCatelogName = indexCatelogName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  首页分类描述
	 */
	@Column(name ="INDEX_CATELOG_DESCRIBE",nullable=true,length=200)
	public String getIndexCatelogDescribe(){
		return this.indexCatelogDescribe;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  首页分类描述
	 */
	public void setIndexCatelogDescribe(String indexCatelogDescribe){
		this.indexCatelogDescribe = indexCatelogDescribe;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  首页分类配图
	 */
	@Column(name ="INDEX_CATELOG_IMG",nullable=true,length=100)
	public String getIndexCatelogImg(){
		return this.indexCatelogImg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  首页分类配图
	 */
	public void setIndexCatelogImg(String indexCatelogImg){
		this.indexCatelogImg = indexCatelogImg;
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
