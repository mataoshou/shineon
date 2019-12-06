package com.shineon.coder.kernel.util;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class StringUtil {

    public String firstUpper(String str)
    {
        char first = Character.toUpperCase(str.charAt(0));
        StringBuffer methodName = new StringBuffer(str);
        methodName.setCharAt(0, first);

        return methodName.toString();
    }

    public boolean isUnEmpty(String str)
    {
        if(str==null||str.length()==0) return false;

        return true;
    }
}
