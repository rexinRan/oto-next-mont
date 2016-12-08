package com.buss.directionalemploymentgroups.controller;
import com.buss.directionalemploymentgroups.entity.DxsDirectionalEmploymentGroupsEntity;
import com.buss.directionalemploymentgroups.service.DxsDirectionalEmploymentGroupsServiceI;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.buss.user.entity.DxsUserEntity;
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
 * @Description: dxs_directional_employment_groups
 * @author onlineGenerator
 * @date 2016-08-05 15:43:57
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsDirectionalEmploymentGroupsController")
public class DxsDirectionalEmploymentGroupsController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsDirectionalEmploymentGroupsController.class);

	@Autowired
	private DxsDirectionalEmploymentGroupsServiceI dxsDirectionalEmploymentGroupsService;
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
	 * dxs_directional_employment_groups列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/directionalemploymentgroups/dxsDirectionalEmploymentGroupsList");
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
	public void datagrid(DxsDirectionalEmploymentGroupsEntity dxsDirectionalEmploymentGroups,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DxsDirectionalEmploymentGroupsEntity.class, dataGrid);
		//查询条件组装器
		dxsDirectionalEmploymentGroups.setIsDelete(0);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsDirectionalEmploymentGroups, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsDirectionalEmploymentGroupsService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_directional_employment_groups
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsDirectionalEmploymentGroupsEntity dxsDirectionalEmploymentGroups, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsDirectionalEmploymentGroups = systemService.getEntity(DxsDirectionalEmploymentGroupsEntity.class, dxsDirectionalEmploymentGroups.getId());
		message = "dxs_directional_employment_groups删除成功";
		try{
			dxsDirectionalEmploymentGroups.setIsDelete(1);
			dxsDirectionalEmploymentGroupsService.saveOrUpdate(dxsDirectionalEmploymentGroups);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_directional_employment_groups删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除dxs_directional_employment_groups
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "dxs_directional_employment_groups删除成功";
		try{
			for(String id:ids.split(",")){
				DxsDirectionalEmploymentGroupsEntity dxsDirectionalEmploymentGroups = systemService.getEntity(DxsDirectionalEmploymentGroupsEntity.class, 
				id
				);
				dxsDirectionalEmploymentGroups.setIsDelete(1);
				dxsDirectionalEmploymentGroupsService.saveOrUpdate(dxsDirectionalEmploymentGroups);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_directional_employment_groups删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加dxs_directional_employment_groups
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsDirectionalEmploymentGroupsEntity dxsDirectionalEmploymentGroups, HttpServletRequest request) {
		dxsDirectionalEmploymentGroups.setIsDelete(0);
		AjaxJson j = new AjaxJson();
		message = "dxs_directional_employment_groups添加成功";
		try{
			dxsDirectionalEmploymentGroupsService.save(dxsDirectionalEmploymentGroups);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_directional_employment_groups添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新dxs_directional_employment_groups
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsDirectionalEmploymentGroupsEntity dxsDirectionalEmploymentGroups, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "dxs_directional_employment_groups更新成功";
		DxsDirectionalEmploymentGroupsEntity t = dxsDirectionalEmploymentGroupsService.get(DxsDirectionalEmploymentGroupsEntity.class, dxsDirectionalEmploymentGroups.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsDirectionalEmploymentGroups, t);
			dxsDirectionalEmploymentGroupsService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "dxs_directional_employment_groups更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * dxs_directional_employment_groups新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DxsDirectionalEmploymentGroupsEntity dxsDirectionalEmploymentGroups, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsDirectionalEmploymentGroups.getId())) {
			dxsDirectionalEmploymentGroups = dxsDirectionalEmploymentGroupsService.getEntity(DxsDirectionalEmploymentGroupsEntity.class, dxsDirectionalEmploymentGroups.getId());
			req.setAttribute("dxsDirectionalEmploymentGroupsPage", dxsDirectionalEmploymentGroups);
		}
		DxsUserEntity dxsUser=new DxsUserEntity();
		dxsUser.setRolecode("emp");
		dxsUser.setIsdelete(0);
		dxsUser.setCheckstatus(10);
		List<DxsUserEntity> DxsUserList=  systemService.findByExample(DxsUserEntity.class.getName(),dxsUser);
		req.setAttribute("DxsUserList",DxsUserList);
		return new ModelAndView("com/buss/directionalemploymentgroups/dxsDirectionalEmploymentGroups-add");
	}
	/**
	 * dxs_directional_employment_groups编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsDirectionalEmploymentGroupsEntity dxsDirectionalEmploymentGroups, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsDirectionalEmploymentGroups.getId())) {
			dxsDirectionalEmploymentGroups = dxsDirectionalEmploymentGroupsService.getEntity(DxsDirectionalEmploymentGroupsEntity.class, dxsDirectionalEmploymentGroups.getId());
			req.setAttribute("dxsDirectionalEmploymentGroupsPage", dxsDirectionalEmploymentGroups);
		}
		DxsUserEntity dxsUser=new DxsUserEntity();
		dxsUser.setRolecode("emp");
		dxsUser.setIsdelete(0);
		dxsUser.setCheckstatus(10);
		List<DxsUserEntity> DxsUserList=  systemService.findByExample(DxsUserEntity.class.getName(),dxsUser);
		req.setAttribute("DxsUserList",DxsUserList);
		return new ModelAndView("com/buss/directionalemploymentgroups/dxsDirectionalEmploymentGroups-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsDirectionalEmploymentGroupsController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsDirectionalEmploymentGroupsEntity dxsDirectionalEmploymentGroups,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsDirectionalEmploymentGroupsEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsDirectionalEmploymentGroups, request.getParameterMap());
		List<DxsDirectionalEmploymentGroupsEntity> dxsDirectionalEmploymentGroupss = this.dxsDirectionalEmploymentGroupsService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_directional_employment_groups");
		modelMap.put(NormalExcelConstants.CLASS,DxsDirectionalEmploymentGroupsEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_directional_employment_groups列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsDirectionalEmploymentGroupss);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsDirectionalEmploymentGroupsEntity dxsDirectionalEmploymentGroups,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_directional_employment_groups");
    	modelMap.put(NormalExcelConstants.CLASS,DxsDirectionalEmploymentGroupsEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_directional_employment_groups列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsDirectionalEmploymentGroupsEntity> listDxsDirectionalEmploymentGroupsEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsDirectionalEmploymentGroupsEntity.class,params);
				for (DxsDirectionalEmploymentGroupsEntity dxsDirectionalEmploymentGroups : listDxsDirectionalEmploymentGroupsEntitys) {
					dxsDirectionalEmploymentGroupsService.save(dxsDirectionalEmploymentGroups);
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
	public List<DxsDirectionalEmploymentGroupsEntity> list() {
		List<DxsDirectionalEmploymentGroupsEntity> listDxsDirectionalEmploymentGroupss=dxsDirectionalEmploymentGroupsService.getList(DxsDirectionalEmploymentGroupsEntity.class);
		return listDxsDirectionalEmploymentGroupss;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsDirectionalEmploymentGroupsEntity task = dxsDirectionalEmploymentGroupsService.get(DxsDirectionalEmploymentGroupsEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsDirectionalEmploymentGroupsEntity dxsDirectionalEmploymentGroups, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsDirectionalEmploymentGroupsEntity>> failures = validator.validate(dxsDirectionalEmploymentGroups);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsDirectionalEmploymentGroupsService.save(dxsDirectionalEmploymentGroups);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsDirectionalEmploymentGroups.getId();
		URI uri = uriBuilder.path("/rest/dxsDirectionalEmploymentGroupsController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsDirectionalEmploymentGroupsEntity dxsDirectionalEmploymentGroups) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsDirectionalEmploymentGroupsEntity>> failures = validator.validate(dxsDirectionalEmploymentGroups);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsDirectionalEmploymentGroupsService.saveOrUpdate(dxsDirectionalEmploymentGroups);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsDirectionalEmploymentGroupsService.deleteEntityById(DxsDirectionalEmploymentGroupsEntity.class, id);
	}
}
