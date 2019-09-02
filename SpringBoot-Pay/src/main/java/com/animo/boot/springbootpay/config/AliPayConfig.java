package com.animo.boot.springbootpay.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 刘金泳
 * @Date 2019/8/5
 */
@Component
@ConfigurationProperties("alipay")
@Data
public class AliPayConfig {

    /**
     * 网关地址
     */
    private String url;

    /**
     * appID
     */
    private String appId;

    /**
     * 私钥
     */
    private String appPrivateKey;

    /**
     * 参数返回格式
     */
    private String format;

    /**
     * 字符集编码 支持 GBK/UTF-8
     */
    private String charSet;

    /**
     * 公钥
     */
    private String alipayPublicKey;

    /**
     * 签名方式 RSA2
     */
    private String signType;

    /**
     * 回调函数
     */
    private String returnUrl;

    /**
     * 异步通知结果
     */
    private String notifyUrl;
}
