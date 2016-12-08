package com.buss.common.controller;

import com.buss.file.entity.FileEntity;
import com.buss.utils.FileService;
import org.jeecgframework.core.common.model.json.AjaxJson;
import org.jeecgframework.web.system.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Past;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/6/13.
 */
@Scope("prototype")
@Controller
@RequestMapping("/files")
public class UploadFile {

    @Autowired
    private FileService fileService;

    @Autowired
    private SystemService systemService;

//    @Autowired
//    private SystemService sysServiceI;

    @RequestMapping("upload")
    public void upload(HttpServletRequest request,
                       PrintWriter out) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        Map<String, MultipartFile> fileMap = multipartRequest.getFileMap();
        MultipartFile multipartFile =null;
        String fileName = null;
        for(Map.Entry<String,MultipartFile > set:fileMap.entrySet()){
            String filekey = set.getKey();      //Filedata
            multipartFile = set.getValue();     //文件名
        }
        fileName = this.storeIOc(multipartRequest, multipartFile);

        out.print(fileName);
    }

    // 接受图片，返回图片地址
    private String storeIOc(HttpServletRequest request, MultipartFile file) {
        String realPath = request.getSession().getServletContext()
                .getRealPath("upload");
        String message = "上传失败";
        if (file == null) {
            return message;
        }
//        String fileName = "";
//        String logImageName = "";
        if (file.isEmpty()) {
            System.out.println("文件未上传");
        } else {
//            String _fileName = file.getOriginalFilename();
//            String suffix = _fileName.substring(_fileName.lastIndexOf("."));
//          /**使用UUID生成文件名称*/
//            logImageName = UUID.randomUUID().toString() + suffix;


//            fileName = realPath + File.separator + logImageName;
//            File restore = new File(fileName);

            Map map = this.fileService.upload(file);
            System.out.println(map);

            // 保存文件信息
            FileEntity fileEntity = new FileEntity();
            try {

                fileEntity.setDownloadUrl(map.get("url").toString());
                fileEntity.setName(map.get("filename").toString());
                Date date = new Date();
                fileEntity.setCreatetime(date);
                fileEntity.setUpdatetime(date);
                fileEntity.setIsDetail(0);
                this.systemService.saveOrUpdate(fileEntity);

                message = (String) map.get("url");
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        // 返回默认的图片地址
        return message;
    }

    @RequestMapping("uploadvideo")
    @ResponseBody
    public List upload2(@RequestParam(value = "upfile", required = false)MultipartFile[] file,HttpServletRequest request,  PrintWriter out) {
        System.out.print("sdfds");
        List list = new ArrayList();
        for (MultipartFile mf : file) {
            Map map = this.fileService.upload(mf);
//            result = "{\"name\":\""+ map.get("filename") +"\", \"originalName\": \""+ map.get("filename") +"\", \"size\": "+ map.get("") +", \"state\": \""+ map.get("state") +"\", \"type\": \""+ map.get("fileType") +"\", \"url\": \""+ map.get("uri") +"\"}";
            list.add(map.get("url"));
        }
        return list;
    }

    @RequestMapping("/fileUploads")
    @ResponseBody
    public AjaxJson uploadFileS(@RequestParam(value = "Filedata", required = false) MultipartFile[] mfs) {
        AjaxJson ajaxJson = new AjaxJson();
        String message = "操作成功!";

        try {
            List<Map> result = new ArrayList();

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
                this.systemService.saveOrUpdate(fileEntity);
                fileEntity = (FileEntity) this.systemService.findByExample(FileEntity.class.getName(), fileEntity).get(0);
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


//    // 接受图片，返回图片地址
//    private String storeIOc(HttpServletRequest request, MultipartFile file) {
//        String realPath = request.getSession().getServletContext()
//                .getRealPath("upload");
//        if (file == null) {
//            return "upload" + File.separator + "headpic.jpg";
//        }
//        String fileName = "";
//        String logImageName = "";
//        if (file.isEmpty()) {
//            System.out.println("文件未上传");
//        } else {
//            String _fileName = file.getOriginalFilename();
//            String suffix = _fileName.substring(_fileName.lastIndexOf("."));
////          /**使用UUID生成文件名称*/
//            logImageName = UUID.randomUUID().toString() + suffix;
//
//
//            fileName = realPath + File.separator + logImageName;
//            File restore = new File(fileName);
//            try {
//                file.transferTo(restore);
//            } catch (Exception e) {
//                throw new RuntimeException(e);
//            }
//        }
//        // 返回默认的图片地址
//        return "upload/" + logImageName;
//    }

//    @RequestMapping("upload1")
//    public void testRemote(@RequestParam(value = "upfile", required = false)MultipartFile[] file, HttpServletRequest request, HttpServletResponse response) throws Exception {
//        request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");
////        Uploader up = new Uploader(request);
////        up.setSavePath("upload");
////        String[] fileType = {".gif" , ".png" , ".jpg" , ".jpeg" , ".bmp"};
////        up.setAllowFiles(fileType);
////        up.setMaxSize(10000); //单位KB
////        up.upload();
//        String result = "";
//        for (MultipartFile mf : file) {
//            Map map = this.fileService.upload(mf);
//            result = "{\"name\":\""+ map.get("filename") +"\", \"originalName\": \""+ map.get("filename") +"\", \"size\": "+ map.get("") +", \"state\": \""+ map.get("state") +"\", \"type\": \""+ map.get("fileType") +"\", \"url\": \""+ map.get("uri") +"\"}";
//
//        }

//        String callback = request.getParameter("callback");
//
////        String result = "{\"name\":\""+ up.getFileName() +"\", \"originalName\": \""+ up.getOriginalName() +"\", \"size\": "+ up.getSize() +", \"state\": \""+ up.getState() +"\", \"type\": \""+ up.getType() +"\", \"url\": \""+ up.getUrl() +"\"}";
//
////        result = result.replaceAll( "\\\\", "\\\\" );
//
//        if( callback == null ){
//            response.getWriter().print( result );
//        } else {
//            response.getWriter().print("<script>"+ callback +"(" + result + ")</script>");
//        }
//    }
//}
