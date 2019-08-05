package com.animo.boot.springboothello.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author 刘金泳
 * @Date 2019/8/1
 */
//@RestController
@Controller
@RequestMapping("/context/")
public class HelloController {

    @RequestMapping("hello")
//    @GetMapping
//    @PostMapping
//    @PutMapping
//    @DeleteMapping
    @ResponseBody
    public String hello(){
        return "Hello Spring Boot";
    }
}
