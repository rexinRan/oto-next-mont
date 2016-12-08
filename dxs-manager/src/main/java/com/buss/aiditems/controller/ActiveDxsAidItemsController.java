package com.buss.aiditems.controller;

import com.buss.aiditems.service.DxsAidItemsServiceI;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Validator;

/**   
 * @Title: Controller
 * @Description: dxs_aid_items
 * @author dq
 * @date 2016-09-01 10:43:59
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/activedxsAidItemsController")
public class ActiveDxsAidItemsController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ActiveDxsAidItemsController.class);

	@Autowired
	private DxsAidItemsServiceI dxsAidItemsService;
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
	 * dxs_aid_items列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list( String aaId,HttpServletRequest request) {
	//大权添加修改
		ModelAndView model=new ModelAndView("com/buss/aiditems/activedxsAidItemsList");
		model.addObject("aaId",aaId);
		return model ;
	}


}
