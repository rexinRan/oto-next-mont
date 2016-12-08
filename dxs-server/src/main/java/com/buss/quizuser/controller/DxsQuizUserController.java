package com.buss.quizuser.controller;


import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;
import com.buss.quiz.entity.QuizEntity;
import com.buss.quizuser.entity.DxsQuizUserEntity;
import com.buss.quizuser.trans.form.QuizUserSearchForm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**   
 * @Title: Controller
 * @Description: dxs_quiz_user
 * @author onlineGenerator
 * @date 2016-06-16 09:33:13
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsQuizUserController")
public class DxsQuizUserController {
	@Resource
	private SysServiceI sysService;


	@RequestMapping("/save.do")
	@ResponseBody
	public ReplyDataMode quizUser(QuizUserSearchForm searchForm, HttpServletRequest request) {
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

		ReplyDataMode replyDataMode = new ReplyDataMode();
		Date date=new Date();

		DxsQuizUserEntity dxsQuizUserEntity= new DxsQuizUserEntity();
		dxsQuizUserEntity.setIsDelete(0);
		dxsQuizUserEntity.setQuizId(searchForm.getQuizId());
		dxsQuizUserEntity.setUserId(user.getId());
		dxsQuizUserEntity.setResult(searchForm.getResult());
		dxsQuizUserEntity.setEvaluationtime(date);
		boolean a = true;
		try {
			sysService.saveOrUpdate(dxsQuizUserEntity);
		}catch ( Exception e){
			a=false;
		}



		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(a);
		return replyDataMode;
	}



}