package com.buss.entrepreneurshipprojectarticle.controller;

import com.buss.common.controller.FileDownLoadController;
import com.buss.employedarticle.entity.DxsEmployedArticleEntity;
import com.buss.entrepreneurshipprojectarticle.entity.EntrepreneurshipProjectArticleEntity;
import com.buss.entrepreneurshipprojectarticle.service.EntrepreneurshipProjectArticleServiceI;
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
 * @Description: entrepreneurship_project_article
 * @author onlineGenerator
 * @date 2016-06-28 19:18:33
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/entrepreneurshipProjectArticleController")
public class EntrepreneurshipProjectArticleController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(EntrepreneurshipProjectArticleController.class);

	@Autowired
	private EntrepreneurshipProjectArticleServiceI entrepreneurshipProjectArticleService;
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
	 * entrepreneurship_project_article列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/entrepreneurshipprojectarticle/entrepreneurshipProjectArticleList");
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
	public void datagrid(EntrepreneurshipProjectArticleEntity entrepreneurshipProjectArticle, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {

		entrepreneurshipProjectArticle.setIsDelete(0);
		CriteriaQuery cq = new CriteriaQuery(EntrepreneurshipProjectArticleEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, entrepreneurshipProjectArticle, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.entrepreneurshipProjectArticleService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除entrepreneurship_project_article
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(EntrepreneurshipProjectArticleEntity entrepreneurshipProjectArticle, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		entrepreneurshipProjectArticle = systemService.getEntity(EntrepreneurshipProjectArticleEntity.class, entrepreneurshipProjectArticle.getId());
		message = "entrepreneurship_project_article删除成功";
		try{
//			entrepreneurshipProjectArticleService.delete(entrepreneurshipProjectArticle);
			entrepreneurshipProjectArticle.setIsDelete(1);
			this.systemService.saveOrUpdate(entrepreneurshipProjectArticle);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "entrepreneurship_project_article删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除entrepreneurship_project_article
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "entrepreneurship_project_article删除成功";
		try{
			for(String id:ids.split(",")){
				EntrepreneurshipProjectArticleEntity entrepreneurshipProjectArticle = systemService.getEntity(EntrepreneurshipProjectArticleEntity.class,
				id
				);
				entrepreneurshipProjectArticle.setIsDelete(1);
				systemService.updateEntitie(entrepreneurshipProjectArticle);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "entrepreneurship_project_article删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加entrepreneurship_project_article
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(EntrepreneurshipProjectArticleEntity entrepreneurshipProjectArticle, HttpServletRequest request) {
		entrepreneurshipProjectArticle.setIsDelete(0);
		AjaxJson j = new AjaxJson();
		message = "entrepreneurship_project_article添加成功";
		try{
			entrepreneurshipProjectArticleService.save(entrepreneurshipProjectArticle);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "entrepreneurship_project_article添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新entrepreneurship_project_article
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(EntrepreneurshipProjectArticleEntity entrepreneurshipProjectArticle, HttpServletRequest request) {

		Date date=new Date();
		entrepreneurshipProjectArticle.setUpdateTime(date);
		AjaxJson j = new AjaxJson();
		message = "entrepreneurship_project_article更新成功";
		EntrepreneurshipProjectArticleEntity t = entrepreneurshipProjectArticleService.get(EntrepreneurshipProjectArticleEntity.class, entrepreneurshipProjectArticle.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(entrepreneurshipProjectArticle, t);
			entrepreneurshipProjectArticleService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "entrepreneurship_project_article更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * entrepreneurship_project_article新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(EntrepreneurshipProjectArticleEntity entrepreneurshipProjectArticle, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(entrepreneurshipProjectArticle.getId())) {
			entrepreneurshipProjectArticle = entrepreneurshipProjectArticleService.getEntity(EntrepreneurshipProjectArticleEntity.class, entrepreneurshipProjectArticle.getId());
			req.setAttribute("entrepreneurshipProjectArticlePage", entrepreneurshipProjectArticle);
		}
		return new ModelAndView("com/buss/entrepreneurshipProjectArticle/entrepreneurshipProjectArticle-add");
	}
	/**
	 * entrepreneurship_project_article编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(EntrepreneurshipProjectArticleEntity entrepreneurshipProjectArticle, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(entrepreneurshipProjectArticle.getId())) {
			entrepreneurshipProjectArticle = entrepreneurshipProjectArticleService.getEntity(EntrepreneurshipProjectArticleEntity.class, entrepreneurshipProjectArticle.getId());

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
			req.setAttribute("entrepreneurshipProjectArticlePage", entrepreneurshipProjectArticle);
		}
		return new ModelAndView("com/buss/entrepreneurshipprojectarticle/entrepreneurshipProjectArticle-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","entrepreneurshipProjectArticleController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(EntrepreneurshipProjectArticleEntity entrepreneurshipProjectArticle, HttpServletRequest request, HttpServletResponse response
			, DataGrid dataGrid, ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(EntrepreneurshipProjectArticleEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, entrepreneurshipProjectArticle, request.getParameterMap());
		List<EntrepreneurshipProjectArticleEntity> entrepreneurshipProjectArticles = this.entrepreneurshipProjectArticleService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"entrepreneurship_project_article");
		modelMap.put(NormalExcelConstants.CLASS,EntrepreneurshipProjectArticleEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("entrepreneurship_project_article列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,entrepreneurshipProjectArticles);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(EntrepreneurshipProjectArticleEntity entrepreneurshipProjectArticle, HttpServletRequest request, HttpServletResponse response
			, DataGrid dataGrid, ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"entrepreneurship_project_article");
    	modelMap.put(NormalExcelConstants.CLASS,EntrepreneurshipProjectArticleEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("entrepreneurship_project_article列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<EntrepreneurshipProjectArticleEntity> listEntrepreneurshipProjectArticleEntitys = ExcelImportUtil.importExcel(file.getInputStream(),EntrepreneurshipProjectArticleEntity.class,params);
				for (EntrepreneurshipProjectArticleEntity entrepreneurshipProjectArticle : listEntrepreneurshipProjectArticleEntitys) {
					entrepreneurshipProjectArticleService.save(entrepreneurshipProjectArticle);
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
	public List<EntrepreneurshipProjectArticleEntity> list() {
		List<EntrepreneurshipProjectArticleEntity> listEntrepreneurshipProjectArticles=entrepreneurshipProjectArticleService.getList(EntrepreneurshipProjectArticleEntity.class);
		return listEntrepreneurshipProjectArticles;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		EntrepreneurshipProjectArticleEntity task = entrepreneurshipProjectArticleService.get(EntrepreneurshipProjectArticleEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody EntrepreneurshipProjectArticleEntity entrepreneurshipProjectArticle, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<EntrepreneurshipProjectArticleEntity>> failures = validator.validate(entrepreneurshipProjectArticle);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		entrepreneurshipProjectArticleService.save(entrepreneurshipProjectArticle);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = entrepreneurshipProjectArticle.getId();
		URI uri = uriBuilder.path("/rest/entrepreneurshipProjectArticleController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody EntrepreneurshipProjectArticleEntity entrepreneurshipProjectArticle) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<EntrepreneurshipProjectArticleEntity>> failures = validator.validate(entrepreneurshipProjectArticle);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		entrepreneurshipProjectArticleService.saveOrUpdate(entrepreneurshipProjectArticle);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		entrepreneurshipProjectArticleService.deleteEntityById(EntrepreneurshipProjectArticleEntity.class, id);
	}

	/**
	 * 下载附件
	 * @param entrepreneurshipProjectArticle
	 * @param request
	 * @param response
	 * @param dataGrid
     */
	@RequestMapping(params = "downloadItems")
	@ResponseBody
	public AjaxJson download(EntrepreneurshipProjectArticleEntity entrepreneurshipProjectArticle, HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) throws IOException {
		/*AjaxJson j = new AjaxJson();
		List<FileEntity> fileEntityList = this.systemService.findByProperty(FileEntity.class,"outId",entrepreneurshipProjectArticle.getId());
		if (fileEntityList != null && fileEntityList.size() > 0){

		}*/

		AjaxJson j = new AjaxJson();
		try {
			if (entrepreneurshipProjectArticle.getId() != ""){
				FileDownLoadController fileDownLoadController = new FileDownLoadController();
				fileDownLoadController.test(entrepreneurshipProjectArticle.getId(), response);

			}
		}catch (Exception e){

		}

		return j;
	}

	/**
	 * 审核通过
	 * @param entrepreneurshipProjectArticle
	 * @param request
     * @return
     */
	@RequestMapping(params = "empower")
	@ResponseBody
	public AjaxJson empower(EntrepreneurshipProjectArticleEntity entrepreneurshipProjectArticle, HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		entrepreneurshipProjectArticle = systemService.getEntity(EntrepreneurshipProjectArticleEntity.class,entrepreneurshipProjectArticle.getId());
		message = "entrepreneurship_project_article审核成功";
		try {
			entrepreneurshipProjectArticle.setCheckCode(10);
			this.systemService.saveOrUpdate(entrepreneurshipProjectArticle);
		}catch (Exception e){
			message = "entrepreneurship_project_article审核失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}

	/**
	 * 审核拒绝
	 * @param entrepreneurshipProjectArticle
	 * @param request
     * @return
     */
	@RequestMapping(params = "reject")
	@ResponseBody
	public AjaxJson reject(EntrepreneurshipProjectArticleEntity entrepreneurshipProjectArticle, HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		entrepreneurshipProjectArticle = systemService.getEntity(EntrepreneurshipProjectArticleEntity.class,entrepreneurshipProjectArticle.getId());
		message = "entrepreneurship_project_article拒绝成功";
		try {
			entrepreneurshipProjectArticle.setCheckCode(15);
			this.systemService.saveOrUpdate(entrepreneurshipProjectArticle);
		}catch (Exception e){
			message = "entrepreneurship_project_article拒绝失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
}
