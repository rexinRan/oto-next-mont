package com.buss.employedonlinespecial.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.buss.employedonlinespecial.entity.EmployedOnlineSpecialEntity;
import com.buss.employedonlinespecial.trans.form.EmployedOnlineSpecialSearchForm;
import com.buss.employedonlinespecial.trans.vo.EmployedOnlineSpecialVO;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buss.common.service.SysServiceI;

/**
 * @author lu
 *
 */
@Controller
@RequestMapping("/employedOnlineSpecial")
public class EmployedOnlineSpecialController {

    @Resource
    private SysServiceI sysService;

    @RequestMapping("/list.do")
    @ResponseBody
    public ReplyDataMode employedList(EmployedOnlineSpecialSearchForm searchForm, HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String,Object> orderMap = new HashMap<String,Object>();
        orderMap.put("emoloyedSort","desc");
        orderMap.put("createTime", "desc");
        orderMap.put("updateTime", "desc");
        criteriaQuery.setOrder(orderMap);

        List<EmployedOnlineSpecialEntity> employedarticles = this.sysService.list(criteriaQuery);
        List<EmployedOnlineSpecialVO> employedOnlineSpecialVOs = new ArrayList<EmployedOnlineSpecialVO>();

        for (EmployedOnlineSpecialEntity employedOnlineSpecialEntity:employedarticles) {
            EmployedOnlineSpecialVO employedOnlineSpecialVO = new EmployedOnlineSpecialVO();
            employedOnlineSpecialVO.copyEntity(employedOnlineSpecialEntity);
            employedOnlineSpecialVOs.add(employedOnlineSpecialVO);

        }
        replyDataMode.setData(employedOnlineSpecialVOs);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }
    @RequestMapping("/pageList.do")
    @ResponseBody
    public ReplyDataMode employedOnlineSpecialPageList(EmployedOnlineSpecialSearchForm searchForm, HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("sort","desc");
        orderMap.put("createTime", "desc");
        orderMap.put("updateTime", "desc");
        criteriaQuery.setOrder(orderMap);

        int pageNo = Integer.parseInt(searchForm.getPageNo());
        int pageSize = Integer.parseInt(searchForm.getPageSize());


        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
        List<EmployedOnlineSpecialEntity> employedarticles = mode.getResult();

        List<EmployedOnlineSpecialVO> employedOnlineSpecialVOs = new ArrayList<EmployedOnlineSpecialVO>();

        for (EmployedOnlineSpecialEntity employedOnlineSpecialEntity:employedarticles) {
            EmployedOnlineSpecialVO employedOnlineSpecialVO = new EmployedOnlineSpecialVO();
            employedOnlineSpecialVO.copyEntity(employedOnlineSpecialEntity);
            employedOnlineSpecialVOs.add(employedOnlineSpecialVO);

        }
        mode.setResult(employedOnlineSpecialVOs);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

    

    @RequestMapping("/employedOnlineSpecialById.do")
    @ResponseBody
    public ReplyDataMode employedOnlineSpecialById(EmployedOnlineSpecialSearchForm searchForm, HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        List<EmployedOnlineSpecialEntity> employedarticles = this.sysService.list(criteriaQuery);
        List<EmployedOnlineSpecialVO> employedOnlineSpecialVOs = new ArrayList<EmployedOnlineSpecialVO>();

        for (EmployedOnlineSpecialEntity employedOnlineSpecialEntity:employedarticles) {
            EmployedOnlineSpecialVO employedOnlineSpecialVO = new EmployedOnlineSpecialVO();
            employedOnlineSpecialVO.copyEntity(employedOnlineSpecialEntity);
            employedOnlineSpecialVOs.add(employedOnlineSpecialVO);

        }
        replyDataMode.setData(employedOnlineSpecialVOs);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }
}

