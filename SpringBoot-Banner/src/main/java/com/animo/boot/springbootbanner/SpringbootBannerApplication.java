package com.animo.boot.springbootbanner;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBannerApplication {

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(SpringbootBannerApplication.class);
        application.setBannerMode(Banner.Mode.OFF);
        application.run(args);
    }

}
