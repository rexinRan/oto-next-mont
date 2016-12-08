package com.buss.company.entity;

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
 * @Description: dxs_company
 * @author onlineGenerator
 * @date 2016-06-02 16:51:54
 * @version V1.0   
 *
 */
@Entity
@Table(name = "dxs_company", schema = "")
@SuppressWarnings("serial")
public class DxsCompanyEntity implements java.io.Serializable {
	/**id*/
	private String id;
	/**公司信息*/
	@Excel(name="公司信息")
	private String name;
	/**公司简介*/
	@Excel(name="公司简介")
	private String about;
	/**电话*/
	@Excel(name="电话")
	private String groupTel;
	/**集团客服中心电话*/
	@Excel(name="集团客服中心电话")
	private String groupServiceTel;
	/**俱乐部邮箱*/
	@Excel(name="俱乐部邮箱")
	private String advertiseEmail;
	/**集团总部位置*/
	@Excel(name="集团总部位置")
	private String groupAddress;
	/**版权信息*/
	@Excel(name="版权信息")
	private String copyright;
	/**备案信息*/
	@Excel(name="备案信息")
	private String record;
	/**微信公众号*/
	@Excel(name="微信公众号")
	private String ext1;
	/**俱乐部网站*/
	@Excel(name="俱乐部网站")
	private String ext2;
	/**传媒网址*/
	@Excel(name="传媒网址")
	private String ext3;
	/**集团网站*/
	@Excel(name="集团网站")
	private String ext4;
	/**集团总部*/
	@Excel(name="集团总部")
	private String ext5;
	/**ext6*/
	@Excel(name="ext6")
	private String ext6;
	
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  id
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
	 *@param: java.lang.String  id
	 */
	public void setId(String id){
		this.id = id;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司信息
	 */
	@Column(name ="NAME",nullable=true,length=255)
	public String getName(){
		return this.name;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司信息
	 */
	public void setName(String name){
		this.name = name;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  公司简介
	 */
	@Column(name ="ABOUT",nullable=true,length=5000)
	public String getAbout(){
		return this.about;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  公司简介
	 */
	public void setAbout(String about){
		this.about = about;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  电话
	 */
	@Column(name ="GROUP_TEL",nullable=true,length=255)
	public String getGroupTel(){
		return this.groupTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  电话
	 */
	public void setGroupTel(String groupTel){
		this.groupTel = groupTel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  集团客服中心电话
	 */
	@Column(name ="GROUP_SERVICE_TEL",nullable=true,length=255)
	public String getGroupServiceTel(){
		return this.groupServiceTel;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  集团客服中心电话
	 */
	public void setGroupServiceTel(String groupServiceTel){
		this.groupServiceTel = groupServiceTel;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  俱乐部邮箱
	 */
	@Column(name ="ADVERTISE_EMAIL",nullable=true,length=255)
	public String getAdvertiseEmail(){
		return this.advertiseEmail;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  俱乐部邮箱
	 */
	public void setAdvertiseEmail(String advertiseEmail){
		this.advertiseEmail = advertiseEmail;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  集团总部位置
	 */
	@Column(name ="GROUP_ADDRESS",nullable=true,length=255)
	public String getGroupAddress(){
		return this.groupAddress;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  集团总部位置
	 */
	public void setGroupAddress(String groupAddress){
		this.groupAddress = groupAddress;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  版权信息
	 */
	@Column(name ="COPYRIGHT",nullable=true,length=255)
	public String getCopyright(){
		return this.copyright;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  版权信息
	 */
	public void setCopyright(String copyright){
		this.copyright = copyright;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  备案信息
	 */
	@Column(name ="RECORD",nullable=true,length=255)
	public String getRecord(){
		return this.record;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  备案信息
	 */
	public void setRecord(String record){
		this.record = record;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  微信公众号
	 */
	@Column(name ="EXT1",nullable=true,length=255)
	public String getExt1(){
		return this.ext1;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  微信公众号
	 */
	public void setExt1(String ext1){
		this.ext1 = ext1;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  俱乐部网站
	 */
	@Column(name ="EXT2",nullable=true,length=255)
	public String getExt2(){
		return this.ext2;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  俱乐部网站
	 */
	public void setExt2(String ext2){
		this.ext2 = ext2;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  传媒网址
	 */
	@Column(name ="EXT3",nullable=true,length=255)
	public String getExt3(){
		return this.ext3;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  传媒网址
	 */
	public void setExt3(String ext3){
		this.ext3 = ext3;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  集团网站
	 */
	@Column(name ="EXT4",nullable=true,length=255)
	public String getExt4(){
		return this.ext4;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  集团网站
	 */
	public void setExt4(String ext4){
		this.ext4 = ext4;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  集团总部
	 */
	@Column(name ="EXT5",nullable=true,length=255)
	public String getExt5(){
		return this.ext5;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  集团总部
	 */
	public void setExt5(String ext5){
		this.ext5 = ext5;
	}
	/**
	 *方法: 取得java.lang.String
	 *@return: java.lang.String  ext6
	 */
	@Column(name ="EXT6",nullable=true)
	public String getExt6(){
		return this.ext6;
	}

	/**
	 *方法: 设置java.lang.String
	 *@param: java.lang.String  ext6
	 */
	public void setExt6(String ext6){
		this.ext6 = ext6;
	}
}
