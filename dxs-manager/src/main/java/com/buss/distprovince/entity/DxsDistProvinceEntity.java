package com.buss.distprovince.entity;

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
 * @Description: dxs_dist_province
 * @author onlineGenerator
 * @date 2016-07-20 13:19:22
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_dist_province", schema = "")
@SuppressWarnings("serial")
public class DxsDistProvinceEntity implements java.io.Serializable {
	/**主键*/
	@Excel(name="主键")
	private Integer pid;
	/**省份ID*/
	@Excel(name="省份ID")
	private Integer provinceid;
	/**省份名称*/
	@Excel(name="省份名称")
	private String pname;
	
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  主键
	 */
	@Id
	@GenericGenerator(name = "generator", strategy = "uuid")
	@GeneratedValue (generator = "generator")
	@Column(name ="PID",nullable=false,length=5)
	public Integer getPid(){
		return this.pid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  主键
	 */
	public void setPid(Integer pid){
		this.pid = pid;
	}
	/**
	 *方法: 取得java.lang.Integer
	 *@return: java.lang.Integer  省份ID
	 */
	@Column(name ="PROVINCEID",nullable=false,length=7)
	public Integer getProvinceid(){
		return this.provinceid;
	}

	/**
	 *方法: 设置java.lang.Integer
	 *@param: java.lang.Integer  省份ID
	 */
	public void setProvinceid(Integer provinceid){
		this.provinceid = provinceid;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  省份名称
	 */
	@Column(name ="PNAME",nullable=false,length=15)
	public String getPname(){
		return this.pname;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  省份名称
	 */
	public void setPname(String pname){
		this.pname = pname;
	}
}
