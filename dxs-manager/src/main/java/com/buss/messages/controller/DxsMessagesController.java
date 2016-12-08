package com.buss.messages.controller;
import com.buss.messages.entity.DxsMessagesEntity;
import com.buss.messages.service.DxsMessagesServiceI;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.buss.messageuser.entity.DxsMessageUserEntity;
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
 * @Description: dxs_messages
 * @author dq
 * @date 2016-09-20 10:18:25
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsMessagesController")
public class DxsMessagesController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsMessagesController.class);

	@Autowired
	private DxsMessagesServiceI dxsMessagesService;
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
	 * dxs_messages列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/messages/dxsMessagesList");
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
	public void datagrid(DxsMessagesEntity dxsMessages,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {

		dxsMessages.setIsDelete(0);

		CriteriaQuery cq = new CriteriaQuery(DxsMessagesEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsMessages, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsMessagesService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 分别向学生、老师、企业发送消息
	 * @param type
	 * @param dxsMessages
	 * @param request
     * @return
     */
	@RequestMapping(params = "send")
	@ResponseBody
	public AjaxJson sends(String type,DxsMessagesEntity dxsMessages, HttpServletRequest request) {

		AjaxJson j = new AjaxJson();
		message = "发送成功";

		List<DxsUserEntity> dxsUserList=new ArrayList();

        if("1".equals(type)){
			DxsUserEntity dxsUserEntity= new DxsUserEntity();
			dxsUserEntity.setIsdelete(0);
			dxsUserEntity.setRolecode("student");
			 dxsUserList=systemService.findByExample(DxsUserEntity.class.getName(),dxsUserEntity);

		}
		if("2".equals(type)){
			DxsUserEntity dxsUserEntity= new DxsUserEntity();
			dxsUserEntity.setIsdelete(0);
			dxsUserEntity.setRolecode("teacher");
			 dxsUserList=systemService.findByExample(DxsUserEntity.class.getName(),dxsUserEntity);

		}
		if("3".equals(type)){
			DxsUserEntity dxsUserEntity= new DxsUserEntity();
			dxsUserEntity.setIsdelete(0);
			dxsUserEntity.setRolecode("emp");
			 dxsUserList=systemService.findByExample(DxsUserEntity.class.getName(),dxsUserEntity);

		}

		DxsMessageUserEntity MessageUser=new DxsMessageUserEntity();
		MessageUser.setUserId(dxsUserList.get(0).getId());
		List<DxsMessageUserEntity> Message= systemService.findByExample(DxsMessageUserEntity.class.getName(),MessageUser);
		if(Message.size()!=0){
			for(DxsMessageUserEntity aa:Message){
				if(aa.getMId().equals(dxsMessages.getId())){
					message = "已发送";
					j.setMsg(message);
					return j;
				}
			}
		}



		try{
			for(DxsUserEntity dxsUser:dxsUserList){
				DxsMessageUserEntity dxsMessageUserEntity=new DxsMessageUserEntity();
				dxsMessageUserEntity.setIsDelete(0);
				dxsMessageUserEntity.setIsRead(0);
				dxsMessageUserEntity.setMId(dxsMessages.getId());
				dxsMessageUserEntity.setUserId(dxsUser.getId());
				systemService.save(dxsMessageUserEntity);
			}

		}catch(Exception e){
			e.printStackTrace();
			message = "发送失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 删除dxs_messages
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsMessagesEntity dxsMessages, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsMessages = systemService.getEntity(DxsMessagesEntity.class, dxsMessages.getId());
		message = "dxs_messages删除成功";
		try{
			dxsMessages.setIsDelete(1);
			dxsMessagesService.saveOrUpdate(dxsMessages);

			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_messages删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除dxs_messages
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "dxs_messages删除成功";
		try{
			for(String id:ids.split(",")){
				DxsMessagesEntity dxsMessages = systemService.getEntity(DxsMessagesEntity.class, 
				id
				);

				dxsMessages.setIsDelete(1);
				dxsMessagesService.saveOrUpdate(dxsMessages);

				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_messages删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加dxs_messages
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsMessagesEntity dxsMessages, HttpServletRequest request) {

		Date date  = new Date();
		dxsMessages.setUpdateTime(date);
		dxsMessages.setCreateTime(date);
		dxsMessages.setIsDelete(0);

		AjaxJson j = new AjaxJson();
		message = "dxs_messages添加成功";
		try{
			dxsMessagesService.save(dxsMessages);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_messages添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新dxs_messages
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsMessagesEntity dxsMessages, HttpServletRequest request) {

		Date date  = new Date();
		dxsMessages.setUpdateTime(date);

		AjaxJson j = new AjaxJson();
		message = "dxs_messages更新成功";
		DxsMessagesEntity t = dxsMessagesService.get(DxsMessagesEntity.class, dxsMessages.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsMessages, t);
			dxsMessagesService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "dxs_messages更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * dxs_messages新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DxsMessagesEntity dxsMessages, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsMessages.getId())) {
			dxsMessages = dxsMessagesService.getEntity(DxsMessagesEntity.class, dxsMessages.getId());
			req.setAttribute("dxsMessagesPage", dxsMessages);
		}
		return new ModelAndView("com/buss/messages/dxsMessages-add");
	}
	/**
	 * dxs_messages编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsMessagesEntity dxsMessages, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsMessages.getId())) {
			dxsMessages = dxsMessagesService.getEntity(DxsMessagesEntity.class, dxsMessages.getId());
			req.setAttribute("dxsMessagesPage", dxsMessages);
		}
		return new ModelAndView("com/buss/messages/dxsMessages-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsMessagesController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsMessagesEntity dxsMessages,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsMessagesEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsMessages, request.getParameterMap());
		List<DxsMessagesEntity> dxsMessagess = this.dxsMessagesService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_messages");
		modelMap.put(NormalExcelConstants.CLASS,DxsMessagesEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_messages列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsMessagess);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsMessagesEntity dxsMessages,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_messages");
    	modelMap.put(NormalExcelConstants.CLASS,DxsMessagesEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_messages列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsMessagesEntity> listDxsMessagesEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsMessagesEntity.class,params);
				for (DxsMessagesEntity dxsMessages : listDxsMessagesEntitys) {
					dxsMessagesService.save(dxsMessages);
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
	public List<DxsMessagesEntity> list() {
		List<DxsMessagesEntity> listDxsMessagess=dxsMessagesService.getList(DxsMessagesEntity.class);
		return listDxsMessagess;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsMessagesEntity task = dxsMessagesService.get(DxsMessagesEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsMessagesEntity dxsMessages, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsMessagesEntity>> failures = validator.validate(dxsMessages);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsMessagesService.save(dxsMessages);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsMessages.getId();
		URI uri = uriBuilder.path("/rest/dxsMessagesController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsMessagesEntity dxsMessages) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsMessagesEntity>> failures = validator.validate(dxsMessages);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsMessagesService.saveOrUpdate(dxsMessages);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsMessagesService.deleteEntityById(DxsMessagesEntity.class, id);
	}
}
