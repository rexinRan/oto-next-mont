package com.buss.activesroadshowapply.controller;


import com.buss.activesroadshowapply.entity.ActivesRoadshowApplyEntity;
import com.buss.activesroadshowapply.trans.from.ActivesRoadshowApplyFrom;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;
import org.apache.http.impl.execchain.TunnelRefusedException;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.ReplyDataMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @Title: Controller
 * @Description: dxs_actives_roadshow_apply
 * @author onlineGenerator
 * @date 2016-08-18 13:36:17
 * @version V1.0   
 *
 */
@Controller
@RequestMapping(value = "ActivesRoadshowApplyController")
public class ActivesRoadshowApplyController{

    @Autowired
    private SysServiceI sysServiceI;

    /**
     * 企业申请创业路演
     * @param activesRoadshowApplyFrom 活动中心->创业路演
     * @param request
     * @return
     */
    @RequestMapping("aplication")
    @ResponseBody
    public ReplyDataMode aplication(ActivesRoadshowApplyFrom activesRoadshowApplyFrom, HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 获取当前登录用户        注:需判断是否是该平台中企业用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if (user != null){
            activesRoadshowApplyFrom.setIsDelete("0");
            activesRoadshowApplyFrom.setUserId(user.getId());
            // 默认结果为0
            activesRoadshowApplyFrom.setResult("0");
            ActivesRoadshowApplyEntity activesRoadshowApplyEntity = (ActivesRoadshowApplyEntity) activesRoadshowApplyFrom.toEntity();
            activesRoadshowApplyEntity.setCreateTime(new Date());
            try {
                this.sysServiceI.saveOrUpdate(activesRoadshowApplyEntity);
                replyDataMode.setStatusCode("申请完成!");
                replyDataMode.setSuccess(true);
            }catch (Exception e){
                replyDataMode.setStatusCode("申请完成!");
                replyDataMode.setSuccess(false);
            }
        }else {
            replyDataMode.setStatusCode("请您登陆!");
            replyDataMode.setSuccess(false);
        }

        return replyDataMode;
    }
}
