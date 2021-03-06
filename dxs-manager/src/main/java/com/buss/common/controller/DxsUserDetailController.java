package com.buss.common.controller;
import com.buss.authentication.entity.DxsAuthenticationEntity;
import com.buss.common.entity.DxsUserDetailEntity;
import com.buss.common.service.DxsUserDetailServiceI;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.buss.user.entity.DxsUserEntity;
import com.buss.user.service.DxsUserServiceI;
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
 * @Description: dxs_user_detail
 * @author onlineGenerator
 * @date 2016-06-17 14:29:33
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsUserDetailController")
public class DxsUserDetailController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsUserDetailController.class);

	@Autowired
	private DxsUserDetailServiceI dxsUserDetailService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private DxsUserServiceI dxsUserService;
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
	 * dxs_user_detail列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list( String userId, HttpServletRequest request) {
		ModelAndView model = new ModelAndView("com/buss/common/dxsUserDetailList");
		model.addObject("userId", userId);
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
	public void datagrid(DxsUserDetailEntity dxsUserDetail,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DxsUserDetailEntity.class, dataGrid);
		//查询条件组装器

		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsUserDetail, request.getParameterMap());
		try{
		//自定义追加查询条件
			cq.eq("userid",dxsUserDetail.getUserid());
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsUserDetailService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_user_detail
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsUserDetailEntity dxsUserDetail, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsUserDetail = systemService.getEntity(DxsUserDetailEntity.class, dxsUserDetail.getId());
		message = "删除成功";
		try{
			dxsUserDetailService.delete(dxsUserDetail);
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
	 * 批量删除dxs_user_detail
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
				DxsUserDetailEntity dxsUserDetail = systemService.getEntity(DxsUserDetailEntity.class, 
				id
				);
				dxsUserDetailService.delete(dxsUserDetail);
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
	 * 添加dxs_user_detail
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsUserEntity dxsUser,DxsUserDetailEntity dxsUserDetail, HttpServletRequest request) {
		String pwd2Str = org.jweb.core.util.PasswordUtil.encrypt("000000", org.jweb.core.util.PasswordUtil.str, org.jweb.core.util.PasswordUtil.getStaticSalt());
		dxsUser.setPwd(pwd2Str);
		dxsUser.setIsdelete(0);
		dxsUser.setMphone(dxsUserDetail.getPhone());
		dxsUser.setRealname(dxsUserDetail.getName());
		dxsUser.setEmail(dxsUserDetail.getEmail());
		dxsUser.setRolecode("teacher");
		dxsUser.setCheckstatus(7);
		AjaxJson j = new AjaxJson();
		message = "添加成功";
		try{
			systemService.save(dxsUser);
			dxsUserDetail.setIsDelete(0);
			dxsUserDetail.setUserid(dxsUser.getId());
			dxsUserDetailService.save(dxsUserDetail);
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
	 * 更新dxs_user_detail
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsUserEntity dxsUser,DxsUserDetailEntity dxsUserDetail, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "更新成功";
		DxsUserDetailEntity t = dxsUserDetailService.get(DxsUserDetailEntity.class, dxsUserDetail.getId());
		dxsUser.setId(t.getUserid());
		dxsUser.setMphone(dxsUserDetail.getPhone());
		dxsUser.setRealname(dxsUserDetail.getName());
		dxsUser.setEmail(dxsUserDetail.getEmail());
		DxsUserEntity r = dxsUserService.get(DxsUserEntity.class, dxsUser.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsUserDetail, t);
			dxsUserDetailService.saveOrUpdate(t);
			MyBeanUtils.copyBeanNotNull2Bean(dxsUser,r);
			dxsUserService.saveOrUpdate(r);
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
	 * dxs_user_detail新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DxsUserDetailEntity dxsUserDetail, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsUserDetail.getId())) {
			dxsUserDetail = dxsUserDetailService.getEntity(DxsUserDetailEntity.class, dxsUserDetail.getId());
			req.setAttribute("dxsUserDetailPage", dxsUserDetail);
		}
		return new ModelAndView("com/buss/common/dxsUserDetail-add");
	}
	/**
	 * dxs_user_detail编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsUserDetailEntity dxsUserDetail, HttpServletRequest req) {
		String t=dxsUserDetail.getId();
		dxsUserDetail.setId(null);
		dxsUserDetail.setUserid(t);
		if (StringUtil.isNotEmpty(dxsUserDetail.getUserid())) {
			List<DxsUserDetailEntity> dxsUserDetailList= dxsUserDetailService.findByProperty(DxsUserDetailEntity.class,"userid", dxsUserDetail.getUserid());
			dxsUserDetail=dxsUserDetailList.get(0);
			req.setAttribute("dxsUserDetailPage", dxsUserDetail);
		}
		if (StringUtil.isNotEmpty(dxsUserDetail.getDxsUserEntity())) {
			req.setAttribute("dxsUserPage", dxsUserDetail.getDxsUserEntity());
		}
		if (StringUtil.isNotEmpty(dxsUserDetail.getUserid())) {
			DxsAuthenticationEntity dxsAuthenticationEntity=new DxsAuthenticationEntity();
			dxsAuthenticationEntity.setIsDelete(0);
			dxsAuthenticationEntity.setUserId(dxsUserDetail.getUserid());
			List<DxsAuthenticationEntity> dxsAuthenticationEntityList= systemService.findByExample(DxsAuthenticationEntity.class.getName(),dxsAuthenticationEntity);

			if(dxsAuthenticationEntityList.size()!=0){
				dxsAuthenticationEntity=dxsAuthenticationEntityList.get(0);
				req.setAttribute("dxsAuthenticationPage", dxsAuthenticationEntity);
			}

		}

		return new ModelAndView("com/buss/common/dxsUserDetail-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsUserDetailController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsUserDetailEntity dxsUserDetail,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsUserDetailEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsUserDetail, request.getParameterMap());
		List<DxsUserDetailEntity> dxsUserDetails = this.dxsUserDetailService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_user_detail");
		modelMap.put(NormalExcelConstants.CLASS,DxsUserDetailEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_user_detail列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsUserDetails);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsUserDetailEntity dxsUserDetail,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_user_detail");
    	modelMap.put(NormalExcelConstants.CLASS,DxsUserDetailEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_user_detail列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsUserDetailEntity> listDxsUserDetailEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsUserDetailEntity.class,params);
				for (DxsUserDetailEntity dxsUserDetail : listDxsUserDetailEntitys) {
					dxsUserDetailService.save(dxsUserDetail);
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
	public List<DxsUserDetailEntity> list() {
		List<DxsUserDetailEntity> listDxsUserDetails=dxsUserDetailService.getList(DxsUserDetailEntity.class);
		return listDxsUserDetails;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsUserDetailEntity task = dxsUserDetailService.get(DxsUserDetailEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsUserDetailEntity dxsUserDetail, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsUserDetailEntity>> failures = validator.validate(dxsUserDetail);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsUserDetailService.save(dxsUserDetail);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsUserDetail.getId();
		URI uri = uriBuilder.path("/rest/dxsUserDetailController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsUserDetailEntity dxsUserDetail) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsUserDetailEntity>> failures = validator.validate(dxsUserDetail);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsUserDetailService.saveOrUpdate(dxsUserDetail);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsUserDetailService.deleteEntityById(DxsUserDetailEntity.class, id);
	}
}
