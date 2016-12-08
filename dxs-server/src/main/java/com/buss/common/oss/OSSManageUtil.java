package com.buss.common.oss;

/**
 * Created by wupan on 2016/7/14.
 */

import com.aliyun.openservices.oss.OSSClient;
import com.aliyun.openservices.oss.OSSException;
import com.aliyun.openservices.oss.model.*;
import org.jweb.core.util.LogUtil;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 对OSS服务器进行上传删除等的处理 
 * @ClassName: OSSManageUtil
 * @Description:
 * @author liujh
 * @date 2015-3-26 上午10:47:00  
 *
 */
public class OSSManageUtil {

    public static String ACCESS_KEY_ID      = null;
    public static String ACCESS_KEY_SECRET  = null;
    public static String ENDPOINT           = null;
    public static String AccessUrl          = null;
    public static String bucketName         = null;
    public static String bucketName_2       = null;

    public static String OUT_OF_DATE        = null;

    private OSSClient client    = null;
    private ObjectMetadata meta = null;

    static{
        try {
            OSSConfigure ossConfigure = new OSSConfigure("oss.conf");
            ACCESS_KEY_ID       =   ossConfigure.getAccessKeyId();
            ACCESS_KEY_SECRET   =   ossConfigure.getAccessKeySecret();
            ENDPOINT            =   ossConfigure.getEndpoint();
            AccessUrl           =   ossConfigure.getAccessUrl();
            bucketName          =   ossConfigure.getBucketName();
            bucketName_2        =   "bucketdev2";
            OUT_OF_DATE         =   "1";
        } catch (java.lang.Exception e) {
            e.printStackTrace();
        }
    }

    public void init(){
        // 初始化一个OSSClient
        client = new OSSClient(ENDPOINT,ACCESS_KEY_ID, ACCESS_KEY_SECRET);
        meta = new ObjectMetadata();
    }

    /**
     * 上传OSS服务器文件 
     * @Title: uploadFile
     * @Description:
     * @param @param file (File)
     * @param @param remotePath 
     * @param @return 
     * @param @throws Exception    设定文件  
     * @return String    返回类型  
     * @throws
     */
    public String uploadFile(File file, String remotePath) throws Exception{
        init();
        // 取得文件的原始名称
        String fileName = new String(file.getName().getBytes(),"UTF-8");

        String key = "";
        if(!"".equals(remotePath) && remotePath!=null){
            key = remotePath.substring(0, remotePath.length()).replaceAll("\\\\","/")+"/";
        }
        key = key + fileName;

        InputStream content = new FileInputStream(file);

        // 设置上传Object的Metadata
        meta.setContentLength(file.length());
        meta.setContentType(contentType(fileName));
        meta.setCacheControl("no-cache");
        meta.setContentEncoding("utf-8");
//        meta.setHeader("Pragma", "no-cache");
//        meta.setContentDisposition("inline;filename=" + fileName);

        // 上传Object.到OSS服务器
        PutObjectResult result = client.putObject(bucketName, key, content, meta);
        // 打印ETag
        System.out.println(result.getETag());
        String url = AccessUrl + "/" + key;
        System.out.println(url);
        return url;
    }

    /**
     * 上传OSS服务器文件
     * @param bucketName 远程OSS桶
     * @param remotePath 远程OSS桶下的路径
     * @param mfile      待上传的文件
     * @return
     * @throws Exception
     */
    public String uploadFile(String bucketName, String remotePath, MultipartFile mfile)
            throws Exception{
        init();
        String key = "";
        if(!"".equals(remotePath) && remotePath!=null){
            key = remotePath.substring(0, remotePath.length()).replaceAll("\\\\","/")+"/";
        }
        String fileName = mfile.getOriginalFilename();  //文件原名称
        long fileLength = mfile.getSize();              //文件长度
        String contentType = mfile.getContentType();    //文件类型
        InputStream content = mfile.getInputStream();   //文件输入流

        key = key + fileName;

        // 设置上传Object的Metadata
        meta.setContentLength(fileLength);
        meta.setContentType(contentType);
        meta.setCacheControl("no-cache");
        meta.setContentEncoding("utf-8");

        // 上传Object.到OSS服务器
        PutObjectResult result = client.putObject(bucketName, key, content, meta);
        // TODO 拼接文件访问地址，并返回
        String url = urlPrefix(bucketName) +"/"+key;
        return url;
    }

    /**
     * 创建OSS服务器文件夹（目录）
     *
     * @param bucketName 远程OSS桶
     * @param remotePath 远程OSS桶下的路径
     * @param fileName   待创建的文件夹名
     * @return
     * @throws Exception
     */
    public String createFile(String bucketName, String remotePath, String fileName)
            throws Exception{
        init();
        String key = "";
        if(!"".equals(remotePath) && remotePath!=null){
            key = remotePath.substring(0, remotePath.length()).replaceAll("\\\\","/")+"/";
        }
        //要创建的文件夹名称,在满足Object命名规则的情况下以"/"结尾 (key/)
        key = key + fileName + "/";

        /*这里的size为0,注意OSS本身没有文件夹的概念,这里创建的文件夹本质上是一个size为0的Object,dataStream仍然可以有数据*/
        byte[] buffer = new byte[0];
        ByteArrayInputStream in = new ByteArrayInputStream(buffer); //文件输入流

        // 设置上传Object的Metadata
        meta.setContentLength(0);
        try {
            // 上传Object.到OSS服务器
            client.putObject(bucketName, key, in, meta);
        } finally {
            in.close();
        }
        // TODO 拼接文件访问地址，并返回
        String url = urlPrefix(bucketName) +"/"+key;
        return url;
    }

    /**
     * 获取文件访问URL前缀
     * @param bucketName
     * @return
     */
    public static String urlPrefix(String bucketName){
        int ii = ENDPOINT.indexOf("//");
        String prefix = "http://"+bucketName+"."+ENDPOINT.substring(ii+2,ENDPOINT.length());
        // 默认为通用地址，以下为自定义域名地址
        if("bucketdev1".equals(bucketName)){
            prefix = AccessUrl;
        }
        return prefix;
    }

    /**
     * @Description: 根据key获取oss服务器上的图片地址
     * @param key
     * @return
     * @ReturnType:String
     */
    public String getImgURl(String key){
        init();
        Date expires = new Date (new Date().getTime() + Integer.parseInt(OUT_OF_DATE)); // 30 minute to expire
        GeneratePresignedUrlRequest generatePresignedUrlRequest ;
        if(key.startsWith("msplatform")){
            generatePresignedUrlRequest =new GeneratePresignedUrlRequest(bucketName, key);
        }else {
            generatePresignedUrlRequest =new GeneratePresignedUrlRequest(bucketName_2, key);
        }
        generatePresignedUrlRequest.setExpiration(expires);
        URL url = client.generatePresignedUrl(generatePresignedUrlRequest);
        return url.toString();
    }
    /**
     * @Description:根据key获取oss服务器上的ipa文件地址
     * @param key
     * @return
     * @ReturnType:String
     */
    public String getIpaURl(String key){
        init();
        Date expires = new Date(new Date().getTime()+ 10*365*24*3600*1000);
        GeneratePresignedUrlRequest generatePresignedUrlRequest ;
        if(key.startsWith("msplatform")){
            generatePresignedUrlRequest =new GeneratePresignedUrlRequest(bucketName, key);
        }else {
            generatePresignedUrlRequest =new GeneratePresignedUrlRequest(bucketName_2, key);
        }
        generatePresignedUrlRequest.setExpiration(expires);
        URL url = client.generatePresignedUrl(generatePresignedUrlRequest);
        return url.toString();
    }

    /**
     * @Description: 根据key获取oss服务器上的图片地址
     * @param key
     * @return
     * @ReturnType:String
     */
    public InputStream  getObject(String key){
        init();
        OSSObject object = null;
        if(key.startsWith("msplatform")){
            object= client.getObject(bucketName, key);
        }else{
            object= client.getObject(bucketName_2, key);
        }
        object.getObjectMetadata().getContentType();
        // 获取Object的输入流
        InputStream objectContent = object.getObjectContent();


        return objectContent;
    }


    /**
     * @Description:删除文件
     * @param key  OSS文件服务器上文件的唯一标识
     * @ReturnType:void
     */
    public void deleteFile(String bucketName, String key){
        init();
        client.deleteObject(bucketName, key);
//        System.out.println("delete file["+key+"] success");
    }

    /**
     * 根据文件名查看文件内容
     */
    public void getFileContent(String firstKey){
        init();
        try {
            OSSObject ossObject = client.getObject(bucketName, firstKey);
            InputStream inputStream = ossObject.getObjectContent();
            StringBuilder objectContent = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String line = reader.readLine();
                if (line == null)
                    break;
                objectContent.append(line);
            }
            inputStream.close();
            System.out.println("Object：" + firstKey + "的内容是：" + objectContent);
        } catch (OSSException oe) {
            oe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     *  列出Bucket中的Object
     */
    public List<OSSObjectSummary> getFileList(String bucketName){
        init();
        List<OSSObjectSummary> objectSummary = null;
        try {
            ObjectListing objectListing = client.listObjects(bucketName);
            objectSummary = objectListing.getObjectSummaries();
//            System.out.println("您有以下Object：");
//            for (OSSObjectSummary object : objectSummary) {
//                System.out.println("\t" + object.getKey());
//            }
        } catch (OSSException oe) {
            oe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objectSummary;
    }

    /**
     *  列出目录下的文件和子目录
     */
    public ObjectListing getFileListDelimiter(String bucketName, String prefix){
        init();
        // 构造ListObjectsRequest请求
        ListObjectsRequest listObjectsRequest = new ListObjectsRequest(bucketName);

        // "/" 为文件夹的分隔符
        listObjectsRequest.setDelimiter("/");

        // 列出prefix目录下的所有文件和文件夹
        if(!"".equals(prefix) && prefix!=null) {
//          listObjectsRequest.setPrefix(prefix+"/");
            listObjectsRequest.setPrefix(prefix);
        }

        ObjectListing listing = client.listObjects(listObjectsRequest);
/*
        // 遍历所有Object
        System.out.println("Objects:");
        for (OSSObjectSummary objectSummary : listing.getObjectSummaries()) {
            System.out.println(objectSummary.getKey());
        }

        // 遍历所有CommonPrefix
        System.out.println("\nCommonPrefixs:");
        for (String commonPrefix : listing.getCommonPrefixes()) {
            System.out.println(commonPrefix);
        }
*/
        return listing;
    }



    /**
     * Description: 判断OSS服务文件上传时文件的contentType 
     * @Version1.0
     * @param FilenameExtension 文件后缀 
     * @return String
     */
    public static String contentType(String FilenameExtension){
        if(!FilenameExtension.contains(".")){
            return "application/octet-stream";
        }
        FilenameExtension = FilenameExtension.substring(FilenameExtension.lastIndexOf(".")+1);

        if(FilenameExtension.equals("BMP")||FilenameExtension.equals("bmp")){return "image/bmp";}
        if(FilenameExtension.equals("GIF")||FilenameExtension.equals("gif")){return "image/gif";}
        if(FilenameExtension.equals("JPEG")||FilenameExtension.equals("jpeg")||
                FilenameExtension.equals("JPG")||FilenameExtension.equals("jpg")||
                FilenameExtension.equals("PNG")||FilenameExtension.equals("png")){return "image/jpeg";}
        if(FilenameExtension.equals("HTML")||FilenameExtension.equals("html")){return "text/html";}
        if(FilenameExtension.equals("TXT")||FilenameExtension.equals("txt")){return "text/plain";}
        if(FilenameExtension.equals("VSD")||FilenameExtension.equals("vsd")){return "application/vnd.visio";}
        if(FilenameExtension.equals("PPTX")||FilenameExtension.equals("pptx")||
                FilenameExtension.equals("PPT")||FilenameExtension.equals("ppt")){return "application/vnd.ms-powerpoint";}
        if(FilenameExtension.equals("DOCX")||FilenameExtension.equals("docx")||
                FilenameExtension.equals("DOC")||FilenameExtension.equals("doc")){return "application/msword";}
        if(FilenameExtension.equals("XML")||FilenameExtension.equals("xml")){return "text/xml";}

        if(FilenameExtension.equals("MP4")||FilenameExtension.equals("mp4")){return "text/octet-stream";}
        return "text/html";
    }


    /**
     * @Description: 断点上传文件到OSS文件服务器

     */
    public String appendObjectFile(File file, String remotePath) throws Exception{
        //进行初始化
        init();
        // 取得文件的原始名称
        String fileName = new String(file.getName().getBytes(),"UTF-8");
        String key = "";
        if(!"".equals(remotePath) && remotePath!=null){
            key = remotePath.substring(0, remotePath.length()).replaceAll("\\\\","/")+"/";
        }
        key = key + fileName;

        // 必须设置ContentLength
        meta.setContentLength(file.length());
        meta.setContentType(contentType(fileName));
        meta.setCacheControl("no-cache");
        meta.setContentEncoding("utf-8");
        // 上传
        LogUtil.info("*****************断点上传图片到oss服务器开始*****************" + key);
//        AppendObjectRequest appendObjectRequest = new AppendObjectRequest(BUCKETNAME, key, content, meta);
//        appendObjectRequest.setPosition(Long.valueOf(position));
//        AppendObjectResult appendObjectResult =client.appendObject(appendObjectRequest);
        // 开始Multipart Upload
        InitiateMultipartUploadRequest initiateMultipartUploadRequest =
                new InitiateMultipartUploadRequest(bucketName, key);
        InitiateMultipartUploadResult initiateMultipartUploadResult =
                client.initiateMultipartUpload(initiateMultipartUploadRequest);
// 打印UploadId
        System.out.println("UploadId: " + initiateMultipartUploadResult.getUploadId());

        List<PartETag> partETags = getPartETag(file, key, initiateMultipartUploadResult);
        CompleteMultipartUploadRequest completeMultipartUploadRequest =
                new CompleteMultipartUploadRequest(bucketName, key, initiateMultipartUploadResult.getUploadId(), partETags);

// 完成分块上传
        CompleteMultipartUploadResult completeMultipartUploadResult =
                client.completeMultipartUpload(completeMultipartUploadRequest);

// 打印Object的ETag
        System.out.println(completeMultipartUploadResult.getETag());
        LogUtil.info("*****************断点上传图片到oss服务器结束*****************" + key);
//        return appendObjectResult.getNextPosition().toString();
        return completeMultipartUploadResult.getETag();
    }

    /**
     *
     * @return
     */
    public List<PartETag> getPartETag(File partFile, String key,
                                      InitiateMultipartUploadResult initiateMultipartUploadResult){
        // 设置每块为 5M
        final int partSize = 1024 * 1024 * 10;

//        File partFile = new File("/path/to/file.zip");

        // 计算分块数目
        int partCount = (int) (partFile.length() / partSize);
        if (partFile.length() % partSize != 0){
            partCount++;
        }

        // 新建一个List保存每个分块上传后的ETag和PartNumber
        List<PartETag> partETags = new ArrayList<PartETag>();

        for(int i = 0; i < partCount; i++){
            // 获取文件流
            FileInputStream fis = null;
            try {
                fis = new FileInputStream(partFile);

                // 跳到每个分块的开头
                long skipBytes = partSize * i;
                fis.skip(skipBytes);

                // 计算每个分块的大小
                long size = partSize < partFile.length() - skipBytes ?
                        partSize : partFile.length() - skipBytes;

                // 创建UploadPartRequest，上传分块
                UploadPartRequest uploadPartRequest = new UploadPartRequest();
                uploadPartRequest.setBucketName(bucketName);
                uploadPartRequest.setKey(key);
                uploadPartRequest.setUploadId(initiateMultipartUploadResult.getUploadId());
                uploadPartRequest.setInputStream(fis);
                uploadPartRequest.setPartSize(size);
                uploadPartRequest.setPartNumber(i + 1);
                UploadPartResult uploadPartResult = client.uploadPart(uploadPartRequest);

                // 将返回的PartETag保存到List中。
                partETags.add(uploadPartResult.getPartETag());

                // 关闭文件
                fis.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return partETags;
    }

    /**
     * 远程下载文件到本地
     * @param downPath 本地存放路径
     * @param fileUrl  文件网络地址 如http://www.baidu.com/1.txt
     */
    public void downUrl(String downPath, String fileUrl, String uname){
        File savePath = new File(downPath);
        // 如果路径不存在,递归创建文件夹
        if (!savePath.exists()) {
            savePath.mkdir();
        }
        //获取文件名
//        String[] urlname = fileUrl.split("/");
//        int len = urlname.length-1;
//        String uname = urlname[len];
        try {
            //创建新文件
            File file = new File(savePath+"/"+uname);
            if(file!=null && !file.exists()){
                file.createNewFile();
            }
            OutputStream oputstream = new FileOutputStream(file);
            URL url = new URL(fileUrl);
            HttpURLConnection uc = (HttpURLConnection) url.openConnection();
            uc.setDoInput(true);//设置是否要从 URL 连接读取数据,默认为true
            uc.connect();
            InputStream iputstream = uc.getInputStream();
            //打印文件长度
//            System.out.println("file size is:"+uc.getContentLength());
            byte[] buffer = new byte[4*1024];
            int byteRead = -1;
            while((byteRead=(iputstream.read(buffer)))!= -1){
                oputstream.write(buffer, 0, byteRead);
            }
            oputstream.flush();
            iputstream.close();
            oputstream.close();
        } catch (Exception e) {
            System.out.println("读取失败！");
            e.printStackTrace();
        }
    }

    /**
     * 文件大小转换成可显示的Mb,Gb和kb方法
     * @param size
     * @return
     */
    public static String convertFileSize(long size) {
        long kb = 1024;
        long mb = kb * 1024;
        long gb = mb * 1024;

        if (size >= gb) {
            return String.format("%.2fGB", (float) size / gb);
        } else if (size >= mb) {
            float f = (float) size / mb;
            return String.format(f > 100 ? "%.0fMB" : "%.2f MB", f);
        } else if (size >= kb) {
            float f = (float) size / kb;
            return String.format(f > 100 ? "%.0fKB" : "%.2f KB", f);
        } else
            return String.format("%dB", size);
    }


    public static void main(String[] args) {
        try {
            OSSManageUtil oss = new OSSManageUtil();

            // 删除文件
//            deleteFile(ossConfigure, "doc/_netrc");

            // 获取指定文件的输入流
//            String filePath = "C:\\Users\\Administrator\\Desktop\\tmp\\jedis_list.jsp";
//            String filePath = "C:\\Users\\Administrator\\Desktop\\tmp\\video.mp4";
//            File file = new File(filePath);
//            oss.uploadFile(file, "video");

//            oss.appendObjectFile(file, "video");

//            oss.getFileList();

//            System.out.print(convertFileSize(0));

//            oss.getFileListDelimiter("");
            System.out.println("####################################");
//            oss.getFileListDelimiter("js/");

//            oss.getFileList("bucketdev2");

            System.out.println(oss.createFile(bucketName,"","video"));

        } catch (OSSException oe) {
            oe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}  