package com.buss.common.controller;

import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Scope("prototype")
@Controller
@RequestMapping("/test")
public class MyTestController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(MyTestController.class);

	@Autowired
	private SystemService systemService;

	/**
	 * dxs_role列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "test")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("test/test");
	}

}
