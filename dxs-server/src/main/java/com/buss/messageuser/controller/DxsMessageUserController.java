package com.buss.messageuser.controller;

import com.alibaba.fastjson.JSON;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.redis.RedisClient;
import com.buss.common.redis.cache.CacheKey;
import com.buss.common.service.SysServiceI;
import com.buss.messageuser.entity.DxsMessageUserEntity;
import com.buss.messageuser.entity.DxsMessagesEntity;
import com.buss.messageuser.trans.form.DxsMessagesSearchForm;
import com.buss.messageuser.trans.form.MessageUserSearchForm;
import com.buss.messageuser.trans.vo.DxsMessagesVO;
import com.buss.messageuser.trans.vo.MessageUserVO;
import com.buss.news.entity.NewsEntity;
import com.buss.news.trans.form.NewsSearchForm;
import com.buss.news.trans.vo.NewsVO;
import com.buss.news.trans.vo.SimpleNewsVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.jweb.core.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author lu
 *
 */
@Controller
@RequestMapping("/dxsMessageUserController")
public class DxsMessageUserController {

	@Resource
	private SysServiceI sysService;


	@RequestMapping("/unread.do")
	@ResponseBody
	public ReplyDataMode unreadMessageUserList(MessageUserSearchForm searchForm, HttpServletRequest request) {
		ReplyDataMode replyDataMode = new ReplyDataMode();
        // 获取当前登录用户
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
		searchForm.setUserId(user.getId());
		searchForm.setIsDelete("0");
		searchForm.setIsRead("0");
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String, Object> orderMap = new HashMap<String, Object>();
		orderMap.put("createTime", "desc");
		criteriaQuery.setOrder(orderMap);

		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());

		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<DxsMessageUserEntity> dxsMessageUser = mode.getResult();

		List<Map> messageUserVOs = new ArrayList<>();

		for (DxsMessageUserEntity dxsMessageUserEntity : dxsMessageUser) {
			Map map= new HashMap();
			MessageUserVO messageUserVO = new MessageUserVO();
			messageUserVO.copyEntity(dxsMessageUserEntity);
					map.put("a",messageUserVO);
			DxsMessagesVO dxsMessagesVO=new DxsMessagesVO();
			DxsMessagesEntity dxsMessages=sysService.getEntity(DxsMessagesEntity.class,dxsMessageUserEntity.getMId());
			if(dxsMessages.getIsDelete()==0){
				dxsMessagesVO.copyEntity(dxsMessages);
				map.put("b",dxsMessagesVO);
			}
			messageUserVOs.add(map);

		}
		mode.setResult(messageUserVOs);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
	@RequestMapping("/read.do")
	@ResponseBody
	public ReplyDataMode readMessageUserList(MessageUserSearchForm searchForm, HttpServletRequest request) {
		ReplyDataMode replyDataMode = new ReplyDataMode();
		// 获取当前登录用户
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
		searchForm.setUserId(user.getId());
		searchForm.setIsDelete("0");
		searchForm.setIsRead("1");
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String, Object> orderMap = new HashMap<String, Object>();
		orderMap.put("createTime", "desc");
		criteriaQuery.setOrder(orderMap);

		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());

		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<DxsMessageUserEntity> dxsMessageUser = mode.getResult();


		List<Map> messageUserVOs = new ArrayList<>();

		for (DxsMessageUserEntity dxsMessageUserEntity : dxsMessageUser) {
			Map map= new HashMap();
			MessageUserVO messageUserVO = new MessageUserVO();
			messageUserVO.copyEntity(dxsMessageUserEntity);
			map.put("a",messageUserVO);
			DxsMessagesVO dxsMessagesVO=new DxsMessagesVO();
			DxsMessagesEntity dxsMessages=sysService.getEntity(DxsMessagesEntity.class,dxsMessageUserEntity.getMId());
			if(dxsMessages.getIsDelete()==0){
				dxsMessagesVO.copyEntity(dxsMessages);
				map.put("b",dxsMessagesVO);
			}
			messageUserVOs.add(map);

		}
		mode.setResult(messageUserVOs);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
	@RequestMapping("/all.do")
	@ResponseBody
	public ReplyDataMode allMessageUserList(MessageUserSearchForm searchForm, HttpServletRequest request) {
		ReplyDataMode replyDataMode = new ReplyDataMode();
		// 获取当前登录用户
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
		searchForm.setUserId(user.getId());
		searchForm.setIsDelete("0");
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String, Object> orderMap = new HashMap<String, Object>();
		orderMap.put("createTime", "desc");
		criteriaQuery.setOrder(orderMap);

		int pageNo = Integer.parseInt(searchForm.getPageNo());
		int pageSize = Integer.parseInt(searchForm.getPageSize());

		PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
		List<DxsMessageUserEntity> dxsMessageUser = mode.getResult();

		List<Map> messageUserVOs = new ArrayList<>();

		for (DxsMessageUserEntity dxsMessageUserEntity : dxsMessageUser) {
			Map map= new HashMap();

			MessageUserVO messageUserVO = new MessageUserVO();
			messageUserVO.copyEntity(dxsMessageUserEntity);

			map.put("a",messageUserVO);
			DxsMessagesVO dxsMessagesVO=new DxsMessagesVO();
			DxsMessagesEntity dxsMessages=sysService.getEntity(DxsMessagesEntity.class,dxsMessageUserEntity.getMId());
			if(dxsMessages.getIsDelete()==0){
				dxsMessagesVO.copyEntity(dxsMessages);
				map.put("b",dxsMessagesVO);
			}
			messageUserVOs.add(map);

		}
		mode.setResult(messageUserVOs);
		replyDataMode.setData(mode);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}

	@RequestMapping("/unreaddetails.do")
	@ResponseBody
	public ReplyDataMode unreadMessageUserdetails(MessageUserSearchForm UserForm, HttpServletRequest request) {
		ReplyDataMode replyDataMode = new ReplyDataMode();
		//标为已读
		DxsMessageUserEntity dxsMessageUserEntity=sysService.getEntity(DxsMessageUserEntity.class,UserForm.getId());
		dxsMessageUserEntity.setIsRead(1);
		dxsMessageUserEntity.setReadTime(new Date());
		sysService.saveOrUpdate(dxsMessageUserEntity);

		DxsMessagesSearchForm searchForm =new DxsMessagesSearchForm();
		searchForm.setIsDelete("0");
		searchForm.setId(dxsMessageUserEntity.getMId());
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();


		List<DxsMessagesEntity> dxsMessage = this.sysService.list(criteriaQuery);
		List<DxsMessagesVO> messageUserVOs = new ArrayList<DxsMessagesVO>();

		for (DxsMessagesEntity dxsMessagesEntity : dxsMessage) {
			DxsMessagesVO messageVO = new DxsMessagesVO();
			messageVO.copyEntity(dxsMessagesEntity);
			messageUserVOs.add(messageVO);

		}
		replyDataMode.setData(messageUserVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
}