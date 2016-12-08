package com.buss.employed.controller;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.collentions.entity.CollentionsEntity;
import com.buss.common.redis.RedisClient;
import com.buss.common.redis.cache.CacheKey;
import com.buss.employed.entity.EmployedEntity;
import com.buss.employed.trans.form.EmployedForm;
import com.buss.employed.trans.vo.EmployedVO;
import com.buss.usercompancy.entity.UserCompancyEntity;
import com.buss.userdetail.entity.UserDetailEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buss.common.service.SysServiceI;

/**
 * @author lu
 *
 */
@Controller
@RequestMapping("/employed")
public class EmployedController {

	@Resource
	private SysServiceI sysService;
	@Resource
	private RedisClient redisClient;

	@RequestMapping("/list.do")
	@ResponseBody
	public ReplyDataMode employedList(EmployedForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		List<EmployedEntity> employeds = this.sysService.list(criteriaQuery);
		List<EmployedVO> employedVOs = new ArrayList<EmployedVO>();

		for (EmployedEntity employedEntity:employeds) {
			EmployedVO employedVO = new EmployedVO();
			employedVO.copyEntity(employedEntity);
			String add = employedVO.getEmployedPosition().replace("#","");
			String add2 = add.replace("市辖区","");
			employedVO.setEmployedPosition(add2);
			employedVOs.add(employedVO);

		}
		replyDataMode.setData(employedVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
	//首页招聘列表
	@RequestMapping("/pageList.do")
	@ResponseBody
	public ReplyDataMode employedpageList(EmployedForm searchForm, HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();
		String key = "";
		if ("on".equals(CacheKey.REDIS_SWITCH)) {
        /* 根据searchForm传递的参数，判断调用哪个缓存 */
			key = CacheKey.INDEX_ARTICLE_EMP;
			// TODO 查Redis缓存
			Object cache = redisClient.get(key);
			if (cache != null) {
				replyDataMode.setData(cache);
				replyDataMode.setStatusCode("201-读缓存");
				replyDataMode.setSuccess(true);
				return replyDataMode;
			}
		}
		searchForm.setIsDelete("0");
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String, Object> orderMap = new HashMap<>();
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());


		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<EmployedEntity> employeds = mode.getResult();

		List<EmployedVO> employedVOs = new ArrayList<EmployedVO>();

		for (EmployedEntity employedEntity:employeds) {
			EmployedVO employedVO = new EmployedVO();
			employedVO.copyEntity(employedEntity);
			/* 设置null 减少页面数据传输 */
			employedVO.setEmployedResponsibilities(null);
			employedVO.setEmployedRequirements(null);
			employedVOs.add(employedVO);

		}
		mode.setResult(employedVOs);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		if(!"".equals(key)){
			// TODO 设置Redis缓存
			Object obj = JSON.toJSON(mode);
			redisClient.put(key, obj);
		}
		return replyDataMode;
	}

	//模糊查询职位
	@RequestMapping("/searchPageList.do")
	@ResponseBody
	public ReplyDataMode searchemployedpageList(EmployedForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");

		String temp = searchForm.getEmployedName();
		searchForm.setEmployedName(null);
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String, Object> orderMap = new HashMap<>();
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());
		String likeName = "%" + temp + "%";

		try{
			criteriaQuery.like("employedName",likeName);
		}catch (Exception e) {
			throw e;
		}
		criteriaQuery.add();

		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<EmployedEntity> employeds = mode.getResult();

		List<EmployedVO> employedVOs = new ArrayList<EmployedVO>();

		for (EmployedEntity employedEntity:employeds) {
			EmployedVO employedVO = new EmployedVO();
			employedVO.copyEntity(employedEntity);
			employedVOs.add(employedVO);

		}
		mode.setResult(employedVOs);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}

	//职位详情
	@RequestMapping("/employedById.do")
	@ResponseBody
	public ReplyDataMode employedById(EmployedForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		List<EmployedEntity> employeds = this.sysService.list(criteriaQuery);
		List<EmployedVO> employedVOs = new ArrayList<EmployedVO>();

		for (EmployedEntity employedEntity:employeds) {
			EmployedVO employedVO = new EmployedVO();
			employedVO.copyEntity(employedEntity);
			employedVOs.add(employedVO);

		}
		replyDataMode.setData(employedVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}


	//首页就业中心
	@RequestMapping("/indexPageList.do")
	@ResponseBody
	public ReplyDataMode indexPageList(String sortType, EmployedForm searchForm, HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();
		String key = "";
		if ("on".equals(CacheKey.REDIS_SWITCH)) {
        /* 根据searchForm传递的参数，判断调用哪个缓存 */
			key = CacheKey.INDEX_ARTICLE_EMP;
			// TODO 查Redis缓存
			Object cache = redisClient.get(key);
			if (cache != null) {
				replyDataMode.setData(cache);
				replyDataMode.setStatusCode("201-读缓存");
				replyDataMode.setSuccess(true);
				return replyDataMode;
			}
		}

		if("".equals(searchForm.getEmployedPosition())){
			searchForm.setEmployedPosition(null);
		}
		if("不限".equals(searchForm.getCompanyNature())){
			searchForm.setCompanyNature(null);
		}
		if("不限".equals(searchForm.getEducation())){
			searchForm.setEducation(null);
		}
		if("不限".equals(searchForm.getExperience())){
			searchForm.setExperience(null);
		}
		if("不限".equals(searchForm.getEmployedType())){
			searchForm.setEmployedType(null);
		}
		if("不限".equals(searchForm.getEmployedSalary())){
			searchForm.setEmployedSalary(null);
		}

		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

		searchForm.setIsDelete("0");
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		if(sortType!=null&&!"".equals(sortType)){
			Map<String, Object> orderMap = new HashMap<>();
			if("最新".equals(sortType)){
				orderMap.put("publishTime", "desc");
			}
			if("人气".equals(sortType)){
				orderMap.put("postNum", "desc");
			}
			criteriaQuery.setOrder(orderMap);
		}


		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());


		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<EmployedEntity> employeds = mode.getResult();

		List<Map> lists = new ArrayList<Map>();

		for (EmployedEntity employedEntity:employeds) {
			Map map = new HashMap();
			EmployedVO employedVO = new EmployedVO();
			employedVO.copyEntity(employedEntity);

			String add = employedVO.getEmployedPosition().replace("#","");
			String add2 = add.replace("市辖区","");
			employedVO.setEmployedPosition(add2);

			if(employedEntity.getPublishTime()!=null){
				String showTime = "";
				Calendar now = Calendar.getInstance();
				now.setTime(new Date());
				Integer nowYear = now.get(Calendar.YEAR);
				Integer nowMonth = now.get(Calendar.MONTH);
				Integer nowDay = now.get(Calendar.DAY_OF_MONTH);
				Integer nowHour = now.get(Calendar.HOUR_OF_DAY);

				Calendar c = Calendar.getInstance();
				c.setTime(employedEntity.getPublishTime());
				Integer year = c.get(Calendar.YEAR);
				Integer month = c.get(Calendar.MONTH);
				Integer day = c.get(Calendar.DAY_OF_MONTH);
				Integer hour = c.get(Calendar.HOUR_OF_DAY);
				if((nowYear-year)!=0){
					showTime = Integer.toString(nowYear-year)+"年前发布";
				}else if((nowMonth-month)!=0){
					showTime = Integer.toString(nowMonth-month)+"月前发布";
				}else if((nowDay-day)!=0){
					showTime = Integer.toString(nowDay-day)+"天前发布";
				}else if((nowHour-hour)!=0){
					showTime = Integer.toString(nowHour-hour)+"小时前发布";
				}else{
					showTime = "刚刚发布";
				}

				employedVO.setTimeShow(showTime);
			}
			//是否关注、收藏
			employedVO.setIsCollention("未关注");
			if(user!=null){
				CollentionsEntity collentionEntity = new CollentionsEntity();
				collentionEntity.setOutId(employedVO.getId());
				collentionEntity.setUserId(user.getId());
				collentionEntity.setIsDelete(0);
				List collentions = this.sysService.findByExample(CollentionsEntity.class.getName(),collentionEntity);
				if(collentions != null&&collentions.size()>0){
					employedVO.setIsCollention("已关注");
				}
			}


			List userCompancyList = this.sysService.findByProperty(UserCompancyEntity.class,"userId",employedVO.getUserId());

			if(userCompancyList!=null&&userCompancyList.size()!=0){

				UserCompancyEntity userCompancyEntity = this.sysService.findByProperty(UserCompancyEntity.class,"userId",employedVO.getUserId()).get(0);
				userCompancyEntity.setCompancyIntroduce(null);
				userCompancyEntity.setUserEntity(null);
				map.put("company",userCompancyEntity);
			}
			employedVO.setEmployedRequirements(null);
			employedVO.setEmployedResponsibilities(null);
			map.put("employed",employedVO);
			lists.add(map);

		}
		mode.setResult(lists);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		if(!"".equals(key)){
			// TODO 设置Redis缓存
			Object obj = JSON.toJSON(mode);
			redisClient.put(key, obj);
		}

		return replyDataMode;
	}


	//就业中心招聘列表
	@RequestMapping("/employedPageList.do")
	@ResponseBody
	public ReplyDataMode employedPageList(String sortType, EmployedForm searchForm, HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();
		if("".equals(searchForm.getEmployedPosition())){
			searchForm.setEmployedPosition(null);
		}
		if("不限".equals(searchForm.getCompanyNature())){
			searchForm.setCompanyNature(null);
		}
		if("不限".equals(searchForm.getEducation())){
			searchForm.setEducation(null);
		}
		if("不限".equals(searchForm.getExperience())){
			searchForm.setExperience(null);
		}
		if("不限".equals(searchForm.getEmployedType())){
			searchForm.setEmployedType(null);
		}
		if("不限".equals(searchForm.getEmployedSalary())){
			searchForm.setEmployedSalary(null);
		}

		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

		searchForm.setIsDelete("0");
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		if(sortType!=null&&!"".equals(sortType)){
			Map<String, Object> orderMap = new HashMap<>();
			if("最新".equals(sortType)){
				orderMap.put("publishTime", "desc");
			}
			if("人气".equals(sortType)){
				orderMap.put("postNum", "desc");
			}
			criteriaQuery.setOrder(orderMap);
		}


		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());


		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<EmployedEntity> employeds = mode.getResult();

		List<Map> lists = new ArrayList<Map>();

		for (EmployedEntity employedEntity:employeds) {
			Map map = new HashMap();
			EmployedVO employedVO = new EmployedVO();
			employedVO.copyEntity(employedEntity);

			String add = employedVO.getEmployedPosition().replace("#","");
			String add2 = add.replace("市辖区","");
			employedVO.setEmployedPosition(add2);

			if(employedEntity.getPublishTime()!=null){
				String showTime = "";
				Calendar now = Calendar.getInstance();
				now.setTime(new Date());
				Integer nowYear = now.get(Calendar.YEAR);
				Integer nowMonth = now.get(Calendar.MONTH);
				Integer nowDay = now.get(Calendar.DAY_OF_MONTH);
				Integer nowHour = now.get(Calendar.HOUR_OF_DAY);

				Calendar c = Calendar.getInstance();
				c.setTime(employedEntity.getPublishTime());
				Integer year = c.get(Calendar.YEAR);
				Integer month = c.get(Calendar.MONTH);
				Integer day = c.get(Calendar.DAY_OF_MONTH);
				Integer hour = c.get(Calendar.HOUR_OF_DAY);
				if((nowYear-year)!=0){
					showTime = Integer.toString(nowYear-year)+"年前发布";
				}else if((nowMonth-month)!=0){
					showTime = Integer.toString(nowMonth-month)+"月前发布";
				}else if((nowDay-day)!=0){
					showTime = Integer.toString(nowDay-day)+"天前发布";
				}else if((nowHour-hour)!=0){
					showTime = Integer.toString(nowHour-hour)+"小时前发布";
				}else{
					showTime = "刚刚发布";
				}

				employedVO.setTimeShow(showTime);
			}
			//是否关注、收藏
			employedVO.setIsCollention("未关注");
			if(user!=null){
				CollentionsEntity collentionEntity = new CollentionsEntity();
				collentionEntity.setOutId(employedVO.getId());
				collentionEntity.setUserId(user.getId());
				collentionEntity.setIsDelete(0);
				List collentions = this.sysService.findByExample(CollentionsEntity.class.getName(),collentionEntity);
				if(collentions != null&&collentions.size()>0){
					employedVO.setIsCollention("已关注");
				}
			}


			List userCompancyList = this.sysService.findByProperty(UserCompancyEntity.class,"userId",employedVO.getUserId());

			if(userCompancyList!=null&&userCompancyList.size()!=0){

				UserCompancyEntity userCompancyEntity = this.sysService.findByProperty(UserCompancyEntity.class,"userId",employedVO.getUserId()).get(0);
				userCompancyEntity.setCompancyIntroduce(null);
				userCompancyEntity.setUserEntity(null);
				map.put("company",userCompancyEntity);
			}
			map.put("employed",employedVO);
			lists.add(map);

		}
		mode.setResult(lists);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);


		return replyDataMode;
	}

	//线上招聘招聘列表
	@RequestMapping("/onlinEmployed.do")
	@ResponseBody
	public ReplyDataMode onlinEmployed(String sortType, EmployedForm searchForm, HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();
		if("".equals(searchForm.getEmployedPosition())){
			searchForm.setEmployedPosition(null);
		}
		if("不限".equals(searchForm.getCompanyNature())){
			searchForm.setCompanyNature(null);
		}
		if("不限".equals(searchForm.getEducation())){
			searchForm.setEducation(null);
		}
		if("不限".equals(searchForm.getExperience())){
			searchForm.setExperience(null);
		}
		if("不限".equals(searchForm.getEmployedType())){
			searchForm.setEmployedType(null);
		}
		if("不限".equals(searchForm.getEmployedSalary())){
			searchForm.setEmployedSalary(null);
		}

		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

		searchForm.setIsDelete("0");
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();
//		criteriaQuery.isNotNull("osId");
//		criteriaQuery.add();

		if(sortType!=null&&!"".equals(sortType)){
			Map<String, Object> orderMap = new HashMap<>();
			if("最新".equals(sortType)){
				orderMap.put("publishTime", "desc");
			}
			if("人气".equals(sortType)){
				orderMap.put("postNum", "desc");
			}
			criteriaQuery.setOrder(orderMap);
		}


		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());


		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<EmployedEntity> employeds = mode.getResult();

		List<Map> lists = new ArrayList<Map>();

		for (EmployedEntity employedEntity:employeds) {
			Map map = new HashMap();
			EmployedVO employedVO = new EmployedVO();
			employedVO.copyEntity(employedEntity);

			String add = employedVO.getEmployedPosition().replace("#","");
			String add2 = add.replace("市辖区","");
			employedVO.setEmployedPosition(add2);

			if(employedEntity.getPublishTime()!=null){
				String showTime = "";
				Calendar now = Calendar.getInstance();
				now.setTime(new Date());
				Integer nowYear = now.get(Calendar.YEAR);
				Integer nowMonth = now.get(Calendar.MONTH);
				Integer nowDay = now.get(Calendar.DAY_OF_MONTH);
				Integer nowHour = now.get(Calendar.HOUR_OF_DAY);

				Calendar c = Calendar.getInstance();
				c.setTime(employedEntity.getPublishTime());
				Integer year = c.get(Calendar.YEAR);
				Integer month = c.get(Calendar.MONTH);
				Integer day = c.get(Calendar.DAY_OF_MONTH);
				Integer hour = c.get(Calendar.HOUR_OF_DAY);
				if((nowYear-year)!=0){
					showTime = Integer.toString(nowYear-year)+"年前发布";
				}else if((nowMonth-month)!=0){
					showTime = Integer.toString(nowMonth-month)+"月前发布";
				}else if((nowDay-day)!=0){
					showTime = Integer.toString(nowDay-day)+"天前发布";
				}else if((nowHour-hour)!=0){
					showTime = Integer.toString(nowHour-hour)+"小时前发布";
				}else{
					showTime = "刚刚发布";
				}

				employedVO.setTimeShow(showTime);
			}
			//是否关注、收藏
			employedVO.setIsCollention("未关注");
			if(user!=null){
				CollentionsEntity collentionEntity = new CollentionsEntity();
				collentionEntity.setOutId(employedVO.getId());
				collentionEntity.setUserId(user.getId());
				collentionEntity.setIsDelete(0);
				List collentions = this.sysService.findByExample(CollentionsEntity.class.getName(),collentionEntity);
				if(collentions != null&&collentions.size()>0){
					employedVO.setIsCollention("已关注");
				}
			}


			List userCompancyList = this.sysService.findByProperty(UserCompancyEntity.class,"userId",employedVO.getUserId());

			if(userCompancyList!=null&&userCompancyList.size()!=0){

				UserCompancyEntity userCompancyEntity = this.sysService.findByProperty(UserCompancyEntity.class,"userId",employedVO.getUserId()).get(0);
				userCompancyEntity.setCompancyIntroduce(null);
				userCompancyEntity.setUserEntity(null);
				map.put("company",userCompancyEntity);
			}
			map.put("employed",employedVO);
			lists.add(map);

		}
		mode.setResult(lists);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);


		return replyDataMode;
	}



	//最受关注职位列表
	@RequestMapping("/collentionsPageList.do")
	@ResponseBody
	public ReplyDataMode collentionsPageList(EmployedForm searchForm, HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();

		searchForm.setIsDelete("0");
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String, Object> orderMap = new HashMap<>();
		orderMap.put("employedNum", "desc");
		criteriaQuery.setOrder(orderMap);

		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());


		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<EmployedEntity> employeds = mode.getResult();

		List<EmployedVO> employedVOs = new ArrayList<EmployedVO>();

		for (EmployedEntity employedEntity:employeds) {
			EmployedVO employedVO = new EmployedVO();
			employedVO.copyEntity(employedEntity);
			/* 设置null 减少页面数据传输 */
			employedVO.setEmployedResponsibilities(null);
			employedVO.setEmployedRequirements(null);
			employedVOs.add(employedVO);

		}
		mode.setResult(employedVOs);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);


		return replyDataMode;
	}
	/**
	 * 最受关注企业排名
	 * SELECT u.user_id,u.display_img,e.employed_name,u.compancy_name,sum(e.employed_num) s
	 FROM dxs_employed e ,dxs_user_compancy u
	 WHERE e.user_id = u.user_id
	 and e.os_id =1
	 AND e.is_delete = 0
	 AND u.is_delete = 0
	 GROUP BY u.user_id
	 ORDER BY s desc
	 LIMIT 0,4
	 *
	 * */

	//最受关注企业列表
	@RequestMapping("/collentionsCompanyList.do")
	@ResponseBody
	public ReplyDataMode collentionsCompanyList(EmployedForm searchForm, HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();

		int pageNo = 1;
		int pageSize = Integer.parseInt(searchForm.getPageSize());

		String sql = " SELECT u.id,u.user_id,u.display_img,e.employed_name,u.compancy_name,sum(e.employed_num) s" +
				" FROM dxs_employed e ,dxs_user_compancy u" +
				" WHERE e.user_id = u.user_id" +
				" and e.os_id = '" +
				 searchForm.getOsId()+
				"' AND e.is_delete = 0" +
				" AND u.is_delete = 0" +
				" GROUP BY u.user_id" +
				" ORDER BY s desc" +
				" LIMIT 0,"+
				pageSize;
		List<Object> list = this.sysService.findListbySql(sql);
		List result = new ArrayList();
		if(list!=null&&list.size()!=0){
			for(Object o:list){
				Map map = new HashMap();
				Object[] s = (Object[]) o;
				String id = s[0].toString();
				String userId = s[1].toString();
				String image = s[2].toString();
				map.put("id",id);
				map.put("userId",userId);
				map.put("logo",image);
				result.add(map);
			}
		}

		replyDataMode.setData(result);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);


		return replyDataMode;
	}
}

