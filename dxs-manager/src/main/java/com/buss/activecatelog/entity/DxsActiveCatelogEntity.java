package com.buss.activecatelog.entity;

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
 * @Description: dxs_active_catelog
 * @author onlineGenerator
 * @date 2016-06-01 14:02:55
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_active_catelog", schema = "")
@SuppressWarnings("serial")
public class DxsActiveCatelogEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**活动种类名称*/
	@Excel(name="活动种类名称")
	private String activeCatelogName;
	/**菜单类型*/
	@Excel(name="菜单类型")
	private java.lang.String pid;
	/**活动种类配图*/
	@Excel(name="活动种类配图")
	private String activeCatelogImg;
	/**活动种类的描述*/
	@Excel(name="活动种类的描述")
	private String activeCatelogDescribe;
	/**活动种类的排序*/
	@Excel(name="活动种类的排序")
	private Integer activeCatelogSort;
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
	 *@return: java.lang.String  活动种类名称
	 */
	@Column(name ="ACTIVE_CATELOG_NAME",nullable=true,length=100)
	public String getActiveCatelogName(){
		return this.activeCatelogName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动种类名称
	 */
	public void setActiveCatelogName(String activeCatelogName){
		this.activeCatelogName = activeCatelogName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  菜单类型
	 */
	@Column(name ="PID",nullable=true,length=10)
	public java.lang.String getPid(){
		return this.pid;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  菜单类型
	 */
	public void setPid(java.lang.String pid){
		this.pid = pid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动种类配图
	 */
	@Column(name ="ACTIVE_CATELOG_IMG",nullable=true,length=100)
	public String getActiveCatelogImg(){
		return this.activeCatelogImg;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动种类配图
	 */
	public void setActiveCatelogImg(String activeCatelogImg){
		this.activeCatelogImg = activeCatelogImg;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  活动种类的描述
	 */
	@Column(name ="ACTIVE_CATELOG_DESCRIBE",nullable=true,length=200)
	public String getActiveCatelogDescribe(){
		return this.activeCatelogDescribe;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  活动种类的描述
	 */
	public void setActiveCatelogDescribe(String activeCatelogDescribe){
		this.activeCatelogDescribe = activeCatelogDescribe;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  活动种类的排序
	 */
	@Column(name ="ACTIVE_CATELOG_SORT",nullable=true,length=10)
	public Integer getActiveCatelogSort(){
		return this.activeCatelogSort;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  活动种类的排序
	 */
	public void setActiveCatelogSort(Integer activeCatelogSort){
		this.activeCatelogSort = activeCatelogSort;
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
