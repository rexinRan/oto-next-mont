package com.buss.common.util.sms.mobi;

public class HttpSenderTest {
	public static void main(String[] args) {
		String url = "http://222.73.117.158/msg/";// 应用地址
		String account = "jiekou-clcs-16";// 账号
		String pswd = "Clwh2009";// 密码
//		String mobile = "13800210021,13800138000";// 手机号码，多个号码使用","分割
//		String mobile = "13522586223,13512430411";// 手机号码，多个号码使用","分割
//		String mobile = "13501205703";
//		String mobile = "13718140255";
		String mobile = "13512430411";
//		String msg = "亲爱的用户，您的验证码是123456，5分钟内有效。";// 短信内容
		String msg = "腾妹发红包，5分钟内有效。";// 短信内容
		boolean needstatus = true;// 是否需要状态报告，需要true，不需要false
		String product = null;// 产品ID
		String extno = null;// 扩展码

		try {
			String returnString = HttpSender.batchSend(url, account, pswd, mobile, msg, needstatus, product, extno);
			System.out.println(returnString);
			String str = returnString.substring(returnString.indexOf(",")+1,returnString.indexOf("\n")); 
			System.out.println("str="+str);
		/*
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
			
			// TODO 处理返回值,参见HTTP协议文档
		} catch (Exception e) {
			// TODO 处理异常
			e.printStackTrace();
		}
	}
}
