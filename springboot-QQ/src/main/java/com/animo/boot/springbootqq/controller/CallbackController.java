package com.animo.boot.springbootqq.controller;

import com.animo.boot.springbootqq.config.ConnectConfig;
import com.animo.boot.springbootqq.dto.HttpClientDto;
import com.animo.boot.springbootqq.util.ConnectUtil;
import com.animo.boot.springbootqq.util.GsonUtil;
import com.animo.boot.springbootqq.util.HttpClientUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 刘金泳
 * @Date 2019/8/4
 */
@Controller
public class CallbackController {

    @Autowired
    private ConnectConfig connectConfig;

    @RequestMapping("/login")
    public String qqLogin(){
        return "redirect:"+ ConnectUtil.getAuthorize(connectConfig.getAppId(),connectConfig.getReturnUri());

    }

    @GetMapping("/callback")
    @ResponseBody
    public String callBack(HttpServletRequest request){

        String code = request.getParameter("code");

        String state = request.getParameter("state");

        String accessTokenUrl = ConnectUtil.getAccessToken(connectConfig.getAppId(),connectConfig.getAppKey(),code,connectConfig.getReturnUri());

        /**
         * 此方法业务逻辑自行设计 需要结合缓存
         */
        try {
            //获取AccessToken
            HttpClientDto accessTokenDto = HttpClientUtil.doGet(accessTokenUrl);
            String [] strings = accessTokenDto.getContent().split("&");
            Map<String,String> map = new HashMap<>(16);
            map.put("access_token",strings[0].split("=")[1]);
            map.put("expires_in",strings[1].split("=")[1]);
            map.put("refresh_token",strings[2].split("=")[1]);
            //获取OpenId
            HttpClientDto openDto = HttpClientUtil.doGet(ConnectUtil.getOpenId(map.get("access_token")));
            String[] strings1 =  openDto.getContent().split(" ");
            Map<String,Object> openMap = GsonUtil.JsonToMap(strings1[1]);
            //获取用户信息
            HttpClientDto userInfo =  HttpClientUtil.doGet(ConnectUtil.getUserInfo(map.get("access_token"),connectConfig.getAppId(),openMap.get("openid").toString()));
            /**
             * 这里应该是ModeAndView  把头像和昵称放进map和页面一起返回
             */
            return userInfo.getContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "回调";
    }

}
