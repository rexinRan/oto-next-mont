package com.buss.manager.controller;

import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;
import com.buss.employed.entity.EmployedEntity;
import com.buss.employed.trans.form.EmployedForm;
import com.buss.employmentrecord.entity.EmploymentRecordEntity;
import com.buss.interview.entity.InterviewEntity;
import com.buss.interview.trans.form.InterviewForm;
import com.buss.interviewassessment.entity.InterviewAssessmentEntity;
import com.buss.interviewassessment.trans.form.InterviewAssessmentForm;
import com.buss.leadassessment.entity.LeadAssessmentEntity;
import com.buss.manager.transfer.form.EmpAssessmentForm;
import com.buss.manager.transfer.form.JobResumeSearchForm;
import com.buss.manager.transfer.vo.EmpInterviewAssessmentVo;
import com.buss.manager.transfer.vo.JobResumeVO;
import com.buss.member.entity.GeneralUserEntity;
import com.buss.offer.entity.DxsOfferEntity;
import com.buss.resumeuser.entity.ResumeUserEntity;
import com.buss.resumeuser.trans.form.ResumeUserForm;
import com.buss.usercompancy.entity.UserCompancyEntity;
import com.buss.usercompancy.trans.form.UserCompancySearchForm;
import com.buss.usercompancy.trans.vo.UserCompancyVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.jweb.core.util.DateUtil;
import org.jweb.core.util.StringUtil;
import org.jweb.core.web.controller.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.util.*;

/***
 * 企业管理 模块
 */
@Controller
@RequestMapping("/m")
public class ManagerController extends BaseController {

	@Autowired
	private SysServiceI sysService;


	/**
	 企业资料 - 查询
	 */
	@RequestMapping("/empById.do")
	@ResponseBody
	public ReplyDataMode empById(UserCompancySearchForm searchForm, HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();

		// 登录下获取用户id
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
		if(user!=null){
			searchForm.setUserId(user.getId());
			CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

			List<UserCompancyEntity> userCompancys = this.sysService.list(criteriaQuery);
			List<UserCompancyVO> userCompancyVOs = new ArrayList<UserCompancyVO>();

			for (UserCompancyEntity userCompancy:userCompancys) {
				UserCompancyVO userCompancyVO = new UserCompancyVO();
				userCompancyVO.copyEntity(userCompancy);
				userCompancyVOs.add(userCompancyVO);
			}
			replyDataMode.setData(userCompancyVOs);
			replyDataMode.setStatusCode("200");
			replyDataMode.setSuccess(true);
		}else{
			replyDataMode.setStatusCode("用户未登录");
			replyDataMode.setSuccess(false);
		}
		return replyDataMode;
	}

	/**
	 * 企业资料 - 修改保存信息
	 *
	 * @param request
	 * @param reponse
	 * @return
	 */
	@RequestMapping("/empSaveMessage.do")
	@ResponseBody
	public ReplyDataMode empSaveMessage(HttpServletRequest request, HttpServletResponse reponse) {
		ReplyDataMode j = new ReplyDataMode();
		// 获取前台传入内容
		String compancyName = request.getParameter("compancyName"); //企业名称
		String compancyNum = request.getParameter("compancyNum");//规模
		String compancyType = request.getParameter("compancyType");//所属行业
		String contactTel = request.getParameter("contactTel");//联系电话
		String contactName = request.getParameter("contactName");//联系人
		String compancyAddress = request.getParameter("compancyAddress");//官网
		String compancyPositation = request.getParameter("compancyPositation");//公司所在地
		String compancyIntroduce = request.getParameter("compancyIntroduce");//企业介绍
		String email = request.getParameter("email"); //邮箱

		/*http://127.0.0.1:8080/dxs-server/m/empSaveMessage.do?compancyName=compancyName&email=abc@qq.com&compancyNum=HONGXIN&compancyType=&contactTel=&contactName=&compancyAddress=&compancyPositation=&compancyIntroduce=
		* */

		if (StringUtil.isEmpty(compancyName) || StringUtil.isEmpty(email)) {
			j.setStatusCode("信息填写不完整");
			j.setSuccess(false);
			return j;
		}

		Subject currentUser = SecurityUtils.getSubject();
		// 获取当前登录用户
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
		GeneralUserEntity userEntity = this.sysService.get(GeneralUserEntity.class, user.getId());
		if (userEntity != null) {
			userEntity.setEmail(email);
			userEntity.setCheckstatus(9);
			this.sysService.saveOrUpdate(userEntity);

			// 公司信息扩展表
			UserCompancyEntity userCompancys = this.sysService.findUniqueByProperty(UserCompancyEntity.class, "userEntity.id", user.getId());

			userCompancys.setCompancyName(compancyName);
			userCompancys.setCompancyNum(compancyNum);
			userCompancys.setCompancyType(compancyType);
			userCompancys.setContactTel(contactTel);
			userCompancys.setContactName(contactName);
			userCompancys.setCompancyAddress(compancyAddress);
			userCompancys.setCompancyPositation(compancyPositation);
			userCompancys.setCompancyIntroduce(compancyIntroduce);
			userCompancys.setUpdateTime(new Date());
			this.sysService.saveOrUpdate(userCompancys);

			// 保存成功
			j.setStatusCode("保存成功");
			j.setSuccess(true);
			return j;
		}

		j.setStatusCode("保存失败,请重试");
		j.setSuccess(false);
		return j;
	}


	/**
	 *	简历管理 - 职位统计的简历数 职位列表
	 */
	@RequestMapping("/empJob.do")
	@ResponseBody
	public ReplyDataMode empJob(HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();
		String feedback = "";

		// 登录下获取用户id
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
		if(user!=null){
			// 获取前台传入内容
			String eq = "";
			String isDelete = request.getParameter("isDelete"); //招聘职位
			if (!StringUtil.isEmpty(isDelete)) {
				eq = " and e.is_delete="+isDelete;
			}

			String sql = "select emoloyed_id, employed_name ,publish_time ,COUNT(result) as num, education, employed_type, employed_num, employed_position, u.user_id " +
					" from dxs_resume_user u,dxs_employed e where u.emoloyed_id = e.id " +
				" and e.user_id='"+user.getId()+"' "+eq+" GROUP BY emoloyed_id";
			List<Map> uaList = this.sysService.findListbySql(sql);

			List<Map<String, Object>>  aList = new ArrayList();
			if(!uaList.isEmpty()) for (Object obj : uaList) {
				Map map = new HashMap();
				Object[] u = (Object[]) obj;
				String emoloyed_id = u[0].toString(); //职位id
				String num = u[3].toString(); //应聘简历数
				String user_id = null; //投递人id,如果等于null，则不算入应聘数
				String education = "";
				String employedType = "";
				String employedNum = "";
				String employedPosition = "";

				if(u[8]!=null){
					user_id = u[8].toString();
				}
//				System.out.println(user_id);

				map.put("emoloyedId",emoloyed_id);
				map.put("employedName",u[1].toString()); //职业名称
				map.put("publishTime",u[2].toString()); //发布时间
				if("1".equals(num)&&user_id==null){
					num = "0";
				}
				map.put("num",num); //应聘简历数

				if(u[4]!=null){
					education = u[4].toString();
				}
				map.put("education",education); //学历

				if(u[5]!=null){
					employedType = u[5].toString();
				}
				map.put("employedType",employedType); //岗位类型

				if(u[6]!=null){
					employedNum = u[6].toString();
				}
				map.put("employedNum",employedNum); //招聘岗位数目

				if(u[7]!=null){
					employedPosition = u[7].toString();
				}
				map.put("employedPosition",employedPosition); //工作地点


//				System.out.println(num+" | " +emoloyed_id);
				if(!"0".equals(num)){
					// 查反馈率
					List<String[]> ubList = getUbList(user.getId(), emoloyed_id);
					if (!ubList.isEmpty()) for (Object ub : ubList) {
						feedback = ub.toString();
					}
				}else{
					feedback = "0.0000";
				}
				map.put("feedback",feedback);
				map.put("isDelete",isDelete);
				aList.add(map);
			}

			replyDataMode.setData(aList);
			replyDataMode.setStatusCode("200");
			replyDataMode.setSuccess(true);
		}else{
			replyDataMode.setStatusCode("用户未登录");
			replyDataMode.setSuccess(false);
		}
		return replyDataMode;
	}
	/**
	 * 查反馈率 =  result >= 15 / 总的
	 * @param userId
	 * @param emoloyedId
     * @return
     */
	public List<String[]>  getUbList(String userId,String emoloyedId){
		String sql = "SELECT ifnull((select COUNT(result) from dxs_resume_user u,dxs_employed e where u.emoloyed_id = e.id " +
				" and e.user_id='"+userId+"' and u.emoloyed_id ='"+emoloyedId+"' and result >= 15 ) / (select COUNT(result) from dxs_resume_user u,dxs_employed e where u.emoloyed_id = e.id " +
				" and e.user_id='"+userId+"' and u.emoloyed_id ='"+emoloyedId+"' ) ,0) as rate";
		List<String[]> ubList = this.sysService.findListbySql(sql);
		return ubList;
	}

	/**
	 * 简历管理 - 发布职位
	 *
	 * @param request
	 * @param reponse
	 * @return
	 */
	@RequestMapping("/empSaveJob.do")
	@ResponseBody
	public ReplyDataMode empSaveJob(HttpServletRequest request, HttpServletResponse reponse) {
//		System.out.println("#### -> empSaveJob.do ");
		ReplyDataMode j = new ReplyDataMode();
		// 判断用户是否登录
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
		if(user!=null){
			// 获取前台传入内容
			String employedName = request.getParameter("employedName"); //招聘职位
			String compancyName = request.getParameter("compancyName"); //公司名称
			String compancyAddress = request.getParameter("compancyAddress");//公司网址
			String compancyIntroduce = request.getParameter("compancyIntroduce");//公司介绍(UserCompancy)
			String compancyType = request.getParameter("compancyType");//所属领域(UserCompancy)
			String compancyNum = request.getParameter("compancyNum");//公司规模(UserCompancy)
			String compancyPositation = request.getParameter("compancyPositation");//公司地址(UserCompancy)
			String employedPosition = request.getParameter("employedPosition");//工作地址
			String employedSalary = request.getParameter("employedSalary");//月薪
			String employedType = request.getParameter("employedType");//职位类型
			String experience = request.getParameter("experience");//工作经验
			String education = request.getParameter("education");//学历
			String employedResponsibilities = request.getParameter("employedResponsibilities");//岗位职责
			String employedRequirements = request.getParameter("employedRequirements");//任职要求
			String fuli = request.getParameter("fuli");//福利待遇
			String contactName = request.getParameter("contactName");//联系人
			String contactPhone = request.getParameter("contactPhone");//手机
			String contactTel = request.getParameter("contactTel");//电话
			String contactMail = request.getParameter("contactMail"); //邮箱
/*
http://127.0.0.1:8080/dxs-server/m/empSaveJob.do?employedName=%E8%AD%A6%E5%AF%9F&compancyName=&compancyAddress=&compancyIntroduce=&compancyType=&compancyNum=HONGXIN&compancyPositation=&employedPosition=&employedSalary=&employedType=&experience=&education=&employedResponsibilities=&employedRequirements=&fuli=&contactName=&contactPhone=&contactTel=&contactMail=
* */
			if (StringUtil.isEmpty(employedName) || StringUtil.isEmpty(compancyName)) {
				j.setStatusCode("信息填写不完整");
				j.setSuccess(false);
				return j;
			}
			// 职位表
			EmployedEntity empJob = new EmployedEntity();
			empJob.setEmployedCatalogId("40");
			empJob.setUserId(user.getId());
			empJob.setEmployedName(employedName);
			empJob.setEmployedPosition(employedPosition);
			empJob.setEmployedSalary(employedSalary);
//			empJob.setEmployedNum();
			empJob.setEmployedResponsibilities(employedResponsibilities);
			empJob.setEmployedRequirements(employedRequirements);
			empJob.setEmployedType(employedType);
			empJob.setExperience(experience);
			empJob.setEducation(education);
			empJob.setCompancyName(compancyName);
			empJob.setCompancyAddress(compancyAddress);
			empJob.setContactName(contactName);
			empJob.setContactTel(contactTel);
			empJob.setContactPhone(contactPhone);
			empJob.setContactMail(contactMail);
			empJob.setPublishTime(new Date());
			empJob.setCreateTime(new Date());
			empJob.setIsDelete(0);

//			this.sysService.saveOrUpdate(empJob);
			Object id = this.sysService.save(empJob);

			// 职位 简历用户关联表表
			ResumeUserEntity resumeUser = new ResumeUserEntity();
			resumeUser.setEmoloyedId(id.toString());
			resumeUser.setCreateTime(new Date());
			resumeUser.setIsDelete(0);
//			resumeUser.setResult("0");
			resumeUser.setResult(0);
			this.sysService.saveOrUpdate(resumeUser);

			// 保存成功
			j.setStatusCode("保存成功");
			j.setSuccess(true);
			return j;
		}

		j.setStatusCode("保存失败,请重试");
		j.setSuccess(false);
		return j;
	}

	/**
	 * 简历管理 - 暂停发布(删除)
	 */
	@RequestMapping("/empResumeToDelete.do")
	@ResponseBody
	public ReplyDataMode empResumeToDelete(HttpServletRequest request, HttpServletResponse reponse) {
		ReplyDataMode j = new ReplyDataMode();
		// 获取前台传入内容
		String employedId = request.getParameter("employedId"); //职位id

		if (StringUtil.isEmpty(employedId)) {
			j.setStatusCode("信息填写不完整");
			j.setSuccess(false);
			return j;
		}

		EmployedEntity empJob = new EmployedEntity();
		empJob = this.sysService.get(EmployedEntity.class, employedId);
		if (empJob != null) {
			empJob.setIsDelete(1);
			this.sysService.saveOrUpdate(empJob);
			// 保存成功
			j.setStatusCode("保存成功");
			j.setSuccess(true);
			return j;
		}

		j.setStatusCode("保存失败,请重试");
		j.setSuccess(false);
		return j;
	}

	/**
	 *	简历管理 - 简历搜索 简历列表
	 */
	@RequestMapping("/empJobToResume.do")
	@ResponseBody
	public ReplyDataMode empJobToResume(JobResumeSearchForm searchForm, HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();
		// 分页模型设置
		PageMode mode = new PageMode();
		int total = 0;
		int pageNo = 0;
		int pageSize = 0;

		// 登录下获取用户id
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
		if(user!=null){
			// 获取前台传入内容
			String emoloyedId = searchForm.getEmoloyedId();
			String rtype = searchForm.getRtype();
			String result = searchForm.getResult();
			String jobType = searchForm.getJobType();
			String schoolEducation = searchForm.getSchoolEducation();
			String sex = searchForm.getSex();
			String targetJob = searchForm.getTargetJob();
			String employedName = searchForm.getEmployedName();

			StringBuffer sb_and = new StringBuffer();
			if (!StringUtil.isEmpty(emoloyedId)) { /* 职位ID */
				sb_and.append(" and emoloyed_id = '"+emoloyedId+"'");
			}
			if (!StringUtil.isEmpty(rtype)) { /* 投递类型（1主动投递，2老师推荐） */
				sb_and.append(" and rtype = "+rtype);
			}
			if (!StringUtil.isEmpty(result)) { /* 0-未操作 5-查看简历 15-标记为不合适 20-发面试邀请 30-已发offer */
				sb_and.append(" and result = "+result);
			}
			if (!StringUtil.isEmpty(jobType)) { /* 工作类型 */
				sb_and.append(" and job_type = '"+jobType+"'");
			}
			if (!StringUtil.isEmpty(schoolEducation)) { /* 学历 */
				sb_and.append(" and school_Education = '"+schoolEducation+"'");
			}
			if (!StringUtil.isEmpty(sex)) { /* 性别 */
				sb_and.append(" and r.sex = '"+sex+"'");
			}
			if (!StringUtil.isEmpty(targetJob)) {  /**求职岗位 (简历搜索 查询条件-模糊查询)*/
				sb_and.append(" and r.target_job like '%"+targetJob+"%'");
			}
			if (!StringUtil.isEmpty(employedName)) { /* 职位名称 (简历搜索 查询条件-模糊查询)*/
				sb_and.append(" and e.employed_name like '%"+employedName+"%'");
			}


			StringBuffer sb_limit = new StringBuffer();
			if (!StringUtil.isEmpty(searchForm.getPageNo()) && !StringUtil.isEmpty(searchForm.getPageSize())) {
				pageNo = Integer.parseInt(searchForm.getPageNo());
				pageSize = Integer.parseInt(searchForm.getPageSize());
				sb_limit.append(" LIMIT " + (pageNo-1)*pageSize +","+ pageSize );
			}

			String sql = "SELECT u.id, u.user_id, u.user_name, u.rtype, u.result, u.send_time, r.`name`, r.target_job, r.sex, r.school_Education, r.job_type, r.school_name " +
					"from dxs_resume_user u, dxs_employed e, dxs_resume r where u.emoloyed_id=e.id and r.id=u.resume_id " +
					sb_and.toString() +" and u.user_id is not NULL " +
					" and e.user_id='"+user.getId()+"' "+ sb_limit.toString();
			String sql_count = "SELECT u.id " +
					"from dxs_resume_user u, dxs_employed e, dxs_resume r where u.emoloyed_id=e.id and r.id=u.resume_id " +
					sb_and.toString() +" and u.user_id is not NULL " +
					" and e.user_id='"+user.getId()+"' ";

			List<Map> uaList = this.sysService.findListbySql(sql);
			List<Map> uaList_count = this.sysService.findListbySql(sql_count);

			List<JobResumeVO> ruVOs = new ArrayList<JobResumeVO>();
			if(!uaList.isEmpty()) for (Object obj : uaList) {
				JobResumeVO ruVo = new JobResumeVO();

				Object[] u = (Object[]) obj;
				String field = "";
				for(int i=0;i<u.length;i++){
					if(u[i]!=null){
						field = u[i].toString();
					}else {
						field = "";
					}

					if(i==0){
						ruVo.setId(field);
					}else if(i==1){
						ruVo.setUserId(field);
					}else if(i==2){
						ruVo.setUserName(field);
					}else if(i==3){
						ruVo.setResult(field);
					}else if(i==4){
						ruVo.setType(field);
					}else if(i==5){
						ruVo.setSendTime(field);
						// 加日期转换
						try {
							Date date=DateUtil.date_sdf.parse(field);
							String formatDate = DateUtil.date_sdf.format(date);
							ruVo.setFormatDate(formatDate);
						} catch (ParseException e) {
							e.printStackTrace();
						}
					}else if(i==6){
						ruVo.setName(field);
					}else if(i==7){
						ruVo.setTargetJob(field);
					}else if(i==8){
						ruVo.setSex(field);
					}else if(i==9){
						ruVo.setSchoolEducation(field);
					}else if(i==10){
						ruVo.setJobType(field);
					}else if(i==11){
						ruVo.setSchoolName(field);
					}
				}
				ruVOs.add(ruVo);

				mode.setTotal(Integer.parseInt(uaList_count.get(0).toString()));
			}

			final int allCounts;
			if (mode.getTotal() != 0) {
				allCounts = mode.getTotal();
			} else {
				allCounts = 0;
			}
			int pageCount = 0;
			if (pageNo!=0 && pageSize!=0) {
				pageCount = allCounts/pageSize + 1;
				int start = (pageNo - 1) * pageSize;
			}
			mode.setPageCount(pageCount);
			mode.setPageNo(pageNo);
			mode.setPageSize(pageSize);
			mode.setResult(ruVOs);

			replyDataMode.setData(mode);
			replyDataMode.setStatusCode("200");
			replyDataMode.setSuccess(true);
		}else{
			replyDataMode.setStatusCode("用户未登录");
			replyDataMode.setSuccess(false);
		}

		return replyDataMode;
	}

	/**
	 *	简历管理 - 简历搜索 简历列表(已废弃)
	 */
/*
	@RequestMapping("/empJobToResumePage.do")
	@ResponseBody
	public ReplyDataMode empJobToResumePage(JobResumeSearchForm searchForm, HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();
		// 登录下获取用户id
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
		if(user!=null){
			searchForm.setUserIdEmp(user.getId()); // 设置只能查看当前登陆企业，发布职位的投递简历
			// 如果Entity里的属性是Integer,需判断是否为空，否则会带上WHERE=0处理
			if(StringUtil.isEmpty(searchForm.getIsDelete())){
				searchForm.setIsDelete(null);
			}
			if(StringUtil.isEmpty(searchForm.getResult())){
				searchForm.setResult(null);
			}
			if(StringUtil.isEmpty(searchForm.getRtype())){
				searchForm.setRtype(null);
			}

			CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

			Map<String, Object> orderMap = new HashMap<>();
			orderMap.put("createTime", "desc");
			orderMap.put("updateTime", "desc");
			criteriaQuery.setOrder(orderMap);

			int pageNo = Integer.parseInt(searchForm.getPageNo());
			int pageSize = Integer.parseInt(searchForm.getPageSize());

			PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
			List<ResumeUserEntity> ruList = mode.getResult();
			List<JobResumeVO> ruVOs = new ArrayList<JobResumeVO>();

			for (ResumeUserEntity ru : ruList) {
				JobResumeVO ruVo = new JobResumeVO();
				ruVo.copyEntity(ru);
				if(!StringUtil.isEmpty(ruVo.getSendTime())){
					try {
						Date date=DateUtil.date_sdf.parse(ruVo.getSendTime());
						String formatDate = DateUtil.date_sdf.format(date);
						ruVo.setFormatDate(formatDate);
					} catch (ParseException e) {
						e.printStackTrace();
					}
				}

				ruVOs.add(ruVo);
			}
			mode.setResult(ruVOs);
			replyDataMode.setData(mode);
			replyDataMode.setStatusCode("200");
			replyDataMode.setSuccess(true);
		}else{
			replyDataMode.setStatusCode("用户未登录");
			replyDataMode.setSuccess(false);
		}

		return replyDataMode;
	}
*/

	/**
	 * 发面试邀请  or  标为不合适
		 0 未操作
		 5 查看简历
		 15 标记为不合适
		 20 发面试邀请
	  	 30 已发offer
	 */
	@RequestMapping("/empResumeToResult.do")
	@ResponseBody
	public ReplyDataMode empResumeToResult(HttpServletRequest request) {
		ReplyDataMode j = new ReplyDataMode();
		// 获取前台传入内容
		String ruId = request.getParameter("ruId"); //简历id
		String opt = request.getParameter("opt"); //操作

		if (StringUtil.isEmpty(ruId) || StringUtil.isEmpty(opt)) {
			j.setStatusCode("信息填写不完整");
			j.setSuccess(false);
			return j;
		}

		ResumeUserEntity ru = new ResumeUserEntity();
		ru = this.sysService.get(ResumeUserEntity.class, ruId);
		if (ru != null) {
			ru.setResult(Integer.parseInt(opt));
			ru.setUpdateTime(new Date());
			this.sysService.saveOrUpdate(ru);
			// 保存成功
			j.setStatusCode("保存成功");
			j.setSuccess(true);
			return j;
		}

		j.setStatusCode("保存失败,请重试");
		j.setSuccess(false);
		return j;
	}

	/**
	 * 简历管理 - 新增offer
	 */
	@RequestMapping("/empInterviewAdd.do")
	@ResponseBody
	public ReplyDataMode empInterviewAdd(HttpServletRequest request, HttpServletResponse reponse) {
		ReplyDataMode j = new ReplyDataMode();
		// 登录下获取用户id
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
		if(user!=null){

			// 获取前台传入内容（step1）
			String ruId = request.getParameter("ruId"); //简历id
			String opt = request.getParameter("opt"); //操作
			if (StringUtil.isEmpty(ruId) || StringUtil.isEmpty(opt)) {
				j.setStatusCode("信息填写不完整");
				j.setSuccess(false);
				return j;
			}

			// 获取前台传入内容（step2）
			String toUserId = request.getParameter("toUserId"); //被选中用户id
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			if (StringUtil.isEmpty(title)||StringUtil.isEmpty(content)||StringUtil.isEmpty(toUserId)) {
				j.setStatusCode("信息填写不完整");
				j.setSuccess(false);
				return j;
			}

			/* step1 - 修改用户简历投送result */
			ResumeUserEntity ru = new ResumeUserEntity();
			ru = this.sysService.get(ResumeUserEntity.class, ruId);
			if (ru != null) {
				ru.setResult(Integer.parseInt(opt));
				ru.setUpdateTime(new Date());
				this.sysService.saveOrUpdate(ru);
				// 保存成功
				j.setStatusCode("保存成功");
				j.setSuccess(true);
				return j;
			}

			/* step2 - 发送给用户（学生）面试邀请函 */
			InterviewEntity entity = new InterviewEntity();
			entity.setResumeUserId(ruId);
			entity.setTitle(title);
			entity.setContent(content);
			entity.setResult(0);
			entity.setIsDelete(0);
			entity.setCreateTime(new Date());
			this.sysService.saveOrUpdate(entity);
			// 保存成功
			j.setStatusCode("保存成功");
			j.setSuccess(true);
		}else{
			j.setStatusCode("用户未登录");
			j.setSuccess(false);
		}
		return j;
	}



	/**
	 * 简历管理 - 员工入职
	 */
	@RequestMapping("/empAssessmentCreate.do")
	@ResponseBody
	public ReplyDataMode empAssessmentCreate(HttpServletRequest request) {
		ReplyDataMode j = new ReplyDataMode();
		// 登录下获取用户id
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
		if(user!=null){
			// 获取前台传入内容
			String toUserId = request.getParameter("toUserId"); //被选中用户id
			String employedId = request.getParameter("employedId"); //职位id

			if (StringUtil.isEmpty(toUserId) ||StringUtil.isEmpty(employedId)) {
				j.setStatusCode("信息填写不完整");
				j.setSuccess(false);
				return j;
			}
			// 我的职业动态 插入一条数据o
			EmploymentRecordEntity er = new EmploymentRecordEntity();
			er.setCompanyUserId(user.getId());/**企业ID*/
			er.setWorkUserId(toUserId);/**职工ID*/
			er.setCompanyNmae(user.getEmpname());/**公司名称*/

			EmployedEntity empJob = new EmployedEntity();
			empJob = this.sysService.get(EmployedEntity.class, employedId);
			if (empJob != null) {
				er.setPosition(empJob.getEmployedName());/**职位*/
			}
			er.setWorkStart(new Date().toString());
			er.setCreateTime(new Date());
			er.setIsDelete(0);
			// 保存
			Object employmentRecordId = this.sysService.save(er);

			// 入职员工评论表 插入一条空评论数据
			LeadAssessmentEntity la = new LeadAssessmentEntity();
			la.setFromUserId(user.getId()); //评价用户ID
			la.setEmploymentRecordId(employmentRecordId.toString()); // 待确认字段
			la.setToUserId(toUserId); //被评价用户id
			la.setEmployedId(employedId); // 职位id
			la.setLeadAssessment(null);
			la.setPublishTime(new Date().toString());
			la.setCreateTime(new Date());
			la.setIsDelete(0);
			// 保存
			this.sysService.saveOrUpdate(la);

			j.setStatusCode("保存成功");
			j.setSuccess(true);
		}else{
			j.setStatusCode("用户未登录");
			j.setSuccess(false);
		}
		return j;
	}

	/**
	 * 简历管理 - 新增offer
	 */
	@RequestMapping("/empOfferAdd.do")
	@ResponseBody
	public ReplyDataMode empOfferAdd(HttpServletRequest request, HttpServletResponse reponse) {
		ReplyDataMode j = new ReplyDataMode();
		// 登录下获取用户id
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
		if(user!=null){

			// 获取前台传入内容（step1）
			String ruId = request.getParameter("ruId"); //简历id
			String opt = request.getParameter("opt"); //操作
			if (StringUtil.isEmpty(ruId) || StringUtil.isEmpty(opt)) {
				j.setStatusCode("信息填写不完整");
				j.setSuccess(false);
				return j;
			}

			String toUserId = request.getParameter("toUserId"); //被选中用户id
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			if (StringUtil.isEmpty(title)||StringUtil.isEmpty(content)||StringUtil.isEmpty(toUserId)) {
				j.setStatusCode("信息填写不完整");
				j.setSuccess(false);
				return j;
			}

			/* step1 - 修改用户简历投送result */
			ResumeUserEntity ru = new ResumeUserEntity();
			ru = this.sysService.get(ResumeUserEntity.class, ruId);
			if (ru != null) {
				ru.setResult(Integer.parseInt(opt));
				ru.setUpdateTime(new Date());
				this.sysService.saveOrUpdate(ru);
				// 保存成功
				j.setStatusCode("保存成功");
				j.setSuccess(true);
				return j;
			}

			/* step2 - 发送给用户（学生）offer */
			DxsOfferEntity offer = new DxsOfferEntity();
			offer.setUserId(user.getId());
			offer.setInterviewId(toUserId);
			offer.setTitle(title);
			offer.setContent(content);
			offer.setResult(0);
			offer.setCreateTime(new Date());
			offer.setIsDelete(0);
			this.sysService.saveOrUpdate(offer);
			// 保存成功
			j.setStatusCode("保存成功");
			j.setSuccess(true);
		}else{
			j.setStatusCode("用户未登录");
			j.setSuccess(false);
		}
		return j;
	}


	/*************************************************************************************************/
	/**
	 *	入职员工点评 - 列表页（列出所有入职人员）*带分页
	 */
	@RequestMapping("/empAssessmentListPage.do")
	@ResponseBody
	public ReplyDataMode empAssessmentListPage(EmpAssessmentForm searchForm, HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();
		// 登录下获取用户id
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
		if(user!=null){
			searchForm.setFromUserId(user.getId());
			// 如果Entity里的属性是Integer,需判断是否为空，否则会带上WHERE=0处理
			if(StringUtil.isEmpty(searchForm.getIsDelete())){
				searchForm.setIsDelete(null);
			}

			CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

			Map<String, Object> orderMap = new HashMap<>();
			orderMap.put("createTime", "desc");
			orderMap.put("updateTime", "desc");
			criteriaQuery.setOrder(orderMap);

			int pageNo = Integer.parseInt(searchForm.getPageNo());
			int pageSize = Integer.parseInt(searchForm.getPageSize());

			PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
//			List<ResumeUserEntity> ruList = mode.getResult();
//			List<JobResumeVO> ruVOs = new ArrayList<JobResumeVO>();
//
//			for (ResumeUserEntity ru : ruList) {
//				JobResumeVO ruVo = new JobResumeVO();
//				ruVo.copyEntity(ru);
//				if(!StringUtil.isEmpty(ruVo.getSendTime())){
//					try {
//						Date date=DateUtil.date_sdf.parse(ruVo.getSendTime());
//						String formatDate = DateUtil.date_sdf.format(date);
//						ruVo.setFormatDate(formatDate);
//					} catch (ParseException e) {
//						e.printStackTrace();
//					}
//				}
//				ruVOs.add(ruVo);
//			}
//			mode.setResult(ruVOs);

			replyDataMode.setData(mode);
			replyDataMode.setStatusCode("200");
			replyDataMode.setSuccess(true);
		}else{
			replyDataMode.setStatusCode("用户未登录");
			replyDataMode.setSuccess(false);
		}

		return replyDataMode;
	}

	/**
	 *  入职员工点评 - 列表页（列出所有入职人员）*带分页 纯SQL 手动组装分页
	 */
	@RequestMapping("/empAssessmentList.do")
	@ResponseBody
	public ReplyDataMode empAssessmentList(EmpAssessmentForm searchForm,HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();

		// 登录下获取用户id
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
		if(user!=null){
			searchForm.setFromUserId(user.getId());
			// 如果Entity里的属性是Integer,需判断是否为空，否则会带上WHERE=0处理
			StringBuffer sb_and = new StringBuffer();
			if(StringUtil.isEmpty(searchForm.getIsDelete())){
				sb_and.append(" and a.is_delete="+ 0);
			}else{
				sb_and.append(" and a.is_delete="+ searchForm.getIsDelete());
			}
			int pageNo = 0;
			int pageSize = 0;
			StringBuffer sb_limit = new StringBuffer();
			if (!StringUtil.isEmpty(searchForm.getPageNo()) && !StringUtil.isEmpty(searchForm.getPageSize())) {
				pageNo = Integer.parseInt(searchForm.getPageNo());
				pageSize = Integer.parseInt(searchForm.getPageSize());
				sb_limit.append(" LIMIT " + (pageNo-1)*pageSize +","+ pageSize );
			}
			/* 分页 */
			PageMode mode = new PageMode();

			String sql = "select a.id,a.to_user_id,a.lead_assessment,a.publish_time,a.create_time, u.realname, e.id as employed_id,e.employed_name" +
					" from dxs_lead_assessment a, dxs_user u, dxs_employed e where a.to_user_id=u.id and a.employed_id=e.id "
					+ sb_and.toString()
					+" and from_user_id='"+searchForm.getFromUserId()+"' GROUP BY to_user_id "
					+ sb_limit.toString();
			String sql_count = "select count(*)" +
					" from dxs_lead_assessment a, dxs_user u, dxs_employed e where a.to_user_id=u.id and a.employed_id=e.id "
					+ sb_and.toString()
					+" and from_user_id='"+searchForm.getFromUserId()+"' GROUP BY to_user_id ";
			List<Map> uaList = this.sysService.findListbySql(sql);
			List<Map> uaList_count = this.sysService.findListbySql(sql_count);

			List<Map<String, Object>> aList = new ArrayList();
			if(!uaList.isEmpty()) for (Object obj : uaList) {
				Map map = new HashMap();
				Object[] u = (Object[]) obj;
				String field = "";
				for(int i=0;i<u.length;i++){
					if(u[i]!=null){
						field = u[i].toString();
					}else {
						field = "";
					}
					map.put("field"+i,field);
				}
				aList.add(map);
				mode.setTotal(Integer.parseInt(uaList_count.get(0).toString()));
			}

			final int allCounts;
			if (mode.getTotal() != 0) {
				allCounts = mode.getTotal();
			} else {
				allCounts = 0;
			}
			int pageCount = 0;
			if (pageNo!=0 && pageSize!=0) {
				pageCount = allCounts/pageSize + 1;
				int start = (pageNo - 1) * pageSize;
			}
			mode.setPageCount(pageCount);
			mode.setPageNo(pageNo);
			mode.setPageSize(pageSize);
			mode.setResult(aList);

			replyDataMode.setData(mode);
			replyDataMode.setStatusCode("200");
			replyDataMode.setSuccess(true);
		}else{
			replyDataMode.setStatusCode("用户未登录");
			replyDataMode.setSuccess(false);
		}
		return replyDataMode;
	}
	/**
	 * 入职员工点评 - 新增点评
	 */
	@RequestMapping("/empAssessmentAdd.do")
	@ResponseBody
	public ReplyDataMode empAssessmentAdd(HttpServletRequest request) {
		ReplyDataMode j = new ReplyDataMode();
		// 登录下获取用户id
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
		if(user!=null){
			// 获取前台传入内容
			String toUserId = request.getParameter("toUserId"); //被选中用户id
			String assessment = request.getParameter("assessment"); //评价内容
			String employedId = request.getParameter("employedId"); //职位id

			if (StringUtil.isEmpty(toUserId)||StringUtil.isEmpty(assessment)||StringUtil.isEmpty(employedId)) {
				j.setStatusCode("信息填写不完整");
				j.setSuccess(false);
				return j;
			}

			LeadAssessmentEntity la = new LeadAssessmentEntity();
			la.setFromUserId(user.getId()); //评价用户ID
			la.setEmploymentRecordId(null); // 待确认字段
			la.setToUserId(toUserId); //被评价用户id
			la.setLeadAssessment(assessment); //评价内容
			la.setEmployedId(employedId); //职位ID

			la.setPublishTime(new Date().toString());
			la.setCreateTime(new Date());
			la.setIsDelete(0);

			this.sysService.saveOrUpdate(la);
			// 保存成功
			j.setStatusCode("保存成功");
			j.setSuccess(true);
		}else{
			j.setStatusCode("用户未登录");
			j.setSuccess(false);
		}
		return j;
	}
	/**
	 * 入职员工点评 - 离职
	 */
	@RequestMapping("/empAssessmentDel.do")
	@ResponseBody
	public ReplyDataMode empAssessmentDel(HttpServletRequest request) {
		ReplyDataMode j = new ReplyDataMode();
		// 登录下获取用户id
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
		if(user!=null){
			// 获取前台传入内容
			String toUserId = request.getParameter("toUserId"); //入职员工点评id

			if (StringUtil.isEmpty(toUserId)) {
				j.setStatusCode("信息填写不完整");
				j.setSuccess(false);
				return j;
			}

//			LeadAssessmentEntity la = new LeadAssessmentEntity();
//			la =  this.sysService.get(LeadAssessmentEntity.class, id);
			List<LeadAssessmentEntity> lsList =  this.sysService.findByProperty(LeadAssessmentEntity.class, "toUserId",toUserId);
			if (lsList != null) {
				for(LeadAssessmentEntity la:lsList){
					la.setIsDelete(1);
					la.setUpdateTime(new Date());
					this.sysService.saveOrUpdate(la);
					// 保存成功
					j.setStatusCode("保存成功");
					j.setSuccess(true);
					return j;
				}
			}
			else{
				j.setStatusCode("保存失败,请重试");
				j.setSuccess(false);
			}
		}else{
			j.setStatusCode("用户未登录");
			j.setSuccess(false);
		}
		return j;
	}
	/**
	 * 入职员工点评 - 查看所有点评
	 */
	@RequestMapping("/empAssessmentListUserAll.do")
	@ResponseBody
	public ReplyDataMode empAssessmentListUserAll(HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();

		// 登录下获取用户id
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
		if(user!=null){
			// 获取前台传入内容
			String toUserId = request.getParameter("toUserId"); //被选中用户id
			if (StringUtil.isEmpty(toUserId)) {
				replyDataMode.setStatusCode("信息填写不完整");
				replyDataMode.setSuccess(false);
				return replyDataMode;
			}

			String sql = "select a.id,a.to_user_id,realname,employed_name,lead_assessment,a.publish_time,a.create_time " +
					" from dxs_lead_assessment a, dxs_user u, dxs_employed e where a.to_user_id=u.id and a.employed_id=e.id " +
					" and a.is_delete=0 and to_user_id='"+toUserId+"' and from_user_id='"+user.getId()+"'";
			List<Map> uaList = this.sysService.findListbySql(sql);

			List<Map<String, Object>> aList = new ArrayList();
			if(!uaList.isEmpty()) for (Object obj : uaList) {
				Map map = new HashMap();
				Object[] u = (Object[]) obj;
				String field = "";
				for(int i=0;i<u.length;i++){
					if(u[i]!=null){
						field = u[i].toString();
					}else {
						field = "";
					}
					map.put("field"+i,field);
				}
				aList.add(map);
			}

			replyDataMode.setData(aList);
			replyDataMode.setStatusCode("200");
			replyDataMode.setSuccess(true);
		}else{
			replyDataMode.setStatusCode("用户未登录");
			replyDataMode.setSuccess(false);
		}
		return replyDataMode;
	}

	/**
	 * 企业形象 - 离职员工评价
	 */
	@RequestMapping("/empAssessmentListToUser.do")
	@ResponseBody
	public ReplyDataMode empAssessmentListToUser(EmployedForm searchForm, HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();
		// 存放多个评价
		List<EmpInterviewAssessmentVo> interviewAssessmentVos = new ArrayList<EmpInterviewAssessmentVo>();
		// 分页模型设置
		PageMode mode = new PageMode();
		int total = 0;
		int pageNo = 0;
		int pageSize = 0;
		if (!StringUtil.isEmpty(searchForm.getPageNo()) && !StringUtil.isEmpty(searchForm.getPageSize())) {
			pageNo = Integer.parseInt(searchForm.getPageNo());
			pageSize = Integer.parseInt(searchForm.getPageSize());
		}
		// 登录下获取用户id
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
		if(user!=null){
			/*
			String sql = "select a.id,a.from_user_id,realname,d.school_name,lead_assessment,a.publish_time,a.create_time " +
					" from dxs_lead_assessment a, dxs_user u, dxs_user_detail d where a.from_user_id=u.id and d.userid=u.id " +
					" and a.is_delete=1 and to_user_id='"+user.getId()+"'";
			*/
			String userid = user.getId();
			// 如果Entity里的属性是Integer,需判断是否为空，否则会带上WHERE=0处理
			StringBuffer sb_and = new StringBuffer();
			if(StringUtil.isEmpty(searchForm.getIsDelete())){
				sb_and.append(" and a.is_delete="+ 1);
			}else{
				sb_and.append(" and a.is_delete="+ searchForm.getIsDelete());
			}
			sb_and.append(" and a.to_user_id='"+ userid + "' ");

			StringBuffer sb_limit = new StringBuffer();
			if (!StringUtil.isEmpty(searchForm.getPageNo()) && !StringUtil.isEmpty(searchForm.getPageSize())) {
				pageNo = Integer.parseInt(searchForm.getPageNo());
				pageSize = Integer.parseInt(searchForm.getPageSize());
				sb_limit.append(" LIMIT " + (pageNo-1)*pageSize +","+ pageSize );
			}

			String sql = "select a.id,a.from_user_id,realname,d.school_name,lead_assessment,a.publish_time,a.create_time " +
					" from dxs_lead_assessment a, dxs_user u, dxs_user_detail d where a.from_user_id=u.id and d.userid=u.id  "
					+ sb_and.toString()
					+ sb_limit.toString();
			String sql_count = "select a.id " +
					" from dxs_lead_assessment a, dxs_user u, dxs_user_detail d where a.from_user_id=u.id and d.userid=u.id  "
					+ sb_and.toString();
			List<Map> uaList = this.sysService.findListbySql(sql);
			List<Map> uaList_count = this.sysService.findListbySql(sql_count);

			List<Map<String, Object>> aList = new ArrayList();
			if(!uaList.isEmpty())
				for (Object obj : uaList) {
					Map map = new HashMap();
					Object[] u = (Object[]) obj;
					String field = "";
					for(int i=0;i<u.length;i++){
						if(u[i]!=null){
							field = u[i].toString();
						}else {
							field = "";
						}
						map.put("field"+i,field);
					}
					aList.add(map);
					mode.setTotal(Integer.parseInt(uaList_count.get(0).toString()));
				}

			final int allCounts;
			if (mode.getTotal() != 0) {
				allCounts = mode.getTotal();
			} else {
				allCounts = 0;
			}
			int pageCount = 0;
			if (pageNo!=0 && pageSize!=0) {
				pageCount = allCounts/pageSize + 1;
				int start = (pageNo - 1) * pageSize;
			}
			mode.setPageCount(pageCount);
			mode.setPageNo(pageNo);
			mode.setPageSize(pageSize);
			mode.setResult(aList);

			replyDataMode.setData(mode);
			replyDataMode.setStatusCode("200");
			replyDataMode.setSuccess(true);
		}else{
			replyDataMode.setStatusCode("用户未登录");
			replyDataMode.setSuccess(false);
		}
		return replyDataMode;
	}



	/**
	 * 查询用户对该公司中的某种职位的所有评价
	 * (注：此方法嵌套多次for循环查询，导致分页pageSize有BUG)

	 * @param request
	 * @return
	 */
	@RequestMapping("/empAssessmentListToInterview")
	@ResponseBody
	public ReplyDataMode empAssessmentListToInterview(EmployedForm searchForm, HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();
		// 存放多个评价
		List<EmpInterviewAssessmentVo> interviewAssessmentVos = new ArrayList<EmpInterviewAssessmentVo>();
		// 分页模型设置
		PageMode mode = new PageMode();
		int total = 0;
		int pageNo = 0;
		int pageSize = 0;
		if (!StringUtil.isEmpty(searchForm.getPageNo()) && !StringUtil.isEmpty(searchForm.getPageSize())) {
			pageNo = Integer.parseInt(searchForm.getPageNo());
			pageSize = Integer.parseInt(searchForm.getPageSize());
		}

		// 登录下获取用户id
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
		if(user!=null){
			searchForm.setUserId(user.getId());
			// sql1
			CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();
			List<EmployedEntity> eeList = this.sysService.list(criteriaQuery);
			ResumeUserForm resumeUserForm = new ResumeUserForm();
			for (EmployedEntity ee : eeList) {
				resumeUserForm.setEmoloyedId(ee.getId());
				// sql2
				CriteriaQuery cq2 = resumeUserForm.getCriteriaQuery();
				List<ResumeUserEntity> entityList2 = this.sysService.list(cq2);
				if (entityList2 != null && entityList2.size() > 0) {
					for (ResumeUserEntity entity2 : entityList2) {
						InterviewForm form3 = new InterviewForm();
						form3.setResumeUserId(entity2.getId());
						// sql3
						CriteriaQuery cq3 = form3.getCriteriaQuery();
						List<InterviewEntity> entityList3 = this.sysService.list(cq3);
						if (entityList3 != null && entityList3.size() > 0) {
							for (InterviewEntity interviewEntity1 : entityList3) {
								// 通过每个面试邀请的ID查询所指定的评价信息
								InterviewAssessmentForm interviewAssessmentForm = new InterviewAssessmentForm();
								interviewAssessmentForm.setIsDelete("0");
								interviewAssessmentForm.setInterviewId(interviewEntity1.getId());
								// sql4
								CriteriaQuery cq4 = interviewAssessmentForm.getCriteriaQuery();
								cq4.addOrder("publishTime", "desc");
								// 查询评价信息
								List<InterviewAssessmentEntity> interviewAssessmentEntityList = null;
								if (pageNo!=0 && pageSize!=0) {
									mode = this.sysService.list4page(cq4, pageNo, pageSize);
									total+=mode.getTotal();
									// 判断分页pageSize!!!! 带解决！！！
									if(pageSize >= total){
										interviewAssessmentEntityList = mode.getResult();
									}
								}else{
									interviewAssessmentEntityList = this.sysService.list(cq4);
								}
								if (interviewAssessmentEntityList != null && interviewAssessmentEntityList.size() > 0) {
									for (InterviewAssessmentEntity interviewAssessmentEntity : interviewAssessmentEntityList) {
										EmpInterviewAssessmentVo interviewAssessmentVo = new EmpInterviewAssessmentVo();
										interviewAssessmentVo.copyEntity(interviewAssessmentEntity);
										interviewAssessmentVos.add(interviewAssessmentVo);
									}
									mode.setResult(interviewAssessmentVos);
								}

							}
						}
					}
				}
			}
			mode.setTotal(total);
			replyDataMode.setData(mode);
			replyDataMode.setStatusCode("200");
			replyDataMode.setSuccess(true);
		}else{
			replyDataMode.setStatusCode("用户未登录");
			replyDataMode.setSuccess(false);
		}
		return replyDataMode;
	}











	/**
	 * 查询用户对该公司中的某种职位的所有评价
	 * (注：此方法嵌套多次for循环查询，导致分页pageSize有BUG)

	 * @param request
	 * @return
	 */
	@RequestMapping("/empAssessmentListToInterviewPage")
	@ResponseBody
	public ReplyDataMode empAssessmentListToInterviewPage(EmployedForm searchForm, HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();
		// 存放多个评价
		List<EmpInterviewAssessmentVo> interviewAssessmentVos = new ArrayList<EmpInterviewAssessmentVo>();
		// 分页模型设置
		PageMode mode = new PageMode();
		int total = 0;
		int pageNo = 0;
		int pageSize = 0;
		if (!StringUtil.isEmpty(searchForm.getPageNo()) && !StringUtil.isEmpty(searchForm.getPageSize())) {
			pageNo = Integer.parseInt(searchForm.getPageNo());
			pageSize = Integer.parseInt(searchForm.getPageSize());
		}

		// 登录下获取用户id
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
		if(user!=null){
			String userid = user.getId();
			// 如果Entity里的属性是Integer,需判断是否为空，否则会带上WHERE=0处理
			StringBuffer sb_and = new StringBuffer();
			if(StringUtil.isEmpty(searchForm.getIsDelete())){
				sb_and.append(" and a.is_delete="+ 0);
			}else{
				sb_and.append(" and a.is_delete="+ searchForm.getIsDelete());
			}
			sb_and.append(" and d.user_id='"+ userid + "' ");

			StringBuffer sb_limit = new StringBuffer();
			if (!StringUtil.isEmpty(searchForm.getPageNo()) && !StringUtil.isEmpty(searchForm.getPageSize())) {
				pageNo = Integer.parseInt(searchForm.getPageNo());
				pageSize = Integer.parseInt(searchForm.getPageSize());
				sb_limit.append(" LIMIT " + (pageNo-1)*pageSize +","+ pageSize );
			}

			String sql = "select user_name,university,a.Assessment_content,a.publish_time, a.id, a.Corporate_environment, a.Employee_atmosphere, a.interviewer_Level " +
					" from dxs_interview_assessment a, dxs_interview b, dxs_resume_user c, dxs_employed d WHERE a.interview_id=b.id and b.resume_user_id=c.id and c.emoloyed_id=d.id  "
					+ sb_and.toString()
					+ sb_limit.toString();
			String sql_count = "select a.id " +
					" from dxs_interview_assessment a, dxs_interview b, dxs_resume_user c, dxs_employed d WHERE a.interview_id=b.id and b.resume_user_id=c.id and c.emoloyed_id=d.id  "
					+ sb_and.toString();
			List<Map> uaList = this.sysService.findListbySql(sql);
			List<Map> uaList_count = this.sysService.findListbySql(sql_count);

			List<Map<String, Object>> aList = new ArrayList();
			if(!uaList.isEmpty()) for (Object obj : uaList) {
				Map map = new HashMap();
				Object[] u = (Object[]) obj;
				String field = "";
				int totalNum = 0;
				for(int i=0;i<u.length;i++){
					if(u[i]!=null){
						field = u[i].toString();
						// 加日期转换
						if(i==5 || i==6 || i==7){
							totalNum += Integer.parseInt(field);
							map.put("field8",(totalNum/3));
						}else{
							map.put("field8","0");
						}
					}else {
						field = "";
					}
					map.put("field"+i,field);
				}
				aList.add(map);
				mode.setTotal(uaList_count.size());
			}

			final int allCounts;
			if (mode.getTotal() != 0) {
				allCounts = mode.getTotal();
			} else {
				allCounts = 0;
			}
			int pageCount = 0;
			if (pageNo!=0 && pageSize!=0) {
				pageCount = allCounts/pageSize + 1;
				int start = (pageNo - 1) * pageSize;
			}
			mode.setPageCount(pageCount);
			mode.setPageNo(pageNo);
			mode.setPageSize(pageSize);
			mode.setResult(aList);

			replyDataMode.setData(mode);
			replyDataMode.setStatusCode("200");
			replyDataMode.setSuccess(true);
		}else{
			replyDataMode.setStatusCode("用户未登录");
			replyDataMode.setSuccess(false);
		}
		return replyDataMode;
	}

}
