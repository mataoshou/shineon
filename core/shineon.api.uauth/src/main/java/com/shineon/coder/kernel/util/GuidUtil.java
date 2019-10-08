package com.shineon.coder.kernel.util;

import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GuidUtil {

    public String gen()
    {
        String s = UUID.randomUUID().toString();
        String s2 = s.substring(0,8)+s.substring(9,13)+s.substring(14,18)+s.substring(19,23)+s.substring(24);
        return s2.toUpperCase();
    }
}
