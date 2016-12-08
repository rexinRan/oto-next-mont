package com.buss.specialrecruit.controller;
import com.buss.specialrecruit.entity.DxsSpecialRecruitEntity;
import com.buss.specialrecruit.service.DxsSpecialRecruitServiceI;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
 * @Description: dxs_special_recruit
 * @author onlineGenerator
 * @date 2016-07-25 15:57:25
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsSpecialRecruitController")
public class DxsSpecialRecruitController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsSpecialRecruitController.class);

	@Autowired
	private DxsSpecialRecruitServiceI dxsSpecialRecruitService;
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
	 * dxs_special_recruit列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/specialrecruit/dxsSpecialRecruitList");
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
	public void datagrid(DxsSpecialRecruitEntity dxsSpecialRecruit,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DxsSpecialRecruitEntity.class, dataGrid);
		//查询条件组装器
		dxsSpecialRecruit.setIsDelete(0);
		cq.addOrder("createTime", SortDirection.desc);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsSpecialRecruit, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsSpecialRecruitService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_special_recruit
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsSpecialRecruitEntity dxsSpecialRecruit, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsSpecialRecruit = systemService.getEntity(DxsSpecialRecruitEntity.class, dxsSpecialRecruit.getId());
		message = "dxs_special_recruit删除成功";
		try{
			dxsSpecialRecruit.setIsDelete(1);
			dxsSpecialRecruitService.saveOrUpdate(dxsSpecialRecruit);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_special_recruit删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除dxs_special_recruit
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "dxs_special_recruit删除成功";
		try{
			for(String id:ids.split(",")){
				DxsSpecialRecruitEntity dxsSpecialRecruit = systemService.getEntity(DxsSpecialRecruitEntity.class, 
				id
				);
				dxsSpecialRecruit.setIsDelete(1);
				dxsSpecialRecruitService.saveOrUpdate(dxsSpecialRecruit);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_special_recruit删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加dxs_special_recruit
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsSpecialRecruitEntity dxsSpecialRecruit, HttpServletRequest request) {
		dxsSpecialRecruit.setIsDelete(0);
		AjaxJson j = new AjaxJson();
		message = "dxs_special_recruit添加成功";
		try{
			dxsSpecialRecruitService.save(dxsSpecialRecruit);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_special_recruit添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新dxs_special_recruit
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsSpecialRecruitEntity dxsSpecialRecruit, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "dxs_special_recruit更新成功";
		DxsSpecialRecruitEntity t = dxsSpecialRecruitService.get(DxsSpecialRecruitEntity.class, dxsSpecialRecruit.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsSpecialRecruit, t);
			dxsSpecialRecruitService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "dxs_special_recruit更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * dxs_special_recruit新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DxsSpecialRecruitEntity dxsSpecialRecruit, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsSpecialRecruit.getId())) {
			dxsSpecialRecruit = dxsSpecialRecruitService.getEntity(DxsSpecialRecruitEntity.class, dxsSpecialRecruit.getId());
			req.setAttribute("dxsSpecialRecruitPage", dxsSpecialRecruit);
		}
		return new ModelAndView("com/buss/specialrecruit/dxsSpecialRecruit-add");
	}
	/**
	 * dxs_special_recruit编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsSpecialRecruitEntity dxsSpecialRecruit, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsSpecialRecruit.getId())) {
			dxsSpecialRecruit = dxsSpecialRecruitService.getEntity(DxsSpecialRecruitEntity.class, dxsSpecialRecruit.getId());
			req.setAttribute("dxsSpecialRecruitPage", dxsSpecialRecruit);
		}
		return new ModelAndView("com/buss/specialrecruit/dxsSpecialRecruit-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsSpecialRecruitController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsSpecialRecruitEntity dxsSpecialRecruit,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsSpecialRecruitEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsSpecialRecruit, request.getParameterMap());
		List<DxsSpecialRecruitEntity> dxsSpecialRecruits = this.dxsSpecialRecruitService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_special_recruit");
		modelMap.put(NormalExcelConstants.CLASS,DxsSpecialRecruitEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_special_recruit列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsSpecialRecruits);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsSpecialRecruitEntity dxsSpecialRecruit,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_special_recruit");
    	modelMap.put(NormalExcelConstants.CLASS,DxsSpecialRecruitEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_special_recruit列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsSpecialRecruitEntity> listDxsSpecialRecruitEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsSpecialRecruitEntity.class,params);
				for (DxsSpecialRecruitEntity dxsSpecialRecruit : listDxsSpecialRecruitEntitys) {
					dxsSpecialRecruitService.save(dxsSpecialRecruit);
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
	public List<DxsSpecialRecruitEntity> list() {
		List<DxsSpecialRecruitEntity> listDxsSpecialRecruits=dxsSpecialRecruitService.getList(DxsSpecialRecruitEntity.class);
		return listDxsSpecialRecruits;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsSpecialRecruitEntity task = dxsSpecialRecruitService.get(DxsSpecialRecruitEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsSpecialRecruitEntity dxsSpecialRecruit, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsSpecialRecruitEntity>> failures = validator.validate(dxsSpecialRecruit);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsSpecialRecruitService.save(dxsSpecialRecruit);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsSpecialRecruit.getId();
		URI uri = uriBuilder.path("/rest/dxsSpecialRecruitController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsSpecialRecruitEntity dxsSpecialRecruit) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsSpecialRecruitEntity>> failures = validator.validate(dxsSpecialRecruit);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsSpecialRecruitService.saveOrUpdate(dxsSpecialRecruit);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsSpecialRecruitService.deleteEntityById(DxsSpecialRecruitEntity.class, id);
	}
}
