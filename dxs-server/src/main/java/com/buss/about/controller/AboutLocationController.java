package com.buss.about.controller;

import com.buss.about.entity.AboutLocationEntity;
import com.buss.about.trans.form.AboutLocationForm;
import com.buss.about.trans.vo.AboutLocationVO;
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
@RequestMapping("/aboutLocationController")
public class AboutLocationController {
    @Resource
    private SysServiceI sysService;

    @RequestMapping("/list.do")
    @ResponseBody
    public ReplyDataMode  DxsAboutLocationController (AboutLocationForm searchForm , HttpServletRequest request){
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
        List<AboutLocationEntity> userCompancys = mode.getResult();

        List<AboutLocationVO> aboutLocationVOs = new ArrayList<AboutLocationVO>();

        for (AboutLocationEntity aboutLocationEntity:userCompancys) {
            AboutLocationVO aboutLocationVO = new AboutLocationVO();
            aboutLocationVO.copyEntity(aboutLocationEntity);
            aboutLocationVOs.add(aboutLocationVO);

        }
        mode.setResult(aboutLocationVOs);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


    }
