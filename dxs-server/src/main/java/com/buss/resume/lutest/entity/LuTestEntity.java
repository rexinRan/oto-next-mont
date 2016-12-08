package com.buss.resume.lutest.entity;

import com.buss.resume.resumetemplate.entity.ResumeTemplateEntity;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * @Title: Entity
 * @Description: dxs_resume
 * @author onlineGenerator
 * @date 2016-08-22 13:28:46
 * @version V1.0
 *
 */
@Entity
@Table(name = "lu_test", schema = "")
@SuppressWarnings("serial")
public class LuTestEntity implements java.io.Serializable {

	private String id;

	private String title;

	private String content;


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

	@Column(name ="TITLE",nullable=true,length=100)
	public String getTitle(){
		return this.title;
	}


	public void setTitle(String title){
		this.title = title;
	}


	@Column(name ="CONTENT",nullable=true,length=1000)
	public String getContent(){
		return this.content;
	}


	public void setContent(String content){
		this.content = content;
	}

}
