package com.buss.vote.controller;

import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;
import com.buss.vote.entity.VoteEntity;
import com.buss.vote.trans.form.VoteSearchForm;
import com.buss.vote.trans.vo.VoteVO;
import com.buss.voteitem.controller.VoteItemController;
import com.buss.voteitem.entity.VoteItemEntity;
import com.buss.voteitem.trans.form.VoteItemSearchForm;
import com.buss.voteitem.trans.vo.VoteItemVO;
import com.buss.voteuser.entity.VoteUserEntity;
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
import java.util.*;

/**   
 * @Title: Controller
 * @Description: dxs_vote
 * @author onlineGenerator
 * @date 2016-07-14 18:41:07
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/VoteEntity")
public class VoteController {
	@Resource
	private SysServiceI sysService;


	@RequestMapping("/voteById.do")
	@ResponseBody
	public ReplyDataMode voteById (VoteSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		List<VoteEntity> votes = this.sysService.list(criteriaQuery);
		List<VoteVO> voteVOs = new ArrayList<VoteVO>();

		for (VoteEntity dxsVoteEntity : votes) {
			VoteVO VoteVO = new VoteVO();
			VoteVO.copyEntity(dxsVoteEntity);
			voteVOs.add(VoteVO);

		}
		replyDataMode.setData(voteVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}

	@RequestMapping("/pageList.do")
	@ResponseBody
	public ReplyDataMode votePageList(VoteSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String, Object> orderMap = new HashMap<>();
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		Date date = new Date();
		criteriaQuery.ge("deadlineDate",date);
		criteriaQuery.add();

		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());

		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<VoteEntity> votes = mode.getResult();
		List<VoteVO> voteVOs = new ArrayList<VoteVO>();

		List<Map> maps = new ArrayList<Map>();

		for (VoteEntity voteEntity:votes) {
//			Map<String,Object> map = new HashMap<>();

//			List<VoteUserEntity> list = this.sysService.findByProperty(VoteUserEntity.class,"voteId",voteEntity.getId());

//			Integer userCount =0;
//			if(list!=null&&list.size()!=0){
//				userCount = list.size();
//			}

//			String voteStatu = "进行中";

			VoteVO voteVO = new VoteVO();
			voteVO.copyEntity(voteEntity);
			voteVOs.add(voteVO);
//			map.put("vote",voteVO);
//			map.put("userCount",userCount);
//			map.put("voteStatu",voteStatu);
//			maps.add(map);


		}
		mode.setResult(voteVOs);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}





	@RequestMapping("/overList.do")
	@ResponseBody
	public ReplyDataMode overList(VoteSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String, Object> orderMap = new HashMap<>();
		orderMap.put("createTime", "desc");
		orderMap.put("updateTime", "desc");
		criteriaQuery.setOrder(orderMap);

		Date date = new Date();
		criteriaQuery.le("deadlineDate",date);
		criteriaQuery.add();

		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());

		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<VoteEntity> votes = mode.getResult();
		List<VoteVO> voteVOs = new ArrayList<VoteVO>();

		List<Map> maps = new ArrayList<Map>();

		for (VoteEntity voteEntity:votes) {
			Map<String,Object> map = new HashMap<>();

//			List<VoteUserEntity> list = this.sysService.findByProperty(VoteUserEntity.class,"voteId",voteEntity.getId());
//
//			Integer userCount =0;
//			if(list!=null&&list.size()!=0){
//				userCount = list.size();
//			}
//
//			String voteStatu = "已结束";

			VoteVO voteVO = new VoteVO();
			voteVO.copyEntity(voteEntity);
			voteVOs.add(voteVO);

			VoteItemSearchForm voteItemSearchForm = new VoteItemSearchForm();
			voteItemSearchForm.setVoteId(voteVO.getId());
			voteItemSearchForm.setIsDelete("0");
			CriteriaQuery criteriaQuery1 = voteItemSearchForm.getCriteriaQuery();

			Map<String, Object> orderMap1 = new HashMap<>();
			orderMap1.put("ite	mNum", "desc");
			criteriaQuery.setOrder(orderMap1);


			PageMode mode1 = this.sysService.list4page(criteriaQuery1,1,3);
			List<VoteItemEntity> voteItems = mode1.getResult();

			List<VoteItemVO> voteItemVOs = new ArrayList<VoteItemVO>();

			for (VoteItemEntity voteItemEntity:voteItems) {
				VoteItemVO voteItemVO = new VoteItemVO();
				voteItemVO.copyEntity(voteItemEntity);
				voteItemVOs.add(voteItemVO);

			}

			map.put("vote",voteVO);
//			map.put("userCount",userCount);
			map.put("voteItemVOs",voteItemVOs);
			maps.add(map);

		}
		mode.setResult(maps);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}


	@RequestMapping("/voteResult.do")
	@ResponseBody
	public ReplyDataMode  voteResult (VoteSearchForm searchForm, HttpServletRequest request){
		searchForm.setIsDelete("0");
		ReplyDataMode replyDataMode = new ReplyDataMode();

		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

		VoteEntity voteEntity = this.sysService.get(VoteEntity.class,searchForm.getId());
		String voteNum ="0";
		if(voteEntity.getVoteNum()!=null){
			voteNum = voteEntity.getVoteNum().toString();
		}
		String voteCount = "0";
		if(voteEntity.getVoteCount()!=null){
			voteCount = voteEntity.getVoteCount().toString();
		}

		List<VoteUserEntity> voteUserList =null;
		if(user!=null){
			VoteUserEntity voteUserEntity = new VoteUserEntity();
			voteUserEntity.setVoteId(searchForm.getId());
			voteUserEntity.setUserId(user.getId());
			voteUserEntity.setIsDelete(0);
			voteUserList = this.sysService.findByExample(VoteUserEntity.class.getName(),voteUserEntity);
		}
		String voteOrder = "0";
		if(voteUserList!=null&&voteUserList.size()>0){
			VoteUserEntity voteUser = voteUserList.get(0);
			voteOrder = voteUser.getViNum().toString();
		}

		Map<String,Object> result = new HashMap<>();
		result.put("voteNum",voteNum);
		result.put("voteCount",voteCount);
		result.put("voteOrder",voteOrder);
		replyDataMode.setData(result);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}



}

