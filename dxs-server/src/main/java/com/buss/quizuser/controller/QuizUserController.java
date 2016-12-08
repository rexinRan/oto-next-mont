package com.buss.quizuser.controller;

import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;
import com.buss.quiz.entity.QuizEntity;
import com.buss.quiz.trans.vo.QuizVO;
import com.buss.quizuser.entity.QuizUserEntity;
import com.buss.quizuser.trans.form.QuizUserSearchForm;
import com.buss.quizuser.trans.vo.QuizUserVO;
import com.buss.trainingcatalog.trans.form.TrainingCatalogSearchForm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.bean.SearchForm;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.jweb.core.util.StringUtil;
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
 * 测评
 * Created by Administrator on 2016/7/14.
 */
@Controller
@RequestMapping("/QuizUserController")
public class QuizUserController {

    @Resource
    private SysServiceI sysServiceI;

    @RequestMapping(value = "/comprehensiveEvaluation")
    @ResponseBody
    public ReplyDataMode comprehensiveEvaluation(QuizUserSearchForm quizUserSearchForm, HttpServletRequest request) {

        ReplyDataMode replyDataMode = new ReplyDataMode();

        // 获取当前登录用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        // 分页模型设置
        PageMode mode = new PageMode();
        int total = 0;
        int pageNo = 0;
        int pageSize = 0;

        if (!StringUtil.isEmpty(quizUserSearchForm.getPageNo()) && StringUtil.isEmpty(quizUserSearchForm.getPageSize())){
            pageNo = Integer.parseInt(quizUserSearchForm.getPageNo());
            pageSize = Integer.parseInt(quizUserSearchForm.getPageSize());
        }

        if (user != null) {

            // 查看未删除的数据
            StringBuffer sb = new StringBuffer();
            if (StringUtil.isEmpty(quizUserSearchForm.getIsDelete())){

                // 追加sql条件查询语句
                sb.append(" AND u.is_delete = + 1");
            }else {
                sb.append(" AND u.is_delete=" + quizUserSearchForm.getIsDelete());
            }

            StringBuffer ab1 = new StringBuffer();
            if (!StringUtil.isEmpty(quizUserSearchForm.getPageNo()) && !StringUtil.isEmpty(quizUserSearchForm.getPageSize())){
                pageNo = Integer.parseInt(quizUserSearchForm.getPageNo());
                pageSize = Integer.parseInt(quizUserSearchForm.getPageSize());

                // 追加分页查询
                ab1.append(" LIMT " + (pageNo - 1) + "," + pageSize);
            }

            /*String sql = "SELECT t.Training_catalog_name, q.quiz_introduction, u.result, u.evaluationTime, u.remark FROM dxs_quiz_user u, dxs_quiz q, dxs_training_catalog t " +
                    " WHERE u.user_id = '" + user.getId() + "'  AND u.quiz_id = q.id  AND q.training_catalog_id = t.id" + sb.toString() + "ORDER BY u.evaluationTime" + ab1.toString();*/
            String sql = "SELECT\n" +
                    "\tt.Training_catalog_name,\n" +
                    "\tq.quiz_introduction,\n" +
                    "\tu.result,\n" +
                    "\tu.evaluationTime,\n" +
                    "\tu.remark\n" +
                    "FROM\n" +
                    "\tdxs_quiz_user u,\n" +
                    "\tdxs_quiz q,\n" +
                    "\tdxs_training_catalog t\n" +
                    "WHERE\n" +
                    "\tu.user_id = '"+ user.getId() +"'\n" +
                    "AND u.quiz_id = q.id\n" +
                    "AND q.training_catalog_id = t.id\n" +
                    "ORDER BY\n" +
                    "\tu.evaluationTime";

            // 总条数
            String count = "SELECT\n" +
                    "\tu.id\n" +
                    "FROM\n" +
                    "\tdxs_quiz_user u,\n" +
                    "\tdxs_quiz q,\n" +
                    "\tdxs_training_catalog t\n" +
                    "WHERE\n" +
                    "\tu.user_id = '"+ user.getId() +"'\n" +
                    "AND u.quiz_id = q.id\n" +
                    "AND q.training_catalog_id = t.id \n" +sb.toString();

            List<Map> ualist = this.sysServiceI.findListbySql(sql);
            List<Map> ualist_count = this.sysServiceI.findListbySql(count);

            List<Map<String,Object>> alist = new ArrayList<Map<String,Object>>();
            if(!ualist.isEmpty()){
                for (Object obj : ualist) {
                    Map map = new HashMap();
                    Object[] u = (Object[]) obj;
                    String field = "";
                    for(int i=0;i<u.length;i++){
                        if(u[i]!=null){
                            field = u[i].toString();
                        }else {
                            field = "";
                        }
                        map.put("field"+i,field);
                    }
                    alist.add(map);
                    mode.setTotal(ualist_count.size());
                }
            }
            final int allCounts;
            if (mode.getTotal() != 0) {
                allCounts = mode.getTotal();
            } else {
                allCounts = 0;
            }
            int pageCount = 0;
            if (pageNo!=0 && pageSize!=0) {
                pageCount = allCounts/pageSize + 1;
                int start = (pageNo - 1) * pageSize;
            }
            mode.setPageCount(pageCount);
            mode.setPageNo(pageNo);
            mode.setPageSize(pageSize);
            mode.setResult(alist);

            replyDataMode.setData(mode);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);
        }else {
            replyDataMode.setStatusCode("请您登陆!");
            replyDataMode.setSuccess(false);
        }
        return replyDataMode;
    }
}
