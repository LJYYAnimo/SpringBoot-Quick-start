package com.animo.boot.springbootrunner;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author 刘金泳
 * @Date 2019/8/1
 */
@Component
@Order(1)
public class ApplicationRunnerNg implements ApplicationRunner{

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("ApplicationRunnerNg");
    }
}
