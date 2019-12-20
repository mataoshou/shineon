package com.shineon.coder.kernel.common.convert;

import com.shineon.coder.kernel.common.CommonTool;
import com.shineon.coder.kernel.common.ibase.ICreateBase;
import com.shineon.coder.kernel.constant.convert.ConvertsConstant;
import com.shineon.coder.kernel.util.ClassBuildUtil;
import org.dom4j.DocumentException;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CreateConvertBase extends ICreateBase {


    public CreateConvertBase(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }

    @Override
    protected void createClass() throws IOException {


        ConvertTools tools = new ConvertTools();
        String mapperName = name +"CommonMapper.xml";
        CommonTool tool = new CommonTool();
        File root = tool.getSysPath(ConvertsConstant.MAPPER_PACKAGE);
        File mapperFile = new File(root,mapperName);
        List<MapperItem> mapperItems =null;
        try {
            mapperItems = tools.getMapper(mapperFile);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        ClassBuildUtil classBuildUtil = new ClassBuildUtil();

        classBuildUtil.classInit(this.getClassName(),null,
                new String[]{String.format("CommonItemUtils<%s>",pojoClassName)}, this.packageName,null,true,
                "java.util.Date", String.format("%s.%s", ConvertsConstant.POJO_PACKAGE,pojoClassName), ConvertsConstant.CONVERT_PACKAGE+".CommonData",
                "java.util.ArrayList","java.util.List","org.springframework.beans.factory.annotation.Autowired",
                ConvertsConstant.CONVERT_PACKAGE+".CommonItemUtils",
                ConvertsConstant.CONVERT_PACKAGE+".CommonItem",
                ConvertsConstant.CONVERT_PACKAGE+".CommonItemUtils",
                "org.slf4j.Logger","org.slf4j.LoggerFactory");

        ////////添加packagename;

        classBuildUtil.addTabContent("Logger logger = LoggerFactory.getLogger(getClass());");
        classBuildUtil.addTabContent("\r\n");

        ////////////////////////////////////CommonData 和 pojo 类之间的转换
        toCommonData(pojoClass.getSimpleName(),mapperItems,classBuildUtil);
        classBuildUtil.addTabContent("\r\n");

        toPojoData(pojoClass.getSimpleName(),mapperItems,classBuildUtil);
        classBuildUtil.addTabContent("\r\n");

        //////////////////////////////////// pojo 类  转换  为CommonItem
        toCommon(pojoClass.getSimpleName(),classBuildUtil);
        classBuildUtil.addTabContent("\r\n");

        toCommonList(pojoClass.getSimpleName(),classBuildUtil);
        classBuildUtil.addTabContent("\r\n");

        //////////////////////////////////// CommonItem 类  转换  为pojo
        toPojo(this.pojoClassName,classBuildUtil);
        classBuildUtil.addTabContent("\r\n");

        toPojoList(this.pojoClassName,classBuildUtil);
        classBuildUtil.addTabContent("\r\n");

        classBuildUtil.finish(this.classFile);
    }


    public void toCommonData(String pojoName, List<MapperItem> items , ClassBuildUtil classBuildUtil)
    {
        String methodName = "toCommonData";

        classBuildUtil.addTabContent(String.format("private CommonData %s( %s pojo) {" ,methodName,pojoName));

        classBuildUtil.addTabRightContent(String.format("CommonData data = new CommonData();" ));

        for(MapperItem item:items)
        {
            if(item.commonName.length()>0) {
                String getMehod = classBuildUtil.getGetMethodName(item.pojoName);
                String setMethod = classBuildUtil.getSetMethodName(item.commonName);

                String str = String.format("data.%s(pojo.%s());", setMethod, getMehod);
                classBuildUtil.addTabContent(str);
            }
        }
        classBuildUtil.addTabContent("return data;");

        classBuildUtil.addTabLeftContent(String.format("}"));

    }


    public void toPojoData(String pojoName, List<MapperItem> items , ClassBuildUtil classBuildUtil)
    {
        String methodName = "toPojoData";

        classBuildUtil.addTabContent(String.format("private %s %s( CommonData data) {" ,pojoName,methodName));

        classBuildUtil.addTabRightContent(String.format("%s pojo = new %s();",pojoName,pojoName ));

        for(MapperItem item:items)
        {
            if(item.commonName.length()>0) {
                String getMehod = classBuildUtil.getGetMethodName(item.commonName);
                String setMethod = classBuildUtil.getSetMethodName(item.pojoName);

                String str = String.format("pojo.%s(data.%s());", setMethod, getMehod);
                classBuildUtil.addTabContent( str);
            }
        }
        classBuildUtil.addTabContent("return pojo;");

        classBuildUtil.addTabLeftContent(String.format("}"));
    }

    public void toCommon(String pojoName , ClassBuildUtil classBuildUtil)
    {

        String methodName = "toCommon";

        classBuildUtil.addTabContent(String.format("public CommonItem %s( %s pojo) {" ,methodName,pojoName));

        classBuildUtil.addTabRightContent("return success(toCommonData(pojo));");


        classBuildUtil.addTabLeftContent(String.format("}"));

    }

    public void toCommonList(String pojoName , ClassBuildUtil classBuildUtil)
    {

        String methodName = "toCommon";

        classBuildUtil.addTabContent(String.format("public  CommonItem %s( List<%s> pojos) {" ,methodName,pojoName));

        classBuildUtil.addTabRightContent(String.format("List<CommonData> result = new ArrayList();" ));

        classBuildUtil.addTabContent(String.format("for(%s item : pojos){",pojoName));
        classBuildUtil.addTabRightContent(String.format("result.add(toCommonData(item));"));
        classBuildUtil.addTabLeftContent(String.format("}"));


        classBuildUtil.addTabContent("return success(result);");


        classBuildUtil.addTabLeftContent(String.format("}"));

    }


    public void toPojo(String pojoName , ClassBuildUtil classBuildUtil)
    {
        String methodName = "toPojo";

        classBuildUtil.addTabContent(String.format("public %s %s( CommonItem item) throws Exception{" ,pojoName,methodName));

        classBuildUtil.addTabRightContent(String.format("checkCommonItem(item);"));

        classBuildUtil.addTabContent(String.format("List<CommonData> datas = item.getDatas();"));

        classBuildUtil.addTabContent(String.format("if(datas ==null||datas.size()==0){logger.debug(\"CommonItem 中data数据为空!!\"); return null;}"));

        classBuildUtil.addTabContent(String.format("if(datas.size()>1){logger.debug(\"CommonItem 中data数据不止一条数据!!\"); }"));

        classBuildUtil.addTabContent("return toPojoData(datas.get(0));");


        classBuildUtil.addTabLeftContent(String.format("}"));
    }



    public void toPojoList(String pojoName, ClassBuildUtil classBuildUtil)
    {
        String methodName = "toPojoList";

        classBuildUtil.addTabContent(String.format("public List<%s> %s(  CommonItem item) throws Exception{" ,pojoName,methodName));

        classBuildUtil.addTabRightContent(String.format("checkCommonItem(item);"));

        classBuildUtil.addTabContent(String.format("List<%s> result = new ArrayList();",pojoName ));
        classBuildUtil.addTabRightContent(String.format("List<CommonData> datas = item.getDatas();" ));

        classBuildUtil.addTabContent(String.format("for(CommonData data : datas){"));
        classBuildUtil.addTabRightContent(String.format("result.add(toPojoData(data));"));
        classBuildUtil.addTabLeftContent(String.format("}"));

        classBuildUtil.addTabContent("return result;");


        classBuildUtil.addTabLeftContent(String.format("}"));
    }

    @Override
    protected void createConstant() throws IOException {

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
        return ConvertsConstant.BASE_PACKAGE;
    }

    @Override
    protected boolean isExitConstant() {
        return false;
    }

    @Override
    protected String getConstantPackageName() {
        return null;
    }

    @Override
    protected String getClassName() {
        return this.name+"CommonBase";
    }

    @Override
    protected String getConstantName() {
        return null;
    }

    @Override
    public void isRewrite(boolean rewrite) {
        super.isRewrite(true);
    }
}
