package com.buss.resume.resume.controller;
import java.util.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.impl.FileService;
import com.buss.file.entity.FileEntity;
import com.buss.resume.resume.entity.ResumeEntity;
import com.buss.resume.resume.trans.form.ResumeSearchForm;
import com.buss.resume.resume.trans.vo.ResumeVO;
import com.buss.userdetail.entity.UserDetailEntity;
import com.buss.userdetail.trans.form.UserDetailForm;
import com.buss.userdetail.trans.vo.UserDetailVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.jweb.core.util.BeanUtil;
import org.jweb.core.util.MyBeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.buss.common.service.SysServiceI;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author lu
 *
 */
@Controller
@RequestMapping("/resume")
public class ResumeController {

    @Resource
    private SysServiceI sysService;


    @RequestMapping("/selectInfo.do")
    @ResponseBody
    public ReplyDataMode selectInfo(UserDetailForm searchForm, HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        //获取用户登录信息
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if(user!= null){
            searchForm.setUserId(user.getId());
            CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

            Map<String,Object> orderMap = new HashMap<String,Object>();
            orderMap.put("createTime", "desc");
            orderMap.put("updateTime", "desc");
            criteriaQuery.setOrder(orderMap);

            List<UserDetailEntity> resume = this.sysService.list(criteriaQuery);
            List<UserDetailVO> userDetailVOs = new ArrayList<UserDetailVO>();

            for (UserDetailEntity userDetailEntity:resume) {
                UserDetailVO userDetailVO = new UserDetailVO();
                userDetailVO.copyEntity(userDetailEntity);
                userDetailVOs.add(userDetailVO);

            }
            replyDataMode.setData(userDetailVOs);
        }else {
            replyDataMode.setData("用户未登陆");
        }

        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

    @RequestMapping("/select.do")
    @ResponseBody
    public ReplyDataMode resumeSelect(ResumeSearchForm searchForm, HttpServletRequest request){
        searchForm.setIsDelete("0");

        ReplyDataMode replyDataMode = new ReplyDataMode();

        //获取用户登录信息
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
        if(user!=null){

            //设置查询条件，只查询当前登录用户
            searchForm.setUserid(user.getId());
            CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

            Map<String,Object> orderMap = new HashMap<String,Object>();
            orderMap.put("createTime", "desc");
            orderMap.put("updateTime", "desc");
            criteriaQuery.setOrder(orderMap);

            List<ResumeEntity> resume = this.sysService.list(criteriaQuery);
            List<ResumeVO> resumeVOs = new ArrayList<ResumeVO>();

            for (ResumeEntity resumeEntity:resume) {
                ResumeVO resumeVO = new ResumeVO();
                resumeVO.copyEntity(resumeEntity);
                resumeVOs.add(resumeVO);

            }
            replyDataMode.setData(resumeVOs);
        }else {
            replyDataMode.setData("用户未登陆");
        }

        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


    @RequestMapping("/saveTarget.do")
    @ResponseBody
    public ReplyDataMode saveTarget(ResumeSearchForm searchForm, HttpServletRequest request){

        ReplyDataMode replyDataMode = new ReplyDataMode();
        String result = "操作成功";

        //获取用户登录信息
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        ResumeEntity resumeEntity = new ResumeEntity();
        resumeEntity.setIsDelete(0);
        if(user!=null){
            resumeEntity.setUserid(user.getId());
            List<ResumeEntity> resumeList = this.sysService.findByExample(ResumeEntity.class.getName(),resumeEntity);
            if(resumeList!=null&&resumeList.size()!=0){
                ResumeEntity resume = resumeList.get(0);
                Date date = new Date();
                resume.setUpdateTime(date);

                resume.setJobStatus((searchForm.getJobStatus()));
                resume.setTargetJob(searchForm.getTargetJob());
                resume.setTargetJobType(searchForm.getTargetJobType());
                resume.setJobType(searchForm.getJobType());
                resume.setTargetAddress(searchForm.getTargetAddress());
                try {

                    this.sysService.saveOrUpdate(resume);
                }catch (Exception e){
                    result = "操作失败";

                }
            }

        }else {
            result = "用户未登陆";
        }

        replyDataMode.setData(result);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;

    }

    @RequestMapping("/saveHobby.do")
    @ResponseBody
    public ReplyDataMode saveHobby(ResumeSearchForm searchForm, HttpServletRequest request){

        ReplyDataMode replyDataMode = new ReplyDataMode();
        String result = "操作成功";

        //获取用户登录信息
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        ResumeEntity resumeEntity = new ResumeEntity();
        resumeEntity.setIsDelete(0);
        if(user!=null){
            resumeEntity.setUserid(user.getId());
            List<ResumeEntity> resumeList = this.sysService.findByExample(ResumeEntity.class.getName(),resumeEntity);
            if(resumeList!=null&&resumeList.size()!=0){
                ResumeEntity resume = resumeList.get(0);
                Date date = new Date();
                resume.setUpdateTime(date);
                resume.setHobby(searchForm.getHobby());
                try {

                    this.sysService.saveOrUpdate(resume);
                }catch (Exception e){
                    result = "操作失败";

                }
            }

        }else {
            result = "用户未登陆";
        }

        replyDataMode.setData(result);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

    @RequestMapping("/saveOther.do")
    @ResponseBody
    public ReplyDataMode saveOther(ResumeSearchForm searchForm, HttpServletRequest request){

        ReplyDataMode replyDataMode = new ReplyDataMode();
        String result = "操作成功";

        //获取用户登录信息
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        ResumeEntity resumeEntity = new ResumeEntity();
        resumeEntity.setIsDelete(0);
        if(user!=null){
            resumeEntity.setUserid(user.getId());
            List<ResumeEntity> resumeList = this.sysService.findByExample(ResumeEntity.class.getName(),resumeEntity);
            if(resumeList!=null&&resumeList.size()!=0){
                ResumeEntity resume = resumeList.get(0);
                Date date = new Date();
                resume.setUpdateTime(date);
                resume.setSelfAssessment(searchForm.getSelfAssessment());
                try {

                    this.sysService.saveOrUpdate(resume);
                }catch (Exception e){
                    result = "操作失败";

                }
            }

        }else {
            result = "用户未登陆";
        }

        replyDataMode.setData(result);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

    @RequestMapping("/isPublic.do")
    @ResponseBody
    public ReplyDataMode isPublic(ResumeSearchForm searchForm, HttpServletRequest request){

        ReplyDataMode replyDataMode = new ReplyDataMode();
        String result = "操作成功";

        //获取用户登录信息
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        ResumeEntity resumeEntity = new ResumeEntity();
        resumeEntity.setIsDelete(0);
        if(user!=null){
            resumeEntity.setUserid(user.getId());
            List<ResumeEntity> resumeList = this.sysService.findByExample(ResumeEntity.class.getName(),resumeEntity);
            if(resumeList!=null&&resumeList.size()!=0){
                ResumeEntity resume = resumeList.get(0);
                Date date = new Date();
                resume.setUpdateTime(date);
                resume.setIsPublic(Integer.parseInt(searchForm.getIsPublic()));
                try {

                    this.sysService.saveOrUpdate(resume);
                }catch (Exception e){
                    result = "操作失败";

                }
            }

        }else {
            result = "用户未登陆";
        }

        replyDataMode.setData(result);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


    @RequestMapping("/selectInfom.do")
    @ResponseBody
    public ReplyDataMode selectInfom(UserDetailForm searchForm, HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();

            searchForm.setUserId("8a2c9a985722138e015722b7cbdb001c");
            CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

            Map<String,Object> orderMap = new HashMap<String,Object>();
            orderMap.put("createTime", "desc");
            orderMap.put("updateTime", "desc");
            criteriaQuery.setOrder(orderMap);

            List<UserDetailEntity> resume = this.sysService.list(criteriaQuery);
            List<UserDetailVO> userDetailVOs = new ArrayList<UserDetailVO>();

            for (UserDetailEntity userDetailEntity:resume) {
                UserDetailVO userDetailVO = new UserDetailVO();
                userDetailVO.copyEntity(userDetailEntity);
                userDetailVOs.add(userDetailVO);

            }
            replyDataMode.setData(userDetailVOs);


        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

    @RequestMapping("/selectm.do")
    @ResponseBody
    public ReplyDataMode resumeSelectm(ResumeSearchForm searchForm, HttpServletRequest request){
        searchForm.setIsDelete("0");

        ReplyDataMode replyDataMode = new ReplyDataMode();


            //设置查询条件，只查询当前登录用户
            searchForm.setUserid("8a2c9a985722138e015722b7cbdb001c");
            CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

            Map<String,Object> orderMap = new HashMap<String,Object>();
            orderMap.put("createTime", "desc");
            orderMap.put("updateTime", "desc");
            criteriaQuery.setOrder(orderMap);

            List<ResumeEntity> resume = this.sysService.list(criteriaQuery);
            List<ResumeVO> resumeVOs = new ArrayList<ResumeVO>();

            for (ResumeEntity resumeEntity:resume) {
                ResumeVO resumeVO = new ResumeVO();
                resumeVO.copyEntity(resumeEntity);
                resumeVOs.add(resumeVO);

            }
            replyDataMode.setData(resumeVOs);

        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


    @RequestMapping("/useTemplate.do")
    @ResponseBody
    public ReplyDataMode useTemplate(ResumeSearchForm searchForm, HttpServletRequest request){

        ReplyDataMode replyDataMode = new ReplyDataMode();
        String result = "操作成功";

        //获取用户登录信息
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        ResumeEntity resumeEntity = new ResumeEntity();
        resumeEntity.setIsDelete(0);
        if(user!=null){
            resumeEntity.setUserid(user.getId());
            List<ResumeEntity> resumeList = this.sysService.findByExample(ResumeEntity.class.getName(),resumeEntity);
            if(resumeList!=null&&resumeList.size()!=0){
                ResumeEntity resume = resumeList.get(0);
                Date date = new Date();
                resume.setUpdateTime(date);
                resume.setRtId((searchForm.getRtId()));

                try {

                    this.sysService.saveOrUpdate(resume);
                }catch (Exception e){
                    result = "操作失败";

                }
            }

        }else {
            result = "用户未登陆";
        }

        replyDataMode.setData(result);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;

    }



}