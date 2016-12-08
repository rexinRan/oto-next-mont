package com.buss.member.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.cache.ehcache.EhCacheManager;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.util.*;
import org.jweb.core.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SMSServiceI;
import com.buss.common.service.SysServiceI;
import com.buss.member.entity.GeneralUserEntity;
import com.buss.member.transfer.vo.pwd.PwdUserVO;
import com.buss.member.util.MemberUtil;

/**
 * 会员密码管理控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/member/pwd")
public class PwdController extends BaseController {
	@Autowired
	private SysServiceI sysService;
	@Autowired
	private EhCacheManager ehcacheCacheManager;
	@Autowired
	private SMSServiceI smsService;
	/**
	 * 发送短信验证码
	 * @return
	 */
	@RequestMapping(value = "/sendSMS")
	@ResponseBody
	public ReplyDataMode sendSMS(String mphone,HttpServletRequest req){
		
		return MemberUtil.sendSMSValidCode(mphone, req.getLocale(), smsService, ehcacheCacheManager);
	}
	
	/**
	 * 校验验证码（校验通过，修改isupdatepwd=1，允许用户修改密码）
	 * @return
	 */
	@RequestMapping(value = "/checkSMScode",method=RequestMethod.POST)
	@ResponseBody
	public ReplyDataMode checkSMScode(String smsCode,String mphone){
		ReplyDataMode j = new ReplyDataMode();
		if(	!MemberUtil.validSMSCode(mphone, smsCode, ehcacheCacheManager)){
			j.setSuccess(false);
			j.setStatusCode(ReplyCodeResourceUtil.getProperties("regist_validCode_error"));
			return j;
		}
		String defaultEhcacheName = ResourceUtil.getConfigByName("defaultEhcacheName");
		this.ehcacheCacheManager.getCache(defaultEhcacheName).remove(mphone);//从缓存服务器中清除短信验证码信息
		// 修改用户isupdatepwd=1
		GeneralUserEntity tempUser = (GeneralUserEntity)sysService.findUniqueByProperty(GeneralUserEntity.class, "mphone", mphone);
		if (tempUser != null) {
			this.sysService.saveOrUpdate(tempUser);
			j.setData(tempUser.getId());
			j.setSuccess(true);
		}
		return j;
	}
	
	/**
	 * 修改密码（测试用，三个参数，
	 * 用户密码，手机验证码，手机号）
	 * @return
	 */
	@RequestMapping(value = "/mod4phone",method=RequestMethod.POST)
	@ResponseBody
	public ReplyDataMode mod4phone(String pwd,String smsCode,String mphone){
		ReplyDataMode j = new ReplyDataMode();
		if(	!MemberUtil.validSMSCode(mphone, smsCode, ehcacheCacheManager)){
			j.setSuccess(false);
			j.setStatusCode(ReplyCodeResourceUtil.getProperties("regist_validCode_error"));
			return j;
		}
		/**修改密码*/
		String defaultEhcacheName = ResourceUtil.getConfigByName("defaultEhcacheName");
		GeneralUserEntity user = (GeneralUserEntity)sysService.findUniqueByProperty(GeneralUserEntity.class, "mphone", mphone);
		// 密码加密
		String pwdStr = PasswordUtil.encrypt(pwd, PasswordUtil.str, PasswordUtil.getStaticSalt());
		user.setPwd(pwdStr);
		this.ehcacheCacheManager.getCache(defaultEhcacheName).remove(mphone);//从缓存服务器中清除短信验证码信息
		sysService.updateEntitie(user);
		
		j.setSuccess(true);
		return j;
	}
	
	
	/**
	 * 修改密码（pwd 用户登录以后修改）
	 * @return
	 */
	/**
	 * 修改密码（pwd 用户登录以后修改）
	 * @return
	 */
	@RequestMapping(value = "/modify",method=RequestMethod.POST)
	@ResponseBody
	public ReplyDataMode modify(String pwd,String id){
		ReplyDataMode j = new ReplyDataMode();
		if(!StringUtil.isEmpty(pwd)&&!StringUtil.isEmpty(id)){
			GeneralUserEntity tempUser = this.sysService.get(GeneralUserEntity.class, id);
			// 只有用户点击邮箱验证后才能修改密码，防止其他人随意修改密码
			// 密码加密
			String pwdStr = PasswordUtil.encrypt(pwd, PasswordUtil.str, PasswordUtil.getStaticSalt());
			tempUser.setPwd(pwdStr);
			this.sysService.saveOrUpdate(tempUser);
//			sysService.updateEntitie(tempUser);
			j.setSuccess(true);
		}else{
			j.setSuccess(false);
			j.setStatusCode("参数不对");
		}
		return j;
	}
	/*
	@RequestMapping(value = "/modify",method=RequestMethod.POST)
	@ResponseBody
	public ReplyDataMode modify(String pwd){
		ReplyDataMode j = new ReplyDataMode();
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
		GeneralUserEntity tempUser = this.sysService.get(GeneralUserEntity.class, user.getId());
		// 只有用户点击邮箱验证后才能修改密码，防止其他人随意修改密码
			// 密码加密
			String pwdStr = PasswordUtil.encrypt(pwd, PasswordUtil.str, PasswordUtil.getStaticSalt());
			tempUser.setPwd(pwdStr);
			this.sysService.saveOrUpdate(tempUser);
			sysService.updateEntitie(tempUser);
			j.setSuccess(true);
		return j;
	}
*/
	
	/**
	 * 获得用户信息(无需用户登录)
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/getUserInfoPwd")
	@ResponseBody
	public ReplyDataMode getUserInfoPwd(String username){
		ReplyDataMode j = new ReplyDataMode();
		j.setStatusCode("404");
		
		PwdUserVO userVO = new PwdUserVO();
		boolean isExistUser = false;
		// 查用户邮箱
		GeneralUserEntity user = (GeneralUserEntity)sysService.findUniqueByProperty(GeneralUserEntity.class, "email", username);
		if (user != null) {
			try {
				MyBeanUtils.copyBean2Bean(userVO, user);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			j.setStatusCode("200");
			isExistUser = true;
		} 
		else if (!isExistUser) {
			// 查用户手机号
			user = (GeneralUserEntity)sysService.findUniqueByProperty(GeneralUserEntity.class, "mphone", username);
			if (user != null) {
				try {
					MyBeanUtils.copyBean2Bean(userVO, user);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				j.setStatusCode("200");
				isExistUser = true;
			}
		}

		j.setData(userVO);
		j.setSuccess(isExistUser);
		
		return j;
	}
}
