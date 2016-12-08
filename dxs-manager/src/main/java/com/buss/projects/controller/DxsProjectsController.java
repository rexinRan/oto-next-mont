package com.buss.projects.controller;
import com.buss.competition.entity.DxsCompetitionEntity;
import com.buss.projects.entity.DxsProjectsEntity;
import com.buss.projects.service.DxsProjectsServiceI;

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
 * @Description: dxs_projects
 * @author onlineGenerator
 * @date 2016-07-21 14:17:28
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsProjectsController")
public class DxsProjectsController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsProjectsController.class);

	@Autowired
	private DxsProjectsServiceI dxsProjectsService;
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
	 * dxs_projects列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/projects/dxsProjectsList");
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
	public void datagrid(DxsProjectsEntity dxsProjects,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DxsProjectsEntity.class, dataGrid);
		//查询条件组装
		dxsProjects.setIsDelete(0);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsProjects, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsProjectsService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_projects
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsProjectsEntity dxsProjects, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsProjects = systemService.getEntity(DxsProjectsEntity.class, dxsProjects.getId());
		message = "dxs_projects删除成功";
		try{
			dxsProjects.setIsDelete(1);
			dxsProjectsService.saveOrUpdate(dxsProjects);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_projects删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除dxs_projects
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "dxs_projects删除成功";
		try{
			for(String id:ids.split(",")){
				DxsProjectsEntity dxsProjects = systemService.getEntity(DxsProjectsEntity.class, 
				id
				);
				dxsProjects.setIsDelete(1);
				dxsProjectsService.saveOrUpdate(dxsProjects);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_projects删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加dxs_projects
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsProjectsEntity dxsProjects, HttpServletRequest request) {
		dxsProjects.setIsDelete(0);
		dxsProjects.setUpdateTime(new Date());
		AjaxJson j = new AjaxJson();
		message = "dxs_projects添加成功";
		try{
			dxsProjectsService.save(dxsProjects);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_projects添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新dxs_projects
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsProjectsEntity dxsProjects, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "dxs_projects更新成功";
		DxsProjectsEntity t = dxsProjectsService.get(DxsProjectsEntity.class, dxsProjects.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsProjects, t);
			dxsProjectsService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "dxs_projects更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * dxs_projects新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DxsProjectsEntity dxsProjects, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsProjects.getId())) {
			dxsProjects = dxsProjectsService.getEntity(DxsProjectsEntity.class, dxsProjects.getId());
			req.setAttribute("dxsProjectsPage", dxsProjects);
		}
		DxsUserEntity dxsUserEntity=new DxsUserEntity();
		dxsUserEntity.setIsdelete(0);
		dxsUserEntity.setRolecode("student");
		List dxsUserList=systemService.findByExample(DxsUserEntity.class.getName(),dxsUserEntity);
		req.setAttribute("dxsUserList",dxsUserList);

		DxsCompetitionEntity dxsCompetitionEntity=new DxsCompetitionEntity();
		dxsCompetitionEntity.setIsDelete(0);
		List dxsCompetitionList=systemService.findByExample(DxsCompetitionEntity.class.getName(),dxsCompetitionEntity);
		req.setAttribute("dxsCompetitionList",dxsCompetitionList);
		return new ModelAndView("com/buss/projects/dxsProjects-add");
	}
	/**
	 * dxs_projects编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsProjectsEntity dxsProjects, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsProjects.getId())) {
			dxsProjects = dxsProjectsService.getEntity(DxsProjectsEntity.class, dxsProjects.getId());
			req.setAttribute("dxsProjectsPage", dxsProjects);
		}
		DxsUserEntity dxsUserEntity=new DxsUserEntity();
		dxsUserEntity.setIsdelete(0);
		dxsUserEntity.setRolecode("student");
		List dxsUserList=systemService.findByExample(DxsUserEntity.class.getName(),dxsUserEntity);
		req.setAttribute("dxsUserList",dxsUserList);

		DxsCompetitionEntity dxsCompetitionEntity=new DxsCompetitionEntity();
		dxsCompetitionEntity.setIsDelete(0);
		List dxsCompetitionList=systemService.findByExample(DxsCompetitionEntity.class.getName(),dxsCompetitionEntity);
		req.setAttribute("dxsCompetitionList",dxsCompetitionList);
		return new ModelAndView("com/buss/projects/dxsProjects-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsProjectsController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsProjectsEntity dxsProjects,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsProjectsEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsProjects, request.getParameterMap());
		List<DxsProjectsEntity> dxsProjectss = this.dxsProjectsService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_projects");
		modelMap.put(NormalExcelConstants.CLASS,DxsProjectsEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_projects列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsProjectss);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsProjectsEntity dxsProjects,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_projects");
    	modelMap.put(NormalExcelConstants.CLASS,DxsProjectsEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_projects列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsProjectsEntity> listDxsProjectsEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsProjectsEntity.class,params);
				for (DxsProjectsEntity dxsProjects : listDxsProjectsEntitys) {
					dxsProjectsService.save(dxsProjects);
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
	public List<DxsProjectsEntity> list() {
		List<DxsProjectsEntity> listDxsProjectss=dxsProjectsService.getList(DxsProjectsEntity.class);
		return listDxsProjectss;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsProjectsEntity task = dxsProjectsService.get(DxsProjectsEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsProjectsEntity dxsProjects, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsProjectsEntity>> failures = validator.validate(dxsProjects);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsProjectsService.save(dxsProjects);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsProjects.getId();
		URI uri = uriBuilder.path("/rest/dxsProjectsController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsProjectsEntity dxsProjects) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsProjectsEntity>> failures = validator.validate(dxsProjects);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsProjectsService.saveOrUpdate(dxsProjects);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsProjectsService.deleteEntityById(DxsProjectsEntity.class, id);
	}
}
