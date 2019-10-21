package com.shineon.coder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients
public class CoderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoderApplication.class, args);
    }

}
