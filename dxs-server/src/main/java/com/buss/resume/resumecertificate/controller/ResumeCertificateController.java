package com.buss.resume.resumecertificate.controller;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;

import com.buss.resume.resume.entity.ResumeEntity;
import com.buss.resume.resumecertificate.entity.ResumeCertificateEntity;
import com.buss.resume.resumecertificate.trans.form.ResumeCertificateSearchForm;
import com.buss.resume.resumecertificate.trans.vo.ResumeCertificateVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
@RequestMapping("/resumeCertificate")
public class ResumeCertificateController {

	@Resource
	private SysServiceI sysService;

	@RequestMapping("/list.do")
	@ResponseBody
	public ReplyDataMode resumeCertificateList(ResumeCertificateSearchForm searchForm, HttpServletRequest request){


		ReplyDataMode replyDataMode = new ReplyDataMode();
		searchForm.setIsDelete("0");
		//获取用户登录信息
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

		ResumeEntity resumeEntity = new ResumeEntity();
		resumeEntity.setIsDelete(0);
		if(user!=null) {

			resumeEntity.setUserid(user.getId());
			List<ResumeEntity> resumeList = this.sysService.findByExample(ResumeEntity.class.getName(), resumeEntity);
			if (resumeList != null && resumeList.size() != 0) {
				searchForm.setResumeId(resumeList.get(0).getId());
				CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

				Map<String, Object> orderMap = new HashMap<String, Object>();
				orderMap.put("createTime", "desc");
				orderMap.put("updateTime", "desc");
				criteriaQuery.setOrder(orderMap);

				List<ResumeCertificateEntity> resumeCertificate = this.sysService.list(criteriaQuery);
				List<ResumeCertificateVO> resumeCertificateVOs = new ArrayList<ResumeCertificateVO>();

				for (ResumeCertificateEntity resumeCertificateEntity : resumeCertificate) {
					ResumeCertificateVO resumeCertificateVO = new ResumeCertificateVO();
					resumeCertificateVO.copyEntity(resumeCertificateEntity);
					resumeCertificateVOs.add(resumeCertificateVO);

				}
				replyDataMode.setData(resumeCertificateVOs);
			}
		}else {

			replyDataMode.setData("用户未登陆");
		}

		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}

	@RequestMapping("/saveResumeCertificate.do")
	@ResponseBody
	public ReplyDataMode saveResumeCertificate(ResumeCertificateSearchForm searchForm, HttpServletRequest request){
		String result = "操作成功";
		ReplyDataMode replyDataMode = new ReplyDataMode();

		//获取用户登录信息
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

		if(user!=null) {
			ResumeEntity resumeEntity = new ResumeEntity();
			resumeEntity.setIsDelete(0);

			resumeEntity.setUserid(user.getId());
			List<ResumeEntity> resumeList = this.sysService.findByExample(ResumeEntity.class.getName(), resumeEntity);
			if (resumeList != null && resumeList.size() != 0) {
				searchForm.setResumeId(resumeList.get(0).getId());

				//设置已确定字段
				ResumeCertificateEntity resumeCertificateEntity = (ResumeCertificateEntity) searchForm.toEntity();
				resumeCertificateEntity.setIsDelete(0);
				Date date = new Date();
				resumeCertificateEntity.setCreateTime(date);
				resumeCertificateEntity.setUpdateTime(date);

				try {

					this.sysService.saveOrUpdate(resumeCertificateEntity);

				}catch (Exception e){
					result= "操作失败";

				}
			}
		}else{
			result = "用户未登陆";
		}

		replyDataMode.setData(result);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}

	@RequestMapping("/updateResumeCertificate.do")
	@ResponseBody
	public ReplyDataMode updateResumeCertificate(ResumeCertificateSearchForm searchForm, HttpServletRequest request) throws Exception {

		String result = "操作成功";
		ReplyDataMode replyDataMode = new ReplyDataMode();

		ResumeCertificateEntity resumeCertificateEntity = this.sysService.getEntity(ResumeCertificateEntity.class,searchForm.getId());

		resumeCertificateEntity.setCertificateName(searchForm.getCertificateName());
		resumeCertificateEntity.setCertificateName2(searchForm.getCertificateName2());
		resumeCertificateEntity.setScore(searchForm.getScore());
		resumeCertificateEntity.setImgUrl(searchForm.getImgUrl());
		resumeCertificateEntity.setUpdateTime(new Date());

		try {

			this.sysService.saveOrUpdate(resumeCertificateEntity);

		}catch (Exception e){
			result = "操作失败";
		}

		replyDataMode.setData(result);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);
		return replyDataMode;

	}

	@RequestMapping("/deleteResumeCertificate.do")
	@ResponseBody
	public ReplyDataMode deleteResumeCertificate(ResumeCertificateSearchForm searchForm, HttpServletRequest request) {

		ReplyDataMode replyDataMode = new ReplyDataMode();
		String result = "操作成功";

		ResumeCertificateEntity resumeCertificateEntity = this.sysService.getEntity(ResumeCertificateEntity.class,searchForm.getId());
		resumeCertificateEntity.setIsDelete(1);

		try {

			this.sysService.saveOrUpdate(resumeCertificateEntity);

		}catch (Exception e){

			result = "操作失败";
		}

		replyDataMode.setData(result);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);
		return replyDataMode;

	}


	@RequestMapping("/listm.do")
	@ResponseBody
	public ReplyDataMode resumeCertificateListm(ResumeCertificateSearchForm searchForm, HttpServletRequest request){


		ReplyDataMode replyDataMode = new ReplyDataMode();
		searchForm.setIsDelete("0");

		ResumeEntity resumeEntity = new ResumeEntity();
		resumeEntity.setIsDelete(0);

			resumeEntity.setUserid("8a2c9a985722138e015722b7cbdb001c");
			List<ResumeEntity> resumeList = this.sysService.findByExample(ResumeEntity.class.getName(), resumeEntity);
			if (resumeList != null && resumeList.size() != 0) {
				searchForm.setResumeId(resumeList.get(0).getId());
				CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

				Map<String, Object> orderMap = new HashMap<String, Object>();
				orderMap.put("createTime", "desc");
				orderMap.put("updateTime", "desc");
				criteriaQuery.setOrder(orderMap);

				List<ResumeCertificateEntity> resumeCertificate = this.sysService.list(criteriaQuery);
				List<ResumeCertificateVO> resumeCertificateVOs = new ArrayList<ResumeCertificateVO>();

				for (ResumeCertificateEntity resumeCertificateEntity : resumeCertificate) {
					ResumeCertificateVO resumeCertificateVO = new ResumeCertificateVO();
					resumeCertificateVO.copyEntity(resumeCertificateEntity);
					resumeCertificateVOs.add(resumeCertificateVO);

				}
				replyDataMode.setData(resumeCertificateVOs);
			}


		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}


}