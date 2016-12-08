package com.buss.common.controller;

import com.buss.account.service.HongXinMoneyService;
import com.buss.actives.entity.ActivesEntity;
import com.buss.activity.entity.ActiveUserEntity;
import com.buss.apply.entity.ApplyEntity;
import com.buss.auth.transfer.vo.authen.AuthUserVO;
import com.buss.common.model.json.AjaxJson;
import com.buss.common.service.SysServiceI;
import com.buss.common.service.impl.FileService;
import com.buss.file.entity.FileEntity;
import com.buss.foundproject.entity.DxsEntrepreneurshipProjectFundEntity;
import com.buss.signin.entity.DxsSignInEntity;
import com.buss.userdetail.entity.UserDetailEntity;
import org.apache.commons.beanutils.DynaBean;
import org.apache.commons.beanutils.DynaProperty;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.jweb.core.query.hibernate.qbc.CriteriaQuery;
import org.jweb.core.util.MyBeanUtils;
import org.jweb.core.web.exception.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.text.Format;
import java.util.*;


/**
 * Created by Administrator on 2016/6/20.
 * wty
 */
@Controller
@RequestMapping("/fileUpload")
public class FileUploadController {

    @Autowired
    private FileService fileService;

    @Autowired
    private SysServiceI sysServiceI;

    @Autowired
    private HongXinMoneyService hongXinMoneyService;

    /**
     * 助学金,奖学金文件上传接口
     * @param mf
     * @return
     */
    @RequestMapping("/fileUpload")
    @ResponseBody
    public AjaxJson uploadFile(@RequestParam(value = "Filedata", required = false) MultipartFile mf) {
        AjaxJson ajaxJson = new AjaxJson();
        Map map = fileService.uploadFile(mf);

        System.out.println(map);

        ajaxJson.setAttributes(map);
        return ajaxJson;
    }




    @RequestMapping("/fileUploads")
    @ResponseBody
    public AjaxJson uploadFileS(@RequestParam(value = "Filedata", required = false) MultipartFile[] mfs) {
        AjaxJson ajaxJson = new AjaxJson();
        String message = "操作成功!";

        try {
            List<Map> result = new ArrayList<>();

            for (MultipartFile mf : mfs) {
                // 上传单个文件
                Map map = fileService.upload(mf);
                System.out.println(map);

                // 保存文件信息
                FileEntity fileEntity = new FileEntity();
                fileEntity.setDownloadUrl(map.get("url").toString());
                fileEntity.setName(map.get("filename").toString());
                Date date = new Date();
                fileEntity.setCreatetime(date);
                fileEntity.setUpdatetime(date);
                fileEntity.setIsDetail(0);
                this.sysServiceI.saveOrUpdate(fileEntity);
                fileEntity = (FileEntity) this.sysServiceI.findByExample(FileEntity.class.getName(), fileEntity).get(0);
                map.put("fid", fileEntity.getId());

                result.add(map);
            }


            ajaxJson.setObj(result);
        } catch (Exception e) {
            message = "操作失败!";
        }
        ajaxJson.setMsg(message);
        return ajaxJson;
    }
}
