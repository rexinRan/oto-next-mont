package com.buss.quiz.controller;
import com.buss.common.service.SysServiceI;
import com.buss.quiz.entity.QuizEntity;
import com.buss.quiz.trans.form.QuizSearchForm;
import com.buss.quiz.trans.vo.QuizVO;
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
@RequestMapping("/quiz")
public class QuizController {

	@Resource
	private SysServiceI sysService;

//	@RequestMapping("/list.do")
//	@ResponseBody
//	public ReplyDataMode quizList(QuizSearchForm searchForm, HttpServletRequest request){
//		searchForm.setIsDelete("0");
//		String  TrainingCatalogId=searchForm.getTrainingCatalogId();
//		ReplyDataMode replyDataMode = new ReplyDataMode();
//		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();
//
////		Map<String,Object> orderMap = new HashMap<String,Object>();
////		orderMap.put("createTime", "desc");
////		orderMap.put("updateTime", "desc");
////		criteriaQuery.setOrder(orderMap);
//		String strsql="SELECT * FROM dxs_quiz where dxs_quiz.is_delete=0 AND training_catalog_id="+TrainingCatalogId+" order by RAND() LIMIT 0,1";
//		List quiz=this.sysService.findListbySql(strsql);
//
//
//
//		List<QuizVO> quizVOs = new ArrayList<QuizVO>();
//		for(int i=0;i<quiz.size();i++){
//			Object[] a=(Object[])quiz.get(i);
//			QuizVO quizVO = new QuizVO();
//
//			if(a[0]!=null){
//				quizVO.setId(a[0].toString());
//			}
//			if(a[1]!=null) {
//				quizVO.setTrainingCatalogId(a[1].toString());
//			}
//			if(a[2]!=null){
//				quizVO.setQuizName(a[2].toString());
//			}
//            if(a[3]!=null){
//	            quizVO.setQuizEditor(a[3].toString());
//            }
//
//			quizVOs.add(quizVO);
//		}
//
//		replyDataMode.setData(quizVOs);
//		replyDataMode.setStatusCode("200");
//		replyDataMode.setSuccess(true);
//
//	return replyDataMode;
//	}


}

