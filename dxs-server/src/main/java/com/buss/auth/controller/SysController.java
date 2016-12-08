package com.buss.auth.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.ReplyDataMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buss.auth.transfer.vo.authen.AuthUserVO;

@Controller
@RequestMapping("/sys")
public class SysController {
	
	@RequestMapping(value = "/heart")
	@ResponseBody
	public ReplyDataMode heart(){
		ReplyDataMode j = new ReplyDataMode();
		j.setSuccess(true);
		
		Subject currentUser = SecurityUtils.getSubject();
		if(currentUser.isAuthenticated()){
			AuthUserVO user = (AuthUserVO)currentUser.getSession().getAttribute("userInfo");
//			System.out.println("#### sys/heart user: "+user.getRealname());
			j.setData(user);
			j.setSuccess(true);
		} else {
			j.setSuccess(false);
			j.setData("no");
		}
		return j;
	}
}
