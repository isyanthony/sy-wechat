package cn.isyanthony.wechat.resonse;


import lombok.Data;

/**
 * @author: Syanthony
 * @Date: 2022/5/14
 * @Version: 1.0.0
 * @description: 获取AccessToken的响应体
 */
@Data
public class AccessTokenResponse {

    /**
     * 获取到的凭证
     */
    String access_token;
    /**
     * 过期时间
     */
    Integer expires_in;

    /**
     * 错误码
     * -1 	    系统繁忙，此时请开发者稍候再试
     * 0 	    请求成功
     * 40001 	AppSecret 错误或者 AppSecret 不属于这个小程序，请开发者确认 AppSecret 的正确性
     * 40002 	请确保 grant_type 字段值为 client_credential
     * 40013 	不合法的 AppID，请开发者检查 AppID 的正确性，避免异常字符，注意大小写
     */
    Integer errcode;

    /**
     * 错误信息
     */
    String errmsg;
}
