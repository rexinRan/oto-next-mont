package com.buss.trainingcatalog.controller;
import com.buss.common.service.SysServiceI;
import com.buss.trainingcatalog.entity.TrainingCatalogEntity;
import com.buss.trainingcatalog.trans.form.TrainingCatalogSearchForm;
import com.buss.trainingcatalog.trans.vo.TrainingCatalogVO;
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
public class TrainingCatalogController {

	@Resource
	private SysServiceI sysService;

	@RequestMapping("/trainingCatalog.do")
	@ResponseBody
	public ReplyDataMode trainingCatalogList(TrainingCatalogSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		List<TrainingCatalogEntity> trainingCatalogs = this.sysService.list(criteriaQuery);
		List<TrainingCatalogVO> trainingCatalogVOs = new ArrayList<TrainingCatalogVO>();

		for (TrainingCatalogEntity trainingCatalog:trainingCatalogs) {
			TrainingCatalogVO trainingCatalogVO = new TrainingCatalogVO();
			trainingCatalogVO.copyEntity(trainingCatalog);
			trainingCatalogVOs.add(trainingCatalogVO);

		}
		replyDataMode.setData(trainingCatalogVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
}

