package com.buss.about.controller;

import com.buss.about.entity.AboutEntity;
import com.buss.about.trans.form.AboutForm;
import com.buss.about.trans.vo.AboutVO;
import com.buss.common.service.SysServiceI;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping("/aboutController")
public class AboutController {
    @Resource
    private SysServiceI sysService;

    @RequestMapping("/list.do")
    @ResponseBody
    public ReplyDataMode  DxsAboutController (AboutForm searchForm , HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String,Object> orderMap = new HashMap<String,Object>();
        orderMap.put("createTime", "desc");
        orderMap.put("updateTime", "desc");
        criteriaQuery.setOrder(orderMap);

        List<AboutEntity> news = this.sysService.list(criteriaQuery);
        List<AboutVO> aboutVOs= new ArrayList<AboutVO>();

        for (AboutEntity aboutEntity:news) {
            AboutVO aboutVO = new AboutVO();
            aboutVO.copyEntity(aboutEntity);
            aboutVOs.add(aboutVO);

        }
        replyDataMode.setData(aboutVOs);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

    @RequestMapping("/aboutById.do")
    @ResponseBody
    public ReplyDataMode newsById(AboutForm searchForm, HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        List<AboutEntity> news = this.sysService.list(criteriaQuery);
        List<AboutVO> aboutVOs = new ArrayList<AboutVO>();

        for (AboutEntity aboutEntity:news) {
            AboutVO aboutVO = new AboutVO();
            aboutVO.copyEntity(aboutEntity);
            aboutVOs.add(aboutVO);

        }
        replyDataMode.setData(aboutVOs);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }



    }
