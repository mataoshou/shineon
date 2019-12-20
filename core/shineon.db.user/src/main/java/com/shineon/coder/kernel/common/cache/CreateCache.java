package com.shineon.coder.kernel.common.cache;

import com.shineon.coder.kernel.common.ibase.ICreateBase;
import com.shineon.coder.kernel.constant.cache.CacheConstant;
import com.shineon.coder.kernel.util.ClassBuildUtil;

import java.io.IOException;

public class CreateCache extends ICreateBase {
    public CreateCache(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }

    @Override
    protected void createClass() throws IOException {

        ClassBuildUtil cacheClassBuildUtil = new ClassBuildUtil();

        cacheClassBuildUtil.classInit(this.getClassName(),String.format("IBaseCache<%s,%s>",pojoClass.getSimpleName(),toolClass.getSimpleName()),null, this.packageName,
                new String[]{"Service","Slf4j"},true,new String[]{pojoClass.getName(),toolClass.getName(),"lombok.extern.slf4j.Slf4j",
                        "org.springframework.stereotype.Service","com.shineon.coder.kernel.util.SpringUtil", CacheConstant.CACHE_CONSTANT_PACKAGE+"." +this.getConstantName(),
                        "com.shineon.coder.db.pojo.QueryItem","com.shineon.coder.service.convert.CommonItem","java.util.List"});

        ///////////////////////////////////////////////////////////////////////////
        cacheClassBuildUtil.addTabContent(String.format("public void initCache()"));
        cacheClassBuildUtil.addTabContent(String.format("{"));

        cacheClassBuildUtil.addTabRightContent(String.format("setCommonutil(SpringUtil.getBean(%s.class));",toolClass.getSimpleName()));

        cacheClassBuildUtil.addTabContent(String.format("setCacheDecorate(%s.CACHE_PRE,%s.CACHE_LAST);",this.getConstantName(),this.getConstantName()));

        cacheClassBuildUtil.addTabLeftContent("}");

        cacheClassBuildUtil.addTabContent("\r\n");


        /////////////////////////////////////////////////////////////////////
        cacheClassBuildUtil.addTabContent(String.format("@Override"));
        cacheClassBuildUtil.addTabContent(String.format("protected boolean check(String key) {"));
        cacheClassBuildUtil.addTabRightContent(String.format("return true;"));
        cacheClassBuildUtil.addTabLeftContent(String.format("}"));

        cacheClassBuildUtil.addTabContent("\r\n");

        ///////////////////////////////////////////////////////////////////
        cacheClassBuildUtil.addTabContent(String.format("@Override"));
        cacheClassBuildUtil.addTabContent(String.format("protected boolean success(String key, List<%s> pojos) {",pojoClass.getSimpleName()));
        cacheClassBuildUtil.addTabRightContent(String.format("return true;"));
        cacheClassBuildUtil.addTabLeftContent(String.format("}"));
        cacheClassBuildUtil.addTabContent("\r\n");

        ///////////////////////////////////////////////////////////////////
        cacheClassBuildUtil.addTabContent(String.format("@Override"));
        cacheClassBuildUtil.addTabContent(String.format("protected boolean fail(String key, List<%s> pojos, Exception e) {",pojoClass.getSimpleName()));
        cacheClassBuildUtil.addTabRightContent(String.format("return true;"));
        cacheClassBuildUtil.addTabLeftContent(String.format("}"));
        cacheClassBuildUtil.addTabContent("\r\n");

        ///////////////////////////////////////////////////////////////////
        cacheClassBuildUtil.addTabContent(String.format("@Override"));
        cacheClassBuildUtil.addTabContent(String.format("protected String getKeyParams(%s pojo) {",pojoClass.getSimpleName()));
        cacheClassBuildUtil.addTabRightContent(String.format("return pojo.getId();"));
        cacheClassBuildUtil.addTabLeftContent(String.format("}"));
        cacheClassBuildUtil.addTabContent("\r\n");


        cacheClassBuildUtil.addTabContent("@Autowired");
        cacheClassBuildUtil.addTabContent(String.format("%sFeign feign;",this.name));


        ///////////////////////////////////////////////////////////////////
        cacheClassBuildUtil.addTabContent(String.format("@Override"));
        cacheClassBuildUtil.addTabContent(String.format("protected CommonItem selectListByDB(QueryItem queryItem) {"));
        cacheClassBuildUtil.addTabRightContent(String.format("return feign.list(queryItemCommonUtil.toCommon(queryItem));"));
        cacheClassBuildUtil.addTabLeftContent(String.format("}"));
        cacheClassBuildUtil.addTabContent("\r\n");

        ///////////////////////////////////////////////////////////////////
        cacheClassBuildUtil.addTabContent(String.format("@Override"));
        cacheClassBuildUtil.addTabContent(String.format("protected CommonItem getPojoByDB(QueryItem queryItem) {"));
        cacheClassBuildUtil.addTabRightContent(String.format("return feign.get(queryItemCommonUtil.toCommon(queryItem));"));
        cacheClassBuildUtil.addTabLeftContent(String.format("}"));
        cacheClassBuildUtil.addTabContent("\r\n");

        ///////////////////////////////////////////////////////////////////
        cacheClassBuildUtil.addTabContent(String.format("@Override"));
        cacheClassBuildUtil.addTabContent(String.format("protected CommonItem updatePojoByDB(%s pojo) {",pojoClass.getSimpleName()));
        cacheClassBuildUtil.addTabRightContent(String.format("return feign.edit(commonutil.toCommon(pojo));"));
        cacheClassBuildUtil.addTabLeftContent(String.format("}"));
        cacheClassBuildUtil.addTabContent("\r\n");


        ///////////////////////////////////////////////////////////////////
        cacheClassBuildUtil.addTabContent(String.format("@Override"));
        cacheClassBuildUtil.addTabContent(String.format("protected void deletePojoByDB(%s pojo) {",pojoClass.getSimpleName()));
        cacheClassBuildUtil.addTabRightContent(String.format("feign.delete(commonutil.toCommon(pojo));"));
        cacheClassBuildUtil.addTabLeftContent(String.format("}"));
        cacheClassBuildUtil.addTabContent("\r\n");

        cacheClassBuildUtil.finish(this.classFile);
    }

    @Override
    protected void createConstant() throws IOException {
        ClassBuildUtil constantClassBuildUtil = new ClassBuildUtil();

        constantClassBuildUtil.classInit(this.getConstantName(), CacheConstant.CACHE_CONSTANT_PACKAGE,true,null);

        constantClassBuildUtil.addTabContent(String.format("public static final String CACHE_PRE = CacheConstant.REDIS_KEY_PRE+\"%s\";",this.name.toUpperCase()));

        constantClassBuildUtil.addTabContent("");

        constantClassBuildUtil.addTabContent("public static final String CACHE_LAST = \"\" + CacheConstant.REDIS_KEY_LAST;");
        constantClassBuildUtil.finish(this.constantFile);
    }

    @Override
    protected boolean checkBeforBuild() {
        return true;
    }

    @Override
    protected void classInit() {

    }

    @Override
    protected String getPackageName() {
        return CacheConstant.CACHE_PACKAGE;
    }

    @Override
    protected boolean isExitConstant() {
        return false;
    }

    @Override
    protected String getConstantPackageName() {
        return CacheConstant.CACHE_CONSTANT_PACKAGE;
    }

    @Override
    protected String getClassName() {
        return this.name +"Cache";
    }

    @Override
    protected String getConstantName() {
        return this.name +"CacheConstant";
    }
}
