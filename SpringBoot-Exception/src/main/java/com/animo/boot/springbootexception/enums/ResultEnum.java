package com.animo.boot.springbootexception.enums;

import lombok.Getter;

/**
 * 全局异常返回
 *
 * @author liujinyong
 *
 * @date 2019/7/9
 */
@Getter
public enum ResultEnum {

    MOENY_NULL(1,"金额为空")
    ;

    private Integer code;

    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
