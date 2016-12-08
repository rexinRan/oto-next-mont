package com.buss.projectarea.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.alibaba.fastjson.JSON;
import com.buss.projectarea.entity.ProjectAreaEntity;
import com.buss.projectarea.trans.form.ProjectAreaSearchForm;
import com.buss.projectarea.trans.vo.ProjectAreaVO;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buss.common.service.SysServiceI;

/**
 * @author lu
 *
 */
@Controller
public class ProjectAreaController {

	@Resource
	private SysServiceI sysService;

	@RequestMapping("/projectArea/list.do")
	@ResponseBody
	public ReplyDataMode projectAreaList(ProjectAreaSearchForm searchForm, HttpServletRequest request, @RequestParam(required = false, value = "callback") String callback, HttpServletResponse response){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("sort", "desc");
		criteriaQuery.setOrder(orderMap);
		List<ProjectAreaEntity> projectAreas = this.sysService.list(criteriaQuery);
		List<ProjectAreaVO> projectAreaVOs = new ArrayList<ProjectAreaVO>();

		for (ProjectAreaEntity projectArea:projectAreas) {
			ProjectAreaVO projectAreaVO = new ProjectAreaVO();
			projectAreaVO.copyEntity(projectArea);
			projectAreaVOs.add(projectAreaVO);

		}
		replyDataMode.setData(projectAreaVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

//		return replyDataMode;
		if (callback == null || "".equals(callback)) {
			return replyDataMode; // 非 JSONP 请求，返回正常的 JOSN 数据
		} else {
			try { String res = JSON.toJSONString(replyDataMode);
				response.getWriter().write(callback + "(" + res + ")");
				response.getWriter().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null; // JSONP 请求，返回 JOSNP 数据
		}
	}
}

