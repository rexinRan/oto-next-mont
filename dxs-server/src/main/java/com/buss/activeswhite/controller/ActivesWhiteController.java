package com.buss.activeswhite.controller;

import com.buss.activeswhite.entity.ActivesWhiteEntity;
import com.buss.activeswhite.trans.from.ActivesWhiteFrom;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;
import com.buss.employed.entity.EmployedEntity;
import com.buss.employed.trans.form.EmployedForm;
import com.buss.employed.trans.vo.EmployedVO;
import com.buss.userdetail.entity.UserDetailEntity;
import com.buss.userdetail.trans.form.UserDetailForm;
import com.buss.userdetail.trans.vo.UserDetailVO;
import org.apache.activemq.console.command.CreateCommand;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.jweb.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailParseException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by Administrator on 2016/7/30.
 */
@Controller
@RequestMapping("/whiteCollarTour")
public class ActivesWhiteController {

    @Resource
    private SysServiceI sysServiceI;

    /**
     * 保存白领专区提交信息
     * @param activesWhiteFrom
     * @param request
     * @return
     */
    @RequestMapping(value = "whiteCollar")
    @ResponseBody
    public ReplyDataMode whiteCollar(ActivesWhiteFrom activesWhiteFrom, HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        //获取用户登录信息
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if (user != null){
            activesWhiteFrom.setIsDelete("0");
            ActivesWhiteEntity activesWhiteEntity = (ActivesWhiteEntity) activesWhiteFrom.toEntity();
            activesWhiteEntity.setCreateTime(new Date());
            this.sysServiceI.saveOrUpdate(activesWhiteEntity);
            replyDataMode.setStatusCode("保存成功!");
            replyDataMode.setSuccess(true);
        }else {
            replyDataMode.setStatusCode("请登录!");
            replyDataMode.setSuccess(false);
        }
        return replyDataMode;
    }

    /**
     * 白领专区中的当前用户的信息
     * @param request
     * @return
     */
    @RequestMapping("userinfo")
    @ResponseBody
    public ReplyDataMode userinfo(HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();
        /** 获取当前用户的信息*/
        //获取用户登录信息
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
        UserDetailVO userDetailVO = new UserDetailVO();
        List<UserDetailVO> userDetailVOs = new ArrayList<UserDetailVO>();
        List<EmployedVO> employedVOs = new ArrayList<EmployedVO>();
        Map<String,List> map = new HashMap<String, List>();
        if (user != null){
            UserDetailForm userDetailForm = new UserDetailForm();
            userDetailForm.setIsDelete("0");
            userDetailForm.setUserId(user.getId());
            CriteriaQuery criteriaQuery = userDetailForm.getCriteriaQuery();
            List<UserDetailEntity> userDetailEntityList = this.sysServiceI.list(criteriaQuery);
            if (userDetailEntityList != null && userDetailEntityList.size() > 0){
                userDetailVO.copyEntity(userDetailEntityList.get(0));
                userDetailVOs.add(userDetailVO);
            }
            map.put("userDetailVOs",userDetailVOs);
            // 当前用户的职位
            EmployedForm employedForm = new EmployedForm();
            employedForm.setIsDelete("0");
            employedForm.setUserId(user.getId());
            CriteriaQuery criteriaQuery1 = employedForm.getCriteriaQuery();
            criteriaQuery1.addOrder("createTime","desc");
            criteriaQuery1.addOrder("updateTime","desc");

            List<EmployedEntity> employedEntityList = this.sysServiceI.list(criteriaQuery1);
            if (employedEntityList != null && employedEntityList.size() > 0){
                for (EmployedEntity ee:employedEntityList){
                    EmployedVO employedVO = new EmployedVO();
                    employedVO.copyEntity(ee);
                    employedVOs.add(employedVO);
                }
            }else {
                employedVOs.add(new EmployedVO());
            }

            map.put("employedVOs",employedVOs);
        }else {
            replyDataMode.setStatusCode("请登录!");
            replyDataMode.setSuccess(false);
        }
        replyDataMode.setData(map);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);
        return replyDataMode;
    }
}
