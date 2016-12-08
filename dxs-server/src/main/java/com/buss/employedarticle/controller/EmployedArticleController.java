package com.buss.employedarticle.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import com.buss.employedarticle.entity.EmployedArticleEntity;
import com.buss.employedarticle.trans.form.EmployedArticleSearchForm;
import com.buss.employedarticle.trans.vo.EmployedArticleVO;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buss.common.service.SysServiceI;

/**
 * @author lu
 *
 */
@Controller
@RequestMapping("/employedArticle")
public class EmployedArticleController {

	@Resource
	private SysServiceI sysService;

	@RequestMapping("/list.do")
	@ResponseBody
	public ReplyDataMode employedList(EmployedArticleSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("emoloyedSort","desc");
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		List<EmployedArticleEntity> employedarticles = this.sysService.list(criteriaQuery);
		List<EmployedArticleVO> employedArticleVOs = new ArrayList<EmployedArticleVO>();

		for (EmployedArticleEntity employedArticleEntity:employedarticles) {
			EmployedArticleVO employedArticleVO = new EmployedArticleVO();
			employedArticleVO.copyEntity(employedArticleEntity);
			employedArticleVOs.add(employedArticleVO);

		}
		replyDataMode.setData(employedArticleVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}


	@RequestMapping("/pageList.do")
	@ResponseBody
	public ReplyDataMode employedArticlePageList(EmployedArticleSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String, Object> orderMap = new HashMap<>();
		orderMap.put("emoloyedPublishTime", "desc");
		criteriaQuery.setOrder(orderMap);

		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());


		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<EmployedArticleEntity> employedarticles = mode.getResult();

		List<EmployedArticleVO> employedArticleVOs = new ArrayList<EmployedArticleVO>();

		for (EmployedArticleEntity employedArticleEntity:employedarticles) {
			EmployedArticleVO employedArticleVO = new EmployedArticleVO();
			employedArticleVO.copyEntity(employedArticleEntity);
			employedArticleVOs.add(employedArticleVO);

		}
		mode.setResult(employedArticleVOs);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}

	@RequestMapping("/searchPageList.do")
	@ResponseBody
	public ReplyDataMode searchEmployedArticlePageList(EmployedArticleSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");

		String temp = searchForm.getEmoloyedContents();
		searchForm.setEmoloyedContents(null);

		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String, Object> orderMap = new HashMap<>();
		orderMap.put("emoloyedPublishTime", "desc");
		criteriaQuery.setOrder(orderMap);

		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());

		String likeName = "%" + temp + "%";
		try{
			criteriaQuery.like("emoloyedTitle",likeName);
		}catch (Exception e) {
			throw e;
		}
		criteriaQuery.add();

		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<EmployedArticleEntity> employedarticles = mode.getResult();

		List<EmployedArticleVO> employedArticleVOs = new ArrayList<EmployedArticleVO>();

		for (EmployedArticleEntity employedArticleEntity:employedarticles) {
			EmployedArticleVO employedArticleVO = new EmployedArticleVO();
			employedArticleVO.copyEntity(employedArticleEntity);
			employedArticleVOs.add(employedArticleVO);

		}
		mode.setResult(employedArticleVOs);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("emoloyedContents",temp);
		replyDataMode.setAttribute(map);

		return replyDataMode;
	}

	@RequestMapping("/employedArticleById.do")
	@ResponseBody
	public ReplyDataMode employedArticleById(EmployedArticleSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		List<EmployedArticleEntity> employedarticles = this.sysService.list(criteriaQuery);
		List<EmployedArticleVO> employedArticleVOs = new ArrayList<EmployedArticleVO>();

		for (EmployedArticleEntity employedArticleEntity:employedarticles) {
			EmployedArticleVO employedArticleVO = new EmployedArticleVO();
			employedArticleVO.copyEntity(employedArticleEntity);
			employedArticleVOs.add(employedArticleVO);

		}
		replyDataMode.setData(employedArticleVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
}

