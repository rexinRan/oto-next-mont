package com.buss.trainingcourse.controller;
import com.buss.common.service.SysServiceI;

import com.buss.trainingcourse.entity.TrainingCourseEntity;
import com.buss.trainingcourse.trans.form.TrainingCourseSearchForm;
import com.buss.trainingcourse.trans.vo.TrainingCourseVO;
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
@RequestMapping("/trainingCourse")
public class TrainingCourseController {

	@Resource
	private SysServiceI sysService;

	@RequestMapping("/list.do")
	@ResponseBody
	public ReplyDataMode trainingList(TrainingCourseSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("courseSort","desc");
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		List<TrainingCourseEntity> trainingCourses = this.sysService.list(criteriaQuery);
		List<TrainingCourseVO> trainingCourseVOs = new ArrayList<TrainingCourseVO>();

		for (TrainingCourseEntity trainingCourseEntity:trainingCourses) {
			TrainingCourseVO trainingCourseVO = new TrainingCourseVO();
			trainingCourseVO.copyEntity(trainingCourseEntity);
			trainingCourseVOs.add(trainingCourseVO);

		}
		replyDataMode.setData(trainingCourseVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
	@RequestMapping("/pageList.do")
	@ResponseBody
	public ReplyDataMode trainingCoursePageList(TrainingCourseSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String, Object> orderMap = new HashMap<>();
		orderMap.put("courseSort","asc");
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());


		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<TrainingCourseEntity> trainingCourses = mode.getResult();

		List<TrainingCourseVO> trainingCourseVOs = new ArrayList<TrainingCourseVO>();

		for (TrainingCourseEntity trainingCourseEntity:trainingCourses) {
			TrainingCourseVO trainingCourseVO = new TrainingCourseVO();
			trainingCourseVO.copyEntity(trainingCourseEntity);
			trainingCourseVOs.add(trainingCourseVO);

		}
		mode.setResult(trainingCourseVOs);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}


	@RequestMapping("/trainingCourseById.do")
	@ResponseBody
	public ReplyDataMode trainingCourseById(TrainingCourseSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		List<TrainingCourseEntity> trainingCourses = this.sysService.list(criteriaQuery);
		List<TrainingCourseVO> trainingCourseVOs = new ArrayList<TrainingCourseVO>();

		for (TrainingCourseEntity trainingCourseEntity:trainingCourses) {
			TrainingCourseVO trainingCourseVO = new TrainingCourseVO();
			trainingCourseVO.copyEntity(trainingCourseEntity);
			trainingCourseVOs.add(trainingCourseVO);

		}
		replyDataMode.setData(trainingCourseVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
}

