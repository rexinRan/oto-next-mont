package test;

import com.buss.common.redis.RedisClient;
import com.buss.common.redis.cache.CacheKey;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;
import java.util.TreeSet;

/**
 * Created by Administrator on 2016/7/22.
 */
public class TestRedis extends TestCase {

    private AbstractApplicationContext ctx;
    private RedisClient redis;

    @Before
    public void setUp() throws Exception {
        ctx = new ClassPathXmlApplicationContext(new String[] {"spring-redis.xml"});
        redis = (RedisClient) ctx.getBean("redisClient");
        System.out.println("######### start #########");
    }
    @After
    public void tearDown() throws Exception {
        ctx = null;
    }

    @Test
    public void testRedis() {
        Object value = "{\"success\":true,\"statusCode\":\"200\",\"data\":{\"pageCount\":5,\"pageNo\":1,\"pageSize\":2,\"total\":8,\"result\":[{\"userCount\":0,\"active\":{\"id\":\"8a2c9a985600edf201560109d38a000f\",\"activeCatelogId\":\"12\",\"activeCatelogName\":\"爱好同行\",\"pid\":\"2\",\"activeCatelogImg\":null,\"activeCatelogDescribe\":null,\"activeCatelogSort\":null,\"activeTitle\":\"情系中原、大爱无疆--全国大学生创业就业中心全国公益活动走进河南省\",\"displayMenu\":\"\",\"activeImage\":\"http://hongxinguoji.com/group1/M00/00/1C/Zckdh1eNk1GAYO3eAAFJDTaOa8g452.jpg\",\"activeAddress\":\"郑州市惠济区大河路敬老院\",\"hostUnit\":\"全国大学生创业就业中心\",\"limitedNumber\":\"65\",\"histaryDate\":\"\",\"deadlineDate\":\"2016-04-20 00:00:00\",\"activeStateTime\":\"2016-05-20 00:00:00\",\"activeEndTime\":\"2016-07-22 00:00:00\",\"activeUsertypeId\":\"\",\"activeContent\":null,\"activePrice\":\"\",\"isCharge\":null,\"maxAccountCount\":\"\",\"publishTime\":\"2016-07-19 00:00:00\",\"activeEditor\":\"瑞雪\"},\"activeStatu\":\"进行中\",\"catelogName\":\"爱好同行\"},{\"userCount\":0,\"active\":{\"id\":\"8a2c9a985600edf2015600fafd580007\",\"activeCatelogId\":\"13\",\"activeCatelogName\":\"书画巡展\",\"pid\":\"2\",\"activeCatelogImg\":null,\"activeCatelogDescribe\":null,\"activeCatelogSort\":null,\"activeTitle\":\"全国大学生爱心接力笔会甘肃站\",\"displayMenu\":\"\",\"activeImage\":\"http://hongxinguoji.com/group1/M00/00/1C/Zckdh1eNkMeAV37MAAB8qddafuY904.jpg\",\"activeAddress\":\"兰州文理学院的翠文厅\",\"hostUnit\":\"全国大学生创业就业中心\",\"limitedNumber\":\"75\",\"histaryDate\":\"\",\"deadlineDate\":\"2016-07-01 00:00:00\",\"activeStateTime\":\"2016-06-21 00:00:00\",\"activeEndTime\":\"2016-08-18 00:00:00\",\"activeUsertypeId\":\"\",\"activeContent\":null,\"activePrice\":\"\",\"isCharge\":null,\"maxAccountCount\":\"\",\"publishTime\":\"2016-07-19 00:00:00\",\"activeEditor\":\"瑞雪\"},\"activeStatu\":\"进行中\",\"catelogName\":\"书画巡展\"}]},\"attribute\":null}";
        String key = "test";
        redis.put(key, value);
        Object ttt = redis.get(key);
        System.out.println(ttt);
    }

    @Test
    public void testRedisRemove() {
//        String key = CacheKey.INDEX_ACTIVES_6;
        String key = "test";
        Object ttt = redis.get(key);
        System.out.println(ttt);
        redis.remove(key);
        ttt = redis.get(key);
        System.out.println(ttt);
        System.out.println("########## end ##########");
    }

/*
    @Test
    public void keyall() {
        TreeSet<String> keys = redisOperator.keys(prefix);
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("prefix", prefix);
        data.put("count", keys.size());
        String type = "unknown";
        if(keys.size()>0){
            type = redisOperator.type(keys.first());
        }
        data.put("type", type);
    }
*/

/*
    @Test
    public void flushDB() {
        redis.flushDB();
    }*/

}
