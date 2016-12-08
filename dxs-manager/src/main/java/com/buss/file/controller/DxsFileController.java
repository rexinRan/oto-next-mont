package com.buss.file.controller;
import com.buss.file.entity.DxsFileEntity;
import com.buss.file.service.DxsFileServiceI;
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
 * @Description: dxs_file
 * @author onlineGenerator
 * @date 2016-06-27 19:10:39
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsFileController")
public class DxsFileController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsFileController.class);

	@Autowired
	private DxsFileServiceI dxsFileService;
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
	 * dxs_file列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(String outId,HttpServletRequest request) {
		ModelAndView modelAndView=new ModelAndView("com/buss/file/dxsFileList");
		modelAndView.addObject("outId",outId);
		return modelAndView;
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
	public void datagrid(DxsFileEntity dxsFile,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DxsFileEntity.class, dataGrid);
		//查询条件组装器
		dxsFile.setIsDetail(0);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsFile, request.getParameterMap());
		try{
		//自定义追加查询条件
			cq.eq("outId",dxsFile.getOutId());
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsFileService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_file
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsFileEntity dxsFile, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsFile = systemService.getEntity(DxsFileEntity.class, dxsFile.getId());
		message = "dxs_file删除成功";
		try{
			dxsFileService.delete(dxsFile);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_file删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除dxs_file
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "dxs_file删除成功";
		try{
			for(String id:ids.split(",")){
				DxsFileEntity dxsFile = systemService.getEntity(DxsFileEntity.class, 
				id
				);
				dxsFileService.delete(dxsFile);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_file删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加dxs_file
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(String geetid,DxsFileEntity dxsFile, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "dxs_file添加成功";
		DxsFileEntity t = dxsFileService.get(DxsFileEntity.class,geetid);
		try{
			t.setOutId(dxsFile.getOutId());
			dxsFileService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_file添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	
//	/**
//	 * 更新dxs_file
//	 *
//	 * @param ids
//	 * @return
//	 */
//	@RequestMapping(params = "doUpdate")
//	@ResponseBody
//	public AjaxJson doUpdate(DxsFileEntity dxsFile, HttpServletRequest request) {
//		AjaxJson j = new AjaxJson();
//		message = "dxs_file更新成功";
//		DxsFileEntity t = dxsFileService.get(DxsFileEntity.class,dxsFile.getId());
//		try {
//			dxsFileService.saveOrUpdate(t);
//			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
//		} catch (Exception e) {
//			e.printStackTrace();
//			message = "dxs_file更新失败";
//			throw new BusinessException(e.getMessage());
//		}
//		j.setMsg(message);
//		return j;
//	}
	

	/**
	 * dxs_file新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DxsFileEntity dxsFile, HttpServletRequest req) {

	    	String outId =  dxsFile.getOutId();
			req.setAttribute("outId", outId);

		return new ModelAndView("com/buss/file/dxsFile-add");
	}
	/**
	 * dxs_file编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsFileEntity dxsFile, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsFile.getId())) {
			dxsFile = dxsFileService.getEntity(DxsFileEntity.class, dxsFile.getId());
			req.setAttribute("dxsFilePage", dxsFile);
		}
		return new ModelAndView("com/buss/file/dxsFile-update");
	}

	/**
	 * dxs_file编辑页面跳转
	 *
	 * @return
	 */
	@RequestMapping(params = "wenJianUpdate")
	public ModelAndView wenJianUpdate(DxsFileEntity dxsFile, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsFile.getId())) {
			DxsFileEntity t = dxsFileService.get(DxsFileEntity.class, dxsFile.getId());
			req.setAttribute("dxsFilePage",t);
			req.setAttribute("outId", dxsFile.getOutId());
		}
		return new ModelAndView("com/buss/file/dxsFile-update");
	}



	@RequestMapping(params = "dowenjianUpdate")
	@ResponseBody
	public AjaxJson dowenjianUpdate(String geetid,DxsFileEntity dxsFile, HttpServletRequest request) {
		DxsFileEntity d = dxsFileService.get(DxsFileEntity.class, dxsFile.getId());
		d.setIsDetail(1);
		dxsFileService.saveOrUpdate(d);

		AjaxJson j = new AjaxJson();
		message = "dxs_file更新成功";
		DxsFileEntity t = dxsFileService.get(DxsFileEntity.class,geetid);
		try {
		t.setOutId(dxsFile.getOutId());
			dxsFileService.saveOrUpdate(t);
		} catch (Exception e) {
			e.printStackTrace();
			message = "dxs_file更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsFileController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsFileEntity dxsFile,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsFileEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsFile, request.getParameterMap());
		List<DxsFileEntity> dxsFiles = this.dxsFileService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_file");
		modelMap.put(NormalExcelConstants.CLASS,DxsFileEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_file列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsFiles);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsFileEntity dxsFile,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_file");
    	modelMap.put(NormalExcelConstants.CLASS,DxsFileEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_file列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsFileEntity> listDxsFileEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsFileEntity.class,params);
				for (DxsFileEntity dxsFile : listDxsFileEntitys) {
					dxsFileService.save(dxsFile);
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
	public List<DxsFileEntity> list() {
		List<DxsFileEntity> listDxsFiles=dxsFileService.getList(DxsFileEntity.class);
		return listDxsFiles;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsFileEntity task = dxsFileService.get(DxsFileEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsFileEntity dxsFile, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsFileEntity>> failures = validator.validate(dxsFile);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsFileService.save(dxsFile);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsFile.getId();
		URI uri = uriBuilder.path("/rest/dxsFileController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsFileEntity dxsFile) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsFileEntity>> failures = validator.validate(dxsFile);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsFileService.saveOrUpdate(dxsFile);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsFileService.deleteEntityById(DxsFileEntity.class, id);
	}
}
