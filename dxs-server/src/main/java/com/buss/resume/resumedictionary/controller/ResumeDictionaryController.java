package com.buss.resume.resumedictionary.controller;
import com.buss.common.service.SysServiceI;


import com.buss.resume.resumedictionary.entity.ResumeDictionaryEntity;
import com.buss.resume.resumedictionary.trans.form.ResumeDictionarySearchForm;
import com.buss.resume.resumedictionary.trans.vo.ResumeDictionaryVO;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author lu
 *
 */
@Controller
@RequestMapping("/resumeDictionary")
public class ResumeDictionaryController {

	@Resource
	private SysServiceI sysService;

	@RequestMapping("/list.do")
	@ResponseBody
	public ReplyDataMode resumeDictionaryList(ResumeDictionarySearchForm searchForm, HttpServletRequest request){

		searchForm.setIsDelete("0");

		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("sort","desc");
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		List<ResumeDictionaryEntity> resumeDictionary = this.sysService.list(criteriaQuery);
		List<ResumeDictionaryVO> resumeDictionaryVOs = new ArrayList<ResumeDictionaryVO>();

		for (ResumeDictionaryEntity resumeDictionaryEntity:resumeDictionary) {
			ResumeDictionaryVO resumeDictionaryVO = new ResumeDictionaryVO();
			resumeDictionaryVO.copyEntity(resumeDictionaryEntity);
			resumeDictionaryVOs.add(resumeDictionaryVO);

		}
		replyDataMode.setData(resumeDictionaryVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
	
}