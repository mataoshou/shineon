package com.shineon.coder.common.convert;

import com.shineon.coder.common.util.DomUtil;
import com.shineon.coder.common.util.FileStore;
import com.shineon.coder.constant.ConvertsConstant;
import com.shineon.coder.convert.CommonData;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ConvertBuild {


    Logger logger = LoggerFactory.getLogger(ConvertBuild.class);


    DomUtil dom = new DomUtil();

    ConvertTools tools = new ConvertTools();

    BuildClass buildApi = new BuildClass();


    File mapper;
    File util;
    File base;
    /**
     * 批量生成转换类
     */
    public void buildConvert() throws Exception {
        String sys = System.getProperty("user.dir");
        File root = new File(sys,"src\\main\\java\\");

        File pojo = new File(root,ConvertsConstant.POJO_PACKAGE.replace(".","\\"));

        File buildRoot = new File(root,ConvertsConstant.CONVERT_PACKAGE.replace(".","\\"));

        mapper = new File(buildRoot,"mapper");

        util = new File(buildRoot,"util");

        base = new File(buildRoot,"base");


        logger.debug("初始化路径....");
        //初始化文件路径
        initFile(mapper,util);

        logger.debug("获取pojo文件");
        File[] pfs = pojo.listFiles();


        for(File pf :pfs)
        {
            eachPojo(pf);
        }
    }



    public void eachPojo(File pf) throws Exception {
        ////////////////////变量初始化
        logger.debug("初始化commonData属性");
        List<PropertyItem> common = getItems(CommonData.class);

        logger.debug("开始处理文件转换" + pf.getPath());

        String fname = tools.getFileName(pf.getName());

        String clPath = ConvertsConstant.POJO_PACKAGE + "." + fname;

        logger.debug("构建类对象"+clPath);

        Class cl = Class.forName(clPath);

        List<PropertyItem> pojos = getItems(cl);

        String mapperName = fname +"CommonMapper.xml";

        String baseName = fname + "CommonBase";

        String utilName  =fname +"CommonUtil";

        //////////////获取并构建映射关系  common  to  pojo
        File mapperFile = new File(mapper,mapperName);

        List<MapperItem> mapperList = new ArrayList<>();

        if(mapperFile.exists())
        {
            mapperList =getMapper(mapperFile);
        }

        for(PropertyItem ci :pojos)
        {
//            ptemp.add(ci);
            for(MapperItem mitem: mapperList)
            {
                if(mitem.pojoName.equals(ci.name)&&mitem.type.equals(ci.type))
                {
                   ci.status =true;

                   for(PropertyItem citem : common)
                   {
                       if(citem.name.equals(mitem.commonName)&&(citem.type.equals(mitem.type)))
                       {
                           citem.status= true;
                       }
                   }
                   break;
                }
            }
        }

        List<PropertyItem> temp = new ArrayList<>();

        //进行属性名称的绝对匹配和模糊匹配
        for(PropertyItem ci :pojos)
        {
            if(ci.status)continue;;

            logger.debug("构建映射关系：" + ci.name);
            PropertyItem citem = tools.getItem(ci,common);
            if(citem ==null)
            {
                logger.debug("未匹配上属性映射：" + ci.name);
                temp.add(ci);
                continue;
            }
            citem.status = true;

            MapperItem mitem = new MapperItem();
            mitem.pojoName =ci.name;
            mitem.commonName = citem.name;

            mitem.type = citem.type;

            logger.debug(String.format("映射关系%s  --  %s",ci.name,citem.name));
            mapperList.add(mitem);
        }

        //匹配不上，相同类型参数 进行匹配
        for(PropertyItem ci :temp)
        {
            logger.debug("再次构建映射关系：" + ci.name);
            PropertyItem citem = tools.getFirstType(ci,common);
            if(citem ==null)
            {
                logger.debug("未匹配上属性映射：" + ci.name);
                citem = new PropertyItem();
                citem.name ="";
                citem.type =ci.type;
            }

            common.remove(citem);

            MapperItem mitem = new MapperItem();
            mitem.pojoName =ci.name;
            mitem.commonName = citem.name;

            mitem.type = citem.type;

            logger.debug(String.format("映射关系%s  --  %s",ci.name,citem.name));
            mapperList.add(mitem);
        }



        /////////////////////////////////////////////////////
        // 生成xml文件
        buildMapper(mapperList,mapperFile);
        ////////////////////////////////////////////////////////////////
        //构建base文件

        buildApi.buildBase(baseName,base,fname,mapperList);
        ///////////////////////////////////////////////////
        //构建util文件  已存在不替换
        File utilFile = new File(util,utilName);
        if(!utilFile.exists())
        {
            logger.debug("生成util文件");
            buildApi.buildUtil(utilName,util,baseName);
        }
    }

    /**
     * 构建映射文件
     * @param items
     * @param mapperFile
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    public boolean buildMapper(List<MapperItem> items, File mapperFile) throws IOException, DocumentException {

        if(!mapperFile.exists())
        {
            FileStore store = new FileStore();
            String content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <root></root>";
            store.putString(mapperFile,content,"UTF-8");
        }

        Document doc = dom.getDocument(mapperFile);

        Element root =  doc.getRootElement();
        List<Element> eles = root.elements();

        for(Element ele:eles) {
            root.remove(ele);
        }


        for(MapperItem mitem :items) {
            Element ele = root.addElement("item");
            ele.addAttribute("pojoName",mitem.pojoName);
            ele.addAttribute("commonName",mitem.commonName);
            ele.addAttribute("type",mitem.type);
        }

        dom.writeDocument(doc,mapperFile);

        return  true;
    }

    //获取原来的映射关系
    public List<MapperItem> getMapper(File file) throws IOException, DocumentException {

        Document doc = dom.getDocument(file);

        List<MapperItem> list = new ArrayList<>();

        Element root =  doc.getRootElement();

        List<Element> eles = root.elements();

        for(Element ele :eles)
        {
            MapperItem item = new MapperItem();
            item.commonName = ele.attributeValue("commonName").trim();
            item.pojoName = ele.attributeValue("pojoName").trim();
            item.type = ele.attributeValue("type").trim();
            item.status = true;
            list.add(item);
        }

        return list;
    }




    public List<PropertyItem> getItems(Class cl)
    {
        Field[] fs = cl.getDeclaredFields();
        logger.debug(cl.getName() +"  属性数量："+fs.length);

        List<PropertyItem> list = new ArrayList<>();

        for(Field f:fs)
        {
//            System.out.println(f.getName());
            PropertyItem item = new PropertyItem();
            item.name = f.getName();
            item.type = f.getType().getName();
            item.status = false;

            list.add(item);
        }

        return  list;
    }



    public void initFile(File...files)
    {
        for(File f : files)
        {
            if(!f.exists())
            {
                System.out.println("构建文件路径" + f.getPath());
                f.mkdirs();
            }
        }
    }



    public static void main(String[] args) throws Exception {
        ConvertBuild tool = new ConvertBuild();
        tool.buildConvert();
    }



}
