package com.buss.indexarticle.controller;

import com.buss.indexarticle.entity.DxsIndexArticleEntity;
import com.buss.indexarticle.service.DxsIndexArticleServiceI;
import com.buss.indexcatelog.entity.DxsIndexCatelogEntity;
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
 * @Description: dxs_index_article
 * @author onlineGenerator
 * @date 2016-07-12 16:38:13
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsIndexArticleController")
public class DxsIndexArticleController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsIndexArticleController.class);

	@Autowired
	private DxsIndexArticleServiceI dxsIndexArticleService;
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
	 * dxs_index_article列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/indexarticle/dxsIndexArticleList");
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
	public void datagrid(DxsIndexArticleEntity dxsIndexArticle,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DxsIndexArticleEntity.class, dataGrid);
		//查询条件组装器
		dxsIndexArticle.setIsDelete(0);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsIndexArticle, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsIndexArticleService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_index_article
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsIndexArticleEntity dxsIndexArticle, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsIndexArticle = systemService.getEntity(DxsIndexArticleEntity.class, dxsIndexArticle.getId());
		message = "dxs_index_article删除成功";
		try{
			dxsIndexArticle.setIsDelete(1);
			dxsIndexArticleService.updateEntitie(dxsIndexArticle);
			systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);

			dxsIndexArticleService.redisRemove(dxsIndexArticle);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_index_article删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 批量删除dxs_index_article
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "dxs_index_article删除成功";
		try{
			for(String id:ids.split(",")){
				DxsIndexArticleEntity dxsIndexArticle = systemService.getEntity(DxsIndexArticleEntity.class, 
				id
				);
				dxsIndexArticle.setIsDelete(1);
				dxsIndexArticleService.updateEntitie(dxsIndexArticle);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);

				dxsIndexArticleService.redisRemove(dxsIndexArticle);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_index_article删除失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加dxs_index_article
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsIndexArticleEntity dxsIndexArticle, HttpServletRequest request) {
		Date date =new Date();
		dxsIndexArticle.setCreateTime(date);
		dxsIndexArticle.setUpdateTime(date);
		dxsIndexArticle.setArticlePublishTime(date);
		dxsIndexArticle.setIsDelete(0);
		AjaxJson j = new AjaxJson();
		message = "dxs_index_article添加成功";
		try{
			dxsIndexArticleService.save(dxsIndexArticle);
			systemService.addLog(message, Globals.Log_Type_INSERT, Globals.Log_Leavel_INFO);
		}catch(Exception e){
			e.printStackTrace();
			message = "dxs_index_article添加失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	
	/**
	 * 更新dxs_index_article
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsIndexArticleEntity dxsIndexArticle, HttpServletRequest request) {
		Date date =new Date();
		dxsIndexArticle.setUpdateTime(date);
		AjaxJson j = new AjaxJson();
		message = "dxs_index_article更新成功";
		DxsIndexArticleEntity t = dxsIndexArticleService.get(DxsIndexArticleEntity.class, dxsIndexArticle.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsIndexArticle, t);
			dxsIndexArticleService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "dxs_index_article更新失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	

	/**
	 * dxs_index_article新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DxsIndexArticleEntity dxsIndexArticle, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsIndexArticle.getId())) {
			dxsIndexArticle = dxsIndexArticleService.getEntity(DxsIndexArticleEntity.class, dxsIndexArticle.getId());
			req.setAttribute("dxsIndexArticlePage", dxsIndexArticle);
		}
		List<DxsIndexCatelogEntity> DxsIndexCatelogList =  systemService.findByProperty(DxsIndexCatelogEntity.class,"isDelete",0);
		req.setAttribute("DxsIndexCatelogList", DxsIndexCatelogList);
		return new ModelAndView("com/buss/indexarticle/dxsIndexArticle-add");
	}
	/**
	 * dxs_index_article编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsIndexArticleEntity dxsIndexArticle, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsIndexArticle.getId())) {
			dxsIndexArticle = dxsIndexArticleService.getEntity(DxsIndexArticleEntity.class, dxsIndexArticle.getId());
			req.setAttribute("dxsIndexArticlePage", dxsIndexArticle);
		}
		List<DxsIndexCatelogEntity> DxsIndexCatelogList =  systemService.findByProperty(DxsIndexCatelogEntity.class,"isDelete",0);
		req.setAttribute("DxsIndexCatelogList", DxsIndexCatelogList);
		return new ModelAndView("com/buss/indexarticle/dxsIndexArticle-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsIndexArticleController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsIndexArticleEntity dxsIndexArticle,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsIndexArticleEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsIndexArticle, request.getParameterMap());
		List<DxsIndexArticleEntity> dxsIndexArticles = this.dxsIndexArticleService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_index_article");
		modelMap.put(NormalExcelConstants.CLASS,DxsIndexArticleEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_index_article列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsIndexArticles);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsIndexArticleEntity dxsIndexArticle,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_index_article");
    	modelMap.put(NormalExcelConstants.CLASS,DxsIndexArticleEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_index_article列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsIndexArticleEntity> listDxsIndexArticleEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsIndexArticleEntity.class,params);
				for (DxsIndexArticleEntity dxsIndexArticle : listDxsIndexArticleEntitys) {
					dxsIndexArticleService.save(dxsIndexArticle);
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
	public List<DxsIndexArticleEntity> list() {
		List<DxsIndexArticleEntity> listDxsIndexArticles=dxsIndexArticleService.getList(DxsIndexArticleEntity.class);
		return listDxsIndexArticles;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsIndexArticleEntity task = dxsIndexArticleService.get(DxsIndexArticleEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsIndexArticleEntity dxsIndexArticle, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsIndexArticleEntity>> failures = validator.validate(dxsIndexArticle);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsIndexArticleService.save(dxsIndexArticle);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsIndexArticle.getId();
		URI uri = uriBuilder.path("/rest/dxsIndexArticleController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsIndexArticleEntity dxsIndexArticle) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsIndexArticleEntity>> failures = validator.validate(dxsIndexArticle);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsIndexArticleService.saveOrUpdate(dxsIndexArticle);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsIndexArticleService.deleteEntityById(DxsIndexArticleEntity.class, id);
	}
}
