package com.buss.project.projects.controller;


import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.collentions.entity.CollentionsEntity;
import com.buss.collentions.trans.form.CollentionsSearchForm;
import com.buss.common.service.SysServiceI;
import com.buss.competition.controller.CompetitionController;
import com.buss.competition.entity.CompetitionEntity;
import com.buss.competition.trans.vo.CompetitionVO;
import com.buss.member.entity.GeneralUserEntity;
import com.buss.project.bases.entity.BasesEntity;
import com.buss.project.bases.trans.vo.BasesVO;
import com.buss.project.founds.entity.FoundEntity;
import com.buss.project.founds.trans.vo.FoundVO;
import com.buss.project.projectapply.entity.ProjectApplyEntity;
import com.buss.project.projectresult.entity.ProjectResultEntity;
import com.buss.project.projectresult.trans.vo.ProjectResultVO;
import com.buss.project.projects.entity.ProjectEntity;
import com.buss.project.projects.trans.form.ProjectSearchForm;
import com.buss.project.projects.trans.vo.ProjectVO;
import com.buss.project.projectusers.entity.ProjectUsersEntity;
import com.buss.project.projectusers.trans.form.ProjectUsersSearchForm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * YZG
 * Created by HongXinGuoJi-yzg on 2016/9/19.
 */
@Controller
@RequestMapping("/projects")
public class ProjectsController {

    @Resource
    private SysServiceI sysServiceI;

    @Resource
    private CompetitionController competitionController;


    /**
     * 创建项目      修改次数未维护(没有修改判断)
     * @param projectSearchForm
     * @param projectUsersSearchForm
     * @return
     */
    @RequestMapping(value = "createPoject")
    @ResponseBody
    public ReplyDataMode createPoject(ProjectSearchForm projectSearchForm,String userName, ProjectUsersSearchForm projectUsersSearchForm){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if (user != null){
            if(projectSearchForm != null && !StringUtils.isEmpty(userName)){

                ProjectEntity projectEntity = (ProjectEntity) projectSearchForm.toEntity();
                projectEntity.setIsDelete(0);
                projectEntity.setCreateTime(new Date());
                SimpleDateFormat format = new SimpleDateFormat("yyyy");
                String date = format.format(new Date());
                projectEntity.setCreateYear(date);
                projectEntity.setUserId(user.getId());

                if (!StringUtils.isEmpty(projectSearchForm.getBcId())){
                    // 有大赛的ID,绑定制定大赛的ID
                    projectEntity.setBcId(projectSearchForm.getBcId());
                }else {
                    // 没有大赛的ID,绑定最新大赛的ID
                    CompetitionVO competitionVO = competitionController.upToDatemegagame();

                    if (competitionVO != null && !StringUtils.isEmpty(competitionVO.getId())){
                        projectEntity.setBcId(competitionVO.getId());
                    }
                }

                // 保存创建项目数据
                this.sysServiceI.saveOrUpdate(projectEntity);

                // 查询刚才创建的项目
                ProjectSearchForm projectSearchForm1 = new ProjectSearchForm();
                projectSearchForm1.setIsDelete("0");
                projectSearchForm1.setUserId(user.getId());
                CriteriaQuery criteriaQuery = projectSearchForm1.getCriteriaQuery();
                criteriaQuery.addOrder("createTime","desc");
                List<ProjectEntity> projectEntityList = this.sysServiceI.list(criteriaQuery);

                // 保存项目成员
                if (projectEntityList != null && projectEntityList.size() > 0){
                    Date createTime = new Date();
                    String[] members = userName.split("#");
                    for (int i = 0;i < members.length;i++){
                        String[] member = members[i].split("\\*");

                        projectUsersSearchForm.setName(member[0]);
                        projectUsersSearchForm.setIdCard(member[1]);
                        projectUsersSearchForm.setUserId(user.getId());
                        projectUsersSearchForm.setProjectId(projectEntityList.get(0).getId());
                        projectUsersSearchForm.setIsDelete("0");
                        ProjectUsersEntity projectUsersEntity = (ProjectUsersEntity) projectUsersSearchForm.toEntity();
                        projectUsersEntity.setCreateTime(createTime);


                        this.sysServiceI.saveOrUpdate(projectUsersEntity);
                    }
                }

                replyDataMode.setStatusCode("提交成功!");
                replyDataMode.setSuccess(false);
            }else {

                replyDataMode.setStatusCode("请完善资料!");
                replyDataMode.setSuccess(false);
            }
        }else {

            replyDataMode.setStatusCode("请您登陆!");
            replyDataMode.setSuccess(false);
        }

        return replyDataMode;
    }


    /**
     * 个人中心/创业管理/我的项目
     * @param projectSearchForm
     * @param request
     * @return
     */
    @RequestMapping(value = "queryProject")
    @ResponseBody
    public ReplyDataMode queryProject(ProjectSearchForm projectSearchForm,HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();
        projectSearchForm.setIsDelete("0");

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if (user != null){
            projectSearchForm.setUserId(user.getId());
            CriteriaQuery criteriaQuery = projectSearchForm.getCriteriaQuery();
            criteriaQuery.addOrder("createTime","desc");

            if (projectSearchForm.getPageNo() != null && projectSearchForm.getPageNo() != null) {
                int pageNo = Integer.parseInt(projectSearchForm.getPageNo());
                int pageSize = Integer.parseInt(projectSearchForm.getPageSize());

                // 查询所有的项目
                PageMode mode = this.sysServiceI.list4page(criteriaQuery,pageNo,pageSize);
                List<ProjectEntity> projectEntityList = mode.getResult();
                List<Map<String,List>> list = new ArrayList<Map<String,List>>();



                if (projectEntityList != null && projectEntityList.size() > 0){
                    for (ProjectEntity pe:projectEntityList){
                        Map<String,List> map = new HashMap<String,List>();
                        List<ProjectVO> projectVOList = new ArrayList<ProjectVO>();
                        List<CompetitionVO> competitionVOs = new ArrayList<CompetitionVO>();
                        List<ProjectResultVO> projectResultVOs = new ArrayList<ProjectResultVO>();
                        List<BasesVO> basesVOs = new ArrayList<BasesVO>();
                        List<FoundVO> foundVOs = new ArrayList<FoundVO>();

                        ProjectVO projectVO = new ProjectVO();
                        projectVO.copyEntity(pe);
                        projectVOList.add(projectVO);

                        // 查询所关联的创业大赛
                        CompetitionEntity competitionEntity = this.sysServiceI.get(CompetitionEntity.class,pe.getBcId());
                        if (competitionEntity != null){
                            CompetitionVO competitionVO = new CompetitionVO();
                            competitionVO.copyEntity(competitionEntity);
                            competitionVOs.add(competitionVO);
                            map.put("competitionVOs",competitionVOs);
                        }else {
                            competitionVOs.add(new CompetitionVO());
                            map.put("competitionVOs",competitionVOs);
                        }

                        // 查询项目得分表
                        ProjectResultEntity projectResultEntity = this.sysServiceI.get(ProjectResultEntity.class,pe.getId());
                        if (projectResultEntity != null){
                            ProjectResultVO projectResultVO = new ProjectResultVO();
                            projectResultVO.copyEntity(projectResultEntity);

                            // 将projectResultEntity中的pcId改为所对应的赛事级别
                            if (!StringUtils.isEmpty(projectResultEntity.getPcId())){
                                switch (Integer.parseInt(projectResultEntity.getPcId())){
                                    case 1 : projectResultVO.setPcId("校级");
                                        break;
                                    case 2 : projectResultVO.setPcId("市级");
                                        break;
                                    case 3 : projectResultVO.setPcId("省级");
                                        break;
                                    case 4 : projectResultVO.setPcId("区域级");
                                        break;
                                    case 5 : projectResultVO.setPcId("全国级");
                                        break;
                                    default:break;
                                }
                            }
                            projectResultVOs.add(projectResultVO);
                            map.put("projectResultVOs",projectResultVOs);
                        }else {
                            projectResultVOs.add(new ProjectResultVO());
                            map.put("projectResultVOs",projectResultVOs);
                        }

                        // 查询创业基金/基地的申请表
                        List<ProjectApplyEntity> projectApplyEntityList = this.sysServiceI.findByProperty(ProjectApplyEntity.class,"projectId",pe.getId());

                        if (projectApplyEntityList != null && projectApplyEntityList.size() > 0){
                            for(ProjectApplyEntity pae:projectApplyEntityList){
                                // 根据基金/基地的申请表查询基金和基地
                                if (!StringUtils.isEmpty(pae.getType())){
                                    // type:  1=基金  2=基地
                                    if ("1".equals(pae.getType() + "")){
                                        FoundEntity foundEntity = this.sysServiceI.get(FoundEntity.class,pae.getOutId());

                                        if (foundEntity != null){
                                            FoundVO foundVO = new FoundVO();
                                            foundVO.copyEntity(foundEntity);
                                            foundVOs.add(foundVO);
                                            map.put("foundVOs",foundVOs);
                                        }else {
                                            foundVOs.add(new FoundVO());
                                            map.put("foundVOs",foundVOs);
                                        }

                                    }else if ("2".equals(pae.getType() + "")){
                                        BasesEntity basesEntity = this.sysServiceI.get(BasesEntity.class,pae.getOutId());

                                        if (basesEntity != null){
                                            BasesVO basesVO = new BasesVO();
                                            basesVO.copyEntity(basesEntity);
                                            basesVOs.add(basesVO);
                                            map.put("basesVOs",basesVOs);
                                        }else {
                                            basesVOs.add(new BasesVO());
                                            map.put("basesVOs",basesVOs);
                                        }
                                    }
                                }
                            }
                        }else {
                            foundVOs.add(new FoundVO());
                            map.put("foundVOs",foundVOs);
                            basesVOs.add(new BasesVO());
                            map.put("basesVOs",basesVOs);
                        }
                        list.add(map);
                    }
                }

                mode.setResult(list);
                replyDataMode.setData(mode);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);
            }
        }else {

            replyDataMode.setStatusCode("请您登陆!");
            replyDataMode.setSuccess(false);
        }

        return replyDataMode;
    }


    /**
     * 教师/创业管理/关注项目
     * @param request
     * @return
     */
    @RequestMapping(value = "focusOnProject")
    @ResponseBody
    public ReplyDataMode focusOnProject(CollentionsSearchForm collentionsSearchForm,HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if (user != null){
            if ("teacher".equals(user.getRolecode())){
                if (collentionsSearchForm.getPageNo() != null && collentionsSearchForm.getPageNo() != null) {
                    int pageNo = Integer.parseInt(collentionsSearchForm.getPageNo());
                    int pageSize = Integer.parseInt(collentionsSearchForm.getPageSize());

                    collentionsSearchForm.setUserId(user.getId());
                    collentionsSearchForm.setType("1");         // 关注项目
                    collentionsSearchForm.setIsDelete("0");
                    CriteriaQuery criteriaQuery = collentionsSearchForm.getCriteriaQuery();
                    criteriaQuery.addOrder("createTime","desc");

                    PageMode mode = this.sysServiceI.list4page(criteriaQuery,pageNo,pageSize);
                    List<CollentionsEntity> collentionsEntityList = mode.getResult();
                    List<ProjectVO> projectVOs = new ArrayList<ProjectVO>();

                    if (collentionsEntityList != null && collentionsEntityList.size() > 0){
                        for (CollentionsEntity ce:collentionsEntityList){
                            ProjectEntity projectEntity = this.sysServiceI.get(ProjectEntity.class,ce.getOutId());
                            GeneralUserEntity generalUserEntity = this.sysServiceI.get(GeneralUserEntity.class,projectEntity.getUserId());
                            if (projectEntity != null){
                                ProjectVO projectVO = new ProjectVO();
                                projectVO.copyEntity(projectEntity);
                                if (generalUserEntity != null){
                                    projectVO.setUserName(generalUserEntity.getRealname());
                                }
                                projectVOs.add(projectVO);
                            }
                        }
                    }

                    mode.setResult(projectVOs);
                    replyDataMode.setData(mode);
                    replyDataMode.setStatusCode("200");
                    replyDataMode.setSuccess(true);
                }else {
                    replyDataMode.setStatusCode("请您设置分页!");
                    replyDataMode.setSuccess(false);
                }
            }else {
                replyDataMode.setStatusCode("您的角色不是教师!");
                replyDataMode.setSuccess(false);
            }
        }else {
            replyDataMode.setStatusCode("请您登陆!");
            replyDataMode.setSuccess(false);
        }

        return replyDataMode;
    }
}
