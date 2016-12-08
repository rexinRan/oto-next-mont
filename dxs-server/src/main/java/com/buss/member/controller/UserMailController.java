package com.buss.member.controller;

import java.net.ConnectException;
import java.util.Date;
import java.util.List;

import javax.mail.AuthenticationFailedException;
import javax.servlet.http.HttpServletRequest;

import com.buss.member.transfer.form.member.MemberRegistForm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.util.PropertiesUtil;
import org.jweb.core.util.StringUtil;
import org.jweb.core.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.model.json.ReplyStatus;
import com.buss.common.service.SysServiceI;
import com.buss.common.util.sms.Constants;
import com.buss.common.util.sms.MailTemplets;
import com.buss.common.util.sms.MailUtil;
import com.buss.common.util.sms.TSSmsEntity;
import com.buss.member.entity.GeneralUserEntity;
import com.buss.member.util.StatusCode;
import com.sun.mail.smtp.SMTPAddressFailedException;

@Controller
@RequestMapping("user")
public class UserMailController extends BaseController {

	@Autowired
	private SysServiceI sysService;

	/**
	 * 邮箱发送通用方法
	 * @return
	 */
	@RequestMapping("/email.do")
	@ResponseBody
	public ReplyStatus doEmail(GeneralUserEntity userEntity,SysServiceI sysService,int mailContentType, HttpServletRequest request) {
		ReplyStatus j = new ReplyStatus();
		PropertiesUtil util = new PropertiesUtil("sysConfig.properties");
		String remark = "";
		//邮件
		TSSmsEntity tsSmsEntity = new TSSmsEntity();
		try {
//			tsSmsEntity.setEsReceiver("wupands@qq.com");
			tsSmsEntity.setEsReceiver(userEntity.getEmail());
			tsSmsEntity.setEsTitle("全国大学生创业就业中心");
			/**邮件内容填充**/
			String esContent = MailTemplets.getMailContent(util, userEntity, tsSmsEntity, mailContentType, request);
			
			tsSmsEntity.setEsContent(esContent);
//			tsSmsEntity.setEsContent("测试内容");
			
			tsSmsEntity.setEsStatus(Constants.SMS_SEND_STATUS_1);
			MailUtil.sendEmail(util.readProperty("mail.smtpHost"), 
					tsSmsEntity.getEsReceiver(),tsSmsEntity.getEsTitle(), tsSmsEntity.getEsContent(), 
					util.readProperty("mail.sender"), util.readProperty("mail.user"), util.readProperty("mail.pwd"));
			
			tsSmsEntity.setEsStatus(Constants.SMS_SEND_STATUS_2);
			tsSmsEntity.setEsSendtime(new Date());
			remark = "发送成功";
			tsSmsEntity.setRemark(remark);
			
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
		}
		
		j.setStatus(tsSmsEntity.getRemark());
		return j;
	}

	/**
	 * 用户点击触发 - 邮箱激活
	 * @return
	 */
	@RequestMapping("/join.do")
	@ResponseBody
	public ReplyStatus join(String id) {
		ReplyStatus j = new ReplyStatus();
		j.setStatus("邮箱验证失效！");

		// 验证手机号是否被注册过
		GeneralUserEntity tempUser = this.sysService.get(GeneralUserEntity.class, id);
		if (tempUser != null) {
			// 修改核审状态
//			tempUser.setCheckstatus(StatusCode.SC_1);
			this.sysService.saveOrUpdate(tempUser);
			j.setStatus("账号激活成功！");
		}
		return j;
	}
	
	
	/**
	 * 给用户发送邮件，带上回调链接地址，跳转至修改密码页面
	 * @return
	 */
	@RequestMapping("/pwdreset.do")
	@ResponseBody
	public ReplyDataMode pwdreset(MemberRegistForm saveForm, HttpServletRequest request) {
		ReplyDataMode j = new ReplyDataMode();

		String email = saveForm.getEmail();
		String empname = saveForm.getEmpname();
		if(!StringUtil.isEmpty(email)&&!StringUtil.isEmpty(empname)){
			String hql = "from GeneralUserEntity where email='" +email+ "' and empname='"+empname+"'";
			List<GeneralUserEntity> tempUserList = sysService.findByQueryString(hql);
			GeneralUserEntity tempUser = new GeneralUserEntity();
			if(tempUserList!=null){
				for (GeneralUserEntity tempUserH:tempUserList){
					tempUser = tempUserH;
				}
				if (tempUser != null) {
//			this.sysService.saveOrUpdate(tempUser);
					// 发送邮件
					ReplyStatus jj = doEmail(tempUser, sysService, 1, request);
					j.setStatusCode(jj.getStatus());
//			j.setStatus("邮件发送成功！");
					j.setSuccess(true);
				}
			}
		}
		j.setStatusCode("邮件发送失败！原因是邮件["+email+"]，企业["+empname+"]的用户不存在");
		j.setSuccess(false);
		return j;
	}
	
	
	/**
	 * 缴费操作（发邮件提示用户）测试
	 * @return
	 */
	@RequestMapping("/paynotifytest.do")
	@ResponseBody
	public ReplyDataMode paynotify(String username, HttpServletRequest request) {
		ReplyDataMode j = new ReplyDataMode();

		GeneralUserEntity tempUser = (GeneralUserEntity)sysService.findUniqueByProperty(GeneralUserEntity.class, "email", username);
		if (tempUser != null) {
			// 发送邮件
			ReplyStatus jj = doEmail(tempUser, sysService, 2, request);
			j.setStatusCode(jj.getStatus());
			j.setSuccess(true);
		}else{
			j.setStatusCode("邮件发送失败！原因是["+username+"]用户不存在");
			j.setSuccess(false);
		}
		return j;
	}
	
	/**
	 * 缴费操作（发邮件提示用户）
	 * @return
	 */
	@RequestMapping("/paynotify.do")
	@ResponseBody
	public ReplyDataMode paynotify(HttpServletRequest request) {
		ReplyDataMode j = new ReplyDataMode();

		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
		GeneralUserEntity userEntity = null;
		if(user!=null){	
			userEntity = this.sysService.get(GeneralUserEntity.class, user.getId());
			// 发送邮件
			ReplyStatus jj = doEmail(userEntity, sysService, 2, request);
			j.setStatusCode(jj.getStatus());
			if("发送成功".equals(jj.getStatus())){
				j.setSuccess(true);
			}else{
				j.setSuccess(false);
			}
		}
		else{
			j.setSuccess(false);
		}
		return j;
	}


}
