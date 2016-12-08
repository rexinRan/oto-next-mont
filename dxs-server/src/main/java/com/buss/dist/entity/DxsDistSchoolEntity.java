package com.buss.dist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**   
 * @Title: Entity
 * @Description: dxs_dist_school
 * @author onlineGenerator
 * @date 2016-07-19 15:46:34
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_dist_school", schema = "")
@SuppressWarnings("serial")
public class DxsDistSchoolEntity implements java.io.Serializable {
	/**主键*/
	private Integer scid;
	/**院系名称*/
	private String name;
	/**大学id*/
	private Integer collegeid;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  主键
	 */
	@Id
	@Column(name ="SCID",nullable=false,length=10)
	public Integer getScid(){
		return this.scid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  主键
	 */
	public void setScid(Integer scid){
		this.scid = scid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  院系名称
	 */
	@Column(name ="NAME",nullable=false,length=100)
	public String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  院系名称
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  大学id
	 */
	@Column(name ="COLLEGEID",nullable=false,length=5)
	public Integer getCollegeid(){
		return this.collegeid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  大学id
	 */
	public void setCollegeid(Integer collegeid){
		this.collegeid = collegeid;
	}
}
