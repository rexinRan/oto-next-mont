package com.buss.project.projects.controller;
import com.alibaba.fastjson.JSON;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.collentions.entity.CollentionsEntity;
import com.buss.common.redis.RedisClient;
import com.buss.common.redis.cache.CacheKey;
import com.buss.common.service.SysServiceI;
import com.buss.dist.entity.DxsDistProjectClassEntity;
import com.buss.project.projectapply.entity.ProjectApplyEntity;
import com.buss.project.projectresult.entity.ProjectResultEntity;
import com.buss.project.projects.entity.ProjectEntity;
import com.buss.project.projects.trans.form.ProjectSearchForm;
import com.buss.project.projects.trans.vo.ProjectVO;
import com.buss.project.projectusers.entity.ProjectUsersEntity;
import com.buss.usercompancy.entity.UserCompancyEntity;
import com.buss.usercompancy.trans.form.UserCompancySearchForm;
import com.buss.userdetail.entity.UserDetailEntity;
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
@RequestMapping("/project")
public class ProjectController {

    @Resource
    private SysServiceI sysService;
    @Resource
    private RedisClient redisClient;


    @RequestMapping("/indexPageList.do")
    @ResponseBody
    public ReplyDataMode indexPageList(String projectClass,String isInvestForm, String isBaseForm, ProjectSearchForm searchForm, HttpServletRequest request){

        ReplyDataMode replyDataMode  = new ReplyDataMode();
//        String key = "";
//        if ("on".equals(CacheKey.REDIS_SWITCH)) {
//        /* 根据searchForm传递的参数，判断调用哪个缓存 */
//            key = CacheKey.INDEX_PROJECT;
//            // TODO 查Redis缓存
//            Object cache = redisClient.get(key);
//            if (cache != null) {
//                replyDataMode.setData(cache);
//                replyDataMode.setStatusCode("201-读缓存");
//                replyDataMode.setSuccess(true);
//                return replyDataMode;
//            }
//        }

        String date = searchForm.getCreateYear();
        String year = "";
        if(date!=null&&!"".equals(date)){
            Integer length = date.length();
            year = date.substring(0,length-1);
            searchForm.setCreateYear(year);
        }
        if(searchForm.getIsFound()!=null&&"已获投资".equals(searchForm.getIsFound())){
            searchForm.setIsFound("1");
        }
        if(searchForm.getIsFound()!=null&&"未获投资".equals(searchForm.getIsFound())){
            searchForm.setIsFound("0");
        }
        if(searchForm.getIsAddress()!=null&&"已获基地".equals(searchForm.getIsAddress())){
            searchForm.setIsAddress("1");
        }
        if(searchForm.getIsAddress()!=null&&"未获基地".equals(searchForm.getIsAddress())){
            searchForm.setIsAddress("0");
        }
        searchForm.setIsDelete("0");
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("createTime", "desc");
        orderMap.put("updateTime", "desc");
        criteriaQuery.setOrder(orderMap);

        int pageNo = Integer.parseInt(searchForm.getPageNo());
        int pageSize = Integer.parseInt(searchForm.getPageSize());

        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
        List<ProjectEntity> project = mode.getResult();

        List<ProjectVO> projectVOs = new ArrayList<ProjectVO>();

        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        for (ProjectEntity projectEntity:project) {

            ProjectVO projectVO = new ProjectVO();
            projectVO.copyEntity(projectEntity);

            //所在学校
            String userId = projectVO.getUserId();
            UserDetailEntity userDetailEntity = new UserDetailEntity();
            userDetailEntity.setIsDelete(0);
            userDetailEntity.setUserId(userId);
            List userDetails = this.sysService.findByExample(UserDetailEntity.class.getName(),userDetailEntity);
            if(userDetails!=null&&userDetails.size()!=0){
                UserDetailEntity userDetail = (UserDetailEntity) userDetails.get(0);
                projectVO.setSchoolName(userDetail.getSchoolName());
                projectVO.setUserName(userDetail.getName());
            }


            //项目所在地址
            if(projectVO.getProjectAddress()!=null&&!"".equals(projectVO.getProjectAddress())){

                String address = projectVO.getProjectAddress().replace("#","");
                projectVO.setProjectAddress(address);
            }

            //是否关注、收藏
            projectVO.setIsCollention("未关注");
            if(user!=null){
                CollentionsEntity collentionEntity = new CollentionsEntity();
                collentionEntity.setOutId(projectVO.getId());
                collentionEntity.setUserId(user.getId());
                collentionEntity.setIsDelete(0);
                List collentions = this.sysService.findByExample(CollentionsEntity.class.getName(),collentionEntity);
                if(collentions != null&&collentions.size()>0){
                    projectVO.setIsCollention("已关注");
                }
            }

            projectVOs.add(projectVO);

        }

        mode.setResult(projectVOs);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

//        if (key != "") {
//            // TODO 设置Redis缓存
//            Object obj = JSON.toJSON(mode);
//            redisClient.put(key, obj);
//        }

        return replyDataMode;
    }

//    @RequestMapping("/pageList.do")
//    @ResponseBody
//    public ReplyDataMode projectPageList(String projectClass,String isInvestForm, String isBaseForm, ProjectSearchForm searchForm, HttpServletRequest request){
//
//        String date = searchForm.getCreateTime();
//        String year = "";
//        if(date!=null&&!"".equals(date)){
//            Integer length = date.length();
//            year = date.substring(0,length-1);
//        }
//        searchForm.setCreateTime(null);
//        searchForm.setIsDelete("0");
//        ReplyDataMode replyDataMode  = new ReplyDataMode();
//        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();
//
//        Map<String, Object> orderMap = new HashMap<>();
//        orderMap.put("createTime", "desc");
//        orderMap.put("updateTime", "desc");
//        criteriaQuery.setOrder(orderMap);
//
//        int pageNo = Integer.parseInt(searchForm.getPageNo());
//        int pageSize = Integer.parseInt(searchForm.getPageSize());
//
//        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
//        List<ProjectEntity> project = mode.getResult();
//
//        List<ProjectVO> projectVOs = new ArrayList<ProjectVO>();
//
//        Subject currentUser = SecurityUtils.getSubject();
//        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
//
//        for (ProjectEntity projectEntity:project) {
//
//            ProjectVO projectVO = new ProjectVO();
//            projectVO.copyEntity(projectEntity);
//            //判断年份
//            if(!"".equals(year)){
//
//                Calendar c = Calendar.getInstance();
//                c.setTime(projectEntity.getCreateTime());
//                Integer years = c.get(Calendar.YEAR);
//                String yearString =years.toString();
//                if(!year.equals(yearString)){
//                    continue;
//                }
//            }
//
//
//            //返回是否获得投资
//            String isInvest = "已获投资";
//            ProjectApplyEntity projectApplyEntity = new ProjectApplyEntity();
//            projectApplyEntity.setProjectId(projectEntity.getId());
//            projectApplyEntity.setType(1);
//            projectApplyEntity.setResult(1);
//            List projectApplyList = this.sysService.findByExample(ProjectApplyEntity.class.getName(),projectApplyEntity);
//            if (projectApplyList==null||projectApplyList.size()==0){
//                isInvest = "未获投资";
//            }
//            projectVO.setIsInvest(isInvest);
//            if(isInvestForm!=null&&!"".equals(isInvestForm)){
//                if(!isInvest.equals(isInvestForm)){
//                    continue;
//                }
//            }
//
//            //返回是否获得投资
//            String isBase = "已获基地";
//            ProjectApplyEntity projectApply = new ProjectApplyEntity();
//            projectApply.setProjectId(projectEntity.getId());
//            projectApply.setType(2);
//            projectApply.setResult(1);
//            List projectApplyBaseList = this.sysService.findByExample(ProjectApplyEntity.class.getName(),projectApply);
//            if (projectApplyBaseList==null||projectApplyBaseList.size()==0){
//                isBase = "未获基地";
//            }
//            projectVO.setIsBase(isBase);
//            if(isBaseForm!=null&&!"".equals(isBaseForm)){
//                if(!isBase.equals(isBaseForm)){
//                    continue;
//                }
//            }
//
//            //所在学校
//            String userId = projectVO.getUserId();
//            UserDetailEntity userDetailEntity = new UserDetailEntity();
//            userDetailEntity.setIsDelete(0);
//            userDetailEntity.setUserId(userId);
//            List userDetails = this.sysService.findByExample(UserDetailEntity.class.getName(),userDetailEntity);
//            if(userDetails!=null&&userDetails.size()!=0){
//                UserDetailEntity userDetail = (UserDetailEntity) userDetails.get(0);
//                projectVO.setSchoolName(userDetail.getSchoolName());
//                projectVO.setUserName(userDetail.getName());
//            }
//
//            //项目参加大赛所获级别
//            ProjectResultEntity projectResultEntity = new ProjectResultEntity();
//            projectResultEntity.setIsDelete(0);
//            projectResultEntity.setPId(projectVO.getId());
//            projectResultEntity.setResult(2);
//            List projectResults = this.sysService.findByExample(ProjectResultEntity.class.getName(),projectResultEntity);
//            if(projectResults!=null&&projectResults.size()!=0){
//                String pcNames = "";
//                for (Object o: projectResults) {
//                    ProjectResultEntity projectResult = (ProjectResultEntity) o;
//                    String pcName = this.sysService.get(DxsDistProjectClassEntity.class,projectResult.getPcId()).getProjectClass();
//                    pcNames = pcNames + pcName + " " ;
//
//                }
//                if(projectClass!=null&&!"".equals(projectClass)){
//
//                    boolean b = pcNames.contains(projectClass);
//                    if(!b){
//                        continue;
//                    }
//                }
//                projectVO.setPcNames(pcNames);
//            }else if(projectClass!=null&&!"".equals(projectClass)){
//                continue;
//            }
//
//
//            //项目所在地址
//            if(projectVO.getProjectAddress()!=null&&!"".equals(projectVO.getProjectAddress())){
//
//                String address = projectVO.getProjectAddress().replace("#","");
//                projectVO.setProjectAddress(address);
//            }
//
//            //是否关注、收藏
//            projectVO.setIsCollention("未关注");
//            if(user!=null){
//                CollentionsEntity collentionEntity = new CollentionsEntity();
//                collentionEntity.setOutId(projectVO.getId());
//                collentionEntity.setUserId(user.getId());
//                collentionEntity.setIsDelete(0);
//                List collentions = this.sysService.findByExample(CollentionsEntity.class.getName(),collentionEntity);
//                if(collentions != null&&collentions.size()>0){
//                    projectVO.setIsCollention("已关注");
//                }
//            }
//
//            projectVOs.add(projectVO);
//
//        }
//
//        mode.setResult(projectVOs);
//        replyDataMode.setData(mode);
//        replyDataMode.setStatusCode("200");
//        replyDataMode.setSuccess(true);
//
//        return replyDataMode;
//    }

    /**
     * 创业项目
     * @param searchForm
     * @param request
     * @return
     */
    @RequestMapping("/pageList.do")
    @ResponseBody
    public ReplyDataMode projectPageList( ProjectSearchForm searchForm, HttpServletRequest request){

        String date = searchForm.getCreateYear();
        String year = "";
        if(date!=null&&!"".equals(date)){
            Integer length = date.length();
            year = date.substring(0,length-1);
            searchForm.setCreateYear(year);
        }
        if(searchForm.getIsFound()!=null&&"已获投资".equals(searchForm.getIsFound())){
            searchForm.setIsFound("1");
        }
        if(searchForm.getIsFound()!=null&&"未获投资".equals(searchForm.getIsFound())){
            searchForm.setIsFound("0");
        }
        if(searchForm.getIsAddress()!=null&&"已获基地".equals(searchForm.getIsAddress())){
            searchForm.setIsAddress("1");
        }
        if(searchForm.getIsAddress()!=null&&"未获基地".equals(searchForm.getIsAddress())){
            searchForm.setIsAddress("0");
        }
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode  = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("createTime", "desc");
        orderMap.put("updateTime", "desc");
        criteriaQuery.setOrder(orderMap);

        int pageNo = Integer.parseInt(searchForm.getPageNo());
        int pageSize = Integer.parseInt(searchForm.getPageSize());

        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
        List<ProjectEntity> project = mode.getResult();

        List<ProjectVO> projectVOs = new ArrayList<ProjectVO>();

        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        for (ProjectEntity projectEntity:project) {

            ProjectVO projectVO = new ProjectVO();
            projectVO.copyEntity(projectEntity);

            //所在学校
            String userId = projectVO.getUserId();
            UserDetailEntity userDetailEntity = new UserDetailEntity();
            userDetailEntity.setIsDelete(0);
            userDetailEntity.setUserId(userId);
            List userDetails = this.sysService.findByExample(UserDetailEntity.class.getName(),userDetailEntity);
            if(userDetails!=null&&userDetails.size()!=0){
                UserDetailEntity userDetail = (UserDetailEntity) userDetails.get(0);
                projectVO.setSchoolName(userDetail.getSchoolName());
                projectVO.setUserName(userDetail.getName());
            }


            //项目所在地址
            if(projectVO.getProjectAddress()!=null&&!"".equals(projectVO.getProjectAddress())){

                String address = projectVO.getProjectAddress().replace("#","");
                projectVO.setProjectAddress(address);
            }

            //是否关注、收藏
            projectVO.setIsCollention("未关注");
            if(user!=null){
                CollentionsEntity collentionEntity = new CollentionsEntity();
                collentionEntity.setOutId(projectVO.getId());
                collentionEntity.setUserId(user.getId());
                collentionEntity.setIsDelete(0);
                List collentions = this.sysService.findByExample(CollentionsEntity.class.getName(),collentionEntity);
                if(collentions != null&&collentions.size()>0){
                    projectVO.setIsCollention("已关注");
                }
            }

            projectVOs.add(projectVO);

        }

        mode.setResult(projectVOs);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

    @RequestMapping("/projectById.do")
    @ResponseBody
    public ReplyDataMode projectById( ProjectSearchForm searchForm, HttpServletRequest request){

        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode  = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("createTime", "desc");
        orderMap.put("updateTime", "desc");
        criteriaQuery.setOrder(orderMap);

        List<ProjectEntity> project = this.sysService.list(criteriaQuery);
        List<ProjectVO> projectVOs = new ArrayList<ProjectVO>();

        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        for (ProjectEntity projectEntity:project) {

            ProjectVO projectVO = new ProjectVO();
            projectVO.copyEntity(projectEntity);

            //所在学校
            String userId = projectVO.getUserId();
            UserDetailEntity userDetailEntity = new UserDetailEntity();
            userDetailEntity.setIsDelete(0);
            userDetailEntity.setUserId(userId);
            List userDetails = this.sysService.findByExample(UserDetailEntity.class.getName(),userDetailEntity);
            if(userDetails!=null&&userDetails.size()!=0){
                UserDetailEntity userDetail = (UserDetailEntity) userDetails.get(0);
                projectVO.setSchoolName(userDetail.getSchoolName());
                projectVO.setUserName(userDetail.getName());
            }

            //项目所在地址
            if(projectVO.getProjectAddress()!=null&&!"".equals(projectVO.getProjectAddress())){

                String address = projectVO.getProjectAddress().replace("#","");
                projectVO.setProjectAddress(address);
            }

            //是否关注、收藏
            projectVO.setIsCollention("未关注");
            if(user!=null){
                CollentionsEntity collentionEntity = new CollentionsEntity();
                collentionEntity.setOutId(projectVO.getId());
                collentionEntity.setUserId(user.getId());
                collentionEntity.setIsDelete(0);
                List collentions = this.sysService.findByExample(CollentionsEntity.class.getName(),collentionEntity);
                if(collentions != null&&collentions.size()>0){
                    projectVO.setIsCollention("已关注");
                }
            }

            projectVOs.add(projectVO);

        }

        replyDataMode.setData(projectVOs);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


    @RequestMapping("/saveProject.do")
    @ResponseBody
    public ReplyDataMode saveProject(String names, String idCards, ProjectSearchForm searchForm, HttpServletRequest request){

        ReplyDataMode replyDataMode = new ReplyDataMode();
        //获取用户登录信息
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        //设置已确定字段
        ProjectEntity projectsEntity = (ProjectEntity) searchForm.toEntity();
        projectsEntity.setUserId(user.getId());
        projectsEntity.setIsDelete(0);
        projectsEntity.setIsAddress(0);
        projectsEntity.setIsFound(0);
        Date date = new Date();
        projectsEntity.setCreateTime(date);
        projectsEntity.setUpdateTime(date);

        boolean flag = false;
        try {

            this.sysService.saveOrUpdate(projectsEntity);
            flag = true;

        }catch (Exception e){

        }


        String [] name = names.split(",");
        String [] idCard = idCards.split(",");
        for (int i = 0; i< name.length;i++) {
            ProjectUsersEntity projectUsers = new ProjectUsersEntity();
            UserDetailEntity userDetail = new UserDetailEntity();
            userDetail.setIdcard(idCard[i]);
            userDetail.setIsDelete(0);
            List userList = this.sysService.findByExample(UserDetailEntity.class.getName(),userDetail);
            if(userList!=null&&userList.size()!=0){

                UserDetailEntity userDetailEntity = (UserDetailEntity) userList.get(0);
                projectUsers.setUserId(userDetailEntity.getUserId());
            }
            projectUsers.setName(name[i]);
            projectUsers.setIdCard(idCard[i]);
            projectUsers.setIsDelete(0);
            projectUsers.setCreateTime(date);
            projectUsers.setUpdateTime(date);
            try {

                this.sysService.saveOrUpdate(projectUsers);
                flag = true;

            }catch (Exception e){
                flag = false;
            }
        }

        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(flag);

        return replyDataMode;
    }


}