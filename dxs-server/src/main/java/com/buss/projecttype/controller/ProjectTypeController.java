package com.buss.projecttype.controller;
import com.alibaba.fastjson.JSON;
import com.buss.common.service.SysServiceI;
import com.buss.projecttype.entity.ProjectTypeEntity;
import com.buss.projecttype.trans.form.ProjectTypeSearchForm;
import com.buss.projecttype.trans.vo.ProjectTypeVO;
import org.apache.commons.collections.list.PredicatedList;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lu
 *
 */
@Controller
public class ProjectTypeController {

	@Resource
	private SysServiceI sysService;

	@RequestMapping("/projectType/list.do")
	@ResponseBody
	public ReplyDataMode projectTypeList(ProjectTypeSearchForm searchForm, HttpServletRequest request, @RequestParam(required = false, value = "callback") String callback, HttpServletResponse response ){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("sort", "desc");
		criteriaQuery.setOrder(orderMap);
		List<ProjectTypeEntity> projectTypes = this.sysService.list(criteriaQuery);
		List<ProjectTypeVO> projectTypeVOs = new ArrayList<ProjectTypeVO>();

		for (ProjectTypeEntity projectType:projectTypes) {
			ProjectTypeVO projectTypeVO = new ProjectTypeVO();
			projectTypeVO.copyEntity(projectType);
			projectTypeVOs.add(projectTypeVO);

		}
		replyDataMode.setData(projectTypeVOs);
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

	/**
	 * 查询所有的类别
	 * @param request
	 * @return
     */
	@RequestMapping(value = "/projectType/categoryOf")
	@ResponseBody
	public ReplyDataMode categoryOf(HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();

		List<ProjectTypeEntity> projectTypeEntityList = this.sysService.findByProperty(ProjectTypeEntity.class,"isDelete",0);
		List<ProjectTypeVO> projectTypeVOs = new ArrayList<ProjectTypeVO>();

		if (projectTypeEntityList != null && projectTypeEntityList.size() > 0){

			for(ProjectTypeEntity pte:projectTypeEntityList){
				ProjectTypeVO projectTypeVO = new ProjectTypeVO();
				projectTypeVO.copyEntity(pte);
				projectTypeVOs.add(projectTypeVO);
			}

			replyDataMode.setData(projectTypeVOs);
			replyDataMode.setStatusCode("200");
			replyDataMode.setSuccess(true);
		}

		return replyDataMode;
	}
}

