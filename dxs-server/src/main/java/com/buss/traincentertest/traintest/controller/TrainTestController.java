package com.buss.traincentertest.traintest.controller;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;


import com.buss.traincentertest.traintest.entity.TrainTestEntity;
import com.buss.traincentertest.traintest.trans.form.TrainTestSearchForm;
import com.buss.traincentertest.traintest.trans.vo.TrainTestVO;
import com.buss.traincoursevideo.entity.TrainCourseVideoEntity;
import com.buss.traincoursevideo.trans.vo.TrainCourseVideoVO;

import com.buss.userdetail.entity.UserDetailEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.PageMode;
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
@RequestMapping("/trainTest")
public class TrainTestController {

	@Resource
	private SysServiceI sysService;

	@RequestMapping("/list.do")
	@ResponseBody
	public ReplyDataMode trainList(TrainTestSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("createTime", "desc");
		criteriaQuery.setOrder(orderMap);

		List<TrainTestEntity> trainTests = this.sysService.list(criteriaQuery);
		List<TrainTestVO> trainTestVOs = new ArrayList<TrainTestVO>();

		for (TrainTestEntity trainTestEntity:trainTests) {
			TrainTestVO trainTestVO = new TrainTestVO();
			trainTestVO.copyEntity(trainTestEntity);
			trainTestVOs.add(trainTestVO);

		}
		replyDataMode.setData(trainTestVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}


	@RequestMapping("/pageList.do")
	@ResponseBody
	public ReplyDataMode trainTestPageList(TrainTestSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String, Object> orderMap = new HashMap<>();
		orderMap.put("sort","asc");
		orderMap.put("createTime", "desc");
		criteriaQuery.setOrder(orderMap);

		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());


		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<TrainTestEntity> trainTests = mode.getResult();

		List<Map> trainTestVOs = new ArrayList<>();

		for (TrainTestEntity trainTestEntity:trainTests) {
			Map map = new HashMap();
			TrainTestVO trainTestVO = new TrainTestVO();
			trainTestVO.copyEntity(trainTestEntity);

			trainTestVOs.add(map);

		}
		mode.setResult(trainTestVOs);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}


	@RequestMapping("/trainTestById.do")
	@ResponseBody
	public ReplyDataMode trainTestById(TrainTestSearchForm searchForm, HttpServletRequest request){



		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		List<TrainTestEntity> trainTests = this.sysService.list(criteriaQuery);

		Map map = new HashMap();
		map.put("trainTestVO",null);
		map.put("trainVideoList",null);


		if(trainTests!=null&&trainTests.size()!=0){
			TrainTestEntity trainTestEntity = trainTests.get(0);

			TrainTestVO trainTestVO = new TrainTestVO();
			trainTestVO.copyEntity(trainTestEntity);

			//获取用户登录信息
			Subject currentUser = SecurityUtils.getSubject();
			AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");


		}


		replyDataMode.setData(map);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
}

