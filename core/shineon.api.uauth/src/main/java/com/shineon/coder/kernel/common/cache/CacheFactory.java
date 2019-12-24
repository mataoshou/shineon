package com.shineon.coder.kernel.common.cache;

import com.shineon.coder.kernel.common.ibase.IFactory;

public class CacheFactory extends IFactory<CacheMakeUp> {
    public CacheFactory(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(name, toolClass, pojoClass, methods, sysName);
    }


    @Override
    public CacheMakeUp setMakeUp(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        return new CacheMakeUp(name,toolClass,pojoClass,methods,sysName);
    }

}
