package com.shineon.coder.kernel.common.ibase;

public abstract class IFactory<T extends IMakeUpBase> {

    T t;

    public abstract T setMakeUp(String name, Class toolClass,
                                   Class pojoClass, String[] methods, String sysName);

    public IFactory(String name, Class toolClass,
                    Class pojoClass, String[] methods, String sysName)
    {
        t = setMakeUp(name, toolClass,
                pojoClass,methods, sysName);
    }



    public void build() throws Exception{
        t.build();
    }

    public void delete() throws Exception{
        t.delete();
    }

    public void rebuild() throws Exception{
        t.rebuild();
    }

}
