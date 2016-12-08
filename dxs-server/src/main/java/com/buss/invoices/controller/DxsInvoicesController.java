package com.buss.invoices.controller;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;
import com.buss.invoices.entity.DxsInvoicesEntity;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.buss.invoices.trans.form.DxsInvoicesSearchForm;
import com.buss.invoices.trans.vo.DxsInvoicesVO;
import com.buss.userdetail.entity.UserDetailEntity;
import org.apache.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.context.annotation.Scope;

/**   
 * @Title: Controller
 * @Description: dxs_invoices
 * @author onlineGenerator
 * @date 2016-09-23 14:59:30
 * @version V1.0   
 *
 */

@Controller
@RequestMapping("/Invoices")
public class DxsInvoicesController  {
	@Resource
	private SysServiceI sysService;


	@RequestMapping("/save.do")
	@ResponseBody
	public ReplyDataMode invoicessave(DxsInvoicesSearchForm searchForm, HttpServletRequest request) {
		ReplyDataMode replyDataMode = new ReplyDataMode();
		// 获取当前登录用户
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
		if(user==null){
			replyDataMode.setData("用户未登陆");
			replyDataMode.setStatusCode("200");
			replyDataMode.setSuccess(true);
			return replyDataMode;

		}
		searchForm.setUserId(user.getId());
		searchForm.setIsDelete("0");
		DxsInvoicesEntity dxsInvoicesEntity=new DxsInvoicesEntity();
		dxsInvoicesEntity = (DxsInvoicesEntity) searchForm.toEntity();
		dxsInvoicesEntity.setCreateTime(new Date());

		try {
			sysService.saveOrUpdate(dxsInvoicesEntity);
			replyDataMode.setData("操作成功");
			replyDataMode.setStatusCode("200");
			replyDataMode.setSuccess(true);

		}catch (Exception e){
			e.printStackTrace();
			replyDataMode.setData("操作失败");
			replyDataMode.setStatusCode("200");
			replyDataMode.setSuccess(false);
		}


		return replyDataMode;
	}
	@RequestMapping("/info.do")
	@ResponseBody
	public ReplyDataMode info(DxsInvoicesSearchForm searchForm, HttpServletRequest request) {
		ReplyDataMode replyDataMode = new ReplyDataMode();
		// 获取当前登录用户
		Subject currentUser = SecurityUtils.getSubject();
		AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
		searchForm.setIsDelete("0");
		searchForm.setUserId(user.getId());
		CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

		Map<String, Object> orderMap = new HashMap<String, Object>();
		orderMap.put("createTime", "desc");
		criteriaQuery.setOrder(orderMap);


		List<DxsInvoicesEntity> dxsInvoicesEntity = this.sysService.list(criteriaQuery);
		List  dxsInvoicesVOs=new ArrayList<>();

        for(DxsInvoicesEntity aa:dxsInvoicesEntity){
			Map map = new HashMap();
			DxsInvoicesVO dxsInvoicesVO= new DxsInvoicesVO();
			dxsInvoicesVO.copyEntity(aa);
			map.put("dxsInvoicesVO",dxsInvoicesVO);
			map.put("userDetail",null);
			List<UserDetailEntity> list = this.sysService.findByProperty(UserDetailEntity.class,"userId",user.getId());
			if(list!=null&&list.size()!=0){

				UserDetailEntity userDetailEntity = list.get(0);
				String add = userDetailEntity.getPostalAddress();
				if(add!=null&&add.contains("#")){

					String adds = add.replace("#","");
					userDetailEntity.setPostalAddress(adds);
				}
				map.put("userDetail",userDetailEntity);
			}
			dxsInvoicesVOs.add(map);
        }


		replyDataMode.setData(dxsInvoicesVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);

		return replyDataMode;
	}
}
