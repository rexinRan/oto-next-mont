package com.buss.specialsyouthimg.controller;
import com.buss.specialsyouthimg.entity.DxsSpecialsYouthImgEntity;
import com.buss.specialsyouthimg.service.DxsSpecialsYouthImgServiceI;

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
 * @Description: dxs_specials_youth_img
 * @author onlineGenerator
 * @date 2016-08-15 10:44:32
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsSpecialsYouthImgController")
public class DxsSpecialsYouthImgController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsSpecialsYouthImgController.class);

	@Autowired
	private DxsSpecialsYouthImgServiceI dxsSpecialsYouthImgService;
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
	 * dxs_specials_youth_img列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(String dsyiId,HttpServletRequest request) {
		//大权添加修改
		ModelAndView mode =	new ModelAndView("com/buss/specialsyouthimg/dxsSpecialsYouthImgList");
		mode.addObject("dsyiId",dsyiId);
		return mode;

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
	public void datagrid(DxsSpecialsYouthImgEntity dxsSpecialsYouthImg,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DxsSpecialsYouthImgEntity.class, dataGrid);
		//查询条件组装器

		//大权添加标志信息
		dxsSpecialsYouthImg.setIsDelete(0);

		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsSpecialsYouthImg, request.getParameterMap());
		try{
		//自定义追加查询条件
			cq.addOrder("createTime", SortDirection.desc);
			cq.eq("dsyiId",dxsSpecialsYouthImg.getDsyiId());
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsSpecialsYouthImgService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_specials_youth_img
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsSpecialsYouthImgEntity dxsSpecialsYouthImg, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsSpecialsYouthImg = systemService.getEntity(DxsSpecialsYouthImgEntity.class, dxsSpecialsYouthImg.getId());
		message = "dxs_specials_youth_img删除成功";
		try{

			//大权添加/修改标志信息
			dxsSpecialsYouthImg.setIsDelete(1);
			dxsSpecialsYouthImgService.saveOrUpdate(dxsSpecialsYouthImg);

			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_specials_youth_img删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除dxs_specials_youth_img
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "dxs_specials_youth_img删除成功";
		try{
			for(String id:ids.split(",")){
				DxsSpecialsYouthImgEntity dxsSpecialsYouthImg = systemService.getEntity(DxsSpecialsYouthImgEntity.class,
				id
				);

				//大权添加/修改标志信息
				dxsSpecialsYouthImg.setIsDelete(1);
				dxsSpecialsYouthImgService.saveOrUpdate(dxsSpecialsYouthImg);

				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_specials_youth_img删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加dxs_specials_youth_img
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsSpecialsYouthImgEntity dxsSpecialsYouthImg, HttpServletRequest request) {
		//大权添加标志信息
		Date date = new Date();
		dxsSpecialsYouthImg.setCreateTime(date);
		dxsSpecialsYouthImg.setCreateTime(date);
		dxsSpecialsYouthImg.setIsDelete(0);

		AjaxJson j = new AjaxJson();
		message = "dxs_specials_youth_img添加成功";
		try{
			dxsSpecialsYouthImgService.save(dxsSpecialsYouthImg);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_specials_youth_img添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新dxs_specials_youth_img
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsSpecialsYouthImgEntity dxsSpecialsYouthImg, HttpServletRequest request) {
		//大权添加标志信息
		Date date = new Date();
		dxsSpecialsYouthImg.setUpdateTime(date);

		AjaxJson j = new AjaxJson();
		message = "dxs_specials_youth_img更新成功";
		DxsSpecialsYouthImgEntity t = dxsSpecialsYouthImgService.get(DxsSpecialsYouthImgEntity.class, dxsSpecialsYouthImg.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsSpecialsYouthImg, t);
			dxsSpecialsYouthImgService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "dxs_specials_youth_img更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * dxs_specials_youth_img新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(String dsyiId,DxsSpecialsYouthImgEntity dxsSpecialsYouthImg, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsSpecialsYouthImg.getId())) {
			dxsSpecialsYouthImg = dxsSpecialsYouthImgService.getEntity(DxsSpecialsYouthImgEntity.class, dxsSpecialsYouthImg.getId());
			req.setAttribute("dxsSpecialsYouthImgPage", dxsSpecialsYouthImg);
		}
		ModelAndView modelAndView=new ModelAndView("com/buss/specialsyouthimg/dxsSpecialsYouthImg-add");
		modelAndView.addObject("dsyiId",dsyiId);
		return modelAndView;
	}
	/**
	 * dxs_specials_youth_img编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsSpecialsYouthImgEntity dxsSpecialsYouthImg, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsSpecialsYouthImg.getId())) {
			dxsSpecialsYouthImg = dxsSpecialsYouthImgService.getEntity(DxsSpecialsYouthImgEntity.class, dxsSpecialsYouthImg.getId());
			req.setAttribute("dxsSpecialsYouthImgPage", dxsSpecialsYouthImg);
		}
		return new ModelAndView("com/buss/specialsyouthimg/dxsSpecialsYouthImg-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsSpecialsYouthImgController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsSpecialsYouthImgEntity dxsSpecialsYouthImg,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsSpecialsYouthImgEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsSpecialsYouthImg, request.getParameterMap());
		List<DxsSpecialsYouthImgEntity> dxsSpecialsYouthImgs = this.dxsSpecialsYouthImgService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_specials_youth_img");
		modelMap.put(NormalExcelConstants.CLASS,DxsSpecialsYouthImgEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_specials_youth_img列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsSpecialsYouthImgs);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsSpecialsYouthImgEntity dxsSpecialsYouthImg,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_specials_youth_img");
    	modelMap.put(NormalExcelConstants.CLASS,DxsSpecialsYouthImgEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_specials_youth_img列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsSpecialsYouthImgEntity> listDxsSpecialsYouthImgEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsSpecialsYouthImgEntity.class,params);
				for (DxsSpecialsYouthImgEntity dxsSpecialsYouthImg : listDxsSpecialsYouthImgEntitys) {
					dxsSpecialsYouthImgService.save(dxsSpecialsYouthImg);
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
	public List<DxsSpecialsYouthImgEntity> list() {
		List<DxsSpecialsYouthImgEntity> listDxsSpecialsYouthImgs=dxsSpecialsYouthImgService.getList(DxsSpecialsYouthImgEntity.class);
		return listDxsSpecialsYouthImgs;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsSpecialsYouthImgEntity task = dxsSpecialsYouthImgService.get(DxsSpecialsYouthImgEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsSpecialsYouthImgEntity dxsSpecialsYouthImg, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsSpecialsYouthImgEntity>> failures = validator.validate(dxsSpecialsYouthImg);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsSpecialsYouthImgService.save(dxsSpecialsYouthImg);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsSpecialsYouthImg.getId();
		URI uri = uriBuilder.path("/rest/dxsSpecialsYouthImgController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsSpecialsYouthImgEntity dxsSpecialsYouthImg) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsSpecialsYouthImgEntity>> failures = validator.validate(dxsSpecialsYouthImg);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsSpecialsYouthImgService.saveOrUpdate(dxsSpecialsYouthImg);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsSpecialsYouthImgService.deleteEntityById(DxsSpecialsYouthImgEntity.class, id);
	}
}
