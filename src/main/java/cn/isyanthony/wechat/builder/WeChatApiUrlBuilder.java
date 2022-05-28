package cn.isyanthony.wechat.builder;

import cn.isyanthony.wechat.config.AppConfiguration;
import org.springframework.data.domain.PageRequest;
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

    private static final String ACCESS_TOKEN = "ACCESS_TOKEN";

    /**
     * 微信登录接口URL
     */
    private final static String URL_CODE_2_SESSION = "https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code";

    /**
     * 微信获取Access_TOKEN URL
     */
    private final static String URL_ACCESS_TOKEN = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";

    /**
     * 获取用户画像分布接口URL
     */
    private final static String URL_USER_PORTRAIT = "https://api.weixin.qq.com/datacube/getweanalysisappiduserportrait?access_token=ACCESS_TOKEN";

    /**
     * 获取页面访问数据接口URL
     */
    private final static String URL_VISIT_PAGE = "https://api.weixin.qq.com/datacube/getweanalysisappidvisitpage?access_token=ACCESS_TOKEN";

    /**
     * 获取日访问数据趋势接口URL
     */
    private final static String URL_DAILY_VISIT_TREND = "https://api.weixin.qq.com/datacube/getweanalysisappiddailyvisittrend?access_token=ACCESS_TOKEN";

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

    /**
     * 获取小程序新增或活跃用户的画像分布数据
     * 时间范围支持昨天、最近7天、最近30天
     * @param token access_token
     * @return url
     */
    public String getUserPortrait(String token){
        return URL_USER_PORTRAIT.replace(ACCESS_TOKEN, token);
    }

    /**
     * 获取小程序访问数据
     * @param token access_token
     * @return url
     */
    public String getVisitPage(String token){
        return URL_VISIT_PAGE.replace(ACCESS_TOKEN, token);
    }


    /**
     * 获取小程序日访问数据趋势
     * @param token access_token
     * @return url
     */
    public String getDailyVisitTrend(String token){
        return URL_DAILY_VISIT_TREND.replace(ACCESS_TOKEN, token);
    }



}
