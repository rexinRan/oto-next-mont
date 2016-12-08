package com.buss.common.controller;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;


import com.buss.file.entity.DxsFileEntity;
import com.buss.file.service.DxsFileServiceI;
import org.apache.commons.chain.Context;
import org.apache.commons.io.FileUtils;
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2016/6/29.
 */
@Controller
@RequestMapping("/drownLoad")
public class FileDownLoadController {

    @Value("#{settings['WIN_REAL_PATH']}")
    private String FilePath = "";

    @Value("#{settings['LINUX_REAL_PATH']}")
    private String LinuxFilePath = "";

    @Autowired
    private DxsFileServiceI fileService;

    @RequestMapping(params = "download")
    public void test (String outid, HttpServletResponse response) throws IOException {
        List<DxsFileEntity> files = null;
        List<File> resultfiles = new ArrayList();
        try {
            // 1.查询所有out_id的文件
            files = fileService.findByProperty(DxsFileEntity.class, "outId", outid);

            for (DxsFileEntity df : files) {
                // 判断当前操作系统的类型
                String osName = System.getProperty("os.name");
                // SystemProperty.getSystemContent();

                File destFile = null;
                // 如果当前是windows系统
                if (osName.toLowerCase().contains("windows")) {
                    destFile = new File(FilePath + df.getName() );
                } else {
                    destFile = new File(LinuxFilePath + df.getName());
                }
//                File file = new File(FilePath + df.getName());
                URL url = new URL(df.getDownloadUrl());
//                FileUtils.copyURLToFile(url, file);         // 出现异常
                FileUtils.copyURLToFile(url, destFile);         // 出现异常
//                resultfiles.add(file);
                resultfiles.add(destFile);
            }

            this.batchDownloadFiles(outid+".zip", resultfiles, response);
        } catch (Exception e) {
            e.printStackTrace();
            // 删除临时项目
            for (File f: resultfiles ) {
                del(f);
            }
        }
    }

    @RequestMapping(params = "downloadurl")
    public void test3 (String url,HttpServletResponse response) throws IOException {
        DxsFileEntity dxsFileEntity=new DxsFileEntity();
        List<DxsFileEntity> dxsFileEntityList=fileService.findByProperty(DxsFileEntity.class,"downloadUrl",url);
        if(dxsFileEntityList.size()!=0){
            dxsFileEntity=dxsFileEntityList.get(0);
            this.test2(dxsFileEntity.getId(),response);
        }
    }
    @RequestMapping(params = "downloadfid")
    public void test2 (String fid, HttpServletResponse response) throws IOException {
        DxsFileEntity df = null;
        List<File> resultfiles = new ArrayList();
        try {
            String[] sourceStrArray = fid.split(",");
            for (int i = 0; i < sourceStrArray.length; i++) {
                df = fileService.getEntity(DxsFileEntity.class,sourceStrArray[i]);

                // 判断当前操作系统的类型
                String osName = System.getProperty("os.name");
                // SystemProperty.getSystemContent();
                System.out.println(osName);
                File destFile = null;
                // 如果当前是windows系统
                if (osName.toLowerCase().contains("windows")) {
                    destFile = new File(FilePath + df.getName() );
                } else {
                    destFile = new File(LinuxFilePath + df.getName());
                }
//                File file = new File(FilePath + df.getName());
                URL url = new URL(df.getDownloadUrl());
//                FileUtils.copyURLToFile(url, file);         // 出现异常
                FileUtils.copyURLToFile(url, destFile);         // 出现异常
//                resultfiles.add(file);
                resultfiles.add(destFile);
            }

            this.batchDownloadFiles("下载文件.zip", resultfiles, response);
        } catch (Exception e) {
            e.printStackTrace();
            // 删除临时项目
            for (File f: resultfiles ) {
                del(f);
            }
        }
    }

    public String  batchDownloadFiles (String tmpFileName, List<File> file1, HttpServletResponse response) {
        //生成的ZIP文件名为Demo.zip
//        String tmpFileName = "Demo.zip";
        byte[] buffer = new byte[1024];

        String strZipPath = FilePath + tmpFileName;
        // 判断当前操作系统的类型
        String osName = System.getProperty("os.name");
        // SystemProperty.getSystemContent();

        File destFile = null;
        // 如果当前是windows系统
        if (osName.toLowerCase().contains("windows")) {
            strZipPath = FilePath + tmpFileName;
        } else {
            strZipPath = LinuxFilePath + tmpFileName;
        }
        try {
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(
                    strZipPath));
            // 需要同时下载的两个文件result.txt ，source.txt
//            File[] file1 = { new File(FilePath+"test1.txt"),
//                    new File(FilePath+"测试2.docx") };
            for (int i = 0; i < file1.size(); i++) {
                FileInputStream fis = new FileInputStream(file1.get(i));// FileInputStream fis = new FileInputStream(file1[i]);
                out.putNextEntry(new ZipEntry(file1.get(i).getName()));//out.putNextEntry(new ZipEntry(file1[i].getName()));
                //设置压缩文件内的字符编码，不然会变成乱码
                out.setEncoding("GBK");
                int len;
                // 读入需要下载的文件的内容，打包到zip文件
                while ((len = fis.read(buffer)) > 0) {
                    out.write(buffer, 0, len);
                }
                out.closeEntry();
                fis.close();
            }
            out.close();
            this.downFile(response, tmpFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    /**
     * 文件下载
     * @param response
     * @param str
     */
    private void downFile(HttpServletResponse response, String str) {
        File file = null;
        try {
            String path = FilePath + str;
            // 判断当前操作系统的类型
            String osName = System.getProperty("os.name");
            // SystemProperty.getSystemContent();

            File destFile = null;
            // 如果当前是windows系统
            if (osName.toLowerCase().contains("windows")) {
                path = FilePath + str;
            } else {
                path = LinuxFilePath + str;
            }
            file = new File(path);
            if (file.exists()) {
                InputStream ins = new FileInputStream(path);
                BufferedInputStream bins = new BufferedInputStream(ins);// 放到缓冲流里面
                OutputStream outs = response.getOutputStream();// 获取文件输出IO流
                BufferedOutputStream bouts = new BufferedOutputStream(outs);
                response.setContentType("application/x-download");// 设置response内容的类型
                response.setHeader(
                        "Content-disposition",
                        "attachment;filename="
                                + URLEncoder.encode(str, "UTF-8"));// 设置头部信息
                int bytesRead = 0;
                byte[] buffer = new byte[8192];
                // 开始向网络传输文件流
                while ((bytesRead = bins.read(buffer, 0, 8192)) != -1) {
                    bouts.write(buffer, 0, bytesRead);
                }
                bouts.flush();// 这里一定要调用flush()方法
                ins.close();
                bins.close();
                outs.close();
                bouts.close();
            } else {
                response.sendRedirect("../error.jsp");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 删除文件
             del(file);
        }
    }

    private void del(File file) {
        if (file!=null && file.exists()) {
            file.delete();
        }
    }

}
