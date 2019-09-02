package com.animo.boot.springbootpay.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 统一下单请求参数 更多请求参数参照:https://docs.open.alipay.com/api_1/alipay.trade.page.pay
 * @author 刘金泳
 * @Date 2019/8/5
 */
@Data
public class PlaceOrderDto {

   /**
    * 商品订单号
    */
   private String out_trade_no;

   /**
    * code 目前仅支持FAST_INSTANT_TRADE_PAY
    */
   private String product_code = "FAST_INSTANT_TRADE_PAY";

   /**
    * 总金额
    */
   private BigDecimal total_amount;

   /**
    * 商品主体名称
    */
   private String subject;

}
