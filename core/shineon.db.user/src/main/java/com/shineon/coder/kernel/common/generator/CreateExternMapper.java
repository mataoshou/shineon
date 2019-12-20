package com.shineon.coder.kernel.common.generator;

import com.shineon.coder.kernel.common.ibase.ICreateBase;
import com.shineon.coder.kernel.constant.db.DBConstant;
import com.shineon.coder.kernel.util.DomUtil;
import com.shineon.coder.kernel.util.FileStore;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class CreateExternMapper extends ICreateBase {

    public CreateExternMapper(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }

    @Override
    protected void createClass() throws IOException {

        String mergeFileName = "I" + this.name + "Mapper";


        File baseMapperFile = new File(this.classFile.getParentFile(),this.name+"MapperBase.xml");


        String content = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" >\n" +
                String.format("<mapper namespace=\"%s.##1\" >\n",DBConstant.DB_MERGEDAO_PACKAGE) +
                "    <select id=\"list\" resultMap=\"BaseResultMap\" >\n" +
                "        select\n" +
                "        <include refid=\"Base_Column_List\" />\n" +
                "        from ##2\n" +
                "        <if test=\"where != null\">\n" +
                "         where ${where}\n" +
                "        </if>\n" +
                "        <if test=\"order != null\">\n" +
                "            order by ${order}\n" +
                "        </if>\n" +
                "    </select>\n" ;

        DomUtil domUtil = new DomUtil();
        Document document = null;
        try {
            document = domUtil.getDocument(baseMapperFile);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        Element element = document.getRootElement().element("resultMap");

        List<Element> eles = element.elements();


        String insert_keys="";
        String insert_value="";

        String itemName ="";
        for (Element ele : eles) {
            String column = ele.attributeValue("column");
            String jdbcType = ele.attributeValue("jdbcType");
            String property = ele.attributeValue("property");
            if(itemName.length()==0&&(column.indexOf("name")>0||column.indexOf("Name")>0))
            {
                itemName=column;
            }

            insert_keys += column+",";
            insert_value += String.format("#{%s,jdbcType=%s},",property,jdbcType);
        }
        insert_keys = insert_keys.substring(0,insert_keys.length()-1);
        insert_value = insert_value.substring(0,insert_value.length()-1);


        String selectByName = "";
        if(itemName.length()>0)
        {
            selectByName ="    <select id=\"selectByName\" resultMap=\"BaseResultMap\" parameterType=\"java.lang.String\" >\n" +
                    "        select\n" +
                    "        <include refid=\"Base_Column_List\" />\n" +
                    "        from ##2 \n" +
                    "        where ##3 = #{name,jdbcType=VARCHAR}\n" +
                    "    </select> \n";
        }

        String insertByCustomId = "    <insert id=\"insertByCustomId\"   parameterType=\"##4\" >\n" +
                "        insert into ##2 (##5)\n" +
                "        values (##6)\n" +
                "    </insert>\n";

        content +=selectByName;
        content +=insertByCustomId;
        content +="</mapper>";

        String tableName = GeneratorUtils.getTableName(this.name);


        content = content.replace("##1", mergeFileName).replace("##2", tableName).replace("##3",itemName)
                .replace("##4",String.format("%s.%s",DBConstant.DB_POJO_PACKAGE, this.name)).replace("##5",insert_keys).replace("##6",insert_value);
        FileStore.putString(this.classFile, content, "UTF-8");
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
        return DBConstant.DB_MAPPER_PACKAGE;
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
        return this.name +"MapperExtern";
    }

    @Override
    protected String getConstantName() {
        return null;
    }

    @Override
    protected String getSuffix() {
        return "xml";
    }
}
