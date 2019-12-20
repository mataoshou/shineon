package com.shineon.coder.kernel.common.bo;

import com.shineon.coder.kernel.common.ibase.IMakeUpBase;

public class BOMakeUp extends IMakeUpBase {

    public BOMakeUp(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(name, toolClass, pojoClass, methods, sysName);
        add( new CreateBO(name,toolClass,pojoClass,methods, sysName));
    }

}
