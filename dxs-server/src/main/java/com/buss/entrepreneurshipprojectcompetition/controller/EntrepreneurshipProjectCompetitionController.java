package com.buss.entrepreneurshipprojectcompetition.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import com.alibaba.fastjson.JSON;
import com.buss.common.redis.RedisClient;
import com.buss.common.redis.cache.CacheKey;
import com.buss.entrepreneurshipprojectcompetition.entity.EntrepreneurshipProjectCompetitionEntity;
import com.buss.entrepreneurshipprojectcompetition.trans.form.EntrepreneurshipProjectCompetitionSearchForm;
import com.buss.entrepreneurshipprojectcompetition.trans.vo.EntrepreneurshipProjectCompetitionVO;
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
@RequestMapping("/entrepreneurshipProjectCompetition")
public class EntrepreneurshipProjectCompetitionController {

	@Resource
	private SysServiceI sysService;
	@Resource
	private RedisClient redisClient;

	@RequestMapping("/list.do")
	@ResponseBody
	public ReplyDataMode entrepreneurshipList(EntrepreneurshipProjectCompetitionSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("emoloyedSort","desc");
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		List<EntrepreneurshipProjectCompetitionEntity> entrepreneurshipprojectCompetitions = this.sysService.list(criteriaQuery);
		List<EntrepreneurshipProjectCompetitionVO> entrepreneurshipProjectCompetitionVOs = new ArrayList<EntrepreneurshipProjectCompetitionVO>();

		for (EntrepreneurshipProjectCompetitionEntity entrepreneurshipProjectCompetitionEntity:entrepreneurshipprojectCompetitions) {
			EntrepreneurshipProjectCompetitionVO entrepreneurshipProjectCompetitionVO = new EntrepreneurshipProjectCompetitionVO();
			entrepreneurshipProjectCompetitionVO.copyEntity(entrepreneurshipProjectCompetitionEntity);
			entrepreneurshipProjectCompetitionVOs.add(entrepreneurshipProjectCompetitionVO);

		}
		replyDataMode.setData(entrepreneurshipProjectCompetitionVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
	@RequestMapping("/pageList.do")
	@ResponseBody
	public ReplyDataMode entrepreneurshipProjectCompetitionPageList(EntrepreneurshipProjectCompetitionSearchForm searchForm, HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();
		String key = "";
		if ("on".equals(CacheKey.REDIS_SWITCH)) {
        /* 根据searchForm传递的参数，判断调用哪个缓存 */
			key = CacheKey.INDEX_PROJECT;
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
		List<EntrepreneurshipProjectCompetitionEntity> entrepreneurshipprojectCompetitions = mode.getResult();

		List<EntrepreneurshipProjectCompetitionVO> entrepreneurshipProjectCompetitionVOs = new ArrayList<EntrepreneurshipProjectCompetitionVO>();

		for (EntrepreneurshipProjectCompetitionEntity entrepreneurshipProjectCompetitionEntity:entrepreneurshipprojectCompetitions) {
			EntrepreneurshipProjectCompetitionVO entrepreneurshipProjectCompetitionVO = new EntrepreneurshipProjectCompetitionVO();
			entrepreneurshipProjectCompetitionVO.copyEntity(entrepreneurshipProjectCompetitionEntity);
			entrepreneurshipProjectCompetitionVOs.add(entrepreneurshipProjectCompetitionVO);

		}
		mode.setResult(entrepreneurshipProjectCompetitionVOs);
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


	@RequestMapping("/entrepreneurshipProjectCompetitionById.do")
	@ResponseBody
	public ReplyDataMode entrepreneurshipProjectCompetitionById(EntrepreneurshipProjectCompetitionSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		List<EntrepreneurshipProjectCompetitionEntity> entrepreneurshipprojectCompetitions = this.sysService.list(criteriaQuery);
		List<EntrepreneurshipProjectCompetitionVO> entrepreneurshipProjectCompetitionVOs = new ArrayList<EntrepreneurshipProjectCompetitionVO>();

		for (EntrepreneurshipProjectCompetitionEntity entrepreneurshipProjectCompetitionEntity:entrepreneurshipprojectCompetitions) {
			EntrepreneurshipProjectCompetitionVO entrepreneurshipProjectCompetitionVO = new EntrepreneurshipProjectCompetitionVO();
			entrepreneurshipProjectCompetitionVO.copyEntity(entrepreneurshipProjectCompetitionEntity);
			entrepreneurshipProjectCompetitionVOs.add(entrepreneurshipProjectCompetitionVO);

		}
		replyDataMode.setData(entrepreneurshipProjectCompetitionVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
}

