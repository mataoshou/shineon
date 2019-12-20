package com.shineon.coder.kernel.common.convert;

import com.shineon.coder.kernel.common.ibase.ICreateBase;
import com.shineon.coder.kernel.constant.convert.ConvertsConstant;
import com.shineon.coder.kernel.util.DomUtil;
import com.shineon.coder.kernel.util.FileStore;
import com.shineon.coder.service.convert.CommonData;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateConvertMapper extends ICreateBase {
    public CreateConvertMapper(String actionName, Class toolClass, Class pojoClass, String[] methods, String sysName) {
        super(actionName, toolClass, pojoClass, methods, sysName);
    }

    @Override
    protected void createClass() throws IOException {
        try {
            List<MapperItem> mapperItems = getMapperList();
            buildMapper(mapperItems);
        } catch (DocumentException e) {
            e.printStackTrace();
        }

    }

    private List<MapperItem> getMapperList() throws IOException, DocumentException {
        List<MapperItem> mapperList = new ArrayList<>();

        ConvertTools tools = new ConvertTools();

        if(this.classFile.exists())
        {
            mapperList =tools.getMapper(this.classFile);
        }

        List<PropertyItem> pojos =tools.getItems(this.pojoClass);

        List<PropertyItem> common = tools.getItems(CommonData.class);


        for(PropertyItem ci :pojos)
        {
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

        return mapperList;
    }

    /**
     * 构建映射文件
     * @param items
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    private boolean buildMapper(List<MapperItem> items) throws IOException, DocumentException {


        if(!this.classFile.exists())
        {
            FileStore store = new FileStore();
            String content = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> <root></root>";
            store.putString(this.classFile,content,"UTF-8");
        }

        DomUtil dom = new DomUtil();
        Document doc = dom.getDocument(this.classFile);

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

        dom.writeDocument(doc,this.classFile);

        return  true;
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
        return ConvertsConstant.MAPPER_PACKAGE;
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
        return this.name +"CommonMapper";
    }

    @Override
    protected String getConstantName() {
        return null;
    }

    @Override
    public String getSuffix() {
        return "xml";
    }

    @Override
    public void isRewrite(boolean rewrite) {
        super.isRewrite(true);
    }
}
