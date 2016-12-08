package com.buss.video;

import org.jeecgframework.core.common.controller.BaseController;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**   
 * @Title: Controller
 * @Description: dxs_quiz
 * @author onlineGenerator
 * @date 2016-06-02 10:41:13
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/video")
public class VideoController extends BaseController {



	/**
	 * dxs_quiz列表 页面跳转
	 * 
	 * @return
	 */
	@RequestMapping(params = "list")
	public ModelAndView list(HttpServletRequest request) {
		return new ModelAndView("com/buss/video/videoList");
	}


}
