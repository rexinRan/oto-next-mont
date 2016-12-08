package com.buss.dist.controller;


import com.alibaba.fastjson.JSON;
import com.buss.common.service.SysServiceI;
import com.buss.dist.entity.DxsDistAreaEntity;
import com.buss.dist.trans.form.DistAreaForm;
import com.buss.dist.trans.vo.DistAreaVo;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
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
 * @Description: dxs_dist_area
 * @author dq
 * @date 2016-07-20 16:43:24
 * @version V1.0   
 */
@Controller
@RequestMapping("/dxsDistAreaController")
public class DxsDistAreaController {
    @Resource
    private SysServiceI sysService;

    @RequestMapping("CityLinkageArea")
    @ResponseBody
    public ReplyDataMode provinceLinkageCityLinkageArea(DistAreaForm SearchForm, HttpServletRequest request,@RequestParam(required = false, value = "callback") String callback, HttpServletResponse response) {
        ReplyDataMode replyDataMode = new ReplyDataMode();
        if (SearchForm.getCityid()!= null){
            CriteriaQuery criteriaQuery = SearchForm.getCriteriaQuery();
            List<DxsDistAreaEntity> distCityEntityList = this.sysService.list(criteriaQuery);
            List<DistAreaVo> distAreaVos = new ArrayList<>();
            for (DxsDistAreaEntity dce:distCityEntityList){
                DistAreaVo distAreaVo = new DistAreaVo();
                distAreaVo.copyEntity(dce);
                distAreaVos.add(distAreaVo);
            }
            replyDataMode.setData(distAreaVos);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);

        }
//        return replyDataMode;
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
}