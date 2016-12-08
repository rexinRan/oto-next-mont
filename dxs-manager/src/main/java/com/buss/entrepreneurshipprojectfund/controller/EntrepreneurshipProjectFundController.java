package com.buss.entrepreneurshipprojectfund.controller;

import com.buss.employedarticle.entity.DxsEmployedArticleEntity;
import com.buss.entrepreneurshipprojectfund.entity.EntrepreneurshipProjectFundEntity;
import com.buss.entrepreneurshipprojectfund.service.EntrepreneurshipProjectFundServiceI;
import com.buss.projectarea.entity.ProjectAreaEntity;
import com.buss.projecttype.entity.ProjectTypeEntity;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**   
 * @Title: Controller
 * @Description: entrepreneurship_project_fund
 * @author onlineGenerator
 * @date 2016-06-28 19:18:33
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/entrepreneurshipProjectFundController")
public class EntrepreneurshipProjectFundController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(EntrepreneurshipProjectFundController.class);

	@Autowired
	private EntrepreneurshipProjectFundServiceI entrepreneurshipProjectFundService;
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
	 * entrepreneurship_project_fund列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/entrepreneurshipprojectfund/entrepreneurshipProjectFundList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 * @param request
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(EntrepreneurshipProjectFundEntity entrepreneurshipProjectFund,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		entrepreneurshipProjectFund.setIsDelete(0);
		CriteriaQuery cq = new CriteriaQuery(EntrepreneurshipProjectFundEntity.class, dataGrid);
		//查询条件组装器
		cq.addOrder("updateTime", SortDirection.desc);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, entrepreneurshipProjectFund, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.entrepreneurshipProjectFundService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除entrepreneurship_project_fund
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(EntrepreneurshipProjectFundEntity entrepreneurshipProjectFund, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		entrepreneurshipProjectFund = systemService.getEntity(EntrepreneurshipProjectFundEntity.class, entrepreneurshipProjectFund.getId());
		message = "删除成功";
		try{
			// 逻辑删除
			entrepreneurshipProjectFund.setIsDelete(1);
			this.systemService.saveOrUpdate(entrepreneurshipProjectFund);
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
	 * 批量删除entrepreneurship_project_fund
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
				EntrepreneurshipProjectFundEntity entrepreneurshipProjectFund = systemService.getEntity(EntrepreneurshipProjectFundEntity.class, 
				id
				);
				// 逻辑删除
				entrepreneurshipProjectFund.setIsDelete(1);
				entrepreneurshipProjectFundService.saveOrUpdate(entrepreneurshipProjectFund);
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
	 * 添加entrepreneurship_project_fund
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(EntrepreneurshipProjectFundEntity entrepreneurshipProjectFund, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "添加成功";
		try{
			entrepreneurshipProjectFundService.save(entrepreneurshipProjectFund);
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
	 * 更新entrepreneurship_project_fund
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(EntrepreneurshipProjectFundEntity entrepreneurshipProjectFund, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "更新成功";
		EntrepreneurshipProjectFundEntity t = entrepreneurshipProjectFundService.get(EntrepreneurshipProjectFundEntity.class, entrepreneurshipProjectFund.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(entrepreneurshipProjectFund, t);
			entrepreneurshipProjectFundService.saveOrUpdate(t);
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
	 * entrepreneurship_project_fund新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(EntrepreneurshipProjectFundEntity entrepreneurshipProjectFund, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(entrepreneurshipProjectFund.getId())) {
			entrepreneurshipProjectFund = entrepreneurshipProjectFundService.getEntity(EntrepreneurshipProjectFundEntity.class, entrepreneurshipProjectFund.getId());
			req.setAttribute("entrepreneurshipProjectFundPage", entrepreneurshipProjectFund);
		}
		return new ModelAndView("com/buss/entrepreneurshipprojectfund/entrepreneurshipProjectFund-add");
	}
	/**
	 * entrepreneurship_project_fund编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(EntrepreneurshipProjectFundEntity entrepreneurshipProjectFund, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(entrepreneurshipProjectFund.getId())) {
			entrepreneurshipProjectFund = entrepreneurshipProjectFundService.getEntity(EntrepreneurshipProjectFundEntity.class, entrepreneurshipProjectFund.getId());

			/**
			 * 杨治国
			 */
			/*查出所有的用户*/
			List<DxsUserEntity> userEntityList =  systemService.findByQueryString("from DxsUserEntity");
			/*查询所有的就业中心文章*/
			List<DxsEmployedArticleEntity> employedArticleEntityList = systemService.findByQueryString("from DxsEmployedArticleEntity");
			/*将所有的用户设置到request域中*/
			req.setAttribute("userEntityList",userEntityList);
			/*查询项目的所有领域*/
			List<ProjectAreaEntity> projectAreaEntityList = systemService.findByQueryString("from ProjectAreaEntity");
			/*查询项目的所有类型*/
			List<ProjectTypeEntity> projectTypeEntityList = systemService.findByQueryString("from ProjectTypeEntity");

			/*将所有的项目所属类型设置到request中*/
			req.setAttribute("projectTypeEntityList",projectTypeEntityList);
			/*将所有的项目所属领域设置到request中*/
			req.setAttribute("projectAreaEntityList",projectAreaEntityList);
			/*将所有的就业中心文章设置到域中*/
			req.setAttribute("employedArticleEntityList",employedArticleEntityList);
			req.setAttribute("entrepreneurshipProjectFundPage", entrepreneurshipProjectFund);
		}
		return new ModelAndView("com/buss/entrepreneurshipprojectfund/entrepreneurshipProjectFund-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","entrepreneurshipProjectFundController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(EntrepreneurshipProjectFundEntity entrepreneurshipProjectFund,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(EntrepreneurshipProjectFundEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, entrepreneurshipProjectFund, request.getParameterMap());
		List<EntrepreneurshipProjectFundEntity> entrepreneurshipProjectFunds = this.entrepreneurshipProjectFundService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"entrepreneurship_project_fund");
		modelMap.put(NormalExcelConstants.CLASS,EntrepreneurshipProjectFundEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("entrepreneurship_project_fund列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,entrepreneurshipProjectFunds);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(EntrepreneurshipProjectFundEntity entrepreneurshipProjectFund,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"entrepreneurship_project_fund");
    	modelMap.put(NormalExcelConstants.CLASS,EntrepreneurshipProjectFundEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("entrepreneurship_project_fund列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<EntrepreneurshipProjectFundEntity> listEntrepreneurshipProjectFundEntitys = ExcelImportUtil.importExcel(file.getInputStream(),EntrepreneurshipProjectFundEntity.class,params);
				for (EntrepreneurshipProjectFundEntity entrepreneurshipProjectFund : listEntrepreneurshipProjectFundEntitys) {
					entrepreneurshipProjectFundService.save(entrepreneurshipProjectFund);
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
	public List<EntrepreneurshipProjectFundEntity> list() {
		List<EntrepreneurshipProjectFundEntity> listEntrepreneurshipProjectFunds=entrepreneurshipProjectFundService.getList(EntrepreneurshipProjectFundEntity.class);
		return listEntrepreneurshipProjectFunds;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		EntrepreneurshipProjectFundEntity task = entrepreneurshipProjectFundService.get(EntrepreneurshipProjectFundEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody EntrepreneurshipProjectFundEntity entrepreneurshipProjectFund, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<EntrepreneurshipProjectFundEntity>> failures = validator.validate(entrepreneurshipProjectFund);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		entrepreneurshipProjectFundService.save(entrepreneurshipProjectFund);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = entrepreneurshipProjectFund.getId();
		URI uri = uriBuilder.path("/rest/entrepreneurshipProjectFundController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody EntrepreneurshipProjectFundEntity entrepreneurshipProjectFund) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<EntrepreneurshipProjectFundEntity>> failures = validator.validate(entrepreneurshipProjectFund);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		entrepreneurshipProjectFundService.saveOrUpdate(entrepreneurshipProjectFund);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		entrepreneurshipProjectFundService.deleteEntityById(EntrepreneurshipProjectFundEntity.class, id);
	}

	/**
	 * 审核通过
	 * @param entrepreneurshipProjectFund
	 * @param request
     * @return
     */
	@RequestMapping(params = "empower")
	@ResponseBody
	public AjaxJson empower(EntrepreneurshipProjectFundEntity entrepreneurshipProjectFund, HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		entrepreneurshipProjectFund = systemService.getEntity(EntrepreneurshipProjectFundEntity.class,entrepreneurshipProjectFund.getId());
		message = "entrepreneurship_project_fund审核成功";
		try {
			entrepreneurshipProjectFund.setCheckCode(10);
			this.systemService.saveOrUpdate(entrepreneurshipProjectFund);
		}catch (Exception e){
			message = "entrepreneurship_project_fund审核失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 审核拒绝
	 * @param entrepreneurshipProjectFund
	 * @param request
     * @return
     */
	@RequestMapping(params = "reject")
	@ResponseBody
	public AjaxJson reject(EntrepreneurshipProjectFundEntity entrepreneurshipProjectFund, HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		entrepreneurshipProjectFund = systemService.getEntity(EntrepreneurshipProjectFundEntity.class,entrepreneurshipProjectFund.getId());
		message = "entrepreneurship_project_fund拒绝成功";
		try {
			entrepreneurshipProjectFund.setCheckCode(15);
			this.systemService.saveOrUpdate(entrepreneurshipProjectFund);
		}catch (Exception e){
			message = "entrepreneurship_project_fund拒绝失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
}
