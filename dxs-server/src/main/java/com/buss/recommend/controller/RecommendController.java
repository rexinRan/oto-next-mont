package com.buss.recommend.controller;
import com.buss.activecatelog.entity.ActiveCatelogEntity;
import com.buss.actives.entity.ActivessEntity;
import com.buss.actives.trans.vo.ActivessVO;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.authentication.entity.DxsAuthenticationEntity;
import com.buss.common.service.SysServiceI;
import com.buss.member.entity.GeneralUserEntity;
import com.buss.project.bases.entity.BasesEntity;
import com.buss.project.bases.trans.vo.BasesVO;
import com.buss.project.founds.entity.FoundEntity;
import com.buss.project.founds.trans.vo.FoundVO;
import com.buss.project.projectapply.entity.ProjectApplyEntity;
import com.buss.project.projectapply.trans.form.ProjectApplySearchForm;
import com.buss.project.projects.entity.ProjectEntity;
import com.buss.project.projects.trans.vo.ProjectVO;
import com.buss.recommend.entity.RecommendEntity;
import com.buss.recommend.trans.form.RecommendSearchForm;
import com.buss.recommend.trans.vo.RecommendVO;
import com.buss.resume.resume.entity.ResumeEntity;
import com.buss.resumeuser.entity.ResumeUserEntity;
import com.buss.resumeuser.trans.form.ResumeUserForm;
import com.buss.userdetail.entity.UserDetailEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.jweb.core.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.jstl.sql.Result;
import java.util.*;

/**
 * @author lu
 *
 */
@Controller
@RequestMapping("/recommend")
public class RecommendController {

	@Resource
	private SysServiceI sysService;


	@RequestMapping("/select.do")
	@ResponseBody
	public ReplyDataMode recommendSelect(GeneralUserEntity generalUserEntity, HttpServletRequest request){
		String idcardnumber = generalUserEntity.getIdcardnumber();
		generalUserEntity.setId(null);
		ReplyDataMode dataMode = new ReplyDataMode();

		String sql = "select * from dxs_user where id_card_number='" +idcardnumber +"' and isdelete =0";

		try {
			List news = this.sysService.findListbySql(sql);

			String name = ((Object[])news.get(0))[1].toString();
			String id = ((Object[])news.get(0))[0].toString();

			UserDetailEntity userDetailEntity = this.sysService.findByProperty(UserDetailEntity.class,"userId",id).get(0);

			Map<String, Object> temp = new HashMap<>();
			temp.put("name",userDetailEntity.getName());
			temp.put("idCard",userDetailEntity.getIdcard());
			temp.put("grade",userDetailEntity.getSchoolGrade());
			temp.put("schoolName",userDetailEntity.getSchoolName());
			temp.put("id",id);
			dataMode.setData(temp);
			dataMode.setSuccess(true);

		}catch (Exception e){

			dataMode.setSuccess(false);

		}

		dataMode.setStatusCode("200");
		return dataMode;
	}


	@RequestMapping("/saveRecommend.do")
	@ResponseBody
	public ReplyDataMode saveRecommend(RecommendSearchForm searchForm, HttpServletRequest request){

		ResumeEntity resumeEntity = null;
		ResumeUserEntity resumeUserEntity = null;
		ReplyDataMode replyDataMode = new ReplyDataMode();
		boolean flag = false;
		//获取用户登录信息
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

		if(user == null){
			//用户没有登录
			replyDataMode.setStatusCode("402");
			replyDataMode.setSuccess(flag);
			return replyDataMode;
		}
		if(!"teacher".equals(user.getRolecode())){
			//用户不是老师
			replyDataMode.setStatusCode("403");
			replyDataMode.setSuccess(flag);
			return replyDataMode;
		}

		List<ResumeEntity> resumeEntityList = null;

		resumeEntityList= this.sysService.findByProperty(ResumeEntity.class,"userid",searchForm.getBerecommendedUserId());

			resumeEntity = resumeEntityList.get(0);
			//设置已确定字段
			resumeUserEntity = new ResumeUserEntity();
			resumeUserEntity.setUserId(searchForm.getBerecommendedUserId());
			resumeUserEntity.setUserName(this.sysService.get(GeneralUserEntity.class,searchForm.getBerecommendedUserId()).getRealname());
			resumeUserEntity.setResumeId(resumeEntity.getId());
			resumeUserEntity.setEmoloyedId(searchForm.getOutId());
			resumeUserEntity.setRtype(2);
			resumeUserEntity.setResult(0);
			resumeUserEntity.setIsDelete(0);
			Date date = new Date();
			resumeUserEntity.setSendTime(date);
			resumeUserEntity.setCreateTime(date);
			resumeUserEntity.setUpdateTime(date);

			try {

				this.sysService.saveOrUpdate(resumeUserEntity);
				replyDataMode.setStatusCode("200");
				flag = true;

			} catch (Exception e) {
				//保存失败
				replyDataMode.setStatusCode("401");
				replyDataMode.setSuccess(flag);
				return replyDataMode;
			}


		//设置已确定字段
		RecommendEntity recommendEntity = (RecommendEntity) searchForm.toEntity();
		recommendEntity.setOutId(searchForm.getOutId());
		recommendEntity.setResumeUserId(resumeUserEntity.getId());
		recommendEntity.setRecommendedUserId(user.getId());
		recommendEntity.setBerecommendedUserId(searchForm.getBerecommendedUserId());
		recommendEntity.setRecommendedReviews(searchForm.getRecommendedReviews());
		recommendEntity.setIsDelete(0);
		recommendEntity.setCreateTime(date);
		recommendEntity.setUpdateTime(date);

		try {

			this.sysService.saveOrUpdate(recommendEntity);
			replyDataMode.setStatusCode("200");
			flag = true;

		}catch (Exception e){
			//保存失败
			replyDataMode.setStatusCode("401");

		}

		replyDataMode.setSuccess(flag);

		return replyDataMode;
	}


	/**
	 * 已推荐职位
	 * @param recommendSearchForm
	 * @param name			推荐的学生名字
	 * @param status		状态筛选
	 * @param request
     * @return
     */
	@RequestMapping(value = "recommendPosition")
	@ResponseBody
	public ReplyDataMode recommendPosition(RecommendSearchForm recommendSearchForm,String name,String status,HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();

		//获取用户登录信息
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

		if (user != null){
			if ("teacher".equals(user.getRolecode())){

				// 分页模型设置
				PageMode mode = new PageMode();
				int total = 0;
				int pageNo = 0;
				int pageSize = 0;
				StringBuffer sb_limit = new StringBuffer();
				if (!StringUtil.isEmpty(recommendSearchForm.getPageNo()) && !StringUtil.isEmpty(recommendSearchForm.getPageSize())) {
					pageNo = Integer.parseInt(recommendSearchForm.getPageNo());
					pageSize = Integer.parseInt(recommendSearchForm.getPageSize());
					sb_limit.append(" LIMIT " + (pageNo-1)*pageSize +","+ pageSize );

					// 判断是否为状态筛选
					String dru = " ";		// 简历投送
					String userId = " ";
					String result = " "; 	// result = 1:学生以点击链接(邮箱推荐链接)报名   rtype = 2:简历投送中类型为教师推荐  status = 状态
					if (!StringUtil.isEmpty(status)){
						dru = " , dxs_resume_user dru ";
						userId = " AND dru.user_id = du.id AND dru.emoloyed_id = dr.out_id ";
						result = " AND dr.result = '1' AND dru.rtype = 2 AND dru.result = " + status;
					}

					// 学生姓名查询
					String likeName = " ";
					if (!StringUtil.isEmpty(name)){
						likeName = " AND du.realname LIKE + '%" + name +"%'";
					}
					String sql = "SELECT dr.hx_currency, dr.recommend_time, dr.result, du.realname, de.employed_name, de.compancy_name, de.id" +
							" FROM dxs_recommend dr, dxs_employed de, dxs_user du " + dru +
							" WHERE dr.recommended_user_id = " +  "'" +user.getId() + "'"  + " AND du.id = dr.berecommended_user_id AND dr.out_id = de.id " +
							userId + " AND dr.is_delete = 0 AND du.isdelete = 0 " + result + likeName + sb_limit.toString();

					String sqlCount = "SELECT COUNT(1) " +
							" FROM dxs_recommend dr, dxs_employed de, dxs_user du " + dru +
							" WHERE dr.recommended_user_id = " +  "'" +user.getId() + "'"  + " AND du.id = dr.berecommended_user_id AND dr.out_id = de.id " +
							userId + " AND dr.is_delete = 0 AND du.isdelete = 0 " + result + likeName;

					// 符合条件数据
					List uaList = this.sysService.findListbySql(sql);

					// 符合条件数据的个数(分页总条数)
					List countList = this.sysService.findListbySql(sqlCount);

					List<Map<String, Object>> aList = new ArrayList();
					if (!uaList.isEmpty()) for (Object obj : uaList) {
						Map map = new HashMap();
						Object[] u = (Object[]) obj;
						String field = "";
						for (int i = 0; i < u.length; i++) {
							if (u[i] != null) {
								field = u[i].toString();
							} else {
								field = "";
							}
							map.put("field" + i, field);
						}
						aList.add(map);
						mode.setTotal(Integer.parseInt(countList.get(0).toString()));
					}

					final int allCounts;
					if (mode.getTotal() != 0) {
						allCounts = mode.getTotal();
					} else {
						allCounts = 0;
					}
					int pageCount = 0;
					if (pageNo != 0 && pageSize != 0) {
						pageCount = (allCounts - 1) / pageSize + 1;
					}

					mode.setPageCount(pageCount);
					mode.setPageNo(pageNo);
					mode.setPageSize(pageSize);
					mode.setResult(aList);

					replyDataMode.setData(mode);
					replyDataMode.setStatusCode("200");
					replyDataMode.setSuccess(true);
				}else {

					replyDataMode.setStatusCode("请设置分页!");
					replyDataMode.setSuccess(false);
				}
			}else {
				replyDataMode.setStatusCode("您不是教师!");
				replyDataMode.setSuccess(false);
			}
		}else {

			replyDataMode.setStatusCode("请您登陆!");
			replyDataMode.setSuccess(false);
		}

		return replyDataMode;
	}


	/**
	 * 推荐创业项目
	 * @return
     */
	@RequestMapping(value = "recommendProject")
	@ResponseBody
	public ReplyDataMode recommendProject(RecommendSearchForm recommendSearchForm,HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();

		// 获取当前登录用户
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

		if (user != null) {
			if ("teacher".equals(user.getRolecode())){
				if (!com.alibaba.druid.util.StringUtils.isEmpty(recommendSearchForm.getPageNo()) && !com.alibaba.druid.util.StringUtils.isEmpty(recommendSearchForm.getPageSize())) {
					Integer pageNo = Integer.parseInt(recommendSearchForm.getPageNo());
					Integer pageSize = Integer.parseInt(recommendSearchForm.getPageSize());

					recommendSearchForm.setIsDelete("0");
					recommendSearchForm.setRecommendedUserId(user.getId());
					CriteriaQuery criteriaQuery = recommendSearchForm.getCriteriaQuery();
					criteriaQuery.addOrder("createTime", "desc");

					PageMode mode = this.sysService.list4page(criteriaQuery,pageNo,pageSize);
					List<RecommendEntity> recommendEntityList = mode.getResult();
					List<Map<String,List>> list = new ArrayList<Map<String,List>>();

					if (recommendEntityList != null && recommendEntityList.size() > 0){
						for (RecommendEntity re:recommendEntityList){
							List<RecommendVO> recommendVOs = new ArrayList<RecommendVO>();
							List<FoundVO> foundVOs = new ArrayList<FoundVO>();
							List<BasesVO> basesVOs = new ArrayList<BasesVO>();
							List<ProjectVO> projectVOs = new ArrayList<ProjectVO>();
							Map<String,List> map = new HashMap<String,List>();

							RecommendVO recommendVO = new RecommendVO();
							recommendVO.copyEntity(re);
							recommendVOs.add(recommendVO);
							map.put("recommendVOs",recommendVOs);

							// 根据re中outId查询所有对应基金/基地申请表
							ProjectApplySearchForm projectApplySearchForm = new ProjectApplySearchForm();
							projectApplySearchForm.setApplyType("1");		// 推荐参赛(如果只查询教师的推荐过的,而不是推荐成功的就可以去掉该条件)
							projectApplySearchForm.setId(re.getOutId());
							CriteriaQuery criteriaQuery1 = projectApplySearchForm.getCriteriaQuery();

							List<ProjectApplyEntity> projectApplyEntityList = this.sysService.list(criteriaQuery1);

							if (projectApplyEntityList != null && projectApplyEntityList.size() > 0){

								// 通过projectApplyEntity中的outId查询所对应的基金/基地
								if (!StringUtils.isEmpty(projectApplyEntityList.get(0).getType()) && "1".equals(projectApplyEntityList.get(0).getType() + "")
										&& !StringUtils.isEmpty(projectApplyEntityList.get(0).getOutId())){
									// 基金
									FoundEntity foundEntity = this.sysService.get(FoundEntity.class,projectApplyEntityList.get(0).getOutId());

									if (foundEntity != null){
										FoundVO foundVO = new FoundVO();
										foundVO.copyEntity(foundEntity);
										foundVOs.add(foundVO);
										map.put("foundVOs",foundVOs);
									}else {
										foundVOs.add(new FoundVO());
										map.put("foundVOs",foundVOs);
									}
								}else {
									foundVOs.add(new FoundVO());
									map.put("foundVOs",foundVOs);
								}
								if (!StringUtils.isEmpty(projectApplyEntityList.get(0).getType()) && "2".equals(projectApplyEntityList.get(0).getType() + "")
										&& !StringUtils.isEmpty(projectApplyEntityList.get(0).getOutId())){
									// 基地
									BasesEntity basesEntity = this.sysService.get(BasesEntity.class,projectApplyEntityList.get(0).getOutId());

									if (basesEntity != null){
										BasesVO basesVO = new BasesVO();
										basesVO.copyEntity(basesEntity);
										basesVOs.add(basesVO);
										map.put("basesVOs",basesVOs);
									}else {
										basesVOs.add(new BasesVO());
										map.put("basesVOs",basesVOs);
									}
								}else {
									basesVOs.add(new BasesVO());
									map.put("basesVOs",basesVOs);
								}

								// 根据projectApplyEntity中的projectId查询所对应的项目
								if (!StringUtil.isEmpty(projectApplyEntityList.get(0).getProjectId())){
									ProjectEntity projectEntity = this.sysService.get(ProjectEntity.class,projectApplyEntityList.get(0).getProjectId());

									if (projectEntity != null){
										ProjectVO projectVO = new ProjectVO();
										projectVO.copyEntity(projectEntity);
										projectVOs.add(projectVO);
										map.put("projectVOs",projectVOs);
									}else {
										projectVOs.add(new ProjectVO());
										map.put("projectVOs",projectVOs);
									}
								}else {
									projectVOs.add(new ProjectVO());
									map.put("projectVOs",projectVOs);
								}
							}else {
								foundVOs.add(new FoundVO());
								basesVOs.add(new BasesVO());
								projectVOs.add(new ProjectVO());

								map.put("foundVOs",foundVOs);
								map.put("basesVOs",basesVOs);
								map.put("projectVOs",projectVOs);
							}
							list.add(map);
						}

						mode.setResult(list);
						replyDataMode.setData(mode);
						replyDataMode.setStatusCode("200");
						replyDataMode.setSuccess(true);
					}else {
						mode.setResult(list);
						replyDataMode.setData(mode);
						replyDataMode.setStatusCode("200");
						replyDataMode.setSuccess(true);
					}
				}else {

					replyDataMode.setStatusCode("请设置分页!");
					replyDataMode.setSuccess(false);
				}
			}else {
				replyDataMode.setStatusCode("您不是教师!");
				replyDataMode.setSuccess(false);
			}
		}else {

			replyDataMode.setStatusCode("请您登陆!");
			replyDataMode.setSuccess(false);
		}
		return replyDataMode;
	}


	/**
	 * 教师/个人中心/活动管理/活动推荐
	 * @param request
	 * @return
     */
	@RequestMapping(value = "recommendedActions")
	@ResponseBody
	public ReplyDataMode recommendedActions(RecommendSearchForm recommendSearchForm,HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();

		// 获取当前登录用户
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

		if (user != null) {
			if ("teacher".equals(user.getRolecode())){
				if (!StringUtil.isEmpty(recommendSearchForm.getPageNo()) && !StringUtil.isEmpty(recommendSearchForm.getPageSize())) {
					Integer pageNo = Integer.parseInt(recommendSearchForm.getPageNo());
					Integer pageSize = Integer.parseInt(recommendSearchForm.getPageSize());

					recommendSearchForm.setIsDelete("0");
					recommendSearchForm.setRecommendedUserId(user.getId());
					CriteriaQuery criteriaQuery = recommendSearchForm.getCriteriaQuery();
					criteriaQuery.addOrder("createTime", "desc");

					PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
					List<RecommendEntity> recommendEntityList = mode.getResult();
					List<Map<String,List>> list = new ArrayList<Map<String,List>>();

					if (recommendEntityList != null && recommendEntityList.size() > 0){
						for (RecommendEntity re:recommendEntityList){
							Map<String,List> map = new HashMap<String,List>();
							List<RecommendVO> recommendVOs = new ArrayList<RecommendVO>();
							List<ActivessVO> activessVOs = new ArrayList<ActivessVO>();

							RecommendVO recommendVO = new RecommendVO();
							recommendVO.copyEntity(re);
							recommendVOs.add(recommendVO);
							map.put("recommendVOs",recommendVOs);

							if (!StringUtil.isEmpty(re.getOutId()) && !StringUtils.isEmpty(re.getBerecommendedUserId())){
								ActivessEntity activessEntity = this.sysService.get(ActivessEntity.class,re.getOutId());
								GeneralUserEntity generalUserEntity = this.sysService.get(GeneralUserEntity.class,re.getBerecommendedUserId());

								if (activessEntity != null && generalUserEntity != null){
									ActivessVO activessVO = new ActivessVO();
									activessVO.copyEntity(activessEntity);
									activessVO.setUserName(generalUserEntity.getRealname());

									if (!StringUtil.isEmpty(activessEntity.getId())){
										List<ActiveCatelogEntity> activeCatelogEntityList = this.sysService.findByProperty(ActiveCatelogEntity.class,"id",activessEntity.getActiveCatelogId());

										if (activeCatelogEntityList != null && activeCatelogEntityList.size() > 0){
											activessVO.setTypeName(activeCatelogEntityList.get(0).getActiveCatelogName());
										}else {
											activessVO.setTypeName(null);
										}
									}else {
										activessVO.setTypeName(null);
									}
									activessVOs.add(activessVO);
									map.put("activessVOs",activessVOs);
								}else {
									activessVOs.add(new ActivessVO());
									map.put("activessVOs",activessVOs);
								}
							}else {
								activessVOs.add(new ActivessVO());
								map.put("activessVOs",activessVOs);
							}
							list.add(map);
						}
					}

					mode.setResult(list);
					replyDataMode.setData(mode);
					replyDataMode.setStatusCode("200");
					replyDataMode.setSuccess(true);
				}else {
					replyDataMode.setStatusCode("请设置分页!");
					replyDataMode.setSuccess(false);
				}
			}else {
				replyDataMode.setStatusCode("您不是教师!");
				replyDataMode.setSuccess(false);
			}
		}else {

			replyDataMode.setStatusCode("请您登陆!");
			replyDataMode.setSuccess(false);
		}

		return replyDataMode;
	}


	/**
	 * 教师/个人中心/学习培训/推荐课程
	 * @param request
	 * @return
     */
	@RequestMapping(value = "recommendCurriculum")
	@ResponseBody
	public ReplyDataMode recommendCurriculum(RecommendSearchForm recommendSearchForm,HttpServletRequest request) {
		ReplyDataMode replyDataMode = new ReplyDataMode();

		// 获取当前登录用户
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

		if (user != null) {
			if ("teacher".equals(user.getRolecode())) {
				// 分页模型设置
				PageMode mode = new PageMode();
				int total = 0;
				int pageNo = 0;
				int pageSize = 0;
				StringBuffer sb_limit = new StringBuffer();
				if (!StringUtil.isEmpty(recommendSearchForm.getPageNo()) && !StringUtil.isEmpty(recommendSearchForm.getPageSize())) {
					pageNo = Integer.parseInt(recommendSearchForm.getPageNo());
					pageSize = Integer.parseInt(recommendSearchForm.getPageSize());
					sb_limit.append(" LIMIT " + (pageNo - 1) + "," + pageSize);

					List<DxsAuthenticationEntity> authenticationEntityList = this.sysService.findByProperty(DxsAuthenticationEntity.class, "userId", user.getId());

					if (authenticationEntityList != null && authenticationEntityList.size() > 0) {
						for (DxsAuthenticationEntity dae : authenticationEntityList) {
							if (!StringUtil.isEmpty(dae.getAuthenticationResult())) {
								if ("8".equals(dae.getAuthenticationResult()) || "11".equals(dae.getAuthenticationResult()) ||
										"20".equals(dae.getAuthenticationResult()) || "14".equals(dae.getAuthenticationResult()) ||
										"17".equals(dae.getAuthenticationResult())) {

									String data_sql = "SELECT\n" +
											"\t*\n" +
											"FROM\n" +
											"(\n" +
											"SELECT\n" +
											"\ttonc.title t1,\n" +
											"\ttcc.catalog_name t2,\n" +
											"\tu.realname t3,\n" +
											"\tdr.result t4,\n" +
											"\ttonc.account t5,\n" +
											"\ttonc.remarks y6,\n" +
											"\tdr.id t7,\n" +
											"\ttonc.id t8\n" +
											"FROM\n" +
											"\tdxs_recommend dr,\n" +
											"\tdxs_train_online_course tonc,\n" +
											"\tdxs_train_course_catalog tcc,\n" +
											"\tdxs_user u\n" +
											"WHERE\n" +
											"\t\tdr.recommended_user_id = '"+ user.getId() +"'\n" +
											"AND dr.out_id = tonc.id\n" +
											"AND tonc.tcc_id = tcc.id\n" +
											"AND dr.berecommended_user_id = u.id\n" +
											"AND dr.is_delete = 0\n" +
											"\tunion\n" +
											"SELECT\n" +
											"\ttouc.title t1,\n" +
											"\ttcc.catalog_name t2,\n" +
											"\tu.realname t3,\n" +
											"\tdr.result t4,\n" +
											"\ttouc.account t5,\n" +
											"\ttouc.remarks y6,\n" +
											"\tdr.id t7,\n" +
											"\ttouc.id t8\n" +
											"FROM\n" +
											"\tdxs_recommend dr,\n" +
											"\tdxs_train_outline_course touc,\n" +
											"\tdxs_train_course_catalog tcc,\n" +
											"\tdxs_user u\n" +
											"WHERE\n" +
											"\t\tdr.recommended_user_id = '"+ user.getId() +"'\n" +
											"AND dr.out_id = touc.id\n" +
											"AND touc.tcc_id = tcc.id\n" +
											"AND dr.berecommended_user_id = u.id\n" +
											"AND dr.is_delete = 0\n" +
											")\tAS a\n" + sb_limit.toString();

									String count_sql = "SELECT\n" +
											"\tCOUNT(1)\n" +
											"FROM\n" +
											"(\n" +
											"SELECT\n" +
											"\ttonc.title t1,\n" +
											"\ttcc.catalog_name t2,\n" +
											"\tu.realname t3,\n" +
											"\tdr.result t4,\n" +
											"\ttonc.account t5,\n" +
											"\ttonc.remarks y6,\n" +
											"\tdr.id t7,\n" +
											"\ttonc.id t8\n" +
											"FROM\n" +
											"\tdxs_recommend dr,\n" +
											"\tdxs_train_online_course tonc,\n" +
											"\tdxs_train_course_catalog tcc,\n" +
											"\tdxs_user u\n" +
											"WHERE\n" +
											"\t\tdr.recommended_user_id = '"+ user.getId() +"'\n" +
											"AND dr.out_id = tonc.id\n" +
											"AND tonc.tcc_id = tcc.id\n" +
											"AND dr.berecommended_user_id = u.id\n" +
											"AND dr.is_delete = 0\n" +
											"\tunion\n" +
											"SELECT\n" +
											"\ttouc.title t1,\n" +
											"\ttcc.catalog_name t2,\n" +
											"\tu.realname t3,\n" +
											"\tdr.result t4,\n" +
											"\ttouc.account t5,\n" +
											"\ttouc.remarks y6,\n" +
											"\tdr.id t7,\n" +
											"\ttouc.id t8\n" +
											"FROM\n" +
											"\tdxs_recommend dr,\n" +
											"\tdxs_train_outline_course touc,\n" +
											"\tdxs_train_course_catalog tcc,\n" +
											"\tdxs_user u\n" +
											"WHERE\n" +
											"\t\tdr.recommended_user_id = '"+ user.getId() +"'\n" +
											"AND dr.out_id = touc.id\n" +
											"AND touc.tcc_id = tcc.id\n" +
											"AND dr.berecommended_user_id = u.id\n" +
											"AND dr.is_delete = 0\n" +
											")\tAS a";

									List dataSql = this.sysService.findListbySql(data_sql);
									List countSql = this.sysService.findListbySql(count_sql);

									List<Map<String, Object>> aList = new ArrayList();
									if (!dataSql.isEmpty())
										for (Object obj : dataSql) {
											Map map = new HashMap();
											Object[] u = (Object[]) obj;
											String field = "";
											for (int i = 0; i < u.length; i++) {
												if (u[i] != null) {
													field = u[i].toString();
												} else {
													field = "";
												}
												map.put("field" + i, field);
											}
											aList.add(map);
											mode.setTotal(Integer.parseInt(countSql.get(0).toString()));
										}

									final int allCounts;
									if (mode.getTotal() != 0) {
										allCounts = mode.getTotal();
									} else {
										allCounts = 0;
									}
									int pageCount = 0;
									if (pageNo != 0 && pageSize != 0) {
										pageCount = (allCounts - 1) / pageSize + 1;
									}

									mode.setPageCount(pageCount);
									mode.setPageNo(pageNo);
									mode.setPageSize(pageSize);
									mode.setResult(aList);

									replyDataMode.setData(mode);
									replyDataMode.setStatusCode("200");
									replyDataMode.setSuccess(true);

								}else {
									replyDataMode.setStatusCode("您还不是导师,请先申请成为导师!");
									replyDataMode.setSuccess(false);
								}
							}
						}
					}
				}else {
					replyDataMode.setStatusCode("请设置分页!");
					replyDataMode.setSuccess(false);
				}
			}else {
				replyDataMode.setStatusCode("您不是教师!");
				replyDataMode.setSuccess(false);
			}
		}else {
			replyDataMode.setStatusCode("请您登录!");
			replyDataMode.setSuccess(false);
		}
		return replyDataMode;
	}



	/**
	 * 教师/个人中心/创业管理/创业基地基金推荐
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "teacherRecommend")
	@ResponseBody
	public ReplyDataMode teacherRecommend(RecommendSearchForm recommendSearchForm, HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();
		recommendSearchForm.setIsDelete("0");

		//获取用户登录信息
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

		if (user != null){
			recommendSearchForm.setRecommendedUserId(user.getId());
			if (!StringUtil.isEmpty(recommendSearchForm.getPageNo()) && !StringUtil.isEmpty(recommendSearchForm.getPageSize())){
				Integer pageNo = Integer.parseInt(recommendSearchForm.getPageNo());
				Integer pageSize = Integer.parseInt(recommendSearchForm.getPageSize());

				if (!StringUtil.isEmpty(recommendSearchForm.getType())){
					CriteriaQuery criteriaQuery = recommendSearchForm.getCriteriaQuery();
					criteriaQuery.addOrder("createTime","deas");
					PageMode mode = this.sysService.list4page(criteriaQuery,pageNo,pageSize);
					List<RecommendEntity> recommendEntityList = mode.getResult();

//					List<RecommendVO> recommendVOs = new ArrayList<RecommendVO>();
//					List<FoundVO> foundVOs = new ArrayList<FoundVO>();
//					List<BasesVO> basesVOs = new ArrayList<BasesVO>();
					List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();

					if (recommendEntityList != null && recommendEntityList.size() > 0){
						for (RecommendEntity re:recommendEntityList){
							Map<String,Object> map = new HashMap<String,Object>();
							RecommendVO recommendVO  = new RecommendVO();
							recommendVO.copyEntity(re);

							if (!StringUtil.isEmpty(re.getBerecommendedUserId())){
								GeneralUserEntity generalUserEntity = this.sysService.get(GeneralUserEntity.class,re.getBerecommendedUserId());

								if (generalUserEntity != null){
									recommendVO.setUserName(generalUserEntity.getRealname());
								}
							}

//							recommendVOs.add(recommendVO);
							map.put("recommendVO",recommendVO);

							if (!StringUtil.isEmpty(re.getOutId())){
								// 判断推荐的类型
								if ("1".equals(recommendSearchForm.getType())){
									// 基金
									FoundEntity foundEntity = this.sysService.get(FoundEntity.class,re.getOutId());

									if (foundEntity != null){
										FoundVO foundVO = new FoundVO();
										foundVO.copyEntity(foundEntity);
//										foundVOs.add(foundVO);
										map.put("foundVO",foundVO);
									}else {
										FoundVO foundVO = new FoundVO();
//										foundVOs.add(foundVO);
										map.put("foundVO",foundVO);
									}

								}else if ("2".equals(recommendSearchForm.getType())){
									// 基地
									BasesEntity basesEntity = this.sysService.get(BasesEntity.class,re.getOutId());

									if (basesEntity != null){
										BasesVO basesVO = new BasesVO();
										basesVO.copyEntity(basesEntity);
//										basesVOs.add(basesVO);
										map.put("basesVO",basesVO);
									}else {
										BasesVO basesVO = new BasesVO();
//										basesVOs.add(basesVO);
										map.put("basesVO",basesVO);
									}

								}else {
									replyDataMode.setStatusCode("推荐中没有该类型!");
									replyDataMode.setSuccess(false);
								}
							}
							list.add(map);
						}
					}

					mode.setResult(list);
					replyDataMode.setData(mode);
					replyDataMode.setStatusCode("200");
					replyDataMode.setSuccess(true);
				}else {
					replyDataMode.setStatusCode("请您设置推荐类型!");
					replyDataMode.setSuccess(false);
				}
			}else {
				replyDataMode.setStatusCode("请您设置分页!");
				replyDataMode.setSuccess(false);
			}
		}else {
			replyDataMode.setStatusCode("请您登陆!");
			replyDataMode.setSuccess(false);
		}

		return replyDataMode;
	}
}