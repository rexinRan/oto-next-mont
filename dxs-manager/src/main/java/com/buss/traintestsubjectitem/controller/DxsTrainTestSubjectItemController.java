package com.buss.traintestsubjectitem.controller;
import com.buss.traintestsubjectitem.entity.DxsTrainTestSubjectItemEntity;
import com.buss.traintestsubjectitem.service.DxsTrainTestSubjectItemServiceI;

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
 * @Description: dxs_train_test_subject_item
 * @author dq
 * @date 2016-09-08 11:56:25
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsTrainTestSubjectItemController")
public class DxsTrainTestSubjectItemController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsTrainTestSubjectItemController.class);

	@Autowired
	private DxsTrainTestSubjectItemServiceI dxsTrainTestSubjectItemService;
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
	 * dxs_train_test_subject_item列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(String ttsId,String ttId,HttpServletRequest request) {
		//dq添加修改标志
		ModelAndView model = new ModelAndView("com/buss/traintestsubjectitem/dxsTrainTestSubjectItemList");
		model.addObject("ttsId",ttsId);
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
	public void datagrid(DxsTrainTestSubjectItemEntity dxsTrainTestSubjectItem,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//dq添加标志项
		dxsTrainTestSubjectItem.setIsDelete(0);

		CriteriaQuery cq = new CriteriaQuery(DxsTrainTestSubjectItemEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsTrainTestSubjectItem, request.getParameterMap());
		try{
		//自定义追加查询条件

			//dq添加修改标志项
			cq.eq("ttsId",dxsTrainTestSubjectItem.getTtsId());

		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsTrainTestSubjectItemService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_train_test_subject_item
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsTrainTestSubjectItemEntity dxsTrainTestSubjectItem, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsTrainTestSubjectItem = systemService.getEntity(DxsTrainTestSubjectItemEntity.class, dxsTrainTestSubjectItem.getId());
		message = "dxs_train_test_subject_item删除成功";
		try{
			//dq修改标志项
			dxsTrainTestSubjectItem.setIsDelete(1);
			dxsTrainTestSubjectItemService.saveOrUpdate(dxsTrainTestSubjectItem);

			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_train_test_subject_item删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除dxs_train_test_subject_item
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "dxs_train_test_subject_item删除成功";
		try{
			for(String id:ids.split(",")){
				DxsTrainTestSubjectItemEntity dxsTrainTestSubjectItem = systemService.getEntity(DxsTrainTestSubjectItemEntity.class, 
				id
				);

				//dq修改标志项
				dxsTrainTestSubjectItem.setIsDelete(1);
				dxsTrainTestSubjectItemService.saveOrUpdate(dxsTrainTestSubjectItem);

				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_train_test_subject_item删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加dxs_train_test_subject_item
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsTrainTestSubjectItemEntity dxsTrainTestSubjectItem, HttpServletRequest request) {
		//dq添加有效标志项
		Date date = new Date ();
		dxsTrainTestSubjectItem.setUpdateTime(date);
		dxsTrainTestSubjectItem.setCreateTime(date);
		dxsTrainTestSubjectItem.setIsDelete(0);

		AjaxJson j = new AjaxJson();
		message = "dxs_train_test_subject_item添加成功";
		try{
			dxsTrainTestSubjectItemService.save(dxsTrainTestSubjectItem);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_train_test_subject_item添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新dxs_train_test_subject_item
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsTrainTestSubjectItemEntity dxsTrainTestSubjectItem, HttpServletRequest request) {
		//dq添加有效标志项
		Date date = new Date ();
		dxsTrainTestSubjectItem.setUpdateTime(date);

		AjaxJson j = new AjaxJson();
		message = "dxs_train_test_subject_item更新成功";
		DxsTrainTestSubjectItemEntity t = dxsTrainTestSubjectItemService.get(DxsTrainTestSubjectItemEntity.class, dxsTrainTestSubjectItem.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsTrainTestSubjectItem, t);
			dxsTrainTestSubjectItemService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "dxs_train_test_subject_item更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * dxs_train_test_subject_item新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(String ttsId,DxsTrainTestSubjectItemEntity dxsTrainTestSubjectItem, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsTrainTestSubjectItem.getId())) {
			dxsTrainTestSubjectItem = dxsTrainTestSubjectItemService.getEntity(DxsTrainTestSubjectItemEntity.class, dxsTrainTestSubjectItem.getId());
			req.setAttribute("dxsTrainTestSubjectItemPage", dxsTrainTestSubjectItem);
		}

		//dq添加修改标志项
		ModelAndView model = new ModelAndView("com/buss/traintestsubjectitem/dxsTrainTestSubjectItem-add");
		model.addObject("ttsId",ttsId);
		return model;
	}
	/**
	 * dxs_train_test_subject_item编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsTrainTestSubjectItemEntity dxsTrainTestSubjectItem, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsTrainTestSubjectItem.getId())) {
			dxsTrainTestSubjectItem = dxsTrainTestSubjectItemService.getEntity(DxsTrainTestSubjectItemEntity.class, dxsTrainTestSubjectItem.getId());
			req.setAttribute("dxsTrainTestSubjectItemPage", dxsTrainTestSubjectItem);
		}
		return new ModelAndView("com/buss/traintestsubjectitem/dxsTrainTestSubjectItem-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsTrainTestSubjectItemController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsTrainTestSubjectItemEntity dxsTrainTestSubjectItem,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsTrainTestSubjectItemEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsTrainTestSubjectItem, request.getParameterMap());
		List<DxsTrainTestSubjectItemEntity> dxsTrainTestSubjectItems = this.dxsTrainTestSubjectItemService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_train_test_subject_item");
		modelMap.put(NormalExcelConstants.CLASS,DxsTrainTestSubjectItemEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_train_test_subject_item列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsTrainTestSubjectItems);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsTrainTestSubjectItemEntity dxsTrainTestSubjectItem,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_train_test_subject_item");
    	modelMap.put(NormalExcelConstants.CLASS,DxsTrainTestSubjectItemEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_train_test_subject_item列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsTrainTestSubjectItemEntity> listDxsTrainTestSubjectItemEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsTrainTestSubjectItemEntity.class,params);
				for (DxsTrainTestSubjectItemEntity dxsTrainTestSubjectItem : listDxsTrainTestSubjectItemEntitys) {
					dxsTrainTestSubjectItemService.save(dxsTrainTestSubjectItem);
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
	public List<DxsTrainTestSubjectItemEntity> list() {
		List<DxsTrainTestSubjectItemEntity> listDxsTrainTestSubjectItems=dxsTrainTestSubjectItemService.getList(DxsTrainTestSubjectItemEntity.class);
		return listDxsTrainTestSubjectItems;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsTrainTestSubjectItemEntity task = dxsTrainTestSubjectItemService.get(DxsTrainTestSubjectItemEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsTrainTestSubjectItemEntity dxsTrainTestSubjectItem, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsTrainTestSubjectItemEntity>> failures = validator.validate(dxsTrainTestSubjectItem);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsTrainTestSubjectItemService.save(dxsTrainTestSubjectItem);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsTrainTestSubjectItem.getId();
		URI uri = uriBuilder.path("/rest/dxsTrainTestSubjectItemController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsTrainTestSubjectItemEntity dxsTrainTestSubjectItem) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsTrainTestSubjectItemEntity>> failures = validator.validate(dxsTrainTestSubjectItem);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsTrainTestSubjectItemService.saveOrUpdate(dxsTrainTestSubjectItem);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsTrainTestSubjectItemService.deleteEntityById(DxsTrainTestSubjectItemEntity.class, id);
	}
}
