package com.buss.trainoutlinecourseuser.controller;
import com.buss.trainoutlinecourseuser.entity.DxsTrainOutlineCourseUserEntity;
import com.buss.trainoutlinecourseuser.service.DxsTrainOutlineCourseUserServiceI;

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
 * @Description: dxs_train_outline_course_user
 * @author dq
 * @date 2016-09-06 14:32:50
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsTrainOutlineCourseUserController")
public class DxsTrainOutlineCourseUserController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsTrainOutlineCourseUserController.class);

	@Autowired
	private DxsTrainOutlineCourseUserServiceI dxsTrainOutlineCourseUserService;
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
	 * dxs_train_outline_course_user列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/trainoutlinecourseuser/dxsTrainOutlineCourseUserList");
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
	public void datagrid(DxsTrainOutlineCourseUserEntity dxsTrainOutlineCourseUser,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {

		dxsTrainOutlineCourseUser.setIsDelete(0);

		CriteriaQuery cq = new CriteriaQuery(DxsTrainOutlineCourseUserEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsTrainOutlineCourseUser, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsTrainOutlineCourseUserService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_train_outline_course_user
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsTrainOutlineCourseUserEntity dxsTrainOutlineCourseUser, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsTrainOutlineCourseUser = systemService.getEntity(DxsTrainOutlineCourseUserEntity.class, dxsTrainOutlineCourseUser.getId());
		message = "dxs_train_outline_course_user删除成功";
		try{

			dxsTrainOutlineCourseUser.setIsDelete(1);
			dxsTrainOutlineCourseUserService.saveOrUpdate(dxsTrainOutlineCourseUser);

			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_train_outline_course_user删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除dxs_train_outline_course_user
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "dxs_train_outline_course_user删除成功";
		try{
			for(String id:ids.split(",")){
				DxsTrainOutlineCourseUserEntity dxsTrainOutlineCourseUser = systemService.getEntity(DxsTrainOutlineCourseUserEntity.class, 
				id
				);

				dxsTrainOutlineCourseUser.setIsDelete(1);
				dxsTrainOutlineCourseUserService.saveOrUpdate(dxsTrainOutlineCourseUser);

				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_train_outline_course_user删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加dxs_train_outline_course_user
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsTrainOutlineCourseUserEntity dxsTrainOutlineCourseUser, HttpServletRequest request) {

		Date date = new Date();
		dxsTrainOutlineCourseUser.setUpdateTime(date);
		dxsTrainOutlineCourseUser.setCreateTime(date);
		dxsTrainOutlineCourseUser.setIsDelete(0);

		AjaxJson j = new AjaxJson();
		message = "dxs_train_outline_course_user添加成功";
		try{
			dxsTrainOutlineCourseUserService.save(dxsTrainOutlineCourseUser);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_train_outline_course_user添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新dxs_train_outline_course_user
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsTrainOutlineCourseUserEntity dxsTrainOutlineCourseUser, HttpServletRequest request) {

		Date date = new Date();
		dxsTrainOutlineCourseUser.setUpdateTime(date);

		AjaxJson j = new AjaxJson();
		message = "dxs_train_outline_course_user更新成功";
		DxsTrainOutlineCourseUserEntity t = dxsTrainOutlineCourseUserService.get(DxsTrainOutlineCourseUserEntity.class, dxsTrainOutlineCourseUser.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsTrainOutlineCourseUser, t);
			dxsTrainOutlineCourseUserService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "dxs_train_outline_course_user更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * dxs_train_outline_course_user新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DxsTrainOutlineCourseUserEntity dxsTrainOutlineCourseUser, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsTrainOutlineCourseUser.getId())) {
			dxsTrainOutlineCourseUser = dxsTrainOutlineCourseUserService.getEntity(DxsTrainOutlineCourseUserEntity.class, dxsTrainOutlineCourseUser.getId());
			req.setAttribute("dxsTrainOutlineCourseUserPage", dxsTrainOutlineCourseUser);
		}
		return new ModelAndView("com/buss/trainoutlinecourseuser/dxsTrainOutlineCourseUser-add");
	}
	/**
	 * dxs_train_outline_course_user编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsTrainOutlineCourseUserEntity dxsTrainOutlineCourseUser, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsTrainOutlineCourseUser.getId())) {
			dxsTrainOutlineCourseUser = dxsTrainOutlineCourseUserService.getEntity(DxsTrainOutlineCourseUserEntity.class, dxsTrainOutlineCourseUser.getId());
			req.setAttribute("dxsTrainOutlineCourseUserPage", dxsTrainOutlineCourseUser);
		}
		return new ModelAndView("com/buss/trainoutlinecourseuser/dxsTrainOutlineCourseUser-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsTrainOutlineCourseUserController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsTrainOutlineCourseUserEntity dxsTrainOutlineCourseUser,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsTrainOutlineCourseUserEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsTrainOutlineCourseUser, request.getParameterMap());
		List<DxsTrainOutlineCourseUserEntity> dxsTrainOutlineCourseUsers = this.dxsTrainOutlineCourseUserService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_train_outline_course_user");
		modelMap.put(NormalExcelConstants.CLASS,DxsTrainOutlineCourseUserEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_train_outline_course_user列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsTrainOutlineCourseUsers);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsTrainOutlineCourseUserEntity dxsTrainOutlineCourseUser,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_train_outline_course_user");
    	modelMap.put(NormalExcelConstants.CLASS,DxsTrainOutlineCourseUserEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_train_outline_course_user列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsTrainOutlineCourseUserEntity> listDxsTrainOutlineCourseUserEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsTrainOutlineCourseUserEntity.class,params);
				for (DxsTrainOutlineCourseUserEntity dxsTrainOutlineCourseUser : listDxsTrainOutlineCourseUserEntitys) {
					dxsTrainOutlineCourseUserService.save(dxsTrainOutlineCourseUser);
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
	public List<DxsTrainOutlineCourseUserEntity> list() {
		List<DxsTrainOutlineCourseUserEntity> listDxsTrainOutlineCourseUsers=dxsTrainOutlineCourseUserService.getList(DxsTrainOutlineCourseUserEntity.class);
		return listDxsTrainOutlineCourseUsers;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsTrainOutlineCourseUserEntity task = dxsTrainOutlineCourseUserService.get(DxsTrainOutlineCourseUserEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsTrainOutlineCourseUserEntity dxsTrainOutlineCourseUser, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsTrainOutlineCourseUserEntity>> failures = validator.validate(dxsTrainOutlineCourseUser);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsTrainOutlineCourseUserService.save(dxsTrainOutlineCourseUser);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsTrainOutlineCourseUser.getId();
		URI uri = uriBuilder.path("/rest/dxsTrainOutlineCourseUserController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsTrainOutlineCourseUserEntity dxsTrainOutlineCourseUser) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsTrainOutlineCourseUserEntity>> failures = validator.validate(dxsTrainOutlineCourseUser);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsTrainOutlineCourseUserService.saveOrUpdate(dxsTrainOutlineCourseUser);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsTrainOutlineCourseUserService.deleteEntityById(DxsTrainOutlineCourseUserEntity.class, id);
	}
}
