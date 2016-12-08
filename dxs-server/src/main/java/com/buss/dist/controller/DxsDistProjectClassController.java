package com.buss.dist.controller;

import com.alibaba.fastjson.JSON;
import com.buss.common.service.SysServiceI;
import com.buss.dist.entity.DxsDistProjectClassEntity;
import com.buss.dist.trans.vo.DistProjectClassVo;
import org.jweb.core.bean.ReplyDataMode;
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
 * @Description: dxs_dist_project_class
 * @author onlineGenerator
 * @date 2016-07-20 17:46:06
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/projectClassController")
public class DxsDistProjectClassController {
    @Resource
    private SysServiceI sysService;

    @RequestMapping("list.do")
    @ResponseBody
    public ReplyDataMode distProvince(@RequestParam(required = false, value = "callback") String callback, HttpServletResponse response){
        ReplyDataMode replyDataMode =new ReplyDataMode();

        List<DxsDistProjectClassEntity> provinceEntityList =this.sysService.getList(DxsDistProjectClassEntity.class);
        List<DistProjectClassVo> projectClassVos=new ArrayList<DistProjectClassVo>();
        if(provinceEntityList!=null&provinceEntityList.size()>0) {
            for (DxsDistProjectClassEntity provinceEntity : provinceEntityList) {
                DistProjectClassVo projectClassVo = new DistProjectClassVo();
                projectClassVo.copyEntity(provinceEntity);
                projectClassVos.add(projectClassVo);
            }
        }
        replyDataMode.setData(projectClassVos);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);
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
