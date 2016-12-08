package com.buss.quizuseritem.controller;
import com.buss.quizuseritem.entity.DxsQuizUserItemEntity;
import com.buss.quizuseritem.service.DxsQuizUserItemServiceI;
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
 * @Description: dxs_quiz_user_item
 * @author onlineGenerator
 * @date 2016-06-16 09:34:07
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsQuizUserItemController")
public class DxsQuizUserItemController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsQuizUserItemController.class);

	@Autowired
	private DxsQuizUserItemServiceI dxsQuizUserItemService;
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
	 * dxs_quiz_user_item列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list( String quizUserId, HttpServletRequest request) {
		ModelAndView model = new ModelAndView("com/buss/quizuseritem/dxsQuizUserItemList");
		model.addObject("quizUserId", quizUserId);
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
	public void datagrid(DxsQuizUserItemEntity dxsQuizUserItem,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DxsQuizUserItemEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsQuizUserItem, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsQuizUserItemService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_quiz_user_item
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsQuizUserItemEntity dxsQuizUserItem, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsQuizUserItem = systemService.getEntity(DxsQuizUserItemEntity.class, dxsQuizUserItem.getId());
		message = "dxs_quiz_user_item删除成功";
		try{
			dxsQuizUserItemService.delete(dxsQuizUserItem);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_quiz_user_item删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除dxs_quiz_user_item
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "dxs_quiz_user_item删除成功";
		try{
			for(String id:ids.split(",")){
				DxsQuizUserItemEntity dxsQuizUserItem = systemService.getEntity(DxsQuizUserItemEntity.class, 
				id
				);
				dxsQuizUserItemService.delete(dxsQuizUserItem);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_quiz_user_item删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加dxs_quiz_user_item
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsQuizUserItemEntity dxsQuizUserItem, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "dxs_quiz_user_item添加成功";
		try{
			dxsQuizUserItemService.save(dxsQuizUserItem);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_quiz_user_item添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新dxs_quiz_user_item
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsQuizUserItemEntity dxsQuizUserItem, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "dxs_quiz_user_item更新成功";
		DxsQuizUserItemEntity t = dxsQuizUserItemService.get(DxsQuizUserItemEntity.class, dxsQuizUserItem.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsQuizUserItem, t);
			dxsQuizUserItemService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "dxs_quiz_user_item更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * dxs_quiz_user_item新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DxsQuizUserItemEntity dxsQuizUserItem, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsQuizUserItem.getId())) {
			dxsQuizUserItem = dxsQuizUserItemService.getEntity(DxsQuizUserItemEntity.class, dxsQuizUserItem.getId());
			req.setAttribute("dxsQuizUserItemPage", dxsQuizUserItem);
		}
		return new ModelAndView("com/buss/quizuseritem/dxsQuizUserItem-add");
	}
	/**
	 * dxs_quiz_user_item编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsQuizUserItemEntity dxsQuizUserItem, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsQuizUserItem.getId())) {
			dxsQuizUserItem = dxsQuizUserItemService.getEntity(DxsQuizUserItemEntity.class, dxsQuizUserItem.getId());
			req.setAttribute("dxsQuizUserItemPage", dxsQuizUserItem);
		}
		return new ModelAndView("com/buss/quizuseritem/dxsQuizUserItem-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsQuizUserItemController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsQuizUserItemEntity dxsQuizUserItem,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsQuizUserItemEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsQuizUserItem, request.getParameterMap());
		List<DxsQuizUserItemEntity> dxsQuizUserItems = this.dxsQuizUserItemService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_quiz_user_item");
		modelMap.put(NormalExcelConstants.CLASS,DxsQuizUserItemEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_quiz_user_item列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsQuizUserItems);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsQuizUserItemEntity dxsQuizUserItem,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_quiz_user_item");
    	modelMap.put(NormalExcelConstants.CLASS,DxsQuizUserItemEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_quiz_user_item列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsQuizUserItemEntity> listDxsQuizUserItemEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsQuizUserItemEntity.class,params);
				for (DxsQuizUserItemEntity dxsQuizUserItem : listDxsQuizUserItemEntitys) {
					dxsQuizUserItemService.save(dxsQuizUserItem);
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
	public List<DxsQuizUserItemEntity> list() {
		List<DxsQuizUserItemEntity> listDxsQuizUserItems=dxsQuizUserItemService.getList(DxsQuizUserItemEntity.class);
		return listDxsQuizUserItems;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsQuizUserItemEntity task = dxsQuizUserItemService.get(DxsQuizUserItemEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsQuizUserItemEntity dxsQuizUserItem, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsQuizUserItemEntity>> failures = validator.validate(dxsQuizUserItem);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsQuizUserItemService.save(dxsQuizUserItem);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsQuizUserItem.getId();
		URI uri = uriBuilder.path("/rest/dxsQuizUserItemController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsQuizUserItemEntity dxsQuizUserItem) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsQuizUserItemEntity>> failures = validator.validate(dxsQuizUserItem);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsQuizUserItemService.saveOrUpdate(dxsQuizUserItem);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsQuizUserItemService.deleteEntityById(DxsQuizUserItemEntity.class, id);
	}
}
