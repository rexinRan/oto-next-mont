package com.buss.traincoursevideo.controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.buss.traincoursevideo.entity.TrainCourseVideoEntity;
import com.buss.traincoursevideo.trans.form.TrainCourseVideoSearchForm;
import com.buss.traincoursevideo.trans.vo.TrainCourseVideoVO;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buss.common.service.SysServiceI;

/**
 * @author lu
 *
 */
@Controller
@RequestMapping("/trainCourseVideo")
public class TrainCourseVideoController {

    @Resource
    private SysServiceI sysService;


    @RequestMapping("/pageList.do")
    @ResponseBody
    public ReplyDataMode trainCourseVideoPageList(TrainCourseVideoSearchForm searchForm, HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("sort", "asc");
        criteriaQuery.setOrder(orderMap);

        int pageNo = Integer.parseInt(searchForm.getPageNo());
        int pageSize = Integer.parseInt(searchForm.getPageSize());


        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
        List<TrainCourseVideoEntity> employedarticles = mode.getResult();

        List<TrainCourseVideoVO> trainCourseVideoVOs = new ArrayList<TrainCourseVideoVO>();

        for (TrainCourseVideoEntity trainCourseVideoEntity:employedarticles) {
            TrainCourseVideoVO trainCourseVideoVO = new TrainCourseVideoVO();
            trainCourseVideoVO.copyEntity(trainCourseVideoEntity);
            trainCourseVideoVOs.add(trainCourseVideoVO);

        }
        mode.setResult(trainCourseVideoVOs);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


    @RequestMapping("/list.do")
    @ResponseBody
    public ReplyDataMode list(TrainCourseVideoSearchForm searchForm, HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("sort", "asc");
        criteriaQuery.setOrder(orderMap);

        List<TrainCourseVideoEntity> employedarticles = this.sysService.list(criteriaQuery);

        List<TrainCourseVideoVO> trainCourseVideoVOs = new ArrayList<TrainCourseVideoVO>();

        for (TrainCourseVideoEntity trainCourseVideoEntity:employedarticles) {
            TrainCourseVideoVO trainCourseVideoVO = new TrainCourseVideoVO();
            trainCourseVideoVO.copyEntity(trainCourseVideoEntity);
            trainCourseVideoVOs.add(trainCourseVideoVO);

        }

        replyDataMode.setData(trainCourseVideoVOs);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }



    @RequestMapping("/trainCourseVideoById.do")
    @ResponseBody
    public ReplyDataMode trainCourseVideoById(TrainCourseVideoSearchForm searchForm, HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        List<TrainCourseVideoEntity> employedarticles = this.sysService.list(criteriaQuery);
        List<TrainCourseVideoVO> trainCourseVideoVOs = new ArrayList<TrainCourseVideoVO>();

        for (TrainCourseVideoEntity trainCourseVideoEntity:employedarticles) {
            TrainCourseVideoVO trainCourseVideoVO = new TrainCourseVideoVO();
            trainCourseVideoVO.copyEntity(trainCourseVideoEntity);
            trainCourseVideoVOs.add(trainCourseVideoVO);

        }
        replyDataMode.setData(trainCourseVideoVOs);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }
}

