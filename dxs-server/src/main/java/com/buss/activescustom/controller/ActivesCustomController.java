package com.buss.activescustom.controller;

import com.buss.activescustom.entity.ActivesCustomEntity;
import com.buss.activescustom.trans.from.ActivesCustomFrom;
import com.buss.activescustomcountry.entity.ActivesCustomCountryEntity;
import com.buss.activescustomcountry.trans.from.ActivesCustomCountryFrom;
import com.buss.activescustomcountry.trans.vo.ActivesCustomCountryVo;
import com.buss.activescustomcourses.entity.ActivesCustomCoursesEntity;
import com.buss.activescustomcourses.trans.vo.ActivesCustomCoursesVo;
import com.buss.activescustomduration.entity.ActivesCustomDurationEntity;
import com.buss.activescustomduration.trans.vo.ActivesCustomDurationVo;
import com.buss.activescustomizedcourses.entity.ActivesCustomizedCoursesEntity;
import com.buss.activescustomizedcourses.trans.from.ActivesCustomizedCoursesFrom;
import com.buss.activescustomizedcourses.trans.vo.ActivesCustomizedCoursesVo;
import com.buss.activescustommode.entity.ActivesCustomModeEntity;
import com.buss.activescustommode.trans.vo.ActivesCustomModeVo;
import com.buss.activescustomvisa.entity.ActivesCustomVisaEntity;
import com.buss.activescustomvisa.trans.vo.ActivesCustomVisaVo;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.jweb.core.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by Administrator on 2016/8/1.
 */
@Controller
@RequestMapping("/ActivesCustomController")
public class ActivesCustomController {

    @Resource
    private SysServiceI sysServiceI;

    // 游学定制
    @RequestMapping(value = "personalTailor")
    @ResponseBody
    public ReplyDataMode personalTailor(ActivesCustomFrom activesCustomFrom,HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");


        try {
            if (user != null){
                activesCustomFrom.setIsDelete("0");
                activesCustomFrom.setUserId(user.getId());
                Date date = new Date();
                ActivesCustomEntity  activesCustomEntity = (ActivesCustomEntity) activesCustomFrom.toEntity();
                activesCustomEntity.setCreateTime(date);
                activesCustomEntity.setUpdateTime(date);
                this.sysServiceI.saveOrUpdate(activesCustomEntity);

                replyDataMode.setStatusCode("提交成功");
                replyDataMode.setSuccess(true);
            }else {
                replyDataMode.setStatusCode("请登录!");
                replyDataMode.setSuccess(false);
            }
        }catch (Exception e){
            replyDataMode.setStatusCode("提交失败!");
            replyDataMode.setSuccess(false);
        }

        return replyDataMode;
    }

    /**
     * 游学定制的定制行程中的所需信息
     * @param activesCustomizedCoursesId    课程选择的ID
     * @param activesCustomCountryId        国家选择查询的ID
     * @param request
     * @return
     */
    @RequestMapping("customTravel")
    @ResponseBody
    public ReplyDataMode customTravel(String activesCustomizedCoursesId, String activesCustomCountryId, HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();
        Map<String,List> map = new HashMap<String,List>();

        if (activesCustomizedCoursesId != null || activesCustomCountryId != null) {
            if (!StringUtil.isEmpty(activesCustomizedCoursesId)){
                // 查询所有的课程选择
                ActivesCustomizedCoursesFrom activesCustomizedCoursesFrom = new ActivesCustomizedCoursesFrom();
                activesCustomizedCoursesFrom.setPid(activesCustomizedCoursesId);
                activesCustomizedCoursesFrom.setIsDelete("0");
                CriteriaQuery criteriaQuery = activesCustomizedCoursesFrom.getCriteriaQuery();
                criteriaQuery.addOrder("createTime","desc");
                criteriaQuery.addOrder("updateTime","desc");
                List<ActivesCustomizedCoursesEntity> activesCustomizedCoursesEntityList = this.sysServiceI.list(criteriaQuery);
                List<ActivesCustomizedCoursesVo> activesCustomizedCoursesVos = new ArrayList<ActivesCustomizedCoursesVo>();
                if (activesCustomizedCoursesEntityList != null && activesCustomizedCoursesEntityList.size() > 0){
                    for (ActivesCustomizedCoursesEntity acce:activesCustomizedCoursesEntityList){
                        ActivesCustomizedCoursesVo activesCustomizedCoursesVo = new ActivesCustomizedCoursesVo();
                        activesCustomizedCoursesVo.copyEntity(acce);
                        activesCustomizedCoursesVos.add(activesCustomizedCoursesVo);
                    }
                }
                map.put("activesCustomizedCoursesVos",activesCustomizedCoursesVos);
            }

            if (!StringUtil.isEmpty(activesCustomCountryId)){
                // 国家选择查询
                ActivesCustomCountryFrom activesCustomCountryFrom = new ActivesCustomCountryFrom();
                activesCustomCountryFrom.setPid(activesCustomCountryId);
                activesCustomCountryFrom.setIsDelete("0");
                CriteriaQuery criteriaQuery1 = activesCustomCountryFrom.getCriteriaQuery();
                criteriaQuery1.addOrder("createTime","desc");
                criteriaQuery1.addOrder("updateTime","desc");
                List<ActivesCustomCountryEntity> activesCustomCountryEntityList = this.sysServiceI.list(criteriaQuery1);
                List<ActivesCustomCountryVo> activesCustomCountryVos = new ArrayList<ActivesCustomCountryVo>();
                if (activesCustomCountryEntityList != null && activesCustomCountryEntityList.size() > 0){
                    for (ActivesCustomCountryEntity acc:activesCustomCountryEntityList){
                        ActivesCustomCountryVo activesCustomCountryVo = new ActivesCustomCountryVo();
                        activesCustomCountryVo.copyEntity(acc);
                        activesCustomCountryVos.add(activesCustomCountryVo);
                    }
                }
                map.put("activesCustomCountryVos",activesCustomCountryVos);
            }
        }else {
            // 兴趣课程
            List<ActivesCustomCoursesEntity> activesCustomCoursesEntityList = this.sysServiceI.getList(ActivesCustomCoursesEntity.class);
            List<ActivesCustomCoursesVo> activesCustomCoursesVos = new ArrayList<ActivesCustomCoursesVo>();
            if (activesCustomCoursesEntityList != null && activesCustomCoursesEntityList.size() > 0){
                for (ActivesCustomCoursesEntity acce:activesCustomCoursesEntityList){
                    ActivesCustomCoursesVo activesCustomCoursesVo = new ActivesCustomCoursesVo();
                    activesCustomCoursesVo.copyEntity(acce);
                    activesCustomCoursesVos.add(activesCustomCoursesVo);
                }
            }
            map.put("activesCustomCoursesVos",activesCustomCoursesVos);

            // 住宿方式
            List<ActivesCustomModeEntity> activesCustomModeEntityList = this.sysServiceI.getList(ActivesCustomModeEntity.class);
            List<ActivesCustomModeVo> activesCustomModeVos = new ArrayList<ActivesCustomModeVo>();
            if (activesCustomModeEntityList != null && activesCustomModeEntityList.size() > 0){
                for (ActivesCustomModeEntity acme:activesCustomModeEntityList){
                    ActivesCustomModeVo activesCustomModeVo = new ActivesCustomModeVo();
                    activesCustomModeVo.copyEntity(acme);
                    activesCustomModeVos.add(activesCustomModeVo);
                }
            }
            map.put("activesCustomModeVos",activesCustomModeVos);

            // 课程时长
            List<ActivesCustomDurationEntity> activesCustomDurationEntityList = this.sysServiceI.getList(ActivesCustomDurationEntity.class);
            List<ActivesCustomDurationVo> activesCustomDurationVos = new ArrayList<ActivesCustomDurationVo>();
            if (activesCustomDurationEntityList != null && activesCustomDurationEntityList.size() > 0){
                for (ActivesCustomDurationEntity acde:activesCustomDurationEntityList){
                    ActivesCustomDurationVo activesCustomDurationVo = new ActivesCustomDurationVo();
                    activesCustomDurationVo.copyEntity(acde);
                    activesCustomDurationVos.add(activesCustomDurationVo);
                }
            }
            map.put("activesCustomDurationVos",activesCustomDurationVos);

            // 签证方式
            List<ActivesCustomVisaEntity> activesCustomVisaEntityList = this.sysServiceI.getList(ActivesCustomVisaEntity.class);
            List<ActivesCustomVisaVo> activesCustomVisaVos =  new ArrayList<ActivesCustomVisaVo>();
            if (activesCustomVisaEntityList != null && activesCustomVisaEntityList.size() > 0){
                for (ActivesCustomVisaEntity acve:activesCustomVisaEntityList){
                    ActivesCustomVisaVo activesCustomVisaVo = new ActivesCustomVisaVo();
                    activesCustomVisaVo.copyEntity(acve);
                    activesCustomVisaVos.add(activesCustomVisaVo);
                }
            }
            map.put("activesCustomVisaVos",activesCustomVisaVos);
        }

        replyDataMode.setData(map);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);
        return replyDataMode;
    }
}
