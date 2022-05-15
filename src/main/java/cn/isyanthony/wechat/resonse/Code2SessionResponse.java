package cn.isyanthony.wechat.resonse;

import lombok.Data;

/**
 * @author: Anthony
 * @Date: 2022/5/14 16:13
 * @Version: 1.0.0
 * @description:
 */
@Data
public class Code2SessionResponse {

    /**
     * string 	用户唯一标识
     */
    String openid;

    /**
     * 会话密钥
     */
    String session_key;

    /**
     * 用户在开放平台的唯一标识符，若当前小程序已绑定到微信开放平台帐号下会返回，详见 UnionID 机制说明。
     */
    String unionid;

    /**
     * 错误码
     */
    Integer errcode;

    /**
     * 错误信息
     */
    String errmsg;
}
