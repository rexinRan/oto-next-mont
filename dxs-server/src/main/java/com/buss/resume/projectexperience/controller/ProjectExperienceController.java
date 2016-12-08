package com.buss.resume.projectexperience.controller;
import com.buss.common.service.SysServiceI;


import com.buss.resume.projectexperience.entity.ProjectExperienceEntity;
import com.buss.resume.projectexperience.trans.form.ProjectExperienceSearchForm;
import com.buss.resume.projectexperience.trans.vo.ProjectExperienceVO;
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
@RequestMapping("/projectExperience")
public class ProjectExperienceController {

	@Resource
	private SysServiceI sysService;

	@RequestMapping("/list.do")
	@ResponseBody
	public ReplyDataMode projectExperienceList(ProjectExperienceSearchForm searchForm, HttpServletRequest request){

		searchForm.setIsDelete("0");

		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		List<ProjectExperienceEntity> projectExperience = this.sysService.list(criteriaQuery);
		List<ProjectExperienceVO> projectExperienceVOs = new ArrayList<ProjectExperienceVO>();

		for (ProjectExperienceEntity projectExperienceEntity:projectExperience) {
			ProjectExperienceVO projectExperienceVO = new ProjectExperienceVO();
			projectExperienceVO.copyEntity(projectExperienceEntity);
			projectExperienceVOs.add(projectExperienceVO);

		}
		replyDataMode.setData(projectExperienceVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}

	@RequestMapping("/saveProjectExperience.do")
	@ResponseBody
	public ReplyDataMode saveProjectExperience(ProjectExperienceSearchForm searchForm, HttpServletRequest request){

		ReplyDataMode replyDataMode = new ReplyDataMode();

		//设置已确定字段
		ProjectExperienceEntity projectExperienceEntity = (ProjectExperienceEntity) searchForm.toEntity();
		projectExperienceEntity.setIsDelete(0);
		Date date = new Date();
		projectExperienceEntity.setCreateTime(date);
		projectExperienceEntity.setUpdateTime(date);

		boolean flag = false;
		try {

			this.sysService.saveOrUpdate(projectExperienceEntity);
			flag = true;

		}catch (Exception e){

		}

		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(flag);
		return replyDataMode;
	}

	@RequestMapping("/updateProjectExperience.do")
	@ResponseBody
	public ReplyDataMode updateProjectExperience(ProjectExperienceSearchForm searchForm, HttpServletRequest request) {

		ReplyDataMode replyDataMode = new ReplyDataMode();

		ProjectExperienceEntity projectExperienceEntity = this.sysService.getEntity(ProjectExperienceEntity.class,searchForm.getId());

		projectExperienceEntity.setProjectName(searchForm.getProjectName());
		projectExperienceEntity.setProjectNum(searchForm.getProjectNum());
		projectExperienceEntity.setProjectTask(searchForm.getProjectTask());
		projectExperienceEntity.setProjectStart(searchForm.getProjectStart());
		projectExperienceEntity.setProjectEnd(searchForm.getProjectEnd());
		projectExperienceEntity.setProjectDescription(searchForm.getProjectDescription());
		projectExperienceEntity.setUpdateTime(new Date());

		boolean flag = false;
		try {

			this.sysService.saveOrUpdate(projectExperienceEntity);
			flag = true;

		}catch (Exception e){

		}

		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(flag);
		return replyDataMode;

	}

	@RequestMapping("/deleteProjectExperience.do")
	@ResponseBody
	public ReplyDataMode deleteProjectExperience(ProjectExperienceSearchForm searchForm, HttpServletRequest request) {

		ReplyDataMode replyDataMode = new ReplyDataMode();

		ProjectExperienceEntity projectExperienceEntity = this.sysService.getEntity(ProjectExperienceEntity.class,searchForm.getId());

		projectExperienceEntity.setIsDelete(1);

		boolean flag = false;
		try {

			this.sysService.saveOrUpdate(projectExperienceEntity);
			flag = true;

		}catch (Exception e){

		}

		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(flag);
		return replyDataMode;

	}


}