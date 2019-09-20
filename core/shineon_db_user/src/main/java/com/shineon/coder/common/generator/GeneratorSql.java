package com.shineon.coder.common.generator;

import com.shineon.coder.common.util.BaseFileUtil;
import com.shineon.coder.common.util.ClassBuildUtil;
import com.shineon.coder.common.util.DomUtil;
import com.shineon.coder.common.util.FileStore;
import com.shineon.coder.constant.DBConstant;
import org.dom4j.Document;
import org.dom4j.Element;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;
import sun.font.TrueTypeFont;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneratorSql {

    boolean isOverride = false;


    public void overrideBuild() throws InterruptedException, SQLException, InvalidConfigurationException, XMLParserException, IOException {
        isOverride = true;
        build();
    }

    public void build() throws InterruptedException, SQLException, InvalidConfigurationException, XMLParserException, IOException {

        buildBase();
        buildMerge();
    }

    public void buildBase() throws IOException, XMLParserException, InvalidConfigurationException, SQLException, InterruptedException
    {
        List<String> warnings = new ArrayList<>();

        File sys =  new File(this.getClass().getResource("/").getPath()).getParentFile().getParentFile();

        System.out.println(sys.getPath());
        File configFile = new File(sys,"src\\main\\resources\\DBConfig.xml");

        System.out.println(configFile.getPath());
        ConfigurationParser cp = new ConfigurationParser(warnings);
        Configuration config = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(true);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
        myBatisGenerator.generate(null);
        System.out.println("基础文件生成成功");
    }

    public String getFileName(String name)
    {
        int index = name.indexOf(".");

        return name.substring(0,index);
    }


    public void buildMerge() throws IOException {

        File sys =  new File(this.getClass().getResource("/").getPath()).getParentFile().getParentFile();;
        System.out.println("开始文件名修正");

        File root = new File(sys,"src\\main\\java");

        File pojoRoot =new File(root,DBConstant.DB_POJO_PACKAGE.replace(".","\\"));

        File daoRoot = new File(root,DBConstant.DB_DAO_PACKAGE.replace(".","\\"));

        File mapperRoot = new File(root,DBConstant.DB_MAPPER_PACKAGE.replace(".","\\"));

        File mergeRoot = new File(root,DBConstant.DB_MERGEDAO_PACKAGE.replace(".","\\"));

        File propertyRoot = new File(root,DBConstant.DB_PROPERTY_PACKAGE.replace(".","\\"));


        File[] pojos = pojoRoot.listFiles();
        for(File pojo : pojos)
        {

                String fileName = getFileName(pojo.getName());

                String tableName = getTableName(fileName);

                System.out.println("................................." + tableName);

                System.out.println("开始生成文件：" + fileName);
            try {
                String mapperFileName = fileName + "Mapper";

                String mapperExternFileName = fileName + "MapperExtern";

                String mapperBaseFileName = fileName + "MapperBase";

                String mergeFileName = "I" + fileName + "Mapper";

                String propertyName = fileName + "Property";

                //////////////////////////////////////构建dao文件///////////////////////////////////////////////
                System.out.println("开始生成dao文件：" + fileName);
                File daoFile = new File(daoRoot, mapperFileName + ".java");
                File baseDaoFile = new File(daoRoot, mapperBaseFileName + ".java");

                if (baseDaoFile.exists()) {
                    BaseFileUtil.delete(baseDaoFile);
                }
                {

                    String content = FileStore.getContent(daoFile, "UTF-8");
                    content = content.replace(mapperFileName, mapperBaseFileName);
                    FileStore.putString(baseDaoFile, content, "UTF-8");

                }


                File externDaoFile = new File(daoRoot, mapperExternFileName + ".java");

                if (!externDaoFile.exists()||isOverride) {
                    ClassBuildUtil classBuildUtil = new ClassBuildUtil();
                    classBuildUtil.classInit(mapperExternFileName, "", DBConstant.DB_DAO_PACKAGE, null, false,
                            String.format("%s.%s;",DBConstant.DB_POJO_PACKAGE, fileName), "java.util.List;");
                    classBuildUtil.addTabContent( String.format(" List<%s> list(String where,String order);", fileName));
                    classBuildUtil.finish(externDaoFile);
                }

                BaseFileUtil.delete(daoFile);
                /////////////////////////////////////构建xml文件////////////////////////////////////////////////
                System.out.println("开始生成dao文件：" + fileName);
                File mapperFile = new File(mapperRoot, mapperFileName + ".xml");
                File baseMapperFile = new File(mapperRoot, mapperBaseFileName + ".xml");

                if (baseMapperFile.exists()) {
                    BaseFileUtil.delete(baseMapperFile);
                }

                {
                    String content = FileStore.getContent(mapperFile, "UTF-8");
                    content = content.replace(mapperFileName, mergeFileName).replace("dao", "mergedao");
                    FileStore.putString(baseMapperFile, content, "UTF-8");
                }


                File externMapperFile = new File(mapperRoot, mapperExternFileName + ".xml");

                if (!externMapperFile.exists()||isOverride) {
                    String content = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                            "<!DOCTYPE mapper PUBLIC \"-//mybatis.org//DTD Mapper 3.0//EN\" \"http://mybatis.org/dtd/mybatis-3-mapper.dtd\" >\n" +
                            "<mapper namespace=\"com.shineon.coder.db.mergedao.##1\" >\n" +
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
                            "    </select>\n" +
                            "</mapper>";

                    content = content.replace("##1", mergeFileName).replace("##2", tableName);
                    FileStore.putString(externMapperFile, content, "UTF-8");
                }

                BaseFileUtil.delete(mapperFile);
                ///////////////////////////////////生成merge文件/////////////////////////////////////////////////////////
                File mergeFile = new File(mergeRoot, mergeFileName + ".java");

                if (!mergeFile.exists()||isOverride) {

                    ClassBuildUtil classBuildUtil = new ClassBuildUtil();
                    classBuildUtil.classInit(mergeFileName, mapperBaseFileName + "," + mapperExternFileName, DBConstant.DB_MERGEDAO_PACKAGE, null, false,
                            DBConstant.DB_DAO_PACKAGE+"." + mapperBaseFileName, DBConstant.DB_DAO_PACKAGE+"." + mapperExternFileName);

                    classBuildUtil.finish(mergeFile);

                }


                ///////////////////////////////////////////生成property类，可以直接读取item属性

                {
                    File prpopertyFile = new File(propertyRoot, propertyName + ".java");

                    DomUtil domUtil = new DomUtil();
                    Document document = domUtil.getDocument(baseMapperFile);

                    Element element = document.getRootElement().element("resultMap");

                    List<Element> eles = element.elements();

                    ClassBuildUtil classBuildUtil = new ClassBuildUtil();

                    classBuildUtil.classInit(propertyName, null, DBConstant.DB_PROPERTY_PACKAGE, null, true, null);


                    classBuildUtil.addTabContent("\r");

                    for (Element ele : eles) {
                        System.out.println(ele.attribute("column"));
                        String itemName = ele.attributeValue("column");
                        String propertyItem = itemName +"Property";


                        classBuildUtil.addTabContent(String.format("static String %s = \"%s\";",propertyItem,tableName +"." +itemName));
                        classBuildUtil.addTabContent("\r");

                    }
                    classBuildUtil.finish(prpopertyFile);
                }
            }
            catch (Exception e)
            {
                System.out.println("生成失败:" +fileName +":" +e.getMessage());
                System.out.println();
                e.printStackTrace();
            }

            System.out.println("生成成功:" +fileName);
        }
    }


    public String getTableName(String pojoName)
    {
        String tableName = pojoName.toLowerCase();

        char[] temp = new char[tableName.length()*2];

        int count =0;
        for(int i=0;i<tableName.length();i++)
        {
            if(pojoName.charAt(i)!=tableName.charAt(i)&&i!=0)
            {
                temp[count] ='_';
                count++;
            }

            temp[count] = tableName.charAt(i);
            count++;
        }

        return new String(temp).trim();
    }



    public static  void main(String[] args) throws InvalidConfigurationException, XMLParserException, IOException, SQLException, InterruptedException {
        GeneratorSql sql = new GeneratorSql();
        sql.overrideBuild();

    }
}
