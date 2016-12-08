package com.buss.common.redis.interfaces;

/**
 * Created by HongXinGuoJi-yzg on 2016/11/1.
 */
public interface Constants {

    // ==============================Redis的参数======================================================


    // redis服务器IP
    public static String redis_pool_host = "118.178.25.3";

    // redis的端口号
    public static int redis_pool_port = 6379;

    //访问密码
    public static String redis_auth = "k5IiZyy";

    // 连接的库
    public static int redis_database = 1;

    public static int redis_timeOut = 10000;

    // 连接耗尽时是否阻塞, false报异常,ture阻塞直到超时, 默认true
    public static final boolean redis_blockWhenExhausted = true;

    // 设置的逐出策略类名, 默认DefaultEvictionPolicy(当连接超过最大空闲时间,或连接数超过最大空闲连接数)
    public static final String redis_evictionPolicyClassName = "org.apache.commons.pool2.impl.DefaultEvictionPolicy";

    // 是否启用pool的jmx管理功能, 默认true
    public static final boolean redis_jmxEnabled = true;

    // MBean ObjectName = new ObjectName("org.apache.commons.pool2:type=GenericObjectPool,name=" + "pool" + i); 默 认为"pool", JMX不熟,具体不知道是干啥的...默认就好.
    public static final String redis_jmxNamePrefix = "poll";

    // 是否启用后进先出, 默认true
    public static final boolean redis_lifo = true;

    // 最大空闲连接数, 默认8个
    public static final Integer redis_maxIdle = 300;

    // 获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
    public static final Integer redis_maxWaitMillis = -1;

    // 逐出连接的最小空闲时间 默认1800000毫秒(30分钟)
    public static final Integer redis_minEvictableIdleTimeMillis = 1800000;

    //最小空闲连接数, 默认0
    public static final Integer redis_minIdle = 0;

    //最大连接数, 默认8个
    public static final Integer redis_maxTotal = 600;

    // 每次逐出检查时 逐出的最大数目 如果为负数就是 : 1/abs(n), 默认3
    public static final Integer redis_numTestsPerEvictionRun = 3;

    //对象空闲多久后逐出, 当空闲时间>该值 且 空闲连接>最大空闲数 时直接逐出,不再根据MinEvictableIdleTimeMillis判断  (默认逐出策略)
    public static final Integer redis_softMinEvictableIdleTimeMillis = 1800000;

    //在获取连接的时候检查有效性, 默认false
    public static final boolean redis_testOnBorrow = true;

    //在空闲时检查有效性, 默认false
    public static final boolean redis_testWhileIdle = true;

    //逐出扫描的时间间隔(毫秒) 如果为负数,则不运行逐出线程, 默认-1
    public static final Integer redis_timeBetweenEvictionRunsMillis = 1;

}
