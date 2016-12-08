package com.buss.aidtheme.controller;



import com.buss.aiditemimage.entity.AidItemImageEntity;
import com.buss.aiditems.entity.AidItemsEntity;
import com.buss.aidtheme.entity.AidThemeEntity;
import com.buss.aidtheme.trans.form.AidThemeSearchForm;
import com.buss.aidtheme.trans.vo.AidThemeItemsVO;
import com.buss.aidtheme.trans.vo.AidThemeVO;
import com.buss.aidthemeimage.entity.AidThemeImageEntity;
import com.buss.aidthemeimage.trans.form.AidThemeImageSearchForm;
import com.buss.aidthemeimage.trans.vo.AidThemeImageVO;
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
@RequestMapping("/aidTheme")
public class AidThemeController {

    @Resource
    private SysServiceI sysService;


    @RequestMapping("/pageList.do")
    @ResponseBody
    public ReplyDataMode aidThemepageList(AidThemeSearchForm searchForm, HttpServletRequest request){

        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode  = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("createTime", "desc");
        criteriaQuery.setOrder(orderMap);

        int pageNo = Integer.parseInt(searchForm.getPageNo());
        int pageSize = Integer.parseInt(searchForm.getPageSize());

        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
        List<AidThemeEntity> aidTheme = mode.getResult();

        List<AidThemeVO> aidThemeVOs = new ArrayList<AidThemeVO>();

        for (AidThemeEntity aidThemeEntity:aidTheme) {
            AidThemeVO aidThemeVO = new AidThemeVO();
            aidThemeVO.copyEntity(aidThemeEntity);

            aidThemeVOs.add(aidThemeVO);

        }

        mode.setResult(aidThemeVOs);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


    @RequestMapping("/bigImageList.do")
    @ResponseBody
    public ReplyDataMode bigImageList(AidThemeImageSearchForm searchForm, HttpServletRequest request){

        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode  = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("createTime", "desc");
        criteriaQuery.setOrder(orderMap);

        List<AidThemeImageEntity> aidTheme = this.sysService.list(criteriaQuery);

        List<AidThemeImageVO> aidThemeVOs = new ArrayList<AidThemeImageVO>();

        for (AidThemeImageEntity aidThemeImageEntity:aidTheme) {
            AidThemeImageVO aidThemeVO = new AidThemeImageVO();
            aidThemeVO.copyEntity(aidThemeImageEntity);
            aidThemeVOs.add(aidThemeVO);

        }

        replyDataMode.setData(aidThemeVOs);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


    @RequestMapping("/aidThemeById.do")
    @ResponseBody
    public ReplyDataMode aidThemeById(AidThemeSearchForm searchForm,HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        List<AidThemeEntity> aidTheme = this.sysService.list(criteriaQuery);
        AidThemeItemsVO aidThemeItemsVO = new AidThemeItemsVO();

        if(aidTheme!=null&&aidTheme.size()!=0){

            AidThemeEntity aidThemeEntity = aidTheme.get(0);
            aidThemeItemsVO.copyEntity(aidThemeEntity);
            List progress = new ArrayList();

            Map mapp = new HashMap();
            mapp.put("words",null);
            mapp.put("images",null);
//            List list = new ArrayList<>();
//            list.add(mapp);
            aidThemeItemsVO.setInstructions(mapp);
            aidThemeItemsVO.setIntroduce(mapp);
            aidThemeItemsVO.setMeanings(mapp);
            aidThemeItemsVO.setContent(mapp);
            aidThemeItemsVO.setTeam(mapp);
            aidThemeItemsVO.setImplement(mapp);
            aidThemeItemsVO.setInvoice(mapp);
            aidThemeItemsVO.setAbout(mapp);
            aidThemeItemsVO.setProgress(null);


            AidItemsEntity aidItemsEntity = new AidItemsEntity();
            aidItemsEntity.setIsDelete(0);
            aidItemsEntity.setAaId(aidThemeItemsVO.getId());
            List<AidItemsEntity> aidItemlist = this.sysService.findByExample(AidItemsEntity.class.getName(),aidItemsEntity);

            if(aidItemlist!=null&&aidItemlist.size()!=0){
                for(AidItemsEntity aidItem:aidItemlist){
                    Map map = new HashMap();
                    map.put("words",null);
                    map.put("images",null);
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

                    if(aidItem.getType() == 6){
                        map.put("words",aidItem.getContent());
                        aidThemeItemsVO.setIntroduce(map);
                    }
                    if(aidItem.getType() == 7){
                        map.put("words",aidItem.getContent());
                        aidThemeItemsVO.setMeanings(map);
                    }
                    if(aidItem.getType() == 8){
                        map.put("words",aidItem.getContent());
                        aidThemeItemsVO.setContent(map);
                    }
                    if(aidItem.getType() == 9){
                        map.put("words",aidItem.getContent());
                        aidThemeItemsVO.setTeam(map);
                    }
                    if(aidItem.getType() == 10){
                        map.put("words",aidItem.getContent());
                        aidThemeItemsVO.setImplement(map);
                    }
                    if(aidItem.getType() == 11){
                        map.put("words",aidItem.getContent());
                        aidThemeItemsVO.setInstructions(map);
                    }
                    if(aidItem.getType() == 12){
                        map.put("words",aidItem.getContent());
                        aidThemeItemsVO.setInvoice(map);
                    }
                    if(aidItem.getType() == 13){
                        map.put("words",aidItem.getContent());
                        progress.add(map);
                    }
                    if(aidItem.getType() == 14){
                        map.put("words",aidItem.getContent());
                        aidThemeItemsVO.setAbout(map);
                    }

                }
                aidThemeItemsVO.setProgress(progress);
            }
        }


        replyDataMode.setData(aidThemeItemsVO);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


}

