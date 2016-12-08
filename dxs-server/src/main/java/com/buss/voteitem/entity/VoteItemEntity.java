package com.buss.voteitem.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: dxs_vote_item
 * @author onlineGenerator
 * @date 2016-07-18 15:14:23
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_vote_item", schema = "")
@SuppressWarnings("serial")
public class VoteItemEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**投票id*/

	private String voteId;
	/**投票项图片*/

	private String itemImage;
	/**投票项标题*/

	private String viTitle;
	/**投票项图片*/

	private Integer itemNum;
	/**投票内容*/

	private String viContent;
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
	 *@return: java.lang.String  投票项图片
	 */
	@Column(name ="ITEM_IMAGE",nullable=true,length=200)
	public String getItemImage(){
		return this.itemImage;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  投票项图片
	 */
	public void setItemImage(String itemImage){
		this.itemImage = itemImage;
	}
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
	 *@return: java.lang.String  投票项标题
	 */
	@Column(name ="VI_TITLE",nullable=true,length=200)
	public String getViTitle(){
		return this.viTitle;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  投票项标题
	 */
	public void setViTitle(String viTitle){
		this.viTitle = viTitle;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  投票内容
	 */
	@Column(name ="VI_CONTENT",nullable=true,length=255)
	public String getViContent(){
		return this.viContent;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  投票内容
	 */
	public void setViContent(String viContent){
		this.viContent = viContent;
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
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  投票数
	 */
	@Column(name ="ITEM_NUM",nullable=true,length=11)
	public Integer getItemNum(){
		return this.itemNum;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  投票数
	 */
	public void setItemNum(Integer itemNum){
		this.itemNum = itemNum;
	}
}
