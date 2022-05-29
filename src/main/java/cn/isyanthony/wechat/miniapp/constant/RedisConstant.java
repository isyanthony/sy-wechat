package cn.isyanthony.wechat.miniapp.constant;

import lombok.Data;

/**
 * @author: Syanthony
 * @Date: 2022/5/28
 * @Version: 1.0.0
 * @description: Redis相关常量
 */
@Data
public class RedisConstant {
    /**
     * Redis Key前缀
     */
    public static String KEY_PREFIX = "wechat:api";
    /**
     * access_token key值
     */
    public static String ACCESS_TOKEN_KEY = KEY_PREFIX + ":" + "access_token";

    /**
     * access_token hashkey值
     */
    public static String ACCESS_TOKEN_HASH_KEY = "access_token";
}
