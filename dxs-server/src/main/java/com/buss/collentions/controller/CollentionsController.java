package com.buss.collentions.controller;

import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.authentication.entity.DxsAuthenticationEntity;
import com.buss.authentication.trans.vo.AuthenticationVo;
import com.buss.collentions.entity.CollentionsEntity;
import com.buss.collentions.trans.form.CollentionsSearchForm;
import com.buss.collentions.trans.vo.CollentionsVo;
import com.buss.common.model.json.AjaxJson;
import com.buss.common.service.SysServiceI;
import com.buss.employed.entity.EmployedEntity;
import com.buss.project.projects.entity.ProjectEntity;
import com.buss.trainonlinecourse.entity.TrainOnlineCourseEntity;
import com.buss.trainoutlinecourse.entity.TrainOutlineCourseEntity;
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
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author lu
 *
 */
@Controller
@RequestMapping("/collentions")
public class CollentionsController {

    @Resource
    private SysServiceI sysService;




    @RequestMapping("/saveCollention.do")
    @ResponseBody
    public AjaxJson saveCollention(CollentionsSearchForm searchForm, HttpServletRequest request){

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
        CollentionsEntity collentionEntity = (CollentionsEntity) searchForm.toEntity();
        collentionEntity.setUserId(user.getId());
        collentionEntity.setIsDelete(0);

        List collentions = this.sysService.findByExample(CollentionsEntity.class.getName(),collentionEntity);
        if(collentions != null&&collentions.size()>0){
            message = "您已关注/收藏";
            ajaxJson.setSuccess(flag);
            ajaxJson.setMsg(message);
            return ajaxJson;
        }
        Date date = new Date();
        collentionEntity.setCreateTime(date);
        collentionEntity.setUpdateTime(date);

        try {

            this.sysService.saveOrUpdate(collentionEntity);
            flag = true;
            message = "保存成功";

        }catch (Exception e){

        }


        ajaxJson.setSuccess(flag);
        ajaxJson.setMsg(message);


        return ajaxJson;
    }



    @RequestMapping("/pageList.do")
    @ResponseBody
    public ReplyDataMode collentionspageList(CollentionsSearchForm searchForm, HttpServletRequest request){

        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode  = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("createTime", "desc");
        criteriaQuery.setOrder(orderMap);

        int pageNo = Integer.parseInt(searchForm.getPageNo());
        int pageSize = Integer.parseInt(searchForm.getPageSize());

        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
        List<CollentionsEntity> collentions = mode.getResult();

        List<CollentionsVo> collentionsVOs = new ArrayList<CollentionsVo>();

        for (CollentionsEntity collentionsEntity:collentions) {
            CollentionsVo collentionsVO = new CollentionsVo();
            collentionsVO.copyEntity(collentionsEntity);
            collentionsVOs.add(collentionsVO);

        }

        mode.setResult(collentionsVOs);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


    @RequestMapping("/employed.do")
    @ResponseBody
    public ReplyDataMode employed(CollentionsSearchForm searchForm, String employedName,HttpServletRequest request){

        ReplyDataMode replyDataMode  = new ReplyDataMode();

        if(employedName==null||"".equals(employedName)){

            //获取用户登录信息
            Subject currentUser = SecurityUtils.getSubject();
            AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
            if(user!=null){

                searchForm.setUserId(user.getId());
                searchForm.setIsDelete("0");
                searchForm.setType("4");
                CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

                Map<String, Object> orderMap = new HashMap<>();
                orderMap.put("createTime", "desc");
                criteriaQuery.setOrder(orderMap);

                int pageNo = Integer.parseInt(searchForm.getPageNo());
                int pageSize = Integer.parseInt(searchForm.getPageSize());

                PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
                List<CollentionsEntity> collentions = mode.getResult();

                List list = new ArrayList();

                for (CollentionsEntity collentionsEntity:collentions) {
                    Map map = new HashMap();
                    CollentionsVo collentionsVO = new CollentionsVo();
                    collentionsVO.copyEntity(collentionsEntity);
                    String empId = collentionsVO.getOutId();

                    EmployedEntity employedEntity = this.sysService.get(EmployedEntity.class,empId);
                    if(employedEntity.getIsDelete()==0){

                        map.put("empName",employedEntity.getEmployedName());
                        map.put("id",employedEntity.getId());
                        map.put("companyName",employedEntity.getCompancyName());
                        String address = employedEntity.getEmployedPosition();
                        String add = address.replace("#","");
                        map.put("address",add);
                        map.put("number",employedEntity.getEmployedNum());
                        list.add(map);
                    }

                }

                mode.setResult(list);
                replyDataMode.setData(mode);
            }else{
                replyDataMode.setData("请先登录");
            }
        }else{
            PageMode mode = new PageMode();

            //获取用户登录信息
            Subject currentUser = SecurityUtils.getSubject();
            AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
            if(user!=null){

                int pageNo = Integer.parseInt(searchForm.getPageNo());
                int pageSize = Integer.parseInt(searchForm.getPageSize());
                int start = (pageNo-1)*pageSize;

                String sql = "SELECT\n" +
                        "\temployeden1_.COMPANCY_NAME AS COMPANCY3_53_0_,\n" +
                        "\temployeden1_.EMPLOYED_NAME AS EMPLOYE13_53_0_,\n" +
                        "\temployeden1_.EMPLOYED_NUM AS EMPLOYE14_53_0_,\n" +
                        "\temployeden1_.EMPLOYED_POSITION AS EMPLOYE16_53_0_,\n" +
                        "\temployeden1_.ID \n" +
                        "FROM\n" +
                        "\tdxs_collentions this_\n" +
                        "INNER JOIN dxs_employed employeden1_ ON this_.OUT_ID = employeden1_.ID\n" +
                        "WHERE\n" +
                        "\temployeden1_.EMPLOYED_NAME LIKE '%"+employedName+"%'\n" +
                        "AND this_.IS_DELETE = 0\n" +
                        "AND this_.TYPE = '4'\n" +
                        "AND this_.USER_ID = '"+user.getId()+"'\n" +
                        "ORDER BY\n" +
                        "\tthis_.CREATE_TIME DESC\n" +
                        "LIMIT "+start+","+pageSize+"";


                String sql_count = "SELECT\n" +
                        "\tcount(*) AS y0_\n" +
                        "FROM\n" +
                        "\tdxs_collentions this_\n" +
                        "INNER JOIN dxs_employed employeden1_ ON this_.OUT_ID = employeden1_.ID\n" +
                        "WHERE\n" +
                        "\temployeden1_.EMPLOYED_NAME LIKE '%"+employedName+"%'\n" +
                        "AND this_.IS_DELETE =0\n" +
                        "AND this_.TYPE ='4'\n" +
                        "AND this_.USER_ID ='"+user.getId()+"'\n" +
                        "ORDER BY\n" +
                        "\tthis_.CREATE_TIME DESC";

                List aList = this.sysService.findListbySql(sql);
                List bList = this.sysService.findListbySql(sql_count);
                List resultData = new ArrayList();
                for (Object o:aList) {
                    Map map = new HashMap<>();
                    Object[] object = (Object[]) o;
                    String empName = (String) object[1];
                    String companyName = (String) object[0];
                    Integer number = (Integer) object[2];
                    String address = (String) object[3];
                    String add = address.replace("#","");
                    map.put("address",add);
                    map.put("empName",empName);
                    map.put("companyName",companyName);
                    map.put("number",number);
                    map.put("id",(String) object[4]);
                    resultData.add(map);
                }
                mode.setTotal(Integer.parseInt(bList.get(0).toString()));

                final int allCounts;
                if (mode.getTotal() != 0) {
                    allCounts = mode.getTotal();
                } else {
                    allCounts = 0;
                }
                int pageCount = 0;
                if (pageNo!=0 && pageSize!=0) {
                    if(allCounts%pageSize!=0){
                        pageCount = allCounts/pageSize + 1;
                    }else {
                        pageCount = allCounts/pageSize;
                    }

                }
                mode.setPageCount(pageCount);
                mode.setPageNo(pageNo);
                mode.setPageSize(pageSize);
                mode.setResult(resultData);

                replyDataMode.setData(mode);


            }else {
                replyDataMode.setData("请先登录");
            }
        }



        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


    @RequestMapping("/project.do")
    @ResponseBody
    public ReplyDataMode project(CollentionsSearchForm searchForm, HttpServletRequest request){

        ReplyDataMode replyDataMode  = new ReplyDataMode();

        //获取用户登录信息
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
        if(user!=null){
            UserDetailEntity userDetailEntity = new UserDetailEntity();
            userDetailEntity.setIsDelete(0);
            userDetailEntity.setUserId(user.getId());
            List<UserDetailEntity> uList = this.sysService.findByExample(UserDetailEntity.class.getName(),userDetailEntity);
            UserDetailEntity userDetail = uList.get(0);

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
            List<CollentionsEntity> collentions = mode.getResult();

            List list = new ArrayList();

            for (CollentionsEntity collentionsEntity:collentions) {
                Map map = new HashMap();
                CollentionsVo collentionsVO = new CollentionsVo();
                collentionsVO.copyEntity(collentionsEntity);
                String empId = collentionsVO.getOutId();

                ProjectEntity projectEntity = this.sysService.get(ProjectEntity.class,empId);
                if(projectEntity.getIsDelete()==0){

                    map.put("projectName",projectEntity.getProjectName());
                    map.put("projectIntroduce",projectEntity.getProjectIntroduce());
                    map.put("projectClass",projectEntity.getProjectClass());
                    map.put("projectProgress",projectEntity.getProjectProgress());
                    map.put("foundNeed",projectEntity.getFoundNeed());
                    map.put("addressNeed",projectEntity.getAddressNeed());
                    map.put("recruitNeed",projectEntity.getRecruitNeed());
                    map.put("remarks",projectEntity.getRemarks());
                    map.put("id",projectEntity.getId());
                    map.put("projectIndustry",projectEntity.getProjectIndustry());
                    map.put("projectCharge",userDetail.getName());
                    list.add(map);
                }

            }

            mode.setResult(list);
            replyDataMode.setData(mode);
        }else{
            replyDataMode.setData("请先登录");
        }

        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


    @RequestMapping("/teacher.do")
    @ResponseBody
    public ReplyDataMode teacher(CollentionsSearchForm searchForm, HttpServletRequest request){

        ReplyDataMode replyDataMode  = new ReplyDataMode();

        //获取用户登录信息
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
        if(user!=null){

            searchForm.setUserId(user.getId());
            searchForm.setIsDelete("0");
            searchForm.setType("5");
            CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

            Map<String, Object> orderMap = new HashMap<>();
            orderMap.put("createTime", "desc");
            criteriaQuery.setOrder(orderMap);

            int pageNo = Integer.parseInt(searchForm.getPageNo());
            int pageSize = Integer.parseInt(searchForm.getPageSize());

            PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
            List<CollentionsEntity> collentions = mode.getResult();

            List list = new ArrayList();

            for (CollentionsEntity collentionsEntity:collentions) {
                Map map = new HashMap();
                CollentionsVo collentionsVO = new CollentionsVo();
                collentionsVO.copyEntity(collentionsEntity);
                String teacherId = collentionsVO.getOutId();

                DxsAuthenticationEntity authenticationEntity = this.sysService.get(DxsAuthenticationEntity.class,teacherId);
                if(authenticationEntity.getIsDelete()==0){

                    String catelog = authenticationEntity.getAuthenticationResult();
                     if("8".equals(catelog)){
                        map.put("catelog","创业导师");
                    }else if("11".equals(catelog)){
                        map.put("catelog","就业导师");
                    }else if("14".equals(catelog)){
                         map.put("catelog","创客导师");
                     }else if("17".equals(catelog)){
                        map.put("catelog","学习导师");
                    }else if("20".equals(catelog)){
                        map.put("catelog","技能培训导师");
                    }

                    map.put("id",authenticationEntity.getId());
                    map.put("skills",authenticationEntity.getToturSkill());
                    map.put("remarks",authenticationEntity.getRemarks());
                    UserDetailEntity userDetailEntity = new UserDetailEntity();
                    userDetailEntity.setIsDelete(0);
                    userDetailEntity.setUserId(authenticationEntity.getUserId());
                    List<UserDetailEntity> userList = this.sysService.findByExample(UserDetailEntity.class.getName(),userDetailEntity);
                    if(userList!=null&&userList.size()!=0){
                        UserDetailEntity userDetail = userList.get(0);
                        map.put("name",userDetail.getName());
                        map.put("education",userDetail.getSchoolEducation());
                        map.put("position",userDetail.getJobSchoolPosition());
                    }

                    list.add(map);
                }

            }

            mode.setResult(list);
            replyDataMode.setData(mode);
        }else{
            replyDataMode.setData("请先登录");
        }

        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

    @RequestMapping("/course.do")
    @ResponseBody
    public ReplyDataMode course(CollentionsSearchForm searchForm, HttpServletRequest request){

        ReplyDataMode replyDataMode  = new ReplyDataMode();

        //获取用户登录信息
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
        if(user!=null){

            searchForm.setUserId(user.getId());
            searchForm.setIsDelete("0");
            searchForm.setType("3");
            CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

            Map<String, Object> orderMap = new HashMap<>();
            orderMap.put("createTime", "desc");
            criteriaQuery.setOrder(orderMap);

            int pageNo = Integer.parseInt(searchForm.getPageNo());
            int pageSize = Integer.parseInt(searchForm.getPageSize());

            PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
            List<CollentionsEntity> collentions = mode.getResult();

            List list = new ArrayList();

            for (CollentionsEntity collentionsEntity:collentions) {
                Map map = new HashMap();
                CollentionsVo collentionsVO = new CollentionsVo();
                collentionsVO.copyEntity(collentionsEntity);
                String teacherId = collentionsVO.getOutId();

                TrainOnlineCourseEntity trainOnlineCourseEntity = this.sysService.get(TrainOnlineCourseEntity.class,teacherId);
                if(trainOnlineCourseEntity!=null){

                    if(trainOnlineCourseEntity.getIsDelete()==0){

                        Date collentionDate = trainOnlineCourseEntity.getCreateTime();
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String dateString = formatter.format(collentionDate);

                        map.put("name",trainOnlineCourseEntity.getTitle());
                        map.put("catelog",trainOnlineCourseEntity.getTrainCourseCatalog().getCatalogName());
                        map.put("time",dateString);
                        map.put("price",trainOnlineCourseEntity.getCoursePrices());
                        map.put("remarks",trainOnlineCourseEntity.getRemarks());
                        map.put("account",trainOnlineCourseEntity.getAccount());
                        map.put("id",trainOnlineCourseEntity.getId());
                        map.put("type","online");

                        list.add(map);
                    }
                }else {
                    TrainOutlineCourseEntity trainOutlineCourseEntity = this.sysService.get(TrainOutlineCourseEntity.class,teacherId);
                    if(trainOutlineCourseEntity.getIsDelete()==0){

                        Date collentionDate = trainOutlineCourseEntity.getCreateTime();
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        String dateString = formatter.format(collentionDate);

                        map.put("name",trainOutlineCourseEntity.getTitle());
                        map.put("catelog",trainOutlineCourseEntity.getTrainCourseCatalog().getCatalogName());
                        map.put("time",dateString);
                        map.put("price",trainOutlineCourseEntity.getPrice());
                        map.put("remarks",trainOutlineCourseEntity.getRemarks());
                        map.put("account",trainOutlineCourseEntity.getAccount());
                        map.put("id",trainOutlineCourseEntity.getId());
                        map.put("type","outline");

                        list.add(map);
                    }
                }

            }

            mode.setResult(list);
            replyDataMode.setData(mode);
        }else{
            replyDataMode.setData("请先登录");
        }

        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }
    
}