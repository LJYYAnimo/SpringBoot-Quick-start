package com.animo.boot.springbootrunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author 刘金泳
 * @Date 2019/8/1
 */
@Component
public class CommandLineRunnerNg implements CommandLineRunner, Ordered {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("CommandLineRunnerNg");
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
