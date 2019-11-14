package com.shineon.coder.action.sys;

import com.shineon.coder.db.pojo.SimpleItem;
import com.shineon.coder.kernel.common.convert.ConvertTools;
import com.shineon.coder.kernel.constant.ConvertsConstant;
import com.shineon.coder.kernel.constant.DTOConstant;
import com.shineon.coder.kernel.constant.ServerConstant;
import com.shineon.coder.service.convert.CommonItem;
import com.shineon.coder.service.convert.util.SimpleItemCommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class SysClassListController {

    @Autowired
    SimpleItemCommonUtil commonUtil;


    @RequestMapping("sys/list/dto")
    public CommonItem listDTO() throws IOException {

        File root =getRoot(DTOConstant.DTO_PACKAGE);

        log.info(root.getPath());

        List<SimpleItem> names = getFileNames(root,DTOConstant.DTO_PACKAGE);

        return commonUtil.toCommon(names);
    }

    @RequestMapping("sys/list/commonUtil")
    public CommonItem listCommonUtils() throws IOException {

        File root =getRoot(ConvertsConstant.UTIL_PACKAGE);

        log.info(root.getPath());

        List<SimpleItem> names = getFileNames(root, ConvertsConstant.UTIL_PACKAGE);

        return commonUtil.toCommon(names);
    }


    @RequestMapping("sys/list/sysName")
    public CommonItem listSysNames() throws IOException, IllegalAccessException {

        ServerConstant constant = new ServerConstant();
        Field[] field = ServerConstant.class.getDeclaredFields();


        List<SimpleItem> names = new ArrayList();
        for (int j = 0; j < field.length; j++) { // 遍历所有属性
            String name = field[j].get(constant).toString(); // 获取属性的名字
            SimpleItem item = new SimpleItem();
            item.setKey(name);
            item.setValue(name);
            names.add(item);
        }

        return commonUtil.toCommon(names);
    }


    @RequestMapping("sys/list/pojo")
    public CommonItem listPojos() throws IOException {

        File root =getRoot(ConvertsConstant.POJO_PACKAGE);

        log.info(root.getPath());

        List<SimpleItem> names = getFileNames(root, ConvertsConstant.POJO_PACKAGE);

        return commonUtil.toCommon(names);
    }

    public List<SimpleItem> getFileNames(File file,String pre)
    {
        File[] fs = file.listFiles();
        List<SimpleItem> names = new ArrayList();
        ConvertTools tools = new ConvertTools();
        for(File f :fs) {
            SimpleItem item = new SimpleItem();
            item.setKey(pre + "." +tools.getFileName(f.getName()));
            item.setValue( tools.getFileName(f.getName()));
            names.add( item);
        }
        return names;
    }

    public File getRoot(String packageName)
    {
        File base = new File( this.getClass().getResource("/").getPath());

        File root = new File(base,packageName.replace(".","/"));

        return root;
    }
}
