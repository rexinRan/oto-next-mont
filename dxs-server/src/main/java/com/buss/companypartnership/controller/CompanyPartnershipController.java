package com.buss.companypartnership.controller;
import com.buss.common.service.SysServiceI;
import com.buss.companypartnership.entity.CompanyPartnershipEntity;
import com.buss.companypartnership.trans.form.CompanyPartnershipSearchForm;
import com.buss.companypartnership.trans.vo.CompanyPartnershipVO;
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
 * @Title: Controller
 * @Description: dxs_company_partnership
 * @author lu
 * @date 2016-06-03 10:42:06
 * @version V1.0   
 *
 */

@Controller
@RequestMapping("/companypartnership")
public class CompanyPartnershipController {

	@Resource
	private SysServiceI sysService;

	@RequestMapping("/list.do")
	@ResponseBody
	public ReplyDataMode newsList(CompanyPartnershipSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		List<CompanyPartnershipEntity> news = this.sysService.list(criteriaQuery);
		List<CompanyPartnershipVO> companyPartnershipVOs = new ArrayList<CompanyPartnershipVO>();

		for (CompanyPartnershipEntity companyPartnershipEntity:news) {
			CompanyPartnershipVO companyPartnershipVO = new CompanyPartnershipVO();
			companyPartnershipVO.copyEntity(companyPartnershipEntity);
			companyPartnershipVOs.add(companyPartnershipVO);

		}
		replyDataMode.setData(companyPartnershipVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}

	@RequestMapping("/companypartnershipById.do")
	@ResponseBody
	public ReplyDataMode newsById(CompanyPartnershipSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		List<CompanyPartnershipEntity> news = this.sysService.list(criteriaQuery);
		List<CompanyPartnershipVO> companyPartnershipVOs = new ArrayList<CompanyPartnershipVO>();

		for (CompanyPartnershipEntity companyPartnershipEntity:news) {
			CompanyPartnershipVO companyPartnershipVO = new CompanyPartnershipVO();
			companyPartnershipVO.copyEntity(companyPartnershipEntity);
			companyPartnershipVOs.add(companyPartnershipVO);

		}
		replyDataMode.setData(companyPartnershipVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
}
