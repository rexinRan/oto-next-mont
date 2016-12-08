package com.buss.common.util.sms.mobi;

import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class Http1 {
	
	public static void main(String[] args) throws HttpException, IOException {
				
		//String Text=URLEncoder.encode("您的验证码：8859【华信】","utf-8");
		String Text="登录验证码@该验证码30分钟内有效。【创世华信】";
		
		String Url="http://114.113.154.5/sms.aspx?action=send";
		
		HttpClient client=new HttpClient();
				
		PostMethod post=new PostMethod(Url);
		post.setRequestHeader("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		NameValuePair userid=new NameValuePair("userid","");
		NameValuePair account=new NameValuePair("account","cshzh");
		NameValuePair password=new NameValuePair("password","123456");
		NameValuePair mobile=new NameValuePair("mobile","13512430411");
		NameValuePair content=new NameValuePair("content",Text);
		NameValuePair sendTime=new NameValuePair("sendTime","");
		NameValuePair extno=new NameValuePair("extno","");
		post.setRequestBody(new NameValuePair[]{userid,account,password,mobile,content,sendTime,extno});
		int statu=client.executeMethod(post);
		System.out.println("statu="+statu);
		String str=post.getResponseBodyAsString();
		
		System.out.println(str);
		
//		HttpMethod method=new PostMethod(Url);//带参数的Url
//		method.setRequestHeader("Content-type", "text/xml; charset=utf-8");
//		client.executeMethod(method);
//		String str = method.getResponseBodyAsString();
//		System.out.println("result="+str);
		
		try {
			//将字符转化为XML
			Document doc=DocumentHelper.parseText(str);
			//获取根节点
			Element rootElt=doc.getRootElement();
			//获取根节点下的子节点的值
			String returnstatus=rootElt.elementText("returnstatus").trim();
			String message=rootElt.elementText("message").trim();
			String remainpoint=rootElt.elementText("remainpoint").trim();
			String taskID=rootElt.elementText("taskID").trim();
			String successCounts=rootElt.elementText("successCounts").trim();
			
			System.out.println("返回状态为："+returnstatus);
			System.out.println("返回信息提示："+message);
			System.out.println("返回余额："+remainpoint);
			System.out.println("返回任务批次："+taskID);
			System.out.println("返回成功条数："+successCounts);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
	}

}
