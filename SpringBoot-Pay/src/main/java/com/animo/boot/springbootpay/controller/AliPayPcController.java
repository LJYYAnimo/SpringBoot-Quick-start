package com.animo.boot.springbootpay.controller;

import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.animo.boot.springbootpay.config.AliPayConfig;
import com.animo.boot.springbootpay.service.AliPayService;
import com.animo.boot.springbootpay.util.MapUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 电脑端下单
 * @author 刘金泳
 * @Date 2019/8/5
 */
@Controller
@RequestMapping("/aliPay/pc/")
public class AliPayPcController {

    @Autowired
    private AliPayConfig aliPayConfig;

    @Autowired
    private AliPayService aliPayService;

    /**
     * 支付 -> 方法逻辑自行编写
     * 校验自行处理 后续自行实现需要把HttpServletRequest 换成 PlaceOrderDto
     * @param request
     * @param modelAndView
     * @return
     */
    @PostMapping("pay")
    public ModelAndView pay(HttpServletRequest request, ModelAndView modelAndView){
        modelAndView.setViewName("pc/pay");
        modelAndView.addObject("form",aliPayService.pay(request));
        return modelAndView;
    }

    @GetMapping("returnUrl")
    @ResponseBody
    public String returnUrl(HttpServletRequest request){
        Map<String,String> params = MapUtil.getRequestMap(request);
        System.out.println("回调通知:"+params.toString());
        try {
            //验证SDK签名是否是支付宝发送的
            boolean signVerified = AlipaySignature.rsaCheckV1(params, aliPayConfig.getAlipayPublicKey(), aliPayConfig.getCharSet(), aliPayConfig.getSignType());

        } catch (AlipayApiException e) {
            e.printStackTrace();
            //TODO 签名失败 做日志处理和统一异常拦截返回 new throws 自己的异常
        }
        return null;
    }



    /**
     * 异步通知
     * @param request
     * @return
     * @throws AlipayApiException
     */
    @PostMapping("noTiTyUrl")
    @ResponseBody
    public String noTiTyUrl(HttpServletRequest request) throws AlipayApiException {
        Map<String,String> params = MapUtil.getRequestMap(request);
        System.out.println("异步通知:"+params.toString());
        //商户系统接收到异步通知以后，必须通过验签（验证通知中的 sign 参数）来确保支付通知是由支付宝发送的
        boolean signVerified = AlipaySignature.rsaCheckV1(params, aliPayConfig.getAlipayPublicKey(), aliPayConfig.getCharSet(), aliPayConfig.getSignType());

        return null;
    }
}
