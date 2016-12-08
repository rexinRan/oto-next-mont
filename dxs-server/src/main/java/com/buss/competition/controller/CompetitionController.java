package com.buss.competition.controller;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.collentions.entity.CollentionsEntity;
import com.buss.common.service.SysServiceI;
import com.buss.competition.entity.CompetitionEntity;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.buss.competition.trans.form.CompetitionForm;
import com.buss.competition.trans.vo.CompetitionNumberVO;
import com.buss.competition.trans.vo.CompetitionVO;
import com.buss.member.entity.GeneralUserEntity;
import com.buss.project.projects.entity.ProjectEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.*;

/**   
 * @Title: Controller
 * @Description: dxs_competition
 * @author onlineGenerator
 * @date 2016-07-21 15:40:26
 * @version V1.0   
 *
 */

@Controller
@RequestMapping("/dxsCompetitionController")
public class CompetitionController {

	@Resource
	private SysServiceI sysService;


	@RequestMapping("/list.do")
	@ResponseBody
	public ReplyDataMode DxsCompetitionList(CompetitionForm searchForm, HttpServletRequest request) {

		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String, Object> orderMap = new HashMap<>();
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());


		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<CompetitionEntity> competitions = mode.getResult();

		List<CompetitionVO> competitionVOs = new ArrayList<CompetitionVO>();

		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

		for (CompetitionEntity employedEntity:competitions) {
			CompetitionVO competitionVO = new CompetitionVO();
			competitionVO.copyEntity(employedEntity);
        	if(employedEntity.getCompetitionStartTime()!=null&&employedEntity.getCompetitionEndTime()!=null){
				String type=null;
	         	if(new Date().before(employedEntity.getCompetitionStartTime())){
		         	type="报名中";
			 	}if(new Date().after(employedEntity.getCompetitionEndTime())){
		        	 type="已结束";
	        	 }if (new Date().before(employedEntity.getCompetitionEndTime())&& new Date().after(employedEntity.getCompetitionStartTime()) ){
					type="进行中";
				}
				competitionVO.setType(type);

				competitionVO.setIsCollention("未关注");
				if(user!=null){
					CollentionsEntity collentionEntity = new CollentionsEntity();
					collentionEntity.setOutId(competitionVO.getId());
					collentionEntity.setUserId(user.getId());
					collentionEntity.setIsDelete(0);
					List collentions = this.sysService.findByExample(CollentionsEntity.class.getName(),collentionEntity);
					if(collentions != null&&collentions.size()>0){
						competitionVO.setIsCollention("已关注");
					}
				}
			competitionVO.setCompetitionIntroduce(null);
			competitionVO.setCompetitionRule(null);
	   		 competitionVOs.add(competitionVO);

   		 }

		}

		mode.setResult(competitionVOs);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}


	@RequestMapping("/CompetitionNumber.do")
	@ResponseBody
	public ReplyDataMode CompetitionNumber(CompetitionForm searchForm, HttpServletRequest request) {

		ReplyDataMode replyDataMode = new ReplyDataMode();
		CompetitionNumberVO competitionNumberVO = new CompetitionNumberVO();

		GeneralUserEntity empUserEntity = new GeneralUserEntity();
		empUserEntity.setIsdelete(0);
		empUserEntity.setRolecode("emp");
		List empList = this.sysService.findByExample(GeneralUserEntity.class.getName(),empUserEntity);
		if(empList!=null){
			competitionNumberVO.setEmpNum(Integer.toString(empList.size()));
		}

		GeneralUserEntity studentUserEntity = new GeneralUserEntity();
		studentUserEntity.setIsdelete(0);
		studentUserEntity.setRolecode("student");
		List studentList = this.sysService.findByExample(GeneralUserEntity.class.getName(),studentUserEntity);
		if(studentList!=null){
			competitionNumberVO.setStudentNum(Integer.toString(studentList.size()));
		}

		ProjectEntity projectEntity = new ProjectEntity();
		projectEntity.setIsDelete(0);
		List projectList = this.sysService.findByExample(ProjectEntity.class.getName(),projectEntity);
		if(projectList!=null){
			competitionNumberVO.setProjectNum(Integer.toString(projectList.size()));
		}

		replyDataMode.setData(competitionNumberVO);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}


	/**
	 * 查询最新大赛
	 * @return
     */
	@RequestMapping(value = "upToDatemegagame")
	@ResponseBody
	public CompetitionVO upToDatemegagame(){
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CompetitionForm competitionForm = new CompetitionForm();
		competitionForm.setIsDelete("0");
		CriteriaQuery criteriaQuery = competitionForm.getCriteriaQuery();
		criteriaQuery.addOrder("createTime","desc");

		List<CompetitionEntity> competitionEntityList = this.sysService.list(criteriaQuery);
		CompetitionVO competitionVO = new CompetitionVO();

		if (competitionEntityList != null && competitionEntityList.size() > 0){
			competitionVO.copyEntity(competitionEntityList.get(0));
		}

		return competitionVO;
	}
}
