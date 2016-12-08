package com.buss.trainonlinecourseuser.controller;

import com.alibaba.druid.util.StringUtils;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.authentication.entity.DxsAuthenticationEntity;
import com.buss.common.service.SysServiceI;
import com.buss.trainonlinecourseuser.trans.from.TrainOnlineCourseUserFrom;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.util.StringUtil;
import org.omg.CORBA.OBJECT_NOT_EXIST;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by HongXinGuoJi-yzg on 2016/9/27.
 */
@Controller
@RequestMapping("/trainOnlineCourseUser")
public class TrainOnlineCourseUserController {

    @Resource
    private SysServiceI sysServiceI;


    /**
     * 教师(学生)/个人中心/学习培训/购买记录
     * @param trainOnlineCourseUserFrom
     * @param request
     * @return
     */
    @RequestMapping(value = "purchaseRecords")
    @ResponseBody
    public ReplyDataMode purchaseRecords(TrainOnlineCourseUserFrom trainOnlineCourseUserFrom,HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if (user != null){
            String data_sql = "SELECT\n" +
                    "\t*\n" +
                    "FROM\n" +
                    "(\n" +
                    "SELECT\n" +
                    "\ttonc.title t1,\n" +
                    "\ttcc.catalog_name t2,\n" +
                    "\ttonc.price t3,\n" +
                    "\ttonc.account t4,\n" +
                    "\ttonc.remarks y5,\n" +
                    "\ttocu.result t6,\n" +
                    "\ttocu.id t7,\n" +
                    "\ttonc.id t8,\n" +
                    "\ttocu.create_time t9\n" +
                    "FROM\n" +
                    "\tdxs_train_online_course_user tocu,\n" +
                    "\tdxs_train_online_course tonc,\n" +
                    "\tdxs_train_course_catalog tcc\n" +
                    "WHERE\n" +
                    "\t\ttocu.user_id = '"+ user.getId() +"'\n" +
                    "AND tocu.toc_id = tonc.id\n" +
                    "AND tonc.tcc_id = tcc.id\n" +
                    "AND tonc.user_id = '"+ user.getId() +"'\n" +
                    "AND tocu.result = 1\n" +
                    "AND tocu.is_delete = 0\n" +
                    "\tunion\n" +
                    "SELECT\n" +
                    "\ttouc.title t1,\n" +
                    "\ttcc.catalog_name t2,\n" +
                    "\ttouc.price t3,\n" +
                    "\ttouc.account t4,\n" +
                    "\ttouc.remarks y5,\n" +
                    "\ttocu.result t6,\n" +
                    "\ttocu.id t7,\n" +
                    "\ttouc.id t8,\n" +
                    "\ttocu.create_time t9\n" +
                    "FROM\n" +
                    "\tdxs_train_online_course_user tocu,\n" +
                    "\tdxs_train_outline_course touc,\n" +
                    "\tdxs_train_course_catalog tcc\n" +
                    "WHERE\n" +
                    "\t\ttocu.user_id = '"+ user.getId() +"'\n" +
                    "AND tocu.toc_id = touc.id\n" +
                    "AND touc.user_id = '"+ user.getId() +"'\n" +
                    "AND touc.tcc_id = tcc.id\n" +
                    "AND tocu.result = 1\n" +
                    "AND tocu.is_delete = 0\n" +
                    ")\tAS a\n";

            String count_sql = "SELECT\n" +
                    "\tCOUNT(1)\n" +
                    "FROM\n" +
                    "(\n" +
                    "SELECT\n" +
                    "\ttonc.title t1,\n" +
                    "\ttcc.catalog_name t2,\n" +
                    "\ttonc.price t3,\n" +
                    "\ttonc.account t4,\n" +
                    "\ttonc.remarks y5,\n" +
                    "\ttocu.result t6,\n" +
                    "\ttocu.id t7,\n" +
                    "\ttonc.id t8,\n" +
                    "\ttocu.create_time t9\n" +
                    "FROM\n" +
                    "\tdxs_train_online_course_user tocu,\n" +
                    "\tdxs_train_online_course tonc,\n" +
                    "\tdxs_train_course_catalog tcc\n" +
                    "WHERE\n" +
                    "\t\ttocu.user_id = '"+ user.getId() +"'\n" +
                    "AND tocu.result = 1\n" +
                    "AND tocu.toc_id = tonc.id\n" +
                    "AND tonc.user_id = '"+ user.getId() +"'\n" +
                    "AND tonc.tcc_id = tcc.id\n" +
                    "AND tocu.result = 1\n" +
                    "AND tocu.is_delete = 0\n" +
                    "\tunion\n" +
                    "SELECT\n" +
                    "\ttouc.title t1,\n" +
                    "\ttcc.catalog_name t2,\n" +
                    "\ttouc.price t3,\n" +
                    "\ttouc.account t4,\n" +
                    "\ttouc.remarks y5,\n" +
                    "\ttocu.result t6,\n" +
                    "\ttocu.id t7,\n" +
                    "\ttouc.id t8,\n" +
                    "\ttocu.create_time t9\n" +
                    "FROM\n" +
                    "\tdxs_train_online_course_user tocu,\n" +
                    "\tdxs_train_outline_course touc,\n" +
                    "\tdxs_train_course_catalog tcc\n" +
                    "WHERE\n" +
                    "\t\ttocu.user_id = '"+ user.getId() +"'\n" +
                    "AND tocu.result = 1\n" +
                    "AND tocu.toc_id = touc.id\n" +
                    "AND touc.user_id = '"+ user.getId() +"'\n" +
                    "AND touc.tcc_id = tcc.id\n" +
                    "AND tocu.result = 1\n" +
                    "AND tocu.is_delete = 0\n" +
                    ")\tAS a";

            if ("teacher".equals(user.getRolecode())){
                List<DxsAuthenticationEntity> authenticationEntityList = this.sysServiceI.findByProperty(DxsAuthenticationEntity.class, "userId", user.getId());

                if (authenticationEntityList != null && authenticationEntityList.size() > 0) {
                    for (DxsAuthenticationEntity dae : authenticationEntityList) {
                        if (!StringUtil.isEmpty(dae.getAuthenticationResult())) {
                            if ("8".equals(dae.getAuthenticationResult()) || "11".equals(dae.getAuthenticationResult()) ||
                                    "20".equals(dae.getAuthenticationResult()) || "14".equals(dae.getAuthenticationResult()) ||
                                    "17".equals(dae.getAuthenticationResult())) {

                                replyDataMode = this.templet(trainOnlineCourseUserFrom,user,data_sql,count_sql);
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
            } else if ("student".equals(user.getRolecode())) {
                replyDataMode = this.templet(trainOnlineCourseUserFrom,user,data_sql,count_sql);
            }else {
                replyDataMode.setStatusCode("当前身份和所需身份不匹配!");
                replyDataMode.setSuccess(false);
            }
        }else {
            replyDataMode.setStatusCode("请您登陆!");
            replyDataMode.setSuccess(false);
        }
        return replyDataMode;
    }


    /**
     * sql查询模板
     * @param
     * @param user          当前用户
     * @param data_sql      数据
     * @param count_sql     数据总条数
     * @return
     */
    private ReplyDataMode templet(SearchForm form, AuthUserVO user, String data_sql, String count_sql){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        if(user != null) {
            // 分页模型设置
            PageMode mode = new PageMode();
            int total = 0;
            int pageNo = 0;
            int pageSize = 0;
            StringBuffer sb_limit = new StringBuffer();
            if (!StringUtil.isEmpty(form.getPageNo()) && !StringUtil.isEmpty(form.getPageSize())) {
                pageNo = Integer.parseInt(form.getPageNo());
                pageSize = Integer.parseInt(form.getPageSize());
                sb_limit.append(" LIMIT " + (pageNo - 1) + "," + pageSize);

                if (!StringUtil.isEmpty(data_sql) && !StringUtil.isEmpty(count_sql)){
                    List dataSql = this.sysServiceI.findListbySql(data_sql + sb_limit.toString());

                    List countSql = this.sysServiceI.findListbySql(count_sql);

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
                }
            }else {
                replyDataMode.setStatusCode("请设置分页!");
                replyDataMode.setSuccess(false);
            }
        }else {
            replyDataMode.setStatusCode("请您登录!");
            replyDataMode.setSuccess(false);
        }
        return replyDataMode;
    }


    /**
     * 学生/个人中心/学习培训/线下课程&线上课程
     * @param type      0:线下课程   1:线上课程
     * @param trainOnlineCourseUserFrom
     * @return
     */
    @RequestMapping(value = "studentCourse")
    @ResponseBody
    public ReplyDataMode studentCourse(String type,TrainOnlineCourseUserFrom trainOnlineCourseUserFrom){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if(user != null) {
            if ("student".equals(user.getRolecode())) {

                if (!StringUtil.isEmpty(type) && "0".equals(type)){
                    String data_sql = "SELECT\n" +
                            " touc.title t1,\n" +
                            " tcc.catalog_name t2,\n" +
                            " touc.price t3,\n" +
                            " touc.account t4,\n" +
                            " touc.remarks y5,\n" +
                            " tocu.result t6,\n" +
                            " tocu.id t7,\n" +
                            " touc.id t8,\n" +
                            " tocu.create_time t9,\n" +
                            " touc.opening_time t10\n" +
                            "FROM\n" +
                            " dxs_train_online_course_user tocu,\n" +
                            " dxs_train_outline_course touc,\n" +
                            " dxs_train_course_catalog tcc\n" +
                            "WHERE\n" +
                            " tocu.user_id = '"+ user.getId() +"'\n" +
                            "AND tocu.toc_id = touc.id\n" +
                            "AND touc.user_id = '"+user.getId()+"'\n" +
                            "AND touc.tcc_id = tcc.id\n" +
                            "AND tocu.result = 1\n" +
                            "AND tocu.is_delete = 0 ";

                    String count_sql = "SELECT\n" +
                            " COUNT(1)\n" +
                            "FROM\n" +
                            " dxs_train_online_course_user tocu,\n" +
                            " dxs_train_outline_course touc,\n" +
                            " dxs_train_course_catalog tcc\n" +
                            "WHERE\n" +
                            " tocu.user_id = '4028800c55c49bf30155c4a178b10000'\n" +
                            "AND tocu.toc_id = touc.id\n" +
                            "AND touc.user_id = '4028800c55c49bf30155c4a178b10000'\n" +
                            "AND touc.tcc_id = tcc.id\n" +
                            "AND tocu.result = 1\n" +
                            "AND tocu.is_delete = 0";

                    replyDataMode = this.templet(trainOnlineCourseUserFrom,user,data_sql,count_sql);
                }else if (!StringUtil.isEmpty(type) && "1".equals(type)){
                    String data_sql = "SELECT\n" +
                            "\ttonc.title t1,\n" +
                            "\ttcc.catalog_name t2,\n" +
                            "\ttonc.price t3,\n" +
                            "\ttonc.account t4,\n" +
                            "\ttonc.remarks y5,\n" +
                            "\ttocu.result t6,\n" +
                            "\ttocu.id t7,\n" +
                            "\ttonc.id t8,\n" +
                            "\ttocu.create_time t9\n" +
                            "FROM\n" +
                            "\tdxs_train_online_course_user tocu,\n" +
                            "\tdxs_train_online_course tonc,\n" +
                            "\tdxs_train_course_catalog tcc\n" +
                            "WHERE\n" +
                            "\ttocu.user_id = '"+ user.getId() +"'\n" +
                            "AND tocu.toc_id = tonc.id\n" +
                            "AND tonc.user_id = '"+ user.getId() +"'\n" +
                            "AND tonc.tcc_id = tcc.id\n" +
                            "AND tocu.result = 1\n" +
                            "AND tocu.is_delete = 0";

                    String count_sql = "SELECT\n" +
                            "\tCOUNT(1)\n" +
                            "FROM\n" +
                            "\tdxs_train_online_course_user tocu,\n" +
                            "\tdxs_train_online_course tonc,\n" +
                            "\tdxs_train_course_catalog tcc\n" +
                            "WHERE\n" +
                            "\ttocu.user_id = '"+ user.getId() +"'\n" +
                            "AND tocu.toc_id = tonc.id\n" +
                            "AND tonc.user_id = '"+ user.getId() +"'\n" +
                            "AND tonc.tcc_id = tcc.id\n" +
                            "AND tocu.result = 1\n" +
                            "AND tocu.is_delete = 0";

                    replyDataMode = this.templet(trainOnlineCourseUserFrom,user,data_sql,count_sql);
                }

            }else {
                replyDataMode.setStatusCode("您不是学生用户!");
                replyDataMode.setSuccess(false);
            }
        }else {
            replyDataMode.setStatusCode("请您登录!");
            replyDataMode.setSuccess(false);
        }

        return replyDataMode;
    }
}
