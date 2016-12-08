package com.buss.entrepreneurshipcatalog.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.buss.entrepreneurshipcatalog.entity.EntrepreneurshipCatalogEntity;
import com.buss.entrepreneurshipcatalog.trans.form.EntrepreneurshipCatalogSearchForm;
import com.buss.entrepreneurshipcatalog.trans.vo.EntrepreneurshipCatalogVO;
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
public class EntrepreneurshipCatalogController {

	@Resource
	private SysServiceI sysService;

	@RequestMapping("/entrepreneurshipCatalogById.do")
	@ResponseBody
	public ReplyDataMode entrepreneurshipCatalogList(EntrepreneurshipCatalogSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("sort", "desc");
		criteriaQuery.setOrder(orderMap);
		List<EntrepreneurshipCatalogEntity> entrepreneurshipCatalogs = this.sysService.list(criteriaQuery);
		List<EntrepreneurshipCatalogVO> entrepreneurshipCatalogVOs = new ArrayList<EntrepreneurshipCatalogVO>();

		for (EntrepreneurshipCatalogEntity entrepreneurshipCatalog:entrepreneurshipCatalogs) {
			EntrepreneurshipCatalogVO entrepreneurshipCatalogVO = new EntrepreneurshipCatalogVO();
			entrepreneurshipCatalogVO.copyEntity(entrepreneurshipCatalog);
			entrepreneurshipCatalogVOs.add(entrepreneurshipCatalogVO);

		}
		replyDataMode.setData(entrepreneurshipCatalogVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
}

