package com.animo.boot.springbootqq.util;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

/**
 * @author 刘金泳
 * @Date 2019/8/5
 */
public class ConnectUtil {

    /**
     * 授权地址
     * @param appId
     * @param redirectUri
     * @return
     */
    public static String getAuthorize(String appId,String redirectUri){

        /**
         * 这里需要随机生成在和客户端传过来的state进行对比,防止CSRF攻击。
         */
        String state = "12n2x94h124vgh1249";

        String url = "https://graph.qq.com/oauth2.0/authorize?response_type=code&client_id=%s&redirect_uri=%s&state=%s";

        try {
            return String.format(url,appId,URLEncoder.encode(redirectUri,"UTF-8"),state);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取AccessToken
     * @param appId
     * @param appKey
     * @param code
     * @param redirectUri
     * @return
     */
    public static String getAccessToken(String appId,String appKey,String code,String redirectUri){
        String url = "https://graph.qq.com/oauth2.0/token?grant_type=authorization_code&client_id=%s&client_secret=%s&code=%s&redirect_uri=%s";
        try {
            return String.format(url,appId,appKey,code,URLEncoder.encode(redirectUri,"UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取openId
     * @param accessToken
     * @return
     */
    public static String getOpenId(String accessToken){
        return "https://graph.qq.com/oauth2.0/me?access_token="+accessToken;
    }

    /**
     * 获取用户信息
     * @param accessToken
     * @param appId
     * @param openId
     * @return
     */
    public static String getUserInfo(String accessToken , String appId, String openId){
        String url = "https://graph.qq.com/user/get_user_info?access_token=%s&oauth_consumer_key=%s&openid=%s";
        return String.format(url,accessToken,appId,openId);
    }

}
