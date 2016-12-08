package com.buss.resume.resumelanguage.controller;
import com.buss.common.service.SysServiceI;


import com.buss.resume.resumelanguage.entity.ResumeLanguageEntity;
import com.buss.resume.resumelanguage.trans.form.ResumeLanguageSearchForm;
import com.buss.resume.resumelanguage.trans.vo.ResumeLanguageVO;
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
@RequestMapping("/resumeLanguage")
public class ResumeLanguageController {

	@Resource
	private SysServiceI sysService;

	@RequestMapping("/list.do")
	@ResponseBody
	public ReplyDataMode resumeLanguageList(ResumeLanguageSearchForm searchForm, HttpServletRequest request){

		searchForm.setIsDelete("0");

		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		List<ResumeLanguageEntity> resumeLanguage = this.sysService.list(criteriaQuery);
		List<ResumeLanguageVO> resumeLanguageVOs = new ArrayList<ResumeLanguageVO>();

		for (ResumeLanguageEntity resumeLanguageEntity:resumeLanguage) {
			ResumeLanguageVO resumeLanguageVO = new ResumeLanguageVO();
			resumeLanguageVO.copyEntity(resumeLanguageEntity);
			resumeLanguageVOs.add(resumeLanguageVO);

		}
		replyDataMode.setData(resumeLanguageVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}

	@RequestMapping("/saveResumeLanguage.do")
	@ResponseBody
	public ReplyDataMode saveResumeLanguage(ResumeLanguageSearchForm searchForm, HttpServletRequest request){

		ReplyDataMode replyDataMode = new ReplyDataMode();

		//设置已确定字段
		ResumeLanguageEntity resumeLanguageEntity = (ResumeLanguageEntity) searchForm.toEntity();
		resumeLanguageEntity.setIsDelete(0);
		Date date = new Date();
		resumeLanguageEntity.setCreateTime(date);
		resumeLanguageEntity.setUpdateTime(date);

		boolean flag = false;
		try {

			this.sysService.saveOrUpdate(resumeLanguageEntity);
			flag = true;

		}catch (Exception e){

		}

		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(flag);

		return replyDataMode;
	}

	@RequestMapping("/updateResumeLanguage.do")
	@ResponseBody
	public ReplyDataMode updateResumeLanguage(ResumeLanguageSearchForm searchForm, HttpServletRequest request) {

		ReplyDataMode replyDataMode = new ReplyDataMode();

		ResumeLanguageEntity resumeLanguageEntity = this.sysService.getEntity(ResumeLanguageEntity.class,searchForm.getId());

		resumeLanguageEntity.setLanguageName(searchForm.getLanguageName());
		resumeLanguageEntity.setLanguageListenSay(searchForm.getLanguageListenSay());
		resumeLanguageEntity.setLanguageReadWrite(searchForm.getLanguageReadWrite());
		resumeLanguageEntity.setLanguageClass(searchForm.getLanguageClass());
		resumeLanguageEntity.setLanguageSore(searchForm.getLanguageSore());
		resumeLanguageEntity.setUpdateTime(new Date());

		boolean flag = false;
		try {

			this.sysService.saveOrUpdate(resumeLanguageEntity);
			flag = true;

		}catch (Exception e){

		}

		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(flag);
		return replyDataMode;

	}

	@RequestMapping("/deleteResumeLanguage.do")
	@ResponseBody
	public ReplyDataMode deleteResumeLanguage(ResumeLanguageSearchForm searchForm, HttpServletRequest request) {

		ReplyDataMode replyDataMode = new ReplyDataMode();

		ResumeLanguageEntity resumeLanguageEntity = this.sysService.getEntity(ResumeLanguageEntity.class,searchForm.getId());

		resumeLanguageEntity.setIsDelete(1);

		boolean flag = false;
		try {

			this.sysService.saveOrUpdate(resumeLanguageEntity);
			flag = true;

		}catch (Exception e){

		}


		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(flag);
		return replyDataMode;

	}


}