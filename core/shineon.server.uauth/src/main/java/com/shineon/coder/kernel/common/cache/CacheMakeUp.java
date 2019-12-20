package com.shineon.coder.kernel.common.cache;

import com.shineon.coder.kernel.common.ibase.IMakeUpBase;

public class CacheMakeUp extends IMakeUpBase {
    public CacheMakeUp(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(name, toolClass, pojoClass, methods, sysName);

        add(new CreateCache(name,toolClass,pojoClass,methods,sysName));
    }
}
