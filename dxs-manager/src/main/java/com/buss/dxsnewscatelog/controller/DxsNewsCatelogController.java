package com.buss.dxsnewscatelog.controller;
import com.buss.dxsnewscatelog.entity.DxsNewsCatelogEntity;
import com.buss.dxsnewscatelog.service.DxsNewsCatelogServiceI;

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
 * @Description: dxs_news_catelog
 * @author onlineGenerator
 * @date 2016-05-31 09:44:24
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsNewsCatelogController")
public class DxsNewsCatelogController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsNewsCatelogController.class);

	@Autowired
	private DxsNewsCatelogServiceI dxsNewsCatelogService;
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
	 * dxs_news_catelog列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/dxsnewscatelog/dxsNewsCatelogList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param dxsNewsCatelog
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(DxsNewsCatelogEntity dxsNewsCatelog,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {

		// 王腾云
		// 增加有效标志
		dxsNewsCatelog.setIsDelete(0);

		CriteriaQuery cq = new CriteriaQuery(DxsNewsCatelogEntity.class, dataGrid);

		// 王腾云
		// 添加排序字段
		cq.addOrder("sort", SortDirection.desc);

		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsNewsCatelog, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsNewsCatelogService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_news_catelog
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsNewsCatelogEntity dxsNewsCatelog, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsNewsCatelog = systemService.getEntity(DxsNewsCatelogEntity.class, dxsNewsCatelog.getId());
		message = "删除成功";
		try{
			dxsNewsCatelog.setIsDelete(1);
			dxsNewsCatelogService.updateEntitie(dxsNewsCatelog);
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
	 * 批量删除dxs_news_catelog
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
				DxsNewsCatelogEntity dxsNewsCatelog = systemService.getEntity(DxsNewsCatelogEntity.class, 
				id
				);
				dxsNewsCatelog.setIsDelete(1);
				dxsNewsCatelogService.updateEntitie(dxsNewsCatelog);
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
	 * 添加dxs_news_catelog
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsNewsCatelogEntity dxsNewsCatelog, HttpServletRequest request) {

		// 王腾云
		// 添加默认字段值
		Date date = new Date();
		dxsNewsCatelog.setCreateTime(date);
		dxsNewsCatelog.setUpdateTime(date);
		dxsNewsCatelog.setIsDelete(0);

		AjaxJson j = new AjaxJson();
		message = "添加成功";
		try{
			dxsNewsCatelogService.save(dxsNewsCatelog);
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
	 * 更新dxs_news_catelog
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsNewsCatelogEntity dxsNewsCatelog, HttpServletRequest request) {
		Date date=new Date();
		dxsNewsCatelog.setUpdateTime(date);
		AjaxJson j = new AjaxJson();
		message = "更新成功";
		DxsNewsCatelogEntity t = dxsNewsCatelogService.get(DxsNewsCatelogEntity.class, dxsNewsCatelog.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsNewsCatelog, t);
			dxsNewsCatelogService.saveOrUpdate(t);
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
	 * dxs_news_catelog新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DxsNewsCatelogEntity dxsNewsCatelog, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsNewsCatelog.getId())) {
			dxsNewsCatelog = dxsNewsCatelogService.getEntity(DxsNewsCatelogEntity.class, dxsNewsCatelog.getId());
			req.setAttribute("dxsNewsCatelogPage", dxsNewsCatelog);
		}
		return new ModelAndView("com/buss/dxsnewscatelog/dxsNewsCatelog-add");
	}
	/**
	 * dxs_news_catelog编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsNewsCatelogEntity dxsNewsCatelog, HttpServletRequest req) {

		if (StringUtil.isNotEmpty(dxsNewsCatelog.getId())) {
			dxsNewsCatelog = dxsNewsCatelogService.getEntity(DxsNewsCatelogEntity.class, dxsNewsCatelog.getId());
			req.setAttribute("dxsNewsCatelogPage", dxsNewsCatelog);
		}
		return new ModelAndView("com/buss/dxsnewscatelog/dxsNewsCatelog-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsNewsCatelogController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsNewsCatelogEntity dxsNewsCatelog,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsNewsCatelogEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsNewsCatelog, request.getParameterMap());
		List<DxsNewsCatelogEntity> dxsNewsCatelogs = this.dxsNewsCatelogService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_news_catelog");
		modelMap.put(NormalExcelConstants.CLASS,DxsNewsCatelogEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_news_catelog列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsNewsCatelogs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsNewsCatelogEntity dxsNewsCatelog,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_news_catelog");
    	modelMap.put(NormalExcelConstants.CLASS,DxsNewsCatelogEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_news_catelog列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsNewsCatelogEntity> listDxsNewsCatelogEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsNewsCatelogEntity.class,params);
				for (DxsNewsCatelogEntity dxsNewsCatelog : listDxsNewsCatelogEntitys) {
					dxsNewsCatelogService.save(dxsNewsCatelog);
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
	public List<DxsNewsCatelogEntity> list() {
		List<DxsNewsCatelogEntity> listDxsNewsCatelogs=dxsNewsCatelogService.getList(DxsNewsCatelogEntity.class);
		return listDxsNewsCatelogs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsNewsCatelogEntity task = dxsNewsCatelogService.get(DxsNewsCatelogEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsNewsCatelogEntity dxsNewsCatelog, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsNewsCatelogEntity>> failures = validator.validate(dxsNewsCatelog);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsNewsCatelogService.save(dxsNewsCatelog);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsNewsCatelog.getId();
		URI uri = uriBuilder.path("/rest/dxsNewsCatelogController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsNewsCatelogEntity dxsNewsCatelog) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsNewsCatelogEntity>> failures = validator.validate(dxsNewsCatelog);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsNewsCatelogService.saveOrUpdate(dxsNewsCatelog);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsNewsCatelogService.deleteEntityById(DxsNewsCatelogEntity.class, id);
	}
}
