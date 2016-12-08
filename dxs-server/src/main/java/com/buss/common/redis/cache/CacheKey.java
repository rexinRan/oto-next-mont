package com.buss.common.redis.cache;

import org.jweb.core.util.PropertiesUtil;

/**
 * Created by wupan on 2016/7/20.
 */
public class CacheKey {
    public static final String REDIS_SWITCH = new PropertiesUtil("sysConfig.properties").readProperty("redis.switch"); //缓存开关

    public static final int MEMCACHE_EXPIRY_TIME    = 60 * 5; //缓存失效时间为5分钟
    public static final long EXPIRE_TIME_HOUR_2     = 60 * 60 * 2; // 2小时
    public static final long EXPIRE_TIME_MIN_60     = 60 * 60; // 60分
    public static final long EXPIRE_TIME_SEC_60     = 60; // 60秒

    public static final String TEST                 = "TEST"; //测试用

    public static final String INDEX_FOOTER_COMP    = "INDEX_FOOTER_COMP"; //页底 公司信息
    public static final String INDEX_FOOTER_SITE    = "INDEX_FOOTER_SITE"; //页底 网站群

    public static final String INDEX_BANNER_1       = "INDEX_BANNER_1";
    public static final String INDEX_BANNER_2       = "INDEX_BANNER_2";
    public static final String INDEX_BANNER_3       = "INDEX_BANNER_3"; // 创业中心

    /* 首页新闻（ 特别关注） */
    public static final String INDEX_NEWS_SPECIAL   = "INDEX_NEWS_SPECIAL";
    /* 首页新闻（ 中心要闻 创业资讯到通知公告 共9个内容） */
    public static final String INDEX_NEWS_CAT_      = "INDEX_NEWS_CAT_"; //约定的前缀名，后面加新闻分类ID
    /* 首页活动 */
    public static final String INDEX_ACTIVES        = "INDEX_ACTIVES";
    public static final String INDEX_ACTIVES_PID    = "INDEX_ACTIVES_PID";

    /* 首页文章 - 就业中心 */
    public static final String INDEX_ARTICLE_EMP    = "INDEX_ARTICLE_EMP";
    /* 首页文章 - 培训中心 */
    public static final String INDEX_ARTICLE_TRAIN  = "INDEX_ARTICLE_TRAIN";
    /* 首页文章 - 活动中心 */
    public static final String INDEX_ACTIVES_6      = "INDEX_ACTIVES_6";

    /* 首页文章 独家策划 & 媒体关注 */
    public static final String INDEX_ARTICLE_CAT_   = "INDEX_ARTICLE_CAT_"; //后面加文章分类ID

    /* 首页合作院校 & 合作企业 */
    public static final String INDEX_HEZUO_SCHOOL   = "INDEX_HEZUO_SCHOOL";
    public static final String INDEX_HEZUO_COMPANY  = "INDEX_HEZUO_COMPANY";
    /* 创业项目 */
    public static final String INDEX_PROJECT        = "INDEX_PROJECT";
    /* 创业基地 */
    public static final String INDEX_JIDI           = "INDEX_JIDI";



    // ====================================================================================================

    /* 个人中心中的邮箱验证 */
    public static final String EMAILBOX_VERIFICATION = "EMAILBOX_VERIFICATION";
}
