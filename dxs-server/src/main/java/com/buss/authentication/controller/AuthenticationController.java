package com.buss.authentication.controller;

import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.authentication.entity.DxsAuthenticationEntity;
import com.buss.authentication.trans.form.AuthenticationSearchForm;
import com.buss.authentication.trans.vo.AuthenticationVo;
import com.buss.authentication.trans.vo.TutorVO;
import com.buss.collentions.entity.CollentionsEntity;
import com.buss.common.model.json.AjaxJson;
import com.buss.common.service.SysServiceI;
import com.buss.usercompancy.entity.UserCompancyEntity;
import com.buss.usercompancy.trans.vo.UserCompancyVO;
import com.buss.userdetail.entity.UserDetailEntity;
import com.buss.userdetail.trans.vo.UserDetailVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.jweb.core.util.MyBeanUtils;
import org.jweb.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**   
 * @Title: Controller
 * @Description: dxs_authentication
 * @author onlineGenerator
 * @date 2016-07-19 13:24:51
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/Authentication")
public class AuthenticationController {
		
	@Autowired
	private SysServiceI sysService;
	//select a.id,a.user_id from dxs_authentication a where is_delete=0 and a.authentication_result in(8,11,14)

	//创业导师
	@RequestMapping("/pageList.do")
	@ResponseBody
	public ReplyDataMode authenticationpageList(AuthenticationSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		searchForm.setAuthenticationResult("8");
		ReplyDataMode replyDataMode  = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String, Object> orderMap = new HashMap<>();
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());

		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<DxsAuthenticationEntity> authentication = mode.getResult();

		List<TutorVO> tutorVOs = new ArrayList<TutorVO>();

		for (DxsAuthenticationEntity authenticationEntity:authentication) {
			AuthenticationVo authenticationVO = new AuthenticationVo();
			TutorVO tutorVO = new TutorVO();
			authenticationVO.copyEntity(authenticationEntity);
			tutorVO.setSkills(authenticationVO.getToturSkill());
			tutorVO.setId(authenticationVO.getId());
			UserDetailEntity userDetailEntity = new UserDetailEntity();
			userDetailEntity.setIsDelete(0);
			userDetailEntity.setUserId(authenticationVO.getUserId());
			List userDetailList = this.sysService.findByExample(UserDetailEntity.class.getName(),userDetailEntity);
			if(userDetailList!=null&&userDetailList.size()!=0){
				UserDetailEntity userDetail = (UserDetailEntity) userDetailList.get(0);
				tutorVO.setImage(userDetail.getHeadImg());
				List jobList = new ArrayList<>();
				String jobSchool = userDetail.getJobSchool();
				if(!StringUtil.isEmpty(jobSchool)){
					if(jobSchool.contains("#")){
						String [] job = jobSchool.split("#");
						for(String j:job){
							jobList.add(j);
						}
					}else {
						jobList.add(jobSchool);
					}
				}

				tutorVO.setJobSchoolList(jobList);
				tutorVO.setName(userDetail.getName());
				tutorVO.setPosition(userDetail.getJobSchoolPosition());
				tutorVO.setSchoolEducation(userDetail.getSchoolEducation());
				tutorVO.setSchool(userDetail.getSchoolName());
			}else {
				List jobList = new ArrayList<>();
				List list = new ArrayList();
				list.add("");
				jobList.add(list);
				tutorVO.setJobSchoolList(jobList);
			}
			tutorVO.setIsCollention("未关注");
			if(user!=null){
				CollentionsEntity collentionEntity = new CollentionsEntity();
				collentionEntity.setOutId(authenticationVO.getId());
				collentionEntity.setUserId(user.getId());
				collentionEntity.setIsDelete(0);
				List collentions = this.sysService.findByExample(CollentionsEntity.class.getName(),collentionEntity);
				if(collentions != null&&collentions.size()>0){
					tutorVO.setIsCollention("已关注");
				}
			}
			tutorVOs.add(tutorVO);

		}

		mode.setResult(tutorVOs);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}

	//就业导师
	@RequestMapping("/empTeacherList.do")
	@ResponseBody
	public ReplyDataMode empTeacherList(AuthenticationSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		searchForm.setAuthenticationResult("11");
		ReplyDataMode replyDataMode  = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String, Object> orderMap = new HashMap<>();
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());

		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<DxsAuthenticationEntity> authentication = mode.getResult();

		List<TutorVO> tutorVOs = new ArrayList<TutorVO>();

		for (DxsAuthenticationEntity authenticationEntity:authentication) {
			AuthenticationVo authenticationVO = new AuthenticationVo();
			TutorVO tutorVO = new TutorVO();
			authenticationVO.copyEntity(authenticationEntity);
			tutorVO.setSkills(authenticationVO.getToturSkill());
			tutorVO.setId(authenticationVO.getId());
			UserDetailEntity userDetailEntity = new UserDetailEntity();
			userDetailEntity.setIsDelete(0);
			userDetailEntity.setUserId(authenticationVO.getUserId());
			List userDetailList = this.sysService.findByExample(UserDetailEntity.class.getName(),userDetailEntity);
			if(userDetailList!=null&&userDetailList.size()!=0){
				UserDetailEntity userDetail = (UserDetailEntity) userDetailList.get(0);
				tutorVO.setImage(userDetail.getHeadImg());
				List jobList = new ArrayList<>();
				String jobSchool = userDetail.getJobSchool();
				if(!StringUtil.isEmpty(jobSchool)){
					if(jobSchool.contains("#")){
						String [] job = jobSchool.split("#");
						for(String j:job){
							jobList.add(j);
						}
					}else {
						jobList.add(jobSchool);
					}
				}

				tutorVO.setJobSchoolList(jobList);
				tutorVO.setName(userDetail.getName());
				tutorVO.setPosition(userDetail.getJobSchoolPosition());
				tutorVO.setSchoolEducation(userDetail.getSchoolEducation());
				tutorVO.setSchool(userDetail.getSchoolName());
			}else {
				List jobList = new ArrayList<>();
				List list = new ArrayList();
				list.add("");
				jobList.add(list);
				tutorVO.setJobSchoolList(jobList);
			}
			tutorVO.setIsCollention("未关注");
			if(user!=null){
				CollentionsEntity collentionEntity = new CollentionsEntity();
				collentionEntity.setOutId(authenticationVO.getId());
				collentionEntity.setUserId(user.getId());
				collentionEntity.setIsDelete(0);
				List collentions = this.sysService.findByExample(CollentionsEntity.class.getName(),collentionEntity);
				if(collentions != null&&collentions.size()>0){
					tutorVO.setIsCollention("已关注");
				}
			}
			tutorVOs.add(tutorVO);

		}

		mode.setResult(tutorVOs);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}

	//创客导师
	@RequestMapping("/ckList.do")
	@ResponseBody
	public ReplyDataMode ckList(AuthenticationSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		searchForm.setAuthenticationResult("14");
		ReplyDataMode replyDataMode  = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String, Object> orderMap = new HashMap<>();
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());

		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<DxsAuthenticationEntity> authentication = mode.getResult();

		List<TutorVO> tutorVOs = new ArrayList<TutorVO>();

		for (DxsAuthenticationEntity authenticationEntity:authentication) {
			AuthenticationVo authenticationVO = new AuthenticationVo();
			TutorVO tutorVO = new TutorVO();
			authenticationVO.copyEntity(authenticationEntity);
			tutorVO.setSkills(authenticationVO.getToturSkill());
			tutorVO.setId(authenticationVO.getId());
			UserDetailEntity userDetailEntity = new UserDetailEntity();
			userDetailEntity.setIsDelete(0);
			userDetailEntity.setUserId(authenticationVO.getUserId());
			List userDetailList = this.sysService.findByExample(UserDetailEntity.class.getName(),userDetailEntity);
			if(userDetailList!=null&&userDetailList.size()!=0){
				UserDetailEntity userDetail = (UserDetailEntity) userDetailList.get(0);
				tutorVO.setImage(userDetail.getHeadImg());
				List jobList = new ArrayList<>();
				String jobSchool = userDetail.getJobSchool();
				if(!StringUtil.isEmpty(jobSchool)){
					if(jobSchool.contains("#")){
						String [] job = jobSchool.split("#");
						for(String j:job){
							jobList.add(j);
						}
					}else {
						jobList.add(jobSchool);
					}
				}

				tutorVO.setJobSchoolList(jobList);
				tutorVO.setName(userDetail.getName());
				tutorVO.setPosition(userDetail.getJobSchoolPosition());
				tutorVO.setSchoolEducation(userDetail.getSchoolEducation());
				tutorVO.setSchool(userDetail.getSchoolName());
			}
			tutorVO.setIsCollention("未关注");
			if(user!=null){
				CollentionsEntity collentionEntity = new CollentionsEntity();
				collentionEntity.setOutId(authenticationVO.getId());
				collentionEntity.setUserId(user.getId());
				collentionEntity.setIsDelete(0);
				List collentions = this.sysService.findByExample(CollentionsEntity.class.getName(),collentionEntity);
				if(collentions != null&&collentions.size()>0){
					tutorVO.setIsCollention("已关注");
				}
			}
			tutorVOs.add(tutorVO);

		}

		mode.setResult(tutorVOs);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}


	//学习导师
	@RequestMapping("/studyList.do")
	@ResponseBody
	public ReplyDataMode studyList(AuthenticationSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		searchForm.setAuthenticationResult("17");
		ReplyDataMode replyDataMode  = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String, Object> orderMap = new HashMap<>();
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());

		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<DxsAuthenticationEntity> authentication = mode.getResult();

		List<TutorVO> tutorVOs = new ArrayList<TutorVO>();

		for (DxsAuthenticationEntity authenticationEntity:authentication) {
			AuthenticationVo authenticationVO = new AuthenticationVo();
			TutorVO tutorVO = new TutorVO();
			authenticationVO.copyEntity(authenticationEntity);
			tutorVO.setSkills(authenticationVO.getToturSkill());
			tutorVO.setId(authenticationVO.getId());
			UserDetailEntity userDetailEntity = new UserDetailEntity();
			userDetailEntity.setIsDelete(0);
			userDetailEntity.setUserId(authenticationVO.getUserId());
			List userDetailList = this.sysService.findByExample(UserDetailEntity.class.getName(),userDetailEntity);
			if(userDetailList!=null&&userDetailList.size()!=0){
				UserDetailEntity userDetail = (UserDetailEntity) userDetailList.get(0);
				tutorVO.setImage(userDetail.getHeadImg());
				List jobList = new ArrayList<>();
				String jobSchool = userDetail.getJobSchool();
				if(!StringUtil.isEmpty(jobSchool)){
					if(jobSchool.contains("#")){
						String [] job = jobSchool.split("#");
						for(String j:job){
							jobList.add(j);
						}
					}else {
						jobList.add(jobSchool);
					}
				}

				tutorVO.setJobSchoolList(jobList);
				tutorVO.setName(userDetail.getName());
				tutorVO.setPosition(userDetail.getJobSchoolPosition());
				tutorVO.setSchoolEducation(userDetail.getSchoolEducation());
				tutorVO.setSchool(userDetail.getSchoolName());
			}
			tutorVO.setIsCollention("未关注");
			if(user!=null){
				CollentionsEntity collentionEntity = new CollentionsEntity();
				collentionEntity.setOutId(authenticationVO.getId());
				collentionEntity.setUserId(user.getId());
				collentionEntity.setIsDelete(0);
				List collentions = this.sysService.findByExample(CollentionsEntity.class.getName(),collentionEntity);
				if(collentions != null&&collentions.size()>0){
					tutorVO.setIsCollention("已关注");
				}
			}
			tutorVOs.add(tutorVO);

		}

		mode.setResult(tutorVOs);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}



	//技能培训导师
	@RequestMapping("/skillList.do")
	@ResponseBody
	public ReplyDataMode skillList(AuthenticationSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		searchForm.setAuthenticationResult("20");
		ReplyDataMode replyDataMode  = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String, Object> orderMap = new HashMap<>();
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());

		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<DxsAuthenticationEntity> authentication = mode.getResult();

		List<TutorVO> tutorVOs = new ArrayList<TutorVO>();

		for (DxsAuthenticationEntity authenticationEntity:authentication) {
			AuthenticationVo authenticationVO = new AuthenticationVo();
			TutorVO tutorVO = new TutorVO();
			authenticationVO.copyEntity(authenticationEntity);
			tutorVO.setSkills(authenticationVO.getToturSkill());
			tutorVO.setId(authenticationVO.getId());
			UserDetailEntity userDetailEntity = new UserDetailEntity();
			userDetailEntity.setIsDelete(0);
			userDetailEntity.setUserId(authenticationVO.getUserId());
			List userDetailList = this.sysService.findByExample(UserDetailEntity.class.getName(),userDetailEntity);
			if(userDetailList!=null&&userDetailList.size()!=0){
				UserDetailEntity userDetail = (UserDetailEntity) userDetailList.get(0);
				tutorVO.setImage(userDetail.getHeadImg());
				List jobList = new ArrayList<>();
				String jobSchool = userDetail.getJobSchool();
				if(!StringUtil.isEmpty(jobSchool)){
					if(jobSchool.contains("#")){
						String [] job = jobSchool.split("#");
						for(String j:job){
							jobList.add(j);
						}
					}else {
						jobList.add(jobSchool);
					}
				}

				tutorVO.setJobSchoolList(jobList);
				tutorVO.setName(userDetail.getName());
				tutorVO.setPosition(userDetail.getJobSchoolPosition());
				tutorVO.setSchoolEducation(userDetail.getSchoolEducation());
				tutorVO.setSchool(userDetail.getSchoolName());
			}
			tutorVO.setIsCollention("未关注");
			if(user!=null){
				CollentionsEntity collentionEntity = new CollentionsEntity();
				collentionEntity.setOutId(authenticationVO.getId());
				collentionEntity.setUserId(user.getId());
				collentionEntity.setIsDelete(0);
				List collentions = this.sysService.findByExample(CollentionsEntity.class.getName(),collentionEntity);
				if(collentions != null&&collentions.size()>0){
					tutorVO.setIsCollention("已关注");
				}
			}
			tutorVOs.add(tutorVO);

		}

		mode.setResult(tutorVOs);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}


	//全部导师
	@RequestMapping("/allList.do")
	@ResponseBody
	public ReplyDataMode allList(AuthenticationSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode  = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();


		Map<String, Object> orderMap = new HashMap<>();
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		criteriaQuery.in("authenticationResult",new Object[]{"8","11","14","17","20"});
		criteriaQuery.add();

		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());

		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<DxsAuthenticationEntity> authentication = mode.getResult();

		List<TutorVO> tutorVOs = new ArrayList<TutorVO>();

		for (DxsAuthenticationEntity authenticationEntity:authentication) {
			AuthenticationVo authenticationVO = new AuthenticationVo();
			TutorVO tutorVO = new TutorVO();
			authenticationVO.copyEntity(authenticationEntity);
			tutorVO.setSkills(authenticationVO.getToturSkill());
			tutorVO.setId(authenticationVO.getId());
			UserDetailEntity userDetailEntity = new UserDetailEntity();
			userDetailEntity.setIsDelete(0);
			userDetailEntity.setUserId(authenticationVO.getUserId());
			List userDetailList = this.sysService.findByExample(UserDetailEntity.class.getName(),userDetailEntity);
			if(userDetailList!=null&&userDetailList.size()!=0){
				UserDetailEntity userDetail = (UserDetailEntity) userDetailList.get(0);
				tutorVO.setImage(userDetail.getHeadImg());
				List jobList = new ArrayList<>();
				String jobSchool = userDetail.getJobSchool();
				if(!StringUtil.isEmpty(jobSchool)){
					if(jobSchool.contains("#")){
						String [] job = jobSchool.split("#");
						for(String j:job){
							jobList.add(j);
						}
					}else {
						jobList.add(jobSchool);
					}
				}

				tutorVO.setJobSchoolList(jobList);
				tutorVO.setName(userDetail.getName());
				tutorVO.setPosition(userDetail.getJobSchoolPosition());
				tutorVO.setSchoolEducation(userDetail.getSchoolEducation());
				tutorVO.setSchool(userDetail.getSchoolName());
			}else {
				List jobList = new ArrayList<>();
				List list = new ArrayList();
				list.add("");
				jobList.add(list);
				tutorVO.setJobSchoolList(jobList);
			}
			tutorVO.setIsCollention("未关注");
			if(user!=null){
				CollentionsEntity collentionEntity = new CollentionsEntity();
				collentionEntity.setOutId(authenticationVO.getId());
				collentionEntity.setUserId(user.getId());
				collentionEntity.setIsDelete(0);
				List collentions = this.sysService.findByExample(CollentionsEntity.class.getName(),collentionEntity);
				if(collentions != null&&collentions.size()>0){
					tutorVO.setIsCollention("已关注");
				}
			}
			tutorVOs.add(tutorVO);

		}

		mode.setResult(tutorVOs);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}



	//查询导师详情
	@RequestMapping("/TutorById.do")
	@ResponseBody
	public ReplyDataMode TutorById(AuthenticationSearchForm searchForm, HttpServletRequest request){

		ReplyDataMode replyDataMode  = new ReplyDataMode();
		Map map = new HashMap();
		DxsAuthenticationEntity authenticationEntity = this.sysService.get(DxsAuthenticationEntity.class,searchForm.getId());
		AuthenticationVo authenticationVo = new AuthenticationVo();
		authenticationVo.copyEntity(authenticationEntity);
		map.put("authentication",authenticationVo);
		List<UserDetailEntity> list = this.sysService.findByProperty(UserDetailEntity.class,"userId",authenticationEntity.getUserId());
		if(list!=null&&list.size()!=0) {
			UserDetailEntity userDetailEntity = list.get(0);
			UserDetailVO userDetailVO = new UserDetailVO();
			userDetailVO.copyEntity(userDetailEntity);

			List jobList = new ArrayList<>();
			String jobSchool = userDetailVO.getJobSchool();
			if (!StringUtil.isEmpty(jobSchool)) {
				if (jobSchool.contains("#")) {
					String[] job = jobSchool.split("#");
					for (String j : job) {
						jobList.add(j);
					}
				} else {
					jobList.add(jobSchool);
				}
				userDetailVO.setJobSchoolList(jobList);
			}
			map.put("teacher", userDetailVO);
		}

		replyDataMode.setData(map);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
	//查询导师详情
	@RequestMapping("/TutorByUserId.do")
	@ResponseBody
	public ReplyDataMode TutorByUserId(AuthenticationSearchForm searchForm, HttpServletRequest request){

		ReplyDataMode replyDataMode  = new ReplyDataMode();
		Map map = new HashMap();
		DxsAuthenticationEntity authenticationEntity = this.sysService.findByProperty(DxsAuthenticationEntity.class,"userId",searchForm.getUserId()).get(0);
		AuthenticationVo authenticationVo = new AuthenticationVo();
		authenticationVo.copyEntity(authenticationEntity);
		map.put("authentication",authenticationVo);
		List<UserDetailEntity> list = this.sysService.findByProperty(UserDetailEntity.class,"userId",authenticationEntity.getUserId());
		if(list!=null&&list.size()!=0) {
			UserDetailEntity userDetailEntity = list.get(0);
			UserDetailVO userDetailVO = new UserDetailVO();
			userDetailVO.copyEntity(userDetailEntity);

			List jobList = new ArrayList<>();
			String jobSchool = userDetailVO.getJobSchool();
			if (!StringUtil.isEmpty(jobSchool)) {
				if (jobSchool.contains("#")) {
					String[] job = jobSchool.split("#");
					for (String j : job) {
						jobList.add(j);
					}
				} else {
					jobList.add(jobSchool);
				}
				userDetailVO.setJobSchoolList(jobList);
			}
			map.put("teacher", userDetailVO);
		}

		replyDataMode.setData(map);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
}

