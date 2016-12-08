package com.buss.entrepreneurshiparticle.controller;
import com.buss.entrepreneurshiparticle.entity.DxsEntrepreneurshipArticleEntity;
import com.buss.entrepreneurshiparticle.service.DxsEntrepreneurshipArticleServiceI;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.buss.entrepreneurshipcatalog.entity.DxsEntrepreneurshipCatalogEntity;
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
 * @Description: dxs_entrepreneurship_article
 * @author onlineGenerator
 * @date 2016-06-06 14:25:34
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsEntrepreneurshipArticleController")
public class DxsEntrepreneurshipArticleController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsEntrepreneurshipArticleController.class);

	@Autowired
	private DxsEntrepreneurshipArticleServiceI dxsEntrepreneurshipArticleService;
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
	 * dxs_entrepreneurship_article列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/entrepreneurshiparticle/dxsEntrepreneurshipArticleList");
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
	public void datagrid(DxsEntrepreneurshipArticleEntity dxsEntrepreneurshipArticle,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		dxsEntrepreneurshipArticle.setIsDelete(0);
		CriteriaQuery cq = new CriteriaQuery(DxsEntrepreneurshipArticleEntity.class, dataGrid);
		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsEntrepreneurshipArticle, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsEntrepreneurshipArticleService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_entrepreneurship_article
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsEntrepreneurshipArticleEntity dxsEntrepreneurshipArticle, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsEntrepreneurshipArticle = systemService.getEntity(DxsEntrepreneurshipArticleEntity.class, dxsEntrepreneurshipArticle.getId());
		message = "删除成功";
		try{
			//lx
			//更改为无效标志
			dxsEntrepreneurshipArticle.setIsDelete(1);
			dxsEntrepreneurshipArticleService.updateEntitie(dxsEntrepreneurshipArticle);
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
	 * 批量删除dxs_entrepreneurship_article
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
				DxsEntrepreneurshipArticleEntity dxsEntrepreneurshipArticle = systemService.getEntity(DxsEntrepreneurshipArticleEntity.class, 
				id
				);
				//lx
				//更改为无效标志
				dxsEntrepreneurshipArticle.setIsDelete(1);
				dxsEntrepreneurshipArticleService.updateEntitie(dxsEntrepreneurshipArticle);
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
	 * 添加dxs_entrepreneurship_article
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsEntrepreneurshipArticleEntity dxsEntrepreneurshipArticle, HttpServletRequest request) {
		//lx
		//添加默认字段
		Date date=new Date();
		dxsEntrepreneurshipArticle.setCreateTime(date);
		dxsEntrepreneurshipArticle.setUpdateTime(date);
		dxsEntrepreneurshipArticle.setEntrepreneurshipPublishTime(date);
		dxsEntrepreneurshipArticle.setIsDelete(0);
		AjaxJson j = new AjaxJson();
		message = "添加成功";
		try{
			dxsEntrepreneurshipArticleService.save(dxsEntrepreneurshipArticle);
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
	 * 更新dxs_entrepreneurship_article
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsEntrepreneurshipArticleEntity dxsEntrepreneurshipArticle, HttpServletRequest request) {
		//lx
		//修改更新时间
		Date date=new Date();
		dxsEntrepreneurshipArticle.setUpdateTime(date);
		AjaxJson j = new AjaxJson();
		message = "更新成功";
		DxsEntrepreneurshipArticleEntity t = dxsEntrepreneurshipArticleService.get(DxsEntrepreneurshipArticleEntity.class, dxsEntrepreneurshipArticle.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsEntrepreneurshipArticle, t);
			dxsEntrepreneurshipArticleService.saveOrUpdate(t);
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
	 * dxs_entrepreneurship_article新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DxsEntrepreneurshipArticleEntity dxsEntrepreneurshipArticle, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsEntrepreneurshipArticle.getId())) {
			dxsEntrepreneurshipArticle = dxsEntrepreneurshipArticleService.getEntity(DxsEntrepreneurshipArticleEntity.class, dxsEntrepreneurshipArticle.getId());
			req.setAttribute("dxsEntrepreneurshipArticlePage", dxsEntrepreneurshipArticle);
		}
		List<DxsEntrepreneurshipCatalogEntity> DxsEntrepreneurshipCatalogList = systemService.findByProperty( DxsEntrepreneurshipCatalogEntity.class,"isDelete",0);
		req.setAttribute("DxsEntrepreneurshipCatalogList", DxsEntrepreneurshipCatalogList);
		return new ModelAndView("com/buss/entrepreneurshiparticle/dxsEntrepreneurshipArticle-add");
	}
	/**
	 * dxs_entrepreneurship_article编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsEntrepreneurshipArticleEntity dxsEntrepreneurshipArticle, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsEntrepreneurshipArticle.getId())) {
			dxsEntrepreneurshipArticle = dxsEntrepreneurshipArticleService.getEntity(DxsEntrepreneurshipArticleEntity.class, dxsEntrepreneurshipArticle.getId());
			req.setAttribute("dxsEntrepreneurshipArticlePage", dxsEntrepreneurshipArticle);
		}
		List<DxsEntrepreneurshipCatalogEntity> DxsEntrepreneurshipCatalogList = systemService.findByProperty( DxsEntrepreneurshipCatalogEntity.class,"isDelete",0);
		req.setAttribute("DxsEntrepreneurshipCatalogList", DxsEntrepreneurshipCatalogList);
		return new ModelAndView("com/buss/entrepreneurshiparticle/dxsEntrepreneurshipArticle-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsEntrepreneurshipArticleController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsEntrepreneurshipArticleEntity dxsEntrepreneurshipArticle,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsEntrepreneurshipArticleEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsEntrepreneurshipArticle, request.getParameterMap());
		List<DxsEntrepreneurshipArticleEntity> dxsEntrepreneurshipArticles = this.dxsEntrepreneurshipArticleService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_entrepreneurship_article");
		modelMap.put(NormalExcelConstants.CLASS,DxsEntrepreneurshipArticleEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_entrepreneurship_article列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsEntrepreneurshipArticles);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsEntrepreneurshipArticleEntity dxsEntrepreneurshipArticle,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_entrepreneurship_article");
    	modelMap.put(NormalExcelConstants.CLASS,DxsEntrepreneurshipArticleEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_entrepreneurship_article列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsEntrepreneurshipArticleEntity> listDxsEntrepreneurshipArticleEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsEntrepreneurshipArticleEntity.class,params);
				for (DxsEntrepreneurshipArticleEntity dxsEntrepreneurshipArticle : listDxsEntrepreneurshipArticleEntitys) {
					dxsEntrepreneurshipArticleService.save(dxsEntrepreneurshipArticle);
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
	public List<DxsEntrepreneurshipArticleEntity> list() {
		List<DxsEntrepreneurshipArticleEntity> listDxsEntrepreneurshipArticles=dxsEntrepreneurshipArticleService.getList(DxsEntrepreneurshipArticleEntity.class);
		return listDxsEntrepreneurshipArticles;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsEntrepreneurshipArticleEntity task = dxsEntrepreneurshipArticleService.get(DxsEntrepreneurshipArticleEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsEntrepreneurshipArticleEntity dxsEntrepreneurshipArticle, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsEntrepreneurshipArticleEntity>> failures = validator.validate(dxsEntrepreneurshipArticle);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsEntrepreneurshipArticleService.save(dxsEntrepreneurshipArticle);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsEntrepreneurshipArticle.getId();
		URI uri = uriBuilder.path("/rest/dxsEntrepreneurshipArticleController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsEntrepreneurshipArticleEntity dxsEntrepreneurshipArticle) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsEntrepreneurshipArticleEntity>> failures = validator.validate(dxsEntrepreneurshipArticle);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsEntrepreneurshipArticleService.saveOrUpdate(dxsEntrepreneurshipArticle);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsEntrepreneurshipArticleService.deleteEntityById(DxsEntrepreneurshipArticleEntity.class, id);
	}
}
