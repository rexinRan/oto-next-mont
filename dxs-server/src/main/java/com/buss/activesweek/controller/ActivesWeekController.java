package com.buss.activesweek.controller;


import com.buss.actives.entity.ActivessEntity;
import com.buss.actives.trans.form.ActivesSearchForm;
import com.buss.actives.trans.vo.ActivessVO;
import com.buss.activesweek.entity.ActivesWeekEntity;
import com.buss.activesweek.trans.from.ActivesWeekFrom;
import com.buss.activesweek.trans.vo.ActivesWeekVo;
import com.buss.common.service.SysServiceI;
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
 * @Description: dxs_actives_week
 * @author onlineGenerator
 * @date 2016-08-29 11:27:31
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/dxsActivesWeek")
public class ActivesWeekController {

    @Resource
    private SysServiceI sysServiceI;


    /**
     * 周末旅行详情页
     * @param activesWeekFrom
     * @param request
     * @return
     */
    @RequestMapping(value = "detailed")
    @ResponseBody
    public ReplyDataMode detailed(ActivesWeekFrom activesWeekFrom, HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();
        activesWeekFrom.setIsDelete("0");

        if (activesWeekFrom.getActiveId() != null && !activesWeekFrom.getActiveId().isEmpty()){
            // 活动查询
            ActivessEntity activessEntity = this.sysServiceI.get(ActivessEntity.class,activesWeekFrom.getActiveId());
            List<Object> list = new ArrayList<Object>();
            Map<String,Object> map1 = new HashMap<String, Object>();
            ActivessVO activessVO = new ActivessVO();
            if (activessEntity != null){
                activessVO.copyEntity(activessEntity);
            }
            map1.put("activessVO",activessVO);
            list.add(map1);

            // 周末旅行
            CriteriaQuery criteriaQuery = activesWeekFrom.getCriteriaQuery();
            List<ActivesWeekEntity> activesWeekVoList = this.sysServiceI.list(criteriaQuery);
            Map<String,Object> map2 = new HashMap<String, Object>();
            ActivesWeekVo activesWeekVo = new ActivesWeekVo();
            if (activesWeekVoList != null && activesWeekVoList.size() > 0){
                activesWeekVo.copyEntity(activesWeekVoList.get(0));

                // 将精彩回放链接以"#"好切割
                String[] picture = null;
                Map<String,Object> pictureMap = new HashMap<String,Object>();
                if (activesWeekVoList.get(0).getImgUrls() != null && !activesWeekVoList.get(0).getImgUrls().isEmpty()){
                    picture = activesWeekVoList.get(0).getImgUrls().split("#");
                    activesWeekVo.setPicture(picture);
                }
            }
            map2.put("activesWeekVo",activesWeekVo);
            list.add(map2);

            replyDataMode.setData(list);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);
        }

        return replyDataMode;
    }

}
