package com.buss.quizitems.entity;

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
 * @Description: dxs_quiz_items
 * @author onlineGenerator
 * @date 2016-06-02 10:40:29
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_quiz_items", schema = "")
@SuppressWarnings("serial")
public class DxsQuizItemsEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**试卷主键*/
	@Excel(name="试卷主键")
	private String quizId;
	/**本题内容*/
	@Excel(name="本题内容")
	private String quizItemContent;
	/**本题答案*/
	@Excel(name="本题答案")
	private String quizItemAnswer;
	/**本题解析*/
	@Excel(name="本题解析")
	private String quizItemAnswerIntroduce;
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
	 *@return: java.lang.String  试卷主键
	 */
	@Column(name ="QUIZ_ID",nullable=true,length=32)
	public String getQuizId(){
		return this.quizId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  试卷主键
	 */
	public void setQuizId(String quizId){
		this.quizId = quizId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  本题内容
	 */
	@Column(name ="QUIZ_ITEM_CONTENT",nullable=true,length=255)
	public java.lang.String getQuizItemContent(){
		return this.quizItemContent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  本题内容
	 */
	public void setQuizItemContent(java.lang.String quizItemContent){
		this.quizItemContent = quizItemContent;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  本题答案
	 */
	@Column(name ="QUIZ_ITEM_ANSWER",nullable=true,length=255)
	public java.lang.String getQuizItemAnswer(){
		return this.quizItemAnswer;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  本题答案
	 */
	public void setQuizItemAnswer(java.lang.String quizItemAnswer){
		this.quizItemAnswer = quizItemAnswer;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  本题解析
	 */
	@Column(name ="QUIZ_ITEM_ANSWER_INTRODUCE",nullable=true)
	public String getQuizItemAnswerIntroduce(){
		return this.quizItemAnswerIntroduce;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  本题解析
	 */
	public void setQuizItemAnswerIntroduce(String quizItemAnswerIntroduce){
		this.quizItemAnswerIntroduce = quizItemAnswerIntroduce;
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
