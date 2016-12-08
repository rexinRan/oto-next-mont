package com.buss.userdetail.controller;

import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;
import com.buss.member.entity.GeneralUserEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.util.PasswordUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 修改密码
 * Created by Administrator on 2016/7/13.
 */
@Controller
@RequestMapping("/PasswordController")
public class PasswordController {

    @Resource
    private SysServiceI sysServiceI;


    /**
     * 修改密码
     * @param pastPassWord  原始密码
     * @param newPassWord   新密码
     * @param reuqest
     * @return
     */
    @RequestMapping(value = "/ModifyPasswordController")
    @ResponseBody
        public ReplyDataMode ModifyPasswordController(String pastPassWord, String newPassWord, HttpServletRequest reuqest){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        Subject currentUser = SecurityUtils.getSubject();
        // 获取当前登录用户
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if (user != null && !pastPassWord.isEmpty()){
            GeneralUserEntity generalUser = this.sysServiceI.get(GeneralUserEntity.class,user.getId());

            if (generalUser.getPwd().equals(PasswordUtil.encrypt(pastPassWord))){
                // 将新密码进行加密
                String password = PasswordUtil.encrypt(newPassWord);
                generalUser.setPwd(password);
                this.sysServiceI.saveOrUpdate(generalUser);

                replyDataMode.setStatusCode("修改成功!");
                replyDataMode.setSuccess(true);
            }else{
                replyDataMode.setStatusCode("您输入的原始密码不正确!");
                replyDataMode.setSuccess(false);
            }
        }
        return replyDataMode;
    }
}
