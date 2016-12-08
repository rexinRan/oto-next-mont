package com.buss.authentication.trans.vo;

import org.jweb.core.bean.BaseVO;

import java.util.List;


public class TutorVO extends BaseVO {
	/**主键*/
	private  String id;
	/**姓名*/
	private  String name;
	/**学历*/
	private  String schoolEducation;
	/**毕业院校*/
	private  String school;
	/**专业技能*/
	private  String skills;
	/**现任职务*/
	private  String position;
	/**就职单位*/
	private List jobSchoolList;
	/**头像*/
	private  String image;
	/**是否关注过*/
	private String isCollention;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchoolEducation() {
		return schoolEducation;
	}

	public void setSchoolEducation(String schoolEducation) {
		this.schoolEducation = schoolEducation;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public List getJobSchoolList() {
		return jobSchoolList;
	}

	public void setJobSchoolList(List jobSchoolList) {
		this.jobSchoolList = jobSchoolList;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getIsCollention() {
		return isCollention;
	}

	public void setIsCollention(String isCollention) {
		this.isCollention = isCollention;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
