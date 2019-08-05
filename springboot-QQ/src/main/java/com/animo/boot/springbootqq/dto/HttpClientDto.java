package com.animo.boot.springbootqq.dto;

/**
 * @author 刘金泳
 * @Date 2019/7/25
 */
public class HttpClientDto {

    /**
     * 响应状态码
     */
    private int code;

    /**
     * 响应数据
     */
    private String content;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public HttpClientDto() {
    }

    public HttpClientDto(int code) {
        this.code = code;
    }

    public HttpClientDto(int code, String content) {
        this.code = code;
        this.content = content;
    }

    @Override
    public String toString() {
        return "HttpClientDto{" +
                "code=" + code +
                ", content='" + content + '\'' +
                '}';
    }
}
