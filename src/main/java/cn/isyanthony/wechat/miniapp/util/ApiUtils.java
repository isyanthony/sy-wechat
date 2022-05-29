package cn.isyanthony.wechat.miniapp.util;
import static cn.isyanthony.wechat.miniapp.constant.RedisConstant.*;
import cn.isyanthony.wechat.miniapp.api.ApiWeChat;
import lombok.Data;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author: Syanthony
 * @Date: 2022/5/28
 * @Version: 1.0.0
 * @description: 微信接口封装工具类
 */
@Component
@Data
public class ApiUtils {

    @Resource
    ApiWeChat apiWeChat;

    @Resource
    StringRedisTemplate stringRedisTemplate;

    /**
     * access_token 过期时长
     */
    public static final Long timeout = 2L;


    /**
     * 获取AccessToken
     * @return access_token
     * @throws Exception 请求异常
     */
    public String ForAccessToken() throws Exception {
        String accessToken = String.valueOf(stringRedisTemplate.opsForHash().get(ACCESS_TOKEN_KEY, ACCESS_TOKEN_HASH_KEY));
        if(!StringUtils.hasLength(accessToken)){
            accessToken  = apiWeChat.getAccessToken().getAccess_token();
            stringRedisTemplate.opsForHash().put(ACCESS_TOKEN_KEY , ACCESS_TOKEN_HASH_KEY , accessToken);
            stringRedisTemplate.expire(ACCESS_TOKEN_KEY, timeout ,TimeUnit.HOURS);
        }
        return accessToken;
    }
}
