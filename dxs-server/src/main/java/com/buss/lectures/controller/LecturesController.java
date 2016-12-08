package com.buss.lectures.controller;


import com.buss.actives.entity.ActivessEntity;
import com.buss.actives.trans.vo.ActivessVO;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;
import com.buss.lectures.entity.LecturesEntity;
import com.buss.lectures.trans.from.LecturesFrom;
import com.buss.lectures.trans.vo.LecturesVo;
import com.buss.lecturesgroups.entity.LecturesGroupsEntity;
import com.buss.lecturesgroups.trans.vo.LecturesGroupsVo;
import com.buss.lecturespersion.entity.LecturesPersionEntity;
import com.buss.lecturespersion.trans.from.LecturesPersionFrom;
import com.buss.lecturespersion.trans.vo.LecturesPersionVo;
import com.buss.userdetail.entity.UserDetailEntity;
import com.buss.userdetail.trans.form.UserDetailForm;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author onlineGenerator
 * @version V1.0
 * @Title: Controller
 * @Description: dxs_s
 * @date 2016-08-22 09:49:54
 */
@Controller
@RequestMapping("/LecturesController")
public class LecturesController {

    @Autowired
    private SysServiceI sysServiceI;

    /**
     * 全国巡讲>>>>根据所在站名查询
     *
     * @param lecturesFrom 名师巡讲->详情页
     * @param request
     * @return
     */
    @RequestMapping(value = "lecture")
    @ResponseBody
    public ReplyDataMode lecture(LecturesFrom lecturesFrom, HttpServletRequest request) {
        ReplyDataMode replyDataMode = new ReplyDataMode();

        lecturesFrom.setIsDelete("0");


        // 根据 (地址/专场) 查询列表
        if ((lecturesFrom.getLectureAddressShort() != null && !lecturesFrom.getLectureAddressShort().isEmpty()) ||
                (lecturesFrom.getLgId() != null && !lecturesFrom.getLgId().isEmpty()) ||
                (lecturesFrom.getOutSign() != null && !lecturesFrom.getOutSign().isEmpty())) {

            CriteriaQuery criteriaQuery = lecturesFrom.getCriteriaQuery();
            criteriaQuery.addOrder("createTime", "desc");


            List list1 = new ArrayList();
            if (lecturesFrom.getPageNo() != null && !lecturesFrom.getPageNo().isEmpty() && lecturesFrom.getPageSize() != null && !lecturesFrom.getPageSize().isEmpty()) {
                int pageNo = Integer.parseInt(lecturesFrom.getPageNo());
                int pageSize = Integer.parseInt(lecturesFrom.getPageSize());

                PageMode mode = this.sysServiceI.list4page(criteriaQuery, pageNo, pageSize);
                List<LecturesEntity> lecturesEntityList = mode.getResult();

                Map<String, List> map = new HashMap<String, List>();
                List<Map> list = new ArrayList<Map>();
                // 名师巡讲->详情页
                List lecturesVos = new ArrayList<LecturesVo>();

                // 名师巡讲->企业家/名家
                List<LecturesPersionVo> lecturesPersionVos = new ArrayList<LecturesPersionVo>();

                if (lecturesEntityList != null && lecturesEntityList.size() > 0) {

                    for (LecturesEntity le : lecturesEntityList) {
                        Map<String,Object> map1 = new HashMap<>();
                        LecturesVo lecturesVo = new LecturesVo();
                        // 根据lp_id查询名师巡讲->企业家/名家中的主讲
                        if (le.getLpId() != null && !le.getLpId().isEmpty()){
                            LecturesPersionEntity lecturesPersionEntity = this.sysServiceI.get(LecturesPersionEntity.class, le.getLpId());
                            LecturesPersionVo lecturesPersionVo = new LecturesPersionVo();
                            lecturesPersionVo.copyEntity(lecturesPersionEntity);

                            map1.put("lecturesPersionVo",lecturesPersionVo);
                        }
                        lecturesVo.copyEntity(le);
                        map1.put("lecturesvo",lecturesVo);
                        lecturesVos.add(map1);
                    }
                }

                // 根据专场查询列表
                if (lecturesFrom.getLgId() != null && !lecturesFrom.getLgId().isEmpty()){
                    Map<String,Object> map2 = new HashMap<>();
                    LecturesGroupsEntity lecturesGroupsEntity = this.sysServiceI.get(LecturesGroupsEntity.class,lecturesFrom.getLgId());
                    LecturesGroupsVo lecturesGroupsVo = new LecturesGroupsVo();
                    if (lecturesGroupsEntity != null){
                        lecturesGroupsVo.copyEntity(lecturesGroupsEntity);
                    }

                    list1.add(lecturesGroupsVo);
                    list1.add(lecturesVos);
                    mode.setResult(list1);
                    replyDataMode.setData(mode);
                    replyDataMode.setStatusCode("200");
                    replyDataMode.setSuccess(true);

                }else {
                    mode.setResult(lecturesVos);
                    replyDataMode.setData(mode);
                    replyDataMode.setStatusCode("200");
                    replyDataMode.setSuccess(true);
                }

            }else {
                replyDataMode.setStatusCode("分页参数传递错误!");
                replyDataMode.setSuccess(false);
            }
        }


        // 详情页
        if (lecturesFrom.getId() != null && !lecturesFrom.getId().isEmpty()) {
            LecturesEntity lecturesEntity = this.sysServiceI.get(LecturesEntity.class, lecturesFrom.getId());

            Map<String, Object> map = new HashMap<String, Object>();
            if (lecturesEntity != null) {
                LecturesVo lecturesVo = new LecturesVo();
                lecturesVo.copyEntity(lecturesEntity);
                map.put("lecturesVo", lecturesVo);

                // 将lectureContentImgs切割
                String[] imgs = null;
                if (lecturesEntity.getLectureContentImgs() != null && !lecturesEntity.getLectureContentImgs().isEmpty()) {
                    imgs = lecturesEntity.getLectureContentImgs().split("#");
                }
                map.put("imgs", imgs);

                // 查询所关联的名师巡讲->企业家/名家表
                LecturesPersionFrom lecturesPersionFrom = new LecturesPersionFrom();
                if (lecturesEntity.getLpId() != null && !lecturesEntity.getLpId().isEmpty()){
                    LecturesPersionEntity lecturesPersionEntity = this.sysServiceI.get(LecturesPersionEntity.class, lecturesEntity.getLpId());
                    if (lecturesPersionEntity != null) {
                        LecturesPersionVo lecturesPersionVo = new LecturesPersionVo();
                        lecturesPersionVo.copyEntity(lecturesPersionEntity);
                        map.put("lecturesPersionVo", lecturesPersionVo);
                    }
                }
            }

            replyDataMode.setData(map);
            replyDataMode.setStatusCode("200");
            replyDataMode.setSuccess(true);
        }

        return replyDataMode;
    }


    /**
     * 根据场次查询>>名家特约专场>>特约名家专场详情列表页
     *
     * @param lecturesFrom
     * @param request
     * @return
     */
    @RequestMapping(value = "tabulation")
    @ResponseBody
    public ReplyDataMode tabulation(LecturesFrom lecturesFrom, HttpServletRequest request) {
        ReplyDataMode replyDataMode = new ReplyDataMode();

        lecturesFrom.setIsDelete("0");
        if (lecturesFrom.getLgId() != null && !lecturesFrom.getLgId().isEmpty()) {
            CriteriaQuery criteriaQuery = lecturesFrom.getCriteriaQuery();
            criteriaQuery.addOrder("createTime", "desc");

            if (lecturesFrom.getPageNo() != null && !lecturesFrom.getPageNo().isEmpty() && lecturesFrom.getPageSize() != null && !lecturesFrom.getPageSize().isEmpty()) {
                Integer pageNo = Integer.parseInt(lecturesFrom.getPageNo());
                Integer pageSize = Integer.parseInt(lecturesFrom.getPageSize());

                PageMode mode = this.sysServiceI.list4page(criteriaQuery,pageNo,pageSize);
                List<LecturesEntity> lecturesEntityList = mode.getResult();
                List<LecturesVo> lecturesVos = new ArrayList<LecturesVo>();

                if (lecturesEntityList != null && lecturesEntityList.size() > 0){
                    for (LecturesEntity le:lecturesEntityList){
                        LecturesVo lecturesVo = new LecturesVo();
                        lecturesVo.copyEntity(le);
                        lecturesVos.add(lecturesVo);
                    }
                }

                mode.setResult(lecturesVos);
                replyDataMode.setData(mode);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);
            }else {
                replyDataMode.setStatusCode("分页参数传递错误!");
            }

        } else {
            replyDataMode.setStatusCode("参数传递错误!");
            replyDataMode.setSuccess(false);
        }

        return replyDataMode;
    }


    /**
     *  名师巡讲中预约
     * @param lecturesFrom
     * @param request
     * @return
     */
    @RequestMapping(value = "bespeak")
    @ResponseBody
    public ReplyDataMode bespeak(LecturesFrom lecturesFrom,HttpServletRequest request){
        ReplyDataMode replyDataMode = new ReplyDataMode();
        lecturesFrom.setIsDelete("0");
        Map<String,Object> map = new HashMap<String,Object>();

        if (lecturesFrom.getId() != null && !lecturesFrom.getId().isEmpty()){

            // 获取当前登录用户的详细信息
            Subject currentUser = SecurityUtils.getSubject();
            AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
            if (user != null){
                LecturesEntity lecturesEntity = this.sysServiceI.get(LecturesEntity.class,lecturesFrom.getId());

                // 查询活动
                if (lecturesEntity.getAcitveId() != null && !lecturesEntity.getAcitveId().isEmpty()){
                    ActivessEntity activessEntity = this.sysServiceI.get(ActivessEntity.class,lecturesEntity.getAcitveId());
                    ActivessVO activessVO = new ActivessVO();
                    if (activessEntity != null){
                        activessVO.copyEntity(activessEntity);
                    }

                    map.put("activessVO",activessVO);
                }

                UserDetailForm userDetailForm = new UserDetailForm();
                userDetailForm.setIsDelete("0");
                userDetailForm.setUserId(user.getId());
                CriteriaQuery criteriaQuery = userDetailForm.getCriteriaQuery();

                List<UserDetailEntity> userDetailEntityList = this.sysServiceI.list(criteriaQuery);
                map.put("user",userDetailEntityList.get(0));

                replyDataMode.setData(map);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);

            }else {
                replyDataMode.setStatusCode("请您登陆!");
                replyDataMode.setSuccess(false);
            }
        }

        return replyDataMode;
    }
}
