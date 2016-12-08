package com.buss.dist.controller;


import com.alibaba.fastjson.JSON;
import com.buss.common.service.SysServiceI;
import com.buss.dist.entity.DxsDistSchoolEntity;
import com.buss.dist.trans.form.DistSchoolForm;
import com.buss.dist.trans.vo.DistSchoolVo;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Title: Controller
 * @Description: dxs_dist_school
 * @author onlineGenerator
 * @date 2016-07-20 17:16:49
 * @version V1.0   
 *
 */
@Scope("prototype")
@Controller
@RequestMapping("/dxsDistSchoolController")
public class DxsDistSchoolController {
    @Resource
    private SysServiceI sysService;

    @RequestMapping("collegeLinkageSchool")
    @ResponseBody
    public ReplyDataMode collegeLinkageSchool(DistSchoolForm SearchForm, @RequestParam(required = false, value = "callback") String callback, HttpServletResponse response){
        ReplyDataMode replyDataMode =new ReplyDataMode();
        if (SearchForm.getCollegeid()!= null){
            CriteriaQuery criteriaQuery = SearchForm.getCriteriaQuery();
            List<DxsDistSchoolEntity> distCityEntityList = this.sysService.list(criteriaQuery);
            List<DistSchoolVo> distSchoolVos = new ArrayList<>();
            for (DxsDistSchoolEntity dce:distCityEntityList){
                DistSchoolVo distSchoolVo = new DistSchoolVo();
                distSchoolVo.copyEntity(dce);
                distSchoolVos.add(distSchoolVo);
            }
            replyDataMode.setData(distSchoolVos);
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
