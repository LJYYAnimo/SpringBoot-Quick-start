package com.animo.boot.springbootpay.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.animo.boot.springbootpay.config.AliPayConfig;
import com.animo.boot.springbootpay.dto.PlaceOrderDto;
import com.animo.boot.springbootpay.service.AliPayService;
import com.animo.boot.springbootpay.util.AliPayUtil;
import com.animo.boot.springbootpay.util.GsonUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;

/**
 * @author 刘金泳
 * @Date 2019/8/6
 */
@Service
public class AliPayServiceImpl implements AliPayService {

    @Autowired
    private AliPayConfig aliPayConfig;

    /**
     * 如果拿此代码使用的话 方法入参需要把HttpServletRequest换成PlaceOrderDto
     * （统一支付请求参数->前端自动对应属性）
     * 这里做简单学习的demo
     * @param request
     * @return
     */
    @Override
    public String pay(HttpServletRequest request) {
        //获取支付宝客户端
        AlipayClient alipayClient = AliPayUtil.getAliPayClient();

        //设置公共参数
        AlipayTradePagePayRequest alipayRequest = new AlipayTradePagePayRequest();
        alipayRequest.setReturnUrl(aliPayConfig.getReturnUrl());
        alipayRequest.setNotifyUrl(aliPayConfig.getNotifyUrl());

        //封装表单 如果该Bean参数不够可以另外加
        PlaceOrderDto placeOrderDto = new PlaceOrderDto();
        placeOrderDto.setOut_trade_no(request.getParameter("WIDout_trade_no"));
        placeOrderDto.setTotal_amount(new BigDecimal(request.getParameter("WIDtotal_amount")));
        placeOrderDto.setSubject(request.getParameter("WIDsubject"));

        //设置请求参数 把Object转化成Json字符串
        alipayRequest.setBizContent(GsonUtil.objectToJson(placeOrderDto));

        try {

            //支付请求
            return alipayClient.pageExecute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
            //TODO 日志记录 统一异常拦截
        }
        return null;
    }
}
