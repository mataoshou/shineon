package com.shineon.coder;

import com.shineon.coder.common.message.MessageItem;
import com.shineon.coder.common.util.SpringUtil;
import com.shineon.coder.common.util.SysServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import javax.print.ServiceUI;

@SpringBootApplication
@EnableEurekaClient
@EnableAsync
public class CoderApplication {


    public static void main(String[] args) {
        SpringApplication.run(CoderApplication.class, args);

        SysServiceUtil serviceUtil = SpringUtil.getBean(SysServiceUtil.class);

        serviceUtil.getService();
    }

}
