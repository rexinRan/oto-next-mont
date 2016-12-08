package com.buss.authentication.controller;
import com.buss.authentication.entity.DxsAuthenticationEntity;
import com.buss.authentication.service.DxsAuthenticationServiceI;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.buss.user.entity.DxsUserEntity;
import org.apache.log4j.Logger;
import org.jeecgframework.tag.vo.datatable.SortDirection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.context.annotation.Scope;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;
import org.jeecgframework.core.util.MyBeanUtils;

import java.io.OutputStream;
import org.jeecgframework.core.util.BrowserUtils;
import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.jeecgframework.core.util.ResourceUtil;
import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.jeecgframework.core.util.ExceptionUtil;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.jeecgframework.core.beanvalidator.BeanValidators;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

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
@RequestMapping("/dxsAuthenticationController")
public class DxsAuthenticationController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsAuthenticationController.class);

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
		//大权
		//增加有效标志
		CriteriaQuery cq = new CriteriaQuery(DxsAuthenticationEntity.class, dataGrid);
		//查询条件组装器
//		if("创业导师".equals(dxsAuthentication.getAuthenticationResult())){
//			dxsAuthentication.setAuthenticationResult("1");
//		}
//		if("创客导师".equals(dxsAuthentication.getAuthenticationResult())){
//			dxsAuthentication.setAuthenticationResult("2");
//		}
//		if("已拒绝".equals(dxsAuthentication.getAuthenticationResult())){
//			dxsAuthentication.setAuthenticationResult("3");
//		}
		dxsAuthentication.setIsDelete(0);
//		if(dxsAuthentication.getAuthenticationResult()!=null&&dxsAuthentication.getAuthenticationResult()!=""){
//			String str=dxsAuthentication.getAuthenticationResult();
//			List list=new ArrayList();
//
//			if("创业导师认证通过".indexOf(str)!=-1){
//				list.add("8");
//			}
//			if("创客导师认证通过".indexOf(str)!=-1){
//				list.add("14");
//			}
//			cq.in("authenticationResult",new Object[]{"8","11","14"});
//			cq.add();
//		}
//		List dxsAuthenticationList=systemService.findListbySql("select a.id,a.user_id from dxs_authentication a where " +
//				"is_delete=0 and a.authentication_result in(8,11,14,17,20)");
		cq.addOrder("createTime", SortDirection.desc);
		cq.in("authenticationResult",new Object[]{"7","8","9","10","11","12","13","14","15","16","17","18","19","20","21"});
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
			if("7".equals(t.getAuthenticationResult())){
				t.setAuthenticationResult("8");
			}
			if("10".equals(t.getAuthenticationResult())){
				t.setAuthenticationResult("11");
			}
			if("13".equals(t.getAuthenticationResult())){
				t.setAuthenticationResult("14");
			}
			if("16".equals(t.getAuthenticationResult())){
				t.setAuthenticationResult("17");
			}
			if("19".equals(t.getAuthenticationResult())){
				t.setAuthenticationResult("20");
			}

		}else {
			if("7".equals(t.getAuthenticationResult())){
				t.setAuthenticationResult("9");
			}
			if("10".equals(t.getAuthenticationResult())){
				t.setAuthenticationResult("12");
			}
			if("13".equals(t.getAuthenticationResult())){
				t.setAuthenticationResult("15");
			}
			if("16".equals(t.getAuthenticationResult())){
				t.setAuthenticationResult("18");
			}
			if("19".equals(t.getAuthenticationResult())){
				t.setAuthenticationResult("21");
			}
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
	/**
	 * 删除dxs_authentication
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsAuthenticationEntity dxsAuthentication, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsAuthentication = systemService.getEntity(DxsAuthenticationEntity.class, dxsAuthentication.getId());
		message = "删除成功";
		try{
			//大权
			//更改为无效标志
			dxsAuthentication.setIsDelete(1);
			dxsAuthenticationService.updateEntitie(dxsAuthentication);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除dxs_authentication
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "删除成功";
		try{
			for(String id:ids.split(",")){
				DxsAuthenticationEntity dxsAuthentication = systemService.getEntity(DxsAuthenticationEntity.class, 
				id
				);
				//大权
				//更改为无效标志
				dxsAuthentication.setIsDelete(1);
				dxsAuthenticationService.updateEntitie(dxsAuthentication);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加dxs_authentication
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsAuthenticationEntity dxsAuthentication, HttpServletRequest request) {
		//大权
		//添加默认字段值
		Date date =new Date();
		dxsAuthentication.setCreateTime(date);
		dxsAuthentication.setUpdateTime(date);
		dxsAuthentication.setIsDelete(0);
		AjaxJson j = new AjaxJson();
		message = "添加成功";
		try{
			dxsAuthenticationService.save(dxsAuthentication);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新dxs_authentication
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsAuthenticationEntity dxsAuthentication, HttpServletRequest request) {
		//大权
		//更新修改时间
		Date date =new Date();
		dxsAuthentication.setUpdateTime(date);
		AjaxJson j = new AjaxJson();
		message = "更新成功";
		DxsAuthenticationEntity t = dxsAuthenticationService.get(DxsAuthenticationEntity.class, dxsAuthentication.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsAuthentication, t);
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
	

	/**
	 * dxs_authentication新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DxsAuthenticationEntity dxsAuthentication, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsAuthentication.getId())) {
			dxsAuthentication = dxsAuthenticationService.getEntity(DxsAuthenticationEntity.class, dxsAuthentication.getId());
			req.setAttribute("dxsAuthenticationPage", dxsAuthentication);
		}
//		List<DxsUserEntity>   userList = systemService.findListbySql("SELECT dxs_user.* FROM dxs_user where dxs_user.rolecode=\"teacher\" and dxs_user.isdelete=\"0\"");
//		req.setAttribute("userList",userList);

//		DxsUserEntity   dxsUserEntity = new DxsUserEntity();
//		dxsUserEntity.setIsdelete(0);
//		dxsUserEntity.setRolecode("teacher");
//		dxsUserEntity.setCheckstatus(7);
//		List<DxsUserEntity>   teacherList = systemService.findByExample(DxsUserEntity.class.getName(),dxsUserEntity);
		DxsAuthenticationEntity dxsAuthenticationEntity=new DxsAuthenticationEntity();
		dxsAuthenticationEntity.setIsDelete(0);
		dxsAuthenticationEntity.setAuthenticationResult("6");
		List<DxsAuthenticationEntity>   teacherList = systemService.findByExample(DxsAuthenticationEntity.class.getName(),dxsAuthenticationEntity);
 		req.setAttribute("teacherList",teacherList);

		return new ModelAndView("com/buss/authentication/dxsAuthentication-add");
	}
	/**
	 * dxs_authentication编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsAuthenticationEntity dxsAuthentication, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsAuthentication.getId())) {
			dxsAuthentication = dxsAuthenticationService.getEntity(DxsAuthenticationEntity.class, dxsAuthentication.getId());
			req.setAttribute("dxsAuthenticationPage", dxsAuthentication);
		}

//		DxsUserEntity   dxsUserEntity = new DxsUserEntity();
//		dxsUserEntity.setIsdelete(0);
//		dxsUserEntity.setRolecode("teacher");
//		dxsUserEntity.setCheckstatus(7);
//		List<DxsUserEntity>   teacherList = systemService.findByExample(DxsUserEntity.class.getName(),dxsUserEntity);
		DxsAuthenticationEntity dxsAuthenticationEntity=new DxsAuthenticationEntity();
		dxsAuthenticationEntity.setIsDelete(0);
		dxsAuthenticationEntity.setAuthenticationResult("6");
		List<DxsAuthenticationEntity>   teacherList = systemService.findByExample(DxsAuthenticationEntity.class.getName(),dxsAuthenticationEntity);
		req.setAttribute("teacherList",teacherList);

//		List<DxsUserEntity>   userList = systemService.findListbySql("SELECT dxs_user.* FROM dxs_user where dxs_user.rolecode=\"teacher\" and dxs_user.isdelete=\"0\"");
//		req.setAttribute("userList",userList);

		return new ModelAndView("com/buss/authentication/dxsAuthentication-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsAuthenticationController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsAuthenticationEntity dxsAuthentication,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsAuthenticationEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsAuthentication, request.getParameterMap());
		List<DxsAuthenticationEntity> dxsAuthentications = this.dxsAuthenticationService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_authentication");
		modelMap.put(NormalExcelConstants.CLASS,DxsAuthenticationEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_authentication列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsAuthentications);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsAuthenticationEntity dxsAuthentication,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_authentication");
    	modelMap.put(NormalExcelConstants.CLASS,DxsAuthenticationEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_authentication列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
    	"导出信息"));
    	modelMap.put(NormalExcelConstants.DATA_LIST,new ArrayList());
    	return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping(params = "importExcel", method = RequestMethod.POST)
	@ResponseBody
	public AjaxJson importExcel(HttpServletRequest request, HttpServletResponse response) {
		AjaxJson j = new AjaxJson();
		
		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
		for (Map.Entry<String, MultipartFile> entity : fileMap.entrySet()) {
			MultipartFile file = entity.getValue();// 获取上传文件对象
			ImportParams params = new ImportParams();
			params.setTitleRows(2);
			params.setHeadRows(1);
			params.setNeedSave(true);
			try {
				List<DxsAuthenticationEntity> listDxsAuthenticationEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsAuthenticationEntity.class,params);
				for (DxsAuthenticationEntity dxsAuthentication : listDxsAuthenticationEntitys) {
					dxsAuthenticationService.save(dxsAuthentication);
				}
				j.setMsg("文件导入成功！");
			} catch (Exception e) {
				j.setMsg("文件导入失败！");
				logger.error(ExceptionUtil.getExceptionMessage(e));
			}finally{
				try {
					file.getInputStream().close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return j;
	}
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<DxsAuthenticationEntity> list() {
		List<DxsAuthenticationEntity> listDxsAuthentications=dxsAuthenticationService.getList(DxsAuthenticationEntity.class);
		return listDxsAuthentications;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsAuthenticationEntity task = dxsAuthenticationService.get(DxsAuthenticationEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsAuthenticationEntity dxsAuthentication, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsAuthenticationEntity>> failures = validator.validate(dxsAuthentication);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsAuthenticationService.save(dxsAuthentication);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsAuthentication.getId();
		URI uri = uriBuilder.path("/rest/dxsAuthenticationController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsAuthenticationEntity dxsAuthentication) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsAuthenticationEntity>> failures = validator.validate(dxsAuthentication);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsAuthenticationService.saveOrUpdate(dxsAuthentication);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsAuthenticationService.deleteEntityById(DxsAuthenticationEntity.class, id);
	}
}
