package com.buss.footer.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.buss.common.redis.RedisClient;
import com.buss.common.redis.cache.CacheKey;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buss.common.entity.BannerEntity;
import com.buss.footer.trans.form.BannerSearchForm;
import com.buss.footer.trans.vo.BannerVO;
import com.buss.common.service.SysServiceI;


@Controller
@RequestMapping("/banner")
public class BannerController {
	
	@Autowired
	private SysServiceI sysService;
	@Resource
	private RedisClient redisClient;

	/**
	 * 分页查询
	 * @param searchForm
	 * @param request
	 * @return
	 */
	@RequestMapping({ "/list.do" })
	@ResponseBody
	public ReplyDataMode bannerList(BannerSearchForm searchForm, HttpServletRequest request)
			throws ServletException, IOException {
		ReplyDataMode j = new ReplyDataMode();

		String key = "";
		if("on".equals(CacheKey.REDIS_SWITCH)){
		/* 根据searchForm传递的参数，判断调用哪个缓存 */
			if ("1".equals(searchForm.getCid())) {
				key = CacheKey.INDEX_BANNER_1;
			}else
			if ("2".equals(searchForm.getCid())) {
				key = CacheKey.INDEX_BANNER_2;
			}else
			if ("3".equals(searchForm.getCid())) {
				key = CacheKey.INDEX_BANNER_3;
			}

			if(!"".equals(key)){
				// TODO 查Redis缓存
				Object cache = redisClient.get(key);
				if( cache != null){
					j.setData(cache);
					j.setStatusCode("201-读缓存");
					j.setSuccess(true);
					return j;
				}
			}
		}

		// 手动加条件
		searchForm.setStatus("0"); // 1正常
		CriteriaQuery cq = searchForm.getCriteriaQuery();
		
		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("sortid", "asc");
		cq.setOrder(orderMap);
		List<BannerEntity> entityList = this.sysService.list(cq);
		List<BannerVO> voList = new ArrayList<BannerVO>();
		BannerVO vo = null;
		for(BannerEntity e : entityList){
			vo = new BannerVO();
			vo.copyEntity(e);
			voList.add(vo);
		}
		
		j.setData(voList);
		j.setSuccess(true);

		if(!"".equals(key)){
			// TODO 设置Redis缓存
			Object obj = JSON.toJSON(voList);
			redisClient.put(key, obj);
		}

		return j;
	}
	
}
