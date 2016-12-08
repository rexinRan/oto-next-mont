package com.buss.quizitems.controller;
import com.buss.common.service.SysServiceI;

import com.buss.quiz.entity.QuizEntity;
import com.buss.quiz.trans.form.QuizSearchForm;
import com.buss.quiz.trans.vo.QuizVO;
import com.buss.quizitems.entity.QuizItemsEntity;
import com.buss.quizitems.trans.form.QuizItemsSearchForm;
import com.buss.quizitems.trans.vo.QuizItemsVO;
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
@RequestMapping("/quizItems")
public class QuizItemsController {

	@Resource
	private SysServiceI sysService;

	@RequestMapping("/list.do")
	@ResponseBody
	public ReplyDataMode quizItemsList(QuizSearchForm quizsearchForm,QuizItemsSearchForm searchForm, HttpServletRequest request){
		String quizid = null;
		String quizname = null;
		String quizintroduction = null;

		if(searchForm.getQuizId()==null||searchForm.getQuizId() =="") {
			String TrainingCatalogId = quizsearchForm.getTrainingCatalogId();
			String strsql = "SELECT * FROM dxs_quiz where dxs_quiz.is_delete=0 AND training_catalog_id=" + TrainingCatalogId + " order by RAND() LIMIT 0,1";
			List quiz = this.sysService.findListbySql(strsql);

			Object[] a = (Object[]) quiz.get(0);


			if (a[0] != null) {
				quizid = a[0].toString();
			}
			if (a[2] != null) {
				quizname = a[2].toString();
			}
			if (a[4] != null) {
				quizintroduction = a[4].toString();
			}

			searchForm.setIsDelete("0");
			searchForm.setQuizId(quizid);
		}else {
			QuizEntity quizEntity = this.sysService.get(QuizEntity.class,searchForm.getQuizId());
			quizname = quizEntity.getQuizName();
			quizintroduction = quizEntity.getQuizIntroduction();
		}

		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("sort", "desc");
		criteriaQuery.setOrder(orderMap);

		List<QuizItemsEntity> quizItems = this.sysService.list(criteriaQuery);
		List<QuizItemsVO> quizItemsVOs = new ArrayList<QuizItemsVO>();

		for (QuizItemsEntity quizItemsEntity:quizItems) {
			QuizItemsVO quizItemsVO = new QuizItemsVO();
			quizItemsVO.copyEntity(quizItemsEntity);
			quizItemsVOs.add(quizItemsVO);

		}
		Map<String, Object> temp = new HashMap<>();
		temp.put("quizItemsVOs",quizItemsVOs);
		temp.put("quizname",quizname);
		temp.put("quizintroduction",quizintroduction);

		replyDataMode.setData(temp);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}

}

