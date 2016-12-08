package com.buss.recommend.controller;
import com.buss.actives.entity.ActivessEntity;
import com.buss.actives.trans.vo.ActivessVO;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.authentication.entity.DxsAuthenticationEntity;
import com.buss.common.model.json.ReplyStatus;
import com.buss.common.service.SysServiceI;
import com.buss.common.util.sms.Constants;
import com.buss.common.util.sms.MailTemplets;
import com.buss.common.util.sms.MailUtil;
import com.buss.common.util.sms.TSSmsEntity;
import com.buss.member.entity.GeneralUserEntity;
import com.buss.member.transfer.form.member.GeneralUserForm;
import com.buss.project.bases.entity.BasesEntity;
import com.buss.project.bases.trans.vo.BasesVO;
import com.buss.project.founds.entity.FoundEntity;
import com.buss.project.founds.trans.vo.FoundVO;
import com.buss.project.projectapply.entity.ProjectApplyEntity;
import com.buss.project.projectapply.trans.form.ProjectApplySearchForm;
import com.buss.project.projects.entity.ProjectEntity;
import com.buss.project.projects.trans.vo.ProjectVO;
import com.buss.recommend.entity.RecommendEntity;
import com.buss.recommend.trans.form.RecommendSearchForm;
import com.buss.recommend.trans.vo.RecommendVO;
import com.buss.resume.resume.entity.ResumeEntity;
import com.buss.resumeuser.entity.ResumeUserEntity;
import com.buss.userdetail.entity.UserDetailEntity;
import com.buss.userdetail.trans.form.UserDetailForm;
import com.sun.mail.smtp.SMTPAddressFailedException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.jweb.core.util.PropertiesUtil;
import org.jweb.core.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.mail.AuthenticationFailedException;
import javax.servlet.http.HttpServletRequest;
import java.net.ConnectException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author lu
 *
 */
@Controller
@RequestMapping("/luRecommend")
public class LuRecommendController {

	@Resource
	private SysServiceI sysService;


	@RequestMapping("/select.do")
	@ResponseBody
	public ReplyDataMode recommendSelect(GeneralUserEntity generalUserEntity, HttpServletRequest request){
		String idcardnumber = generalUserEntity.getIdcardnumber();
		generalUserEntity.setId(null);
		ReplyDataMode dataMode = new ReplyDataMode();

		String sql = "select * from dxs_user where id_card_number='" +idcardnumber +"' and isdelete =0";

		try {
			List news = this.sysService.findListbySql(sql);

			String name = ((Object[])news.get(0))[1].toString();
			String id = ((Object[])news.get(0))[0].toString();

			UserDetailEntity userDetailEntity = this.sysService.findByProperty(UserDetailEntity.class,"userId",id).get(0);

			Map<String, Object> temp = new HashMap<>();
			temp.put("name",userDetailEntity.getName());
			temp.put("idCard",userDetailEntity.getIdcard());
			temp.put("grade",userDetailEntity.getSchoolGrade());
			temp.put("schoolName",userDetailEntity.getSchoolName());
			temp.put("id",id);
			dataMode.setData(temp);
			dataMode.setSuccess(true);

		}catch (Exception e){

			dataMode.setSuccess(false);

		}

		dataMode.setStatusCode("200");
		return dataMode;
	}


	@RequestMapping("/selectByAccount.do")
	@ResponseBody
	public ReplyDataMode selectByAccount(GeneralUserEntity generalUserEntity, HttpServletRequest request){
		String mphone = generalUserEntity.getMphone();
		ReplyDataMode dataMode = new ReplyDataMode();

		String sql = "select * from dxs_user where mphone='" +mphone +"' and isdelete =0";

		try {
			List users = this.sysService.findListbySql(sql);
			if(users!=null&&users.size()!=0){

				String id = ((Object[])users.get(0))[0].toString();
				String name = ((Object[])users.get(0))[1].toString();
				Object email = ((Object[])users.get(0))[6];
				if(email!=null){

//					UserDetailEntity userDetailEntity = this.sysService.findByProperty(UserDetailEntity.class,"userId",id).get(0);

					Map<String, Object> temp = new HashMap<>();
					temp.put("name",name);
					temp.put("email",email);
					temp.put("id",id);
					dataMode.setData(temp);
					dataMode.setSuccess(true);
				}else {
					dataMode.setData("用户没有绑定邮箱");
					dataMode.setSuccess(false);
					dataMode.setStatusCode("200");
					return dataMode;
				}


			}else {
				dataMode.setData("找不到该用户");
				dataMode.setSuccess(false);
				dataMode.setStatusCode("200");
				return dataMode;
			}


		}catch (Exception e){

			dataMode.setData("操作失败");
			dataMode.setSuccess(false);

		}

		dataMode.setStatusCode("200");
		return dataMode;
	}

	/**
	 * 邮件发送
	 * @param email
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "sendEmail")
	@ResponseBody
	public ReplyDataMode sendEmail(String htmlAddress,String id,String email,String name,String userId,String type,HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();

		// 获取当前登录用户
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

		if (user != null){
			if("teacher".equals(user.getRolecode())){
				if (!StringUtil.isEmpty(email)){
//				replyDataMode = this.judgePhone(null,email,request);

					GeneralUserEntity userEntity = this.sysService.get(GeneralUserEntity.class,user.getId());
					userEntity.setEmail(email);
					replyDataMode = doEmail(htmlAddress,id,email,name,userEntity,0,request);
				    RecommendEntity recommendEntity = new RecommendEntity();
					recommendEntity.setIsDelete(0);
					recommendEntity.setRecommendedUserId(user.getId());
					recommendEntity.setBerecommendedUserId(userId);
					recommendEntity.setOutId(id);
					Date date = new Date();
					recommendEntity.setCreateTime(date);
					SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					String dateString = simpleDateFormat.format(date);
					recommendEntity.setRecommendTime(dateString);
					recommendEntity.setType(type);
					recommendEntity.setResult("2");
					this.sysService.saveOrUpdate(recommendEntity);

//				if (replyDataMode.isSuccess()){
//					PropertiesUtil util = new PropertiesUtil("sysConfig.properties");
//					String host = util.readProperty("mail.url.host");
////					String url = "http://"+host+"/"+util.readProperty("mail.url.user.join")+"?id="+ userEntity.getId() + "&email=" + email;
//
////					String key = userEntity.getId();
//					// 将用户的id作为key存储
////					if (!StringUtil.isEmpty(key)) {
////						// TODO 设置Redis缓存
////						int date = 1 * 24 * 60 * 60 * 3;       // 缓存时间
////						redisClient.put(key, url,date);
////					}
//				} else {
//						return  replyDataMode;
//				}

				}else {

					replyDataMode.setStatusCode("请输入邮箱!");
					replyDataMode.setSuccess(false);
				}

			}else {
				replyDataMode.setStatusCode("只有老师可以推荐!");
				replyDataMode.setSuccess(false);
			}

		}else {

			replyDataMode.setStatusCode("请您登陆!");
			replyDataMode.setSuccess(false);
		}

		return replyDataMode;
	}


	/**
	 * 发送邮件
	 * @param userEntity
	 * @param mailContentType       // 邮件类型  "0":拼接邮件
	 * @param request
	 * @return
	 */
	public ReplyDataMode doEmail(String htmlAddress,String id,String email,String name,GeneralUserEntity userEntity,int mailContentType, HttpServletRequest request) {
		ReplyStatus j = new ReplyStatus();

		ReplyDataMode replyDataMode = new ReplyDataMode();
		// 获取配置参数
		PropertiesUtil util = new PropertiesUtil("sysConfig.properties");
		String remark = "";
		//邮件
		TSSmsEntity tsSmsEntity = new TSSmsEntity();
		try {
//			tsSmsEntity.setEsReceiver("wupands@qq.com");
			tsSmsEntity.setEsReceiver(email);
			tsSmsEntity.setEsTitle("全国大学生创业就业中心");
			/**邮件内容填充**/
			String esContent =setMailContentJoin(util, htmlAddress,id,name,userEntity, tsSmsEntity, request);

			tsSmsEntity.setEsContent(esContent);
//			tsSmsEntity.setEsContent("测试内容");

			tsSmsEntity.setEsStatus(Constants.SMS_SEND_STATUS_1);
			MailUtil.sendEmail(util.readProperty("mail.smtpHost"),
					tsSmsEntity.getEsReceiver(),tsSmsEntity.getEsTitle(), tsSmsEntity.getEsContent(),
					util.readProperty("mail.sender"), util.readProperty("mail.user"), util.readProperty("mail.pwd"));

			tsSmsEntity.setEsStatus(Constants.SMS_SEND_STATUS_2);
			tsSmsEntity.setEsSendtime(new Date());
			remark = "已发送到邮箱!";
			tsSmsEntity.setRemark(remark);
			replyDataMode.setStatusCode(remark);
			replyDataMode.setSuccess(true);

			// 保存发送记录
			if(this.sysService!=null){
				this.sysService.saveOrUpdate(tsSmsEntity);
			}else{
				sysService.saveOrUpdate(tsSmsEntity);
			}
		} catch (Exception e) {
			//tsSmsEntity.setEsStatus(Constants.SMS_SEND_STATUS_3);
			if (e instanceof AuthenticationFailedException){
				remark = "认证失败错误的用户名或者密码";
			}else if (e instanceof SMTPAddressFailedException){
				remark = "接受邮箱格式不对";
			}else if (e instanceof ConnectException){
				remark = "邮件服务器连接失败";
			}else{
				remark = e.getMessage();
			}
			//System.out.println(remark);
			//e.printStackTrace();
			tsSmsEntity.setEsStatus(Constants.SMS_SEND_STATUS_3);
			tsSmsEntity.setEsSendtime(new Date());
			tsSmsEntity.setRemark(remark);
			// 保存发送记录
			if(this.sysService!=null){
				this.sysService.saveOrUpdate(tsSmsEntity);
			}else{
				sysService.saveOrUpdate(tsSmsEntity);
			}
			replyDataMode.setStatusCode(remark);
			replyDataMode.setSuccess(false);
		}

		j.setStatus(tsSmsEntity.getRemark());
		return replyDataMode;
	}

	/**
	 * 邮件内容页面
	 */
	public static String setMailContentJoin(PropertiesUtil util,String htmlAddress,String id,String name, GeneralUserEntity userEntity,
											TSSmsEntity tsSmsEntity, HttpServletRequest request) {
		//用户邮箱校验网址拼接 URL + 用户id
		String host = util.readProperty("mail.url.host");   // request.getServerName()
		String url = "http://"+host+"/"+ htmlAddress + "?id=" + id  +"&userId="+ userEntity.getId();
//		String realname = userEntity.getRealname();
//		String email = userEntity.getEmail();

		StringBuffer demo = new StringBuffer();
		//长长的分割线===============================================================================================================================
		demo.append(html1(name))
				.append("       <p style=\"margin-left: 30px; color:#686868; font-size: 14px;\">感谢使用全国大学生创业就业中心</p>")
				.append("       <p style=\"margin-left: 30px;\">" + userEntity.getRealname() + " 分享给您一个精彩信息，请点击以下链接查看详情：</p>")
				.append("       </td>")
				.append("       </tr><tr >")
				.append("       <td style=\"border: 0px red solid; height: 50px; \">")
				.append("       <a style=\"display: block; margin-left: 30px; color: #8e8e8e;\" href=\""+url+"\">"+url+"</a>")
				.append("       </td>")
				.append("       </tr><tr >")
				.append("       <td style=\"border: 0px red solid; height: 50px;\">")
				.append("       <a href=\""+url+"\" style=\"text-decoration: none; display:block;float: left; width:114px; height:32px; width: 115px; margin-left:30px; background-color: #015D90; text-align: center; line-height: 30px;color: white;\">马上进入</a>")
				.append("       </td>");
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