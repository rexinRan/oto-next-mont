package com.buss.newscatelog.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.buss.newscatelog.entity.NewsCatelogEntity;
import com.buss.newscatelog.trans.form.NewsCatelogSearchForm;
import com.buss.newscatelog.trans.vo.NewsCatelogVO;
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
public class NewsCatelogController {

	@Resource
	private SysServiceI sysService;

	@RequestMapping("/newsCatelog/list.do")
	@ResponseBody
	public ReplyDataMode newsCatelogList(NewsCatelogSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("sort", "desc");
		criteriaQuery.setOrder(orderMap);
		List<NewsCatelogEntity> newsCatelogs = this.sysService.list(criteriaQuery);
		List<NewsCatelogVO> newsCatelogVOs = new ArrayList<NewsCatelogVO>();

		for (NewsCatelogEntity newsCatelog:newsCatelogs) {
			NewsCatelogVO newsCatelogVO = new NewsCatelogVO();
			newsCatelogVO.copyEntity(newsCatelog);
			newsCatelogVOs.add(newsCatelogVO);

		}
		replyDataMode.setData(newsCatelogVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
}

