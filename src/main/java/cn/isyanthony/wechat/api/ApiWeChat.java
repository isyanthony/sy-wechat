package cn.isyanthony.wechat.api;

import cn.isyanthony.wechat.builder.WeChatApiUrlBuilder;
import cn.isyanthony.wechat.resonse.AccessTokenResponse;
import cn.isyanthony.wechat.resonse.Code2SessionResponse;
import cn.isyanthony.wechat.rest.RestServer;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: Anthony
 * @Date: 2022/5/14 15:52
 * @Version: 1.0.0
 * @description: 微信小程序API
 */
@Component
public class ApiWeChat {

    @Resource
    RestServer server;

    @Resource
    WeChatApiUrlBuilder builder;

    /**
     * 获取用户 openId 以及 session_key
     * @param code 登录码
     * @return 响应体
     * @throws Exception url 不能为空
     */
    public Code2SessionResponse code2session(String code) throws Exception {
        return server.get(builder.getCode2session(code), Code2SessionResponse.class);
    }

    /**
     * 获取微信授权凭证token
     * @return 响应体
     * @throws Exception url 不能为空
     */
    public AccessTokenResponse getAccessToken() throws Exception {
        return server.get(builder.getAccessToken() , AccessTokenResponse.class);
    }
}
