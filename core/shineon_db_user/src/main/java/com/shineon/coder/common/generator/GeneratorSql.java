package com.shineon.coder.common.generator;

import com.shineon.coder.common.util.BaseFileUtil;
import com.shineon.coder.common.util.ClassBuildUtil;
import com.shineon.coder.common.util.FileStore;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GeneratorSql {

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

        File pojoRoot =new File(sys,"src\\main\\java\\com\\shineon\\coder\\db\\pojo");

        File daoRoot = new File(sys,"src\\main\\java\\com\\shineon\\coder\\db\\dao");

        File mapperRoot = new File(sys,"src\\main\\java\\com\\shineon\\coder\\db\\mapper");

        File mergeRoot = new File(sys,"src\\main\\java\\com\\shineon\\coder\\db\\mergedao");


        File[] pojos = pojoRoot.listFiles();
        for(File pojo : pojos)
        {
            String fileName = getFileName(pojo.getName());

            String tableName = getTableName(fileName);

            System.out.println("................................."+tableName);

            System.out.println("开始生成文件："+fileName);

            String mapperFileName = fileName + "Mapper";

            String  mapperExternFileName = fileName + "MapperExtern";

            String mapperBaseFileName = fileName + "MapperBase";

            String mergeFileName = "I" + fileName +"Mapper";

            //////////////////////////////////////构建dao文件///////////////////////////////////////////////
            System.out.println("开始生成dao文件："+fileName);
            File daoFile = new File(daoRoot, mapperFileName+".java");
            File baseDaoFile = new File(daoRoot, mapperBaseFileName+".java");

            if(baseDaoFile.exists())
            {
                BaseFileUtil.delete(baseDaoFile);
            }
            {

                String content = FileStore.getContent(daoFile, "UTF-8");
                content = content.replace(mapperFileName, mapperBaseFileName);
                FileStore.putString(baseDaoFile, content, "UTF-8");

            }




            File externDaoFile = new File(daoRoot,mapperExternFileName+".java");

            if(!externDaoFile.exists())
            {
                ClassBuildUtil classBuildUtil = new ClassBuildUtil();
                String content = classBuildUtil.classInit(mapperExternFileName,"","com.shineon.coder.db.dao",null,false,
                        String.format("com.shineon.coder.db.pojo.%s;",fileName),"java.util.List;");

                content = content.replace("##1",String.format("    List<%s> list(String where,String order);",fileName));
                FileStore.putString(externDaoFile,content,"UTF-8");
            }

            BaseFileUtil.delete(daoFile);
            /////////////////////////////////////构建xml文件////////////////////////////////////////////////
            System.out.println("开始生成dao文件："+fileName);
            File mapperFile = new File(mapperRoot, mapperFileName+".xml");
            File baseMapperFile = new File(mapperRoot, mapperBaseFileName+".xml");

            if(baseMapperFile.exists())
            {
                BaseFileUtil.delete(baseMapperFile);
            }

            {
                String content = FileStore.getContent(mapperFile, "UTF-8");
                content = content.replace(mapperFileName, mergeFileName).replace("dao","mergedao");
                FileStore.putString(baseMapperFile, content, "UTF-8");
            }


            File externMapperFile = new File(mapperRoot,mapperExternFileName+".xml");

            if(!externMapperFile.exists())
            {
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
                        "        </if>\n"+
                        "    </select>\n" +
                        "</mapper>";

                content = content.replace("##1",mergeFileName).replace("##2",tableName);
                FileStore.putString(externMapperFile,content,"UTF-8");
            }

            BaseFileUtil.delete(mapperFile);
            ///////////////////////////////////生成merge文件/////////////////////////////////////////////////////////
            File mergeFile = new File(mergeRoot,mergeFileName+".java");

            if(!mergeFile.exists())
            {

                ClassBuildUtil classBuildUtil = new ClassBuildUtil();
                String content = classBuildUtil.classInit(mergeFileName,mapperBaseFileName+","+mapperExternFileName,"com.shineon.coder.db.mergedao",null,false,
                        "com.shineon.coder.db.dao."+mapperBaseFileName,"com.shineon.coder.db.dao."+mapperExternFileName);

                content = content.replace("##1","");
                FileStore.putString(mergeFile,content,"UTF-8");

            }
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
        sql.build();

    }
}
