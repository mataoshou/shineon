package com.shineon.coder.kernel.common.generator;

import com.shineon.coder.kernel.common.CommonTool;
import com.shineon.coder.kernel.common.ibase.IFactory;
import com.shineon.coder.kernel.constant.db.DBConstant;
import com.shineon.coder.kernel.constant.sys.SysConstant;
import com.shineon.coder.kernel.util.BaseFileUtil;

import java.io.File;

public class GeneratorFactory implements IFactory {


    @Override
    public void build(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) throws Exception {

    }

    @Override
    public void build() throws Exception {
        CreatePojo createPojo = new CreatePojo();
        createPojo.createClass();

        CommonTool tool = new CommonTool();

        File pojoRoot = tool.getSysPath(DBConstant.DB_POJO_PACKAGE);

        File[] pojos = pojoRoot.listFiles();
        for(File pojo : pojos) {
            String name = BaseFileUtil.getFileNameNoSuffix(pojo.getName());
//            String pojoClassName = ConvertsConstant.POJO_PACKAGE +"." + name;
//            Class pojoClass = Class.forName(pojoClassName);
            GeneratorMakeUp makeUp = new GeneratorMakeUp(name,null,null,null, SysConstant.CURRENT_SYS_NAME);
            makeUp.build();
        }
    }

    @Override
    public void delete(String name, Class toolClass, Class pojoClass, String[] methods, String sysName) throws Exception {

    }
}
