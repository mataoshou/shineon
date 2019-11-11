package com.shineon.coder.kernel.common.cache;

import com.shineon.coder.kernel.common.CommonTool;
import com.shineon.coder.kernel.constant.cache.CacheConstant;
import com.shineon.coder.kernel.util.ClassBuildUtil;
import com.shineon.coder.service.convert.CommonItemUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class CacheBuild {

    Logger log = LoggerFactory.getLogger(getClass());

    public void build(String name, Class<? extends CommonItemUtils> dtoClass, Class pojoClass) throws IOException {

        String baseName = ClassBuildUtil.firstUpper(name);

        String constantName = baseName +"CacheConstant";
        String cacheName = baseName +"Cache";

        CommonTool tool = new CommonTool();


        File constantRoot = tool.getSysPath(CacheConstant.CACHE_CONSTANT_PACKAGE);

        File cacheRoot = tool.getSysPath(CacheConstant.CACHE_PACKAGE);

        File constantFile = new File(constantRoot,constantName+".java");

        File cacheFile = new File(cacheRoot,cacheName+".java");

        if(constantFile.exists())
        {
            log.info("已存在文件" + constantFile.getPath());
            return;
        }


        if(cacheFile.exists())
        {
            log.info("已存在文件" + cacheFile.getPath());
            return;
        }

        ClassBuildUtil constantClassBuildUtil = new ClassBuildUtil();

        constantClassBuildUtil.classInit(constantName, CacheConstant.CACHE_CONSTANT_PACKAGE,true,null);

        constantClassBuildUtil.addTabContent(String.format("public static final String CACHE_PRE = CacheConstant.REDIS_KEY_PRE+\"%s\";",baseName.toUpperCase()));

        constantClassBuildUtil.addTabContent("");

        constantClassBuildUtil.addTabContent("public static final String CACHE_LAST = \"\" + CacheConstant.REDIS_KEY_LAST;");
        constantClassBuildUtil.finish(constantFile);


        ///////////////.....................................//////////////////////////////////////////////////////
        ClassBuildUtil cacheClassBuildUtil = new ClassBuildUtil();

        cacheClassBuildUtil.classInit(cacheName,String.format("BaseCache<%s,%s>",pojoClass.getSimpleName(),dtoClass.getSimpleName()),null, CacheConstant.CACHE_PACKAGE,
                new String[]{"Service","Slf4j"},true,new String[]{pojoClass.getName(),dtoClass.getName(),"lombok.extern.slf4j.Slf4j",
                "org.springframework.stereotype.Service","com.shineon.coder.kernel.util.SpringUtil", CacheConstant.CACHE_CONSTANT_PACKAGE+"." +constantName,
                "com.shineon.coder.db.pojo.QueryItem","com.shineon.coder.service.convert.CommonItem"});

        ///////////////////////////////////////////////////////////////////////////
        cacheClassBuildUtil.addTabContent(String.format("public %s()",cacheName));
        cacheClassBuildUtil.addTabContent(String.format("{"));

        cacheClassBuildUtil.addTabRightContent(String.format("setDTO(SpringUtil.getBean(%s.class));",dtoClass.getSimpleName()));

        cacheClassBuildUtil.addTabContent(String.format("setCacheDecorate(%s.CACHE_PRE,%s.CACHE_LAST);",constantName,constantName));

        cacheClassBuildUtil.addTabLeftContent("}");

        cacheClassBuildUtil.addTabContent("\r\n");


        /////////////////////////////////////////////////////////////////////
        cacheClassBuildUtil.addTabContent(String.format("@Override"));
        cacheClassBuildUtil.addTabContent(String.format("public boolean check(String key) {"));
        cacheClassBuildUtil.addTabRightContent(String.format("return true;"));
        cacheClassBuildUtil.addTabLeftContent(String.format("}"));

        cacheClassBuildUtil.addTabContent("\r\n");

        ///////////////////////////////////////////////////////////////////
        cacheClassBuildUtil.addTabContent(String.format("@Override"));
        cacheClassBuildUtil.addTabContent(String.format("public boolean success(String key, String body) {"));
        cacheClassBuildUtil.addTabRightContent(String.format("return true;"));
        cacheClassBuildUtil.addTabLeftContent(String.format("}"));
        cacheClassBuildUtil.addTabContent("\r\n");

        ///////////////////////////////////////////////////////////////////
        cacheClassBuildUtil.addTabContent(String.format("@Override"));
        cacheClassBuildUtil.addTabContent(String.format("public boolean fail(String key, String body, Exception e) {"));
        cacheClassBuildUtil.addTabRightContent(String.format("return true;"));
        cacheClassBuildUtil.addTabLeftContent(String.format("}"));
        cacheClassBuildUtil.addTabContent("\r\n");

        ///////////////////////////////////////////////////////////////////
        cacheClassBuildUtil.addTabContent(String.format("@Override"));
        cacheClassBuildUtil.addTabContent(String.format("public String getKeyParams(%s pojo) {",pojoClass.getSimpleName()));
        cacheClassBuildUtil.addTabRightContent(String.format("return pojo.getId();"));
        cacheClassBuildUtil.addTabLeftContent(String.format("}"));
        cacheClassBuildUtil.addTabContent("\r\n");


        ///////////////////////////////////////////////////////////////////
        cacheClassBuildUtil.addTabContent(String.format("@Override"));
        cacheClassBuildUtil.addTabContent(String.format("public CommonItem selectListByDB(QueryItem queryItem) {"));
        cacheClassBuildUtil.addTabRightContent(String.format("return null;"));
        cacheClassBuildUtil.addTabLeftContent(String.format("}"));
        cacheClassBuildUtil.addTabContent("\r\n");

        ///////////////////////////////////////////////////////////////////
        cacheClassBuildUtil.addTabContent(String.format("@Override"));
        cacheClassBuildUtil.addTabContent(String.format("public CommonItem getPojoByDB(QueryItem queryItem) {"));
        cacheClassBuildUtil.addTabRightContent(String.format("return null;"));
        cacheClassBuildUtil.addTabLeftContent(String.format("}"));
        cacheClassBuildUtil.addTabContent("\r\n");

        cacheClassBuildUtil.finish(cacheFile);


    }


    public void buildEmptyMethod(ClassBuildUtil cacheClassBuildUtil)
    {
        cacheClassBuildUtil.addTabContent("@");
    }


    public static void main(String[] args) throws IOException {
        CacheBuild cacheBuild = new CacheBuild();
//        cacheBuild.build("matao", RmtUserInfoCommonUtil.class, RmtUserInfo.class);
    }
}
