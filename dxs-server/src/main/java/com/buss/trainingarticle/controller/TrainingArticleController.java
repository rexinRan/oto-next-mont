package com.buss.trainingarticle.controller;
import com.alibaba.fastjson.JSON;
import com.buss.common.redis.RedisClient;
import com.buss.common.redis.cache.CacheKey;
import com.buss.common.service.SysServiceI;
import com.buss.trainingarticle.entity.TrainingArticleEntity;
import com.buss.trainingarticle.trans.form.TrainingArticleSearchForm;
import com.buss.trainingarticle.trans.vo.TrainingArticleVO;
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
 * @author lu
 *
 */
@Controller
@RequestMapping("/trainingArticle")
public class TrainingArticleController {

	@Resource
	private SysServiceI sysService;
	@Resource
	private RedisClient redisClient;

	@RequestMapping("/list.do")
	@ResponseBody
	public ReplyDataMode trainingList(TrainingArticleSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("trainingSort","asc");
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		List<TrainingArticleEntity> trainingarticles = this.sysService.list(criteriaQuery);
		List<TrainingArticleVO> trainingArticleVOs = new ArrayList<TrainingArticleVO>();

		for (TrainingArticleEntity trainingArticleEntity:trainingarticles) {
			TrainingArticleVO trainingArticleVO = new TrainingArticleVO();
			trainingArticleVO.copyEntity(trainingArticleEntity);
			trainingArticleVOs.add(trainingArticleVO);

		}
		replyDataMode.setData(trainingArticleVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
	@RequestMapping("/pageList.do")
	@ResponseBody
	public ReplyDataMode trainingArticlePageList(TrainingArticleSearchForm searchForm, HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();
		String key = "";
		if ("on".equals(CacheKey.REDIS_SWITCH)) {
        /* 根据searchForm传递的参数，判断调用哪个缓存 */
			key = CacheKey.INDEX_ARTICLE_TRAIN;
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
		orderMap.put("trainingSort","desc");
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());


		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<TrainingArticleEntity> trainingarticles = mode.getResult();

		List<TrainingArticleVO> trainingArticleVOs = new ArrayList<TrainingArticleVO>();

		for (TrainingArticleEntity trainingArticleEntity:trainingarticles) {
			TrainingArticleVO trainingArticleVO = new TrainingArticleVO();
			trainingArticleVO.copyEntity(trainingArticleEntity);
			trainingArticleVO.setTrainingContents(null);
			trainingArticleVOs.add(trainingArticleVO);

		}
		mode.setResult(trainingArticleVOs);
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


	@RequestMapping("/trainingArticleById.do")
	@ResponseBody
	public ReplyDataMode trainingArticleById(TrainingArticleSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		List<TrainingArticleEntity> trainingarticles = this.sysService.list(criteriaQuery);
		List<TrainingArticleVO> trainingArticleVOs = new ArrayList<TrainingArticleVO>();

		for (TrainingArticleEntity trainingArticleEntity:trainingarticles) {
			TrainingArticleVO trainingArticleVO = new TrainingArticleVO();
			trainingArticleVO.copyEntity(trainingArticleEntity);
			trainingArticleVOs.add(trainingArticleVO);

		}
		replyDataMode.setData(trainingArticleVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
}

