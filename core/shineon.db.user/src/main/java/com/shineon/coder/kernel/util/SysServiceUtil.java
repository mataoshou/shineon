package com.shineon.coder.kernel.util;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class SysServiceUtil {

    @Autowired
    DiscoveryClient client;

    public void getService()
    {
        List<String> services = client.getServices();

        for(String str :services)
        {
            System.out.println("service:" +str);
        }
    }
}
