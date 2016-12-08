package com.buss.lecturesgroups.controller;


import com.buss.common.service.SysServiceI;
import com.buss.lecturesgroups.entity.LecturesGroupsEntity;
import com.buss.lecturesgroups.trans.from.LecturesGroupsFrom;
import com.buss.lecturesgroups.trans.vo.LecturesGroupsVo;
import org.hibernate.type.TrueFalseType;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
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
 * @Title: Controller
 * @Description: dxs_lectures_groups
 * @author onlineGenerator
 * @date 2016-08-24 14:42:10
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/LecturesGroups")
public class LecturesGroupsController{

    @Resource
    private SysServiceI sysServiceI;


    /**
     * 名师巡讲>>>特约专场/主题
     * @param lecturesGroupsFrom
     * @param request
     * @return
     */
    @RequestMapping(value = "specialPerformance")
    @ResponseBody
    public ReplyDataMode specialPerformance(LecturesGroupsFrom lecturesGroupsFrom, HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        lecturesGroupsFrom.setIsDelete("0");
        if (lecturesGroupsFrom.getType() != null && !lecturesGroupsFrom.getType().isEmpty()){
            CriteriaQuery criteriaQuery = lecturesGroupsFrom.getCriteriaQuery();
            criteriaQuery.addOrder("createTime","desc");

            if (lecturesGroupsFrom.getPageNo() != null && lecturesGroupsFrom.getPageSize() != null){
                Integer pageNo = Integer.parseInt(lecturesGroupsFrom.getPageNo());
                Integer pageSize = Integer.parseInt(lecturesGroupsFrom.getPageSize());
                PageMode mode = this.sysServiceI.list4page(criteriaQuery,pageNo,pageSize);
                List<LecturesGroupsEntity> lecturesGroupsEntityList = mode.getResult();
                List<LecturesGroupsVo> lecturesGroupsVos = new ArrayList<LecturesGroupsVo>();

                if (lecturesGroupsEntityList != null && lecturesGroupsEntityList.size() > 0){
                    for (LecturesGroupsEntity lge:lecturesGroupsEntityList){
                        LecturesGroupsVo lecturesGroupsVo = new LecturesGroupsVo();
                        lecturesGroupsVo.copyEntity(lge);
                        lecturesGroupsVos.add(lecturesGroupsVo);
                    }
                }

                mode.setResult(lecturesGroupsVos);
                replyDataMode.setData(mode);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);

            }else {
                replyDataMode.setStatusCode("分页参数传递错误!");
                replyDataMode.setSuccess(false);
            }
        }

        return replyDataMode;
    }

    /**
     * 全国主题专场中的全国各大城市
     * @param lecturesGroupsFrom
     * @param request
     * @return
     */
    @RequestMapping(value = "address")
    @ResponseBody
    public ReplyDataMode address(LecturesGroupsFrom lecturesGroupsFrom,HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        if (lecturesGroupsFrom.getId() != null && !lecturesGroupsFrom.getId().isEmpty()){
            String sql = "SELECT DISTINCT\n" +
                    "\t(l.lecture_address_short)\n" +
                    "FROM\n" +
                    "\tdxs_lectures_groups lg\n" +
                    "INNER JOIN dxs_lectures l ON "+ lecturesGroupsFrom.getId() +" = l.lg_id\n" +
                    "WHERE\n" +
                    "\tlg.is_delete = 0\n" +
                    "AND l.is_delete = 0\n" +
                    "AND l.lecture_address_short <> ''";

            List<Map> uaList = this.sysServiceI.findListbySql(sql);

            /*if (!uaList.isEmpty())
                for (Object obj : uaList) {
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

                replyDataMode.setData(map);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);
            }*/
            replyDataMode.setData(uaList);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);
        }

        return replyDataMode;
    }
}
