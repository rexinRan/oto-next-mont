package com.buss.member.util;

/**
 * 常量  状态码
 */
public abstract interface StatusCode
{
	/** 注册成功  **/
	public static final int SC_REGIST = 0;

	public static final int SC_STUDENT_NO = 2;
	/** 学生完善信息审核  **/
	public static final int SC_STUDENT = 3;
	public static final int SC_STUDENT_OK = 4;

	public static final int SC_TEACHER_NO = 5;
	/** 教师完善信息审核  **/
	public static final int SC_TEACHER = 6;
	public static final int SC_TEACHER_OK = 7;

	public static final int SC_EMP_NO = 8;
	/** 企业完善信息审核  **/
	public static final int SC_EMP = 9;
	public static final int SC_EMP_OK = 10;

}