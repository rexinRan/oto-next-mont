package com.buss.activesroadshowapply.controller;



import com.buss.activesroadshowapply.entity.ActivesRoadshowApplyEntity;
import com.buss.activesroadshowapply.trans.from.ActivesRoadshowApplyFrom;
import com.buss.activesroadshowapply.trans.vo.ActivesRoadshowDetailVo;
import com.buss.common.service.SysServiceI;
import com.buss.usercompancy.entity.UserCompancyEntity;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @Title: Controller
 * @Description: dxs_actives_roadshow_detail
 * @author onlineGenerator
 * @date 2016-08-18 13:36:17
 * @version V1.0   
 *
 */
@Controller
@RequestMapping(value = "ActivesRoadshowDetailController")
public class ActivesRoadshowDetailController {

    @Autowired
    private SysServiceI sysServiceI;

    /**
     * 企业申请创业路演
     *
     * @param request
     * @return
     */
    @RequestMapping("DetailById")
    @ResponseBody
    public ReplyDataMode DetailById(ActivesRoadshowApplyFrom searchForm, HttpServletRequest request) {
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        List<ActivesRoadshowApplyEntity> activesRoadshowApplys = this.sysServiceI.list(criteriaQuery);
        List<ActivesRoadshowDetailVo> activesRoadshowDetailVos = new ArrayList<ActivesRoadshowDetailVo>();

        for (ActivesRoadshowApplyEntity activesRoadshowApply : activesRoadshowApplys) {
            ActivesRoadshowDetailVo activesRoadshowDetailVo = new ActivesRoadshowDetailVo();
            activesRoadshowDetailVo.copyEntity(activesRoadshowApply);
            activesRoadshowDetailVos.add(activesRoadshowDetailVo);
            List<UserCompancyEntity> userCompancyEntityList = this.sysServiceI.findByProperty(UserCompancyEntity.class,"userId",activesRoadshowDetailVo.getUserId());
            if(userCompancyEntityList!=null&&userCompancyEntityList.size()!=0){
                UserCompancyEntity userCompancyEntity = userCompancyEntityList.get(0);
                activesRoadshowDetailVo.setCompanyName(userCompancyEntity.getCompancyName());
            }

        }
        replyDataMode.setData(activesRoadshowDetailVos);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }
}
