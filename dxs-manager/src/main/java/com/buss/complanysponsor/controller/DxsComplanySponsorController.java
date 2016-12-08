package com.buss.complanysponsor.controller;

import com.buss.complanysponsor.entity.DxsComplanySponsorEntity;
import com.buss.complanysponsor.service.DxsComplanySponsorServiceI;
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
 * @Description: dxs_complany_sponsor
 * @author dq
 * @date 2016-07-13 08:54:35
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsComplanySponsorController")
public class DxsComplanySponsorController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsComplanySponsorController.class);

	@Autowired
	private DxsComplanySponsorServiceI dxsComplanySponsorService;
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
	 * dxs_complany_sponsor列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/complanysponsor/dxsComplanySponsorList");
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
	public void datagrid(DxsComplanySponsorEntity dxsComplanySponsor,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		//大权
		//增加有效标志
		dxsComplanySponsor.setIsDelete(0);
		CriteriaQuery cq = new CriteriaQuery(DxsComplanySponsorEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsComplanySponsor, request.getParameterMap());
		try{
		//自定义追加查询条件
			cq.addOrder("createTime", SortDirection.desc);
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsComplanySponsorService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_complany_sponsor
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsComplanySponsorEntity dxsComplanySponsor, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsComplanySponsor = systemService.getEntity(DxsComplanySponsorEntity.class, dxsComplanySponsor.getId());
		message = "删除成功";
		try{
				//大权
				//更改为无效标志
				dxsComplanySponsor.setIsDelete(1);
				dxsComplanySponsorService.updateEntitie(dxsComplanySponsor);
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
	 * 批量删除dxs_complany_sponsor
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
				DxsComplanySponsorEntity dxsComplanySponsor = systemService.getEntity(DxsComplanySponsorEntity.class, 
				id
				);
				//大权
				//更改为无效标志
				dxsComplanySponsor.setIsDelete(1);
				dxsComplanySponsorService.updateEntitie(dxsComplanySponsor);
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
	 * 添加dxs_complany_sponsor
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsComplanySponsorEntity dxsComplanySponsor, HttpServletRequest request) {
		//大权
		//添加默认字段值
		Date date =new Date();
		dxsComplanySponsor.setCreateTime(date);
		dxsComplanySponsor.setUpdateTime(date);
		dxsComplanySponsor.setIsDelete(0);
		AjaxJson j = new AjaxJson();
		message = "添加成功";
		try{
			dxsComplanySponsorService.save(dxsComplanySponsor);
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
	 * 更新dxs_complany_sponsor
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsComplanySponsorEntity dxsComplanySponsor, HttpServletRequest request) {
		//大权
		//更新修改时间
		Date date =new Date();
		dxsComplanySponsor.setUpdateTime(date);
		AjaxJson j = new AjaxJson();
		message = "更新成功";
		DxsComplanySponsorEntity t = dxsComplanySponsorService.get(DxsComplanySponsorEntity.class, dxsComplanySponsor.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsComplanySponsor, t);
			dxsComplanySponsorService.saveOrUpdate(t);
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
	 * dxs_complany_sponsor新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DxsComplanySponsorEntity dxsComplanySponsor, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsComplanySponsor.getId())) {
			dxsComplanySponsor = dxsComplanySponsorService.getEntity(DxsComplanySponsorEntity.class, dxsComplanySponsor.getId());
			req.setAttribute("dxsComplanySponsorPage", dxsComplanySponsor);
		}
		DxsUserEntity dxsUser=new DxsUserEntity();
		dxsUser.setRolecode("emp");
		dxsUser.setIsdelete(0);
		dxsUser.setCheckstatus(10);
		List<DxsUserEntity> DxsUserList=  systemService.findByExample(DxsUserEntity.class.getName(),dxsUser);
		req.setAttribute("DxsUserList",DxsUserList);
		return new ModelAndView("com/buss/complanysponsor/dxsComplanySponsor-add");
	}
	/**
	 * dxs_complany_sponsor编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsComplanySponsorEntity dxsComplanySponsor, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsComplanySponsor.getId())) {
			dxsComplanySponsor = dxsComplanySponsorService.getEntity(DxsComplanySponsorEntity.class, dxsComplanySponsor.getId());
			req.setAttribute("dxsComplanySponsorPage", dxsComplanySponsor);
		}
		DxsUserEntity dxsUser=new DxsUserEntity();
		dxsUser.setRolecode("emp");
		dxsUser.setIsdelete(0);
		dxsUser.setCheckstatus(10);
		List<DxsUserEntity> DxsUserList=  systemService.findByExample(DxsUserEntity.class.getName(),dxsUser);
		req.setAttribute("DxsUserList",DxsUserList);
		return new ModelAndView("com/buss/complanysponsor/dxsComplanySponsor-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsComplanySponsorController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsComplanySponsorEntity dxsComplanySponsor,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsComplanySponsorEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsComplanySponsor, request.getParameterMap());
		List<DxsComplanySponsorEntity> dxsComplanySponsors = this.dxsComplanySponsorService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_complany_sponsor");
		modelMap.put(NormalExcelConstants.CLASS,DxsComplanySponsorEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_complany_sponsor列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsComplanySponsors);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsComplanySponsorEntity dxsComplanySponsor,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_complany_sponsor");
    	modelMap.put(NormalExcelConstants.CLASS,DxsComplanySponsorEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_complany_sponsor列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsComplanySponsorEntity> listDxsComplanySponsorEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsComplanySponsorEntity.class,params);
				for (DxsComplanySponsorEntity dxsComplanySponsor : listDxsComplanySponsorEntitys) {
					dxsComplanySponsorService.save(dxsComplanySponsor);
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
	public List<DxsComplanySponsorEntity> list() {
		List<DxsComplanySponsorEntity> listDxsComplanySponsors=dxsComplanySponsorService.getList(DxsComplanySponsorEntity.class);
		return listDxsComplanySponsors;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsComplanySponsorEntity task = dxsComplanySponsorService.get(DxsComplanySponsorEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsComplanySponsorEntity dxsComplanySponsor, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsComplanySponsorEntity>> failures = validator.validate(dxsComplanySponsor);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsComplanySponsorService.save(dxsComplanySponsor);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsComplanySponsor.getId();
		URI uri = uriBuilder.path("/rest/dxsComplanySponsorController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsComplanySponsorEntity dxsComplanySponsor) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsComplanySponsorEntity>> failures = validator.validate(dxsComplanySponsor);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsComplanySponsorService.saveOrUpdate(dxsComplanySponsor);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsComplanySponsorService.deleteEntityById(DxsComplanySponsorEntity.class, id);
	}
}
