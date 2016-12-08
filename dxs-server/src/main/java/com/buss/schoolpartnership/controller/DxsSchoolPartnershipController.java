package com.buss.schoolpartnership.controller;
import com.alibaba.fastjson.JSON;
import com.buss.common.redis.RedisClient;
import com.buss.common.redis.cache.CacheKey;
import com.buss.common.service.SysServiceI;
import com.buss.schoolpartnership.entity.DxsSchoolPartnershipEntity;
import com.buss.schoolpartnership.entity.SchoolPartnershipImgsEntity;
import com.buss.schoolpartnership.trans.form.DxsSchoolPartnershipSearchForm;
import com.buss.schoolpartnership.trans.form.SchoolPartnershipImgsSearchForm;
import com.buss.schoolpartnership.trans.vo.DxsSchoolPartnershipVO;
import com.buss.schoolpartnership.trans.vo.SchoolPartnershipImgsVO;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**   
 * @Title: Controller
 * @Description: dxs_school_partnership
 * @author dq
 * @date 2016-07-14 16:06:05
 * @version V1.0   
 *
 */

@Controller
	@RequestMapping("/SchoolPartnershipController")
public class DxsSchoolPartnershipController {
	@Resource
	private SysServiceI sysService;
	@Resource
	private RedisClient redisClient;

	@RequestMapping("/pageList.do")
	@ResponseBody
	public ReplyDataMode homePage(DxsSchoolPartnershipSearchForm searchForm, HttpServletRequest request){
//		try {
//
//			String schoolAddrees = new String(searchForm.getSchoolRealAddress().getBytes("iso-8859-1"), "utf-8");
//			searchForm.setSchoolRealAddress(schoolAddrees);
//		}catch (Exception e){
//		}

		ReplyDataMode replyDataMode = new ReplyDataMode();
		String key = "";
		if ("on".equals(CacheKey.REDIS_SWITCH)) {
			key = CacheKey.INDEX_HEZUO_SCHOOL;
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
		List<DxsSchoolPartnershipEntity> userCompancys = mode.getResult();

		List<DxsSchoolPartnershipVO> dxsSchoolPartnershipVOs = new ArrayList<DxsSchoolPartnershipVO>();

		for (DxsSchoolPartnershipEntity dxsSchoolPartnershipEntity:userCompancys) {
			DxsSchoolPartnershipVO dxsSchoolPartnershipVO = new DxsSchoolPartnershipVO();
			dxsSchoolPartnershipVO.copyEntity(dxsSchoolPartnershipEntity);
//			dxsSchoolPartnershipVO.setSchoolIntroduce(null);
//			dxsSchoolPartnershipVO.setSchoolDisplay(null);
//			dxsSchoolPartnershipVO.setSchoolScenery(null);
			String  replace=dxsSchoolPartnershipVO.getSchoolRealAddress().replace("#","");
			dxsSchoolPartnershipVO.setSchoolRealAddress(replace);
			String  replace2=dxsSchoolPartnershipVO.getSchoolRealAddress().replace("市辖区","");
			dxsSchoolPartnershipVO.setSchoolRealAddress(replace2);
			dxsSchoolPartnershipVOs.add(dxsSchoolPartnershipVO);

		}
		mode.setResult(dxsSchoolPartnershipVOs);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		if (key != "") {
			// TODO 设置Redis缓存
			Object obj = JSON.toJSON(mode);
			redisClient.put(key, obj);
		}
		return replyDataMode;
	}
	@RequestMapping("/SchoolPartnershipById.do")
	@ResponseBody
	public ReplyDataMode findco(DxsSchoolPartnershipSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		List<DxsSchoolPartnershipEntity> news = this.sysService.list(criteriaQuery);
		List<DxsSchoolPartnershipVO> SchoolPartnershipVOs = new ArrayList<DxsSchoolPartnershipVO>();

		for (DxsSchoolPartnershipEntity SchoolPartnershipEntity:news) {
			DxsSchoolPartnershipVO SchoolPartnershipVO = new DxsSchoolPartnershipVO();
			SchoolPartnershipVO.copyEntity(SchoolPartnershipEntity);
			String  replace=SchoolPartnershipVO.getSchoolRealAddress().replace("#","");
			SchoolPartnershipVO.setSchoolRealAddress(replace);
			String  replace2=SchoolPartnershipVO.getSchoolRealAddress().replace("市辖区","");
			SchoolPartnershipVO.setSchoolRealAddress(replace2);
			SchoolPartnershipVOs.add(SchoolPartnershipVO);

		}
		replyDataMode.setData(SchoolPartnershipVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}

	@RequestMapping("/schoolPartnerDetail.do")
	@ResponseBody
	public ReplyDataMode detailSPage(DxsSchoolPartnershipSearchForm searchForm, HttpServletRequest request){
		try {
//			 String schoolAddrees = new String(searchForm.getSchoolRealAddress().getBytes("iso-8859-1"), "utf-8");
//			 searchForm.setSchoolRealAddress(schoolAddrees);
		}catch (Exception e){

		}

		ReplyDataMode replyDataMode = new ReplyDataMode();
		searchForm.setIsDelete("0");
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String, Object> orderMap = new HashMap<>();
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());


		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<DxsSchoolPartnershipEntity> userCompancys = mode.getResult();

		List<DxsSchoolPartnershipVO> dxsSchoolPartnershipVOs = new ArrayList<DxsSchoolPartnershipVO>();

		for (DxsSchoolPartnershipEntity dxsSchoolPartnershipEntity:userCompancys) {
			DxsSchoolPartnershipVO dxsSchoolPartnershipVO = new DxsSchoolPartnershipVO();
			dxsSchoolPartnershipVO.copyEntity(dxsSchoolPartnershipEntity);
//			dxsSchoolPartnershipVO.setSchoolIntroduce(null);
//			dxsSchoolPartnershipVO.setSchoolDisplay(null);
//			dxsSchoolPartnershipVO.setSchoolScenery(null);
			String  replace=dxsSchoolPartnershipVO.getSchoolRealAddress().replace("#","");
			dxsSchoolPartnershipVO.setSchoolRealAddress(replace);
			String  replace2=dxsSchoolPartnershipVO.getSchoolRealAddress().replace("市辖区","");
			dxsSchoolPartnershipVO.setSchoolRealAddress(replace2);
			dxsSchoolPartnershipVOs.add(dxsSchoolPartnershipVO);
		}

		mode.setResult(dxsSchoolPartnershipVOs);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}

	@RequestMapping("/schoolPartnerDetailImgs.do")
	@ResponseBody
	public ReplyDataMode imgs(DxsSchoolPartnershipSearchForm searchForm,Integer curPage,Integer pageSize, HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();

		Map<String,List> schoolMap = new HashMap<String,List>();
		List<DxsSchoolPartnershipVO> schoolPartnershipVos = null;
		List<SchoolPartnershipImgsVO> schoolPartnershipImgsEntityVos = null;

		DxsSchoolPartnershipEntity schoolPartnershipEntity = this.sysService.get(DxsSchoolPartnershipEntity.class,searchForm.getId());
		if (schoolPartnershipEntity != null && schoolPartnershipEntity.getIsDelete() != 1 && curPage != null  && pageSize != null){
			schoolPartnershipVos = new ArrayList<DxsSchoolPartnershipVO>();
			DxsSchoolPartnershipVO dxsSchoolPartnershipVO = new DxsSchoolPartnershipVO();
			dxsSchoolPartnershipVO.copyEntity(schoolPartnershipEntity);
			String  replace=dxsSchoolPartnershipVO.getSchoolRealAddress().replace("#","");
			dxsSchoolPartnershipVO.setSchoolRealAddress(replace);
			String  replace2=dxsSchoolPartnershipVO.getSchoolRealAddress().replace("市辖区","");
			dxsSchoolPartnershipVO.setSchoolRealAddress(replace2);
			schoolPartnershipVos.add(dxsSchoolPartnershipVO);

			// 合作院校图片集查询
			SchoolPartnershipImgsSearchForm schoolPartnershipImgsSearchForm = new SchoolPartnershipImgsSearchForm();
			schoolPartnershipImgsSearchForm.setSpId(schoolPartnershipEntity.getId());
			schoolPartnershipImgsSearchForm.setIsDelete("0");
			CriteriaQuery criteriaQuery = schoolPartnershipImgsSearchForm.getCriteriaQuery();
			criteriaQuery.addOrder("createTime","desc");
			criteriaQuery.addOrder("updateTime","desc");

			PageMode mode = this.sysService.list4page(criteriaQuery,curPage,pageSize);
			List<SchoolPartnershipImgsEntity> schoolPartnershipImgsEntityList = mode.getResult();
			schoolPartnershipImgsEntityVos = new ArrayList<SchoolPartnershipImgsVO>();
			if (schoolPartnershipImgsEntityList != null && schoolPartnershipImgsEntityList.size() > 0){
				for (SchoolPartnershipImgsEntity spie:schoolPartnershipImgsEntityList){
					SchoolPartnershipImgsVO schoolPartnershipImgsVO = new SchoolPartnershipImgsVO();
					schoolPartnershipImgsVO.copyEntity(spie);
					schoolPartnershipImgsEntityVos.add(schoolPartnershipImgsVO);
				}
			}
		}
		schoolMap.put("schoolPartnershipVos", schoolPartnershipVos);
		schoolMap.put("schoolPartnershipImgsEntityVos",schoolPartnershipImgsEntityVos);

		replyDataMode.setData(schoolMap);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}

}
