package com.buss.common.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.auth.transfer.vo.authen.AuthUserVOAdmin;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import com.buss.common.entity.HxArticle;
import com.buss.common.service.SysServiceI;
import com.buss.member.entity.GeneralUserEntity;
import com.buss.member.transfer.form.member.MemberRegistForm;
import com.buss.member.util.MemberUtil;


@Controller
public class TestController {
	
	@Autowired
	private SysServiceI sysService;

	@RequestMapping({ "/test.do" })
	public void test(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		System.out.println("test success");
	}
	
	@RequestMapping({ "/testjson.do" })
	@ResponseBody
	public ReplyDataMode serverList(HttpServletRequest req){
		ReplyDataMode j = new ReplyDataMode();

		List<Map> mapList = new ArrayList<Map>();
		Map map = null;
		String url = "1234";
		
		String sql = "SELECT NOW()";
		List<String> dataList = sysService.findListbySql(sql);
		String dataStr = "";
		if(!dataList.isEmpty()){
			for(Object o : dataList){					
				dataStr = o.toString();
				System.out.println(dataStr);
				map=new HashMap();
				map.put("text", dataStr);
				map.put("href", url);
				mapList.add(map);
			}
		}
		
		Map resultMap = new HashMap();
		resultMap.put("list", mapList);
		Object obj = JSON.toJSON(resultMap);
		
		j.setData(obj);
		j.setSuccess(true);
		return j;
	}
	
/*
	@RequestMapping({ "/ge.do" })
	@ResponseBody
	public ReplyDataMode order(ArticleSearchForm searchForm){
		ReplyDataMode j = new ReplyDataMode();

		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();
		criteriaQuery.ge("levelclass", 4);
		criteriaQuery.add();
		Map<String, Object> orderMap = new HashMap<>();
		criteriaQuery.setOrder(orderMap);

		List<HxArticle> articles = this.sysService.list(criteriaQuery);
		// 封装返回数据
		List<ArticleVO> articleVOs = new ArrayList<>();
		ArticleVO articleVO = null;
		for(HxArticle ha : articles) {
			articleVO = new ArticleVO();
			articleVO.copyEntity(ha);
			articleVOs.add(articleVO);
		}
		j.setData(articleVOs);
		j.setSuccess(true);
		return j;
	}
*/


	@RequestMapping(value = "/test/getUser")
	@ResponseBody
	public ReplyDataMode heart(){
		ReplyDataMode j = new ReplyDataMode();
		j.setSuccess(true);

		Subject currentUser = SecurityUtils.getSubject();
		if(currentUser.isAuthenticated()){
			AuthUserVOAdmin  vo = (AuthUserVOAdmin) currentUser.getSession().getAttribute("userInfoAdmin");
			System.out.println("#### sys/heart user: "+vo.getUsername());
//			AdminEntity userEntity = this.sysService.getEntity(AdminEntity.class, vo.getId());


			j.setSuccess(true);
		} else {
			j.setSuccess(false);
			j.setData("no");
		}
		return j;
	}
	
}
