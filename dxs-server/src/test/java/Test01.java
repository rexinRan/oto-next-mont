import strman.Strman;

/**
 * Created by Administrator on 2016/8/17.
 */
public class Test01 {

    public static void main(String[] args) {
//        String s = "http://oss-cn-beijing.aliyuncs.com";
//        int i = s.indexOf("//");
//        System.out.println(s.substring(i+2,s.length()));

//        String path = "/Untitled/folder";
//        long ii = Strman.countSubstr(path, "/");
//        String key = Strman.last(path, path.length()-1);
//        System.out.println(ii);
//        if(ii>1){
//            key = Strman.first(key, key.length()-1);
//        }

        String fileUrl = "http://bucketdev1.oss-cn-beijing.aliyuncs.com/test/test123/1-echo.png";
        String fileName = "";
        if(fileUrl != null && !"".equals(fileUrl)) {
            fileName = Strman.last(fileUrl, fileUrl.length()-1);
            if(Strman.contains(fileName, "/")){
                int index = Strman.lastIndexOf(fileName, "/", false) + 1;
                fileName = Strman.last(fileName, fileName.length()-index);
            }
        }
        System.out.println(fileName);
    }
}
