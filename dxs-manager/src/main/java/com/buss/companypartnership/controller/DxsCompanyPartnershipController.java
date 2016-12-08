package com.buss.companypartnership.controller;
import com.buss.companypartnership.entity.DxsCompanyPartnershipEntity;
import com.buss.companypartnership.service.DxsCompanyPartnershipServiceI;

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
 * @Description: dxs_company_partnership
 * @author onlineGenerator
 * @date 2016-06-03 10:42:06
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsCompanyPartnershipController")
public class DxsCompanyPartnershipController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsCompanyPartnershipController.class);

	@Autowired
	private DxsCompanyPartnershipServiceI dxsCompanyPartnershipService;
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
	 * dxs_company_partnership列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/companypartnership/dxsCompanyPartnershipList");
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
	public void datagrid(DxsCompanyPartnershipEntity dxsCompanyPartnership,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		// 兰啸
		// 增加有效标志
		dxsCompanyPartnership.setIsDelete(0);
		CriteriaQuery cq = new CriteriaQuery(DxsCompanyPartnershipEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsCompanyPartnership, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsCompanyPartnershipService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_company_partnership
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsCompanyPartnershipEntity dxsCompanyPartnership, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsCompanyPartnership = systemService.getEntity(DxsCompanyPartnershipEntity.class, dxsCompanyPartnership.getId());
		message = "删除成功";
		try{
			//兰啸
			//更改为无效标志
			dxsCompanyPartnership.setIsDelete(1);
			dxsCompanyPartnershipService.updateEntitie(dxsCompanyPartnership);
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
	 * 批量删除dxs_company_partnership
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
				DxsCompanyPartnershipEntity dxsCompanyPartnership = systemService.getEntity(DxsCompanyPartnershipEntity.class, 
				id
				);
				//兰啸
				//更改为无效标志
				dxsCompanyPartnership.setIsDelete(1);
				dxsCompanyPartnershipService.updateEntitie(dxsCompanyPartnership);
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
	 * 添加dxs_company_partnership
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsCompanyPartnershipEntity dxsCompanyPartnership, HttpServletRequest request) {
		// 兰啸
		// 添加默认字段值
		Date date=new Date();
		dxsCompanyPartnership.setCreateTime(date);
		dxsCompanyPartnership.setUpdateTime(date);
		dxsCompanyPartnership.setIsDelete(0);
		AjaxJson j = new AjaxJson();
		message = "添加成功";
		try{
			dxsCompanyPartnershipService.save(dxsCompanyPartnership);
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
	 * 更新dxs_company_partnership
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsCompanyPartnershipEntity dxsCompanyPartnership, HttpServletRequest request) {
		// 兰啸
		// 更新修改时间
		Date date=new Date();
		dxsCompanyPartnership.setUpdateTime(date);
		AjaxJson j = new AjaxJson();
		message = "更新成功";
		DxsCompanyPartnershipEntity t = dxsCompanyPartnershipService.get(DxsCompanyPartnershipEntity.class, dxsCompanyPartnership.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsCompanyPartnership, t);
			dxsCompanyPartnershipService.saveOrUpdate(t);
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
	 * dxs_company_partnership新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DxsCompanyPartnershipEntity dxsCompanyPartnership, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsCompanyPartnership.getId())) {
			dxsCompanyPartnership = dxsCompanyPartnershipService.getEntity(DxsCompanyPartnershipEntity.class, dxsCompanyPartnership.getId());
			req.setAttribute("dxsCompanyPartnershipPage", dxsCompanyPartnership);
		}
		return new ModelAndView("com/buss/companypartnership/dxsCompanyPartnership-add");
	}
	/**
	 * dxs_company_partnership编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsCompanyPartnershipEntity dxsCompanyPartnership, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsCompanyPartnership.getId())) {
			dxsCompanyPartnership = dxsCompanyPartnershipService.getEntity(DxsCompanyPartnershipEntity.class, dxsCompanyPartnership.getId());
			req.setAttribute("dxsCompanyPartnershipPage", dxsCompanyPartnership);
		}
		return new ModelAndView("com/buss/companypartnership/dxsCompanyPartnership-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsCompanyPartnershipController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsCompanyPartnershipEntity dxsCompanyPartnership,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsCompanyPartnershipEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsCompanyPartnership, request.getParameterMap());
		List<DxsCompanyPartnershipEntity> dxsCompanyPartnerships = this.dxsCompanyPartnershipService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_company_partnership");
		modelMap.put(NormalExcelConstants.CLASS,DxsCompanyPartnershipEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_company_partnership列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsCompanyPartnerships);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsCompanyPartnershipEntity dxsCompanyPartnership,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_company_partnership");
    	modelMap.put(NormalExcelConstants.CLASS,DxsCompanyPartnershipEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_company_partnership列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsCompanyPartnershipEntity> listDxsCompanyPartnershipEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsCompanyPartnershipEntity.class,params);
				for (DxsCompanyPartnershipEntity dxsCompanyPartnership : listDxsCompanyPartnershipEntitys) {
					dxsCompanyPartnershipService.save(dxsCompanyPartnership);
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
	public List<DxsCompanyPartnershipEntity> list() {
		List<DxsCompanyPartnershipEntity> listDxsCompanyPartnerships=dxsCompanyPartnershipService.getList(DxsCompanyPartnershipEntity.class);
		return listDxsCompanyPartnerships;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsCompanyPartnershipEntity task = dxsCompanyPartnershipService.get(DxsCompanyPartnershipEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsCompanyPartnershipEntity dxsCompanyPartnership, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsCompanyPartnershipEntity>> failures = validator.validate(dxsCompanyPartnership);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsCompanyPartnershipService.save(dxsCompanyPartnership);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsCompanyPartnership.getId();
		URI uri = uriBuilder.path("/rest/dxsCompanyPartnershipController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsCompanyPartnershipEntity dxsCompanyPartnership) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsCompanyPartnershipEntity>> failures = validator.validate(dxsCompanyPartnership);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsCompanyPartnershipService.saveOrUpdate(dxsCompanyPartnership);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsCompanyPartnershipService.deleteEntityById(DxsCompanyPartnershipEntity.class, id);
	}
}
