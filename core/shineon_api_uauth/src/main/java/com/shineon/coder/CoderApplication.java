package com.shineon.coder;

import com.shineon.coder.common.util.SpringUtil;
import com.shineon.coder.common.util.SysServiceUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableEurekaClient
@EnableAsync
@EnableFeignClients
public class CoderApplication {


    public static void main(String[] args) {
        SpringApplication.run(CoderApplication.class, args);

//        SysServiceUtil serviceUtil = SpringUtil.getBean(SysServiceUtil.class);
//
//        serviceUtil.getService();
    }

}
