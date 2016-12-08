package com.buss.lecturesgroups.controller;


import com.buss.common.service.SysServiceI;
import com.buss.lectures.entity.LecturesEntity;
import com.buss.lecturesgroups.entity.LecturesGroupsEntity;
import com.buss.lecturesgroups.trans.from.LecturesGroupsFrom;
import com.buss.lecturesgroups.trans.vo.LecturesGroupsVo;
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
 * @Title: Controller
 * @Description: dxs_lectures_groups
 * @author onlineGenerator
 * @date 2016-08-24 14:42:10
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/LuLecturesGroups")
public class LuLecturesGroupsController {

    @Resource
    private SysServiceI sysServiceI;


    @RequestMapping("/lecturesGroups.do")
    @ResponseBody
    public ReplyDataMode lecturesGroupsList(LecturesGroupsFrom searchForm, HttpServletRequest request){
        searchForm.setIsDelete("0");
        searchForm.setType("1");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();
        Integer pageNo = Integer.parseInt(searchForm.getPageNo());
        Integer pageSize = Integer.parseInt(searchForm.getPageSize());
        PageMode mode = this.sysServiceI.list4page(criteriaQuery,pageNo,pageSize);

        List<LecturesGroupsEntity> lecturesGroupss = mode.getResult();
        List lecturesGroupsVOs = new ArrayList<LecturesGroupsVo>();

        for (LecturesGroupsEntity lecturesGroups:lecturesGroupss) {
            Map map = new HashMap();
            LecturesGroupsVo lecturesGroupsVO = new LecturesGroupsVo();
            lecturesGroupsVO.copyEntity(lecturesGroups);
            map.put("lecturesGroupsVo",lecturesGroupsVO);
            String lgId = lecturesGroupsVO.getId();
            List<LecturesEntity> leList = this.sysServiceI.findByProperty(LecturesEntity.class,"lgId",lgId);
            if(leList!=null&&leList.size()!=0){
                Set set  = new HashSet();
                for(LecturesEntity le:leList){
                    set.add(le.getLectureAddressShort());
                }
                map.put("adds",set);
            }else{
                map.put("adds",null);
            }
            lecturesGroupsVOs.add(map);

        }
        mode.setResult(lecturesGroupsVOs);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }
}
