package com.shineon.coder.kernel.common.feign;

import com.shineon.coder.kernel.common.ibase.IMakeUpBase;

public class FeignMakeUp extends IMakeUpBase {
    public FeignMakeUp(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(name, toolClass, pojoClass, methods, sysName);
        add(new CreateFeign(name,toolClass,pojoClass,methods,sysName));
        add(new CreateFeignFallBack(name,toolClass,pojoClass,methods,sysName));
    }
}
