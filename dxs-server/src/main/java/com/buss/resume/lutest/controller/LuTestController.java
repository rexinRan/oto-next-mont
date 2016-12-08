package com.buss.resume.lutest.controller;


import com.buss.common.service.SysServiceI;

import com.buss.resume.lutest.entity.LuTestEntity;
import com.buss.resume.lutest.trans.form.LuTestSearchForm;
import com.buss.resume.lutest.trans.vo.LuTestVO;

import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * @author lu
 *
 */
@Controller
@RequestMapping("/zhazha")
public class LuTestController {

    @Resource
    private SysServiceI sysService;


    @RequestMapping("/select.do")
    @ResponseBody
    public ReplyDataMode select(LuTestSearchForm searchForm, HttpServletRequest request){


        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        int pageNo = Integer.parseInt(searchForm.getPageNo());
        int pageSize = Integer.parseInt(searchForm.getPageSize());

        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);

        List<LuTestEntity> luTest = mode.getResult();
        List<LuTestVO> luTestVOs = new ArrayList<LuTestVO>();

        for (LuTestEntity luTestEntity:luTest) {
            LuTestVO luTestVO = new LuTestVO();
            luTestVO.copyEntity(luTestEntity);
            luTestVOs.add(luTestVO);

        }

        replyDataMode.setData(mode);

        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


    @RequestMapping("/save.do")
    @ResponseBody
    public ReplyDataMode save(LuTestSearchForm searchForm, HttpServletRequest request){

        ReplyDataMode replyDataMode = new ReplyDataMode();
        String result = "操作成功";

        LuTestEntity luTestEntity = (LuTestEntity) searchForm.toEntity();

         try {

               this.sysService.saveOrUpdate(luTestEntity);
         }catch (Exception e){
             result = "操作失败";

         }

        replyDataMode.setData(result);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;

    }

    @RequestMapping("/update.do")
    @ResponseBody
    public ReplyDataMode update(LuTestSearchForm searchForm, HttpServletRequest request){

        ReplyDataMode replyDataMode = new ReplyDataMode();
        String result = "操作成功";

        LuTestEntity luTestEntity = new LuTestEntity();
        luTestEntity.setId(searchForm.getId());
        luTestEntity.setContent(searchForm.getContent());
        if(searchForm.getTitle()!=null){
            luTestEntity.setTitle(searchForm.getTitle());
        }

        try {

            this.sysService.saveOrUpdate(luTestEntity);
        }catch (Exception e){
            result = "操作失败";

        }

        replyDataMode.setData(result);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;

    }

    @RequestMapping("/delete.do")
    @ResponseBody
    public ReplyDataMode delete(LuTestSearchForm searchForm, HttpServletRequest request){

        ReplyDataMode replyDataMode = new ReplyDataMode();
        String result = "操作成功";

        LuTestEntity luTestEntity = new LuTestEntity();
        luTestEntity.setId(searchForm.getId());

        try {

            this.sysService.delete(luTestEntity);
        }catch (Exception e){
            result = "操作失败";

        }

        replyDataMode.setData(result);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;

    }



}