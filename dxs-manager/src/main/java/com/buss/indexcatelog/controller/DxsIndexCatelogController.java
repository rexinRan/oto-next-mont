package com.buss.indexcatelog.controller;
import com.buss.indexcatelog.entity.DxsIndexCatelogEntity;
import com.buss.indexcatelog.service.DxsIndexCatelogServiceI;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
 * @Description: dxs_index_catelog
 * @author onlineGenerator
 * @date 2016-07-12 16:38:40
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsIndexCatelogController")
public class DxsIndexCatelogController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsIndexCatelogController.class);

	@Autowired
	private DxsIndexCatelogServiceI dxsIndexCatelogService;
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
	 * dxs_index_catelog列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/indexcatelog/dxsIndexCatelogList");
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
	public void datagrid(DxsIndexCatelogEntity dxsIndexCatelog,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DxsIndexCatelogEntity.class, dataGrid);
		//查询条件组装器
		dxsIndexCatelog.setIsDelete(0);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsIndexCatelog, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsIndexCatelogService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_index_catelog
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsIndexCatelogEntity dxsIndexCatelog, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsIndexCatelog = systemService.getEntity(DxsIndexCatelogEntity.class, dxsIndexCatelog.getId());
		message = "dxs_index_catelog删除成功";
		try{
			dxsIndexCatelog.setIsDelete(1);
			dxsIndexCatelogService.updateEntitie(dxsIndexCatelog);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_index_catelog删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除dxs_index_catelog
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "dxs_index_catelog删除成功";
		try{
			for(String id:ids.split(",")){
				DxsIndexCatelogEntity dxsIndexCatelog = systemService.getEntity(DxsIndexCatelogEntity.class, 
				id
				);
				dxsIndexCatelog.setIsDelete(1);
				dxsIndexCatelogService.updateEntitie(dxsIndexCatelog);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_index_catelog删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加dxs_index_catelog
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsIndexCatelogEntity dxsIndexCatelog, HttpServletRequest request) {
		Date date =new Date();
		dxsIndexCatelog.setCreateTime(date);
		dxsIndexCatelog.setUpdateTime(date);
		dxsIndexCatelog.setIsDelete(0);
		AjaxJson j = new AjaxJson();
		message = "dxs_index_catelog添加成功";
		try{
			dxsIndexCatelogService.save(dxsIndexCatelog);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_index_catelog添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新dxs_index_catelog
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsIndexCatelogEntity dxsIndexCatelog, HttpServletRequest request) {
		Date date =new Date();
		dxsIndexCatelog.setUpdateTime(date);
		AjaxJson j = new AjaxJson();
		message = "dxs_index_catelog更新成功";
		DxsIndexCatelogEntity t = dxsIndexCatelogService.get(DxsIndexCatelogEntity.class, dxsIndexCatelog.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsIndexCatelog, t);
			dxsIndexCatelogService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "dxs_index_catelog更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * dxs_index_catelog新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DxsIndexCatelogEntity dxsIndexCatelog, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsIndexCatelog.getId())) {
			dxsIndexCatelog = dxsIndexCatelogService.getEntity(DxsIndexCatelogEntity.class, dxsIndexCatelog.getId());
			req.setAttribute("dxsIndexCatelogPage", dxsIndexCatelog);
		}
		return new ModelAndView("com/buss/indexcatelog/dxsIndexCatelog-add");
	}
	/**
	 * dxs_index_catelog编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsIndexCatelogEntity dxsIndexCatelog, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsIndexCatelog.getId())) {
			dxsIndexCatelog = dxsIndexCatelogService.getEntity(DxsIndexCatelogEntity.class, dxsIndexCatelog.getId());
			req.setAttribute("dxsIndexCatelogPage", dxsIndexCatelog);
		}
		return new ModelAndView("com/buss/indexcatelog/dxsIndexCatelog-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsIndexCatelogController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsIndexCatelogEntity dxsIndexCatelog,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsIndexCatelogEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsIndexCatelog, request.getParameterMap());
		List<DxsIndexCatelogEntity> dxsIndexCatelogs = this.dxsIndexCatelogService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_index_catelog");
		modelMap.put(NormalExcelConstants.CLASS,DxsIndexCatelogEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_index_catelog列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsIndexCatelogs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsIndexCatelogEntity dxsIndexCatelog,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_index_catelog");
    	modelMap.put(NormalExcelConstants.CLASS,DxsIndexCatelogEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_index_catelog列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsIndexCatelogEntity> listDxsIndexCatelogEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsIndexCatelogEntity.class,params);
				for (DxsIndexCatelogEntity dxsIndexCatelog : listDxsIndexCatelogEntitys) {
					dxsIndexCatelogService.save(dxsIndexCatelog);
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
	public List<DxsIndexCatelogEntity> list() {
		List<DxsIndexCatelogEntity> listDxsIndexCatelogs=dxsIndexCatelogService.getList(DxsIndexCatelogEntity.class);
		return listDxsIndexCatelogs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsIndexCatelogEntity task = dxsIndexCatelogService.get(DxsIndexCatelogEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsIndexCatelogEntity dxsIndexCatelog, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsIndexCatelogEntity>> failures = validator.validate(dxsIndexCatelog);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsIndexCatelogService.save(dxsIndexCatelog);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsIndexCatelog.getId();
		URI uri = uriBuilder.path("/rest/dxsIndexCatelogController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsIndexCatelogEntity dxsIndexCatelog) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsIndexCatelogEntity>> failures = validator.validate(dxsIndexCatelog);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsIndexCatelogService.saveOrUpdate(dxsIndexCatelog);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsIndexCatelogService.deleteEntityById(DxsIndexCatelogEntity.class, id);
	}
}
