package com.buss.dist.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**   
 * @Title: Entity
 * @Description: dxs_dist_college
 * @author onlineGenerator
 * @date 2016-07-19 15:45:34
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_dist_college", schema = "")
@SuppressWarnings("serial")
public class DxsDistCollegeEntity implements java.io.Serializable {
	/**主键*/
	private Integer coid;
	/**大学名称*/
	private String name;
	/**省份id*/
	private Integer provinceid;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  主键
	 */
	@Id
	@Column(name ="COID",nullable=false,length=5)
	public Integer getCoid(){
		return this.coid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  主键
	 */
	public void setCoid(Integer coid){
		this.coid = coid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  大学名称
	 */
	@Column(name ="NAME",nullable=false,length=100)
	public String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  大学名称
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  省份id
	 */
	@Column(name ="PROVINCEID",nullable=false,length=7)
	public Integer getProvinceid(){
		return this.provinceid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  省份id
	 */
	public void setProvinceid(Integer provinceid){
		this.provinceid = provinceid;
	}
}
