package cn.isyanthony.wechat.miniapp.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: Anthony
 * @Date: 2022/5/14 16:06
 * @Version: 1.0.0
 * @description:
 */

@Component
@ConfigurationProperties(prefix = "app")
@Data
public class AppConfiguration {
    /**
     * 小程序的 app_id
     */
    private String appid;

    /**
     * 小程序的 app_secret
     */
    private String appsecret;
}
