package com.buss.specialrecruit.controller;

import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.collentions.entity.CollentionsEntity;
import com.buss.collentions.trans.form.CollentionsSearchForm;
import com.buss.common.service.SysServiceI;
import com.buss.resume.resume.entity.ResumeEntity;
import com.buss.resume.resume.trans.form.ResumeSearchForm;
import com.buss.resumeuser.controller.ResumeUserController;
import com.buss.resumeuser.trans.form.ResumeUserForm;
import com.buss.specialrecruit.entity.ResumeUsersEntity;
import com.buss.specialrecruit.entity.SpecialRecruitEntity;
import com.buss.specialrecruit.trans.from.ResumeUserSearchFrom;
import com.buss.specialrecruit.trans.from.SpecialReruitFrom;
import com.buss.specialrecruit.trans.vo.SpecialRecruitVo;
import com.buss.specialrecruitapply.entity.SpecialRecruitApplyEntity;
import com.buss.specialrecruitapply.trans.from.SpecialRecruitApplyFrom;
import com.buss.specialrecruitjob.entity.SpecialRecruitJobEntity;
import com.buss.specialrecruitjob.trans.from.SpecialRecruitJobFrom;
import com.buss.specialrecruitjob.trans.vo.SpecialRecruitJobVo;
import com.buss.specialrecruitjobappointment.entity.SpecialRecruitJobAppointmentEntity;
import com.buss.specialrecruitjobappointment.trans.from.SpecialRecruitJobAppointmentFrom;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.jweb.core.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by Administrator on 2016/7/25.
 */
@Controller
@RequestMapping("/recruit")
public class SpecialRecruitController {

    @Resource
    private SysServiceI sysServiceI;

    /**
     * 所有的专场招聘
     * @return
     */
    @RequestMapping(value = "allTheSpecialRecruitment")
    @ResponseBody
    public ReplyDataMode allTheSpecialRecruitment(SpecialReruitFrom specialReruitFrom, int curPage, int pageSize, HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();
        // 存放所有的专场信息
        List special = new ArrayList();

        //获取用户登录信息
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if (specialReruitFrom.getId() != null && !specialReruitFrom.getId().isEmpty()){
            specialReruitFrom.setIsDelete("0");
            CriteriaQuery criteriaQuery1 = specialReruitFrom.getCriteriaQuery();
            criteriaQuery1.gt("holdEndTime",new Date());
            List<SpecialRecruitEntity> specialRecruitEntityList = this.sysServiceI.list(criteriaQuery1);

            SpecialRecruitEntity specialRecruitEntity = this.sysServiceI.get(SpecialRecruitEntity.class,specialReruitFrom.getId());

            if (specialRecruitEntity != null){
                // 存放专场招聘
                Map SpecialRecruitment = new HashMap();
                String time = null;
                SpecialRecruitVo specialRecruitVo = new SpecialRecruitVo();
                specialRecruitVo.copyEntity(specialRecruitEntity);

                // 时间和地址的处理
                manage(specialRecruitEntity,specialRecruitVo);
                specialRecruitVo.setHoldDatatime(specialRecruitEntity.getHoldDatatime());

                SpecialRecruitment.put("specialRecruitVo",specialRecruitVo);        // 专场招聘

                if (specialRecruitEntity.getId() != null){
                    SpecialRecruitJobFrom specialRecruitJobFrom = new SpecialRecruitJobFrom();
                    specialRecruitJobFrom.setIsDelete("0");
                    specialRecruitJobFrom.setSrId(specialRecruitEntity.getId());

                    CriteriaQuery criteriaQuery = specialRecruitJobFrom.getCriteriaQuery();
                    criteriaQuery.addOrder("createTime", "desc");
                    criteriaQuery.addOrder("updateTime", "desc");

                    PageMode mode = this.sysServiceI.list4page(criteriaQuery,curPage,pageSize);
                    List<SpecialRecruitJobEntity> specialRecruitJobEntityList = mode.getResult();

                    if (specialRecruitJobEntityList != null && specialRecruitJobEntityList.size() > 0){
                        List<SpecialRecruitJobVo> specialRecruitJobVos = new ArrayList<SpecialRecruitJobVo>();

                        for (SpecialRecruitJobEntity srje:specialRecruitJobEntityList){
                            SpecialRecruitJobVo specialRecruitJobVo = new SpecialRecruitJobVo();
                            specialRecruitJobVo.copyEntity(srje);
                            specialRecruitJobVos.add(specialRecruitJobVo);
                        }
                        SpecialRecruitment.put("specialRecruitJobVos",specialRecruitJobVos);
                    }
                    special.add(SpecialRecruitment);
                    mode.setResult(special);
                    replyDataMode.setData(mode);
                    replyDataMode.setStatusCode("200");
                    replyDataMode.setSuccess(true);
                }
            }
        }else {
            specialReruitFrom.setIsDelete("0");
            CriteriaQuery criteriaQuery = specialReruitFrom.getCriteriaQuery();
            criteriaQuery.gt("holdEndTime",new Date());
            PageMode mode = this.sysServiceI.list4page(criteriaQuery,curPage,pageSize);
            List<SpecialRecruitEntity> specialRecruitEntityList = mode.getResult();

            if (specialRecruitEntityList != null && specialRecruitEntityList.size() > 0){
                for (SpecialRecruitEntity sre:specialRecruitEntityList){
                    SpecialRecruitVo specialRecruitVo = new SpecialRecruitVo();
                    specialRecruitVo.copyEntity(sre);

                    // 时间和地址的处理
                    this.manage(sre,specialRecruitVo);
                    specialRecruitVo.setHoldDatatime(sre.getHoldDatatime());
                    // 查询是否关注
                    specialRecruitVo.setIsCollention("未关注");
                    if (user != null){
                        if (!StringUtil.isEmpty(sre.getId())){
                            CollentionsSearchForm collentions = new CollentionsSearchForm();
                            collentions.setOutId(sre.getId());
                            collentions.setIsDelete("0");
                            collentions.setUserId(user.getId());
                            CriteriaQuery criteriaQuery1 = collentions.getCriteriaQuery();
                            List<CollentionsEntity> collentionsEntityList = this.sysServiceI.list(criteriaQuery1);
                            if (collentionsEntityList != null && collentionsEntityList.size() > 0){
                                specialRecruitVo.setIsCollention("已关注");
                            }
                        }
                    }
                    special.add(specialRecruitVo);
                }
                mode.setResult(special);
                replyDataMode.setData(mode);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);
            }
        }
        return  replyDataMode;
    }


    /**
     * 专场招聘中日期和时间的管理
     * @param specialRecruitEntity 专项就业实体
     * @param specialRecruitVo     VO
     */
    private static void manage(SpecialRecruitEntity specialRecruitEntity,SpecialRecruitVo specialRecruitVo){
        // 日期
        if (specialRecruitEntity.getHoldStartTime() != null && specialRecruitEntity.getHoldEndTime() != null){
            if (specialRecruitEntity.getHoldEndTime().toString().equals(specialRecruitEntity.getHoldStartTime().toString())){
                specialRecruitVo.setHoldStartTime(specialRecruitEntity.getHoldStartTime().toString().substring(0,10));
                specialRecruitVo.setHoldEndTime(null);
            }else {
                String start = specialRecruitEntity.getHoldStartTime().toString().substring(0,10);
                String end = specialRecruitEntity.getHoldEndTime().toString().substring(0,10);
                specialRecruitVo.setHoldStartTime(start + " - " + end);
                specialRecruitVo.setHoldEndTime(null);
            }
        }
        // 地址
        if(specialRecruitEntity.getSpAddress() != null && !specialRecruitEntity.getSpAddress().isEmpty()){
            if (specialRecruitEntity.getSpAddress().contains("市辖区")){
                String addres = specialRecruitEntity.getSpAddress().replaceAll("市辖区","").replaceAll("#","");
                specialRecruitVo.setSpAddress(addres);
            }else {
                String addres = specialRecruitEntity.getSpAddress().replaceAll("#","");
                specialRecruitVo.setSpAddress(addres);
            }
        }
        // 学历层次
        if (specialRecruitVo.getSpEducation() != null && !specialRecruitVo.getSpEducation().isEmpty()){
            if ("1".equals(specialRecruitVo.getSpEducation())){
                specialRecruitVo.setSpEducation("本科");
            }else if ("2".equals(specialRecruitVo.getSpEducation())){
                specialRecruitVo.setSpEducation("硕士");
            }else if ("3".equals(specialRecruitVo.getSpEducation())){
                specialRecruitVo.setSpEducation("博士");
            }

        }
    }

    /**
     * 企业申请参加专场>>选择省份后联动所有的数据
     * @param request
     * @return
     */
    @RequestMapping(value = "number")
    @ResponseBody
    public ReplyDataMode number(SpecialReruitFrom specialReruitFrom,String province ,HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        List<SpecialRecruitVo> specialRecruitVos = null;
        if (province != null && !province.isEmpty()){
            specialReruitFrom.setIsDelete("0");
            CriteriaQuery criteriaQuery = specialReruitFrom.getCriteriaQuery();

            // 查询条件
            criteriaQuery.addOrder("holdDatatime","asc");
            criteriaQuery.like("spAddress","%" + province + "%");
            criteriaQuery.gt("holdEndTime",new Date());
            criteriaQuery.add();

            List<SpecialRecruitEntity> specialRecruitEntityList = this.sysServiceI.list(criteriaQuery);
            specialRecruitVos = new ArrayList<SpecialRecruitVo>();
            if (specialRecruitEntityList != null && specialRecruitEntityList.size() > 0){
                for (SpecialRecruitEntity sre:specialRecruitEntityList){
                    SpecialRecruitVo specialRecruitVo = new SpecialRecruitVo();
                    specialRecruitVo.copyEntity(sre);
                    specialRecruitVos.add(specialRecruitVo);
                }
            }
        }

        replyDataMode.setData(specialRecruitVos);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


    /**
     * 企业申请参加专场>>确认提交
     * @param specialReruitFrom
     * @param privince
     * @param request
     * @return
     */
    @RequestMapping("enterpriseApplication")
    @ResponseBody
    public ReplyDataMode enterpriseApplication(SpecialReruitFrom specialReruitFrom,String privince, HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if (user != null){      // 注:还需判断是否是企业用户
            // 通过所选参数查询唯一的专场
            specialReruitFrom.setIsDelete("0");
            CriteriaQuery criteriaQuery = specialReruitFrom.getCriteriaQuery();
            List<SpecialRecruitEntity> specialRecruitEntityList = this.sysServiceI.list(criteriaQuery);
            if (specialRecruitEntityList != null && specialRecruitEntityList.size() > 0){
                SpecialRecruitApplyFrom specialRecruitApplyFrom = new SpecialRecruitApplyFrom();
                specialRecruitApplyFrom.setIsDelete("0");
                specialRecruitApplyFrom.setUserId(user.getId());
                specialRecruitApplyFrom.setSrId(specialRecruitEntityList.get(0).getId());
                specialRecruitApplyFrom.setEmployDirection(specialRecruitEntityList.get(0).getSpDirection());
                specialRecruitApplyFrom.setEmploySchool(specialRecruitEntityList.get(0).getSpSchool());
                specialRecruitApplyFrom.setPrivince(privince);
                SpecialRecruitApplyEntity specialRecruitApplyEntity = (SpecialRecruitApplyEntity) specialRecruitApplyFrom.toEntity();
                specialRecruitApplyEntity.setCreateTime(new Date());

                // 保存申请
                this.sysServiceI.saveOrUpdate(specialRecruitApplyEntity);

                replyDataMode.setStatusCode("保存成功!");
                replyDataMode.setSuccess(true);
            }else {
                replyDataMode.setStatusCode("没有该专场招聘!");
                replyDataMode.setSuccess(false);
            }
        }else {
            replyDataMode.setStatusCode("请您登录!");
            replyDataMode.setSuccess(false);
        }
        return replyDataMode;
    }


    @Resource
    private ResumeUserController ResumeUserController;

    @RequestMapping(value = "bespeak")
    @ResponseBody
    public ReplyDataMode bespeak(SpecialRecruitJobAppointmentFrom specialRecruitJobAppointmentFrom, HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if (user != null ){
            if (specialRecruitJobAppointmentFrom.getAppointmentType() != null && specialRecruitJobAppointmentFrom.getSrId() != null && specialRecruitJobAppointmentFrom.getSrjId() != null){
                // 预约类型 0:预约    1:现场可初试     2:预约+现场可初试
                if ("0".equals(specialRecruitJobAppointmentFrom.getAppointmentType())){         // 预约需投递简历

                    if (judgmentAppointment(specialRecruitJobAppointmentFrom,user)) {       // 判断当前用户是否投递过某种专场招聘项的活动
                        // 查询当前用户是否简历
                        ResumeSearchForm resumeSearchForm = new ResumeSearchForm();
                        resumeSearchForm.setIsDelete("0");
                        resumeSearchForm.setUserid(user.getId());

                        CriteriaQuery criteriaQuery = resumeSearchForm.getCriteriaQuery();
                        List<ResumeEntity> resumeEntityList = this.sysServiceI.list(criteriaQuery);

                        // 判断是否有简历
                        if (resumeEntityList != null && resumeEntityList.size() > 0) {
                            // 给某企业发送简历
                            ResumeUserForm searchForm = new ResumeUserForm();
                            searchForm.setEmoloyedId(specialRecruitJobAppointmentFrom.getSrjId());
                            ResumeUserController.saveResumeUser(searchForm, request);

                            // 保存预约数据
                            saveOrUpdate(specialRecruitJobAppointmentFrom, user);
                            replyDataMode.setStatusCode("预约成功!");
                            replyDataMode.setSuccess(true);

                        } else {
                            replyDataMode.setStatusCode("请您添加简历!");
                            replyDataMode.setSuccess(false);
                        }
                    }else {
                        replyDataMode.setStatusCode("您已预约!");
                        replyDataMode.setSuccess(false);
                    }
                }else if (specialRecruitJobAppointmentFrom.getAppointmentType() == "1" || specialRecruitJobAppointmentFrom.getAppointmentType() == "2"){ // 现场可初试 / 预约+现场可初试

                    saveOrUpdate(specialRecruitJobAppointmentFrom,user);
                    replyDataMode.setStatusCode("预约成功!");
                    replyDataMode.setSuccess(true);
                }else {
                    replyDataMode.setStatusCode("选择预约类型错误!");
                    replyDataMode.setSuccess(true);
                }
            }else {
                replyDataMode.setStatusCode("请选择预约类型!");
                replyDataMode.setSuccess(true);
            }
        }else {
            replyDataMode.setStatusCode("请登录!");
            replyDataMode.setSuccess(true);
        }

        return replyDataMode;
    }

    /**
     * 专场招聘和岗位预约的保存
     * @param specialRecruitJobAppointmentFrom      专场招聘项
     * @param user      当前用户
     */
    public void saveOrUpdate(SpecialRecruitJobAppointmentFrom specialRecruitJobAppointmentFrom, AuthUserVO user) {

        Date date = new Date();
        SpecialRecruitJobAppointmentEntity specialRecruitJobAppointmentEntity = new SpecialRecruitJobAppointmentEntity();
        specialRecruitJobAppointmentEntity.setSrId(specialRecruitJobAppointmentFrom.getSrId());
        specialRecruitJobAppointmentEntity.setSrjId(specialRecruitJobAppointmentFrom.getSrjId());
        specialRecruitJobAppointmentEntity.setUserId(user.getId());
        specialRecruitJobAppointmentEntity.setCreateTime(new Date());
        specialRecruitJobAppointmentEntity.setAppointmentType(Integer.parseInt(specialRecruitJobAppointmentFrom.getAppointmentType()));
        specialRecruitJobAppointmentEntity.setType(0);    // 预留
        specialRecruitJobAppointmentEntity.setAppointmentTime(date);
        specialRecruitJobAppointmentEntity.setCreateTime(date);
        specialRecruitJobAppointmentEntity.setUpdateTime(date);
        specialRecruitJobAppointmentEntity.setIsDelete(0);

        this.sysServiceI.saveOrUpdate(specialRecruitJobAppointmentEntity);

    }

    /**
     *
     * @param specialRecruitJobAppointmentFrom      专场招聘项
     * @param user         当前用户
     * @return
     */
    @RequestMapping(value = "judgmentAppointment")
    @ResponseBody
    public boolean judgmentAppointment(SpecialRecruitJobAppointmentFrom specialRecruitJobAppointmentFrom, AuthUserVO user){

        ResumeUserSearchFrom resumeUserSearchFrom = new ResumeUserSearchFrom();
        resumeUserSearchFrom.setIsDelete("0");
        resumeUserSearchFrom.setUserId("ff80818155c47eaa0155c47fc9c90000");
        resumeUserSearchFrom.setEmoloyedId(specialRecruitJobAppointmentFrom.getSrjId());

        CriteriaQuery criteriaQuery = resumeUserSearchFrom.getCriteriaQuery();
        List<ResumeUsersEntity> resumeUserEntityList = this.sysServiceI.list(criteriaQuery);

        if (resumeUserEntityList != null && resumeUserEntityList.size() > 0){
            return false;
        }else {
            return true;
        }
    }
}
