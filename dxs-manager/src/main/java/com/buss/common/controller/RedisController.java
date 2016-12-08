package com.buss.common.controller;

import com.buss.common.redis.RedisClient;
import com.buss.common.redis.cache.CacheKey;
import org.apache.log4j.Logger;
import org.jeecgframework.core.common.controller.BaseController;
import org.jeecgframework.web.system.service.SystemService;
import org.jweb.core.bean.ReplyDataMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Scope("prototype")
@Controller
@RequestMapping("/r")
public class RedisController extends BaseController {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(RedisController.class);

	@Autowired
	private SystemService systemService;
	@Resource
	private RedisClient redisClient;

	/**
	 * 添加缓存
	 * @param request
	 * r.do?add
	 */
	@RequestMapping(params = "add")
	@ResponseBody
	public ReplyDataMode add(HttpServletRequest request) {

		String key = CacheKey.TEST;
		Object value = "{\"success\":true,\"statusCode\":\"200\",\"data\":{\"pageCount\":5,\"pageNo\":1,\"pageSize\":2,\"total\":8,\"result\":[{\"name\":\"测试\"}]},\"attribute\":null}";
		redisClient.put(key, value);

		ReplyDataMode j = new ReplyDataMode();
		j.setData(key);
		j.setSuccess(true);
		j.setStatusCode("redis add success");
		return j;
	}

	/**
	 * 删除缓存
	 * @param request
	 * r.do?remove
	 */
	@RequestMapping(params = "remove")
	@ResponseBody
	public ReplyDataMode remove(HttpServletRequest request) {
		String key = CacheKey.TEST;
		redisClient.remove(key);

		ReplyDataMode j = new ReplyDataMode();
		j.setData(key);
		j.setSuccess(true);
		j.setStatusCode("redis remove success");
		return j;
	}


}
