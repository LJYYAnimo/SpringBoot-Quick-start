package com.animo.boot.springbootconfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 刘金泳
 * @Date 2019/8/1
 */
@RestController
public class MainController {

    @Autowired
    private Student student;

    @Autowired
    private StudentConfigurationProperties studentConfigurationProperties;

    @GetMapping("/getStudent")
    public Student getStudent(){
        return student;
    }

    @GetMapping("/getStudentConfigurationProperties")
    public StudentConfigurationProperties getStudentConfigurationProperties(){
        return studentConfigurationProperties;
    }

}
