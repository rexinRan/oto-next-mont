package com.buss.messageuser.entity;

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
 * @Description: dxs_message_user
 * @author onlineGenerator
 * @date 2016-09-20 10:19:20
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_message_user", schema = "")
@SuppressWarnings("serial")
public class DxsMessageUserEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**用户id*/

	private String userId;
	/**站内信id*/

	private String mId;
	/**是否已读*/

	private Integer isRead;
	/**阅读时间*/

	private Date readTime;
	/**是否放到回收站(预留)*/

	private Integer isRubbish;
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
	 *@return: java.lang.String  站内信id
	 */
	@Column(name ="M_ID",nullable=true,length=32)
	public String getMId(){
		return this.mId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  站内信id
	 */
	public void setMId(String mId){
		this.mId = mId;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否已读
	 */
	@Column(name ="IS_READ",nullable=true,length=3)
	public Integer getIsRead(){
		return this.isRead;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否已读
	 */
	public void setIsRead(Integer isRead){
		this.isRead = isRead;
	}
	/**
	 *方法: 取得java.util.Date
	 *@return: java.util.Date  阅读时间
	 */
	@Column(name ="READ_TIME",nullable=true)
	public Date getReadTime(){
		return this.readTime;
	}

	/**
	 *方法: 设置java.util.Date
	 *@param: java.util.Date  阅读时间
	 */
	public void setReadTime(Date readTime){
		this.readTime = readTime;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  是否放到回收站(预留)
	 */
	@Column(name ="IS_RUBBISH",nullable=true,length=3)
	public Integer getIsRubbish(){
		return this.isRubbish;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  是否放到回收站(预留)
	 */
	public void setIsRubbish(Integer isRubbish){
		this.isRubbish = isRubbish;
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
