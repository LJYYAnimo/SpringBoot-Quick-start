package com.animo.boot.springbootexception.handler;

import com.animo.boot.springbootexception.exception.PageException;
import com.animo.boot.springbootexception.exception.ProjectException;
import com.animo.boot.springbootexception.vo.ServerResponseVo;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
/**
 * 交互响应异常拦截
 *
 * @author liujinyong
 *
 * @date 2019/7/9
 */
@ControllerAdvice
public class ProjectExceptionHandler {

    @ExceptionHandler(value = ProjectException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ServerResponseVo execute(ProjectException e){
        return ServerResponseVo.createByError(e.getMessage());
    }

    @ExceptionHandler(value = PageException.class)
    public ModelAndView execute(PageException e){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("error");
        modelAndView.addObject("errorMesg",e.getMessage());
        return modelAndView;
    }

}
