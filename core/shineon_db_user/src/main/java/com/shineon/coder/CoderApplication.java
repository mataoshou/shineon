package com.shineon.coder;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import java.util.Timer;
import java.util.TimerTask;

@SpringBootApplication
@MapperScan("com.shineon.coder.db.mergedao")
@EnableEurekaClient
public class CoderApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoderApplication.class, args);

    }

}
