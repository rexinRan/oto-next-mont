package com.buss.user.controller;
import com.buss.authentication.entity.DxsAuthenticationEntity;
import com.buss.common.entity.DxsUserCompancyEntity;
import com.buss.common.entity.DxsUserDetailEntity;
import com.buss.common.service.DxsUserCompancyServiceI;
import com.buss.user.entity.DxsRoleEntity;
import com.buss.user.entity.DxsUserEntity;
import com.buss.user.service.DxsUserServiceI;

import java.io.ObjectOutputStream;
import java.util.*;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thoughtworks.xstream.core.TreeUnmarshaller;
import com.thoughtworks.xstream.core.util.ThreadSafeSimpleDateFormat;
import com.thoughtworks.xstream.mapper.Mapper;
import jodd.servlet.tag.ElseTag;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.model.json.ComboTree;
import org.jeecgframework.core.util.*;
import org.jeecgframework.core.util.MyBeanUtils;
import org.jeecgframework.core.util.PasswordUtil;
import org.jeecgframework.core.util.ResourceUtil;
import org.jeecgframework.core.util.StringUtil;
import org.jeecgframework.tag.vo.easyui.ComboTreeModel;

import org.jeecgframework.web.system.pojo.base.TSIcon;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.util.*;
import org.postgresql.jdbc2.optional.SimpleDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
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
import org.jeecgframework.tag.core.easyui.TagUtil;
import org.jeecgframework.web.system.pojo.base.TSDepart;
import org.jeecgframework.web.system.service.SystemService;

import java.io.OutputStream;

import org.jeecgframework.poi.excel.ExcelExportUtil;
import org.jeecgframework.poi.excel.ExcelImportUtil;
import org.jeecgframework.poi.excel.entity.ExportParams;
import org.jeecgframework.poi.excel.entity.ImportParams;
import org.jeecgframework.poi.excel.entity.TemplateExportParams;
import org.jeecgframework.poi.excel.entity.vo.NormalExcelConstants;
import org.jeecgframework.poi.excel.entity.vo.TemplateExcelConstants;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.IOException;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

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
 * @Description: dxs_user
 * @author onlineGenerator
 * @date 2016-05-31 13:12:59
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsUserController")
public class DxsUserController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(DxsUserController.class);

	@Autowired
	private DxsUserServiceI dxsUserService;
	@Autowired
	private DxsUserCompancyServiceI dxsUserCompancyService;
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
	 * dxs_user列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/user/dxsUserList");
	}

	/**
	 * easyui AJAX请求数据
	 * 
	 * @param request
	 * @param response
	 * @param dataGrid
	 */

	@RequestMapping(params = "datagrid")
	public void datagrid(DxsUserEntity dxsUser,HttpServletRequest request, HttpServletResponse response, DataGrid dataGrid) {
		CriteriaQuery cq = new CriteriaQuery(DxsUserEntity.class, dataGrid);
		//查询条件组装器
		dxsUser.setIsdelete(0);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsUser, request.getParameterMap());
		try{
		//自定义追加查询条件
		}catch (Exception e) {
			throw new BusinessException(e.getMessage());
		}
		cq.add();
		this.dxsUserService.getDataGridReturn(cq, true);
		TagUtil.datagrid(response, dataGrid);
	}

	@RequestMapping(params = "panDaun")
	@ResponseBody
	public AjaxJson panDaun(DxsUserEntity dxsUser, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		List list=systemService.findByProperty(DxsUserEntity.class,"email",dxsUser.getEmail());
		String  message="1";
		if(list.size()==0){
			message="2";
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 删除dxs_user
	 * 
	 * @return
	 */
	@RequestMapping(params = "doDel")
	@ResponseBody
	public AjaxJson doDel(DxsUserEntity dxsUser, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		dxsUser = systemService.getEntity(DxsUserEntity.class, dxsUser.getId());
		message = "删除成功";
		try{
			List<DxsUserCompancyEntity> dxsUserCompancyEntity =systemService.findByProperty(DxsUserCompancyEntity.class,"userId", dxsUser.getId());
			DxsUserCompancyEntity list=dxsUserCompancyEntity.get(0);
			list.setIsDelete(1);
			dxsUser.setIsdelete(1);
			systemService.saveOrUpdate(list);
			dxsUserService.saveOrUpdate(dxsUser);
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
	 * 批量删除dxs_user
	 * 
	 * @return
	 */
	 @RequestMapping(params = "doBatchDel")
	@ResponseBody
	public AjaxJson doBatchDel(String ids,HttpServletRequest request){
		AjaxJson j = new AjaxJson();
		message = "操作成功";
		try{
			for(String id:ids.split(",")){
				DxsUserEntity dxsUser = systemService.getEntity(DxsUserEntity.class, 
				id
				);
				if("emp".equals(dxsUser.getRolecode())){
					dxsUser.setCheckstatus(10);
				}
				if("student".equals(dxsUser.getRolecode())){
					dxsUser.setCheckstatus(4);
				}
				if("teacher".equals(dxsUser.getRolecode())){
					dxsUser.setCheckstatus(7);
				}
				dxsUserService.saveOrUpdate(dxsUser);
				systemService.addLog(message, Globals.Log_Type_DEL, Globals.Log_Leavel_INFO);
			}
		}catch(Exception e){
			e.printStackTrace();
			message = "操作失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}


	/**
	 * 添加dxs_user
	 * 
	 * @return
	 */
	@RequestMapping(params = "doAdd")
	@ResponseBody
	public AjaxJson doAdd(DxsUserEntity dxsUser, HttpServletRequest request) {
		String pwd2Str = org.jweb.core.util.PasswordUtil.encrypt("000000", org.jweb.core.util.PasswordUtil.str, org.jweb.core.util.PasswordUtil.getStaticSalt());
		dxsUser.setPwd(pwd2Str);
		Date date= new Date();
		dxsUser.setRolecode("emp");
		dxsUser.setCheckstatus(10);
		dxsUser.setCreatetime(date);
		dxsUser.setIsdelete(0);

		AjaxJson j = new AjaxJson();
		message = "添加成功";
		try{
			dxsUserService.save(dxsUser);
			DxsUserCompancyEntity dxsUserCompancyEntity =new DxsUserCompancyEntity();
			dxsUserCompancyEntity.setUserId(dxsUser.getId());
			dxsUserCompancyEntity.setIsDelete(0);
			dxsUserCompancyEntity.setCompancyName(dxsUser.getEmpname());
			systemService.saveOrUpdate(dxsUserCompancyEntity);
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
	 * 更新dxs_user
	 *
	 * @return
	 */
	@RequestMapping(params = "dostatus")
	@ResponseBody
	public AjaxJson dostatus( int tongyi,DxsUserEntity dxsUser, HttpServletRequest request) {
		DxsAuthenticationEntity dxsAuthenticationEntity=new DxsAuthenticationEntity();
		AjaxJson j = new AjaxJson();
		message = "操作成功";
		DxsUserEntity t = dxsUserService.get(DxsUserEntity.class, dxsUser.getId());
		dxsAuthenticationEntity.setUserId(dxsUser.getId());
		dxsAuthenticationEntity.setIsDelete(0);
		List<DxsAuthenticationEntity> d = systemService.findByExample(DxsAuthenticationEntity.class.getName(),dxsAuthenticationEntity );
		if(d.size()!=0){
			dxsAuthenticationEntity=d.get(0);
		//	dxsAuthenticationEntity= systemService.get(DxsAuthenticationEntity.class,dxsAuthenticationEntity.getId());
		}
        if(tongyi==1){
			if("emp".equals(t.getRolecode())){
				t.setCheckstatus(10);
			}
			if("student".equals(t.getRolecode())){
				t.setCheckstatus(4);
				dxsAuthenticationEntity.setAuthenticationResult("2");
			}
			if("teacher".equals(t.getRolecode())){
				t.setCheckstatus(7);
				dxsAuthenticationEntity.setAuthenticationResult("5");
			}

         }else {
			if("emp".equals(t.getRolecode())){
				t.setCheckstatus(8);
			}
			if("student".equals(t.getRolecode())){
				t.setCheckstatus(2);
				dxsAuthenticationEntity.setAuthenticationResult("3");
			}
			if("teacher".equals(t.getRolecode())){
				t.setCheckstatus(5);
				dxsAuthenticationEntity.setAuthenticationResult("6");
			}
		}

		try {
			systemService.saveOrUpdate(dxsAuthenticationEntity);
			MyBeanUtils.copyBeanNotNull2Bean(dxsUser, t);
			dxsUserService.saveOrUpdate(t);
			systemService.addLog(message, Globals.Log_Type_UPDATE, Globals.Log_Leavel_INFO);
		} catch (Exception e) {
			e.printStackTrace();
			message = "操作失败";
			throw new BusinessException(e.getMessage());
		}
		j.setMsg(message);
		return j;
	}
	/**
	 * 更新dxs_user
	 *
	 * @return
	 */
	@RequestMapping(params = "doUpdate")
	@ResponseBody
	public AjaxJson doUpdate( DxsUserEntity dxsUser, HttpServletRequest request) {
		AjaxJson j = new AjaxJson();
		message = "更新成功";
		DxsUserEntity t = dxsUserService.get(DxsUserEntity.class, dxsUser.getId());
		try {
			List<DxsUserCompancyEntity> r=systemService.findByProperty(DxsUserCompancyEntity.class,"userId",t.getId());
			DxsUserCompancyEntity dxsUserCompancyEntity=r.get(0);
			dxsUserCompancyEntity.setCompancyName(dxsUser.getEmpname());
			systemService.saveOrUpdate(dxsUserCompancyEntity);
			MyBeanUtils.copyBeanNotNull2Bean(dxsUser, t);
			dxsUserService.saveOrUpdate(t);
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
	 * dxs_user新增页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goAdd")
	public ModelAndView goAdd(DxsUserEntity dxsUser, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsUser.getId())) {
			dxsUser = dxsUserService.getEntity(DxsUserEntity.class, dxsUser.getId());
			req.setAttribute("dxsUserPage", dxsUser);
		}
		// 查用户角色
		List<DxsRoleEntity> roleList = systemService.findByQueryString("from DxsRoleEntity");
		req.setAttribute("roleList", roleList);
		return new ModelAndView("com/buss/user/dxsUser-add");
	}
	/**
	 * dxs_user编辑页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "goUpdate")
	public ModelAndView goUpdate(DxsUserEntity dxsUser, HttpServletRequest req) {
		if (StringUtil.isNotEmpty(dxsUser.getId())) {
			dxsUser = dxsUserService.getEntity(DxsUserEntity.class, dxsUser.getId());
			req.setAttribute("dxsUserPage", dxsUser);
		}

		// 查用户角色
		List<DxsRoleEntity> roleList = systemService.findByQueryString("from DxsRoleEntity");
		req.setAttribute("roleList", roleList);
		return new ModelAndView("com/buss/user/dxsUser-update");
	}
	
	/**
	 * 导入功能跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "upload")
	public ModelAndView upload(HttpServletRequest req) {
		req.setAttribute("controller_name","dxsUserController");
		return new ModelAndView("common/upload/pub_excel_upload");
	}
	
	/**
	 * 导出excel
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXls")
	public String exportXls(DxsUserEntity dxsUser,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
		CriteriaQuery cq = new CriteriaQuery(DxsUserEntity.class, dataGrid);
		org.jeecgframework.core.extend.hqlsearch.HqlGenerateUtil.installHql(cq, dxsUser, request.getParameterMap());
		List<DxsUserEntity> dxsUsers = this.dxsUserService.getListByCriteriaQuery(cq,false);
		modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_user");
		modelMap.put(NormalExcelConstants.CLASS,DxsUserEntity.class);
		modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_user列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
			"导出信息"));
		modelMap.put(NormalExcelConstants.DATA_LIST,dxsUsers);
		return NormalExcelConstants.JEECG_EXCEL_VIEW;
	}
	/**
	 * 导出excel 使模板
	 * 
	 * @param request
	 * @param response
	 */
	@RequestMapping(params = "exportXlsByT")
	public String exportXlsByT(DxsUserEntity dxsUser,HttpServletRequest request,HttpServletResponse response
			, DataGrid dataGrid,ModelMap modelMap) {
    	modelMap.put(NormalExcelConstants.FILE_NAME,"dxs_user");
    	modelMap.put(NormalExcelConstants.CLASS,DxsUserEntity.class);
    	modelMap.put(NormalExcelConstants.PARAMS,new ExportParams("dxs_user列表", "导出人:"+ResourceUtil.getSessionUserName().getRealName(),
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
				List<DxsUserEntity> listDxsUserEntitys = ExcelImportUtil.importExcel(file.getInputStream(),DxsUserEntity.class,params);
				for (DxsUserEntity dxsUser : listDxsUserEntitys) {
					dxsUserService.save(dxsUser);
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
	public List<DxsUserEntity> list() {
		List<DxsUserEntity> listDxsUsers=dxsUserService.getList(DxsUserEntity.class);
		return listDxsUsers;
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> get(@PathVariable("id") String id) {
		DxsUserEntity task = dxsUserService.get(DxsUserEntity.class, id);
		if (task == null) {
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity(task, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<?> create(@RequestBody DxsUserEntity dxsUser, UriComponentsBuilder uriBuilder) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsUserEntity>> failures = validator.validate(dxsUser);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsUserService.save(dxsUser);

		//按照Restful风格约定，创建指向新任务的url, 也可以直接返回id或对象.
		String id = dxsUser.getId();
		URI uri = uriBuilder.path("/rest/dxsUserController/" + id).build().toUri();
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(uri);

		return new ResponseEntity(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> update(@RequestBody DxsUserEntity dxsUser) {
		//调用JSR303 Bean Validator进行校验，如果出错返回含400错误码及json格式的错误信息.
		Set<ConstraintViolation<DxsUserEntity>> failures = validator.validate(dxsUser);
		if (!failures.isEmpty()) {
			return new ResponseEntity(BeanValidators.extractPropertyAndMessage(failures), HttpStatus.BAD_REQUEST);
		}

		//保存
		dxsUserService.saveOrUpdate(dxsUser);

		//按Restful约定，返回204状态码, 无内容. 也可以返回200状态码.
		return new ResponseEntity(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") String id) {
		dxsUserService.deleteEntityById(DxsUserEntity.class, id);
	}


	/**
	 * 父级权限下拉菜单
	 */
	@RequestMapping(params = "setPFunction")
	@ResponseBody
	public List<ComboTree> setPFunction(HttpServletRequest request,
										ComboTree comboTree) {
		CriteriaQuery cq = new CriteriaQuery(DxsRoleEntity.class);

		List<DxsRoleEntity> listByCriteriaQuery = systemService.getListByCriteriaQuery(
				cq, false);
		List<DxsRoleEntity> functionList = listByCriteriaQuery;
		List<ComboTree> comboTrees = new ArrayList<ComboTree>();
		ComboTreeModel comboTreeModel = new ComboTreeModel("id",
				"name", "DxsRoleEntitys");
		comboTrees = systemService.ComboTree(functionList, comboTreeModel,
				null, false);
		MutiLangUtil.setMutiTree(comboTrees);
		return comboTrees;
	}

	@RequestMapping(params = "test")
	@ResponseBody
	public void testAnnotation(String arg) {
		// DxsUserDetailEntity onetoone
//		DxsUserDetailEntity dxsUserDetailEntity = this.systemService.getEntity(DxsUserDetailEntity.class, "402880025556de00015556e251bd0000");
//		System.out.print(dxsUserDetailEntity.getUserid());

		DxsUserCompancyEntity dxsUserCompancyEntity = this.systemService.getEntity(DxsUserCompancyEntity.class, "1");
		System.out.println(dxsUserCompancyEntity.getDxsUserEntity().getEmpname());

	}


	/**
	 * 查询该平台的所有用户
	 * @return
	 * http://localhost:8080/dxs-manager/dxsUserController.do?queryAllUser
     */
	@RequestMapping(params = "queryAllUser")
	@ResponseBody
	public ReplyDataMode queryAllUser(){
		ReplyDataMode replyDataMode = new ReplyDataMode();

		String sql = "SELECT COUNT(1) FROM dxs_user WHERE dxs_user.isdelete = 0";
		List<String> counts = (List) this.systemService.findListbySql(sql);

		if (counts != null && counts.size() > 0){
			replyDataMode.setData(counts.get(0));
			replyDataMode.setStatusCode("200");
			replyDataMode.setSuccess(true);
		}else {
			List list = new ArrayList();
			list.add("null");
			replyDataMode.setData(list.get(0));
			replyDataMode.setStatusCode("200");
			replyDataMode.setSuccess(true);
		}

		return replyDataMode;
	}

	/**
	 * 今日新增用户
	 * @return
	 * http://localhost:8080/dxs-manager/dxsUserController.do?newlyIncreasedNum
     */
	@RequestMapping(params = "newlyIncreasedNum")
	@ResponseBody
	public ReplyDataMode newlyIncreasedNum(){
		ReplyDataMode replydatamode = new ReplyDataMode();
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String time = dateFormat.format(date);
		if (!StringUtil.isEmpty(time)){
			// 当日用户的注册量
			String sql = "SELECT\n" +
					"\tCOUNT(1)\n" +
					"FROM\n" +
					"\tdxs_user\n" +
					"WHERE\n" +
					"\t'"+ time +"' <= dxs_user.createtime";

			// 统计每日用户的注册量
			String dailyStatistics = "SELECT\n" +
					"\tDATE_FORMAT(createtime, '%Y-%m-%d') AS time,\n" +
					"\tcount(1) AS count\n" +
					"FROM\n" +
					"\tdxs_user\n" +
					"GROUP BY\n" +
					"\ttime";

			List<String> counts = this.systemService.findListbySql(sql);

			if (counts != null && counts.size() > 0){
				replydatamode.setData(counts.get(0));
				replydatamode.setStatusCode("200");
				replydatamode.setSuccess(true);
			}else {
				List list = new ArrayList();
				list.add("null");

				replydatamode.setData(list.get(0));
				replydatamode.setStatusCode("200");
				replydatamode.setSuccess(true);
			}
		}

		return replydatamode;
	}


	/**
	 * 统计各区域今日新增人数
	 * @param type  区域类别
	 * @param queryType  查询类别 (区域：0    今日新增人数：5)
	 * @return
	 * http://localhost:8080/dxs-manager/dxsUserController.do?rangeStatistics&type=4
	 */
	@RequestMapping(params = "rangeStatistics")
	@ResponseBody
	public ReplyDataMode rangeStatistics(String type,String queryType){
		ReplyDataMode replyDataMode = new ReplyDataMode();

		String address1 = null;
		String address2 = null;
		String address3 = null;
		String address4 = null;
		String address5 = null;
		String address6 = null;

		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String time = dateFormat.format(date);

		/**
		 * 区域定义:北一区<1>,北二区<2>,北三区<3>,西北区<4>,西南区<5>,
		 *          华中区<6>,东一区<7>,东二区<8>,南区<9>
		 */
		if (type != null && !type.isEmpty() && queryType != null && !queryType.isEmpty()){

			StringBuffer stringBuffer = new StringBuffer();

			if (type.equals("1")){
				// 北一区
				address1 = "黑龙江";
				address2 = "吉林";
				address3 = "辽宁";
			}else if (type.equals("2")){
				// 北二区
				address1 = "内蒙古";
				address2 = "天津市";
				address3 = "北京市";
			}else if (type.equals("3")){
				// 北三区
				address1 = "河北";
				address2 = "山东";
				address3 = "山西";
			}else if (type.equals("4")){
				// 西北区
				address1 = "陕西";
				address2 = "宁夏";
				address3 = "甘肃";
				address4 = "青海";
				address5 = "新疆";
				address6 = "西藏";

				stringBuffer.append("OR u.postal_address LIKE '%"+ address4 +"%'\n" );
				stringBuffer.append("OR u.postal_address LIKE '%"+ address5 +"%'\n" );
				stringBuffer.append("OR u.postal_address LIKE '%"+ address6 +"%'\n");

			}else if (type.equals("5")){
				// 西南区
				address1 = "四川";
				address2 = "重庆市";
				address3 = "云南";
				address4 = "贵州";
				stringBuffer.append("OR u.postal_address LIKE '%"+ address4 +"%'\n");
			}else if (type.equals("6")){
				// 华中区
				address1 = "河南";
				address2 = "湖北";
				address3 = "湖南";
			}else if (type.equals("7")){
				// 东一区
				address1 = "安徽";
				address2 = "江苏";
				address3 = "上海市";
			}else if (type.equals("8")){
				// 东二区
				address1 = "浙江";
				address2 = "福建";
				address3 = "江西";
			}else if (type.equals("9")){
				// 南区
				address1 = "广东";
				address2 = "海南";
				address3 = "广西";
			}

			List<String> counts = null;


			if (queryType.equals("5")){
				// 区域今日新增人数
				String today_sql = "SELECT\n" +
						"\tCOUNT(1)\n" +
						"FROM\n" +
						"\tdxs_user_detail u\n" +
						"WHERE\n" +
						"\t'"+ time +"' <= u.create_time\n" +
						"AND (\n" +
						"\tu.postal_address LIKE '%"+ address1 +"%'\n" +
						"\tOR u.postal_address LIKE '%"+ address2 +"%'\n" +
						"\tOR u.postal_address LIKE '%"+ address3 +"%'\n" + stringBuffer.toString() +
						")";

				counts = this.systemService.findListbySql(today_sql);
			}else if (queryType.equals("0")){
				// 区域人数
				String area_num = "SELECT\n" +
						"\tCOUNT(1)\n" +
						"FROM\n" +
						"\tdxs_user_detail u\n" +
						"WHERE\n" +
						"\tu.postal_address LIKE '%"+ address1 +"%'\n" +
						"OR u.postal_address LIKE '%"+ address2 +"%'\n" +
						"OR u.postal_address LIKE '%"+ address3 +"%'\n" + stringBuffer.toString();

				counts = this.systemService.findListbySql(area_num);
			}

			if (counts != null && counts.size() > 0){
				replyDataMode.setData(counts.get(0));
				replyDataMode.setStatusCode("200");
				replyDataMode.setSuccess(true);
			}else {
				List list = new ArrayList();
				list.add("null");

				replyDataMode.setData(list.get(0));
				replyDataMode.setStatusCode("200");
				replyDataMode.setSuccess(true);
			}
		}

		return replyDataMode;
	}
}