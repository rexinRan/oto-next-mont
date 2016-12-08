package com.buss.traincentertest.traintestitemopposite.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

/**   
 * @Title: Entity
 * @Description: dxs_train_test_item_opposite
 * @author onlineGenerator
 * @date 2016-09-09 17:08:37
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_train_test_item_opposite", schema = "")
@SuppressWarnings("serial")
public class TrainTestItemOppositeEntity implements java.io.Serializable {
	/**主键*/
	private String id;
	/**试卷id*/

	private String ttId;
	/**正*/

	private String just;
	/**反*/

	private String back;
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
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  正
	 */
	@Column(name ="JUST",nullable=true,length=2)
	public String getJust(){
		return this.just;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  正
	 */
	public void setJust(String just){
		this.just = just;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  反
	 */
	@Column(name ="BACK",nullable=true,length=2)
	public String getBack(){
		return this.back;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  反
	 */
	public void setBack(String back){
		this.back = back;
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
