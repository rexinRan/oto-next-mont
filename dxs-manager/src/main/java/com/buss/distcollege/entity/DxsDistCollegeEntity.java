package com.buss.distcollege.entity;

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
 * @Description: dxs_dist_college
 * @author onlineGenerator
 * @date 2016-07-20 17:00:34
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_dist_college", schema = "")
@SuppressWarnings("serial")
public class DxsDistCollegeEntity implements java.io.Serializable {
	/**主键*/
	@Excel(name="主键")
	private Integer coid;
	/**大学名称*/
	@Excel(name="大学名称")
	private String name;
	/**省份id*/
	@Excel(name="省份id")
	private Integer provinceid;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  主键
	 */
	@Id
	@GenericGenerator(name = "generator", strategy = "uuid")
	@GeneratedValue (generator = "generator")
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
