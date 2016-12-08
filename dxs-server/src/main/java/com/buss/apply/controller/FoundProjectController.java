package com.buss.apply.controller;

import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.model.json.AjaxJson;
import com.buss.common.service.SysServiceI;
import com.buss.file.entity.FileEntity;
import com.buss.foundproject.entity.DxsEntrepreneurshipProjectFundEntity;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/6/24.
 */
@Controller
@RequestMapping("/applyFound")
public class FoundProjectController {

    @Autowired
    private SysServiceI sysServiceI;

    /**
     * 创业基金/创业基地 申请接口
     * 创业基金type为3, 创业基地为4
     */
    @RequestMapping("/applayfund")
    @ResponseBody
    public AjaxJson ApplayFund(String fm, String type, DxsEntrepreneurshipProjectFundEntity projectFundEntity, HttpServletRequest request) {
        AjaxJson ajaxJson = new AjaxJson();
        String message = "操作成功!";

        try {
            //获取用户登录信息
            Subject currentUser = SecurityUtils.getSubject();
            AuthUserVO user = (AuthUserVO) currentUser.getSession().getAttribute("userInfo");

            DxsEntrepreneurshipProjectFundEntity entity = new DxsEntrepreneurshipProjectFundEntity();
            entity.setIsDelete(0);
            entity.setType(Integer.parseInt(type));
            entity.setUserId(user.getId());
            entity.setApplytoId(projectFundEntity.getApplytoId());
            List list=  this.sysServiceI.findByExample(DxsEntrepreneurshipProjectFundEntity.class.getName(),entity);
                if(list!=null&&list.size()>0){
                    message ="您已申请过";
                    ajaxJson.setMsg(message);

                    return ajaxJson;
                }

            // 添加用户申请表
            Date date = new Date();
            projectFundEntity.setIsDelete(0);
            projectFundEntity.setCreateTime(date);
            projectFundEntity.setUpdateTime(date);
            projectFundEntity.setCheckCode(0); // 0 待审核  5审核中(后台用户下载)
                                                // 10 审核通过   15 审核未通过
            projectFundEntity.setUserId(user.getId());

            this.sysServiceI.saveOrUpdate(projectFundEntity);
            projectFundEntity = (DxsEntrepreneurshipProjectFundEntity) this.sysServiceI.findByExample(DxsEntrepreneurshipProjectFundEntity.class.getName(), projectFundEntity).get(0);


            // 更新文件表
            FileEntity file_temp = this.sysServiceI.get(FileEntity.class, fm);
            file_temp.setOutId(projectFundEntity.getId());
            file_temp.setTableType("3");
            file_temp.setUpdatetime(new Date());
            file_temp.setIsDetail(0);
            sysServiceI.saveOrUpdate(file_temp);
        } catch (Exception e) {
            e.printStackTrace();
            message = "操作失败!";
        }
        ajaxJson.setMsg(message);

        return ajaxJson;
    }
}
