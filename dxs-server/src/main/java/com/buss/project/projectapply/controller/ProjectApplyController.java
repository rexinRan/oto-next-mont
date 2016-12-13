package com.buss.project.projectapply.controller;

import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.model.json.AjaxJson;
import com.buss.common.service.SysServiceI;
import com.buss.project.bases.entity.BasesEntity;
import com.buss.project.founds.entity.FoundEntity;
import com.buss.project.projectapply.entity.ProjectApplyEntity;
import com.buss.project.projectapply.trans.form.ProjectApplySearchForm;
import com.buss.project.projectapply.trans.vo.ProjectApplyVO;
import com.buss.project.projects.entity.ProjectEntity;
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
import java.util.*;

/**
 * @author lu
 *
 */
@Controller
@RequestMapping("/projectApply")
public class ProjectApplyController {

    @Resource
    private SysServiceI sysService;




    @RequestMapping("/saveProjectApply.do")
    @ResponseBody
    public AjaxJson saveProjectApply(ProjectApplySearchForm searchForm, HttpServletRequest request){

        boolean flag = false;
        String message = "保存失败";

        AjaxJson ajaxJson = new AjaxJson();
        //获取用户登录信息
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if(user==null){
            message = "请先登录";
            ajaxJson.setSuccess(flag);
            ajaxJson.setMsg(message);
            return ajaxJson;
        }

        //设置已确定字段
        ProjectApplyEntity projectApplyEntity = (ProjectApplyEntity) searchForm.toEntity();
        projectApplyEntity.setUserId(user.getId());
        projectApplyEntity.setIsDelete(0);

        List projectApply = this.sysService.findByExample(ProjectApplyEntity.class.getName(),projectApplyEntity);
        if(projectApply != null&&projectApply.size()>0){
            message = "您已关注/收藏";
            ajaxJson.setSuccess(flag);
            ajaxJson.setMsg(message);
            return ajaxJson;
        }
        Date date = new Date();
        projectApplyEntity.setCreateTime(date);
        projectApplyEntity.setUpdateTime(date);

        try {

            this.sysService.saveOrUpdate(projectApplyEntity);
            flag = true;
            message = "保存成功";

        }catch (Exception e){

        }


        ajaxJson.setSuccess(flag);
        ajaxJson.setMsg(message);


        return ajaxJson;
    }



    @RequestMapping("/found.do")
    @ResponseBody
    public ReplyDataMode found(ProjectApplySearchForm searchForm, HttpServletRequest request){

        ReplyDataMode replyDataMode  = new ReplyDataMode();
        //获取用户登录信息
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if(user==null){

            String message = "请先登录";
            replyDataMode.setData(message);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);
            return replyDataMode;

        }

        searchForm.setUserId(user.getId());
        searchForm.setIsDelete("0");
        searchForm.setType("1");
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("createTime", "desc");
        criteriaQuery.setOrder(orderMap);

        int pageNo = Integer.parseInt(searchForm.getPageNo());
        int pageSize = Integer.parseInt(searchForm.getPageSize());

        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
        List<ProjectApplyEntity> projectApply = mode.getResult();

        List<Map> maps = new ArrayList<>();

        for (ProjectApplyEntity projectApplyEntity:projectApply) {
            Map map = new HashMap();
            ProjectApplyVO projectApplyVO = new ProjectApplyVO();
            projectApplyVO.copyEntity(projectApplyEntity);
            String projectId = projectApplyVO.getProjectId();
            ProjectEntity projectEntity = this.sysService.get(ProjectEntity.class,projectId);
            map.put("projectName",projectEntity.getProjectName());
            map.put("projectId",projectEntity.getId());
            map.put("projectClass",projectEntity.getProjectClass());
            map.put("projectProgress",projectEntity.getProjectProgress());
            map.put("remarks",projectEntity.getRemarks());
            String  outId = projectApplyVO.getOutId();
            FoundEntity foundEntity = this.sysService.get(FoundEntity.class,outId);
            map.put("foundName",foundEntity.getFoundTitle());
            map.put("foundId",foundEntity.getId());
            maps.add(map);

        }

        mode.setResult(maps);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }



    @RequestMapping("/base.do")
    @ResponseBody
    public ReplyDataMode base(ProjectApplySearchForm searchForm, HttpServletRequest request){

        ReplyDataMode replyDataMode  = new ReplyDataMode();
        //获取用户登录信息
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if(user==null){

            String message = "请先登录";
            replyDataMode.setData(message);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);
            return replyDataMode;

        }

        searchForm.setUserId(user.getId());
        searchForm.setIsDelete("0");
        searchForm.setType("2");
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("createTime", "desc");
        criteriaQuery.setOrder(orderMap);

        int pageNo = Integer.parseInt(searchForm.getPageNo());
        int pageSize = Integer.parseInt(searchForm.getPageSize());

        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
        List<ProjectApplyEntity> projectApply = mode.getResult();

        List<Map> maps = new ArrayList<>();

        for (ProjectApplyEntity projectApplyEntity:projectApply) {
            Map map = new HashMap();
            ProjectApplyVO projectApplyVO = new ProjectApplyVO();
            projectApplyVO.copyEntity(projectApplyEntity);
            String projectId = projectApplyVO.getProjectId();
            ProjectEntity projectEntity = this.sysService.get(ProjectEntity.class,projectId);
            map.put("projectName",projectEntity.getProjectName());
            map.put("projectId",projectEntity.getId());
            map.put("projectClass",projectEntity.getProjectClass());
            map.put("projectProgress",projectEntity.getProjectProgress());
            map.put("remarks",projectEntity.getRemarks());
            String  outId = projectApplyVO.getOutId();
            BasesEntity basesEntity = this.sysService.get(BasesEntity.class,outId);
            map.put("baseName",basesEntity.getBaseName());
            map.put("baseId",basesEntity.getId());
            maps.add(map);

        }

        mode.setResult(maps);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


}