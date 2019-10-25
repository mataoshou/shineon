package com.shineon.coder.kernel.common.cache;

import com.shineon.coder.kernel.constant.SysConstant;
import com.shineon.coder.kernel.util.ClassBuildUtil;

import java.io.File;
import java.io.IOException;

public class CacheInit {

    public void init() throws IOException {
        String sys = System.getProperty("user.dir");
        File coder = new File(sys, "src\\main\\java\\");

        String constantPage = "com.shineon.coder.kernel.constant.cache";

        File cacheRoot = new File(coder,constantPage.replace(".","\\"));

        String className = "CacheConstant";

        File constantFile = new File(cacheRoot,className+".java");


        ClassBuildUtil classBuildUtil = new ClassBuildUtil();
        classBuildUtil.classInit(className,constantPage,true,null);

        classBuildUtil.addTabContent(String.format("public static final String CACHE_PACKAGE =\"com.shineon.coder.kernel.constant.cache\";"));
        classBuildUtil.addTabContent(String.format(""));

        classBuildUtil.addTabContent(String.format("public static final String CACHE_CONSTANT_PACKAGE =\"com.shineon.coder.service.cache\";"));
        classBuildUtil.addTabContent(String.format(""));

        classBuildUtil.addTabContent(String.format("public static final String REDIS_KEY_PRE = \"%s.\";", SysConstant.CURRENT_SYS_NAME.toUpperCase()));
        classBuildUtil.addTabContent(String.format(""));

        classBuildUtil.addTabContent(String.format("public static final String REDIS_KEY_LAST = \".DATA\";"));
        classBuildUtil.addTabContent(String.format(""));

        classBuildUtil.addTabContent(String.format("public static long CACHE_SYS_INTERVAL = 1000*60;"));
        classBuildUtil.addTabContent(String.format(""));

        classBuildUtil.finish(constantFile);

    }

    public static void main(String[] args) throws IOException {
        CacheInit init = new CacheInit();
        init.init();
    }


}
