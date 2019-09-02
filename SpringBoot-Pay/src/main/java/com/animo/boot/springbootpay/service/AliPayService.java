package com.animo.boot.springbootpay.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author 刘金泳
 * @Date 2019/8/6
 */
public interface AliPayService {

    String pay(HttpServletRequest request);

}
