package com.buss.voteuser.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: dxs_vote_user
 * @author onlineGenerator
 * @date 2016-07-18 15:12:43
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_vote_user", schema = "")
@SuppressWarnings("serial")
public class VoteUserEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**用户id*/

	private String userId;
	/**投票id*/

	private String voteId;
	/**投票项id*/

	private String viItem;

	/**投票时间*/
	private Date viTime;

	/**当前活动投票数*/

	private Integer viNum;
	/**创建时间*/

	private Date createTime;
	/**更新时间*/

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
	 *@return: java.lang.String  投票id
	 */
	@Column(name ="VOTE_ID",nullable=true,length=32)
	public String getVoteId(){
		return this.voteId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  投票id
	 */
	public void setVoteId(String voteId){
		this.voteId = voteId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  投票项id
	 */
	@Column(name ="VI_ITEM",nullable=true,length=32)
	public String getViItem(){
		return this.viItem;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  投票项id
	 */
	public void setViItem(String viItem){
		this.viItem = viItem;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  当前投票数
	 */
	@Column(name ="VI_NUM",nullable=true,length=10)
	public Integer getViNum(){
		return this.viNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  当前投票数
	 */
	public void setViNum(Integer viNum){
		this.viNum = viNum;
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
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  t投票时间
	 */
	@Column(name ="VI_TIME",nullable=true)
	public Date getViTime(){
		return this.viTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  t投票时间
	 */
	public void setViTime(Date viTime){
		this.viTime = viTime;
	}
}
