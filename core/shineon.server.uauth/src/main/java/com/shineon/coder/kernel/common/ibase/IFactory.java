package com.shineon.coder.kernel.common.ibase;

public interface IFactory {

    void build(String name, Class toolClass,
                      Class pojoClass, String[] methods, String sysName) throws Exception;

    void build() throws Exception;

    void delete(String name, Class toolClass,Class pojoClass, String[] methods, String sysName) throws Exception;
}
