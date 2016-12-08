package com.buss.common.util.sms;

import javax.servlet.http.HttpServletRequest;

import org.jweb.core.util.PropertiesUtil;

import com.buss.member.entity.GeneralUserEntity;
import org.jweb.core.util.StringUtil;

/**
 * @author wupan
 * 邮件内容模板
 *
 */
public class MailTemplets {
	
	/**
	 * 邮件发送内容
	 * @param util
	 * @param userEntity
	 * @param tsSmsEntity
	 * @param mailContentType
	 * @return
	 */
	public static String getMailContent(PropertiesUtil util, GeneralUserEntity userEntity, 
			TSSmsEntity tsSmsEntity, int mailContentType, HttpServletRequest request) {

		switch (mailContentType) {
	     case 0:  // 设置邮件内容连接
	    	 return setMailContentJoin(util, userEntity, tsSmsEntity, request);
	     case 1: // 设置密码重置邮件内容
	    	 return setMailContentPwdReset(util, userEntity, tsSmsEntity, request);
	     case 2: // 设置邮件内容付费通知
	    	 return setMailContentPayNotify(util, userEntity, tsSmsEntity, request);
	   }
		return "";
	}
	
	/**
	 * 注册后，激活邮件界面
	 */
	public static String setMailContentJoin(PropertiesUtil util, GeneralUserEntity userEntity, 
			TSSmsEntity tsSmsEntity, HttpServletRequest request) {
		//用户邮箱校验网址拼接 URL + 用户id
		String host = util.readProperty("mail.url.host");   // request.getServerName()
		String url = "http://"+host+"/"+util.readProperty("mail.url.user.join")+"?id="+ userEntity.getId();
		String realname = userEntity.getRealname();
		String email = userEntity.getEmail();
		
		StringBuffer demo = new StringBuffer();
		//长长的分割线===============================================================================================================================
		demo.append(html1(realname))
		.append("       <p style=\"margin-left: 30px; color:#686868; font-size: 14px;\">感谢您注册全国大学生创业就业中心</p>")
		.append("       <p style=\"margin-left: 30px;\"> 您的登录邮箱为：<a style=\"color: #010101;\">"+email+"</a>。请点击以下链接激活帐号，以便接收重要提醒消息：</p>")
		.append("       </td>")
		.append("       </tr><tr >")
		.append("       <td style=\"border: 0px red solid; height: 50px; \">")
		.append("       <a style=\"display: block; margin-left: 30px; color: #8e8e8e;\" href=\""+url+"\">"+url+"</a>")
		.append("       </td>")
		.append("       </tr><tr >")
		.append("       <td style=\"border: 0px red solid; height: 50px;\">")
		.append("       <a href=\""+url+"\" style=\"text-decoration: none; display:block;float: left; width:114px; height:32px; width: 115px; margin-left:30px; background-color: #015D90; text-align: center; line-height: 30px;color: white;\">马上激活</a>")
		.append("       </td>");
		demo.append(html2());
		
		return demo.toString();
	}
	
	/**
	 * 密码重置邮件页面
	 */
	public static String setMailContentPwdReset(PropertiesUtil util, GeneralUserEntity userEntity, 
			TSSmsEntity tsSmsEntity, HttpServletRequest request) {
		//用户邮箱校验网址拼接 URL + 用户id
		String host = util.readProperty("mail.url.host");  // request.getServerName()
		String url = "http://"+host+"/"+util.readProperty("mail.url.user.pwd")+"?id="+ userEntity.getId();
		String realname = userEntity.getRealname();
		if(StringUtil.isEmpty(realname)){
			realname = userEntity.getEmpname();
		}

		StringBuffer demo = new StringBuffer();
		//长长的分割线===============================================================================================================================
		demo.append(html1(realname))
		.append("       <p style=\"margin-left: 30px;\"> 请点击以下链接重置您的密码：</p>")
		.append("       </td>")
		.append("       </tr><tr >")
		.append("       <td style=\"border: 0px red solid; height: 50px; \">")
		.append("       <a style=\"display: block; margin-left: 30px; color: #8e8e8e;\" href=\""+url+"\">"+url+"</a>")
		.append("       </td>")
		.append("       </tr>");
		demo.append(html2());
		
		return demo.toString();
	
	}
	
	/**
	 * 缴费通知邮件页面
	 */
	public static String setMailContentPayNotify(PropertiesUtil util, GeneralUserEntity userEntity, 
			TSSmsEntity
					tsSmsEntity, HttpServletRequest request) {
		String realname = userEntity.getRealname();
		StringBuffer demo = new StringBuffer();
		//长长的分割线===============================================================================================================================
		demo.append(html1(realname))
		.append("		<p style=\"margin-left: 30px; color:#686868; font-size: 14px;\">我司账户信息如下：</p>")
		.append("       <p style=\"margin-left: 30px;\"> 账户名称：北京鸿鑫盛世文化传媒有限公司</p>")
		.append("       <p style=\"margin-left: 30px;\">   账  号：11001071700053009581</p>")
		.append("       <p style=\"margin-left: 30px;\"> 开户银行：中国建设银行北京安华支行</p>")
		.append("       </td>")
		.append("       </tr>")
		.append("       <tr >")
		.append("       <td style=\"border: 0px red solid; height: 50px; \">")
		.append("       <p style=\"margin-left: 30px;\"> 请及时缴纳会费，并将缴费回执单扫描件上传到俱乐部个人中心，全国大学生创业就业中心网站：</p>")
		.append("       <p style=\"margin-left: 30px;\"><a href=\" http://www.sec-hxi.com\">http://www.sec-hxi.com/</a> </p>")
		.append("       </td>")
		.append("       </tr>")
		.append("       <tr >")
		.append("       <td style=\"border: 0px red solid; height: 30px;\">")
		.append("       <p style=\"float: right;margin-right: 40px;\">谢谢您的配合</p>")
		.append("       </td>")
		.append("       </tr>");
		demo.append(html2());
		
		return demo.toString();
	}
	
	
	
	
	
	
	/**
	 * html1
	 */
	public static String html1(String realname) {
		StringBuffer demo1 = new StringBuffer();
		demo1.append("<!DOCTYPE html>")
		.append("<html xmlns=\"http://www.w3.org/1999/xhtml\">")
		.append("<head lang=\"en\">")
		.append("   <meta charset=\"UTF-8\">")
		.append("   <title></title>")
		.append("   </head>")
		.append("   <body>")
		.append("    <table style=\"border:0px red solid; margin: 0px auto; width: 900px; height: 705px; background-color:#f3f3f3; \">")
		.append("     <tr>")
		.append("      <td>")
		.append("        <table style=\"border: 0px red solid; width: 700px; height: 480px; margin: 0px auto; background-color: white; \">")
		.append("        <tr >")
		.append("       <td style=\"border: 0px red solid; height: 20px; width: 698px;\">")
		.append("       <img style=\"margin-left: 17px;\" class=\"ImgTop\" src=\"http://www.hongxinguoji.com/group1/M00/00/07/Zckdh1cQY2mAFxCjAAAEYhBCNXo329.png\" alt=\"图片\"/>")
		.append("       </td>")
		.append("       </tr>")
		.append("       <tr>")
		.append("       <td style=\"border: 0px red solid; height: 40px; text-align: center;font-size: 18px;color: #015d90; font-weight: bold; font-family: microsoft YaHei\">")
		.append("       全国大学生创业就业中心")
		.append("        </td>")
		.append("       </tr>")
		.append("        <tr>")
		.append("       <td style=\"border: 0px red solid; height: 40px; width: 40px; font-size: 12px;color: #686868;  font-family: microsoft YaHei\">")
		.append("        <a style=\"margin-left: 10px\">亲爱的</a> <a style=\"color: #015d90;\">"+realname+":</a>")
		.append("       </td>")
		.append("       </tr>")
		.append("       <tr>")
		.append("       <td style=\"border: 0px red solid; height: 50px; width: 40px; font-size: 12px;color: #686868;  font-family: microsoft YaHei\">");
		
		return demo1.toString();
	}
	
	/**
	 * html2
	 */
	public static String html2() {
		StringBuffer demo2 = new StringBuffer();
		demo2.append("   <tr>")
		.append("       <td style=\"border: 0px red solid; height: 40px; width: 40px; font-size: 12px;color: #686868;  font-family:\5b8b\4f53;\">")
		.append("       <p style=\"margin-top: 35px; color: #a1a1a1; margin-left: 30px; line-height: 20px; float: left;\">")
		.append("       本邮件由<span style=\"color: red;\">全国大学生创业就业中心</span>发出。<br>")
		.append("       如在网站使用中遇到任何问题，或者有任何疑问或建议，<br>")
		.append("       可发送邮件至 ")
		.append("       tywang@hongxinguoji.com，或致电010 6482 3008 - 836。")
		.append("       </p>")
		.append("       <a style=\"float: right; margin-right: 40px; display: block; border: 0px red solid;\">")
		.append("       <p style=\"text-align: center\">关注全国大学生创业就业中心：</p>")
		.append("       <img style=\"margin-left: 43px;\" src=\"http://hongxinguoji.com/group1/M00/00/13/Zckdh1d7efKAW6OQAAAgBICU0zI985.jpg\" alt=\"图片\"/>")
		.append("       <p style=\"text-align: center\">全国大学生创业就业中心官方公众号</p>")
		.append("       </a>")
		.append("       </td>")
		.append("       </tr><tr>")
		.append("       <td style=\"border: 0px red solid; height: 40px; width: 40px; font-size: 12px;color: #686868;  font-family: microsoft YaHei\"></td>")
		.append("       </tr>")
		.append("       </table>")
		.append("        </td>")
		.append("       </tr>")
		.append("     </table>")
		.append("  </body>")
		.append("</html>");
		
		return demo2.toString();
	}
	
}
