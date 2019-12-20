package com.shineon.coder.kernel.common.generator;

import com.shineon.coder.kernel.common.ibase.ICreateBase;
import com.shineon.coder.kernel.constant.db.DBConstant;
import com.shineon.coder.kernel.util.ClassBuildUtil;
import com.shineon.coder.kernel.util.DomUtil;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CreateProperty extends ICreateBase {
    public CreateProperty(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }

    @Override
    protected void createClass() throws IOException {

        String tableName = GeneratorUtils.getTableName(this.name);

        File baseMapperFile = new  File(this.classFile.getParentFile().getParentFile(),"/mapper/"+this.name +"MapperBase.xml");

        DomUtil domUtil = new DomUtil();
        Document document = null;
        try {
            document = domUtil.getDocument(baseMapperFile);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        Element element = document.getRootElement().element("resultMap");

        List<Element> eles = element.elements();

        ClassBuildUtil classBuildUtil = new ClassBuildUtil();

        classBuildUtil.classInit(this.getClassName(), null,null, this.packageName, null, true, null);


        classBuildUtil.addTabContent("\r");

        for (Element ele : eles) {
//            System.out.println(ele.attribute("column"));
            String itemName = ele.attributeValue("column");
            String propertyItem = itemName +"Property";


            classBuildUtil.addTabContent(String.format("public static String %s = \"%s\";",propertyItem,tableName +"." +itemName));
            classBuildUtil.addTabContent("\r");

        }
        classBuildUtil.finish(this.classFile);
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
        return DBConstant.DB_PROPERTY_PACKAGE;
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
        return this.name+ "Property";
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
