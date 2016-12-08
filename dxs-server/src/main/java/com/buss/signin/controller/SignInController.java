package com.buss.signin.controller;

import com.alibaba.druid.util.StringUtils;
import com.buss.accountlogin.entity.AccountLogInEntity;
import com.buss.accountlogin.trans.from.AccountLogInFrom;
import com.buss.accountlogin.trans.vo.AccountLogInVo;
import com.buss.accountlogout.entity.AccountLogOutEntity;
import com.buss.accountlogout.trans.from.AccountLogOutFrom;
import com.buss.accountlogout.trans.vo.AccountLogOutVo;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;
import com.buss.signin.entity.DxsSignInEntity;
import com.buss.signin.trans.from.SignInFrom;
import com.buss.signin.trans.vo.SignInVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
 * Created by HongXinGuoJi-yzg on 2016/9/21.
 */
@Controller
@RequestMapping("/SignIn")
public class SignInController {

    @Resource
    private SysServiceI sysServiceI;


    /**
     * 签到获取鸿鑫豆明细
     * @param signInFrom
     * @param request
     * @return
     */
    @RequestMapping(value = "SignIndetail")
    @ResponseBody
    public ReplyDataMode SignIndetail(SignInFrom signInFrom, HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if (user != null){
            signInFrom.setIsDelete("0");
            signInFrom.setUserId(user.getId());
            CriteriaQuery criteriaQuery = signInFrom.getCriteriaQuery();
            criteriaQuery.addOrder("createTime","desc");

            if (!StringUtils.isEmpty(signInFrom.getPageNo()) && !StringUtils.isEmpty(signInFrom.getPageSize())){
                Integer pageNo = Integer.parseInt(signInFrom.getPageNo());
                Integer pageSize = Integer.parseInt(signInFrom.getPageSize());

                PageMode mode = this.sysServiceI.list4page(criteriaQuery,pageNo,pageSize);
                List<DxsSignInEntity> signInEntityList = mode.getResult();
                List<SignInVo> signInVos = new ArrayList<SignInVo>();

                if (signInEntityList != null && signInEntityList.size() > 0){
                    for (DxsSignInEntity sie:signInEntityList){
                        SignInVo signInVo = new SignInVo();
                        signInVo.copyEntity(sie);
                        signInVos.add(signInVo);
                    }
                }

                mode.setResult(signInVos);
                replyDataMode.setData(mode);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);
            }else {

                replyDataMode.setStatusCode("请设置分页!");
                replyDataMode.setSuccess(false);
            }
        }else {

            replyDataMode.setStatusCode("请您登陆!");
            replyDataMode.setSuccess(false);
        }
        return replyDataMode;
    }


    /**
     * 产品购买获鸿鑫豆明细
     * @param accountLogInFrom
     * @param request
     * @return
     */
    @RequestMapping(value = "purchaseHxb")
    @ResponseBody
    public ReplyDataMode purchaseHxb(AccountLogInFrom accountLogInFrom, HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();
        accountLogInFrom.setIsDelete("0");

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if (user != null){
            accountLogInFrom.setUserId(user.getId());
            CriteriaQuery criteriaQuery = accountLogInFrom.getCriteriaQuery();
            criteriaQuery.addOrder("createTime","desc");

            if (!StringUtils.isEmpty(accountLogInFrom.getPageNo()) && !StringUtils.isEmpty(accountLogInFrom.getPageSize())) {
                Integer pageNo = Integer.parseInt(accountLogInFrom.getPageNo());
                Integer pageSize = Integer.parseInt(accountLogInFrom.getPageSize());

                PageMode mode = this.sysServiceI.list4page(criteriaQuery,pageNo,pageSize);
                List<AccountLogInEntity> accountLogInEntityList = mode.getResult();
                List<Object> accountLogInVos = new ArrayList<Object>();

                // 鸿鑫币总和
                /*int totail = 0;
                Map map = new HashMap();*/
                if (accountLogInEntityList != null && accountLogInEntityList.size() > 0){
                    for (AccountLogInEntity alie:accountLogInEntityList){
                        AccountLogInVo accountLogInVo = new AccountLogInVo();
                        accountLogInVo.copyEntity(alie);
                        accountLogInVos.add(accountLogInVo);
                        /*totail += alie.getAccountIn();*/
                    }
                }

                /*map.put("totail",totail);
                accountLogInVos.add(map);*/
                mode.setResult(accountLogInVos);
                replyDataMode.setData(mode);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);
             }else {

                replyDataMode.setStatusCode("请设置分页!");
                replyDataMode.setSuccess(false);
            }
        }else {

            replyDataMode.setStatusCode("请您登陆!");
            replyDataMode.setSuccess(false);
        }

        return replyDataMode;
    }


    /**
     * 消费支出鸿鑫豆明细
     * @param accountLogOutFrom
     * @param request
     * @return
     */
    @RequestMapping(value = "hxbConsume")
    @ResponseBody
    public ReplyDataMode hxbConsume(AccountLogOutFrom accountLogOutFrom, HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();
        accountLogOutFrom.setIsDelete("0");

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if (user != null){
            accountLogOutFrom.setUserId(user.getId());
            CriteriaQuery criteriaQuery = accountLogOutFrom.getCriteriaQuery();
            criteriaQuery.addOrder("createTime","desc");

            if (!StringUtils.isEmpty(accountLogOutFrom.getPageNo()) && !StringUtils.isEmpty(accountLogOutFrom.getPageSize())) {
                Integer pageNo = Integer.parseInt(accountLogOutFrom.getPageNo());
                Integer pageSize = Integer.parseInt(accountLogOutFrom.getPageSize());

                PageMode mode = this.sysServiceI.list4page(criteriaQuery,pageNo,pageSize);
                List<AccountLogOutEntity> accountLogOutEntityList = mode.getResult();
                List<Object> list = new ArrayList<Object>();

                /*// 鸿鑫币总和
                int totail = 0;
                Map map = new HashMap();*/
                if (accountLogOutEntityList != null && accountLogOutEntityList.size() > 0){
                    for (AccountLogOutEntity aloe:accountLogOutEntityList){
                        AccountLogOutVo accountLogInVo = new AccountLogOutVo();
                        accountLogInVo.copyEntity(aloe);
                        list.add(accountLogInVo);
                        /*totail += aloe.getAccountOut();*/
                    }
                }

                /*map.put("totail",totail);
                list.add(map);*/
                mode.setResult(list);
                replyDataMode.setData(mode);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);
            }else {

                replyDataMode.setStatusCode("请设置分页!");
                replyDataMode.setSuccess(false);
            }
        }else {
            replyDataMode.setStatusCode("请您登陆!");
            replyDataMode.setSuccess(false);
        }

        return replyDataMode;
    }

}
