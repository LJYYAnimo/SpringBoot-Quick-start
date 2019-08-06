package com.animo.boot.springbootexception.exception;

import com.animo.boot.springbootexception.enums.ResultEnum;
import lombok.Getter;

/**
 * @author 刘金泳
 * @Date 2019/8/6
 */
@Getter
public class PageException extends RuntimeException {

    private Integer code;

    public PageException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

}

