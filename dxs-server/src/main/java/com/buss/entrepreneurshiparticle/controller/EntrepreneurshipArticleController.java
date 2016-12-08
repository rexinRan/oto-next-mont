package com.buss.entrepreneurshiparticle.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.alibaba.fastjson.JSON;
import com.buss.common.redis.RedisClient;
import com.buss.common.redis.cache.CacheKey;
import com.buss.entrepreneurshiparticle.entity.EntrepreneurshipArticleEntity;
import com.buss.entrepreneurshiparticle.trans.form.EntrepreneurshipArticleSearchForm;
import com.buss.entrepreneurshiparticle.trans.vo.EntrepreneurshipArticleVO;
import com.buss.entrepreneurshiparticle.trans.vo.SimpleArtiicleVO;
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
@RequestMapping("/entrepreneurshipArticle")
public class EntrepreneurshipArticleController {

	@Resource
	private SysServiceI sysService;
	@Resource
	private RedisClient redisClient;

	@RequestMapping("/list.do")
	@ResponseBody
	public ReplyDataMode entrepreneurshipList(EntrepreneurshipArticleSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("entrepreneurshipSort","desc");
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		List<EntrepreneurshipArticleEntity> entrepreneurshiparticles = this.sysService.list(criteriaQuery);
		List<EntrepreneurshipArticleVO> entrepreneurshipArticleVOs = new ArrayList<EntrepreneurshipArticleVO>();

		for (EntrepreneurshipArticleEntity entrepreneurshipArticleEntity:entrepreneurshiparticles) {
			EntrepreneurshipArticleVO entrepreneurshipArticleVO = new EntrepreneurshipArticleVO();
			entrepreneurshipArticleVO.copyEntity(entrepreneurshipArticleEntity);
			entrepreneurshipArticleVOs.add(entrepreneurshipArticleVO);

		}
		replyDataMode.setData(entrepreneurshipArticleVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
	@RequestMapping("/pageList.do")
	@ResponseBody
	public ReplyDataMode entrepreneurshipArticlePageList(EntrepreneurshipArticleSearchForm searchForm, HttpServletRequest request){
		ReplyDataMode replyDataMode = new ReplyDataMode();
		String key = "";
		if("on".equals(CacheKey.REDIS_SWITCH)){
			key = CacheKey.INDEX_JIDI;
			// TODO 查Redis缓存
			Object cache = redisClient.get(key);
			if( cache != null){
				replyDataMode.setData(cache);
				replyDataMode.setStatusCode("201-读缓存");
				replyDataMode.setSuccess(true);
				return replyDataMode;
			}
		}
		searchForm.setIsDelete("0");
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String, Object> orderMap = new HashMap<>();
		orderMap.put("entrepreneurshipSort","asc");
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());


		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<EntrepreneurshipArticleEntity> entrepreneurshiparticles = mode.getResult();

		List<EntrepreneurshipArticleVO> entrepreneurshipArticleVOs = new ArrayList<EntrepreneurshipArticleVO>();

		for (EntrepreneurshipArticleEntity entrepreneurshipArticleEntity:entrepreneurshiparticles) {
			EntrepreneurshipArticleVO entrepreneurshipArticleVO = new EntrepreneurshipArticleVO();
			entrepreneurshipArticleVO.copyEntity(entrepreneurshipArticleEntity);
			entrepreneurshipArticleVO.setEntrepreneurshipContents(null);
			entrepreneurshipArticleVOs.add(entrepreneurshipArticleVO);

		}
		mode.setResult(entrepreneurshipArticleVOs);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		// TODO 设置Redis缓存
		if(!"".equals(key)){
			Object obj = JSON.toJSON(mode);
			redisClient.put(key, obj);
		}
		return replyDataMode;
	}


	@RequestMapping("/entrepreneurshipArticleById.do")
	@ResponseBody
	public ReplyDataMode entrepreneurshipArticleById(EntrepreneurshipArticleSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		List<EntrepreneurshipArticleEntity> entrepreneurshiparticles = this.sysService.list(criteriaQuery);
		List<EntrepreneurshipArticleVO> entrepreneurshipArticleVOs = new ArrayList<EntrepreneurshipArticleVO>();

		for (EntrepreneurshipArticleEntity entrepreneurshipArticleEntity:entrepreneurshiparticles) {
			EntrepreneurshipArticleVO entrepreneurshipArticleVO = new EntrepreneurshipArticleVO();
			entrepreneurshipArticleVO.copyEntity(entrepreneurshipArticleEntity);
			entrepreneurshipArticleVOs.add(entrepreneurshipArticleVO);

		}
		replyDataMode.setData(entrepreneurshipArticleVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}

	/**
	 * 获取文章的上一篇，下一篇
	 */
	@RequestMapping("/relationlist.do")
	@ResponseBody
	public ReplyDataMode newsRelationList(EntrepreneurshipArticleSearchForm searchForm, HttpServletRequest request) {
		String myid = searchForm.getId();

		ReplyDataMode dataMode = new ReplyDataMode();

		String sql ="select * from dxs_entrepreneurship_article where is_delete=0 and Entrepreneurship_catelog_id ="
				+ searchForm.getEntrepreneurshipCatelogId()
				+" order by Entrepreneurship_sort desc,create_time desc";

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
		SimpleArtiicleVO next = new SimpleArtiicleVO();
		if (nextId != -1) {
			Object [] obj = (Object[])news.get(nextId);
			next.setId(obj[0].toString());
			next.setEntrepreneurshipTitle(obj[3].toString());
		} else {
			next = (null);
		}
		SimpleArtiicleVO pre = new SimpleArtiicleVO();
		if (preId != news.size()) {
			Object [] obj = (Object[])news.get(preId);
			pre.setId(obj[0].toString());
			pre.setEntrepreneurshipTitle(obj[3].toString());
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

		@RequestMapping("/listOne.do")
	@ResponseBody
	public ReplyDataMode entrepreneurshipListOne(EntrepreneurshipArticleSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("entrepreneurshipSort","desc");
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		List<EntrepreneurshipArticleEntity> entrepreneurshiparticles = this.sysService.list(criteriaQuery);
//		List<EntrepreneurshipArticleVO> entrepreneurshipArticleVOs = new ArrayList<EntrepreneurshipArticleVO>();
//
//		for (EntrepreneurshipArticleEntity entrepreneurshipArticleEntity:entrepreneurshiparticles) {
//			EntrepreneurshipArticleVO entrepreneurshipArticleVO = new EntrepreneurshipArticleVO();
//			entrepreneurshipArticleVO.copyEntity(entrepreneurshipArticleEntity);
//			entrepreneurshipArticleVOs.add(entrepreneurshipArticleVO);
//
//		}
		EntrepreneurshipArticleVO entrepreneurshipArticleVO = new EntrepreneurshipArticleVO();
		entrepreneurshipArticleVO.copyEntity(entrepreneurshiparticles.get(0));
		replyDataMode.setData(entrepreneurshipArticleVO);

		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
}

