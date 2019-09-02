package com.animo.boot.aop.custom.service.impl;

import com.animo.boot.aop.custom.service.PersonService;

/**
 * @author 刘金泳
 * @Date 2019/8/22
 */
public class PersonServiceImpl implements PersonService {

    @Override
    public void eat(String name) {
        if(name ==null || name.trim().equals("")){
            throw new RuntimeException("Name is Null");
        }
        System.out.println(name + "在吃饭");
    }
}
