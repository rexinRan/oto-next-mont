package com.buss.resume.resumeskills.controller;
import com.buss.common.service.SysServiceI;


import com.buss.resume.resumeskills.entity.ResumeSkillsEntity;
import com.buss.resume.resumeskills.trans.form.ResumeSkillsSearchForm;
import com.buss.resume.resumeskills.trans.vo.ResumeSkillsVO;
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
@RequestMapping("/resumeSkills")
public class ResumeSkillsController {

	@Resource
	private SysServiceI sysService;

	@RequestMapping("/list.do")
	@ResponseBody
	public ReplyDataMode resumeSkillsList(ResumeSkillsSearchForm searchForm, HttpServletRequest request){

		searchForm.setIsDelete("0");

		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		List<ResumeSkillsEntity> resumeSkills = this.sysService.list(criteriaQuery);
		List<ResumeSkillsVO> resumeSkillsVOs = new ArrayList<ResumeSkillsVO>();

		for (ResumeSkillsEntity resumeSkillsEntity:resumeSkills) {
			ResumeSkillsVO resumeSkillsVO = new ResumeSkillsVO();
			resumeSkillsVO.copyEntity(resumeSkillsEntity);
			resumeSkillsVOs.add(resumeSkillsVO);

		}
		replyDataMode.setData(resumeSkillsVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}


	@RequestMapping("/updateResumeSkills.do")
	@ResponseBody
	public ReplyDataMode updateResumeSkills(ResumeSkillsSearchForm searchForm, HttpServletRequest request) {

		String skills = searchForm.getSkills();
		searchForm.setSkills(null);
		ReplyDataMode replyDataMode = new ReplyDataMode();
		searchForm.setIsDelete("0");

		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		List<ResumeSkillsEntity> resumeSkillsEntityList = this.sysService.list(criteriaQuery);
		ResumeSkillsEntity resumeSkillsEntity;

		boolean flag = false;
		if(resumeSkillsEntityList.size() != 0) {
			resumeSkillsEntity = resumeSkillsEntityList.get(0);
			resumeSkillsEntity.setSkills(skills);
			resumeSkillsEntity.setUpdateTime(new Date());

			try {

				this.sysService.saveOrUpdate(resumeSkillsEntity);
				flag = true;

			} catch (Exception e) {

			}
		}else {
			resumeSkillsEntity = new ResumeSkillsEntity();
			resumeSkillsEntity.setResumeId(searchForm.getResumeId());
			resumeSkillsEntity.setSkills(skills);
			resumeSkillsEntity.setIsDelete(0);
			resumeSkillsEntity.setSkillsType(searchForm.getSkillsType());
			Date date = new Date();
			resumeSkillsEntity.setCreateTime(date);
			resumeSkillsEntity.setUpdateTime(date);

			try {

				this.sysService.saveOrUpdate(resumeSkillsEntity);
				flag = true;

			} catch (Exception e) {

			}
		}

		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(flag);
		return replyDataMode;

	}



}