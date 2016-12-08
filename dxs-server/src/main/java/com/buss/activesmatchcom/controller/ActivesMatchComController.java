package com.buss.activesmatchcom.controller;


import com.buss.activesmatchcom.entity.ActivesMatchComEntity;
import com.buss.activesmatchcom.trans.from.ActivesMatchComFrom;
import com.buss.activesmatchcom.trans.vo.ActivesMatchComVo;
import com.buss.activesmathch.entity.ActivesMathchEntity;
import com.buss.activesmathch.trans.vo.ActivesMathchVo;
import com.buss.common.service.SysServiceI;
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
 * @Description: dxs_actives_match_com
 * @author onlineGenerator
 * @date 2016-08-30 15:48:03
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/ActivesMatchCom")
public class ActivesMatchComController {

    @Resource
    private SysServiceI sysServiceI;


    /**
     * 根据活动的ID/单位类型/活动的类型查询单位
     * @param activesMatchComFrom
     * @param request
     * @return
     */
    @RequestMapping(value = "unit")
    @ResponseBody
    public ReplyDataMode unit(ActivesMatchComFrom activesMatchComFrom, HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();
        activesMatchComFrom.setIsDelete("0");


        if ((activesMatchComFrom.getActivesId() != null && !activesMatchComFrom.getActivesId().isEmpty()) &&
                (activesMatchComFrom.getAmId() != null && !activesMatchComFrom.getAmId().isEmpty()) &&
                (activesMatchComFrom.getDataType() != null && !activesMatchComFrom.getDataType().isEmpty())){
            CriteriaQuery criteriaQuery = activesMatchComFrom.getCriteriaQuery();
            criteriaQuery.addOrder("createTime","desc");

            if ((activesMatchComFrom.getPageNo() != null && !activesMatchComFrom.getPageNo().isEmpty()) &&
                    (activesMatchComFrom.getPageSize() != null && !activesMatchComFrom.getPageSize().isEmpty())){
                Integer pageNo = Integer.parseInt(activesMatchComFrom.getPageNo());
                Integer pageSize = Integer.parseInt(activesMatchComFrom.getPageSize());

                PageMode mode = this.sysServiceI.list4page(criteriaQuery,pageNo,pageSize);
                List<ActivesMatchComEntity> activesMatchComEntityList = mode.getResult();
                List<ActivesMatchComVo> activesMatchComVos = new ArrayList<ActivesMatchComVo>();

                if (activesMatchComEntityList != null && activesMatchComEntityList.size() > 0){
                    for (ActivesMatchComEntity ame:activesMatchComEntityList){
                        ActivesMatchComVo activesMatchComVo = new ActivesMatchComVo();
                        activesMatchComVo.copyEntity(ame);

                        activesMatchComVos.add(activesMatchComVo);
                    }
                }

                mode.setResult(activesMatchComVos);
                replyDataMode.setData(mode);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);
            }
        }
        return replyDataMode;
    }
}
