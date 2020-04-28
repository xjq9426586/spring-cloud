package com.xjq.feigna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FeignAApplication {

    public static void main(String[] args) {
        SpringApplication.run(FeignAApplication.class, args);
    }

}
