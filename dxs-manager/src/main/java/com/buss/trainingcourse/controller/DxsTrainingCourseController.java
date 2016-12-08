package com.buss.trainingcourse.controller;
import com.buss.trainingcatalog.entity.DxsTrainingCatalogEntity;
import com.buss.trainingcourse.entity.DxsTrainingCourseEntity;
import com.buss.trainingcourse.service.DxsTrainingCourseServiceI;

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
 * @Description: dxs_training_course
 * @author onlineGenerator
 * @date 2016-07-01 10:59:40
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsTrainingCourseController")
public class DxsTrainingCourseController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsTrainingCourseController.class);

	@Autowired
	private DxsTrainingCourseServiceI dxsTrainingCourseService;
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
	 * dxs_training_course列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/trainingcourse/dxsTrainingCourseList");
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
	public void datagrid(DxsTrainingCourseEntity dxsTrainingCourse,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		dxsTrainingCourse.setIsDelete(0);
		CriteriaQuery cq = new CriteriaQuery(DxsTrainingCourseEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsTrainingCourse, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsTrainingCourseService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_training_course
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsTrainingCourseEntity dxsTrainingCourse, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsTrainingCourse = systemService.getEntity(DxsTrainingCourseEntity.class, dxsTrainingCourse.getId());
		message = "删除成功";
		try{
			dxsTrainingCourse.setIsDelete(1);
			dxsTrainingCourseService.updateEntitie(dxsTrainingCourse);
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
	 * 批量删除dxs_training_course
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
				DxsTrainingCourseEntity dxsTrainingCourse = systemService.getEntity(DxsTrainingCourseEntity.class, 
				id
				);
				dxsTrainingCourse.setIsDelete(1);
				dxsTrainingCourseService.updateEntitie(dxsTrainingCourse);
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
	 * 添加dxs_training_course
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsTrainingCourseEntity dxsTrainingCourse, HttpServletRequest request) {
		dxsTrainingCourse.setIsDelete(0);
		Date date=new Date();
		dxsTrainingCourse.setCoursePublishTime(date);
		AjaxJson j = new AjaxJson();
		message = "添加成功";
		try{
			dxsTrainingCourseService.save(dxsTrainingCourse);
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
	 * 更新dxs_training_course
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsTrainingCourseEntity dxsTrainingCourse, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "更新成功";
		DxsTrainingCourseEntity t = dxsTrainingCourseService.get(DxsTrainingCourseEntity.class, dxsTrainingCourse.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsTrainingCourse, t);
			dxsTrainingCourseService.saveOrUpdate(t);
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
	 * dxs_training_course新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DxsTrainingCourseEntity dxsTrainingCourse, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsTrainingCourse.getId())) {
			dxsTrainingCourse = dxsTrainingCourseService.getEntity(DxsTrainingCourseEntity.class, dxsTrainingCourse.getId());
			req.setAttribute("dxsTrainingCoursePage", dxsTrainingCourse);
		}
		List <DxsTrainingCatalogEntity>  dxsTrainingCatalogList=systemService.findByProperty(DxsTrainingCatalogEntity.class,"isDelete",0);
		req.setAttribute("dxsTrainingCatalogList",dxsTrainingCatalogList);
		return new ModelAndView("com/buss/trainingcourse/dxsTrainingCourse-add");
	}
	/**
	 * dxs_training_course编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsTrainingCourseEntity dxsTrainingCourse, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsTrainingCourse.getId())) {
			dxsTrainingCourse = dxsTrainingCourseService.getEntity(DxsTrainingCourseEntity.class, dxsTrainingCourse.getId());
			req.setAttribute("dxsTrainingCoursePage", dxsTrainingCourse);
		}
		List <DxsTrainingCatalogEntity>  dxsTrainingCatalogList=systemService.findByProperty(DxsTrainingCatalogEntity.class,"isDelete",0);
		req.setAttribute("dxsTrainingCatalogList",dxsTrainingCatalogList);
		return new ModelAndView("com/buss/trainingcourse/dxsTrainingCourse-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsTrainingCourseController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsTrainingCourseEntity dxsTrainingCourse,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsTrainingCourseEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsTrainingCourse, request.getParameterMap());
		List<DxsTrainingCourseEntity> dxsTrainingCourses = this.dxsTrainingCourseService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_training_course");
		modelMap.put(NormalExcelConstants.CLASS,DxsTrainingCourseEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_training_course列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsTrainingCourses);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsTrainingCourseEntity dxsTrainingCourse,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_training_course");
    	modelMap.put(NormalExcelConstants.CLASS,DxsTrainingCourseEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_training_course列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsTrainingCourseEntity> listDxsTrainingCourseEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsTrainingCourseEntity.class,params);
				for (DxsTrainingCourseEntity dxsTrainingCourse : listDxsTrainingCourseEntitys) {
					dxsTrainingCourseService.save(dxsTrainingCourse);
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
	public List<DxsTrainingCourseEntity> list() {
		List<DxsTrainingCourseEntity> listDxsTrainingCourses=dxsTrainingCourseService.getList(DxsTrainingCourseEntity.class);
		return listDxsTrainingCourses;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsTrainingCourseEntity task = dxsTrainingCourseService.get(DxsTrainingCourseEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsTrainingCourseEntity dxsTrainingCourse, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsTrainingCourseEntity>> failures = validator.validate(dxsTrainingCourse);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsTrainingCourseService.save(dxsTrainingCourse);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsTrainingCourse.getId();
		URI uri = uriBuilder.path("/rest/dxsTrainingCourseController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsTrainingCourseEntity dxsTrainingCourse) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsTrainingCourseEntity>> failures = validator.validate(dxsTrainingCourse);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsTrainingCourseService.saveOrUpdate(dxsTrainingCourse);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsTrainingCourseService.deleteEntityById(DxsTrainingCourseEntity.class, id);
	}
}
