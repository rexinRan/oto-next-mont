package com.buss.dxsnews.controller;

import com.buss.common.redis.RedisClient;
import com.buss.common.redis.cache.CacheKey;
import com.buss.dxsnews.entity.DxsNewsEntity;
import com.buss.dxsnews.service.DxsNewsServiceI;
import com.buss.dxsnewscatelog.entity.DxsNewsCatelogEntity;
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

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import java.io.IOException;
import java.net.URI;
import java.util.*;

/**   
 * @Title: Controller
 * @Description: dxs_news
 * @author onlineGenerator
 * @date 2016-05-30 17:05:49
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsNewsController")
public class DxsNewsController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsNewsController.class);

	@Autowired
	private DxsNewsServiceI dxsNewsService;
	@Autowired
	private SystemService systemService;
	@Autowired
	private Validator validator;

	@Resource
	private RedisClient redisClient;
	
	private String message;
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}


	/**
	 * dxs_news列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/dxsnews/dxsNewsList");
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
	public void datagrid(DxsNewsEntity dxsNews,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		// 兰啸
		// 增加有效标志
		dxsNews.setIsDelete(0);

		CriteriaQuery cq = new CriteriaQuery(DxsNewsEntity.class, dataGrid);

		//查询条件组装器
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsNews, request.getParameterMap());
		try{
		//自定义追加查询条件
			// 追加排序条件
			Map orderMap = new HashMap();
//			orderMap.put("newSort", SortDirection.desc);
			orderMap.put("createTime", SortDirection.desc);
			cq.setOrder(orderMap);

		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsNewsService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	/**
	 * 删除dxs_news
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsNewsEntity dxsNews, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsNews = systemService.getEntity(DxsNewsEntity.class, dxsNews.getId());
		message = "删除成功";
		try{
			// TODO 清理redis缓存
			dxsNewsService.redisRemove(dxsNews);
			//兰啸
			//更改为无效标志
			dxsNews.setIsDelete(1);
			dxsNewsService.updateEntitie(dxsNews);
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
	 * 批量删除dxs_news
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
				DxsNewsEntity dxsNews = systemService.getEntity(DxsNewsEntity.class, 
				id
				);
				// TODO 清理redis缓存
				dxsNewsService.redisRemove(dxsNews);
				//兰啸
				//更改为无效标志
				dxsNews.setIsDelete(1);
				dxsNewsService.updateEntitie(dxsNews);
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
	 * 添加dxs_news
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsNewsEntity dxsNews, HttpServletRequest request) {
		// 兰啸
		// 添加默认字段值
		Date date =new Date();
		Calendar c = Calendar.getInstance();
		c.setTime(dxsNews.getNewPublishTime());
		int year = c.get(Calendar.YEAR);

		String ye=Integer.toString(year);

		dxsNews.setCreateTime(date);
		dxsNews.setUpdateTime(date);
		dxsNews.setIsDelete(0);
		dxsNews.setNewSort(0);
		dxsNews.setNewPublishYear(ye);


		dxsNews.setIsSpecial(0);
		AjaxJson j = new AjaxJson();
		message = "添加成功";
		try{
			String cid = dxsNews.getNewCatelogId();
			DxsNewsCatelogEntity nce = systemService.get(DxsNewsCatelogEntity.class, cid);

			dxsNews.setDxsNewsCatelogEntity(nce);
			dxsNews.getNewCatelogId();
			dxsNewsService.save(dxsNews);
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
	 * 更新dxs_news
	 * 
	 * @param ids
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate(DxsNewsEntity dxsNews, HttpServletRequest request) {
		// 兰啸
		// 更新修改时间
		Date date=new Date();
		dxsNews.setUpdateTime(date);
		if(dxsNews.getNewPublishTime()!=null){
			Calendar c = Calendar.getInstance();
			c.setTime(dxsNews.getNewPublishTime());
			int year = c.get(Calendar.YEAR);

			String ye=Integer.toString(year);
			dxsNews.setNewPublishYear(ye);
		}

		if(dxsNews.getIsSpecial()!=null){
			if(dxsNews.getIsSpecial()==1){
				List<DxsNewsEntity> list=systemService.findByProperty(DxsNewsEntity.class,"isSpecial",1);
				for(DxsNewsEntity dxsNewsEntity:list){
					dxsNewsEntity.setIsSpecial(0);
					dxsNewsService.updateEntitie(dxsNewsEntity);
				}
			}
		}


		AjaxJson j = new AjaxJson();
		message = "更新成功";
		DxsNewsEntity t = dxsNewsService.get(DxsNewsEntity.class, dxsNews.getId());
		try {
			MyBeanUtils.copyBeanNotNull2Bean(dxsNews, t);
			dxsNewsService.saveOrUpdate(t);
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
	 * dxs_news新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DxsNewsEntity dxsNews, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsNews.getId())) {
			dxsNews = dxsNewsService.getEntity(DxsNewsEntity.class, dxsNews.getId());
			req.setAttribute("dxsNewsPage", dxsNews);
		}
		//兰啸
		//添加新闻类别
		List<DxsNewsCatelogEntity> dxsnewscatelogList = systemService.findByProperty(DxsNewsCatelogEntity.class,"isDelete",0);
		req.setAttribute("dxsnewscatelogList", dxsnewscatelogList);

		return new ModelAndView("com/buss/dxsnews/dxsNews-add");
	}
	/**
	 * dxs_news编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsNewsEntity dxsNews, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsNews.getId())) {
			dxsNews = dxsNewsService.getEntity(DxsNewsEntity.class, dxsNews.getId());
			req.setAttribute("dxsNewsPage", dxsNews);
		}
		//兰啸
		//添加新闻类别
		List<DxsNewsCatelogEntity> dxsnewscatelogList = systemService.findByProperty(DxsNewsCatelogEntity.class,"isDelete",0);
		req.setAttribute("dxsnewscatelogList", dxsnewscatelogList);
		return new ModelAndView("com/buss/dxsnews/dxsNews-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsNewsController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsNewsEntity dxsNews,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsNewsEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsNews, request.getParameterMap());
		List<DxsNewsEntity> dxsNewss = this.dxsNewsService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_news");
		modelMap.put(NormalExcelConstants.CLASS,DxsNewsEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_news列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsNewss);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsNewsEntity dxsNews,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_news");
    	modelMap.put(NormalExcelConstants.CLASS,DxsNewsEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_news列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsNewsEntity> listDxsNewsEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsNewsEntity.class,params);
				for (DxsNewsEntity dxsNews : listDxsNewsEntitys) {
					dxsNewsService.save(dxsNews);
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
	public List<DxsNewsEntity> list() {
		List<DxsNewsEntity> listDxsNewss=dxsNewsService.getList(DxsNewsEntity.class);
		return listDxsNewss;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsNewsEntity task = dxsNewsService.get(DxsNewsEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsNewsEntity dxsNews, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsNewsEntity>> failures = validator.validate(dxsNews);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsNewsService.save(dxsNews);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsNews.getId();
		URI uri = uriBuilder.path("/rest/dxsNewsController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsNewsEntity dxsNews) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsNewsEntity>> failures = validator.validate(dxsNews);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsNewsService.saveOrUpdate(dxsNews);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}




	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsNewsService.deleteEntityById(DxsNewsEntity.class, id);
	}
}
