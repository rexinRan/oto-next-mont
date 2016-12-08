package com.buss.quizuser.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.lang.String;
import java.lang.Double;
import java.lang.Integer;
import java.math.BigDecimal;
import javax.persistence.*;
import javax.xml.soap.Text;
import java.sql.Blob;

import com.buss.quiz.entity.DxsQuizEntity;
import com.buss.user.entity.DxsUserEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;
import org.jeecgframework.poi.excel.annotation.Excel;

/**   
 * @Title: Entity
 * @Description: dxs_quiz_user
 * @author onlineGenerator
 * @date 2016-06-16 09:33:13
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_quiz_user", schema = "")
@SuppressWarnings("serial")
public class DxsQuizUserEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**用户id*/
	@Excel(name="用户id")
	private String userId;
	/**试卷id*/
	@Excel(name="试卷id")
	private String quizId;
	/**结果处理类型*/
	@Excel(name="结果处理类型")
	private Integer resulttype;
	/**结果*/
	@Excel(name="结果")
	private String result;
	/**结果报告地址*/
	@Excel(name="结果报告地址")
	private String resultUrl;
	/**创建时间*/
	@Excel(name="创建时间",format = "yyyy-MM-dd")
	private Date createTime;
	/**更新时间*/
	@Excel(name="更新时间",format = "yyyy-MM-dd")
	private Date updateTime;
	/**删除标志*/
	@Excel(name="删除标志")
	private Integer isDelete;

	private DxsQuizEntity dxsQuizEntity;

	private DxsUserEntity dxsUserEntity;
	
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
	 *@return: java.lang.String  用户id
	 */
	@Column(name ="USER_ID",nullable=true,length=32)
	public String getUserId(){
		return this.userId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  用户id
	 */
	public void setUserId(String userId){
		this.userId = userId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  试卷id
	 */
	@Column(name ="QUIZ_ID",nullable=true,length=32)
	public String getQuizId(){
		return this.quizId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  试卷id
	 */
	public void setQuizId(String quizId){
		this.quizId = quizId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  结果处理类型
	 */
	@Column(name ="RESULTTYPE",nullable=true,length=10)
	public Integer getResulttype(){
		return this.resulttype;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  结果处理类型
	 */
	public void setResulttype(Integer resulttype){
		this.resulttype = resulttype;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结果
	 */
	@Column(name ="RESULT",nullable=true,length=200)
	public String getResult(){
		return this.result;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结果
	 */
	public void setResult(String result){
		this.result = result;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  结果报告地址
	 */
	@Column(name ="RESULT_URL",nullable=true,length=255)
	public String getResultUrl(){
		return this.resultUrl;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  结果报告地址
	 */
	public void setResultUrl(String resultUrl){
		this.resultUrl = resultUrl;
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
	@JoinColumn(name = "quiz_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)
	public DxsQuizEntity getDxsQuizEntity() {
		return dxsQuizEntity;
	}

	public void setDxsQuizEntity(DxsQuizEntity dxsQuizEntity) {
		this.dxsQuizEntity = dxsQuizEntity;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", insertable=false, updatable = false)
	@NotFound(action= NotFoundAction.IGNORE)
	public DxsUserEntity getDxsUserEntity() {
		return dxsUserEntity;
	}

	public void setDxsUserEntity(DxsUserEntity dxsUserEntity) {
		this.dxsUserEntity = dxsUserEntity;
	}
}
