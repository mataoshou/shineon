package com.shineon.coder.kernel.common.bo;

import com.shineon.coder.kernel.common.ibase.IFactory;

public class BOFactory implements IFactory {
    @Override
    public void build(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) throws Exception {
        BOMakeUp makeUp = new BOMakeUp(name,toolClass,pojoClass,methods,sysName);
        makeUp.build();
    }

    @Override
    public void build() throws Exception {

    }

    @Override
    public void delete(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) throws Exception {
        BOMakeUp makeUp = new BOMakeUp(name,toolClass,pojoClass,methods,sysName);
        makeUp.delete();
    }
}
