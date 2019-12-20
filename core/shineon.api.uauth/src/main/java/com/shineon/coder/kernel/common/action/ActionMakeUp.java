package com.shineon.coder.kernel.common.action;

import com.shineon.coder.kernel.common.ibase.IMakeUpBase;

public class ActionMakeUp extends IMakeUpBase {
    public ActionMakeUp(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(name, toolClass, pojoClass, methods, sysName);
       add(new CreateAction(name,toolClass,pojoClass,methods, sysName));
       add(new CreateDTO(name,toolClass,pojoClass,methods,sysName));
    }
}
