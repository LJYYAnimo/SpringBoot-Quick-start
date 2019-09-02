package com.animo.boot.springbootpay.util;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.animo.boot.springbootpay.config.AliPayConfig;

/**
 * 支付宝工具类
 * @author 刘金泳
 * @Date 2019/8/6
 */
public class AliPayUtil {

    /**
     * 获取支付宝SDK 客户端 进行api操作
     * @return
     */
    public static AlipayClient getAliPayClient(){
        AliPayConfig aliPayConfig = SpringUtil.getBean(AliPayConfig.class);
        return new DefaultAlipayClient(aliPayConfig.getUrl(),aliPayConfig.getAppId(),aliPayConfig.getAppPrivateKey(),aliPayConfig.getFormat(),aliPayConfig.getCharSet(),aliPayConfig.getAlipayPublicKey(),aliPayConfig.getSignType());
    }



}
