package com.shineon.coder.kernel.common.convert;

import com.shineon.coder.kernel.common.CommonTool;
import com.shineon.coder.kernel.common.ibase.IFactory;
import com.shineon.coder.kernel.constant.convert.ConvertsConstant;
import com.shineon.coder.kernel.constant.sys.SysConstant;
import com.shineon.coder.kernel.util.BaseFileUtil;

import java.io.File;

public class ConvertFactory implements IFactory {


    @Override
    public void build(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) throws Exception {

    }

    @Override
    public void build() throws Exception {
        CommonTool tools = new CommonTool();
        File root = tools.getSysPath(ConvertsConstant.POJO_PACKAGE);
        File[] pojos = root.listFiles();

        for(File pf :pojos) {
            String fname = BaseFileUtil.getFileNameNoSuffix(pf.getName());
            String pojoClassName = ConvertsConstant.POJO_PACKAGE +"." + fname;
            Class pojoClass = Class.forName(pojoClassName);
            ConvertMakeUp makeUp = new ConvertMakeUp(fname,null,pojoClass,null, SysConstant.CURRENT_SYS_NAME);
            makeUp.build();
        }
    }

    @Override
    public void delete(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) throws Exception {

    }
}
