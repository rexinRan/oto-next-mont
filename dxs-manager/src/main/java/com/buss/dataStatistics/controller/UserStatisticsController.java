package com.buss.dataStatistics.controller;

import com.buss.user.entity.DxsUserEntity;
import org.jeecgframework.web.system.service.SystemService;
import org.jweb.core.bean.ReplyDataMode;
import org.jeecgframework.core.common.controller.BaseController;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by HongXinGuoJi-yzg on 2016/12/7.
 */
@Controller
@RequestMapping("/dxsUserStatisticsController")
public class UserStatisticsController extends BaseController{


    @Autowired
    private SystemService systemService;


    /**
     * dxs_actives列表 页面跳转
     *
     * @return
     */
    @RequestMapping(params = "list")
    public ModelAndView list(HttpServletRequest request) {

        return new ModelAndView("com/buss/dataStatistics/dxsActivesList");
    }


    /**
     * 查询平台的所有用户
     * @return
     */
    @RequestMapping(params = "selectQuery")
    @ResponseBody
    public ReplyDataMode selectQuery(){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        DxsUserEntity dxsUserEntity = this.systemService.get(DxsUserEntity.class,"2524AAB027630B4AA9065453BC8E1D30");
        List<DxsUserEntity> userEntityList = this.systemService.findByProperty(DxsUserEntity.class,"isdelete",0);

        replyDataMode.setData(userEntityList);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);
        return replyDataMode;
    }



    @RequestMapping(value = "")
    public ReplyDataMode queryAllregisterUser(){
        ReplyDataMode replyDataMode = new ReplyDataMode();


        return replyDataMode;
    }
}
