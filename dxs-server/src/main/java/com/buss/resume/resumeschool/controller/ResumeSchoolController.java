package com.buss.resume.resumeschool.controller;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;

import com.buss.resume.resume.entity.ResumeEntity;
import com.buss.resume.resumeschool.entity.ResumeSchoolEntity;
import com.buss.resume.resumeschool.trans.form.ResumeSchoolSearchForm;
import com.buss.resume.resumeschool.trans.vo.ResumeSchoolVO;
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
@RequestMapping("/resumeSchool")
public class ResumeSchoolController {

	@Resource
	private SysServiceI sysService;

	@RequestMapping("/list.do")
	@ResponseBody
	public ReplyDataMode resumeSchoolList(ResumeSchoolSearchForm searchForm, HttpServletRequest request){


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

				List<ResumeSchoolEntity> resumeSchool = this.sysService.list(criteriaQuery);
				List<ResumeSchoolVO> resumeSchoolVOs = new ArrayList<ResumeSchoolVO>();

				for (ResumeSchoolEntity resumeSchoolEntity : resumeSchool) {
					ResumeSchoolVO resumeSchoolVO = new ResumeSchoolVO();
					resumeSchoolVO.copyEntity(resumeSchoolEntity);
					resumeSchoolVOs.add(resumeSchoolVO);

				}
				replyDataMode.setData(resumeSchoolVOs);
			}
		}else {

			replyDataMode.setData("用户未登陆");
		}

		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}

	@RequestMapping("/saveResumeSchool.do")
	@ResponseBody
	public ReplyDataMode saveResumeSchool(ResumeSchoolSearchForm searchForm, HttpServletRequest request){
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
				ResumeSchoolEntity resumeSchoolEntity = (ResumeSchoolEntity) searchForm.toEntity();
				resumeSchoolEntity.setIsDelete(0);
				Date date = new Date();
				resumeSchoolEntity.setCreateTime(date);
				resumeSchoolEntity.setUpdateTime(date);

				try {

					this.sysService.saveOrUpdate(resumeSchoolEntity);

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

	@RequestMapping("/updateResumeSchool.do")
	@ResponseBody
	public ReplyDataMode updateResumeSchool(ResumeSchoolSearchForm searchForm, HttpServletRequest request) {

		String result = "操作成功";
		ReplyDataMode replyDataMode = new ReplyDataMode();

		ResumeSchoolEntity resumeSchoolEntity = this.sysService.getEntity(ResumeSchoolEntity.class,searchForm.getId());

		resumeSchoolEntity.setSchoolStart(searchForm.getSchoolStart());
		resumeSchoolEntity.setSchoolEnd(searchForm.getSchoolEnd());
		resumeSchoolEntity.setSchoolName(searchForm.getSchoolName());
		resumeSchoolEntity.setSchoolProfessional(searchForm.getSchoolProfessional());
		resumeSchoolEntity.setSchoolQualifications(searchForm.getSchoolQualifications()	);
		resumeSchoolEntity.setCourses(searchForm.getCourses());
		resumeSchoolEntity.setGpa(searchForm.getGpa());
		resumeSchoolEntity.setTeacher(searchForm.getTeacher());
		resumeSchoolEntity.setUpdateTime(new Date());

		try {

			this.sysService.saveOrUpdate(resumeSchoolEntity);

		}catch (Exception e){
			result = "操作失败";
		}

		replyDataMode.setData(result);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);
		return replyDataMode;

	}

	@RequestMapping("/deleteResumeSchool.do")
	@ResponseBody
	public ReplyDataMode deleteResumeSchool(ResumeSchoolSearchForm searchForm, HttpServletRequest request) {

		ReplyDataMode replyDataMode = new ReplyDataMode();
		String result = "操作成功";

		ResumeSchoolEntity resumeSchoolEntity = this.sysService.getEntity(ResumeSchoolEntity.class,searchForm.getId());
		resumeSchoolEntity.setIsDelete(1);


		try {

			this.sysService.saveOrUpdate(resumeSchoolEntity);

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
	public ReplyDataMode resumeSchoolListm(ResumeSchoolSearchForm searchForm, HttpServletRequest request){


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

				List<ResumeSchoolEntity> resumeSchool = this.sysService.list(criteriaQuery);
				List<ResumeSchoolVO> resumeSchoolVOs = new ArrayList<ResumeSchoolVO>();

				for (ResumeSchoolEntity resumeSchoolEntity : resumeSchool) {
					ResumeSchoolVO resumeSchoolVO = new ResumeSchoolVO();
					resumeSchoolVO.copyEntity(resumeSchoolEntity);
					resumeSchoolVOs.add(resumeSchoolVO);

				}
				replyDataMode.setData(resumeSchoolVOs);
			}

		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}


}