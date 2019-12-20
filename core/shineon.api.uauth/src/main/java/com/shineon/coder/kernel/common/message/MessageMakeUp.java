package com.shineon.coder.kernel.common.message;

import com.shineon.coder.kernel.common.ibase.IMakeUpBase;

public class MessageMakeUp extends IMakeUpBase {
    public MessageMakeUp(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(name, toolClass, pojoClass, methods, sysName);

        add(new CreateMessageClient(name,toolClass,pojoClass,methods,sysName));
        add(new CreateMessageService(name,toolClass,pojoClass,methods,sysName));

    }
}
