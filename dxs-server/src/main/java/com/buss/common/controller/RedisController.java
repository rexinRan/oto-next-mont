package com.buss.common.controller;

import com.buss.common.redis.RedisClient;
import com.buss.common.redis.cache.CacheKey;
import com.buss.common.redis.service.impl.RedisServiceImpl;
import org.jweb.core.bean.RedisBean;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
//@RequestMapping("/redis")
public class RedisController {

	@Resource
	private RedisClient redisClient;
	@Resource
	private RedisServiceImpl redisService;

	/**
	 * 页面跳转
	 */
	@RequestMapping(value = "/redis.do")
	public ModelAndView list(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("page/redis");
		ReplyDataMode j = new ReplyDataMode();
		j = getkey(request);
		mav.addObject("result", j);
		return mav;
	}

	@RequestMapping({ "/redis/getkey.do" })
	@ResponseBody
	public ReplyDataMode getkey(HttpServletRequest request) {
		ReplyDataMode j = new ReplyDataMode();
		List<Map> mapList = new ArrayList<Map>();

		// 获取前台传入内容
		String key = request.getParameter("key");
		if (StringUtil.isEmpty(key)) {
			// key为空，则列出所有key
			Set<String> set = (Set<String>) redisClient.Setkeys("*");
			int sid = 0;
			for (String str : set) {
				sid++;
				Map map = new HashMap();
				map.put("sid",sid);
				map.put("key",str);
				mapList.add(map);
			}
//			request.setAttribute("mapList", mapList);
			j.setData(mapList);
			j.setStatusCode("ALL KEY");
			j.setSuccess(true);
		}else{
			if (redisClient.containsKey(key)) {
				Map map = new HashMap();
				map.put("sid","1");
				map.put("key",key);
				mapList.add(map);
				j.setData(mapList);
				j.setStatusCode("KEY["+key+"] IS EXIST");
				j.setSuccess(true);
			}else {
				j.setData(null);
				j.setStatusCode("KEY["+key+"] IS NOT EXIST");
				j.setSuccess(false);
			}
		}
		return j;
	}

	/**
	 * 获取缓存值
	 * @param request
	 * @return
	 */
	@RequestMapping({ "/redis/getvalue.do" })
	@ResponseBody
	public ReplyDataMode getvalue(HttpServletRequest request) {
		ReplyDataMode j = new ReplyDataMode();
		// 获取前台传入内容
		String key = request.getParameter("key");

		if (StringUtil.isEmpty(key)) {
			// key为空，返回错误
			j.setStatusCode("ERROR");
			j.setSuccess(false);
		}else{
			if (redisClient.containsKey(key)) {
				j.setStatusCode("ExpiredTimes["+key+"]:" + redisClient.getExpire(key));
				j.setData(redisClient.get(key));
				j.setSuccess(true);
			}else {
				j.setData(null);
				j.setStatusCode("KEY["+key+"] IS NOT EXIST");
				j.setSuccess(false);
			}
		}
		return j;
	}

	/**
	 * 添加缓存
	 * @param request
	 * @return
	 */
	@RequestMapping({ "/redis/add.do" })
	@ResponseBody
	public ReplyDataMode add(HttpServletRequest request) {

		String key = CacheKey.TEST;
		Object value = "{\"success\":true,\"statusCode\":\"200\",\"data\":{\"pageCount\":5,\"pageNo\":1,\"pageSize\":2,\"total\":8,\"result\":[{\"name\":\"测试\"}]},\"attribute\":null}";
		redisClient.put(key, value);

		ReplyDataMode j = new ReplyDataMode();
		j.setData(key);
		j.setSuccess(true);
		j.setStatusCode("KEY["+key+"] ADD SUCCESS");
		return j;
	}

	/**
	 * 删除KEY
	 * @param request
	 * @return
	 */
	@RequestMapping({ "/redis/delete.do" })
	@ResponseBody
	public ReplyDataMode delete(HttpServletRequest request) {
		ReplyDataMode j = new ReplyDataMode();
		// 获取前台传入内容
		String key = request.getParameter("key");
		if (redisClient.containsKey(key)) {
			redisClient.remove(key);
			j.setData(1);
			j.setStatusCode("KEY["+key+"] REMOVE SUCCESS");
			j.setSuccess(true);
		}else {
			j.setData(0);
			j.setStatusCode("KEY["+key+"] IS NOT EXIST");
			j.setSuccess(false);
		}
		return j;
	}

	/**
	 * 清空所有KEY
	 * @param request
	 * @return
	 */
	@RequestMapping({ "/redis/flushDB.do" })
	@ResponseBody
	public ReplyDataMode flushDB(HttpServletRequest request) {
		Object obj = redisService.flushDB();
		ReplyDataMode j = new ReplyDataMode();
		j.setData(obj);
		j.setSuccess(true);
		j.setStatusCode("KEY flushDB SUCCESS");
		return j;
	}


}
