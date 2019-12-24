package com.shineon.coder.kernel.common.message;

import com.shineon.coder.kernel.common.ibase.IFactory;

public class MessageFactory extends IFactory<MessageMakeUp> {

    public MessageFactory(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(name, toolClass, pojoClass, methods, sysName);
    }


    @Override
    public MessageMakeUp setMakeUp(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        return new MessageMakeUp(name,toolClass,pojoClass,methods,sysName);
    }
}
