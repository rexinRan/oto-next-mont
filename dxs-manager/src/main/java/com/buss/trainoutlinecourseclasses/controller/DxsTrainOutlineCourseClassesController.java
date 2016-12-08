package com.buss.trainoutlinecourseclasses.controller;
import com.buss.trainoutlinecourseclasses.entity.DxsTrainOutlineCourseClassesEntity;
import com.buss.trainoutlinecourseclasses.service.DxsTrainOutlineCourseClassesServiceI;
import java.util.ArrayList;
import java.util.List;
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
import java.util.Map;
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
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.net.URI;
import org.springframework.http.MediaType;
import org.springframework.web.util.UriComponentsBuilder;

/**   
 * @Title: Controller
 * @Description: dxs_train_outline_course_classes
 * @author onlineGenerator
 * @date 2016-09-09 11:01:06
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsTrainOutlineCourseClassesController")
public class DxsTrainOutlineCourseClassesController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsTrainOutlineCourseClassesController.class);

	@Autowired
	private DxsTrainOutlineCourseClassesServiceI dxsTrainOutlineCourseClassesService;
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
	 * dxs_train_outline_course_classes列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(String tocId,HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView("com/buss/trainoutlinecourseclasses/dxsTrainOutlineCourseClassesList");
		modelAndView.addObject("tocId",tocId);
		return modelAndView;
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
	public void datagrid(DxsTrainOutlineCourseClassesEntity dxsTrainOutlineCourseClasses,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DxsTrainOutlineCourseClassesEntity.class, dataGrid);
		//查询条件组装器
		dxsTrainOutlineCourseClasses.setIsDelete(0);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsTrainOutlineCourseClasses, request.getParameterMap());
		try{
		//自定义追加查询条件
			cq.eq("tocId",dxsTrainOutlineCourseClasses.getTocId());
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsTrainOutlineCourseClassesService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_train_outline_course_classes
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsTrainOutlineCourseClassesEntity dxsTrainOutlineCourseClasses, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsTrainOutlineCourseClasses = systemService.getEntity(DxsTrainOutlineCourseClassesEntity.class, dxsTrainOutlineCourseClasses.getId());
		message = "dxs_train_outline_course_classes删除成功";
		try{
			dxsTrainOutlineCourseClasses.setIsDelete(1);
			dxsTrainOutlineCourseClassesService.saveOrUpdate(dxsTrainOutlineCourseClasses);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_train_outline_course_classes删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除dxs_train_outline_course_classes
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "dxs_train_outline_course_classes删除成功";
		try{
			for(String id:ids.split(",")){
				DxsTrainOutlineCourseClassesEntity dxsTrainOutlineCourseClasses = systemService.getEntity(DxsTrainOutlineCourseClassesEntity.class, 
				id
				);
				dxsTrainOutlineCourseClasses.setIsDelete(1);
				dxsTrainOutlineCourseClassesService.saveOrUpdate(dxsTrainOutlineCourseClasses);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_train_outline_course_classes删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加dxs_train_outline_course_classes
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsTrainOutlineCourseClassesEntity dxsTrainOutlineCourseClasses, HttpServletRequest request) {
		dxsTrainOutlineCourseClasses.setIsDelete(0);
		AjaxJson j = new AjaxJson();
		message = "dxs_train_outline_course_classes添加成功";
		try{
			dxsTrainOutlineCourseClassesService.save(dxsTrainOutlineCourseClasses);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_train_outline_course_classes添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新dxs_train_outline_course_classes
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsTrainOutlineCourseClassesEntity dxsTrainOutlineCourseClasses, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "dxs_train_outline_course_classes更新成功";
		DxsTrainOutlineCourseClassesEntity t = dxsTrainOutlineCourseClassesService.get(DxsTrainOutlineCourseClassesEntity.class, dxsTrainOutlineCourseClasses.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsTrainOutlineCourseClasses, t);
			dxsTrainOutlineCourseClassesService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "dxs_train_outline_course_classes更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * dxs_train_outline_course_classes新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(String tocId,DxsTrainOutlineCourseClassesEntity dxsTrainOutlineCourseClasses, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsTrainOutlineCourseClasses.getId())) {
			dxsTrainOutlineCourseClasses = dxsTrainOutlineCourseClassesService.getEntity(DxsTrainOutlineCourseClassesEntity.class, dxsTrainOutlineCourseClasses.getId());
			req.setAttribute("dxsTrainOutlineCourseClassesPage", dxsTrainOutlineCourseClasses);
		}
		ModelAndView modelAndView=new ModelAndView("com/buss/trainoutlinecourseclasses/dxsTrainOutlineCourseClasses-add");
		modelAndView.addObject("tocId",tocId);
		return modelAndView;
	}
	/**
	 * dxs_train_outline_course_classes编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsTrainOutlineCourseClassesEntity dxsTrainOutlineCourseClasses, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsTrainOutlineCourseClasses.getId())) {
			dxsTrainOutlineCourseClasses = dxsTrainOutlineCourseClassesService.getEntity(DxsTrainOutlineCourseClassesEntity.class, dxsTrainOutlineCourseClasses.getId());
			req.setAttribute("dxsTrainOutlineCourseClassesPage", dxsTrainOutlineCourseClasses);
		}
		return new ModelAndView("com/buss/trainoutlinecourseclasses/dxsTrainOutlineCourseClasses-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsTrainOutlineCourseClassesController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsTrainOutlineCourseClassesEntity dxsTrainOutlineCourseClasses,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsTrainOutlineCourseClassesEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsTrainOutlineCourseClasses, request.getParameterMap());
		List<DxsTrainOutlineCourseClassesEntity> dxsTrainOutlineCourseClassess = this.dxsTrainOutlineCourseClassesService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_train_outline_course_classes");
		modelMap.put(NormalExcelConstants.CLASS,DxsTrainOutlineCourseClassesEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_train_outline_course_classes列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsTrainOutlineCourseClassess);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsTrainOutlineCourseClassesEntity dxsTrainOutlineCourseClasses,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_train_outline_course_classes");
    	modelMap.put(NormalExcelConstants.CLASS,DxsTrainOutlineCourseClassesEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_train_outline_course_classes列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsTrainOutlineCourseClassesEntity> listDxsTrainOutlineCourseClassesEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsTrainOutlineCourseClassesEntity.class,params);
				for (DxsTrainOutlineCourseClassesEntity dxsTrainOutlineCourseClasses : listDxsTrainOutlineCourseClassesEntitys) {
					dxsTrainOutlineCourseClassesService.save(dxsTrainOutlineCourseClasses);
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
	public List<DxsTrainOutlineCourseClassesEntity> list() {
		List<DxsTrainOutlineCourseClassesEntity> listDxsTrainOutlineCourseClassess=dxsTrainOutlineCourseClassesService.getList(DxsTrainOutlineCourseClassesEntity.class);
		return listDxsTrainOutlineCourseClassess;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsTrainOutlineCourseClassesEntity task = dxsTrainOutlineCourseClassesService.get(DxsTrainOutlineCourseClassesEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsTrainOutlineCourseClassesEntity dxsTrainOutlineCourseClasses, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsTrainOutlineCourseClassesEntity>> failures = validator.validate(dxsTrainOutlineCourseClasses);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsTrainOutlineCourseClassesService.save(dxsTrainOutlineCourseClasses);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsTrainOutlineCourseClasses.getId();
		URI uri = uriBuilder.path("/rest/dxsTrainOutlineCourseClassesController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsTrainOutlineCourseClassesEntity dxsTrainOutlineCourseClasses) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsTrainOutlineCourseClassesEntity>> failures = validator.validate(dxsTrainOutlineCourseClasses);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsTrainOutlineCourseClassesService.saveOrUpdate(dxsTrainOutlineCourseClasses);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsTrainOutlineCourseClassesService.deleteEntityById(DxsTrainOutlineCourseClassesEntity.class, id);
	}
}
