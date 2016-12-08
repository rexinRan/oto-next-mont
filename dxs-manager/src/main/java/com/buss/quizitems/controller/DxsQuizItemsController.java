package com.buss.quizitems.controller;
import com.buss.quiz.entity.DxsQuizEntity;
import com.buss.quizitems.entity.DxsQuizItemsEntity;
import com.buss.quizitems.service.DxsQuizItemsServiceI;

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
 * @Description: dxs_quiz_items
 * @author onlineGenerator
 * @date 2016-06-02 10:40:29
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsQuizItemsController")
public class DxsQuizItemsController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsQuizItemsController.class);

	@Autowired
	private DxsQuizItemsServiceI dxsQuizItemsService;
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
	 * dxs_quiz_items列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(String quizId, HttpServletRequest request) {
		ModelAndView model = new ModelAndView("com/buss/quizitems/dxsQuizItemsList");
		model.addObject("quizId", quizId);
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
	public void datagrid(DxsQuizItemsEntity dxsQuizItems,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		// 兰啸
		// 增加有效标志
		dxsQuizItems.setIsDelete(0);
		CriteriaQuery cq = new CriteriaQuery(DxsQuizItemsEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsQuizItems, request.getParameterMap());
		try{
			cq.eq("quizId",dxsQuizItems.getQuizId());
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsQuizItemsService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_quiz_items
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsQuizItemsEntity dxsQuizItems, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsQuizItems = systemService.getEntity(DxsQuizItemsEntity.class, dxsQuizItems.getId());
		message = "删除成功";
		try{
			//兰啸
			//更改为无效标志
			dxsQuizItems.setIsDelete(1);
			dxsQuizItemsService.updateEntitie(dxsQuizItems);
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
	 * 批量删除dxs_quiz_items
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
				DxsQuizItemsEntity dxsQuizItems = systemService.getEntity(DxsQuizItemsEntity.class, 
				id
				);
				//兰啸
				//更改为无效标志
				dxsQuizItems.setIsDelete(1);
				dxsQuizItemsService.updateEntitie(dxsQuizItems);
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
	 * 添加dxs_quiz_items
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsQuizItemsEntity dxsQuizItems, HttpServletRequest request) {
		// 兰啸
		// 添加默认字段值
		Date date = new Date();
		dxsQuizItems.setCreateTime(date);
		dxsQuizItems.setUpdateTime(date);
		dxsQuizItems.setIsDelete(0);
		AjaxJson j = new AjaxJson();
		message = "添加成功";
		try{
			dxsQuizItemsService.save(dxsQuizItems);
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
	 * 更新dxs_quiz_items
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsQuizItemsEntity dxsQuizItems, HttpServletRequest request) {
		// 兰啸
		// 更新修改时间
		Date date=new Date();
		dxsQuizItems.setUpdateTime(date);
		AjaxJson j = new AjaxJson();
		message = "更新成功";
		DxsQuizItemsEntity t = dxsQuizItemsService.get(DxsQuizItemsEntity.class, dxsQuizItems.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsQuizItems, t);
			dxsQuizItemsService.saveOrUpdate(t);
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
	 * dxs_quiz_items新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(String quizId, DxsQuizItemsEntity dxsQuizItems, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsQuizItems.getId())) {
			dxsQuizItems = dxsQuizItemsService.getEntity(DxsQuizItemsEntity.class, dxsQuizItems.getId());
			req.setAttribute("dxsQuizItemsPage", dxsQuizItems);
		}
		ModelAndView modelAndView = new ModelAndView("com/buss/quizitems/dxsQuizItems-add");
		modelAndView.addObject("quizId", quizId);
		//兰啸
		//添加试卷
//		List<DxsQuizEntity> dxsQuizList = systemService.findByQueryString("from DxsQuizEntity");
//		req.setAttribute("dxsQuizList", dxsQuizList);
		return modelAndView;
	}
	/**
	 * dxs_quiz_items编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsQuizItemsEntity dxsQuizItems, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsQuizItems.getId())) {
			dxsQuizItems = dxsQuizItemsService.getEntity(DxsQuizItemsEntity.class, dxsQuizItems.getId());
			req.setAttribute("dxsQuizItemsPage", dxsQuizItems);
		}
		//兰啸
		//添加试卷
		List<DxsQuizEntity> dxsQuizList = systemService.findByQueryString("from DxsQuizEntity");
		req.setAttribute("dxsQuizList", dxsQuizList);
		return new ModelAndView("com/buss/quizitems/dxsQuizItems-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsQuizItemsController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsQuizItemsEntity dxsQuizItems,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsQuizItemsEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsQuizItems, request.getParameterMap());
		List<DxsQuizItemsEntity> dxsQuizItemss = this.dxsQuizItemsService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_quiz_items");
		modelMap.put(NormalExcelConstants.CLASS,DxsQuizItemsEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_quiz_items列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsQuizItemss);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsQuizItemsEntity dxsQuizItems,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_quiz_items");
    	modelMap.put(NormalExcelConstants.CLASS,DxsQuizItemsEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_quiz_items列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsQuizItemsEntity> listDxsQuizItemsEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsQuizItemsEntity.class,params);
				for (DxsQuizItemsEntity dxsQuizItems : listDxsQuizItemsEntitys) {
					dxsQuizItemsService.save(dxsQuizItems);
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
	public List<DxsQuizItemsEntity> list() {
		List<DxsQuizItemsEntity> listDxsQuizItemss=dxsQuizItemsService.getList(DxsQuizItemsEntity.class);
		return listDxsQuizItemss;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsQuizItemsEntity task = dxsQuizItemsService.get(DxsQuizItemsEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsQuizItemsEntity dxsQuizItems, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsQuizItemsEntity>> failures = validator.validate(dxsQuizItems);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsQuizItemsService.save(dxsQuizItems);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsQuizItems.getId();
		URI uri = uriBuilder.path("/rest/dxsQuizItemsController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsQuizItemsEntity dxsQuizItems) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsQuizItemsEntity>> failures = validator.validate(dxsQuizItems);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsQuizItemsService.saveOrUpdate(dxsQuizItems);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsQuizItemsService.deleteEntityById(DxsQuizItemsEntity.class, id);
	}
}
