package com.buss.resume.resumehonor.controller;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;
import com.buss.resume.resume.entity.ResumeEntity;
import com.buss.resume.resumehonor.entity.ResumeHonorEntity;
import com.buss.resume.resumehonor.trans.form.ResumeHonorSearchForm;
import com.buss.resume.resumehonor.trans.vo.ResumeHonorVO;
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
@RequestMapping("/resumeHonor")
public class ResumeHonorController {

    @Resource
    private SysServiceI sysService;

    @RequestMapping("/list.do")
    @ResponseBody
    public ReplyDataMode resumeHonorList(ResumeHonorSearchForm searchForm, HttpServletRequest request){


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

                List<ResumeHonorEntity> resumeHonor = this.sysService.list(criteriaQuery);
                List<ResumeHonorVO> resumeHonorVOs = new ArrayList<ResumeHonorVO>();

                for (ResumeHonorEntity resumeHonorEntity : resumeHonor) {
                    ResumeHonorVO resumeHonorVO = new ResumeHonorVO();
                    resumeHonorVO.copyEntity(resumeHonorEntity);
                    resumeHonorVOs.add(resumeHonorVO);

                }
                replyDataMode.setData(resumeHonorVOs);
            }
        }else {

            replyDataMode.setData("用户未登陆");
        }

        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

    @RequestMapping("/saveResumeHonor.do")
    @ResponseBody
    public ReplyDataMode saveResumeHonor(ResumeHonorSearchForm searchForm, HttpServletRequest request){
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
                ResumeHonorEntity resumeHonorEntity = (ResumeHonorEntity) searchForm.toEntity();
                resumeHonorEntity.setIsDelete(0);
                Date date = new Date();
                resumeHonorEntity.setCreateTime(date);
                resumeHonorEntity.setUpdateTime(date);

                try {

                    this.sysService.saveOrUpdate(resumeHonorEntity);

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

    @RequestMapping("/updateResumeHonor.do")
    @ResponseBody
    public ReplyDataMode updateResumeHonor(ResumeHonorSearchForm searchForm, HttpServletRequest request) throws Exception {

        String result = "操作成功";
        ReplyDataMode replyDataMode = new ReplyDataMode();

        ResumeHonorEntity resumeHonorEntity = this.sysService.getEntity(ResumeHonorEntity.class,searchForm.getId());

        String dateForm = searchForm.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        resumeHonorEntity.setTime(sdf.parse(searchForm.getTime()));
        resumeHonorEntity.setContent(searchForm.getContent());
        resumeHonorEntity.setImgUrl(searchForm.getImgUrl());
        resumeHonorEntity.setUpdateTime(new Date());

        try {

            this.sysService.saveOrUpdate(resumeHonorEntity);

        }catch (Exception e){
            result = "操作失败";
        }

        replyDataMode.setData(result);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);
        return replyDataMode;

    }

    @RequestMapping("/deleteResumeHonor.do")
    @ResponseBody
    public ReplyDataMode deleteResumeHonor(ResumeHonorSearchForm searchForm, HttpServletRequest request) {

        ReplyDataMode replyDataMode = new ReplyDataMode();
        String result = "操作成功";

        ResumeHonorEntity resumeHonorEntity = this.sysService.getEntity(ResumeHonorEntity.class,searchForm.getId());
        resumeHonorEntity.setIsDelete(1);

        try {

            this.sysService.saveOrUpdate(resumeHonorEntity);

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
    public ReplyDataMode resumeHonorListm(ResumeHonorSearchForm searchForm, HttpServletRequest request){


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

                List<ResumeHonorEntity> resumeHonor = this.sysService.list(criteriaQuery);
                List<ResumeHonorVO> resumeHonorVOs = new ArrayList<ResumeHonorVO>();

                for (ResumeHonorEntity resumeHonorEntity : resumeHonor) {
                    ResumeHonorVO resumeHonorVO = new ResumeHonorVO();
                    resumeHonorVO.copyEntity(resumeHonorEntity);
                    resumeHonorVOs.add(resumeHonorVO);

                }
                replyDataMode.setData(resumeHonorVOs);
            }

        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

}