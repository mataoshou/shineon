package com.shineon.coder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@MapperScan("com.shineon.coder.db.sql.mergedao")
@EnableEurekaClient
public class CoderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoderApplication.class, args);
    }

}
