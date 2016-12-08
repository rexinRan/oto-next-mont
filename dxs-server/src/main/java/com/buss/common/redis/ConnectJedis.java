package com.buss.common.redis;

import com.buss.common.redis.interfaces.Constants;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Controller;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by JSADKFJ on 2016/11/23.
 */
public class ConnectJedis {

    /*private String host;
    private String password;
    private String prot;

    // 读取redis.properties的配置文件
    public void getProperties(){
        Properties prop = new Properties();
        InputStream in = this.getClass().getResourceAsStream("/conf/redis.properties");
        try {
            prop.load(in);
            host = prop.getProperty("redis.pool.host");
            password = prop.getProperty("redis.pool.port");
            prot = prop.getProperty("redis.pool.password");

            System.out.print(host+password+prot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }*/


    // redis连接池
    private static JedisPool jedisPool = null;

    /**
     * 初始化Redis连接池
     */
    static {
        try {
            JedisPoolConfig config = new JedisPoolConfig();

            config.setBlockWhenExhausted(Constants.redis_blockWhenExhausted);

            config.setEvictionPolicyClassName(Constants.redis_evictionPolicyClassName);

            config.setJmxEnabled(Constants.redis_jmxEnabled);

            config.setJmxNamePrefix(Constants.redis_jmxNamePrefix);

            config.setLifo(Constants.redis_lifo);

            config.setMaxIdle(Constants.redis_maxIdle);

            config.setMaxTotal(Constants.redis_maxTotal);

            config.setMaxWaitMillis(Constants.redis_maxWaitMillis);

            config.setMinEvictableIdleTimeMillis(Constants.redis_minEvictableIdleTimeMillis);

            config.setMinIdle(Constants.redis_minIdle);

            config.setNumTestsPerEvictionRun(Constants.redis_numTestsPerEvictionRun);

            config.setSoftMinEvictableIdleTimeMillis(Constants.redis_softMinEvictableIdleTimeMillis);

            config.setTestOnBorrow(Constants.redis_testOnBorrow);

            config.setTestWhileIdle(Constants.redis_testWhileIdle);

            config.setTimeBetweenEvictionRunsMillis(Constants.redis_timeBetweenEvictionRunsMillis);

            jedisPool = new JedisPool(config,Constants.redis_pool_host,
                    Constants.redis_pool_port,Constants.redis_timeOut ,
                    Constants.redis_auth,Constants.redis_database);

//            jedisPool = new JedisPool(config, ADDR, PORT, TIMEOUT, AUTH);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取Jedis实例
     * @return
     */
    public synchronized static Jedis getJedis() {
        try {
            if (jedisPool != null) {
                Jedis resource = jedisPool.getResource();
                return resource;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 释放jedis资源
     * @param jedis
     */
    public static void returnResource(final Jedis jedis) {
        if (jedis != null) {
            jedisPool.returnResource(jedis);
        }
    }


}
