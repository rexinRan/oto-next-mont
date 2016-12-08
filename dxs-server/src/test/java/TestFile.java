import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/8/19.
 */
public class TestFile {

    public static void main(String[] args) {
        TestFile t =new TestFile();
        try {
//            t.InputStream();
            t.getFilePath("http://bucketdev1.oss-cn-beijing.aliyuncs.com/test/1-echo.png","1-echo.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getFilePath(String fileUrl,String fileName) throws Exception {
        String downPath = "E:/upload/";  //本地版
//      String downPath = "/home/tempFlowTxt/";  //服务器版
        downUrl(downPath, fileUrl);
        System.out.println("生成文件路径："+downPath+fileName);
        return downPath+fileName;
    }

    public InputStream InputStream() throws Exception {

        String fileUrl = "http://bucketdev2.oss-cn-beijing.aliyuncs.com/test/%E5%B0%B1%E4%B8%9A%E4%B8%AD%E5%BF%83--%E7%BA%BF%E4%B8%8A%E6%8B%9B%E8%81%98%E9%A6%96%E9%A1%B5%2B%E8%AF%A6%E6%83%85%E9%A1%B5.pdf";
        String fileName = "1-echo.png";

        String date = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String downPath = "E:/upload/" + date +"/";  //本地版
//      String downPath = "/home/tempFlowTxt/";  //服务器版
        downUrl(downPath, fileUrl);
        System.out.println("生成文件路径："+downPath+fileName);
        return new FileInputStream(downPath+fileName);
    }

    /**
     * 远程下载文件到本地
     * @param downPath 本地存放路径
     * @param fileUrl  文件网络地址 如http://www.baidu.com/1.txt
     */
    public void downUrl(String downPath, String fileUrl){
        File savePath = new File(downPath);
        if (!savePath.exists()) {
            savePath.mkdir();
        }
        String[] urlname = fileUrl.split("/");
        int len = urlname.length-1;
        String uname = urlname[len];//获取文件名
        try {
            File file = new File(savePath+"/"+uname);//创建新文件
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
}

