package com.buss.apply.controller;

import com.buss.actives.entity.ActivesEntity;
import com.buss.activity.entity.ActiveUserEntity;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.model.json.AjaxJson;
import com.buss.common.service.SysServiceI;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/6/24.
 */
@Controller
@RequestMapping("/activeapply")
public class ActiveApplyController {

    @Autowired
    private SysServiceI sysServiceI;

    /**
     * 是否可以报名
     * 报名活动
     */
    @RequestMapping("/isActive")
    @ResponseBody
    public AjaxJson isApplayActive(ActivesEntity activesEntity1, HttpServletRequest request) {
        AjaxJson ajaxJson = new AjaxJson();
        String message = "false";

        try {
            //获取用户登录信息
            Subject currentUser = SecurityUtils.getSubject();
            AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
//            if (user == null) {
//                message = "用户没有登录!";
//            }
            // 查询报名信息
            ActiveUserEntity activeUserEntity = new ActiveUserEntity();
            activeUserEntity.setUserId(user.getId());
            activeUserEntity.setActiveId(activesEntity1.getId());
            activeUserEntity.setType(0);
            List activeusers = this.sysServiceI.findByExample(ActiveUserEntity.class.getName(), activeUserEntity);
            if (activeusers != null && activeusers.size()>0) {
                message = "次活动您已经申请过";
            } else {
                ActivesEntity activesEntity = this.sysServiceI.getEntity(ActivesEntity.class, activeUserEntity.getActiveId()); // activeUserEntity.getActivesEntity();
                if (activesEntity!=null && activesEntity.getActiveStateTime().before(new Date()) && activesEntity.getIsDelete()==0){
                    message = "可以报名";
                } else {
                    message = "次活动目前不可报名";
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            message = "报名失败";

        }
        ajaxJson.setMsg(message);

        return ajaxJson;
    }



    /**
     * 活动报名
     * 报名活动
     */
    @RequestMapping("/applayActive")
    @ResponseBody
    public AjaxJson applayActive(ActiveUserEntity activeUserEntity, HttpServletRequest request) {
        AjaxJson ajaxJson = new AjaxJson();
        String message = "操作成功!";

        try {
            //获取用户登录信息
            Subject currentUser = SecurityUtils.getSubject();
            AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
            // 查询报名信息
            activeUserEntity.setUserId(user.getId());
            List activeusers = this.sysServiceI.findByExample(ActiveUserEntity.class.getName(), activeUserEntity);
            if (activeusers != null && activeusers.size()>0) {
                activeUserEntity = (ActiveUserEntity) activeusers.get(0);
                activeUserEntity.setUpdateTime(new Date());
            } else {
                Date date = new Date();
                activeUserEntity.setCreateTime(date);
                activeUserEntity.setUpdateTime(date);
            }
            activeUserEntity.setIsDelete(0);
            activeUserEntity.setType(0);

            this.sysServiceI.saveOrUpdate(activeUserEntity);

        } catch (Exception e) {
            e.printStackTrace();
            message = "操作失败!";
        }
        ajaxJson.setMsg(message);

        return ajaxJson;
    }
}
