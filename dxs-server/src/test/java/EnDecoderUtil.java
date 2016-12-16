import strman.Strman;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class EnDecoderUtil {
    public static void main(String []args) {
        try {
            String path = "/Test/你好/-+去.txt";


            String str = URLEncoder.encode(path, "UTF-8");
            System.out.println(str.replace("%2F" ,"/"));
//            str = URLDecoder.decode(str, "UTF-8");
//            System.out.println(str);

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}  