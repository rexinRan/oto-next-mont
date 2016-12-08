package com.buss.schoolpartnership.controller;
import com.buss.schoolpartnership.entity.DxsSchoolPartnershipEntity;
import com.buss.schoolpartnership.service.DxsSchoolPartnershipServiceI;

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
 * @Description: dxs_school_partnership
 * @author onlineGenerator
 * @date 2016-07-14 15:41:15
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsSchoolPartnershipController")
public class DxsSchoolPartnershipController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsSchoolPartnershipController.class);

	@Autowired
	private DxsSchoolPartnershipServiceI dxsSchoolPartnershipService;
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
	 * dxs_school_partnership列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/schoolpartnership/dxsSchoolPartnershipList");
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
	public void datagrid(DxsSchoolPartnershipEntity dxsSchoolPartnership,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DxsSchoolPartnershipEntity.class, dataGrid);
		//查询条件组装器
		dxsSchoolPartnership.setIsDelete(0);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsSchoolPartnership, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsSchoolPartnershipService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_school_partnership
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsSchoolPartnershipEntity dxsSchoolPartnership, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsSchoolPartnership = systemService.getEntity(DxsSchoolPartnershipEntity.class, dxsSchoolPartnership.getId());
		message = "dxs_school_partnership删除成功";
		try{
			dxsSchoolPartnership.setIsDelete(1);
			dxsSchoolPartnershipService.updateEntitie(dxsSchoolPartnership);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_school_partnership删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除dxs_school_partnership
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "dxs_school_partnership删除成功";
		try{
			for(String id:ids.split(",")){
				DxsSchoolPartnershipEntity dxsSchoolPartnership = systemService.getEntity(DxsSchoolPartnershipEntity.class, 
				id
				);
				dxsSchoolPartnership.setIsDelete(1);
				dxsSchoolPartnershipService.updateEntitie(dxsSchoolPartnership);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_school_partnership删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加dxs_school_partnership
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsSchoolPartnershipEntity dxsSchoolPartnership, HttpServletRequest request) {
		Date date =new Date();
		dxsSchoolPartnership.setIsDelete(0);
		dxsSchoolPartnership.setCreateTime(date);
		dxsSchoolPartnership.setUpdateTime(date);
		AjaxJson j = new AjaxJson();
		message = "dxs_school_partnership添加成功";
		try{
			dxsSchoolPartnershipService.save(dxsSchoolPartnership);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_school_partnership添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新dxs_school_partnership
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsSchoolPartnershipEntity dxsSchoolPartnership, HttpServletRequest request) {
		Date date =new Date();
		dxsSchoolPartnership.setUpdateTime(date);
		AjaxJson j = new AjaxJson();
		message = "dxs_school_partnership更新成功";
		DxsSchoolPartnershipEntity t = dxsSchoolPartnershipService.get(DxsSchoolPartnershipEntity.class, dxsSchoolPartnership.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsSchoolPartnership, t);
			dxsSchoolPartnershipService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "dxs_school_partnership更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * dxs_school_partnership新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DxsSchoolPartnershipEntity dxsSchoolPartnership, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsSchoolPartnership.getId())) {
			dxsSchoolPartnership = dxsSchoolPartnershipService.getEntity(DxsSchoolPartnershipEntity.class, dxsSchoolPartnership.getId());
			req.setAttribute("dxsSchoolPartnershipPage", dxsSchoolPartnership);
		}
		return new ModelAndView("com/buss/schoolpartnership/dxsSchoolPartnership-add");
	}
	/**
	 * dxs_school_partnership编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsSchoolPartnershipEntity dxsSchoolPartnership, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsSchoolPartnership.getId())) {
			dxsSchoolPartnership = dxsSchoolPartnershipService.getEntity(DxsSchoolPartnershipEntity.class, dxsSchoolPartnership.getId());
			req.setAttribute("dxsSchoolPartnershipPage", dxsSchoolPartnership);
		}
		return new ModelAndView("com/buss/schoolpartnership/dxsSchoolPartnership-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsSchoolPartnershipController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsSchoolPartnershipEntity dxsSchoolPartnership,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsSchoolPartnershipEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsSchoolPartnership, request.getParameterMap());
		List<DxsSchoolPartnershipEntity> dxsSchoolPartnerships = this.dxsSchoolPartnershipService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_school_partnership");
		modelMap.put(NormalExcelConstants.CLASS,DxsSchoolPartnershipEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_school_partnership列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsSchoolPartnerships);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsSchoolPartnershipEntity dxsSchoolPartnership,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_school_partnership");
    	modelMap.put(NormalExcelConstants.CLASS,DxsSchoolPartnershipEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_school_partnership列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsSchoolPartnershipEntity> listDxsSchoolPartnershipEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsSchoolPartnershipEntity.class,params);
				for (DxsSchoolPartnershipEntity dxsSchoolPartnership : listDxsSchoolPartnershipEntitys) {
					dxsSchoolPartnershipService.save(dxsSchoolPartnership);
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
	public List<DxsSchoolPartnershipEntity> list() {
		List<DxsSchoolPartnershipEntity> listDxsSchoolPartnerships=dxsSchoolPartnershipService.getList(DxsSchoolPartnershipEntity.class);
		return listDxsSchoolPartnerships;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsSchoolPartnershipEntity task = dxsSchoolPartnershipService.get(DxsSchoolPartnershipEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsSchoolPartnershipEntity dxsSchoolPartnership, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsSchoolPartnershipEntity>> failures = validator.validate(dxsSchoolPartnership);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsSchoolPartnershipService.save(dxsSchoolPartnership);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsSchoolPartnership.getId();
		URI uri = uriBuilder.path("/rest/dxsSchoolPartnershipController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsSchoolPartnershipEntity dxsSchoolPartnership) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsSchoolPartnershipEntity>> failures = validator.validate(dxsSchoolPartnership);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsSchoolPartnershipService.saveOrUpdate(dxsSchoolPartnership);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsSchoolPartnershipService.deleteEntityById(DxsSchoolPartnershipEntity.class, id);
	}
}
