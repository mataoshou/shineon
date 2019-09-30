package com.shineon.coder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class CoderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoderApplication.class, args);
    }

}
