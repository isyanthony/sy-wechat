package cn.isyanthony.wechat;

import cn.isyanthony.wechat.resonse.Code2SessionResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.Duration;

/**
 * @author: Syanthony
 * @Date: 2022/5/15
 * @Version: 1.0.0
 * @description:
 */
@SpringBootApplication
@EnableConfigurationProperties
@RestController
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Resource
    StringRedisTemplate stringRedisTemplate;

    @Resource
    ObjectMapper mapper;

    @GetMapping("/test")
    public String test() throws JsonProcessingException {
        stringRedisTemplate.opsForHash().put("test", "test", mapper.writeValueAsString(new Code2SessionResponse()));
        stringRedisTemplate.expire("test", Duration.ofMinutes(2L));
        return "Hello World";
    }


}
