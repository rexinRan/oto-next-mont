package com.buss.basecase.controller;
import com.buss.basecase.entity.DxsBaseCaseEntity;
import com.buss.basecase.service.DxsBaseCaseServiceI;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
 * @Description: dxs_base_case
 * @author onlineGenerator
 * @date 2016-07-25 14:00:59
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsBaseCaseController")
public class DxsBaseCaseController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsBaseCaseController.class);

	@Autowired
	private DxsBaseCaseServiceI dxsBaseCaseService;
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
	 * dxs_base_case列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(String dbId,HttpServletRequest request) {
		ModelAndView mod=new ModelAndView("com/buss/basecase/dxsBaseCaseList");
		mod.addObject("dbId",dbId);
		System.out.println(dbId);
		return mod;
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
	public void datagrid(DxsBaseCaseEntity dxsBaseCase,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DxsBaseCaseEntity.class, dataGrid);
		//查询条件组装器
		dxsBaseCase.setIsDelete(0);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsBaseCase, request.getParameterMap());
		try{
		//自定义追加查询条件
			cq.addOrder("createTime", SortDirection.desc);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsBaseCaseService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_base_case
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsBaseCaseEntity dxsBaseCase, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsBaseCase = systemService.getEntity(DxsBaseCaseEntity.class, dxsBaseCase.getId());
		message = "dxs_base_case删除成功";
		try{
			dxsBaseCase.setIsDelete(1);
			dxsBaseCaseService.updateEntitie(dxsBaseCase);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_base_case删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除dxs_base_case
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "dxs_base_case删除成功";
		try{
			for(String id:ids.split(",")){
				DxsBaseCaseEntity dxsBaseCase = systemService.getEntity(DxsBaseCaseEntity.class, 
				id
				);
				dxsBaseCase.setIsDelete(1);
				dxsBaseCaseService.updateEntitie(dxsBaseCase);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_base_case删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加dxs_base_case
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsBaseCaseEntity dxsBaseCase, HttpServletRequest request) {
		Date date =new Date();
		dxsBaseCase.setIsDelete(0);
		dxsBaseCase.setCreateTime(date);
		dxsBaseCase.setUpdateTime(date);
		AjaxJson j = new AjaxJson();
		message = "dxs_base_case添加成功";
		try{
			dxsBaseCaseService.save(dxsBaseCase);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_base_case添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新dxs_base_case
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsBaseCaseEntity dxsBaseCase, HttpServletRequest request) {
		Date date =new Date();
		dxsBaseCase.setUpdateTime(date);
		AjaxJson j = new AjaxJson();
		message = "dxs_base_case更新成功";
		DxsBaseCaseEntity t = dxsBaseCaseService.get(DxsBaseCaseEntity.class, dxsBaseCase.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsBaseCase, t);
			dxsBaseCaseService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "dxs_base_case更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * dxs_base_case新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(String dbId,DxsBaseCaseEntity dxsBaseCase, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsBaseCase.getId())) {
			dxsBaseCase = dxsBaseCaseService.getEntity(DxsBaseCaseEntity.class, dxsBaseCase.getId());
			req.setAttribute("dxsBaseCasePage", dxsBaseCase);
		}
		System.out.println(dbId);
		ModelAndView modelAndView=new ModelAndView("com/buss/basecase/dxsBaseCase-add");
		modelAndView.addObject("dbId",dbId);
		return modelAndView;
	}
	/**
	 * dxs_base_case编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsBaseCaseEntity dxsBaseCase, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsBaseCase.getId())) {
			dxsBaseCase = dxsBaseCaseService.getEntity(DxsBaseCaseEntity.class, dxsBaseCase.getId());
			req.setAttribute("dxsBaseCasePage", dxsBaseCase);
		}
		return new ModelAndView("com/buss/basecase/dxsBaseCase-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsBaseCaseController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsBaseCaseEntity dxsBaseCase,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsBaseCaseEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsBaseCase, request.getParameterMap());
		List<DxsBaseCaseEntity> dxsBaseCases = this.dxsBaseCaseService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_base_case");
		modelMap.put(NormalExcelConstants.CLASS,DxsBaseCaseEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_base_case列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsBaseCases);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsBaseCaseEntity dxsBaseCase,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_base_case");
    	modelMap.put(NormalExcelConstants.CLASS,DxsBaseCaseEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_base_case列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsBaseCaseEntity> listDxsBaseCaseEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsBaseCaseEntity.class,params);
				for (DxsBaseCaseEntity dxsBaseCase : listDxsBaseCaseEntitys) {
					dxsBaseCaseService.save(dxsBaseCase);
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
	public List<DxsBaseCaseEntity> list() {
		List<DxsBaseCaseEntity> listDxsBaseCases=dxsBaseCaseService.getList(DxsBaseCaseEntity.class);
		return listDxsBaseCases;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsBaseCaseEntity task = dxsBaseCaseService.get(DxsBaseCaseEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsBaseCaseEntity dxsBaseCase, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsBaseCaseEntity>> failures = validator.validate(dxsBaseCase);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsBaseCaseService.save(dxsBaseCase);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsBaseCase.getId();
		URI uri = uriBuilder.path("/rest/dxsBaseCaseController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsBaseCaseEntity dxsBaseCase) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsBaseCaseEntity>> failures = validator.validate(dxsBaseCase);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsBaseCaseService.saveOrUpdate(dxsBaseCase);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsBaseCaseService.deleteEntityById(DxsBaseCaseEntity.class, id);
	}
}
