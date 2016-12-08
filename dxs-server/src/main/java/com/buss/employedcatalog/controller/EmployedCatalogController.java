package com.buss.employedcatalog.controller;
import com.buss.common.service.SysServiceI;
import com.buss.employedcatalog.entity.EmployedCatalogEntity;
import com.buss.employedcatalog.trans.form.EmployedCatalogSearchForm;
import com.buss.employedcatalog.trans.vo.EmployedCatalogVO;
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
 * @author lu
 *
 */
@Controller
@RequestMapping("/employedCatelog")
public class EmployedCatalogController {

	@Resource
	private SysServiceI sysService;

	@RequestMapping("/biglist.do")
	@ResponseBody
	public ReplyDataMode employedCatalogBigList(EmployedCatalogSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		searchForm.setPid("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

//		Map<String,Object> orderMap = new HashMap<String,Object>();
//		orderMap.put("sort", "asc");
//		criteriaQuery.setOrder(orderMap);
		List<EmployedCatalogEntity> employedCatelogs = this.sysService.list(criteriaQuery);
		List<EmployedCatalogVO> employedCatelogVOs = new ArrayList<EmployedCatalogVO>();

		for (EmployedCatalogEntity employedCatelog:employedCatelogs) {
			EmployedCatalogVO employedCatelogVO = new EmployedCatalogVO();
			employedCatelogVO.copyEntity(employedCatelog);
			employedCatelogVOs.add(employedCatelogVO);

		}
		replyDataMode.setData(employedCatelogVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
	@RequestMapping("/list.do")
	@ResponseBody
	public ReplyDataMode employedCatalogList(EmployedCatalogSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

//		Map<String,Object> orderMap = new HashMap<String,Object>();
//		orderMap.put("sort", "asc");
//		criteriaQuery.setOrder(orderMap);
		List<EmployedCatalogEntity> employedCatelogs = this.sysService.list(criteriaQuery);
		List<EmployedCatalogVO> employedCatelogVOs = new ArrayList<EmployedCatalogVO>();

		for (EmployedCatalogEntity employedCatelog:employedCatelogs) {
			EmployedCatalogVO employedCatelogVO = new EmployedCatalogVO();
			employedCatelogVO.copyEntity(employedCatelog);
			employedCatelogVOs.add(employedCatelogVO);

		}
		replyDataMode.setData(employedCatelogVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
	@RequestMapping("/employedCatalogIntroduction.do")
	@ResponseBody
	public ReplyDataMode employedCatalogIntroduction(EmployedCatalogSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		searchForm.setPid("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

//		Map<String,Object> orderMap = new HashMap<String,Object>();
//		orderMap.put("sort", "asc");
//		criteriaQuery.setOrder(orderMap);
		List<EmployedCatalogEntity> employedCatalogs = this.sysService.list(criteriaQuery);
		List<EmployedCatalogVO> employedCatalogVOs = new ArrayList<EmployedCatalogVO>();

		for (EmployedCatalogEntity employedCatalog:employedCatalogs) {
			EmployedCatalogVO employedCatalogVO = new EmployedCatalogVO();
			employedCatalogVO.copyEntity(employedCatalog);
			employedCatalogVOs.add(employedCatalogVO);

		}
		replyDataMode.setData(employedCatalogs.get(0).getEmployedIntroduction());
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
}

