package com.buss.about.controller;

import com.buss.about.entity.AboutCenterEntity;
import com.buss.about.trans.form.AboutCenterForm;
import com.buss.about.trans.vo.AboutCenterVO;
import com.buss.common.service.SysServiceI;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: Controller
 * @Description: dxs_about
 * @author dq
 * @date 2016-07-16 13:29:33
 * @version V1.0
 *
 */
@Controller
@RequestMapping("/aboutCenterController")
public class AboutCenterController {
    @Resource
    private SysServiceI sysService;

    @RequestMapping("/list.do")
    @ResponseBody
    public ReplyDataMode DxsAboutCenterController (AboutCenterForm searchForm , HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String,Object> orderMap = new HashMap<String,Object>();
        orderMap.put("sort","desc");
        orderMap.put("createTime", "desc");
        orderMap.put("updateTime", "desc");
        criteriaQuery.setOrder(orderMap);

        int pageNo = Integer.parseInt(searchForm.getPageNo());
        int pageSize = Integer.parseInt(searchForm.getPageSize());

        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
        List<AboutCenterEntity> userCompancys = mode.getResult();

        List<AboutCenterVO> aboutCenterVOs = new ArrayList<AboutCenterVO>();

        for (AboutCenterEntity aboutCenterEntity:userCompancys) {
            AboutCenterVO aboutCenterVO = new AboutCenterVO();
            aboutCenterVO.copyEntity(aboutCenterEntity);
            aboutCenterVOs.add(aboutCenterVO);

        }
        mode.setResult(aboutCenterVOs);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

}
