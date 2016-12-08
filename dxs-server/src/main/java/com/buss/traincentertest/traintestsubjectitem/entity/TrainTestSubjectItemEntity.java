package com.buss.traincentertest.traintestsubjectitem.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: dxs_train_test_subject_item
 * @author onlineGenerator
 * @date 2016-09-08 11:56:25
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_train_test_subject_item", schema = "")
@SuppressWarnings("serial")
public class TrainTestSubjectItemEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**试题ID*/

	private String ttsId;
	/**试题项内容*/

	private String itemName;
	/**测试偏向*/

	private String itemObject;
	/**编号*/

	private Integer sort;
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
	 *@return: java.lang.String  试题ID
	 */
	@Column(name ="TTS_ID",nullable=true,length=32)
	public String getTtsId(){
		return this.ttsId;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  试题ID
	 */
	public void setTtsId(String ttsId){
		this.ttsId = ttsId;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  试题项内容
	 */
	@Column(name ="ITEM_NAME",nullable=true,length=255)
	public String getItemName(){
		return this.itemName;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  试题项内容
	 */
	public void setItemName(String itemName){
		this.itemName = itemName;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  测试偏向
	 */
	@Column(name ="ITEM_OBJECT",nullable=true,length=255)
	public String getItemObject(){
		return this.itemObject;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  测试偏向
	 */
	public void setItemObject(String itemObject){
		this.itemObject = itemObject;
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
