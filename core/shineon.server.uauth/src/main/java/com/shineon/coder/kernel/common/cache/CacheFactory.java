package com.shineon.coder.kernel.common.cache;

import com.shineon.coder.kernel.common.ibase.IFactory;

public class CacheFactory implements IFactory {
    @Override
    public void build(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) throws Exception {
        CacheMakeUp makeUp = new CacheMakeUp(name,toolClass,pojoClass,methods,sysName);
        makeUp.build();
    }

    @Override
    public void build() throws Exception {

    }

    @Override
    public void delete(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) throws Exception {
        CacheMakeUp makeUp = new CacheMakeUp(name,toolClass,pojoClass,methods,sysName);
        makeUp.delete();
    }
}
