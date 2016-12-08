package com.buss.employedmeetingemployed.controller;
import com.buss.common.service.SysServiceI;

import com.buss.employedmeetingemployed.entity.EmployedMeetingEmployedEntity;
import com.buss.employedmeetingemployed.trans.form.EmployedMeetingEmployedSearchForm;
import com.buss.employedmeetingemployed.trans.vo.EmployedMeetingEmployedVO;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lu
 *
 */
@Controller
@RequestMapping("/employedMeetingEmployed")
public class
EmployedMeetingEmployedController {

	@Resource
	private SysServiceI sysService;

	@RequestMapping("/list.do")
	@ResponseBody
	public ReplyDataMode employedList(EmployedMeetingEmployedSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("employedSort","desc");
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		List<EmployedMeetingEmployedEntity> employedMeetingEmployeds = this.sysService.list(criteriaQuery);
		List<EmployedMeetingEmployedVO> employedMeetingEmployedVOs = new ArrayList<EmployedMeetingEmployedVO>();

		for (EmployedMeetingEmployedEntity employedMeetingEmployedEntity:employedMeetingEmployeds) {
			EmployedMeetingEmployedVO employedMeetingEmployedVO = new EmployedMeetingEmployedVO();
			employedMeetingEmployedVO.copyEntity(employedMeetingEmployedEntity);
			employedMeetingEmployedVOs.add(employedMeetingEmployedVO);

		}
		replyDataMode.setData(employedMeetingEmployedVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
	@RequestMapping("/pageList.do")
	@ResponseBody
	public ReplyDataMode employedMeetingEmployedPageList(EmployedMeetingEmployedSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String, Object> orderMap = new HashMap<>();
		orderMap.put("employedSort","desc");
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());


		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<EmployedMeetingEmployedEntity> employedMeetingEmployeds = mode.getResult();

		List<EmployedMeetingEmployedVO> employedMeetingEmployedVOs = new ArrayList<EmployedMeetingEmployedVO>();

		for (EmployedMeetingEmployedEntity employedMeetingEmployedEntity:employedMeetingEmployeds) {
			EmployedMeetingEmployedVO employedMeetingEmployedVO = new EmployedMeetingEmployedVO();
			employedMeetingEmployedVO.copyEntity(employedMeetingEmployedEntity);
			employedMeetingEmployedVOs.add(employedMeetingEmployedVO);

		}
		mode.setResult(employedMeetingEmployedVOs);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}

}

