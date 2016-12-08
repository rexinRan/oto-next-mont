package com.buss.activecatelog.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.buss.activecatelog.entity.ActiveCatelogEntity;
import com.buss.activecatelog.trans.form.ActiveCatelogSearchForm;
import com.buss.activecatelog.trans.vo.ActiveCatelogVO;
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
@RequestMapping("/activecatelog")
@Controller
public class ActiveCatelogController {

	@Resource
	private SysServiceI sysService;

	@RequestMapping("/list.do")
	@ResponseBody
	public ReplyDataMode newsCatelogList(ActiveCatelogSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();


		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("activeCatelogSort", "desc");
		criteriaQuery.setOrder(orderMap);
		List<ActiveCatelogEntity> activeCatelogs = this.sysService.list(criteriaQuery);
		List<ActiveCatelogVO> activeCatelogVOs = new ArrayList<ActiveCatelogVO>();

		for (ActiveCatelogEntity activeCatelog:activeCatelogs) {
			ActiveCatelogVO activeCatelogVO = new ActiveCatelogVO();
			activeCatelogVO.copyEntity(activeCatelog);
			activeCatelogVOs.add(activeCatelogVO);

		}
		replyDataMode.setData(activeCatelogVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
	@RequestMapping("/pageList.do")
	@ResponseBody
	public ReplyDataMode activeCatelogpageList(ActiveCatelogSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String, Object> orderMap = new HashMap<>();
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());

		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<ActiveCatelogEntity> activeCatelog = mode.getResult();

		List<ActiveCatelogVO> activeCatelogVOs = new ArrayList<ActiveCatelogVO>();

		for (ActiveCatelogEntity activeCatelogEntity:activeCatelog) {
			ActiveCatelogVO activeCatelogVO = new ActiveCatelogVO();
			activeCatelogVO.copyEntity(activeCatelogEntity);
			activeCatelogVOs.add(activeCatelogVO);

		}
		mode.setResult(activeCatelogVOs);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}

}

