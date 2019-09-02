package com.animo.boot.springbootpay;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.AlipayResponse;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.animo.boot.springbootpay.config.AliPayConfig;
import com.animo.boot.springbootpay.dto.PlaceOrderDto;
import com.animo.boot.springbootpay.util.GsonUtil;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author 刘金泳
 * @Date 2019/8/5
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AlipayClientTest {

    @Autowired
    private AliPayConfig aliPayConfig;

    @Test
    public void testClient(){

    }

}
