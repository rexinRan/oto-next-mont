package com.buss.indexarticle.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.buss.common.redis.RedisClient;
import com.buss.common.redis.cache.CacheKey;
import com.buss.indexarticle.entity.IndexArticleEntity;
import com.buss.indexarticle.trans.form.IndexArticleSearchForm;
import com.buss.indexarticle.trans.vo.IndexArticleVO;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.jweb.core.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buss.common.service.SysServiceI;

/**
 * @author lu
 *
 */
@Controller
@RequestMapping("/indexArticle")
public class IndexArticleController {

	@Resource
	private SysServiceI sysService;
	@Resource
	private RedisClient redisClient;

	@RequestMapping("/list.do")
	@ResponseBody
	public ReplyDataMode indexArticleList(IndexArticleSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		List<IndexArticleEntity> indexArticle = this.sysService.list(criteriaQuery);
		List<IndexArticleVO> indexArticleVOs = new ArrayList<IndexArticleVO>();

		for (IndexArticleEntity indexArticleEntity:indexArticle) {
			IndexArticleVO indexArticleVO = new IndexArticleVO();
			indexArticleVO.copyEntity(indexArticleEntity);
			indexArticleVOs.add(indexArticleVO);

		}
		replyDataMode.setData(indexArticleVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}

	@RequestMapping("/pageList.do")
	@ResponseBody
	public ReplyDataMode indexArticlepageList(IndexArticleSearchForm searchForm, HttpServletRequest request){
		ReplyDataMode replyDataMode  = new ReplyDataMode();
		String key = "";
		if("on".equals(CacheKey.REDIS_SWITCH)){
			if(!StringUtil.isEmpty(searchForm.getIndexCatelogId())){
			/* 根据searchForm传递的参数，判断调用哪个缓存 */
				key = CacheKey.INDEX_ARTICLE_CAT_ + searchForm.getIndexCatelogId();
			}

			if(!"".equals(key)){
				// TODO 查Redis缓存
				Object cache = redisClient.get(key);
				if( cache != null){
					replyDataMode.setData(cache);
					replyDataMode.setStatusCode("201-读缓存");
					replyDataMode.setSuccess(true);
					return replyDataMode;
				}
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
		List<IndexArticleEntity> indexArticle = mode.getResult();

		List<IndexArticleVO> indexArticleVOs = new ArrayList<IndexArticleVO>();

		for (IndexArticleEntity indexArticleEntity:indexArticle) {
			IndexArticleVO indexArticleVO = new IndexArticleVO();
			indexArticleVO.copyEntity(indexArticleEntity);
			indexArticleVO.setArticleContents(null);
			indexArticleVOs.add(indexArticleVO);

		}

		mode.setResult(indexArticleVOs);
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

	@RequestMapping("/indexArticleById.do")
	@ResponseBody
	public ReplyDataMode indexArticleById(IndexArticleSearchForm searchForm,HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		List<IndexArticleEntity> indexArticle = this.sysService.list(criteriaQuery);
		List<IndexArticleVO> indexArticleVOs = new ArrayList<IndexArticleVO>();

		for (IndexArticleEntity indexArticleEntity:indexArticle) {
			IndexArticleVO indexArticleVO = new IndexArticleVO();
			indexArticleVO.copyEntity(indexArticleEntity);
			indexArticleVOs.add(indexArticleVO);

		}
		replyDataMode.setData(indexArticleVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}



}

