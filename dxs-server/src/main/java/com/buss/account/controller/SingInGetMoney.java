package com.buss.account.controller;

import com.buss.account.entity.DxsAccountEntity;
import com.buss.account.service.HongXinMoneyService;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.model.json.AjaxJson;
import com.buss.common.service.SysServiceI;
import com.buss.common.service.impl.FileService;
import com.buss.signin.entity.DxsSignInEntity;
import com.buss.usercompancy.entity.UserCompancyEntity;
import com.buss.userdetail.entity.UserDetailEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.jweb.core.util.MyBeanUtils;
import org.jweb.core.web.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/24.
 */
@Controller
@RequestMapping("/signIn")
public class SingInGetMoney {

    @Autowired
    private SysServiceI sysServiceI;

    @Autowired
    private HongXinMoneyService hongXinMoneyService;

    /**
     * 签到(赚鸿鑫币)
     */
    @RequestMapping("/signDay")
    @ResponseBody
    public AjaxJson signDay(DxsSignInEntity signInEntity, HttpServletRequest request){
        AjaxJson ajax = new AjaxJson();
        String message1 = "操作成功!";
        String message2 = "";
        String message3 = "";
        try {
            // 或得登录用户
            Subject currentUser = SecurityUtils.getSubject();
            AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
//         = new DxsSignInEntity();
            if (user == null) {
                throw new Exception("未登录");
            }
            signInEntity.setUserId(user.getId());
//        try {
//            this.sysServiceI.findByExample();
//        }
            CriteriaQuery cq = new CriteriaQuery(DxsSignInEntity.class);
            //查询条件组装器
            org.jweb.core.query.hibernate.utils.HqlGenerateUtil.installHql(cq, signInEntity, request.getParameterMap());
            try{
                //自定义追加查询条件
                cq.addOrder("signTime",  "desc");

            }catch (Exception e) {
                throw new BusinessException(e.getMessage());
            }
            cq.add();
            List list = this.sysServiceI.getListByCriteriaQuery(cq, false);
            Date serdate = new Date();
            if (list != null && list.size()>0) {
                // 获取最后一次签到实例,得到其签到日期
                DxsSignInEntity last = (DxsSignInEntity) list.get(0);
                Date lastSD = last.getSignTime();
                System.out.println("天数" + this.daysBetween(lastSD, new Date()));
                if (this.daysBetween(lastSD, new Date()) < 1){
                    // 当天签到
                    System.out.println("当天签到");
                    signInEntity = (DxsSignInEntity) list.get(0);
                    signInEntity.setIsDelete(0);
                    signInEntity.setUpdateTime(serdate);
                    message1 = "您已签到,请不要重复签到!";
                    message2 = "";
                    if (signInEntity.getSignDay()*5 <=50) {
                        message3 = "次日签到将获得鸿鑫币" + ((signInEntity.getSignDay()+1)*5>=50?50:(signInEntity.getSignDay()+1)*5) + "枚";
                    } else {
                        message3 = "次日签到将获得鸿鑫币" + ((signInEntity.getSignDay()+1)*5>=50?50:(signInEntity.getSignDay()+1)*5) + "枚";
                    }
                    // 不增加鸿鑫币
                } else if (this.daysBetween(lastSD, new Date()) > 1){
                    // 断签到
                    System.out.println("断签到");
                    // 新的初始化的bean
                    System.out.println("新的初始化的bean");
                    signInEntity.setSignDay(1);
                    signInEntity.setUpdateTime(serdate);
                    signInEntity.setCreateTime(serdate);
                    signInEntity.setSignTime(serdate);
                    signInEntity.setUserId(user.getId());
                    signInEntity.setSignType("0");
                    message1 = "很可惜,您已中断签到,重新开始签到1天";
                    message2 = "";

                    // 签到加鸿鑫币
                    if (signInEntity.getSignDay()*5 <=50) {
                        this.hongXinMoneyService.comeMoney(user.getId(), signInEntity.getSignDay()*5+"");
                        message3 = "次日签到将获得鸿鑫币" + ((signInEntity.getSignDay()+1)*5>=50?50:(signInEntity.getSignDay()+1)*5) + "枚";
                    } else {
                        this.hongXinMoneyService.comeMoney(user.getId(), 50 + "");
                        message3 = "次日签到将获得鸿鑫币" + ((signInEntity.getSignDay()+1)*5>=50?50:(signInEntity.getSignDay()+1)*5) + "枚";
                    }
                } else {
                    // 标准签到
                    System.out.println("连续签到");
                    // 新的初始化的bean
                    System.out.println("新的初始化的bean");
                    signInEntity.setSignDay(((DxsSignInEntity) list.get(0)).getSignDay()+1);
                    signInEntity.setUpdateTime(serdate);
                    signInEntity.setCreateTime(serdate);
                    signInEntity.setSignTime(serdate);
                    signInEntity.setUserId(user.getId());
                    signInEntity.setSignType("0");
                    message1 = "您已连续签到" + signInEntity.getSignDay() + "天!";
                    message2 = "";

                    // 增加鸿鑫币
                    if (signInEntity.getSignDay()*5 <=50) {
                        message3 = "次日签到将获得鸿鑫币" + ((signInEntity.getSignDay()+1)*5>=50?50:(signInEntity.getSignDay()+1)*5) + "枚";
                        this.hongXinMoneyService.comeMoney(user.getId(), signInEntity.getSignDay()*5+"");
                    } else {
                        this.hongXinMoneyService.comeMoney(user.getId(), 50 + "");
                        message3 = "次日签到将获得鸿鑫币" + ((signInEntity.getSignDay()+1)*5>=50?50:(signInEntity.getSignDay()+1)*5) + "枚";
                    }
                }
            } else {
                // 新的初始化的bean
                System.out.println("新的初始化的bean");
                signInEntity.setSignDay(0);
                signInEntity.setUpdateTime(serdate);
                signInEntity.setCreateTime(serdate);
                signInEntity.setSignTime(serdate);
                signInEntity.setUserId(user.getId());
                signInEntity.setSignType("0");
                message1 = "您已持续签到" + signInEntity.getSignDay() + "天";
                message2 = "";
                message3 = "次日签到将获得鸿鑫币" + 10 + "枚";
                // 第一次赠送鸿鑫币40
                this.hongXinMoneyService.comeMoney(user.getId(), 5+"");
            }

            signInEntity.setIsDelete(0);
            this.sysServiceI.saveOrUpdate(signInEntity);
            AjaxJson temp = this.myAccount();
            String account = (String) ((Map)temp.getObj()).get("account");
            message2 = "已拥有鸿鑫币" + account+ "枚";
        } catch (Exception e) {
            e.printStackTrace();
            message1 = "服务器正在升级,请稍后再试!";
        }
        Map result = new HashMap();
        result.put("message1", message1);
        result.put("message2", message2);
        result.put("message3", message3);
        ajax.setMsg(message1);
        ajax.setObj(result);

        return ajax;
    }

    @RequestMapping("/myAccount")
    @ResponseBody
    public AjaxJson myAccount(){
        AjaxJson ajaxJson = new AjaxJson();
        Map result = new HashMap();
        String message = "你的操作成功!";
        try {
            // 或得登录用户
            Subject currentUser = SecurityUtils.getSubject();
            AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

            DxsAccountEntity accountEntity = this.sysServiceI.findUniqueByProperty(DxsAccountEntity.class, "userId", user.getId());
            MyBeanUtils.copyBean2Map(result, accountEntity);

            if (user.getRolecode().equals("emp")) {
                UserCompancyEntity userdetail = this.sysServiceI.findUniqueByProperty(UserCompancyEntity.class, "userEntity.id", user.getId());
                result.put("compancyName", userdetail.getCompancyName());
                result.put("acname", user.getEmail());
            } else {
                UserDetailEntity userdetail = this.sysServiceI.findUniqueByProperty(UserDetailEntity.class, "userId", user.getId());
                result.put("name", userdetail.getName());
                // 注:(杨治国)将email改mphone
                result.put("acname", user.getMphone());

            }

        } catch (Exception e) {
            message = "服务器正在升级,稍后重试......";
            result.clear();
        }

        ajaxJson.setMsg(message);
        ajaxJson.setObj(result);

        return ajaxJson;
    }



    /**
     * 得到两个时间相差的天数
     */
    public int daysBetween(Date early, Date late) {

        java.util.Calendar calst = java.util.Calendar.getInstance();
        java.util.Calendar caled = java.util.Calendar.getInstance();
        calst.setTime(early);
        caled.setTime(late);
        //设置时间为0时
        calst.set(java.util.Calendar.HOUR_OF_DAY, 0);
        calst.set(java.util.Calendar.MINUTE, 0);
        calst.set(java.util.Calendar.SECOND, 0);
        caled.set(java.util.Calendar.HOUR_OF_DAY, 0);
        caled.set(java.util.Calendar.MINUTE, 0);
        caled.set(java.util.Calendar.SECOND, 0);
        //得到两个日期相差的天数
        int days = ((int) (caled.getTime().getTime() / 1000) - (int) (calst
                .getTime().getTime() / 1000)) / 3600 / 24;

        return days;

    }
}
