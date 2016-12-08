package com.buss.activesdetailsdays.controller;
import com.buss.activesdetails.entity.DxsActivesDetailsEntity;
import com.buss.activesdetailsdays.entity.DxsActivesDetailsDaysEntity;
import com.buss.activesdetailsdays.service.DxsActivesDetailsDaysServiceI;
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
 * @Description: dxs_actives_details_days
 * @author onlineGenerator
 * @date 2016-08-04 09:16:13
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsActivesDetailsDaysController")
public class DxsActivesDetailsDaysController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsActivesDetailsDaysController.class);

	@Autowired
	private DxsActivesDetailsDaysServiceI dxsActivesDetailsDaysService;
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
	 * dxs_actives_details_days列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(String activeId,HttpServletRequest request) {
		DxsActivesDetailsEntity dxsActivesDetailsEntity=systemService.getEntity(DxsActivesDetailsEntity.class, activeId);
		activeId=dxsActivesDetailsEntity.getActivesId();
		ModelAndView mod=new ModelAndView("com/buss/activesdetailsdays/dxsActivesDetailsDaysList");

		mod.addObject("activeId",activeId);
		return mod;
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
	public void datagrid(DxsActivesDetailsDaysEntity dxsActivesDetailsDays,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DxsActivesDetailsDaysEntity.class, dataGrid);
		//查询条件组装器
		dxsActivesDetailsDays.setIsDelete(0);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsActivesDetailsDays, request.getParameterMap());
		try{
		//自定义追加查询条件
			cq.eq("activeId",dxsActivesDetailsDays.getActiveId());

		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsActivesDetailsDaysService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_actives_details_days
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsActivesDetailsDaysEntity dxsActivesDetailsDays, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsActivesDetailsDays = systemService.getEntity(DxsActivesDetailsDaysEntity.class, dxsActivesDetailsDays.getId());
		message = "dxs_actives_details_days删除成功";
		try{
			dxsActivesDetailsDays.setIsDelete(1);
			dxsActivesDetailsDaysService.saveOrUpdate(dxsActivesDetailsDays);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_actives_details_days删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除dxs_actives_details_days
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "dxs_actives_details_days删除成功";
		try{
			for(String id:ids.split(",")){
				DxsActivesDetailsDaysEntity dxsActivesDetailsDays = systemService.getEntity(DxsActivesDetailsDaysEntity.class, 
				id
				);
				dxsActivesDetailsDays.setIsDelete(1);
				dxsActivesDetailsDaysService.saveOrUpdate(dxsActivesDetailsDays);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_actives_details_days删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加dxs_actives_details_days
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsActivesDetailsDaysEntity dxsActivesDetailsDays, HttpServletRequest request) {
		dxsActivesDetailsDays.setIsDelete(0);
		AjaxJson j = new AjaxJson();
		message = "dxs_actives_details_days添加成功";
		try{
			dxsActivesDetailsDaysService.save(dxsActivesDetailsDays);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_actives_details_days添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新dxs_actives_details_days
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsActivesDetailsDaysEntity dxsActivesDetailsDays, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "dxs_actives_details_days更新成功";
		DxsActivesDetailsDaysEntity t = dxsActivesDetailsDaysService.get(DxsActivesDetailsDaysEntity.class, dxsActivesDetailsDays.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsActivesDetailsDays, t);
			dxsActivesDetailsDaysService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "dxs_actives_details_days更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * dxs_actives_details_days新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(String activeId,DxsActivesDetailsDaysEntity dxsActivesDetailsDays, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsActivesDetailsDays.getId())) {
			dxsActivesDetailsDays = dxsActivesDetailsDaysService.getEntity(DxsActivesDetailsDaysEntity.class, dxsActivesDetailsDays.getId());
			req.setAttribute("dxsActivesDetailsDaysPage", dxsActivesDetailsDays);
		}
		ModelAndView modelAndView=new ModelAndView("com/buss/activesdetailsdays/dxsActivesDetailsDays-add");
		modelAndView.addObject("activeId",activeId);
		return modelAndView;
	}
	/**
	 * dxs_actives_details_days编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsActivesDetailsDaysEntity dxsActivesDetailsDays, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsActivesDetailsDays.getId())) {
			dxsActivesDetailsDays = dxsActivesDetailsDaysService.getEntity(DxsActivesDetailsDaysEntity.class, dxsActivesDetailsDays.getId());
			req.setAttribute("dxsActivesDetailsDaysPage", dxsActivesDetailsDays);
		}
		return new ModelAndView("com/buss/activesdetailsdays/dxsActivesDetailsDays-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsActivesDetailsDaysController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsActivesDetailsDaysEntity dxsActivesDetailsDays,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsActivesDetailsDaysEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsActivesDetailsDays, request.getParameterMap());
		List<DxsActivesDetailsDaysEntity> dxsActivesDetailsDayss = this.dxsActivesDetailsDaysService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_actives_details_days");
		modelMap.put(NormalExcelConstants.CLASS,DxsActivesDetailsDaysEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_actives_details_days列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsActivesDetailsDayss);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsActivesDetailsDaysEntity dxsActivesDetailsDays,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_actives_details_days");
    	modelMap.put(NormalExcelConstants.CLASS,DxsActivesDetailsDaysEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_actives_details_days列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsActivesDetailsDaysEntity> listDxsActivesDetailsDaysEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsActivesDetailsDaysEntity.class,params);
				for (DxsActivesDetailsDaysEntity dxsActivesDetailsDays : listDxsActivesDetailsDaysEntitys) {
					dxsActivesDetailsDaysService.save(dxsActivesDetailsDays);
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
	public List<DxsActivesDetailsDaysEntity> list() {
		List<DxsActivesDetailsDaysEntity> listDxsActivesDetailsDayss=dxsActivesDetailsDaysService.getList(DxsActivesDetailsDaysEntity.class);
		return listDxsActivesDetailsDayss;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsActivesDetailsDaysEntity task = dxsActivesDetailsDaysService.get(DxsActivesDetailsDaysEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsActivesDetailsDaysEntity dxsActivesDetailsDays, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsActivesDetailsDaysEntity>> failures = validator.validate(dxsActivesDetailsDays);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsActivesDetailsDaysService.save(dxsActivesDetailsDays);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsActivesDetailsDays.getId();
		URI uri = uriBuilder.path("/rest/dxsActivesDetailsDaysController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsActivesDetailsDaysEntity dxsActivesDetailsDays) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsActivesDetailsDaysEntity>> failures = validator.validate(dxsActivesDetailsDays);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsActivesDetailsDaysService.saveOrUpdate(dxsActivesDetailsDays);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsActivesDetailsDaysService.deleteEntityById(DxsActivesDetailsDaysEntity.class, id);
	}
}
