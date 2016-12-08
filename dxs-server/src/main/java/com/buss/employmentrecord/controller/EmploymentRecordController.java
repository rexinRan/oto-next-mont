package com.buss.employmentrecord.controller;

import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.service.SysServiceI;
import com.buss.employmentrecord.entity.EmploymentRecordEntity;
import com.buss.employmentrecord.trans.form.EmplymentRecordForm;
import com.buss.employmentrecord.trans.vo.EmplymentRecordVo;
import com.buss.leadassessment.entity.LeadAssessmentEntity;
import com.buss.leadassessment.trans.form.LeadAssessmentForm;
import com.buss.leadassessment.trans.vo.LeadAssessmentVo;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.bean.PageMode;
import org.jweb.core.bean.ReplyDataMode;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.jweb.core.util.MyBeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.*;

/**
 * Created by Administrator on 2016/6/22.
 */
@Controller
@RequestMapping("/employmentrecordController")
public class EmploymentRecordController {

    @Resource
    private SysServiceI sysServiceI;

    /**
     * 初始化我的职业动态页面
     * @param emplymentRecordForm
     * @param curPage
     * @param pageSize
     * @param request
     * @return
     */
    @RequestMapping("/dynamicState")
    @ResponseBody
    public ReplyDataMode dynamicState(EmplymentRecordForm emplymentRecordForm, Integer curPage, Integer pageSize, HttpServletRequest request){

        ReplyDataMode replyDataMode = new ReplyDataMode();
        LeadAssessmentForm leadAssessmentForm = new LeadAssessmentForm();

        // 获取当前用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

        // 判断是否为查看所有评价信息
        if (emplymentRecordForm.getId() == null){       // 查看所有
            // 判断是否有当前用户
            if (user != null){
                // 设置查询条件
                emplymentRecordForm.setWorkUserId(user.getId());
                emplymentRecordForm.setIsDelete("0");
                CriteriaQuery criteriaQuery = emplymentRecordForm.getCriteriaQuery();
                criteriaQuery.setCurPage(curPage);
                criteriaQuery.setPageSize(pageSize);
                criteriaQuery.addOrder("createTime", "desc");


                // 查询
                PageMode mode = this.sysServiceI.list4page(criteriaQuery,curPage,pageSize);
                List<EmploymentRecordEntity> ere = mode.getResult();
                List<EmplymentRecordVo> emplymentRecordVos = new ArrayList<EmplymentRecordVo>();

                for (EmploymentRecordEntity employmentRecordEntity:ere){

                    EmplymentRecordVo emplymentRecordVo = new EmplymentRecordVo();
                    emplymentRecordVo.copyEntity(employmentRecordEntity);

                    Set<LeadAssessmentEntity> lae = employmentRecordEntity.getLeadAssessmentEntities();

                    for(LeadAssessmentEntity leadAssessmentEntity:lae){
                        if (leadAssessmentEntity.getIsDelete() == 0) {
                            Map<String,Object> map = new HashMap<String,Object>();
                            map.put("leadAssessment",leadAssessmentEntity.getLeadAssessment());
                            map.put("leadAssessmentId",leadAssessmentEntity.getId());
                            emplymentRecordVo.getList().add(map);
                        }
                    }

                    emplymentRecordVos.add(emplymentRecordVo);
                }
                mode.setResult(emplymentRecordVos);
                replyDataMode.setData(mode);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);
            }
        }else {

            EmploymentRecordEntity employmentRecordEntity = this.sysServiceI.get(EmploymentRecordEntity.class,emplymentRecordForm.getId());

            EmplymentRecordVo emplymentRecordVo = new EmplymentRecordVo();
            emplymentRecordVo.copyEntity(employmentRecordEntity);
            Set<LeadAssessmentEntity> set = employmentRecordEntity.getLeadAssessmentEntities();
            for(LeadAssessmentEntity leadAssessmentEntity:set){
                if (leadAssessmentEntity.getIsDelete() == 0){
                    Map<String,Object> map = new HashMap<String,Object>();
                    map.put("leadAssessment",leadAssessmentEntity.getLeadAssessment());
                    map.put("leadAssessmentId",leadAssessmentEntity.getId());
                    emplymentRecordVo.getList().add(map);
                }
            }
                replyDataMode.setData(emplymentRecordVo);
                replyDataMode.setStatusCode("200");
                replyDataMode.setSuccess(true);

            }
        return replyDataMode;
    }


    /**
     * 保存对企业的评价
     * @param emplymentRecordForm
     * @param leadAssessment
     * @param request
     * @return
     */
    @RequestMapping("saveLeadAssessment")
    @ResponseBody
    public ReplyDataMode saveLeadAssessment(EmplymentRecordForm emplymentRecordForm,String leadAssessment, HttpServletRequest request){

        ReplyDataMode replyDataMode = new ReplyDataMode();

        LeadAssessmentEntity leadAssessmentEntity = new LeadAssessmentEntity();

        // 获取当前用户
        Subject currentUser = SecurityUtils.getSubject();
        AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");
        try {
            // 处理乱码问题
            /*if(leadAssessment != null && leadAssessment != ""){
                try {
                    leadAssessment = new String(leadAssessment.getBytes("iso-8859-1"), "utf-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }*/
            Date date = new Date();

            leadAssessmentEntity.setLeadAssessment(leadAssessment);
            leadAssessmentEntity.setEmploymentRecordId(emplymentRecordForm.getId());
            leadAssessmentEntity.setCreateTime(date);
            leadAssessmentEntity.setUpdateTime(date);
            leadAssessmentEntity.setIsDelete(0);

            this.sysServiceI.saveOrUpdate(leadAssessmentEntity);

        }catch (Exception e){
            replyDataMode.setStatusCode("提交失败！");
            replyDataMode.setSuccess(false);
            return replyDataMode;
        }
        replyDataMode.setStatusCode("修改成功！");
        replyDataMode.setSuccess(true);
        return replyDataMode;
    }
}
