package com.qk.ginkgoservice.common.constant;

/**
 * @author fuxuelong
 * 常量类
 */
public class Constant {
    /**
     * 请求成功代码
     * */
    public static final int SUCCESS_CODE = 0;
    /**
     * 登录成功提示信息
     * */
    public static final String LOGIN_SUCESS_MESSAGE = "登录成功";
    /**
     * jwt缓存过期时间，单位：秒
     * */
    public static final int JWT_CACHE_LIVE_TIME=60*60;
    /**
     * RedisCacheManager中的配置的默认过期时间，单位：秒
     * */
    public static final int CACHE_LIVE_TIME=60*60;
    /**
     * 用户缓存前缀，使用redistemplate操作
     * */
    public static final String GINKGO_USER_annotation_PREFIX = "ginkgo_user";
    /**
     * 经销商缓存前缀,使用redistemplate操作
     * */
    public static final String GINKGO_JXS_annotation_PREFIX = "ginkgo_jxs";
    /**
     * 用户缓存名称，使用缓存注解操作
     * */
    public static final String GINKGO_USER_REDISTEMP_PREFIX = "ginkgo_user::";
    /**
     * 经销商缓存名称,使用缓存注解操作
     * */
    public static final String GINKGO_JXS_REDISTEMP_PREFIX = "ginkgo_jxs::";
    /**
     * jwt缓存前缀，使用redistemplate操作
     * */
    public static final String GINKGO_JWT_REDISTEMP_PREFIX = "ginkgo_jwt:";


}
