package com.buss.foundproject.controller;

import com.buss.common.service.SysServiceI;
import org.jweb.core.bean.ReplyDataMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * 个人中心创业基金基地项目查询
 * Created by Administrator on 2016/6/22.
 */
@Controller
@RequestMapping("/fundProject")
public class EntrepreneurshipProjectFundController {

    @Autowired
    private SysServiceI sysServiceI;

    @RequestMapping("/entrepreneurshipProjectFund")
    @ResponseBody
    public ReplyDataMode entrepreneurshipProjectFund(HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();


        return null;
    }
}
