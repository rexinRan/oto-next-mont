package com.buss.entrepreneurshipprojectcompetition.controller;
import com.buss.entrepreneurshipprojectcompetition.entity.DxsEntrepreneurshipProjectCompetitionEntity;
import com.buss.entrepreneurshipprojectcompetition.service.DxsEntrepreneurshipProjectCompetitionServiceI;

import java.net.URL;
import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.buss.projectarea.entity.ProjectAreaEntity;
import com.buss.projecttype.entity.ProjectTypeEntity;
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
 * @Description: entrepreneurship_project_competition
 * @author onlineGenerator
 * @date 2016-06-30 11:56:21
 * @version V1.0   
 *添加项目
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsEntrepreneurshipProjectCompetitionController")
public class DxsEntrepreneurshipProjectCompetitionController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsEntrepreneurshipProjectCompetitionController.class);

	@Autowired
	private DxsEntrepreneurshipProjectCompetitionServiceI dxsEntrepreneurshipProjectCompetitionService;
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
	 * entrepreneurship_project_competition列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/entrepreneurshipprojectcompetition/dxsEntrepreneurshipProjectCompetitionList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param dxsEntrepreneurshipProjectCompetition
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(DxsEntrepreneurshipProjectCompetitionEntity dxsEntrepreneurshipProjectCompetition,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {

		CriteriaQuery cq = new CriteriaQuery(DxsEntrepreneurshipProjectCompetitionEntity.class, dataGrid);
		// 添加有效字段
		dxsEntrepreneurshipProjectCompetition.setIsDelete(0);
		cq.addOrder("updateTime", SortDirection.desc);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsEntrepreneurshipProjectCompetition, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsEntrepreneurshipProjectCompetitionService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除entrepreneurship_project_competition
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsEntrepreneurshipProjectCompetitionEntity dxsEntrepreneurshipProjectCompetition, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsEntrepreneurshipProjectCompetition = systemService.getEntity(DxsEntrepreneurshipProjectCompetitionEntity.class, dxsEntrepreneurshipProjectCompetition.getId());
		message = "删除成功";
		try{
			// 逻辑删除
			dxsEntrepreneurshipProjectCompetition.setIsDelete(1);
			this.systemService.saveOrUpdate(dxsEntrepreneurshipProjectCompetition);
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
	 * 批量删除entrepreneurship_project_competition
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
				DxsEntrepreneurshipProjectCompetitionEntity dxsEntrepreneurshipProjectCompetition = systemService.getEntity(DxsEntrepreneurshipProjectCompetitionEntity.class, 
				id
				);
				// 逻辑删除
				dxsEntrepreneurshipProjectCompetition.setIsDelete(1);
				dxsEntrepreneurshipProjectCompetitionService.saveOrUpdate(dxsEntrepreneurshipProjectCompetition);
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
	 * 添加entrepreneurship_project_competition
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsEntrepreneurshipProjectCompetitionEntity dxsEntrepreneurshipProjectCompetition, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();

		// 去除逗号
		String[] arr = dxsEntrepreneurshipProjectCompetition.getProjectImgurl().split("");
		if (arr[arr.length - 1].equals(",")){
			String url = dxsEntrepreneurshipProjectCompetition.getProjectImgurl();
			StringBuffer s = new StringBuffer(url);
			s.deleteCharAt(url.length()-1);
			dxsEntrepreneurshipProjectCompetition.setProjectImgurl(s.toString());
		}
		dxsEntrepreneurshipProjectCompetition.setCreateTime(new Date());
		dxsEntrepreneurshipProjectCompetition.setUpdateTime(new Date());
		dxsEntrepreneurshipProjectCompetition.setIsDelete(0);
		message = "添加成功";
		try{
			dxsEntrepreneurshipProjectCompetitionService.save(dxsEntrepreneurshipProjectCompetition);
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
	 * 更新entrepreneurship_project_competition
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsEntrepreneurshipProjectCompetitionEntity dxsEntrepreneurshipProjectCompetition, HttpServletRequest request) {
		// 杨治国
		// 更新时间\
		dxsEntrepreneurshipProjectCompetition.setUpdateTime(new Date());
		AjaxJson j = new AjaxJson();
		message = "更新成功";
		DxsEntrepreneurshipProjectCompetitionEntity t = dxsEntrepreneurshipProjectCompetitionService.get(DxsEntrepreneurshipProjectCompetitionEntity.class, dxsEntrepreneurshipProjectCompetition.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsEntrepreneurshipProjectCompetition, t);
			dxsEntrepreneurshipProjectCompetitionService.saveOrUpdate(t);
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
	 * entrepreneurship_project_competition新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DxsEntrepreneurshipProjectCompetitionEntity dxsEntrepreneurshipProjectCompetition, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsEntrepreneurshipProjectCompetition.getId())) {
			dxsEntrepreneurshipProjectCompetition = dxsEntrepreneurshipProjectCompetitionService.getEntity(DxsEntrepreneurshipProjectCompetitionEntity.class, dxsEntrepreneurshipProjectCompetition.getId());
			req.setAttribute("dxsEntrepreneurshipProjectCompetitionPage", dxsEntrepreneurshipProjectCompetition);
		}
		// 杨治国
		// 所有的项目所属领域
		List<ProjectAreaEntity> projectAreaEntityList = systemService.findByQueryString("from ProjectAreaEntity");
		req.setAttribute("projectAreaEntityList",projectAreaEntityList);

		// 所有的项目所有类型
		List<ProjectTypeEntity> projectTypeEntityList =  systemService.findByQueryString("from ProjectTypeEntity");
		req.setAttribute("projectTypeEntityList",projectTypeEntityList);
		return new ModelAndView("com/buss/entrepreneurshipprojectcompetition/dxsEntrepreneurshipProjectCompetition-add");
	}
	/**
	 * entrepreneurship_project_competition编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsEntrepreneurshipProjectCompetitionEntity dxsEntrepreneurshipProjectCompetition, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsEntrepreneurshipProjectCompetition.getId())) {
			dxsEntrepreneurshipProjectCompetition = dxsEntrepreneurshipProjectCompetitionService.getEntity(DxsEntrepreneurshipProjectCompetitionEntity.class, dxsEntrepreneurshipProjectCompetition.getId());

			// 杨治国
			// 查询所有的项目所属领域
			List<ProjectAreaEntity> projectAreaEntityList = systemService.findByQueryString("from ProjectAreaEntity");
			// 查询项目所属类型
			List<ProjectTypeEntity> projectTypeEntityList = systemService.findByQueryString("from ProjectTypeEntity");

			req.setAttribute("dxsEntrepreneurshipProjectCompetitionPage", dxsEntrepreneurshipProjectCompetition);
			req.setAttribute("projectAreaEntityList",projectAreaEntityList);
			req.setAttribute("projectTypeEntityList",projectTypeEntityList);
		}
		return new ModelAndView("com/buss/entrepreneurshipprojectcompetition/dxsEntrepreneurshipProjectCompetition-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsEntrepreneurshipProjectCompetitionController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsEntrepreneurshipProjectCompetitionEntity dxsEntrepreneurshipProjectCompetition,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsEntrepreneurshipProjectCompetitionEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsEntrepreneurshipProjectCompetition, request.getParameterMap());
		List<DxsEntrepreneurshipProjectCompetitionEntity> dxsEntrepreneurshipProjectCompetitions = this.dxsEntrepreneurshipProjectCompetitionService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"entrepreneurship_project_competition");
		modelMap.put(NormalExcelConstants.CLASS,DxsEntrepreneurshipProjectCompetitionEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("entrepreneurship_project_competition列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsEntrepreneurshipProjectCompetitions);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsEntrepreneurshipProjectCompetitionEntity dxsEntrepreneurshipProjectCompetition,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"entrepreneurship_project_competition");
    	modelMap.put(NormalExcelConstants.CLASS,DxsEntrepreneurshipProjectCompetitionEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("entrepreneurship_project_competition列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsEntrepreneurshipProjectCompetitionEntity> listDxsEntrepreneurshipProjectCompetitionEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsEntrepreneurshipProjectCompetitionEntity.class,params);
				for (DxsEntrepreneurshipProjectCompetitionEntity dxsEntrepreneurshipProjectCompetition : listDxsEntrepreneurshipProjectCompetitionEntitys) {
					dxsEntrepreneurshipProjectCompetitionService.save(dxsEntrepreneurshipProjectCompetition);
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
	public List<DxsEntrepreneurshipProjectCompetitionEntity> list() {
		List<DxsEntrepreneurshipProjectCompetitionEntity> listDxsEntrepreneurshipProjectCompetitions=dxsEntrepreneurshipProjectCompetitionService.getList(DxsEntrepreneurshipProjectCompetitionEntity.class);
		return listDxsEntrepreneurshipProjectCompetitions;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsEntrepreneurshipProjectCompetitionEntity task = dxsEntrepreneurshipProjectCompetitionService.get(DxsEntrepreneurshipProjectCompetitionEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsEntrepreneurshipProjectCompetitionEntity dxsEntrepreneurshipProjectCompetition, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsEntrepreneurshipProjectCompetitionEntity>> failures = validator.validate(dxsEntrepreneurshipProjectCompetition);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsEntrepreneurshipProjectCompetitionService.save(dxsEntrepreneurshipProjectCompetition);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsEntrepreneurshipProjectCompetition.getId();
		URI uri = uriBuilder.path("/rest/dxsEntrepreneurshipProjectCompetitionController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsEntrepreneurshipProjectCompetitionEntity dxsEntrepreneurshipProjectCompetition) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsEntrepreneurshipProjectCompetitionEntity>> failures = validator.validate(dxsEntrepreneurshipProjectCompetition);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsEntrepreneurshipProjectCompetitionService.saveOrUpdate(dxsEntrepreneurshipProjectCompetition);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsEntrepreneurshipProjectCompetitionService.deleteEntityById(DxsEntrepreneurshipProjectCompetitionEntity.class, id);
	}
}
