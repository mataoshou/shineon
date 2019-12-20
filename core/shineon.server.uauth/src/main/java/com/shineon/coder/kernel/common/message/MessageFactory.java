package com.shineon.coder.kernel.common.message;

import com.shineon.coder.kernel.common.ibase.IFactory;

public class MessageFactory implements IFactory {

    @Override
    public void build(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) throws Exception {
        MessageMakeUp messageMakeUp = new MessageMakeUp(name,toolClass,pojoClass,methods,sysName);
        messageMakeUp.build();
    }

    @Override
    public void build() throws Exception {

    }

    @Override
    public void delete(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) throws Exception {
        MessageMakeUp messageMakeUp = new MessageMakeUp(name,toolClass,pojoClass,methods,sysName);
        messageMakeUp.delete();
    }
}
