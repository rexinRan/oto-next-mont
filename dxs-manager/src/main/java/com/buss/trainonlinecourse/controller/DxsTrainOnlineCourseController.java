package com.buss.trainonlinecourse.controller;
import com.buss.authentication.entity.DxsAuthenticationEntity;
import com.buss.traincoursecatalog.entity.DxsTrainCourseCatalogEntity;
import com.buss.trainonlinecourse.entity.DxsTrainOnlineCourseEntity;
import com.buss.trainonlinecourse.service.DxsTrainOnlineCourseServiceI;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.buss.user.entity.DxsUserEntity;
import org.apache.log4j.Logger;
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
 * @Description: dxs_train_online_course
 * @author dq
 * @date 2016-09-06 13:39:21
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsTrainOnlineCourseController")
public class DxsTrainOnlineCourseController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsTrainOnlineCourseController.class);

	@Autowired
	private DxsTrainOnlineCourseServiceI dxsTrainOnlineCourseService;
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
	 * dxs_train_online_course列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/trainonlinecourse/dxsTrainOnlineCourseList");
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
	public void datagrid(DxsTrainOnlineCourseEntity dxsTrainOnlineCourse,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {

		dxsTrainOnlineCourse.setIsDelete(0);

		CriteriaQuery cq = new CriteriaQuery(DxsTrainOnlineCourseEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsTrainOnlineCourse, request.getParameterMap());
		try{
		//自定义追加查询条件

		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsTrainOnlineCourseService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_train_online_course
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsTrainOnlineCourseEntity dxsTrainOnlineCourse, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsTrainOnlineCourse = systemService.getEntity(DxsTrainOnlineCourseEntity.class, dxsTrainOnlineCourse.getId());
		message = "dxs_train_online_course删除成功";
		try{

			dxsTrainOnlineCourse.setIsDelete(1);
			dxsTrainOnlineCourseService.saveOrUpdate(dxsTrainOnlineCourse);

			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_train_online_course删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除dxs_train_online_course
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "dxs_train_online_course删除成功";
		try{
			for(String id:ids.split(",")){
				DxsTrainOnlineCourseEntity dxsTrainOnlineCourse = systemService.getEntity(DxsTrainOnlineCourseEntity.class, 
				id
				);

				dxsTrainOnlineCourse.setIsDelete(1);
				dxsTrainOnlineCourseService.saveOrUpdate(dxsTrainOnlineCourse);

				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_train_online_course删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加dxs_train_online_course
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsTrainOnlineCourseEntity dxsTrainOnlineCourse, HttpServletRequest request) {

		Date date = new Date();
		dxsTrainOnlineCourse.setUpdateTime(date);
		dxsTrainOnlineCourse.setCreateTime(date);
		dxsTrainOnlineCourse.setIsDelete(0);

		AjaxJson j = new AjaxJson();
		message = "dxs_train_online_course添加成功";
		try{
			dxsTrainOnlineCourseService.save(dxsTrainOnlineCourse);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_train_online_course添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新dxs_train_online_course
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsTrainOnlineCourseEntity dxsTrainOnlineCourse, HttpServletRequest request) {

		Date date = new Date();
		dxsTrainOnlineCourse.setUpdateTime(date);

		AjaxJson j = new AjaxJson();
		message = "dxs_train_online_course更新成功";
		DxsTrainOnlineCourseEntity t = dxsTrainOnlineCourseService.get(DxsTrainOnlineCourseEntity.class, dxsTrainOnlineCourse.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsTrainOnlineCourse, t);
			dxsTrainOnlineCourseService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "dxs_train_online_course更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * dxs_train_online_course新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DxsTrainOnlineCourseEntity dxsTrainOnlineCourse, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsTrainOnlineCourse.getId())) {
			dxsTrainOnlineCourse = dxsTrainOnlineCourseService.getEntity(DxsTrainOnlineCourseEntity.class, dxsTrainOnlineCourse.getId());
			req.setAttribute("dxsTrainOnlineCoursePage", dxsTrainOnlineCourse);
		}
		DxsTrainCourseCatalogEntity dxsTrainCourseCatalogEntity = new DxsTrainCourseCatalogEntity();
		dxsTrainCourseCatalogEntity.setIsDelete(0);
		List<DxsTrainCourseCatalogEntity> dxsTrainCourseCatalogList=systemService.findByExample(DxsTrainCourseCatalogEntity.class.getName(),dxsTrainCourseCatalogEntity);
		req.setAttribute("dxsTrainCourseCatalogList",dxsTrainCourseCatalogList);

//		CriteriaQuery cq = new CriteriaQuery(DxsAuthenticationEntity.class);
//		cq.eq("isDelete",0);
//		cq.or(Restrictions.eq("authenticationResult","8"), Restrictions.eq("authenticationResult","11"));
//		cq.add();
		List dxsAuthenticationList=systemService.findListbySql("select a.id,a.user_id from dxs_authentication a where " +
				"is_delete=0 and a.authentication_result in(8,11,14,17,20)");

		List<DxsUserEntity> dxsUserList = new ArrayList<DxsUserEntity>();
		for(Object dxsAuthentication:dxsAuthenticationList) {
			Object [] s = (Object[]) dxsAuthentication;
			DxsUserEntity dxsUserEntity=systemService.getEntity(DxsUserEntity.class,s[1].toString());
			dxsUserList.add(dxsUserEntity);
		}

		req.setAttribute("dxsUserList",dxsUserList);
		return new ModelAndView("com/buss/trainonlinecourse/dxsTrainOnlineCourse-add");
	}
	@RequestMapping(params = "fenLeiFind")
	@ResponseBody
	public List DaoShi(String type){
		AjaxJson j=new AjaxJson();
		List dxsAuthenticationList=new ArrayList();
		if("8".equals(type)){
			dxsAuthenticationList=systemService.findListbySql("select a.id,a.user_id from dxs_authentication a where " +
				"is_delete=0 and a.authentication_result in(8)");
		}
		if("11".equals(type)){
			dxsAuthenticationList=systemService.findListbySql("select a.id,a.user_id from dxs_authentication a where " +
				"is_delete=0 and a.authentication_result in(11)");
		}
		if("14".equals(type)){
			dxsAuthenticationList=systemService.findListbySql("select a.id,a.user_id from dxs_authentication a where " +
				"is_delete=0 and a.authentication_result in(14)");
		}
		if("17".equals(type)){
			dxsAuthenticationList=systemService.findListbySql("select a.id,a.user_id from dxs_authentication a where " +
				"is_delete=0 and a.authentication_result in(17)");
		}
		if("20".equals(type)){
			 dxsAuthenticationList=systemService.findListbySql("select a.id,a.user_id from dxs_authentication a where " +
				"is_delete=0 and a.authentication_result in(20)");
		}


		List<DxsUserEntity> dxsUserList = new ArrayList<DxsUserEntity>();
		for(Object dxsAuthentication:dxsAuthenticationList) {
			Object [] s = (Object[]) dxsAuthentication;
			DxsUserEntity dxsUserEntity=systemService.getEntity(DxsUserEntity.class,s[1].toString());
			dxsUserList.add(dxsUserEntity);
		}
		j.setObj(dxsUserList);
		return dxsUserList;
	}
	/**
	 * dxs_train_online_course编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsTrainOnlineCourseEntity dxsTrainOnlineCourse, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsTrainOnlineCourse.getId())) {
			dxsTrainOnlineCourse = dxsTrainOnlineCourseService.getEntity(DxsTrainOnlineCourseEntity.class, dxsTrainOnlineCourse.getId());
			req.setAttribute("dxsTrainOnlineCoursePage", dxsTrainOnlineCourse);
		}
		DxsTrainCourseCatalogEntity dxsTrainCourseCatalogEntity = new DxsTrainCourseCatalogEntity();
		dxsTrainCourseCatalogEntity.setIsDelete(0);
		List<DxsTrainCourseCatalogEntity> dxsTrainCourseCatalogList=systemService.findByExample(DxsTrainCourseCatalogEntity.class.getName(),dxsTrainCourseCatalogEntity);
		req.setAttribute("dxsTrainCourseCatalogList",dxsTrainCourseCatalogList);

//		CriteriaQuery cq = new CriteriaQuery(DxsAuthenticationEntity.class);
//		cq.eq("isDelete",0);
//		cq.or(Restrictions.eq("authenticationResult","8"), Restrictions.eq("authenticationResult","11"));
//		cq.add();
		List dxsAuthenticationList=systemService.findListbySql("select a.id,a.user_id from dxs_authentication a where " +
				"is_delete=0 and a.authentication_result in(8,11,14,17,20)");

		List<DxsUserEntity> dxsUserList = new ArrayList<DxsUserEntity>();
		for(Object dxsAuthentication:dxsAuthenticationList) {
			Object [] s = (Object[]) dxsAuthentication;
			DxsUserEntity dxsUserEntity=systemService.getEntity(DxsUserEntity.class,s[1].toString());
			dxsUserList.add(dxsUserEntity);
		}

		req.setAttribute("dxsUserList",dxsUserList);
		return new ModelAndView("com/buss/trainonlinecourse/dxsTrainOnlineCourse-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsTrainOnlineCourseController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsTrainOnlineCourseEntity dxsTrainOnlineCourse,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsTrainOnlineCourseEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsTrainOnlineCourse, request.getParameterMap());
		List<DxsTrainOnlineCourseEntity> dxsTrainOnlineCourses = this.dxsTrainOnlineCourseService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_train_online_course");
		modelMap.put(NormalExcelConstants.CLASS,DxsTrainOnlineCourseEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_train_online_course列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsTrainOnlineCourses);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsTrainOnlineCourseEntity dxsTrainOnlineCourse,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_train_online_course");
    	modelMap.put(NormalExcelConstants.CLASS,DxsTrainOnlineCourseEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_train_online_course列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsTrainOnlineCourseEntity> listDxsTrainOnlineCourseEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsTrainOnlineCourseEntity.class,params);
				for (DxsTrainOnlineCourseEntity dxsTrainOnlineCourse : listDxsTrainOnlineCourseEntitys) {
					dxsTrainOnlineCourseService.save(dxsTrainOnlineCourse);
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
	public List<DxsTrainOnlineCourseEntity> list() {
		List<DxsTrainOnlineCourseEntity> listDxsTrainOnlineCourses=dxsTrainOnlineCourseService.getList(DxsTrainOnlineCourseEntity.class);
		return listDxsTrainOnlineCourses;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsTrainOnlineCourseEntity task = dxsTrainOnlineCourseService.get(DxsTrainOnlineCourseEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsTrainOnlineCourseEntity dxsTrainOnlineCourse, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsTrainOnlineCourseEntity>> failures = validator.validate(dxsTrainOnlineCourse);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsTrainOnlineCourseService.save(dxsTrainOnlineCourse);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsTrainOnlineCourse.getId();
		URI uri = uriBuilder.path("/rest/dxsTrainOnlineCourseController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsTrainOnlineCourseEntity dxsTrainOnlineCourse) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsTrainOnlineCourseEntity>> failures = validator.validate(dxsTrainOnlineCourse);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsTrainOnlineCourseService.saveOrUpdate(dxsTrainOnlineCourse);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsTrainOnlineCourseService.deleteEntityById(DxsTrainOnlineCourseEntity.class, id);
	}
}
