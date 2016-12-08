package com.buss.activescompanies.controller;


import com.buss.actives.entity.ActivessEntity;
import com.buss.actives.trans.form.ActivesSearchForm;
import com.buss.actives.trans.vo.ActivessVO;
import com.buss.activescompanies.entity.ActivesCompaniesEntity;
import com.buss.activescompanies.trans.from.ActivesCompaniesFrom;
import com.buss.activescompanies.trans.vo.ActivesCompaniesVo;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.aspectj.org.eclipse.jdt.core.dom.ASTParser;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.jweb.core.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: Controller
 * @Description: dxs_actives_companies
 * @author onlineGenerator
 * @date 2016-08-18 13:35:16
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/ActivesCompaniesController")
public class ActivesCompaniesController {

    @Autowired
    private SysServiceI sysServiceI;


    /**
     * 名企参观的列表页(可条件查询)
     * @param activesCompaniesFrom  名企参观
     * @param request
     * @return
     */
    @RequestMapping(value = "application")
    @ResponseBody
    public ReplyDataMode application(ActivesCompaniesFrom activesCompaniesFrom,String provincial,String city,HttpServletRequest request) {
        ReplyDataMode replyDataMode = new ReplyDataMode();
        activesCompaniesFrom.setIsDelete("0");

        // 注:将省市分开中间加#作为分隔符
        if (provincial != null && !provincial.isEmpty()) {
            provincial = provincial + "#";
        }
        // 将省市用#号进行拼接
        if (city != null && !city.isEmpty()) {
            city = city + "#";
            if (provincial != null && !provincial.isEmpty()) {
                provincial = provincial + city;
            }
        }

        CriteriaQuery criteriaQuery = activesCompaniesFrom.getCriteriaQuery();
        criteriaQuery.addOrder("createTime", "desc");


        // 条件查询
        if (provincial != null && !provincial.isEmpty()) {

            int total = 0;
            int pageNo = 0;
            int pageSize = 0;
            StringBuffer sb_limit = new StringBuffer();
            if (!StringUtil.isEmpty(activesCompaniesFrom.getPageNo()) && !StringUtil.isEmpty(activesCompaniesFrom.getPageSize())) {
                pageNo = Integer.parseInt(activesCompaniesFrom.getPageNo());
                pageSize = Integer.parseInt(activesCompaniesFrom.getPageSize());
                sb_limit.append(" LIMIT " + (pageNo - 1) * pageSize + "," + pageSize);
            }
            /* 分页 */
            PageMode mode = new PageMode();

            // 符合条件的所有数据
            String sql = "SELECT\n" +
                    "activessen1_.ID,\n" +                          // 活动id
                    "\tthis_.BUS_NUM,\n" +                          // 大巴车牌号
                    "\tthis_.COMPANY_ADDRESS,\n" +                  // 企业所属地
                    "\tthis_.COMPANY_NAME,\n" +                     // 参观企业
                    "\tactivessen1_.ACTIVE_STATE_TIME,\n" +         // 活动开始时间
                    "\tactivessen1_.LIMITED_NUMBER,\n" +            // 限报人数
                    "this_.IS_DELETE = 0,\n" +
                    "activessen1_.is_delete = 0\n" +
                    "FROM\n" +
                    "\tdxs_actives_companies this_\n" +
                    "INNER JOIN dxs_actives activessen1_ ON this_.active_id = activessen1_.ID\n" +
                    "WHERE\n" +
                    "\tactivessen1_.ACTIVE_ADDRESS LIKE '%"+ provincial +"%'\n" +
                    "AND this_.IS_DELETE = 0\n" +
                    "AND activessen1_.is_delete = 0\n" +
                    "ORDER BY\n" +
                    "\tthis_.CREATE_TIME DESC\n" + sb_limit.toString();

            // 数据总条数
            String sql_count = "SELECT\n" +
                    "\tCOUNT(1)\n" +
                    "FROM\n" +
                    "\tdxs_actives_companies this_\n" +
                    "INNER JOIN dxs_actives activessen1_ ON this_.active_id = activessen1_.ID\n" +
                    "WHERE\n" +
                    "\tactivessen1_.ACTIVE_ADDRESS LIKE '%" + provincial + "%'\n" +
                    "AND this_.IS_DELETE = 0\n" +
                    "AND activessen1_.IS_DELETE = 0";

            List<Map> resourceList =  this.sysServiceI.findListbySql(sql);
            List totalList = this.sysServiceI.findListbySql(sql_count);

            List<Map<String, Object>> aList = new ArrayList();
            if(resourceList != null)
                for (Object obj : resourceList) {
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
                aList.add(map);
                mode.setTotal(Integer.parseInt(totalList.get(0).toString()));
            }

            final int allCounts;
            if (mode.getTotal() != 0) {
                allCounts = mode.getTotal();
            } else {
                allCounts = 0;
            }

            int pageCount = 0;
            if (pageNo!=0 && pageSize!=0) {
                pageCount = (allCounts + pageSize - 1)/pageSize;
//                int start = (pageNo - 1) * pageSize;pageSize;
            }

            mode.setPageCount(pageCount);
            mode.setPageNo(pageNo);
            mode.setPageSize(pageSize);
            mode.setResult(aList);

            replyDataMode.setData(mode);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);

        } else {
            // 列表页

            int total = 0;
            int pageNo = 0;
            int pageSize = 0;
            StringBuffer sb_limit = new StringBuffer();
            if (!StringUtil.isEmpty(activesCompaniesFrom.getPageNo()) && !StringUtil.isEmpty(activesCompaniesFrom.getPageSize())) {
                pageNo = Integer.parseInt(activesCompaniesFrom.getPageNo());
                pageSize = Integer.parseInt(activesCompaniesFrom.getPageSize());
                sb_limit.append(" LIMIT " + (pageNo - 1) * pageSize + "," + pageSize);
            }
            /* 分页 */
            PageMode mode = new PageMode();

            // 符合条件的所有数据
            String sql = "SELECT\n" +
                    "activessen1_.ID,\n" +                          // 活动id
                    "\tthis_.BUS_NUM,\n" +                          // 大巴车牌号
                    "\tthis_.COMPANY_ADDRESS,\n" +                  // 企业所属地
                    "\tthis_.COMPANY_NAME,\n" +                     // 参观企业
                    "\tactivessen1_.ACTIVE_STATE_TIME,\n" +         // 活动开始时间
                    "\tactivessen1_.LIMITED_NUMBER,\n" +            // 限报人数
                    "this_.IS_DELETE = 0,\n" +
                    "activessen1_.is_delete = 0\n" +
                    "FROM\n" +
                    "\tdxs_actives_companies this_\n" +
                    "INNER JOIN dxs_actives activessen1_ ON this_.active_id = activessen1_.ID\n" +
                    "WHERE\n" +
                    "this_.IS_DELETE = 0\n" +
                    "AND activessen1_.is_delete = 0\n" +
                    "ORDER BY\n" +
                    "\tthis_.CREATE_TIME DESC\n" + sb_limit.toString();

            // 数据总条数
            String sql_count = "SELECT\n" +
                    "\tCOUNT(1)\n" +
                    "FROM\n" +
                    "\tdxs_actives_companies this_\n" +
                    "INNER JOIN dxs_actives activessen1_ ON this_.active_id = activessen1_.ID\n" +
                    "WHERE\n" +
                    "\tactivessen1_.ACTIVE_ADDRESS LIKE '%" + provincial + "%'\n" +
                    "AND this_.IS_DELETE = 0\n" +
                    "AND activessen1_.IS_DELETE = 0";

            List<Map> resourceList = this.sysServiceI.findListbySql(sql);
            List totalList = this.sysServiceI.findListbySql(sql_count);

            List<Map<String, Object>> aList = new ArrayList();
            if (resourceList != null)
                for (Object obj : resourceList) {
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
                    mode.setTotal(totalList.size());
                }

            final int allCounts;
            if (mode.getTotal() != 0) {
                allCounts = mode.getTotal();
            } else {
                allCounts = 0;
            }

            int pageCount = 0;
            if (pageNo != 0 && pageSize != 0) {
                pageCount = (allCounts + pageSize - 1) / pageSize;
//                int start = (pageNo - 1) * pageSize;pageSize;
            }

            mode.setPageCount(pageCount);
            mode.setPageNo(pageNo);
            mode.setPageSize(pageSize);
            mode.setResult(aList);

            replyDataMode.setData(mode);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);
        }
        return replyDataMode;
    }
}
