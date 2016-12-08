package com.buss.invoices.controller;
import com.buss.common.entity.DxsUserDetailEntity;
import com.buss.invoices.entity.DxsInvoicesEntity;
import com.buss.invoices.service.DxsInvoicesServiceI;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.buss.user.entity.DxsUserEntity;
import org.apache.log4j.Logger;
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
 * @Description: dxs_invoices
 * @author dq
 * @date 2016-09-23 14:59:30
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsInvoicesController")
public class DxsInvoicesController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsInvoicesController.class);

	@Autowired
	private DxsInvoicesServiceI dxsInvoicesService;
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
	 * dxs_invoices列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/invoices/dxsInvoicesList");
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
	public void datagrid(DxsInvoicesEntity dxsInvoices,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {

		dxsInvoices.setIsDelete(0);

		CriteriaQuery cq = new CriteriaQuery(DxsInvoicesEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsInvoices, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsInvoicesService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_invoices
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsInvoicesEntity dxsInvoices, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsInvoices = systemService.getEntity(DxsInvoicesEntity.class, dxsInvoices.getId());
		message = "dxs_invoices删除成功";
		try{

			dxsInvoices.setIsDelete(1);
			dxsInvoicesService.saveOrUpdate(dxsInvoices);

			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_invoices删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除dxs_invoices
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "dxs_invoices删除成功";
		try{
			for(String id:ids.split(",")){
				DxsInvoicesEntity dxsInvoices = systemService.getEntity(DxsInvoicesEntity.class, 
				id
				);

				dxsInvoices.setIsDelete(1);
				dxsInvoicesService.saveOrUpdate(dxsInvoices);

				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_invoices删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加dxs_invoices
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsInvoicesEntity dxsInvoices, HttpServletRequest request) {

		Date date = new Date();
		dxsInvoices.setUpdateTime(date);
		dxsInvoices.setCreateTime(date);
		dxsInvoices.setIsDelete(0);

		AjaxJson j = new AjaxJson();
		message = "dxs_invoices添加成功";
		try{
			dxsInvoicesService.save(dxsInvoices);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_invoices添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新dxs_invoices
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsInvoicesEntity dxsInvoices, HttpServletRequest request) {

		Date date = new Date();
		dxsInvoices.setUpdateTime(date);

		AjaxJson j = new AjaxJson();
		message = "dxs_invoices更新成功";
		DxsInvoicesEntity t = dxsInvoicesService.get(DxsInvoicesEntity.class, dxsInvoices.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsInvoices, t);
			dxsInvoicesService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "dxs_invoices更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * dxs_invoices新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DxsInvoicesEntity dxsInvoices, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsInvoices.getId())) {
			dxsInvoices = dxsInvoicesService.getEntity(DxsInvoicesEntity.class, dxsInvoices.getId());
			req.setAttribute("dxsInvoicesPage", dxsInvoices);
		}

		DxsUserDetailEntity dxsUserDetailEntity=new DxsUserDetailEntity();
		dxsUserDetailEntity.setIsDelete(0);
		List<DxsUserDetailEntity>  dxsUserDetailEntityList=systemService.findByExample(DxsUserDetailEntity.class.getName(),dxsUserDetailEntity);
		req.setAttribute("dxsUserDetailEntityList",dxsUserDetailEntityList);

	return new ModelAndView("com/buss/invoices/dxsInvoices-add");
	}
	/**
	 * dxs_invoices编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsInvoicesEntity dxsInvoices, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsInvoices.getId())) {
			dxsInvoices = dxsInvoicesService.getEntity(DxsInvoicesEntity.class, dxsInvoices.getId());
			req.setAttribute("dxsInvoicesPage", dxsInvoices);
		}

		DxsUserDetailEntity dxsUserDetailEntity=new DxsUserDetailEntity();
		dxsUserDetailEntity.setIsDelete(0);
		List<DxsUserDetailEntity>  dxsUserDetailEntityList=systemService.findByExample(DxsUserDetailEntity.class.getName(),dxsUserDetailEntity);
		req.setAttribute("dxsUserDetailEntityList",dxsUserDetailEntityList);

		return new ModelAndView("com/buss/invoices/dxsInvoices-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsInvoicesController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsInvoicesEntity dxsInvoices,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsInvoicesEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsInvoices, request.getParameterMap());
		List<DxsInvoicesEntity> dxsInvoicess = this.dxsInvoicesService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_invoices");
		modelMap.put(NormalExcelConstants.CLASS,DxsInvoicesEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_invoices列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsInvoicess);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsInvoicesEntity dxsInvoices,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_invoices");
    	modelMap.put(NormalExcelConstants.CLASS,DxsInvoicesEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_invoices列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsInvoicesEntity> listDxsInvoicesEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsInvoicesEntity.class,params);
				for (DxsInvoicesEntity dxsInvoices : listDxsInvoicesEntitys) {
					dxsInvoicesService.save(dxsInvoices);
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
	public List<DxsInvoicesEntity> list() {
		List<DxsInvoicesEntity> listDxsInvoicess=dxsInvoicesService.getList(DxsInvoicesEntity.class);
		return listDxsInvoicess;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsInvoicesEntity task = dxsInvoicesService.get(DxsInvoicesEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsInvoicesEntity dxsInvoices, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsInvoicesEntity>> failures = validator.validate(dxsInvoices);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsInvoicesService.save(dxsInvoices);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsInvoices.getId();
		URI uri = uriBuilder.path("/rest/dxsInvoicesController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsInvoicesEntity dxsInvoices) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsInvoicesEntity>> failures = validator.validate(dxsInvoices);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsInvoicesService.saveOrUpdate(dxsInvoices);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsInvoicesService.deleteEntityById(DxsInvoicesEntity.class, id);
	}
}
