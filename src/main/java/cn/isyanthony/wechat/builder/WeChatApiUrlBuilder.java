package cn.isyanthony.wechat.builder;

import cn.isyanthony.wechat.config.AppConfiguration;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author: Syanthony
 * @Date: 2022/5/14 15:55
 * @Version: 1.0.0
 * @description:
 */

@Component
public class WeChatApiUrlBuilder {

    @Resource
    AppConfiguration conf;

    /**
     * url 正则待填参数
     */
    private static final String APP_ID = "APPID";
    private static final String APP_SECRET = "SECRET";
    private static final String CODE_2_SESSION_JSCODE = "JSCODE";

    /**
     * 微信登录接口URL
     */
    private final static String URL_CODE_2_SESSION = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";

    /**
     * 微信获取Access_TOKEN URL
     */
    private final static String URL_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    /**
     * 构造code2session接口的url
     * @param jsCode 登录时获取的 code
     * @return url
     */
    public String getCode2session(String jsCode){
        String url = URL_CODE_2_SESSION;
        url = url.replace(APP_ID, conf.getAppid())
                .replace(APP_SECRET, conf.getAppsecret())
                .replace(CODE_2_SESSION_JSCODE, jsCode);
        return url;
    }


    /**
     * 获取微信access_token
     * @return url
     */
    public String getAccessToken(){
        String url = URL_ACCESS_TOKEN;
        url = url.replace(APP_ID, conf.getAppid())
                .replace(APP_SECRET, conf.getAppsecret());
        return url;
    }

}
