package com.buss.trainoutlinecourse.controller;


import com.alibaba.druid.pool.vendor.MockExceptionSorter;
import com.buss.common.service.SysServiceI;
import com.buss.member.entity.GeneralUserEntity;
import com.buss.traincoursecatalog.entity.TrainCourseCatalogEntity;
import com.buss.traincoursecatalog.trans.vo.TrainCourseCatalogVo;
import com.buss.trainoutlinecourse.entity.TrainOutlineCourseEntity;
import com.buss.trainoutlinecourse.trans.from.TrainOutlineCourseFrom;
import com.buss.trainoutlinecourse.trans.vo.TrainOutlineCourseVo;
import com.buss.trainoutlinecourseclasses.entity.TrainOutlineCourseClassesEntity;
import com.buss.trainoutlinecourseclasses.trans.from.TrainOutlineCourseClassesFrom;
import com.buss.trainoutlinecourseclasses.trans.vo.TrainOutlineCourseClassesVo;
import com.buss.trainoutlinecourseuser.entity.TrainOutlineCourseUserEntity;
import com.buss.trainoutlinecourseuser.trans.from.TrainOutlineCourseUserFrom;
import com.buss.userdetail.entity.UserDetailEntity;
import com.buss.userdetail.trans.form.UserDetailForm;
import com.buss.userdetail.trans.vo.UserDetailVO;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.jweb.core.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Title: Controller
 * @Description: dxs_train_outline_course
 * @author onlineGenerator
 * @date 2016-09-06 14:32:25
 * @version V1.0   
 *
 */
@Controller
@RequestMapping("/TrainOutlineCourse")
public class TrainOutlineCourseController {

    @Resource
    private SysServiceI sysServiceI;


    /**
     * 培训中心中的线下培训活动列表
     * @param trainOutlineCourseFrom    培训中心->线下培训
     * @param request
     * @return
     */
    @RequestMapping(value = "tabulation")
    @ResponseBody
    public ReplyDataMode tabulation (TrainOutlineCourseFrom trainOutlineCourseFrom, HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();
        trainOutlineCourseFrom.setIsDelete("0");
        if ("全部地点".equals(trainOutlineCourseFrom.getAddress()) || "".equals(trainOutlineCourseFrom.getAddress())) {
            trainOutlineCourseFrom.setAddress(null);
        }
        CriteriaQuery criteriaQuery = trainOutlineCourseFrom.getCriteriaQuery();
        criteriaQuery.addOrder("createTime","desc");

        // 根据地点模糊查询
        if (trainOutlineCourseFrom.getAddress() != null && !trainOutlineCourseFrom.getAddress().isEmpty()){

            criteriaQuery.like("address",trainOutlineCourseFrom.getAddress());
            criteriaQuery.add();
        }
        if (!StringUtil.isEmpty(trainOutlineCourseFrom.getPageNo()) && !StringUtil.isEmpty(trainOutlineCourseFrom.getPageSize())) {
            Integer pageNo = Integer.parseInt(trainOutlineCourseFrom.getPageNo());
            Integer pageSize = Integer.parseInt(trainOutlineCourseFrom.getPageSize());

            PageMode mode = this.sysServiceI.list4page(criteriaQuery,pageNo,pageSize);
            List<TrainOutlineCourseEntity> trainOutlineCourseEntityList = mode.getResult();
            List<TrainOutlineCourseVo> trainOutlineCourseVos = new ArrayList<TrainOutlineCourseVo>();

            if (trainOutlineCourseEntityList != null && trainOutlineCourseEntityList.size() > 0){
                for (TrainOutlineCourseEntity toce:trainOutlineCourseEntityList){
                    TrainOutlineCourseVo trainOutlineCourseVo = new TrainOutlineCourseVo();
                    trainOutlineCourseVo.copyEntity(toce);
                    trainOutlineCourseVos.add(trainOutlineCourseVo);
                }
            }

            mode.setResult(trainOutlineCourseVos);
            replyDataMode.setData(mode);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);

        }else {
            replyDataMode.setStatusCode("分页传输错误!");
            replyDataMode.setSuccess(false);
        }

        return replyDataMode;
    }


    /**
     * 培训中心中的线下培训活动的详情页
     * @param trainOutlineCourseFrom
     * @param request
     * @return
     */
    @RequestMapping(value = "detailed")
    @ResponseBody
    public ReplyDataMode detailed(TrainOutlineCourseFrom trainOutlineCourseFrom,HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();
        trainOutlineCourseFrom.setIsDelete("0");

        if (trainOutlineCourseFrom.getId() != null && !trainOutlineCourseFrom.getId().isEmpty()){
            List list = new ArrayList();
            Map<String,Object> map = new HashMap<String, Object>();
            TrainOutlineCourseEntity trainOutlineCourseEntity = this.sysServiceI.get(TrainOutlineCourseEntity.class,trainOutlineCourseFrom.getId());

            TrainCourseCatalogVo trainCourseCatalogVo = new TrainCourseCatalogVo();
            TrainOutlineCourseVo trainOutlineCourseVo = new TrainOutlineCourseVo();
            UserDetailVO userDetailVO = new UserDetailVO();

            if (trainOutlineCourseEntity != null){
                trainOutlineCourseVo.copyEntity(trainOutlineCourseEntity);

                // 培训分类
                if (trainOutlineCourseEntity.getTccId() != null && !trainOutlineCourseEntity.getTccId().isEmpty()){
                    TrainCourseCatalogEntity trainCourseCatalogEntity = this.sysServiceI.get(TrainCourseCatalogEntity.class,trainOutlineCourseEntity.getTccId());

                    if (trainCourseCatalogEntity != null){
                        trainCourseCatalogVo.copyEntity(trainCourseCatalogEntity);
                    }
                }

                // 用户
                if (trainOutlineCourseEntity.getUserId() != null && !trainOutlineCourseEntity.getUserId().isEmpty()){
                    GeneralUserEntity generalUserEntity = this.sysServiceI.get(GeneralUserEntity.class,trainOutlineCourseEntity.getUserId());

                    if (generalUserEntity != null){
                        UserDetailForm userDetailForm = new UserDetailForm();
                        userDetailForm.setUserId(generalUserEntity.getId());
                        userDetailForm.setIsDelete("0");
                        CriteriaQuery criteriaQuery = userDetailForm.getCriteriaQuery();

                        List<UserDetailEntity> userDetailEntityList = this.sysServiceI.list(criteriaQuery);

                        if (userDetailEntityList != null && userDetailEntityList.size() > 0){
                            userDetailVO.copyEntity(userDetailEntityList.get(0));
                        }
                    }
                }

                // 报名人数
                List<TrainOutlineCourseUserEntity> trainOutlineCourseUserEntityList = null;
                if (trainOutlineCourseEntity != null){
                    TrainOutlineCourseUserFrom trainOutlineCourseUserFrom = new TrainOutlineCourseUserFrom();
                    trainOutlineCourseUserFrom.setIsDelete("0");
                    trainOutlineCourseUserFrom.setTocId(trainOutlineCourseEntity.getId());
                    CriteriaQuery criteriaQuery = trainOutlineCourseUserFrom.getCriteriaQuery();

                    trainOutlineCourseUserEntityList = this.sysServiceI.list(criteriaQuery);
                }

                map.put("trainOutlineCourseVo",trainOutlineCourseVo);
                map.put("trainCourseCatalogVo",trainCourseCatalogVo);
                map.put("numberOfApplicants",trainOutlineCourseUserEntityList.size());
                map.put("userDetailVO",userDetailVO);

                list.add(map);
            }

            replyDataMode.setData(list);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);
        }
        return replyDataMode;
    }


    /**
     * 培训中心中的线下培训活动的详情页中的"选择培训时间及培训地址"
     * @return
     */
    @RequestMapping(value = "timeAddress")
    @ResponseBody
    public ReplyDataMode timeAddress(TrainOutlineCourseClassesFrom trainOutlineCourseClassesFrom,HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();
        trainOutlineCourseClassesFrom.setIsDelete("0");

        if (trainOutlineCourseClassesFrom.getTocId() != null && !trainOutlineCourseClassesFrom.getTocId().isEmpty()){
            if (!StringUtil.isEmpty(trainOutlineCourseClassesFrom.getPageNo()) && !StringUtil.isEmpty(trainOutlineCourseClassesFrom.getPageSize())) {
                Integer pageNo = Integer.parseInt(trainOutlineCourseClassesFrom.getPageNo());
                Integer pageSize = Integer.parseInt(trainOutlineCourseClassesFrom.getPageSize());

                CriteriaQuery criteriaQuery = trainOutlineCourseClassesFrom.getCriteriaQuery();
                criteriaQuery.addOrder("createTime","desc");

                PageMode mode = this.sysServiceI.list4page(criteriaQuery,pageNo,pageSize);
                List<TrainOutlineCourseClassesEntity> trainOutlineCourseClassesEntityList = mode.getResult();
                List<TrainOutlineCourseClassesVo> trainOutlineCourseClassesVos = new ArrayList<TrainOutlineCourseClassesVo>();

                if (trainOutlineCourseClassesEntityList != null && trainOutlineCourseClassesEntityList.size() > 0){
                    for (TrainOutlineCourseClassesEntity tocc:trainOutlineCourseClassesEntityList){
                        TrainOutlineCourseClassesVo trainOutlineCourseClassesVo = new TrainOutlineCourseClassesVo();
                        trainOutlineCourseClassesVo.copyEntity(tocc);
                        trainOutlineCourseClassesVos.add(trainOutlineCourseClassesVo);
                    }
                }

                mode.setResult(trainOutlineCourseClassesVos);
                replyDataMode.setData(mode);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);
            }
        }

        return replyDataMode;
    }
}
