package cn.isyanthony.wechat.miniapp.rest.config;

import cn.isyanthony.wechat.miniapp.config.convert.WxMappingJackson2HttpMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * @author: Anthony
 * @Date: 2022/5/14 16:19
 * @Version: 1.0.0
 * @description:
 */
@Component
public class HttpConfig {
    /**
     * 设置 2 分钟为超时时间
     */
    private int outTime = 2 * 60 * 1000;
    @Bean
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
        requestFactory.setConnectTimeout(outTime);
        requestFactory.setReadTimeout(outTime);
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new WxMappingJackson2HttpMessageConverter());
        return restTemplate;
    }
}
