package com.buss.traintestsubject.entity;

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
 * @Description: dxs_train_test_subject
 * @author onlineGenerator
 * @date 2016-09-08 11:56:53
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_train_test_subject", schema = "")
@SuppressWarnings("serial")
public class DxsTrainTestSubjectEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**试卷id*/
	@Excel(name="试卷id")
	private String ttId;
	/**题号*/
	@Excel(name="题号")
	private Integer subjectNum;
	/**试题内容*/
	@Excel(name="试题内容")
	private String subjectContent;
	/**测试项(预留)*/
	@Excel(name="测试项(预留)")
	private String testContent;
	/**试题组*/
	@Excel(name="试题组")
	private String subjectGroup;
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
	 *@return: java.lang.String  试卷id
	 */
	@Column(name ="TT_ID",nullable=true,length=32)
	public String getTtId(){
		return this.ttId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  试卷id
	 */
	public void setTtId(String ttId){
		this.ttId = ttId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  题号
	 */
	@Column(name ="SUBJECT_NUM",nullable=true,length=10)
	public Integer getSubjectNum(){
		return this.subjectNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  题号
	 */
	public void setSubjectNum(Integer subjectNum){
		this.subjectNum = subjectNum;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  试题内容
	 */
	@Column(name ="SUBJECT_CONTENT",nullable=true,length=255)
	public String getSubjectContent(){
		return this.subjectContent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  试题内容
	 */
	public void setSubjectContent(String subjectContent){
		this.subjectContent = subjectContent;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  测试项(预留)
	 */
	@Column(name ="TEST_CONTENT",nullable=true,length=50)
	public String getTestContent(){
		return this.testContent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  测试项(预留)
	 */
	public void setTestContent(String testContent){
		this.testContent = testContent;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  试题组
	 */
	@Column(name ="SUBJECT_GROUP",nullable=true,length=100)
	public String getSubjectGroup(){
		return this.subjectGroup;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  试题组
	 */
	public void setSubjectGroup(String subjectGroup){
		this.subjectGroup = subjectGroup;
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
}
