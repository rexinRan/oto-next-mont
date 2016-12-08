package com.buss.project.bases.controller;
import com.alibaba.fastjson.JSON;
import com.buss.common.redis.RedisClient;
import com.buss.common.redis.cache.CacheKey;
import com.buss.common.service.SysServiceI;

import com.buss.project.bases.entity.BasesEntity;
import com.buss.project.bases.trans.form.BasesSearchForm;
import com.buss.project.bases.trans.vo.BasesVO;
import com.buss.project.basescase.entity.BasesCaseEntity;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.jweb.core.util.StringUtil;
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
 * @author lu
 *
 */
@Controller
@RequestMapping("/bases")
public class BasesController {

    @Resource
    private SysServiceI sysService;
    @Resource
    private RedisClient redisClient;


    @RequestMapping("/indexPageList.do")
    @ResponseBody
    public ReplyDataMode indexPageList(String province, String city, BasesSearchForm searchForm, HttpServletRequest request){
        ReplyDataMode replyDataMode  = new ReplyDataMode();

//        String key = "";
//        if("on".equals(CacheKey.REDIS_SWITCH)){
//            key = CacheKey.INDEX_JIDI;
//            // TODO 查Redis缓存
//            Object cache = redisClient.get(key);
//            if( cache != null){
//                replyDataMode.setData(cache);
//                replyDataMode.setStatusCode("201-读缓存");
//                replyDataMode.setSuccess(true);
//                return replyDataMode;
//            }
//        }

        if(searchForm.getBaseClass()!=null&&"".equals(searchForm.getBaseClass())){
            searchForm.setBaseClass(null);
        }
        if(searchForm.getBaseIndustry()!=null&&"".equals(searchForm.getBaseIndustry())){
            searchForm.setBaseIndustry(null);
        }
        searchForm.setIsDelete("0");
        if(city!=null&&!("".equals(city))) {

            searchForm.setBaseAddress("北京市");
        }else {

            searchForm.setBaseAddress("天津市");
        }
        if("北京市".equals(city)){
        } else {

            searchForm.setBaseAddress("重庆市");
        }
        if("天津市".equals(city)){
        }
        else {

            searchForm.setBaseAddress("上海市");
        }
        if("重庆市".equals(city)){
        }
        else {
            if(province!=null&&!"".equals(province)){
                    searchForm.setBaseAddress(""+province+"#"+city);
                }else {
                    searchForm.setBaseAddress(city);
                }
        }
        if("上海市".equals(city)){
        }
        if(city!=null&&"".equals(city)){
            searchForm.setBaseAddress(null);
        }


        if(searchForm.getBaseClass()!=null&&searchForm.getBaseClass()!=""){
            if(searchForm.getBaseClass().equals("县级")){
                searchForm.setBaseClass("1");
            }
            if(searchForm.getBaseClass().equals("市级")){
                searchForm.setBaseClass("2");
            }
            if(searchForm.getBaseClass().equals("省级")){
                searchForm.setBaseClass("3");
            }
            if(searchForm.getBaseClass().equals("国家级")){
                searchForm.setBaseClass("4");
            }
        }
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("createTime", "desc");
        orderMap.put("updateTime", "desc");
        criteriaQuery.setOrder(orderMap);

        int pageNo = Integer.parseInt(searchForm.getPageNo());
        int pageSize = Integer.parseInt(searchForm.getPageSize());

        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
        List<BasesEntity> bases = mode.getResult();

        List<BasesVO> basesVOs = new ArrayList<BasesVO>();

        for (BasesEntity basesEntity:bases) {
            BasesVO basesVO = new BasesVO();
            basesVO.copyEntity(basesEntity);
            String address = basesEntity.getBaseAddress();
            String [] addresses = address.split("#");
            basesVO.setBaseProvince(addresses[0]);
            if("北京市".equals(addresses[0])){
                basesVO.setBaseCity(addresses[0]);
            }else
            if("天津市".equals(addresses[0])){
                basesVO.setBaseCity(addresses[0]);
            }else
            if("重庆市".equals(addresses[0])){
                basesVO.setBaseCity(addresses[0]);
            }else
            if("上海市".equals(addresses[0])){
                basesVO.setBaseCity(addresses[0]);
            }else {

                basesVO.setBaseCity(addresses[1]);
            }
            String add = basesVO.getBaseAddress().replace("#","");
            basesVO.setBaseAddress(add);
            if(basesVO.getBaseClass()!=null&&basesVO.getBaseClass()!=""){
                if("1".equals(basesVO.getBaseClass())){
                    basesVO.setBaseClass("县级");
                }
                if("2".equals(basesVO.getBaseClass())){
                    basesVO.setBaseClass("市级");
                }
                if("3".equals(basesVO.getBaseClass())){
                    basesVO.setBaseClass("省级");
                }
                if("4".equals(basesVO.getBaseClass())){
                    basesVO.setBaseClass("国家级");
                }
            }

            basesVOs.add(basesVO);
        }

        mode.setResult(basesVOs);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

//        // TODO 设置Redis缓存
//        if(!"".equals(key)){
//            Object obj = JSON.toJSON(mode);
//            redisClient.put(key, obj);
//        }

        return replyDataMode;
    }

    @RequestMapping("/pageList.do")
    @ResponseBody
    public ReplyDataMode basesPageList(String province, String city, BasesSearchForm searchForm, HttpServletRequest request){
        if(searchForm.getBaseClass()!=null&&"".equals(searchForm.getBaseClass())){
            searchForm.setBaseClass(null);
        }
        if(searchForm.getBaseIndustry()!=null&&"".equals(searchForm.getBaseIndustry())){
            searchForm.setBaseIndustry(null);
        }
        searchForm.setIsDelete("0");
        if(city!=null&&!("".equals(city)))
            if("北京市".equals(city)){
                searchForm.setBaseAddress("北京市");
            }else
            if("天津市".equals(city)){
                searchForm.setBaseAddress("天津市");
            }else
            if("重庆市".equals(city)){
                searchForm.setBaseAddress("重庆市");
            }else
            if("上海市".equals(city)){
                searchForm.setBaseAddress("上海市");
            }else {
                if(province!=null&&!"".equals(province)){
                    searchForm.setBaseAddress(""+province+"#"+city);
                }else {
                    searchForm.setBaseAddress(city);
                }
            }
        if(city!=null&&"".equals(city)){
            searchForm.setBaseAddress(null);
        }


        if(searchForm.getBaseClass()!=null&&searchForm.getBaseClass()!=""){
            if(searchForm.getBaseClass().equals("县级")){
                searchForm.setBaseClass("1");
            }
            if(searchForm.getBaseClass().equals("市级")){
                searchForm.setBaseClass("2");
            }
            if(searchForm.getBaseClass().equals("省级")){
                searchForm.setBaseClass("3");
            }
            if(searchForm.getBaseClass().equals("国家级")){
                searchForm.setBaseClass("4");
            }
        }
        ReplyDataMode replyDataMode  = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("createTime", "desc");
        orderMap.put("updateTime", "desc");
        criteriaQuery.setOrder(orderMap);

        int pageNo = Integer.parseInt(searchForm.getPageNo());
        int pageSize = Integer.parseInt(searchForm.getPageSize());

        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
        List<BasesEntity> bases = mode.getResult();

        List<BasesVO> basesVOs = new ArrayList<BasesVO>();

        for (BasesEntity basesEntity:bases) {
            BasesVO basesVO = new BasesVO();
            basesVO.copyEntity(basesEntity);
            String address = basesEntity.getBaseAddress();
            String [] addresses = address.split("#");
            basesVO.setBaseProvince(addresses[0]);
            if("北京市".equals(addresses[0])){
                basesVO.setBaseCity(addresses[0]);
            }else
            if("天津市".equals(addresses[0])){
                basesVO.setBaseCity(addresses[0]);
            }else
            if("重庆市".equals(addresses[0])){
                basesVO.setBaseCity(addresses[0]);
            }else
            if("上海市".equals(addresses[0])){
                basesVO.setBaseCity(addresses[0]);
            }else {

                basesVO.setBaseCity(addresses[1]);
            }
            String add = basesVO.getBaseAddress().replace("#","");
            basesVO.setBaseAddress(add);
            if(basesVO.getBaseClass()!=null&&basesVO.getBaseClass()!=""){
                if("1".equals(basesVO.getBaseClass())){
                    basesVO.setBaseClass("县级");
                }
                if("2".equals(basesVO.getBaseClass())){
                    basesVO.setBaseClass("市级");
                }
                if("3".equals(basesVO.getBaseClass())){
                    basesVO.setBaseClass("省级");
                }
                if("4".equals(basesVO.getBaseClass())){
                    basesVO.setBaseClass("国家级");
                }
            }

            basesVOs.add(basesVO);
        }

        mode.setResult(basesVOs);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

    @RequestMapping("/basesById.do")
    @ResponseBody
    public ReplyDataMode basesById (BasesSearchForm searchForm, HttpServletRequest request) {
        searchForm.setIsDelete("0");

        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("createTime", "desc");
        orderMap.put("updateTime", "desc");
        criteriaQuery.setOrder(orderMap);

        List<BasesEntity> bases = this.sysService.list(criteriaQuery);

        List<BasesVO> basesVOs = new ArrayList<BasesVO>();

        for (BasesEntity basesEntity : bases) {
            BasesVO basesVO = new BasesVO();
            basesVO.copyEntity(basesEntity);

            String add = basesVO.getBaseAddress().replace("#", "");
            basesVO.setBaseAddress(add);
            if (basesVO.getBaseClass() != null && basesVO.getBaseClass() != "") {
                if ("1".equals(basesVO.getBaseClass())) {
                    basesVO.setBaseClass("县级");
                }
                if ("2".equals(basesVO.getBaseClass())) {
                    basesVO.setBaseClass("市级");
                }
                if ("3".equals(basesVO.getBaseClass())) {
                    basesVO.setBaseClass("省级");
                }
                if ("4".equals(basesVO.getBaseClass())) {
                    basesVO.setBaseClass("国家级");
                }
            }
            BasesCaseEntity basesCaseEntity = new BasesCaseEntity();
            basesCaseEntity.setIsDelete(0);
            basesCaseEntity.setDbId(basesVO.getId());
            List basesCases = this.sysService.findByExample(BasesCaseEntity.class.getName(),basesCaseEntity);
            if(basesCases!=null&&basesCases.size()!=0){
                List picutures = new ArrayList();
                for(Object o:basesCases){
                    BasesCaseEntity basesCase = (BasesCaseEntity)o;
                    picutures.add(basesCase.getDbImgUrl());
                }
                basesVO.setPictures(picutures);
            }

            basesVOs.add(basesVO);
        }

        replyDataMode.setData(basesVOs);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }
}