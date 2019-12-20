package com.shineon.coder.kernel.util;

import org.springframework.stereotype.Service;

@Service
public class StringUtil {

    public String firstUpper(String str)
    {
        char first = Character.toUpperCase(str.charAt(0));
        StringBuffer methodName = new StringBuffer(str);
        methodName.setCharAt(0, first);

        return methodName.toString();
    }

    public boolean isEmpty(String str)
    {
        return isEmpty(str,false);
    }

    public boolean isEmpty(String str ,boolean isingore,String...ingores)
    {
        if(str==null||str.length()==0)return true;
        if(isingore)
        {
            for(String ingore : ingores)
            {
                if(str.equals(ingore))
                {
                    return true;
                }
            }
        }

        return false;
    }
}
