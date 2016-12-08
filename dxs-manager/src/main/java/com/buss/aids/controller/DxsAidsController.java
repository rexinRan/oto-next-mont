package com.buss.aids.controller;
import com.buss.aidcatelog.entity.DxsAidCatelogEntity;
import com.buss.aids.entity.DxsAidsEntity;
import com.buss.aids.service.DxsAidsServiceI;

import java.util.*;
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
 * @Description: dxs_aids
 * @author onlineGenerator
 * @date 2016-08-24 13:53:42
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsAidsController")
public class DxsAidsController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsAidsController.class);

	@Autowired
	private DxsAidsServiceI dxsAidsService;
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
	 * dxs_aids列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/aids/dxsAidsList");
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
	public void datagrid(DxsAidsEntity dxsAids,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		dxsAids.setIsDelete(0);
		CriteriaQuery cq = new CriteriaQuery(DxsAidsEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsAids, request.getParameterMap());
		try{
		//自定义追加查询条件
			cq.addOrder("createTime", SortDirection.desc);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsAidsService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_aids
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsAidsEntity dxsAids, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsAids = systemService.getEntity(DxsAidsEntity.class, dxsAids.getId());
		message = "dxs_aids删除成功";
		try{
			dxsAids.setIsDelete(1);
			dxsAidsService.saveOrUpdate(dxsAids);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_aids删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除dxs_aids
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "dxs_aids删除成功";
		try{
			for(String id:ids.split(",")){
				DxsAidsEntity dxsAids = systemService.getEntity(DxsAidsEntity.class, 
				id
				);
				dxsAids.setIsDelete(1);
				dxsAidsService.saveOrUpdate(dxsAids);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_aids删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加dxs_aids
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsAidsEntity dxsAids, HttpServletRequest request) {
		dxsAids.setIsDelete(0);
		Calendar c = Calendar.getInstance();
		c.setTime(dxsAids.getAidPublishTime());
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		String ye=Integer.toString(year);
		String mon=Integer.toString(month);
		dxsAids.setAidPublishYear(ye);
		dxsAids.setAidPublicMonth(mon);
		AjaxJson j = new AjaxJson();
		message = "dxs_aids添加成功";
		try{
			dxsAidsService.save(dxsAids);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_aids添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新dxs_aids
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsAidsEntity dxsAids, HttpServletRequest request) {

		Calendar c = Calendar.getInstance();
		c.setTime(dxsAids.getAidPublishTime());
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH)+1;
		String ye=Integer.toString(year);
		String mon=Integer.toString(month);
		dxsAids.setAidPublishYear(ye);
		dxsAids.setAidPublicMonth(mon);
		AjaxJson j = new AjaxJson();
		message = "dxs_aids更新成功";
		DxsAidsEntity t = dxsAidsService.get(DxsAidsEntity.class, dxsAids.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsAids, t);
			dxsAidsService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "dxs_aids更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * dxs_aids新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DxsAidsEntity dxsAids, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsAids.getId())) {
			dxsAids = dxsAidsService.getEntity(DxsAidsEntity.class, dxsAids.getId());
			req.setAttribute("dxsAidsPage", dxsAids);
		}
		DxsAidCatelogEntity dxsAidCatelogEntity =new DxsAidCatelogEntity();
		dxsAidCatelogEntity.setIsDelete(0);
		List<DxsAidCatelogEntity> dxsAidCatelogList=systemService.findByExample(DxsAidCatelogEntity.class.getName(),dxsAidCatelogEntity);
		req.setAttribute("dxsAidCatelogList",dxsAidCatelogList);
		return new ModelAndView("com/buss/aids/dxsAids-add");
	}
	/**
	 * dxs_aids编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsAidsEntity dxsAids, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsAids.getId())) {
			dxsAids = dxsAidsService.getEntity(DxsAidsEntity.class, dxsAids.getId());
			req.setAttribute("dxsAidsPage", dxsAids);
		}
		DxsAidCatelogEntity dxsAidCatelogEntity =new DxsAidCatelogEntity();
		dxsAidCatelogEntity.setIsDelete(0);
		List<DxsAidCatelogEntity> dxsAidCatelogList=systemService.findByExample(DxsAidCatelogEntity.class.getName(),dxsAidCatelogEntity);
		req.setAttribute("dxsAidCatelogList",dxsAidCatelogList);
		return new ModelAndView("com/buss/aids/dxsAids-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsAidsController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsAidsEntity dxsAids,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsAidsEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsAids, request.getParameterMap());
		List<DxsAidsEntity> dxsAidss = this.dxsAidsService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_aids");
		modelMap.put(NormalExcelConstants.CLASS,DxsAidsEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_aids列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsAidss);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsAidsEntity dxsAids,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_aids");
    	modelMap.put(NormalExcelConstants.CLASS,DxsAidsEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_aids列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsAidsEntity> listDxsAidsEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsAidsEntity.class,params);
				for (DxsAidsEntity dxsAids : listDxsAidsEntitys) {
					dxsAidsService.save(dxsAids);
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
	public List<DxsAidsEntity> list() {
		List<DxsAidsEntity> listDxsAidss=dxsAidsService.getList(DxsAidsEntity.class);
		return listDxsAidss;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsAidsEntity task = dxsAidsService.get(DxsAidsEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsAidsEntity dxsAids, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsAidsEntity>> failures = validator.validate(dxsAids);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsAidsService.save(dxsAids);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsAids.getId();
		URI uri = uriBuilder.path("/rest/dxsAidsController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsAidsEntity dxsAids) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsAidsEntity>> failures = validator.validate(dxsAids);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsAidsService.saveOrUpdate(dxsAids);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsAidsService.deleteEntityById(DxsAidsEntity.class, id);
	}
}
