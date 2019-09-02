package com.animo.boot.springbootqq.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author 刘金泳
 * @Date 2019/8/5
 */
@Component
@ConfigurationProperties(prefix = "connect")
public class ConnectConfig {

    /**
     * appID
     */
    private String appId;

    /**
     * appKey
     */
    private String appKey;

    /**
     * 回调的url
     */
    private String returnUri;

    /**
     * 项目的域名 为了方便测试
     */
    private String uri;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getReturnUri() {
        return returnUri;
    }

    public void setReturnUri(String returnUri) {
        this.returnUri = returnUri;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
