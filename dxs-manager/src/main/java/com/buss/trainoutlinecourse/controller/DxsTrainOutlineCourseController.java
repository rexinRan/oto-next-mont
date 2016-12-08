package com.buss.trainoutlinecourse.controller;
import com.buss.authentication.entity.DxsAuthenticationEntity;
import com.buss.traincoursecatalog.entity.DxsTrainCourseCatalogEntity;
import com.buss.trainoutlinecourse.entity.DxsTrainOutlineCourseEntity;
import com.buss.trainoutlinecourse.service.DxsTrainOutlineCourseServiceI;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.buss.user.entity.DxsUserEntity;
import org.apache.log4j.Logger;
import org.apache.xmlbeans.impl.xb.xsdschema.RestrictionDocument;
import org.hibernate.criterion.Restrictions;
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
 * @Description: dxs_train_outline_course
 * @author dq
 * @date 2016-09-06 14:32:25
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsTrainOutlineCourseController")
public class DxsTrainOutlineCourseController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsTrainOutlineCourseController.class);

	@Autowired
	private DxsTrainOutlineCourseServiceI dxsTrainOutlineCourseService;
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
	 * dxs_train_outline_course列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/trainoutlinecourse/dxsTrainOutlineCourseList");
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
	public void datagrid(DxsTrainOutlineCourseEntity dxsTrainOutlineCourse,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {

		dxsTrainOutlineCourse.setIsDelete(0);

		CriteriaQuery cq = new CriteriaQuery(DxsTrainOutlineCourseEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsTrainOutlineCourse, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsTrainOutlineCourseService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_train_outline_course
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsTrainOutlineCourseEntity dxsTrainOutlineCourse, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsTrainOutlineCourse = systemService.getEntity(DxsTrainOutlineCourseEntity.class, dxsTrainOutlineCourse.getId());
		message = "dxs_train_outline_course删除成功";
		try{

			dxsTrainOutlineCourse.setIsDelete(1);
			dxsTrainOutlineCourseService.saveOrUpdate(dxsTrainOutlineCourse);

			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_train_outline_course删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除dxs_train_outline_course
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "dxs_train_outline_course删除成功";
		try{
			for(String id:ids.split(",")){
				DxsTrainOutlineCourseEntity dxsTrainOutlineCourse = systemService.getEntity(DxsTrainOutlineCourseEntity.class, 
				id
				);

				dxsTrainOutlineCourse.setIsDelete(1);
				dxsTrainOutlineCourseService.saveOrUpdate(dxsTrainOutlineCourse);

				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_train_outline_course删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加dxs_train_outline_course
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsTrainOutlineCourseEntity dxsTrainOutlineCourse, HttpServletRequest request) {

		Date date = new Date();
		dxsTrainOutlineCourse.setUpdateTime(date);
		dxsTrainOutlineCourse.setCreateTime(date);
		dxsTrainOutlineCourse.setIsDelete(0);

		AjaxJson j = new AjaxJson();
		message = "dxs_train_outline_course添加成功";
		try{
			dxsTrainOutlineCourseService.save(dxsTrainOutlineCourse);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_train_outline_course添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新dxs_train_outline_course
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsTrainOutlineCourseEntity dxsTrainOutlineCourse, HttpServletRequest request) {

		Date date = new Date();
		dxsTrainOutlineCourse.setUpdateTime(date);

		AjaxJson j = new AjaxJson();
		message = "dxs_train_outline_course更新成功";
		DxsTrainOutlineCourseEntity t = dxsTrainOutlineCourseService.get(DxsTrainOutlineCourseEntity.class, dxsTrainOutlineCourse.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsTrainOutlineCourse, t);
			dxsTrainOutlineCourseService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "dxs_train_outline_course更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * dxs_train_outline_course新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DxsTrainOutlineCourseEntity dxsTrainOutlineCourse, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsTrainOutlineCourse.getId())) {
			dxsTrainOutlineCourse = dxsTrainOutlineCourseService.getEntity(DxsTrainOutlineCourseEntity.class, dxsTrainOutlineCourse.getId());
			req.setAttribute("dxsTrainOutlineCoursePage", dxsTrainOutlineCourse);
		}
		//查询培训类型
		DxsTrainCourseCatalogEntity dxsTrainCourseCatalogEntity = new DxsTrainCourseCatalogEntity();
		dxsTrainCourseCatalogEntity.setIsDelete(0);
		List<DxsTrainCourseCatalogEntity> dxsTrainCourseCatalogList = systemService.findByExample(DxsTrainCourseCatalogEntity.class.getName(),dxsTrainCourseCatalogEntity);
		req.setAttribute("dxsTrainCourseCatalogList",dxsTrainCourseCatalogList);
		//查询导师
		CriteriaQuery cq = new CriteriaQuery(DxsAuthenticationEntity.class);
		cq.eq("isDelete",0);
		cq.or(Restrictions.eq("authenticationResult","8"),Restrictions.eq("authenticationResult","11"));
		cq.add();
		List<DxsAuthenticationEntity> dxsAuthenticationEntities = systemService.getListByCriteriaQuery(cq,false);
		List<DxsUserEntity> dxsUserList = new ArrayList<DxsUserEntity>();
		for(DxsAuthenticationEntity dxsAuthenticationEntity:dxsAuthenticationEntities){
			DxsUserEntity user = systemService.getEntity(DxsUserEntity.class,dxsAuthenticationEntity.getUserId());
			dxsUserList.add(user);
		}
		req.setAttribute("dxsUserList",dxsUserList);
		return new ModelAndView("com/buss/trainoutlinecourse/dxsTrainOutlineCourse-add");
	}
	/**
	 * dxs_train_outline_course编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsTrainOutlineCourseEntity dxsTrainOutlineCourse, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsTrainOutlineCourse.getId())) {
			dxsTrainOutlineCourse = dxsTrainOutlineCourseService.getEntity(DxsTrainOutlineCourseEntity.class, dxsTrainOutlineCourse.getId());
			req.setAttribute("dxsTrainOutlineCoursePage", dxsTrainOutlineCourse);
		}
		//查询培训类型
		DxsTrainCourseCatalogEntity dxsTrainCourseCatalogEntity = new DxsTrainCourseCatalogEntity();
		dxsTrainCourseCatalogEntity.setIsDelete(0);
		List<DxsTrainCourseCatalogEntity> dxsTrainCourseCatalogList = systemService.findByExample(DxsTrainCourseCatalogEntity.class.getName(),dxsTrainCourseCatalogEntity);
		req.setAttribute("dxsTrainCourseCatalogList",dxsTrainCourseCatalogList);
		//查询导师
		CriteriaQuery cq = new CriteriaQuery(DxsAuthenticationEntity.class);
		cq.eq("isDelete",0);
		cq.or(Restrictions.eq("authenticationResult","8"),Restrictions.eq("authenticationResult","11"));
		cq.add();
		List<DxsAuthenticationEntity> dxsAuthenticationList = systemService.getListByCriteriaQuery(cq,false);
		List<DxsUserEntity> dxsUserList = new ArrayList<DxsUserEntity>();
		for(DxsAuthenticationEntity dxsAuthenticationEntity:dxsAuthenticationList){
			DxsUserEntity dxsUserEntity = systemService.getEntity(DxsUserEntity.class,dxsAuthenticationEntity.getUserId());
			dxsUserList.add(dxsUserEntity);
		}
		req.setAttribute("dxsUserList",dxsUserList);
		return new ModelAndView("com/buss/trainoutlinecourse/dxsTrainOutlineCourse-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsTrainOutlineCourseController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsTrainOutlineCourseEntity dxsTrainOutlineCourse,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsTrainOutlineCourseEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsTrainOutlineCourse, request.getParameterMap());
		List<DxsTrainOutlineCourseEntity> dxsTrainOutlineCourses = this.dxsTrainOutlineCourseService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_train_outline_course");
		modelMap.put(NormalExcelConstants.CLASS,DxsTrainOutlineCourseEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_train_outline_course列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsTrainOutlineCourses);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsTrainOutlineCourseEntity dxsTrainOutlineCourse,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_train_outline_course");
    	modelMap.put(NormalExcelConstants.CLASS,DxsTrainOutlineCourseEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_train_outline_course列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsTrainOutlineCourseEntity> listDxsTrainOutlineCourseEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsTrainOutlineCourseEntity.class,params);
				for (DxsTrainOutlineCourseEntity dxsTrainOutlineCourse : listDxsTrainOutlineCourseEntitys) {
					dxsTrainOutlineCourseService.save(dxsTrainOutlineCourse);
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
	public List<DxsTrainOutlineCourseEntity> list() {
		List<DxsTrainOutlineCourseEntity> listDxsTrainOutlineCourses=dxsTrainOutlineCourseService.getList(DxsTrainOutlineCourseEntity.class);
		return listDxsTrainOutlineCourses;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsTrainOutlineCourseEntity task = dxsTrainOutlineCourseService.get(DxsTrainOutlineCourseEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsTrainOutlineCourseEntity dxsTrainOutlineCourse, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsTrainOutlineCourseEntity>> failures = validator.validate(dxsTrainOutlineCourse);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsTrainOutlineCourseService.save(dxsTrainOutlineCourse);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsTrainOutlineCourse.getId();
		URI uri = uriBuilder.path("/rest/dxsTrainOutlineCourseController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsTrainOutlineCourseEntity dxsTrainOutlineCourse) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsTrainOutlineCourseEntity>> failures = validator.validate(dxsTrainOutlineCourse);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsTrainOutlineCourseService.saveOrUpdate(dxsTrainOutlineCourse);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsTrainOutlineCourseService.deleteEntityById(DxsTrainOutlineCourseEntity.class, id);
	}
}
