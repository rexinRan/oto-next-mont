	package com.buss.traintest.entity;

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
 * @Description: dxs_train_test
 * @author onlineGenerator
 * @date 2016-09-08 11:58:29
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_train_test", schema = "")
@SuppressWarnings("serial")
public class DxsTrainTestEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**题目总数*/
	@Excel(name="题目总数")
	private Integer tiNum;
	/**试题分类*/
	@Excel(name="试题分类")
	private String ttcId;
	/**试题名称*/
	@Excel(name="试题名称")
	private String tiName;
	/**缩略图*/
	@Excel(name="缩略图")
	private String imgUrl;
	/**摘要(预留)*/
	@Excel(name="摘要(预留)")
	private String tSummary;
	/**介绍*/
	@Excel(name="介绍")
	private String tiIntroduce;
	/**答题须知*/
	@Excel(name="答题须知")
	private String requested;
	/**计分类型*/
	@Excel(name="计分类型")
	private Integer scoreType;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  题目总数
	 */
	@Column(name ="TI_NUM",nullable=true,length=10)
	public Integer getTiNum(){
		return this.tiNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  题目总数
	 */
	public void setTiNum(Integer tiNum){
		this.tiNum = tiNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  试题分类
	 */
	@Column(name ="TTC_ID",nullable=true,length=32)
	public String getTtcId(){
		return this.ttcId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  试题分类
	 */
	public void setTtcId(String ttcId){
		this.ttcId = ttcId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  试题名称
	 */
	@Column(name ="T_NAME",nullable=true)
	public String getTiName(){
		return this.tiName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  试题名称
	 */
	public void setTiName(String tiName){
		this.tiName = tiName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  缩略图
	 */
	@Column(name ="IMG_URL",nullable=true,length=255)
	public String getImgUrl(){
		return this.imgUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  缩略图
	 */
	public void setImgUrl(String imgUrl){
		this.imgUrl = imgUrl;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  摘要(预留)
	 */
	@Column(name ="T_SUMMARY",nullable=true,length=255)
	public String getTSummary(){
		return this.tSummary;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  摘要(预留)
	 */
	public void setTSummary(String tSummary){
		this.tSummary = tSummary;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  介绍
	 */
	@Column(name ="T_INTRODUCE",nullable=true,length=255)
	public String getTiIntroduce(){
		return this.tiIntroduce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  介绍
	 */
	public void setTiIntroduce(String tiIntroduce){
		this.tiIntroduce = tiIntroduce;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  答题须知
	 */
	@Column(name ="REQUESTED",nullable=true,length=16777215)
	public String getRequested(){
		return this.requested;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  答题须知
	 */
	public void setRequested(String requested){
		this.requested = requested;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  计分类型
	 */
	@Column(name ="SCORE_TYPE",nullable=true,length=3)
	public Integer getScoreType(){
		return this.scoreType;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  计分类型
	 */
	public void setScoreType(Integer scoreType){
		this.scoreType = scoreType;
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
