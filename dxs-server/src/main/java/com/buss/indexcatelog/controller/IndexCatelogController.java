package com.buss.indexcatelog.controller;
import com.buss.common.service.SysServiceI;
import com.buss.indexcatelog.entity.IndexCatelogEntity;
import com.buss.indexcatelog.trans.form.IndexCatelogSearchForm;
import com.buss.indexcatelog.trans.vo.IndexCatelogVO;
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
 * @author lu
 *
 */
@Controller
public class IndexCatelogController {

	@Resource
	private SysServiceI sysService;

	@RequestMapping("/indexCatelog/list.do")
	@ResponseBody
	public ReplyDataMode indexCatelogList(IndexCatelogSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("sort", "desc");
		criteriaQuery.setOrder(orderMap);
		List<IndexCatelogEntity> indexCatelogs = this.sysService.list(criteriaQuery);
		List<IndexCatelogVO> indexCatelogVOs = new ArrayList<IndexCatelogVO>();

		for (IndexCatelogEntity indexCatelog:indexCatelogs) {
			IndexCatelogVO indexCatelogVO = new IndexCatelogVO();
			indexCatelogVO.copyEntity(indexCatelog);
			indexCatelogVOs.add(indexCatelogVO);

		}
		replyDataMode.setData(indexCatelogVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
}

