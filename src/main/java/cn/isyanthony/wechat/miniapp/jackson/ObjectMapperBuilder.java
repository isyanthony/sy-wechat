package cn.isyanthony.wechat.miniapp.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @author: Syanthony
 * @Date: 2022/5/27
 * @Version: 1.0.0
 * @description: Jackson实例化
 */
@Component
public class ObjectMapperBuilder {

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }
}
