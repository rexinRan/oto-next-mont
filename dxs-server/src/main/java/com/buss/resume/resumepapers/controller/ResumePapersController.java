package com.buss.resume.resumepapers.controller;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;
import com.buss.resume.resume.entity.ResumeEntity;
import com.buss.resume.resumepapers.entity.ResumePapersEntity;
import com.buss.resume.resumepapers.trans.form.ResumePapersSearchForm;
import com.buss.resume.resumepapers.trans.vo.ResumePapersVO;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author lu
 *
 */
@Controller
@RequestMapping("/resumePapers")
public class ResumePapersController {

    @Resource
    private SysServiceI sysService;

    @RequestMapping("/list.do")
    @ResponseBody
    public ReplyDataMode resumePapersList(ResumePapersSearchForm searchForm, HttpServletRequest request){


        ReplyDataMode replyDataMode = new ReplyDataMode();
        searchForm.setIsDelete("0");
        //获取用户登录信息
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        ResumeEntity resumeEntity = new ResumeEntity();
        resumeEntity.setIsDelete(0);
        if(user!=null) {

            resumeEntity.setUserid(user.getId());
            List<ResumeEntity> resumeList = this.sysService.findByExample(ResumeEntity.class.getName(), resumeEntity);
            if (resumeList != null && resumeList.size() != 0) {
                searchForm.setResumeId(resumeList.get(0).getId());
                CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

                Map<String, Object> orderMap = new HashMap<String, Object>();
                orderMap.put("createTime", "desc");
                orderMap.put("updateTime", "desc");
                criteriaQuery.setOrder(orderMap);

                List<ResumePapersEntity> resumePapers = this.sysService.list(criteriaQuery);
                List<ResumePapersVO> resumePapersVOs = new ArrayList<ResumePapersVO>();

                for (ResumePapersEntity resumePapersEntity : resumePapers) {
                    ResumePapersVO resumePapersVO = new ResumePapersVO();
                    resumePapersVO.copyEntity(resumePapersEntity);
                    resumePapersVOs.add(resumePapersVO);

                }
                replyDataMode.setData(resumePapersVOs);
            }
        }else {

            replyDataMode.setData("用户未登陆");
        }

        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

    @RequestMapping("/saveResumePapers.do")
    @ResponseBody
    public ReplyDataMode saveResumePapers(ResumePapersSearchForm searchForm, HttpServletRequest request){
        String result = "操作成功";
        ReplyDataMode replyDataMode = new ReplyDataMode();

        //获取用户登录信息
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        if(user!=null) {
            ResumeEntity resumeEntity = new ResumeEntity();
            resumeEntity.setIsDelete(0);

            resumeEntity.setUserid(user.getId());
            List<ResumeEntity> resumeList = this.sysService.findByExample(ResumeEntity.class.getName(), resumeEntity);
            if (resumeList != null && resumeList.size() != 0) {
                searchForm.setResumeId(resumeList.get(0).getId());

                //设置已确定字段
                ResumePapersEntity resumePapersEntity = (ResumePapersEntity) searchForm.toEntity();
                resumePapersEntity.setIsDelete(0);
                Date date = new Date();
                resumePapersEntity.setCreateTime(date);
                resumePapersEntity.setUpdateTime(date);

                try {

                    this.sysService.saveOrUpdate(resumePapersEntity);

                }catch (Exception e){
                    result= "操作失败";

                }
            }
        }else{
            result = "用户未登陆";
        }

        replyDataMode.setData(result);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

    @RequestMapping("/updateResumePapers.do")
    @ResponseBody
    public ReplyDataMode updateResumePapers(ResumePapersSearchForm searchForm, HttpServletRequest request) throws Exception {

        String result = "操作成功";
        ReplyDataMode replyDataMode = new ReplyDataMode();

        ResumePapersEntity resumePapersEntity = this.sysService.getEntity(ResumePapersEntity.class,searchForm.getId());

        resumePapersEntity.setType(searchForm.getType());
        resumePapersEntity.setImgUrl(searchForm.getImgUrl());
        resumePapersEntity.setUpdateTime(new Date());

        try {

            this.sysService.saveOrUpdate(resumePapersEntity);

        }catch (Exception e){
            result = "操作失败";
        }

        replyDataMode.setData(result);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);
        return replyDataMode;

    }

    @RequestMapping("/deleteResumePapers.do")
    @ResponseBody
    public ReplyDataMode deleteResumePapers(ResumePapersSearchForm searchForm, HttpServletRequest request) {

        ReplyDataMode replyDataMode = new ReplyDataMode();
        String result = "操作成功";

        ResumePapersEntity resumePapersEntity = this.sysService.getEntity(ResumePapersEntity.class,searchForm.getId());
        resumePapersEntity.setIsDelete(1);

        try {

            this.sysService.saveOrUpdate(resumePapersEntity);

        }catch (Exception e){

            result = "操作失败";
        }

        replyDataMode.setData(result);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);
        return replyDataMode;

    }

    @RequestMapping("/listm.do")
    @ResponseBody
    public ReplyDataMode resumePapersListm(ResumePapersSearchForm searchForm, HttpServletRequest request){


        ReplyDataMode replyDataMode = new ReplyDataMode();
        searchForm.setIsDelete("0");


        ResumeEntity resumeEntity = new ResumeEntity();
        resumeEntity.setIsDelete(0);

            resumeEntity.setUserid("8a2c9a985722138e015722b7cbdb001c");
            List<ResumeEntity> resumeList = this.sysService.findByExample(ResumeEntity.class.getName(), resumeEntity);
            if (resumeList != null && resumeList.size() != 0) {
                searchForm.setResumeId(resumeList.get(0).getId());
                CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

                Map<String, Object> orderMap = new HashMap<String, Object>();
                orderMap.put("createTime", "desc");
                orderMap.put("updateTime", "desc");
                criteriaQuery.setOrder(orderMap);

                List<ResumePapersEntity> resumePapers = this.sysService.list(criteriaQuery);
                List<ResumePapersVO> resumePapersVOs = new ArrayList<ResumePapersVO>();

                for (ResumePapersEntity resumePapersEntity : resumePapers) {
                    ResumePapersVO resumePapersVO = new ResumePapersVO();
                    resumePapersVO.copyEntity(resumePapersEntity);
                    resumePapersVOs.add(resumePapersVO);

                }
                replyDataMode.setData(resumePapersVOs);
            }


        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


}