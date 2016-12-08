/**
 * Copyright  2016
 *
 * 	All right reserved.
 *
 *	Created on  2016年3月8日 下午5:23:54
 * 
 */
package com.buss.footer.controller;

import com.alibaba.fastjson.JSON;
import com.buss.common.entity.HxCompany;
import com.buss.common.redis.RedisClient;
import com.buss.common.redis.cache.CacheKey;
import com.buss.common.service.SysServiceI;
import com.buss.footer.trans.form.HxCompanySearchForm;
import com.buss.footer.trans.vo.CompanyVo;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuh
 *
 */
@Controller
@RequestMapping("/comp")
public class CompController {

	@Resource
	private SysServiceI sysService;
	/*
	@RequestMapping("/list.do")
	@ResponseBody
	public ReplyDataMode serviceList(HxCompanySearchForm searchForm, HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();
		
		List<HxCompany> companys = this.sysService.list(criteriaQuery);
		List<CompanyVo> companyVos = new ArrayList<>();
		CompanyVo companyVo = new CompanyVo();
		
		for(HxCompany company : companys){
			companyVo.copyEntity(company);
			companyVos.add(companyVo);
		}
		replyDataMode.setData(companys);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);
		
		return replyDataMode;
	}
	*/

	@Resource
	private RedisClient redisClient;

	@RequestMapping("/list.do")
	@ResponseBody
	public ReplyDataMode serviceList(HxCompanySearchForm searchForm, HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();
		String key = "";
		if("on".equals(CacheKey.REDIS_SWITCH)){
			key = CacheKey.INDEX_FOOTER_COMP;
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

		List<HxCompany> companys = this.sysService.list(criteriaQuery);
		List<CompanyVo> companyVos = new ArrayList<>();
		CompanyVo companyVo = new CompanyVo();

		for(HxCompany company : companys){
			companyVo.copyEntity(company);
			companyVos.add(companyVo);
		}
		replyDataMode.setData(companys);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		// TODO 设置Redis缓存
		if(!"".equals(key)){
			Object obj = JSON.toJSON(companys);
			redisClient.put(key, obj);
		}

		return replyDataMode;

	}
}
