package com.buss.employed.controller;

import com.buss.employed.entity.DxsEmployedEntity;
import com.buss.employed.service.DxsEmployedServiceI;
import com.buss.employedcatalog.entity.DxsEmployedCatalogEntity;
import com.buss.user.entity.DxsUserEntity;
import org.apache.log4j.Logger;
import org.jeecgframework.core.beanvalidator.BeanValidators;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.core.common.exception.BusinessException;
import org.jeecgframework.core.common.hibernate.qbc.CriteriaQuery;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.core.common.model.json.DataGrid;
import org.jeecgframework.core.constant.Globals;
import org.jeecgframework.core.util.ExceptionUtil;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.tag.vo.datatable.SortDirection;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.net.URI;
import java.util.*;

/**   
 * @Title: Controller
 * @Description: dxs_employed
 * @author onlineGenerator
 * @date 2016-06-02 09:53:56
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/EmployedController")
public class EmployedController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(EmployedController.class);

	@Autowired
	private DxsEmployedServiceI dxsEmployedService;
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
	 * dxs_employed列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(String osId,HttpServletRequest request) {
		ModelAndView mod=new ModelAndView("com/buss/employed/osdxsEmployedList");
		mod.addObject("osId",osId);
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
	public void datagrid(DxsEmployedEntity dxsEmployed,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {

		// wty
		// 添加数据有效性访问
		dxsEmployed.setIsDelete(0);

		CriteriaQuery cq = new CriteriaQuery(DxsEmployedEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsEmployed, request.getParameterMap());
		try{
		//自定义追加查询条件
			cq.eq("osId",dxsEmployed.getOsId());
			cq.addOrder("createTime", SortDirection.desc);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsEmployedService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_employed
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsEmployedEntity dxsEmployed, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsEmployed = systemService.getEntity(DxsEmployedEntity.class, dxsEmployed.getId());
		message = "删除成功";
		try{
			// wty
			// 改为 逻辑删除
			dxsEmployed.setIsDelete(1);
			dxsEmployedService.updateEntitie(dxsEmployed);
//			dxsEmployedService.delete(dxsEmployed);
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
	 * 批量删除dxs_employed
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
				DxsEmployedEntity dxsEmployed = systemService.getEntity(DxsEmployedEntity.class, 
				id
				);
				// wty
				// 改为逻辑删除
				dxsEmployed.setIsDelete(1);
				dxsEmployedService.updateEntitie(dxsEmployed);
//				dxsEmployedService.delete(dxsEmployed);

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
	 * 添加dxs_employed
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsEmployedEntity dxsEmployed, HttpServletRequest request) {
		// wty
		// 添加 默认字段的默认值
		dxsEmployed.setIsDelete(0);
		Date date = new Date();
		dxsEmployed.setCreateTime(date);
		dxsEmployed.setUpdateTime(date);
		dxsEmployed.setPublishTime(date);

		AjaxJson j = new AjaxJson();
		message = "添加成功";
		try{
			dxsEmployedService.save(dxsEmployed);
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
	 * 更新dxs_employed
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsEmployedEntity dxsEmployed, HttpServletRequest request) {
		// wty
		// 添加 修改时间
		dxsEmployed.setUpdateTime(new Date());

		AjaxJson j = new AjaxJson();
		message = "更新成功";
		DxsEmployedEntity t = dxsEmployedService.get(DxsEmployedEntity.class, dxsEmployed.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsEmployed, t);
			dxsEmployedService.saveOrUpdate(t);
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
	 * dxs_employed新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(String osId,DxsEmployedEntity dxsEmployed, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsEmployed.getId())) {
			dxsEmployed = dxsEmployedService.getEntity(DxsEmployedEntity.class, dxsEmployed.getId());
			req.setAttribute("dxsEmployedPage", dxsEmployed);
		}
		ModelAndView modelAndView=new ModelAndView("com/buss/employed/osdxsEmployed-add");
		modelAndView.addObject("osId",osId);
//    	List<DxsEmployedCatalogEntity> DxsEmployedCatalogList= systemService.findByProperty(DxsEmployedCatalogEntity.class,"isDelete",0);
//		req.setAttribute("DxsEmployedCatalogList",DxsEmployedCatalogList);
//		List<DxsUserEntity> DxsUserList=  systemService.findByProperty(DxsUserEntity.class,"rolecode","emp");
		DxsUserEntity dxsUser=new DxsUserEntity();
		dxsUser.setRolecode("emp");
		dxsUser.setIsdelete(0);
		dxsUser.setCheckstatus(10);
		List<DxsUserEntity> DxsUserList=  systemService.findByExample(DxsUserEntity.class.getName(),dxsUser);
		req.setAttribute("DxsUserList",DxsUserList);
		return modelAndView;
	}
	/**
	 * dxs_employed编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsEmployedEntity dxsEmployed, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsEmployed.getId())) {
			dxsEmployed = dxsEmployedService.getEntity(DxsEmployedEntity.class, dxsEmployed.getId());
			req.setAttribute("dxsEmployedPage", dxsEmployed);
		}
//		List<DxsEmployedCatalogEntity> DxsEmployedCatalogList=  systemService.findByProperty(DxsEmployedCatalogEntity.class,"isDelete",0);
//		req.setAttribute("DxsEmployedCatalogList",DxsEmployedCatalogList);
//		List<DxsUserEntity> DxsUserList=  systemService.findByProperty(DxsUserEntity.class,"rolecode","emp");
		DxsUserEntity dxsUser=new DxsUserEntity();
		dxsUser.setRolecode("emp");
		dxsUser.setIsdelete(0);
		dxsUser.setCheckstatus(10);
		List<DxsUserEntity> DxsUserList=  systemService.findByExample(DxsUserEntity.class.getName(),dxsUser);
		req.setAttribute("DxsUserList",DxsUserList);
		return new ModelAndView("com/buss/employed/osdxsEmployed-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsEmployedController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsEmployedEntity dxsEmployed,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsEmployedEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsEmployed, request.getParameterMap());
		List<DxsEmployedEntity> dxsEmployeds = this.dxsEmployedService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_employed");
		modelMap.put(NormalExcelConstants.CLASS,DxsEmployedEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_employed列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsEmployeds);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsEmployedEntity dxsEmployed,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_employed");
    	modelMap.put(NormalExcelConstants.CLASS,DxsEmployedEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_employed列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsEmployedEntity> listDxsEmployedEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsEmployedEntity.class,params);
				for (DxsEmployedEntity dxsEmployed : listDxsEmployedEntitys) {
					dxsEmployedService.save(dxsEmployed);
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
	public List<DxsEmployedEntity> list() {
		List<DxsEmployedEntity> listDxsEmployeds=dxsEmployedService.getList(DxsEmployedEntity.class);
		return listDxsEmployeds;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsEmployedEntity task = dxsEmployedService.get(DxsEmployedEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsEmployedEntity dxsEmployed, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsEmployedEntity>> failures = validator.validate(dxsEmployed);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsEmployedService.save(dxsEmployed);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsEmployed.getId();
		URI uri = uriBuilder.path("/rest/dxsEmployedController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsEmployedEntity dxsEmployed) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsEmployedEntity>> failures = validator.validate(dxsEmployed);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsEmployedService.saveOrUpdate(dxsEmployed);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsEmployedService.deleteEntityById(DxsEmployedEntity.class, id);
	}
}
