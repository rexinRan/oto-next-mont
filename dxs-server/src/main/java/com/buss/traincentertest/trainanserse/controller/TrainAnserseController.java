package com.buss.traincentertest.trainanserse.controller;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;


import com.buss.traincentertest.trainanserse.entity.TrainAnserseEntity;
import com.buss.traincentertest.trainanserse.trans.form.TrainAnserseSearchForm;
import com.buss.traincentertest.trainanserse.trans.vo.TrainAnserseVO;
import com.buss.traincentertest.traintestuser.entity.TrainTestUserEntity;
import com.buss.traincoursevideo.entity.TrainCourseVideoEntity;
import com.buss.traincoursevideo.trans.vo.TrainCourseVideoVO;

import com.buss.userdetail.entity.UserDetailEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
@RequestMapping("/trainAnserse")
public class TrainAnserseController {

    @Resource
    private SysServiceI sysService;

    @RequestMapping("/list.do")
    @ResponseBody
    public ReplyDataMode trainList(TrainAnserseSearchForm searchForm, HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String,Object> orderMap = new HashMap<String,Object>();
        orderMap.put("createTime", "desc");
        criteriaQuery.setOrder(orderMap);

        List<TrainAnserseEntity> trainAnserses = this.sysService.list(criteriaQuery);
        List<TrainAnserseVO> trainAnserseVOs = new ArrayList<TrainAnserseVO>();

        for (TrainAnserseEntity trainAnserseEntity:trainAnserses) {
            TrainAnserseVO trainAnserseVO = new TrainAnserseVO();
            trainAnserseVO.copyEntity(trainAnserseEntity);
            trainAnserseVOs.add(trainAnserseVO);

        }
        replyDataMode.setData(trainAnserseVOs);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


    @RequestMapping("/pageList.do")
    @ResponseBody
    public ReplyDataMode trainAnsersePageList(TrainAnserseSearchForm searchForm, HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("sort","asc");
        orderMap.put("createTime", "desc");
        criteriaQuery.setOrder(orderMap);

        int pageNo = Integer.parseInt(searchForm.getPageNo());
        int pageSize = Integer.parseInt(searchForm.getPageSize());


        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
        List<TrainAnserseEntity> trainAnserses = mode.getResult();

        List<Map> trainAnserseVOs = new ArrayList<>();

        for (TrainAnserseEntity trainAnserseEntity:trainAnserses) {
            Map map = new HashMap();
            TrainAnserseVO trainAnserseVO = new TrainAnserseVO();
            trainAnserseVO.copyEntity(trainAnserseEntity);

            trainAnserseVOs.add(map);

        }
        mode.setResult(trainAnserseVOs);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


    @RequestMapping("/trainAnserseById.do")
    @ResponseBody
    public ReplyDataMode trainAnserseById(TrainAnserseSearchForm searchForm, HttpServletRequest request){



        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        List<TrainAnserseEntity> trainAnserses = this.sysService.list(criteriaQuery);

        Map map = new HashMap();
        map.put("trainAnserseVO",null);
        map.put("trainVideoList",null);


        if(trainAnserses!=null&&trainAnserses.size()!=0){
            TrainAnserseEntity trainAnserseEntity = trainAnserses.get(0);

            TrainAnserseVO trainAnserseVO = new TrainAnserseVO();
            trainAnserseVO.copyEntity(trainAnserseEntity);

            //获取用户登录信息
            Subject currentUser = SecurityUtils.getSubject();
            AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");


        }


        replyDataMode.setData(map);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


    @RequestMapping("/Anserse.do")
    @ResponseBody
    public ReplyDataMode anserse(TrainAnserseSearchForm searchForm, HttpServletRequest request){

        ReplyDataMode replyDataMode = new ReplyDataMode();
        String answer ="";

        //获取用户登录信息
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        TrainTestUserEntity trainTestUserEntity = new TrainTestUserEntity();
        trainTestUserEntity.setUserId(user.getId());
        trainTestUserEntity.setTtId(searchForm.getTtId());
        trainTestUserEntity.setIsDelete(0);
        List<TrainTestUserEntity> list = this.sysService.findByExample(TrainTestUserEntity.class.getName(),trainTestUserEntity);
        if(list!=null&&list.size()!=0){
            TrainTestUserEntity trainTestUser = list.get(0);
            answer = trainTestUser.getAnswer();
            String [] answers = answer.split(",");
            for(int i=0;i<answers.length;i++){

            }
        }



        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }
}

