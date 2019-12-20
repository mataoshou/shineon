package com.shineon.coder.kernel.common.feign;

import com.shineon.coder.kernel.common.ibase.IFactory;

public class FeignFactory implements IFactory {
    @Override
    public void build(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) throws Exception {
        FeignMakeUp makeUp = new FeignMakeUp(name,toolClass,pojoClass,methods,sysName);
        makeUp.build();
    }

    @Override
    public void build() throws Exception {

    }

    @Override
    public void delete(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) throws Exception {
        FeignMakeUp makeUp = new FeignMakeUp(name,toolClass,pojoClass,methods,sysName);
        makeUp.delete();
    }
}
