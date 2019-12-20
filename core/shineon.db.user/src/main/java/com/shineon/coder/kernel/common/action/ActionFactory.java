package com.shineon.coder.kernel.common.action;

import com.shineon.coder.kernel.common.ibase.IFactory;

public class ActionFactory implements IFactory {
    @Override
    public void build(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) throws Exception {
        ActionMakeUp makeUp = new ActionMakeUp(name,toolClass,pojoClass,methods,sysName);
        makeUp.build();
    }

    @Override
    public void build() throws Exception {

    }

    @Override
    public void delete(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) throws Exception {
        ActionMakeUp makeUp = new ActionMakeUp(name,toolClass,pojoClass,methods,sysName);
        makeUp.delete();
    }
}
