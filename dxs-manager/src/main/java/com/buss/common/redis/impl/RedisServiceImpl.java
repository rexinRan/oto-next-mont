package com.buss.common.redis.impl;

/**
 * Created by Administrator on 2016/7/23.
 */

import com.buss.common.redis.RedisClient;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.stereotype.Service;

/**
 * 封装redis 缓存服务器服务接口
 *
 * @author hk
 *
 *         2012-12-16 上午3:09:18
 */
@Service(value = "redisService")
public class RedisServiceImpl extends RedisClient {

    private RedisServiceImpl() {

    }
//    private RedisTemplate<K, V> redisTemplate;

    private static String redisCode = "utf-8";

    /**
     * 添加key value 并且设置存活时间(byte)
     *
     * @param key
     * @param value
     * @param liveTime
     */
    public void set(final byte[] key, final byte[] value, final long liveTime) {
        redisTemplate.execute(new RedisCallback() {
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                connection.set(key, value);
                if (liveTime > 0) {
                    connection.expire(key, liveTime);
                }
                return 1L;
            }
        });
    }

    /**
     * 添加key value 并且设置存活时间
     *
     * @param key
     * @param value
     * @param liveTime
     *            单位秒
     */
    public void set(String key, String value, long liveTime) {
        this.set(key.getBytes(), value.getBytes(), liveTime);
    }

    /**
     * 添加key value
     *
     * @param key
     * @param value
     */
    public void set(String key, String value) {
        this.set(key, value, 0L);
    }

    /**
     * 添加key value (字节)(序列化)
     *
     * @param key
     * @param value
     */
    public void set(byte[] key, byte[] value) {
        this.set(key, value, 0L);
    }

    /**
     * 通过正则匹配keys
     *
     * @param pattern
     * @return
     */
    public Object Setkeys(String pattern) {
        return redisTemplate.keys(pattern);
    }

    /**
     * boolean
     */
    public Object exists(final String key) {
        return redisTemplate.execute(new RedisCallback() {
            public Boolean doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.exists(key.getBytes());
            }
        });
    }

    /**
     * 清空redis 所有数据
     * (String)
     * @return
     */
    public Object flushDB() {
        return redisTemplate.execute(new RedisCallback() {
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                connection.flushDb();
                return "ok";
            }
        });
    }

    /**
     * 查看redis里有多少数据
     * (long)
     * @return
     */
    public Object dbSize() {
        return redisTemplate.execute(new RedisCallback() {
            public Long doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.dbSize();
            }
        });
    }

    /**
     * 检查是否连接成功
     * (String)
     * @return
     */
    public Object ping() {
        return redisTemplate.execute(new RedisCallback() {
            public String doInRedis(RedisConnection connection) throws DataAccessException {
                return connection.ping();
            }
        });
    }

}