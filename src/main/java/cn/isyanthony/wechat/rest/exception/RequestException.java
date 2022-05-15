package cn.isyanthony.wechat.rest.exception;

/**
 * @author: Syanthony
 * @Date: 2022/5/14
 * @Version: 1.0.0
 * @description: Http请求异常
 */
public class RequestException extends Exception{

    public  RequestException(){}
    public RequestException(String message) {
        super(message);
    }
}
