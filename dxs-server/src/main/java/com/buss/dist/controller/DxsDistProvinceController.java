package com.buss.dist.controller;

import com.alibaba.fastjson.JSON;
import com.buss.common.service.SysServiceI;
import com.buss.dist.entity.DxsDistProvinceEntity;
import com.buss.dist.trans.vo.DistProvinceVo;
import com.fasterxml.jackson.databind.util.JSONPObject;
import org.jweb.core.bean.ReplyDataMode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**   
 * @Title: Controller
 * @Description: dxs_dist_province
 * @author dq
 * @date 2016-07-20 13:19:21
 * @version V1.0   
 *
 */

@Controller
@RequestMapping("/dxsDistProvinceController")
public class DxsDistProvinceController {
	@Resource
	private SysServiceI sysService;

	@RequestMapping("list.do")
	@ResponseBody
	public ReplyDataMode distProvince(@RequestParam(required = false, value = "callback") String callback, HttpServletResponse response) {
		ReplyDataMode replyDataMode =new ReplyDataMode();

		List<DxsDistProvinceEntity> provinceEntityList =this.sysService.getList(DxsDistProvinceEntity.class);
		List<DistProvinceVo> provinceVOs=new ArrayList<DistProvinceVo>();
		if(provinceEntityList!=null&provinceEntityList.size()>0) {
			for (DxsDistProvinceEntity provinceEntity : provinceEntityList) {
				DistProvinceVo provinceVO = new DistProvinceVo();
				provinceVO.copyEntity(provinceEntity);
				provinceVOs.add(provinceVO);
			}
		}
		replyDataMode.setData(provinceVOs);
		replyDataMode.setStatusCode("200");
		replyDataMode.setSuccess(true);
		if (callback == null || "".equals(callback)) {
			return replyDataMode; // 非 JSONP 请求，返回正常的 JOSN 数据
		} else {
			try { String res = JSON.toJSONString(replyDataMode);
				response.getWriter().write(callback + "(" + res + ")");
				response.getWriter().flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null; // JSONP 请求，返回 JOSNP 数据
		}
	}
	@RequestMapping(value = "/test")
	@ResponseBody
	public Object test(@RequestParam(required = false, value = "callback") String callback, HttpServletResponse response) {
		// 程序需要返回的数据
		// Map<String,String> result = new HashMap<>();
		// result.put("result","返回的结果");
//		ReplyDataMode replyDataMode =new ReplyDataMode();
//
//		List<DxsDistProvinceEntity> provinceEntityList =this.sysService.getList(DxsDistProvinceEntity.class);
//		List<DistProvinceVo> provinceVOs=new ArrayList<DistProvinceVo>();
//		if(provinceEntityList!=null&provinceEntityList.size()>0) {
//			for (DxsDistProvinceEntity provinceEntity : provinceEntityList) {
//				DistProvinceVo provinceVO = new DistProvinceVo();
//				provinceVO.copyEntity(provinceEntity);
//				provinceVOs.add(provinceVO);
//			}
//		}
//		replyDataMode.setData(provinceVOs);
//		replyDataMode.setStatusCode("200");
//		replyDataMode.setSuccess(true);
//		if (callback == null || "".equals(callback)) {
//		return replyDataMode; // 非 JSONP 请求，返回正常的 JOSN 数据
//	} else {
//			try { String res = JSON.toJSONString(replyDataMode);
//				response.getWriter().write(callback + "(" + res + ")");
//				response.getWriter().flush();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
			return null; // JSONP 请求，返回 JOSNP 数据
//	}
}
}
//