package com.shineon.coder.kernel.common.bo;

import com.shineon.coder.kernel.common.ibase.IFactory;

public class BOFactory extends IFactory<BOMakeUp> {
    public BOFactory(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(name, toolClass, pojoClass, methods, sysName);
    }

    @Override
    public BOMakeUp setMakeUp(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        return new BOMakeUp(name,toolClass,pojoClass,methods,sysName);
    }
}
