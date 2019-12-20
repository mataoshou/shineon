package com.shineon.coder.kernel.common.ibase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * 生成过程组合
 */
public abstract class IMakeUpBase {


    public IMakeUpBase(String name, Class toolClass,
                       Class pojoClass, String[] methods, String sysName)
    {

    }

    protected void add(ICreateBase item)
    {
        items.add(item);
    }


    List<ICreateBase> items = new ArrayList<>();

    /**
     * 重新生成对象
     * @throws IOException
     */
    public void rebuild() throws IOException{
        for(ICreateBase item : items)
        {
            item.isRewrite(true);
            item.startCreate();
        }

    }

    /**
     * 生成对象
     * @throws IOException
     */
    public void build() throws IOException{
        for(ICreateBase item : items)
        {
            item.startCreate();
        }
    }


    /**
     * 删除生成的对象
     */
    public void delete(){
        for(ICreateBase item : items)
        {
            item.deleteFile();
        }
    }
}
