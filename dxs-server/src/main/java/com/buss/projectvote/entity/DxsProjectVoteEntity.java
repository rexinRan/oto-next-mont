package com.buss.projectvote.entity;

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


/**   
 * @Title: Entity
 * @Description: dxs_project_vote
 * @author onlineGenerator
 * @date 2016-06-23 10:48:30
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_project_vote", schema = "dxsdb")
@SuppressWarnings("serial")
public class DxsProjectVoteEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**用户id*/

	private String userId;
	/**项目id*/

	private String projectId;
	/**投票的时间*/

	private Date voteTime;
	/**投票状态*/

	private String voteStatus;
	/**创建时间*/

	private Date createTime;
	/**修改时间*/

	private Date updateTime;
	/**删除标志*/

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
	 *@return: java.lang.String  项目id
	 */
	@Column(name ="PROJECT_ID",nullable=true,length=32)
	public String getProjectId(){
		return this.projectId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  项目id
	 */
	public void setProjectId(String projectId){
		this.projectId = projectId;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  投票的时间
	 */
	@Column(name ="VOTE_TIME",nullable=true)
	public Date getVoteTime(){
		return this.voteTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  投票的时间
	 */
	public void setVoteTime(Date voteTime){
		this.voteTime = voteTime;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  投票状态
	 */
	@Column(name ="VOTE_STATUS",nullable=true,length=3)
	public String getVoteStatus(){
		return this.voteStatus;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  投票状态
	 */
	public void setVoteStatus(String voteStatus){
		this.voteStatus = voteStatus;
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
	 *@return: java.util.Date  修改时间
	 */
	@Column(name ="UPDATE_TIME",nullable=true)
	public Date getUpdateTime(){
		return this.updateTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  修改时间
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
