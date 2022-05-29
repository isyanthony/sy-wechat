package cn.isyanthony.wechat.miniapp.rest;

import cn.isyanthony.wechat.miniapp.rest.exception.RequestException;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.Map;

/**
 * @author: Syanthony
 * @Date: 2022/5/14
 * @Version: 1.0.0
 * @description: 封装 RestTemplate
 */
@Service
public class RestServer {
    @Resource
    private RestTemplate restTemplate;

    /**
     *
     * @param url api 地址
     * @param header 头部信息
     * @param params 参数
     * @param resp 响应体结构
     * @return 响应体结果
     */
    public <T> T get(String url , Map<String , String> header , Map<String , Object> params , Class<T> resp) throws Exception {
        if(!StringUtils.hasLength(url)){
            throw new RequestException("Syanthony Tips : URL CAN'T BE NULL.");
        }
        HttpHeaders headers = null;
        if(header != null){
            headers = new HttpHeaders();
            for (Map.Entry<String, String> stringStringEntry : header.entrySet()) {
                headers.add(stringStringEntry.getKey(), stringStringEntry.getValue());
            }
        }
        HttpEntity<Map<String , Object>> httpEntity;
        HttpEntity<Map<String, Object>> entity = new HttpEntity<>(params, headers);

        ResponseEntity<T> result = restTemplate.exchange(url, HttpMethod.GET, entity, resp);
        return result.getBody();
    }

    /**
     *
     * @param url api 地址
     * @param params 参数
     * @param resp 响应体结构
     * @return 响应体结果
     */
    public <T> T get(String url , Map<String , Object> params , Class<T> resp) throws Exception {
        return get(url, null, params, resp);
    }


    /**
     *
     * @param url api 地址
     * @param resp 响应体结构
     * @return 响应体结果
     */
    public <T> T get(String url , Class<T> resp) throws Exception {
        return get(url, null , resp);
    }


    /**
     * post 请求
     * @param url api 地址
     * @param header 头部参数
     * @param data 请求体
     * @param resp 返回类型
     * @return 相应体
     */
    public <T> T post(String url , Map<String , String> header , Map<String, Object> data , Class<T> resp) throws Exception {
        if(!StringUtils.hasLength(url)){
            throw new RequestException("Syanthony Tips : URL CAN'T BE NULL.");
        }
        HttpHeaders headers = null;
        HttpEntity<Map<String, Object>> entity = null;
        if(header != null){
            headers = new HttpHeaders();
            for (Map.Entry<String, String> entry : header.entrySet()) {
                headers.add(entry.getKey(), entry.getValue());
            }
        }
        entity = new HttpEntity<>(data , headers);

        return (T) restTemplate.postForEntity(url, entity, resp);
    }

    /**
     * post 请求
     * @param url api 地址
     * @param data 请求体
     * @param resp 返回类型
     * @return 相应体
     */
    public <T> T post(String url , Map<String, Object> data , Class<T> resp) throws Exception {
        return post(url, null, data, resp);
    }
}
