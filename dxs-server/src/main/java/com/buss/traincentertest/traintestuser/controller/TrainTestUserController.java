package com.buss.traincentertest.traintestuser.controller;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;
import com.buss.traincentertest.trainanserse.entity.TrainAnserseEntity;
import com.buss.traincentertest.trainanserse.trans.vo.TrainAnserseVO;
import com.buss.traincentertest.traintest.entity.TrainTestEntity;
import com.buss.traincentertest.traintestsubject.entity.TrainTestSubjectEntity;
import com.buss.traincentertest.traintestsubjectitem.entity.TrainTestSubjectItemEntity;
import com.buss.traincentertest.traintestuser.entity.TrainTestUserEntity;
import com.buss.traincentertest.traintestuser.trans.form.TrainTestUserSearchForm;
import com.buss.traincentertest.traintestuser.trans.vo.TrainTestUserVO;
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
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author lu
 *
 */
@Controller
@RequestMapping("/trainTestUser")
public class TrainTestUserController {

	@Resource
	private SysServiceI sysService;

	@RequestMapping("/list.do")
	@ResponseBody
	public ReplyDataMode trainList(TrainTestUserSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("createTime", "desc");
		criteriaQuery.setOrder(orderMap);

		List<TrainTestUserEntity> trainTestUsers = this.sysService.list(criteriaQuery);
		List<TrainTestUserVO> trainTestUserVOs = new ArrayList<TrainTestUserVO>();

		for (TrainTestUserEntity trainTestUserEntity:trainTestUsers) {
			TrainTestUserVO trainTestUserVO = new TrainTestUserVO();
			trainTestUserVO.copyEntity(trainTestUserEntity);
			trainTestUserVOs.add(trainTestUserVO);

		}
		replyDataMode.setData(trainTestUserVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}

	@RequestMapping("/pageList.do")
	@ResponseBody
	public ReplyDataMode pageList(TrainTestUserSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();

		//获取用户登录信息
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

		if(user==null){

			replyDataMode.setData("未登陆");
			replyDataMode.setStatusCode("200");
			replyDataMode.setSuccess(true);
			return replyDataMode;

		}
		searchForm.setUserId(user.getId());
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("createTime", "desc");
		criteriaQuery.setOrder(orderMap);

		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());

		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);

		List<TrainTestUserEntity> trainTestUsers = mode.getResult();
		List mapList = new ArrayList<>();

		for (TrainTestUserEntity trainTestUserEntity:trainTestUsers) {
			Map map = new HashMap();
			TrainTestUserVO trainTestUserVO = new TrainTestUserVO();
			trainTestUserVO.copyEntity(trainTestUserEntity);
			String testId= trainTestUserVO.getTtId();
			TrainTestEntity trainTestEntity = this.sysService.get(TrainTestEntity.class,testId);
			if(trainTestEntity!=null){
				map.put("testName",trainTestEntity.getTName());
				map.put("testId",trainTestEntity.getId());
				map.put("testIntroduce",trainTestEntity.getTIntroduce());
			}
			map.put("testResult",trainTestUserVO.getResult());
			Date date = trainTestUserEntity.getCreateTime();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String dateString = formatter.format(date);
			map.put("testIime",dateString);
			map.put("remarks",trainTestUserEntity.getRemarks());
			mapList.add(map);

		}
		mode.setResult(mapList);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}





	@RequestMapping("/trainTestUserById.do")
	@ResponseBody
	public ReplyDataMode trainTestUserById(TrainTestUserSearchForm searchForm, HttpServletRequest request){
		
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("createTime", "desc");
		criteriaQuery.setOrder(orderMap);

		List<TrainTestUserEntity> trainTestUsers = this.sysService.list(criteriaQuery);

		if(trainTestUsers!=null&&trainTestUsers.size()!=0){
			TrainTestUserEntity trainTestUserEntity = trainTestUsers.get(0);

			TrainTestUserVO trainTestUserVO = new TrainTestUserVO();
			trainTestUserVO.copyEntity(trainTestUserEntity);
			
		}
		
		replyDataMode.setData("");
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}

	@RequestMapping("/saveTestUser.do")
	@ResponseBody
	public ReplyDataMode saveTestUser(TrainTestUserSearchForm searchForm, HttpServletRequest request){

		ReplyDataMode replyDataMode = new ReplyDataMode();
		String result = "操作成功";

		//获取用户登录信息
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

		TrainTestUserEntity trainTestUserEntity = new TrainTestUserEntity();
		trainTestUserEntity.setIsDelete(0);
		trainTestUserEntity.setAnswer(searchForm.getAnswer());
		trainTestUserEntity.setTtId(searchForm.getTtId());

		Date date = new Date();
		trainTestUserEntity.setUpdateTime(date);
		trainTestUserEntity.setCreateTime(date);

		if(user!=null){
			trainTestUserEntity.setUserId(user.getId());

					try {

					this.sysService.saveOrUpdate(trainTestUserEntity);
				}catch (Exception e){
					result = "操作失败";

				}


		}else {
			result = "用户未登陆";
		}

		replyDataMode.setData(result);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;

	}


	@RequestMapping("/MBTIResult.do")
	@ResponseBody
	public ReplyDataMode MBTIResult(TrainTestUserSearchForm searchForm, HttpServletRequest request){

		ReplyDataMode replyDataMode = new ReplyDataMode();
		replyDataMode.setData(null);
		//获取用户登录信息
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
		if(user==null){
			replyDataMode.setData("您未登陆");
			replyDataMode.setStatusCode("200");
			replyDataMode.setSuccess(true);

			return replyDataMode;

		}

		searchForm.setUserId(user.getId());
		searchForm.setIsDelete("0");
		searchForm.setTtId("1");

		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String,Object> orderMap = new HashMap<String,Object>();
		orderMap.put("createTime", "desc");
		criteriaQuery.setOrder(orderMap);

		List<TrainTestUserEntity> trainTestUsers = this.sysService.list(criteriaQuery);

		if(trainTestUsers!=null&&trainTestUsers.size()!=0){
			TrainTestUserEntity trainTestUserEntity = trainTestUsers.get(0);
			String answer = trainTestUserEntity.getAnswer();
			String []answers = answer.split(",");
			Map map = new HashMap();
			map.put("E",0);
			map.put("I",0);
			map.put("S",0);
			map.put("N",0);
			map.put("T",0);
			map.put("F",0);
			map.put("J",0);
			map.put("P",0);
			for(int i= 0;i<answers.length;i++){
				int number = i+1;
				TrainTestSubjectEntity trainTestSubjectEntity = new TrainTestSubjectEntity();
				trainTestSubjectEntity.setTtId("1");
				trainTestSubjectEntity.setSubjectNum(number);
				trainTestSubjectEntity.setIsDelete(0);
				List<TrainTestSubjectEntity> trainTestSubjectList = this.sysService.findByExample(TrainTestSubjectEntity.class.getName(),trainTestSubjectEntity);
				if(trainTestSubjectList!=null&&trainTestSubjectList.size()!=0){
					TrainTestSubjectEntity trainTestSubject = trainTestSubjectList.get(0);
					String subjectId = trainTestSubject.getId();
					TrainTestSubjectItemEntity trainTestSubjectItemEntity = new TrainTestSubjectItemEntity();
					trainTestSubjectItemEntity.setTtsId(subjectId);
					trainTestSubjectItemEntity.setSort(Integer.parseInt(answers[i]));
					trainTestSubjectItemEntity.setIsDelete(0);
					List<TrainTestSubjectItemEntity> trainTestSubjectItemEntityList = this.sysService.findByExample(TrainTestSubjectItemEntity.class.getName(),trainTestSubjectItemEntity);
					if(trainTestSubjectItemEntityList!=null&&trainTestSubjectItemEntityList.size()!=0){
						TrainTestSubjectItemEntity trainTestSubjectItem = trainTestSubjectItemEntityList.get(0);
						String result = trainTestSubjectItem.getItemObject();
						Integer before = (Integer) map.get(result);
						Integer after = before + 1;
						map.put(result,after);
					}
				}
			}
			String resultType = "";
			String type1 = (Integer)map.get("E")>(Integer)map.get("I") ? "E":"I";
			String type2 = (Integer)map.get("S")>(Integer)map.get("N") ? "S":"N";
			String type3 = (Integer)map.get("T")>(Integer)map.get("F") ? "T":"F";
			String type4 = (Integer)map.get("J")>(Integer)map.get("P") ? "J":"P";
			resultType = resultType +type1 +type2 +type3 +type4;
			TrainAnserseEntity trainAnserseEntity = new TrainAnserseEntity();
			trainAnserseEntity.setIsDelete(0);
			trainAnserseEntity.setResult(resultType);
//			trainAnserseEntity.setResult("ENFP");
			trainAnserseEntity.setTtId("1");
			List<TrainAnserseEntity> trainAnserseList = this.sysService.findByExample(TrainAnserseEntity.class.getName(),trainAnserseEntity);
			if(trainAnserseList!=null&&trainAnserseList.size()!=0){
				TrainAnserseEntity trainAnserse = trainAnserseList.get(0);
				TrainAnserseVO trainAnserseVO = new TrainAnserseVO();
				trainAnserseVO.copyEntity(trainAnserse);
				if((trainTestUserEntity.getResult()==null)||"".equals(trainTestUserEntity.getResult())){

					trainTestUserEntity.setResult(trainAnserseVO.getCharacterType());
					this.sysService.saveOrUpdate(trainAnserseEntity);
				}
				String suitJob = trainAnserseVO.getSultJob();
				List empList = new ArrayList();
				if(suitJob!=null&&!"".equals(suitJob)){
					String [] emps = suitJob.split("#");
					for(String emp:emps){
						empList.add(emp);
					}
				}
				trainAnserseVO.setEmpList(empList);
				Map returnMap = new HashMap();
				returnMap.put("trainAnserse",trainAnserseVO);
				returnMap.put("items",map);
				replyDataMode.setData(returnMap);
			}

		}


		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}

}

