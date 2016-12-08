package com.buss.common.service.impl;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.ParseException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.jweb.core.service.impl.CommonServiceImpl;
import org.jweb.core.util.ResourceUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.buss.common.service.SMSServiceI;
import com.buss.common.util.sms.SMSUtil;

@Service("smsService")
@Transactional
public class SMSServiceImpl extends CommonServiceImpl implements SMSServiceI{
	
	@Override
	public boolean sendSMS(String mobileNum, String msg) {
		System.out.println("当前号码：" + mobileNum);
		
		String returnstatus = "";
		
		//String Text=URLEncoder.encode("您的验证码：8859【华信】","utf-8");
//		String Text="登录验证码@该验证码30分钟内有效。【创世华信】";
		String companyName = "";
		companyName = ResourceUtil.getConfigByName("current_sys_company_name");

//			companyName = URLEncoder.encode(ResourceUtil.getConfigByName("current_sys_company_name"),"utf-8");
//			companyName = new String(ResourceUtil.getConfigByName("current_sys_company_name").getBytes("UTF-8"), "iso-8859-1");

		String Text=msg+"【"+companyName+"】";
		System.out.println("发送内容：" + Text);
		String Url=ResourceUtil.getConfigByName("sms_send_plat_app_url");
		
		HttpClient client=new HttpClient();
				
		PostMethod post=new PostMethod(Url);
		post.setRequestHeader("Content-type", "application/x-www-form-urlencoded;charset=utf-8");
		NameValuePair userid=new NameValuePair("userid","");
		NameValuePair account=new NameValuePair("account",ResourceUtil.getConfigByName("sms_send_plat_app_id"));
		NameValuePair password=new NameValuePair("password",ResourceUtil.getConfigByName("sms_send_plat_app_pwd"));
		NameValuePair mobile=new NameValuePair("mobile",mobileNum);
		NameValuePair content=new NameValuePair("content",Text);
		NameValuePair sendTime=new NameValuePair("sendTime","");
		NameValuePair extno=new NameValuePair("extno","");
		post.setRequestBody(new NameValuePair[]{userid,account,password,mobile,content,sendTime,extno});
		int statu;
		String str="";
		try {
			statu = client.executeMethod(post);
			System.out.println("statu="+statu);
			str=post.getResponseBodyAsString();
		} catch (HttpException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
//		System.out.println(str);
		
		try {
			//将字符转化为XML
			Document doc=DocumentHelper.parseText(str);
			//获取根节点
			Element rootElt=doc.getRootElement();
			//获取根节点下的子节点的值
			returnstatus=rootElt.elementText("returnstatus").trim();
			String message=rootElt.elementText("message").trim();
			String remainpoint=rootElt.elementText("remainpoint").trim();
			String taskID=rootElt.elementText("taskID").trim();
			String successCounts=rootElt.elementText("successCounts").trim();
			
			System.out.println("返回状态为："+returnstatus);
//			System.out.println("返回信息提示："+message);
			System.out.println("返回余额："+remainpoint);
//			System.out.println("返回任务批次："+taskID);
//			System.out.println("返回成功条数："+successCounts);
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		
//		System.out.println(getReturnStatus(returnstatus));
		if("Success".equals(returnstatus)){
			return true;
		}
		return false;
	}
	
	/*
	public boolean sendSMS(String mobile, String msg) {
		System.out.println("当前号码：" + mobile);
		System.out.println("发送内容：" + msg);
		
		String url = ResourceUtil.getConfigByName("sms_send_plat_app_url");
		String account = ResourceUtil.getConfigByName("sms_send_plat_app_id");
		String pswd = ResourceUtil.getConfigByName("sms_send_plat_app_pwd");
		String companyName = ResourceUtil.getConfigByName("current_sys_company_name");
		
		boolean needstatus = true;// 是否需要状态报告，需要true，不需要false
		String product = null;// 产品ID
		String extno = null;// 扩展码
		
		String respost = "";
		try {
			String returnString = HttpSender.batchSend(url, account, pswd, mobile, msg, needstatus, product, extno);
			System.out.println(returnString);
			respost = returnString.substring(returnString.indexOf(",")+1,returnString.indexOf("\n")); 
			
			// TODO 处理返回值,参见HTTP协议文档
		} catch (Exception e) {
			// TODO 处理异常
			e.printStackTrace();
		}
		System.out.println(getReturnStatus(respost));
		if(Integer.parseInt(respost)==0){
			return true;
		}
		return false;
	}
	*/
	/**
	用户短信通过http请求提交到服务器后，服务器返回响应码，响应码的格式如下：
	resptime,respstatus
	msgid
	
	短信提交响应分为两行，第一行为响应时间和状态，
	第二行为服务器给出提交msgid。无论发送的号码是多少，一个发送请求只返回一个msgid，
	如果响应的状态不是“0”，则没有msgid即第二行数据。（每行以换行符(0x0a,即\n)分割）
	
	成功
	20160408173928,0
	1000408173928143100
	响应时间为20110725160412，响应状态为0 表明那个成功提交到服务器；1234567890100为返回的msgid，这个工状态报告匹配时使用
	
	失败
	20110725160412,101
	本示例表明用户提交失败，返回错误码为101，服务器端并未返回msgid。
	
	1.3.3	响应状态值说明
	代码	说明
	0	提交成功
	101	无此用户
	102	密码错
	103	提交过快（提交速度超过流速限制）
	104	系统忙（因平台侧原因，暂时无法处理提交的短信）
	105	敏感短信（短信内容包含敏感词）
	106	消息长度错（>536或<=0）
	107	包含错误的手机号码
	108	手机号码个数错（群发>50000或<=0;单发>200或<=0）
	109	无发送额度（该用户可用短信数已使用完）
	110	不在发送时间内
	111	超出该账户当月发送额度限制
	112	无此产品，用户没有订购该产品
	113	extno格式错（非数字或者长度不对）
	115	自动审核驳回
	116	签名不合法，未带签名（用户必须带签名的前提下）
	117	IP地址认证错,请求调用的IP地址不是系统登记的IP地址
	118	用户没有相应的发送权限
	119	用户已过期
	120	短信内容不在白名单中
 */
	public String getReturnStatus(String respost) {
		String statusCode = "";
		switch (Integer.parseInt(respost)){
		case 0: 
			statusCode = "成功";
			return statusCode;
		case 101:
			statusCode = "无此用户";
			break;
		case 102:
			statusCode = "密码错";
			break;
		case 103:
			statusCode = "提交过快（提交速度超过流速限制）";
			break;
		case 104:
			statusCode = "系统忙（因平台侧原因，暂时无法处理提交的短信）";
			break;
		case 105:
			statusCode = "敏感短信（短信内容包含敏感词）";
			break;
		case 106:
			statusCode = "消息长度错（>536或<=0）";
			break;
		case 107:
			statusCode = "包含错误的手机号码";
			break;
		case 108:
			statusCode = "手机号码个数错（群发>50000或<=0;单发>200或<=0）";
			break;		
		case 109:
			statusCode = "无发送额度（该用户可用短信数已使用完）";
			break;
		case 110:
			statusCode = "不在发送时间内";
			break;
		case 111:
			statusCode = "超出该账户当月发送额度限制";
			break;
		case 112:
			statusCode = "无此产品，用户没有订购该产品";
			break;
		case 113:
			statusCode = "extno格式错（非数字或者长度不对）";
			break;
		case 115:
			statusCode = "自动审核驳回";
			break;
		case 116:
			statusCode = "签名不合法，未带签名（用户必须带签名的前提下）";
			break;
		case 117:
			statusCode = "IP地址认证错,请求调用的IP地址不是系统登记的IP地址";
			break;
		case 118:
			statusCode = "用户没有相应的发送权限";
			break;
		case 119:
			statusCode = "用户已过期";
			break;
		case 120:
			statusCode = "短信内容不在白名单中";
			break;
		}

		return statusCode;
	}
	

	
	public boolean sendSMS_old(String mobile, String con) {
		System.out.println("当前号码：" + mobile);
		String username = ResourceUtil.getConfigByName("sms_send_plat_app_id");
		String password = ResourceUtil.getConfigByName("sms_send_plat_app_pwd");
		String companyName = ResourceUtil.getConfigByName("current_sys_company_name");
		
		String key = ResourceUtil.getConfigByName("current_sys_company_key");
		
		/*
		java短信发送示例
		注意：
		1.此接口支持通知类和注册类短信，谢绝一切营销类推广
		2.短信内容总字数超过65个字则扣除2条短信的余额

		短信内容收不到由如下原因引起：
		1.短信信号不好
		2.手机欠费
		3.一个手机号在一小时内收到超过8封信
		4.发送内容不符合接口规定
		5.手机装有手机卫士之类拒收或在被拦截名单中
		6.手机死机
		*/
		
		/*-------------请填写以下信息------------*/
		String utf8Con = "";
		String utf8CompanyName = "";
		try {
			utf8Con = new String(con.getBytes("UTF-8"),"UTF-8");
			utf8CompanyName = new String(companyName.getBytes("UTF-8"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String body = java.net.URLEncoder.encode(utf8Con);//测试时尽量用祝福语
		String suffix = java.net.URLEncoder.encode(utf8CompanyName);//在3-8个字内
		/*-------------请填写以下信息------------*/
		
		String content = body + java.net.URLEncoder.encode("【") + suffix + java.net.URLEncoder.encode("】");//get content
//		SMSUtil test = new SMSUtil();
		
		long time = 0;
		try {
			time = SMSUtil.GetGMTTime();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//获取格林尼治时间
		String authkey = SMSUtil.getMD5Str(username+time+ SMSUtil.getMD5Str(password)+key);//生成authkey
		String para = "username="+username+"&time="+time+"&content="+content+"&mobile="+mobile+"&authkey="+authkey;//生成参数
		
		//post逻辑
		String respost = SMSUtil.sendPost("http://sms.edmcn.cn/api/cm/trigger_mobile.php", para);
		
		switch (Integer.parseInt(respost)){
		case 1: 
			System.out.println("成功");
			return true;
		case 2:
			System.out.println("参数不正确");
			break;
		case 3:
			System.out.print("密钥验证失败");
			break;
		case 4:
			System.out.print("用户名或密码错误");
			break;
		case 5:
			System.out.print("服务器内部失败");
			break;
		case 6:
			System.out.print("余额不足");
			break;
		case 7:
			System.out.print("内容不符合格式");
			break;
		case 8:
			System.out.print("频率超限");
			break;
		case 9:
			System.out.print("接口超时");
			break;		
		case 10:
			System.out.print("后缀签名长度超过限制");
			break;
		}
		return false;
		
	}

	
}
