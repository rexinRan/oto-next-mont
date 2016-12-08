package com.buss.trainonlinecourse.controller;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.authentication.controller.AuthenticationController;
import com.buss.authentication.entity.DxsAuthenticationEntity;
import com.buss.authentication.trans.form.AuthenticationSearchForm;
import com.buss.common.service.SysServiceI;


import com.buss.traincoursevideo.entity.TrainCourseVideoEntity;
import com.buss.traincoursevideo.trans.vo.TrainCourseVideoVO;
import com.buss.trainonlinecourse.entity.TrainOnlineCourseEntity;
import com.buss.trainonlinecourse.trans.form.TrainOnlineCourseSearchForm;
import com.buss.trainonlinecourse.trans.vo.TrainOnlineCourseVO;
import com.buss.trainonlinecourseuser.entity.TrainOnlineCourseUserEntity;
import com.buss.userdetail.entity.UserDetailEntity;
import com.buss.userdetail.trans.vo.UserDetailVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.jweb.core.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.swing.text.StyledEditorKit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author lu
 *
 */
@Controller
@RequestMapping("/trainOnlineCourse")
public class TrainOnlineCourseController {

    @Resource
    private SysServiceI sysService;

    @RequestMapping("/list.do")
    @ResponseBody
    public ReplyDataMode trainList(TrainOnlineCourseSearchForm searchForm, HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String,Object> orderMap = new HashMap<String,Object>();
        orderMap.put("sort","desc");
        orderMap.put("createTime", "desc");
        criteriaQuery.setOrder(orderMap);

        List<TrainOnlineCourseEntity> trainOnlineCourses = this.sysService.list(criteriaQuery);
        List<TrainOnlineCourseVO> trainOnlineCourseVOs = new ArrayList<TrainOnlineCourseVO>();

        for (TrainOnlineCourseEntity trainOnlineCourseEntity:trainOnlineCourses) {
            TrainOnlineCourseVO trainOnlineCourseVO = new TrainOnlineCourseVO();
            trainOnlineCourseVO.copyEntity(trainOnlineCourseEntity);
            trainOnlineCourseVOs.add(trainOnlineCourseVO);

        }
        replyDataMode.setData(trainOnlineCourseVOs);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


    @RequestMapping("/pageList.do")
    @ResponseBody
    public ReplyDataMode trainOnlineCoursePageList(TrainOnlineCourseSearchForm searchForm, HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("sort","asc");
        orderMap.put("createTime", "desc");
        criteriaQuery.setOrder(orderMap);

        int pageNo = Integer.parseInt(searchForm.getPageNo());
        int pageSize = Integer.parseInt(searchForm.getPageSize());


        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
        List<TrainOnlineCourseEntity> trainOnlineCourses = mode.getResult();

        List<Map> trainOnlineCourseVOs = new ArrayList<>();

        for (TrainOnlineCourseEntity trainOnlineCourseEntity:trainOnlineCourses) {
            Map map = new HashMap();
            TrainOnlineCourseVO trainOnlineCourseVO = new TrainOnlineCourseVO();
            trainOnlineCourseVO.copyEntity(trainOnlineCourseEntity);
            map.put("trainOnlineCourseVO",trainOnlineCourseVO);
            UserDetailEntity userDetailEntity = new UserDetailEntity();
            userDetailEntity.setIsDelete(0);
            userDetailEntity.setUserId(trainOnlineCourseVO.getUserId());
            List<UserDetailEntity> userDetailList = this.sysService.findByExample(UserDetailEntity.class.getName(),userDetailEntity);
            if(userDetailList!=null&&userDetailList.size()!=0){
                UserDetailEntity userDetail = userDetailList.get(0);
                map.put("userDetail",userDetail);
            }else {
                UserDetailVO userDetailVO = new UserDetailVO();
                map.put("userDetail",userDetailVO);

            }
            trainOnlineCourseVOs.add(map);

        }
        mode.setResult(trainOnlineCourseVOs);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


    @RequestMapping("/trainOnlineCourseById.do")
    @ResponseBody
    public ReplyDataMode trainOnlineCourseById(TrainOnlineCourseSearchForm searchForm, HttpServletRequest request){



        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        List<TrainOnlineCourseEntity> trainOnlineCourses = this.sysService.list(criteriaQuery);

        Map map = new HashMap();
        map.put("trainOnlineCourseVO",null);
        map.put("trainVideoList",null);


        if(trainOnlineCourses!=null&&trainOnlineCourses.size()!=0){
            TrainOnlineCourseEntity trainOnlineCourseEntity = trainOnlineCourses.get(0);

            TrainOnlineCourseVO trainOnlineCourseVO = new TrainOnlineCourseVO();
            trainOnlineCourseVO.copyEntity(trainOnlineCourseEntity);

            //获取用户登录信息
            Subject currentUser = SecurityUtils.getSubject();
            AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
            String status = "未开通";
            if(user!=null){
                TrainOnlineCourseUserEntity trainOnlineCourseUserEntity = new TrainOnlineCourseUserEntity();
                trainOnlineCourseUserEntity.setIsDelete(0);
                trainOnlineCourseUserEntity.setUserId(user.getId());
                trainOnlineCourseUserEntity.setTocId(trainOnlineCourseVO.getId());
                List<TrainOnlineCourseUserEntity> trainOnlineCourseUserEntityList = this.sysService.findByExample(TrainOnlineCourseUserEntity.class.getName(),trainOnlineCourseUserEntity);
                if(trainOnlineCourseUserEntityList!=null&&trainOnlineCourseUserEntityList.size()!=0){
                    status = "已开通";
                }
            }

            map.put("trainOnlineCourseVO",trainOnlineCourseVO);
            TrainCourseVideoEntity trainCourseVideoEntity = new TrainCourseVideoEntity();
            trainCourseVideoEntity.setIsDelete(0);
            trainCourseVideoEntity.setTocId(trainOnlineCourseVO.getId());
            List<TrainCourseVideoEntity> trainVideoList = this.sysService.findByExample(TrainCourseVideoEntity.class.getName(),trainCourseVideoEntity);
            List<TrainCourseVideoVO> TrainCourseVideoVOs = new ArrayList<>();
            if(trainVideoList!=null&&trainVideoList.size()!=0){
                for(TrainCourseVideoEntity trainCourseVideo:trainVideoList){
                    TrainCourseVideoVO trainCourseVideoVO = new TrainCourseVideoVO();
                    trainCourseVideoVO.copyEntity(trainCourseVideo);
                    if(trainCourseVideo.getIsFree()==0){
                        trainCourseVideoVO.setStatus("免费");
                    }else {
                        trainCourseVideoVO.setStatus(status);
                    }
                    TrainCourseVideoVOs.add(trainCourseVideoVO);
                }
            }
            map.put("trainVideoList",TrainCourseVideoVOs);

        }


        replyDataMode.setData(map);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }



    @RequestMapping("/teacherCourseList.do")
    @ResponseBody
    public ReplyDataMode teacherCourseList(TrainOnlineCourseSearchForm searchForm,String teacherId, HttpServletRequest request){
        DxsAuthenticationEntity authenticationEntity = this.sysService.get(DxsAuthenticationEntity.class,teacherId);

        searchForm.setUserId(authenticationEntity.getUserId());
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("sort","asc");
        orderMap.put("createTime", "desc");
        criteriaQuery.setOrder(orderMap);

        int pageNo = Integer.parseInt(searchForm.getPageNo());
        int pageSize = Integer.parseInt(searchForm.getPageSize());


        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
        List<TrainOnlineCourseEntity> trainOnlineCourses = mode.getResult();

        List<Map> trainOnlineCourseVOs = new ArrayList<>();

        for (TrainOnlineCourseEntity trainOnlineCourseEntity:trainOnlineCourses) {
            Map map = new HashMap();
            TrainOnlineCourseVO trainOnlineCourseVO = new TrainOnlineCourseVO();
            trainOnlineCourseVO.copyEntity(trainOnlineCourseEntity);
            map.put("trainOnlineCourseVO",trainOnlineCourseVO);
            UserDetailEntity userDetailEntity = new UserDetailEntity();
            userDetailEntity.setIsDelete(0);
            userDetailEntity.setUserId(trainOnlineCourseVO.getUserId());
            List<UserDetailEntity> userDetailList = this.sysService.findByExample(UserDetailEntity.class.getName(),userDetailEntity);
            if(userDetailList!=null&&userDetailList.size()!=0){
                UserDetailEntity userDetail = userDetailList.get(0);
                map.put("userDetail",userDetail);
            }
            trainOnlineCourseVOs.add(map);

        }
        mode.setResult(trainOnlineCourseVOs);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


    /**
     * 教师/个人中心/学习培训/我的课程
     * @param request
     * @return
     */
    @RequestMapping(value = "myLessons")
    @ResponseBody
    public ReplyDataMode myLessons(AuthenticationSearchForm authenticationSearchForm,HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if(user != null){
            if ("teacher".equals(user.getRolecode())){
                // 分页模型设置
                PageMode mode = new PageMode();
                int total = 0;
                int pageNo = 0;
                int pageSize = 0;
                StringBuffer sb_limit = new StringBuffer();
                if (!StringUtil.isEmpty(authenticationSearchForm.getPageNo()) && !StringUtil.isEmpty(authenticationSearchForm.getPageSize())) {
                    pageNo = Integer.parseInt(authenticationSearchForm.getPageNo());
                    pageSize = Integer.parseInt(authenticationSearchForm.getPageSize());
                    sb_limit.append(" LIMIT " + (pageNo - 1) + "," + pageSize);

                    List<DxsAuthenticationEntity> authenticationEntityList = this.sysService.findByProperty(DxsAuthenticationEntity.class,"userId",user.getId());

                    if (authenticationEntityList != null && authenticationEntityList.size() > 0){
                        for (DxsAuthenticationEntity dae:authenticationEntityList){
                            if (!StringUtil.isEmpty(dae.getAuthenticationResult())){
                                if ("8".equals(dae.getAuthenticationResult()) || "11".equals(dae.getAuthenticationResult()) ||
                                        "20".equals(dae.getAuthenticationResult()) || "14".equals(dae.getAuthenticationResult()) ||
                                        "17".equals(dae.getAuthenticationResult())){

                                    String data_sql = "select * from \n" +
                                            "(\n" +
                                            "SELECT\n" +
                                            "\ttoc.id t1,\n" +
                                            "\ttoc.title t2,\n" +
                                            "\ttcc.catalog_name t3,\n" +
                                            "\ttocu.create_time t4,\n" +
                                            "\ttoc.account t5,\n" +
                                            "\ttoc.remarks t6\n" +
                                            "FROM\n" +
                                            "\n" +
                                            "\tdxs_train_outline_course toc,\n" +
                                            "\tdxs_train_course_catalog tcc,\n" +
                                            "\tdxs_train_online_course_user tocu\n" +
                                            "WHERE\n" +
                                            "\ttoc.user_id = '" + user.getId() + "'\n" +
                                            "AND toc.tcc_id = tcc.id\n" +
                                            "AND tocu.user_id = '" + user.getId() + "'\n" +
                                            "AND tocu.toc_id = toc.id\n" +
                                            "AND tocu.result = 1\n" +
                                            "AND tocu.toc_id = toc.id\n" +
                                            "AND toc.is_delete  = 0\n" +
                                            "AND tcc.is_delete = 0\n" +
                                            "AND tocu.is_delete = 0\n" +
                                            ") AS a \n" +
                                            "union ALL\n" +
                                            "(\n" +
                                            "SELECT\n" +
                                            "\ttroc.id t1,\n" +
                                            "\ttroc.title t2,\n" +
                                            "\ttcc.catalog_name t3,\n" +
                                            "\ttocu.create_time t4,\n" +
                                            "\ttroc.account t5,\n" +
                                            "\ttroc.remarks t6\n" +
                                            "FROM\n" +
                                            "\tdxs_train_online_course troc,\n" +
                                            "\tdxs_train_course_catalog tcc,\n" +
                                            "\tdxs_train_online_course_user tocu\n" +
                                            "WHERE\n" +
                                            "\ttroc.user_id = '" + user.getId() + "'\n" +
                                            "AND troc.tcc_id = tcc.id\n" +
                                            "AND tocu.user_id = '" + user.getId() + "'\n" +
                                            "AND tocu.result = 1\n" +
                                            "AND tocu.toc_id = troc.id\n" +
                                            "AND troc.is_delete = 0\n" +
                                            "AND tcc.is_delete = 0\n" +
                                            "AND tocu.is_delete = 0\n" +
                                            ") \n" + sb_limit.toString();

                                    String count_Sql = "select COUNT(1) from \n" +
                                            "(\n" +
                                            "SELECT\n" +
                                            "\ttoc.id t1,\n" +
                                            "\ttoc.title t2,\n" +
                                            "\ttcc.catalog_name t3,\n" +
                                            "\ttocu.create_time t4,\n" +
                                            "\ttoc.account t5,\n" +
                                            "\ttoc.remarks t6\n" +
                                            "FROM\n" +
                                            "\n" +
                                            "\tdxs_train_outline_course toc,\n" +
                                            "\tdxs_train_course_catalog tcc,\n" +
                                            "\tdxs_train_online_course_user tocu\n" +
                                            "WHERE\n" +
                                            "\ttoc.user_id = '"+ user.getId() +"'\n" +
                                            "AND toc.tcc_id = tcc.id\n" +
                                            "AND tocu.user_id = '"+ user.getId() +"'\n" +
                                            "AND tocu.toc_id = toc.id\n" +
                                            "AND tocu.result = 1\n" +
                                            "AND tocu.toc_id = toc.id\n" +
                                            "AND toc.is_delete  = 0\n" +
                                            "AND tcc.is_delete = 0\n" +
                                            "AND tocu.is_delete = 0\n" +
                                            "union ALL\n" +
                                            "SELECT\n" +
                                            "\ttroc.id t1,\n" +
                                            "\ttroc.title t2,\n" +
                                            "\ttcc.catalog_name t3,\n" +
                                            "\ttocu.create_time t4,\n" +
                                            "\ttroc.account t5,\n" +
                                            "\ttroc.remarks t6\n" +
                                            "FROM\n" +
                                            "\tdxs_train_online_course troc,\n" +
                                            "\tdxs_train_course_catalog tcc,\n" +
                                            "\tdxs_train_online_course_user tocu\n" +
                                            "WHERE\n" +
                                            "\ttroc.user_id = '"+ user.getId() +"'\n" +
                                            "AND troc.tcc_id = tcc.id\n" +
                                            "AND tocu.user_id = '"+ user.getId() +"'\n" +
                                            "AND tocu.result = 1\n" +
                                            "AND tocu.toc_id = troc.id\n" +
                                            "AND troc.is_delete = 0\n" +
                                            "AND tcc.is_delete = 0\n" +
                                            "AND tocu.is_delete = 0\n" +
                                            ") AS a";

                                    List dataSql = this.sysService.findListbySql(data_sql);

                                    List countSql = this.sysService.findListbySql(count_Sql);

                                    List<Map<String, Object>> aList = new ArrayList();
                                    if (!dataSql.isEmpty())
                                        for (Object obj : dataSql) {
                                        Map map = new HashMap();
                                        Object[] u = (Object[]) obj;
                                        String field = "";
                                        for (int i = 0; i < u.length; i++) {
                                            if (u[i] != null) {
                                                field = u[i].toString();
                                            } else {
                                                field = "";
                                            }
                                            map.put("field" + i, field);
                                        }
                                        aList.add(map);
                                        mode.setTotal(Integer.parseInt(countSql.get(0).toString()));
                                    }

                                    final int allCounts;
                                    if (mode.getTotal() != 0) {
                                        allCounts = mode.getTotal();
                                    } else {
                                        allCounts = 0;
                                    }
                                    int pageCount = 0;
                                    if (pageNo != 0 && pageSize != 0) {
                                        pageCount = (allCounts - 1) / pageSize + 1;
                                    }

                                    mode.setPageCount(pageCount);
                                    mode.setPageNo(pageNo);
                                    mode.setPageSize(pageSize);
                                    mode.setResult(aList);

                                    replyDataMode.setData(mode);
                                    replyDataMode.setStatusCode("200");
                                    replyDataMode.setSuccess(true);
                                }else {
                                    replyDataMode.setStatusCode("您还不是导师,请先申请成为导师!");
                                    replyDataMode.setSuccess(false);
                                }
                            }
                        }
                    }else {
                        replyDataMode.setStatusCode("您还不是导师,请先申请成为导师!");
                        replyDataMode.setSuccess(false);
                    }
                }else {
                    replyDataMode.setStatusCode("请设置分页!");
                    replyDataMode.setSuccess(false);
                }
            }else {
                replyDataMode.setStatusCode("您不是教师!");
                replyDataMode.setSuccess(false);
            }
        }else {
            replyDataMode.setStatusCode("请您登录!");
            replyDataMode.setSuccess(false);
        }
        return replyDataMode;
    }
}

