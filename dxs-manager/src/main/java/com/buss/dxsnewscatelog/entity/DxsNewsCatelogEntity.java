package com.buss.dxsnewscatelog.entity;

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
 * @Description: dxs_news_catelog
 * @author onlineGenerator
 * @date 2016-06-01 10:40:14
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_news_catelog", schema = "")
@SuppressWarnings("serial")
public class DxsNewsCatelogEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**新闻分类的名称*/
	@Excel(name="新闻分类的名称")
	private String newCatelogName;
	/**新闻分类的描述*/
	@Excel(name="新闻分类的描述")
	private String newCatelogDescribe;
	/**新闻分类的配图*/
	@Excel(name="新闻分类的配图")
	private String newCatelogImg;
	/**新闻分类显示位置*/
	@Excel(name="新闻分类显示位置")
	private java.lang.Integer newCatelogPosition;
	/**新闻分类的创建时间*/
	@Excel(name="新闻分类的创建时间",format = "yyyy-MM-dd")
	private Date createTime;
	/**新闻分类的修改时间*/
	@Excel(name="新闻分类的修改时间",format = "yyyy-MM-dd")
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
	 *@return: java.lang.String  新闻分类的名称
	 */
	@Column(name ="NEW_CATELOG_NAME",nullable=true,length=200)
	public String getNewCatelogName(){
		return this.newCatelogName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  新闻分类的名称
	 */
	public void setNewCatelogName(String newCatelogName){
		this.newCatelogName = newCatelogName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  新闻分类的描述
	 */
	@Column(name ="NEW_CATELOG_DESCRIBE",nullable=true,length=200)
	public String getNewCatelogDescribe(){
		return this.newCatelogDescribe;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  新闻分类的描述
	 */
	public void setNewCatelogDescribe(String newCatelogDescribe){
		this.newCatelogDescribe = newCatelogDescribe;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  新闻分类的配图
	 */
	@Column(name ="NEW_CATELOG_IMG",nullable=true,length=100)
	public String getNewCatelogImg(){
		return this.newCatelogImg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  新闻分类的配图
	 */
	public void setNewCatelogImg(String newCatelogImg){
		this.newCatelogImg = newCatelogImg;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  新闻分类显示位置
	 */
	@Column(name ="NEW_CATELOG_POSITION",nullable=true,length=10)
	public java.lang.Integer getNewCatelogPosition(){
		return this.newCatelogPosition;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  新闻分类显示位置
	 */
	public void setNewCatelogPosition(java.lang.Integer newCatelogPosition){
		this.newCatelogPosition = newCatelogPosition;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  新闻分类的创建时间
	 */
	@Column(name ="CREATE_TIME",nullable=true)
	public Date getCreateTime(){
		return this.createTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  新闻分类的创建时间
	 */
	public void setCreateTime(Date createTime){
		this.createTime = createTime;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  新闻分类的修改时间
	 */
	@Column(name ="UPDATE_TIME",nullable=true)
	public Date getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  新闻分类的修改时间
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
