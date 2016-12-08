package com.buss.activesfriendship.controller;


import com.buss.actives.entity.ActivessEntity;
import com.buss.actives.trans.vo.ActivesVO;
import com.buss.actives.trans.vo.ActivessVO;
import com.buss.activesfriendship.entity.ActivesFriendshipEntity;
import com.buss.activesfriendship.trans.from.ActivesFriendshipFrom;
import com.buss.activesfriendship.trans.vo.ActivesFriendshipVo;
import com.buss.common.service.SysServiceI;
import com.sun.tools.javac.code.Attribute;
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
 * @Description: dxs_actives_friendship
 * @author onlineGenerator
 * @date 2016-08-29 11:29:42
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/dxsActivesFriendship")
public class ActivesFriendshipController {

    @Resource
    private SysServiceI sysServiceI;

    /**
     * 校园联谊/爱好者同行的详情页
     * @param activesFriendshipFrom
     * @param request
     * @return
     */
    @RequestMapping(value = "detailed")
    @ResponseBody
    public ReplyDataMode detailed(ActivesFriendshipFrom activesFriendshipFrom, HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();
        activesFriendshipFrom.setIsDelete("0");

        if (activesFriendshipFrom.getActiveId() != null && !activesFriendshipFrom.getActiveId().isEmpty()){
            // 活动查询
            ActivessEntity activessEntity = this.sysServiceI.get(ActivessEntity.class,activesFriendshipFrom.getActiveId());
            List<Object> list = new ArrayList<Object>();
            Map<String,Object> map1 = new HashMap<String, Object>();
            ActivessVO activessVO = new ActivessVO();
            if (activessEntity != null){
                activessVO.copyEntity(activessEntity);
            }
            map1.put("activessVO",activessVO);
            list.add(map1);

            // 校园联谊和爱好者同行查询
            CriteriaQuery criteriaQuery = activesFriendshipFrom.getCriteriaQuery();
            List<ActivesFriendshipEntity> activesFriendshipEntityList = this.sysServiceI.list(criteriaQuery);
            Map<String,Object> map2 = new HashMap<String, Object>();
            ActivesFriendshipVo activesFriendshipVo = new ActivesFriendshipVo();
            if (activesFriendshipEntityList != null && activesFriendshipEntityList.size() > 0){
                activesFriendshipVo.copyEntity(activesFriendshipEntityList.get(0));

                // 将精彩回放链接以"#"好切割
                String[] picture = null;
                Map<String,Object> pictureMap = new HashMap<String,Object>();
                if (activesFriendshipEntityList.get(0).getImgUrls() != null && !activesFriendshipEntityList.get(0).getImgUrls().isEmpty()){
                    picture = activesFriendshipEntityList.get(0).getImgUrls().split("#");
                    activesFriendshipVo.setPicture(picture);
                }
            }
            map2.put("activesFriendshipVo",activesFriendshipVo);
            list.add(map2);

            replyDataMode.setData(list);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);
        }

        return replyDataMode;
    }

}
