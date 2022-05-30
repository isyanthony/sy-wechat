package cn.isyanthony.wechat.miniapp.api;

import cn.isyanthony.wechat.miniapp.builder.WeChatApiUrlBuilder;
import cn.isyanthony.wechat.miniapp.resonse.*;
import cn.isyanthony.wechat.miniapp.rest.RestServer;
import cn.isyanthony.wechat.miniapp.util.ApiUtils;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;

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
    ApiUtils apiUtils;

    @Resource
    WeChatApiUrlBuilder builder;

    @Resource
    StringRedisTemplate stringRedisTemplate;

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

    /**
     * 获取用户画像数据
     * @param beginDate 开始时间
     * @param endDate 最后时间
     * @return 用户画像数据
     * @throws Exception url不能为空
     */
    public UserPortraitResponse getUserPortrait(String beginDate , String endDate) throws Exception {
        return server.post(builder.getUserPortrait(apiUtils.ForAccessToken()), new HashMap<String, Object>(){
            {
                put("beginDate", beginDate);
                put("endDate", endDate);
            }
        }, UserPortraitResponse.class);
    }

    /**
     * 获取页面访问数据
     * @return 页面访问数据
     * @throws Exception url不能为空
     */
    public VisitPageResponse getVisitPage() throws Exception {
        return server.get(builder.getVisitPage(apiUtils.ForAccessToken()), VisitPageResponse.class);
    }


    /**
     * 获取日访问数据趋势
     * @return 日访问数据
     * @throws Exception url不能为空
     */
    public DailyVisitTrendResponse getDailyVisitTrend() throws Exception {
        return server.get(builder.getDailyVisitTrend(apiUtils.ForAccessToken()), DailyVisitTrendResponse.class);
    }

}
