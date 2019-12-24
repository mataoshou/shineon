package com.shineon.coder.kernel.common.action;

import com.shineon.coder.kernel.common.ibase.IFactory;

public class ActionFactory extends IFactory<ActionMakeUp> {

    public ActionFactory(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(name, toolClass, pojoClass, methods, sysName);
    }

    @Override
    public ActionMakeUp setMakeUp(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        return  new ActionMakeUp(name,toolClass,pojoClass,methods,sysName);
    }


}
