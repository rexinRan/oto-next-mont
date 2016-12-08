package com.buss.traintestsubject.controller;
import com.buss.traintestsubject.entity.DxsTrainTestSubjectEntity;
import com.buss.traintestsubject.service.DxsTrainTestSubjectServiceI;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.annotation.Resource;
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
 * @Description: dxs_train_test_subject
 * @author onlineGenerator
 * @date 2016-09-08 11:56:53
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsTrainTestSubjectController")
public class DxsTrainTestSubjectController extends BaseController {
	/**
	 * Logger for this class
	 *
	 */
	private static final Logger logger = Logger.getLogger(DxsTrainTestSubjectController.class);

	@Autowired
	private DxsTrainTestSubjectServiceI dxsTrainTestSubjectService;
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
	 * dxs_train_test_subject列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(String ttId ,HttpServletRequest request) {
		ModelAndView model =new ModelAndView("com/buss/traintestsubject/dxsTrainTestSubjectList");
		model.addObject("ttId",ttId);
		return model;
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
	public void datagrid(DxsTrainTestSubjectEntity dxsTrainTestSubject,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//dq添加标志项
		dxsTrainTestSubject.setIsDelete(0);

		CriteriaQuery cq = new CriteriaQuery(DxsTrainTestSubjectEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsTrainTestSubject, request.getParameterMap());
		try{
		//自定义追加查询条件
			cq.eq("ttId",dxsTrainTestSubject.getTtId());

		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsTrainTestSubjectService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_train_test_subject
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsTrainTestSubjectEntity dxsTrainTestSubject, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsTrainTestSubject = systemService.getEntity(DxsTrainTestSubjectEntity.class, dxsTrainTestSubject.getId());
		message = "dxs_train_test_subject删除成功";
		try{

			//dq修改标志项
			dxsTrainTestSubject.setIsDelete(1);
			dxsTrainTestSubjectService.saveOrUpdate(dxsTrainTestSubject);

			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_train_test_subject删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除dxs_train_test_subject
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "dxs_train_test_subject删除成功";
		try{
			for(String id:ids.split(",")){
				DxsTrainTestSubjectEntity dxsTrainTestSubject = systemService.getEntity(DxsTrainTestSubjectEntity.class, 
				id
				);

				//dq添加修改标志项
				dxsTrainTestSubject.setIsDelete(1);
				dxsTrainTestSubjectService.saveOrUpdate(dxsTrainTestSubject);

				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_train_test_subject删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加dxs_train_test_subject
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsTrainTestSubjectEntity dxsTrainTestSubject, HttpServletRequest request) {

		//dq添加修改标志项
		Date date = new Date();
		dxsTrainTestSubject.setUpdateTime(date);
		dxsTrainTestSubject.setCreateTime(date);
		dxsTrainTestSubject.setIsDelete(0);

		AjaxJson j = new AjaxJson();
		message = "dxs_train_test_subject添加成功";
		try{
			dxsTrainTestSubjectService.save(dxsTrainTestSubject);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_train_test_subject添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新dxs_train_test_subject
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsTrainTestSubjectEntity dxsTrainTestSubject, HttpServletRequest request) {

		//dq添加修改标志项
		Date date = new Date();
		dxsTrainTestSubject.setUpdateTime(date);

		AjaxJson j = new AjaxJson();
		message = "dxs_train_test_subject更新成功";
		DxsTrainTestSubjectEntity t = dxsTrainTestSubjectService.get(DxsTrainTestSubjectEntity.class, dxsTrainTestSubject.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsTrainTestSubject, t);
			dxsTrainTestSubjectService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "dxs_train_test_subject更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * dxs_train_test_subject新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(String ttId,DxsTrainTestSubjectEntity dxsTrainTestSubject, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsTrainTestSubject.getId())) {
			dxsTrainTestSubject = dxsTrainTestSubjectService.getEntity(DxsTrainTestSubjectEntity.class, dxsTrainTestSubject.getId());
			req.setAttribute("dxsTrainTestSubjectPage", dxsTrainTestSubject);
		}

		ModelAndView model=new ModelAndView("com/buss/traintestsubject/dxsTrainTestSubject-add");
		model.addObject("ttId",ttId);
		return model;
	}
	/**
	 * dxs_train_test_subject编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsTrainTestSubjectEntity dxsTrainTestSubject, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsTrainTestSubject.getId())) {
			dxsTrainTestSubject = dxsTrainTestSubjectService.getEntity(DxsTrainTestSubjectEntity.class, dxsTrainTestSubject.getId());
			req.setAttribute("dxsTrainTestSubjectPage", dxsTrainTestSubject);
		}
		return new ModelAndView("com/buss/traintestsubject/dxsTrainTestSubject-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsTrainTestSubjectController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsTrainTestSubjectEntity dxsTrainTestSubject,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsTrainTestSubjectEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsTrainTestSubject, request.getParameterMap());
		List<DxsTrainTestSubjectEntity> dxsTrainTestSubjects = this.dxsTrainTestSubjectService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_train_test_subject");
		modelMap.put(NormalExcelConstants.CLASS,DxsTrainTestSubjectEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_train_test_subject列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsTrainTestSubjects);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsTrainTestSubjectEntity dxsTrainTestSubject,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_train_test_subject");
    	modelMap.put(NormalExcelConstants.CLASS,DxsTrainTestSubjectEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_train_test_subject列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsTrainTestSubjectEntity> listDxsTrainTestSubjectEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsTrainTestSubjectEntity.class,params);
				for (DxsTrainTestSubjectEntity dxsTrainTestSubject : listDxsTrainTestSubjectEntitys) {
					dxsTrainTestSubjectService.save(dxsTrainTestSubject);
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
	public List<DxsTrainTestSubjectEntity> list() {
		List<DxsTrainTestSubjectEntity> listDxsTrainTestSubjects=dxsTrainTestSubjectService.getList(DxsTrainTestSubjectEntity.class);
		return listDxsTrainTestSubjects;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsTrainTestSubjectEntity task = dxsTrainTestSubjectService.get(DxsTrainTestSubjectEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsTrainTestSubjectEntity dxsTrainTestSubject, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsTrainTestSubjectEntity>> failures = validator.validate(dxsTrainTestSubject);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsTrainTestSubjectService.save(dxsTrainTestSubject);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsTrainTestSubject.getId();
		URI uri = uriBuilder.path("/rest/dxsTrainTestSubjectController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsTrainTestSubjectEntity dxsTrainTestSubject) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsTrainTestSubjectEntity>> failures = validator.validate(dxsTrainTestSubject);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsTrainTestSubjectService.saveOrUpdate(dxsTrainTestSubject);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsTrainTestSubjectService.deleteEntityById(DxsTrainTestSubjectEntity.class, id);
	}
}
