package com.buss.careerguidancecatalog.controller;
import com.buss.careerguidancecatalog.entity.DxsCareerGuidanceCatalogEntity;
import com.buss.careerguidancecatalog.service.DxsCareerGuidanceCatalogServiceI;

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
 * @Description: dxs_career_guidance_catalog
 * @author dq
 * @date 2016-08-24 13:52:17
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsCareerGuidanceCatalogController")
public class DxsCareerGuidanceCatalogController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsCareerGuidanceCatalogController.class);

	@Autowired
	private DxsCareerGuidanceCatalogServiceI dxsCareerGuidanceCatalogService;
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
	 * dxs_career_guidance_catalog列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/careerguidancecatalog/dxsCareerGuidanceCatalogList");
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
	public void datagrid(DxsCareerGuidanceCatalogEntity dxsCareerGuidanceCatalog,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {

		dxsCareerGuidanceCatalog.setIsDelete(0);

		CriteriaQuery cq = new CriteriaQuery(DxsCareerGuidanceCatalogEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsCareerGuidanceCatalog, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsCareerGuidanceCatalogService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_career_guidance_catalog
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsCareerGuidanceCatalogEntity dxsCareerGuidanceCatalog, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsCareerGuidanceCatalog = systemService.getEntity(DxsCareerGuidanceCatalogEntity.class, dxsCareerGuidanceCatalog.getId());
		message = "dxs_career_guidance_catalog删除成功";
		try{

			dxsCareerGuidanceCatalog.setIsDelete(1);
			dxsCareerGuidanceCatalogService.saveOrUpdate(dxsCareerGuidanceCatalog);

			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_career_guidance_catalog删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除dxs_career_guidance_catalog
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "dxs_career_guidance_catalog删除成功";
		try{
			for(String id:ids.split(",")){
				DxsCareerGuidanceCatalogEntity dxsCareerGuidanceCatalog = systemService.getEntity(DxsCareerGuidanceCatalogEntity.class, 
				id
				);

				dxsCareerGuidanceCatalog.setIsDelete(1);
				dxsCareerGuidanceCatalogService.saveOrUpdate(dxsCareerGuidanceCatalog);

				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_career_guidance_catalog删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加dxs_career_guidance_catalog
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsCareerGuidanceCatalogEntity dxsCareerGuidanceCatalog, HttpServletRequest request) {

		Date date = new Date();
		dxsCareerGuidanceCatalog.setUpdateTime(date);
		dxsCareerGuidanceCatalog.setCreateTime(date);
		dxsCareerGuidanceCatalog.setIsDelete(0);

		AjaxJson j = new AjaxJson();
		message = "dxs_career_guidance_catalog添加成功";
		try{
			dxsCareerGuidanceCatalogService.save(dxsCareerGuidanceCatalog);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_career_guidance_catalog添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新dxs_career_guidance_catalog
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsCareerGuidanceCatalogEntity dxsCareerGuidanceCatalog, HttpServletRequest request) {

		Date date = new Date();
		dxsCareerGuidanceCatalog.setUpdateTime(date);

		AjaxJson j = new AjaxJson();
		message = "dxs_career_guidance_catalog更新成功";
		DxsCareerGuidanceCatalogEntity t = dxsCareerGuidanceCatalogService.get(DxsCareerGuidanceCatalogEntity.class, dxsCareerGuidanceCatalog.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsCareerGuidanceCatalog, t);
			dxsCareerGuidanceCatalogService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "dxs_career_guidance_catalog更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * dxs_career_guidance_catalog新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DxsCareerGuidanceCatalogEntity dxsCareerGuidanceCatalog, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsCareerGuidanceCatalog.getId())) {
			dxsCareerGuidanceCatalog = dxsCareerGuidanceCatalogService.getEntity(DxsCareerGuidanceCatalogEntity.class, dxsCareerGuidanceCatalog.getId());
			req.setAttribute("dxsCareerGuidanceCatalogPage", dxsCareerGuidanceCatalog);
		}
		DxsCareerGuidanceCatalogEntity dxsCareerGuidanceCatalogEntity=new DxsCareerGuidanceCatalogEntity();
		dxsCareerGuidanceCatalogEntity.setIsDelete(0);
		dxsCareerGuidanceCatalogEntity.setPid("0");
		List<DxsCareerGuidanceCatalogEntity> dxsCareerGuidanceCatalogList= systemService.findByExample(DxsCareerGuidanceCatalogEntity.class.getName(),dxsCareerGuidanceCatalogEntity);
		req.setAttribute("dxsCareerGuidanceCatalogList",dxsCareerGuidanceCatalogList);
		return new ModelAndView("com/buss/careerguidancecatalog/dxsCareerGuidanceCatalog-add");
	}
	/**
	 * dxs_career_guidance_catalog编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsCareerGuidanceCatalogEntity dxsCareerGuidanceCatalog, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsCareerGuidanceCatalog.getId())) {
			dxsCareerGuidanceCatalog = dxsCareerGuidanceCatalogService.getEntity(DxsCareerGuidanceCatalogEntity.class, dxsCareerGuidanceCatalog.getId());
			req.setAttribute("dxsCareerGuidanceCatalogPage", dxsCareerGuidanceCatalog);
		}
		DxsCareerGuidanceCatalogEntity dxsCareerGuidanceCatalogEntity=new DxsCareerGuidanceCatalogEntity();
		dxsCareerGuidanceCatalogEntity.setIsDelete(0);
		dxsCareerGuidanceCatalogEntity.setPid("0");
		List<DxsCareerGuidanceCatalogEntity> dxsCareerGuidanceCatalogList= systemService.findByExample(DxsCareerGuidanceCatalogEntity.class.getName(),dxsCareerGuidanceCatalogEntity);
		req.setAttribute("dxsCareerGuidanceCatalogList",dxsCareerGuidanceCatalogList);
		return new ModelAndView("com/buss/careerguidancecatalog/dxsCareerGuidanceCatalog-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsCareerGuidanceCatalogController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsCareerGuidanceCatalogEntity dxsCareerGuidanceCatalog,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsCareerGuidanceCatalogEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsCareerGuidanceCatalog, request.getParameterMap());
		List<DxsCareerGuidanceCatalogEntity> dxsCareerGuidanceCatalogs = this.dxsCareerGuidanceCatalogService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_career_guidance_catalog");
		modelMap.put(NormalExcelConstants.CLASS,DxsCareerGuidanceCatalogEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_career_guidance_catalog列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsCareerGuidanceCatalogs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsCareerGuidanceCatalogEntity dxsCareerGuidanceCatalog,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_career_guidance_catalog");
    	modelMap.put(NormalExcelConstants.CLASS,DxsCareerGuidanceCatalogEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_career_guidance_catalog列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsCareerGuidanceCatalogEntity> listDxsCareerGuidanceCatalogEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsCareerGuidanceCatalogEntity.class,params);
				for (DxsCareerGuidanceCatalogEntity dxsCareerGuidanceCatalog : listDxsCareerGuidanceCatalogEntitys) {
					dxsCareerGuidanceCatalogService.save(dxsCareerGuidanceCatalog);
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
	public List<DxsCareerGuidanceCatalogEntity> list() {
		List<DxsCareerGuidanceCatalogEntity> listDxsCareerGuidanceCatalogs=dxsCareerGuidanceCatalogService.getList(DxsCareerGuidanceCatalogEntity.class);
		return listDxsCareerGuidanceCatalogs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsCareerGuidanceCatalogEntity task = dxsCareerGuidanceCatalogService.get(DxsCareerGuidanceCatalogEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsCareerGuidanceCatalogEntity dxsCareerGuidanceCatalog, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsCareerGuidanceCatalogEntity>> failures = validator.validate(dxsCareerGuidanceCatalog);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsCareerGuidanceCatalogService.save(dxsCareerGuidanceCatalog);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsCareerGuidanceCatalog.getId();
		URI uri = uriBuilder.path("/rest/dxsCareerGuidanceCatalogController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsCareerGuidanceCatalogEntity dxsCareerGuidanceCatalog) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsCareerGuidanceCatalogEntity>> failures = validator.validate(dxsCareerGuidanceCatalog);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsCareerGuidanceCatalogService.saveOrUpdate(dxsCareerGuidanceCatalog);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsCareerGuidanceCatalogService.deleteEntityById(DxsCareerGuidanceCatalogEntity.class, id);
	}
}
