package com.buss.employedmeeting.controller;
import com.buss.common.service.SysServiceI;
import com.buss.employedmeeting.entity.EmployedMeetingEntity;
import com.buss.employedmeeting.trans.form.EmployedMeetingSearchForm;
import com.buss.employedmeeting.trans.vo.EmployedMeetingVO;
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
@RequestMapping("/employedMeeting")
public class EmployedMeetingController {

	@Resource
	private SysServiceI sysService;

	@RequestMapping("/list.do")
	@ResponseBody
	public ReplyDataMode employedList(EmployedMeetingSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("meetingSort","desc");
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		List<EmployedMeetingEntity> employedMeetings = this.sysService.list(criteriaQuery);
		List<EmployedMeetingVO> employedMeetingVOs = new ArrayList<EmployedMeetingVO>();

		for (EmployedMeetingEntity employedMeetingEntity:employedMeetings) {
			EmployedMeetingVO employedMeetingVO = new EmployedMeetingVO();
			employedMeetingVO.copyEntity(employedMeetingEntity);
			employedMeetingVOs.add(employedMeetingVO);

		}
		replyDataMode.setData(employedMeetingVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
	@RequestMapping("/pageList.do")
	@ResponseBody
	public ReplyDataMode employedMeetingPageList(EmployedMeetingSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String, Object> orderMap = new HashMap<>();
		orderMap.put("meetingSort","desc");
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());


		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<EmployedMeetingEntity> employedMeetings = mode.getResult();

		List<EmployedMeetingVO> employedMeetingVOs = new ArrayList<EmployedMeetingVO>();

		for (EmployedMeetingEntity employedMeetingEntity:employedMeetings) {
			EmployedMeetingVO employedMeetingVO = new EmployedMeetingVO();
			employedMeetingVO.copyEntity(employedMeetingEntity);
			employedMeetingVOs.add(employedMeetingVO);

		}
		mode.setResult(employedMeetingVOs);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
	
	@RequestMapping("/employedMeetingById.do")
	@ResponseBody
	public ReplyDataMode employedMeetingById(EmployedMeetingSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		List<EmployedMeetingEntity> employedMeetings = this.sysService.list(criteriaQuery);
		List<EmployedMeetingVO> employedMeetingVOs = new ArrayList<EmployedMeetingVO>();

		for (EmployedMeetingEntity employedMeetingEntity:employedMeetings) {
			EmployedMeetingVO employedMeetingVO = new EmployedMeetingVO();
			employedMeetingVO.copyEntity(employedMeetingEntity);
			employedMeetingVOs.add(employedMeetingVO);

		}
		replyDataMode.setData(employedMeetingVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
}

