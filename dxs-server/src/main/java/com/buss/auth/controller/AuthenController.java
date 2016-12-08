package com.buss.auth.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.util.MyBeanUtils;
import org.jweb.core.util.PasswordUtil;
import org.jweb.core.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buss.auth.transfer.form.authen.LoginForm;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.auth.transfer.vo.authen.AuthUserVOAdmin;
import com.buss.auth.transfer.vo.authen.AuthUserVOAll;
import com.buss.common.service.SysServiceI;
import com.buss.member.entity.GeneralUserEntity;
import com.buss.member.util.StatusCode;
/**
 * 登录登出功能控制器
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/authen")
public class AuthenController extends BaseController {

	@Autowired
	private SysServiceI sysService;

	/**
	 * 用户登录
	 *
	 * @param loginForm
	 * @return
	 */
	@RequestMapping(value = "/login")
	@ResponseBody
	public ReplyDataMode login(LoginForm loginForm){
		ReplyDataMode j = new ReplyDataMode();
		String pwd2Str = PasswordUtil.encrypt(loginForm.getPwd(), PasswordUtil.str, PasswordUtil.getStaticSalt());
		Subject currentUser = SecurityUtils.getSubject();
		/**用户名code可以是用户邮箱或者手机号*/
		UsernamePasswordToken token = new UsernamePasswordToken(loginForm.getCode(), pwd2Str);
		token.setRememberMe(true);
		try {
			currentUser.login(token);
		} catch (AuthenticationException e) {
			j.setSuccess(false);
			j.setData("login errors");
			// 登陆失败返回错误信息处理
			ReplyDataMode jj = getUserInfoAll(loginForm.getCode(),null);
			if("200".equals(jj.getStatusCode())){
				AuthUserVOAll userVO = (AuthUserVOAll) jj.getData();
				if(!pwd2Str.equals(userVO.getPwd())){
					j.setStatusCode("用户密码错误");
					return j;
				}
				// 判断用户审核状态
//				if(Integer.parseInt(userVO.getCheckstatus())==StatusCode.SC_10_NO){
//					j.setStatusCode("用户审核未通过，请联系会籍管理员");
//				}
//				if(Integer.parseInt(userVO.getCheckstatus())==StatusCode.SC_1){
//					j.setStatusCode("用户已激活邮箱，等待会籍管理员审核");
//				}
//				if(Integer.parseInt(userVO.getCheckstatus())==StatusCode.SC_REGIST){
//					j.setStatusCode("用户未激活邮箱");
//				}
			}
//			else if("201".equals(jj.getStatusCode())){
//				AuthUserVOAdmin userVO = (AuthUserVOAdmin) jj.getData();
//				if(!pwd2Str.equals(userVO.getPassword())){
//					j.setStatusCode("用户密码错误");
//					return j;
//				}
//			}
			else{
				j.setStatusCode("用户不存在");
			}
			e.printStackTrace();
			return j;
		}
		if(currentUser.isAuthenticated()){
			ReplyDataMode jj = getUserInfoNo(loginForm.getCode(),null);
			// 判断前台还是后台，并设置不同session
			if("200".equals(jj.getStatusCode())){
				currentUser.getSession().setAttribute("userInfo", jj.getData());
				j.setStatusCode("200");
			}
//			else{
//				currentUser.getSession().setAttribute("userInfoAdmin", jj.getData());
//				j.setStatusCode("201");
//			}
			j.setData(jj.getData());
			j.setSuccess(true);
		}
		return j;
	}

	/**
	 * 获得用户信息(用户必须先登录，查该用户信息)
	 * @return
	 */
	@RequestMapping(value = "/getUserInfo")
	@ResponseBody
	@RequiresAuthentication
	public ReplyDataMode getUserInfo(){
		ReplyDataMode j = new ReplyDataMode();
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

		if(currentUser.isAuthenticated()){
			ReplyDataMode jj = getUserInfoNo(user.getEmail(),null);
			if(!"200".equals(jj.getStatusCode())){
				jj = getUserInfoNo(user.getMphone(),null);
			}
			j.setData(jj.getData());
			j.setSuccess(true);
		}else{
			j.setSuccess(false);
		}
		return j;
	}

	/**
	 * 获得用户信息(无需用户登录)
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/getUserInfoNo")
	@ResponseBody
	public ReplyDataMode getUserInfoNo(String username,SysServiceI sysService){
		ReplyDataMode j = new ReplyDataMode();
		j.setStatusCode("404");

		AuthUserVO userVO = new AuthUserVO();
		boolean isExistUser = false;
		// 查用户邮箱
		GeneralUserEntity user = null;
		if(this.sysService!=null){
			user = (GeneralUserEntity)this.sysService.findUniqueByProperty(GeneralUserEntity.class, "email", username);
		}else{
			user = (GeneralUserEntity)sysService.findUniqueByProperty(GeneralUserEntity.class, "email", username);
		}
		if (user != null) {
			try {
				MyBeanUtils.copyBean2Bean(userVO, user);
				userVO.setUserType("f");//前台会员
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			j.setStatusCode("200");
			isExistUser = true;
		}
		else if (!isExistUser) {
			// 查用户手机号
			if(this.sysService!=null){
				user = (GeneralUserEntity)this.sysService.findUniqueByProperty(GeneralUserEntity.class, "mphone", username);
			}else{
				user = (GeneralUserEntity)sysService.findUniqueByProperty(GeneralUserEntity.class, "mphone", username);
			}
			if (user != null) {
				try {
					MyBeanUtils.copyBean2Bean(userVO, user);
					userVO.setUserType("f");//前台会员
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

	/**
	 * 判断用户是否登录
	 * @return
	 */
	@RequestMapping(value = "/isLogin")
	@ResponseBody
	public ReplyDataMode isLogin(){
		ReplyDataMode j = new ReplyDataMode();

		Subject currentUser = SecurityUtils.getSubject();

		if(currentUser.isAuthenticated()){
			AuthUserVO user = (AuthUserVO)currentUser.getSession().getAttribute("userInfo");

			j.setData(user);
			j.setSuccess(true);
		} else {
			j.setSuccess(false);
			j.setData("no");
		}

		return j;
	}

	/**
	 * 登出
	 * @return
	 */
	@RequestMapping(value = "/logout")
	@ResponseBody
	public ReplyDataMode logout(){
		ReplyDataMode j = new ReplyDataMode();

		Subject currentUser = SecurityUtils.getSubject();

		if(currentUser.isAuthenticated()){
			currentUser.logout();

		}

		j.setData("successful");
		j.setSuccess(true);
		return j;
	}



	/**
	 * 获得用户信息(无需用户登录)
	 * @param username
	 * @return
	 */
	@RequestMapping(value = "/getUserInfoAll")
	@ResponseBody
	public ReplyDataMode getUserInfoAll(String username,SysServiceI sysService){
		ReplyDataMode j = new ReplyDataMode();
		j.setStatusCode("404");

		AuthUserVOAll userVO = new AuthUserVOAll();
		boolean isExistUser = false;
		// 查用户邮箱
		GeneralUserEntity user = null;
		if(this.sysService!=null){
			user = (GeneralUserEntity)this.sysService.findUniqueByProperty(GeneralUserEntity.class, "email", username);
		}else{
			user = (GeneralUserEntity)sysService.findUniqueByProperty(GeneralUserEntity.class, "email", username);
		}
		if (user != null) {
			try {
				MyBeanUtils.copyBean2Bean(userVO, user);
				userVO.setUserType("f");//前台会员
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			j.setStatusCode("200");
			isExistUser = true;
		}
		else if (!isExistUser) {
			// 查用户手机号
			if(this.sysService!=null){
				user = (GeneralUserEntity)this.sysService.findUniqueByProperty(GeneralUserEntity.class, "mphone", username);
			}else{
				user = (GeneralUserEntity)sysService.findUniqueByProperty(GeneralUserEntity.class, "mphone", username);
			}
			if (user != null) {
				try {
					MyBeanUtils.copyBean2Bean(userVO, user);
					userVO.setUserType("f");//前台会员
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
