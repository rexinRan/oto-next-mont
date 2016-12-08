/**
 * Copyright  2016
 *
 * 	All right reserved.
 *
 *	Created on  2016年3月8日 下午5:23:54
 * 
 */
package com.buss.footer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.buss.common.redis.RedisClient;
import com.buss.common.redis.cache.CacheKey;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buss.common.service.SysServiceI;
import com.buss.common.entity.HxSite;
import com.buss.footer.trans.form.HxSiteSearchForm;

/**
 * @author liuh
 *
 */
@Controller
public class SiteFController {

	@Resource
	private SysServiceI sysService;
	@Resource
	private RedisClient redisClient;
	
	@RequestMapping("/site/list.do")
	@ResponseBody
	public ReplyDataMode serviceList(HxSiteSearchForm searchForm, HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();
		String key = "";
		if("on".equals(CacheKey.REDIS_SWITCH)){
			key = CacheKey.INDEX_FOOTER_SITE;
			// TODO 查Redis缓存
			Object cache = redisClient.get(key);
			if( cache != null){
				replyDataMode.setData(cache);
				replyDataMode.setStatusCode("201-读缓存");
				replyDataMode.setSuccess(true);
				return replyDataMode;
			}
		}

		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();
		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("id", "asc");
		criteriaQuery.setOrder(orderMap);
		List<HxSite> sites = this.sysService.list(criteriaQuery);
		replyDataMode.setData(sites);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		if(!"".equals(key)){
			// TODO 设置Redis缓存
			Object obj = JSON.toJSON(sites);
			redisClient.put(key, obj);
		}
		return replyDataMode;
	}
}
