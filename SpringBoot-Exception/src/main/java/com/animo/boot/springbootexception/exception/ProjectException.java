package com.animo.boot.springbootexception.exception;

import com.animo.boot.springbootexception.enums.ResultEnum;
import lombok.Getter;

/**
 * 前后端交互响应异常
 *
 * @author liujinyong
 *
 * @date 2019/7/9
 */
@Getter
public class ProjectException extends RuntimeException {

    private Integer code;

    public ProjectException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }

    public ProjectException(Integer code, String message) {
        super(message);
        this.code = code;
    }

}
