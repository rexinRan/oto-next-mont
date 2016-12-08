package com.buss.usercompancy.controller;
import com.alibaba.fastjson.JSON;
import com.buss.common.redis.RedisClient;
import com.buss.common.redis.cache.CacheKey;
import com.buss.common.service.SysServiceI;

import com.buss.member.util.StatusCode;
import com.buss.usercompancy.entity.UserCompancyEntity;
import com.buss.usercompancy.trans.form.UserCompancySearchForm;
import com.buss.usercompancy.trans.vo.UserCompancyVO;
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
 * @author lu
 *
 */
@Controller
@RequestMapping("/userCompancy")
public class UserCompancyController {

    @Resource
    private SysServiceI sysService;
    @Resource
    private RedisClient redisClient;

    /**
     查询审核通过企业列表
     */
    @RequestMapping("/list.do")
    @ResponseBody
    public ReplyDataMode userCompancyList(UserCompancySearchForm searchForm, HttpServletRequest request){
        searchForm.setuCheckstatus(Integer.toString(StatusCode.SC_EMP_OK));
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        List<UserCompancyEntity> userCompancys = this.sysService.list(criteriaQuery);
        List<UserCompancyVO> userCompancyVOs = new ArrayList<UserCompancyVO>();

        for (UserCompancyEntity userCompancy:userCompancys) {
            UserCompancyVO userCompancyVO = new UserCompancyVO();
            userCompancyVO.copyEntity(userCompancy);
            userCompancyVOs.add(userCompancyVO);

        }
        replyDataMode.setData(userCompancyVOs);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }
    @RequestMapping("/pageList.do")
    @ResponseBody
    public ReplyDataMode userCompancyPageList(UserCompancySearchForm searchForm, HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();
        String key = "";
        if ("on".equals(CacheKey.REDIS_SWITCH)) {
            key = CacheKey.INDEX_HEZUO_COMPANY;
            // TODO 查Redis缓存
            Object cache = redisClient.get(key);
            if (cache != null) {
                replyDataMode.setData(cache);
                replyDataMode.setStatusCode("201-读缓存");
                replyDataMode.setSuccess(true);
                return replyDataMode;
            }
        }
        searchForm.setuCheckstatus(Integer.toString(StatusCode.SC_EMP_OK));
        searchForm.setIsDelete("0");
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("createTime", "desc");
        orderMap.put("updateTime", "desc");
        criteriaQuery.setOrder(orderMap);

        int pageNo = Integer.parseInt(searchForm.getPageNo());
        int pageSize = Integer.parseInt(searchForm.getPageSize());


        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
        List<UserCompancyEntity> userCompancys = mode.getResult();

        List<UserCompancyVO> userCompancyVOs = new ArrayList<UserCompancyVO>();

        for (UserCompancyEntity userCompancyEntity:userCompancys) {
            UserCompancyVO userCompancyVO = new UserCompancyVO();
            userCompancyVO.copyEntity(userCompancyEntity);
            userCompancyVO.setCompancyIntroduce(null);
            userCompancyVOs.add(userCompancyVO);

        }
        mode.setResult(userCompancyVOs);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        if (key != "") {
            // TODO 设置Redis缓存
            Object obj = JSON.toJSON(mode);
            redisClient.put(key, obj);
        }
        return replyDataMode;
    }


    @RequestMapping("/companyPageList.do")
    @ResponseBody
    public ReplyDataMode companyPageList(UserCompancySearchForm searchForm, HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();

        searchForm.setuCheckstatus(Integer.toString(StatusCode.SC_EMP_OK));
        searchForm.setIsDelete("0");
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("createTime", "desc");
        orderMap.put("updateTime", "desc");
        criteriaQuery.setOrder(orderMap);

        int pageNo = Integer.parseInt(searchForm.getPageNo());
        int pageSize = Integer.parseInt(searchForm.getPageSize());


        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
        List<UserCompancyEntity> userCompancys = mode.getResult();

        List<UserCompancyVO> userCompancyVOs = new ArrayList<UserCompancyVO>();

        for (UserCompancyEntity userCompancyEntity:userCompancys) {
            UserCompancyVO userCompancyVO = new UserCompancyVO();
            userCompancyVO.copyEntity(userCompancyEntity);
            userCompancyVO.setCompancyIntroduce(null);
            userCompancyVOs.add(userCompancyVO);

        }
        mode.setResult(userCompancyVOs);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);


        return replyDataMode;
    }

    /**
     查询审核通过企业列表
     */
    @RequestMapping("/userCompancyById.do")
    @ResponseBody
    public ReplyDataMode userCompancyById(UserCompancySearchForm searchForm, HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        List<UserCompancyEntity> userCompancys = this.sysService.list(criteriaQuery);
        List<UserCompancyVO> userCompancyVOs = new ArrayList<UserCompancyVO>();

        for (UserCompancyEntity userCompancy:userCompancys) {
            UserCompancyVO userCompancyVO = new UserCompancyVO();
            userCompancyVO.copyEntity(userCompancy);
            userCompancyVOs.add(userCompancyVO);

        }
        replyDataMode.setData(userCompancyVOs);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }
}

