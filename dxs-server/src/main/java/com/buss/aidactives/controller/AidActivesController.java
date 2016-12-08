package com.buss.aidactives.controller;

import com.buss.aidactives.entity.AidActivesEntity;
import com.buss.aidactives.trans.form.AidActivesSearchForm;
import com.buss.aidactives.trans.vo.AidActiveItemsVO;
import com.buss.aidactives.trans.vo.AidActivesVO;
import com.buss.aiditemimage.entity.AidItemImageEntity;
import com.buss.aiditems.entity.AidItemsEntity;
import com.buss.common.service.SysServiceI;
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
 * @author lu
 *
 */
@Controller
@RequestMapping("/aidActives")
public class AidActivesController {

    @Resource
    private SysServiceI sysService;


    @RequestMapping("/pageList.do")
    @ResponseBody
    public ReplyDataMode aidActivespageList(AidActivesSearchForm searchForm, HttpServletRequest request){

        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode  = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("publishTime", "desc");
        criteriaQuery.setOrder(orderMap);

//        Date date2 = new Date();
//        criteriaQuery.ge("deadlineDate",date2);
//        criteriaQuery.add();

        int pageNo = Integer.parseInt(searchForm.getPageNo());
        int pageSize = Integer.parseInt(searchForm.getPageSize());

        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
        List<AidActivesEntity> aidActives = mode.getResult();

        List<AidActivesVO> aidActivesVOs = new ArrayList<AidActivesVO>();

        for (AidActivesEntity aidActivesEntity:aidActives) {
            AidActivesVO aidActivesVO = new AidActivesVO();
            aidActivesVO.copyEntity(aidActivesEntity);

            String activeStatu = "";
            Date date = new Date();
            if (date.before(aidActivesEntity.getDeadlineDate())) {
                activeStatu = "报名中";
            } else if ((date.after(aidActivesEntity.getDeadlineDate())) && (date.before(aidActivesEntity.getActiveStartTime()))) {
                activeStatu = "报名结束";
            } else if ((date.before(aidActivesEntity.getActiveEndTime())) && (date.after(aidActivesEntity.getActiveStartTime()))) {
                activeStatu = "进行中";
            } else if (date.after(aidActivesEntity.getActiveEndTime())) {
                activeStatu = "已结束";
            }

            aidActivesVO.setState(activeStatu);

            String add = aidActivesVO.getActiveAddress();
            if(add!=null&&!"".equals(add)){
                if(add.contains("北京市")||add.contains("天津市")||add.contains("上海市")||add.contains("重庆市")){

                    String [] adds = add.split("#");
                    String a = "";
                    for(int i=0;i<adds.length;i++){
                        if(i!=1){

                            a = a + adds[i];
                        }
                    }
                    aidActivesVO.setActiveAddress(a);
                }else {

                    String  adds = add.replace("#","");
                    aidActivesVO.setActiveAddress(adds);
                }
            }
            aidActivesVOs.add(aidActivesVO);

        }

        mode.setResult(aidActivesVOs);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

    @RequestMapping("/aidActivesById.do")
    @ResponseBody
    public ReplyDataMode aidActivesById(AidActivesSearchForm searchForm,HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        List<AidActivesEntity> aidActives = this.sysService.list(criteriaQuery);
        AidActiveItemsVO aidActiveItemsVO = new AidActiveItemsVO();

        if(aidActives!=null&&aidActives.size()!=0){

            AidActivesEntity aidActivesEntity = aidActives.get(0);
            aidActiveItemsVO.copyEntity(aidActivesEntity);
            String activeStatu = "";
            Date date = new Date();
            if (date.before(aidActivesEntity.getDeadlineDate())) {
                activeStatu = "报名中";
            } else if ((date.after(aidActivesEntity.getDeadlineDate())) && (date.before(aidActivesEntity.getActiveStartTime()))) {
                activeStatu = "报名结束";
            } else if ((date.before(aidActivesEntity.getActiveEndTime())) && (date.after(aidActivesEntity.getActiveStartTime()))) {
                activeStatu = "进行中";
            } else if (date.after(aidActivesEntity.getActiveEndTime())) {
                activeStatu = "已结束";
            }

            aidActiveItemsVO.setState(activeStatu);

            Map mapp = new HashMap();
            mapp.put("words",null);
            mapp.put("images",null);
            aidActiveItemsVO.setContent(mapp);
            aidActiveItemsVO.setMeanings(mapp);
            aidActiveItemsVO.setTarget(mapp);
            aidActiveItemsVO.setReview(mapp);
            aidActiveItemsVO.setSummary(mapp);

            String add = aidActiveItemsVO.getActiveAddress();
            if(add!=null&&!"".equals(add)){
                if(add.contains("北京市")||add.contains("天津市")||add.contains("上海市")||add.contains("重庆市")){

                    String [] adds = add.split("#");
                    String a = "";
                    for(int i=0;i<adds.length;i++){
                        if(i!=1){

                            a = a + adds[i];
                        }
                    }
                    aidActiveItemsVO.setActiveAddress(a);
                }else {

                    String  adds = add.replace("#","");
                    aidActiveItemsVO.setActiveAddress(adds);
                }
            }
            AidItemsEntity aidItemsEntity = new AidItemsEntity();
            aidItemsEntity.setIsDelete(0);
            aidItemsEntity.setAaId(aidActiveItemsVO.getId());
            List<AidItemsEntity> aidItemlist = this.sysService.findByExample(AidItemsEntity.class.getName(),aidItemsEntity);

            if(aidItemlist!=null&&aidItemlist.size()!=0){
                for(AidItemsEntity aidItem:aidItemlist){
                    Map map = new HashMap();
                    List imageList = new ArrayList();

                    AidItemImageEntity aidItemImageEntity = new AidItemImageEntity();
                    aidItemImageEntity.setIsDelete(0);
                    aidItemImageEntity.setAaiId(aidItem.getId());
                    List<AidItemImageEntity> aidItemImageList  = this.sysService.findByExample(AidItemImageEntity.class.getName(),aidItemImageEntity);
                    if(aidItemImageList!=null&&aidItemImageList.size()!=0){
                        for(AidItemImageEntity itemImage:aidItemImageList){
                            imageList.add(itemImage.getImgUrl());
                        }
                    }
                    map.put("images",imageList);

                    if(aidItem.getType() == 1){
                        map.put("words",aidItem.getContent());
                        aidActiveItemsVO.setContent(map);
                    }
                    if(aidItem.getType() == 2){
                        map.put("words",aidItem.getContent());
                        aidActiveItemsVO.setMeanings(map);
                    }
                    if(aidItem.getType() == 3){
                        map.put("words",aidItem.getContent());
                        aidActiveItemsVO.setTarget(map);
                    }
                    if(aidItem.getType() == 4){
                        map.put("words",aidItem.getContent());
                        aidActiveItemsVO.setReview(map);
                    }
                    if(aidItem.getType() == 5){
                        map.put("words",aidItem.getContent());
                        aidActiveItemsVO.setSummary(map);
                    }

                }
            }
        }


        replyDataMode.setData(aidActiveItemsVO);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


}

