package com.shineon.coder.kernel.common.feign;

import com.shineon.coder.kernel.common.ibase.IFactory;

public class FeignFactory extends IFactory<FeignMakeUp> {
    public FeignFactory(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(name, toolClass, pojoClass, methods, sysName);
    }

    @Override
    public FeignMakeUp setMakeUp(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        return new FeignMakeUp(name,toolClass,pojoClass,methods,sysName);
    }

}
