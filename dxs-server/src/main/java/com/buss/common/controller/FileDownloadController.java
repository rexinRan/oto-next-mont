package com.buss.common.controller;

import com.buss.common.model.json.AjaxJson;
import com.buss.common.service.SysServiceI;
import com.buss.common.service.impl.FileService;
import com.buss.file.entity.FileEntity;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

/**
 * Created by Administrator on 2016/7/13.
 */
@Controller
public class FileDownloadController {

    @Autowired
    private FileService fileService;

    @Autowired
    private SysServiceI sysService;

    @RequestMapping("download")
    public AjaxJson download(HttpServletResponse res,String fid) throws IOException {

        AjaxJson ajaxJson = new AjaxJson();
        String massage = "下载成功";

        FileEntity fileEntity = this.sysService.get(FileEntity.class,fid);

        try {

            this.fileService.download(res,fileEntity.getName(),fileEntity.getDownloadUrl());

        }catch (Exception e){
             massage = "下载失败";
        }
        ajaxJson.setMsg(massage);
        return ajaxJson;
    }
}
