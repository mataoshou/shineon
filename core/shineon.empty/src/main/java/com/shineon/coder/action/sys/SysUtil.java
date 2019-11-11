package com.shineon.coder.action.sys;

import org.springframework.stereotype.Service;

@Service
public class SysUtil {
    public String getName(String fileName)
    {
        return fileName + ".mg";
    }
}
