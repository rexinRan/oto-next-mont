package com.buss.authentication.controller;

import com.buss.authentication.entity.DxsAuthenticationEntity;
import com.buss.authentication.service.DxsAuthenticationServiceI;
import com.buss.common.entity.DxsUserDetailEntity;
import com.buss.user.entity.DxsUserEntity;
import org.apache.log4j.Logger;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.tag.vo.datatable.SortDirection;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.net.URI;
import java.util.*;

/**   
 * @Title: Controller
 * @Description: dxs_authentication
 * @author onlineGenerator
 * @date 2016-07-19 13:24:51
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/nodxsAuthenticationController")
public class NoDxsAuthenticationController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(NoDxsAuthenticationController.class);

	@Autowired
	private DxsAuthenticationServiceI dxsAuthenticationService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * dxs_authentication列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/authentication/dxsAuthenticationList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param user
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(DxsAuthenticationEntity dxsAuthentication,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {

		CriteriaQuery cq = new CriteriaQuery(DxsAuthenticationEntity.class, dataGrid);
		//查询条件组装器
		if("待审核".equals(dxsAuthentication.getAuthenticationResult())){
			dxsAuthentication.setAuthenticationResult("1");
		}
		if("已通过".equals(dxsAuthentication.getAuthenticationResult())){
			dxsAuthentication.setAuthenticationResult("2");
		}
		if("已拒绝".equals(dxsAuthentication.getAuthenticationResult())){
			dxsAuthentication.setAuthenticationResult("3");
		}
		dxsAuthentication.setIsDelete(0);

		cq.addOrder("createTime", SortDirection.desc);
		cq.in("authenticationResult",new Object[]{"1","2","3"});
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsAuthentication, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsAuthenticationService.getDataGridReturn(cq, true);
	//	dataGrid.setResults(new ArrayList());
		TagUtil.datagrid(response, dataGrid);
	}
	@RequestMapping(params = "doType")
	@ResponseBody
	public AjaxJson doUpdate(int tongyi,DxsAuthenticationEntity dxsAuthentication, HttpServletRequest request) {
		DxsAuthenticationEntity t = dxsAuthenticationService.get(DxsAuthenticationEntity.class, dxsAuthentication.getId());
		if(tongyi==1){
			t.setAuthenticationResult("2");
		}else {
			t.setAuthenticationResult("3");
		}
		AjaxJson j = new AjaxJson();
		message = "更新成功";

		try {
			//MyBeanUtils.copyBeanNotNull2Bean(dxsAuthentication, t);
			dxsAuthenticationService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsAuthenticationEntity dxsAuthentication, HttpServletRequest req) {
		DxsUserDetailEntity dxsUserDetail = new DxsUserDetailEntity();
		DxsAuthenticationEntity dxsAuthenticationEntity=new DxsAuthenticationEntity();
		if (StringUtil.isNotEmpty(dxsAuthentication.getId())) {
			dxsAuthenticationEntity = systemService.getEntity(DxsAuthenticationEntity.class,dxsAuthentication.getId());
			req.setAttribute("dxsAuthenticationPage", dxsAuthenticationEntity);

		}
		if (StringUtil.isNotEmpty(dxsAuthenticationEntity.getUserId())) {
			List<DxsUserDetailEntity> dxsUserDetailList = systemService.findByProperty(DxsUserDetailEntity.class, "userid", dxsAuthenticationEntity.getUserId());
			dxsUserDetail = dxsUserDetailList.get(0);
			req.setAttribute("dxsUserDetailPage", dxsUserDetail);
		}
		if (StringUtil.isNotEmpty(dxsUserDetail.getDxsUserEntity())) {
			req.setAttribute("dxsUserPage", dxsUserDetail.getDxsUserEntity());
		}

		return new ModelAndView("com/buss/common/dxsUserDetail-update");
	}

}
