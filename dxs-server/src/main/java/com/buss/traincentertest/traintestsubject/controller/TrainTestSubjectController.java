package com.buss.traincentertest.traintestsubject.controller;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;


import com.buss.traincentertest.traintestsubject.entity.TrainTestSubjectEntity;
import com.buss.traincentertest.traintestsubject.trans.form.TrainTestSubjectSearchForm;
import com.buss.traincentertest.traintestsubject.trans.vo.TrainTestSubjectVO;
import com.buss.traincentertest.traintestsubjectitem.entity.TrainTestSubjectItemEntity;
import com.buss.traincentertest.traintestsubjectitem.trans.form.TrainTestSubjectItemSearchForm;
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
@RequestMapping("/trainTestSubject")
public class TrainTestSubjectController {

    @Resource
    private SysServiceI sysService;

    @RequestMapping("/list.do")
    @ResponseBody
    public ReplyDataMode trainList(TrainTestSubjectSearchForm searchForm, HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String,Object> orderMap = new HashMap<String,Object>();
        orderMap.put("createTime", "desc");
        criteriaQuery.setOrder(orderMap);

        List<TrainTestSubjectEntity> trainTestSubjects = this.sysService.list(criteriaQuery);
        List<TrainTestSubjectVO> trainTestSubjectVOs = new ArrayList<TrainTestSubjectVO>();

        for (TrainTestSubjectEntity trainTestSubjectEntity:trainTestSubjects) {
            TrainTestSubjectVO trainTestSubjectVO = new TrainTestSubjectVO();
            trainTestSubjectVO.copyEntity(trainTestSubjectEntity);
            trainTestSubjectVOs.add(trainTestSubjectVO);

        }
        replyDataMode.setData(trainTestSubjectVOs);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


    @RequestMapping("/pageList.do")
    @ResponseBody
    public ReplyDataMode trainTestSubjectPageList(TrainTestSubjectSearchForm searchForm, HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("subjectNum","asc");
        criteriaQuery.setOrder(orderMap);

        int pageNo = Integer.parseInt(searchForm.getPageNo());
        int pageSize = Integer.parseInt(searchForm.getPageSize());


        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
        List<TrainTestSubjectEntity> trainTestSubjects = mode.getResult();

        List<TrainTestSubjectVO> trainTestSubjectVOs = new ArrayList<>();

        for (TrainTestSubjectEntity trainTestSubjectEntity:trainTestSubjects) {
            TrainTestSubjectVO trainTestSubjectVO = new TrainTestSubjectVO();
            trainTestSubjectVO.copyEntity(trainTestSubjectEntity);

            TrainTestSubjectItemSearchForm itemSearchForm = new TrainTestSubjectItemSearchForm();
            itemSearchForm.setIsDelete("0");
            itemSearchForm.setTtsId(trainTestSubjectVO.getId());
            CriteriaQuery itemCriteriaQuery = itemSearchForm.getCriteriaQuery();

            Map<String, Object> itemOrderMap = new HashMap<>();
            itemOrderMap.put("sort","asc");
            itemCriteriaQuery.setOrder(itemOrderMap);
            List<TrainTestSubjectItemEntity> list = this.sysService.list(itemCriteriaQuery);
            trainTestSubjectVO.setItemList(list);

            trainTestSubjectVOs.add(trainTestSubjectVO);

        }
        mode.setResult(trainTestSubjectVOs);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


    @RequestMapping("/trainTestSubjectById.do")
    @ResponseBody
    public ReplyDataMode trainTestSubjectById(TrainTestSubjectSearchForm searchForm, HttpServletRequest request){



        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        List<TrainTestSubjectEntity> trainTestSubjects = this.sysService.list(criteriaQuery);

        Map map = new HashMap();
        map.put("trainTestSubjectVO",null);
        map.put("trainVideoList",null);


        if(trainTestSubjects!=null&&trainTestSubjects.size()!=0){
            TrainTestSubjectEntity trainTestSubjectEntity = trainTestSubjects.get(0);

            TrainTestSubjectVO trainTestSubjectVO = new TrainTestSubjectVO();
            trainTestSubjectVO.copyEntity(trainTestSubjectEntity);

            //获取用户登录信息
            Subject currentUser = SecurityUtils.getSubject();
            AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");


        }


        replyDataMode.setData(map);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }
}

