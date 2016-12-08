package com.buss.projectvote.controller;
import com.buss.actives.entity.ActivesEntity;
import com.buss.actives.trans.form.ActivesSearchForm;
import com.buss.actives.trans.vo.ActivesVO;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.model.json.AjaxJson;
import com.buss.common.service.SysServiceI;
import com.buss.projectvote.entity.DxsProjectVoteEntity;
import com.buss.projectvote.trans.form.DxsProjectVoteSearchForm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.jweb.core.web.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author lx
 *
 */
@Controller
@RequestMapping("/dxsprojectvote")
public class DxsProjectVoteController {

	@Resource
	private SysServiceI sysService;

	@Autowired
	private SysServiceI sysServiceI;


	@RequestMapping("/votecount.do")
	@ResponseBody
	public ReplyDataMode dxsProjectVoteList(DxsProjectVoteSearchForm searchForm, HttpServletRequest request) {
		searchForm.setIsDelete("0");

		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();


		List<ActivesEntity> vote = this.sysService.list(criteriaQuery);
		String count = Integer.toString(vote.size());


		replyDataMode.setData(count);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}


	@RequestMapping("/vote")
	@ResponseBody
	public AjaxJson vote(DxsProjectVoteSearchForm searchForm, DxsProjectVoteEntity dxsProjectVoteEntity, HttpServletRequest request) {
		// 或得登录用户
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
		AjaxJson ajax = new AjaxJson();
     if(user!=null){
	     searchForm.setIsDelete("0");
		 searchForm.setUserId(user.getId());
	     ReplyDataMode replyDataMode = new ReplyDataMode();
	     CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();


	     List<DxsProjectVoteEntity> vote = this.sysService.list(criteriaQuery);
	     int count = vote.size();
	     System.out.println(count);
		 if (count == 0) {

		String message = "操作成功!";
		try {

			dxsProjectVoteEntity.setUserId(user.getId());
			dxsProjectVoteEntity.setProjectId(searchForm.getProjectId());
			dxsProjectVoteEntity.setIsDelete(0);
			this.sysServiceI.saveOrUpdate(dxsProjectVoteEntity);
		} catch (Exception e) {
			e.printStackTrace();
			message = "操作失败";
			ajax.setSuccess(false);

			throw new BusinessException(e.getMessage());
		}
		System.out.println(message);
		ajax.setMsg(message);

	      }else {

		String message = "已投票";
		System.out.println(message);
		ajax.setMsg(message);

		 }


      }else {
		 String  message = "用户没有登录";
		 ajax.setMsg(message);
		 ajax.setSuccess(false);
	 }


		return ajax;

	}
}





