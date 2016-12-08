package com.buss.dist.controller;

import com.alibaba.fastjson.JSON;
import com.buss.common.service.SysServiceI;
import com.buss.dist.entity.DxsDistCityEntity;
import com.buss.dist.trans.form.DistCityForm;
import com.buss.dist.trans.vo.DistCityVo;
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
 *
 * @Title: Controller
 * @Description: dxs_dist_city
 * @author dq
 * @date 2016-07-20 16:13:58
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/dxsDistCityController")
public class DxsDistCityController {
    @Resource
    private SysServiceI sysService;

    @RequestMapping("provinceLinkageCity")
    @ResponseBody
    public ReplyDataMode provincesCitiesLinkage(DistCityForm SearchForm, HttpServletRequest request, @RequestParam(required = false, value = "callback") String callback, HttpServletResponse response){
    ReplyDataMode replyDataMode = new ReplyDataMode();
    if (SearchForm.getProvinceid()!= null){
        CriteriaQuery criteriaQuery = SearchForm.getCriteriaQuery();
        List<DxsDistCityEntity> distCityEntityList = this.sysService.list(criteriaQuery);
        List<DistCityVo> distCityVos = new ArrayList<>();
        for (DxsDistCityEntity dce:distCityEntityList){
            DistCityVo distCityVo = new DistCityVo();
            distCityVo.copyEntity(dce);
            distCityVos.add(distCityVo);
        }
        replyDataMode.setData(distCityVos);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);
    }
//    return replyDataMode;
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
