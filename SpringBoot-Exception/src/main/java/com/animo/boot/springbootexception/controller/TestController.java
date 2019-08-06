package com.animo.boot.springbootexception.controller;

import com.animo.boot.springbootexception.enums.ResultEnum;
import com.animo.boot.springbootexception.exception.PageException;
import com.animo.boot.springbootexception.exception.ProjectException;
import com.animo.boot.springbootexception.vo.ServerResponseVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 刘金泳
 * @Date 2019/8/6
 */
@Controller
public class TestController {

    @GetMapping("/money")
    @ResponseBody
    public ServerResponseVo sendMoney(Integer money){
        try{
            money.hashCode();
        }catch (NullPointerException e){
            e.printStackTrace();
            throw new PageException(ResultEnum.MOENY_NULL);
        }
        return ServerResponseVo.createBySuccess("金额="+money);
    }

}
