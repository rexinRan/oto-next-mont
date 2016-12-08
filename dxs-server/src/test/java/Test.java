import org.junit.Before;
import redis.clients.jedis.Jedis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by HongXinGuoJi-yzg on 2016/11/23.
 */
public class Test {

    private Jedis jedis;
    @Before
    public void setup() {

        //连接redis服务器，192.168.0.100:6379

//        jedis = new Jedis("118.178.25.3", 6379);

        //权限认证

//        jedis.auth("k5IiZyy");
//        jedis.select(1);

    }

    @org.junit.Test
    public static final void testString() {

        // 读取配置文件
        /*jedis.auth("k5IiZyy");
        jedis.select(1);
        jedis.set("name","xinxin");*/
    }
}
