package com.buss.resume.resumetemplate.controller;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.collentions.entity.CollentionsEntity;
import com.buss.common.service.SysServiceI;
import com.buss.resume.resumetemplate.entity.ResumeTemplateEntity;
import com.buss.resume.resumetemplate.trans.form.ResumeTemplateSearchForm;
import com.buss.resume.resumetemplate.trans.vo.ResumeTemplateVO;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import com.buss.member.entity.GeneralUserEntity;
import com.buss.project.projects.entity.ProjectEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


import java.util.*;

/**
 * @Title: Controller
 * @Description: dxs_resumeTemplate
 * @author onlineGenerator
 * @date 2016-07-21 15:40:26
 * @version V1.0
 *
 */

@Controller
@RequestMapping("/resumeTemplateController")
public class ResumeTemplateController {

    @Resource
    private SysServiceI sysService;


    @RequestMapping("/pageList.do")
    @ResponseBody
    public ReplyDataMode pageList(ResumeTemplateSearchForm searchForm, HttpServletRequest request) {

        if(searchForm.getJobIntention()!=null&&"不限".equals(searchForm.getJobIntention())){
            searchForm.setJobIntention(null);
        }
        if(searchForm.getTemplateStyle()!=null&&"不限".equals(searchForm.getTemplateStyle())){
            searchForm.setTemplateStyle(null);
        }
        if(searchForm.getTemplateLanguage()!=null&&"不限".equals(searchForm.getTemplateLanguage())){
            searchForm.setTemplateLanguage(null);
        }

        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        Map<String, Object> orderMap = new HashMap<>();
        orderMap.put("createTime", "desc");
        orderMap.put("updateTime", "desc");
        criteriaQuery.setOrder(orderMap);

        int pageNo = Integer.parseInt(searchForm.getPageNo());
        int pageSize = Integer.parseInt(searchForm.getPageSize());


        PageMode mode = this.sysService.list4page(criteriaQuery, pageNo, pageSize);
        List<ResumeTemplateEntity> resumeTemplates = mode.getResult();

        List<ResumeTemplateVO> resumeTemplateVOs = new ArrayList<ResumeTemplateVO>();

        for (ResumeTemplateEntity employedEntity:resumeTemplates) {
            ResumeTemplateVO resumeTemplateVO = new ResumeTemplateVO();
            resumeTemplateVO.copyEntity(employedEntity);
             resumeTemplateVOs.add(resumeTemplateVO);
            }


        mode.setResult(resumeTemplateVOs);
        replyDataMode.setData(mode);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }


    @RequestMapping("/resumeTemplateById.do")
    @ResponseBody
    public ReplyDataMode resumeTemplateById (ResumeTemplateSearchForm searchForm, HttpServletRequest request){
        searchForm.setIsDelete("0");
        ReplyDataMode replyDataMode = new ReplyDataMode();
        CriteriaQuery criteriaQuery = searchForm.getCriteriaQuery();

        List<ResumeTemplateEntity> resumeTemplates = this.sysService.list(criteriaQuery);
        List<ResumeTemplateVO> resumeTemplateVOs = new ArrayList<ResumeTemplateVO>();

        for (ResumeTemplateEntity dxsResumeTemplateEntity : resumeTemplates) {
            ResumeTemplateVO ResumeTemplateVO = new ResumeTemplateVO();
            ResumeTemplateVO.copyEntity(dxsResumeTemplateEntity);
            resumeTemplateVOs.add(ResumeTemplateVO);

        }
        replyDataMode.setData(resumeTemplateVOs);
        replyDataMode.setStatusCode("200");
        replyDataMode.setSuccess(true);

        return replyDataMode;
    }

    

}
