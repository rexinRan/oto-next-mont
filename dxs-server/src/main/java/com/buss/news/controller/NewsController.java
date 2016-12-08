package com.buss.news.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.buss.common.redis.RedisClient;
import com.buss.common.redis.cache.CacheKey;
import com.buss.news.entity.NewsEntity;
import com.buss.news.trans.form.NewsSearchForm;
import com.buss.news.trans.vo.NewsVO;
import com.buss.news.trans.vo.SimpleNewsVO;
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
@RequestMapping("/news")
public class NewsController {

	@Resource
	private SysServiceI sysService;
	@Resource
	private RedisClient redisClient;

	@RequestMapping("/list.do")
	@ResponseBody
	public ReplyDataMode newsList(NewsSearchForm searchForm, HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();
		String key = "";
		if("on".equals(CacheKey.REDIS_SWITCH)){
			if("1".equals(searchForm.getIsSpecial())){
			/* 根据searchForm传递的参数，判断调用哪个缓存 */
				key = CacheKey.INDEX_NEWS_SPECIAL;
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

		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("newPublishTime", "desc");
		criteriaQuery.setOrder(orderMap);

		List<NewsEntity> news = this.sysService.list(criteriaQuery);
		List<NewsVO> newsVOs = new ArrayList<NewsVO>();

		for (NewsEntity newsEntity:news) {
			NewsVO newsVO = new NewsVO();
			newsVO.copyEntity(newsEntity);
			newsVOs.add(newsVO);

		}
		replyDataMode.setData(newsVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		if(!"".equals(key)){
			// TODO 设置Redis缓存
			Object obj = JSON.toJSON(newsVOs);
			redisClient.put(key, obj);
		}
		return replyDataMode;
	}

	@RequestMapping("/indexList.do")
	@ResponseBody
	public ReplyDataMode indexNewsList(NewsSearchForm searchForm, HttpServletRequest request){
		ReplyDataMode replyDataMode  = new ReplyDataMode();

		String key = "";
		if("on".equals(CacheKey.REDIS_SWITCH)){
			if(!StringUtil.isEmpty(searchForm.getNewCatelogId())){
			/* 根据searchForm传递的参数，判断调用哪个缓存 */
				key = CacheKey.INDEX_NEWS_CAT_ + searchForm.getNewCatelogId();
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

		// 手动加条件
		searchForm.setIsDelete("0");
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String, Object> orderMap = new HashMap<>();
		orderMap.put("newPublishTime", "desc");
		criteriaQuery.setOrder(orderMap);

		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());

		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<NewsEntity> news = mode.getResult();

		List<NewsVO> newsVOs = new ArrayList<NewsVO>();

		for (NewsEntity newsEntity:news) {
			NewsVO newsVO = new NewsVO();
			newsVO.copyEntity(newsEntity);
			newsVO.setNewContents(null);
			newsVOs.add(newsVO);

		}

		mode.setResult(newsVOs);
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

	@RequestMapping("/pageList.do")
	@ResponseBody
	public ReplyDataMode newspageList(NewsSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode  = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String, Object> orderMap = new HashMap<>();
		orderMap.put("newPublishTime", "desc");
		criteriaQuery.setOrder(orderMap);

		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());

		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<NewsEntity> news = mode.getResult();

		List<NewsVO> newsVOs = new ArrayList<NewsVO>();

		for (NewsEntity newsEntity:news) {
			NewsVO newsVO = new NewsVO();
			newsVO.copyEntity(newsEntity);
			newsVOs.add(newsVO);

		}

		mode.setResult(newsVOs);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}

	@RequestMapping("/newsById.do")
	@ResponseBody
	public ReplyDataMode newsById(NewsSearchForm searchForm,HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		List<NewsEntity> news = this.sysService.list(criteriaQuery);
		List<NewsVO> newsVOs = new ArrayList<NewsVO>();

		for (NewsEntity newsEntity:news) {
			NewsVO newsVO = new NewsVO();
			newsVO.copyEntity(newsEntity);
			newsVOs.add(newsVO);

		}
		replyDataMode.setData(newsVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}

	/**
	 * 获取新闻的上一篇，下一篇
	 */
	@RequestMapping("/relationlist.do")
	@ResponseBody
	public ReplyDataMode newsRelationList(NewsSearchForm searchForm, HttpServletRequest request) {
		String myid = searchForm.getId();

		ReplyDataMode dataMode = new ReplyDataMode();

		String sql ="select * from dxs_news where is_delete=0 and new_catelog_id ="
				+ searchForm.getNewCatelogId()
				+" order by new_publish_time desc";

		List news = this.sysService.findListbySql(sql);

		int preId = 0;
		int nextId = 0;

		for(int i=0;i<news.size();i++){
			Object [] obj = (Object[])news.get(i);

			if(myid.equals(obj[0].toString())){
				preId = i+1;
				nextId = i-1;
			}
		}


		// 封装返回数据
		Map<String, Object> temp = new HashMap<>();
		SimpleNewsVO next = new SimpleNewsVO();
		if (nextId != -1) {
			Object [] obj = (Object[])news.get(nextId);
			next.setId(obj[0].toString());
			next.setNewTitle(obj[2].toString());
		} else {
			next = (null);
		}
		SimpleNewsVO pre = new SimpleNewsVO();
		if (preId != news.size()) {
			Object [] obj = (Object[])news.get(preId);
			pre.setId(obj[0].toString());
			pre.setNewTitle(obj[2].toString());
		} else {
			pre = (null);
		}

		temp.put("pre", pre);
		temp.put("next", next);

		dataMode.setData(temp);
		dataMode.setStatusCode("200");
		dataMode.setSuccess(true);

		return dataMode;
	}

}

