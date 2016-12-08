package com.buss.activespainting.controller;


import com.buss.actives.entity.ActivessEntity;
import com.buss.actives.trans.vo.ActivessVO;
import com.buss.activespainting.entity.ActivesPaintingEntity;
import com.buss.activespainting.trans.from.ActivesPaintingFrom;
import com.buss.activespainting.trans.vo.ActivesPaintingVo;
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
 * @Description: dxs_actives_painting
 * @author onlineGenerator
 * @date 2016-08-29 11:28:54
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/dxsActivesPainting")
public class ActivesPaintingController {

    @Resource
    private SysServiceI sysServiceI;


    /**
     * 书画巡展详情页
     * @param activesPaintingFrom
     * @param request
     * @return
     */
    @RequestMapping(value = "detailed")
    @ResponseBody
    public ReplyDataMode detailed(ActivesPaintingFrom activesPaintingFrom, HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        activesPaintingFrom.setIsDelete("0");

        if (activesPaintingFrom.getActiveId() != null && !activesPaintingFrom.getActiveId().isEmpty()){
            // 活动查询
            ActivessEntity activessEntity = this.sysServiceI.get(ActivessEntity.class,activesPaintingFrom.getActiveId());
            List<Object> list = new ArrayList<Object>();
            Map<String,Object> map1 = new HashMap<String, Object>();
            ActivessVO activessVO = new ActivessVO();
            if (activessEntity != null){
                activessVO.copyEntity(activessEntity);
            }
            map1.put("activessVO",activessVO);
            list.add(map1);

            // 书画巡展
            CriteriaQuery criteriaQuery = activesPaintingFrom.getCriteriaQuery();
            List<ActivesPaintingEntity> ActivesPaintingEntityList = this.sysServiceI.list(criteriaQuery);
            Map<String,Object> map2 = new HashMap<String, Object>();
            ActivesPaintingVo activesPaintingVo = new ActivesPaintingVo();
            if (ActivesPaintingEntityList != null && ActivesPaintingEntityList.size() > 0){
                activesPaintingVo.copyEntity(ActivesPaintingEntityList.get(0));

                // 将精彩回放链接以"#"好切割
                String[] picture = null;
                Map<String,Object> pictureMap = new HashMap<String,Object>();
                if (ActivesPaintingEntityList.get(0).getImgUrls() != null && !ActivesPaintingEntityList.get(0).getImgUrls().isEmpty()){
                    picture = ActivesPaintingEntityList.get(0).getImgUrls().split("#");
                    activesPaintingVo.setPicture(picture);
                }

            }
            map2.put("activesPaintingVo",activesPaintingVo);
            list.add(map2);

            replyDataMode.setData(list);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);
        }

        return replyDataMode;
    }


    /**
     * 查询提示框中的分类和报名费
     * @param activesPaintingFrom
     * @param request
     * @return
     */
    @RequestMapping(value = "spilt")
    @ResponseBody
    public ReplyDataMode spilt(ActivesPaintingFrom activesPaintingFrom,HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();
        activesPaintingFrom.setIsDelete("0");

        if (activesPaintingFrom.getId() != null && !activesPaintingFrom.getId().isEmpty()){
            ActivesPaintingEntity activesPaintingEntity = this.sysServiceI.get(ActivesPaintingEntity.class,activesPaintingFrom.getId());
            if (activesPaintingEntity != null){
                if (activesPaintingEntity.getCatalogChilds() != null && !activesPaintingEntity.getCatalogChilds().isEmpty()){

                    String[] one = activesPaintingEntity.getCatalogChilds().split("#");
                    List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();

                    for (int i = 0;i < one.length;i++){
                       String[] two = one[i].split("-");
                       Map<String,Object> map = new HashMap<String,Object>();
                       map.put("classify",two[0]);
                       map.put("entryFee",two[1]);
                       list.add(map);
                    }

                    replyDataMode.setData(list);
                    replyDataMode.setStatusCode("200");
                    replyDataMode.setSuccess(true);
                }
            }
        }

        return replyDataMode;
    }
}
