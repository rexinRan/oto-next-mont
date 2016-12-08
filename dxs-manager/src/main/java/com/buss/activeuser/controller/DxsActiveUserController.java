package com.buss.activeuser.controller;
import com.buss.actives.entity.DxsActivesEntity;
import com.buss.activeuser.entity.DxsActiveUserEntity;
import com.buss.activeuser.service.DxsActiveUserServiceI;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.buss.file.entity.DxsFileEntity;
import com.buss.file.service.DxsFileServiceI;
import com.buss.user.entity.DxsUserEntity;
import org.apache.log4j.Logger;
import org.hibernate.criterion.Restrictions;
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
import org.springframework.web.servlet.tags.Param;
import org.springframework.web.util.UriComponentsBuilder;

/**   
 * @Title: Controller
 * @Description: dxs_active_user
 * @author onlineGenerator
 * @date 2016-06-15 17:48:08
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsActiveUserController")
public class DxsActiveUserController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsActiveUserController.class);

	@Autowired
	private DxsActiveUserServiceI dxsActiveUserService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	@Autowired
	private DxsFileServiceI fileService;
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * dxs_active_user列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/activeuser/dxsActiveUserList");
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
	public void datagrid(DxsActiveUserEntity dxsActiveUser,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		int type = dxsActiveUser.getType();
		if(type==100) {
			dxsActiveUser.setType(null);
		}

		CriteriaQuery cq = new CriteriaQuery(DxsActiveUserEntity.class, dataGrid);
		//查询条件组装器

		dxsActiveUser.setIsDelete(0);
		cq.addOrder("createTime", SortDirection.desc);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsActiveUser, request.getParameterMap());
		try{
		//自定义追加查询条件
			if (type == 100) {
				cq.or(Restrictions.eq("type",3), Restrictions.eq("type", 4));

			}
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsActiveUserService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_active_user
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsActiveUserEntity dxsActiveUser, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsActiveUser = systemService.getEntity(DxsActiveUserEntity.class, dxsActiveUser.getId());
		message = "删除成功";
		try{
			dxsActiveUser.setIsDelete(1);
			dxsActiveUserService.saveOrUpdate(dxsActiveUser);
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
	 * 批量删除dxs_active_user
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
				DxsActiveUserEntity dxsActiveUser = systemService.getEntity(DxsActiveUserEntity.class, 
				id
				);
				dxsActiveUser.setIsDelete(1);
				dxsActiveUserService.saveOrUpdate(dxsActiveUser);
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
	 * 添加dxs_active_user
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsActiveUserEntity dxsActiveUser, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "添加成功";
		try{
			dxsActiveUserService.save(dxsActiveUser);
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
	 * 更新dxs_active_user
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate( DxsActiveUserEntity dxsActiveUser, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "更新成功";
		DxsActiveUserEntity t = dxsActiveUserService.get(DxsActiveUserEntity.class, dxsActiveUser.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsActiveUser, t);
			dxsActiveUserService.saveOrUpdate(t);
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
	 * dxs_active_user新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DxsActiveUserEntity dxsActiveUser, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsActiveUser.getId())) {
			dxsActiveUser = dxsActiveUserService.getEntity(DxsActiveUserEntity.class, dxsActiveUser.getId());
			req.setAttribute("dxsActiveUserPage", dxsActiveUser);
		}
		return new ModelAndView("com/buss/activeuser/dxsActiveUser-add");
	}
	/**
	 * dxs_active_user编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsActiveUserEntity dxsActiveUser, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsActiveUser.getId())) {
			dxsActiveUser = dxsActiveUserService.getEntity(DxsActiveUserEntity.class, dxsActiveUser.getId());
			req.setAttribute("dxsActiveUserPage", dxsActiveUser);
		}
		List<DxsActivesEntity>  dxsActivesList= systemService.findByProperty(DxsActivesEntity.class,"isDelete",0);
		req.setAttribute("dxsActivesList",dxsActivesList);

		List<DxsUserEntity>  dxsUserList= systemService.findByProperty(DxsUserEntity.class,"isdelete",0);
		req.setAttribute("dxsUserList",dxsUserList);
		return new ModelAndView("com/buss/activeuser/dxsActiveUser-update");
	}


	/**
	 * 查看活动报名凭证
	 */
	@RequestMapping(params = "seePic")
//	@ResponseBody()
	public void seePic(/*DxsFileEntity fileEntity*/ String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
		ModelAndView modelAndView = null;
		DxsFileEntity fileEntity = new DxsFileEntity();
		fileEntity.setOutId(id);
		fileEntity.setIsDetail(0);
		List list = this.fileService.findByExample(DxsFileEntity.class.getName(), fileEntity);
		if (list!=null && list.size()>0) {
			modelAndView = new ModelAndView(((DxsFileEntity)list.get(0)).getDownloadUrl());
		} else {
			System.out.println("这里没有图片怎么办呢");
		}
		response.setContentType("text/html");

		response.getOutputStream().print("<img src='"+((DxsFileEntity)list.get(0)).getDownloadUrl()+"'/>");

//		return modelAndView;
	}


	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsActiveUserController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsActiveUserEntity dxsActiveUser,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsActiveUserEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsActiveUser, request.getParameterMap());
		List<DxsActiveUserEntity> dxsActiveUsers = this.dxsActiveUserService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_active_user");
		modelMap.put(NormalExcelConstants.CLASS,DxsActiveUserEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_active_user列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsActiveUsers);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsActiveUserEntity dxsActiveUser,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_active_user");
    	modelMap.put(NormalExcelConstants.CLASS,DxsActiveUserEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_active_user列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsActiveUserEntity> listDxsActiveUserEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsActiveUserEntity.class,params);
				for (DxsActiveUserEntity dxsActiveUser : listDxsActiveUserEntitys) {
					dxsActiveUserService.save(dxsActiveUser);
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
	public List<DxsActiveUserEntity> list() {
		List<DxsActiveUserEntity> listDxsActiveUsers=dxsActiveUserService.getList(DxsActiveUserEntity.class);
		return listDxsActiveUsers;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsActiveUserEntity task = dxsActiveUserService.get(DxsActiveUserEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsActiveUserEntity dxsActiveUser, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsActiveUserEntity>> failures = validator.validate(dxsActiveUser);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsActiveUserService.save(dxsActiveUser);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsActiveUser.getId();
		URI uri = uriBuilder.path("/rest/dxsActiveUserController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsActiveUserEntity dxsActiveUser) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsActiveUserEntity>> failures = validator.validate(dxsActiveUser);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsActiveUserService.saveOrUpdate(dxsActiveUser);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsActiveUserService.deleteEntityById(DxsActiveUserEntity.class, id);
	}
}
